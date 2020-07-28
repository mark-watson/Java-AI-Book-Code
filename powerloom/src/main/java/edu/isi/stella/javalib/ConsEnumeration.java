// -*- Mode: Java -*-

/*--------------------------- BEGIN LICENSE BLOCK ---------------------------+
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
| Portions created by the Initial Developer are Copyright (C) 1996-2006      |
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
+---------------------------- END LICENSE BLOCK ----------------------------*/

// Version: ConsEnumeration.java,v 1.10 2006/05/11 07:06:45 hans Exp

package edu.isi.stella.javalib;

import edu.isi.stella.Cons;

/** An Enumeration for Stells Conses.  This class allows iteration over
 *  a Stella Cons using the java.util.Enumeration interface.
 *
 *  @author Thomas Russ, USC Information Sciences Institute
 *  @version ConsEnumeration.java,v 1.5 2001/10/03 02:08:50 hans Exp 
 */
public class ConsEnumeration implements java.util.Enumeration {
  protected Cons cons;

  /** Creates a new Enumeration that will range over the values in
   *  the Stella Cons.
   *
   * @param theCons An instance of a Stella Cons.
   */
  public ConsEnumeration (Cons theCons) {
    cons = theCons;
  }

  /** Tests if more elements are available.
   *
   * @return true if at least one more element is available.
   */
  public boolean hasMoreElements () {
    return cons.nonEmptyP();
  }

  /** Returns the next Stella_Object contained in the Cons.
   *
   * @return the next Stella_Object in the Cons.
   */
  public Object nextElement () {
    if (cons.emptyP()) {
      throw new java.util.NoSuchElementException();
    } else {
      Object obj = cons.value;
      cons = cons.rest;
      return obj;
    }
  }
}
