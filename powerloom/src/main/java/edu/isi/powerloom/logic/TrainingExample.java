//  -*- Mode: Java -*-
//
// TrainingExample.java

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

/** A single example of a proposition paired with the score
 *   that should be returned and the module it should be evaluated in.
 * @author Stella Java Translator
 */
public class TrainingExample extends StandardObject {
    public Cons query;
    public Symbol concept;
    public Symbol name;
    public double score;
    public Module module;
    public List inputFeatures;
    public Vector input;
    public Cons facts;
    public Vector nnHidden;
    public Stella_Object output;
    public double temp;
    public Stella_Object cachedSolution;
    public int timestamp;

  public static TrainingExample newTrainingExample() {
    { TrainingExample self = null;

      self = new TrainingExample();
      self.timestamp = Stella.NULL_INTEGER;
      self.cachedSolution = null;
      self.temp = Stella.NULL_FLOAT;
      self.output = null;
      self.nnHidden = null;
      self.facts = null;
      self.input = null;
      self.inputFeatures = null;
      self.module = null;
      self.score = Stella.NULL_FLOAT;
      self.name = null;
      self.concept = null;
      self.query = null;
      return (self);
    }
  }

  public static List getNearestNeighbors(TrainingExample probe, List cases, int k) {
    { List result = List.newList();
      Module currentModule = ((Module)(Stella.$MODULE$.get()));
      Vector neighbors = Vector.newVector(k);
      int farthest = 0;
      double distance = 0.0;
      Vector distances = Vector.newVector(k);

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = k - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (distances.theArray)[i] = (FloatWrapper.wrapFloat(999999.0));
        }
      }
      if (probe.input == null) {
        probe.input = Logic.createInputSignature(probe.query);
      }
      { TrainingExample renamed_Case = null;
        Cons iter001 = cases.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Case = ((TrainingExample)(iter001.value));
          if (renamed_Case.input == null) {
            if (!(renamed_Case.module == null)) {
              renamed_Case.module.changeModule();
            }
            renamed_Case.input = Logic.createInputSignature(renamed_Case.query);
            currentModule.changeModule();
          }
          if (probe.input.length() == 1) {
            probe.input = Logic.createInputSignature(probe.query);
          }
          distance = Logic.hammingDistance(probe.input, renamed_Case.input) + 0.0;
          if (Logic.$PRINT_CASE_DISTANCES$) {
            Stella.STANDARD_OUTPUT.nativeStream.println("  Distance from " + renamed_Case.query.last() + ": " + distance);
          }
          renamed_Case.temp = distance;
          if (distance < ((FloatWrapper)((distances.theArray)[farthest])).wrapperValue) {
            (distances.theArray)[farthest] = (FloatWrapper.wrapFloat(distance));
            (neighbors.theArray)[farthest] = renamed_Case;
            farthest = 0;
            { int j = Stella.NULL_INTEGER;
              int iter002 = 1;
              int upperBound001 = k - 1;

              for (;iter002 <= upperBound001; iter002 = iter002 + 1) {
                j = iter002;
                if (((FloatWrapper)((distances.theArray)[j])).wrapperValue > ((FloatWrapper)((distances.theArray)[farthest])).wrapperValue) {
                  farthest = j;
                }
              }
            }
          }
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter003 = 0;
        int upperBound002 = k - 1;
        Cons collect000 = null;

        for (;iter003 <= upperBound002; iter003 = iter003 + 1) {
          i = iter003;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(((TrainingExample)((neighbors.theArray)[i])), Stella.NIL);
              if (result.theConsList == Stella.NIL) {
                result.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(result.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(((TrainingExample)((neighbors.theArray)[i])), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (result);
    }
  }

  public static List getNnNearestNeighbors(TrainingExample probe, List cases, int k) {
    { List result = List.newList();
      Module currentModule = ((Module)(Stella.$MODULE$.get()));
      Vector neighbors = Vector.newVector(k);
      int farthest = 0;
      double distance = 0.0;
      Vector distances = Vector.newVector(k);

      Logic.shuffleList(cases);
      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = k - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (distances.theArray)[i] = (FloatWrapper.wrapFloat(999999.0));
        }
      }
      probe.nnHidden = Logic.createHiddenSignature(probe.query);
      { TrainingExample renamed_Case = null;
        Cons iter001 = cases.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Case = ((TrainingExample)(iter001.value));
          if (renamed_Case.nnHidden == null) {
            if (renamed_Case.module != null) {
              renamed_Case.module.changeModule();
            }
            if (renamed_Case.nnHidden == null) {
              renamed_Case.nnHidden = Logic.createHiddenSignature(renamed_Case.query);
            }
            currentModule.changeModule();
          }
          distance = Logic.euclideanDistance(probe.nnHidden, renamed_Case.nnHidden) + 0.0;
          if (Logic.$PRINT_CASE_DISTANCES$) {
            Stella.STANDARD_OUTPUT.nativeStream.println("  Distance from " + renamed_Case.query.last() + ": " + distance);
          }
          renamed_Case.temp = distance;
          if (distance < ((FloatWrapper)((distances.theArray)[farthest])).wrapperValue) {
            (distances.theArray)[farthest] = (FloatWrapper.wrapFloat(distance));
            (neighbors.theArray)[farthest] = renamed_Case;
            farthest = 0;
            { int j = Stella.NULL_INTEGER;
              int iter002 = 1;
              int upperBound001 = k - 1;

              for (;iter002 <= upperBound001; iter002 = iter002 + 1) {
                j = iter002;
                if (((FloatWrapper)((distances.theArray)[j])).wrapperValue > ((FloatWrapper)((distances.theArray)[farthest])).wrapperValue) {
                  farthest = j;
                }
              }
            }
          }
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter003 = 0;
        int upperBound002 = k - 1;
        Cons collect000 = null;

        for (;iter003 <= upperBound002; iter003 = iter003 + 1) {
          i = iter003;
          if (((TrainingExample)((neighbors.theArray)[i])) != null) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((TrainingExample)((neighbors.theArray)[i])), Stella.NIL);
                if (result.theConsList == Stella.NIL) {
                  result.theConsList = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(result.theConsList, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((TrainingExample)((neighbors.theArray)[i])), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (result);
    }
  }

  public static void printTrainingExample(TrainingExample example) {
    Stella.STANDARD_OUTPUT.nativeStream.println(example.query + " in " + example.module);
  }

  public static Stella_Object accessTrainingExampleSlotValue(TrainingExample self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_QUERY) {
      if (setvalueP) {
        self.query = ((Cons)(value));
      }
      else {
        value = self.query;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CONCEPT) {
      if (setvalueP) {
        self.concept = ((Symbol)(value));
      }
      else {
        value = self.concept;
      }
    }
    else if (slotname == Logic.SYM_STELLA_NAME) {
      if (setvalueP) {
        self.name = ((Symbol)(value));
      }
      else {
        value = self.name;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_SCORE) {
      if (setvalueP) {
        self.score = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.score);
      }
    }
    else if (slotname == Logic.SYM_STELLA_MODULE) {
      if (setvalueP) {
        self.module = ((Module)(value));
      }
      else {
        value = self.module;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INPUT_FEATURES) {
      if (setvalueP) {
        self.inputFeatures = ((List)(value));
      }
      else {
        value = self.inputFeatures;
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
    else if (slotname == Logic.SYM_LOGIC_FACTS) {
      if (setvalueP) {
        self.facts = ((Cons)(value));
      }
      else {
        value = self.facts;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_NN_HIDDEN) {
      if (setvalueP) {
        self.nnHidden = ((Vector)(value));
      }
      else {
        value = self.nnHidden;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_OUTPUT) {
      if (setvalueP) {
        self.output = value;
      }
      else {
        value = self.output;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TEMP) {
      if (setvalueP) {
        self.temp = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.temp);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CACHED_SOLUTION) {
      if (setvalueP) {
        self.cachedSolution = value;
      }
      else {
        value = self.cachedSolution;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TIMESTAMP) {
      if (setvalueP) {
        self.timestamp = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.timestamp);
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
    { TrainingExample self = this;

      return (Logic.SGT_LOGIC_TRAINING_EXAMPLE);
    }
  }

}

