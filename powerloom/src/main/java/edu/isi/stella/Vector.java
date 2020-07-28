//  -*- Mode: Java -*-
//
// Vector.java

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

public class Vector extends Sequence {
    public int arraySize;
    public edu.isi.stella.Stella_Object[] theArray;

  public static Vector newVector(int arraySize) {
    { Vector self = null;

      self = new Vector();
      self.arraySize = arraySize;
      self.theArray = null;
      self.initializeVector();
      return (self);
    }
  }

  /** Just like <code>sort</code> but assumes each element of <code>self</code> has a <code>slot</code>
   * whose value will be used for comparison.  Elements must be descendants of
   * STANDARD OBJECT.  Note that while this will work with literal-valued slots,
   * it will cause value wrapping everytime <code>slot</code> is read.
   * @param slot
   * @param predicate
   * @return Vector
   */
  public Vector sortObjects(StorageSlot slot, java.lang.reflect.Method predicate) {
    { Vector self = this;

      { int length = self.length();

        if (length == 0) {
          return (self);
        }
        else if (predicate == null) {
          predicate = Stella_Object.chooseSortPredicate(StandardObject.readSlotValue(((StandardObject)((self.theArray)[0])), slot));
        }
        { Object old$SortTupleComparePredicate$000 = Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get();
          Object old$SortObjectsCompareSlot$000 = Stella.$SORT_OBJECTS_COMPARE_SLOT$.get();

          try {
            Native.setSpecial(Stella.$SORT_TUPLE_COMPARE_PREDICATE$, predicate);
            Native.setSpecial(Stella.$SORT_OBJECTS_COMPARE_SLOT$, slot);
            Stella.heapSortNativeVector(self.theArray, self.length(), Native.find_java_method("edu.isi.stella.Stella_Object", "sortObjectsCompareP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}));
            return (self);

          } finally {
            Stella.$SORT_OBJECTS_COMPARE_SLOT$.set(old$SortObjectsCompareSlot$000);
            Stella.$SORT_TUPLE_COMPARE_PREDICATE$.set(old$SortTupleComparePredicate$000);
          }
        }
      }
    }
  }

  /** Just like <code>sort</code> but assumes each element of <code>self</code> is a tuple (a cons)
   * whose <code>n</code>-th element (0-based) will be used for comparison.
   * @param n
   * @param predicate
   * @return Vector
   */
  public Vector sortTuples(int n, java.lang.reflect.Method predicate) {
    { Vector self = this;

      { int length = self.length();

        if (length == 0) {
          return (self);
        }
        else if (predicate == null) {
          predicate = Stella_Object.chooseSortPredicate(((Cons)((self.theArray)[0])).nth(n));
        }
        { Object old$SortTupleComparePredicate$000 = Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get();
          Object old$SortTupleCompareIndex$000 = Stella.$SORT_TUPLE_COMPARE_INDEX$.get();

          try {
            Native.setSpecial(Stella.$SORT_TUPLE_COMPARE_PREDICATE$, predicate);
            Native.setIntSpecial(Stella.$SORT_TUPLE_COMPARE_INDEX$, n);
            Stella.heapSortNativeVector(self.theArray, self.length(), Native.find_java_method("edu.isi.stella.Cons", "sortTupleCompareP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}));
            return (self);

          } finally {
            Stella.$SORT_TUPLE_COMPARE_INDEX$.set(old$SortTupleCompareIndex$000);
            Stella.$SORT_TUPLE_COMPARE_PREDICATE$.set(old$SortTupleComparePredicate$000);
          }
        }
      }
    }
  }

  /** Perform a destructive sort of <code>self</code> according to
   * <code>predicate</code>, and return the result.  If <code>predicate</code> has a '&lt;' semantics, the
   * result will be in ascending order.  If <code>predicate</code> is <code>null</code>, a
   * suitable '&lt;' predicate is chosen depending on the first element of <code>self</code>,
   * and it is assumed that all elements of <code>self</code> have the same type (supported
   * element types are GENERALIZED-SYMBOL, STRING, INTEGER, and FLOAT).
   * @param predicate
   * @return Vector
   */
  public Vector sort(java.lang.reflect.Method predicate) {
    { Vector self = this;

      { int length = self.length();

        if (length == 0) {
          return (self);
        }
        else if (predicate == null) {
          predicate = Stella_Object.chooseSortPredicate((self.theArray)[0]);
        }
        Stella.heapSortNativeVector(self.theArray, self.length(), predicate);
        return (self);
      }
    }
  }

  /** Generate all but the last element of the vector <code>self</code>.
   * @return Iterator
   */
  public Iterator butLast() {
    { Vector self = this;

      { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

        iterator.iteratorObject = self;
        iterator.iteratorInteger = 0;
        iterator.iteratorSecondInteger = self.arraySize - 1;
        iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "vectorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        return (iterator);
      }
    }
  }

  public AbstractIterator allocateIterator() {
    { Vector self = this;

      { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

        iterator.iteratorObject = self;
        iterator.iteratorInteger = 0;
        iterator.iteratorSecondInteger = self.length();
        iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "vectorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        return (iterator);
      }
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { Vector self = this;

      { int cursor = self.length();
        int code = 66435053;

        loop000 : for (;;) {
          if (cursor == 0) {
            break loop000;
          }
          else {
            cursor = cursor - 1;
          }
          code = (code ^ (Stella_Object.safeEqualHashCode((self.theArray)[cursor])));
          code = (((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$));
        }
        return (code);
      }
    }
  }

  /** Return TRUE iff the vectors <code>x</code> and <code>y</code> are structurally
   * equivalent.  Uses <code>equalP</code> to test equality of elements.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { Vector x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_VECTOR)) {
        { Vector y000 = ((Vector)(y));

          if (x.arraySize == y000.arraySize) {
            { Stella_Object eltx = null;
              Vector vector000 = x;
              int index000 = 0;
              int length000 = vector000.length();
              Stella_Object elty = null;
              Vector vector001 = y000;
              int index001 = 0;
              int length001 = vector001.length();

              for (;(index000 < length000) &&
                        (index001 < length001); index000 = index000 + 1, index001 = index001 + 1) {
                eltx = (vector000.theArray)[index000];
                elty = (vector001.theArray)[index001];
                if (!Stella_Object.equalP(eltx, elty)) {
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

  public void clear() {
    { Vector self = this;

      { int size = self.arraySize;
        edu.isi.stella.Stella_Object[] array = self.theArray;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = size - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            array[i] = null;
          }
        }
      }
    }
  }

  /** Return a copy of the vector <code>self</code>.
   * @return Vector
   */
  public Vector copy() {
    { Vector self = this;

      { int size = self.arraySize;
        edu.isi.stella.Stella_Object[] sourcearray = self.theArray;
        Vector copy = Vector.newVector(size);
        edu.isi.stella.Stella_Object[] copyarray = copy.theArray;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = size - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            copyarray[i] = (sourcearray[i]);
          }
        }
        return (copy);
      }
    }
  }

  public void insertAt(int offset, Stella_Object value) {
    { Vector self = this;

      if (offset >= self.arraySize) {
        throw ((StellaException)(StellaException.newStellaException("Out-of-bounds array access").fillInStackTrace()));
      }
      (self.theArray)[offset] = value;
    }
  }

  /** Return the position of <code>renamed_Object</code> within the vector
   * <code>self</code> (counting from zero); or return <code>null</code> if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>end</code> was supplied as non-<code>null</code>, only 
   * consider the portion ending at index <code>end</code>, however, the returned position 
   * will always be relative to the entire vector.
   * @param renamed_Object
   * @param end
   * @return int
   */
  public int lastPosition(Stella_Object renamed_Object, int end) {
    { Vector self = this;

      if (end == Stella.NULL_INTEGER) {
        end = self.length() - 1;
      }
      { int i = Stella.NULL_INTEGER;
        ReverseIntegerIntervalIterator iter000 = Stella.interval(0, end).reverse();

        while (iter000.nextP()) {
          i = iter000.value;
          if (Stella_Object.eqlP((self.theArray)[i], renamed_Object)) {
            return (i);
          }
        }
      }
      return (Stella.NULL_INTEGER);
    }
  }

  /** Return the position of <code>renamed_Object</code> within the vector
   * <code>self</code> (counting from zero); or return <code>null</code> if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>start</code> was supplied as non-<code>null</code>, only 
   * consider the portion starting at <code>start</code>, however, the returned position 
   * will always be relative to the entire vector.
   * @param renamed_Object
   * @param start
   * @return int
   */
  public int position(Stella_Object renamed_Object, int start) {
    { Vector self = this;

      if (start == Stella.NULL_INTEGER) {
        start = 0;
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = start;
        int upperBound000 = self.length() - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          if (Stella_Object.eqlP((self.theArray)[i], renamed_Object)) {
            return (i);
          }
        }
      }
      return (Stella.NULL_INTEGER);
    }
  }

  public boolean memberP(Stella_Object renamed_Object) {
    { Vector self = this;

      { edu.isi.stella.Stella_Object[] array = self.theArray;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = self.length() - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            if (Stella_Object.eqlP(array[i], renamed_Object)) {
              return (true);
            }
          }
        }
        return (false);
      }
    }
  }

  public int length() {
    { Vector self = this;

      return (self.arraySize);
    }
  }

  public Stella_Object lastSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[(self.arraySize - 1)] = value);
    }
  }

  public Stella_Object nthSetter(Stella_Object value, int position) {
    { Vector self = this;

      return ((self.theArray)[position] = value);
    }
  }

  public Stella_Object fifthSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[4] = value);
    }
  }

  public Stella_Object fourthSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[3] = value);
    }
  }

  public Stella_Object thirdSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[2] = value);
    }
  }

  public Stella_Object secondSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[1] = value);
    }
  }

  public Stella_Object firstSetter(Stella_Object value) {
    { Vector self = this;

      return ((self.theArray)[0] = value);
    }
  }

  /** Return the last item in the vector <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object last() {
    { Vector self = this;

      return ((self.theArray)[(self.arraySize - 1)]);
    }
  }

  public Stella_Object nth(int position) {
    { Vector self = this;

      return ((self.theArray)[position]);
    }
  }

  public Stella_Object fifth() {
    { Vector self = this;

      return ((self.theArray)[4]);
    }
  }

  public Stella_Object fourth() {
    { Vector self = this;

      return ((self.theArray)[3]);
    }
  }

  public Stella_Object third() {
    { Vector self = this;

      return ((self.theArray)[2]);
    }
  }

  public Stella_Object second() {
    { Vector self = this;

      return ((self.theArray)[1]);
    }
  }

  public Stella_Object first() {
    { Vector self = this;

      return ((self.theArray)[0]);
    }
  }

  /** Return <code>true</code> if <code>self</code> has length &gt; 0.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { Vector self = this;

      return (self.arraySize > 0);
    }
  }

  /** Return <code>true</code> if <code>self</code> has length 0.
   * @return boolean
   */
  public boolean emptyP() {
    { Vector self = this;

      return (self.arraySize == 0);
    }
  }

  public void printVector(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Vector self = this;

      if (self.length() == 0) {
        stream.print("|i|[]");
      }
      else {
        { int i = 0;
          int limit = 9;

          stream.print("|i|[");
          { Stella_Object element = null;
            Vector vector000 = self;
            int index000 = 0;
            int length000 = vector000.length();

            loop000 : for (;index000 < length000; index000 = index000 + 1) {
              element = (vector000.theArray)[index000];
              stream.print(element);
              i = i + 1;
              if (i > limit) {
                break loop000;
              }
              if (i < self.length()) {
                stream.print(" ");
              }
            }
          }
          if ((i <= limit) ||
              (i == self.length())) {
            stream.print("]");
          }
          else {
            stream.print(" ...]");
          }
        }
      }
    }
  }

  /** Return a list of elements in <code>self</code>.
   * @return List
   */
  public List listify() {
    { Vector self = this;

      { List result = List.newList();

        { Stella_Object v = null;
          Vector vector000 = self;
          int index000 = 0;
          int length000 = vector000.length();
          Cons collect000 = null;

          for (;index000 < length000; index000 = index000 + 1) {
            v = (vector000.theArray)[index000];
            if (collect000 == null) {
              {
                collect000 = Cons.cons(v, Stella.NIL);
                if (result.theConsList == Stella.NIL) {
                  result.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(result.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(v, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Return a list of elements in <code>self</code>.
   * @return Cons
   */
  public Cons consify() {
    { Vector self = this;

      { Cons result = Stella.NIL;

        { Stella_Object v = null;
          Vector vector000 = self;
          int index000 = 0;
          int length000 = vector000.length();
          Cons collect000 = null;

          for (;index000 < length000; index000 = index000 + 1) {
            v = (vector000.theArray)[index000];
            if (collect000 == null) {
              {
                collect000 = Cons.cons(v, Stella.NIL);
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
                collect000.rest = Cons.cons(v, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        return (result);
      }
    }
  }

  /** Change the size of <code>self</code> to <code>size</code>.  If <code>size</code> is smaller
   * than the current size of <code>self</code> the vector will be truncated.  Otherwise, 
   * the internal array of <code>self</code> will be grown to <code>size</code> and unused elements
   * will be initialized to NULL.
   * @param self
   * @param size
   */
  public static void resizeVector(Vector self, int size) {
    { int old_size = self.arraySize;
      int i = old_size;
      edu.isi.stella.Stella_Object[] old_array = self.theArray;
      edu.isi.stella.Stella_Object[] new_array = old_array;

      if (size == old_size) {
        return;
      }
      new_array = new edu.isi.stella.Stella_Object[size];
      if (size < old_size) {
        old_size = size;
        i = old_size;
      }
      while ((i = i - 1) >= 0) {
        new_array[i] = (old_array[i]);
      }
      i = i;
      self.theArray = new_array;
      self.arraySize = size;
    }
  }

  public void initializeVector() {
    { Vector self = this;

      { int size = self.arraySize;

        self.theArray = new edu.isi.stella.Stella_Object[size];
        size = size;
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Vector self = this;

      self.printVector(stream);
    }
  }

  public static Stella_Object accessVectorSlotValue(Vector self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_ARRAY_SIZE) {
      if (setvalueP) {
        self.arraySize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.arraySize);
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
    { Vector self = this;

      return (Stella.SGT_STELLA_VECTOR);
    }
  }

}

