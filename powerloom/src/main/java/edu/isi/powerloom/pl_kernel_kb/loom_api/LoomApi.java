//  -*- Mode: Java -*-
//
// LoomApi.java

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

public class LoomApi {
  public static Surrogate SGT_LOOM_API_LOOM_ROLE = null;

  public static Symbol SYM_LOOM_API_LOOM_ROLE_OF = null;

  public static Keyword KWD_DOCUMENTATION = null;

  public static Keyword KWD_AXIOMS = null;

  public static Symbol SYM_LOOM_API_pI = null;

  public static Symbol SYM_LOOM_API_pR = null;

  public static Symbol SYM_LOOM_API_pROLE = null;

  public static Symbol SYM_LOOM_API_F_FIND_OR_CREATE_LOOM_ROLE_QUERY_000 = null;

  public static Surrogate SGT_LOOM_API_LOOM_ROLE_OF = null;

  public static Symbol SYM_LOOM_API_F_GET_LOOM_ROLES_QUERY_000 = null;

  public static Symbol SYM_LOOM_API_pFR = null;

  public static Symbol SYM_LOOM_API_pV = null;

  public static Symbol SYM_LOOM_API_FRAME_PREDICATE = null;

  public static Symbol SYM_PL_KERNEL_KB_RANGE_MAX_CARDINALITY = null;

  public static Symbol SYM_LOOM_API_INSTANCE_OF = null;

  public static Symbol SYM_LOOM_API_F_GET_RELATION_INDUCED_ROLES_QUERY_000 = null;

  public static Symbol SYM_LOOM_API_F_RELATION_OF_LOOM_ROLE_QUERY_000 = null;

  public static Keyword KWD_CONCEPTS = null;

  public static Symbol SYM_LOOM_API_F_LIST_CONTEXT_QUERY_000 = null;

  public static Keyword KWD_RELATIONS = null;

  public static Symbol SYM_LOOM_API_F_LIST_CONTEXT_QUERY_001 = null;

  public static Keyword KWD_INSTANCES = null;

  public static Keyword KWD_DIRECT = null;

  public static Keyword KWD_ASSERTED = null;

  public static Symbol SYM_LOOM_API_pD = null;

  public static Symbol SYM_LOOM_API_F_GET_DOMAIN_QUERY_000 = null;

  public static Symbol SYM_LOOM_API_F_GET_RANGE_QUERY_000 = null;

  public static Symbol SYM_PL_KERNEL_KB_MUTUALLY_DISJOINT_COLLECTION = null;

  public static Symbol SYM_LOOM_API_F_GET_PARTITIONS_QUERY_000 = null;

  public static Symbol SYM_LOOM_API_pCOVERED = null;

  public static Symbol SYM_PL_KERNEL_KB_COVERING = null;

  public static Symbol SYM_LOOM_API_F_COVERINGp_QUERY_000 = null;

  public static Symbol SYM_LOOM_API_STARTUP_LOOM_SUPPORT = null;

