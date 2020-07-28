//  -*- Mode: Java -*-
//
// _StartupKifIn.java

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

public class _StartupKifIn {
  static void helpStartupKifIn1() {
    {
      Logic.SYM_LOGIC_PARSE_TREE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("PARSE-TREE", null, 0)));
      Logic.SGT_STELLA_CONS = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("CONS", Stella.getStellaModule("/STELLA", true), 1)));
      Logic.SYM_STELLA_ISA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ISA", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_EXISTS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("EXISTS", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_FORALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FORALL", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_SETOFALL = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETOFALL", null, 0)));
      Logic.SYM_LOGIC_KAPPA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("KAPPA", null, 0)));
      Logic.SYM_LOGIC_THE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE", null, 0)));
      Logic.SYM_LOGIC_THE_ONLY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("THE-ONLY", null, 0)));
      Logic.SYM_STELLA_e = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_OR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("OR", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_eg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=>", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_legg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<=>>", null, 0)));
      Logic.SYM_LOGIC_lleg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<=>", null, 0)));
      Logic.SYM_LOGIC_llegg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<=>>", null, 0)));
      Logic.SYM_LOGIC_ltg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<~>", null, 0)));
      Logic.SYM_LOGIC_ltgg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<~>>", null, 0)));
      Logic.SYM_LOGIC_lltg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<~>", null, 0)));
      Logic.SYM_LOGIC_lltgg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<~>>", null, 0)));
      Logic.SYM_LOGIC_egg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("=>>", null, 0)));
      Logic.SYM_LOGIC_lle = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<=", null, 0)));
      Logic.SYM_LOGIC_tg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("~>", null, 0)));
      Logic.SYM_LOGIC_lt = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<~", null, 0)));
      Logic.SYM_LOGIC_tgg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("~>>", null, 0)));
      Logic.SYM_LOGIC_llt = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<<~", null, 0)));
      Logic.SYM_LOGIC_ABOUT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ABOUT", null, 0)));
      Logic.SYM_PL_KERNEL_KB_VALUE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("VALUE", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.KWD_DIRECTION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECTION", null, 2)));
      Logic.KWD_BACKWARD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("BACKWARD", null, 2)));
      Logic.KWD_FORWARD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("FORWARD", null, 2)));
      Logic.KWD_CONFIDENCE_LEVEL = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONFIDENCE-LEVEL", null, 2)));
      Logic.KWD_DEFAULT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFAULT", null, 2)));
      Logic.KWD_ABOUT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ABOUT", null, 2)));
      Logic.SYM_PL_KERNEL_KB_HOLDS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("HOLDS", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      Logic.SYM_LOGIC_leg = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("<=>", null, 0)));
      Logic.SYM_LOGIC_LAMBDA = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LAMBDA", null, 0)));
      Logic.SYM_STELLA_SETOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("SETOF", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_LOGIC_LISTOF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LISTOF", null, 0)));
      Logic.SYM_STELLA_WHERE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("WHERE", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.SYM_STELLA_ALWAYS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("ALWAYS", Stella.getStellaModule("/STELLA", true), 0)));
      Logic.KWD_KIF = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("KIF", null, 2)));
      Logic.KWD_STELLA = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("STELLA", null, 2)));
      Logic.KWD_PREFIX_STELLA = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREFIX-STELLA", null, 2)));
      Logic.KWD_MELD = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MELD", null, 2)));
      Logic.KWD_LOOM = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOM", null, 2)));
      Logic.SYM_LOGIC_STARTUP_KIF_IN = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-KIF-IN", null, 0)));
    }
  }

  public static void startupKifIn() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/LOGIC", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupKifIn.helpStartupKifIn1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Logic.$ANNOTATION_TRANSLATION_TABLE$ = Cons.list$(Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_lle, Cons.cons(Logic.SYM_STELLA_le, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_DIRECTION, Cons.cons(Logic.KWD_BACKWARD, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_egg, Cons.cons(Logic.SYM_STELLA_eg, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_DIRECTION, Cons.cons(Logic.KWD_FORWARD, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_lt, Cons.cons(Logic.SYM_STELLA_le, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_CONFIDENCE_LEVEL, Cons.cons(Logic.KWD_DEFAULT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_tg, Cons.cons(Logic.SYM_STELLA_eg, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_CONFIDENCE_LEVEL, Cons.cons(Logic.KWD_DEFAULT, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_llt, Cons.cons(Logic.SYM_STELLA_le, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_CONFIDENCE_LEVEL, Cons.cons(Logic.KWD_DEFAULT, Cons.cons(Logic.KWD_DIRECTION, Cons.cons(Logic.KWD_BACKWARD, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_tgg, Cons.cons(Logic.SYM_STELLA_eg, Cons.cons(Cons.list$(Cons.cons(Logic.KWD_CONFIDENCE_LEVEL, Cons.cons(Logic.KWD_DEFAULT, Cons.cons(Logic.KWD_DIRECTION, Cons.cons(Logic.KWD_FORWARD, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))))));
          Logic.$KIF_SENTENCE_OPERATORS$ = Stella.getQuotedTree("((AND OR NOT FAIL EXISTS FORALL => <= <=> =) \"/LOGIC\")", "/LOGIC");
          Logic.$KIF_TERM_OPERATORS$ = Stella.getQuotedTree("((THE SETOFALL KAPPA LAMBDA COND IF SETOF LISTOF) \"/LOGIC\")", "/LOGIC");
          Logic.$LOGIC_DIALECT$.setDefaultValue(Logic.KWD_KIF);
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE PARSE-TREE OBJECT)");
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("QUESTION-MARK-SYMBOL?", "(DEFUN (QUESTION-MARK-SYMBOL? BOOLEAN) ((SYMBOL OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "questionMarkSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("SEQUENCE-VARIABLE-SYMBOL?", "(DEFUN (SEQUENCE-VARIABLE-SYMBOL? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "sequenceVariableSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("AUTOMATIC-INSTANCE-SYMBOL?", "(DEFUN (AUTOMATIC-INSTANCE-SYMBOL? BOOLEAN) ((SYMBOL OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "automaticInstanceSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-SYMBOL-TO-STELLA-SYMBOL", "(DEFUN (KIF-SYMBOL-TO-STELLA-SYMBOL GENERALIZED-SYMBOL) ((SYMBOL SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifSymbolToStellaSymbol", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("KIF-VARIABLE-TO-STELLA-VARIABLE", "(DEFUN (KIF-VARIABLE-TO-STELLA-VARIABLE SYMBOL) ((VARIABLE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifVariableToStellaVariable", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-VARIABLE-DECLARATION?", "(DEFUN (KIF-VARIABLE-DECLARATION? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifVariableDeclarationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("ONE-KIF-VARIABLE-DECLARATION-TO-STELLA", "(DEFUN (ONE-KIF-VARIABLE-DECLARATION-TO-STELLA OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "oneKifVariableDeclarationToStella", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STELLA-VARIABLE-DECLARATIONS?", "(DEFUN (STELLA-VARIABLE-DECLARATIONS? BOOLEAN) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "stellaVariableDeclarationsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-VARIABLE-DECLARATIONS-TO-STELLA", "(DEFUN (KIF-VARIABLE-DECLARATIONS-TO-STELLA CONS) ((TREE OBJECT) (ERROR? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifVariableDeclarationsToStella", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("KIF-QUANTIFIER-SYMBOL?", "(DEFUN (KIF-QUANTIFIER-SYMBOL? BOOLEAN) ((SELF SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifQuantifierSymbolP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("KIF-THE-TO-STELLA-THE-ONLY", "(DEFUN (KIF-THE-TO-STELLA-THE-ONLY CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifTheToStellaTheOnly", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-SETOFALL-TO-STELLA-SETOFALL", "(DEFUN (KIF-SETOFALL-TO-STELLA-SETOFALL CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifSetofallToStellaSetofall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-KAPPA-TO-STELLA-KAPPA", "(DEFUN (KIF-KAPPA-TO-STELLA-KAPPA CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifKappaToStellaKappa", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-LAMBDA-TO-STELLA-KAPPA", "(DEFUN (KIF-LAMBDA-TO-STELLA-KAPPA CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifLambdaToStellaKappa", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-COND-TO-IF", "(DEFUN (KIF-COND-TO-IF CONS) ((CONDITIONS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifCondToIf", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-INVERT-SENTENCE", "(DEFUN (KIF-INVERT-SENTENCE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifInvertSentence", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-IMPLIES-TO-OR-NOT", "(DEFUN (KIF-IMPLIES-TO-OR-NOT CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifImpliesToOrNot", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-BICONDITIONAL-TO-TWO-IMPLIES", "(DEFUN (KIF-BICONDITIONAL-TO-TWO-IMPLIES CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifBiconditionalToTwoImplies", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-EXISTS-TO-STELLA-EXISTS", "(DEFUN (KIF-EXISTS-TO-STELLA-EXISTS CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifExistsToStellaExists", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-THREE-ARGUMENT-FORALL-TO-STELLA-FORALL", "(DEFUN (KIF-THREE-ARGUMENT-FORALL-TO-STELLA-FORALL CONS) ((TREE CONS) (DECLARATIONS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifThreeArgumentForallToStellaForall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-TWO-ARGUMENT-FORALL-TO-STELLA-FORALL", "(DEFUN (KIF-TWO-ARGUMENT-FORALL-TO-STELLA-FORALL CONS) ((TREE CONS) (DECLARATIONS CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifTwoArgumentForallToStellaForall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-FORALL-TO-STELLA-FORALL", "(DEFUN (KIF-FORALL-TO-STELLA-FORALL CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifForallToStellaForall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-PREDICATION-TO-STELLA-PREDICATION", "(DEFUN (KIF-PREDICATION-TO-STELLA-PREDICATION CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifPredicationToStellaPredication", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("HELP-TRANSFORM-KIF-FUNCTION", "(DEFUN (HELP-TRANSFORM-KIF-FUNCTION CONS) ((ARG1 OBJECT) (ARG2 OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "helpTransformKifFunction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-EQUALITY-TO-STELLA-EQUALITY", "(DEFUN (KIF-EQUALITY-TO-STELLA-EQUALITY CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifEqualityToStellaEquality", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-OPERATOR-TO-INTERNAL-STELLA", "(DEFUN (KIF-OPERATOR-TO-INTERNAL-STELLA SYMBOL) ((OPERATOR SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifOperatorToInternalStella", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("INTERNAL-STELLA-OPERATOR-TO-KIF", "(DEFUN (INTERNAL-STELLA-OPERATOR-TO-KIF SYMBOL) ((OPERATOR SYMBOL)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "internalStellaOperatorToKif", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Symbol")}), null);
          Stella.defineFunctionObject("CHANGE-KIF-EXPRESSIONS-TO-STELLA-EXPRESSIONS", "(DEFUN CHANGE-KIF-EXPRESSIONS-TO-STELLA-EXPRESSIONS ((EXPRESSIONS CONS) (TERMS? BOOLEAN)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "changeKifExpressionsToStellaExpressions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("CANONICALIZE-ANNOTATION", "(DEFUN (CANONICALIZE-ANNOTATION CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "canonicalizeAnnotation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-SENTENCE-TO-UNTYPED-STELLA-SENTENCE", "(DEFUN (KIF-SENTENCE-TO-UNTYPED-STELLA-SENTENCE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifSentenceToUntypedStellaSentence", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("TERM-KIF-SPECIAL-FORM?", "(DEFUN (TERM-KIF-SPECIAL-FORM? BOOLEAN) ((OPERATOR OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "termKifSpecialFormP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-TERM-TO-UNTYPED-STELLA-TERM", "(DEFUN (KIF-TERM-TO-UNTYPED-STELLA-TERM OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifTermToUntypedStellaTerm", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("KIF-VARIABLE?", "(DEFUN (KIF-VARIABLE? BOOLEAN) ((SELF OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifVariableP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("EXTRACT-VARIABLES-FROM-DECLARATIONS", "(DEFUN (EXTRACT-VARIABLES-FROM-DECLARATIONS CONS) ((DECLARATIONS OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "extractVariablesFromDeclarations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COLLECT-UNDECLARED-VARIABLES", "(DEFUN COLLECT-UNDECLARED-VARIABLES ((TREE OBJECT) (DECLAREDVARIABLES CONS) (UNDECLAREDVARIABLES (LIST OF SYMBOL))))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "collectUndeclaredVariables", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.List")}), null);
          Stella.defineFunctionObject("WRAP-KIF-WITH-FORALL", "(DEFUN (WRAP-KIF-WITH-FORALL OBJECT) ((TREE OBJECT) (DECLAREDVARIABLES CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "wrapKifWithForall", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("KIF-EXPRESSION-TO-UNTYPED-STELLA-EXPRESSION", "(DEFUN (KIF-EXPRESSION-TO-UNTYPED-STELLA-EXPRESSION OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "kifExpressionToUntypedStellaExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CONVERT-TO-PREFIX-PROPOSITION-TREE", "(DEFUN (CONVERT-TO-PREFIX-PROPOSITION-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "convertToPrefixPropositionTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("INFIX-TO-PREFIX-QUANTIFICATION-TREE", "(DEFUN (INFIX-TO-PREFIX-QUANTIFICATION-TREE CONS) ((TREE CONS)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "infixToPrefixQuantificationTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("STANDARDIZE-LOGICAL-PARSE-TREE", "(DEFUN (STANDARDIZE-LOGICAL-PARSE-TREE OBJECT) ((TREE OBJECT)))", Native.find_java_method("edu.isi.powerloom.logic.Logic", "standardizeLogicalParseTree", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("IN-DIALECT", "(DEFUN (IN-DIALECT KEYWORD) ((DIALECT NAME)) :DOCUMENTATION \"Change the current logic dialect to `dialect'.\nCurrently supported dialects are `KIF', `STELLA', and `PREFIX-STELLA'.\nThe STELLA dialects are not recommended for the construction of knowledge\nbases, they are mainly used internally by PowerLoom.\" :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE)", Native.find_java_method("edu.isi.powerloom.logic.Logic", "inDialect", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-KIF-IN", "(DEFUN STARTUP-KIF-IN () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.logic._StartupKifIn", "startupKifIn", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Logic.SYM_LOGIC_STARTUP_KIF_IN);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupKifIn"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOGIC")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *AUTOMATIC-INSTANCE-CHARACTER* CHARACTER #\\$ :DOCUMENTATION \"Character that identifies variables representing\ninstances named by the system.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *ANNOTATION-TRANSLATION-TABLE* (CONS OF CONS) (BQUOTE ((<<= <= (:DIRECTION :BACKWARD)) (=>> => (:DIRECTION :FORWARD)) (<~ <= (:CONFIDENCE-LEVEL :DEFAULT)) (~> => (:CONFIDENCE-LEVEL :DEFAULT)) (<<~ <= (:CONFIDENCE-LEVEL :DEFAULT :DIRECTION :BACKWARD)) (~>> => (:CONFIDENCE-LEVEL :DEFAULT :DIRECTION :FORWARD)))))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *KIF-SENTENCE-OPERATORS* (CONS OF SYMBOL) (QUOTE (AND OR NOT FAIL EXISTS FORALL => <= <=> =)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *KIF-TERM-OPERATORS* (CONS OF SYMBOL) (QUOTE (THE SETOFALL KAPPA LAMBDA COND IF SETOF LISTOF)))");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *LOGIC-DIALECT* KEYWORD :KIF :DOCUMENTATION \"Indicates the current dialect of logic used to phrase\nqueries, assertions, and definitions.\")");
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
