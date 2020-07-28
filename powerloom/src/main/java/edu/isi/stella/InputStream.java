//  -*- Mode: Java -*-
//
// InputStream.java

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

public class InputStream extends Stream {
    public edu.isi.stella.javalib.NativeInputStream nativeStream;
    public OutputStream echoStream;
    public TokenizerStreamState tokenizerState;
    /** One of :CHARACTER, :LINE or :BLOCK indicating what kind of
     * input buffer we are reading from.  This determines what read function to use
     * for tokenization.
     */
    public Keyword bufferingScheme;

  public static InputStream newInputStream() {
    { InputStream self = null;

      self = new InputStream();
      self.state = null;
      self.bufferingScheme = Stella.KWD_LINE;
      self.tokenizerState = null;
      self.echoStream = null;
      self.nativeStream = null;
      return (self);
    }
  }

  public static void substituteTemplateVariablesToStream(InputStream templatestream, OutputStream outputstream, KeyValueList variables) {
    { String line = null;
      LineIterator iter000 = InputStream.lines(templatestream);

      while (iter000.nextP()) {
        line = iter000.value;
        outputstream.nativeStream.println(Stella.substituteTemplateVariablesInString(line, variables));
      }
    }
  }

  /** Return an XML-expression-iterator (which see) reading from
   * <code>stream</code>.  <code>regiontag</code> can be used to define delimited regions from which
   * expressions should be considered. Use s-expression representation to specify
   * <code>regiontag</code>, e.g., '(KIF (:version &quot;1.0&quot;))'.  The tag can be an XML element
   * object, a symbol, a string or a cons.  If the tag is a cons the first element
   * can also be (name namespace) pair.
   * @param stream
   * @param regiontag
   * @return XmlExpressionIterator
   */
  public static XmlExpressionIterator xmlExpressions(InputStream stream, Stella_Object regiontag) {
    { XmlExpressionIterator self000 = XmlExpressionIterator.newXmlExpressionIterator();

      self000.theStream = stream;
      { XmlExpressionIterator iterator = self000;

        if (regiontag != null) {
          if (Stella_Object.safePrimaryType(regiontag) == Stella.SGT_STELLA_CONS) {
            { Cons regiontag000 = ((Cons)(regiontag));

              if (regiontag000 == Stella.NIL) {
              }
              else if (regiontag000.rest == null) {
                iterator.regionTag = Cons.cons(Stella_Object.coerceToXmlElement(regiontag000.value), Cons.cons(Stella.NIL, Stella.NIL));
              }
              else if (regiontag000.rest.rest == null) {
                iterator.regionTag = Cons.cons(Stella_Object.coerceToXmlElement(regiontag000.value), Cons.cons(regiontag000.rest.value, Stella.NIL));
              }
              else {
                iterator.regionTag = Cons.cons(Stella_Object.coerceToXmlElement(regiontag000.value), Cons.cons(regiontag000.rest, Stella.NIL));
              }
            }
          }
          else {
            iterator.regionTag = Cons.cons(Stella_Object.coerceToXmlElement(regiontag), Cons.cons(Stella.NIL, Stella.NIL));
          }
        }
        return (iterator);
      }
    }
  }

  /** Read one balanced XML expression from <code>stream</code> and return
   * its s-expression representation (see <code>xmlTokenListToSExpression</code>).  If
   * <code>startTagName</code> is non-<code>null</code>, skip all tags until a start tag matching <code>startTag</code>
   * is encountered.  XML namespaces are ignored for outside of the start tag.
   * Use s-expression representation to specify <code>startTag</code>, e.g., '(KIF (:version &quot;1.0&quot;))'.
   * The tag can be an XML element object, a symbol, a string or a cons.  If the tag is a cons
   * the first element can also be (name namespace) pair.
   * <p>
   * Return <code>true</code> as the second value on EOF.
   * <p>
   * CHANGE WARNING:  It is anticipated that this function will change to
   *  a) Properly take XML namespaces into account and
   *  b) require XML element objects instead of strings as the second argument.
   * This change will not be backwards-compatible.
   * @param stream
   * @param startTag
   * @param MV_returnarray
   * @return Stella_Object
   */
  public static Stella_Object readXmlExpression(InputStream stream, Stella_Object startTag, Object [] MV_returnarray) {
    { XmlExpressionIterator iter = InputStream.xmlExpressions(stream, startTag);
      Stella_Object result = null;
      boolean eofP = false;

      if (iter.nextP()) {
        result = iter.value;
      }
      else {
        eofP = true;
      }
      if ((stream == Stella.STANDARD_INPUT) ||
          (stream.echoStream != null)) {
        InputStream.eatNextCharacterIfWhitespace(stream);
      }
      { Stella_Object _return_temp = result;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(eofP);
        return (_return_temp);
      }
    }
  }

