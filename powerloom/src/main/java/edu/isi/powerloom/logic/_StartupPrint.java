//  -*- Mode: Java -*-
//
// _StartupPrint.java

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

package edu.isi.powerloom.logic;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.stella.*;

public class _StartupPrint {
  public static void startupPrint() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          Logic.KWD_DEBUG_LOW = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUG-LOW", null, 2)));
          Logic.KWD_DEBUG_HIGH = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEBUG-HIGH", null, 2)));
          Logic.SYM_LOGIC_STARTUP_PRINT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-PRINT", null, 0)));
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$PRINTMODE$.setDefaultValue(Logic.KWD_FLAT);
          Logic.$PRINTFUNCTIONSASRELATIONSp$.setDefaultValue(new Boolean(false));
          Logic.$SKOLEMNAMEMAPPINGTABLE$.setDefaultValue(null);
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("WRAP-NATIVE-OUTPUT-STREAM", "(DEFUN (WRAP-NATIVE-OUTPUT-STREAM OUTPUT-STREAM) ((NATIVESTREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "wrapNativeOutputStream", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("PRINT-TOP-LEVEL-OBJECT", "(DEFUN PRINT-TOP-LEVEL-OBJECT ((SELF OBJECT) (NATIVESTREAM NATIVE-OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printTopLevelObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.javalib.NativeOutputStream")}), null);
          Stella.defineFunctionObject("PRINT-LOGIC-OBJECT", "(DEFUN PRINT-LOGIC-OBJECT ((SELF LOGIC-OBJECT) (STREAM OUTPUT-STREAM) (TOPLEVEL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "printLogicObject", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-SKOLEM-PRINT-NAME", "(DEFUN (GET-SKOLEM-PRINT-NAME STRING) ((SELF SKOLEM)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "getSkolemPrintName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem")}), null);
          Stella.defineFunctionObject("PRINT-VALUE-OF-CHAIN", "(DEFUN PRINT-VALUE-OF-CHAIN ((SELF SKOLEM) (STREAM OUTPUT-STREAM) (CHAINEND OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "printValueOfChain", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("PRINT-SKOLEM-NAME", "(DEFUN PRINT-SKOLEM-NAME ((SELF SKOLEM) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "printSkolemName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-VARIABLE-NAME", "(DEFUN PRINT-VARIABLE-NAME ((SELF PATTERN-VARIABLE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "printVariableName", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-VARIABLE-VALUE", "(DEFUN PRINT-VARIABLE-VALUE ((SELF OBJECT) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printVariableValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-SKOLEM", "(DEFUN PRINT-SKOLEM ((SELF SKOLEM) (STREAM OUTPUT-STREAM) (TOPLEVEL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "printSkolem", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("PRINT-VARIABLE", "(DEFUN PRINT-VARIABLE ((SELF PATTERN-VARIABLE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "printVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-QUANTIFIED-VARIABLE", "(DEFUN PRINT-QUANTIFIED-VARIABLE ((SELF PATTERN-VARIABLE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "printQuantifiedVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
          Stella.defineFunctionObject("PRINT-PROPOSITION", "(DEFUN PRINT-PROPOSITION ((SELF PROPOSITION) (STREAM OUTPUT-STREAM) (TOPLEVEL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("PRINT-DESCRIPTION", "(DEFUN PRINT-DESCRIPTION ((SELF DESCRIPTION) (STREAM OUTPUT-STREAM) (TOPLEVEL? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "printDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-PRINT", "(DEFUN STARTUP-PRINT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupPrint", "startupPrint", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_PRINT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupPrint"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEBUG-PRINT-MODE?* BOOLEAN FALSE :DOCUMENTATION \"If set to TRUE, modify printing so that it\ndoesn't break and is more informative during a debugging session.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRINTMODE* KEYWORD :FLAT :DOCUMENTATION \"Controls the kind of detail that gets printed about\nindividual objects.  Values are :ORIGINAL, :REALISTIC, :FLAT, :DEBUG-LOW, and\n :DEBUG-HIGH.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRINTFUNCTIONSASRELATIONS?* BOOLEAN FALSE :DOCUMENTATION \"Controls whether functions are printed as relations (F i v) or\nas functions (= (F i) v).\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT VARIABLE-BINDING-SEPARATOR STRING \"/\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT VALUE-OF-SEPARATOR STRING \"//\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SKOLEMNAMEMAPPINGTABLE* (ENTITY-MAPPING OF SKOLEM SKOLEM) NULL :DOCUMENTATION \"If set, maps some skolems to names other than\ntheir own.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
