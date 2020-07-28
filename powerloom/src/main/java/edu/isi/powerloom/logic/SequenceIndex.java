//  -*- Mode: Java -*-
//
// SequenceIndex.java

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

/** Abstract class for managing a sequence of objects.
 * @author Stella Java Translator
 */
public abstract class SequenceIndex extends StandardObject {
    public Cons theSequence;
    public int theSequenceLength;

  public static boolean emptyPropositionsIndexP(SequenceIndex index, Stella_Object primarykey, boolean specializeP) {
    return ((!specializeP) &&
        (((index == Logic.NIL_PAGING_INDEX) ||
        (index == Logic.NIL_NON_PAGING_INDEX)) &&
         (!Logic.hasEquivalentValuesP(primarykey))));
  }

  public static SequenceIndex maybeWrapSequenceIndex(SequenceIndex index, Cons pattern, Keyword kind, Stella_Object arg1, Stella_Object arg2) {
    { ObjectStore store = ((ObjectStore)(KeyValueList.dynamicSlotValue(((Module)(Stella.$MODULE$.get())).dynamicSlots, Logic.SYM_LOGIC_OBJECT_STORE, null)));
      SequenceIndex baseindex = index;

      if ((store != null) &&
          ((!Logic.descriptionModeP()) &&
           (!Logic.variableP(arg1)))) {
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(index), Logic.SGT_LOGIC_PAGING_INDEX)) {
          { PagingIndex index000 = ((PagingIndex)(index));

            if (index000.store == store) {
              return (index000);
            }
            if (pattern == null) {
              pattern = index000.selectionPattern;
            }
          }
        }
        else {
        }
        if (pattern == null) {
          pattern = Cons.cons(kind, Cons.cons(((null == null) ? Stella.NIL : null), Cons.cons(arg1, ((arg2 == null) ? Stella.NIL : Cons.cons(arg2, Stella.NIL)))));
        }
        index = store.objectStoreDcreateSequenceIndex(pattern);
        index.theSequence = baseindex.theSequence;
        index.theSequenceLength = baseindex.theSequenceLength;
      }
      return (index);
    }
  }

  public Iterator allocateIterator() {
    { SequenceIndex self = this;

      { SequenceIndexIterator self000 = SequenceIndexIterator.newSequenceIndexIterator();

        self000.listIteratorCursor = self.theSequence;
        { SequenceIndexIterator value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static void printSequenceIndex(SequenceIndex self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { int limit = 10;

      stream.print("|SEQ-IDX|(");
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
          if (i > 1) {
            stream.print(" ");
          }
          stream.print(elt);
          if (i == limit) {
            stream.print("...");
          }
        }
      }
      stream.print(")");
    }
  }

  public Cons consify() {
    { SequenceIndex self = this;

      { Cons value000 = Stella.NIL;

        { Stella_Object i = null;
          Iterator iter000 = self.allocateIterator();
          Cons collect000 = null;

          while (iter000.nextP()) {
            i = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(i, Stella.NIL);
                if (value000 == Stella.NIL) {
                  value000 = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(value000, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(i, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { Cons value001 = value000;

          return (value001);
        }
      }
    }
  }

  public SequenceIndex remove(Stella_Object value) {
    { SequenceIndex self = this;

      self.theSequence = self.theSequence.remove(value);
      self.theSequenceLength = Stella.NULL_INTEGER;
      return (self);
    }
  }

  public SequenceIndex removeDeletedMembers() {
    { SequenceIndex self = this;

      { Cons sequence = self.theSequence.removeDeletedMembers();

        self.theSequence = sequence;
        self.theSequenceLength = Stella.NULL_INTEGER;
        return (self);
      }
    }
  }

  public static int sequenceIndexDestimatedLength(SequenceIndex self) {
    { int length = self.theSequenceLength;

      if (length == Stella.NULL_INTEGER) {
        length = self.theSequence.length();
        self.theSequenceLength = length;
      }
      return (length);
    }
  }

  public int estimatedLength() {
    { SequenceIndex self = this;

      return (SequenceIndex.sequenceIndexDestimatedLength(self));
    }
  }

  public boolean emptyP() {
    { SequenceIndex self = this;

      if (self.theSequence == Stella.NIL) {
        return (true);
      }
      if (!self.theSequence.value.deletedP()) {
        return (false);
      }
      self.removeDeletedMembers();
      return (self.theSequence == Stella.NIL);
    }
  }

  public Stella_Object first() {
    { SequenceIndex self = this;

      { Stella_Object item = null;
        Iterator iter000 = self.allocateIterator();

        while (iter000.nextP()) {
          item = iter000.value;
          return (item);
        }
      }
      return (null);
    }
  }

  public void push(Stella_Object value) {
    { SequenceIndex self = this;

      self.insert(value);
    }
  }

  public void insert(Stella_Object value) {
    { SequenceIndex self = this;

      if (!(!(self == Logic.NIL_NON_PAGING_INDEX))) {
        System.err.print("Safety violation: Attempt to insert into NIL-NON-PAGING-INDEX");
      }
      self.theSequence = Cons.cons(value, self.theSequence);
      { int length = self.theSequenceLength;

        if (length != Stella.NULL_INTEGER) {
          self.theSequenceLength = length + 1;
        }
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { SequenceIndex self = this;

      SequenceIndex.printSequenceIndex(self, stream);
    }
  }

  public static Stella_Object accessSequenceIndexSlotValue(SequenceIndex self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_THE_SEQUENCE) {
      if (setvalueP) {
        self.theSequence = ((Cons)(value));
      }
      else {
        value = self.theSequence;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_THE_SEQUENCE_LENGTH) {
      if (setvalueP) {
        self.theSequenceLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.theSequenceLength);
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

}

