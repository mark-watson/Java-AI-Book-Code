//  -*- Mode: Java -*-
//
// ParallelThread.java

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

public class ParallelThread extends StandardObject {
    public ControlFrame topControlFrame;
    public World hypotheticalWorld;
    public Vector variableBindings;
    public IntegerVector unbindingStack;
    public int topUnbindingStackOffset;
    public int priority;
    public Keyword status;

  public static ParallelThread newParallelThread() {
    { ParallelThread self = null;

      self = new ParallelThread();
      self.status = null;
      self.priority = Stella.NULL_INTEGER;
      self.topUnbindingStackOffset = Stella.NULL_INTEGER;
      self.unbindingStack = null;
      self.variableBindings = null;
      self.hypotheticalWorld = null;
      self.topControlFrame = null;
      return (self);
    }
  }

  public static Stella_Object accessParallelThreadSlotValue(ParallelThread self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_TOP_CONTROL_FRAME) {
      if (setvalueP) {
        self.topControlFrame = ((ControlFrame)(value));
      }
      else {
        value = self.topControlFrame;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_HYPOTHETICAL_WORLD) {
      if (setvalueP) {
        self.hypotheticalWorld = ((World)(value));
      }
      else {
        value = self.hypotheticalWorld;
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
    else if (slotname == Logic.SYM_LOGIC_PRIORITY) {
      if (setvalueP) {
        self.priority = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.priority);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_STATUS) {
      if (setvalueP) {
        self.status = ((Keyword)(value));
      }
      else {
        value = self.status;
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
    { ParallelThread self = this;

      return (Logic.SGT_LOGIC_PARALLEL_THREAD);
    }
  }

}

