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

// Version: StellaIterator.java,v 1.9 2006/05/11 07:06:50 hans Exp

package edu.isi.stella.javalib;

import edu.isi.stella.Iterator;

/** An Iterator for Stella Iterators.  Accepts a Stella Iterator and allows
 *  access to it using the standard Java Iterator interface.
 *
 *  @author Thomas Russ, USC Information Sciences Institute
 *  @version StellaIterator.java,v 1.4 2002/08/08 19:25:19 tar Exp 
 */
public class StellaIterator implements java.util.Iterator {
  protected edu.isi.stella.Iterator iter;
  protected boolean  moreP;
  

  /** Creates a new Java Iterator that will range over the values in
   *  the Stella Iterator.
   *
   * @param theIter An instance of a Stella Iterator.
   */
  public StellaIterator (edu.isi.stella.Iterator theIter) {
    iter = theIter;
    moreP = iter.nextP();
  }

  /** Tests if more elements are available.
   *
   * @return true if at least one more element is available.
   */
  public boolean hasNext () {
    return moreP;
  }

  /** Returns the next Stella_Object provided by the encapsulated Iterator.
   *
   * @return the next Stella_Object provided by the iterator.
   */
  public Object next () {
    if (moreP) {
      Object element = iter.value;
      moreP = iter.nextP();
      return element;
    } else {
      throw new java.util.NoSuchElementException();
    }
  }

 /** Remove is unsupported for StellaIterators.
   *
   * @throws UnsupportedOperationException
   */
  public void remove () {
    throw new UnsupportedOperationException();
  }

}
