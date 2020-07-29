//  -*- Mode: Java -*-
//
// StartupPowerloomSystem.java

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

package edu.isi.powerloom;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;
import edu.isi.powerloom.logic.*;
import edu.isi.powerloom.*;
import edu.isi.powerloom.extensions.*;
import edu.isi.stella.utilities.*;

public class StartupPowerloomSystem {
  public static void startupPowerloomSystem() {
    synchronized (Stella.$BOOTSTRAP_LOCK$) {
      if (Stella.currentStartupTimePhaseP(0)) {
        if (!(Stella.systemStartedUpP("logic", "/LOGIC"))) {
          StartupLogicSystem.startupLogicSystem();
        }
        if (!(Stella.systemStartedUpP("powerloom-extensions", "/PLX"))) {
          StartupPowerloomExtensionsSystem.startupPowerloomExtensionsSystem();
        }
      }
      if (Stella.currentStartupTimePhaseP(1)) {
        Module.defineModuleFromStringifiedSource("/POWERLOOM-CODE", "(:LISP-PACKAGE \"STELLA\" :JAVA-PACKAGE \"edu.isi.powerloom\" :JAVA-CATCHALL-CLASS \"PowerLoom\" :CLEARABLE? FALSE :CODE-ONLY? TRUE :USES (\"STELLA\" \"LOGIC\" \"PLI\" \"PLX\" \"UTILITIES\"))");
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/POWERLOOM-CODE", Stella.$STARTUP_TIME_PHASE$ > 1));
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          if (Stella.currentStartupTimePhaseP(2)) {
            PowerLoom.SYM_POWERLOOM_CODE_STARTUP_POWERLOOM_SYSTEM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-POWERLOOM-SYSTEM", null, 0)));
          }
          if (Stella.currentStartupTimePhaseP(6)) {
            Stella.finalizeClasses();
          }
          if (Stella.currentStartupTimePhaseP(7)) {
            Stella.defineFunctionObject("STARTUP-POWERLOOM-SYSTEM", "(DEFUN STARTUP-POWERLOOM-SYSTEM () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.StartupPowerloomSystem", "startupPowerloomSystem", new java.lang.Class [] {}), null);
            { MethodSlot function = Symbol.lookupFunction(PowerLoom.SYM_POWERLOOM_CODE_STARTUP_POWERLOOM_SYSTEM);

              KeyValueList.setDynamicSlotValue(function.dynamicSlots, PowerLoom.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("StartupPowerloomSystem"), Stella.NULL_STRING_WRAPPER);
            }
          }
          if (Stella.currentStartupTimePhaseP(8)) {
            Stella.finalizeSlots();
            Stella.cleanupUnfinalizedClasses();
          }
          if (Stella.currentStartupTimePhaseP(9)) {
            Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/POWERLOOM-CODE")))));
            { int phase = Stella.NULL_INTEGER;
              int iter000 = 0;
              int upperBound001 = 9;

              for (;iter000 <= upperBound001; iter000 = iter000 + 1) {
                phase = iter000;
                Stella.$STARTUP_TIME_PHASE$ = phase;
                _StartupPowerloom.startupPowerloom();
              }
            }
            Stella.$STARTUP_TIME_PHASE$ = 999;
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

}
