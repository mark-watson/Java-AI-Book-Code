//  -*- Mode: Java -*-
//
// DecodedTimeDuration.java

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
| Portions created by the Initial Developer are Copyright (C) 1996-2017      |
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

package edu.isi.stella;

import edu.isi.stella.javalib.*;

/** A data structure for holding decoded time duration values with
 * fields for easy access of the components.  Note that all non-zero values
 * should have the same sign.
 * @author Stella Java Translator
 */
public class DecodedTimeDuration extends StandardObject {
    public double durationMillis;
    public int durationSeconds;
    public int durationMinutes;
    public int durationHours;
    public int durationDays;

  public static DecodedTimeDuration newDecodedTimeDuration() {
    { DecodedTimeDuration self = null;

      self = new DecodedTimeDuration();
      self.durationDays = 0;
      self.durationHours = 0;
      self.durationMinutes = 0;
      self.durationSeconds = 0;
      self.durationMillis = 0.0;
      return (self);
    }
  }

  public TimeDuration encodeTimeDuration() {
    { DecodedTimeDuration timeStructure = this;

      return (TimeDuration.makeTimeDuration(timeStructure.durationDays, ((int)((timeStructure.durationHours * Stella.MILLIS_PER_HOUR) + (timeStructure.durationMinutes * 60000) + (timeStructure.durationSeconds * 1000) + timeStructure.durationMillis))));
    }
  }

  public int hashCode_() {
    { DecodedTimeDuration self = this;

      return (((self.durationDays) ^ (((((((self.durationHours) << 12)) | (((self.durationMinutes) << 6)))) | (self.durationSeconds)))));
    }
  }

  public static Stella_Object accessDecodedTimeDurationSlotValue(DecodedTimeDuration self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_DURATION_MILLIS) {
      if (setvalueP) {
        self.durationMillis = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.durationMillis);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DURATION_SECONDS) {
      if (setvalueP) {
        self.durationSeconds = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.durationSeconds);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DURATION_MINUTES) {
      if (setvalueP) {
        self.durationMinutes = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.durationMinutes);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DURATION_HOURS) {
      if (setvalueP) {
        self.durationHours = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.durationHours);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DURATION_DAYS) {
      if (setvalueP) {
        self.durationDays = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.durationDays);
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
    { DecodedTimeDuration self = this;

      return (Stella.SGT_STELLA_DECODED_TIME_DURATION);
    }
  }

}

