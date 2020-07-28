//  -*- Mode: Java -*-
//
// TokenizerToken.java

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

public class TokenizerToken extends StandardObject {
    public Keyword type;
    public String content;
    public TokenizerToken next;

  public static TokenizerToken newTokenizerToken() {
    { TokenizerToken self = null;

      self = new TokenizerToken();
      self.next = null;
      self.content = null;
      self.type = null;
      return (self);
    }
  }

  /** Convert the XML <code>tokenlist</code> (using <code>doctype</code> for guidance) into a
   * representative s-expression and return the result.    The <code>doctype</code> argument is
   * currently only used for expansion of entity references.  It can be 'null'.  The
   * flag <code>doctypeDefinitionP</code> should be true only when processing the DTD definition
   * of a DOCTYPE tag, since it enables substitution of parameter entity values.
   * <p>
   * Every XML tag is represented as a cons-list starting with the tag as its header,
   * followed by a possibly empty list of keyword value pairs representing tag attributes,
   * followed by a possibly empty list of content expressions which might themselves
   * be XML expressions.  For example, the expression
   * <p>
   *     &lt;a a1=v1 a2='v2'&gt; foo &lt;b a3=v3/&gt; bar &lt;/a&gt;
   * <p>
   * becomes
   * <p>
   *    (&lt;a&gt; (&lt;a1&gt; &quot;v1&quot; &lt;a2&gt; &quot;v2&quot;) &quot;foo&quot; (&lt;b&gt; (&lt;a3&gt; &quot;v3&quot;)) &quot;bar&quot;)
   * <p>
   * when represented as an s-expression.  The tag names are subtypes of XML-OBJECT
   * such as XML-ELEMENT, XML-LOCAL-ATTRIBUTE, XML-GLOBAL-ATTRIBUTE, etc.
   * ?, ! and [ prefixed tags are encoded as their own subtypes of XML-OBJECT, namely
   * XML-PROCESSING-INSTRUCTION, XML-DECLARATION, XML-SPECIAL, XML-COMMENT, etc.
   * CDATA is an XML-SPECIAL tag with a name of CDATA.
   * <p>
   * The name is available using class accessors.
   * @param tokenlist
   * @param doctype
   * @param doctypeDefinitionP
   * @return Stella_Object
   */
  public static Stella_Object xmlTokenListToSExpression(TokenizerToken tokenlist, XmlDoctype doctype, boolean doctypeDefinitionP) {
    { Cons parsedtree = null;
      Cons parsedtreestack = Stella.NIL;
      Stella_Object parsedtoken = null;
      String tagname = null;
      XmlElement element = null;
      String xmlnsName = null;
      int colonPosition = 0;
      Cons attributelist = Stella.NIL;
      Cons conscell = null;
      Keyword tokentype = null;
      KvCons namespaceTable = Stella.makeNamespaceTable();
      Cons nsStack = Stella.NIL;

      loop000 : for (;;) {
        tokentype = tokenlist.type;
        if (tokentype == Stella.KWD_START_TAG) {
          if (parsedtree != null) {
            parsedtreestack = Cons.cons(parsedtree, parsedtreestack);
          }
          nsStack = Cons.cons(namespaceTable, nsStack);
          parsedtree = Stella.NIL;
          tagname = tokenlist.content;
          tokenlist = tokenlist.next;
          continue loop000;
        }
        else if ((tokentype == Stella.KWD_START_PI_TAG) ||
            ((tokentype == Stella.KWD_START_DECLARATION_TAG) ||
             (tokentype == Stella.KWD_START_SPECIAL_TAG))) {
          if (parsedtree != null) {
            parsedtreestack = Cons.cons(parsedtree, parsedtreestack);
          }
          parsedtree = Stella.NIL;
          tagname = null;
          if (tokentype == Stella.KWD_START_PI_TAG) {
            { XmlProcessingInstruction self000 = XmlProcessingInstruction.newXmlProcessingInstruction();

              self000.name = tokenlist.content;
              self000.surfaceForm = tokenlist.content;
              parsedtoken = self000;
            }
          }
          else if (tokentype == Stella.KWD_START_DECLARATION_TAG) {
            { XmlDeclaration self001 = XmlDeclaration.newXmlDeclaration();

              self001.name = tokenlist.content;
              self001.surfaceForm = tokenlist.content;
              parsedtoken = self001;
            }
          }
          else if (tokentype == Stella.KWD_START_SPECIAL_TAG) {
            { XmlSpecial self002 = XmlSpecial.newXmlSpecial();

              self002.name = tokenlist.content;
              self002.surfaceForm = tokenlist.content;
              parsedtoken = self002;
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + tokentype + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        else if (tokentype == Stella.KWD_START_TAG_END) {
          if (tagname != null) {
            {
              element = Stella.makeXmlElementRespectingNamespace(tagname, namespaceTable);
              conscell = new Cons();
              conscell.value = element;
              conscell.rest = parsedtree;
              parsedtree = conscell;
              parsedtoken = Cons.processAttributeList(attributelist, element, namespaceTable);
            }
          }
          else {
            parsedtoken = ((attributelist == Stella.NIL) ? Stella.NIL : attributelist.reverse());
          }
          attributelist = Stella.NIL;
        }
        else if ((tokentype == Stella.KWD_EMPTY_TAG_END) ||
            (tokentype == Stella.KWD_DATA_TAG_END)) {
          if (tagname != null) {
            {
              element = Stella.makeXmlElementRespectingNamespace(tagname, namespaceTable);
              conscell = new Cons();
              conscell.value = element;
              conscell.rest = parsedtree;
              parsedtree = conscell;
              parsedtoken = Cons.processAttributeList(attributelist, element, namespaceTable);
            }
          }
          else {
            parsedtoken = ((attributelist == Stella.NIL) ? Stella.NIL : attributelist.reverse());
          }
          conscell = new Cons();
          conscell.value = parsedtoken;
          conscell.rest = parsedtree;
          parsedtree = conscell;
          attributelist = Stella.NIL;
          tagname = null;
          if (parsedtreestack == Stella.NIL) {
            parsedtree = parsedtree.reverse();
            break loop000;
          }
          else {
            if (tokentype == Stella.KWD_EMPTY_TAG_END) {
              namespaceTable = ((KvCons)(nsStack.value));
              nsStack = nsStack.rest;
            }
            { Cons parenttree = parsedtreestack;

              parsedtreestack = parsedtreestack.rest;
              parenttree.rest = ((Cons)(parenttree.value));
              parenttree.firstSetter(parsedtree.reverse());
              parsedtree = parenttree;
              tokenlist = tokenlist.next;
              continue loop000;
            }
          }
        }
        else if (tokentype == Stella.KWD_END_TAG) {
          if (parsedtreestack == Stella.NIL) {
            parsedtree = parsedtree.reverse();
            break loop000;
          }
          else {
            namespaceTable = ((KvCons)(nsStack.value));
            nsStack = nsStack.rest;
            { Cons parenttree = parsedtreestack;

              parsedtreestack = parsedtreestack.rest;
              parenttree.rest = ((Cons)(parenttree.value));
              parenttree.firstSetter(parsedtree.reverse());
              parsedtree = parenttree;
              tokenlist = tokenlist.next;
              continue loop000;
            }
          }
        }
        else if (tokentype == Stella.KWD_CONTENT) {
          parsedtoken = new StringWrapper();
          ((StringWrapper)(parsedtoken)).wrapperValue = XmlDoctype.decodeXmlString(doctype, tokenlist.content, doctypeDefinitionP);
        }
        else if (tokentype == Stella.KWD_ATTRIBUTE_NAME) {
          conscell = new Cons();
          conscell.value = tokenlist;
          conscell.rest = attributelist;
          attributelist = conscell;
          if (Stella.xmlnsAttributeNameP(tokenlist.content)) {
            xmlnsName = XmlDoctype.decodeXmlString(doctype, tokenlist.content, doctypeDefinitionP);
            tokenlist = tokenlist.next;
            if (!(tokenlist.type == Stella.KWD_ATTRIBUTE_VALUE)) {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("Illegal XMLNS syntax, namespace value is `" + tokenlist.content + "' of type `" + tokenlist.type + "'");
                throw ((ReadException)(ReadException.newReadException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
            colonPosition = Native.string_position(xmlnsName, ':', 0);
            { String namespaceValue = XmlDoctype.normalizeAttributeValue(doctype, tokenlist.content, doctypeDefinitionP);

              if (colonPosition != Stella.NULL_INTEGER) {
                namespaceTable = KvCons.kvCons(StringWrapper.wrapString(Native.string_subsequence(xmlnsName, colonPosition + 1, Stella.NULL_INTEGER)), StringWrapper.wrapString(namespaceValue), namespaceTable);
              }
              else if (Stella.stringEqlP(namespaceValue, "")) {
                namespaceTable = KvCons.kvCons(StringWrapper.wrapString(""), null, namespaceTable);
              }
              else {
                namespaceTable = KvCons.kvCons(StringWrapper.wrapString(""), StringWrapper.wrapString(namespaceValue), namespaceTable);
              }
              parsedtoken = new StringWrapper();
              ((StringWrapper)(parsedtoken)).wrapperValue = namespaceValue;
              conscell = new Cons();
              conscell.value = parsedtoken;
              conscell.rest = attributelist;
              attributelist = conscell;
            }
          }
          tokenlist = tokenlist.next;
          continue loop000;
        }
        else if ((tokentype == Stella.KWD_ATTRIBUTE_VALUE) ||
            (tokentype == Stella.KWD_DECLARATION_TAG_DATA)) {
          parsedtoken = new StringWrapper();
          ((StringWrapper)(parsedtoken)).wrapperValue = XmlDoctype.normalizeAttributeValue(doctype, tokenlist.content, doctypeDefinitionP);
          conscell = new Cons();
          conscell.value = parsedtoken;
          conscell.rest = attributelist;
          attributelist = conscell;
          tokenlist = tokenlist.next;
          continue loop000;
        }
        else if ((tokentype == Stella.KWD_PI_TAG_DATA) ||
            ((tokentype == Stella.KWD_SPECIAL_TAG_DATA) ||
             (tokentype == Stella.KWD_DECLARATION_TAG_MARKUP_DATA))) {
          parsedtoken = new StringWrapper();
          ((StringWrapper)(parsedtoken)).wrapperValue = tokenlist.content;
          conscell = new Cons();
          conscell.value = parsedtoken;
          conscell.rest = attributelist;
          attributelist = conscell;
          tokenlist = tokenlist.next;
          continue loop000;
        }
        else {
          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

            stream002.nativeStream.print("Illegal XML syntax: `" + tokenlist.content + "' of type `" + tokentype + "'");
            throw ((ReadException)(ReadException.newReadException(stream002.theStringReader()).fillInStackTrace()));
          }
        }
        if (parsedtree != null) {
          conscell = new Cons();
          conscell.value = parsedtoken;
          conscell.rest = parsedtree;
          parsedtree = conscell;
          tokenlist = tokenlist.next;
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

  public static Stella_Object accessTokenizerTokenSlotValue(TokenizerToken self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_TYPE) {
      if (setvalueP) {
        self.type = ((Keyword)(value));
      }
      else {
        value = self.type;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CONTENT) {
      if (setvalueP) {
        self.content = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.content);
      }
    }
    else if (slotname == Stella.SYM_STELLA_NEXT) {
      if (setvalueP) {
        self.next = ((TokenizerToken)(value));
      }
      else {
        value = self.next;
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
    { TokenizerToken self = this;

      return (Stella.SGT_STELLA_TOKENIZER_TOKEN);
    }
  }

}