  public static Surrogate safeSurrogatify(Stella_Object surrogateref) {
    if (surrogateref == null) {
      return (null);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(surrogateref);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper surrogateref000 = ((StringWrapper)(surrogateref));

          return (Stella.stringToSurrogate(surrogateref000.wrapperValue));
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate surrogateref000 = ((Surrogate)(surrogateref));

          return (surrogateref000);
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol surrogateref000 = ((Symbol)(surrogateref));

          return (Symbol.symbolToSurrogate(surrogateref000));
        }
      }
      else {
        return (null);
      }
    }
  }

  /** Return a LOOM-ROLE instance if 'instanceRef' has
   * a Loom role named 'relationRef'.  If 'create?', create a role
   * instance if one doesn't already exist.
   * @param instanceref
   * @param relationref
   * @param createP
   * @return LoomRole
   */
  public static LoomRole findOrCreateLoomRole(Stella_Object instanceref, Stella_Object relationref, boolean createP) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      LogicObject relation = Logic.getRelation(relationref);
      LoomRole role = null;

      if ((instance == null) ||
          (relation == null)) {
        return (null);
      }
      role = ((LoomRole)(Logic.applyCachedRetrieve(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pROLE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_LOOM_ROLE_OF, Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pROLE, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.consList(Cons.cons(instance, Cons.cons(relation, Cons.cons(null, Stella.NIL)))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_FIND_OR_CREATE_LOOM_ROLE_QUERY_000, new Object[2]).value));
      if ((role != null) ||
          (!createP)) {
        return (role);
      }
      role = ((LoomRole)(Logic.createLogicInstance(null, LoomApi.SGT_LOOM_API_LOOM_ROLE)));
      Logic.assertTuple(LoomApi.SGT_LOOM_API_LOOM_ROLE_OF, Cons.consList(Cons.cons(instance, Cons.cons(relation, Cons.cons(role, Stella.NIL)))));
      return (role);
    }
  }

  /** Return a list of LOOM-ROLEs on 'instanceRef'.  If
   * 'inferRoles', create roles on the fly corresponding to
   * frame predicate or domain propositions inherited by 'instance'.
   * @param instanceref
   * @param inferrolesP
   * @return Cons
   */
  public static Cons getLoomRoles(Stella_Object instanceref, boolean inferrolesP) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      if (instance == null) {
        return (null);
      }
      if (inferrolesP) {
        LoomApi.getRelationInducedRoles(instance);
      }
      return (Logic.applyCachedRetrieve(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(LoomApi.SYM_LOOM_API_pROLE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_LOOM_ROLE_OF, Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pROLE, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(instance, Cons.cons(null, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_GET_LOOM_ROLES_QUERY_000, new Object[2]));
    }
  }

  public static Cons getRelationInducedRoles(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Cons relations = Stella.NIL;
      Cons roles = Stella.NIL;

      if (instance == null) {
        return (null);
      }
      relations = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_STELLA_OR, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pFR, Cons.cons(LoomApi.SYM_LOOM_API_pV, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_FRAME_PREDICATE, Cons.cons(LoomApi.SYM_LOOM_API_pFR, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_HOLDS, Cons.cons(LoomApi.SYM_LOOM_API_pFR, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(LoomApi.SYM_LOOM_API_pV, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_e, Cons.cons(LoomApi.SYM_LOOM_API_pFR, Cons.cons(LoomApi.SYM_PL_KERNEL_KB_RANGE_MAX_CARDINALITY, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_e, Cons.cons(LoomApi.SYM_LOOM_API_pV, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(Cons.cons(Logic.SYM_LOGIC_pC, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_INSTANCE_OF, Cons.cons(LoomApi.SYM_LOOM_API_pI, Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_DOMAIN, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(null, Cons.cons(instance, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_GET_RELATION_INDUCED_ROLES_QUERY_000, new Object[2]);
      { Stella_Object r = null;
        Cons iter000 = relations;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          r = iter000.value;
          roles = Cons.cons(LoomApi.findOrCreateLoomRole(instance, r, true), roles);
        }
      }
      return (roles);
    }
  }

  /** Return a list of lists, with each sublist containing
   * a relation (role) name (a symbol) followed by one or more fillers of
   * that role on 'instanceRef'.
   * @param instanceref
   * @return Cons
   */
  public static Cons getRoleNamesAndValues(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      KeyValueList table = KeyValueList.newKeyValueList();

      if (instance == null) {
        return (null);
      }
      { Proposition p = null;
        Iterator iter000 = ((Iterator)(Logic.allTrueDependentPropositions(instance, null, true).concatenate(Logic.allTrueDependentPropositions(instance, null, true), Stella.NIL)));

        while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          if ((p.arguments.length() == 2) &&
              Stella_Object.eqlP((p.arguments.theArray)[0], instance)) {
            { Symbol relation = Symbol.internSymbolInModule(((Surrogate)(p.operator)).symbolName, ((Module)(((Surrogate)(p.operator)).homeContext)), true);
              Stella_Object filler = Logic.valueOf((p.arguments.theArray)[1]);

              if (filler != null) {
                { Cons bucket = ((Cons)(table.lookup(relation)));

                  if (bucket == null) {
                    table.insertAt(relation, Cons.consList(Cons.cons(filler, Stella.NIL)));
                  }
                  else {
                    table.insertAt(relation, Cons.cons(filler, bucket));
                  }
                }
              }
            }
          }
        }
      }
      { Cons result = Stella.NIL;

        { Stella_Object key = null;
          Stella_Object value = null;
          KvCons iter001 = table.theKvList;

          for (;iter001 != null; iter001 = iter001.rest) {
            key = iter001.key;
            value = iter001.value;
            result = Cons.cons(Cons.cons(key, ((Cons)(value)).concatenate(Stella.NIL, Stella.NIL)), result);
          }
        }
        return (result);
      }
    }
  }

  /** Return the module referenced by 'contextRef'.
   * @param contextref
   * @return Module
   */
  public static Module getXcontext(Stella_Object contextref) {
    return (Logic.getModule(contextref));
  }

  /** Return a list of parent modules of 'moduleRef'.
   * @param moduleref
   * @return Cons
   */
  public static Cons getParentContexts(Stella_Object moduleref) {
    { Module module = Logic.getModule(moduleref);

      if (module == null) {
        return (null);
      }
      else {
        return (module.parentModules.consify());
      }
    }
  }

  /** Return a list of child modules of 'moduleRef'.
   * @param moduleref
   * @return Cons
   */
  public static Cons getChildContexts(Stella_Object moduleref) {
    { Module module = Logic.getModule(moduleref);
      Cons children = Stella.NIL;

      if (module == null) {
        return (null);
      }
      { Context cxt = null;
        Cons iter000 = module.childContexts.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          cxt = ((Context)(iter000.value));
          if (Stella_Object.isaP(cxt, Logic.SGT_STELLA_MODULE)) {
            children = Cons.cons(cxt, children);
          }
        }
      }
      return (children);
    }
  }

  /** Return the home context (a module) of 'instanceRef',
   * or NULL if it is not context sensitive.
   * @param instanceref
   * @return Module
   */
  public static Module contextOfInstance(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      if (instance == null) {
        return (null);
      }
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(instance), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject instance000 = ((LogicObject)(instance));

          return (((Module)(instance000.homeContext)));
        }
      }
      else {
        return (null);
      }
    }
  }

  /** Destroy the contents of all non-system-defined modules.
   */
  public static void clearUserContexts() {
    { Module mdl = null;
      Iterator iter000 = Stella.allModules();

      while (iter000.nextP()) {
        mdl = ((Module)(iter000.value));
        if (mdl.clearableP() &&
            (!Cons.consList(Cons.cons(Logic.$PL_KERNEL_MODULE$, Stella.NIL)).memberP(mdl))) {
          Stella.STANDARD_OUTPUT.nativeStream.println("Clearing: " + mdl);
          Stella.callClearModule(Cons.cons(mdl, Stella.NIL));
        }
      }
    }
  }

  public static Cons listContext(Module context, Keyword values) {
    { Object old$Context$000 = Stella.$CONTEXT$.get();
      Object old$Module$000 = Stella.$MODULE$.get();

      try {
        Native.setSpecial(Stella.$CONTEXT$, context);
        Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
        if (values == Logic.KWD_ALL) {
          return (Logic.allNamedTerms(context, false).consify());
        }
        else if (values == LoomApi.KWD_CONCEPTS) {
          return (Logic.applyCachedRetrieve(Cons.cons(Logic.SYM_LOGIC_pX, Stella.NIL), Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CLASS, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.consList(Cons.cons(null, Stella.NIL)), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_LIST_CONTEXT_QUERY_000, new Object[2]));
        }
        else if (values == LoomApi.KWD_RELATIONS) {
          return (Logic.applyCachedRetrieve(Cons.cons(Logic.SYM_LOGIC_pX, Stella.NIL), Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_RELATION, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_FAIL, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CLASS, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(null, Stella.NIL)), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_LIST_CONTEXT_QUERY_001, new Object[2]));
        }
        else if (values == LoomApi.KWD_INSTANCES) {
          return (Logic.allInstances(context, false).consify());
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + values + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }

      } finally {
        Stella.$MODULE$.set(old$Module$000);
        Stella.$CONTEXT$.set(old$Context$000);
      }
    }
  }

  /** Return the arity of the relation 'relationRef'.
   * @param relationref
   * @return int
   */
  public static int relationArity(Stella_Object relationref) {
    { LogicObject relation = Logic.getRelation(relationref);

      if (relation != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(relation);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
            { Description relation000 = ((Description)(relation));

              return (relation000.arity());
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
            { LogicObject relation000 = ((LogicObject)(relation));

              return (((IntegerWrapper)(LogicObject.getSlotValue(relation000, Logic.SGT_PL_KERNEL_KB_ARITY))).wrapperValue);
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      else {
        return (Stella.NULL_INTEGER);
      }
    }
  }

  /** Return the nearest class with name 'instanceRef' in
   * the module 'module'.  If 'local?' is FALSE, also search modules inherited
   * by 'module'.  'instanceRef' can be a string, symbol, or surrogate.
   * @param instanceref
   * @param module
   * @param localP
   * @return LogicObject
   */
  public static LogicObject findClass(Stella_Object instanceref, Module module, boolean localP) {
    { Stella_Object instance = Logic.coerceToInstanceInModule(instanceref, module, localP, null);

      if (Logic.classP(instance)) {
        return (((LogicObject)(instance)));
      }
      else {
        return (null);
      }
    }
  }

  /** Return the nearest relation with name 'instanceRef' in
   * the module 'module'.  If 'local?' is FALSE, also search modules inherited
   * by 'module'.  'instanceRef' can be a string, symbol, or surrogate.
   * @param instanceref
   * @param module
   * @param localP
   * @return LogicObject
   */
  public static LogicObject findRelation(Stella_Object instanceref, Module module, boolean localP) {
    { Stella_Object instance = Logic.coerceToInstanceInModule(instanceref, module, localP, null);

      if (Logic.relationP(instance)) {
        return (((LogicObject)(instance)));
      }
      else {
        return (null);
      }
    }
  }

  /** Return the surrogate pointing to the instance referenced by
   * 'instanceRef'.
   * @param instanceref
   * @return Surrogate
   */
  public static Surrogate getInstanceSurrogate(Stella_Object instanceref) {
    if (instanceref == null) {
      return (null);
    }
    else if (Stella_Object.isaP(instanceref, Logic.SGT_STELLA_SURROGATE)) {
      if (((Surrogate)(instanceref)).surrogateValue == null) {
        return (null);
      }
      else {
        return (((Surrogate)(instanceref)));
      }
    }
    else {
      { Stella_Object instance = Logic.getInstance(instanceref);

        if (instance == null) {
          return (null);
        }
        { Surrogate testValue000 = Stella_Object.safePrimaryType(instance);

          if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
            { LogicObject instance000 = ((LogicObject)(instance));

              if (instance000 != null) {
                return (instance000.surrogateValueInverse);
              }
              else {
                return (null);
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_THING)) {
            { Thing instance000 = ((Thing)(instance));

              if (instance000 != null) {
                return (instance000.surrogateValueInverse);
              }
              else {
                return (null);
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
    }
  }

  /** Return the name (a symbol) of the instance referenced by
   * 'instanceRef'.
   * @param instanceref
   * @return Symbol
   */
  public static Symbol getInstanceName(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      { Surrogate testValue000 = Stella_Object.safePrimaryType(instance);

        if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
          { LogicObject instance000 = ((LogicObject)(instance));

            if ((instance000 != null) &&
                (instance000.surrogateValueInverse != null)) {
              return (Symbol.internSymbolInModule(instance000.surrogateValueInverse.symbolName, ((Module)(instance000.surrogateValueInverse.homeContext)), true));
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_THING)) {
          { Thing instance000 = ((Thing)(instance));

            if ((instance000 != null) &&
                (instance000.surrogateValueInverse != null)) {
              return (Symbol.internSymbolInModule(instance000.surrogateValueInverse.symbolName, ((Module)(instance000.surrogateValueInverse.homeContext)), true));
            }
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (null);
    }
  }

  /** Return a list containing the name of 'relationRef'
   * plus the names of any equivalent relations.
   * @param relationref
   * @return Cons
   */
  public static Cons getEquivalentNames(Stella_Object relationref) {
    { LogicObject relation = Logic.getRelation(relationref);
      Cons equivalentnames = Stella.NIL;

      if (relation == null) {
        return (null);
      }
      { LogicObject e = null;
        Cons iter000 = LogicObject.allEquivalentCollections(relation, true);
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          e = ((LogicObject)(iter000.value));
          if (Description.namedDescriptionP(((Description)(e)))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((Description)(e)).descriptionName(), Stella.NIL);
                if (equivalentnames == Stella.NIL) {
                  equivalentnames = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(equivalentnames, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((Description)(e)).descriptionName(), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (equivalentnames);
    }
  }

  /** Return TRUE if 'objectRef' is an instance or the
   * name of an instance.
   * @param objectref
   * @return boolean
   */
  public static boolean instanceP(Stella_Object objectref) {
    { Object old$SuppressnonlogicobjectwarningP$000 = Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$.get();

      try {
        Native.setBooleanSpecial(Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$, true);
        return (Logic.getInstance(objectref) != null);

      } finally {
        Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$.set(old$SuppressnonlogicobjectwarningP$000);
      }
    }
  }

  /** Return TRUE if 'objectRef' is an instance or the
   * name of an instance, and does not denote a relation, class, or set.
   * @param renamed_Object
   * @return boolean
   */
  public static boolean individualP(Stella_Object renamed_Object) {
    { Object old$SuppressnonlogicobjectwarningP$000 = Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$.get();

      try {
        Native.setBooleanSpecial(Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$, true);
        { Stella_Object instance = Logic.getInstance(renamed_Object);

          return ((instance != null) &&
              (!Logic.collectionP(instance)));
        }

      } finally {
        Logic.$SUPPRESSNONLOGICOBJECTWARNINGp$.set(old$SuppressnonlogicobjectwarningP$000);
      }
    }
  }

  /** Return TRUE if the object returned by 'instanceRef'
   * is matched with a logical constant.
   * @param instanceref
   * @return boolean
   */
  public static boolean namedP(Stella_Object instanceref) {
    return (LoomApi.getInstanceName(instanceref) != null);
  }

  /** Create an instance named 'instanceRef'
   * of type 'classRef'.
   * @param instanceref
   * @param classref
   * @return Stella_Object
   */
  public static Stella_Object createInstance(Stella_Object instanceref, Stella_Object classref) {
    { Surrogate classtype = LoomApi.getInstanceSurrogate(classref);
      Surrogate surrogate = LoomApi.safeSurrogatify(instanceref);

      if (Logic.classP(classtype) &&
          ((instanceref == null) ||
           (surrogate != null))) {
        return (Logic.createLogicInstance(surrogate, classtype));
      }
      else {
        return (null);
      }
    }
  }

  /** Find an existing instance refenced by 'instanceRef'
   * of type 'classRef', or create one of type 'classRef'.
   * @param instanceref
   * @param classref
   * @return LogicObject
   */
  public static LogicObject findOrCreateInstance(Stella_Object instanceref, Stella_Object classref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate classtype = LoomApi.getInstanceSurrogate(classref);

      if (instance != null) {
        if ((classref == null) ||
            LoomApi.instanceOfP(instance, classtype)) {
          return (((LogicObject)(instance)));
        }
        else {
          return (null);
        }
      }
      else {
        return (((LogicObject)(LoomApi.createInstance(instanceref, classref))));
      }
    }
  }

  /** Return TRUE if the instance referenced by 'instanceRef'
   * belongs to the class referenced by 'classRef'.
   * @param instanceref
   * @param classref
   * @return boolean
   */
  public static boolean instanceOfP(Stella_Object instanceref, Stella_Object classref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate classtype = LoomApi.getInstanceSurrogate(classref);

      return ((instance != null) &&
          ((classtype != null) &&
           Logic.testTypeOnInstanceP(instance, classtype)));
    }
  }

  /** Assert that the instance referenced by 'instanceRef'
   * is an instance of the class referenced by 'classRef'.
   * @param instanceref
   * @param classref
   */
  public static void addType(Stella_Object instanceref, Stella_Object classref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate classtype = LoomApi.getInstanceSurrogate(classref);

      if ((instance != null) &&
          Logic.classP(classtype)) {
        Logic.updateIsaProposition(instance, classtype, Logic.KWD_ASSERT_TRUE);
      }
    }
  }

  /** Retract that the instance referenced by 'instanceRef'
   * is an instance of the class referenced by 'classRef'.
   * @param instanceref
   * @param classref
   */
  public static void removeType(Stella_Object instanceref, Stella_Object classref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate classtype = LoomApi.getInstanceSurrogate(classref);

      if ((instance != null) &&
          Logic.classP(classtype)) {
        Logic.updateIsaProposition(instance, classtype, Logic.KWD_RETRACT_TRUE);
      }
    }
  }

  /** Return a list of classes that instance belongs to.
   * @param instanceref
   * @param directorasserted
   * @return Cons
   */
  public static Cons getTypes(Stella_Object instanceref, Keyword directorasserted) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Cons result = Stella.NIL;

      if (instance == null) {
        return (null);
      }
      if (directorasserted == LoomApi.KWD_DIRECT) {
        { LogicObject d = null;
          Cons iter000 = Logic.allDirectTypes(instance);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            d = ((LogicObject)(iter000.value));
            result = Cons.cons(d, result);
          }
        }
      }
      else if (directorasserted == LoomApi.KWD_ASSERTED) {
        { NamedDescription d = null;
          Cons iter001 = Logic.allAssertedTypes(instance);

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            d = ((NamedDescription)(iter001.value));
            result = Cons.cons(d, result);
          }
        }
      }
      else {
        { NamedDescription d = null;
          Cons iter002 = Logic.allTypes(instance);

          for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            d = ((NamedDescription)(iter002.value));
            result = Cons.cons(d, result);
          }
        }
      }
      return (result);
    }
  }

  /** Assert the tuple '(relationRef instanceRef valueRef)',
   * or retract if 'assert?' is FALSE.
   * @param instanceref
   * @param relationref
   * @param valueref
   * @param assertP
   */
  public static void updateRoleValue(Stella_Object instanceref, Stella_Object relationref, Stella_Object valueref, boolean assertP) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      LogicObject relation = Logic.getRelation(relationref);
      Stella_Object value = Logic.getInstance(valueref);

      if ((instance != null) &&
          ((relation != null) &&
           ((LoomApi.relationArity(relation) == 2) &&
            (value != null)))) {
        Logic.updateTuple(LoomApi.getInstanceSurrogate(relation), Cons.consList(Cons.cons(instance, Cons.cons(value, Stella.NIL))), (assertP ? Logic.KWD_ASSERT_TRUE : Logic.KWD_RETRACT_TRUE));
      }
    }
  }

  /** Assert the tuple '(relationRef instanceRef valueRef)'.
   * @param instanceref
   * @param relationref
   * @param valueref
   */
  public static void addRoleValue(Stella_Object instanceref, Stella_Object relationref, Stella_Object valueref) {
    LoomApi.updateRoleValue(instanceref, relationref, valueref, true);
  }

  /** Retract the tuple '(relationRef instanceRef valueRef)'.
   * @param instanceref
   * @param relationref
   * @param valueref
   */
  public static void removeRoleValue(Stella_Object instanceref, Stella_Object relationref, Stella_Object valueref) {
    LoomApi.updateRoleValue(instanceref, relationref, valueref, false);
  }

  /** Return a value for the binary relation 'relationRef'
   * applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return Stella_Object
   */
  public static Stella_Object getRoleValue(Stella_Object instanceref, Stella_Object relationref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      LogicObject relation = Logic.getRelation(relationref);

      if ((instance != null) &&
          ((relation != null) &&
           (LoomApi.relationArity(relation) == 2))) {
        return (LogicObject.getSlotValue(((LogicObject)(instance)), LoomApi.getInstanceSurrogate(relation)));
      }
      else {
        return (null);
      }
    }
  }

  /** Return a list of values for the binary relation 'relationRef'
   * applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return Cons
   */
  public static Cons getRoleValues(Stella_Object instanceref, Stella_Object relationref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      LogicObject relation = Logic.getRelation(relationref);

      if ((instance != null) &&
          ((relation != null) &&
           (LoomApi.relationArity(relation) == 2))) {
        return (LogicObject.allSlotValues(((LogicObject)(instance)), LoomApi.getInstanceSurrogate(relation)));
      }
      else {
        return (null);
      }
    }
  }

  /** Return a list of default values for the binary relation
   * 'relationRef' applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return Cons
   */
  public static Cons getRoleDefaultValues(Stella_Object instanceref, Stella_Object relationref) {
    { Cons defaultvalues = null;

      { Object old$Context$000 = Stella.$CONTEXT$.get();
        Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, Logic.getInferenceCache(((Module)(Stella.$MODULE$.get())), Logic.KWD_DEFAULT));
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          defaultvalues = LoomApi.getRoleValues(instanceref, relationref);

        } finally {
          Stella.$MODULE$.set(old$Module$000);
          Stella.$CONTEXT$.set(old$Context$000);
        }
      }
      { Object old$Context$001 = Stella.$CONTEXT$.get();
        Object old$Module$001 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$CONTEXT$, Logic.getInferenceCache(((Module)(Stella.$MODULE$.get())), Logic.KWD_STRICT));
          Native.setSpecial(Stella.$MODULE$, ((Context)(Stella.$CONTEXT$.get())).baseModule);
          { Stella_Object v = null;
            Cons iter000 = LoomApi.getRoleValues(instanceref, relationref);

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              v = iter000.value;
              defaultvalues = defaultvalues.remove(v);
            }
          }

        } finally {
          Stella.$MODULE$.set(old$Module$001);
          Stella.$CONTEXT$.set(old$Context$001);
        }
      }
      return (defaultvalues);
    }
  }

  /** Return a list of instances belonging to the class 'classRef'.
   * @param classref
   * @param directP
   * @return Cons
   */
  public static Cons getClassInstances(Stella_Object classref, boolean directP) {
    { Surrogate classtype = LoomApi.getInstanceSurrogate(classref);

      if (Logic.classP(classtype)) {
        if (directP) {
          { Cons instances = Logic.allClassInstances(classtype);
            Cons directinstances = Stella.NIL;
            Cons directsubs = NamedDescription.allDirectSubrelations(((NamedDescription)(Logic.getInstance(classref))), true);
            boolean instanceOfSubP = false;

            { Stella_Object i = null;
              Cons iter000 = instances;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                i = iter000.value;
                instanceOfSubP = false;
                { NamedDescription s = null;
                  Cons iter001 = directsubs;

                  loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    s = ((NamedDescription)(iter001.value));
                    if (LoomApi.instanceOfP(i, s)) {
                      instanceOfSubP = true;
                      break loop001;
                    }
                  }
                }
                if (!(instanceOfSubP)) {
                  directinstances = Cons.cons(i, directinstances);
                }
              }
            }
            return (directinstances);
          }
        }
        else {
          return (Logic.allClassInstances(classtype));
        }
      }
      else {
        return (Stella.NIL);
      }
    }
  }

  /** Return TRUE if 'subrelationRef' specializes 'superrelationRef'.
   * Side-effect: Upclassify 'subrelationRef'.
   * @param subrelationref
   * @param superrelationref
   * @return boolean
   */
  public static boolean subrelationP(Stella_Object subrelationref, Stella_Object superrelationref) {
    { LogicObject subrelation = Logic.getRelation(subrelationref);
      Surrogate subrelationtype = ((subrelation != null) ? subrelation.surrogateValueInverse : ((Surrogate)(null)));
      Surrogate superrelationtype = LoomApi.getInstanceSurrogate(superrelationref);

      if (Logic.relationP(subrelationtype) &&
          Logic.relationP(superrelationtype)) {
        {
          Description.findDirectSupersAndSubs(((Description)(subrelation)), true, new Object[2]);
          return (Logic.testSubrelationP(subrelationtype, superrelationtype));
        }
      }
      else {
        return (false);
      }
    }
  }

  /** Return a list of relations that generalize 'relationRef'.
   * Does not include relations equivalent to 'relationRef'.
   * @param relationref
   * @param directP
   * @return Cons
   */
  public static Cons getSuperrelations(Stella_Object relationref, boolean directP) {
    Logic.finalizeObjects();
    { Stella_Object relation = Logic.getInstance(relationref);
      Cons result = Stella.NIL;

      if (Logic.relationP(relation)) {
        if (directP) {
          { NamedDescription renamed_Super = null;
            Cons iter000 = NamedDescription.allDirectSuperrelations(((NamedDescription)(relation)), true);

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              renamed_Super = ((NamedDescription)(iter000.value));
              result = Cons.cons(renamed_Super, result);
            }
          }
        }
        else {
          { NamedDescription renamed_Super = null;
            Cons iter001 = NamedDescription.allSuperrelations(((NamedDescription)(relation)), true);

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              renamed_Super = ((NamedDescription)(iter001.value));
              result = Cons.cons(renamed_Super, result);
            }
          }
        }
      }
      return (result);
    }
  }

  /** Return a list of relations that specialize 'relationRef'.
   * Does not include relations equivalent to 'relationRef'.
   * @param relationref
   * @param directP
   * @return Cons
   */
  public static Cons getSubrelations(Stella_Object relationref, boolean directP) {
    Logic.finalizeObjects();
    { Stella_Object relation = Logic.getInstance(relationref);
      Cons result = Stella.NIL;

      if (Logic.relationP(relation)) {
        if (directP) {
          { NamedDescription sub = null;
            Cons iter000 = NamedDescription.allDirectSubrelations(((NamedDescription)(relation)), true);

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sub = ((NamedDescription)(iter000.value));
              result = Cons.cons(sub, result);
            }
          }
        }
        else {
          { NamedDescription sub = null;
            Cons iter001 = NamedDescription.allSubrelations(((NamedDescription)(relation)), true);

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              sub = ((NamedDescription)(iter001.value));
              result = Cons.cons(sub, result);
            }
          }
        }
      }
      return (result);
    }
  }

  /** Return a list of the most specific among the
   * relations in 'relationRefs'.  If 'classifyFirst?', insure that
   * all relations are classified before filtering for most-specific.
   * @param relationrefs
   * @param classifyfirstP
   * @return Cons
   */
  public static Cons mostSpecificRelations(Cons relationrefs, boolean classifyfirstP) {
    { Cons relations = Stella.NIL;

      { Stella_Object r = null;
        Cons iter000 = relationrefs;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          r = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Logic.getRelation(r), Stella.NIL);
              if (relations == Stella.NIL) {
                relations = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(relations, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Logic.getRelation(r), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      relations = relations.removeDuplicates();
      if (relations.rest == Stella.NIL) {
        return (relations);
      }
      if (classifyfirstP) {
        { Object old$Classificationsession$000 = Logic.$CLASSIFICATIONSESSION$.get();

          try {
            Native.setSpecial(Logic.$CLASSIFICATIONSESSION$, Logic.getClassificationSession(Logic.KWD_DESCRIPTION));
            { Object old$Context$000 = Stella.$CONTEXT$.get();

              try {
                Native.setSpecial(Stella.$CONTEXT$, Logic.getClassificationWorld());
                { Description youngestrelation = ((Description)(relations.value));

                  { Description r = null;
                    Cons iter001 = relations.rest;

                    for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                      r = ((Description)(iter001.value));
                      if (r.introductionTimestamp() > youngestrelation.introductionTimestamp()) {
                        youngestrelation = r;
                      }
                    }
                  }
                  { Description r = null;
                    Cons iter002 = relations;

                    for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                      r = ((Description)(iter002.value));
                      if (!LogicObject.upclassifiedLaterThanP(r, youngestrelation)) {
                        LogicObject.upclassifyOneDescription(r);
                      }
                    }
                  }
                  return (Logic.mostSpecificNamedCollections(relations));
                }

              } finally {
                Stella.$CONTEXT$.set(old$Context$000);
              }
            }

          } finally {
            Logic.$CLASSIFICATIONSESSION$.set(old$Classificationsession$000);
          }
        }
      }
      return (Logic.mostSpecificNamedCollections(relations));
    }
  }

  /** Return a relation representing the conjunction
   * of relations in 'relationRefs'.
   * @param relationrefs
   * @return Description
   */
  public static Description computeConjunctionRelation(Cons relationrefs) {
    { Cons relations = Stella.NIL;
      LogicObject conjunctiondescription = null;

      { NamedDescription r = null;
        Cons iter000 = relationrefs;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          r = ((NamedDescription)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Logic.getRelation(r), Stella.NIL);
              if (relations == Stella.NIL) {
                relations = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(relations, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Logic.getRelation(r), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      relations = relations.removeDuplicates();
      if (relations.rest == Stella.NIL) {
        return (((Description)(relations.value)));
      }
      { Cons clauses = Stella.NIL;
        Cons variables = Stella.NIL;

        { Symbol v = null;
          Cons iter001 = Logic.SYSTEM_DEFINED_ARGUMENT_NAMES;
          IntegerIntervalIterator i = Stella.interval(1, LoomApi.relationArity(((Description)(relations.value))));
          Cons collect001 = null;

          for (;(!(iter001 == Stella.NIL)) &&
                    i.nextP(); iter001 = iter001.rest) {
            v = ((Symbol)(iter001.value));
            if (collect001 == null) {
              {
                collect001 = Cons.cons(v, Stella.NIL);
                if (variables == Stella.NIL) {
                  variables = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(variables, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(v, Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
        { Description r = null;
          Cons iter002 = relations;

          for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            r = ((Description)(iter002.value));
            if (LoomApi.namedP(r)) {
              clauses = Cons.cons(Cons.cons(Symbol.internSymbolInModule(r.surrogateValueInverse.symbolName, ((Module)(r.surrogateValueInverse.homeContext)), true), Cons.copyConsList(variables).concatenate(Stella.NIL, Stella.NIL)), clauses);
            }
            else {
              clauses = Cons.cons(((Cons)(LogicObject.generateExpression(r, true))).rest.rest.value, clauses);
            }
          }
        }
        conjunctiondescription = ((LogicObject)(Logic.conceiveTerm(Cons.list$(Cons.cons(Logic.SYM_LOGIC_KAPPA, Cons.cons(Cons.cons(variables, Stella.NIL), Cons.cons(Cons.cons(Logic.SYM_STELLA_AND, clauses.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))))));
      }
      { Cons supers = null;
        Cons subs = null;
        Cons equivalents = null;

        { Object [] caller_MV_returnarray = new Object[2];

          supers = Description.findDirectSupersAndSubs(((Description)(conjunctiondescription)), true, caller_MV_returnarray);
          subs = ((Cons)(caller_MV_returnarray[0]));
          equivalents = ((Cons)(caller_MV_returnarray[1]));
        }
        {
          supers = supers;
          subs = subs;
        }
        if (!(equivalents == Stella.NIL)) {
          return (((Description)(equivalents.value)));
        }
        else {
          return (((Description)(conjunctiondescription)));
        }
      }
    }
  }

  /** Return the domain of the binary relation 'relationRef'.
   * @param relationref
   * @return NamedDescription
   */
  public static NamedDescription getDomain(Stella_Object relationref) {
    { LogicObject relation = Logic.getRelation(relationref);

      if (relation == null) {
        return (null);
      }
      return (((NamedDescription)(Logic.applyCachedRetrieve(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pD, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_DOMAIN, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pD, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(null, Cons.cons(relation, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_GET_DOMAIN_QUERY_000, new Object[2]).value)));
    }
  }

  /** Return the range of the binary relation 'relationRef'.
   * @param relationref
   * @return NamedDescription
   */
  public static NamedDescription getRange(Stella_Object relationref) {
    { LogicObject relation = Logic.getRelation(relationref);

      if (relation == null) {
        return (null);
      }
      return (((NamedDescription)(Logic.applyCachedRetrieve(Cons.list$(Cons.cons(LoomApi.SYM_LOOM_API_pD, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_RANGE, Cons.cons(LoomApi.SYM_LOOM_API_pR, Cons.cons(LoomApi.SYM_LOOM_API_pD, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(null, Cons.cons(relation, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_GET_RANGE_QUERY_000, new Object[2]).value)));
    }
  }

  /** Infer a minimum cardinality for the set of fillers of
   * the range of relation 'relationRef' applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return int
   */
  public static int getMinCardinality(Stella_Object instanceref, Stella_Object relationref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate relationsurrogate = LoomApi.getInstanceSurrogate(relationref);

      return (LogicObject.getSlotMinimumCardinality(((LogicObject)(instance)), relationsurrogate));
    }
  }

  /** Infer a maximum cardinality for the set of fillers of
   * the range of relation 'relationRef' applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return int
   */
  public static int getMaxCardinality(Stella_Object instanceref, Stella_Object relationref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate relationsurrogate = LoomApi.getInstanceSurrogate(relationref);

      return (LogicObject.getSlotMaximumCardinality(((LogicObject)(instance)), relationsurrogate));
    }
  }

  /** Infer a type restriction on the set of fillers of
   * the range of relation 'relationRef' applied to 'instanceRef'.
   * @param instanceref
   * @param relationref
   * @return Description
   */
  public static Description getValueRestriction(Stella_Object instanceref, Stella_Object relationref) {
    { Stella_Object instance = Logic.getInstance(instanceref);
      Surrogate relationsurrogate = LoomApi.getInstanceSurrogate(relationref);
      NamedDescription type = LogicObject.getSlotValueType(((LogicObject)(instance)), relationsurrogate);

      if (type == null) {
        type = Logic.getDescription(Logic.SGT_STELLA_THING);
      }
      return (type);
    }
  }

  /** Convert each Loom sentence into a KIF equivalent
   * and assert it or retract it.
   * @param loomsentence
   * @param retractP
   */
  public static void assertLoomProposition(Cons loomsentence, boolean retractP) {
    Logic.updateProposition(Logic.translateLoomSentenceToKif(loomsentence), (retractP ? Logic.KWD_RETRACT_TRUE : Logic.KWD_ASSERT_TRUE));
  }

  /** Destroy the instance, class or relation 'instanceRef'.
   * @param instanceref
   */
  public static void deleteInstance(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      if (instance != null) {
        LogicObject.destroyTerm(((LogicObject)(instance)));
      }
    }
  }

  /** Return an s-expression representing the
   * source expression for 'instanceRef'.
   * @param instanceref
   * @return Stella_Object
   */
  public static Stella_Object generateSourceExpression(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      return (LogicObject.generateExpression(((LogicObject)(instance)), false));
    }
  }

  /** Return a list of partitions that
   * specify disjointness of children of the class classRef'.
   * @param classref
   * @return Cons
   */
  public static Cons getPartitions(Stella_Object classref) {
    { LogicObject renamed_Class = Logic.getClass(classref);
      Cons partitions = Stella.NIL;

      if (renamed_Class != null) {
        { LogicObject c = null;
          Cons iter000 = LoomApi.getSubrelations(renamed_Class, true);

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            c = ((LogicObject)(iter000.value));
            { Stella_Object mdc = null;
              Cons iter001 = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_MEMBER_OF, Cons.cons(Logic.SYM_LOGIC_pC, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(LoomApi.SYM_PL_KERNEL_KB_MUTUALLY_DISJOINT_COLLECTION, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(c, Cons.cons(null, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_GET_PARTITIONS_QUERY_000, new Object[2]);

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                mdc = iter001.value;
                if (!partitions.memberP(mdc)) {
                  partitions = Cons.cons(mdc, partitions);
                }
              }
            }
          }
        }
      }
      return (partitions);
    }
  }

  /** Return TRUE if 'relationRef1' and 'relationRef2' are
   * disjoint.
   * @param relationref1
   * @param relationref2
   * @return boolean
   */
  public static boolean disjointRelationsP(Stella_Object relationref1, Stella_Object relationref2) {
    { LogicObject relation1 = Logic.getRelation(relationref1);
      LogicObject relation2 = Logic.getRelation(relationref2);

      return (Description.expensiveDisjointTermsP(((Description)(relation1)), ((Description)(relation2))));
    }
  }

  /** Return TRUE if the mutually disjoint collection 'instanceRef'
   * covers 'classRef'.  If 'classRef' is NULL, return TRUE if 'instanceRef' covers
   * some concept.
   * @param instanceref
   * @param classref
   * @return boolean
   */
  public static boolean coveringP(Stella_Object instanceref, Stella_Object classref) {
    { Stella_Object mdc = Logic.getInstance(instanceref);
      LogicObject coveredclass = Logic.getClass(classref);

      if ((mdc == null) ||
          (!Logic.testPropertyP(mdc, Logic.SGT_PL_KERNEL_KB_MUTUALLY_DISJOINT_COLLECTION))) {
        return (false);
      }
      { ConsIterator c = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(LoomApi.SYM_LOOM_API_pCOVERED, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(LoomApi.SYM_PL_KERNEL_KB_COVERING, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(LoomApi.SYM_LOOM_API_pCOVERED, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(mdc, Cons.cons(coveredclass, Stella.NIL))), Cons.consList(Stella.NIL), LoomApi.SYM_LOOM_API_F_COVERINGp_QUERY_000, new Object[2]).allocateIterator();

        while (c.nextP()) {
          return (true);
        }
      }
      return (false);
    }
  }

  /** Return a list of concepts that belong to the collection 'instanceRef'.
   * @param instanceref
   * @return Cons
   */
  public static Cons collectionMembers(Stella_Object instanceref) {
    { Stella_Object instance = Logic.getInstance(instanceref);

      if (instance != null) {
        return (Logic.assertedCollectionMembers(instance, false).consify());
      }
      return (Stella.NIL);
    }
  }

}
