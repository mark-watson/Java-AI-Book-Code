//  -*- Mode: Java -*-
//
// PropertyListIterator.java

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

/** Iterator class for the collection PROPERTY-LIST.
 * @author Stella Java Translator
 */
public class PropertyListIterator extends DictionaryIterator {
    public Cons plistIteratorCursor;
    public PropertyList plistIteratorCollection;

  public static PropertyListIterator newPropertyListIterator() {
    { PropertyListIterator self = null;

      self = new PropertyListIterator();
      self.firstIterationP = true;
      self.value = null;
      self.key = null;
      self.plistIteratorCollection = null;
      self.plistIteratorCursor = null;
      return (self);
    }
  }

  public Stella_Object keySetter(Stella_Object key) {
    { PropertyListIterator self = this;

      self.plistIteratorCursor.value = key;
      self.key = key;
      return (key);
    }
  }

  public Stella_Object valueSetter(Stella_Object value) {
    { PropertyListIterator self = this;

      self.plistIteratorCursor.rest.value = value;
      self.value = value;
      return (value);
    }
  }

  public boolean nextP() {
    { PropertyListIterator self = this;

      if (self.firstIterationP) {
        self.firstIterationP = false;
      }
      else {
        self.plistIteratorCursor = self.plistIteratorCursor.rest.rest;
      }
      { Cons remainingplist = self.plistIteratorCursor;

        if (!(remainingplist == Stella.NIL)) {
          self.key = remainingplist.value;
          self.value = remainingplist.rest.value;
          return (true);
        }
        return (false);
      }
    }
  }

  public static Stella_Object accessPropertyListIteratorSlotValue(PropertyListIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PLIST_ITERATOR_CURSOR) {
      if (setvalueP) {
        self.plistIteratorCursor = ((Cons)(value));
      }
      else {
        value = self.plistIteratorCursor;
      }
    }
    else if (slotname == Stella.SYM_STELLA_PLIST_ITERATOR_COLLECTION) {
      if (setvalueP) {
        self.plistIteratorCollection = ((PropertyList)(value));
      }
      else {
        value = self.plistIteratorCollection;
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
    { PropertyListIterator self = this;

      return (Stella.SGT_STELLA_PROPERTY_LIST_ITERATOR);
    }
  }

}

