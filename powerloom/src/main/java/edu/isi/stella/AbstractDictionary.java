//  -*- Mode: Java -*-
//
// AbstractDictionary.java

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

public abstract class AbstractDictionary extends AbstractCollection {
  /** Return a dictionary of <code>collectiontype</code> containing <code>values</code>, in order.
   * Currently supported <code>collectiontype</code>s are @HASH-TABLE, @STELLA-HASH-TABLE,
   * @KEY-VALUE-LIST, @KEY-VALUE-MAP and @PROPERTY-LIST.
   * @param collectiontype
   * @param alternatingkeysandvalues
   * @return AbstractDictionary
   */
  public static AbstractDictionary dictionary(Surrogate collectiontype, Cons alternatingkeysandvalues) {
    { AbstractDictionary dictionary = ((AbstractDictionary)(Surrogate.createObject(collectiontype, Stella.NIL)));
      Stella_Object key = null;
      Stella_Object value = null;
      Cons copy = Stella.NIL;
      Cons cursor = null;

      { Stella_Object item = null;
        Cons iter000 = alternatingkeysandvalues;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(item, Stella.NIL);
              if (copy == Stella.NIL) {
                copy = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(copy, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(item, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      cursor = copy;
      while (!(cursor == Stella.NIL)) {
        key = cursor.value;
        value = cursor.rest.value;
        { Surrogate testValue000 = Stella_Object.safePrimaryType(dictionary);

          if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_HASH_TABLE)) {
            { HashTable dictionary000 = ((HashTable)(dictionary));

              dictionary000.insertAt(key, value);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_STELLA_HASH_TABLE)) {
            { StellaHashTable dictionary000 = ((StellaHashTable)(dictionary));

              dictionary000.insertAt(key, value);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_KEY_VALUE_LIST)) {
            { KeyValueList dictionary000 = ((KeyValueList)(dictionary));

              dictionary000.insertAt(key, value);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_KEY_VALUE_MAP)) {
            { KeyValueMap dictionary000 = ((KeyValueMap)(dictionary));

              dictionary000.insertAt(key, value);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_PROPERTY_LIST)) {
            { PropertyList dictionary000 = ((PropertyList)(dictionary));

              dictionary000.insertAt(key, value);
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("dictionary: Can't create dictionaries of type `" + collectiontype + "'");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        cursor = cursor.rest.rest;
      }
      return (dictionary);
    }
  }

  public AbstractIterator allocateIterator() {
    { AbstractDictionary self = this;

      return (null);
    }
  }

}

