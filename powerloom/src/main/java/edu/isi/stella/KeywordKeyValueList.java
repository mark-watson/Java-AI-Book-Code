//  -*- Mode: Java -*-
//
// KeywordKeyValueList.java

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

public class KeywordKeyValueList extends KeyValueList {
  public static KeywordKeyValueList newKeywordKeyValueList() {
    { KeywordKeyValueList self = null;

      self = new KeywordKeyValueList();
      self.theKvList = null;
      return (self);
    }
  }

  public static void inPlaceNormalizeMethodOptions(KeywordKeyValueList methodoptions, Symbol methodname) {
    methodname = methodname;
    { Keyword key = null;
      Stella_Object value = null;
      KvListIterator iter000 = ((KvListIterator)(methodoptions.allocateIterator()));

      while (iter000.nextP()) {
        key = ((Keyword)(iter000.key));
        value = iter000.value;
        if ((key == Stella.KWD_TYPE) ||
            (key == Stella.KWD_RETURN_TYPES)) {
        }
        else if ((key == Stella.KWD_RENAMES) ||
            ((key == Stella.KWD_STORAGE_SLOT) ||
             (key == Stella.KWD_INHERITS_THROUGH))) {
          methodoptions.insertAt(key, value.permanentify());
        }
        else if ((key == Stella.KWD_PUBLICp) ||
            ((key == Stella.KWD_ABSTRACTp) ||
             ((key == Stella.KWD_SETTERp) ||
              ((key == Stella.KWD_NATIVEp) ||
               ((key == Stella.KWD_CONSTRUCTORp) ||
                ((key == Stella.KWD_AUXILIARYp) ||
                 ((key == Stella.KWD_GLOBALLY_INLINEp) ||
                  ((key == Stella.KWD_COMMANDp) ||
                   ((key == Stella.KWD_LISP_MACROp) ||
                    (key == Stella.KWD_EVALUATE_ARGUMENTSp)))))))))) {
          methodoptions.insertAt(key, Stella_Object.coerceToBoolean(value));
        }
        else if (key == Stella.KWD_DOCUMENTATION) {
          methodoptions.insertAt(key, value);
        }
        else if (key == Stella.KWD_INLINE) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

            if (Surrogate.subtypeOfSymbolP(testValue000)) {
              { Symbol value000 = ((Symbol)(value));

                methodoptions.insertAt(key, ((Symbol)(value000.permanentify())));
              }
            }
            else if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons value000 = ((Cons)(value));

                { Cons symbolslist = Stella.NIL;

                  { Stella_Object symbol = null;
                    Cons iter001 = value000;
                    Cons collect000 = null;

                    for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                      symbol = iter001.value;
                      if (collect000 == null) {
                        {
                          collect000 = Cons.cons(symbol.permanentify(), Stella.NIL);
                          if (symbolslist == Stella.NIL) {
                            symbolslist = collect000;
                          }
                          else {
                            Cons.addConsToEndOfConsList(symbolslist, collect000);
                          }
                        }
                      }
                      else {
                        {
                          collect000.rest = Cons.cons(symbol.permanentify(), Stella.NIL);
                          collect000 = collect000.rest;
                        }
                      }
                    }
                  }
                  methodoptions.insertAt(key, symbolslist);
                }
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        else if (key == Stella.KWD_PROPERTIES) {
          methodoptions.insertAt(key, Stella_Object.collectFeatureList(value));
        }
        else if (key == Stella.KWD_META_ATTRIBUTES) {
          methodoptions.insertAt(key, Stella_Object.collectKeyValueList(value));
        }
        else {
          methodoptions.insertAt(key, value.permanentify());
        }
      }
    }
    methodoptions.reverse();
  }

  public Surrogate primaryType() {
    { KeywordKeyValueList self = this;

      return (Stella.SGT_STELLA_KEYWORD_KEY_VALUE_LIST);
    }
  }

}

