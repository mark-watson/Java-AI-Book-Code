//  -*- Mode: Java -*-
//
// _StartupInferenceCaches.java

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

public class _StartupInferenceCaches {
  public static void startupInferenceCaches() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Logic.SYM_LOGIC_INFERENCE_CACHE_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INFERENCE-CACHE-OF", null, 0)));
          Logic.KWD_JUST_IN_TIME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JUST-IN-TIME", null, 2)));
          Logic.SYM_LOGIC_JUST_IN_TIME_INFERENCE_CACHE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JUST-IN-TIME-INFERENCE-CACHE", null, 0)));
          Logic.KWD_TMS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TMS", null, 2)));
          Logic.SYM_LOGIC_UP_TO_DATE_INFERENCESp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UP-TO-DATE-INFERENCES?", null, 0)));
          Logic.SYM_LOGIC_TRUTH_MAINTAINEDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("TRUTH-MAINTAINED?", null, 0)));
          Logic.KWD_PERFORMANCE_CLUES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PERFORMANCE-CLUES", null, 2)));
          Logic.KWD_FORCEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORCE?", null, 2)));
          Logic.KWD_FORCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORCE", null, 2)));
          Logic.SYM_LOGIC_STARTUP_INFERENCE_CACHES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-INFERENCE-CACHES", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$INVISIBLEASSERTIONp$.setDefaultValue(new Boolean(false));
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("WORLD-STATE?", "(DEFUN (WORLD-STATE? BOOLEAN) ((SELF CONTEXT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "worldStateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("GET-WORLD-STATE", "(DEFUN (GET-WORLD-STATE CONTEXT) ((SELF CONTEXT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getWorldState", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTEXT META-INFERENCE-CACHE :TYPE WORLD :ALLOCATION :DYNAMIC)");
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTEXT TRUTH-MAINTAINED-INFERENCE-CACHE :TYPE WORLD :ALLOCATION :DYNAMIC)");
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT CONTEXT JUST-IN-TIME-INFERENCE-CACHE :TYPE WORLD :ALLOCATION :DYNAMIC)");
          Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT WORLD INFERENCE-CACHE-OF :TYPE CONTEXT :PUBLIC? TRUE :ALLOCATION :DYNAMIC)");
          Stella.defineFunctionObject("LOOKUP-INFERENCE-CACHE", "(DEFUN (LOOKUP-INFERENCE-CACHE WORLD) ((CONTEXT CONTEXT) (KIND KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("INITIALIZE-INFERENCE-WORLD", "(DEFUN INITIALIZE-INFERENCE-WORLD ((WORLD WORLD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "initializeInferenceWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World")}), null);
          Stella.defineFunctionObject("CREATE-INFERENCE-CACHE", "(DEFUN (CREATE-INFERENCE-CACHE WORLD) ((CONTEXT CONTEXT) (KIND KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("JUST-IN-TIME-INFERENCE-CACHE?", "(DEFUN (JUST-IN-TIME-INFERENCE-CACHE? BOOLEAN) ((SELF CONTEXT)) :DOCUMENTATION \"Return true if `self' is the JIT cache of some world state.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "justInTimeInferenceCacheP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("META-INFERENCE-CACHE?", "(DEFUN (META-INFERENCE-CACHE? BOOLEAN) ((SELF CONTEXT)) :DOCUMENTATION \"Return true if `self' is the meta-JIT cache of some world state.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "metaInferenceCacheP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("GET-INFERENCE-CACHE", "(DEFUN (GET-INFERENCE-CACHE WORLD) ((CONTEXT CONTEXT) (KIND KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("DESTROY-INFERENCE-CACHE", "(DEFUN DESTROY-INFERENCE-CACHE ((CONTEXT CONTEXT) (KIND KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("DESTROY-ALL-INFERENCE-CACHES", "(DEFUN DESTROY-ALL-INFERENCE-CACHES ((CONTEXT CONTEXT) (KIND KEYWORD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyAllInferenceCaches", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("UNLINK-INFERENCE-CACHE", "(DEFUN UNLINK-INFERENCE-CACHE ((SELF WORLD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unlinkInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World")}), null);
          Stella.defineFunctionObject("DESTROY-INFERENCE-CACHES", "(DEFUN DESTROY-INFERENCE-CACHES ((CONTEXT CONTEXT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "destroyInferenceCaches", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("META-PROPOSITION?", "(DEFUN (META-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION)) :DOCUMENTATION \"Return TRUE if 'proposition' is tied only to at least one meta object\nand no other objects except literals or function terms that are itself meta objects.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "metaPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("HANDLE-OUT-OF-DATE-INFERENCE-CACHE", "(DEFUN HANDLE-OUT-OF-DATE-INFERENCE-CACHE ((ASSERTORRETRACT KEYWORD) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "handleOutOfDateInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("BEST-INFERENCE-CACHE", "(DEFUN (BEST-INFERENCE-CACHE WORLD) ((CONTEXT CONTEXT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "bestInferenceCache", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("GET-QUERY-CONTEXT", "(DEFUN (GET-QUERY-CONTEXT CONTEXT) () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getQueryContext", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("GET-PROPERTY-TEST-CONTEXT", "(DEFUN (GET-PROPERTY-TEST-CONTEXT CONTEXT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getPropertyTestContext", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("GET-INFERABLE-TEST-CONTEXT", "(DEFUN (GET-INFERABLE-TEST-CONTEXT CONTEXT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getInferableTestContext", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("GET-TOP-LEVEL-UPDATE-CONTEXT", "(DEFUN (GET-TOP-LEVEL-UPDATE-CONTEXT CONTEXT) ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getTopLevelUpdateContext", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LOOKUP-CONSTRAINT-PROPAGATION-WORLD", "(DEFUN (LOOKUP-CONSTRAINT-PROPAGATION-WORLD WORLD) ((SELF CONTEXT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupConstraintPropagationWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("INHERIT-CACHED-INFERENCES", "(DEFUN INHERIT-CACHED-INFERENCES ((FROMWORLD WORLD) (TOWORLD WORLD)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inheritCachedInferences", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World"), Native.find_java_class("edu.isi.stella.World")}), null);
          Stella.defineFunctionObject("INHERIT-TRUTH-VALUE-UPDATE", "(DEFUN INHERIT-TRUTH-VALUE-UPDATE ((PROPOSITION PROPOSITION) (TOWORLD WORLD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inheritTruthValueUpdate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.World")}), null);
          Stella.defineFunctionObject("INHERIT-VARIABLE-VALUE-UPDATE", "(DEFUN INHERIT-VARIABLE-VALUE-UPDATE ((SKOLEM SKOLEM) (TOWORLD WORLD)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "inheritVariableValueUpdate", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.World")}), null);
          Stella.defineFunctionObject("CALL-PROPAGATE-CONSTRAINTS", "(DEFUN CALL-PROPAGATE-CONSTRAINTS ((CONTEXT CONTEXT)) :DOCUMENTATION \"Trigger constraint propagation over all propositions\nin the module or world `context'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callPropagateConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("PROPAGATE-CONSTRAINTS", "(DEFUN PROPAGATE-CONSTRAINTS (|&REST| (NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Trigger constraint propagation over all propositions of module `name'.\nIf no `name' is supplied, the current module will be used.  This also\nenables incremental constraint propagation for future monotonic updates to\nthe module.  Once a non-monotonic update is performed, i.e., a retraction\nor clipping of a function value, all cached inferences will be discarded\nand constraint propagation will be turned off until this function is\ncalled again.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "propagateConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "propagateConstraintsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("REPROPAGATE-CONSTRAINTS", "(DEFUN REPROPAGATE-CONSTRAINTS (|&REST| (NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Force non-incremental constraint propagation over all propositions of\nmodule `name'.  If no `name' is supplied, the current module will be used.\nThis also enables incremental constraint propagation for future monotonic\nupdates to the module similar to `propagate-constraints'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "repropagateConstraints", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "repropagateConstraintsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CALL-RUN-FORWARD-RULES", "(DEFUN CALL-RUN-FORWARD-RULES ((MODULE MODULE) (FORCE? BOOLEAN)) :DOCUMENTATION \"Run forward inference rules in module 'module'. If 'module'\nis NULL, the current module will be used.  If forward inferencing is already\nup-to-date in the designated module, no additional inferencing will occur,\nunless 'force?' is set to TRUE, in which case all forward rules are run or rerun.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callRunForwardRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("RUN-FORWARD-RULES", "(DEFUN RUN-FORWARD-RULES (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Run forward inference rules in the module defined by the :module option (which\ndefaults to the current module).  If forward inferencing is already up-to-date\nin the designated module, no additional inferencing will occur, unless the :force?\noption is specified as TRUE, in which case all forward rules are run or rerun.\nFor backwards compatibility, this command also supports the old <module> :force\narguments specified with a non-standard keyword notation.\n\nCalling `run-forward-rules' temporarily puts the module into a mode where\nfuture assertional (monotonic) updates will trigger additional forward\ninference.  Once a non-monotonic update is performed, i.e., a retraction\nor clipping of relation value, all cached forward inferences will be discarded\nand forward inferencing will be disabled until this function is called again.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "runForwardRules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "runForwardRulesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("STARTUP-INFERENCE-CACHES", "(DEFUN STARTUP-INFERENCE-CACHES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupInferenceCaches", "startupInferenceCaches", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_INFERENCE_CACHES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupInferenceCaches"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *INVISIBLEASSERTION?* BOOLEAN FALSE :DOCUMENTATION \"Used to signal an assertion that doesn't\nblow away inference caches.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
