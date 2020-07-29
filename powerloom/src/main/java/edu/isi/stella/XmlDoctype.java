//  -*- Mode: Java -*-
//
// XmlDoctype.java

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

public class XmlDoctype extends StandardObject {
    public String name;
    public KeyValueList entityTable;
    public KeyValueList parameterEntityTable;

  public static XmlDoctype newXmlDoctype() {
    { XmlDoctype self = null;

      self = new XmlDoctype();
      self.parameterEntityTable = KeyValueList.newKeyValueList();
      self.entityTable = KeyValueList.newKeyValueList();
      self.name = null;
      return (self);
    }
  }

  public static String normalizeAttributeValue(XmlDoctype doctype, String input, boolean peReferenceAllowedP) {
    return (XmlDoctype.decodeXmlString(doctype, input, peReferenceAllowedP));
  }

  public static String decodeXmlString(XmlDoctype doctype, String input, boolean peReferenceAllowedP) {
    { int inputEnd = (peReferenceAllowedP ? (input.length() - 1) : ((int)(Stella.NULL_INTEGER)));
      int referenceStart = (peReferenceAllowedP ? Stella.findReferenceStart(input, 0, inputEnd) : Native.string_position(input, '&', 0));
      String substitution = null;

      if (referenceStart == Stella.NULL_INTEGER) {
        return (input);
      }
      else {
        { OutputStringStream buffer = OutputStringStream.newOutputStringStream();
          int referenceEnd = 0;

          if (!(peReferenceAllowedP)) {
            inputEnd = input.length() - 1;
          }
          while (referenceStart != Stella.NULL_INTEGER) {
            buffer.nativeStream.print(Native.string_subsequence(input, referenceEnd, referenceStart));
            referenceEnd = Native.string_position(input, ';', referenceStart);
            if (!(referenceEnd != Stella.NULL_INTEGER)) {
              System.err.print("Safety violation: Unterminated XML reference");
            }
            referenceEnd = referenceEnd + 1;
            substitution = XmlDoctype.decodeXmlReference(doctype, Native.string_subsequence(input, referenceStart, referenceEnd), peReferenceAllowedP);
            if (substitution == null) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Unrecognized entity reference: `" + Native.string_subsequence(input, referenceStart, referenceEnd) + "'");
                throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              buffer.nativeStream.print(substitution);
            }
            referenceStart = (peReferenceAllowedP ? Stella.findReferenceStart(input, referenceEnd, inputEnd) : Native.string_position(input, '&', referenceEnd));
          }
          if (!(referenceEnd == inputEnd)) {
            buffer.nativeStream.print(Native.string_subsequence(input, referenceEnd, Stella.NULL_INTEGER));
          }
          return (buffer.theStringReader());
        }
      }
    }
  }

  public static String decodeXmlReference(XmlDoctype doctype, String reference, boolean peReferenceAllowedP) {
    if (reference.charAt(0) == '&') {
      if (reference.charAt(1) == '#') {
        return (Stella.decodeXmlCharRef(reference));
      }
      else {
        return (XmlDoctype.decodeXmlEntityRef(doctype, Native.string_subsequence(reference, 1, reference.length() - 1), peReferenceAllowedP));
      }
    }
    else {
      return (XmlDoctype.decodeXmlParameterEntityRef(doctype, Native.string_subsequence(reference, 1, reference.length() - 1), peReferenceAllowedP));
    }
  }

  public static String decodeXmlParameterEntityRef(XmlDoctype doctype, String name, boolean peReferenceAllowedP) {
    if (!(peReferenceAllowedP)) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Illegal XML Parameter Entity Reference: `" + name + "'");
        throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if (doctype == null) {
      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

        stream001.nativeStream.print("Parameter Entity References need a Doctype object: `" + name + "'");
        throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream001.theStringReader()).fillInStackTrace()));
      }
    }
    { String value = ((StringWrapper)(doctype.entityTable.lookup(StringWrapper.wrapString(name)))).wrapperValue;

      if (value != null) {
        return (XmlDoctype.decodeXmlString(doctype, value, peReferenceAllowedP));
      }
      else {
        { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

          stream002.nativeStream.print("No Parameter Entity found to match `" + name + "'");
          throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream002.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static String decodeXmlEntityRef(XmlDoctype doctype, String name, boolean peReferenceAllowedP) {
    { StringWrapper value = null;

      if (doctype != null) {
        value = ((StringWrapper)(doctype.entityTable.lookup(StringWrapper.wrapString(name))));
      }
      if (value == null) {
        value = ((StringWrapper)(Stella.$XML_BASE_ENTITY_TABLE$.lookup(StringWrapper.wrapString(name))));
      }
      if (value == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Couldn't find entity reference for `" + name + "'");
          throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (XmlDoctype.decodeXmlString(doctype, value.wrapperValue, peReferenceAllowedP));
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { XmlDoctype self = this;

      stream.print("<!DOCTYPE " + self.name + ">");
    }
  }

  public static Stella_Object accessXmlDoctypeSlotValue(XmlDoctype self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_NAME) {
      if (setvalueP) {
        self.name = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.name);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ENTITY_TABLE) {
      if (setvalueP) {
        self.entityTable = ((KeyValueList)(value));
      }
      else {
        value = self.entityTable;
      }
    }
    else if (slotname == Stella.SYM_STELLA_PARAMETER_ENTITY_TABLE) {
      if (setvalueP) {
        self.parameterEntityTable = ((KeyValueList)(value));
      }
      else {
        value = self.parameterEntityTable;
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
    { XmlDoctype self = this;

      return (Stella.SGT_STELLA_XML_DOCTYPE);
    }
  }

}

