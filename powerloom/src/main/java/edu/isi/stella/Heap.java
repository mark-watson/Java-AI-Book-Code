//  -*- Mode: Java -*-
//
// Heap.java

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

/** Implements a Min or Max heap depending on the semantics
 * of <code>predicate</code> (Min if <code>predicate</code> has a <code>L</code> semantics).  This is useful
 * for in-place sorting (even though we have specialzed sort routines for that)
 * or to maintain top-N lists with log(N) insertion time.  We place this under
 * VECTOR instead of VECTOR-SEQUENCE for now, since sequential order isn't
 * really maintained or accessible until we sort the heap.
 * @author Stella Java Translator
 */
public class Heap extends Vector {
    public java.lang.reflect.Method predicate;
    public int fillPointer;

  public static Heap newHeap(java.lang.reflect.Method predicate, int arraySize) {
    { Heap self = null;

      self = new Heap();
      self.predicate = predicate;
      self.arraySize = arraySize;
      self.theArray = null;
      self.fillPointer = 0;
      self.initializeVector();
      self.initializeHeap();
      return (self);
    }
  }

  /** Sort the heap <code>self</code> according to <code>predicate</code> (in
   * ascending order if <code>predicate</code> has <code>L</code> semantics).  If <code>predicate</code>
   * is NULL simply use <code>self</code>s internal predicate (the normal case).
   * If it is different from <code>self</code>s internal predicate, heapify <code>self</code> first
   * according to the new predicate, store the new predicate in <code>self</code> and
   * then sort the heap.  Note that a sorted array automatically satisfies
   * the heap property.  This is slightly different than a regular heap
   * sort due to the way HEAP's are maintained; however, the complexity is
   * the same.
   * @param predicate
   * @return Vector
   */
  public Vector sort(java.lang.reflect.Method predicate) {
    { Heap self = this;

      { edu.isi.stella.Stella_Object[] values = self.theArray;
        int cursor = self.fillPointer;
        Stella_Object value = null;

        if (predicate == null) {
          predicate = self.predicate;
        }
        else if (!(predicate == self.predicate)) {
          self.predicate = predicate;
          self.heapify();
        }
        while (cursor > 0) {
          cursor = cursor - 1;
          value = values[cursor];
          values[cursor] = (values[0]);
          Stella.heapSiftDown(values, 0, cursor, value, predicate);
        }
        cursor = self.fillPointer;
        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;

          loop001 : for (;true; iter000 = iter000 + 1) {
            i = iter000;
            cursor = cursor - 1;
            if (i >= cursor) {
              break loop001;
            }
            value = values[i];
            values[i] = (values[cursor]);
            values[cursor] = value;
          }
        }
        return (self);
      }
    }
  }

  /** Restore the heap property of <code>self</code> according to its
   * <code>predicate</code>.  Normally, this is not needed, since insert operations
   * preserve the heap property.  However, this can be useful after bulk
   * insertion of values or if <code>predicate</code> has been changed.
   */
  public void heapify() {
    { Heap self = this;

      { edu.isi.stella.Stella_Object[] values = self.theArray;
        int fillpointer = self.fillPointer;
        java.lang.reflect.Method predicate = self.predicate;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = fillpointer - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            Stella.heapSiftUp(values, 0, i, values[i], predicate);
          }
        }
      }
    }
  }

  /** Insert <code>value</code> into <code>self</code> and restore the heap property.
   * If <code>self</code> has available room, simply insert <code>value</code>.  If the heap is full, only
   * insert <code>value</code> if it is better than the current root (i.e., if <code>value</code> is
   * greater than the minimum of <code>self</code> for the case of a min-heap where <code>self</code>s
   * <code>predicate</code> has <code>L</code> semantics).  In that case, replace the root of <code>self</code>
   * and restore the heap property.  This is useful to build and maintain a
   * heap with some top-N elements (relative to <code>predicate</code>) where the root (or
   * minimum) of <code>self</code> is the currently weakest element at the end of the list.
   * @param value
   */
  public void insertIfBetter(Stella_Object value) {
    { Heap self = this;

      { edu.isi.stella.Stella_Object[] values = self.theArray;
        int fillpointer = self.fillPointer;
        java.lang.reflect.Method predicate = self.predicate;

        if (fillpointer == self.arraySize) {
          if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {(self.theArray)[0], value}))).booleanValue()) {
            Stella.heapSiftDown(values, 0, fillpointer, value, predicate);
          }
        }
        else {
          Stella.heapSiftUp(values, 0, fillpointer, value, predicate);
          self.fillPointer = fillpointer + 1;
        }
      }
    }
  }

  /** Replace the current root of <code>self</code> with <code>value</code> and restore
   * the heap property.  Signal an error if <code>self</code> is empty.  Maintains <code>self</code> as
   * a Min-heap if <code>self</code>s <code>predicate</code> has <code>L</code> semantics; otherwise as a Max-heap.
   * @param value
   */
  public void replaceHeapRoot(Stella_Object value) {
    { Heap self = this;

      { edu.isi.stella.Stella_Object[] values = self.theArray;
        int fillpointer = self.fillPointer;
        java.lang.reflect.Method predicate = self.predicate;

        if (fillpointer == 0) {
          throw ((StellaException)(StellaException.newStellaException("HEAP.replace-heap-root: can't replace root of an empty heap").fillInStackTrace()));
        }
        else {
          Stella.heapSiftDown(values, 0, fillpointer, value, predicate);
        }
      }
    }
  }

  /** Insert <code>value</code> into <code>self</code> and restore the heap property.
   * Signal an error if there is no more room in <code>self</code>.  Maintains <code>self</code> as
   * a Min-heap if <code>self</code>s <code>predicate</code> has <code>L</code> semantics; otherwise as a Max-heap.
   * @param value
   */
  public void insert(Stella_Object value) {
    { Heap self = this;

      { edu.isi.stella.Stella_Object[] values = self.theArray;
        int fillpointer = self.fillPointer;
        java.lang.reflect.Method predicate = self.predicate;

        if (fillpointer < self.arraySize) {
          Stella.heapSiftUp(values, 0, fillpointer, value, predicate);
          self.fillPointer = fillpointer + 1;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("HEAP.insert: heap overflow, can't insert new value: `" + value + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
  }

  /** Return the root of <code>self</code> which is assumed to be non-empty.
   * @return Stella_Object
   */
  public Stella_Object fastHeapRoot() {
    { Heap self = this;

      return ((self.theArray)[0]);
    }
  }

  /** Return the root of <code>self</code> (NULL if <code>self</code> is empty).
   * The root contains the minimum element of a min-heap with '&lt;' predicate.
   * @return Stella_Object
   */
  public Stella_Object heapRoot() {
    { Heap self = this;

      return ((self.emptyP() ? null : (self.theArray)[0]));
    }
  }

  /** Return the last item in the heap <code>self</code> which will be the
   * largest or best item if <code>self</code> is a sorted min-heap with a '&lt;' predicate.
   * @return Stella_Object
   */
  public Stella_Object last() {
    { Heap self = this;

      return ((self.theArray)[(self.length() - 1)]);
    }
  }

  /** Return TRUE if <code>self</code> is empty.
   * @return boolean
   */
  public boolean emptyP() {
    { Heap self = this;

      return (self.fillPointer == 0);
    }
  }

  /** Return the length of the currently filled portion of <code>self</code>.
   * @return int
   */
  public int length() {
    { Heap self = this;

      return (self.fillPointer);
    }
  }

  /** Clear <code>self</code> by setting its active length to zero.
   */
  public void clear() {
    { Heap self = this;

      self.fillPointer = 0;
    }
  }

  /** Return a copy of the heap <code>self</code>.
   * @return Vector
   */
  public Vector copy() {
    { Heap self = this;

      { int length = self.fillPointer;

        { Heap self000 = Heap.newHeap(self.predicate, self.arraySize);

          self000.fillPointer = length;
          { Heap copy = self000;
            edu.isi.stella.Stella_Object[] sourcearray = self.theArray;
            edu.isi.stella.Stella_Object[] copyarray = copy.theArray;

            { int i = Stella.NULL_INTEGER;
              int iter000 = 0;
              int upperBound000 = length - 1;

              for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                i = iter000;
                copyarray[i] = (sourcearray[i]);
              }
            }
            return (copy);
          }
        }
      }
    }
  }

  public void initializeHeap() {
    { Heap self = this;

      { int size = self.arraySize;

        if (!(size > 0)) {
          System.err.print("Safety violation: Trying to create an empty heap");
        }
      }
    }
  }

  public static Stella_Object accessHeapSlotValue(Heap self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PREDICATE) {
      if (setvalueP) {
        self.predicate = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.predicate);
      }
    }
    else if (slotname == Stella.SYM_STELLA_FILL_POINTER) {
      if (setvalueP) {
        self.fillPointer = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.fillPointer);
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
    { Heap self = this;

      return (Stella.SGT_STELLA_HEAP);
    }
  }

}

