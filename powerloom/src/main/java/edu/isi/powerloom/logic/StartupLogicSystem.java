//  -*- Mode: Java -*-
//
// StartupLogicSystem.java

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

public class StartupLogicSystem {
  public static void startupLogicSystem() {
    synchronized (Stella.$BOOTSTRAP_LOCK$) {
      if (Stella.currentStartupTimePhaseP(0)) {
        if (!(Stella.systemStartedUpP("stella", "/STELLA"))) {
          StartupStellaSystem.startupStellaSystem();
        }
      }
      if (Stella.currentStartupTimePhaseP(1)) {
        Module.defineModuleFromStringifiedSource("/LOGIC", "(:LISP-PACKAGE \"STELLA\" :CPP-PACKAGE \"logic\" :JAVA-PACKAGE \"edu.isi.powerloom.logic\" :CLEARABLE? FALSE :CODE-ONLY? TRUE)");
        Module.defineModuleFromStringifiedSource("/PL-KERNEL-KB", "(:DOCUMENTATION \"Defines foundation classes and relations for PowerLoom.\" :CPP-PACKAGE \"pl_kernel_kb\" :JAVA-PACKAGE \"edu.isi.powerloom.pl_kernel_kb\" :USES (\"LOGIC\" \"STELLA\") :SHADOW (COLLECTION SET RELATION FUNCTION CLASS LIST VALUE ARITY INVERSE NAME QUANTITY FLOOR CEILING LOG LOG10 EXP EXPT) :NICKNAME \"PL-KERNEL\" :PROTECT-SURROGATES? TRUE)");
        Module.defineModuleFromStringifiedSource("/PL-KERNEL-KB/PL-USER", "(:DOCUMENTATION \"The default module for PowerLoom users.  It does not\ncontain any local declarations or axioms, but it includes other modules\nneeded to call PowerLoom functions.\" :INCLUDES (\"PL-KERNEL\") :USES (\"LOGIC\" \"STELLA\"))");
        Module.defineModuleFromStringifiedSource("/PL-ANONYMOUS", "(:DOCUMENTATION \"Holds names of system-generated anonymous objects such as prototypes.\nUsers should never allocate any names in this module.\" :CASE-SENSITIVE? TRUE :USES ())");
        Module.defineModuleFromStringifiedSource("/PL-KERNEL-KB/LOOM-API", "(:DOCUMENTATION \"Defines a Loom API for PowerLoom.\" :LISP-PACKAGE \"LOOM-API\" :INCLUDES \"PL-KERNEL\" :USES (\"LOGIC\" \"STELLA\") :SHADOW (NAMED?) :PROTECT-SURROGATES? TRUE)");
        Module.defineModuleFromStringifiedSource("/PL-KERNEL-KB/KIF-FRAME-ONTOLOGY", "(:DOCUMENTATION \"Defines KIF-compatible frame predicates following\nOntolingua conventions.\" :USES (\"LOGIC\" \"STELLA\"))");
        Module.defineModuleFromStringifiedSource("/PL-KERNEL-KB/CYC-FRAME-ONTOLOGY", "(:DOCUMENTATION \"Defines Cyc-compatible frame predicates.\" :USES (\"LOGIC\" \"STELLA\"))");
        Module.defineModuleFromStringifiedSource("/PLI", "(:DOCUMENTATION \"Defines the PowerLoom API.\" :USES (\"LOGIC\" \"STELLA\") :SHADOW (GET-OBJECT GET-RELATION GET-MODULE CHANGE-MODULE CLEAR-MODULE LOAD LOAD-IN-MODULE LOAD-STREAM LOAD-STREAM-IN-MODULE GET-RULES PRINT-RULES RUN-FORWARD-RULES SAVE-MODULE CREATE-OBJECT DESTROY-OBJECT REGISTER-SPECIALIST-FUNCTION REGISTER-COMPUTATION-FUNCTION ASSERT RETRACT CONCEIVE EVALUATE EVALUATE-STRING IS-TRUE IS-FALSE IS-UNKNOWN ASK RETRIEVE CREATE-ENUMERATED-SET RESET-POWERLOOM CLEAR-CACHES) :API? TRUE :LISP-PACKAGE \"PLI\" :CPP-PACKAGE \"pli\" :JAVA-PACKAGE \"edu.isi.powerloom\" :JAVA-CATCHALL-CLASS \"PLI\" :CODE-ONLY? TRUE)");
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          if (Stella.currentStartupTimePhaseP(2)) {
            Logic.SYM_LOGIC_STARTUP_LOGIC_SYSTEM = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-LOGIC-SYSTEM", null, 0)));
          }
          if (Stella.currentStartupTimePhaseP(6)) {
            Stella.finalizeClasses();
          }
          if (Stella.currentStartupTimePhaseP(7)) {
            Stella.defineFunctionObject("STARTUP-LOGIC-SYSTEM", "(DEFUN STARTUP-LOGIC-SYSTEM () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.StartupLogicSystem", "startupLogicSystem", new java.lang.Class [] {}), null);
            { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_LOGIC_SYSTEM);

              KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("StartupLogicSystem"), Stella.NULL_STRING_WRAPPER);
            }
          }
          if (Stella.currentStartupTimePhaseP(8)) {
            Stella.finalizeSlots();
            Stella.cleanupUnfinalizedClasses();
          }
          if (Stella.currentStartupTimePhaseP(9)) {
            Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("/LOGIC")))));
            { int phase = Stella.NULL_INTEGER;
              int iter066 = 0;
              int upperBound067 = 9;

              for (;iter066 <= upperBound067; iter066 = iter066 + 1) {
                phase = iter066;
                Stella.$STARTUP_TIME_PHASE$ = phase;
                _StartupLogicMacros.startupLogicMacros();
                _StartupSequenceIndices.startupSequenceIndices();
                _StartupKifIn.startupKifIn();
                _StartupPropositions.startupPropositions();
                _StartupBacklinks.startupBacklinks();
                _StartupPropagate.startupPropagate();
                _StartupInferenceCaches.startupInferenceCaches();
                _StartupDescriptions.startupDescriptions();
                _StartupNormalize.startupNormalize();
                _StartupRules.startupRules();
                _StartupQuery.startupQuery();
                _StartupPartialMatch.startupPartialMatch();
                _StartupMachineLearning.startupMachineLearning();
                _StartupRuleInduction.startupRuleInduction();
                _StartupNeuralNetwork.startupNeuralNetwork();
                _StartupCaseBased.startupCaseBased();
                _StartupGoalCaches.startupGoalCaches();
                _StartupStrategies.startupStrategies();
                _StartupJustifications.startupJustifications();
                _StartupExplanations.startupExplanations();
                _StartupWhynot.startupWhynot();
                _StartupKifOut.startupKifOut();
                _StartupPrint.startupPrint();
                _StartupGenerate.startupGenerate();
                _StartupSpecialists.startupSpecialists();
                _StartupSpecialize.startupSpecialize();
                _StartupOptimize.startupOptimize();
                _StartupClassify.startupClassify();
                _StartupLogicIn.startupLogicIn();
                edu.isi.powerloom.pl_kernel_kb._StartupPlKernelKb.startupPlKernelKb();
                edu.isi.powerloom.pl_kernel_kb._StartupArithmetic.startupArithmetic();
                _StartupFrameSupport.startupFrameSupport();
                edu.isi.powerloom.pl_kernel_kb.loom_api._StartupLoomSupport.startupLoomSupport();
                _StartupLoomToKif.startupLoomToKif();
                _StartupApiSupport.startupApiSupport();
                edu.isi.powerloom._StartupPli.startupPli();
                _StartupPowerloom.startupPowerloom();
                _StartupTools.startupTools();
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
