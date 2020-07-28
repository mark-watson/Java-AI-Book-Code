//  -*- Mode: Java -*-
//
// StringHashTable.java

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

public class StringHashTable extends AbstractHashTable {
  public static StringHashTable newStringHashTable() {
    { StringHashTable self = null;

      self = new StringHashTable();
      self.theStellaHashTable = null;
      self.theHashTable = null;
      self.initializeHashTable();
      return (self);
    }
  }

  public static void javaPushIntoStringHashTable(StringHashTable ht, String key, Stella_Object renamed_Object) {
    { Cons value = ((Cons)(ht.lookup(key)));

      if (value != null) {
        ht.insertAt(key, Cons.cons(renamed_Object, value));
      }
      else {
        ht.insertAt(key, Cons.cons(renamed_Object, Stella.NIL));
      }
    }
  }

  public static void javaOutputStartupUnitsToFile(StringHashTable startupht, Cons keylist) {
    { String classoutputfile = null;
      Cons startupfunctions = null;

      { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_STREAM$, null);
          { StringWrapper classname = null;
            Cons iter000 = keylist;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              classname = ((StringWrapper)(iter000.value));
              startupfunctions = ((Cons)(startupht.lookup(classname.wrapperValue)));
              if ((startupfunctions != null) &&
                  (!(startupfunctions == null))) {
                { Object old$Module$000 = Stella.$MODULE$.get();
                  Object old$Context$000 = Stella.$CONTEXT$.get();

                  try {
                    Native.setSpecial(Stella.$MODULE$, ((TranslationUnit)(startupfunctions.value)).homeModule());
                    Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
                    classoutputfile = Stella.string_javaMakeCodeOutputFileName(classname.wrapperValue, false);
                    { OutputFileStream classoutputstream = null;

                      try {
                        classoutputstream = Stella.openOutputFile(classoutputfile, Stella.NIL);
                        Native.setSpecial(Stella.$CURRENT_STREAM$, classoutputstream);
                        if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                          Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + classoutputfile + "'...");
                        }
                        OutputStream.javaOutputFileHeader(classoutputstream, Stella.string_javaMakeCodeOutputFileName(classname.wrapperValue, true));
                        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("public class " + classname.wrapperValue + " {");
                        Stella.javaBumpIndent();
                        { TranslationUnit function = null;
                          Cons iter001 = startupfunctions;

                          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                            function = ((TranslationUnit)(iter001.value));
                            Cons.javaOutputMethod(TranslationUnit.javaTranslateUnit(function).rest);
                            function.translation = null;
                            function.codeRegister = null;
                          }
                        }
                        Stella.javaUnbumpIndent();
                        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");

                      } finally {
                        if (classoutputstream != null) {
                          classoutputstream.free();
                        }
                      }
                    }

                  } finally {
                    Stella.$CONTEXT$.set(old$Context$000);
                    Stella.$MODULE$.set(old$Module$000);
                  }
                }
              }
            }
          }

        } finally {
          Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        }
      }
    }
  }

  public void removeAt(String key) {
    { StringHashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        StellaHashTable.stellaHashTableRemoveAt(self.theStellaHashTable, StringWrapper.wrapString(key));
        return;
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        nativeTable.remove(key);;
      }
    }
  }

  public void insertAt(String key, Stella_Object value) {
    { StringHashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        StellaHashTable.stellaHashTableInsertAt(self.theStellaHashTable, StringWrapper.wrapString(key), value);
        return;
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        nativeTable.put(key, value);;
      }
    }
  }

  public Stella_Object lookup(String key) {
    { StringHashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        return (StellaHashTable.stellaStringHashTableLookup(self.theStellaHashTable, key));
      }
      { java.util.HashMap nativeTable = self.theHashTable;

        return (((Stella_Object) nativeTable.get(key)));
      }
    }
  }

  /** Insert a newly-created native hash table into <code>self</code>.
   */
  public void initializeHashTable() {
    { StringHashTable self = this;

      if (Stella.$USE_STELLA_HASH_TABLESp$) {
        self.theStellaHashTable = StellaHashTable.newStellaHashTable();
        return;
      }
      self.theHashTable = new java.util.HashMap();
    }
  }

  public Surrogate primaryType() {
    { StringHashTable self = this;

      return (Stella.SGT_STELLA_STRING_HASH_TABLE);
    }
  }

}

