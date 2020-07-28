//  -*- Mode: Java -*-
//
// _StartupUnitDefs.java

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
| Portions created by the Initial Developer are Copyright (C) 2001-2017      |
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

package edu.isi.stella.utilities;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class _StartupUnitDefs {
  public static void startupUnitDefs() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/UTILITIES", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Utilities.SYM_UTILITIES_STARTUP_UNIT_DEFS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-UNIT-DEFS", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("INITIALIZE-UNIT-DEFINITIONS", "(DEFUN INITIALIZE-UNIT-DEFINITIONS () :DOCUMENTATION \"Measure conversion factors.  The ultimate source for the\nconversions are the following publications.  NIST was normally followed\nunless a more precise value was found in MfM.\n\nSources:\n[NIST]\n  Guide for the Use of the International System of Units (SI)\n  U.S. Department of Commerce\n  National Institute of Standards and Technology (NIST)\n  NIST Special Publication 811, 1995 Edition\n  http://physics.nist.gov/Document/sp811.pdf\n\n[MfM]\n  Richard A. Young and Thomas J. Glover\n  Measure for Measure\n  1996.  ISBN 1-889796-00-X\n  (Blue Willow, Inc.; Littleton, Colorado, USA)\n  http://www.bluewillow.com/\n\")", Native.find_java_method("edu.isi.stella.utilities.Utilities", "initializeUnitDefinitions", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("STARTUP-UNIT-DEFS", "(DEFUN STARTUP-UNIT-DEFS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.utilities._StartupUnitDefs", "startupUnitDefs", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Utilities.SYM_UTILITIES_STARTUP_UNIT_DEFS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Utilities.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupUnitDefs"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("UTILITIES")))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
