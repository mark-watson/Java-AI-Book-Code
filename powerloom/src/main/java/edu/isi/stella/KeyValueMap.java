//  -*- Mode: Java -*-
//
// KeyValueMap.java

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

/** Full-featured dictionary class that supports <code>eqlP</code> or
 * <code>equalP</code> equality tests, O(1) access operations even for large numbers
 * of entries by using a hash table, light-weight KV-CONS representation for
 * small tables and iteration even if the dictionary is represented by a
 * hash table.
 * @author Stella Java Translator
 */
public class KeyValueMap extends Dictionary {
    public Stella_Object theMap;
    /** If true use <code>equalP</code> as the
     * equality test (and <code>equalHashCode</code> as the hash function), otherwise,
     * use <code>eqlP</code> (and <code>hashCode</code>) (the default).
     */
    public boolean equalTestP;
    /** If supplied, the initial table
     * will be sized to hold at least that many elements.
     */
    public int initialSize;
    public int crossoverPoint;

  public static KeyValueMap newKeyValueMap() {
    { KeyValueMap self = null;

      self = new KeyValueMap();
      self.crossoverPoint = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
      self.initialSize = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
      self.equalTestP = false;
      self.theMap = null;
      return (self);
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of entries of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { KeyValueMap self = this;

      { int code = 2137005;

        { Stella_Object key = null;
          Stella_Object value = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

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
    { KeyValueMap x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_KEY_VALUE_MAP)) {
        { KeyValueMap y000 = ((KeyValueMap)(y));

          if (x.length() == y000.length()) {
            { Stella_Object key = null;
              Stella_Object value = null;
              DictionaryIterator iter000 = ((DictionaryIterator)(x.allocateIterator()));

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
    { KeyValueMap self = this;

      { Cons result = Stella.NIL;

        { Stella_Object key = null;
          Stella_Object value = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));
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

  /** Allocate an iterator for <code>self</code>.  The only modifying
   * operations allowed during iteration are removal of the current element or
   * changing its value.  All other removal or insertion operations might lead
   * to corruption or undefined results.
   * @return AbstractIterator
   */
  public AbstractIterator allocateIterator() {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;

        if (self.crossoverPoint == 0) {
          return (((StellaHashTableIterator)(((StellaHashTable)(map)).allocateIterator())));
        }
        else {
          { KeyValueList self000 = KeyValueList.newKeyValueList();

            self000.theKvList = ((KvCons)(map));
            { KvListIterator value000 = ((KvListIterator)(self000.allocateIterator()));

              return (value000);
            }
          }
        }
      }
    }
  }

  /** Reset <code>self</code> to have zero entries.
   */
  public void clear() {
    { KeyValueMap self = this;

      self.theMap = null;
      self.crossoverPoint = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
    }
  }

  /** Return a copy of the map <code>self</code>.  All entries are freshly
   * allocated, however, the keys and values of entries are not copied themselves
   *  (similar to what we do for lists, etc.).
   * @return KeyValueMap
   */
  public KeyValueMap copy() {
    { KeyValueMap self = this;

      { KeyValueMap self000 = KeyValueMap.newKeyValueMap();

        self000.equalTestP = self.equalTestP;
        self000.initialSize = self.initialSize;
        self000.crossoverPoint = self.crossoverPoint;
        { KeyValueMap copy = self000;
          Stella_Object map = self.theMap;

          if (self.crossoverPoint == 0) {
            copy.theMap = ((StellaHashTable)(map)).copy();
          }
          else {
            copy.theMap = KvCons.copyKvConsList(((KvCons)(map)));
          }
          return (copy);
        }
      }
    }
  }

  /** Return TRUE if <code>self</code> has at least 1 entry.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;

        if (map == null) {
          return (false);
        }
        else if (self.crossoverPoint == 0) {
          return (((StellaHashTable)(map)).length() > 0);
        }
        else {
          return (true);
        }
      }
    }
  }

  /** Return TRUE if <code>self</code> has zero entries.
   * @return boolean
   */
  public boolean emptyP() {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;

        if (map == null) {
          return (true);
        }
        else if (self.crossoverPoint == 0) {
          return (((StellaHashTable)(map)).length() == 0);
        }
        else {
          return (false);
        }
      }
    }
  }

  /** Return the number of entries in <code>self</code>.
   * @return int
   */
  public int length() {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;

        if (map == null) {
          return (0);
        }
        else if (self.crossoverPoint == 0) {
          return (((StellaHashTable)(map)).length());
        }
        else {
          return (((KvCons)(map)).length());
        }
      }
    }
  }

  /** Remove the entry identified by <code>key</code> from <code>self</code>.  Uses an
   * <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   */
  public void removeAt(Stella_Object key) {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;
        int crossover = self.crossoverPoint;

        if (crossover == 0) {
          StellaHashTable.stellaHashTableRemoveAt(((StellaHashTable)(map)), key);
        }
        else {
          { KvCons cursor = ((KvCons)(map));
            KvCons trailer = ((KvCons)(map));

            if (self.equalTestP) {
              loop000 : while (cursor != null) {
                if (Stella_Object.equalP(cursor.key, key)) {
                  break loop000;
                }
                trailer = cursor;
                cursor = cursor.rest;
              }
            }
            else {
              loop001 : while (cursor != null) {
                if (Stella_Object.eqlP(cursor.key, key)) {
                  break loop001;
                }
                trailer = cursor;
                cursor = cursor.rest;
              }
            }
            if (cursor == null) {
              return;
            }
            else if (cursor == trailer) {
              self.theMap = cursor.rest;
            }
            else {
              trailer.rest = cursor.rest;
            }
            self.crossoverPoint = crossover + 1;
          }
        }
      }
    }
  }

  /** Set the value of the entry identified by <code>key</code> in <code>self</code>
   * to <code>value</code> or add a new entry if no entry with <code>key</code> exists yet.  Uses an
   * <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   * @param value
   */
  public void insertAt(Stella_Object key, Stella_Object value) {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;
        int crossover = self.crossoverPoint;

        if (map == null) {
          if (self.initialSize > Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$) {
            { StellaHashTable self000 = StellaHashTable.newStellaHashTable();

              self000.initialSize = self.initialSize;
              self000.equalTestP = self.equalTestP;
              map = self000;
            }
            self.theMap = map;
            crossover = 0;
          }
          else {
            crossover = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
          }
          self.crossoverPoint = crossover;
        }
        if (crossover == 0) {
          StellaHashTable.stellaHashTableInsertAt(((StellaHashTable)(map)), key, value);
        }
        else {
          { KvCons cursor = ((KvCons)(map));

            if (self.equalTestP) {
              while (cursor != null) {
                if (Stella_Object.equalP(cursor.key, key)) {
                  cursor.value = value;
                  return;
                }
                cursor = cursor.rest;
              }
            }
            else {
              while (cursor != null) {
                if (Stella_Object.eqlP(cursor.key, key)) {
                  cursor.value = value;
                  return;
                }
                cursor = cursor.rest;
              }
            }
            cursor = KvCons.kvCons(key, value, ((KvCons)(map)));
            self.theMap = cursor;
            crossover = crossover - 1;
            self.crossoverPoint = crossover;
            if (crossover == 0) {
              { StellaHashTable self001 = StellaHashTable.newStellaHashTable();

                self001.equalTestP = self.equalTestP;
                map = self001;
              }
              self.theMap = map;
              { Stella_Object key000 = null;
                Stella_Object value000 = null;
                KvCons iter000 = cursor;

                for (;iter000 != null; iter000 = iter000.rest) {
                  key000 = iter000.key;
                  value000 = iter000.value;
                  StellaHashTable.stellaHashTableInsertAt(((StellaHashTable)(map)), key000, value000);
                }
              }
            }
          }
        }
      }
    }
  }

  /** Lookup the entry identified by <code>key</code> in <code>self</code> and
   * return its value, or NULL if no such entry exists.    Uses an <code>eqlP</code>
   * test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param key
   * @return Stella_Object
   */
  public Stella_Object lookup(Stella_Object key) {
    { KeyValueMap self = this;

      { Stella_Object map = self.theMap;
        int crossover = self.crossoverPoint;

        if (crossover == 0) {
          return (StellaHashTable.stellaHashTableLookup(((StellaHashTable)(map)), key));
        }
        else {
          { KvCons cursor = ((KvCons)(map));

            if (self.equalTestP) {
              while (cursor != null) {
                if (Stella_Object.equalP(cursor.key, key)) {
                  return (cursor.value);
                }
                cursor = cursor.rest;
              }
            }
            else {
              while (cursor != null) {
                if (Stella_Object.eqlP(cursor.key, key)) {
                  return (cursor.value);
                }
                cursor = cursor.rest;
              }
            }
            return (null);
          }
        }
      }
    }
  }

  public static Stella_Object accessKeyValueMapSlotValue(KeyValueMap self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_MAP) {
      if (setvalueP) {
        self.theMap = value;
      }
      else {
        value = self.theMap;
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
    else if (slotname == Stella.SYM_STELLA_INITIAL_SIZE) {
      if (setvalueP) {
        self.initialSize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.initialSize);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CROSSOVER_POINT) {
      if (setvalueP) {
        self.crossoverPoint = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.crossoverPoint);
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
    { KeyValueMap self = this;

      return (Stella.SGT_STELLA_KEY_VALUE_MAP);
    }
  }

}

