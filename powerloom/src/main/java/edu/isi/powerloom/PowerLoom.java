//  -*- Mode: Java -*-
//
// PowerLoom.java

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
 | The Original Code is the PowerLoom KR&R System.                            |
 |                                                                            |
 | The Initial Developer of the Original Code is                              |
 | UNIVERSITY OF SOUTHERN CALIFORNIA, INFORMATION SCIENCES INSTITUTE          |
 | 4676 Admiralty Way, Marina Del Rey, California 90292, U.S.A.               |
 |                                                                            |
 | Portions created by the Initial Developer are Copyright (C) 1997-2017      |
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
 +----------------------------- END LICENSE BLOCK ----------------------------+
*/

package edu.isi.powerloom;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;
import edu.isi.powerloom.logic.*;
import edu.isi.powerloom.*;
import edu.isi.powerloom.extensions.*;
import edu.isi.stella.utilities.*;

public class PowerLoom {
  /** List of extension systems that can be loaded
   * dynamically (not yet in C++).
   */
  public static Cons $POWERLOOM_EXTENSION_SYSTEMS$ = null;

  public static Keyword KWD_KEY = null;

  public static Keyword KWD_DOCUMENTATION = null;

  public static Keyword KWD_N_ARGUMENTS = null;

  public static Keyword KWD_HANDLER = null;

  public static Symbol SYM_POWERLOOM_CODE_LOAD_ALL_EXTENSIONS_OPTION_HANDLER = null;

  public static Keyword KWD_ERROR_ACTION = null;

  public static Keyword KWD_ERROR = null;

  public static Symbol SYM_POWERLOOM_CODE_START_POWERLOOM_GUI_OPTION_HANDLER = null;

  public static Keyword KWD_WARN = null;

  public static Keyword KWD_KEY2 = null;

  public static Keyword KWD_PROPERTY = null;

  public static Keyword KWD_VALUE_TYPE = null;

  public static Surrogate SGT_STELLA_BOOLEAN = null;

  public static Keyword KWD_DEFAULT_VALUE = null;

  public static Keyword KWD_KEY3 = null;

  public static Symbol SYM_STELLA_EVAL_OPTION_HANDLER = null;

  public static Symbol SYM_POWERLOOM_CODE_STARTUP_POWERLOOM = null;

  public static Symbol SYM_STELLA_METHOD_STARTUP_CLASSNAME = null;

  public static Symbol SYM_POWERLOOM_CODE_STARTUP_POWERLOOM_SYSTEM = null;

  /** Load and initialize all installed extension systems.
   */
  public static void loadAllExtensionSystems() {
    { StringWrapper system = null;
      Cons iter000 = PowerLoom.$POWERLOOM_EXTENSION_SYSTEMS$;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        system = ((StringWrapper)(iter000.value));
        if (!Stella.systemLoadedOrStartedUpP(Native.stringDowncase(system.wrapperValue))) {
          Stella.STANDARD_OUTPUT.nativeStream.print("Initializing " + StringWrapper.unwrapString(system) + "...");
          try {
            Stella.loadSystem(Native.stringDowncase(system.wrapperValue), Stella.NIL);
          } catch (java.lang.Exception e000) {
            Stella.STANDARD_OUTPUT.nativeStream.print("FAILED");
          }
          Stella.STANDARD_OUTPUT.nativeStream.println();
        }
      }
    }
  }

  /** Load and initialize all installed extension systems.
   * @param option
   * @param value
   */
  public static void loadAllExtensionsOptionHandler(CmdLineOption option, Stella_Object value) {
    {
      option = option;
      value = value;
    }
    PowerLoom.loadAllExtensionSystems();
  }

  /** Start the PowerLoom GUI.
   * @param option
   * @param value
   */
  public static void startPowerloomGuiOptionHandler(CmdLineOption option, Stella_Object value) {
    {
      option = option;
      value = value;
    }
    Stella.setConfigurationProperty("powerloom.runInteractively", Stella.TRUE_WRAPPER, null);
    Logic.startPowerloomGui(Stella.NIL);
  }

  public static void main(String[] arguments) {
    { int count = arguments.length;

      Stella.STANDARD_OUTPUT.nativeStream.println("Initializing STELLA...");
      StartupStellaSystem.startupStellaSystem();
      Stella.STANDARD_OUTPUT.nativeStream.println("Initializing PowerLoom...");
      StartupLogicSystem.startupLogicSystem();
      StartupPowerloomExtensionsSystem.startupPowerloomExtensionsSystem();
      StartupPowerloomSystem.startupPowerloomSystem();
      Stella.string_changeModule("PL-USER");
      Stella.processCommandLineArguments(count, arguments, PowerLoom.KWD_WARN);
      if ((!Stella_Object.eqlP(Stella_Object.getProperty(StringWrapper.wrapString("powerloom.runInteractively"), Stella.NIL), Stella.FALSE_WRAPPER)) &&
          (!Stella_Object.eqlP(Stella_Object.getProperty(StringWrapper.wrapString("stella.showInfoOnly"), Stella.NIL), Stella.TRUE_WRAPPER))) {
        Logic.powerloom();
      }
      HookList.runHooks(Stella.$STELLA_EXIT_HOOKS$, null);
    }
  }

}
