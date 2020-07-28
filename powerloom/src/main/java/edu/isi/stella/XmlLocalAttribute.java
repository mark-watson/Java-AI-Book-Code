//  -*- Mode: Java -*-
//
// XmlLocalAttribute.java

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

public class XmlLocalAttribute extends XmlAttribute {
    public XmlElement parentElement;

  public static XmlLocalAttribute newXmlLocalAttribute() {
    { XmlLocalAttribute self = null;

      self = new XmlLocalAttribute();
      self.surfaceForm = null;
      self.name = null;
      self.parentElement = null;
      return (self);
    }
  }

  /** Return true if <code>attribute</code> is a local attribute with <code>name</code> and whose
   * parent element matches <code>elementName</code> and <code>elementNamespace</code>.
   * @param attribute
   * @param name
   * @param elementName
   * @param elementNamespace
   * @return boolean
   */
  public static boolean xmlLocalAttributeMatchP(XmlLocalAttribute attribute, String name, String elementName, String elementNamespace) {
    return (Stella.stringEqlP(attribute.name, name) &&
        (Stella.stringEqlP(attribute.parentElement.name, elementName) &&
         Stella.stringEqlP(attribute.parentElement.namespaceUri, elementNamespace)));
  }

  /** Return <code>true</code> if <code>attribute</code> is a local XML attribute with name <code>name</code>.
   * Note that <code>namespace</code> must be <code>null</code> and that the <code>attribute</code>s parent element
   * element is not considered by the match.  To take the parent element into
   * account use <code>xmlLocalAttributeMatchP</code>.
   * @param name
   * @param namespace
   * @return boolean
   */
  public boolean xmlAttributeMatchP(String name, String namespace) {
    { XmlLocalAttribute attribute = this;

      return ((namespace == null) &&
          Stella.stringEqlP(attribute.name, name));
    }
  }

  public static Stella_Object accessXmlLocalAttributeSlotValue(XmlLocalAttribute self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PARENT_ELEMENT) {
      if (setvalueP) {
        self.parentElement = ((XmlElement)(value));
      }
      else {
        value = self.parentElement;
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
    { XmlLocalAttribute self = this;

      return (Stella.SGT_STELLA_XML_LOCAL_ATTRIBUTE);
    }
  }

}

