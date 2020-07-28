//  -*- Mode: Java -*-
//
// DimNumberLogicWrapper.java

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

package edu.isi.powerloom.extensions.units;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.utilities.*;

public class DimNumberLogicWrapper extends QuantityLogicWrapper {
  public static DimNumberLogicWrapper newDimNumberLogicWrapper(DimNumber wrapperValue) {
    { DimNumberLogicWrapper self = null;

      self = new DimNumberLogicWrapper();
      self.wrapperValue = wrapperValue;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.functionTerm = null;
      return (self);
    }
  }

  public double getMagnitude(String units) {
    { DimNumberLogicWrapper self = this;

      return (((DimNumber)(self.wrapperValue)).getMagnitude(units));
    }
  }

  public String getBaseUnit() {
    { DimNumberLogicWrapper self = this;

      return (((DimNumber)(self.wrapperValue)).getBaseUnit());
    }
  }

  public String getUnit() {
    { DimNumberLogicWrapper self = this;

      return (((DimNumber)(self.wrapperValue)).getUnit());
    }
  }

  public boolean objectEqlP(Stella_Object x) {
    { DimNumberLogicWrapper self = this;

      return ((x != null) &&
          (Stella_Object.isaP(x, Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER) &&
           Stella_Object.eqlP(((DimNumber)(self.wrapperValue)), ((DimNumber)(((DimNumberLogicWrapper)(x)).wrapperValue)))));
    }
  }

  public int hashCode_() {
    { DimNumberLogicWrapper self = this;

      if (((DimNumber)(self.wrapperValue)) != null) {
        return (((DimNumber)(self.wrapperValue)).hashCode_());
      }
      else {
        return (0);
      }
    }
  }

  public Stella_Object generateSpecializedTerm() {
    { DimNumberLogicWrapper self = this;

      { Cons term = self.functionTerm;
        DimNumber dim = ((DimNumber)(self.wrapperValue));

        if (term != null) {
          return (term);
        }
        else if (dim != null) {
          term = Cons.cons(Logic.generateTerm(Units.SGT_UNIT_KB_UNITS), Cons.cons(FloatWrapper.wrapFloat(dim.getMagnitude(dim.getUnit())), Cons.cons(StringWrapper.wrapString(dim.getUnit()), Stella.NIL)));
          self.functionTerm = term;
          return (term);
        }
        else {
          throw ((TermGenerationException)(TermGenerationException.newTermGenerationException(self, "Dim Number Wrapper doesn't have a value.").fillInStackTrace()));
        }
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { DimNumberLogicWrapper self = this;

      if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
        stream.print(((DimNumber)(self.wrapperValue)));
      }
      else {
        stream.print("|uw|" + ((DimNumber)(self.wrapperValue)));
      }
    }
  }

  public static Stella_Object accessDimNumberLogicWrapperSlotValue(DimNumberLogicWrapper self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Units.SYM_STELLA_WRAPPER_VALUE) {
      if (setvalueP) {
        self.wrapperValue = ((DimNumber)(value));
      }
      else {
        value = ((DimNumber)(self.wrapperValue));
      }
    }
    else {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public Surrogate primaryType() {
    { DimNumberLogicWrapper self = this;

      return (Units.SGT_UNIT_SUPPORT_DIM_NUMBER_LOGIC_WRAPPER);
    }
  }

}

