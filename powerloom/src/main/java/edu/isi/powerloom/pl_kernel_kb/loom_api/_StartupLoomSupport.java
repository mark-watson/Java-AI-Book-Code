//  -*- Mode: Java -*-
//
// _StartupLoomSupport.java

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

package edu.isi.powerloom.pl_kernel_kb.loom_api;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.powerloom.pl_kernel_kb.*;

public class _StartupLoomSupport {
  static void helpStartupLoomSupport1() {
    {
      LoomApi.SGT_LOOM_API_LOOM_ROLE = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOM-ROLE", null, 1)));
      LoomApi.SYM_LOOM_API_LOOM_ROLE_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOM-ROLE-OF", null, 0)));
      LoomApi.KWD_DOCUMENTATION = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DOCUMENTATION", null, 2)));
      LoomApi.KWD_AXIOMS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("AXIOMS", null, 2)));
      LoomApi.SYM_LOOM_API_pI = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?I", null, 0)));
      LoomApi.SYM_LOOM_API_pR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?R", null, 0)));
      LoomApi.SYM_LOOM_API_pROLE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?ROLE", null, 0)));
      LoomApi.SYM_LOOM_API_F_FIND_OR_CREATE_LOOM_ROLE_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-FIND-OR-CREATE-LOOM-ROLE-QUERY-000", null, 0)));
      LoomApi.SGT_LOOM_API_LOOM_ROLE_OF = ((Surrogate)(GeneralizedSymbol.internRigidSymbolWrtModule("LOOM-ROLE-OF", null, 1)));
      LoomApi.SYM_LOOM_API_F_GET_LOOM_ROLES_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-LOOM-ROLES-QUERY-000", null, 0)));
      LoomApi.SYM_LOOM_API_pFR = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?FR", null, 0)));
      LoomApi.SYM_LOOM_API_pV = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?V", null, 0)));
      LoomApi.SYM_LOOM_API_FRAME_PREDICATE = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("FRAME-PREDICATE", null, 0)));
      LoomApi.SYM_PL_KERNEL_KB_RANGE_MAX_CARDINALITY = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("RANGE-MAX-CARDINALITY", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      LoomApi.SYM_LOOM_API_INSTANCE_OF = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCE-OF", null, 0)));
      LoomApi.SYM_LOOM_API_F_GET_RELATION_INDUCED_ROLES_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-RELATION-INDUCED-ROLES-QUERY-000", null, 0)));
      LoomApi.SYM_LOOM_API_F_RELATION_OF_LOOM_ROLE_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-RELATION-OF-LOOM-ROLE-QUERY-000", null, 0)));
      LoomApi.KWD_CONCEPTS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("CONCEPTS", null, 2)));
      LoomApi.SYM_LOOM_API_F_LIST_CONTEXT_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-LIST-CONTEXT-QUERY-000", null, 0)));
      LoomApi.KWD_RELATIONS = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("RELATIONS", null, 2)));
      LoomApi.SYM_LOOM_API_F_LIST_CONTEXT_QUERY_001 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-LIST-CONTEXT-QUERY-001", null, 0)));
      LoomApi.KWD_INSTANCES = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("INSTANCES", null, 2)));
      LoomApi.KWD_DIRECT = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("DIRECT", null, 2)));
      LoomApi.KWD_ASSERTED = ((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule("ASSERTED", null, 2)));
      LoomApi.SYM_LOOM_API_pD = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?D", null, 0)));
      LoomApi.SYM_LOOM_API_F_GET_DOMAIN_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-DOMAIN-QUERY-000", null, 0)));
      LoomApi.SYM_LOOM_API_F_GET_RANGE_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-RANGE-QUERY-000", null, 0)));
      LoomApi.SYM_PL_KERNEL_KB_MUTUALLY_DISJOINT_COLLECTION = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("MUTUALLY-DISJOINT-COLLECTION", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      LoomApi.SYM_LOOM_API_F_GET_PARTITIONS_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-GET-PARTITIONS-QUERY-000", null, 0)));
      LoomApi.SYM_LOOM_API_pCOVERED = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("?COVERED", null, 0)));
      LoomApi.SYM_PL_KERNEL_KB_COVERING = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("COVERING", Stella.getStellaModule("/PL-KERNEL-KB", true), 0)));
      LoomApi.SYM_LOOM_API_F_COVERINGp_QUERY_000 = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("F-COVERING?-QUERY-000", null, 0)));
      LoomApi.SYM_LOOM_API_STARTUP_LOOM_SUPPORT = ((Symbol)(GeneralizedSymbol.internRigidSymbolWrtModule("STARTUP-LOOM-SUPPORT", null, 0)));
    }
  }

  public static void startupLoomSupport() {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule("/PL-KERNEL-KB/LOOM-API", Stella.$STARTUP_TIME_PHASE$ > 1));
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        if (Stella.currentStartupTimePhaseP(2)) {
          _StartupLoomSupport.helpStartupLoomSupport1();
        }
        if (Stella.currentStartupTimePhaseP(5)) {
          { Stella_Class renamed_Class = Stella.defineClassFromStringifiedSource("LOOM-ROLE", "(DEFCLASS LOOM-ROLE (THING) :DOCUMENTATION \"\")");

            renamed_Class.classConstructorCode = Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomRole", "newLoomRole", new java.lang.Class [] {});
          }
        }
        if (Stella.currentStartupTimePhaseP(6)) {
          Stella.finalizeClasses();
        }
        if (Stella.currentStartupTimePhaseP(7)) {
          Stella.defineFunctionObject("SAFE-SURROGATIFY", "(DEFUN (SAFE-SURROGATIFY SURROGATE) ((SURROGATEREF OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "safeSurrogatify", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("FIND-OR-CREATE-LOOM-ROLE", "(DEFUN (FIND-OR-CREATE-LOOM-ROLE LOOM-ROLE) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT) (CREATE? BOOLEAN)) :DOCUMENTATION \"Return a LOOM-ROLE instance if 'instanceRef' has\na Loom role named 'relationRef'.  If 'create?', create a role\ninstance if one doesn't already exist.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "findOrCreateLoomRole", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-LOOM-ROLES", "(DEFUN (GET-LOOM-ROLES (CONS OF LOOM-ROLE)) ((INSTANCEREF OBJECT) (INFERROLES? BOOLEAN)) :DOCUMENTATION \"Return a list of LOOM-ROLEs on 'instanceRef'.  If\n'inferRoles', create roles on the fly corresponding to\nframe predicate or domain propositions inherited by 'instance'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getLoomRoles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-RELATION-INDUCED-ROLES", "(DEFUN (GET-RELATION-INDUCED-ROLES (CONS OF LOOM-ROLE)) ((INSTANCEREF OBJECT)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRelationInducedRoles", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("RELATION-OF-LOOM-ROLE", "(DEFUN (RELATION-OF-LOOM-ROLE NAMED-DESCRIPTION) ((ROLE LOOM-ROLE)) :DOCUMENTATION \"Return the relation for the Loom role 'role'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomRole", "relationOfLoomRole", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomRole")}), null);
          Stella.defineFunctionObject("GET-ROLE-NAMES-AND-VALUES", "(DEFUN (GET-ROLE-NAMES-AND-VALUES CONS) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return a list of lists, with each sublist containing\na relation (role) name (a symbol) followed by one or more fillers of\nthat role on 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRoleNamesAndValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-XCONTEXT", "(DEFUN (GET-XCONTEXT MODULE) ((CONTEXTREF OBJECT)) :DOCUMENTATION \"Return the module referenced by 'contextRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getXcontext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-PARENT-CONTEXTS", "(DEFUN (GET-PARENT-CONTEXTS (CONS OF MODULE)) ((MODULEREF OBJECT)) :DOCUMENTATION \"Return a list of parent modules of 'moduleRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getParentContexts", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-CHILD-CONTEXTS", "(DEFUN (GET-CHILD-CONTEXTS (CONS OF MODULE)) ((MODULEREF OBJECT)) :DOCUMENTATION \"Return a list of child modules of 'moduleRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getChildContexts", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CONTEXT-OF-INSTANCE", "(DEFUN (CONTEXT-OF-INSTANCE MODULE) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the home context (a module) of 'instanceRef',\nor NULL if it is not context sensitive.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "contextOfInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CLEAR-USER-CONTEXTS", "(DEFUN CLEAR-USER-CONTEXTS () :DOCUMENTATION \"Destroy the contents of all non-system-defined modules.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "clearUserContexts", new java.lang.Class [] {}), null);
          Stella.defineFunctionObject("LIST-CONTEXT", "(DEFUN (LIST-CONTEXT CONS) ((CONTEXT MODULE) (VALUES KEYWORD)))", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "listContext", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Module"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("RELATION-ARITY", "(DEFUN (RELATION-ARITY INTEGER) ((RELATIONREF OBJECT)) :DOCUMENTATION \"Return the arity of the relation 'relationRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "relationArity", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("FIND-CLASS", "(DEFUN (FIND-CLASS LOGIC-OBJECT) ((INSTANCEREF OBJECT) (MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Return the nearest class with name 'instanceRef' in\nthe module 'module'.  If 'local?' is FALSE, also search modules inherited\nby 'module'.  'instanceRef' can be a string, symbol, or surrogate.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "findClass", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("FIND-RELATION", "(DEFUN (FIND-RELATION LOGIC-OBJECT) ((INSTANCEREF OBJECT) (MODULE MODULE) (LOCAL? BOOLEAN)) :DOCUMENTATION \"Return the nearest relation with name 'instanceRef' in\nthe module 'module'.  If 'local?' is FALSE, also search modules inherited\nby 'module'.  'instanceRef' can be a string, symbol, or surrogate.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "findRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Module"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-INSTANCE-SURROGATE", "(DEFUN (GET-INSTANCE-SURROGATE SURROGATE) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the surrogate pointing to the instance referenced by\n'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getInstanceSurrogate", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-INSTANCE-NAME", "(DEFUN (GET-INSTANCE-NAME SYMBOL) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return the name (a symbol) of the instance referenced by\n'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getInstanceName", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-EQUIVALENT-NAMES", "(DEFUN (GET-EQUIVALENT-NAMES (CONS OF SYMBOL)) ((RELATIONREF OBJECT)) :DOCUMENTATION \"Return a list containing the name of 'relationRef'\nplus the names of any equivalent relations.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getEquivalentNames", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("INSTANCE?", "(DEFUN (INSTANCE? BOOLEAN) ((OBJECTREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'objectRef' is an instance or the\nname of an instance.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "instanceP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("INDIVIDUAL?", "(DEFUN (INDIVIDUAL? BOOLEAN) ((OBJECT OBJECT)) :DOCUMENTATION \"Return TRUE if 'objectRef' is an instance or the\nname of an instance, and does not denote a relation, class, or set.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "individualP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("NAMED?", "(DEFUN (NAMED? BOOLEAN) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return TRUE if the object returned by 'instanceRef'\nis matched with a logical constant.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "namedP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("CREATE-INSTANCE", "(DEFUN (CREATE-INSTANCE OBJECT) ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Create an instance named 'instanceRef'\nof type 'classRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "createInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("FIND-OR-CREATE-INSTANCE", "(DEFUN (FIND-OR-CREATE-INSTANCE LOGIC-OBJECT) ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Find an existing instance refenced by 'instanceRef'\nof type 'classRef', or create one of type 'classRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "findOrCreateInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("INSTANCE-OF?", "(DEFUN (INSTANCE-OF? BOOLEAN) ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Return TRUE if the instance referenced by 'instanceRef'\nbelongs to the class referenced by 'classRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "instanceOfP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("ADD-TYPE", "(DEFUN ADD-TYPE ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Assert that the instance referenced by 'instanceRef'\nis an instance of the class referenced by 'classRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "addType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("REMOVE-TYPE", "(DEFUN REMOVE-TYPE ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Retract that the instance referenced by 'instanceRef'\nis an instance of the class referenced by 'classRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "removeType", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-TYPES", "(DEFUN (GET-TYPES (CONS OF DESCRIPTION)) ((INSTANCEREF OBJECT) (DIRECTORASSERTED KEYWORD)) :DOCUMENTATION \"Return a list of classes that instance belongs to.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getTypes", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Keyword")}), null);
          Stella.defineFunctionObject("UPDATE-ROLE-VALUE", "(DEFUN UPDATE-ROLE-VALUE ((INSTANCEREF OBJECT) (RELATIONREF OBJECT) (VALUEREF OBJECT) (ASSERT? BOOLEAN)) :DOCUMENTATION \"Assert the tuple '(relationRef instanceRef valueRef)',\nor retract if 'assert?' is FALSE.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "updateRoleValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("ADD-ROLE-VALUE", "(DEFUN ADD-ROLE-VALUE ((INSTANCEREF OBJECT) (RELATIONREF OBJECT) (VALUEREF OBJECT)) :DOCUMENTATION \"Assert the tuple '(relationRef instanceRef valueRef)'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "addRoleValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("REMOVE-ROLE-VALUE", "(DEFUN REMOVE-ROLE-VALUE ((INSTANCEREF OBJECT) (RELATIONREF OBJECT) (VALUEREF OBJECT)) :DOCUMENTATION \"Retract the tuple '(relationRef instanceRef valueRef)'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "removeRoleValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-ROLE-VALUE", "(DEFUN (GET-ROLE-VALUE OBJECT) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Return a value for the binary relation 'relationRef'\napplied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRoleValue", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-ROLE-VALUES", "(DEFUN (GET-ROLE-VALUES CONS) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Return a list of values for the binary relation 'relationRef'\napplied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRoleValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-ROLE-DEFAULT-VALUES", "(DEFUN (GET-ROLE-DEFAULT-VALUES CONS) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Return a list of default values for the binary relation\n'relationRef' applied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRoleDefaultValues", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-CLASS-INSTANCES", "(DEFUN (GET-CLASS-INSTANCES CONS) ((CLASSREF OBJECT) (DIRECT? BOOLEAN)) :DOCUMENTATION \"Return a list of instances belonging to the class 'classRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getClassInstances", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("SUBRELATION?", "(DEFUN (SUBRELATION? BOOLEAN) ((SUBRELATIONREF OBJECT) (SUPERRELATIONREF OBJECT)) :DOCUMENTATION \"Return TRUE if 'subrelationRef' specializes 'superrelationRef'.\nSide-effect: Upclassify 'subrelationRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "subrelationP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-SUPERRELATIONS", "(DEFUN (GET-SUPERRELATIONS (CONS OF LOGIC-OBJECT)) ((RELATIONREF OBJECT) (DIRECT? BOOLEAN)) :DOCUMENTATION \"Return a list of relations that generalize 'relationRef'.\nDoes not include relations equivalent to 'relationRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getSuperrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("GET-SUBRELATIONS", "(DEFUN (GET-SUBRELATIONS (CONS OF LOGIC-OBJECT)) ((RELATIONREF OBJECT) (DIRECT? BOOLEAN)) :DOCUMENTATION \"Return a list of relations that specialize 'relationRef'.\nDoes not include relations equivalent to 'relationRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getSubrelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("MOST-SPECIFIC-RELATIONS", "(DEFUN (MOST-SPECIFIC-RELATIONS (CONS OF LOGIC-OBJECT)) ((RELATIONREFS CONS) (CLASSIFYFIRST? BOOLEAN)) :DOCUMENTATION \"Return a list of the most specific among the\nrelations in 'relationRefs'.  If 'classifyFirst?', insure that\nall relations are classified before filtering for most-specific.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "mostSpecificRelations", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("COMPUTE-CONJUNCTION-RELATION", "(DEFUN (COMPUTE-CONJUNCTION-RELATION DESCRIPTION) ((RELATIONREFS (CONS OF NAMED-DESCRIPTION))) :DOCUMENTATION \"Return a relation representing the conjunction\nof relations in 'relationRefs'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "computeConjunctionRelation", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons")}), null);
          Stella.defineFunctionObject("GET-DOMAIN", "(DEFUN (GET-DOMAIN NAMED-DESCRIPTION) ((RELATIONREF OBJECT)) :DOCUMENTATION \"Return the domain of the binary relation 'relationRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getDomain", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-RANGE", "(DEFUN (GET-RANGE NAMED-DESCRIPTION) ((RELATIONREF OBJECT)) :DOCUMENTATION \"Return the range of the binary relation 'relationRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getRange", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-MIN-CARDINALITY", "(DEFUN (GET-MIN-CARDINALITY INTEGER) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Infer a minimum cardinality for the set of fillers of\nthe range of relation 'relationRef' applied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getMinCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-MAX-CARDINALITY", "(DEFUN (GET-MAX-CARDINALITY INTEGER) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Infer a maximum cardinality for the set of fillers of\nthe range of relation 'relationRef' applied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getMaxCardinality", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-VALUE-RESTRICTION", "(DEFUN (GET-VALUE-RESTRICTION DESCRIPTION) ((INSTANCEREF OBJECT) (RELATIONREF OBJECT)) :DOCUMENTATION \"Infer a type restriction on the set of fillers of\nthe range of relation 'relationRef' applied to 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getValueRestriction", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("ASSERT-LOOM-PROPOSITION", "(DEFUN ASSERT-LOOM-PROPOSITION ((LOOMSENTENCE CONS) (RETRACT? BOOLEAN)) :DOCUMENTATION \"Convert each Loom sentence into a KIF equivalent\nand assert it or retract it.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "assertLoomProposition", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), java.lang.Boolean.TYPE}), null);
          Stella.defineFunctionObject("DELETE-INSTANCE", "(DEFUN DELETE-INSTANCE ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Destroy the instance, class or relation 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "deleteInstance", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GENERATE-SOURCE-EXPRESSION", "(DEFUN (GENERATE-SOURCE-EXPRESSION OBJECT) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return an s-expression representing the\nsource expression for 'instanceRef'.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "generateSourceExpression", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("GET-PARTITIONS", "(DEFUN (GET-PARTITIONS CONS) ((CLASSREF OBJECT)) :DOCUMENTATION \"Return a list of partitions that\nspecify disjointness of children of the class classRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "getPartitions", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("DISJOINT-RELATIONS?", "(DEFUN (DISJOINT-RELATIONS? BOOLEAN) ((RELATIONREF1 OBJECT) (RELATIONREF2 OBJECT)) :DOCUMENTATION \"Return TRUE if 'relationRef1' and 'relationRef2' are\ndisjoint.\" :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "disjointRelationsP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COVERING?", "(DEFUN (COVERING? BOOLEAN) ((INSTANCEREF OBJECT) (CLASSREF OBJECT)) :DOCUMENTATION \"Return TRUE if the mutually disjoint collection 'instanceRef'\ncovers 'classRef'.  If 'classRef' is NULL, return TRUE if 'instanceRef' covers\nsome concept.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "coveringP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("COLLECTION-MEMBERS", "(DEFUN (COLLECTION-MEMBERS CONS) ((INSTANCEREF OBJECT)) :DOCUMENTATION \"Return a list of concepts that belong to the collection 'instanceRef'.\")", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api.LoomApi", "collectionMembers", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);
          Stella.defineFunctionObject("STARTUP-LOOM-SUPPORT", "(DEFUN STARTUP-LOOM-SUPPORT () :PUBLIC? TRUE)", Native.find_java_method("edu.isi.powerloom.pl_kernel_kb.loom_api._StartupLoomSupport", "startupLoomSupport", new java.lang.Class [] {}), null);
          { MethodSlot function = Symbol.lookupFunction(LoomApi.SYM_LOOM_API_STARTUP_LOOM_SUPPORT);

            KeyValueList.setDynamicSlotValue(function.dynamicSlots, Logic.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString("_StartupLoomSupport"), Stella.NULL_STRING_WRAPPER);
          }
        }
        if (Stella.currentStartupTimePhaseP(8)) {
          Stella.finalizeSlots();
          Stella.cleanupUnfinalizedClasses();
        }
        if (Stella.currentStartupTimePhaseP(9)) {
          Stella_Object.inModule(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("LOOM-API")))));
          Logic.defrelation(Cons.cons(((Symbol)(Stella_Object.copyConsTree(LoomApi.SYM_LOOM_API_LOOM_ROLE_OF))), Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("(((?C CLASS) (?R RELATION) (?ROLE LOOM-ROLE)) \"/PL-KERNEL-KB/LOOM-API\")", "/PL-KERNEL-KB/LOOM-API")))), Cons.cons(LoomApi.KWD_DOCUMENTATION, Cons.cons(((StringWrapper)(Stella_Object.copyConsTree(StringWrapper.wrapString("")))), Cons.cons(LoomApi.KWD_AXIOMS, Cons.cons(((Cons)(Stella_Object.copyConsTree(Stella.getQuotedTree("((SINGLE-VALUED LOOM-ROLE-OF) \"/PL-KERNEL-KB/LOOM-API\")", "/PL-KERNEL-KB/LOOM-API")))), Stella.NIL)))))));
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

}
