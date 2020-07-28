//  -*- Mode: Java -*-
//
// StreamTokenizer.java

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

/** Iterator that generates tokens by tokenizing a <code>stream</code>
 * according to a particular tokenization <code>table</code>.
 * @author Stella Java Translator
 */
public class StreamTokenizer extends Iterator {
    public InputStream stream;
    public TokenizerTable table;

  public static StreamTokenizer newStreamTokenizer(InputStream stream, TokenizerTable table) {
    { StreamTokenizer self = null;

      self = new StreamTokenizer();
      self.stream = stream;
      self.table = table;
      self.firstIterationP = true;
      self.value = null;
      return (self);
    }
  }

  public boolean nextP() {
    { StreamTokenizer self = this;

      { TokenizerTable tok_table_ = self.table;
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        InputStream tok_inputstream_ = self.stream;
        OutputStream tok_echostream_ = tok_inputstream_.echoStream;
        TokenizerStreamState tok_streamstate_ = ((tok_inputstream_.tokenizerState == null) ? (tok_inputstream_.tokenizerState = TokenizerStreamState.newTokenizerStreamState()) : tok_inputstream_.tokenizerState);
        char[] tok_buffer_ = tok_streamstate_.buffer;
        int tok_size_ = tok_streamstate_.bufferSize;
        int tok_state_ = tok_streamstate_.getSavedState(tok_table_);
        int tok_nextstate_ = tok_state_;
        int tok_cursor_ = tok_streamstate_.cursor;
        int tok_end_ = tok_streamstate_.end;
        int tok_checkpoint_ = ((tok_cursor_ <= tok_end_) ? tok_end_ : tok_size_);

        {
          tok_statenames_ = tok_statenames_;
          tok_endoftokensP_ = tok_endoftokensP_;
        }
        {
          tok_tokenstart_ = -1;
          loop000 : for (;;) {
            if (tok_cursor_ == tok_checkpoint_) {
              if (tok_cursor_ == tok_end_) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_endoftokensP_ = InputStream.readIntoTokenizerBuffer(tok_inputstream_, tok_streamstate_, tok_tokenstart_);
                tok_buffer_ = tok_streamstate_.buffer;
                tok_size_ = tok_streamstate_.bufferSize;
                tok_cursor_ = Stella.integer_mod(tok_streamstate_.cursor, tok_size_);
                tok_end_ = tok_streamstate_.end;
                if (tok_endoftokensP_) {
                  tok_checkpoint_ = tok_cursor_;
                  if (tok_nextstate_ == -1) {
                  }
                  else if (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)((tok_table_.legalEofStates.theArray)[tok_state_])))) {
                    tok_nextstate_ = -1;
                    if (!(tok_tokenstart_ == -1)) {
                      tok_endoftokensP_ = false;
                    }
                  }
                  else {
                    tok_endoftokensP_ = false;
                    tok_state_ = 0;
                    tok_nextstate_ = -1;
                  }
                  break loop000;
                }
                if (tok_cursor_ >= tok_end_) {
                  tok_checkpoint_ = tok_size_;
                }
                else {
                  tok_checkpoint_ = tok_end_;
                }
              }
              else {
                tok_checkpoint_ = tok_end_;
                tok_cursor_ = 0;
              }
            }
            tok_nextstate_ = (int) (tok_buffer_[tok_cursor_]);
            tok_nextstate_ = (int) (tok_transitions_.charAt(((((tok_state_ << 8)) | tok_nextstate_))));
            if ((tok_nextstate_ & 128) == 0) {
              tok_state_ = tok_nextstate_;
              tok_cursor_ = tok_cursor_ + 1;
            }
            else if (tok_tokenstart_ == -1) {
              if ((tok_nextstate_ & 64) == 0) {
                tok_tokenstart_ = tok_cursor_;
              }
              tok_state_ = (tok_nextstate_ & 63);
              tok_cursor_ = tok_cursor_ + 1;
            }
            else {
              break loop000;
            }
            if (tok_echostream_ != null) {
              tok_echostream_.nativeStream.print(tok_buffer_[(tok_cursor_ - 1)]);
            }
          }
          if (tok_streamstate_ != null) {
            tok_streamstate_.cursor = tok_cursor_;
            tok_streamstate_.table = tok_table_;
            tok_streamstate_.state = tok_state_;
          }
        }
        if (tok_endoftokensP_) {
          self.value = null;
        }
        else {
          { TokenizerToken self002 = TokenizerToken.newTokenizerToken();

            self002.type = ((Keyword)(((GeneralizedSymbol)(tok_statenames_[tok_state_]))));
            self002.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            self.value = self002;
          }
        }
      }
      return (((TokenizerToken)(self.value)) != null);
    }
  }

  public static Stella_Object accessStreamTokenizerSlotValue(StreamTokenizer self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_STREAM) {
      if (setvalueP) {
        self.stream = ((InputStream)(value));
      }
      else {
        value = self.stream;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TABLE) {
      if (setvalueP) {
        self.table = ((TokenizerTable)(value));
      }
      else {
        value = self.table;
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
    { StreamTokenizer self = this;

      return (Stella.SGT_STELLA_STREAM_TOKENIZER);
    }
  }

}

