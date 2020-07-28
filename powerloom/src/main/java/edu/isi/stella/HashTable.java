//  -*- Mode: Java -*-
//
// HashTable.java

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

public class HashTable extends AbstractHashTable {
  public static HashTable newHashTable() {
    { HashTable self = null;

      self = new HashTable();
      self.theStellaHashTable = null;
      self.theHashTable = null;
      self.initializeHashTable();
      return (self);
    }
  }

  public static void javaPushIntoHashTable(HashTable ht, Stella_Object key, Stella_Object renamed_Object) {
    { Cons value = ((Cons)(ht.lookup(key)));

      if (value != null) {
        ht.insertAt(key, Cons.cons(renamed_Object, value));
      }
      else {
        ht.insertAt(key, Cons.cons(renamed_Object, Stella.NIL));
      }
    }
  }

  public static void javaOutputFlotsamUnitsToFile(HashTable globalsht, HashTable functionht, Cons codemodulelist) {
    { Cons functions = Stella.NIL;
      Cons globals = Stella.NIL;
      String filename = null;
      Cons flotsamFiles = Stella.NIL;

      { Module module = null;
        Cons iter000 = codemodulelist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          module = ((Module)(iter000.value));
          { Object old$Module$000 = Stella.$MODULE$.get();
            Object old$Context$000 = Stella.$CONTEXT$.get();

            try {
              Native.setSpecial(Stella.$MODULE$, module);
              Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
              filename = Module.javaMakeGlobalOutputFileName(module, false);
              if (flotsamFiles.memberP(StringWrapper.wrapString(filename))) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Overwriting Flotsam file `" + filename + "'.  This is surely bad.");
              }
              flotsamFiles = Cons.cons(StringWrapper.wrapString(filename), flotsamFiles);
              globals = ((Cons)(globalsht.lookup(module)));
              if (!(globals != null)) {
                globals = Stella.NIL;
              }
              functions = ((Cons)(functionht.lookup(module)));
              if (!(functions != null)) {
                functions = Stella.NIL;
              }
              Stella.javaOutputFlotsamUnitsToFileForModule(filename, module, null, globals, functions);

            } finally {
              Stella.$CONTEXT$.set(old$Context$000);
              Stella.$MODULE$.set(old$Module$000);
            }
          }
        }
      }
    }
  }

  public void removeAt(Stella_Object key) {
    { HashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        StellaHashTable.stellaHashTableRemoveAt(self.theStellaHashTable, key);
        return;
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        nativeTable.remove(key);;
      }
    }
  }

  public void insertAt(Stella_Object key, Stella_Object value) {
    { HashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        StellaHashTable.stellaHashTableInsertAt(self.theStellaHashTable, key, value);
        return;
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        nativeTable.put(key, value);
      }
    }
  }

  public Stella_Object lookup(Stella_Object key) {
    { HashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        return (StellaHashTable.stellaHashTableLookup(self.theStellaHashTable, key));
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        return ((Stella_Object) nativeTable.get(key));
      }
    }
  }

  public Surrogate primaryType() {
    { HashTable self = this;

      return (Stella.SGT_STELLA_HASH_TABLE);
    }
  }

}

