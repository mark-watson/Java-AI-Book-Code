//  -*- Mode: Java -*-
//
// XmlExpressionIterator.java

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

/** Iterator that yields XML expressions from an input stream.
 * If the value of <code>regionTag</code> is non-<code>null</code>, only XML expressions enclosed within
 * matching region tags will be returned (there can be multiple such regions).
 * What is a match is determined by <code>regionMatchFunction</code>.  Usually, region tags
 * will/should be at the top level, but this is not necessarily so and also not
 * enforced by the iterator.
 * @author Stella Java Translator
 */
public class XmlExpressionIterator extends StreamIterator {
    public Cons regionTag;
    public java.lang.reflect.Method regionMatchFunction;
    public XmlDoctype doctype;
    /** Set to <code>true</code> when iterating over a DTD definition.
     */
    public boolean doctypeIteratorP;
    /** The current value of this iterator
     */
    public Stella_Object value;

  public static XmlExpressionIterator newXmlExpressionIterator() {
    { XmlExpressionIterator self = null;

      self = new XmlExpressionIterator();
      self.firstIterationP = true;
      self.value = null;
      self.theStream = null;
      self.doctypeIteratorP = false;
      self.doctype = null;
      self.regionMatchFunction = Native.find_java_method("edu.isi.stella.Cons", "xmlRegionMatchesP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")});
      self.regionTag = null;
      return (self);
    }
  }

  public Cons consify() {
    { XmlExpressionIterator iter = this;

      { Cons value000 = Stella.NIL;

        { Stella_Object item = null;
          XmlExpressionIterator iter000 = iter;
          Cons collect000 = null;

          while (iter000.nextP()) {
            item = iter000.value;
            if (collect000 == null) {
              {
                collect000 = Cons.cons(item, Stella.NIL);
                if (value000 == Stella.NIL) {
                  value000 = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(value000, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(item, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
        { Cons value001 = value000;

          return (value001);
        }
      }
    }
  }

  public boolean nextP() {
    { XmlExpressionIterator self = this;

      { InputStream stream = self.theStream;
        boolean firstiterationP = self.firstIterationP;
        TokenizerToken tokenlist = (firstiterationP ? ((TokenizerToken)(null)) : stream.tokenizerState.tokenList);
        Cons regiontag = self.regionTag;
        String regiontagname = ((regiontag != null) ? ((XmlElement)(regiontag.value)).name : ((String)(null)));
        boolean skiptoregionP = false;
        boolean eofP = false;

        if (firstiterationP) {
          self.firstIterationP = false;
          if (regiontag != null) {
            skiptoregionP = true;
          }
        }
        loop000 : for (;;) {
          { Object [] caller_MV_returnarray = new Object[1];

            tokenlist = InputStream.tokenizeXmlExpression(stream, tokenlist, regiontagname, skiptoregionP, caller_MV_returnarray);
            eofP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
          }
          if (eofP) {
            if ((regiontag != null) &&
                (!skiptoregionP)) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("EOF encountered before the end of the current `" + regiontagname + "' region");
                throw ((ReadException)(ReadException.newReadException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            self.value = null;
            Stream.closeStream(stream);
            self.theStream = null;
            return (false);
          }
          if (tokenlist == null) {
            skiptoregionP = true;
            tokenlist = stream.tokenizerState.tokenList;
            continue loop000;
          }
          if (firstiterationP) {
            stream.tokenizerState.tokenList = tokenlist;
            firstiterationP = false;
          }
          if (skiptoregionP &&
              (regiontag != null)) {
            { TokenizerToken lasttoken = tokenlist;
              boolean emptytagP = false;

              while (lasttoken.next.type != null) {
                lasttoken = lasttoken.next;
              }
              if (lasttoken.type == Stella.KWD_EMPTY_TAG_END) {
                emptytagP = true;
              }
              else {
                lasttoken.type = Stella.KWD_EMPTY_TAG_END;
              }
              if (!((Boolean)(edu.isi.stella.javalib.Native.funcall(self.regionMatchFunction, null, new java.lang.Object [] {self.regionTag, TokenizerToken.xmlTokenListToSExpression(tokenlist, self.doctype, self.doctypeIteratorP)}))).booleanValue()) {
                skiptoregionP = true;
                continue loop000;
              }
              skiptoregionP = false;
              if (emptytagP) {
                regiontag = null;
                regiontagname = null;
                self.regionTag = null;
              }
              continue loop000;
            }
          }
          else {
            { Stella_Object xmlExpression = TokenizerToken.xmlTokenListToSExpression(tokenlist, self.doctype, self.doctypeIteratorP);

              self.value = xmlExpression;
              if ((Stella_Object.isaP(xmlExpression, Stella.SGT_STELLA_CONS) &&
                  Stella_Object.isaP(((Cons)(xmlExpression)).value, Stella.SGT_STELLA_XML_DECLARATION)) &&
                  Stella.stringEqlP(((XmlDeclaration)(((Cons)(xmlExpression)).value)).name, "DOCTYPE")) {
                if (self.doctype != null) {
                  Stella.STANDARD_WARNING.nativeStream.println("Warning: Found a DOCTYPE declaration in an XML-EXPRESSION-ITERATOR that already has a doctype!");
                }
                self.doctype = Cons.processDoctype(((Cons)(xmlExpression)));
              }
            }
            return (true);
          }
        }
      }
    }
  }

  public static Stella_Object accessXmlExpressionIteratorSlotValue(XmlExpressionIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_REGION_TAG) {
      if (setvalueP) {
        self.regionTag = ((Cons)(value));
      }
      else {
        value = self.regionTag;
      }
    }
    else if (slotname == Stella.SYM_STELLA_REGION_MATCH_FUNCTION) {
      if (setvalueP) {
        self.regionMatchFunction = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.regionMatchFunction);
      }
    }
    else if (slotname == Stella.SYM_STELLA_DOCTYPE) {
      if (setvalueP) {
        self.doctype = ((XmlDoctype)(value));
      }
      else {
        value = self.doctype;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DOCTYPE_ITERATORp) {
      if (setvalueP) {
        self.doctypeIteratorP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.doctypeIteratorP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { XmlExpressionIterator self = this;

      return (Stella.SGT_STELLA_XML_EXPRESSION_ITERATOR);
    }
  }

  public void free() {
    { XmlExpressionIterator self = this;

      if (StreamIterator.terminateStreamIteratorP(self)) {
        Stella_Object.unmake(self);
      }
    }
  }

}

