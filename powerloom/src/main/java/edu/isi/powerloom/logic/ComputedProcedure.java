//  -*- Mode: Java -*-
//
// ComputedProcedure.java

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

/** Each instance denotes a programming language 
 * function that computes some procedure.  The slot 'procedure-name'
 * provides the name of the procedure.  The slot 'procedure-function'
 * points to the STELLA function object carrying out the computation.
 * If neither is supplied, the procedure will be looked up by extracting
 * its name from the name of the instance.  Pointing to a function object
 * instead of just the code gives us access to argument type information.
 * Note that we support external non-STELLA functions by creating a dummy
 * STELLA function object during registration of the computation (see
 * <code>registerComputationFunction</code> and friends).
 * @author Stella Java Translator
 */
public class ComputedProcedure extends Thing {
    public Symbol procedureName;
    public MethodSlot procedureFunction;

  public static ComputedProcedure newComputedProcedure() {
    { ComputedProcedure self = null;

      self = new ComputedProcedure();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.procedureFunction = null;
      self.procedureName = null;
      return (self);
    }
  }

  public static java.lang.reflect.Method functionCodeFromProcedure(ComputedProcedure procedure) {
    { MethodSlot stellafunction = procedure.procedureFunction;

      if (stellafunction == null) {
        stellafunction = ComputedProcedure.stellaFunctionFromProcedure(procedure);
      }
      return (stellafunction.functionCode);
    }
  }

  public static MethodSlot stellaFunctionFromProcedure(ComputedProcedure procedure) {
    if (procedure.procedureFunction != null) {
      return (procedure.procedureFunction);
    }
    { Symbol procedurename = procedure.procedureName;
      MethodSlot stellafunction = null;

      if (procedurename == null) {
        procedurename = Symbol.internSymbolInModule(procedure.surrogateValueInverse.symbolName, ((Module)(procedure.surrogateValueInverse.homeContext)), true);
        procedure.procedureName = procedurename;
      }
      stellafunction = Symbol.lookupFunction(procedurename);
      if (stellafunction == null) {
        { Symbol kernelname = Symbol.lookupSymbolInModule(procedurename.symbolName, Logic.$PL_KERNEL_MODULE$, false);

          if (kernelname != null) {
            stellafunction = Symbol.lookupFunction(kernelname);
          }
        }
      }
      if (stellafunction == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              stream000.nativeStream.println("ERROR: Missing specialist, no STELLA function is named `" + procedurename + "'.");
              Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      if (Logic.$POWERLOOM_EXECUTION_MODE$ == Logic.KWD_RELEASE) {
        procedure.procedureFunction = stellafunction;
      }
      return (stellafunction);
    }
  }

  public static Stella_Object accessComputedProcedureSlotValue(ComputedProcedure self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_PROCEDURE_NAME) {
      if (setvalueP) {
        self.procedureName = ((Symbol)(value));
      }
      else {
        value = self.procedureName;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_PROCEDURE_FUNCTION) {
      if (setvalueP) {
        self.procedureFunction = ((MethodSlot)(value));
      }
      else {
        value = self.procedureFunction;
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
    { ComputedProcedure self = this;

      return (Logic.SGT_LOGIC_COMPUTED_PROCEDURE);
    }
  }

}

