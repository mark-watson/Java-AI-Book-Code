//  -*- Mode: Java -*-
//
// PatternRecord.java

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

/** A pattern record records bookkeeping data used during
 * the processing of a description.
 * @author Stella Java Translator
 */
public class PatternRecord extends StandardObject {
    public ControlFrame controlFrame;
    public Vector variableBindings;
    public IntegerVector unbindingStack;
    public int topUnbindingStackOffset;
    public Description description;
    public Vector externalArguments;
    public BooleanVector booleanVector;
    public Description optimalPattern;
    public List collectionList;

  public static PatternRecord newPatternRecord() {
    { PatternRecord self = null;

      self = new PatternRecord();
      self.collectionList = null;
      self.optimalPattern = null;
      self.booleanVector = null;
      self.externalArguments = null;
      self.description = null;
      self.topUnbindingStackOffset = Stella.NULL_INTEGER;
      self.unbindingStack = null;
      self.variableBindings = null;
      self.controlFrame = null;
      return (self);
    }
  }

  public static boolean terminatePatternRecordP(PatternRecord self) {
    if (self.externalArguments != null) {
      self.externalArguments.free();
    }
    self.optimalPattern = null;
    return (true);
  }

  public static void unbindVariablesBeginningAt(PatternRecord patternrecord, int ubstackoffset) {
    { Vector variablebindingsvector = patternrecord.variableBindings;
      IntegerVector unbindingstack = patternrecord.unbindingStack;

      if (patternrecord.topUnbindingStackOffset < ubstackoffset) {
        return;
      }
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_QUERY_STACKS)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("unbind-variables-beginning-at: UBS= " + ubstackoffset + "  F" + ControlFrame.debugFrameId(patternrecord.controlFrame) + "  #bindings= " + ((patternrecord.topUnbindingStackOffset - ubstackoffset) + 1));
      }
      { int i = Stella.NULL_INTEGER;
        int iter000 = ubstackoffset;
        int upperBound000 = patternrecord.topUnbindingStackOffset;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          (variablebindingsvector.theArray)[(((IntegerWrapper)((unbindingstack.theArray)[i])).wrapperValue)] = null;
          (unbindingstack.theArray)[i] = null;
        }
      }
      patternrecord.topUnbindingStackOffset = ubstackoffset - 1;
    }
  }

  public static void activatePatternRecord(PatternRecord patternrecord, int variablecount) {
    { Vector vector = patternrecord.variableBindings;
      IntegerVector stack = patternrecord.unbindingStack;

      if ((vector != null) &&
          (vector.arraySize >= variablecount)) {
        { int i = Stella.NULL_INTEGER;
          int iter000 = 0;
          int upperBound000 = variablecount - 1;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            (vector.theArray)[i] = null;
            (stack.theArray)[i] = null;
          }
        }
      }
      else {
        {
          patternrecord.variableBindings = Vector.newVector(variablecount);
          patternrecord.unbindingStack = IntegerVector.newIntegerVector(variablecount);
        }
      }
      patternrecord.topUnbindingStackOffset = -1;
      ((QueryIterator)(Logic.$QUERYITERATOR$.get())).currentPatternRecord = patternrecord;
    }
  }

  public static Stella_Object accessPatternRecordSlotValue(PatternRecord self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_CONTROL_FRAME) {
      if (setvalueP) {
        self.controlFrame = ((ControlFrame)(value));
      }
      else {
        value = self.controlFrame;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_VARIABLE_BINDINGS) {
      if (setvalueP) {
        self.variableBindings = ((Vector)(value));
      }
      else {
        value = self.variableBindings;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_UNBINDING_STACK) {
      if (setvalueP) {
        self.unbindingStack = ((IntegerVector)(value));
      }
      else {
        value = self.unbindingStack;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_TOP_UNBINDING_STACK_OFFSET) {
      if (setvalueP) {
        self.topUnbindingStackOffset = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.topUnbindingStackOffset);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_DESCRIPTION) {
      if (setvalueP) {
        self.description = ((Description)(value));
      }
      else {
        value = self.description;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_EXTERNAL_ARGUMENTS) {
      if (setvalueP) {
        self.externalArguments = ((Vector)(value));
      }
      else {
        value = self.externalArguments;
      }
    }
    else if (slotname == Logic.SYM_STELLA_BOOLEAN_VECTOR) {
      if (setvalueP) {
        self.booleanVector = ((BooleanVector)(value));
      }
      else {
        value = self.booleanVector;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_OPTIMAL_PATTERN) {
      if (setvalueP) {
        self.optimalPattern = ((Description)(value));
      }
      else {
        value = self.optimalPattern;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_COLLECTION_LIST) {
      if (setvalueP) {
        self.collectionList = ((List)(value));
      }
      else {
        value = self.collectionList;
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
    { PatternRecord self = this;

      return (Logic.SGT_LOGIC_PATTERN_RECORD);
    }
  }

  public void free() {
    { PatternRecord self = this;

      if (PatternRecord.terminatePatternRecordP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

