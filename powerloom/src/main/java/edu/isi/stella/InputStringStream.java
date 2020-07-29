//  -*- Mode: Java -*-
//
// InputStringStream.java

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

public class InputStringStream extends InputStream {
    public String theString;

  public static InputStringStream newInputStringStream(String theString) {
    { InputStringStream self = null;

      self = new InputStringStream();
      self.theString = theString;
      self.state = null;
      self.tokenizerState = null;
      self.echoStream = null;
      self.nativeStream = null;
      self.bufferingScheme = Stella.KWD_BLOCK;
      InputStringStream.initializeStringInputStream(self);
      return (self);
    }
  }

  public static boolean terminateStringInputStreamP(InputStringStream self) {
    self.nativeStream = null;
    self.state = Stella.KWD_CLOSED;
    return (true);
  }

  public static void initializeStringInputStream(InputStringStream self) {
    { String string = self.theString;

      self.nativeStream = edu.isi.stella.javalib.NativeStringInputStream.create(string);
    }
  }

  public static Stella_Object accessInputStringStreamSlotValue(InputStringStream self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_STRING) {
      if (setvalueP) {
        self.theString = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.theString);
      }
    }
    else if (slotname == Stella.SYM_STELLA_BUFFERING_SCHEME) {
      if (setvalueP) {
        self.bufferingScheme = ((Keyword)(value));
      }
      else {
        value = self.bufferingScheme;
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
    { InputStringStream self = this;

      return (Stella.SGT_STELLA_INPUT_STRING_STREAM);
    }
  }

  public void free() {
    { InputStringStream self = this;

      if (InputStringStream.terminateStringInputStreamP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

