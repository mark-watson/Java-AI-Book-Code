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

// Version: StellaSpecialVariable.java,v 1.7 2006/05/11 07:06:51 hans Exp

package edu.isi.stella.javalib;

public class StellaSpecialVariable extends InheritableThreadLocal {
    protected Object defaultValue = null;

    protected Object childValue (Object parentValue) {
	if (parentValue == null) {
	    return defaultValue;
	} else {
	    return parentValue;
	}
    }

    public void setDefaultValue (Object newDefault) {
      // Don't allow a null default to overwrite an existing (possibly
      // non-null default value.
      // This is a bit of a kludge, but it is needed to handle a
      // Stella bootstrap problem where *context* and *module* are
      // set before the normal initialization of global variables.
      // HC 09/02/05: Tom added this guard since he was afraid that the
      // :UNBOUND-SPECIAL-VARIABLE mechanism might go away, but it is
      // here to stay and the check might not be needed anymore - in
      // fact, we might want change things back to null during a reset...
      if (newDefault != null) {
	defaultValue = newDefault;
      }
      // Also set the variable value not just its default which properly
      // supports reset functions such as `reset-kojak' which re-call
      // system startup functions to reset variables, etc. to their initial
      // value.  Not sure whether this might screw things up in threaded
      // environments such as Tomcat - we'll see...
      set(newDefault);
    }

    protected Object initialValue () {
	return defaultValue;
    }
}
