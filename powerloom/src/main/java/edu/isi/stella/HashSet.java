//  -*- Mode: Java -*-
//
// HashSet.java

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

/** Full-featured set class that supports <code>eqlP</code> or <code>equalP</code>
 * equality tests, O(1) insert and <code>memberP</code> operations &amp; O(N) <code>intersection</code>
 * etc. operations even for large numbers of entries by using a hash table,
 * light-weight KV-CONS representation for small sets and iteration even if the
 * set is represented by a hash table.  The only minor drawback right now is that
 * this wastes a value slot per entry, since we piggy-back off KEY-VALUE-MAP's,
 * however, that wastes at most 25% space.
 * @author Stella Java Translator
 */
public class HashSet extends KeyValueMap {
  public static HashSet newHashSet() {
    { HashSet self = null;

      self = new HashSet();
      self.crossoverPoint = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
      self.initialSize = Stella.$KEY_VALUE_MAP_CROSSOVER_POINT$;
      self.equalTestP = false;
      self.theMap = null;
      return (self);
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of elements of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { HashSet self = this;

      { int code = 7971569;

        { Stella_Object elt = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

          while (iter000.nextP()) {
            elt = iter000.value;
            code = (code ^ (elt.equalHashCode()));
          }
        }
        return (code);
      }
    }
  }

  /** Return TRUE iff sets <code>x</code> and <code>y</code> are HASH-SET's with equivalent members.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * This is equivalent to calling <code>equivalentSetsP</code>.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { HashSet x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_HASH_SET)) {
        { HashSet y000 = ((HashSet)(y));

          return (x.equivalentSetsP(y000));
        }
      }
      else {
      }
      return (false);
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherset</code> by destructively
   * removing elements from <code>self</code> that also occur in <code>otherset</code>.  Uses an <code>eqlP</code>
   * test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return HashSet
   */
  public HashSet subtract(HashSet otherset) {
    { HashSet self = this;

      { Stella_Object elt = null;
        DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

        while (iter000.nextP()) {
          elt = iter000.value;
          if (otherset.lookup(elt) != null) {
            self.removeAt(elt);
          }
        }
      }
      return (self);
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherset</code> as a new set (i.e.,
   * all elements that are in <code>self</code> but not in <code>otherset</code>).  Uses an <code>eqlP</code> test
   * by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return HashSet
   */
  public HashSet difference(HashSet otherset) {
    { HashSet self = this;

      { HashSet result = null;

        if (self.length() > (otherset.length() * 2)) {
          result = ((HashSet)(self.copy()));
          { Stella_Object elt = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(otherset.allocateIterator()));

            while (iter000.nextP()) {
              elt = iter000.value;
              if (result.lookup(elt) != null) {
                result.removeAt(elt);
              }
            }
          }
        }
        else {
          { HashSet self000 = HashSet.newHashSet();

            self000.equalTestP = self.equalTestP;
            result = self000;
          }
          { Stella_Object elt = null;
            DictionaryIterator iter001 = ((DictionaryIterator)(self.allocateIterator()));

            while (iter001.nextP()) {
              elt = iter001.value;
              if (!(otherset.lookup(elt) != null)) {
                result.insertAt(elt, elt);
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Return the set union of <code>self</code> and <code>otherset</code> as a new set.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return HashSet
   */
  public HashSet union(HashSet otherset) {
    { HashSet self = this;

      { HashSet result = null;
        HashSet aux = self;

        if (self.length() < otherset.length()) {
          self = otherset;
          otherset = aux;
        }
        result = ((HashSet)(self.copy()));
        { Stella_Object elt = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(otherset.allocateIterator()));

          while (iter000.nextP()) {
            elt = iter000.value;
            result.insertAt(elt, elt);
          }
        }
        return (result);
      }
    }
  }

  /** Return the set intersection of <code>self</code> and <code>otherset</code> as a new set.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return HashSet
   */
  public HashSet intersection(HashSet otherset) {
    { HashSet self = this;

      { HashSet self000 = HashSet.newHashSet();

        self000.equalTestP = self.equalTestP;
        { HashSet result = self000;
          HashSet aux = self;

          if (self.length() > otherset.length()) {
            self = otherset;
            otherset = aux;
          }
          { Stella_Object elt = null;
            DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

            while (iter000.nextP()) {
              elt = iter000.value;
              if (otherset.lookup(elt) != null) {
                result.insertAt(elt, elt);
              }
            }
          }
          return (result);
        }
      }
    }
  }

  /** Return true if every element of <code>self</code> occurs in <code>otherset</code> and vice versa.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return boolean
   */
  public boolean equivalentSetsP(HashSet otherset) {
    { HashSet self = this;

      { boolean testValue000 = false;

        testValue000 = self.length() == otherset.length();
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object elt = null;
              DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

              loop000 : while (iter000.nextP()) {
                elt = iter000.value;
                if (!(otherset.lookup(elt) != null)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
        { boolean value000 = testValue000;

          return (value000);
        }
      }
    }
  }

  /** Return true if every element of <code>self</code> also occurs in <code>otherset</code>.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param otherset
   * @return boolean
   */
  public boolean subsetP(HashSet otherset) {
    { HashSet self = this;

      { boolean testValue000 = false;

        testValue000 = self.length() <= otherset.length();
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object elt = null;
              DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

              loop000 : while (iter000.nextP()) {
                elt = iter000.value;
                if (!(otherset.lookup(elt) != null)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
        { boolean value000 = testValue000;

          return (value000);
        }
      }
    }
  }

  /** Collect all entries of <code>self</code> into a cons list and return the result.
   * @return Cons
   */
  public Cons consify() {
    { HashSet self = this;

      { Cons result = Stella.NIL;

        { Stella_Object value = null;
          DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));
          Cons collect000 = null;

          while (iter000.nextP()) {
            value = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(value, Stella.NIL);
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
                collect000.rest = Cons.cons(value, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Return a copy of the set <code>self</code>.  All entries are freshly
   * allocated, however, the values are not copied themselves (similar to what we
   * do for lists, etc.).
   * @return KeyValueMap
   */
  public KeyValueMap copy() {
    { HashSet self = this;

      { HashSet self000 = HashSet.newHashSet();

        self000.equalTestP = self.equalTestP;
        self000.initialSize = self.initialSize;
        self000.crossoverPoint = self.crossoverPoint;
        { HashSet copy = self000;
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

  /** Destructively replace <code>old</code> with <code>renamed_New</code> in the set <code>self</code>
   * unless <code>renamed_New</code> is already a member.  Uses an <code>eqlP</code> test by default or <code>equalP</code>
   * if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param renamed_New
   * @param old
   * @return HashSet
   */
  public HashSet substitute(Stella_Object renamed_New, Stella_Object old) {
    { HashSet self = this;

      if (!self.memberP(renamed_New)) {
        self.removeAt(old);
        self.insertAt(renamed_New, renamed_New);
      }
      return (self);
    }
  }

  /** Remove and return an arbitrary element of the set <code>self</code>.
   * Return NULL if the set is empty.  Performance note: for large sets implemented
   * via hash tables it takes O(N) to empty out the set with repeated calls to <code>pop</code>,
   * since the emptier the table gets, the longer it takes to find an element.
   * Therefore, it is usually better to use iteration with embedded removals for
   * such cases.
   * @return Stella_Object
   */
  public Stella_Object pop() {
    { HashSet self = this;

      { Stella_Object element = null;
        Stella_Object setmap = self.theMap;

        if (setmap != null) {
          if (self.crossoverPoint == 0) {
            { StellaHashTable map = ((StellaHashTable)(setmap));
              KvCons[] table = map.theTable;
              KvCons bucket = null;

              if (table != null) {
                { int i = Stella.NULL_INTEGER;
                  int iter000 = 0;
                  int upperBound000 = map.size - 1;

                  loop000 : for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                    i = iter000;
                    bucket = table[i];
                    if (bucket != null) {
                      element = bucket.key;
                      break loop000;
                    }
                  }
                }
              }
            }
          }
          else {
            { KvCons map = ((KvCons)(self.theMap));

              if (map != null) {
                element = map.key;
              }
            }
          }
        }
        if (element != null) {
          self.removeAt(element);
        }
        return (element);
      }
    }
  }

  /** Destructively remove all elements of the set <code>self</code> for which
   * 'test?' evaluates to TRUE.  <code>testP</code> takes a single argument of type OBJECT and
   * returns TRUE or FALSE.  Returns <code>self</code>.
   * @param testP
   * @return HashSet
   */
  public HashSet removeIf(java.lang.reflect.Method testP) {
    { HashSet self = this;

      { Stella_Object element = null;
        DictionaryIterator iter000 = ((DictionaryIterator)(self.allocateIterator()));

        while (iter000.nextP()) {
          element = iter000.value;
          if (((Boolean)(edu.isi.stella.javalib.Native.funcall(testP, null, new java.lang.Object [] {element}))).booleanValue()) {
            self.removeAt(element);
          }
        }
      }
      return (self);
    }
  }

  /** Destructively remove <code>value</code> from the set <code>self</code> if it is a member and
   * return <code>self</code>.  Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of
   * <code>self</code> is TRUE.
   * @param value
   * @return AbstractCollection
   */
  public AbstractCollection remove(Stella_Object value) {
    { HashSet self = this;

      self.removeAt(value);
      return (self);
    }
  }

  /** Add <code>value</code> to the set <code>self</code> unless it is already a member.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param value
   */
  public void insert(Stella_Object value) {
    { HashSet self = this;

      self.insertAt(value, value);
    }
  }

  /** Return TRUE iff <code>renamed_Object</code> is a member of the set <code>self</code>.
   * Uses an <code>eqlP</code> test by default or <code>equalP</code> if <code>equalTestP</code> of <code>self</code> is TRUE.
   * @param renamed_Object
   * @return boolean
   */
  public boolean memberP(Stella_Object renamed_Object) {
    { HashSet self = this;

      return (self.lookup(renamed_Object) != null);
    }
  }

  public Surrogate primaryType() {
    { HashSet self = this;

      return (Stella.SGT_STELLA_HASH_SET);
    }
  }

}

