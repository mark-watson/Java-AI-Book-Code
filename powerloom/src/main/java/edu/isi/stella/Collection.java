//  -*- Mode: Java -*-
//
// Collection.java

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

public abstract class Collection extends AbstractCollection {
  /** Return <code>true</code> if the collection <code>self</code> is ordered.
   * @return boolean
   */
  public boolean orderedP() {
    { Collection self = this;

      return (false);
    }
  }

  /** Return <code>true</code> if the collection <code>self</code> forbids duplicate values.
   * @return boolean
   */
  public boolean noDuplicatesP() {
    { Collection self = this;

      return (false);
    }
  }

  /** Return true iff <code>renamed_Object</code> is a member of the collection <code>self</code>.
   * @param renamed_Object
   * @return boolean
   */
  public boolean memberP(Stella_Object renamed_Object) {
    { Collection self = this;

      { Stella_Object i = null;
        Iterator iter000 = ((Iterator)(self.allocateIterator()));

        while (iter000.nextP()) {
          i = iter000.value;
          if (Stella_Object.eqlP(i, renamed_Object)) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  public AbstractCollection remove(Stella_Object value) {
    { Collection self = this;

      value = value;
      return (null);
    }
  }

  public void insert(Stella_Object value) {
    { Collection self = this;

      value = value;
      return;
    }
  }

  public int length() {
    { Collection self = this;

      return (Stella.NULL_INTEGER);
    }
  }

  public AbstractIterator allocateIterator() {
    { Collection self = this;

      return (null);
    }
  }

}

