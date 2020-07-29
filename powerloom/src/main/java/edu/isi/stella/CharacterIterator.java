//  -*- Mode: Java -*-
//
// CharacterIterator.java

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

/** Iterator that yields characters from an input stream.
 * @author Stella Java Translator
 */
public class CharacterIterator extends StreamIterator {
    /** The current value of this iterator
     */
    public char value;

  public static CharacterIterator newCharacterIterator() {
    { CharacterIterator self = null;

      self = new CharacterIterator();
      self.firstIterationP = true;
      self.value = Stella.NULL_CHARACTER;
      self.theStream = null;
      return (self);
    }
  }

  public boolean nextP() {
    { CharacterIterator self = this;

      self.firstIterationP = false;
      { char renamed_Char = Stella.NULL_CHARACTER;
        boolean eofP = false;

        { Object [] caller_MV_returnarray = new Object[1];

          renamed_Char = InputStream.readCharacter(self.theStream, caller_MV_returnarray);
          eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        if (eofP) {
          self.value = Stella.NULL_CHARACTER;
          Stream.closeStream(self.theStream);
          return (false);
        }
        else {
          self.value = renamed_Char;
          return (true);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { CharacterIterator self = this;

      return (Stella.SGT_STELLA_CHARACTER_ITERATOR);
    }
  }

  public void free() {
    { CharacterIterator self = this;

      if (StreamIterator.terminateStreamIteratorP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

