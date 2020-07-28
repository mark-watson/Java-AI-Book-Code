//  -*- Mode: Java -*-
//
// InputFileStream.java

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

public class InputFileStream extends InputStream {
    public String filename;
    public Keyword ifNotExistsAction;

  public static InputFileStream newInputFileStream(String filename) {
    { InputFileStream self = null;

      self = new InputFileStream();
      self.filename = filename;
      self.state = null;
      self.tokenizerState = null;
      self.echoStream = null;
      self.nativeStream = null;
      self.bufferingScheme = Stella.KWD_BLOCK;
      self.ifNotExistsAction = Stella.KWD_ERROR;
      InputFileStream.initializeFileInputStream(self);
      return (self);
    }
  }

  /** Set the current position of the file input cursor in <code>self</code> to <code>newpos</code>.
   * If <code>self</code> has any tokenizer state associated with it, this will also reset
   * to the start state of the tokenizer table; otherwise, behavior would be
   * unpredictable unless the character class of the new position is exactly the
   * same as the one following the most recent token.
   * @param newpos
   * @return long
   */
  public long streamPositionSetter(long newpos) {
    { InputFileStream self = this;

      { edu.isi.stella.javalib.NativeInputStream nstream = self.nativeStream;
        TokenizerStreamState state = self.tokenizerState;

        if (state != null) {
          { long fileposition = Stella.nativeFileInputStreamPosition(nstream);
            long offset = fileposition - newpos;
            int buffered = 0;

            if (offset > 0) {
              buffered = state.bufferedInputLength();
              if (offset <= buffered) {
                state.cursor = ((int)(Stella.longInteger_mod(state.cursor + (buffered - offset), ((long)(state.bufferSize)))));
                state.reset();
                return (newpos);
              }
            }
            state.clear();
            state.reset();
          }
        }
        Stella.nativeFileInputStreamPositionSetter(nstream, newpos);
        return (newpos);
      }
    }
  }

  /** Return the current position of the file input cursor in <code>self</code>.
   * @return long
   */
  public long streamPosition() {
    { InputFileStream self = this;

      { long position = Stella.nativeFileInputStreamPosition(self.nativeStream);
        TokenizerStreamState state = self.tokenizerState;

        if (state != null) {
          position = position - state.bufferedInputLength();
        }
        return (position);
      }
    }
  }

  public static boolean terminateFileInputStreamP(InputFileStream self) {
    { edu.isi.stella.javalib.NativeInputStream nativeStream = self.nativeStream;

      if (!(nativeStream == null)) {
        try {
          nativeStream.close();
        } catch (java.io.IOException e) {
          throw (InputOutputException) InputOutputException.newInputOutputException("terminateFileInputStreamP: " + e.getMessage()).fillInStackTrace();
        }
;
      }
      self.nativeStream = null;
      self.state = Stella.KWD_CLOSED;
      Stella.$OPEN_FILE_STREAMS$.remove(self);
      return (true);
    }
  }

  public static void initializeFileInputStream(InputFileStream self) {
    if (!(self.filename != null)) {
      return;
    }
    { String filename = Stella.translateLogicalPathname(self.filename);

      { Keyword testValue000 = self.ifNotExistsAction;

        if ((testValue000 == Stella.KWD_ABORT) ||
            (testValue000 == Stella.KWD_PROBE)) {
          if (!(Stella.probeFileP(filename))) {
            return;
          }
        }
        else if (testValue000 == Stella.KWD_ERROR) {
          Stella.ensureFileExists(filename, "initialize-file-input-stream");
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("initialize-file-input-stream: illegal :if-not-exists action: `" + self.ifNotExistsAction + "'");
            throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      self.nativeStream = NativeFileInputStream.open(filename);
      if (self.nativeStream == null) {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("initialize-file-input-stream: Could not open `" + self + "'");
          throw ((InputOutputException)(InputOutputException.newInputOutputException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
      self.state = Stella.KWD_OPEN;
      Stella.$OPEN_FILE_STREAMS$.push(self);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { InputFileStream self = this;

      stream.print("|FIS|'" + self.filename + "'");
    }
  }

  public static Stella_Object accessInputFileStreamSlotValue(InputFileStream self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_FILENAME) {
      if (setvalueP) {
        self.filename = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.filename);
      }
    }
    else if (slotname == Stella.SYM_STELLA_IF_NOT_EXISTS_ACTION) {
      if (setvalueP) {
        self.ifNotExistsAction = ((Keyword)(value));
      }
      else {
        value = self.ifNotExistsAction;
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
    { InputFileStream self = this;

      return (Stella.SGT_STELLA_INPUT_FILE_STREAM);
    }
  }

  public void free() {
    { InputFileStream self = this;

      if (InputFileStream.terminateFileInputStreamP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

