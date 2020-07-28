//  -*- Mode: Java -*-
//
// _StartupDescriptions.java

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

public class _StartupDescriptions {
  static void helpStartupDescriptions1() {
    {
      Logic.SGT_STELLA_METHOD_SLOT = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("METHOD-SLOT", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_STELLA_ANY_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ANY-VALUE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_pX1 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X1", null, 0)));
      Logic.SYM_LOGIC_pX2 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X2", null, 0)));
      Logic.SYM_LOGIC_pX3 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X3", null, 0)));
      Logic.SYM_LOGIC_pX4 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X4", null, 0)));
      Logic.SYM_LOGIC_pX5 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X5", null, 0)));
      Logic.SYM_LOGIC_pX6 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X6", null, 0)));
      Logic.SYM_LOGIC_pX7 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X7", null, 0)));
      Logic.SYM_LOGIC_pX8 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X8", null, 0)));
      Logic.SYM_LOGIC_pX9 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X9", null, 0)));
      Logic.SYM_LOGIC_pX10 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X10", null, 0)));
      Logic.SYM_LOGIC_pX11 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X11", null, 0)));
      Logic.SYM_LOGIC_pX12 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X12", null, 0)));
      Logic.SYM_LOGIC_pX13 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X13", null, 0)));
      Logic.SYM_LOGIC_pX14 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X14", null, 0)));
      Logic.SYM_LOGIC_pX15 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X15", null, 0)));
      Logic.SYM_LOGIC_pX16 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X16", null, 0)));
      Logic.SYM_LOGIC_pX17 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X17", null, 0)));
      Logic.SYM_LOGIC_pX18 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X18", null, 0)));
      Logic.SYM_LOGIC_pX19 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X19", null, 0)));
      Logic.SYM_LOGIC_pX20 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X20", null, 0)));
      Logic.SYM_LOGIC_pX21 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X21", null, 0)));
      Logic.SYM_LOGIC_pX22 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X22", null, 0)));
      Logic.SYM_LOGIC_pX23 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X23", null, 0)));
      Logic.SYM_LOGIC_pX24 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X24", null, 0)));
      Logic.SYM_LOGIC_pX25 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X25", null, 0)));
      Logic.SYM_LOGIC_pX26 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X26", null, 0)));
      Logic.SYM_LOGIC_pX27 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X27", null, 0)));
      Logic.SYM_LOGIC_pX28 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X28", null, 0)));
      Logic.SYM_LOGIC_pX29 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X29", null, 0)));
      Logic.SYM_LOGIC_pX30 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X30", null, 0)));
      Logic.SYM_LOGIC_pX31 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X31", null, 0)));
      Logic.SYM_LOGIC_pX32 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X32", null, 0)));
      Logic.SYM_LOGIC_pX33 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X33", null, 0)));
      Logic.SYM_LOGIC_pX34 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X34", null, 0)));
      Logic.SYM_LOGIC_pX35 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X35", null, 0)));
      Logic.SYM_LOGIC_pX36 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X36", null, 0)));
      Logic.SYM_LOGIC_pX37 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X37", null, 0)));
      Logic.SYM_LOGIC_pX38 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X38", null, 0)));
      Logic.SYM_LOGIC_pX39 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X39", null, 0)));
      Logic.SYM_LOGIC_pX40 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X40", null, 0)));
      Logic.SYM_LOGIC_pX41 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X41", null, 0)));
      Logic.SYM_LOGIC_pX42 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X42", null, 0)));
      Logic.SYM_LOGIC_pX43 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X43", null, 0)));
      Logic.SYM_LOGIC_pX44 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X44", null, 0)));
      Logic.SYM_LOGIC_pX45 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X45", null, 0)));
      Logic.SYM_LOGIC_pX46 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X46", null, 0)));
      Logic.SYM_LOGIC_pX47 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X47", null, 0)));
      Logic.SYM_LOGIC_pX48 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X48", null, 0)));
      Logic.SYM_LOGIC_pX49 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X49", null, 0)));
      Logic.SYM_LOGIC_pX50 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X50", null, 0)));
      Logic.SYM_LOGIC_pX51 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X51", null, 0)));
      Logic.SYM_LOGIC_pX52 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X52", null, 0)));
      Logic.SYM_LOGIC_pX53 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X53", null, 0)));
      Logic.SYM_LOGIC_pX54 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X54", null, 0)));
      Logic.SYM_LOGIC_pX55 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X55", null, 0)));
      Logic.SYM_LOGIC_pX56 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X56", null, 0)));
      Logic.SYM_LOGIC_pX57 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X57", null, 0)));
      Logic.SYM_LOGIC_pX58 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X58", null, 0)));
    }
  }

  static void helpStartupDescriptions2() {
    {
      Logic.SYM_LOGIC_pX59 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X59", null, 0)));
      Logic.SYM_LOGIC_pX60 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X60", null, 0)));
      Logic.SYM_LOGIC_pX61 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X61", null, 0)));
      Logic.SYM_LOGIC_pX62 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X62", null, 0)));
      Logic.SYM_LOGIC_pX63 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X63", null, 0)));
      Logic.SYM_LOGIC_pX64 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X64", null, 0)));
      Logic.SYM_LOGIC_pX65 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X65", null, 0)));
      Logic.SYM_LOGIC_pX66 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X66", null, 0)));
      Logic.SYM_LOGIC_pX67 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X67", null, 0)));
      Logic.SYM_LOGIC_pX68 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X68", null, 0)));
      Logic.SYM_LOGIC_pX69 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X69", null, 0)));
      Logic.SYM_LOGIC_pX70 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X70", null, 0)));
      Logic.SYM_LOGIC_pX71 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X71", null, 0)));
      Logic.SYM_LOGIC_pX72 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X72", null, 0)));
      Logic.SYM_LOGIC_pX73 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X73", null, 0)));
      Logic.SYM_LOGIC_pX74 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X74", null, 0)));
      Logic.SYM_LOGIC_pX75 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X75", null, 0)));
      Logic.SYM_LOGIC_pX76 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X76", null, 0)));
      Logic.SYM_LOGIC_pX77 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X77", null, 0)));
      Logic.SYM_LOGIC_pX78 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X78", null, 0)));
      Logic.SYM_LOGIC_pX79 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X79", null, 0)));
      Logic.SYM_LOGIC_pX80 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X80", null, 0)));
      Logic.SYM_LOGIC_pX81 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X81", null, 0)));
      Logic.SYM_LOGIC_pX82 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X82", null, 0)));
      Logic.SYM_LOGIC_pX83 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X83", null, 0)));
      Logic.SYM_LOGIC_pX84 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X84", null, 0)));
      Logic.SYM_LOGIC_pX85 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X85", null, 0)));
      Logic.SYM_LOGIC_pX86 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X86", null, 0)));
      Logic.SYM_LOGIC_pX87 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X87", null, 0)));
      Logic.SYM_LOGIC_pX88 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X88", null, 0)));
      Logic.SYM_LOGIC_pX89 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X89", null, 0)));
      Logic.SYM_LOGIC_pX90 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X90", null, 0)));
      Logic.SYM_LOGIC_pX91 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X91", null, 0)));
      Logic.SYM_LOGIC_pX92 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X92", null, 0)));
      Logic.SYM_LOGIC_pX93 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X93", null, 0)));
      Logic.SYM_LOGIC_pX94 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X94", null, 0)));
      Logic.SYM_LOGIC_pX95 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X95", null, 0)));
      Logic.SYM_LOGIC_pX96 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X96", null, 0)));
      Logic.SYM_LOGIC_pX97 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X97", null, 0)));
      Logic.SYM_LOGIC_pX98 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X98", null, 0)));
      Logic.SYM_LOGIC_pX99 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X99", null, 0)));
      Logic.SYM_LOGIC_pX100 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X100", null, 0)));
      Logic.SGT_LOGIC_UNFINALIZED = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("UNFINALIZED", null, 1)));
      Logic.SGT_STELLA_LIST = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LIST", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_LOGIC_EXTERNAL_VARIABLES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXTERNAL-VARIABLES", null, 0)));
      Logic.SGT_STELLA_PROPOSITIONdIF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("PROPOSITION.IF", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_HEAD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("HEAD", null, 2)));
      Logic.KWD_TOP_LEVEL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TOP-LEVEL", null, 2)));
      Logic.SYM_LOGIC_VARIABLE_TYPE_TABLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VARIABLE-TYPE-TABLE", null, 0)));
      Logic.SYM_LOGIC_UNDECLAREDp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("UNDECLARED?", null, 0)));
      Logic.SYM_LOGIC_pX = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?X", null, 0)));
      Logic.SYM_PL_KERNEL_KB_RELATION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATION", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_F_CALL_LIST_UNDEFINED_RELATIONS_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-CALL-LIST-UNDEFINED-RELATIONS-QUERY-000", null, 0)));
      Logic.SYM_LOGIC_STARTUP_DESCRIPTIONS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-DESCRIPTIONS", null, 0)));
    }
  }

  static void helpStartupDescriptions3() {
    {
      Logic.FAKE_IO_VARIABLES = Vector.newVector(0);
      Logic.SYSTEM_DEFINED_ARGUMENT_NAMES = Cons.list$(Cons.cons(Logic.SYM_LOGIC_pX1, Cons.cons(Logic.SYM_LOGIC_pX2, Cons.cons(Logic.SYM_LOGIC_pX3, Cons.cons(Logic.SYM_LOGIC_pX4, Cons.cons(Logic.SYM_LOGIC_pX5, Cons.cons(Logic.SYM_LOGIC_pX6, Cons.cons(Logic.SYM_LOGIC_pX7, Cons.cons(Logic.SYM_LOGIC_pX8, Cons.cons(Logic.SYM_LOGIC_pX9, Cons.cons(Logic.SYM_LOGIC_pX10, Cons.cons(Logic.SYM_LOGIC_pX11, Cons.cons(Logic.SYM_LOGIC_pX12, Cons.cons(Logic.SYM_LOGIC_pX13, Cons.cons(Logic.SYM_LOGIC_pX14, Cons.cons(Logic.SYM_LOGIC_pX15, Cons.cons(Logic.SYM_LOGIC_pX16, Cons.cons(Logic.SYM_LOGIC_pX17, Cons.cons(Logic.SYM_LOGIC_pX18, Cons.cons(Logic.SYM_LOGIC_pX19, Cons.cons(Logic.SYM_LOGIC_pX20, Cons.cons(Logic.SYM_LOGIC_pX21, Cons.cons(Logic.SYM_LOGIC_pX22, Cons.cons(Logic.SYM_LOGIC_pX23, Cons.cons(Logic.SYM_LOGIC_pX24, Cons.cons(Logic.SYM_LOGIC_pX25, Cons.cons(Logic.SYM_LOGIC_pX26, Cons.cons(Logic.SYM_LOGIC_pX27, Cons.cons(Logic.SYM_LOGIC_pX28, Cons.cons(Logic.SYM_LOGIC_pX29, Cons.cons(Logic.SYM_LOGIC_pX30, Cons.cons(Logic.SYM_LOGIC_pX31, Cons.cons(Logic.SYM_LOGIC_pX32, Cons.cons(Logic.SYM_LOGIC_pX33, Cons.cons(Logic.SYM_LOGIC_pX34, Cons.cons(Logic.SYM_LOGIC_pX35, Cons.cons(Logic.SYM_LOGIC_pX36, Cons.cons(Logic.SYM_LOGIC_pX37, Cons.cons(Logic.SYM_LOGIC_pX38, Cons.cons(Logic.SYM_LOGIC_pX39, Cons.cons(Logic.SYM_LOGIC_pX40, Cons.cons(Logic.SYM_LOGIC_pX41, Cons.cons(Logic.SYM_LOGIC_pX42, Cons.cons(Logic.SYM_LOGIC_pX43, Cons.cons(Logic.SYM_LOGIC_pX44, Cons.cons(Logic.SYM_LOGIC_pX45, Cons.cons(Logic.SYM_LOGIC_pX46, Cons.cons(Logic.SYM_LOGIC_pX47, Cons.cons(Logic.SYM_LOGIC_pX48, Cons.cons(Logic.SYM_LOGIC_pX49, Cons.cons(Logic.SYM_LOGIC_pX50, Cons.cons(Logic.SYM_LOGIC_pX51, Cons.cons(Logic.SYM_LOGIC_pX52, Cons.cons(Logic.SYM_LOGIC_pX53, Cons.cons(Logic.SYM_LOGIC_pX54, Cons.cons(Logic.SYM_LOGIC_pX55, Cons.cons(Logic.SYM_LOGIC_pX56, Cons.cons(Logic.SYM_LOGIC_pX57, Cons.cons(Logic.SYM_LOGIC_pX58, Cons.cons(Logic.SYM_LOGIC_pX59, Cons.cons(Logic.SYM_LOGIC_pX60, Cons.cons(Logic.SYM_LOGIC_pX61, Cons.cons(Logic.SYM_LOGIC_pX62, Cons.cons(Logic.SYM_LOGIC_pX63, Cons.cons(Logic.SYM_LOGIC_pX64, Cons.cons(Logic.SYM_LOGIC_pX65, Cons.cons(Logic.SYM_LOGIC_pX66, Cons.cons(Logic.SYM_LOGIC_pX67, Cons.cons(Logic.SYM_LOGIC_pX68, Cons.cons(Logic.SYM_LOGIC_pX69, Cons.cons(Logic.SYM_LOGIC_pX70, Cons.cons(Logic.SYM_LOGIC_pX71, Cons.cons(Logic.SYM_LOGIC_pX72, Cons.cons(Logic.SYM_LOGIC_pX73, Cons.cons(Logic.SYM_LOGIC_pX74, Cons.cons(Logic.SYM_LOGIC_pX75, Cons.cons(Logic.SYM_LOGIC_pX76, Cons.cons(Logic.SYM_LOGIC_pX77, Cons.cons(Logic.SYM_LOGIC_pX78, Cons.cons(Logic.SYM_LOGIC_pX79, Cons.cons(Logic.SYM_LOGIC_pX80, Cons.cons(Logic.SYM_LOGIC_pX81, Cons.cons(Logic.SYM_LOGIC_pX82, Cons.cons(Logic.SYM_LOGIC_pX83, Cons.cons(Logic.SYM_LOGIC_pX84, Cons.cons(Logic.SYM_LOGIC_pX85, Cons.cons(Logic.SYM_LOGIC_pX86, Cons.cons(Logic.SYM_LOGIC_pX87, Cons.cons(Logic.SYM_LOGIC_pX88, Cons.cons(Logic.SYM_LOGIC_pX89, Cons.cons(Logic.SYM_LOGIC_pX90, Cons.cons(Logic.SYM_LOGIC_pX91, Cons.cons(Logic.SYM_LOGIC_pX92, Cons.cons(Logic.SYM_LOGIC_pX93, Cons.cons(Logic.SYM_LOGIC_pX94, Cons.cons(Logic.SYM_LOGIC_pX95, Cons.cons(Logic.SYM_LOGIC_pX96, Cons.cons(Logic.SYM_LOGIC_pX97, Cons.cons(Logic.SYM_LOGIC_pX98, Cons.cons(Logic.SYM_LOGIC_pX99, Cons.cons(Logic.SYM_LOGIC_pX100, Cons.cons(Stella.NIL, Stella.NIL))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
      Logic.$LOGICVARIABLETABLE$.setDefaultValue(null);
      Logic.$VARIABLETYPEPROPOSITIONS$.setDefaultValue(Stella.NIL);
      Logic.$UNIFY_PROPOSITIONSp$.setDefaultValue(new Boolean(false));
      Logic.$RECURSIVEGETCOMPLEMENTARGUMENT$.setDefaultValue(null);
      Logic.$ADDEDNEWTYPEp$.setDefaultValue(new Boolean(false));
    }
  }

  static void helpStartupDescriptions4() {
    {
      Stella.defineExternalSlotFromStringifiedSource("(DEFSLOT RELATION DESCRIPTION :TYPE NAMED-DESCRIPTION :DOCUMENTATION \"Maps a relation (class or slot or table) to a\nprimitive description.\" :ALLOCATION :DYNAMIC)");
      Stella.defineFunctionObject("DIRECT-SUPERRELATIONS", "(DEFUN (DIRECT-SUPERRELATIONS (ITERATOR OF (LIKE SELF))) ((SELF RELATION)) :DOCUMENTATION \"Return direct super classes/slots of 'self'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "directSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("SLOT-COLUMN-TYPES", "(DEFUN (SLOT-COLUMN-TYPES (CONS OF TYPE)) ((SELF SLOT) (COUNT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "slotColumnTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("CREATE-DESCRIPTION", "(DEFUN (CREATE-DESCRIPTION DESCRIPTION) ((ARITY INTEGER) (NAMED? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createDescription", new java.lang.Class [] {java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineMethodObject("(DEFMETHOD (DESCRIPTION-NAME SYMBOL) ((SELF DESCRIPTION)) :DOCUMENTATION \"Return the name of the description `self', if it has one.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionName", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (DESCRIPTION-NAME SYMBOL) ((SELF NAMED-DESCRIPTION)) :DOCUMENTATION \"Return the name of the description `self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "descriptionName", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("CREATE-BASE-RELATION-FOR-POLYMORPHIC-DESCRIPTION", "(DEFUN CREATE-BASE-RELATION-FOR-POLYMORPHIC-DESCRIPTION ((DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "createBaseRelationForPolymorphicDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("YIELD-SYSTEM-DEFINED-PARAMETER-NAME", "(DEFUN (YIELD-SYSTEM-DEFINED-PARAMETER-NAME SYMBOL) ((INDEX INTEGER) (REFERENCEOBJECT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "yieldSystemDefinedParameterName", new java.lang.Class [] {java.lang.Integer.TYPE, Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("ENSURE-DESCRIPTION-BODY", "(DEFUN ENSURE-DESCRIPTION-BODY ((DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "ensureDescriptionBody", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("MATERIALIZE-PRIMITIVE-DESCRIPTION-BODY", "(DEFUN MATERIALIZE-PRIMITIVE-DESCRIPTION-BODY ((DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "materializePrimitiveDescriptionBody", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("CREATE-PRIMITIVE-DESCRIPTION", "(DEFUN (CREATE-PRIMITIVE-DESCRIPTION NAMED-DESCRIPTION) ((IOVARIABLENAMES (LIST OF SYMBOL)) (IOVARIABLETYPES (LIST OF TYPE)) (VARIABLEARITY? BOOLEAN) (CLASS? BOOLEAN) (FUNCTION? BOOLEAN) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createPrimitiveDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("LINK-STELLA-RELATION-AND-DESCRIPTION", "(DEFUN LINK-STELLA-RELATION-AND-DESCRIPTION ((SELF RELATION) (DESCRIPTION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "linkStellaRelationAndDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation"), Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("CREATE-DESCRIPTION-FOR-STELLA-RELATION", "(DEFUN (CREATE-DESCRIPTION-FOR-STELLA-RELATION NAMED-DESCRIPTION) ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createDescriptionForStellaRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("SURROGATE-TO-DESCRIPTION", "(DEFUN (SURROGATE-TO-DESCRIPTION NAMED-DESCRIPTION) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "surrogateToDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("GET-DESCRIPTION", "(DEFUN (GET-DESCRIPTION NAMED-DESCRIPTION) ((SELF OBJECT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "getDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("SURROGATE.GET-DESCRIPTION", "(DEFUN (SURROGATE.GET-DESCRIPTION NAMED-DESCRIPTION) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "surrogateDgetDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("STRING.GET-DESCRIPTION", "(DEFUN (STRING.GET-DESCRIPTION NAMED-DESCRIPTION) ((SELF STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringDgetDescription", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CLASS.GET-DESCRIPTION", "(DEFUN (CLASS.GET-DESCRIPTION NAMED-DESCRIPTION) ((SELF CLASS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "classDgetDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("SLOT.GET-DESCRIPTION", "(DEFUN (SLOT.GET-DESCRIPTION NAMED-DESCRIPTION) ((SELF SLOT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "slotDgetDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot")}), null);
      Stella.defineFunctionObject("ENSURE-DEFERRED-DESCRIPTION", "(DEFUN (ENSURE-DEFERRED-DESCRIPTION SURROGATE) ((SELF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "ensureDeferredDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("LOGIC-CLASS?", "(DEFUN (LOGIC-CLASS? BOOLEAN) ((SELF CLASS)) :DOCUMENTATION \"Return TRUE if the class 'self' or one of its\nsupers supports indices that record extensions referenced by\nthe logic system. Also return true for literal classes.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "logicClassP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Class")}), null);
      Stella.defineFunctionObject("VARIABLE-ARITY-DOMAIN-TYPES-NEXT?", "(DEFUN (VARIABLE-ARITY-DOMAIN-TYPES-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "variableArityDomainTypesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("WRAP-ITERATOR-FOR-VARIABLE-ARITY", "(DEFUN (WRAP-ITERATOR-FOR-VARIABLE-ARITY ITERATOR) ((ITERATOR ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "wrapIteratorForVariableArity", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Iterator")}), null);
      Stella.defineFunctionObject("ALL-DOMAIN-TYPES", "(DEFUN (ALL-DOMAIN-TYPES ITERATOR) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allDomainTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("ALL-ARGUMENT-TYPES", "(DEFUN (ALL-ARGUMENT-TYPES ITERATOR) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "allArgumentTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
      Stella.defineFunctionObject("PUSH-LOGIC-VARIABLE-BINDING", "(DEFUN PUSH-LOGIC-VARIABLE-BINDING ((VARIABLE SKOLEM)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "pushLogicVariableBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem")}), null);
      Stella.defineFunctionObject("POP-LOGIC-VARIABLE-BINDING", "(DEFUN POP-LOGIC-VARIABLE-BINDING ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "popLogicVariableBinding", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("POP-LOGIC-VARIABLE-BINDINGS", "(DEFUN POP-LOGIC-VARIABLE-BINDINGS ((VARIABLES (CONS OF SKOLEM))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "popLogicVariableBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("LOOKUP-LOGIC-VARIABLE-BINDING", "(DEFUN (LOOKUP-LOGIC-VARIABLE-BINDING OBJECT) ((VARIABLENAME SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "lookupLogicVariableBinding", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
      Stella.defineFunctionObject("PARSE-ONE-VARIABLE-DECLARATION", "(DEFUN PARSE-ONE-VARIABLE-DECLARATION ((VDEC OBJECT) (LOCALDECLARATIONS (LIST OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parseOneVariableDeclaration", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("PARSE-LOGIC-VARIABLE-DECLARATIONS", "(DEFUN (PARSE-LOGIC-VARIABLE-DECLARATIONS (CONS OF PATTERN-VARIABLE)) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "parseLogicVariableDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("HELP-BUILD-QUANTIFIED-PROPOSITION", "(DEFUN (HELP-BUILD-QUANTIFIED-PROPOSITION (CONS OF SKOLEM) PROPOSITION PROPOSITION) ((TREE CONS) (CONVERTTYPESTOCONSTRAINTS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpBuildQuantifiedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("BUILD-QUANTIFIED-PROPOSITION", "(DEFUN (BUILD-QUANTIFIED-PROPOSITION (CONS OF SKOLEM) PROPOSITION PROPOSITION) ((TREE CONS) (CONVERTTYPESTOCONSTRAINTS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "buildQuantifiedProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COPY-CONS-LIST-TO-VARIABLES-VECTOR", "(DEFUN (COPY-CONS-LIST-TO-VARIABLES-VECTOR VARIABLES-VECTOR) ((CONSLIST CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "copyConsListToVariablesVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("EQUIVALENT-HOLDS-PROPOSITION?", "(DEFUN (EQUIVALENT-HOLDS-PROPOSITION? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equivalentHoldsPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("EQUIVALENT-COMMUTATIVE-PROPOSITIONS?", "(DEFUN (EQUIVALENT-COMMUTATIVE-PROPOSITIONS? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equivalentCommutativePropositionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("HELP-EQUIVALENT-PROPOSITIONS?", "(DEFUN (HELP-EQUIVALENT-PROPOSITIONS? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING) (IGNORELASTARG? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpEquivalentPropositionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("EQUIVALENT-PROPOSITIONS?", "(DEFUN (EQUIVALENT-PROPOSITIONS? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equivalentPropositionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("EQUIVALENT-FUNCTION-PROPOSITIONS?", "(DEFUN (EQUIVALENT-FUNCTION-PROPOSITIONS? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equivalentFunctionPropositionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("EQUIVALENT-DESCRIPTIONS?", "(DEFUN (EQUIVALENT-DESCRIPTIONS? BOOLEAN) ((SELF DESCRIPTION) (OTHER DESCRIPTION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "equivalentDescriptionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("EQUIVALENT-ENUMERATIONS?", "(DEFUN (EQUIVALENT-ENUMERATIONS? BOOLEAN) ((SELF COLLECTION) (OTHER COLLECTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "equivalentEnumerationsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Collection"), Native.find_java_class("edu.isi.stella.Collection")}), null);
      Stella.defineFunctionObject("EQUIVALENT-FORMULAE?", "(DEFUN (EQUIVALENT-FORMULAE? BOOLEAN) ((SELF OBJECT) (OTHER OBJECT) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "equivalentFormulaeP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("SAME-AND-UNIQUE-ARGUMENTS?", "(DEFUN (SAME-AND-UNIQUE-ARGUMENTS? BOOLEAN) ((VARIABLES VARIABLES-VECTOR) (ARGUMENTS VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "sameAndUniqueArgumentsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("UNIFY-PROPOSITIONS?", "(DEFUN (UNIFY-PROPOSITIONS? BOOLEAN) ((SELF PROPOSITION) (OTHER PROPOSITION) (MAPPING ENTITY-MAPPING)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "unifyPropositionsP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueMap")}), null);
      Stella.defineFunctionObject("DESCRIPTION?", "(DEFUN (DESCRIPTION? BOOLEAN) ((SELF OBJECT)) :DOCUMENTATION \"Return TRUE if 'self' is a description.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "descriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("UNNAMED-DESCRIPTION?", "(DEFUN (UNNAMED-DESCRIPTION? BOOLEAN) ((SELF OBJECT)) :DOCUMENTATION \"Return TRUE if 'self' is an unnamed description.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "unnamedDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("NAMED-DESCRIPTION?", "(DEFUN (NAMED-DESCRIPTION? BOOLEAN) ((SELF DESCRIPTION)) :DOCUMENTATION \"Return TRUE if 'self' is the description of a named class or relation.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Description", "namedDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineMethodObject("(DEFMETHOD (FIND-DUPLICATE-NAMED-DESCRIPTION LOGIC-OBJECT) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "findDuplicateNamedDescription", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("FIND-DUPLICATE-COMPLEX-DESCRIPTION", "(DEFUN (FIND-DUPLICATE-COMPLEX-DESCRIPTION DESCRIPTION) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "findDuplicateComplexDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("FIND-DUPLICATE-DESCRIPTION", "(DEFUN (FIND-DUPLICATE-DESCRIPTION DESCRIPTION) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "findDuplicateDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("CONTAINS-NESTED-ARGUMENT?", "(DEFUN (CONTAINS-NESTED-ARGUMENT? BOOLEAN) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "containsNestedArgumentP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("EXPAND-IF-PROPOSITION", "(DEFUN (EXPAND-IF-PROPOSITION PROPOSITION) ((IFPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "expandIfProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-COLLECT-FLATTENED-ARGUMENTS", "(DEFUN HELP-COLLECT-FLATTENED-ARGUMENTS ((SELF PROPOSITION) (FLATTENEDARGUMENTS (LIST OF PROPOSITION)) (EXISTSVARIABLES (LIST OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpCollectFlattenedArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("YIELD-FLATTENED-ARGUMENTS", "(DEFUN (YIELD-FLATTENED-ARGUMENTS (LIST OF PROPOSITION)) ((PROPOSITION PROPOSITION) (EXISTSVARIABLES (LIST OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "yieldFlattenedArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List")}), null);
      Stella.defineFunctionObject("FLATTEN-NESTED-FUNCTION-ARGUMENTS", "(DEFUN (FLATTEN-NESTED-FUNCTION-ARGUMENTS PROPOSITION) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "flattenNestedFunctionArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("COLLAPSE-VALUE-OF-CHAINS-FOR-IO-VARIABLES", "(DEFUN COLLAPSE-VALUE-OF-CHAINS-FOR-IO-VARIABLES ((IOVARIABLES VARIABLES-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collapseValueOfChainsForIoVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("REMOVE-NULLS-IN-VARIABLES-VECTOR", "(DEFUN (REMOVE-NULLS-IN-VARIABLES-VECTOR VARIABLES-VECTOR) ((IOVARIABLES VARIABLES-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "removeNullsInVariablesVector", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("TIGHTEN-ARGUMENT-BINDINGS", "(DEFUN TIGHTEN-ARGUMENT-BINDINGS ((PROPOSITION PROPOSITION) (IOVARIABLES VARIABLES-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "tightenArgumentBindings", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("EQUATE-TOP-LEVEL-EQUIVALENCES", "(DEFUN EQUATE-TOP-LEVEL-EQUIVALENCES ((PROPOSITION PROPOSITION) (IOVARIABLES VARIABLES-VECTOR) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "equateTopLevelEquivalences", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("COLLECT-ALL-VARIABLES", "(DEFUN COLLECT-ALL-VARIABLES ((SELF PROPOSITION) (COLLECTION (LIST OF PATTERN-VARIABLE)) (BEENTHERE LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectAllVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
    }
  }

  public static void startupDescriptions() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupDescriptions.helpStartupDescriptions1();
          _StartupDescriptions.helpStartupDescriptions2();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupDescriptions.helpStartupDescriptions3();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE VARIABLE-TYPE-TABLE (KEY-VALUE-LIST OF PATTERN-VARIABLE (LIST OF TYPE)))");
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupDescriptions.helpStartupDescriptions4();
          Stella.defineFunctionObject("COMPUTE-INTERNAL-VARIABLES", "(DEFUN COMPUTE-INTERNAL-VARIABLES ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "computeInternalVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
          Stella.defineFunctionObject("COLLECT-EXTERNAL-VARIABLES", "(DEFUN COLLECT-EXTERNAL-VARIABLES ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectExternalVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("FINISH-BUILDING-DESCRIPTION", "(DEFUN (FINISH-BUILDING-DESCRIPTION DESCRIPTION) ((DESCRIPTION DESCRIPTION) (CHECKFORDUPLICATE? BOOLEAN) (KIND KEYWORD)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "finishBuildingDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE, Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("EVALUATE-DESCRIPTION-TERM", "(DEFUN (EVALUATE-DESCRIPTION-TERM DESCRIPTION) ((TERM CONS) (CHECKFORDUPLICATE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "evaluateDescriptionTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("REMOVE-VARIABLE-TYPE-PROPOSITIONS", "(DEFUN (REMOVE-VARIABLE-TYPE-PROPOSITIONS (CONS OF PROPOSITION)) ((PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "removeVariableTypePropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("GET-COMPLEMENT-OF-GOAL-DESCRIPTION", "(DEFUN (GET-COMPLEMENT-OF-GOAL-DESCRIPTION DESCRIPTION) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "getComplementOfGoalDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
          Stella.defineFunctionObject("COLLECT-FREE-VARIABLES", "(DEFUN COLLECT-FREE-VARIABLES ((SELF OBJECT) (COLLECTION (LIST OF PATTERN-VARIABLE)) (QUANTIFIEDVARS LIST) (BEENTHERE LIST)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectFreeVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("TOP-LEVEL-EXISTENTIAL-VARIABLES", "(DEFUN (TOP-LEVEL-EXISTENTIAL-VARIABLES (CONS OF PATTERN-VARIABLE)) ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "topLevelExistentialVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
          Stella.defineFunctionObject("TOP-LEVEL-EXISTENTIAL-VARIABLE?", "(DEFUN (TOP-LEVEL-EXISTENTIAL-VARIABLE? BOOLEAN) ((VARIABLE PATTERN-VARIABLE) (DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "topLevelExistentialVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
          Stella.defineFunctionObject("FREE-VARIABLE?", "(DEFUN (FREE-VARIABLE? BOOLEAN) ((VARIABLE PATTERN-VARIABLE) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "freeVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("MOST-SPECIFIC-TYPES", "(DEFUN (MOST-SPECIFIC-TYPES (LIST OF TYPE)) ((TYPES (LIST OF TYPE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "mostSpecificTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("ADD-VARIABLE-TYPE", "(DEFUN ADD-VARIABLE-TYPE ((VARIABLE PATTERN-VARIABLE) (NEWTYPE TYPE) (TABLE VARIABLE-TYPE-TABLE) (VISIBLEVARIABLES (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "addVariableType", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable"), Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("INFER-PREDICATE-FROM-OPERATOR-AND-TYPES", "(DEFUN (INFER-PREDICATE-FROM-OPERATOR-AND-TYPES OBJECT) ((OPERATOR OBJECT) (TYPES (LIST OF TYPE))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inferPredicateFromOperatorAndTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("INFER-TYPES-FROM-ONE-PROPOSITION", "(DEFUN INFER-TYPES-FROM-ONE-PROPOSITION ((PROPOSITION PROPOSITION) (TABLE VARIABLE-TYPE-TABLE) (VISIBLEVARS (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inferTypesFromOneProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("INFER-TYPES-FROM-PROPOSITIONS", "(DEFUN INFER-TYPES-FROM-PROPOSITIONS ((PROPOSITION PROPOSITION) (TABLE VARIABLE-TYPE-TABLE) (VISIBLEVARS (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inferTypesFromPropositions", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueList"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("INFER-VARIABLE-TYPES-IN-PROPOSITION", "(DEFUN (INFER-VARIABLE-TYPES-IN-PROPOSITION VARIABLE-TYPE-TABLE) ((PROPOSITION PROPOSITION) (VISIBLEVARIABLES (CONS OF PATTERN-VARIABLE))))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "inferVariableTypesInProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("INFER-VARIABLE-TYPES-IN-DESCRIPTION", "(DEFUN (INFER-VARIABLE-TYPES-IN-DESCRIPTION VARIABLE-TYPE-TABLE) ((DESCRIPTION DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "inferVariableTypesInDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
          Stella.defineFunctionObject("COLLECT-UNRESOLVED-SLOT-REFERENCES", "(DEFUN (COLLECT-UNRESOLVED-SLOT-REFERENCES (CONS OF PROPOSITION)) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "collectUnresolvedSlotReferences", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("RESOLVE-ONE-SLOT-REFERENCE?", "(DEFUN (RESOLVE-ONE-SLOT-REFERENCE? BOOLEAN) ((PROPOSITION PROPOSITION) (VARIABLETYPESTABLE VARIABLE-TYPE-TABLE)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "resolveOneSlotReferenceP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.KeyValueList")}), null);
          Stella.defineFunctionObject("RESOLVE-UNRESOLVED-SLOT-REFERENCES", "(DEFUN RESOLVE-UNRESOLVED-SLOT-REFERENCES ((FORMULA OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "resolveUnresolvedSlotReferences", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CREATE-DUMMY-RELATION", "(DEFUN CREATE-DUMMY-RELATION ((WAYWARDPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "createDummyRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("DEFINED-RELATION?", "(DEFUN (DEFINED-RELATION? BOOLEAN) ((SELF NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "definedRelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), null);
          Stella.defineFunctionObject("LIST-UNDEFINED-RELATIONS", "(DEFUN (LIST-UNDEFINED-RELATIONS (CONS OF NAMED-DESCRIPTION)) (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Return a list of as yet undefined concepts and relations in the module defined\nby the :module option (which defaults to the current module).  These relations were\ndefined by the system, since they were referenced but have not yet been defined by\nthe user.  If `:local?' is specified as TRUE only look in the specified module but\nnot any modules it inherits.  For backwards compatibility, this command also supports\nthe old <module> <local?> arguments specified without keywords.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUndefinedRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "listUndefinedRelationsEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CALL-LIST-UNDEFINED-RELATIONS", "(DEFUN (CALL-LIST-UNDEFINED-RELATIONS CONS) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Callable version of `list-undefined-relations' (which see).\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "callListUndefinedRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("COMPLAIN-ABOUT-UNDECLARED-REFERENCE", "(DEFUN COMPLAIN-ABOUT-UNDECLARED-REFERENCE ((WAYWARDPROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "complainAboutUndeclaredReference", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
          Stella.defineFunctionObject("ALL-NAMED-DESCRIPTIONS-NEXT?", "(DEFUN (ALL-NAMED-DESCRIPTIONS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allNamedDescriptionsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-NAMED-DESCRIPTIONS", "(DEFUN (ALL-NAMED-DESCRIPTIONS (ITERATOR OF NAMED-DESCRIPTION)) ((MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Iterate over all named descriptions visible from 'module'.\nIf 'local?', return only named descriptions interned in 'module'.\nIf 'module' is null, return all named descriptions interned everywhere.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "allNamedDescriptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("STARTUP-DESCRIPTIONS", "(DEFUN STARTUP-DESCRIPTIONS () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupDescriptions", "startupDescriptions", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_DESCRIPTIONS);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupDescriptions"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT FAKE-IO-VARIABLES VARIABLES-VECTOR (NEW VARIABLES-VECTOR :ARRAY-SIZE 0) :DOCUMENTATION \"Installed in a description with undetermined arity.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFCONSTANT SYSTEM-DEFINED-ARGUMENT-NAMES (CONS OF SYMBOL) (BQUOTE (?X1 ?X2 ?X3 ?X4 ?X5 ?X6 ?X7 ?X8 ?X9 ?X10 ?X11 ?X12 ?X13 ?X14 ?X15 ?X16 ?X17 ?X18 ?X19 ?X20 ?X21 ?X22 ?X23 ?X24 ?X25 ?X26 ?X27 ?X28 ?X29 ?X30 ?X31 ?X32 ?X33 ?X34 ?X35 ?X36 ?X37 ?X38 ?X39 ?X40 ?X41 ?X42 ?X43 ?X44 ?X45 ?X46 ?X47 ?X48 ?X49 ?X50 ?X51 ?X52 ?X53 ?X54 ?X55 ?X56 ?X57 ?X58 ?X59 ?X60 ?X61 ?X62 ?X63 ?X64 ?X65 ?X66 ?X67 ?X68 ?X69 ?X70 ?X71 ?X72 ?X73 ?X74 ?X75 ?X76 ?X77 ?X78 ?X79 ?X80 ?X81 ?X82 ?X83 ?X84 ?X85 ?X86 ?X87 ?X88 ?X89 ?X90 ?X91 ?X92 ?X93 ?X94 ?X95 ?X96 ?X97 ?X98 ?X99 ?X100)) :PUBLIC? TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *LOGICVARIABLETABLE* (CONS OF SKOLEM) NULL :DOCUMENTATION \"Table mapping logic variable names to variables or skolems.\nUsed during construction of a proposition or description.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *VARIABLETYPEPROPOSITIONS* (CONS OF PROPOSITION) NIL :DOCUMENTATION \"List of propositions extracted from parsing\na list of quantified, typed variables.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *UNIFY-PROPOSITIONS?* BOOLEAN FALSE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXTERNALVARIABLES* CONS :DOCUMENTATION \"Used by 'evaluate-DESCRIPTION-term' for collecting\na list of variables declared external to the description in which they\nare referenced.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *RECURSIVEGETCOMPLEMENTARGUMENT* NAMED-DESCRIPTION NULL :DOCUMENTATION \"Used to prevent infinite looping.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *ADDEDNEWTYPE?* BOOLEAN FALSE :DOCUMENTATION \"Used by 'infer-variable-types'.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
