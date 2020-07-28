//  -*- Mode: Java -*-
//
// ExtensibleSymbolArray.java

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

/** Self-extending array with methods for storing and
 * accessing symbols within it.
 * @author Stella Java Translator
 */
public class ExtensibleSymbolArray extends ExtensibleVector {
    public int topSymbolOffset;
    public int potentialFreeSymbolOffset;

  public static ExtensibleSymbolArray newExtensibleSymbolArray(int arraySize) {
    { ExtensibleSymbolArray self = null;

      self = new ExtensibleSymbolArray();
      self.arraySize = arraySize;
      self.theArray = null;
      self.potentialFreeSymbolOffset = 0;
      self.topSymbolOffset = -1;
      self.initializeVector();
      return (self);
    }
  }

  public static boolean legalSymbolArrayOffsetP(ExtensibleSymbolArray array, int offset) {
    return (offset <= array.topSymbolOffset);
  }

  public static int addToSymbolArray(ExtensibleSymbolArray array, GeneralizedSymbol symbol) {
    { int offset = ExtensibleSymbolArray.nextFreeOffset(array);

      ExtensibleSymbolArray.addToSymbolArrayAt(array, offset, symbol);
      return (offset);
    }
  }

  public static void addToSymbolArrayAt(ExtensibleSymbolArray array, int offset, GeneralizedSymbol symbol) {
    array.insertAt(offset, symbol);
    symbol.symbolId = offset;
  }

  public static void freeSymbolOffset(ExtensibleSymbolArray self, int offset) {
    (self.theArray)[offset] = null;
    if (offset < self.potentialFreeSymbolOffset) {
      self.potentialFreeSymbolOffset = offset;
    }
  }

  public static int nextFreeOffset(ExtensibleSymbolArray self) {
    { int topoffset = self.topSymbolOffset;
      int freeoffset = topoffset + 1;

      { int i = Stella.NULL_INTEGER;
        int iter000 = self.potentialFreeSymbolOffset;
        int upperBound000 = topoffset;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        loop000 : for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          if ((self.theArray)[i] == null) {
            freeoffset = i;
            break loop000;
          }
        }
      }
      self.potentialFreeSymbolOffset = freeoffset + 1;
      return (freeoffset);
    }
  }

  public void insertAt(int offset, Stella_Object value) {
    { ExtensibleSymbolArray self = this;

      if (offset >= self.arraySize) {
        { int size = self.arraySize;

          while (offset >= size) {
            size = 2 * size;
          }
          Vector.resizeVector(self, size);
        }
      }
      (self.theArray)[offset] = value;
      if (offset > self.topSymbolOffset) {
        self.topSymbolOffset = offset;
      }
    }
  }

  public static Stella_Object accessExtensibleSymbolArraySlotValue(ExtensibleSymbolArray self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_TOP_SYMBOL_OFFSET) {
      if (setvalueP) {
        self.topSymbolOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.topSymbolOffset);
      }
    }
    else if (slotname == Stella.SYM_STELLA_POTENTIAL_FREE_SYMBOL_OFFSET) {
      if (setvalueP) {
        self.potentialFreeSymbolOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.potentialFreeSymbolOffset);
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
    { ExtensibleSymbolArray self = this;

      return (Stella.SGT_STELLA_EXTENSIBLE_SYMBOL_ARRAY);
    }
  }

}

