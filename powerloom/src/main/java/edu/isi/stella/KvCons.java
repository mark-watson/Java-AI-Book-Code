//  -*- Mode: Java -*-
//
// KvCons.java

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

public class KvCons extends StandardObject {
    public Stella_Object key;
    public Stella_Object value;
    public KvCons rest;

  /** Create, fill-in, and return a new KV-CONS.
   * @param key
   * @param value
   * @param rest
   * @return KvCons
   */
  public static KvCons kvCons(Stella_Object key, Stella_Object value, KvCons rest) {
    { KvCons newkvc = KvCons.newKvCons();

      newkvc.key = key;
      newkvc.value = value;
      newkvc.rest = rest;
      return (newkvc);
    }
  }

  public static KvCons newKvCons() {
    { KvCons self = null;

      self = new KvCons();
      self.rest = null;
      self.value = null;
      self.key = null;
      return (self);
    }
  }

  public static void helpInsertACsValue(KvCons kvcons, Stella_Object newvalue, Context target, boolean overwriteP) {
    { int contextnumber = target.contextNumber;

      for (;;) {
        if ((!Stella.$CONTEXT_BACKTRACKING_MODE$) &&
            (Stella.$UNLINK_DISCARDED_CONTEXTS_ON_WRITEp$ &&
             (((((Context)(kvcons.key)).contextNumber) % 2) == 1))) {
          if (kvcons.rest != null) {
            { KvCons nextkvcons = kvcons.rest;

              kvcons.key = nextkvcons.key;
              kvcons.value = nextkvcons.value;
              kvcons.rest = nextkvcons.rest;
              nextkvcons.free();
            }
          }
          else {
            {
              kvcons.key = target;
              kvcons.value = newvalue;
              return;
            }
          }
        }
        if (kvcons.key == target) {
          if (overwriteP) {
            kvcons.value = newvalue;
          }
          return;
        }
        else if (((Context)(kvcons.key)).contextNumber < contextnumber) {
          kvcons.rest = KvCons.kvCons(kvcons.key, kvcons.value, kvcons.rest);
          kvcons.key = target;
          kvcons.value = newvalue;
          return;
        }
        else if (kvcons.rest == null) {
          kvcons.rest = KvCons.kvCons(target, newvalue, null);
          return;
        }
        else {
          kvcons = kvcons.rest;
        }
      }
    }
  }

  /** Return a copy of the cons list <code>consList</code>.
   * @param kvconslist
   * @return KvCons
   */
  public static KvCons copyKvConsList(KvCons kvconslist) {
    if (kvconslist == null) {
      return (null);
    }
    { KvCons newkvconslist = KvCons.newKvCons();
      KvCons nextkvcons = newkvconslist;
      KvCons copyfromkvcons = null;
      KvCons previouskvcons = null;

      nextkvcons.key = kvconslist.key;
      nextkvcons.value = kvconslist.value;
      copyfromkvcons = kvconslist.rest;
      while (copyfromkvcons != null) {
        previouskvcons = nextkvcons;
        nextkvcons = KvCons.newKvCons();
        previouskvcons.rest = nextkvcons;
        nextkvcons.key = copyfromkvcons.key;
        nextkvcons.value = copyfromkvcons.value;
        copyfromkvcons = copyfromkvcons.rest;
      }
      nextkvcons.rest = null;
      return (newkvconslist);
    }
  }

  public static void freeKvCons(KvCons kvcons) {
    kvcons.free();
  }

  public int length() {
    { KvCons self = this;

      { KvCons cursor = self;
        int length = 0;

        while (cursor != null) {
          length = length + 1;
          cursor = cursor.rest;
        }
        return (length);
      }
    }
  }

  public Stella_Object lookup(Stella_Object key) {
    { KvCons self = this;

      { KvCons cursor = self;

        while (cursor != null) {
          if (Stella_Object.eqlP(cursor.key, key)) {
            return (cursor.value);
          }
          cursor = cursor.rest;
        }
        return (null);
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { KvCons self = this;

      stream.print("<" + self.key + "," + self.value + ">");
    }
  }

  public static Stella_Object accessKvConsSlotValue(KvCons self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_KEY) {
      if (setvalueP) {
        self.key = value;
      }
      else {
        value = self.key;
      }
    }
    else if (slotname == Stella.SYM_STELLA_VALUE) {
      if (setvalueP) {
        self.value = value;
      }
      else {
        value = self.value;
      }
    }
    else if (slotname == Stella.SYM_STELLA_REST) {
      if (setvalueP) {
        self.rest = ((KvCons)(value));
      }
      else {
        value = self.rest;
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
    { KvCons self = this;

      return (Stella.SGT_STELLA_KV_CONS);
    }
  }

}

