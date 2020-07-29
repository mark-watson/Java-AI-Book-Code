//  -*- Mode: Java -*-
//
// _StartupNeuralNetwork.java

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

public class _StartupNeuralNetwork {
  static void helpStartupNeuralNetwork1() {
    {
      Logic.KWD_BACKPROP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKPROP", null, 2)));
      Logic.SYM_LOGIC_WEIGHT_VECTOR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WEIGHT-VECTOR", null, 0)));
      Logic.SYM_LOGIC_2_D_WEIGHT_ARRAY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("2_D_WEIGHT-ARRAY", null, 0)));
      Logic.SGT_LOGIC_PROPOSITION_NEURAL_NETWORK = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION-NEURAL-NETWORK", null, 1)));
      Logic.SYM_LOGIC_HIDDEN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HIDDEN", null, 0)));
      Logic.SYM_LOGIC_INPUT_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INPUT-ERROR", null, 0)));
      Logic.SYM_LOGIC_HIDDEN_ERROR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HIDDEN-ERROR", null, 0)));
      Logic.SYM_LOGIC_IH = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IH", null, 0)));
      Logic.SYM_LOGIC_IH_DELTA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IH-DELTA", null, 0)));
      Logic.SYM_LOGIC_HO = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HO", null, 0)));
      Logic.SYM_LOGIC_HO_DELTA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HO-DELTA", null, 0)));
      Logic.SYM_LOGIC_IH_SLOPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IH-SLOPE", null, 0)));
      Logic.SYM_LOGIC_IH_PREV_SLOPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IH-PREV-SLOPE", null, 0)));
      Logic.SYM_LOGIC_HO_SLOPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HO-SLOPE", null, 0)));
      Logic.SYM_LOGIC_HO_PREV_SLOPE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HO-PREV-SLOPE", null, 0)));
      Logic.KWD_QUICKPROP = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("QUICKPROP", null, 2)));
      Logic.KWD_BACKPROPAGATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKPROPAGATION", null, 2)));
      Logic.SYM_LOGIC_DEFNETWORK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFNETWORK", null, 0)));
      Logic.SGT_LOGIC_MULTI_DIMENSIONAL_ARRAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("MULTI-DIMENSIONAL-ARRAY", null, 1)));
      Logic.SGT_LOGIC_2_D_ARRAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("2_D_ARRAY", null, 1)));
      Logic.SYM_LOGIC_NOF_ROWS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NOF-ROWS", null, 0)));
      Logic.SYM_LOGIC_NOF_COLUMNS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NOF-COLUMNS", null, 0)));
      Logic.SGT_LOGIC_FLOAT_VECTOR = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("FLOAT-VECTOR", null, 1)));
      Logic.SYM_STELLA_ARRAY_SIZE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ARRAY-SIZE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SGT_LOGIC_2_D_FLOAT_ARRAY = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("2_D_FLOAT-ARRAY", null, 1)));
      Logic.SYM_LOGIC_STARTUP_NEURAL_NETWORK = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-NEURAL-NETWORK", null, 0)));
    }
  }

  static void helpStartupNeuralNetwork2() {
    {
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE WEIGHT-VECTOR (VECTOR OF FLOAT-WRAPPER))");
      Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE 2_D_WEIGHT-ARRAY (2_D_ARRAY OF FLOAT-WRAPPER))");
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("PROPOSITION-NEURAL-NETWORK", "(DEFCLASS PROPOSITION-NEURAL-NETWORK (STANDARD-OBJECT) :SLOTS ((PROPOSITION :TYPE PROPOSITION) (INPUT :TYPE WEIGHT-VECTOR) (HIDDEN :TYPE WEIGHT-VECTOR) (OUTPUT :TYPE FLOAT) (INPUT-ERROR :TYPE WEIGHT-VECTOR) (HIDDEN-ERROR :TYPE WEIGHT-VECTOR) (IH :TYPE 2_D_WEIGHT-ARRAY) (IH-DELTA :TYPE 2_D_WEIGHT-ARRAY) (HO :TYPE WEIGHT-VECTOR) (HO-DELTA :TYPE WEIGHT-VECTOR) (IH-SLOPE :TYPE 2_D_WEIGHT-ARRAY) (IH-PREV-SLOPE :TYPE 2_D_WEIGHT-ARRAY) (HO-SLOPE :TYPE WEIGHT-VECTOR) (HO-PREV-SLOPE :TYPE WEIGHT-VECTOR)))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "newPropositionNeuralNetwork", new java.lang.Class [] {});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "accessPropositionNeuralNetworkSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("MULTI-DIMENSIONAL-ARRAY", "(DEFCLASS MULTI-DIMENSIONAL-ARRAY (ABSTRACT-COLLECTION))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.MultiDimensionalArray", "newMultiDimensionalArray", new java.lang.Class [] {});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("2_D_ARRAY", "(DEFCLASS 2_D_ARRAY (MULTI-DIMENSIONAL-ARRAY) :DOCUMENTATION \"Two-dimensional arrays with elements of type OBJECT.\" :PARAMETERS ((ANY-VALUE :TYPE OBJECT)) :SLOTS ((NOF-ROWS :TYPE INTEGER :REQUIRED? TRUE) (NOF-COLUMNS :TYPE INTEGER :REQUIRED? TRUE) (THE-ARRAY :TYPE (NATIVE-VECTOR OF (LIKE (ANY-VALUE SELF))))) :INITIALIZER INITIALIZE-2_D_ARRAY :PRINT-FORM (PRINT-ARRAY SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "new2_D_array", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "access2_D_arraySlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.two_D_array"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("FLOAT-VECTOR", "(DEFCLASS FLOAT-VECTOR (ABSTRACT-COLLECTION SEQUENCE-MIXIN) :PARAMETERS ((ANY-VALUE :TYPE FLOAT)) :PUBLIC-SLOTS ((ARRAY-SIZE :TYPE INTEGER :REQUIRED? TRUE)) :SLOTS ((THE-ARRAY :TYPE (NATIVE-VECTOR OF FLOAT-WRAPPER))) :PRINT-FORM (PRINT-VECTOR SELF STREAM) :INITIALIZER INITIALIZE-FLOAT-VECTOR)");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "newFloatVector", new java.lang.Class [] {java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "accessFloatVectorSlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.FloatVector"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
      { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("2_D_FLOAT-ARRAY", "(DEFCLASS 2_D_FLOAT-ARRAY (MULTI-DIMENSIONAL-ARRAY) :DOCUMENTATION \"Two-dimensional arrays with elements of type FLOAT.\" :PARAMETERS ((ANY-VALUE :TYPE FLOAT)) :SLOTS ((NOF-ROWS :TYPE INTEGER :REQUIRED? TRUE) (NOF-COLUMNS :TYPE INTEGER :REQUIRED? TRUE) (THE-ARRAY :TYPE (NATIVE-VECTOR OF FLOAT-WRAPPER))) :INITIALIZER INITIALIZE-2_D_FLOAT-ARRAY :PRINT-FORM (PRINT-ARRAY SELF STREAM))");

        renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "new2_D_floatArray", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE});
        renamed_Class.classSlotAccessorCode = Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "access2_D_floatArraySlotValue", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.two_D_floatArray"), Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE});
      }
    }
  }

  static void helpStartupNeuralNetwork3() {
    {
      Stella.defineFunctionObject("SET-TRACE-NEURAL-NETWORK-TRAINING", "(DEFUN SET-TRACE-NEURAL-NETWORK-TRAINING ((B BOOLEAN)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setTraceNeuralNetworkTraining", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setTraceNeuralNetworkTrainingEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-SAVE-NETWORK-CYCLE", "(DEFUN SET-SAVE-NETWORK-CYCLE ((I INTEGER)) :DOCUMENTATION \"Set number of cycles between which networks are saved to the\nfile established by the last call to `save-all-neural-networks'.  A number <= 0\nor a NULL number turns off periodic saving.\" :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setSaveNetworkCycle", new java.lang.Class [] {java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setSaveNetworkCycleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-ERROR-CUTOFF", "(DEFUN SET-ERROR-CUTOFF ((F FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setErrorCutoff", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setErrorCutoffEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-TRAIN-CACHED-NEURAL-NETWORKS", "(DEFUN SET-TRAIN-CACHED-NEURAL-NETWORKS ((B BOOLEAN)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setTrainCachedNeuralNetworks", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setTrainCachedNeuralNetworksEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-LEARNING-RATE", "(DEFUN SET-LEARNING-RATE ((RATE FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setLearningRate", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setLearningRateEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-MOMENTUM-TERM", "(DEFUN SET-MOMENTUM-TERM ((M FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMomentumTerm", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setMomentumTermEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-WEIGHT-RANGE", "(DEFUN SET-WEIGHT-RANGE ((W FLOAT)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setWeightRange", new java.lang.Class [] {java.lang.Double.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setWeightRangeEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SET-NEURAL-NETWORK-TRAINING-METHOD", "(DEFUN SET-NEURAL-NETWORK-TRAINING-METHOD ((M KEYWORD)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setNeuralNetworkTrainingMethod", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("SET-ERROR-PRINT-CYCLE", "(DEFUN SET-ERROR-PRINT-CYCLE ((I INTEGER)) :DOCUMENTATION \"Set number of cycles between which error rates are saved to\nthe file established by the last call to `save-all-neural-networks' appended\nwith extension `.err'.  A number <= 0 (or NULL) turns off periodic saving.\" :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "setErrorPrintCycle", new java.lang.Class [] {java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "setErrorPrintCycleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DELETE-ALL-NEURAL-NETWORKS", "(DEFUN DELETE-ALL-NEURAL-NETWORKS () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "deleteAllNeuralNetworks", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CHECK-MASTER-NETWORK-LIST", "(DEFUN CHECK-MASTER-NETWORK-LIST () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "checkMasterNetworkList", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CLEAR-ALL-NEURAL-NETWORKS", "(DEFUN CLEAR-ALL-NEURAL-NETWORKS () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearAllNeuralNetworks", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CLEAR-ALL-SLOPES", "(DEFUN CLEAR-ALL-SLOPES ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "clearAllSlopes", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("CLEAR-SLOPES", "(DEFUN CLEAR-SLOPES ((NET PROPOSITION-NEURAL-NETWORK)))", Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "clearSlopes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork")}), null);
      Stella.defineFunctionObject("RANDOMIZE-NEURAL-NETWORK", "(DEFUN RANDOMIZE-NEURAL-NETWORK ((NET PROPOSITION-NEURAL-NETWORK)))", Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "randomizeNeuralNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork")}), null);
      Stella.defineFunctionObject("CREATE-NEURAL-NETWORK", "(DEFUN (CREATE-NEURAL-NETWORK PROPOSITION-NEURAL-NETWORK) ((PROP PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "createNeuralNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("GNP", "(DEFUN (GNP PROPOSITION) ((NAME SYMBOL)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "gnp", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("DEFNETWORK", "(DEFUN (DEFNETWORK PROPOSITION-NEURAL-NETWORK) (|&REST| (ARGS PARSE-TREE)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defnetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "defnetworkEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("DEFINE-NEURAL-NETWORK-FROM-PARSE-TREE", "(DEFUN (DEFINE-NEURAL-NETWORK-FROM-PARSE-TREE PROPOSITION-NEURAL-NETWORK) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "defineNeuralNetworkFromParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ALLOCATE-NEURAL-NETWORK", "(DEFUN (ALLOCATE-NEURAL-NETWORK PROPOSITION-NEURAL-NETWORK) ((NUM-IN INTEGER) (NUM-HIDDEN INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allocateNeuralNetwork", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("ACTIVATE-PROPOSITIONAL-NEURAL-NETWORK", "(DEFUN (ACTIVATE-PROPOSITIONAL-NEURAL-NETWORK FLOAT) ((NET PROPOSITION-NEURAL-NETWORK)))", Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "activatePropositionalNeuralNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork")}), null);
      Stella.defineFunctionObject("MAKE-NET-INPUT-STRING", "(DEFUN (MAKE-NET-INPUT-STRING STRING) ((INPUT WEIGHT-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "makeNetInputString", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("TRAIN-NEURAL-NETWORK", "(DEFUN TRAIN-NEURAL-NETWORK ((CYCLES INTEGER) (NUM-TRAINING INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainNeuralNetwork", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainNeuralNetworkEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TRAIN-UNCACHED-NEURAL-NETWORKS", "(DEFUN TRAIN-UNCACHED-NEURAL-NETWORKS ((CYCLES INTEGER) (NUM-TRAINING INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainUncachedNeuralNetworks", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("BACKPROPAGATE-ERROR", "(DEFUN BACKPROPAGATE-ERROR ((PROP PROPOSITION) (ERROR FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "backpropagateError", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("QUICKPROPAGATE-ERROR", "(DEFUN QUICKPROPAGATE-ERROR ((PROP PROPOSITION) (ERROR FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "quickpropagateError", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-ERROR", "(DEFUN (COMPUTE-ERROR FLOAT) ((TRAINING FLOAT) (OUTPUT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeError", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-DELTA", "(DEFUN (COMPUTE-DELTA FLOAT) ((SLOPE FLOAT) (PREV-SLOPE FLOAT) (PREV-DELTA FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeDelta", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-QP-DELTA", "(DEFUN (COMPUTE-QP-DELTA FLOAT) ((SLOPE FLOAT) (PREV-SLOPE FLOAT) (PREV-DELTA FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "computeQpDelta", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("MODIFY-WEIGHTS", "(DEFUN MODIFY-WEIGHTS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "modifyWeights", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("TEST-OVER-TRAINING-EXAMPLES", "(DEFUN (TEST-OVER-TRAINING-EXAMPLES FLOAT) () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testOverTrainingExamples", new java.lang.Class [] {}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "testOverTrainingExamplesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TRAIN-AND-TEST-NEURAL-NETWORK", "(DEFUN (TRAIN-AND-TEST-NEURAL-NETWORK FLOAT) ((CYCLES INTEGER) (NUM-TRAINING INTEGER) (NUM-TESTING INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainAndTestNeuralNetwork", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainAndTestNeuralNetworkEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TEST-NEURAL-NETWORK", "(DEFUN (TEST-NEURAL-NETWORK FLOAT) () :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "testNeuralNetwork", new java.lang.Class [] {}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "testNeuralNetworkEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("MULTIPLE-NETWORK-TRAINING-RUNS", "(DEFUN (MULTIPLE-NETWORK-TRAINING-RUNS FLOAT) ((RUNS INTEGER) (CYCLES INTEGER) (NUM-TRAINING INTEGER)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "multipleNetworkTrainingRuns", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "multipleNetworkTrainingRunsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("TRAIN-CACHED-NEURAL-NETWORKS", "(DEFUN TRAIN-CACHED-NEURAL-NETWORKS ((CYCLES INTEGER) (NUM-TRAINING INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "trainCachedNeuralNetworks", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CACHED-BACKPROPAGATE-ERROR", "(DEFUN CACHED-BACKPROPAGATE-ERROR ((TREE CONS) (ERROR FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "cachedBackpropagateError", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("CACHED-QUICKPROPAGATE-ERROR", "(DEFUN CACHED-QUICKPROPAGATE-ERROR ((TREE CONS) (ERROR FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "cachedQuickpropagateError", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("CREATE-CACHED-NETWORK", "(DEFUN (CREATE-CACHED-NETWORK CONS) ((CONS-QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createCachedNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("BUILD-NETWORK-TREE", "(DEFUN (BUILD-NETWORK-TREE PARSE-TREE) ((PROP PROPOSITION) (PROP-LIST (CONS OF PROPOSITION))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "buildNetworkTree", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ACTIVATE-CACHED-NETWORK", "(DEFUN (ACTIVATE-CACHED-NETWORK FLOAT) ((TREE (CONS OF CONS))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "activateCachedNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("RANDOM-WEIGHT", "(DEFUN (RANDOM-WEIGHT FLOAT) ((N FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "randomWeight", new java.lang.Class [] {java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("RANDOM-FLOAT", "(DEFUN (RANDOM-FLOAT FLOAT) ((N FLOAT)) :PUBLIC? TRUE :DOCUMENTATION \"Generate a random integer in the interval [0..n-1].\n'n' must be <= 2^15.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "randomFloat", new java.lang.Class [] {java.lang.Double.TYPE}), null);
      Stella.defineFunctionObject("CONS-TO-VECTOR", "(DEFUN (CONS-TO-VECTOR VECTOR) ((FORM CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "consToVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("CREATE-VECTOR", "(DEFUN (CREATE-VECTOR VECTOR) (|&REST| (VALUES OBJECT)) :DOCUMENTATION \"Return a vector containing 'values', in order.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("ZERO-VECTOR", "(DEFUN ZERO-VECTOR ((V WEIGHT-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "zeroVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("STRUCTURED-NEURAL-NETWORK-REGRESSION", "(DEFUN STRUCTURED-NEURAL-NETWORK-REGRESSION ((CLASS-NAME SYMBOL) (SLOT-NAME SYMBOL) (CYCLES INTEGER)) :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "structuredNeuralNetworkRegression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol"), Native.find_java_class("edu.isi.stella.Symbol"), java.lang.Integer.TYPE}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "structuredNeuralNetworkRegressionEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("GET-NN-NEAREST-NEIGHBORS", "(DEFUN (GET-NN-NEAREST-NEIGHBORS (LIST OF TRAINING-EXAMPLE)) ((PROBE TRAINING-EXAMPLE) (CASES (LIST OF TRAINING-EXAMPLE)) (K INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.TrainingExample", "getNnNearestNeighbors", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.TrainingExample"), Native.find_java_class("edu.isi.stella.List"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("SWAP-IN-NEW-NETWORKS", "(DEFUN SWAP-IN-NEW-NETWORKS ((OLD-NETS (LIST OF PROPOSITION-NEURAL-NETWORK)) (NEW-NETS (LIST OF PROPOSITION-NEURAL-NETWORK))) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "swapInNewNetworks", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("SWAP-IN-NETWORK-FILE", "(DEFUN SWAP-IN-NETWORK-FILE ((FILE STRING)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "swapInNetworkFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "swapInNetworkFileEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("LOAD-NEURAL-NETWORK-FILE", "(DEFUN (LOAD-NEURAL-NETWORK-FILE (LIST OF PROPOSITION-NEURAL-NETWORK)) ((FILE STRING)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "loadNeuralNetworkFile", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "loadNeuralNetworkFileEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SAVE-ALL-NEURAL-NETWORKS", "(DEFUN SAVE-ALL-NEURAL-NETWORKS ((FILE STRING)) :DOCUMENTATION \"Save all neural networks to `file' (if `file' is non-NULL).\nIf networks are saved periodically (see `set-save-network-cycle') this file\nname will be used to perform periodic saves.\" :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveAllNeuralNetworks", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveAllNeuralNetworksEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("SAVE-NEURAL-NETWORK", "(DEFUN SAVE-NEURAL-NETWORK ((NET PROPOSITION-NEURAL-NETWORK) (FILE STRING)) :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "saveNeuralNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork"), Native.find_java_class("java.lang.String")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveNeuralNetworkEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("PRINT-NEURAL-NETWORK", "(DEFUN PRINT-NEURAL-NETWORK ((NET PROPOSITION-NEURAL-NETWORK) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PropositionNeuralNetwork", "printNeuralNetwork", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PropositionNeuralNetwork"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("CREATE-HIDDEN-SIGNATURE", "(DEFUN (CREATE-HIDDEN-SIGNATURE WEIGHT-VECTOR) ((CONS-QUERY CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createHiddenSignature", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("INITIALIZE-2_D_ARRAY", "(DEFUN INITIALIZE-2_D_ARRAY ((SELF 2_D_ARRAY)))", Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "initialize2_D_array", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.two_D_array")}), null);
      Stella.defineMethodObject("(DEFMETHOD (2_D_ELEMENT (LIKE (ANY-VALUE SELF))) ((ARRAY 2_D_ARRAY) (ROW INTEGER) (COLUMN INTEGER)) :DOCUMENTATION \"Return the element of `array' at position [`row', `column'].\" :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (NTH (THE-ARRAY ARRAY) (+ (* ROW (NOF-COLUMNS ARRAY)) COLUMN))))", Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "two_D_element", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (2_D_ELEMENT-SETTER (LIKE (ANY-VALUE SELF))) ((ARRAY 2_D_ARRAY) (VALUE OBJECT) (ROW INTEGER) (COLUMN INTEGER)) :DOCUMENTATION \"Set the element of `array' at position [`row', `column']\nto `value' and return the result.\" :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (SETF (NTH (THE-ARRAY ARRAY) (+ (* ROW (NOF-COLUMNS ARRAY)) COLUMN)) VALUE)))", Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "two_D_elementSetter", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CREATE-2_D_ARRAY", "(DEFUN (CREATE-2_D_ARRAY 2_D_ARRAY) ((NOF-ROWS INTEGER) (NOF-COLUMNS INTEGER) |&REST| (VALUES OBJECT)) :DOCUMENTATION \"Create a two-dimensional array with `nof-rows' rows and\n`nof-columns' columns, and initialize it in row-major-order from `values'.\nMissing values will be padded with NULL, extraneous values will be ignored.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "create2_D_array", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineMethodObject("(DEFMETHOD FILL-ARRAY ((SELF 2_D_ARRAY) |&REST| (VALUES OBJECT)) :DOCUMENTATION \"Fill the two-dimensional array `self' in row-major-order\nfrom `values'.  Missing values will retain their old values, extraneous values\nwill be ignored.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "fillArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD PRINT-ARRAY ((SELF 2_D_ARRAY) (STREAM NATIVE-OUTPUT-STREAM)) :DOCUMENTATION \"Print the array `self' to `stream'.\")", Native.find_java_method("edu.isi.powerloom.logic.two_D_array", "printArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), ((java.lang.reflect.Method)(null)));
    }
  }

  public static void startupNeuralNetwork() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupNeuralNetwork.helpStartupNeuralNetwork1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$NEURAL_NETWORK_TRAINING_METHOD$ = Logic.KWD_BACKPROP;
          Logic.$SAVE_NETWORK_FILE$ = null;
          Logic.$SHRINK_FACTOR$ = Logic.$MAX_MOVEMENT$ / (1.0 + Logic.$MAX_MOVEMENT$);
          Logic.$MASTER_NEURAL_NETWORK_LIST$ = List.newList();
          Logic.$ACTIVATED_NETWORKS$ = List.newList();
          Logic.$PARTIAL_SUPPORT_CACHE$ = List.newList();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          _StartupNeuralNetwork.helpStartupNeuralNetwork2();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupNeuralNetwork.helpStartupNeuralNetwork3();
          Stella.defineFunctionObject("INITIALIZE-FLOAT-VECTOR", "(DEFUN INITIALIZE-FLOAT-VECTOR ((SELF FLOAT-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "initializeFloatVector", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.FloatVector")}), null);
          Stella.defineFunctionObject("CREATE-FLOAT-VECTOR", "(DEFUN (CREATE-FLOAT-VECTOR FLOAT-VECTOR) (|&REST| (VALUES FLOAT)) :DOCUMENTATION \"Return a vector containing 'values', in order.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createFloatVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD PRINT-VECTOR ((SELF FLOAT-VECTOR) (STREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "printVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (EMPTY? BOOLEAN) ((SELF FLOAT-VECTOR)) :DOCUMENTATION \"Return TRUE if 'self' has length 0.\" :GLOBALLY-INLINE? TRUE (RETURN (EQL? (ARRAY-SIZE SELF) 0)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "emptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NON-EMPTY? BOOLEAN) ((SELF FLOAT-VECTOR)) :DOCUMENTATION \"Return TRUE if 'self' has length > 0.\" :GLOBALLY-INLINE? TRUE (RETURN (> (ARRAY-SIZE SELF) 0)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "nonEmptyP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NTH FLOAT) ((SELF FLOAT-VECTOR) (POSITION INTEGER)) :GLOBALLY-INLINE? TRUE (RETURN (SAFE-CAST (NTH (THE-ARRAY SELF) POSITION) FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "nth", new java.lang.Class [] {java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (NTH-SETTER FLOAT) ((SELF FLOAT-VECTOR) (VALUE FLOAT) (POSITION INTEGER)) :GLOBALLY-INLINE? TRUE (RETURN (SETF (WRAPPER-VALUE (SAFE-CAST (NTH (THE-ARRAY SELF) POSITION) FLOAT-WRAPPER)) VALUE)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "nthSetter", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (LENGTH INTEGER) ((SELF FLOAT-VECTOR)) :GLOBALLY-INLINE? TRUE (RETURN (ARRAY-SIZE SELF)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "length", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (MEMBER? BOOLEAN) ((SELF FLOAT-VECTOR) (OBJECT FLOAT)))", Native.find_java_method("edu.isi.powerloom.logic.FloatVector", "memberP", new java.lang.Class [] {java.lang.Double.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("INITIALIZE-2_D_FLOAT-ARRAY", "(DEFUN INITIALIZE-2_D_FLOAT-ARRAY ((SELF 2_D_FLOAT-ARRAY)))", Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "initialize2_D_floatArray", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.two_D_floatArray")}), null);
          Stella.defineMethodObject("(DEFMETHOD (2_D_ELEMENT FLOAT) ((ARRAY 2_D_FLOAT-ARRAY) (ROW INTEGER) (COLUMN INTEGER)) :DOCUMENTATION \"Return the element of `array' at position [`row', `column'].\" :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (SAFE-CAST (NTH (THE-ARRAY ARRAY) (+ (* ROW (NOF-COLUMNS ARRAY)) COLUMN)) FLOAT-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "two_D_element", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD (2_D_ELEMENT-SETTER (LIKE (ANY-VALUE SELF))) ((ARRAY 2_D_FLOAT-ARRAY) (VALUE FLOAT) (ROW INTEGER) (COLUMN INTEGER)) :DOCUMENTATION \"Set the element of `array' at position [`row', `column']\nto `value' and return the result.\" :GLOBALLY-INLINE? TRUE :PUBLIC? TRUE (RETURN (SETF (WRAPPER-VALUE (SAFE-CAST (NTH (THE-ARRAY ARRAY) (+ (* ROW (NOF-COLUMNS ARRAY)) COLUMN)) FLOAT-WRAPPER)) VALUE)))", Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "two_D_elementSetter", new java.lang.Class [] {java.lang.Double.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("CREATE-2_D_FLOAT-ARRAY", "(DEFUN (CREATE-2_D_FLOAT-ARRAY 2_D_FLOAT-ARRAY) ((NOF-ROWS INTEGER) (NOF-COLUMNS INTEGER) |&REST| (VALUES FLOAT)) :DOCUMENTATION \"Create a two-dimensional array with `nof-rows' rows and\n`nof-columns' columns, and initialize it in row-major-order from `values'.\nMissing values will be padded with NULL, extraneous values will be ignored.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "create2_D_floatArray", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineMethodObject("(DEFMETHOD FILL-ARRAY ((SELF 2_D_FLOAT-ARRAY) |&REST| (VALUES FLOAT)) :DOCUMENTATION \"Fill the two-dimensional array `self' in row-major-order\nfrom `values'.  Missing values will retain their old values, extraneous values\nwill be ignored.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "fillArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), ((java.lang.reflect.Method)(null)));
          Stella.defineMethodObject("(DEFMETHOD PRINT-ARRAY ((SELF 2_D_FLOAT-ARRAY) (STREAM NATIVE-OUTPUT-STREAM)) :DOCUMENTATION \"Print the array `self' to `stream'.\")", Native.find_java_method("edu.isi.powerloom.logic.two_D_floatArray", "printArray", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), ((java.lang.reflect.Method)(null)));
          Stella.defineFunctionObject("STARTUP-NEURAL-NETWORK", "(DEFUN STARTUP-NEURAL-NETWORK () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupNeuralNetwork", "startupNeuralNetwork", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_NEURAL_NETWORK);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupNeuralNetwork"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *NEURAL-NETWORK-TRAINING-METHOD* KEYWORD :BACKPROP)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LEARNING-RATE* FLOAT 0.1)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MOMENTUM-TERM* FLOAT 0.9)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *WEIGHT-RANGE* FLOAT 0.05)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ERROR-CUTOFF* FLOAT 0.0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ERROR-PRINT-CYCLE* INTEGER 25)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SAVE-NETWORK-CYCLE* INTEGER 10000)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SAVE-NETWORK-FILE* STRING NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRACE-NEURAL-NETWORK-TRAINING* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *TRAIN-CACHED-NETWORKS?* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MAX-MOVEMENT* FLOAT 1.75)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MODE-SWITCH* FLOAT 0.0)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SHRINK-FACTOR* FLOAT (/ *MAX-MOVEMENT* (+ 1.0 *MAX-MOVEMENT*)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *WEIGHT-DECAY* FLOAT -1.0e-4)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SIGMOID-PRIME-OFFSET* FLOAT 0.1)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MASTER-NEURAL-NETWORK-LIST* (LIST OF PROPOSITION-NEURAL-NETWORK) (NEW LIST))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ACTIVATED-NETWORKS* (LIST OF PROPOSITION-NEURAL-NETWORK) (NEW LIST))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SAVED-NET* PROPOSITION-NEURAL-NETWORK NULL)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *PARTIAL-SUPPORT-CACHE* (LIST OF INTEGER-WRAPPER) (NEW LIST))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LEARNING-CURVE* (VECTOR OF FLOAT-WRAPPER) NULL)");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
