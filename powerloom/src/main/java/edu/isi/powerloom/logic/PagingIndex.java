//  -*- Mode: Java -*-
//
// PagingIndex.java

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
 | The Original Code is the PowerLoom KR&R System.                            |
 |                                                                            |
 | The Initial Developer of the Original Code is                              |
 | UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
 | 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
 |                                                                            |
 | Portions created by the Initial Developer are Copyright (C) 1997-2017      |
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
 +----------------------------- END LICENSE BLOCK ----------------------------+
*/

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

/** Index that manages a sequence of objects retrievable from
 * persistent storage.  Needs to be appropriately subclassed by actual store
 * implementations and facilitated with a proper iterator class.
 * @author Stella Java Translator
 */
public class PagingIndex extends SequenceIndex {
    public Cons selectionPattern;
    public ObjectStore store;

  public static PagingIndex newPagingIndex() {
    { PagingIndex self = null;

      self = new PagingIndex();
      self.theSequenceLength = Stella.NULL_INTEGER;
      self.theSequence = Stella.NIL;
      self.store = null;
      self.selectionPattern = null;
      return (self);
    }
  }

  public Iterator allocateIterator() {
    { PagingIndex self = this;

      { PagingIndexIterator self000 = PagingIndexIterator.newPagingIndexIterator();

        self000.listIteratorCursor = self.theSequence;
        { PagingIndexIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static void printPagingIndex(PagingIndex self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { int limit = 10;

      stream.print("|PAGING-IDX|(" + self.selectionPattern);
      { Stella_Object elt = null;
        Cons iter000 = self.theSequence;
        int i = Stella.NULL_INTEGER;
        int iter001 = 1;
        int upperBound000 = limit;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;(!(iter000 == Stella.NIL)) &&
                  (unboundedP000 ||
                   (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
          elt = iter000.value;
          i = iter001;
          stream.print(" " + elt);
          if (i == limit) {
            stream.print("...");
          }
        }
      }
      stream.print(")");
    }
  }

  public SequenceIndex remove(Stella_Object value) {
    { PagingIndex self = this;

      { Cons sequence = self.theSequence.remove(value);

        self.theSequence = sequence;
        self.theSequenceLength = Stella.NULL_INTEGER;
        return (self);
      }
    }
  }

  /** Destructively remove all deleted members of <code>self</code>.
   * @return SequenceIndex
   */
  public SequenceIndex removeDeletedMembers() {
    { PagingIndex self = this;

      { Cons sequence = self.theSequence.removeDeletedMembers();

        self.theSequence = sequence;
        self.theSequenceLength = Stella.NULL_INTEGER;
        return (self);
      }
    }
  }

  /** Return the estimated length of the sequences in 'self',
   * which could be too large if some of the members have been deleted.
   * @return int
   */
  public int estimatedLength() {
    { PagingIndex self = this;

      { int length = self.theSequenceLength;

        if (length == Stella.NULL_INTEGER) {
          length = self.theSequence.length();
          self.theSequenceLength = length;
        }
        return (length);
      }
    }
  }

  public void push(Stella_Object value) {
    { PagingIndex self = this;

      self.insert(value);
    }
  }

  public void insert(Stella_Object value) {
    { PagingIndex self = this;

      if (!(!(self == Logic.NIL_PAGING_INDEX))) {
        System.err.print("Safety violation: Attempt to insert into NIL-PAGING-INDEX");
      }
      self.theSequence = Cons.cons(value, self.theSequence);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { PagingIndex self = this;

      PagingIndex.printPagingIndex(self, stream);
    }
  }

  public static Stella_Object accessPagingIndexSlotValue(PagingIndex self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_SELECTION_PATTERN) {
      if (setvalueP) {
        self.selectionPattern = ((Cons)(value));
      }
      else {
        value = self.selectionPattern;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_STORE) {
      if (setvalueP) {
        self.store = ((ObjectStore)(value));
      }
      else {
        value = self.store;
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
    { PagingIndex self = this;

      return (Logic.SGT_LOGIC_PAGING_INDEX);
    }
  }

}

