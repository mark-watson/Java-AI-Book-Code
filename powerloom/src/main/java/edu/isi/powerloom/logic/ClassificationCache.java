//  -*- Mode: Java -*-
//
// ClassificationCache.java

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

/** Records various kinds of data about a description
 * during a classification session.
 * @author Stella Java Translator
 */
public class ClassificationCache extends StandardObject {
    public List inferableDirectSubdescriptions;
    public int cacheUpclassificationTimestamp;
    public int cacheDownclassificationTimestamp;
    public int introductionTimestamp;

  public static ClassificationCache newClassificationCache() {
    { ClassificationCache self = null;

      self = new ClassificationCache();
      self.introductionTimestamp = 0;
      self.cacheDownclassificationTimestamp = -1;
      self.cacheUpclassificationTimestamp = -1;
      self.inferableDirectSubdescriptions = null;
      return (self);
    }
  }

  public static Stella_Object accessClassificationCacheSlotValue(ClassificationCache self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_INFERABLE_DIRECT_SUBDESCRIPTIONS) {
      if (setvalueP) {
        self.inferableDirectSubdescriptions = ((List)(value));
      }
      else {
        value = self.inferableDirectSubdescriptions;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CACHE_UPCLASSIFICATION_TIMESTAMP) {
      if (setvalueP) {
        self.cacheUpclassificationTimestamp = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.cacheUpclassificationTimestamp);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_CACHE_DOWNCLASSIFICATION_TIMESTAMP) {
      if (setvalueP) {
        self.cacheDownclassificationTimestamp = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.cacheDownclassificationTimestamp);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_INTRODUCTION_TIMESTAMP) {
      if (setvalueP) {
        self.introductionTimestamp = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.introductionTimestamp);
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
    { ClassificationCache self = this;

      return (Logic.SGT_LOGIC_CLASSIFICATION_CACHE);
    }
  }

}

