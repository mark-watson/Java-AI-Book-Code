//  -*- Mode: Java -*-
//
// VectorSequence.java

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

/** Extensible sequence implemented by a vector.  Whenever we run
 * out of room, we grow the sequence by a factor of two.  Note that this keeps the
 * average insertion cost per element constant.  This is generally preferable over
 * linked lists unless we need within-list insertions or removals, since it uses
 * less space and has better cache locality.
 * @author Stella Java Translator
 */
public class VectorSequence extends Vector {
    public int sequenceLength;

  public static VectorSequence newVectorSequence(int arraySize) {
    { VectorSequence self = null;

      self = new VectorSequence();
      self.arraySize = arraySize;
      self.theArray = null;
      self.sequenceLength = 0;
      self.initializeVector();
      return (self);
    }
  }

  /** Return TRUE iff the sequences <code>x</code> and <code>y</code> are structurally
   * equivalent.  Uses <code>equalP</code> to test equality of elements.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { VectorSequence x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_VECTOR_SEQUENCE)) {
        { VectorSequence y000 = ((VectorSequence)(y));

          if (x.sequenceLength == y000.sequenceLength) {
            { Stella_Object eltx = null;
              VectorSequence vector000 = x;
              int index000 = 0;
              int length000 = vector000.sequenceLength;
              Stella_Object elty = null;
              VectorSequence vector001 = y000;
              int index001 = 0;
              int length001 = vector001.sequenceLength;

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

  /** Clear <code>self</code> by setting its active length to zero.
   */
  public void clear() {
    { VectorSequence self = this;

      self.sequenceLength = 0;
    }
  }

  /** Return a copy of the vector sequence <code>self</code>.
   * @return Vector
   */
  public Vector copy() {
    { VectorSequence self = this;

      { VectorSequence copy = VectorSequence.newVectorSequence(self.arraySize);

        VectorSequence.copyVectorSequence(self, copy);
        return (copy);
      }
    }
  }

  public static void copyVectorSequence(VectorSequence source, VectorSequence copy) {
    { edu.isi.stella.Stella_Object[] sourcearray = source.theArray;
      edu.isi.stella.Stella_Object[] copyarray = copy.theArray;
      int length = source.sequenceLength;

      copy.sequenceLength = length;
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = length - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          copyarray[i] = (sourcearray[i]);
        }
      }
    }
  }

  /** Reverse the order of elements in the active portion of <code>self</code>.
   * @return VectorSequence
   */
  public VectorSequence reverse() {
    { VectorSequence self = this;

      { edu.isi.stella.Stella_Object[] array = self.theArray;
        int bottom = 0;
        int top = self.sequenceLength - 1;
        Stella_Object elt = null;

        while (bottom < top) {
          elt = array[bottom];
          array[bottom] = (array[top]);
          array[top] = elt;
          bottom = bottom + 1;
          top = top - 1;
        }
        return (self);
      }
    }
  }

  /** Remove <code>value</code> from the sequence <code>self</code>, and left shift
   * the values after it to close the gap.
   * @param value
   * @return AbstractCollection
   */
  public AbstractCollection remove(Stella_Object value) {
    { VectorSequence self = this;

      { edu.isi.stella.Stella_Object[] array = self.theArray;
        int length = self.sequenceLength;
        int nhits = 0;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = length - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            if (Stella_Object.eqlP(array[i], value)) {
              nhits = nhits + 1;
            }
            else if (nhits > 0) {
              array[(i - nhits)] = (array[i]);
            }
          }
        }
        self.sequenceLength = length - nhits;
        { int i = Stella.NULL_INTEGER;
          int iter001 = self.sequenceLength;
          int upperBound001 = length - 1;

          for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
            i = iter001;
            array[i] = null;
          }
        }
        return (self);
      }
    }
  }

  /** Append <code>value</code> to the END of the sequence <code>self</code>.  
   * Resize the array if necessary.
   * @param value
   */
  public void insert(Stella_Object value) {
    { VectorSequence self = this;

      { int oldlength = self.sequenceLength;

        if (oldlength == self.arraySize) {
          Vector.resizeVector(self, self.arraySize * 2);
        }
        (self.theArray)[oldlength] = value;
        self.sequenceLength = oldlength + 1;
      }
    }
  }

  public Stella_Object lastSetter(Stella_Object value) {
    { VectorSequence self = this;

      return ((self.theArray)[(self.sequenceLength - 1)] = value);
    }
  }

  /** Return the last item in the vector <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object last() {
    { VectorSequence self = this;

      return ((self.theArray)[(self.sequenceLength - 1)]);
    }
  }

  public int length() {
    { VectorSequence self = this;

      return (self.sequenceLength);
    }
  }

  /** Return <code>true</code> if <code>self</code> has length &gt; 0.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { VectorSequence self = this;

      return (self.sequenceLength > 0);
    }
  }

  /** Return <code>true</code> if <code>self</code> has length 0.
   * @return boolean
   */
  public boolean emptyP() {
    { VectorSequence self = this;

      return (self.sequenceLength == 0);
    }
  }

  public static Stella_Object accessVectorSequenceSlotValue(VectorSequence self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_SEQUENCE_LENGTH) {
      if (setvalueP) {
        self.sequenceLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.sequenceLength);
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
    { VectorSequence self = this;

      return (Stella.SGT_STELLA_VECTOR_SEQUENCE);
    }
  }

}