  public static TokenizerToken tokenizeXmlExpression(InputStream stream, TokenizerToken tokenlist, String regiontagname, boolean skiptoregionP, Object [] MV_returnarray) {
    { int parenbalance = 0;
      String starttag = null;
      String currenttag = null;
      boolean regiontagfoundP = (regiontagname == null) ||
          (!skiptoregionP);
      boolean endoffileP = true;
      Keyword tokentype = null;
      String tokencontent = null;
      TokenizerToken tokencursor = tokenlist;

      if (tokenlist == null) {
        tokenlist = TokenizerToken.newTokenizerToken();
        tokencursor = tokenlist;
      }
      { TokenizerTable tok_table_ = Stella.getXmlTokenizerTable();
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        InputStream tok_inputstream_ = stream;
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
        loop000 : for (;;) {
          {
            tok_tokenstart_ = -1;
            loop001 : for (;;) {
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
                    break loop001;
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
                break loop001;
              }
              if (tok_echostream_ != null) {
                tok_echostream_.nativeStream.print(tok_buffer_[(tok_cursor_ - 1)]);
              }
            }
          }
          if (tok_endoftokensP_) {
            endoffileP = true;
            if (parenbalance == 0) {
              break loop000;
            }
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            throw ((ReadException)(ReadException.newReadException("XML Expression ended prematurely").fillInStackTrace()));
          }
          endoffileP = false;
          tokentype = ((Keyword)(((GeneralizedSymbol)(tok_statenames_[tok_state_]))));
          if (regiontagfoundP) {
          }
          else if ((tokentype == Stella.KWD_START_TAG) &&
              Stella.stringEqlP(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false), regiontagname)) {
            regiontagfoundP = true;
          }
          else {
            continue loop000;
          }
          if ((tokentype == Stella.KWD_START_TAG) ||
              ((tokentype == Stella.KWD_START_PI_TAG) ||
               ((tokentype == Stella.KWD_START_DECLARATION_TAG) ||
                (tokentype == Stella.KWD_START_SPECIAL_TAG)))) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            currenttag = tokencontent;
            if (starttag == null) {
              starttag = tokencontent;
            }
            if (Stella.stringEqlP(tokencontent, starttag)) {
              parenbalance = parenbalance + 1;
            }
          }
          else if (tokentype == Stella.KWD_START_TAG_END) {
            tokencontent = ">";
            if ((regiontagname != null) &&
                skiptoregionP) {
              parenbalance = parenbalance - 1;
            }
            currenttag = null;
          }
          else if ((tokentype == Stella.KWD_END_TAG) ||
              ((tokentype == Stella.KWD_EMPTY_TAG_END) ||
               (tokentype == Stella.KWD_DATA_TAG_END))) {
            if (tokentype == Stella.KWD_END_TAG) {
              tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
              currenttag = tokencontent;
            }
            else {
              tokencontent = ">";
            }
            if (Stella.stringEqlP(currenttag, starttag) ||
                ((regiontagname != null) &&
                 ((!skiptoregionP) &&
                  Stella.stringEqlP(currenttag, regiontagname)))) {
              parenbalance = parenbalance - 1;
            }
            currenttag = null;
          }
          else if (tokentype == Stella.KWD_ATTRIBUTE_NAME) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
          }
          else if ((tokentype == Stella.KWD_QUOTED_ATTRIBUTE_VALUE) ||
              (tokentype == Stella.KWD_QUOTED_DECLARATION_TAG_DATA)) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_ + -1, tok_size_, false);
            tokentype = Stella.KWD_ATTRIBUTE_VALUE;
          }
          else if (tokentype == Stella.KWD_UNQUOTED_ATTRIBUTE_VALUE) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            tokentype = Stella.KWD_ATTRIBUTE_VALUE;
          }
          else if (tokentype == Stella.KWD_PI_TAG_DATA) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_ + -1, tok_size_, false);
          }
          else if ((tokentype == Stella.KWD_DECLARATION_TAG_DATA) ||
              (tokentype == Stella.KWD_DECLARATION_TAG_MARKUP_DATA)) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
          }
          else if (tokentype == Stella.KWD_SPECIAL_TAG_DATA) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_ + -2, tok_size_, false);
          }
          else if (tokentype == Stella.KWD_CONTENT) {
            tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            if (!(((Boolean)(Stella.$XML_PRESERVE_ALL_WHITESPACEp$.get())).booleanValue())) {
              { int cursor = tokencontent.length();

                { int i = Stella.NULL_INTEGER;
                  int iter000 = 0;

                  loop002 : for (;true; iter000 = iter000 + 1) {
                    i = iter000;
                    if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) (tokencontent.charAt((cursor = cursor - 1)))] == Stella.KWD_WHITE_SPACE)) {
                      if (i > 0) {
                        i = 0 - i;
                        tokencontent = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((i < 0) ? (tok_cursor_ + i) : (tok_tokenstart_ + i)), tok_size_, false);
                      }
                      break loop002;
                    }
                  }
                }
              }
            }
          }
          else if (tokentype == Stella.KWD_ERROR) {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Illegal XML syntax: `" + tokencontent + "'");
              throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("Illegal XML syntax: `" + tokencontent + "' in state `" + tokentype + "'");
              throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          tokencursor.type = tokentype;
          tokencursor.content = tokencontent;
          if (tokencursor.next == null) {
            tokencursor.next = TokenizerToken.newTokenizerToken();
          }
          tokencursor = tokencursor.next;
          if (parenbalance == 0) {
            break loop000;
          }
          if (parenbalance < 0) {
            if ((regiontagname != null) &&
                ((!skiptoregionP) &&
                 (Stella.stringEqlP(tokenlist.content, regiontagname) &&
                  (tokenlist.next == tokencursor)))) {
              tokenlist = null;
              break loop000;
            }
            else {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("Unmatched end tag encountered: `" + tokencontent + "'");
                throw ((ReadException)(ReadException.newReadException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
        tokencursor.type = null;
        if (tok_streamstate_ != null) {
          tok_streamstate_.cursor = tok_cursor_;
          tok_streamstate_.table = tok_table_;
          tok_streamstate_.state = tok_state_;
        }
        if (endoffileP) {
          { TokenizerToken _return_temp = null;

            MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
            return (_return_temp);
          }
        }
        else {
          { TokenizerToken _return_temp = tokenlist;

            MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
            return (_return_temp);
          }
        }
      }
    }
  }

  /** Read all of the input from <code>stream</code> and return it as a string.
   * @return String
   */
  public String streamToString() {
    { InputStream from = this;

      { OutputStringStream to = OutputStringStream.newOutputStringStream();

        InputStream.copyStreamToStream(from, to);
        return (to.theStringReader());
      }
    }
  }

  /** Read one character from <code>inputstream</code> and return the result.
   * Return <code>true</code> as the second value on EOF.
   * @param inputstream
   * @param MV_returnarray
   * @return char
   */
  public static char readCharacter(InputStream inputstream, Object [] MV_returnarray) {
    if (inputstream.tokenizerState != null) {
      return (InputStream.readCharacterFromTokenizerBuffer(inputstream, MV_returnarray));
    }
    { edu.isi.stella.javalib.NativeInputStream stream = inputstream.nativeStream;
      OutputStream echostream = inputstream.echoStream;
      char input = Stella.NULL_CHARACTER;
      boolean eof = false;

      Stella_Object[] eofValue = new Stella_Object[1];
    input = Native.readCharacter(stream, eofValue);
    eof = ((BooleanWrapper)(eofValue[0])).wrapperValue
;
      if ((echostream != null) &&
          (!eof)) {
        echostream.nativeStream.print(input);
      }
      { char _return_temp = input;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(eof);
        return (_return_temp);
      }
    }
  }

  /** Read one line from <code>stream</code> and return the result and
   * a keyword that indicates the terminator for that line ending:
   * <code>CCR</code> <code>CLF</code> <code>CCRLF</code> or <code>CEOF</code>.   This is not platform-dependent
   * and differs from <code>readLine</code> by returning a second value.  It
   * may hang when used on interactive streams such as terminal or
   * network streams with only CR line endings.  It should only be
   * used on file or string input streams.
   * @param stream
   * @param MV_returnarray
   * @return String
   */
  public static String readLine2(InputStream stream, Object [] MV_returnarray) {
    { String line = "";

      { TokenizerTable tok_table_ = Stella.$READ_LINE_TOKENIZER_TABLE$;
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        InputStream tok_inputstream_ = stream;
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
        for (;;) {
          {
            tok_tokenstart_ = -1;
            loop001 : for (;;) {
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
                    break loop001;
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
                break loop001;
              }
              if (tok_echostream_ != null) {
                tok_echostream_.nativeStream.print(tok_buffer_[(tok_cursor_ - 1)]);
              }
            }
          }
          if (tok_endoftokensP_) {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            if (Stella.stringEqlP(line, "")) {
              { String _return_temp = null;

                MV_returnarray[0] = Stella.KWD_EOF;
                return (_return_temp);
              }
            }
            else {
              { String _return_temp = line;

                MV_returnarray[0] = Stella.KWD_EOF;
                return (_return_temp);
              }
            }
          }
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

            if (testValue000 == Stella.KWD_LINE) {
              line = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            }
            else if (testValue000 == Stella.KWD_LINEFEED) {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { String _return_temp = line;

                MV_returnarray[0] = Stella.KWD_LF;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.KWD_RETURN_LINEFEED) {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { String _return_temp = line;

                MV_returnarray[0] = Stella.KWD_CRLF;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.KWD_RETURN) {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { String _return_temp = line;

                MV_returnarray[0] = Stella.KWD_CR;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.KWD_ERROR) {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Illegal read syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "'");
                throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
    }
  }

  /** Read one line from <code>stream</code> and return the result.
   * This differs from <code>nativeReadLine</code> in that it is not platform-dependent.
   * It recognizes any of the three common line ending formats: CR, LF, CR-LF
   * in any combination.  It is not as fast as <code>nativeReadLine</code>, however.
   * @param stream
   * @return String
   */
  public static String readLine(InputStream stream) {
    if (stream == Stella.STANDARD_INPUT) {
      return (InputStream.nativeReadLine(stream));
    }
    { TokenizerTable tok_table_ = Stella.$READ_LINE_TOKENIZER_TABLE$;
      String tok_transitions_ = tok_table_.transitions;
      edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
      int tok_tokenstart_ = -1;
      boolean tok_endoftokensP_ = false;
      InputStream tok_inputstream_ = stream;
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
      for (;;) {
        {
          tok_tokenstart_ = -1;
          loop001 : for (;;) {
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
                  break loop001;
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
              break loop001;
            }
            if (tok_echostream_ != null) {
              tok_echostream_.nativeStream.print(tok_buffer_[(tok_cursor_ - 1)]);
            }
          }
        }
        if (tok_endoftokensP_) {
          if (tok_streamstate_ != null) {
            tok_streamstate_.cursor = tok_cursor_;
            tok_streamstate_.table = tok_table_;
            tok_streamstate_.state = tok_state_;
          }
          return (null);
        }
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

          if (testValue000 == Stella.KWD_LINE) {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            return (Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false));
          }
          else if ((testValue000 == Stella.KWD_RETURN) ||
              (testValue000 == Stella.KWD_LINEFEED)) {
          }
          else if ((testValue000 == Stella.KWD_INITIAL_LINEFEED) ||
              (testValue000 == Stella.KWD_INITIAL_RETURN)) {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            return ("");
          }
          else if (testValue000 == Stella.KWD_ERROR) {
            if (tok_streamstate_ != null) {
              tok_streamstate_.cursor = tok_cursor_;
              tok_streamstate_.table = tok_table_;
              tok_streamstate_.state = tok_state_;
            }
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("Illegal read syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "'");
              throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
    }
  }

  /** Read one line from <code>inputstream</code> using the native language
   * readline algorithm and return the result.  On EOF return <code>null</code>
   * @param inputstream
   * @return String
   */
  public static String nativeReadLine(InputStream inputstream) {
    if (inputstream.tokenizerState != null) {
      return (InputStream.readLineFromTokenizerBuffer(inputstream));
    }
    { edu.isi.stella.javalib.NativeInputStream stream = inputstream.nativeStream;
      OutputStream echostream = inputstream.echoStream;
      String input = null;

      input = Native.readLine(stream);
      if ((echostream != null) &&
          (input != null)) {
        echostream.nativeStream.println(input);
      }
      return (input);
    }
  }

  public static boolean consumeWhitespace(InputStream stream) {
    loop000 : for (;;) {
      { char renamed_Char = Stella.NULL_CHARACTER;
        boolean eofP = false;

        { Object [] caller_MV_returnarray = new Object[1];

          renamed_Char = InputStream.readCharacter(stream, caller_MV_returnarray);
          eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        if (eofP) {
          return (true);
        }
        if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Stella.KWD_WHITE_SPACE)) {
          Stella.unreadCharacter(renamed_Char, stream);
          break loop000;
        }
      }
    }
    return (false);
  }

  public static boolean eatNextCharacterIfWhitespace(InputStream stream) {
    { char renamed_Char = Stella.NULL_CHARACTER;
      boolean eofP = false;

      { Object [] caller_MV_returnarray = new Object[1];

        renamed_Char = InputStream.readCharacter(stream, caller_MV_returnarray);
        eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
      }
      if (eofP) {
        return (true);
      }
      if (Stella.$CHARACTER_TYPE_TABLE$[(int) renamed_Char] == Stella.KWD_WHITE_SPACE) {
        { TokenizerStreamState state = stream.tokenizerState;

          if (state != null) {
            state.state = Stella.$STELLA_TOKENIZER_WHITE_SPACE_STATE$;
          }
        }
      }
      else {
        Stella.unreadCharacter(renamed_Char, stream);
      }
      return (false);
    }
  }

  /** Read one STELLA s-expression from <code>stream</code> and return
   * the result.  Return <code>true</code> as the second value on EOF.
   * @param stream
   * @param MV_returnarray
   * @return Stella_Object
   */
  public static Stella_Object readSExpression(InputStream stream, Object [] MV_returnarray) {
    { TokenizerStreamState tokenizerstate = stream.tokenizerState;
      StellaToken tokenlist = ((tokenizerstate != null) ? ((StellaToken)(tokenizerstate.tokenList)) : null);

      if (tokenlist != null) {
        tokenlist = InputStream.tokenizeSExpression(stream, tokenlist);
      }
      else {
        tokenlist = InputStream.tokenizeSExpression(stream, null);
        stream.tokenizerState.tokenList = tokenlist;
      }
      if (tokenlist == null) {
        { Stella_Object _return_temp = null;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      if ((stream == Stella.STANDARD_INPUT) ||
          (stream.echoStream != null)) {
        InputStream.eatNextCharacterIfWhitespace(stream);
      }
      { Stella_Object _return_temp = StellaToken.stellaTokenListToSExpression(tokenlist);

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
        return (_return_temp);
      }
    }
  }

  public static StellaToken tokenizeSExpression(InputStream stream, StellaToken tokenlist) {
    { boolean upcaseP = !((Module)(Stella.$MODULE$.get())).caseSensitiveP;
      int parenbalance = 0;
      boolean endoffileP = true;
      boolean skipclosingquoteP = false;
      StellaToken tokencursor = tokenlist;

      if (tokenlist == null) {
        tokenlist = StellaToken.newStellaToken();
        tokencursor = tokenlist;
      }
      { TokenizerTable tok_table_ = Stella.$STELLA_TOKENIZER_TABLE$;
        String tok_transitions_ = tok_table_.transitions;
        edu.isi.stella.Stella_Object[] tok_statenames_ = tok_table_.stateNames.theArray;
        int tok_tokenstart_ = -1;
        boolean tok_endoftokensP_ = false;
        InputStream tok_inputstream_ = stream;
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
        { edu.isi.stella.Stella_Object[] tok_stellalogicalstatenames_ = Stella.$STELLA_LOGICAL_STATE_NAMES$.theArray;
          Keyword tok_stellalogicalstatename_ = null;

          loop000 : for (;;) {
            {
              {
                tok_tokenstart_ = -1;
                loop001 : for (;;) {
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
                        break loop001;
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
                    break loop001;
                  }
                  if (tok_echostream_ != null) {
                    tok_echostream_.nativeStream.print(tok_buffer_[(tok_cursor_ - 1)]);
                  }
                }
              }
              tok_stellalogicalstatename_ = ((Keyword)(tok_stellalogicalstatenames_[tok_state_]));
            }
            if (tok_endoftokensP_) {
              if (parenbalance == 0) {
                break loop000;
              }
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              throw ((ReadException)(ReadException.newReadException("Expression ended prematurely").fillInStackTrace()));
            }
            endoffileP = false;
            if (!(skipclosingquoteP)) {
              tokencursor.type = ((Keyword)(((GeneralizedSymbol)(tok_statenames_[tok_state_]))));
              tokencursor.logicalTokenType = tok_stellalogicalstatename_;
              tokencursor.module = null;
              tokencursor.escapeMode = null;
            }
            skipclosingquoteP = false;
            if (tok_stellalogicalstatename_ == Stella.KWD_OPEN_PAREN) {
              parenbalance = parenbalance + 1;
              tokencursor.content = "(";
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_CLOSE_PAREN) {
              parenbalance = parenbalance - 1;
              tokencursor.content = ")";
              if (parenbalance < 0) {
                if (tok_streamstate_ != null) {
                  tok_streamstate_.cursor = tok_cursor_;
                  tok_streamstate_.table = tok_table_;
                  tok_streamstate_.state = tok_state_;
                }
                throw ((ReadException)(ReadException.newReadException("Extra right parenthesis encountered").fillInStackTrace()));
              }
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_SYMBOL) {
              { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

                if (testValue000 == Stella.KWD_SYMBOL) {
                  tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, upcaseP);
                }
                else if (testValue000 == Stella.KWD_QUALIFIED_SYMBOL) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_NONE);

                    tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 1, tok_cursor_, tok_size_, upcaseP);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                  }
                }
                else if (testValue000 == Stella.KWD_FULLY_ESCAPED_SYMBOL) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', false);
                  tokencursor.escapeMode = Stella.KWD_FULL;
                  skipclosingquoteP = true;
                }
                else if (testValue000 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SYMBOL) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_FULLY_ESCAPED);

                    tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, false), '\\', false);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                    tokencursor.escapeMode = Stella.KWD_FULL;
                  }
                  skipclosingquoteP = true;
                }
                else if (testValue000 == Stella.KWD_ESCAPED_SYMBOL) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false), '\\', upcaseP);
                  tokencursor.escapeMode = Stella.KWD_PARTIAL;
                }
                else if (testValue000 == Stella.KWD_QUALIFIED_ESCAPED_SYMBOL) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_ESCAPED);

                    tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 1, tok_cursor_, tok_size_, false), '\\', upcaseP);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                    tokencursor.escapeMode = Stella.KWD_PARTIAL;
                  }
                }
                else if (testValue000 == Stella.KWD_CL_SYMBOL) {
                  tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 3, tok_cursor_, tok_size_, true);
                  tokencursor.module = "/COMMON-LISP";
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_SURROGATE) {
              { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

                if (testValue001 == Stella.KWD_SURROGATE) {
                  tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, upcaseP);
                }
                else if (testValue001 == Stella.KWD_QUALIFIED_SURROGATE) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_NONE);

                    tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, upcaseP);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                  }
                }
                else if (testValue001 == Stella.KWD_FULLY_ESCAPED_SURROGATE) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 2, tok_cursor_, tok_size_, false), '\\', false);
                  tokencursor.escapeMode = Stella.KWD_FULL;
                  skipclosingquoteP = true;
                }
                else if (testValue001 == Stella.KWD_QUALIFIED_FULLY_ESCAPED_SURROGATE) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_FULLY_ESCAPED);

                    tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 3, tok_cursor_, tok_size_, false), '\\', false);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                    tokencursor.escapeMode = Stella.KWD_FULL;
                  }
                  skipclosingquoteP = true;
                }
                else if (testValue001 == Stella.KWD_ESCAPED_SURROGATE) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', upcaseP);
                  tokencursor.escapeMode = Stella.KWD_PARTIAL;
                }
                else if (testValue001 == Stella.KWD_QUALIFIED_ESCAPED_SURROGATE) {
                  { int separatorpos = Stella.getQualifiedSymbolSeparatorPositionInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, Stella.KWD_ESCAPED);

                    tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + separatorpos + 2, tok_cursor_, tok_size_, false), '\\', upcaseP);
                    tokencursor.module = ((separatorpos == 0) ? "ROOT-MODULE" : Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, ((separatorpos < 0) ? (tok_cursor_ + separatorpos) : (tok_tokenstart_ + separatorpos)), tok_size_, true));
                    tokencursor.escapeMode = Stella.KWD_PARTIAL;
                  }
                }
                else {
                  { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                    stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_KEYWORD) {
              { GeneralizedSymbol testValue002 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

                if (testValue002 == Stella.KWD_KEYWORD) {
                  tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, true);
                }
                else if (testValue002 == Stella.KWD_FULLY_ESCAPED_KEYWORD) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 2, tok_cursor_, tok_size_, false), '\\', false);
                  tokencursor.escapeMode = Stella.KWD_FULL;
                  skipclosingquoteP = true;
                }
                else if (testValue002 == Stella.KWD_ESCAPED_KEYWORD) {
                  tokencursor.content = Stella.unescapeTokenString(Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false), '\\', true);
                  tokencursor.escapeMode = Stella.KWD_PARTIAL;
                }
                else {
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_STRING) {
              tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_ + 1, tok_cursor_, tok_size_, false);
              { GeneralizedSymbol testValue003 = ((GeneralizedSymbol)(tok_statenames_[tok_state_]));

                if (testValue003 == Stella.KWD_STRING) {
                }
                else if (testValue003 == Stella.KWD_ESCAPED_STRING) {
                  tokencursor.content = Stella.unescapeTokenString(tokencursor.content, '\\', false);
                  tokencursor.escapeMode = Stella.KWD_PARTIAL;
                }
                else {
                  { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                    stream003.nativeStream.print("`" + testValue003 + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              skipclosingquoteP = true;
            }
            else if ((tok_stellalogicalstatename_ == Stella.KWD_INTEGER) ||
                (tok_stellalogicalstatename_ == Stella.KWD_FLOAT)) {
              tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_CHARACTER) {
              { String name = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);

                if (name.length() > 1) {
                  name = Native.stringUpcase(name);
                }
                tokencursor.content = name;
              }
            }
            else if ((tok_stellalogicalstatename_ == Stella.KWD_SINGLE_QUOTE) ||
                ((tok_stellalogicalstatename_ == Stella.KWD_BACK_QUOTE) ||
                 ((tok_stellalogicalstatename_ == Stella.KWD_COMMA) ||
                  (tok_stellalogicalstatename_ == Stella.KWD_COMMA_SPLICE)))) {
              tokencursor.content = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false);
              if (((StellaToken)(tokencursor.next)) == null) {
                tokencursor.next = StellaToken.newStellaToken();
              }
              tokencursor = ((StellaToken)(tokencursor.next));
              continue loop000;
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_QUALIFIED_NAME) {
              { String token = Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, true);
                int length = token.length();

                if ((length >= 1) &&
                    ((token.charAt((length - 1)) == '/') &&
                     ((length == 1) ||
                      (token.charAt((length - 2)) == '/')))) {
                  tokencursor.content = "/";
                  tokencursor.type = Stella.KWD_SYMBOL;
                  tokencursor.logicalTokenType = Stella.KWD_SYMBOL;
                  if (length > 1) {
                    tokencursor.module = Native.string_subsequence(token, 0, length - 2);
                    tokencursor.type = Stella.KWD_QUALIFIED_SYMBOL;
                  }
                }
                else {
                  tokencursor.content = token;
                }
              }
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_CLOSE_BALANCED_QUOTE) {
            }
            else if (tok_stellalogicalstatename_ == Stella.KWD_ERROR) {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                stream004.nativeStream.print("Illegal read syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "'");
                throw ((ReadException)(ReadException.newReadException(stream004.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              if (tok_streamstate_ != null) {
                tok_streamstate_.cursor = tok_cursor_;
                tok_streamstate_.table = tok_table_;
                tok_streamstate_.state = tok_state_;
              }
              { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                stream005.nativeStream.print("Illegal read syntax: `" + Stella.getTokenTextInternal(tok_buffer_, tok_tokenstart_, tok_cursor_, tok_size_, false) + "' in state `" + ((GeneralizedSymbol)(tok_statenames_[tok_state_])) + "'");
                throw ((ReadException)(ReadException.newReadException(stream005.theStringReader()).fillInStackTrace()));
              }
            }
            if (!(skipclosingquoteP)) {
              if (((StellaToken)(tokencursor.next)) == null) {
                tokencursor.next = StellaToken.newStellaToken();
              }
              tokencursor = ((StellaToken)(tokencursor.next));
              if (parenbalance == 0) {
                break loop000;
              }
            }
          }
          tokencursor.type = null;
          tokencursor.logicalTokenType = null;
          if (tok_streamstate_ != null) {
            tok_streamstate_.cursor = tok_cursor_;
            tok_streamstate_.table = tok_table_;
            tok_streamstate_.state = tok_state_;
          }
          if (endoffileP) {
            return (null);
          }
          else {
            return (tokenlist);
          }
        }
      }
    }
  }

  public static String readLineFromTokenizerBuffer(InputStream stream) {
    { OutputStringStream buffer = OutputStringStream.newOutputStringStream();
      String line = null;
      char ch = Stella.NULL_CHARACTER;
      char ch2 = Stella.NULL_CHARACTER;
      boolean eofP = false;
      char newline = Stella.EOL_STRING.charAt(0);

      loop000 : for (;;) {
        { Object [] caller_MV_returnarray = new Object[1];

          ch = InputStream.readCharacterFromTokenizerBuffer(stream, caller_MV_returnarray);
          eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
        }
        if (eofP) {
          line = buffer.theStringReader();
          if (line.length() == 0) {
            line = null;
          }
          else {
            eofP = false;
          }
          break loop000;
        }
        if (ch == newline) {
          if (Stella.EOL_STRING.length() == 2) {
            { Object [] caller_MV_returnarray = new Object[1];

              ch2 = InputStream.readCharacterFromTokenizerBuffer(stream, caller_MV_returnarray);
              eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
            }
            if (eofP) {
              line = buffer.theStringReader();
              if (line.length() == 0) {
                line = null;
              }
              else {
                eofP = false;
              }
              break loop000;
            }
            if (!(ch2 == Stella.EOL_STRING.charAt(1))) {
              buffer.nativeStream.print("" + ch + ch2);
              continue loop000;
            }
          }
          line = buffer.theStringReader();
          break loop000;
        }
        buffer.nativeStream.print(ch);
      }
      return (line);
    }
  }

  public static char readCharacterFromTokenizerBuffer(InputStream stream, Object [] MV_returnarray) {
    { TokenizerStreamState state = stream.tokenizerState;
      int cursor = state.cursor;
      int end = state.end;
      int size = state.bufferSize;
      OutputStream echostream = stream.echoStream;
      char ch = Stella.NULL_CHARACTER;

      if (cursor == end) {
        if (InputStream.readIntoTokenizerBuffer(stream, state, -1)) {
          { char _return_temp = Stella.NULL_CHARACTER;

            MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
            return (_return_temp);
          }
        }
        cursor = state.cursor;
        if (cursor == size) {
          cursor = 0;
        }
      }
      ch = (state.buffer)[cursor];
      if (echostream != null) {
        echostream.nativeStream.print(ch);
      }
      state.cursor = cursor + 1;
      { char _return_temp = ch;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
        return (_return_temp);
      }
    }
  }

  public static boolean readIntoTokenizerBuffer(InputStream stream, TokenizerStreamState state, int currenttokenstart) {
    { int requiredspace = ((state.bufferSize < Stella.$TOKENIZER_INITIAL_BUFFER_SIZE$) ? 1 : (Stella.$TOKENIZER_INITIAL_BUFFER_SIZE$ >> 1));
      char inputchar = Stella.NULL_CHARACTER;
      String inputline = null;
      boolean eofP = false;

      if (!(stream.bufferingScheme == Stella.KWD_BLOCK)) {
        try {
          stream.tokenizerState = null;
          { Keyword testValue000 = stream.bufferingScheme;

            if (testValue000 == Stella.KWD_LINE) {
              inputline = InputStream.nativeReadLine(stream);
              if (inputline == null) {
                inputline = "";
                eofP = true;
              }
              inputline = Native.stringConcatenate(inputline, Stella.EOL_STRING);
            }
            else if (testValue000 == Stella.KWD_CHARACTER) {
              { Object [] caller_MV_returnarray = new Object[1];

                inputchar = InputStream.readCharacter(stream, caller_MV_returnarray);
                eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
              }
              if (eofP) {
                inputline = "";
              }
              else {
                inputline = Native.makeString(1, inputchar);
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }

        } finally {
          stream.tokenizerState = state;
        }
        requiredspace = inputline.length();
      }
      TokenizerStreamState.ensureTokenizerBufferSize(state, currenttokenstart, requiredspace);
      { edu.isi.stella.javalib.NativeInputStream nativestream = stream.nativeStream;
        char[] buffer = state.buffer;
        int size = state.bufferSize;
        int end = state.end;
        int start = -1;

        if (end == size) {
          end = 0;
        }
        if (currenttokenstart < 0) {
          start = 0;
          end = size;
          state.cursor = 0;
        }
        else if (end <= currenttokenstart) {
          start = end;
          end = currenttokenstart;
        }
        else if (end > currenttokenstart) {
          start = end;
          end = size;
        }
        if (inputline != null) {
          end = start;
          { char ch = Stella.NULL_CHARACTER;
            String vector000 = inputline;
            int index000 = 0;
            int length000 = vector000.length();

            for (;index000 < length000; index000 = index000 + 1) {
              ch = vector000.charAt(index000);
              buffer[end] = ch;
              end = end + 1;
              if (end == size) {
                end = 0;
              }
            }
          }
        }
        else {
          end = Stella.nativeByteArrayReadSequence(buffer, nativestream, start, end);
        }
        state.end = end;
        return (eofP ||
            (start == end));
      }
    }
  }

  /** Copy <code>in</code> verbatimely to <code>out</code>.  Does the right thing for binary data.
   * @param in
   * @param out
   */
  public static void copyStreamToStream(InputStream in, OutputStream out) {
    { char[] buffer = new char[Stella.$TOKENIZER_INITIAL_BUFFER_SIZE$];
      int bytesread = 0;

      loop000 : for (;;) {
        bytesread = Stella.nativeByteArrayReadSequence(buffer, in.nativeStream, 0, Stella.$TOKENIZER_INITIAL_BUFFER_SIZE$);
        if (bytesread > 0) {
          Stella.nativeByteArrayWriteSequence(buffer, out.nativeStream, 0, bytesread);
        }
        else {
          OutputStream.flushOutput(out);
          break loop000;
        }
      }
    }
  }

  public static CharacterIterator characters(InputStream stream) {
    { CharacterIterator self000 = CharacterIterator.newCharacterIterator();

      self000.theStream = stream;
      { CharacterIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static LineIterator lines(InputStream stream) {
    { LineIterator self000 = LineIterator.newLineIterator();

      self000.theStream = stream;
      { LineIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static NativeLineIterator nativeLines(InputStream stream) {
    { NativeLineIterator self000 = NativeLineIterator.newNativeLineIterator();

      self000.theStream = stream;
      { NativeLineIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static SExpressionIterator sExpressions(InputStream stream) {
    { SExpressionIterator self000 = SExpressionIterator.newSExpressionIterator();

      self000.theStream = stream;
      { SExpressionIterator value000 = self000;

        return (value000);
      }
    }
  }

  public static boolean terminateInputStreamP(InputStream self) {
    { edu.isi.stella.javalib.NativeInputStream nativeStream = self.nativeStream;

      if (!(nativeStream == null)) {
        try {
        nativeStream.close();
      } catch (java.io.IOException e) {
      throw (InputOutputException) InputOutputException.newInputOutputException("terminateInputStreamP: " + e.getMessage()).fillInStackTrace();
      }
;
      }
      self.nativeStream = null;
      self.state = Stella.KWD_CLOSED;
      return (true);
    }
  }

  public static Stella_Object accessInputStreamSlotValue(InputStream self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_ECHO_STREAM) {
      if (setvalueP) {
        self.echoStream = ((OutputStream)(value));
      }
      else {
        value = self.echoStream;
      }
    }
    else if (slotname == Stella.SYM_STELLA_TOKENIZER_STATE) {
      if (setvalueP) {
        self.tokenizerState = ((TokenizerStreamState)(value));
      }
      else {
        value = self.tokenizerState;
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
    { InputStream self = this;

      return (Stella.SGT_STELLA_INPUT_STREAM);
    }
  }

  public void free() {
    { InputStream self = this;

      if (InputStream.terminateInputStreamP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

