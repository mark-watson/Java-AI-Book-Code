//  -*- Mode: Java -*-
//
// NativeLineIterator.java

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

/** Iterator that yields lines from an input stream.
 * @author Stella Java Translator
 */
public class NativeLineIterator extends StreamIterator {
    /** The current value of this iterator
     */
    public String value;

  public static NativeLineIterator newNativeLineIterator() {
    { NativeLineIterator self = null;

      self = new NativeLineIterator();
      self.firstIterationP = true;
      self.value = null;
      self.theStream = null;
      return (self);
    }
  }

  public boolean nextP() {
    { NativeLineIterator self = this;

      { String line = InputStream.nativeReadLine(self.theStream);

        self.firstIterationP = false;
        self.value = line;
        if (line == null) {
          Stream.closeStream(self.theStream);
          return (false);
        }
        else {
          return (true);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { NativeLineIterator self = this;

      return (Stella.SGT_STELLA_NATIVE_LINE_ITERATOR);
    }
  }

  public void free() {
    { NativeLineIterator self = this;

      if (StreamIterator.terminateStreamIteratorP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

