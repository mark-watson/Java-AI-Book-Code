//  -*- Mode: Java -*-
//
// PropositionNeuralNetwork.java

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

public class PropositionNeuralNetwork extends StandardObject {
    public Proposition proposition;
    public Vector input;
    public Vector hidden;
    public double output;
    public Vector inputError;
    public Vector hiddenError;
    public two_D_array ih;
    public two_D_array ihDelta;
    public Vector ho;
    public Vector hoDelta;
    public two_D_array ihSlope;
    public two_D_array ihPrevSlope;
    public Vector hoSlope;
    public Vector hoPrevSlope;

  public static PropositionNeuralNetwork newPropositionNeuralNetwork() {
    { PropositionNeuralNetwork self = null;

      self = new PropositionNeuralNetwork();
      self.hoPrevSlope = null;
      self.hoSlope = null;
      self.ihPrevSlope = null;
      self.ihSlope = null;
      self.hoDelta = null;
      self.ho = null;
      self.ihDelta = null;
      self.ih = null;
      self.hiddenError = null;
      self.inputError = null;
      self.output = Stella.NULL_FLOAT;
      self.hidden = null;
      self.input = null;
      self.proposition = null;
      return (self);
    }
  }

  public static void printNeuralNetwork(PropositionNeuralNetwork net, OutputStream stream) {
    stream.nativeStream.println("defnetwork ");
    Proposition.printProposition(net.proposition, stream, false);
    stream.nativeStream.println();
    stream.nativeStream.println(net.input.length() + " " + net.hidden.length());
    { int i = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = net.input.length() - 1;

      for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        i = iter000;
        { int j = Stella.NULL_INTEGER;
          int iter001 = 0;
          int upperBound001 = net.hidden.length() - 1;

          for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
            j = iter001;
            { double value = ((FloatWrapper)((net.ih.theArray)[((i * net.ih.nofColumns) + j)])).wrapperValue;

              stream.nativeStream.print(" " + value);
            }
          }
        }
      }
    }
    stream.nativeStream.println();
    { FloatWrapper num = null;
      Vector vector000 = net.ho;
      int index000 = 0;
      int length000 = vector000.length();

      for (;index000 < length000; index000 = index000 + 1) {
        num = ((FloatWrapper)((vector000.theArray)[index000]));
        { double value = num.wrapperValue;

          stream.nativeStream.print(" " + value);
        }
      }
    }
    stream.nativeStream.println();
  }

  public static void saveNeuralNetwork(PropositionNeuralNetwork net, String file) {
    { OutputFileStream fptr = OutputFileStream.newOutputFileStream(file);

      PropositionNeuralNetwork.printNeuralNetwork(net, fptr);
      fptr.free();
    }
  }

  public static double activatePropositionalNeuralNetwork(PropositionNeuralNetwork net) {
    { int numIn = net.input.length();
      int numHidden = net.hidden.length();
      Vector arguments = net.proposition.arguments;
      int stop = numIn - 1;
      Vector input = net.input;
      Vector hidden = net.hidden;
      two_D_array ih = net.ih;
      Vector ho = net.ho;
      double score = 0.0;
      double sum = 0.0;

      Logic.$ACTIVATED_NETWORKS$.push(net);
      (net.input.theArray)[0] = (FloatWrapper.wrapFloat(1.0));
      { int i = Stella.NULL_INTEGER;
        int iter000 = 1;
        int upperBound000 = stop;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          if (((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)((arguments.theArray)[(i - 1)])).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue != Stella.NULL_FLOAT) {
            (input.theArray)[i] = (FloatWrapper.wrapFloat(((FloatWrapper)(KeyValueList.dynamicSlotValue(((Proposition)((arguments.theArray)[(i - 1)])).dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, Stella.NULL_FLOAT_WRAPPER))).wrapperValue));
          }
          else {
            (input.theArray)[i] = (FloatWrapper.wrapFloat(0.0));
          }
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter001 = 0;
        int upperBound001 = numHidden - 1;

        for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
          i = iter001;
          { int j = Stella.NULL_INTEGER;
            int iter002 = 0;
            int upperBound002 = stop;
            boolean unboundedP001 = upperBound002 == Stella.NULL_INTEGER;

            for (;unboundedP001 ||
                      (iter002 <= upperBound002); iter002 = iter002 + 1) {
              j = iter002;
              sum = sum + (((FloatWrapper)((input.theArray)[j])).wrapperValue * ((FloatWrapper)((ih.theArray)[((j * ih.nofColumns) + i)])).wrapperValue);
            }
          }
          (hidden.theArray)[i] = (FloatWrapper.wrapFloat(1.0 / (1.0 + Math.exp((0 - sum)))));
          score = score + (((FloatWrapper)((hidden.theArray)[i])).wrapperValue * ((FloatWrapper)((ho.theArray)[i])).wrapperValue);
        }
      }
      if ((1.0 + Math.exp((0 - score))) == 0.0) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Sum is " + score);
      }
      net.output = 1.0 / (1.0 + Math.exp((0 - score)));
      KeyValueList.setDynamicSlotValue(net.proposition.dynamicSlots, Logic.SYM_LOGIC_MATCH_SCORE, FloatWrapper.wrapFloat(net.output), Stella.NULL_FLOAT_WRAPPER);
      return (net.output);
    }
  }

  public static void randomizeNeuralNetwork(PropositionNeuralNetwork net) {
    { int numIn = net.input.length();
      int numHidden = net.hidden.length();

      { int h = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = numHidden - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          h = iter000;
          (net.hoDelta.theArray)[h] = (FloatWrapper.wrapFloat(0.0));
          { int i = Stella.NULL_INTEGER;
            int iter001 = 0;
            int upperBound001 = numIn - 1;

            for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
              i = iter001;
              (net.ihDelta.theArray)[((i * net.ihDelta.nofColumns) + h)] = (FloatWrapper.wrapFloat(0.0));
            }
          }
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter002 = 0;
        int upperBound002 = numHidden - 1;

        for (;iter002 <= upperBound002; iter002 = iter002 + 1) {
          i = iter002;
          { int j = Stella.NULL_INTEGER;
            int iter003 = 0;
            int upperBound003 = numIn - 1;

            for (;iter003 <= upperBound003; iter003 = iter003 + 1) {
              j = iter003;
              (net.ih.theArray)[((j * net.ih.nofColumns) + i)] = (FloatWrapper.wrapFloat(Logic.randomWeight(Logic.$WEIGHT_RANGE$)));
            }
          }
          (net.ho.theArray)[i] = (FloatWrapper.wrapFloat(Logic.randomWeight(Logic.$WEIGHT_RANGE$)));
        }
      }
    }
  }

  public static void clearSlopes(PropositionNeuralNetwork net) {
    { int h = Stella.NULL_INTEGER;
      int iter000 = 0;
      int upperBound000 = net.hidden.length() - 1;

      for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
        h = iter000;
        { int i = Stella.NULL_INTEGER;
          int iter001 = 0;
          int upperBound001 = net.input.length() - 1;

          for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
            i = iter001;
            (net.ihPrevSlope.theArray)[((i * net.ihPrevSlope.nofColumns) + h)] = (((FloatWrapper)((net.ihSlope.theArray)[((i * net.ihSlope.nofColumns) + h)])));
            (net.ihSlope.theArray)[((i * net.ihSlope.nofColumns) + h)] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.ih.theArray)[((i * net.ih.nofColumns) + h)])).wrapperValue * Logic.$WEIGHT_DECAY$));
          }
        }
        (net.hoPrevSlope.theArray)[h] = (((FloatWrapper)((net.hoSlope.theArray)[h])));
        (net.hoSlope.theArray)[h] = (FloatWrapper.wrapFloat(((FloatWrapper)((net.ho.theArray)[h])).wrapperValue * Logic.$WEIGHT_DECAY$));
      }
    }
  }

  public static Stella_Object accessPropositionNeuralNetworkSlotValue(PropositionNeuralNetwork self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_PROPOSITION) {
      if (setvalueP) {
        self.proposition = ((Proposition)(value));
      }
      else {
        value = self.proposition;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INPUT) {
      if (setvalueP) {
        self.input = ((Vector)(value));
      }
      else {
        value = self.input;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HIDDEN) {
      if (setvalueP) {
        self.hidden = ((Vector)(value));
      }
      else {
        value = self.hidden;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_OUTPUT) {
      if (setvalueP) {
        self.output = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.output);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INPUT_ERROR) {
      if (setvalueP) {
        self.inputError = ((Vector)(value));
      }
      else {
        value = self.inputError;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HIDDEN_ERROR) {
      if (setvalueP) {
        self.hiddenError = ((Vector)(value));
      }
      else {
        value = self.hiddenError;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_IH) {
      if (setvalueP) {
        self.ih = ((two_D_array)(value));
      }
      else {
        value = self.ih;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_IH_DELTA) {
      if (setvalueP) {
        self.ihDelta = ((two_D_array)(value));
      }
      else {
        value = self.ihDelta;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HO) {
      if (setvalueP) {
        self.ho = ((Vector)(value));
      }
      else {
        value = self.ho;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HO_DELTA) {
      if (setvalueP) {
        self.hoDelta = ((Vector)(value));
      }
      else {
        value = self.hoDelta;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_IH_SLOPE) {
      if (setvalueP) {
        self.ihSlope = ((two_D_array)(value));
      }
      else {
        value = self.ihSlope;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_IH_PREV_SLOPE) {
      if (setvalueP) {
        self.ihPrevSlope = ((two_D_array)(value));
      }
      else {
        value = self.ihPrevSlope;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HO_SLOPE) {
      if (setvalueP) {
        self.hoSlope = ((Vector)(value));
      }
      else {
        value = self.hoSlope;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HO_PREV_SLOPE) {
      if (setvalueP) {
        self.hoPrevSlope = ((Vector)(value));
      }
      else {
        value = self.hoPrevSlope;
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
    { PropositionNeuralNetwork self = this;

      return (Logic.SGT_LOGIC_PROPOSITION_NEURAL_NETWORK);
    }
  }

}

