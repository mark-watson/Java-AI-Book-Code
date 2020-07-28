//  -*- Mode: Java -*-
//
// Set.java

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

public class Set extends List {
  public static Set newSet() {
    { Set self = null;

      self = new Set();
      self.theConsList = Stella.NIL;
      return (self);
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of elements of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { Set self = this;

      { Cons cursor = self.theConsList;
        int code = 95880665;

        loop000 : for (;;) {
          if (cursor == Stella.NIL) {
            break loop000;
          }
          code = (code ^ (Stella_Object.safeEqualHashCode(cursor.value)));
          cursor = cursor.rest;
        }
        return (code);
      }
    }
  }

  /** Return TRUE iff <code>x</code> and <code>y</code> are SET's with equivalent members.
   * Uses <code>equalP</code> to test equality of elements.  This is more general than
   * <code>equivalentSetsP</code>, since that only uses an <code>eqlP</code> test.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { Set x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_SET)) {
        { Set y000 = ((Set)(y));

          { boolean testValue000 = false;

            testValue000 = x.length() == y000.length();
            if (testValue000) {
              { boolean alwaysP000 = true;

                { Stella_Object eltx = null;
                  ListIterator iter000 = ((ListIterator)(x.allocateIterator()));

                  loop000 : while (iter000.nextP()) {
                    eltx = iter000.value;
                    { boolean testValue001 = false;

                      { boolean foundP000 = false;

                        { Stella_Object elty = null;
                          ListIterator iter001 = ((ListIterator)(y000.allocateIterator()));

                          loop001 : while (iter001.nextP()) {
                            elty = iter001.value;
                            if (Stella_Object.equalP(eltx, elty)) {
                              foundP000 = true;
                              break loop001;
                            }
                          }
                        }
                        testValue001 = foundP000;
                      }
                      testValue001 = !testValue001;
                      if (testValue001) {
                        alwaysP000 = false;
                        break loop000;
                      }
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
      else {
      }
      return (false);
    }
  }

  /** Union <code>set2</code> and all <code>othersets</code> onto the end of <code>set1</code>.
   * The operation is destructive wrt <code>set1</code>, but leaves all other sets intact.
   * The two mandatory parameters allow us to optimize the common binary case by
   * not relying on the somewhat less efficient variable arguments mechanism.
   * @param set2
   * @param othersets
   * @return List
   */
  public List concatenate(List set2, Cons othersets) {
    { Set set1 = this;

      { Cons resultset = set1.theConsList;

        { Stella_Object elt = null;
          Cons iter000 = set2.theConsList;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            elt = iter000.value;
            if (!resultset.memberP(elt)) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(elt, Stella.NIL);
                  if (resultset == Stella.NIL) {
                    resultset = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(resultset, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(elt, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        if (othersets.length() > 0) {
          { List oset = null;
            Cons iter001 = othersets;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              oset = ((List)(iter001.value));
              { Stella_Object elt = null;
                Cons iter002 = oset.theConsList;
                Cons collect001 = null;

                for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  elt = iter002.value;
                  if (!resultset.memberP(elt)) {
                    if (collect001 == null) {
                      {
                        collect001 = Cons.cons(elt, Stella.NIL);
                        if (resultset == Stella.NIL) {
                          resultset = collect001;
                        }
                        else {
                          Cons.addConsToEndOfConsList(resultset, collect001);
                        }
                      }
                    }
                    else {
                      {
                        collect001.rest = Cons.cons(elt, Stella.NIL);
                        collect001 = collect001.rest;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        set1.theConsList = resultset;
        return (set1);
      }
    }
  }

  /** Destructively replace <code>old</code> with <code>renamed_New</code> in the set <code>self</code>
   * unless <code>renamed_New</code> is already a member.
   * @param renamed_New
   * @param old
   * @return List
   */
  public List substitute(Stella_Object renamed_New, Stella_Object old) {
    { Set self = this;

      if (!self.memberP(renamed_New)) {
        self.theConsList = self.theConsList.substitute(renamed_New, old);
      }
      return (self);
    }
  }

  public Collection removeDuplicates() {
    { Set self = this;

      return (self);
    }
  }

  /** Add <code>value</code> to the end of set <code>self</code> unless it is already a member.
   * @param value
   */
  public void insertLast(Stella_Object value) {
    { Set self = this;

      if (!self.memberP(value)) {
        { Cons cursor = self.theConsList;
          Cons lastcons = Cons.cons(value, Stella.NIL);

          if (cursor == Stella.NIL) {
            self.theConsList = lastcons;
          }
          else {
            Cons.addConsToEndOfConsList(cursor, lastcons);
          }
        }
      }
    }
  }

  /** Add <code>value</code> to the front of set <code>self</code> unless it is already a member.
   * @param value
   */
  public void push(Stella_Object value) {
    { Set self = this;

      if (!self.memberP(value)) {
        self.theConsList = Cons.cons(value, self.theConsList);
      }
    }
  }

  /** Add <code>value</code> to the set <code>self</code> unless it is already a member.
   * @param value
   */
  public void insert(Stella_Object value) {
    { Set self = this;

      if (!self.memberP(value)) {
        self.theConsList = Cons.cons(value, self.theConsList);
      }
    }
  }

  public boolean orderedP() {
    { Set self = this;

      return (false);
    }
  }

  public boolean noDuplicatesP() {
    { Set self = this;

      return (true);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Set self = this;

      {
        stream.print("|s|");
        Cons.printCons(self.theConsList, stream, "(", ")");
      }
    }
  }

  public Surrogate primaryType() {
    { Set self = this;

      return (Stella.SGT_STELLA_SET);
    }
  }

}

