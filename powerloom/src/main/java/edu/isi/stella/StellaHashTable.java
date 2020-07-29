//  -*- Mode: Java -*-
//
// StellaHashTable.java

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

public class StellaHashTable extends AbstractHashTable {
    public KvCons[] theTable;
    public int size;
    /** If supplied, the initial hash table
     * will be sized to hold at least that many elements.
     */
    public int initialSize;
    public int freeElements;
    /** If true use <code>equalP</code> as the
     * equality test and <code>equalHashCode</code> as the hash function, otherwise,
     * use <code>eqlP</code> and <code>hashCode</code> (the default).
     */
    public boolean equalTestP;

  public static StellaHashTable newStellaHashTable() {
    { StellaHashTable self = null;

      self = new StellaHashTable();
      self.theStellaHashTable = null;
      self.theHashTable = null;
      self.equalTestP = false;
      self.freeElements = Stella.NULL_INTEGER;
      self.initialSize = 50;
      self.size = Stella.NULL_INTEGER;
      self.theTable = null;
      self.initializeHashTable();
      return (self);
    }
  }

  /** Allocate an iterator for <code>self</code>.
   * @return AbstractIterator
   */
  public AbstractIterator allocateIterator() {
    { StellaHashTable self = this;

      { StellaHashTableIterator self000 = StellaHashTableIterator.newStellaHashTableIterator();

        self000.size = self.size;
        self000.bucketTable = self.theTable;
        self000.bucketIndex = 0;
        self000.bucketCursor = null;
        { StellaHashTableIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of entries of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { StellaHashTable self = this;

      { int code = 36273463;

        { Stella_Object key = null;
          Stella_Object value = null;
          StellaHashTableIterator iter000 = ((StellaHashTableIterator)(self.allocateIterator()));

          while (iter000.nextP()) {
            key = iter000.key;
            value = iter000.value;
            code = (code ^ (key.equalHashCode()));
            code = (code ^ (value.equalHashCode()));
          }
        }
        return (code);
      }
    }
  }

  /** Return TRUE if <code>x</code> and <code>y</code> represent the same set of key/value pairs.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { StellaHashTable x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_STELLA_HASH_TABLE)) {
        { StellaHashTable y000 = ((StellaHashTable)(y));

          if (x.length() == y000.length()) {
            { Stella_Object key = null;
              Stella_Object value = null;
              StellaHashTableIterator iter000 = ((StellaHashTableIterator)(x.allocateIterator()));

              while (iter000.nextP()) {
                key = iter000.key;
                value = iter000.value;
                if (!Stella_Object.equalP(value, y000.lookup(key))) {
                  return (false);
                }
              }
            }
            return (true);
          }
        }
      }
      else {
      }
      return (false);
    }
  }

  /** Collect all entries of <code>self</code> into a cons list of
   * <code>_LkeyGLvalueG_</code> pairs and return the result.
   * @return Cons
   */
  public Cons consify() {
    { StellaHashTable self = this;

      { Cons result = Stella.NIL;

        { Stella_Object key = null;
          Stella_Object value = null;
          StellaHashTableIterator iter000 = ((StellaHashTableIterator)(self.allocateIterator()));
          Cons collect000 = null;

          while (iter000.nextP()) {
            key = iter000.key;
            value = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Cons.cons(key, Cons.cons(value, Stella.NIL)), Stella.NIL);
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
                collect000.rest = Cons.cons(Cons.cons(key, Cons.cons(value, Stella.NIL)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Remove all entries from <code>self</code>.  This will result in a
   * re-initialization of the table upon the first insertion into <code>self</code>.
   */
  public void clear() {
    { StellaHashTable self = this;

      self.theTable = null;
      self.size = Stella.NULL_INTEGER;
      self.freeElements = Stella.NULL_INTEGER;
    }
  }

  /** Return a copy of the hash table <code>self</code>.  The bucket table
   * and buckets are freshly allocated, however, the keys and values of entries
   * are not copied themselves (similar to what we do for lists, etc.).
   * @return StellaHashTable
   */
  public StellaHashTable copy() {
    { StellaHashTable self = this;

      { int size = self.size;

        { StellaHashTable self000 = StellaHashTable.newStellaHashTable();

          self000.size = size;
          self000.initialSize = self.initialSize;
          self000.freeElements = self.freeElements;
          self000.equalTestP = self.equalTestP;
          { StellaHashTable copy = self000;
            KvCons[] table = self.theTable;
            KvCons[] tablecopy = table;
            KvCons bucket = null;

            if (table != null) {
              tablecopy = new KvCons[size];
              copy.theTable = tablecopy;
              { int i = Stella.NULL_INTEGER;
                int iter000 = 0;
                int upperBound000 = size - 1;

                for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                  i = iter000;
                  bucket = table[i];
                  if (bucket != null) {
                    tablecopy[i] = KvCons.copyKvConsList(bucket);
                  }
                  else {
                    tablecopy[i] = null;
                  }
                }
              }
            }
            return (copy);
          }
        }
      }
    }
  }

  /** Return TRUE if <code>self</code> has at least 1 entry.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { StellaHashTable self = this;

      return (self.length() > 0);
    }
  }

  /** Return TRUE if <code>self</code> has zero entries.
   * @return boolean
   */
  public boolean emptyP() {
    { StellaHashTable self = this;

      return (self.length() == 0);
    }
  }

  /** Return the number of entries in <code>self</code>.
   * @return int
   */
  public int length() {
    { StellaHashTable self = this;

      if (self.theTable == null) {
        return (0);
      }
      else {
        return (self.size - self.freeElements);
      }
    }
  }

  /** Remove the entry identified by <code>key</code> from <code>self</code>.  Uses an
   * <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   */
  public void removeAt(Stella_Object key) {
    { StellaHashTable self = this;

      StellaHashTable.stellaHashTableRemoveAt(self, key);
      return;
    }
  }

  /** Set the value of the entry identified by <code>key</code> in <code>self</code>
   * to <code>value</code> or add a new entry if no entry with <code>key</code> exists yet.  Uses an
   * <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   * @param value
   */
  public void insertAt(Stella_Object key, Stella_Object value) {
    { StellaHashTable self = this;

      StellaHashTable.stellaHashTableInsertAt(self, key, value);
      return;
    }
  }

  /** Lookup the entry identified by <code>key</code> in <code>self</code> and
   * return its value, or NULL if no such entry exists.    Uses an <code>eqlP</code>
   * test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   * @return Stella_Object
   */
  public Stella_Object lookup(Stella_Object key) {
    { StellaHashTable self = this;

      return (StellaHashTable.stellaHashTableLookup(self, key));
    }
  }

  public static Stella_Object stellaStringHashTableLookup(StellaHashTable self, String key) {
    { KvCons[] table = self.theTable;
      KvCons bucket = null;

      if (table == null) {
        return (null);
      }
      bucket = table[(((key.hashCode()) & 0x7FFFFFFF) % (self.size))];
      while (bucket != null) {
        if (Stella.stringEqlP(((StringWrapper)(bucket.key)).wrapperValue, key)) {
          return (bucket.value);
        }
        else {
          bucket = bucket.rest;
        }
      }
      return (null);
    }
  }

  public static Stella_Object stellaHashTableLookup(StellaHashTable self, Stella_Object key) {
    { KvCons[] table = self.theTable;
      KvCons bucket = null;

      if (table == null) {
        return (null);
      }
      if (self.equalTestP) {
        bucket = table[(((key.equalHashCode()) & 0x7FFFFFFF) % (self.size))];
        while (bucket != null) {
          if (Stella_Object.equalP(bucket.key, key)) {
            return (bucket.value);
          }
          else {
            bucket = bucket.rest;
          }
        }
      }
      else {
        bucket = table[(((key.hashCode_()) & 0x7FFFFFFF) % (self.size))];
        while (bucket != null) {
          if (Stella_Object.eqlP(bucket.key, key)) {
            return (bucket.value);
          }
          else {
            bucket = bucket.rest;
          }
        }
      }
      return (null);
    }
  }

  public static void stellaHashTableRemoveAt(StellaHashTable self, Stella_Object key) {
    { KvCons[] table = self.theTable;
      int bucketindex = 0;
      KvCons bucket = null;
      boolean equaltestP = self.equalTestP;

      if (table == null) {
        return;
      }
      if (equaltestP) {
        bucketindex = (((key.equalHashCode()) & 0x7FFFFFFF) % (self.size));
      }
      else {
        bucketindex = (((key.hashCode_()) & 0x7FFFFFFF) % (self.size));
      }
      bucket = table[bucketindex];
      if (bucket == null) {
        return;
      }
      else if ((!equaltestP) &&
          Stella_Object.eqlP(bucket.key, key)) {
        table[bucketindex] = bucket.rest;
        self.freeElements = self.freeElements + 1;
        return;
      }
      else if (equaltestP &&
          Stella_Object.equalP(bucket.key, key)) {
        table[bucketindex] = bucket.rest;
        self.freeElements = self.freeElements + 1;
        return;
      }
      else {
        { KvCons trailer = bucket;

          bucket = bucket.rest;
          while (bucket != null) {
            if ((!equaltestP) &&
                Stella_Object.eqlP(bucket.key, key)) {
              trailer.rest = bucket.rest;
              self.freeElements = self.freeElements + 1;
              return;
            }
            else if (equaltestP &&
                Stella_Object.equalP(bucket.key, key)) {
              trailer.rest = bucket.rest;
              self.freeElements = self.freeElements + 1;
              return;
            }
            else {
              trailer = bucket;
              bucket = bucket.rest;
            }
          }
        }
      }
    }
  }

  public static void stellaHashTableInsertAt(StellaHashTable self, Stella_Object key, Stella_Object value) {
    { KvCons[] table = self.theTable;
      int free = self.freeElements;
      int bucketindex = 0;
      KvCons bucket = null;
      boolean equaltestP = self.equalTestP;

      if (table == null) {
        StellaHashTable.initializeStellaHashTable(self);
        table = self.theTable;
        free = self.freeElements;
      }
      if (free == 0) {
        StellaHashTable.rehashStellaHashTable(self, Stella.pickHashTableSizePrime(self.size + 1));
        table = self.theTable;
        free = self.freeElements;
      }
      if (equaltestP) {
        bucketindex = (((key.equalHashCode()) & 0x7FFFFFFF) % (self.size));
      }
      else {
        bucketindex = (((key.hashCode_()) & 0x7FFFFFFF) % (self.size));
      }
      bucket = table[bucketindex];
      if (bucket == null) {
        { KvCons self000 = KvCons.newKvCons();

          self000.key = key;
          self000.value = value;
          table[bucketindex] = self000;
        }
        self.freeElements = free - 1;
      }
      else {
        { KvCons cursor = bucket;

          if (equaltestP) {
            while ((cursor != null) &&
                (!Stella_Object.equalP(cursor.key, key))) {
              cursor = cursor.rest;
            }
          }
          else {
            while ((cursor != null) &&
                (!Stella_Object.eqlP(cursor.key, key))) {
              cursor = cursor.rest;
            }
          }
          if (cursor != null) {
            cursor.value = value;
          }
          else {
            { KvCons self001 = KvCons.newKvCons();

              self001.key = key;
              self001.value = value;
              self001.rest = bucket.rest;
              bucket.rest = self001;
            }
            self.freeElements = free - 1;
          }
        }
      }
    }
  }

  public static void rehashStellaHashTable(StellaHashTable self, int newsize) {
    if (self.theTable == null) {
      StellaHashTable.initializeStellaHashTable(self);
      return;
    }
    { int size = self.size;
      KvCons[] table = self.theTable;
      KvCons[] newtable = new KvCons[newsize];
      int newbucketindex = 0;
      KvCons newbucket = null;
      KvCons cursor = null;
      KvCons current = null;
      boolean equaltestP = self.equalTestP;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = newsize - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          newtable[i] = null;
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter001 = 0;
        int upperBound001 = size - 1;

        for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
          i = iter001;
          cursor = table[i];
          while (cursor != null) {
            if (equaltestP) {
              newbucketindex = (((cursor.key.equalHashCode()) & 0x7FFFFFFF) % newsize);
            }
            else {
              newbucketindex = (((cursor.key.hashCode_()) & 0x7FFFFFFF) % newsize);
            }
            newbucket = newtable[newbucketindex];
            current = cursor;
            cursor = cursor.rest;
            if (newbucket != null) {
              current.rest = newbucket.rest;
              newbucket.rest = current;
            }
            else {
              newtable[newbucketindex] = current;
              current.rest = null;
            }
          }
        }
      }
      self.theTable = newtable;
      self.size = newsize;
      self.freeElements = Stella.integer_max(self.freeElements + Native.floor((newsize - size) * Stella.$STELLA_HASH_TABLE_AVG_BUCKET_LENGTH$), 0);
    }
  }

  /** Initialize the STELLA hash table <code>self</code>.  This is a
   * no-op and primarily exists to shadow the standard initializer inherited
   * from ABSTRACT-HASH-TABLE.  STELLA hash tables are initialized at the
   * first insertion operation.
   */
  public void initializeHashTable() {
    { StellaHashTable self = this;

    }
  }

  public static void initializeStellaHashTable(StellaHashTable self) {
    { int size = Stella.pickHashTableSizePrime(Native.floor(self.initialSize / Stella.$STELLA_HASH_TABLE_AVG_BUCKET_LENGTH$));
      KvCons[] table = new KvCons[size];

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = size - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          table[i] = null;
        }
      }
      self.theTable = table;
      self.size = size;
      self.freeElements = Native.floor(size * Stella.$STELLA_HASH_TABLE_AVG_BUCKET_LENGTH$);
    }
  }

  public static Stella_Object accessStellaHashTableSlotValue(StellaHashTable self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SIZE) {
      if (setvalueP) {
        self.size = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.size);
      }
    }
    else if (slotname == Stella.SYM_STELLA_INITIAL_SIZE) {
      if (setvalueP) {
        self.initialSize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.initialSize);
      }
    }
    else if (slotname == Stella.SYM_STELLA_FREE_ELEMENTS) {
      if (setvalueP) {
        self.freeElements = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.freeElements);
      }
    }
    else if (slotname == Stella.SYM_STELLA_EQUAL_TESTp) {
      if (setvalueP) {
        self.equalTestP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.equalTestP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { StellaHashTable self = this;

      return (Stella.SGT_STELLA_STELLA_HASH_TABLE);
    }
  }

}

