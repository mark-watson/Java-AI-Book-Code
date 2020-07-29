//  -*- Mode: Java -*-
//
// XmlElement.java

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

public class XmlElement extends XmlObject {
    public String namespaceName;
    public String namespaceUri;
    public KeyValueList elementDictionary;

  public static XmlElement newXmlElement() {
    { XmlElement self = null;

      self = new XmlElement();
      self.surfaceForm = null;
      self.name = null;
      self.elementDictionary = null;
      self.namespaceUri = null;
      self.namespaceName = null;
      return (self);
    }
  }

  /** Returns <code>true</code> if <code>tag</code> is an XML element with the name <code>name</code>
   * in namespace <code>namespace</code>.  Note that <code>namespace</code> is the full URI, not an abbreviation.
   * Also, <code>namespace</code> may be <code>null</code>, in which case <code>tag</code> must not have a namespace
   * associated with it.
   * @param name
   * @param namespace
   * @return boolean
   */
  public boolean xmlElementMatchP(String name, String namespace) {
    { XmlElement tag = this;

      return (Stella.stringEqlP(tag.name, name) &&
          Stella.stringEqlP(tag.namespaceUri, namespace));
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { XmlElement self = this;

      stream.print("<" + self.surfaceForm + ">");
    }
  }

  public static Stella_Object accessXmlElementSlotValue(XmlElement self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_NAMESPACE_NAME) {
      if (setvalueP) {
        self.namespaceName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.namespaceName);
      }
    }
    else if (slotname == Stella.SYM_STELLA_NAMESPACE_URI) {
      if (setvalueP) {
        self.namespaceUri = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.namespaceUri);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ELEMENT_DICTIONARY) {
      if (setvalueP) {
        self.elementDictionary = ((KeyValueList)(value));
      }
      else {
        value = self.elementDictionary;
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
    { XmlElement self = this;

      return (Stella.SGT_STELLA_XML_ELEMENT);
    }
  }

}

