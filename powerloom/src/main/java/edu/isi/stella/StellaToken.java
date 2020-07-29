//  -*- Mode: Java -*-
//
// StellaToken.java

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

public class StellaToken extends TokenizerToken {
    public Keyword logicalTokenType;
    public String module;
    public Keyword escapeMode;

  public static StellaToken newStellaToken() {
    { StellaToken self = null;

      self = new StellaToken();
      self.content = null;
      self.type = null;
      self.next = null;
      self.escapeMode = null;
      self.module = null;
      self.logicalTokenType = null;
      return (self);
    }
  }

  public static void expandQuoteMacroToken(StellaToken quotedlist) {
    { String quotestring = quotedlist.content;

      { StellaToken self000 = StellaToken.newStellaToken();

        self000.type = Stella.KWD_SYMBOL;
        self000.logicalTokenType = Stella.KWD_SYMBOL;
        self000.content = (Stella.stringEqlP(quotestring, "'") ? "QUOTE" : "BQUOTE");
        self000.module = "/STELLA";
        self000.next = ((StellaToken)(quotedlist.next));
        { StellaToken token = self000;
          Keyword tokentype = null;
          int balance = 0;

          quotedlist.type = Stella.KWD_OPEN_PAREN;
          quotedlist.logicalTokenType = Stella.KWD_OPEN_PAREN;
          quotedlist.content = "(";
          quotedlist.next = token;
          quotedlist = ((StellaToken)(token.next));
          loop000 : for (;;) {
            tokentype = quotedlist.logicalTokenType;
            if (tokentype == null) {
              break loop000;
            }
            if (tokentype == Stella.KWD_OPEN_PAREN) {
              balance = balance + 1;
            }
            else if (tokentype == Stella.KWD_CLOSE_PAREN) {
              balance = balance - 1;
              if (balance == 0) {
                break loop000;
              }
              else if (balance < 0) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("Illegal `" + quotestring + "' syntax");
                  throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else {
              if (balance == 0) {
                break loop000;
              }
            }
            quotedlist = ((StellaToken)(quotedlist.next));
          }
          if (tokentype == null) {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("EOF encountered while parsing `" + quotestring + "' syntax");
              throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          { StellaToken self005 = StellaToken.newStellaToken();

            self005.type = Stella.KWD_CLOSE_PAREN;
            self005.logicalTokenType = Stella.KWD_CLOSE_PAREN;
            self005.content = ")";
            self005.next = ((StellaToken)(quotedlist.next));
            token = self005;
          }
          quotedlist.next = token;
        }
      }
    }
  }

  public static Stella_Object stellaTokenListToSExpression(StellaToken tokenlist) {
    { Cons parsedtree = null;
      Cons parsedtreestack = Stella.NIL;
      Stella_Object parsedtoken = null;
      Cons conscell = null;
      Keyword tokentype = null;

      loop000 : for (;;) {
        tokentype = tokenlist.logicalTokenType;
        if (tokentype == Stella.KWD_OPEN_PAREN) {
          if (parsedtree != null) {
            parsedtreestack = Cons.cons(parsedtree, parsedtreestack);
          }
          parsedtree = Stella.NIL;
          tokenlist = ((StellaToken)(tokenlist.next));
          continue loop000;
        }
        else if (tokentype == Stella.KWD_CLOSE_PAREN) {
          if (parsedtreestack == Stella.NIL) {
            parsedtree = parsedtree.reverse();
            break loop000;
          }
          else {
            { Cons parenttree = parsedtreestack;

              parsedtreestack = parsedtreestack.rest;
              parenttree.rest = ((Cons)(parenttree.value));
              parenttree.firstSetter(parsedtree.reverse());
              parsedtree = parenttree;
              tokenlist = ((StellaToken)(tokenlist.next));
              continue loop000;
            }
          }
        }
        else if ((tokentype == Stella.KWD_SYMBOL) ||
            (tokentype == Stella.KWD_SURROGATE)) {
          { String modulename = tokenlist.module;
            String name = tokenlist.content;
            Module module = ((modulename != null) ? Stella.getStellaModule(modulename, false) : ((Module)(Stella.$MODULE$.get())));

            if (module == null) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Module `" + modulename + "' does not exist; current token=`" + name + "'");
                throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else if (tokentype == Stella.KWD_SURROGATE) {
              parsedtoken = Surrogate.internSurrogateInModule(name, module, false);
            }
            else {
              parsedtoken = ((((Boolean)(Stella.$TRANSIENTOBJECTSp$.get())).booleanValue() &&
                  (modulename == null)) ? Stella.internTransientSymbol(name) : Symbol.internSymbolInModule(name, module, false));
            }
          }
        }
        else if (tokentype == Stella.KWD_KEYWORD) {
          parsedtoken = GeneralizedSymbol.internRigidSymbolWrtModule(tokenlist.content, null, Stella.KEYWORD_SYM);
        }
        else if (tokentype == Stella.KWD_STRING) {
          parsedtoken = new StringWrapper();
          ((StringWrapper)(parsedtoken)).wrapperValue = tokenlist.content;
        }
        else if (tokentype == Stella.KWD_INTEGER) {
          parsedtoken = Stella.wrapIntegerValue(Native.stringToInteger(tokenlist.content));
        }
        else if (tokentype == Stella.KWD_FLOAT) {
          parsedtoken = new FloatWrapper();
          ((FloatWrapper)(parsedtoken)).wrapperValue = Native.stringToFloat(tokenlist.content);
        }
        else if (tokentype == Stella.KWD_CHARACTER) {
          parsedtoken = new CharacterWrapper();
          ((CharacterWrapper)(parsedtoken)).wrapperValue = Stella.stringToCharacter(tokenlist.content);
        }
        else if (tokentype == Stella.KWD_COMMA) {
          parsedtoken = Stella.SYM_STELLA_a;
        }
        else if (tokentype == Stella.KWD_COMMA_SPLICE) {
          parsedtoken = Stella.SYM_STELLA_aa;
        }
        else if ((tokentype == Stella.KWD_SINGLE_QUOTE) ||
            (tokentype == Stella.KWD_BACK_QUOTE)) {
          StellaToken.expandQuoteMacroToken(tokenlist);
          continue loop000;
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("Illegal read syntax: `" + tokenlist.content + "' of type `" + tokentype + "'");
            throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
        if (parsedtree != null) {
          conscell = new Cons();
          conscell.value = parsedtoken;
          conscell.rest = parsedtree;
          parsedtree = conscell;
          tokenlist = ((StellaToken)(tokenlist.next));
        }
        else {
          break loop000;
        }
      }
      if (parsedtree == null) {
        return (parsedtoken);
      }
      else {
        return (parsedtree);
      }
    }
  }

  public static Stella_Object accessStellaTokenSlotValue(StellaToken self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_LOGICAL_TOKEN_TYPE) {
      if (setvalueP) {
        self.logicalTokenType = ((Keyword)(value));
      }
      else {
        value = self.logicalTokenType;
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE) {
      if (setvalueP) {
        self.module = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.module);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ESCAPE_MODE) {
      if (setvalueP) {
        self.escapeMode = ((Keyword)(value));
      }
      else {
        value = self.escapeMode;
      }
    }
    else if (slotname == Stella.SYM_STELLA_NEXT) {
      if (setvalueP) {
        self.next = ((StellaToken)(value));
      }
      else {
        value = ((StellaToken)(self.next));
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
    { StellaToken self = this;

      return (Stella.SGT_STELLA_STELLA_TOKEN);
    }
  }

}

