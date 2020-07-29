//  -*- Mode: Java -*-
//
// ConsIterator.java

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

/** Iterator class for the class CONS.
 * @author Stella Java Translator
 */
public class ConsIterator extends Iterator {
    public Cons consIteratorCursor;

  public static ConsIterator newConsIterator() {
    { ConsIterator self = null;

      self = new ConsIterator();
      self.firstIterationP = true;
      self.value = null;
      self.consIteratorCursor = null;
      return (self);
    }
  }

  public Stella_Object valueSetter(Stella_Object value) {
    { ConsIterator self = this;

      self.consIteratorCursor.value = value;
      self.value = value;
      return (value);
    }
  }

  /** Iterate over values of <code>self</code> and return TRUE
   * if one of them is <code>eqlP</code> to 'value.
   * @param value
   * @return boolean
   */
  public boolean memberP(Stella_Object value) {
    { ConsIterator self = this;

      { boolean result = (self.firstIterationP ? self.consIteratorCursor.memberP(value) : self.consIteratorCursor.rest.memberP(value));

        self.consIteratorCursor = Stella.NIL;
        return (result);
      }
    }
  }

  /** Iterate over 'self', and count how many items there are.
   * @return int
   */
  public int length() {
    { ConsIterator self = this;

      { int count = (self.firstIterationP ? self.consIteratorCursor.length() : self.consIteratorCursor.rest.length());

        self.consIteratorCursor = Stella.NIL;
        return (count);
      }
    }
  }

  public boolean emptyP() {
    { ConsIterator self = this;

      return ((self.firstIterationP ? (self.consIteratorCursor == Stella.NIL) : (self.consIteratorCursor.rest == Stella.NIL)));
    }
  }

  public boolean nextP() {
    { ConsIterator self = this;

      if (self.firstIterationP) {
        self.firstIterationP = false;
      }
      else {
        self.consIteratorCursor = self.consIteratorCursor.rest;
      }
      self.value = self.consIteratorCursor.value;
      return (!(self.consIteratorCursor == Stella.NIL));
    }
  }

  public static boolean terminateConsIteratorP(ConsIterator self) {
    self.consIteratorCursor = null;
    return (true);
  }

  public static Stella_Object accessConsIteratorSlotValue(ConsIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_CONS_ITERATOR_CURSOR) {
      if (setvalueP) {
        self.consIteratorCursor = ((Cons)(value));
      }
      else {
        value = self.consIteratorCursor;
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
    { ConsIterator self = this;

      return (Stella.SGT_STELLA_CONS_ITERATOR);
    }
  }

  public void free() {
    { ConsIterator self = this;

      if (ConsIterator.terminateConsIteratorP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

