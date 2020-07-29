//  -*- Mode: Java -*-
//
// _StartupKifOut.java

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

public class _StartupKifOut {
  static void helpStartupKifOut1() {
    {
      Logic.KWD_SQL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SQL", null, 2)));
      Logic.KWD_ORIGINAL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ORIGINAL", null, 2)));
      Logic.KWD_UNESCAPED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("UNESCAPED", null, 2)));
      Logic.KWD_ESCAPED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ESCAPED", null, 2)));
      Logic.KWD_COMPLEX_ESCAPED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("COMPLEX-ESCAPED", null, 2)));
      Logic.SGT_PL_KERNEL_KB_le = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("<=", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_KAPPA = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("KAPPA", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_eg = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("=>", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_egg = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("=>>", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_lle = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("<<=", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_lt = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("<~", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_tg = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("~>", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_llt = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("<<~", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.SGT_PL_KERNEL_KB_tgg = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("~>>", Stella.getStellaModule("/PL-KERNEL-KB", true), 1)));
      Logic.KWD_TERSE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TERSE", null, 2)));
      Logic.KWD_SOURCE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SOURCE", null, 2)));
      Logic.KWD_SLOTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SLOTS", null, 2)));
      Logic.KWD_PUBLIC_SLOTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC-SLOTS", null, 2)));
      Logic.KWD_METHODS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("METHODS", null, 2)));
      Logic.KWD_PUBLIC_METHODS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PUBLIC-METHODS", null, 2)));
      Logic.SYM_LOGIC_PRESUME = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PRESUME", null, 0)));
      Logic.SYM_STELLA_RETRACT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RETRACT", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_IN_DIALECT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("IN-DIALECT", null, 0)));
      Logic.SGT_STELLA_OUTPUT_STREAM = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("OUTPUT-STREAM", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.KWD_FILE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FILE", null, 2)));
      Logic.SYM_LOGIC_STARTUP_KIF_OUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-KIF-OUT", null, 0)));
    }
  }

  static void helpStartupKifOut2() {
    {
      Logic.$PRETTYPRINTLOGICALFORMSp$.setDefaultValue(new Boolean(false));
      Logic.$PRETTYPRINTKIFp$.setDefaultValue(new Boolean(false));
      Logic.$PRINTLOGICALFORMSTREAM$.setDefaultValue(null);
      Logic.$DOWNCASEOPERATORSp$.setDefaultValue(new Boolean(false));
      Logic.$LOGIC_DIALECT_PRINT_FUNCTIONS$ = KeyValueList.newKeyValueList();
      Logic.$PRINTQUANTIFIEDOBJECTSSTACK$.setDefaultValue(null);
      Logic.$INDENTCOUNTER$.setDefaultValue(new Integer(0));
      Logic.$TOPLEVELPRINTKIFPROPOSITIONp$.setDefaultValue(new Boolean(true));
      Logic.$EXCLUDEDPROPOSITIONS$.setDefaultValue(null);
      Logic.$BUILT_IN_MODULE_NAMES$ = Stella.getQuotedTree("((\"PL-USER\" \"PL-KERNEL-KB\" \"PLI\" \"LOOM-API\" \"CYC-FRAME-ONTOLOGY\" \"KIF-FRAME-ONTOLOGY\" \"IDL-THEORY\" \"IDL-USER-THEORY\" \"LOGIC\" \"STELLA\" \"COMMON-LISP\") \"/LOGIC\")", "/LOGIC");
    }
  }

  static void helpStartupKifOut3() {
    {
      Stella.defineFunctionObject("REGISTER-LOGIC-DIALECT-PRINT-FUNCTION", "(DEFUN REGISTER-LOGIC-DIALECT-PRINT-FUNCTION ((DIALECT KEYWORD) (FN FUNCTION-CODE-WRAPPER)) :DOCUMENTATION \"Register `fn' as a logic-object print function for `dialect'.\nEach function should have the signature `((self OBJECT) (stream OUTPUT-STREAM))'.\nAny return values will be ignored.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "registerLogicDialectPrintFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.FunctionCodeWrapper")}), null);
      Stella.defineFunctionObject("PUSH-QUANTIFIED-OBJECT", "(DEFUN PUSH-QUANTIFIED-OBJECT ((OBJECT OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "pushQuantifiedObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("POP-QUANTIFIED-OBJECT", "(DEFUN POP-QUANTIFIED-OBJECT ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "popQuantifiedObject", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("QUANTIFIED-OBJECT-VARIABLE?", "(DEFUN (QUANTIFIED-OBJECT-VARIABLE? BOOLEAN) ((VAR SKOLEM)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "quantifiedObjectVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem")}), null);
      Stella.defineFunctionObject("MAYBE-DOWNCASE", "(DEFUN (MAYBE-DOWNCASE STRING) ((STRING STRING)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "maybeDowncase", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("INCREASE-INDENT", "(DEFUN INCREASE-INDENT ((INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "increaseIndent", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("DECREASE-INDENT", "(DEFUN DECREASE-INDENT ((INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "decreaseIndent", new java.lang.Class [] {java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-INDENT", "(DEFUN PRINT-INDENT ((STREAM OUTPUT-STREAM) (INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printIndent", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-LOGICAL-FORM-IN-DIALECT", "(DEFUN PRINT-LOGICAL-FORM-IN-DIALECT ((SELF OBJECT) (DIALECT KEYWORD) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Produce a stringified version of a logical representation\nof 'self' and write it to the stream 'stream'.  Use the dialect 'dialect',\nor use the current dialect if 'dialect' is NULL.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printLogicalFormInDialect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-LOGICAL-FORM", "(DEFUN PRINT-LOGICAL-FORM ((FORM OBJECT) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Print the logical form `form' to `stream' according to\nthe current setting of `*logic-dialect*'.  Pretty-printing is controlled\nby the current setting of `*prettyPrintLogicalForms?*'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printLogicalForm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-LOGICAL-FORM", "(DEFUN PRETTY-PRINT-LOGICAL-FORM ((FORM OBJECT) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Pretty-print the logical form `form' to `stream' according\nto the current setting of `*logic-dialect*'.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "prettyPrintLogicalForm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-UNFORMATTED-LOGICAL-FORM", "(DEFUN PRINT-UNFORMATTED-LOGICAL-FORM ((FORM OBJECT) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE :DOCUMENTATION \"Print the logical form `form' to `stream' according to\nthe current setting of `*logic-dialect*'.  Pretty-printing is explicitly\nforced to be turned off.\")", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printUnformattedLogicalForm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-FORMULA", "(DEFUN PRINT-FORMULA ((FORMULA OBJECT) (INDENT INTEGER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printFormula", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("PRINT-AS-KIF", "(DEFUN PRINT-AS-KIF ((SELF OBJECT) (STREAM OUTPUT-STREAM)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printAsKif", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-AS-KIF-INTERNAL", "(DEFUN PRINT-AS-KIF-INTERNAL ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printAsKifInternal", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("VISIBLE-ARGUMENT?", "(DEFUN (VISIBLE-ARGUMENT? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "visibleArgumentP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("VISIBLE-ARGUMENTS-COUNT", "(DEFUN (VISIBLE-ARGUMENTS-COUNT INTEGER) ((ARGUMENTS ARGUMENTS-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "visibleArgumentsCount", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("PRINT-KIF-ARGUMENTS", "(DEFUN PRINT-KIF-ARGUMENTS ((ARGUMENTS ARGUMENTS-VECTOR) (SEPARATELINES? BOOLEAN) (OMITLASTARGUMENT? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printKifArguments", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRINT-KIF-OPERATOR-WITH-ARGUMENTS", "(DEFUN PRINT-KIF-OPERATOR-WITH-ARGUMENTS ((OPERATOR STRING) (ARGUMENTS ARGUMENTS-VECTOR) (SEPARATELINES? BOOLEAN) (OMITLASTARGUMENT? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printKifOperatorWithArguments", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Vector"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("STRINGIFIED-SURROGATE", "(DEFUN (STRINGIFIED-SURROGATE STRING) ((OPERATOR SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stringifiedSurrogate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("STRINGIFIED-KIF-OPERATOR", "(DEFUN (STRINGIFIED-KIF-OPERATOR STRING) ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "stringifiedKifOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-PROPOSITION", "(DEFUN PRINT-KIF-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("HELP-PRINT-KIF-PROPOSITION", "(DEFUN HELP-PRINT-KIF-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "helpPrintKifProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-FUNCTION-PROPOSITION", "(DEFUN PRINT-KIF-FUNCTION-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifFunctionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-FUNCTION-EXPRESSION", "(DEFUN PRINT-KIF-FUNCTION-EXPRESSION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifFunctionExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-IMPLIES-PROPOSITION", "(DEFUN PRINT-KIF-IMPLIES-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifImpliesProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-QUANTIFIED-VARIABLES", "(DEFUN PRINT-KIF-QUANTIFIED-VARIABLES ((VARIABLES (VECTOR OF SKOLEM)) (INCLUDETYPES? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printKifQuantifiedVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRINT-KIF-QUANTIFICATION", "(DEFUN PRINT-KIF-QUANTIFICATION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifQuantification", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-TOP-LEVEL-EXISTS-PROPOSITION", "(DEFUN PRINT-KIF-TOP-LEVEL-EXISTS-PROPOSITION ((SELF PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "printKifTopLevelExistsProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), null);
      Stella.defineFunctionObject("PRINT-KIF-WRAPPER", "(DEFUN PRINT-KIF-WRAPPER ((SELF LITERAL-WRAPPER)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printKifWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.LiteralWrapper")}), null);
      Stella.defineFunctionObject("PRINT-KIF-LOGIC-OBJECT", "(DEFUN PRINT-KIF-LOGIC-OBJECT ((SELF LOGIC-OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "printKifLogicObject", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null);
      Stella.defineFunctionObject("PRINT-KIF-SKOLEM", "(DEFUN PRINT-KIF-SKOLEM ((SELF SKOLEM) (SUPPRESSDEFININGPROPOSITION? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Skolem", "printKifSkolem", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Skolem"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRINT-KIF-VARIABLE", "(DEFUN PRINT-KIF-VARIABLE ((SELF PATTERN-VARIABLE)))", Native.find_java_method("edu.isi.powerloom.logic.PatternVariable", "printKifVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.PatternVariable")}), null);
      Stella.defineFunctionObject("PRINT-KIF-STELLA-COLLECTION", "(DEFUN PRINT-KIF-STELLA-COLLECTION ((SELF COLLECTION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printKifStellaCollection", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Collection")}), null);
      Stella.defineFunctionObject("PRINT-KIF-DESCRIPTION", "(DEFUN PRINT-KIF-DESCRIPTION ((SELF DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "printKifDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description")}), null);
      Stella.defineFunctionObject("PRINT-KIF-DESCRIPTION-PROPOSITION", "(DEFUN PRINT-KIF-DESCRIPTION-PROPOSITION ((SELF DESCRIPTION) (INVERT? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "printKifDescriptionProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CHOOSE-IMPLICATION-OPERATOR", "(DEFUN (CHOOSE-IMPLICATION-OPERATOR SURROGATE) ((RULE PROPOSITION) (FORWARD? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "chooseImplicationOperator", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("CREATE-SKOLEM-MAPPING-TABLE", "(DEFUN (CREATE-SKOLEM-MAPPING-TABLE ENTITY-MAPPING) ((OLDVARS VARIABLES-VECTOR) (NEWVARS VARIABLES-VECTOR)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "createSkolemMappingTable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Vector"), Native.find_java_class("edu.isi.stella.Vector")}), null);
      Stella.defineFunctionObject("PRINT-DESCRIPTIONS-AS-KIF-RULE", "(DEFUN PRINT-DESCRIPTIONS-AS-KIF-RULE ((HEAD DESCRIPTION) (TAIL DESCRIPTION) (RULE PROPOSITION) (REVERSEPOLARITY? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Description", "printDescriptionsAsKifRule", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Proposition"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("EXCLUDE-ORIGINATED-PROPOSITIONS", "(DEFUN EXCLUDE-ORIGINATED-PROPOSITIONS ())", Native.find_java_method("edu.isi.powerloom.logic.Logic", "excludeOriginatedPropositions", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("HIDDEN-RELATION?", "(DEFUN (HIDDEN-RELATION? BOOLEAN) ((RELATION-REF SURROGATE)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "hiddenRelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate")}), null);
      Stella.defineFunctionObject("EXCLUDED-PROPOSITION?", "(DEFUN (EXCLUDED-PROPOSITION? BOOLEAN) ((PROPOSITION PROPOSITION) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "excludedPropositionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-NAMED-DESCRIPTION", "(DEFUN PRETTY-PRINT-NAMED-DESCRIPTION ((SELF NAMED-DESCRIPTION) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "prettyPrintNamedDescription", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD DESCRIBE-OBJECT ((SELF NAMED-DESCRIPTION) (STREAM OUTPUT-STREAM) (MODE KEYWORD)) :DOCUMENTATION \"Prints a description of 'self' to stream 'stream'.  'mode'\ncan be :terse, :verbose, or :source.  Used by `describe'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.NamedDescription", "describeObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.OutputStream"), Native.find_java_class("edu.isi.stella.Keyword")}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("STELLA-RELATION-STRINGIFIED-SOURCE", "(DEFUN (STELLA-RELATION-STRINGIFIED-SOURCE STRING) ((SELF RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stellaRelationStringifiedSource", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-RELATION-DEFINITION", "(DEFUN PRETTY-PRINT-RELATION-DEFINITION ((SELF RELATION) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "prettyPrintRelationDefinition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-RELATION-DEFINITION-TREE", "(DEFUN PRETTY-PRINT-RELATION-DEFINITION-TREE ((TREE CONS) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "prettyPrintRelationDefinitionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("HELP-PRETTY-PRINT-RELATION-DEFINITION-TREE", "(DEFUN HELP-PRETTY-PRINT-RELATION-DEFINITION-TREE ((TREE CONS) (STREAM OUTPUT-STREAM) (STARTINDENT INTEGER) (KEYINDENT INTEGER) (FORCEFIRSTKEYONSEPARATELINE? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpPrettyPrintRelationDefinitionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.OutputStream"), java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-ASSERTION", "(DEFUN PRETTY-PRINT-ASSERTION ((PROPOSITION PROPOSITION) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Proposition", "prettyPrintAssertion", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRETTY-PRINT-NAMED-RULE", "(DEFUN PRETTY-PRINT-NAMED-RULE ((RULENAME SURROGATE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "prettyPrintNamedRule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-MODULE-FILE-HEADER", "(DEFUN PRINT-MODULE-FILE-HEADER ((MODULE MODULE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printModuleFileHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineFunctionObject("PRINT-MODULE-FILE-TRAILER", "(DEFUN PRINT-MODULE-FILE-TRAILER ((MODULE MODULE) (STREAM OUTPUT-STREAM)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "printModuleFileTrailer", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.OutputStream")}), null);
      Stella.defineMethodObject("(DEFMETHOD STORE-NATIVE-RELATION ((STORE OBJECT-STORE) (RELATION RELATION)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "storeNativeRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Relation")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD STORE-RELATION ((STORE OBJECT-STORE) (RELATION NAMED-DESCRIPTION)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "storeRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.NamedDescription")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD STORE-ASSERTION ((STORE OBJECT-STORE) (PROPOSITION PROPOSITION)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "storeAssertion", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Proposition")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD STORE-MODULE-HEADER ((STORE OBJECT-STORE) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "storeModuleHeader", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD STORE-MODULE-TRAILER ((STORE OBJECT-STORE) (MODULE MODULE)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "storeModuleTrailer", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD CLEAR-OBJECT-STORE ((STORE OBJECT-STORE)))", Native.find_java_method("edu.isi.powerloom.logic.ObjectStore", "clearObjectStore", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("SAVE-OBJECT", "(DEFUN SAVE-OBJECT ((OBJECT OBJECT) (STORE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveObject", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("DO-SAVE-MODULE", "(DEFUN DO-SAVE-MODULE ((MODULE MODULE) (STORE OBJECT)) :DOCUMENTATION \"Save `module' to the persistent store `store' which can\neither be an output stream or a persistent OBJECT-STORE.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "doSaveModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
    }
  }

  public static void startupKifOut() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupKifOut.helpStartupKifOut1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          _StartupKifOut.helpStartupKifOut2();
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupKifOut.helpStartupKifOut3();
          Stella.defineFunctionObject("SAVE-MODULE", "(DEFUN SAVE-MODULE (|&REST| (OPTIONS OBJECT)) :DOCUMENTATION \"Save all definitions and assertions of the specified :module (which\ndefaults to the current module) to a file or persistent store.  If :file is specified,\nthe KB is saved to that file.  If no :file is specified but the specified :module is\nassociated with a persistent store, the KB will saved to that store, otherwise, an\nerror will be signalled.  The specifics on how a save operation will proceed for a\npersistent store depends on the particular type of store (see respective documentation).\nFor backwards compatibility, this command also supports the old <module> <file> arguments\nspecified without keywords.\" :COMMAND? TRUE :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.powerloom.logic.Logic", "saveModuleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("STARTUP-KIF-OUT", "(DEFUN STARTUP-KIF-OUT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupKifOut", "startupKifOut", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_KIF_OUT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupKifOut"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRETTYPRINTLOGICALFORMS?* BOOLEAN FALSE :PUBLIC? TRUE :DOCUMENTATION \"Controls whether logical forms print on single lines\n(unformatted) or multi-line indented.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRETTYPRINTKIF?* BOOLEAN FALSE :PUBLIC? TRUE :DOCUMENTATION \"Controls whether KIF expressions print on single lines\n(unformatted) or multi-line indented.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRINTLOGICALFORMSTREAM* OUTPUT-STREAM NULL :PUBLIC? TRUE :DOCUMENTATION \"Eliminates necessity of passing stream argument\nthroughout 'print-logical-form' functions.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *DOWNCASEOPERATORS?* BOOLEAN FALSE :PUBLIC? TRUE :DOCUMENTATION \"Controls whether down-casing happens during logical\nform printing (leading to lots more string garbage).\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *LOGIC-DIALECT-PRINT-FUNCTIONS* (KEY-VALUE-LIST OF KEYWORD FUNCTION-CODE-WRAPPER) (NEW (KEY-VALUE-LIST OF KEYWORD FUNCTION-CODE-WRAPPER)) :DOCUMENTATION \"Table to allow extension of the logical form printing code\nby associating keywords with print functions.  Should have values added only\nvia the associated function REGISTER-LOGIC-DIALECT-PRINT-FUNCTION.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *PRINTQUANTIFIEDOBJECTSSTACK* CONS NULL :DOCUMENTATION \"Used to register objects that quantify variables, so we\ncan decide in certain contexts whether to print a variable or its value.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *INDENTCOUNTER* INTEGER 0 :PUBLIC? TRUE :DOCUMENTATION \"The number of spaces prepended during printing a logical form.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *INDENT-QUANTUM* INTEGER 3 :PUBLIC? TRUE :DOCUMENTATION \"The number of spaces added by a call to 'increase-indent'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *TOPLEVELPRINTKIFPROPOSITION?* BOOLEAN TRUE)");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *EXCLUDEDPROPOSITIONS* (HASH-TABLE OF PROPOSITION BOOLEAN-WRAPPER) NULL :PUBLIC? TRUE :DOCUMENTATION \"List of propositions that shouldn't be saved by `save-module'.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *BUILT-IN-MODULE-NAMES* (CONS OF STRING-WRAPPER) (QUOTE (\"PL-USER\" \"PL-KERNEL-KB\" \"PLI\" \"LOOM-API\" \"CYC-FRAME-ONTOLOGY\" \"KIF-FRAME-ONTOLOGY\" \"IDL-THEORY\" \"IDL-USER-THEORY\" \"LOGIC\" \"STELLA\" \"COMMON-LISP\")))");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
