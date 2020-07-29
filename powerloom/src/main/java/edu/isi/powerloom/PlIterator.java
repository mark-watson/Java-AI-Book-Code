//  -*- Mode: Java -*-
//
// PlIterator.java

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

package edu.isi.powerloom;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;

public class PlIterator extends Iterator {
    public Cons cursor;

  public static PlIterator newPlIterator() {
    { PlIterator self = null;

      self = new PlIterator();
      self.firstIterationP = true;
      self.value = null;
      self.cursor = null;
      return (self);
    }
  }

  /** Convert <code>self</code> into a Stella CONS.
   * @return Cons
   */
  public Cons consify() {
    { PlIterator self = this;

      { Cons value000 = Stella.NIL;

        { Stella_Object x = null;
          PlIterator iter000 = self;
          Cons collect000 = null;

          while (iter000.nextP()) {
            x = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(x, Stella.NIL);
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
                collect000.rest = Cons.cons(x, Stella.NIL);
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

  /** Convert <code>self</code> into a Stella LIST.
   * @return List
   */
  public List listify() {
    { PlIterator self = this;

      { List self000 = List.newList();

        { Cons value001 = Stella.NIL;

          { Stella_Object x = null;
            PlIterator iter000 = self;
            Cons collect000 = null;

            while (iter000.nextP()) {
              x = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(x, Stella.NIL);
                  if (value001 == Stella.NIL) {
                    value001 = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(value001, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(x, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          self000.theConsList = value001;
        }
        { List value000 = self000;

          return (value000);
        }
      }
    }
  }

  /** Number of items remaining in <code>self</code>.  Non destructive.
   * @return int
   */
  public int length() {
    { PlIterator self = this;

      return (self.cursor.length());
    }
  }

  /** Return TRUE if the iterator <code>self</code> has no more elements.
   * @return boolean
   */
  public boolean emptyP() {
    { PlIterator self = this;

      return (self.cursor == Stella.NIL);
    }
  }

  /** Advance the PL-Iterator <code>self</code> and return <code>true</code> if more
   * elements are available, <code>false</code> otherwise.
   * @return boolean
   */
  public boolean nextP() {
    { PlIterator self = this;

      { Cons cursor = self.cursor;

        if (cursor == Stella.NIL) {
          self.value = null;
          return (false);
        }
        self.value = cursor.value;
        self.cursor = cursor.rest;
        return (true);
      }
    }
  }

  public static Stella_Object accessPlIteratorSlotValue(PlIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_CURSOR) {
      if (setvalueP) {
        self.cursor = ((Cons)(value));
      }
      else {
        value = self.cursor;
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
    { PlIterator self = this;

      return (PLI.SGT_PLI_PL_ITERATOR);
    }
  }

}

