//  -*- Mode: Java -*-
//
// ObjectStore.java

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

public abstract class ObjectStore extends StandardObject {
    public Module module;

  public void clearObjectStore() {
    { ObjectStore store = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("clear-object-store: not implemented on `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void storeModuleTrailer(Module module) {
    { ObjectStore store = this;

      {
        store = store;
        module = module;
      }
    }
  }

  public void storeModuleHeader(Module module) {
    { ObjectStore store = this;

      module = module;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("store-module-header: not implemented on `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void storeAssertion(Proposition proposition) {
    { ObjectStore store = this;

      proposition = proposition;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("store-proposition: not implemented on `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void storeRelation(NamedDescription relation) {
    { ObjectStore store = this;

      relation = relation;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("store-relation: not implemented on `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void storeNativeRelation(Relation relation) {
    { ObjectStore store = this;

      relation = relation;
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("store-native-relation: not implemented on `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** A module with <code>store</code> has had the truth value of <code>proposition</code>
   * change according to <code>updateMode</code>.  The default method does nothing.
   * @param proposition
   * @param updateMode
   */
  public void updatePropositionInStore(Proposition proposition, Keyword updateMode) {
    { ObjectStore store = this;

      {
        proposition = proposition;
        updateMode = updateMode;
      }
      return;
    }
  }

  /** Fetch a duplicate of <code>prop</code> if defined by <code>store</code>.  EXPERIMENTAL!
   * The exact semantics of this still needs to be worked out.  This needs to be appropriately
   * specialized on actual OBJECT-STORE implementations.
   * @param prop
   * @return Proposition
   */
  public Proposition fetchDuplicateProposition(Proposition prop) {
    { ObjectStore store = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Don't know how to fetch a duplicate of `" + prop + "' from `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Fetch the instance identified by <code>name</code> (a string or symbol) from <code>store</code>
   * and return it as an appropriate logic object.  This needs to be appropriately
   * specialized on actual OBJECT-STORE implementations.
   * @param name
   * @return Stella_Object
   */
  public Stella_Object fetchInstance(Stella_Object name) {
    { ObjectStore store = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Don't know how to fetch instance `" + name + "' from `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Fetch the relation identified by <code>name</code> (a string or symbol) from <code>store</code>
   * and return it as a named description.  This needs to be appropriately 
   * specialized on actual OBJECT-STORE implementations.
   * @param name
   * @return NamedDescription
   */
  public NamedDescription fetchRelation(Stella_Object name) {
    { ObjectStore store = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Don't know how to fetch relation `" + name + "' from `" + store + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public SequenceIndex objectStoreDcreateSequenceIndex(Cons pattern) {
    { ObjectStore store = this;

      { PagingIndex self000 = PagingIndex.newPagingIndex();

        self000.store = store;
        self000.selectionPattern = pattern;
        { PagingIndex value000 = self000;

          return (value000);
        }
      }
    }
  }

  /** Remove <code>store</code> from the list of active object stores.
   * @param store
   */
  public static void unregisterObjectStore(ObjectStore store) {
    if (!(List.nullListP(Logic.$ALL_OBJECT_STORES$))) {
      Logic.$ALL_OBJECT_STORES$.remove(store);
      if (Logic.$ALL_OBJECT_STORES$.emptyP()) {
        Logic.$ALL_OBJECT_STORES$ = Stella.NIL_LIST;
      }
    }
  }

  /** Register <code>store</code> as an active object store.
   * @param store
   */
  public static void registerObjectStore(ObjectStore store) {
    if (List.nullListP(Logic.$ALL_OBJECT_STORES$)) {
      Logic.$ALL_OBJECT_STORES$ = List.newList();
    }
    Logic.$ALL_OBJECT_STORES$.insertNew(store);
  }

  public static Stella_Object accessObjectStoreSlotValue(ObjectStore self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_MODULE) {
      if (setvalueP) {
        self.module = ((Module)(value));
      }
      else {
        value = self.module;
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

