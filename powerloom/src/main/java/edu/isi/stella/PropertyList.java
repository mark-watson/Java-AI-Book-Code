//  -*- Mode: Java -*-
//
// PropertyList.java

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

public class PropertyList extends Dictionary {
    public Cons thePlist;

  public static PropertyList newPropertyList() {
    { PropertyList self = null;

      self = new PropertyList();
      self.thePlist = Stella.NIL;
      return (self);
    }
  }

  /** Convert <code>self</code> into a key-value list with identical and identically
   * ordered keys and values.
   * @param self
   * @return KeyValueList
   */
  public static KeyValueList plistToKvlist(PropertyList self) {
    { KeyValueList kvlist = KeyValueList.newKeyValueList();
      KvCons kvcons = null;

      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = self.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          if (kvcons == null) {
            kvcons = KvCons.newKvCons();
            kvlist.theKvList = kvcons;
          }
          else {
            kvcons.rest = KvCons.newKvCons();
            kvcons = kvcons.rest;
          }
          kvcons.key = key;
          kvcons.value = value;
        }
      }
      return (kvlist);
    }
  }

  public AbstractIterator allocateIterator() {
    { PropertyList self = this;

      { PropertyListIterator iterator = PropertyListIterator.newPropertyListIterator();

        iterator.plistIteratorCursor = self.thePlist;
        iterator.plistIteratorCollection = self;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of entries of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { PropertyList self = this;

      { int code = 108398967;

        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = self.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            code = (code ^ (Stella_Object.safeEqualHashCode(key)));
            code = (code ^ (Stella_Object.safeEqualHashCode(value)));
          }
        }
        return (code);
      }
    }
  }

  /** Return TRUE if <code>x</code> and <code>y</code> represent the same set of key/value pairs..
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { PropertyList x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_PROPERTY_LIST)) {
        { PropertyList y000 = ((PropertyList)(y));

          if (x.length() == y000.length()) {
            { Stella_Object key = null;
              Stella_Object value = null;
              Cons iter000 = x.thePlist;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
                key = iter000.value;
                value = iter000.rest.value;
                if (!Stella_Object.equalP(value, y000.lookup(key))) {
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

  /** Make <code>self</code> an empty property list.
   */
  public void clear() {
    { PropertyList self = this;

      self.thePlist = Stella.NIL;
    }
  }

  /** Return a copy of the list <code>self</code>.  The conses in the copy are
   * freshly allocated.
   * @return PropertyList
   */
  public PropertyList copy() {
    { PropertyList self = this;

      { PropertyList copy = ((PropertyList)(Surrogate.createObject(self.primaryType(), Stella.NIL)));

        copy.thePlist = Cons.copyConsList(self.thePlist);
        return (copy);
      }
    }
  }

  public boolean nonEmptyP() {
    { PropertyList self = this;

      return (!(self.thePlist == Stella.NIL));
    }
  }

  public boolean emptyP() {
    { PropertyList self = this;

      return (self.thePlist == Stella.NIL);
    }
  }

  /** Remove the entry that matches the key <code>key</code>.  Return the
   * value of the matching entry, or NULL if there is no matching entry.  Assumes that at
   * most one entry matches <code>key</code>.
   * @param key
   * @return Stella_Object
   */
  public Stella_Object removeAt(Stella_Object key) {
    { PropertyList self = this;

      { Cons cursor = self.thePlist;
        Cons previouscons = null;
        Stella_Object value = null;

        if (!(cursor == Stella.NIL)) {
          if (Stella_Object.eqlP(cursor.value, key)) {
            self.thePlist = cursor.rest.rest;
            value = cursor.rest.value;
            return (value);
          }
          previouscons = cursor.rest;
          cursor = previouscons.rest;
          while (!(cursor == Stella.NIL)) {
            if (Stella_Object.eqlP(cursor.value, key)) {
              previouscons.rest = cursor.rest.rest;
              value = cursor.rest.value;
              return (value);
            }
            previouscons = cursor.rest;
            cursor = previouscons.rest;
          }
        }
        return (null);
      }
    }
  }

  /** Insert the entry &lt;<code>key</code>, <code>value</code>&gt; into the property list <code>self</code>.
   * If a previous entry existed with key <code>key</code>, that entry is replaced.
   * @param key
   * @param value
   */
  public void insertAt(Stella_Object key, Stella_Object value) {
    { PropertyList self = this;

      { Cons cursor = self.thePlist;

        while (!(cursor == Stella.NIL)) {
          if (Stella_Object.eqlP(cursor.value, key)) {
            cursor = cursor.rest;
            cursor.value = value;
            return;
          }
          cursor = cursor.rest.rest;
        }
        self.thePlist = Cons.cons(key, Cons.cons(value, self.thePlist));
      }
    }
  }

  public int length() {
    { PropertyList self = this;

      { Cons cursor = self.thePlist;
        int length = 0;

        while (!(cursor == Stella.NIL)) {
          length = length + 1;
          cursor = cursor.rest.rest;
        }
        return (length);
      }
    }
  }

  /** Lookup <code>key</code> in <code>self</code> and return the result.
   * Return <code>renamed_Default</code> if no value was found.
   * @param key
   * @param renamed_Default
   * @return Stella_Object
   */
  public Stella_Object lookupWithDefault(Stella_Object key, Stella_Object renamed_Default) {
    { PropertyList self = this;

      { Stella_Object value = Cons.searchPlist(self.thePlist, key);

        if (value == null) {
          return (renamed_Default);
        }
        else {
          return (value);
        }
      }
    }
  }

  public Stella_Object lookup(Stella_Object key) {
    { PropertyList self = this;

      return (Cons.searchPlist(self.thePlist, key));
    }
  }

  public void initializeObject() {
    { PropertyList self = this;

      self.thePlist = Stella.NIL;
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { PropertyList self = this;

      {
        stream.print("|pl|");
        Cons.printCons(self.thePlist, stream, "(", ")");
      }
    }
  }

  public static Stella_Object accessPropertyListSlotValue(PropertyList self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_PLIST) {
      if (setvalueP) {
        self.thePlist = ((Cons)(value));
      }
      else {
        value = self.thePlist;
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
    { PropertyList self = this;

      return (Stella.SGT_STELLA_PROPERTY_LIST);
    }
  }

}

