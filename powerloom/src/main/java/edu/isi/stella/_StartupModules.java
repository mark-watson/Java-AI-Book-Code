//  -*- Mode: Java -*-
//
// _StartupModules.java

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

public class _StartupModules {
  static void helpStartupModules1() {
    {
      Stella.KWD_CLEAR = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEAR", null, 2)));
      Stella.SGT_STELLA_F_GET_STELLA_MODULE_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-STELLA-MODULE-MEMO-TABLE-000", null, 1)));
      Stella.KWD_MODULE_UPDATE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("MODULE-UPDATE", null, 2)));
      Stella.KWD_INCLUDES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INCLUDES", null, 2)));
      Stella.KWD_USES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("USES", null, 2)));
      Stella.KWD_SHADOW = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("SHADOW", null, 2)));
      Stella.KWD_CASE_SENSITIVEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CASE-SENSITIVE?", null, 2)));
      Stella.KWD_APIp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("API?", null, 2)));
      Stella.SYM_STELLA_APIp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("API?", null, 0)));
      Stella.KWD_LISP_PACKAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("LISP-PACKAGE", null, 2)));
      Stella.KWD_CPP_PACKAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CPP-PACKAGE", null, 2)));
      Stella.KWD_JAVA_PACKAGE = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-PACKAGE", null, 2)));
      Stella.KWD_JAVA_CATCHALL_CLASS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-CATCHALL-CLASS", null, 2)));
      Stella.SYM_STELLA_JAVA_FLOTSAM_CLASS = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("JAVA-FLOTSAM-CLASS", null, 0)));
      Stella.KWD_NICKNAME = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NICKNAME", null, 2)));
      Stella.KWD_CLEARABLEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CLEARABLE?", null, 2)));
      Stella.KWD_PROTECT_SURROGATESp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PROTECT-SURROGATES?", null, 2)));
      Stella.KWD_CODE_ONLYp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CODE-ONLY?", null, 2)));
      Stella.KWD_NAMESPACEp = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("NAMESPACE?", null, 2)));
      Stella.SYM_STELLA_NAMESPACEp = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("NAMESPACE?", null, 0)));
      Stella.KWD_REQUIRES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("REQUIRES", null, 2)));
      Stella.KWD_DESTROY = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DESTROY", null, 2)));
      Stella.KWD_PREORDER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("PREORDER", null, 2)));
      Stella.KWD_TOPDOWN = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("TOPDOWN", null, 2)));
      Stella.SYM_STELLA_DEFINE_MODULE_FROM_STRINGIFIED_SOURCE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("DEFINE-MODULE-FROM-STRINGIFIED-SOURCE", null, 0)));
      Stella.KWD_POSTORDER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("POSTORDER", null, 2)));
      Stella.KWD_INORDER = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INORDER", null, 2)));
      Stella.SGT_STELLA_F_VISIBLE_MODULES_MEMO_TABLE_000 = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("F-VISIBLE-MODULES-MEMO-TABLE-000", null, 1)));
      Stella.SYM_STELLA_STARTUP_MODULES = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-MODULES", null, 0)));
    }
  }

  static void helpStartupModules2() {
    {
      Stella.defineMethodObject("(DEFMETHOD (PARENT-CONTEXTS (ITERATOR OF CONTEXT)) ((SELF CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "parentContexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PARENT-CONTEXTS (ITERATOR OF CONTEXT)) ((SELF MODULE)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "parentContexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (PARENT-CONTEXTS (ITERATOR OF CONTEXT)) ((SELF WORLD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.World", "parentContexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("COMPUTE-CONTEXT-OR-MODULE-FROM-PATHNAME", "(DEFUN (COMPUTE-CONTEXT-OR-MODULE-FROM-PATHNAME CONTEXT INTEGER) ((PATHNAME STRING) (MODULE? BOOLEAN) (SYMBOLNAME? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "computeContextOrModuleFromPathname", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("COMPONENT-MATCH?", "(DEFUN (COMPONENT-MATCH? BOOLEAN) ((COMPONENT STRING) (STRING STRING) (START INTEGER) (END INTEGER)))", Native.find_java_method("edu.isi.stella.Stella", "componentMatchP", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String"), java.lang.Integer.TYPE, java.lang.Integer.TYPE}), null);
      Stella.defineFunctionObject("COMPUTE-MODULE-AND-BARE-NAME", "(DEFUN (COMPUTE-MODULE-AND-BARE-NAME MODULE STRING) ((NAME STRING)) :DOCUMENTATION \"Compute the module indicated by the STELLA name\n`name' and return it.  Return the bare symbol name as the second\nvalue.  `name' does not necessarily have to be qualified in which\ncase the current module is returned.  `name' is assumed to be the\nprinted representation of a STELLA symbol, surrogate or keyword.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "computeModuleAndBareName", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("[Ljava.lang.Object;")}), null);
      Stella.defineFunctionObject("HELP-GET-STELLA-CONTEXT-OR-MODULE", "(DEFUN (HELP-GET-STELLA-CONTEXT-OR-MODULE CONTEXT) ((PATHNAME STRING) (MODULE? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella", "helpGetStellaContextOrModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("GET-STELLA-CONTEXT", "(DEFUN (GET-STELLA-CONTEXT CONTEXT) ((PATHNAME STRING) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return the context located at `pathName', or `null'\nif no such context exists.  If `error?' is `true', throw an exception\nif no context is found, otherwise silently return `null'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "getStellaContext", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("GET-STELLA-MODULE", "(DEFUN (GET-STELLA-MODULE MODULE) ((PATHNAME STRING) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return the module located at `pathName', or `null'\nif no such module exists.  The search looks at ancestors and top-most\n (cardinal) modules.  If `error?' is `true', throw an exception if no\n module is found.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "getStellaModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("HELP-GET-STELLA-MODULE", "(DEFUN (HELP-GET-STELLA-MODULE MODULE) ((PATHNAME STRING) (ERROR? BOOLEAN)) :DOCUMENTATION \"Return the module located at `pathName', or `null'\nif no such module exists.  The search looks at ancestors and top-most\n (cardinal) modules.  If `error?' is `true', throw an exception if no\n module is found.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "helpGetStellaModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COERCE-TO-MODULE-NAME", "(DEFUN (COERCE-TO-MODULE-NAME STRING) ((NAMESPEC NAME) (WARN? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Stella_Object", "coerceToModuleName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("COERCE-TO-MODULE", "(DEFUN (COERCE-TO-MODULE MODULE) ((OBJECT OBJECT) (WARN? BOOLEAN)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella_Object", "coerceToModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("FIND-OR-CREATE-MODULE", "(DEFUN (FIND-OR-CREATE-MODULE MODULE) ((PATHNAME STRING)) :DOCUMENTATION \"Return a module located at `pathname' if one exists,\n  otherwise create one\")", Native.find_java_method("edu.isi.stella.Stella", "findOrCreateModule", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("CHANGE-CURRENT-MODULE", "(DEFUN (CHANGE-CURRENT-MODULE MODULE) ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "changeCurrentModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("CHANGE-CURRENT-CONTEXT", "(DEFUN (CHANGE-CURRENT-CONTEXT CONTEXT) ((CONTEXT CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "changeCurrentContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
      Stella.defineMethodObject("(DEFMETHOD (CHANGE-CONTEXT CONTEXT) ((CONTEXT CONTEXT)) :DOCUMENTATION \"Change the current context to be the context\n'context'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Context", "changeContext", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CHANGE-CONTEXT CONTEXT) ((CONTEXTNAME STRING)) :DOCUMENTATION \"Change the current context to be the context named\n'contextName'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_changeContext", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CHANGE-MODULE MODULE) ((MODULE MODULE)) :DOCUMENTATION \"Change the current module to be the module\n'module'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "changeModule", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (CHANGE-MODULE MODULE) ((MODULENAME STRING)) :DOCUMENTATION \"Change the current module to be the module named\n'moduleName'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_changeModule", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLE-PARENTS? BOOLEAN) ((SELF CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "multipleParentsP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLE-PARENTS? BOOLEAN) ((MODULE MODULE)) :DOCUMENTATION \"Return TRUE if 'module' has more than one parent.\")", Native.find_java_method("edu.isi.stella.Module", "multipleParentsP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("NORMALIZE-PARENT-MODULES", "(DEFUN NORMALIZE-PARENT-MODULES ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "normalizeParentModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineMethodObject("(DEFMETHOD INHERIT-SUPERCONTEXTS ((CONTEXT CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "inheritSupercontexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD INHERIT-SUPERCONTEXTS ((WORLD WORLD)))", Native.find_java_method("edu.isi.stella.World", "inheritSupercontexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD INHERIT-SUPERCONTEXTS ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "inheritSupercontexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD UNINHERIT-SUPERCONTEXTS ((CONTEXT CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "uninheritSupercontexts", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("INHERIT-USED-MODULES", "(DEFUN INHERIT-USED-MODULES ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "inheritUsedModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("UNINHERIT-USED-MODULES", "(DEFUN UNINHERIT-USED-MODULES ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "uninheritUsedModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("FINALIZE-MODULE", "(DEFUN FINALIZE-MODULE ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "finalizeModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("FINALIZE-WORLD", "(DEFUN FINALIZE-WORLD ((SELF WORLD)))", Native.find_java_method("edu.isi.stella.World", "finalizeWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World")}), null);
      Stella.defineMethodObject("(DEFMETHOD UNFINALIZE-MODULE ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "unfinalizeModule", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD UNFINALIZE-WORLD ((SELF WORLD)))", Native.find_java_method("edu.isi.stella.World", "unfinalizeWorld", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("DESTROY-MODULE", "(DEFUN DESTROY-MODULE ((SELF MODULE)) :DOCUMENTATION \"Destroy the module 'self', and recursively destroy\nall contexts that inherit 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "destroyModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("HELP-DESTROY-MODULE", "(DEFUN HELP-DESTROY-MODULE ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "helpDestroyModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("DESTROY-WORLD", "(DEFUN DESTROY-WORLD ((SELF WORLD)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.World", "destroyWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.World")}), null);
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CONTEXT ((SELF MODULE)) :DOCUMENTATION \"Destroy the context 'self', and recursively destroy\nall contexts that inherit 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "destroyContext", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CONTEXT ((SELF WORLD)) :DOCUMENTATION \"Destroy the context 'self', and recursively destroy\nall contexts that inherit 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.World", "destroyContext", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CONTEXT ((SELF STRING)) :DOCUMENTATION \"Destroy the context 'self', and recursively destroy\nall contexts that inherit 'self'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "string_destroyContext", new java.lang.Class [] {Native.find_java_class("java.lang.String")}), ((java.lang.reflect.Method)(null)));
      Stella.defineMethodObject("(DEFMETHOD DESTROY-CONTEXT ((SELF CONTEXT)) :PUBLIC? TRUE :DOCUMENTATION \"Make the translator happy.\")", Native.find_java_method("edu.isi.stella.Context", "destroyContext", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("LINK-TO-PARENT-MODULE", "(DEFUN LINK-TO-PARENT-MODULE ((SELF MODULE) (PARENT MODULE) (INSERT-FIRST? BOOLEAN)))", Native.find_java_method("edu.isi.stella.Module", "linkToParentModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
      Stella.defineFunctionObject("INCORPORATE-MODULE-NAME", "(DEFUN INCORPORATE-MODULE-NAME ((MODULE MODULE) (NAME STRING)))", Native.find_java_method("edu.isi.stella.Module", "incorporateModuleName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("INCORPORATE-INCLUDES-MODULES", "(DEFUN INCORPORATE-INCLUDES-MODULES ((MODULE MODULE) (INCLUDEES OBJECT)))", Native.find_java_method("edu.isi.stella.Module", "incorporateIncludesModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INCORPORATE-USES-MODULES", "(DEFUN INCORPORATE-USES-MODULES ((MODULE MODULE) (USEES OBJECT)))", Native.find_java_method("edu.isi.stella.Module", "incorporateUsesModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("TRUE-OPTION?", "(DEFUN (TRUE-OPTION? BOOLEAN) ((VALUE OBJECT)) :GLOBALLY-INLINE? TRUE (RETURN (OR (EQL? VALUE (QUOTE TRUE)) (EQL? VALUE TRUE-WRAPPER) (AND (ISA? VALUE @SYMBOL) (STRING-EQUAL? (SYMBOL-NAME (CAST VALUE SYMBOL)) \"TRUE\")))))", Native.find_java_method("edu.isi.stella.Stella_Object", "trueOptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("INCORPORATE-MODULE-OPTIONS", "(DEFUN INCORPORATE-MODULE-OPTIONS ((SELF MODULE) (OPTIONS CONS)))", Native.find_java_method("edu.isi.stella.Module", "incorporateModuleOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("UNDEFINE-MODULE", "(DEFUN UNDEFINE-MODULE ((OLDMODULE MODULE) (NEWMODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "undefineModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("DEFINE-MODULE", "(DEFUN (DEFINE-MODULE MODULE) ((NAME STRING) (OPTIONS CONS)) :DOCUMENTATION \"Define or redefine a module named 'name' having the\noptions 'options'.  Return the new module.\" :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.Module", "defineModule", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("edu.isi.stella.Cons")}), null);
      Stella.defineFunctionObject("UPDATE-NON-STRUCTURAL-MODULE-OPTIONS", "(DEFUN UPDATE-NON-STRUCTURAL-MODULE-OPTIONS ((OLDMODULE MODULE) (NEWMODULE MODULE) (NEWOPTIONS STRING)))", Native.find_java_method("edu.isi.stella.Module", "updateNonStructuralModuleOptions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("IDENTICAL-MODULE-STRUCTURE?", "(DEFUN (IDENTICAL-MODULE-STRUCTURE? BOOLEAN) ((OLDMODULE MODULE) (NEWMODULE MODULE) (NEWOPTIONS STRING)))", Native.find_java_method("edu.isi.stella.Module", "identicalModuleStructureP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("DEFINE-MODULE-FROM-STRINGIFIED-SOURCE", "(DEFUN (DEFINE-MODULE-FROM-STRINGIFIED-SOURCE MODULE) ((NAME STRING) (STRINGIFIEDOPTIONS STRING)) :PUBLIC? TRUE :CONSTRUCTOR? TRUE)", Native.find_java_method("edu.isi.stella.Module", "defineModuleFromStringifiedSource", new java.lang.Class [] {Native.find_java_class("java.lang.String"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineFunctionObject("YIELD-DEFINE-MODULE", "(DEFUN (YIELD-DEFINE-MODULE CONS) ((MODULE MODULE)))", Native.find_java_method("edu.isi.stella.Module", "yieldDefineModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
      Stella.defineFunctionObject("DEFMODULE", "(DEFUN DEFMODULE ((NAME NAME) |&REST| (OPTIONS OBJECT)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Define (or redefine) a module named `name'.\nThe accepted syntax is:\n	 \n  (defmodule <module-name>\n     [:documentation <docstring>]\n     [:includes {<module-name> | (<module-name>*)}]\n     [:uses {<module-name> | (<module-name>*)}]\n     [:lisp-package <package-name-string>]\n     [:java-package <package-specification-string>]\n     [:cpp-namespace <namespace-name-string>]\n     [:java-catchall-class\n     [:api? {TRUE | FALSE}]\n     [:case-sensitive? {TRUE | FALSE}]\n     [:shadow (<symbol>*)]\n     [:java-catchall-class <class-name-string>]\n     [<other-options>*])\n	\n`name' can be a string or a symbol.\n\nModules include objects from other modules via two separate mechanisms:\n(1) they inherit from their parents specified via the `:includes' option\nand/or a fully qualified module name, and (2) they inherit from used\nmodules specified via the `:uses' option.  The main difference between\nthe two mechanisms is that inheritance from parents is transitive, while\nuses-links are only followed one level deep.  I.e., a module A that uses\nB will see all objects of B (and any of B's parents) but not see anything\nfrom modules used by B.  Another difference is that only objects declared\nas public can be inherited via uses-links (this is not yet enforced).\nNote that - contrary to Lisp - there are separate name spaces for classes,\nfunctions, and variables.  For example, a module could inherit the class\n`CONS' from the `STELLA' module, but shadow the function of the same name.\n\nThe above discussion of `:includes' and `:uses' semantics keyed on the\ninheritance/visibility of symbols. The PowerLoom system makes another\nvery important distinction: If a module 'A' is inherited directly or\nindirectly via `:includes' specification(s) by a submodule 'B', then all\ndefinitions and facts asserted in 'A' are visible in 'B'. This is not the\ncases for `:uses'; the `:uses' options does not impact inheritance of\npropositions at all.\n\nThe list of modules specified in the\n`:includes' option plus (if supplied) the parent in the path used for\n`name' become the new module's parents. If no `:uses' option was\nsupplied, the new module will use the `STELLA' module by default,\notherwise, it will use the set of specified modules.\n\nIf `:case-sensitive?' is supplied as TRUE, symbols in the module\nwill be interned case-sensitively, otherwise (the default), they\nwill be converted to uppercase before they get interned.  That\nmeans that any reference from inside a case-sensitive module to a\nnon-case-sensitive module will have to use uppercase names for\nsymbols in the non-case-sensitive module.  The standard system\nmodules are all NOT case sensitive.\n\nModules can shadow definitions of functions and classes inherited\nfrom parents or used modules. Shadowing is done automatically,\nbut generates a warning unless the shadowed type or function name\nis listed in the `:shadow' option of the module definition .\n\nExamples:\n	 \n  (defmodule \\\"PL-KERNEL/PL-USER\\\"\n    :uses (\\\"LOGIC\\\" \\\"STELLA\\\")\n    :package \\\"PL-USER\\\")\n\n  (defmodule PL-USER/GENEALOGY)\n	\nThe remaining options are relevant only for modules that contain STELLA\ncode.  Modules used only to contain knowledge base definitions and assertions\nhave no use for them:\n\nThe keywords `:lisp-package', `:java-package', and `:cpp-package' specify\nthe name of a native package or name space in which symbols of the module\nshould be allocated when they get translated into one of Lisp, Java, or\nC++. By default, Lisp symbols are allocated in the `STELLA' package, and\nC++ names are translated without any prefixes. The rules that the STELLA\ntranslator uses to attach translated Java objects to classes and packages\nare somewhat complex. Use :java-package option to specify a list of\npackage names (separated by periods) that prefix the Java object in this\nmodule.  Use :java-catchall-class to specify the name of the Java class to\nco" + "ntain all global & special variables, parameter-less functions and functions \ndefined on arguments that are not classes in the current module.\nThe default value will be the name of the module.\n\nWhen set to TRUE, the :api? option tells the PowerLoom User Manual\ngenerator that all functions defined in this module should be included in\nthe API section. Additionally, the Java translator makes all API\nfunctions `synchronized'.\n\")", Native.find_java_method("edu.isi.stella.Stella_Object", "defmodule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "defmoduleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
      Stella.defineFunctionObject("IN-MODULE", "(DEFUN (IN-MODULE MODULE) ((NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :LISP-MACRO? TRUE :DOCUMENTATION \"Change the current module to the module named `name'.\")", Native.find_java_method("edu.isi.stella.Stella_Object", "inModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
      Stella.defineFunctionObject("CREATE-WORLD", "(DEFUN (CREATE-WORLD WORLD) ((PARENTCONTEXT CONTEXT) (NAME STRING)) :DOCUMENTATION \"Create a new world below the world or module 'parentContext'.\nOptionally, specify a name.\" :PUBLIC? TRUE :INLINE FINALIZE-WORLD)", Native.find_java_method("edu.isi.stella.Context", "createWorld", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("java.lang.String")}), null);
      Stella.defineMethodObject("(DEFMETHOD (MULTIPLE-PARENTS? BOOLEAN) ((WORLD WORLD)) :DOCUMENTATION \"Return FALSE always, since worlds never have more than one parent.\")", Native.find_java_method("edu.isi.stella.World", "multipleParentsP", new java.lang.Class [] {}), ((java.lang.reflect.Method)(null)));
      Stella.defineFunctionObject("PUSH-WORLD", "(DEFUN (PUSH-WORLD WORLD) () :DOCUMENTATION \"Spawn a new world that is a child of the current context,\nand change the current context to the new world.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "pushWorld", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("POP-WORLD", "(DEFUN (POP-WORLD CONTEXT) () :DOCUMENTATION \"Destroy the current world and change the current\ncontext to be its parent.  Return the current context. Nothing happens\nif there is no current world.\" :PUBLIC? TRUE :COMMAND? TRUE)", Native.find_java_method("edu.isi.stella.Stella", "popWorld", new java.lang.Class [] {}), null);
      Stella.defineFunctionObject("ALL-SUBCONTEXTS", "(DEFUN (ALL-SUBCONTEXTS (ALL-PURPOSE-ITERATOR OF CONTEXT)) ((CONTEXT CONTEXT) (TRAVERSAL KEYWORD)) :DOCUMENTATION \"Return an iterator that generates all subcontexts of\n'self' (not including 'self') in the order specified by 'traversal' (one\nof :preorder, :inorder, :postorder or :topdown).\")", Native.find_java_method("edu.isi.stella.Context", "allSubcontexts", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
      Stella.defineFunctionObject("ALL-SUBCONTEXTS-NEXT?", "(DEFUN (ALL-SUBCONTEXTS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSubcontextsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
      Stella.defineFunctionObject("ALL-TOPDOWN-SUBCONTEXTS-NEXT?", "(DEFUN (ALL-TOPDOWN-SUBCONTEXTS-NEXT? BOOLEAN) ((SELF ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allTopdownSubcontextsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
    }
  }

  public static void startupModules() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.$STELLA_MODULE$);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupModules.helpStartupModules1();
        }
        if (Stella.currentStartupTimePhaseP(4)) {
          Stella.$SUBCONTEXT_REVISION_POLICY$ = Stella.KWD_CLEAR;
          Stella.$SHADOWEDSURROGATES$.setDefaultValue(null);
          Stella.$DEFINE_MODULE_HOOKS$ = HookList.newHookList();
          Stella.$MODULE_NON_STRUCTURAL_OPTIONS$ = Cons.cons(Stella.KWD_DOCUMENTATION, Stella.NIL);
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          Stella.defineStellaTypeFromStringifiedSource("(DEFTYPE NAME OBJECT)");
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          _StartupModules.helpStartupModules2();
          Stella.defineFunctionObject("ALL-CONTEXTS", "(DEFUN (ALL-CONTEXTS (ITERATOR OF CONTEXT)) () :PUBLIC? TRUE :DOCUMENTATION \"Return an iterator that generates all contexts.\")", Native.find_java_method("edu.isi.stella.Stella", "allContexts", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("FILTER-MODULE?", "(DEFUN (FILTER-MODULE? BOOLEAN) ((SELF OBJECT) (ITERATOR ALL-PURPOSE-ITERATOR)))", Native.find_java_method("edu.isi.stella.Stella_Object", "filterModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), null);
          Stella.defineFunctionObject("ALL-MODULES", "(DEFUN (ALL-MODULES (ITERATOR OF MODULE)) () :PUBLIC? TRUE :DOCUMENTATION \"Return an iterator that generates all modules.\")", Native.find_java_method("edu.isi.stella.Stella", "allModules", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LIST-MODULES", "(DEFUN (LIST-MODULES (CONS OF MODULE)) ((KB-ONLY? BOOLEAN)) :PUBLIC? TRUE :COMMAND? TRUE :DOCUMENTATION \"Returns a cons of all modules defined in PowerLoom.  If `kb-only?'\nis `true', then any modules which are code only or just namespaces are not returned.\")", Native.find_java_method("edu.isi.stella.Stella", "listModules", new java.lang.Class [] {java.lang.Boolean.TYPE}), Native.find_java_method("edu.isi.stella.Cons", "listModulesEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("ALL-INCLUDED-MODULES", "(DEFUN (ALL-INCLUDED-MODULES (ITERATOR OF MODULE)) ((SELF MODULE)) :PUBLIC? TRUE :DOCUMENTATION \"Generate a sequence of all modules included\nby 'self', inclusive, starting from the highest ancestor and working\ndown to 'self' (which is last).\")", Native.find_java_method("edu.isi.stella.Module", "allIncludedModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("VISIBLE-MODULES", "(DEFUN (VISIBLE-MODULES (CONS OF MODULE)) ((FROM MODULE)) :DOCUMENTATION \"Return a list of all modules visible from module `from' (or `*module*'\nif `from' is NULL.  The generated modules are generated from most to\nleast-specific and will start with the module `from'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Module", "visibleModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("HELP-MEMOIZE-VISIBLE-MODULES", "(DEFUN (HELP-MEMOIZE-VISIBLE-MODULES (CONS OF MODULE)) ((FROM MODULE)))", Native.find_java_method("edu.isi.stella.Module", "helpMemoizeVisibleModules", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("CARDINAL-MODULE?", "(DEFUN (CARDINAL-MODULE? BOOLEAN) ((SELF MODULE)))", Native.find_java_method("edu.isi.stella.Module", "cardinalModuleP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module")}), null);
          Stella.defineFunctionObject("VISIBLE-FROM?", "(DEFUN (VISIBLE-FROM? BOOLEAN) ((VIEWEDCONTEXT CONTEXT) (FROMCONTEXT CONTEXT)) :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella.Context", "visibleFromP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context"), Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("CLEAR-ONE-CONTEXT", "(DEFUN CLEAR-ONE-CONTEXT ((SELF CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "clearOneContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("HELP-CLEAR-CONTEXT", "(DEFUN HELP-CLEAR-CONTEXT ((SELF CONTEXT)))", Native.find_java_method("edu.isi.stella.Context", "helpClearContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("CLEAR-CONTEXT", "(DEFUN CLEAR-CONTEXT ((SELF CONTEXT)) :PUBLIC? TRUE :DOCUMENTATION \"Destroy all objects belonging to 'self' or any of its subcontexts.\")", Native.find_java_method("edu.isi.stella.Context", "clearContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Context")}), null);
          Stella.defineFunctionObject("CALL-CLEAR-MODULE", "(DEFUN CALL-CLEAR-MODULE (|&REST| (NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? TRUE :LISP-MACRO? FALSE :DOCUMENTATION \"Destroy all objects belonging to module `name' or any of its children.\nIf no `name' is supplied, the current module will be cleared after\nconfirming with the user.  Important modules such as STELLA are protected\nagainst accidental clearing.\")", Native.find_java_method("edu.isi.stella.Stella", "callClearModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "callClearModuleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("CLEAR-MODULE", "(DEFUN CLEAR-MODULE (|&REST| (NAME NAME)) :PUBLIC? TRUE :COMMAND? TRUE :EVALUATE-ARGUMENTS? FALSE :DOCUMENTATION \"Destroy all objects belonging to module `name' or any of its children.\nIf no `name' is supplied, the current module will be cleared after\nconfirming with the user.  Important modules such as STELLA are protected\nagainst accidental clearing.\")", Native.find_java_method("edu.isi.stella.Stella", "clearModule", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), Native.find_java_method("edu.isi.stella.Cons", "clearModuleEvaluatorWrapper", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}));
          Stella.defineFunctionObject("STARTUP-MODULES", "(DEFUN STARTUP-MODULES () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.stella._StartupModules", "startupModules", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(Stella.SYM_STELLA_STARTUP_MODULES);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupModules"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("STELLA")))));
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *SUBCONTEXT-REVISION-POLICY* KEYWORD :CLEAR :DOCUMENTATION \"Controls actions reflexive transitive closure of\n   subcontexts when a context is revised.\n   Values are ':destroy' -- destroy subcontexts;\n   ':clear' -- clear contents of subcontexts;\n   ':preserve' -- don't disturb subcontexts.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFSPECIAL *SHADOWEDSURROGATES* (CONS OF SYMBOL) NULL :DOCUMENTATION \"Holds list of symbols representing surrogates\nto be shadowed during module finalization.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *DEFINE-MODULE-HOOKS* HOOK-LIST (NEW HOOK-LIST) :DOCUMENTATION \"HOOK-LIST called by 'define-module', applied to a\n'module' argument.\")");
          Stella.defineStellaGlobalVariableFromStringifiedSource("(DEFGLOBAL *MODULE-NON-STRUCTURAL-OPTIONS* (CONS OF KEYWORD) (BQUOTE (:DOCUMENTATION)) :PUBLIC? FALSE :DOCUMENTATION \"List of non-structural options for Module definitions.\nUsed in testing for module changes and in updating non-structurally changed\nmodules.\")");
          KeyValueList.setDynamicSlotValue(Stella.$ROOT_MODULE$.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
          KeyValueList.setDynamicSlotValue(Stella.$STELLA_MODULE$.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
          KeyValueList.setDynamicSlotValue(Stella.$COMMON_LISP_MODULE$.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, Stella.FALSE_WRAPPER, Stella.FALSE_WRAPPER);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
