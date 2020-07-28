//  -*- Mode: Java -*-
//
// CustomVectorSequence.java

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

/** VECTOR-SEQUENCE (which see) with a customizable resize factor.
 * The resize factor needs to be &gt; 1.
 * @author Stella Java Translator
 */
public class CustomVectorSequence extends VectorSequence {
    public double resizeFactor;

  public static CustomVectorSequence newCustomVectorSequence(int arraySize) {
    { CustomVectorSequence self = null;

      self = new CustomVectorSequence();
      self.arraySize = arraySize;
      self.theArray = null;
      self.sequenceLength = 0;
      self.resizeFactor = 2.0;
      self.initializeVector();
      return (self);
    }
  }

  /** Return a copy of the vector sequence <code>self</code>.
   * @return Vector
   */
  public Vector copy() {
    { CustomVectorSequence self = this;

      { CustomVectorSequence copy = CustomVectorSequence.newCustomVectorSequence(self.arraySize);

        copy.resizeFactor = self.resizeFactor;
        VectorSequence.copyVectorSequence(self, copy);
        return (copy);
      }
    }
  }

  /** Append <code>value</code> to the END of the sequence <code>self</code>.  
   * Resize the array if necessary.
   * @param value
   */
  public void insert(Stella_Object value) {
    { CustomVectorSequence self = this;

      { int oldlength = self.sequenceLength;

        if (oldlength == self.arraySize) {
          if (!(self.resizeFactor > 1.0)) {
            System.err.print("Safety violation: CUSTOM-VECTOR-SEQUENCE.insert: resize factor needs to be > 1");
          }
          Vector.resizeVector(self, ((int)(self.arraySize * self.resizeFactor)));
        }
        (self.theArray)[oldlength] = value;
        self.sequenceLength = oldlength + 1;
      }
    }
  }

  public static Stella_Object accessCustomVectorSequenceSlotValue(CustomVectorSequence self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_RESIZE_FACTOR) {
      if (setvalueP) {
        self.resizeFactor = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.resizeFactor);
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
    { CustomVectorSequence self = this;

      return (Stella.SGT_STELLA_CUSTOM_VECTOR_SEQUENCE);
    }
  }

}

