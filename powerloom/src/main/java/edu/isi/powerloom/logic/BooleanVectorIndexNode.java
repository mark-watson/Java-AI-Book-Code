//  -*- Mode: Java -*-
//
// BooleanVectorIndexNode.java

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

public class BooleanVectorIndexNode extends StandardObject {
    public BooleanVectorIndexNode trueLink;
    public BooleanVectorIndexNode falseLink;
    public BooleanVector theVector;

  public static BooleanVectorIndexNode newBooleanVectorIndexNode() {
    { BooleanVectorIndexNode self = null;

      self = new BooleanVectorIndexNode();
      self.theVector = null;
      self.falseLink = null;
      self.trueLink = null;
      return (self);
    }
  }

  public static BooleanVectorIndexNode createBooleanVectorIndexNode(BooleanVectorIndexNode parentnode, boolean lastvalue) {
    { BooleanVectorIndexNode node = BooleanVectorIndexNode.newBooleanVectorIndexNode();
      int vectorlength = parentnode.theVector.length() + 1;
      BooleanVector vector = BooleanVector.newBooleanVector(vectorlength);

      node.theVector = vector;
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = vectorlength - 2;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (vector.theArray)[i] = (((BooleanWrapper)((parentnode.theVector.theArray)[i])));
        }
      }
      (vector.theArray)[(vectorlength - 1)] = ((lastvalue ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      if (lastvalue) {
        parentnode.trueLink = node;
      }
      else {
        parentnode.falseLink = node;
      }
      return (node);
    }
  }

  public static Stella_Object accessBooleanVectorIndexNodeSlotValue(BooleanVectorIndexNode self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_TRUE_LINK) {
      if (setvalueP) {
        self.trueLink = ((BooleanVectorIndexNode)(value));
      }
      else {
        value = self.trueLink;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FALSE_LINK) {
      if (setvalueP) {
        self.falseLink = ((BooleanVectorIndexNode)(value));
      }
      else {
        value = self.falseLink;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_THE_VECTOR) {
      if (setvalueP) {
        self.theVector = ((BooleanVector)(value));
      }
      else {
        value = self.theVector;
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
    { BooleanVectorIndexNode self = this;

      return (Logic.SGT_LOGIC_BOOLEAN_VECTOR_INDEX_NODE);
    }
  }

}

