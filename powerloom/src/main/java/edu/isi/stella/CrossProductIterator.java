//  -*- Mode: Java -*-
//
// CrossProductIterator.java

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

/** Iterator class that generates the cross product of a list of domains.
 * Each value tuple is represented as a CONS.  CAUTION: the value tuple will be modified
 * destructively, hence, it needs to be copied in case it needs to persist beyond a single
 * iteration.
 * @author Stella Java Translator
 */
public class CrossProductIterator extends Iterator {
    public Cons domains;
    public Cons cursors;

  public static CrossProductIterator newCrossProductIterator() {
    { CrossProductIterator self = null;

      self = new CrossProductIterator();
      self.firstIterationP = true;
      self.value = null;
      self.cursors = Stella.NIL;
      self.domains = Stella.NIL;
      return (self);
    }
  }

  public boolean nextP() {
    { CrossProductIterator self = this;

      { Cons domains = self.domains;
        Cons cursors = self.cursors;
        Cons cursor = Stella.NIL;
        Cons values = ((Cons)(self.value));

        if (values == null) {
          return (false);
        }
        while (!(cursors == Stella.NIL)) {
          cursor = ((Cons)(cursors.value));
          if (!(cursor == Stella.NIL)) {
            values.firstSetter(cursor.value);
            cursors.firstSetter(cursor.rest);
            return (true);
          }
          else {
            cursor = ((Cons)(domains.value));
            values.firstSetter(cursor.value);
            cursors.firstSetter(cursor.rest);
          }
          cursors = cursors.rest;
          domains = domains.rest;
          values = values.rest;
        }
        self.value = null;
        return (false);
      }
    }
  }

  /** Reset <code>self</code> to its initially allocated state.  Note, that
   * this is somewhat expensive, costing almost as much as allocating the iterator.
   */
  public void reset() {
    { CrossProductIterator self = this;

      { Cons domains = self.domains;
        Cons cursors = Stella.NIL;
        Cons values = Stella.NIL;

        { Cons domain = null;
          Cons iter000 = domains;
          int i = Stella.NULL_INTEGER;
          int iter001 = 0;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            domain = ((Cons)(iter000.value));
            i = iter001;
            if ((domain == null) ||
                (domain == Stella.NIL)) {
              return;
            }
            cursors = Cons.cons(((i == 0) ? domain : domain.rest), cursors);
            values = Cons.cons(domain.value, values);
          }
        }
        self.cursors = cursors.reverse();
        self.value = values.reverse();
      }
    }
  }

  public static Stella_Object accessCrossProductIteratorSlotValue(CrossProductIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DOMAINS) {
      if (setvalueP) {
        self.domains = ((Cons)(value));
      }
      else {
        value = self.domains;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CURSORS) {
      if (setvalueP) {
        self.cursors = ((Cons)(value));
      }
      else {
        value = self.cursors;
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
    { CrossProductIterator self = this;

      return (Stella.SGT_STELLA_CROSS_PRODUCT_ITERATOR);
    }
  }

}

