//  -*- Mode: Java -*-
//
// Iterator.java

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

/** Instances of ITERATOR support iteration over 
 * collections of OBJECTs.
 * @author Stella Java Translator
 */
public abstract class Iterator extends AbstractIterator {
    /** The current value of this iterator
     */
    public Stella_Object value;

  public static void printClassList(Iterator self, OutputStream stream) {
    stream.nativeStream.print("(");
    if (self.nextP()) {
      stream.nativeStream.print(((Stella_Class)(self.value)).classType.symbolName);
    }
    while (self.nextP()) {
      stream.nativeStream.print(" " + ((Stella_Class)(self.value)).classType.symbolName);
    }
    stream.nativeStream.print(")");
  }

  /** Return an iterator that first generates all values of
   * <code>iterator1</code>, then those of <code>iterator2</code>, and then those of all <code>otheriterators</code>.
   * The generated values can be filtered by supplying a filter function to the
   * resulting iterator.
   * @param iterator2
   * @param otheriterators
   * @return AllPurposeIterator
   */
  public AllPurposeIterator concatenate(Iterator iterator2, Cons otheriterators) {
    { Iterator iterator1 = this;

      { Cons iteratorlist = Cons.cons(iterator2, Stella.NIL);

        { Iterator iterator = null;
          Cons iter000 = otheriterators;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            iterator = ((Iterator)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(iterator, Stella.NIL);
                if (iteratorlist == Stella.NIL) {
                  iteratorlist = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(iteratorlist, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(iterator, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { AllPurposeIterator self000 = AllPurposeIterator.newAllPurposeIterator();

          self000.iteratorNestedIterator = iterator1;
          self000.iteratorConsList = iteratorlist;
          self000.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredConcatenatedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
          { AllPurposeIterator value000 = self000;

            return (value000);
          }
        }
      }
    }
  }

  /** Iterate over values of 'self', returning TRUE
   * if one of them is 'eql' to 'value.
   * @param value
   * @return boolean
   */
  public boolean memberP(Stella_Object value) {
    { Iterator self = this;

      if ((value == null) ||
          value.standardObjectP()) {
        { Stella_Object m = null;
          Iterator iter000 = self;

          while (iter000.nextP()) {
            m = iter000.value;
            if (m == value) {
              return (true);
            }
          }
        }
      }
      else {
        { Stella_Object m = null;
          Iterator iter001 = self;

          while (iter001.nextP()) {
            m = iter001.value;
            if (Stella_Object.eqlP(m, value)) {
              return (true);
            }
          }
        }
      }
      return (false);
    }
  }

  /** Return TRUE if the sequence represented by 'self'
   * has no elements.  Side-effect free.
   * @return boolean
   */
  public boolean emptyP() {
    { Iterator self = this;

      throw ((StellaException)(StellaException.newStellaException("Missing 'empty?' method").fillInStackTrace()));
    }
  }

  /** Return 'self' after skipping over the first
   * 'n' elements in the (remainder of the) iteration.
   * @param n
   * @return Iterator
   */
  public Iterator advance(int n) {
    { Iterator self = this;

      while ((n > 0) &&
          self.nextP()) {
        n = n - 1;
      }
      return (self);
    }
  }

  /** Return the first item of the sequence represented by 'self',
   * or NULL if it is empty.  Destructively uses up the first iteration element.
   * @return Stella_Object
   */
  public Stella_Object pop() {
    { Iterator self = this;

      if (self.nextP()) {
        return (self.value);
      }
      else {
        return (null);
      }
    }
  }

  /** Return a list of elements generated by <code>self</code>.
   * @return List
   */
  public List listify() {
    { Iterator self = this;

      { List list = List.newList();

        { Stella_Object value = null;
          Iterator iter000 = self;

          while (iter000.nextP()) {
            value = iter000.value;
            list.push(value);
          }
        }
        return (list.reverse());
      }
    }
  }

  /** Return a list of elements generated by <code>self</code>.
   * @return Cons
   */
  public Cons consify() {
    { Iterator self = this;

      { Cons list = Stella.NIL;

        { Stella_Object value = null;
          Iterator iter000 = self;

          while (iter000.nextP()) {
            value = iter000.value;
            list = Cons.cons(value, list);
          }
        }
        return (list.reverse());
      }
    }
  }

}

