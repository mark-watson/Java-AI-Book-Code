//  -*- Mode: Java -*-
//
// PLI.java

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
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;
import edu.isi.stella.Module;

public class PLI {
  public static boolean $POWERLOOM_INITIALIZEDp$ = false;

  public static Surrogate SGT_PLI_ENVIRONMENT = null;

  public static Symbol SYM_LOGIC_LEVEL = null;

  public static Environment ASSERTION_ENV = null;

  public static Environment TAXONOMIC_ENV = null;

  public static Environment INFERENCE_ENV = null;

  public static Surrogate SGT_PLI_PL_ITERATOR = null;

  /** Iterator that generates no values.
   */
  static PlIterator EMPTY_PL_ITERATOR = null;

  static NamedDescription $LITERAL_CONCEPT$ = null;

  static NamedDescription $STRING_CONCEPT$ = null;

  static NamedDescription $INTEGER_CONCEPT$ = null;

  static NamedDescription $FLOAT_CONCEPT$ = null;

  public static Symbol SYM_PLI_pR = null;

  public static Symbol SYM_PLI_pI = null;

  public static Symbol SYM_PLI_pV = null;

  public static Symbol SYM_PLI_F_GET_INFERRED_BINARY_PROPOSITION_VALUES_QUERY_000 = null;

  public static Symbol SYM_PLI_PROPER_SUBRELATION = null;

  public static Keyword KWD_CASE_SENSITIVEp = null;

  public static Keyword KWD_SUBSET_OF = null;

  public static Surrogate SGT_PL_KERNEL_KB_NTH_DOMAIN = null;

  public static Symbol SYM_PLI_STARTUP_PLI = null;

  /** Initialize the PowerLoom logic system.  This function
   * needs to be called by all applications before using PowerLoom.  If it
   * is called more than once, every call after the first one is a no-op.
   */
  public static void initialize() {
    synchronized (Stella.$BOOTSTRAP_LOCK$) {
      if (!PLI.$POWERLOOM_INITIALIZEDp$) {
        StartupLogicSystem.startupLogicSystem();
      }
    }
  }

  /** Reset PowerLoom to its initial state.
   * CAUTION: This will destroy all loaded knowledge bases and might break other
   * loaded STELLA systems if they do reference PowerLoom symbols in their code.
   */
  public static void resetPowerloom() {
    synchronized (Logic.$POWERLOOM_LOCK$) {
      Logic.resetPowerloom();
    }
  }

  /** Clear all query and memoization caches.
   */
  public static void clearCaches() {
    synchronized (Logic.$POWERLOOM_LOCK$) {
      Logic.clearCaches();
    }
  }

  /** Convert a Stella cons list into an API iterator.
   * @param self
   * @return PlIterator
   */
  static PlIterator consToPlIterator(Cons self) {
    if (self == Stella.NIL) {
      return (PLI.EMPTY_PL_ITERATOR);
    }
    else {
      { PlIterator self001 = PlIterator.newPlIterator();

        self001.cursor = self;
        { PlIterator value000 = self001;

          return (value000);
        }
      }
    }
  }

  /** Convert a Stella list into an API iterator.
   * @param self
   * @return PlIterator
   */
  static PlIterator listToPlIterator(List self) {
    if (self.emptyP()) {
      return (PLI.EMPTY_PL_ITERATOR);
    }
    else {
      return (PLI.consToPlIterator(self.theConsList));
    }
  }

  /** Convert an arbitrary Stella iterator into an API iterator.
   * @param self
   * @return PlIterator
   */
  static PlIterator iteratorToPlIterator(Iterator self) {
    return (PLI.consToPlIterator(self.consify()));
  }

  static Stella_Object safelyGetObject(String name, Module module, Environment environment) {
    if (name == null) {
      return (null);
    }
    { Stella_Object renamed_Object = PLI.getObject(name, module, environment);

      if (renamed_Object == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't find an object named `" + name + "'");
          throw ((NoSuchObjectException)(NoSuchObjectException.newNoSuchObjectException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (renamed_Object);
      }
    }
  }

  static Stella_Object safelyGetConcept(String name, Module module, Environment environment) {
    if (name == null) {
      return (null);
    }
    { LogicObject renamed_Object = PLI.getConcept(name, module, environment);

      if (renamed_Object == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't find a concept named `" + name + "'");
          throw ((NoSuchObjectException)(NoSuchObjectException.newNoSuchObjectException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (renamed_Object);
      }
    }
  }

  static Stella_Object safelyGetRelation(String name, Module module, Environment environment) {
    if (name == null) {
      return (null);
    }
    { LogicObject renamed_Object = PLI.getRelation(name, module, environment);

      if (renamed_Object == null) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't find a relation named `" + name + "'");
          throw ((NoSuchObjectException)(NoSuchObjectException.newNoSuchObjectException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      else {
        return (renamed_Object);
      }
    }
  }

  static Context safelyGetModule(String name, Environment environment) {
    environment = environment;
    if ((name == null) ||
        Stella.stringEqlP(name, "")) {
      return (((Module)(Stella.$MODULE$.get())));
    }
    return (Stella.getStellaModule(name, true));
  }

  static Stella_Object safelyGetObjectOrNull(String name, Module module, Environment environment) {
    if ((module == null) ||
        ((name == null) ||
         (Stella.stringEqlP(name, "") ||
          Stella.stringEqualP(name, "null")))) {
      return (null);
    }
    try {
      return (PLI.getObject(name, module, environment));
    } catch (NoSuchObjectException e000) {
      return (null);
    }
  }

  static Cons sequenceToConsList(Stella_Object sequence) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(sequence);

      if (testValue000 == Logic.SGT_STELLA_CONS) {
        { Cons sequence000 = ((Cons)(sequence));

          return (sequence000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_LIST)) {
        { List sequence000 = ((List)(sequence));

          return (sequence000.theConsList);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_VECTOR)) {
        { Vector sequence000 = ((Vector)(sequence));

          { Cons result = Stella.NIL;

            { int i = Stella.NULL_INTEGER;
              int iter000 = 0;
              int upperBound000 = sequence000.length();
              Cons collect000 = null;

              for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                i = iter000;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons((sequence000.theArray)[i], Stella.NIL);
                    if (result == Stella.NIL) {
                      result = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(result, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons((sequence000.theArray)[i], Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            return (result);
          }
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Don't know how to convert object of type `" + sequence.primaryType() + "' into a cons list.");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  static Cons explodeStringList(String stringlist, Module module) {
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, module);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        { Cons expression = ((Cons)(Stella.readSExpressionFromString(stringlist)));
          Stella_Object term = null;
          Cons result = Stella.NIL;

          { Stella_Object ref = null;
            Cons iter000 = expression;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              ref = iter000.value;
              term = ((ref == Logic.SYM_STELLA_NULL) ? null : Logic.evaluateTerm(ref));
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(term, Stella.NIL);
                  if (result == Stella.NIL) {
                    result = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(result, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(term, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          return (result);
        }

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  static boolean legalOperatorP(Symbol operator) {
    return (Logic.$KIF_SENTENCE_OPERATORS$.memberP(operator) ||
        (Logic.$KIF_TERM_OPERATORS$.memberP(operator) ||
         Stella.getQuotedTree("((<=>> <<=> <<=>> <~> <~>> <<~> <<~>> ABOUT <<= =>> <~ ~> <<~ ~>>) \"/PLI\")", "/PLI").memberP(operator)));
  }

  /** Returns the Stella KEYWORD <code>name</code> if it exists.  Case sensitive.
   * @param name
   * @return Keyword
   */
  public static Keyword getKeyword(String name) {
    return (Keyword.lookupKeyword(name));
  }

  /** Returns the Stella SYMBOL <code>name</code> visible in <code>module</code> if it
   * exists.  <code>name</code> is ALWAYS treated case sensitively.
   * @param name
   * @param module
   * @param environment
   * @return Symbol
   */
  public static Symbol getSymbol(String name, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Symbol.lookupSymbol(name));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Returns the logical operator object (a Stella SYMBOL) for <code>name</code>.
   * If no such operator exists then a <code>noSuchObject</code> exception is thrown.
   * @param name
   * @return Symbol
   */
  public static Symbol getOperator(String name) {
    if (!(Stella.allUpperCaseStringP(name))) {
      name = Native.stringUpcase(name);
    }
    { Symbol operator = Symbol.lookupSymbolInModule(name, Logic.$LOGIC_MODULE$, false);

      if ((operator != null) &&
          PLI.legalOperatorP(operator)) {
        return (operator);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("No operator named `" + name + "'");
          throw ((NoSuchObjectException)(NoSuchObjectException.newNoSuchObjectException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Look for an object named <code>name</code> that is local to
   * or visible from the module <code>module</code>.
   * @param name
   * @param module
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object getObject(String name, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.getInstance(Stella.internStellaName(name)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Look for an object named <code>name</code> that is local to
   * or visible from the module <code>moduleName</code>.  A module name of <code>null</code> or the
   * empty string refers to the current module.  If no module can be found
   * with the name <code>moduleName</code>, then a Stella <code>noSuchContextException</code> is thrown.
   * @param name
   * @param moduleName
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object sGetObject(String name, String moduleName, Environment environment) {
    return (PLI.getObject(name, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
  }

  /** Return a class/concept named <code>name</code> that is local to
   * or visible from the module <code>module</code>.
   * @param name
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject getConcept(String name, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.getClass(Stella.internStellaName(name)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return a class/concept named <code>name</code> that is local to
   * or visible from the module <code>moduleName</code>.  A module name of <code>null</code> or the
   * empty string refers to the current module.  If no module can be found
   * with the name <code>moduleName</code>, then a Stella <code>noSuchContextException</code> is thrown.
   * @param name
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sGetConcept(String name, String moduleName, Environment environment) {
    return (PLI.getConcept(name, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
  }

  /** Return a concept or relation named <code>name</code> that is local to
   * or visible from the module <code>module</code>.
   * @param name
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject getRelation(String name, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.getRelation(Stella.internStellaName(name)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return a concept or relation named <code>name</code> that is local to
   * or visible from the module <code>moduleName</code>.  A module name of <code>null</code> or the
   * empty string refers to the current module.  If no module can be found
   * with the name <code>moduleName</code>, then a Stella <code>noSuchContextException</code> is thrown.
   * @param name
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sGetRelation(String name, String moduleName, Environment environment) {
    return (PLI.getRelation(name, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
  }

  /** Return relations that have been referenced but not defined in <code>module</code>.
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getUndefinedRelations(Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(Logic.callListUndefinedRelations(module, false)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return the name, qualified as necessary, so that <code>obj</code> can be found from
   * <code>module</code>.  If there is no name for the object return <code>null</code>.
   * @param obj
   * @param module
   * @param environment
   * @return String
   */
  public static String getNameInModule(Stella_Object obj, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

              if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
                { Skolem obj000 = ((Skolem)(obj));

                  return (null);
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                { LogicObject obj000 = ((LogicObject)(obj));

                  return (Native.stringify(Logic.objectName(obj000)));
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
                { GeneralizedSymbol obj000 = ((GeneralizedSymbol)(obj));

                  return (Native.stringify(obj000));
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_MODULE)) {
                { Module obj000 = ((Module)(obj));

                  return (obj000.moduleFullName);
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_CONTEXT)) {
                { Context obj000 = ((Context)(obj));

                  return (obj000.contextName());
                }
              }
              else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_COMPUTED_PROCEDURE)) {
                { ComputedProcedure obj000 = ((ComputedProcedure)(obj));

                  return (Native.stringify(obj000.surrogateValueInverse));
                }
              }
              else {
                return (null);
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return the fully qualified name of <code>obj</code>, if it has one.  Otherwise return <code>null</code>.
   * @param obj
   * @return String
   */
  public static String getName(Stella_Object obj) {
    return (PLI.getNameInModule(obj, Stella.$ROOT_MODULE$, null));
  }

  /** Return the short name of <code>obj</code>, if it has one.  Otherwise return <code>null</code>.
   * @param obj
   * @return String
   */
  public static String getShortName(Stella_Object obj) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem obj000 = ((Skolem)(obj));

          return (null);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject obj000 = ((LogicObject)(obj));

          return (Logic.objectNameString(obj000));
        }
      }
      else if (Surrogate.subtypeOfKeywordP(testValue000)) {
        { Keyword obj000 = ((Keyword)(obj));

          return (":" + obj000.symbolName);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_GENERALIZED_SYMBOL)) {
        { GeneralizedSymbol obj000 = ((GeneralizedSymbol)(obj));

          return (obj000.symbolName);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_CONTEXT)) {
        { Context obj000 = ((Context)(obj));

          return (obj000.contextName());
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_COMPUTED_PROCEDURE)) {
        { ComputedProcedure obj000 = ((ComputedProcedure)(obj));

          return (obj000.surrogateValueInverse.symbolName);
        }
      }
      else {
        return (null);
      }
    }
  }

  /** Return a printed representation of the term <code>self</code> as a string.
   * @param self
   * @return String
   */
  public static String objectToString(Stella_Object self) {
    if (self == null) {
      return (null);
    }
    else {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

            if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper self000 = ((StringWrapper)(self));

                return (self000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
              { Skolem self000 = ((Skolem)(self));

                { Stella_Object value = Logic.valueOf(self000);

                  if (value == self000) {
                    return (Native.stringify(self000));
                  }
                  else {
                    return (PLI.objectToString(value));
                  }
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue000, PLI.SGT_PLI_PL_ITERATOR)) {
              { PlIterator self000 = ((PlIterator)(self));

                return (Native.stringify(self000.consify()));
              }
            }
            else {
              return (Native.stringify(self));
            }
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  /** Coerce <code>self</code> to an integer, or throw a Stella Exception if the coersion is not feasible.
   * Floating point values will be coerced by rounding.
   * @param self
   * @return int
   */
  public static int objectToInteger(Stella_Object self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem self000 = ((Skolem)(self));

          { Stella_Object value = Logic.valueOf(self000);

            if (value == self000) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Can't coerce `" + self000 + "' to an integer.");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              return (PLI.objectToInteger(value));
            }
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper self000 = ((IntegerWrapper)(self));

          return (self000.wrapperValue);
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper self000 = ((FloatWrapper)(self));

          return (Native.round(self000.wrapperValue));
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("Can't coerce `" + self + "' to an integer.");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Coerce <code>self</code> to a float, or throw a Stella Exception if the coersion is not feasible.
   * @param self
   * @return double
   */
  public static double objectToFloat(Stella_Object self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem self000 = ((Skolem)(self));

          { Stella_Object value = Logic.valueOf(self000);

            if (value == self000) {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("Can't coerce `" + self000 + "' to a float.");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
            else {
              return (PLI.objectToFloat(value));
            }
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper self000 = ((IntegerWrapper)(self));

          return (self000.numberWrapperToFloat());
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper self000 = ((FloatWrapper)(self));

          return (self000.wrapperValue);
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("Can't coerce `" + self + "' to a float.");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Return a string representing a printed
   * representation of the object <code>self</code>.  Like <code>objectToString</code>, but puts
   * escaped double quotes around strings.
   * @param self
   * @return String
   */
  public static String objectToParsableString(Stella_Object self) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(self))) {
      { StringWrapper self000 = ((StringWrapper)(self));

        return ("\"" + self000.wrapperValue + "\"");
      }
    }
    else {
      return (PLI.objectToString(self));
    }
  }

  /** Evaluate <code>string</code> with respect to <code>module</code> and <code>environment</code>
   * and return the corresponding logical term.  <code>type</code> is a concept used to assist the
   * correct interpretation of <code>string</code>.
   * <p>
   * Currently <code>type</code> only has an effect on the interpretation of literal types.
   * @param string
   * @param type
   * @param module
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object stringToObject(String string, LogicObject type, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { Stella_Object obj = Stella.readSExpressionFromString(string);

              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(obj), Logic.SGT_STELLA_LITERAL_WRAPPER)) {
                { LiteralWrapper obj000 = ((LiteralWrapper)(obj));

                  if (type == null) {
                    return (obj000);
                  }
                  { Surrogate testValue000 = Stella_Object.safePrimaryType(obj000);

                    if (Surrogate.subtypeOfStringP(testValue000)) {
                      { StringWrapper obj001 = ((StringWrapper)(obj000));

                        if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$STRING_CONCEPT$)) {
                          return (obj001);
                        }
                        else {
                          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                            stream000.nativeStream.print("String argument found, but `" + type + "' is not a subconcept of `" + PLI.$STRING_CONCEPT$ + "'");
                            throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
                          }
                        }
                      }
                    }
                    else if (Surrogate.subtypeOfIntegerP(testValue000)) {
                      { IntegerWrapper obj001 = ((IntegerWrapper)(obj000));

                        if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$INTEGER_CONCEPT$)) {
                          return (obj001);
                        }
                        else if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$FLOAT_CONCEPT$)) {
                          return (FloatWrapper.wrapFloat(((double)(obj001.wrapperValue))));
                        }
                        else {
                          return (PLI.getObject(string, module, environment));
                        }
                      }
                    }
                    else if (Surrogate.subtypeOfFloatP(testValue000)) {
                      { FloatWrapper obj001 = ((FloatWrapper)(obj000));

                        if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$FLOAT_CONCEPT$)) {
                          return (obj001);
                        }
                        else {
                          return (PLI.getObject(string, module, environment));
                        }
                      }
                    }
                    else {
                      { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                        stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                        throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                      }
                    }
                  }
                }
              }
              else {
                if (type == null) {
                  return (PLI.getObject(string, module, environment));
                }
                else if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$STRING_CONCEPT$)) {
                  return (StringWrapper.wrapString(string));
                }
                else if (NamedDescription.subrelationOfP(((NamedDescription)(type)), PLI.$LITERAL_CONCEPT$)) {
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    stream002.nativeStream.print("`" + string + "' is a non-literal, but `" + type + "' is a subconcept of `" + PLI.$LITERAL_CONCEPT$ + "'");
                    throw ((ParsingError)(ParsingError.newParsingError(stream002.theStringReader()).fillInStackTrace()));
                  }
                }
                else {
                  return (PLI.getObject(string, module, environment));
                }
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  static Cons helpGetTrueExtensionMembers(NamedDescription relation, boolean specializeP) {
    { Cons value000 = Stella.NIL;

      { Stella_Object p = null;
        Iterator iter000 = NamedDescription.allExtensionMembers(relation);
        Cons collect000 = null;

        while (iter000.nextP()) {
          p = iter000.value;
          if ((!((Proposition)(p)).deletedP()) &&
              ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(((Proposition)(p))) : (Proposition.trueP(((Proposition)(p))) ||
              Proposition.functionWithDefinedValueP(((Proposition)(p))))))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(p, Stella.NIL);
                if (value000 == Stella.NIL) {
                  value000 = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(value000, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(p, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { Cons result = value000;

        if (specializeP) {
          { LogicObject sub = null;
            Iterator iter001 = LogicObject.allSubcollections(relation);

            while (iter001.nextP()) {
              sub = ((LogicObject)(iter001.value));
              if (Stella_Object.isaP(sub, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
                { Stella_Object p = null;
                  Iterator iter002 = NamedDescription.allExtensionMembers(((NamedDescription)(sub)));

                  while (iter002.nextP()) {
                    p = iter002.value;
                    if ((!((Proposition)(p)).deletedP()) &&
                        ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(((Proposition)(p))) : (Proposition.trueP(((Proposition)(p))) ||
                        Proposition.functionWithDefinedValueP(((Proposition)(p))))))) {
                      result = Cons.cons(p, result);
                    }
                  }
                }
              }
            }
          }
          return (result.removeDuplicates());
        }
        return (result);
      }
    }
  }

  static Cons helpGetPropositions(LogicObject relation, Cons arguments, int limit, Module module, Environment environment) {
    if (relation == null) {
      return (Stella.NIL);
    }
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { boolean assertionsonlyP = (environment != null) &&
                  Stella.stringEqlP(environment.level, "ASSERTION");
              boolean specializeP = !assertionsonlyP;

              { Stella_Object value000 = null;

                { Stella_Object arg = null;
                  Cons iter000 = arguments;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    arg = iter000.value;
                    if ((arg != null) &&
                        Stella_Object.isaP(arg, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                      value000 = arg;
                      break loop000;
                    }
                  }
                }
                { Stella_Object argumentwithbacklinks = value000;
                  Iterator iterator = ((argumentwithbacklinks != null) ? ((Iterator)(Logic.allTrueDependentPropositions(argumentwithbacklinks, relation.surrogateValueInverse, specializeP))) : PLI.helpGetTrueExtensionMembers(((NamedDescription)(relation)), specializeP).allocateIterator());
                  Cons results = Stella.NIL;

                  if (!(assertionsonlyP)) {
                    Native.setSpecial(Stella.$CONTEXT$, Logic.getPropertyTestContext());
                  }
                  { Proposition p = null;
                    Iterator iter001 = iterator;

                    loop001 : while (iter001.nextP()) {
                      p = ((Proposition)(iter001.value));
                      { boolean testValue000 = false;

                        { boolean alwaysP000 = true;

                          { Stella_Object inputarg = null;
                            Cons iter002 = arguments;
                            Stella_Object arg2 = null;
                            Vector vector000 = p.arguments;
                            int index000 = 0;
                            int length000 = vector000.length();

                            loop002 : for (;(!(iter002 == Stella.NIL)) &&
                                      (index000 < length000); iter002 = iter002.rest, index000 = index000 + 1) {
                              inputarg = iter002.value;
                              arg2 = (vector000.theArray)[index000];
                              if (!((inputarg == null) ||
                                  Stella_Object.eqlP(inputarg, Logic.valueOf(arg2)))) {
                                alwaysP000 = false;
                                break loop002;
                              }
                            }
                          }
                          testValue000 = alwaysP000;
                        }
                        if (testValue000) {
                          testValue000 = arguments.length() == p.arguments.length();
                        }
                        if (testValue000) {
                          results = Cons.cons(p, results);
                          limit = limit - 1;
                          if (limit == 0) {
                            break loop001;
                          }
                        }
                      }
                    }
                  }
                  return (results);
                }
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return a proposition matching <code>relationAndArguments</code> that
   * has been asserted (or inferred by forward chaining).  <code>relationAndArguments</code>
   * is a sequence containing objects and nulls.  The first argument must be the
   * name of a relation.  A null value acts like a wild card.  If more than one 
   * proposition matches the input criteria, the selection among satisficing
   * propositions is arbitrary.  This procedure is normally applied to single-valued
   * relations or functions.
   * @param relationAndArguments
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition getProposition(Stella_Object relationAndArguments, Module module, Environment environment) {
    { Cons list = PLI.sequenceToConsList(relationAndArguments);
      Stella_Object relation = list.value;
      Cons arguments = list.rest;

      return (((Proposition)(PLI.helpGetPropositions(((LogicObject)(relation)), arguments, 1, module, environment).value)));
    }
  }

  /** Return a proposition matching <code>relationAndArguments</code> that
   * has been asserted (or inferred by forward chaining).  <code>relationAndArguments</code>
   * is a string that begins with a left parenthesis, followed by a relation name, 
   * one or more argument identifiers, and terminated by a right parenthesis.  Each
   * argument identifier can be the name of a logical constant, a literal
   * reference (e.g., a number), the null identifier, or a variable (an identifier that begins
   * with a question mark). Each occurrence of a null or a variable acts like a wild card.
   * If more than one proposition matches the input criteria, the selection among
   * satisficing propositions is arbitrary.  This procedure is normally applied to
   * single-valued relations or functions.
   * <p>
   * A module name of <code>null</code> or the
   * empty string refers to the current module.  If no module can be found
   * with the name <code>moduleName</code>, then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationAndArguments
   * @param moduleName
   * @param environment
   * @return Proposition
   */
  public static Proposition sGetProposition(String relationAndArguments, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Cons elements = PLI.explodeStringList(relationAndArguments, ((Module)(module)));
      Stella_Object relation = elements.value;
      Cons arguments = elements.rest;

      return (((Proposition)(PLI.helpGetPropositions(((LogicObject)(relation)), arguments, 1, ((Module)(module)), environment).value)));
    }
  }

  /** Return propositions matching <code>relationAndArguments</code> that
   * have been asserted (or inferred by forward chaining).  <code>relationAndArguments</code>
   * is a sequence containing objects and nulls.  The first argument must be the
   * name of a relation.  A null value acts like a wild card.
   * @param relationAndArguments
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getPropositions(Stella_Object relationAndArguments, Module module, Environment environment) {
    { Cons list = PLI.sequenceToConsList(relationAndArguments);
      Stella_Object relation = list.value;
      Cons arguments = list.rest;

      return (PLI.consToPlIterator(PLI.helpGetPropositions(((LogicObject)(relation)), arguments, 0, module, environment)));
    }
  }

  /** Return propositions matching <code>relationAndArguments</code> that
   * have been asserted (or inferred by forward chaining).  <code>relationAndArguments</code>
   * is a string that begins with a left parenthesis, followed by a relation name, 
   * one or more argument identifiers, and terminated by a right parenthesis.  Each
   * argument identifier can be the name of a logical constant, a literal 
   * reference (e.g., a number), the null identifier, or a variable (an identifier that begins
   * with a question mark). Each occurrence of a null or a variable acts like a wild card.
   * <p>
   * A module name of <code>null</code> or the
   * empty string refers to the current module.  If no module can be found
   * with the name <code>moduleName</code>, then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationAndArguments
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetPropositions(String relationAndArguments, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Cons elements = PLI.explodeStringList(relationAndArguments, ((Module)(module)));
      Stella_Object relation = elements.value;
      Cons arguments = elements.rest;

      return (PLI.consToPlIterator(PLI.helpGetPropositions(((LogicObject)(relation)), arguments, 0, ((Module)(module)), environment)));
    }
  }

  /** Return inconsistent propositions visible in <code>module</code>.
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getInconsistentPropositions(Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.iteratorToPlIterator(Logic.allInconsistentPropositions(module, false)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return a proposition such that (<code>relation</code> <code>arg1</code> <code>arg2</code>)
   * is true.  The <code>relation</code> argument must be bound to a relation.  One or both
   * of the <code>arg1</code> and <code>arg2</code> arguments may be set to NULL, which is interpreted
   * as a wildcard. If more than one proposition matches the input criteria,
   * the selection is arbitrary.  This procedure is normally applied to single-valued
   * relations or functions.
   * @param relation
   * @param arg1
   * @param arg2
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition getBinaryProposition(LogicObject relation, Stella_Object arg1, Stella_Object arg2, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { LogicObject argumentwithbacklinks = null;

              if ((arg1 != null) &&
                  Stella_Object.isaP(arg1, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                argumentwithbacklinks = ((LogicObject)(arg1));
              }
              else if ((arg2 != null) &&
                  Stella_Object.isaP(arg2, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
                argumentwithbacklinks = ((LogicObject)(arg2));
              }
              if (argumentwithbacklinks != null) {
                { Proposition p = null;
                  Iterator iter000 = Logic.allTrueDependentPropositions(argumentwithbacklinks, relation.surrogateValueInverse, false);

                  while (iter000.nextP()) {
                    p = ((Proposition)(iter000.value));
                    if (((arg1 == null) ||
                        Stella_Object.eqlP(arg1, Logic.valueOf((p.arguments.theArray)[0]))) &&
                        ((arg2 == null) ||
                         Stella_Object.eqlP(arg2, Logic.valueOf((p.arguments.theArray)[1])))) {
                      return (p);
                    }
                  }
                }
              }
              else {
                return (((Proposition)(PLI.helpGetPropositions(relation, Cons.consList(Cons.cons(arg1, Cons.cons(arg2, Stella.NIL))), 1, module, environment).value)));
              }
              return (null);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return propositions such that (<code>relation</code> <code>arg1</code> <code>arg2</code>)
   * is true.  The <code>relation</code> argument
   * must be bound to a relation.  One or both of the <code>arg1</code> and <code>arg2</code> arguments
   * may be set to NULL, which is interpreted as a wildcard.
   * @param relation
   * @param arg1
   * @param arg2
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getBinaryPropositions(LogicObject relation, Stella_Object arg1, Stella_Object arg2, Module module, Environment environment) {
    return (PLI.consToPlIterator(PLI.helpGetPropositions(relation, Cons.consList(Cons.cons(arg1, Cons.cons(arg2, Stella.NIL))), 0, module, environment)));
  }

  /** Return all values <code>v</code> such that (<code>relation</code> <code>arg</code> <code>v</code>)
   * has been asserted or can be inferred.
   * @param relation
   * @param arg
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getInferredBinaryPropositionValues(LogicObject relation, Stella_Object arg, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(Logic.applyCachedRetrieve(Cons.list$(Cons.cons(PLI.SYM_PLI_pR, Cons.cons(PLI.SYM_PLI_pI, Cons.cons(PLI.SYM_PLI_pV, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.list$(Cons.cons(PLI.SYM_PLI_pR, Cons.cons(PLI.SYM_PLI_pI, Cons.cons(PLI.SYM_PLI_pV, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(relation, Cons.cons(arg, Cons.cons(null, Stella.NIL)))), Cons.consList(Stella.NIL), PLI.SYM_PLI_F_GET_INFERRED_BINARY_PROPOSITION_VALUES_QUERY_000, new Object[2])));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return all values <code>v</code> such that (<code>relationName</code> <code>argName</code> <code>v</code>)
   * has been asserted or can be inferred.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param relationName
   * @param argName
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetInferredBinaryPropositionValues(String relationName, String argName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);
      Stella_Object renamed_Object = PLI.safelyGetObject(argName, ((Module)(module)), environment);

      if ((renamed_Object != null) &&
          (relation != null)) {
        return (PLI.getInferredBinaryPropositionValues(((LogicObject)(relation)), renamed_Object, ((Module)(module)), environment));
      }
      else {
        return (PLI.EMPTY_PL_ITERATOR);
      }
    }
  }

  /** Return all propositions that have <code>renamed_Object</code> among their arguments,
   * and that are TRUE in the scope of the module <code>module</code>.
   * @param renamed_Object
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getPropositionsOf(LogicObject renamed_Object, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.listToPlIterator(Logic.allFactsOfInstance(renamed_Object, false, false)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return all propositions that have the object named <code>objectName</code> among
   * their arguments, and that are TRUE in the scope of the module <code>moduleName</code>.
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param objectName
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetPropositionsOf(String objectName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object renamed_Object = PLI.safelyGetObject(objectName, ((Module)(module)), environment);

      if (renamed_Object != null) {
        return (PLI.getPropositionsOf(((LogicObject)(renamed_Object)), ((Module)(module)), environment));
      }
      else {
        return (PLI.EMPTY_PL_ITERATOR);
      }
    }
  }

  /** Return propositions that have been conceived in
   * the module <code>module</code>.
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getPropositionsInModule(Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(Logic.allPropositions(((Module)(Stella.$MODULE$.get())), true).consify()));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return TRUE if the proposition (<code>relation</code> <code>arg</code>) has
   * been asserted (or inferred by forward chaining).
   * @param relation
   * @param arg
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isTrueUnaryProposition(LogicObject relation, Stella_Object arg, Module module, Environment environment) {
    return (PLI.helpGetPropositions(relation, Cons.consList(Cons.cons(arg, Stella.NIL)), 1, module, environment) != null);
  }

  /** Return TRUE if the proposition (<code>relation</code> <code>arg</code> <code>value</code>) has
   * been asserted (or inferred by forward chaining).
   * @param relation
   * @param arg
   * @param value
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isTrueBinaryProposition(LogicObject relation, Stella_Object arg, Stella_Object value, Module module, Environment environment) {
    return (PLI.getBinaryProposition(relation, arg, value, module, environment) != null);
  }

  /** Return TRUE if a proposition (<code>relation</code> <code>args</code>) has
   * been asserted (or inferred by forward chaining).
   * @param relationAndArguments
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isTrueProposition1(Stella_Object relationAndArguments, Module module, Environment environment) {
    { Cons list = PLI.sequenceToConsList(relationAndArguments);
      Stella_Object relation = list.value;
      Cons arguments = list.rest;

      return (PLI.helpGetPropositions(((LogicObject)(relation)), arguments, 1, module, environment) != null);
    }
  }

  /** Return TRUE if <code>proposition</code> is  TRUE in the module <code>module</code>.
   * @param proposition
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isTrueProposition(Proposition proposition, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return ((!proposition.deletedP()) &&
                ((((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Proposition.falseP(proposition) : (Proposition.trueP(proposition) ||
                Proposition.functionWithDefinedValueP(proposition)))));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return TRUE if a proposition that prints as the string
   * <code>relationAndArguments</code> is true in the module named <code>moduleName</code>.
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param relationAndArguments
   * @param moduleName
   * @param environment
   * @return boolean
   */
  public static boolean sIsTrueProposition(String relationAndArguments, String moduleName, Environment environment) {
    return (PLI.sGetProposition(relationAndArguments, moduleName, environment) != null);
  }

  /** Return TRUE if <code>sub</code> is a subconcept/subrelation of <code>renamed_Super</code>.
   * @param sub
   * @param renamed_Super
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isSubrelation(LogicObject sub, LogicObject renamed_Super, Module module, Environment environment) {
    if ((sub == null) ||
        (renamed_Super == null)) {
      return (false);
    }
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (TruthValue.trueTruthValueP(Description.descriptionSpecializesDescriptionP(((Description)(sub)), ((Description)(renamed_Super)))));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return relations that specialize <code>relation</code>.
   * Non-reflexive.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getProperSubrelations(LogicObject relation, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(NamedDescription.allSubrelations(((NamedDescription)(relation)), true)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return relations that directly specialize <code>relation</code>.
   * Non-reflexive.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getDirectSubrelations(LogicObject relation, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(NamedDescription.allDirectSubrelations(((NamedDescription)(relation)), true)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return relations that generalize <code>relation</code>.
   * Non-reflexive.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getProperSuperrelations(LogicObject relation, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(NamedDescription.allSuperrelations(((NamedDescription)(relation)), true)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return relations that directly generalize <code>relation</code>.
   * Non-reflexive.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getDirectSuperrelations(LogicObject relation, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(NamedDescription.allDirectSuperrelations(((NamedDescription)(relation)), true)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return TRUE if <code>renamed_Object</code> is a member of the concept <code>concept</code>.
   * @param renamed_Object
   * @param concept
   * @param module
   * @param environment
   * @return boolean
   */
  public static boolean isA(Stella_Object renamed_Object, LogicObject concept, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.testIsaP(renamed_Object, concept.surrogateValueInverse));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return instances of the concept <code>concept</code>.
   * Include instances of subconcepts of <code>concept</code>.  Depending on <code>concept</code>,
   * the return values could be (wrapped) literals.
   * @param concept
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getConceptInstances(LogicObject concept, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            if ((environment != null) &&
                Stella.stringEqlP(environment.level, "ASSERTION")) {
              return (PLI.listToPlIterator(Logic.assertedCollectionMembers(concept, false).removeDeletedMembers()));
            }
            else {
              return (PLI.retrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_ALL, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Cons.cons(Logic.objectName(concept), Cons.cons(Logic.SYM_LOGIC_pX, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))), module, environment));
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return instances of concept <code>conceptName</code>.
   * Include instances of subconcepts of <code>conceptName</code>.  Depending on <code>conceptName</code>,
   * the return values could be (wrapped) literals.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param conceptName
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetConceptInstances(String conceptName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object concept = PLI.safelyGetConcept(conceptName, ((Module)(module)), environment);

      if (concept != null) {
        return (PLI.getConceptInstances(((LogicObject)(concept)), ((Module)(module)), environment));
      }
      else {
        return (PLI.EMPTY_PL_ITERATOR);
      }
    }
  }

  /** Return instances of concept <code>concept</code>.
   * Exclude instances of subconcepts of <code>concept</code>.  Depending on <code>concept</code>,
   * the return values could be (wrapped) literals.
   * @param concept
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getDirectConceptInstances(LogicObject concept, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            if ((environment != null) &&
                Stella.stringEqlP(environment.level, "ASSERTION")) {
              return (PLI.listToPlIterator(Logic.assertedCollectionMembers(concept, true).removeDeletedMembers()));
            }
            else {
              return (PLI.retrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_ALL, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.cons(Logic.objectName(concept), Cons.cons(Logic.SYM_LOGIC_pX, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_FAIL, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_EXISTS, Cons.cons(Cons.cons(Logic.SYM_LOGIC_pY, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(PLI.SYM_PLI_PROPER_SUBRELATION, Cons.cons(Logic.objectName(concept), Cons.cons(Cons.cons(Logic.SYM_LOGIC_pY, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pY, Cons.cons(Logic.SYM_LOGIC_pX, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), module, environment));
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return instances of concept <code>conceptName</code>.
   * Exclude instances of subconcepts of <code>conceptName</code>.  Depending on <code>conceptName</code>,
   * the return values could be (wrapped) literals.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param conceptName
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetDirectConceptInstances(String conceptName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object concept = PLI.safelyGetConcept(conceptName, ((Module)(module)), environment);

      if (concept != null) {
        return (PLI.getDirectConceptInstances(((LogicObject)(concept)), ((Module)(module)), environment));
      }
      else {
        return (PLI.EMPTY_PL_ITERATOR);
      }
    }
  }

  /** Return members of concept <code>concept</code> that
   * have an attribute matching <code>value</code> for the binary relation <code>relation</code>, i.e.,
   * <code>_relationLresultGValue_</code> holds.
   * @param concept
   * @param relation
   * @param value
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getConceptInstancesMatchingValue(LogicObject concept, LogicObject relation, Stella_Object value, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { PlIterator instances = PLI.getConceptInstances(concept, module, environment);
              Cons answers = Stella.NIL;

              { Stella_Object i = null;
                PlIterator iter000 = instances;

                while (iter000.nextP()) {
                  i = iter000.value;
                  if (PLI.isTrueBinaryProposition(relation, i, value, module, environment)) {
                    answers = Cons.cons(i, answers);
                  }
                }
              }
              return (PLI.consToPlIterator(answers));
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return a member of concept <code>concept</code> that
   * has an attribute matching <code>value</code> for the binary relation <code>relation</code>, i.e.,
   * <code>_relationLresultGValue_</code> holds.
   * @param concept
   * @param relation
   * @param value
   * @param module
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object getConceptInstanceMatchingValue(LogicObject concept, LogicObject relation, Stella_Object value, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { PlIterator instances = PLI.getConceptInstances(concept, module, environment);

              { Stella_Object i = null;
                PlIterator iter000 = instances;

                while (iter000.nextP()) {
                  i = iter000.value;
                  if (PLI.isTrueBinaryProposition(relation, i, value, module, environment)) {
                    return (i);
                  }
                }
              }
              return (null);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  static Cons helpGetTypes(LogicObject renamed_Object, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { Cons derivabletypes = Stella.NIL;

              if ((environment == null) ||
                  ((environment != null) &&
                   Stella.stringEqlP(environment.level, "INFERENCE"))) {
                derivabletypes = Logic.allTypes(renamed_Object);
              }
              else if ((environment != null) &&
                  Stella.stringEqlP(environment.level, "ASSERTION")) {
                derivabletypes = Logic.allAssertedTypes(renamed_Object);
              }
              else if ((environment != null) &&
                  Stella.stringEqlP(environment.level, "TAXONOMIC")) {
                derivabletypes = Logic.allTaxonomicTypes(renamed_Object);
              }
              return (derivabletypes);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return all named concepts that <code>renamed_Object</code> belongs to.
   * @param renamed_Object
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getTypes(LogicObject renamed_Object, Module module, Environment environment) {
    return (PLI.consToPlIterator(PLI.helpGetTypes(renamed_Object, module, environment)));
  }

  /** Return most specific concepts that <code>renamed_Object</code> belongs to.
   * @param renamed_Object
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getDirectTypes(LogicObject renamed_Object, Module module, Environment environment) {
    return (PLI.consToPlIterator(Logic.mostSpecificNamedDescriptions(PLI.helpGetTypes(renamed_Object, module, environment))));
  }

  /** Return propositions that satisfy <code>relation</code>.
   * Include propositions that satisfy subrelations of <code>relation</code>.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getRelationExtension(LogicObject relation, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (PLI.consToPlIterator(PLI.helpGetTrueExtensionMembers(((NamedDescription)(relation)), !((environment != null) &&
                Stella.stringEqlP(environment.level, "ASSERTION")))));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Return propositions that satisfy the relation named
   * <code>relationName</code>.  Include propositions that satisfy subrelations of the relation.
   * @param relationName
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetRelationExtension(String relationName, Module module, Environment environment) {
    { Stella_Object relation = PLI.safelyGetRelation(relationName, module, environment);

      if (relation != null) {
        return (PLI.getRelationExtension(((LogicObject)(relation)), module, environment));
      }
      else {
        return (PLI.EMPTY_PL_ITERATOR);
      }
    }
  }

  /** Return a module named <code>name</code>.
   * @param name
   * @param environment
   * @return Module
   */
  public static Module getModule(String name, Environment environment) {
    environment = environment;
    return (Stella.getStellaModule(name, false));
  }

  /** Return the module in which <code>renamed_Object</code> was created.
   * @param renamed_Object
   * @return Module
   */
  public static Module getHomeModule(LogicObject renamed_Object) {
    return (renamed_Object.homeModule());
  }

  /** Return all modules currently loaded into PowerLoom.  If <code>kbModulesOnlyP</code>
   * is <code>true</code>, then Stella modules that are used only for program code are
   * not included in the list.
   * @param kbModulesOnlyP
   * @return PlIterator
   */
  public static PlIterator getModules(boolean kbModulesOnlyP) {
    return (PLI.consToPlIterator(Stella.listModules(kbModulesOnlyP)));
  }

  /** Creates a new module <code>name</code> as a child of <code>parent</code>.  The flag
   * <code>caseSensitiveP</code> controls whether names read in this module will be
   * case sensitive or not.
   * @param name
   * @param parent
   * @param caseSensitiveP
   * @return Module
   */
  public static Module createModule(String name, Module parent, boolean caseSensitiveP) {
    { String fullName = ((parent != null) ? (parent.moduleFullName + "/" + name) : name);
      Symbol caseSensitiveSymbol = (caseSensitiveP ? Logic.SYM_STELLA_TRUE : Logic.SYM_STELLA_FALSE);

      return (Module.defineModule(fullName, Cons.list$(Cons.cons(PLI.KWD_CASE_SENSITIVEp, Cons.cons(caseSensitiveSymbol, Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  /** Creates a new module <code>name</code> as a child of <code>parentName</code>.  The flag
   * <code>caseSensitiveP</code> controls whether names read in this module will be
   * case sensitive or not.
   * @param name
   * @param parentName
   * @param caseSensitiveP
   * @param environment
   * @return Module
   */
  public static Module sCreateModule(String name, String parentName, boolean caseSensitiveP, Environment environment) {
    return (PLI.createModule(name, ((Module)(PLI.safelyGetModule(parentName, environment))), caseSensitiveP));
  }

  /** Set the current module to <code>module</code> and return it.
   * If <code>module</code> is <code>null</code>, then no switch is performed and the current
   * module is returned.
   * @param module
   * @return Module
   */
  public static Module changeModule(Module module) {
    if (module == null) {
      return (((Module)(Stella.$MODULE$.get())));
    }
    return (module.changeModule());
  }

  /** Set the current module to the module named <code>name</code>.
   * The return value is the module named <code>name</code> unless <code>name</code> is null or
   * the empty string.  In that case, the current module is returned.
   * If no module named <code>name</code> exists, a Stella <code>noSuchContextException</code>
   * is thrown.
   * @param name
   * @param environment
   * @return Module
   */
  public static Module sChangeModule(String name, Environment environment) {
    return (PLI.changeModule(((Module)(PLI.safelyGetModule(name, environment)))));
  }

  /** Destroy the contents of the module <code>module</code> as well as
   * the contents of all of its children, recursively.
   * @param module
   * @return Module
   */
  public static Module clearModule(Module module) {
    Stella.callClearModule(Cons.cons(module, Stella.NIL));
    return (module);
  }

  /** Destroy the contents of the module named <code>name</code>, as
   * well as the contents of all of its children, recursively.  If no module
   * named <code>name</code> exists, a Stella <code>noSuchContextException</code> is thrown.
   * @param name
   * @param environment
   * @return Module
   */
  public static Module sClearModule(String name, Environment environment) {
    { Context module = PLI.safelyGetModule(name, environment);

      Stella.callClearModule(Cons.cons(module, Stella.NIL));
      return (((Module)(module)));
    }
  }

  /** Return the modules that are immediate children of <code>module</code>.
   * @param module
   * @return PlIterator
   */
  public static PlIterator getChildModules(Module module) {
    { Cons directsubmodules = Stella.NIL;

      { Context child = null;
        Cons iter000 = module.childContexts.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((Context)(iter000.value));
          if (Stella_Object.isaP(child, Logic.SGT_STELLA_MODULE)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(child, Stella.NIL);
                if (directsubmodules == Stella.NIL) {
                  directsubmodules = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(directsubmodules, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(child, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (PLI.consToPlIterator(directsubmodules));
    }
  }

  /** Return the modules that are immediate children of module <code>name</code>.
   * If no module named <code>name</code> exists, a Stella <code>noSuchContextException</code>
   * is thrown.
   * @param name
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetChildModules(String name, Environment environment) {
    return (PLI.getChildModules(((Module)(PLI.safelyGetModule(name, environment)))));
  }

  /** Return the modules that are immediate parents of <code>module</code>.
   * @param module
   * @return PlIterator
   */
  public static PlIterator getParentModules(Module module) {
    return (PLI.listToPlIterator(module.parentModules));
  }

  /** Return the modules that are immediate parents of module <code>name</code>.
   * If no module named <code>name</code> exists, a Stella <code>noSuchContextException</code>
   * is thrown.
   * @param name
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetParentModules(String name, Environment environment) {
    return (PLI.getParentModules(((Module)(PLI.safelyGetModule(name, environment)))));
  }

  /** Generates a name based on <code>prefix</code> with a number appended that
   * is not currently in use in <code>moduleD</code>  In a non-case-sensitive module, the returned
   * name will be all upper case (This latter feature may change!)
   * @param prefix
   * @param module
   * @param environment
   * @return String
   */
  public static String generateUniqueName(String prefix, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            if (!(((Module)(Stella.$MODULE$.get())).caseSensitiveP ||
                Stella.allUpperCaseStringP(prefix))) {
              prefix = Native.stringUpcase(prefix);
            }
            return (Stella.yieldUniqueGensymName(prefix, ((Module)(Stella.$MODULE$.get()))));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Returns the Stella keyword <code>name</code>, creating it if
   * necessary.  <code>name</code> is treated case-sensitively.  This should
   * generally not be necessary to do.
   * @param name
   * @return Keyword
   */
  public static Keyword createKeyword(String name) {
    return (((Keyword)(GeneralizedSymbol.internRigidSymbolWrtModule(name, ((Module)(Stella.$MODULE$.get())), Stella.KEYWORD_SYM))));
  }

  /** Returns the Stella symbol <code>name</code> visible in <code>module</code>,
   * creating it if necessary.  <code>name</code> is ALWAYS treated case-sensitively,
   * even if <code>module</code> is case insensitive. This should generally not be
   * necessary to do.
   * @param name
   * @param module
   * @param environment
   * @return Symbol
   */
  public static Symbol createSymbol(String name, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Symbol.internSymbolInModule(name, ((Module)(Stella.$MODULE$.get())), false));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Create an object named <code>name</code> of type <code>concept</code> in the designated
   * module.  Both <code>name</code> and <code>concept</code> can be <code>null</code>.  If <code>name</code> is <code>null</code> then an
   * object will be created with a new, non-conflicting name based on the name of
   * <code>concept</code>, or system-generated if no concept is specified.  If <code>concept</code> is
   * <code>null</code>, then the object will be of type THING.  It is an error to create an
   * object with the same name as an existing object.
   * <p>
   * Note that the string can be a qualified name, in which case the object
   * will be created in the module specified, but with a name as determined
   * by the qualified name.  Vertical bars in the name string are interpreted
   * as Stella escape characters.
   * <p>
   * Note that because names in modules that are not case-sensitive are
   * canonicalized, the name of the returned object may not match <code>name</code>
   * exactly.
   * <p>
   * Return the object.
   * @param name
   * @param concept
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createObject(String name, LogicObject concept, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { LogicObject renamed_Object = null;
              Symbol nameSymbol = null;
              Surrogate objectSurrogate = null;

              if (name != null) {
                nameSymbol = ((Symbol)(Stella.internStellaName(name)));
              }
              else if (concept != null) {
                nameSymbol = Symbol.internSymbol(PLI.getShortName(concept));
                nameSymbol = Symbol.internSymbolInModule(PLI.generateUniqueName(nameSymbol.symbolName, ((Module)(nameSymbol.homeContext)), null), ((Module)(nameSymbol.homeContext)), true);
              }
              else {
                nameSymbol = Symbol.internSymbolInModule(PLI.generateUniqueName("I", null, null), ((Module)(Stella.$MODULE$.get())), true);
              }
              objectSurrogate = Surrogate.lookupSurrogateInModule(nameSymbol.symbolName, ((Module)(nameSymbol.homeContext)), false);
              if (objectSurrogate == null) {
                objectSurrogate = Surrogate.internSurrogateInModule(nameSymbol.symbolName, ((Module)(nameSymbol.homeContext)), false);
              }
              renamed_Object = ((LogicObject)(Logic.helpCreateLogicInstance(objectSurrogate, null)));
              if (concept != null) {
                if (PLI.assertUnaryProposition(concept, renamed_Object, module, environment) != null) {
                  return (renamed_Object);
                }
                else {
                  return (null);
                }
              }
              return (renamed_Object);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Create an object named <code>name</code> of type <code>conceptName</code> in the designated
   * module.  Both <code>name</code> and <code>conceptName</code> can be null strings.  If <code>name</code> is a null string
   * then an object will be created with a new, non-conflicting name based on <code>conceptName</code>, or
   * system-generated if no concept nameis specified.  If <code>conceptName</code> is the null string, then
   * the object will be of type THING.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * <p>
   * Return the object.
   * @param name
   * @param conceptName
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sCreateObject(String name, String conceptName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);

      return (PLI.createObject(name, ((LogicObject)(PLI.safelyGetConcept(conceptName, ((Module)(module)), environment))), ((Module)(module)), environment));
    }
  }

  /** Create a concept named <code>name</code> in the designated <code>module</code>, with the
   * designated <code>parent</code> superconcept (which can be left undefined).  Additional
   * superconcepts can be added via assertions of the <code>subsetOf</code> relation.  Note
   * that a specified <code>parent</code> concept needs to be created separately.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param parent
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createConcept(String name, LogicObject parent, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.callDefconcept(Cons.cons(Stella.internStellaName(name), (((parent != null) ? Cons.list$(Cons.cons(PLI.KWD_SUBSET_OF, Cons.cons(Logic.objectName(parent), Cons.cons(Stella.NIL, Stella.NIL)))) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL))));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Create a concept named <code>name</code> in the designated module, with
   * with the concept named <code>parentName</code> as superconcept (which can be left
   * undefined).  Additional superconcepts can be added via assertions of the
   * <code>subsetOf</code> relation.  Note that a specified parent concept needs to be
   * created separately.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param parentName
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sCreateConcept(String name, String parentName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);

      return (PLI.createConcept(name, ((LogicObject)(PLI.safelyGetConcept(parentName, ((Module)(module)), environment))), ((Module)(module)), environment));
    }
  }

  /** Create a relation named <code>name</code> with arity <code>arity</code> in the
   * designated module.  Domain and range information can be added via assertions
   * of <code>nthDomain</code> (or <code>domain</code> and <code>range</code>) relations.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param arity
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createRelation(String name, int arity, Module module, Environment environment) {
    if (!(arity > 0)) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("PARSING ERROR: Relations must have arity of at least 1.");
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Cons args = Stella.NIL;

      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { int i = Stella.NULL_INTEGER;
                int iter000 = 0;
                int upperBound000 = arity - 1;
                Cons collect000 = null;

                for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                  i = iter000;
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(Logic.yieldSystemDefinedParameterName(i, ((Module)(Stella.$MODULE$.get()))), Stella.NIL);
                      if (args == Stella.NIL) {
                        args = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(args, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(Logic.yieldSystemDefinedParameterName(i, ((Module)(Stella.$MODULE$.get()))), Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
              return (Logic.callDefrelation(Cons.cons(Stella.internStellaName(name), Cons.cons(args, Stella.NIL))));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Create a relation named <code>name</code> with arity <code>arity</code> in the
   * designated module.  Domain and range information can be added via assertions
   * of <code>nthDomain</code> (or <code>domain</code> and <code>range</code>) relations.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param arity
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sCreateRelation(String name, int arity, String moduleName, Environment environment) {
    return (PLI.createRelation(name, arity, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
  }

  /** Create a function named <code>name</code> with arity <code>arity</code>  in the designated 
   * <code>module</code>.  Domain and range information can be added via assertions of
   * <code>nthDomain</code> (or <code>domain</code> and <code>range</code>) relations.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param arity
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createFunction(String name, int arity, Module module, Environment environment) {
    if (!(arity > 0)) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream000.nativeStream.println("PARSING ERROR: Functions must have arity of at least 1.");
            Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        throw ((ParsingError)(ParsingError.newParsingError(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Cons args = Stella.NIL;

      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { int i = Stella.NULL_INTEGER;
                int iter000 = 0;
                int upperBound000 = arity - 1;
                Cons collect000 = null;

                for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                  i = iter000;
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(Logic.yieldSystemDefinedParameterName(i, ((Module)(Stella.$MODULE$.get()))), Stella.NIL);
                      if (args == Stella.NIL) {
                        args = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(args, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(Logic.yieldSystemDefinedParameterName(i, ((Module)(Stella.$MODULE$.get()))), Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
              return (Logic.callDeffunction(Cons.cons(Stella.internStellaName(name), Cons.cons(args, Stella.NIL))));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Create a function named <code>name</code> with arity <code>arity</code> in the designated 
   * module.  Domain and range information can be added via assertions of
   * <code>domain</code>, <code>nthDomain</code> and <code>range</code> relations.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * <p>
   * Note that because names in modules that are not case-sensitive are canonicalized,
   * the name of the returned object may not match <code>name</code> exactly.
   * @param name
   * @param arity
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sCreateFunction(String name, int arity, String moduleName, Environment environment) {
    return (PLI.createFunction(name, arity, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
  }

  /** Register <code>name</code> as a function name in <code>module</code> which will invoke the
   * native code procedure described by <code>functionReferenceD</code>  The <code>name</code>
   * is a fully-qualified name which will be interpreted by the normal
   * rules for reading names in PowerLoom.  The function must conform
   * to the signature for specialist functions.
   * <p>
   * The exact form of <code>functionReference</code> depends on the underlying
   * programming language.  The following type mappings are used:
   *           C++:  
   *   Common Lisp:  FUNCTION   (result of #' or (FUNCTION ...))
   *          Java:  java.lang.reflect.Method
   * @param name
   * @param functionReference
   * @param module
   * @param environment
   */
  public static void registerSpecialistFunction(String name, java.lang.reflect.Method functionReference, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.registerSpecialistFunction(name, functionReference);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Register <code>name</code> as a function name in the module named <code>moduleName</code>.
   * This function will the native code named <code>nativeName</code>.  The <code>name</code>
   * is a fully-qualified name which will be interpreted by the normal
   * rules for reading names in PowerLoom.  The <code>nativeName</code> will be
   * processed in a manner that depends on the underlying programming
   * language.  The following type mappings are used:
   *           C++:  Not available.  Error signaled.
   *   Common Lisp:  The native-name is read by READ-FROM-STRING and then
   *                 the SYMBOL-FUNCTION is taken.
   *          Java:  A fully package-qualified name is required.  It is
   *                 looked up using the Reflection tools.
   * The function found must conform to the signature for specialist functions.
   * @param name
   * @param nativeName
   * @param moduleName
   * @param environment
   */
  public static void sRegisterSpecialistFunction(String name, String nativeName, String moduleName, Environment environment) {
    { Module mdl000 = ((Module)(PLI.safelyGetModule(moduleName, environment)));
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.registerSpecialistFunctionName(name, nativeName);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Register <code>name</code> as a function name in <code>module</code> which will invoke the
   * native code procedure described by <code>functionReferenceD</code>  The <code>name</code>
   * is a fully-qualified name which will be interpreted by the normal
   * rules for reading names in PowerLoom.  The function must conform
   * to the signature for computation functions used by the computation
   * specialist.  Arity specifies the number of arguments the computation
   * accepts.
   * <p>
   * The exact form of <code>functionReference</code> depends on the underlying
   * programming language.  The following type mappings are used:
   *           C++:  cpp_function_code (a pointer to the function code)
   *   Common Lisp:  FUNCTION   (result of #' or (FUNCTION ...))
   *          Java:  java.lang.reflect.Method
   * @param name
   * @param functionReference
   * @param arity
   * @param module
   * @param environment
   */
  public static void registerComputationFunction(String name, java.lang.reflect.Method functionReference, int arity, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.registerComputationFunction(name, functionReference, arity);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Register <code>name</code> as a function name in the module named <code>moduleName</code>.
   * This function will the native code named <code>nativeName</code>.  The <code>name</code>
   * is a fully-qualified name which will be interpreted by the normal
   * rules for reading names in PowerLoom.  The <code>nativeName</code> will be
   * processed in a manner that depends on the underlying programming
   * language.  The following type mappings are used:
   *           C++:  Not available.  Error signaled.
   *   Common Lisp:  The native-name is read by READ-FROM-STRING and then
   *                 the SYMBOL-FUNCTION is taken.
   *          Java:  A fully package-qualified name is required.  It is
   *                 looked up using the Reflection tools.
   * The function found must conform to the signature for computation functions.
   * Arity specifies the number of arguments the computation accepts.
   * @param name
   * @param nativeName
   * @param arity
   * @param moduleName
   * @param environment
   */
  public static void sRegisterComputationFunction(String name, String nativeName, int arity, String moduleName, Environment environment) {
    { Module mdl000 = ((Module)(PLI.safelyGetModule(moduleName, environment)));
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.registerComputationFunctionName(name, nativeName, arity);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Create a logical term that denotes a list containing <code>members</code> in
   * <code>module</code> using <code>environment</code>.  Useful for passing lists as arguments
   * to parameterized queries.
   * @param members
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createEnumeratedList(Cons members, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { List self000 = List.newList();

              self000.theConsList = members;
              { Skolem value000 = Logic.createLogicalList(self000);

                return (value000);
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Create a logical term that denotes the enumerated set containing <code>members</code>
   * in <code>module</code> using <code>environment</code>.
   * @param members
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject createEnumeratedSet(Cons members, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { List self000 = List.newList();

              self000.theConsList = members;
              { Skolem value000 = Logic.createEnumeratedSet(self000);

                return (value000);
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Delete the object <code>renamed_Object</code>, retracting all facts attached to it.
   * @param renamed_Object
   */
  public static void destroyObject(Stella_Object renamed_Object) {
    synchronized (Logic.$POWERLOOM_LOCK$) {
      Logic.destroyObject(renamed_Object);
    }
  }

  /** Delete the object named <code>objectName</code>, retracting all facts
   * attached to it.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module. 
   * If no module can be found with the name <code>moduleName</code>, then a Stella 
   * <code>noSuchContextException</code> is thrown.
   * @param objectName
   * @param moduleName
   * @param environment
   */
  public static void sDestroyObject(String objectName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object renamed_Object = PLI.safelyGetObject(objectName, ((Module)(module)), environment);

      if (renamed_Object != null) {
        PLI.destroyObject(renamed_Object);
      }
    }
  }

  /** Assert that the proposition (<code>relation</code> <code>arg</code>) is TRUE in <code>module</code>.  Return the asserted proposition.
   * @param relation
   * @param arg
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition assertUnaryProposition(LogicObject relation, Stella_Object arg, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            if (Logic.classP(relation)) {
              return (Logic.assertIsaProposition(arg, relation.surrogateValueInverse));
            }
            else {
              return (LogicObject.assertProperty(((LogicObject)(arg)), relation.surrogateValueInverse));
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Assert that the proposition (<code>relation</code> <code>arg</code> <code>value</code>) is TRUE
   * in <code>module</code>.  Return the asserted proposition.
   * @param relation
   * @param arg
   * @param value
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition assertBinaryProposition(LogicObject relation, Stella_Object arg, Stella_Object value, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.assertBinaryValue(relation.surrogateValueInverse, arg, value));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Assert that the proposition represented by the list <code>RelationAndArguments</code> satisfies
   * the relation <code>relation</code>.
   * @param relationAndArguments
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition assertNaryProposition(Stella_Object relationAndArguments, Module module, Environment environment) {
    { Cons list = PLI.sequenceToConsList(relationAndArguments);
      NamedDescription relation = ((NamedDescription)(list.value));
      Surrogate relationsurrogate = relation.surrogateValueInverse;
      Cons arguments = list.rest;

      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (Logic.assertTuple(relationsurrogate, arguments));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Retract that the proposition (<code>relation</code> <code>arg</code>) is TRUE in <code>module</code>.  Return the asserted proposition.
   * @param relation
   * @param arg
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition retractUnaryProposition(LogicObject relation, Stella_Object arg, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            if (Logic.classP(relation)) {
              return (Logic.retractIsaProposition(arg, relation.surrogateValueInverse));
            }
            else {
              return (LogicObject.retractProperty(((LogicObject)(arg)), relation.surrogateValueInverse));
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Retract that the proposition (<code>relation</code> <code>arg</code> <code>value</code>) is TRUE
   * in <code>module</code>.  Return the asserted proposition.
   * @param relation
   * @param arg
   * @param value
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition retractBinaryProposition(LogicObject relation, Stella_Object arg, Stella_Object value, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            return (Logic.retractBinaryValue(relation.surrogateValueInverse, arg, value));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Retract the proposition that <code>arguments</code> satisfies
   * the relation <code>relation</code>.
   * @param relationAndArguments
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition retractNaryProposition(Stella_Object relationAndArguments, Module module, Environment environment) {
    { Cons list = PLI.sequenceToConsList(relationAndArguments);
      NamedDescription relation = ((NamedDescription)(list.value));
      Surrogate relationsurrogate = relation.surrogateValueInverse;
      Cons arguments = list.rest;

      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (Logic.updateTuple(relationsurrogate, arguments, Logic.KWD_RETRACT_TRUE));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Assert that the proposition <code>proposition</code> is true in <code>module</code>.
   * Return the asserted proposition.
   * @param proposition
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition assertProposition(Proposition proposition, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Proposition.helpUpdateTopLevelProposition(proposition, Logic.KWD_ASSERT_TRUE);
            return (proposition);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Assert that the logical sentence <code>sentence</code> is true in the module
   * named <code>moduleName</code>.  A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * <p>
   * Return an iterator of the propositions resulting from sentence.
   * @param sentence
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sAssertProposition(String sentence, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      PlIterator propositions = null;
      PlIterator returnValue = null;

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              propositions = PLI.sConceive(sentence, moduleName, environment);
              returnValue = PLI.consToPlIterator(propositions.cursor);
              { Proposition proposition = null;
                PlIterator iter000 = propositions;

                while (iter000.nextP()) {
                  proposition = ((Proposition)(iter000.value));
                  Proposition.helpUpdateTopLevelProposition(proposition, Logic.KWD_ASSERT_TRUE);
                }
              }
              return (returnValue);
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Retract the truth of the proposition <code>proposition</code> in <code>module</code>.
   * Return the retracted proposition.
   * @param proposition
   * @param module
   * @param environment
   * @return Proposition
   */
  public static Proposition retractProposition(Proposition proposition, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Proposition.helpUpdateTopLevelProposition(proposition, Logic.KWD_RETRACT_TRUE);
            return (proposition);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Retract the truth of the logical sentence <code>sentence</code> in the module named
   * <code>moduleName</code>.  A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * <p>
   * Return an iterator of the retracted propositions resulting from sentence.
   * @param sentence
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sRetractProposition(String sentence, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      PlIterator propositions = null;
      PlIterator returnValue = null;

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              propositions = PLI.sConceive(sentence, moduleName, environment);
              returnValue = PLI.consToPlIterator(propositions.cursor);
              { Proposition proposition = null;
                PlIterator iter000 = propositions;

                while (iter000.nextP()) {
                  proposition = ((Proposition)(iter000.value));
                  Proposition.helpUpdateTopLevelProposition(proposition, Logic.KWD_RETRACT_TRUE);
                }
              }
              return (returnValue);
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Create one or more proposition objects from the sentence <code>sentence</code>
   * in the  module <code>module</code>.  Return an iterator of the propositions.
   * If any of the new propositions has the same structure as an already existing
   * proposition, an automatic check for duplicates will return the pre-existing
   * proposition.  Multiple propositions may be returned for a single sentence
   * because of normalization of equivalences, conjunctions, etc.
   * <p>
   * Signals a <code>Proposition_Error</code> if PowerLoom could not conceive <code>sentence</code>.
   * @param sentence
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator conceive(Stella_Object sentence, Module module, Environment environment) {
    if (sentence == null) {
      return (null);
    }
    else {
      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { Stella_Object propositions = Logic.conceiveFormula(sentence);

                if (propositions == null) {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        stream000.nativeStream.println("ERROR: Failed to conceive `" + sentence + "'.");
                        Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                      }
                    }
                    throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
                { Surrogate testValue000 = Stella_Object.safePrimaryType(propositions);

                  if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
                    { Proposition propositions000 = ((Proposition)(propositions));

                      return (PLI.consToPlIterator(Cons.cons(propositions000, Stella.NIL)));
                    }
                  }
                  else if (testValue000 == Logic.SGT_STELLA_CONS) {
                    { Cons propositions000 = ((Cons)(propositions));

                      return (PLI.consToPlIterator(propositions000));
                    }
                  }
                  else {
                    { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                      { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                        try {
                          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                          stream001.nativeStream.println("ERROR: Formula is not a sentence: `" + sentence + "'.");
                          Logic.helpSignalPropositionError(stream001, Logic.KWD_ERROR);

                        } finally {
                          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                        }
                      }
                      throw ((PropositionError)(PropositionError.newPropositionError(stream001.theStringReader()).fillInStackTrace()));
                    }
                  }
                }
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Create one or more proposition objects from the sentence <code>sentence</code>
   * in the  module named <code>moduleName</code>.  Return an iterator of the propositions.
   * If any of the new propositions has the same structure as an already existing
   * proposition, an automatic check for duplicates will return the pre-existing
   * proposition.  Multiple propositions may be returned for a single sentence
   * because of normalization of equivalences, conjunctions, etc.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module.
   * If no module can be found with the name <code>moduleName</code>, then a Stella
   * <code>No_Such_Context_Exception</code> is thrown.
   * <p>
   * Signals a <code>Proposition_Error</code> if PowerLoom could not conceive <code>sentence</code>.
   * @param sentence
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sConceive(String sentence, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (PLI.conceive(Stella.readSExpressionFromString(sentence), ((Module)(module)), environment));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Return rules attached to the concept/relation <code>relation</code>
   * in either antecedent or consequent position.
   * @param relation
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator getRules(LogicObject relation, Module module, Environment environment) {
    if (relation == null) {
      return (PLI.EMPTY_PL_ITERATOR);
    }
    else {
      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (PLI.consToPlIterator(Logic.callGetRules(relation)));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Return rules attached to the concept/relation named
   * <code>relationName</code> found in the module named <code>moduleName</code>.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the current module.
   * If no module can be found with the name <code>moduleName</code>, then a Stella
   * <code>No_Such_Context_Exception</code> is thrown.
   * @param relationName
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sGetRules(String relationName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);

      return (PLI.getRules(((LogicObject)(relation)), ((Module)(module)), environment));
    }
  }

  /** Print rules attached to the concept/relation named <code>name</code>.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param name
   * @param stream
   * @param moduleName
   * @param environment
   */
  public static void sPrintRules(String name, OutputStream stream, String moduleName, Environment environment) {
    if (stream == null) {
      stream = Stella.STANDARD_OUTPUT;
    }
    { Proposition rule = null;
      PlIterator iter000 = PLI.sGetRules(name, moduleName, environment);

      while (iter000.nextP()) {
        rule = ((Proposition)(iter000.value));
        Logic.printLogicalForm(rule, stream);
        {
          stream.nativeStream.println("");
          stream.nativeStream.println();
        }
;
      }
    }
  }

  /** Run forward inference rules in module <code>module</code>.
   * If <code>module</code> is NULL, the
   * current module will be used.  If forward inferencing is already up-to-date
   * in the designated module, no additional inferencing will occur, unless <code>force</code>
   * is set to TRUE, in which case all forward rules are run or rerun.
   * <p>
   * Calling <code>runForwardRules</code> temporarily puts the module into a mode where
   * future assertional (monotonic) updates will trigger additional forward
   * inference.  Once a non-monotonic update is performed, i.e., a retraction
   * or clipping of relation value, all cached forward inferences will be discarded
   * and forward inferencing will be disabled until this function is
   * called again.
   * @param module
   * @param forceP
   */
  public static void runForwardRules(Stella_Object module, boolean forceP) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    if (module != null) {
      Logic.callRunForwardRules(((Module)(module)), forceP);
    }
  }

  /** Return the arity of the relation <code>relation</code>.
   * @param relation
   * @return int
   */
  public static int getArity(LogicObject relation) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(relation), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
      { NamedDescription relation000 = ((NamedDescription)(relation));

        return (relation000.arity());
      }
    }
    else {
      return (0);
    }
  }

  /** Return the arity of the relation named <code>relationName</code>.
   * <p>
   *  A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationName
   * @param moduleName
   * @param environment
   * @return int
   */
  public static int sGetArity(String relationName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);

      if (relation != null) {
        return (PLI.getArity(((LogicObject)(relation))));
      }
      else {
        return (Stella.NULL_INTEGER);
      }
    }
  }

  /** Return the type (a concept) for the first argument to the binary
   * relation <code>relation</code>.
   * @param relation
   * @return LogicObject
   */
  public static LogicObject getDomain(LogicObject relation) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(relation), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
      { NamedDescription relation000 = ((NamedDescription)(relation));

        return (PLI.getNthDomain(relation000, 0));
      }
    }
    else {
      return (null);
    }
  }

  /** Return the type (concept) for the first argument to the binary
   * relation <code>relationName</code>.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationName
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sGetDomain(String relationName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);

      if (relation != null) {
        return (PLI.getDomain(((LogicObject)(relation))));
      }
      else {
        return (null);
      }
    }
  }

  /** Return the type (a concept) for fillers of the binary relation
   * <code>relation</code>.
   * @param relation
   * @return LogicObject
   */
  public static LogicObject getRange(LogicObject relation) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(relation), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
      { NamedDescription relation000 = ((NamedDescription)(relation));

        return (PLI.getNthDomain(relation000, 1));
      }
    }
    else {
      return (null);
    }
  }

  /** Return the type (a concept) for fillers of the binary relation
   * <code>relationName</code>.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationName
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sGetRange(String relationName, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);

      if (relation != null) {
        return (PLI.getRange(((LogicObject)(relation))));
      }
      else {
        return (null);
      }
    }
  }

  /** Return the type (a concept) for the the nth argument of the
   * relation <code>relation</code>.  Counting starts at zero.  NOTE: if there are multiple
   * <code>nthDomain</code> propositions for <code>relation</code>, this arbitrarily returns one of them;
   * it does not look for the most specific one (which might have to be created).
   * @param relation
   * @param n
   * @return LogicObject
   */
  public static LogicObject getNthDomain(LogicObject relation, int n) {
    if (Logic.classP(relation)) {
      return (((n == 0) ? relation : null));
    }
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(relation), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
      { NamedDescription relation000 = ((NamedDescription)(relation));

        if ((n >= 0) &&
            (n < relation000.ioVariableTypes.length())) {
          { Proposition domainprop = ((Proposition)(PLI.helpGetPropositions(((LogicObject)(PLI.SGT_PL_KERNEL_KB_NTH_DOMAIN.surrogateValue)), Cons.cons(relation000, Cons.cons(IntegerWrapper.wrapInteger(n), Cons.cons(null, Stella.NIL))), 1, null, null).value));

            if (domainprop != null) {
              return (((LogicObject)((domainprop.arguments.theArray)[(domainprop.arguments.length() - 1)])));
            }
          }
        }
      }
    }
    else {
    }
    return (null);
  }

  /** Return the type (a concept) for the nth argument of the relation
   * named <code>relationName</code>.  Counting starts at zero.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param relationName
   * @param n
   * @param moduleName
   * @param environment
   * @return LogicObject
   */
  public static LogicObject sGetNthDomain(String relationName, int n, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);
      Stella_Object relation = PLI.safelyGetRelation(relationName, ((Module)(module)), environment);

      if (relation != null) {
        return (PLI.getNthDomain(((LogicObject)(relation)), n));
      }
      else {
        return (null);
      }
    }
  }

  /** Read logic commands from the file named <code>filename</code> and evaluate them.
   * The file should contain an <code>inModule</code> declaration that specifies the module
   * within which all remaining commands are to be evaluated.  The remaining commands
   * are evaluated one-by-one, applying the function <code>evaluate</code> to each of them.
   * @param filename
   * @param environment
   */
  public static void load(String filename, Environment environment) {
    { Module mdl000 = ((Module)(Stella.$MODULE$.get()));
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.load(filename, Stella.NIL);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Read logic commands from the file named <code>filename</code> and evaluate them.
   * If the file does not have an <code>inModule</code> declaration that specifies the module
   * within which all remaining commands are to be evaluated, it will be loaded
   * in the <code>module</code> specified.  If no <code>module</code> is specified and the file does
   * not contain an <code>inModule</code> declaration, an error will be signaled.
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param filename
   * @param module
   * @param environment
   */
  public static void loadInModule(String filename, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.load(filename, Cons.cons(Logic.KWD_MODULE, Cons.cons(module, Stella.NIL)));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Read logic commands from the STELLA stream <code>stream</code> and evaluate them.
   * The stream should contain an <code>inModule</code> declaration that specifies
   * the module within which all remaining commands are to be evaluated.
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param stream
   * @param environment
   */
  public static void loadStream(InputStream stream, Environment environment) {
    { Module mdl000 = ((Module)(Stella.$MODULE$.get()));
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.loadStream(stream);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Read logic commands from the STELLA stream <code>stream</code> and evaluate them.
   * If the stream does not supply an <code>inModule</code> declaration that specifies the
   * module within which all remaining commands are to be evaluated, it will be
   * loaded in the <code>module</code> specified.  If no <code>module</code> is specified and the file 
   * does not supply an <code>inModule</code> declaration, an error will be signaled.
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param stream
   * @param module
   * @param environment
   */
  public static void loadStreamInModule(InputStream stream, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            Logic.loadStreamInModule(stream, module);
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Read logic commands from the native input stream <code>stream</code> and evaluate them.
   * Assumes <code>stream</code> is a line-buffered stream which is a safe compromise but does
   * not generate the best efficiency for block-buffered streams such as files.
   * The stream should begin with an <code>inModule</code> declaration that specifies
   * the module within which all remaining commands are to be evaluated
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param stream
   * @param environment
   */
  public static void loadNativeStream(edu.isi.stella.javalib.NativeInputStream stream, Environment environment) {
    { Module mdl000 = ((Module)(Stella.$MODULE$.get()));
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { InputStream self000 = InputStream.newInputStream();

              self000.nativeStream = stream;
              Logic.loadStream(self000);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Read logic commands from the native input stream <code>stream</code> and evaluate them.
   * Assumes <code>stream</code> is a line-buffered stream which is a safe compromise but does
   * not generate the best efficiency for block-buffered streams such as files.
   * If the stream does not supply an <code>inModule</code> declaration that specifies the
   * module within which all remaining commands are to be evaluated, it will be
   * loaded in the <code>module</code> specified.  If no <code>module</code> is specified and the file 
   * does not supply an <code>inModule</code> declaration, an error will be signaled.
   * The remaining commands are evaluated one-by-one, applying the function
   * <code>evaluate</code> to each of them.
   * @param stream
   * @param module
   * @param environment
   */
  public static void loadNativeStreamInModule(edu.isi.stella.javalib.NativeInputStream stream, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { InputStream self000 = InputStream.newInputStream();

              self000.nativeStream = stream;
              Logic.loadStreamInModule(self000, module);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Save the contents of the module <code>mod</code> into a file named <code>filename</code>.
   * If a file named <code>filename</code> already exists, then the action taken depends on the
   * value of <code>ifexists</code>.  Possible values are &quot;ASK&quot;, &quot;REPLACE&quot;, &quot;WARN&quot; and &quot;ERROR&quot;:
   * <p>
   *   REPLACE =&gt; Means overwrite without warning.
   *   WARN    =&gt; Means overwrite with a warning.
   *   ERROR   =&gt; Means don't overwrite, signal an error instead.
   *   ASK     =&gt; Ask the user whether to overwrite or not.  If not overwritten, an 
   *              exception is thrown.
   * @param module
   * @param filename
   * @param ifexists
   * @param environment
   */
  public static void saveModule(Module module, String filename, String ifexists, Environment environment) {
    { boolean existsP = Stella.probeFileP(filename);

      if ((!existsP) ||
          Stella.stringEqualP(ifexists, "REPLACE")) {
      }
      else if (Stella.stringEqualP(ifexists, "ASK")) {
        if (!(Stella.yesOrNoP("File `" + filename + "' already exists.  Overwrite it? (yes or no) "))) {
          Stella.ensureFileDoesNotExist(filename, "save-module");
        }
      }
      else if (Stella.stringEqualP(ifexists, "WARN")) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: File `" + filename + "' already exists, overwriting.");
      }
      else if (Stella.stringEqualP(ifexists, "ERROR")) {
        Stella.ensureFileDoesNotExist(filename, "save-module");
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Unrecognized ifexists option `" + ifexists + "'");
          throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { OutputFileStream stream = null;

                try {
                  stream = Stella.openOutputFile(filename, Stella.NIL);
                  Logic.doSaveModule(((Module)(Stella.$MODULE$.get())), stream);

                } finally {
                  if (stream != null) {
                    stream.free();
                  }
                }
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Save the contents of the module <code>moduleName</code> into a file named <code>filename</code>.
   * If a file named <code>filename</code> already exists, then the action taken depends on the
   * value of <code>ifexists</code>.  Possible values are &quot;ASK&quot;, &quot;REPLACE&quot;, &quot;WARN&quot; and &quot;ERROR&quot;:
   * <p>
   *   REPLACE =&gt; Means overwrite without warning.
   *   WARN    =&gt; Means overwrite with a warning.
   *   ERROR   =&gt; Means don't overwrite, signal an error instead.
   *   ASK     =&gt; Ask the user whether to overwrite or not.  If not overwritten, an
   *              exception is thrown.
   * <p>
   * A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param moduleName
   * @param filename
   * @param ifexists
   * @param environment
   */
  public static void sSaveModule(String moduleName, String filename, String ifexists, Environment environment) {
    PLI.saveModule(((Module)(PLI.safelyGetModule(moduleName, environment))), filename, ifexists, environment);
  }

  /** Return the concept or relation predicate for
   * the proposition <code>prop</code>.
   * @param prop
   * @return LogicObject
   */
  public static LogicObject getPredicate(Proposition prop) {
    { LogicObject relation = Logic.getDescription(((Surrogate)(prop.operator)));

      if (relation == null) {
        relation = ((LogicObject)(((Surrogate)(prop.operator)).surrogateValue));
      }
      return (relation);
    }
  }

  /** Return the number of columns in <code>obj</code>, which must
   * be of type proposition, cons, vector or PL-iterator.  For a proposition,
   * the number includes both the predidate and arguments. For the PL-iterator
   * case,the number of columns is for the current value of the iterator.
   * <p>
   * For a null item, the column count is zero.
   * For non sequence objects, the column count is one.
   * @param obj
   * @return int
   */
  public static int getColumnCount(Stella_Object obj) {
    if (obj == null) {
      return (0);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(obj);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
        { Proposition obj000 = ((Proposition)(obj));

          return (obj000.arguments.length() + 1);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, PLI.SGT_PLI_PL_ITERATOR)) {
        { PlIterator obj000 = ((PlIterator)(obj));

          return (PLI.getColumnCount(obj000.value));
        }
      }
      else if (testValue000 == Logic.SGT_STELLA_CONS) {
        { Cons obj000 = ((Cons)(obj));

          return (obj000.length());
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_VECTOR)) {
        { Vector obj000 = ((Vector)(obj));

          return (obj000.length());
        }
      }
      else {
        return (1);
      }
    }
  }

  /** Return the value in the <code>nth</code> column of <code>sequence</code>.
   * Counting starts at zero.  Unless <code>n</code> is zero, <code>sequence</code> must be of type
   * proposition, cons, vector or PL-iterator.  A zero column number returns
   * a proposition's relational predicate.  For the PL-iterator case, the number
   * of columns is for the current value of the iterator.
   * <p>
   * As a special case, a column number of zero will also return <code>sequence</code> itself
   * if it is not one of the types enumerated above.  This is done to allow the
   * use of <code>getNthValue</code> on PL-iterators with only a single return variable.
   * @param sequence
   * @param n
   * @param module
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object getNthValue(Stella_Object sequence, int n, Module module, Environment environment) {
    if ((n >= PLI.getColumnCount(sequence)) ||
        (n < 0)) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Column index `" + n + "' is out of range for `" + sequence + "'");
        throw ((LogicException)(LogicException.newLogicException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(sequence);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PROPOSITION)) {
        { Proposition sequence000 = ((Proposition)(sequence));

          if (n == 0) {
            return (PLI.getPredicate(sequence000));
          }
          else {
            { Stella_Object value = (sequence000.arguments.theArray)[(n - 1)];

              if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(value), Logic.SGT_LOGIC_SKOLEM)) {
                { Skolem value000 = ((Skolem)(value));

                  { Module mdl000 = module;
                    Context cxt000 = mdl000;

                    if (mdl000 == null) {
                      mdl000 = ((Module)(Stella.$MODULE$.get()));
                      cxt000 = ((Context)(Stella.$CONTEXT$.get()));
                    }
                    { Object old$Module$000 = Stella.$MODULE$.get();
                      Object old$Context$000 = Stella.$CONTEXT$.get();

                      try {
                        Native.setSpecial(Stella.$MODULE$, mdl000);
                        Native.setSpecial(Stella.$CONTEXT$, cxt000);
                        environment = environment;
                        synchronized (Logic.$POWERLOOM_LOCK$) {
                          return (Logic.valueOf(value000));
                        }

                      } finally {
                        Stella.$CONTEXT$.set(old$Context$000);
                        Stella.$MODULE$.set(old$Module$000);
                      }
                    }
                  }
                }
              }
              else {
                return (value);
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, PLI.SGT_PLI_PL_ITERATOR)) {
        { PlIterator sequence000 = ((PlIterator)(sequence));

          return (PLI.getNthValue(sequence000.value, n, module, environment));
        }
      }
      else if (testValue000 == Logic.SGT_STELLA_CONS) {
        { Cons sequence000 = ((Cons)(sequence));

          return (sequence000.nth(n));
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_STELLA_VECTOR)) {
        { Vector sequence000 = ((Vector)(sequence));

          return ((sequence000.theArray)[n]);
        }
      }
      else {
        return (sequence);
      }
    }
  }

  /** Return a string representation of the value in the <code>nth</code> column of
   * <code>sequence</code>. Counting starts at zero.   Unless <code>n</code> is zero, <code>sequence</code> must be of type
   * proposition, cons, vector or PL-iterator.  A zero column number returns
   * a proposition's relational predicate.  For the PL-iterator case, the
   * the current value pointed to by the iterator is used.  This will always
   * succeed, even if the <code>nth</code> value is not a string object.  In that case, a
   * string reprensentation will be returned.
   * <p>
   * <p>
   * As a special case, a column number of zero will also return <code>sequence</code> itself
   * as a string if it is not one of the types enumerated above.  This is done to 
   * allow the use of <code>getNthString</code> on PL-iterators with only a single return variable.
   * @param sequence
   * @param n
   * @param module
   * @param environment
   * @return String
   */
  public static String getNthString(Stella_Object sequence, int n, Module module, Environment environment) {
    return (PLI.objectToString(PLI.getNthValue(sequence, n, module, environment)));
  }

  /** Return an integer representation of the value in the <code>nth</code> column of
   * <code>sequence</code>. Counting starts at zero.   Unless <code>n</code> is zero, <code>sequence</code> must be of type
   * proposition, cons, vector or PL-iterator.  A zero column number returns
   * a proposition's relational predicate.  For the PL-iterator case, the
   * the current value pointed to by the iterator is used.  If this is not
   * an integer value, then an exception will be thrown.
   * <p>
   * <p>
   * As a special case, a column number of zero will also return the integer
   * value of <code>sequence</code> itself if it is not one of the types enumerated
   * above.   This allows the use of <code>getNthInteger</code> on PL-iterators with
   * only a single return variable.  If  <code>sequence</code> cannot be turned into an
   * integer, an exception will be thrown.
   * @param sequence
   * @param n
   * @param module
   * @param environment
   * @return int
   */
  public static int getNthInteger(Stella_Object sequence, int n, Module module, Environment environment) {
    return (PLI.objectToInteger(PLI.getNthValue(sequence, n, module, environment)));
  }

  /** Return the floating point value in the <code>nth</code> column of
   * <code>sequence</code>. Counting starts at zero.  <code>sequence</code> must be of type
   * proposition, cons, vector or PL-iterator.  A zero column number returns
   * a proposition's relational predicate.  For the PL-iterator case, the
   * the current value pointed to by the iterator is used.  If this is not
   * a floating point value, then an exception will be thrown.
   * <p>
   * <p>
   * As a special case, a column number of zero will also return the floating
   * point value of <code>sequence</code> itself if it is not one of the types enumerated
   * above.  This allows the use of <code>getNthFloat</code> on PL-iterators with only
   * a single return variable.    If  <code>sequence</code> cannot be turned into a floating
   * point value, an exception will be thrown.
   * @param sequence
   * @param n
   * @param module
   * @param environment
   * @return double
   */
  public static double getNthFloat(Stella_Object sequence, int n, Module module, Environment environment) {
    return (PLI.objectToFloat(PLI.getNthValue(sequence, n, module, environment)));
  }

  /** Return a logic object representation of the value in the <code>nth</code> column
   * of <code>sequence</code>.  Counting starts at zero.   Unless <code>n</code> is zero, <code>sequence</code> must be of type
   * proposition, cons, vector or PL-iterator.  A zero column number returns
   * a proposition's relational predicate.  For the PL-iterator case, the
   * the current value pointed to by the iterator is used.  A zero column number
   * returns the proposition's relational predicate.  If the return value is
   * not a LOGIC-OBJECT, an exception is thrown.
   * <p>
   * As a special case, a column number of zero will also return <code>sequence</code> itself
   * if it is not one of the types enumerated above.  This is done to allow the
   * use of <code>getNthValue</code> on PL-iterators with only a single return variable.
   * If <code>sequence</code> is not a LOGIC-OBJECT, an exception is thrown.
   * @param sequence
   * @param n
   * @param module
   * @param environment
   * @return LogicObject
   */
  public static LogicObject getNthLogicObject(Stella_Object sequence, int n, Module module, Environment environment) {
    { Stella_Object value = PLI.getNthValue(sequence, n, module, environment);

      if (Stella_Object.isaP(value, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        return (((LogicObject)(value)));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Can't coerce `" + value + "' to a LOGIC-OBJECT.");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Returns the members of an enumerated collection.  This works on all types
   * of collection, i.e., sets and lists
   * @param collection
   * @param module
   * @param environment
   * @return Cons
   */
  public static Cons getEnumeratedCollectionMembers(Stella_Object collection, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            { List members = Logic.assertedCollectionMembers(collection, true);

              if (members != null) {
                return (members.theConsList);
              }
              else {
                return (null);
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Evaluate the command <code>command</code> within <code>module</code> and return
   * the result. Currently, only the evaluation of (possibly nested) commands and
   * global variables is supported.  Commands are simple to program in Common Lisp,
   * since they are built into the language, and relatively awkward in Java and C++.
   * Users of either of those languages are more likely to want to call <code>sEvaluate</code>.
   * @param command
   * @param module
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object evaluate(Stella_Object command, Module module, Environment environment) {
    if (command != null) {
      { Module mdl000 = module;
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (Stella_Object.evaluate(command));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
    return (null);
  }

  /** Evaluate the command represented by the string <code>command</code> within <code>module</code> and
   * return the result.  Currently, only the evaluation of (possibly nested) commands and
   * global variables is supported.
   * <p>
   *  A module name of <code>null</code> or the empty string refers to the
   * current module.  If no module can be found with the name <code>moduleName</code>,
   * then a Stella <code>noSuchContextException</code> is thrown.
   * @param command
   * @param moduleName
   * @param environment
   * @return Stella_Object
   */
  public static Stella_Object sEvaluate(String command, String moduleName, Environment environment) {
    { Context module = PLI.safelyGetModule(moduleName, environment);

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              return (PLI.evaluate(Stella.readSExpressionFromString(command), ((Module)(module)), environment));
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
    }
  }

  /** Test whether <code>obj</code> is of type LOGIC-OBJECT
   * @param obj
   * @return boolean
   */
  public static boolean isLogicObject(Stella_Object obj) {
    return (Stella_Object.isaP(obj, Logic.SGT_LOGIC_LOGIC_OBJECT));
  }

  /** Test whether <code>obj</code> is of type INTEGER
   * @param obj
   * @return boolean
   */
  public static boolean isInteger(Stella_Object obj) {
    return (Stella_Object.isaP(obj, Logic.SGT_STELLA_INTEGER_WRAPPER));
  }

  /** Test whether <code>obj</code> is of type FLOAT (double)
   * @param obj
   * @return boolean
   */
  public static boolean isFloat(Stella_Object obj) {
    return (Stella_Object.isaP(obj, Logic.SGT_STELLA_FLOAT_WRAPPER));
  }

  /** Test whether <code>obj</code> is of type NUMBER.  This can
   * be either an integer or a floating point number.  One key characteristic
   * is that 'object-to-integer' and <code>objectToFloat</code> will both work on it.
   * @param obj
   * @return boolean
   */
  public static boolean isNumber(Stella_Object obj) {
    return (Stella_Object.isaP(obj, Logic.SGT_STELLA_NUMBER_WRAPPER));
  }

  /** Test whether <code>obj</code> is of type STRING
   * @param obj
   * @return boolean
   */
  public static boolean isString(Stella_Object obj) {
    return (Stella_Object.isaP(obj, Logic.SGT_STELLA_STRING_WRAPPER));
  }

  /** Test whether <code>obj</code> is an enumerated collection.  This
   * subsumes both sets and lists.
   * @param obj
   * @return boolean
   */
  public static boolean isEnumeratedCollection(Stella_Object obj) {
    return (Logic.logicalCollectionP(obj));
  }

  /** Test whether <code>obj</code> is an enumerated set.
   * @param obj
   * @return boolean
   */
  public static boolean isEnumeratedSet(Stella_Object obj) {
    return (Logic.enumeratedSetP(obj));
  }

  /** Test whether <code>obj</code> is an enumerated list
   * @param obj
   * @return boolean
   */
  public static boolean isEnumeratedList(Stella_Object obj) {
    return (Logic.enumeratedListP(obj));
  }

  /** Tests whether <code>tv</code> is a true truth value.  It can be true
   * either absolutely or by default.
   * @param tv
   * @return boolean
   */
  public static boolean isTrue(TruthValue tv) {
    return ((tv == Logic.TRUE_TRUTH_VALUE) ||
        (tv == Logic.DEFAULT_TRUE_TRUTH_VALUE));
  }

  /** Tests whether <code>tv</code> is a false truth value.  It can be false
   * either absolutely or by default.
   * @param tv
   * @return boolean
   */
  public static boolean isFalse(TruthValue tv) {
    return ((tv == Logic.FALSE_TRUTH_VALUE) ||
        (tv == Logic.DEFAULT_FALSE_TRUTH_VALUE));
  }

  /** Tests whether <code>tv</code> is an unknown truth value.
   * @param tv
   * @return boolean
   */
  public static boolean isUnknown(TruthValue tv) {
    return ((tv == Logic.UNKNOWN_TRUTH_VALUE) ||
        (tv == null));
  }

  /** Tests whether <code>tv</code> is a known truth value (i.e., true or false).
   * @param tv
   * @return boolean
   */
  public static boolean isKnown(TruthValue tv) {
    return (TruthValue.knownTruthValueP(tv));
  }

  /** Tests whether <code>tv</code> is an inconsistent truth value.
   * @param tv
   * @return boolean
   */
  public static boolean isInconsistent(TruthValue tv) {
    return (tv == Logic.INCONSISTENT_TRUTH_VALUE);
  }

  /** Tests whether <code>tv</code> is a strict (non-default) truth value.
   * @param tv
   * @return boolean
   */
  public static boolean isStrict(TruthValue tv) {
    return ((tv == Logic.TRUE_TRUTH_VALUE) ||
        (tv == Logic.FALSE_TRUTH_VALUE));
  }

  /** Tests whether <code>tv</code> is a default truth value.
   * @param tv
   * @return boolean
   */
  public static boolean isDefault(TruthValue tv) {
    return ((tv == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv == Logic.DEFAULT_FALSE_TRUTH_VALUE));
  }

  /** Returns a truth value for <code>query</code> in <code>module</code> and <code>environment</code>.
   * <code>query</code> has the same syntax as the PowerLoom <code>ask</code> command (which see)
   * but with the <code>ask</code> operator omitted.  For example, here are some legal
   * <code>query</code> arguments:
   * 	 
   *     ((happy Fred))
   *     ((happy Fred) :inference-level :assertion)
   *     ((happy Fred) :inference-level :assertion :timeout 1.0)
   * 	
   * As a convenience, a <code>query</code> argument whose first element is a symbol is
   * interpreted as a sentence that is queried without any options.  For example:
   * 	 
   *     (happy Fred)
   * 	
   * is a legal <code>query</code> argument.  Note that for a sentence whose relation is a list
   * itself, e.g., <code>__FruitFn_BananaTree__MyBanana_</code> this shortcut is not available,
   * that is, in that case an extra level of list nesting is always necessary.
   * The returned truth value represents the logical truth of the queried sentence
   * as determined by PowerLoom.  It can be be tested via the functions <code>isTrue</code>,
   * <code>isFalse</code> and <code>isUnknown</code> (which see).
   * @param query
   * @param module
   * @param environment
   * @return TruthValue
   */
  public static TruthValue ask(Cons query, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            query = ((Cons)(Logic.deobjectifyTree(query)));
            if (Stella_Object.symbolP(query.value)) {
              query = Cons.cons(query, Stella.NIL);
            }
            return (Logic.callAsk(query));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Returns a truth value for <code>query</code> in module <code>moduleName</code> and <code>environment</code>.
   * <code>query</code> has the same syntax as the PowerLoom <code>ask</code> command (which see) but
   * with the <code>ask</code> operator omitted.  Different from the PLI <code>ask</code> function, <code>sAsk</code>
   * does not expect a top-level pair of parentheses.  For example, here are some legal
   * <code>query</code> arguments:
   * 	 
   *     &quot;(happy Fred)&quot;
   *     &quot;(happy Fred) :inference-level :assertion&quot;
   *     &quot;(happy Fred) :inference-level :assertion :timeout 1.0&quot;
   * 	
   * Names in <code>query</code> will be interpreted relative to module <code>moduleName</code>.
   * A null <code>moduleName</code> or the empty string refers to the current module.
   * If no module can be found with the name <code>moduleName</code>, then a STELLA
   * <code>noSuchContextException</code> is thrown.
   * The returned truth value represents the logical truth of the queried sentence
   * as determined by PowerLoom.  It can be be tested via the functions <code>isTrue</code>,
   * <code>isFalse</code> and <code>isUnknown</code> (which see).
   * @param query
   * @param moduleName
   * @param environment
   * @return TruthValue
   */
  public static TruthValue sAsk(String query, String moduleName, Environment environment) {
    { Cons queryform = Stella.NIL;
      Context module = PLI.safelyGetModule(moduleName, environment);

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { Stella_Object sexp = null;
                SExpressionIterator iter000 = InputStream.sExpressions(InputStringStream.newInputStringStream(query));
                Cons collect000 = null;

                while (iter000.nextP()) {
                  sexp = iter000.value;
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(sexp, Stella.NIL);
                      if (queryform == Stella.NIL) {
                        queryform = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(queryform, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(sexp, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
      return (PLI.ask(queryform, ((Module)(PLI.safelyGetModule(moduleName, environment))), environment));
    }
  }

  /** Returns an iterator of variable bindings that when substituted for the
   * open variables in <code>query</code> satisfy the query proposition.  The query is
   * run in <code>module</code> and relative to <code>environment</code>.  <code>query</code> has the same syntax
   * as the PowerLoom <code>retrieve</code> command (which see) but with the <code>retrieve</code>
   * operator omitted.    For example, here are some legal <code>query</code> arguments:
   * 	 
   *     ((happy ?x))
   *     (10 (happy ?x))
   *     (all (happy ?x))
   *     (all ?x (happy ?x))
   *     (10 (happy ?x) :inference-level :assertion)
   *     (10 (happy ?x) :inference-level :assertion :timeout 1.0)
   * 	
   * If there is only a single output variable (as in all the examples above)
   * each element generated by the returned iterator will be a binding for
   * that variable - unless, the output variable was declared with a surrounding
   * pair of parentheses.  For example:
   * 	 
   *     (all (?x) (happy ?x))
   * 	
   * In that case, the generated elements will be one-element lists.  If there
   * are multiple output variables, each element generated by the returned
   * iterator will be a list of variable bindings that can be accessed using
   * the various <code>getNthDDD</code> functions.  The list of output variables does
   * not need to be declared in which case they are taken to be the open variables
   * in the query proposition in the order in which they were encountered.  If
   * order does matter or should be different from its default, it can be forced
   * by declaring the set of output variables.
   * @param query
   * @param module
   * @param environment
   * @return PlIterator
   */
  public static PlIterator retrieve(Cons query, Module module, Environment environment) {
    { Module mdl000 = module;
      Context cxt000 = mdl000;

      if (mdl000 == null) {
        mdl000 = ((Module)(Stella.$MODULE$.get()));
        cxt000 = ((Context)(Stella.$CONTEXT$.get()));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, mdl000);
          Native.setSpecial(Stella.$CONTEXT$, cxt000);
          environment = environment;
          synchronized (Logic.$POWERLOOM_LOCK$) {
            query = ((Cons)(Logic.deobjectifyTree(query)));
            return (PLI.consToPlIterator(Logic.callRetrieve(query).consifyCurrentSolutions()));
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  /** Returns an iterator of variable bindings that when substituted for the
   * open variables in <code>query</code> satisfy the query proposition.  The query is
   * run in <code>module</code> and relative to <code>environment</code>.  <code>query</code> has the same syntax
   * as the PowerLoom <code>retrieve</code> command (which see) but with the <code>retrieve</code>
   * operator omitted.  Different from the PLI <code>retrieve</code> function, <code>sRetrieve</code>
   * does not expect a top-level pair of parentheses.  For example, here are some
   * legal <code>query</code> arguments:
   * 	 
   *     &quot;(happy ?x)&quot;
   *     &quot;10 (happy ?x)&quot;
   *     &quot;all (happy ?x)&quot;
   *     &quot;all ?x (happy ?x)&quot;
   *     &quot;10 (happy ?x) :inference-level :assertion&quot;
   *     &quot;10 (happy ?x) :inference-level :assertion :timeout 1.0&quot;
   * 	
   * If there is only a single output variable (as in all the examples above)
   * each element generated by the returned iterator will be a binding for
   * that variable - unless, the output variable was declared with a surrounding
   * pair of parentheses.  For example:
   * 	 
   *     &quot;all (?x) (happy ?x)&quot;
   * 	
   * In that case, the generated elements will be one-element lists.  If there
   * are multiple output variables, each element generated by the returned
   * iterator will be a list of variable bindings that can be accessed using
   * the various <code>getNthDDD</code> functions.  The list of output variables does
   * not need to be declared in which case they are taken to be the open variables
   * in the query proposition in the order in which they were encountered.  If
   * order does matter or should be different from its default, it can be forced
   * by declaring the set of output variables.
   * <p>
   * Names in <code>query</code> will be interpreted relative to module <code>moduleName</code>.
   * A null <code>moduleName</code> or the empty string refers to the current module.
   * If no module can be found with the name <code>moduleName</code>, then a STELLA
   * <code>noSuchContextException</code> is thrown.
   * @param query
   * @param moduleName
   * @param environment
   * @return PlIterator
   */
  public static PlIterator sRetrieve(String query, String moduleName, Environment environment) {
    { Cons queryform = Stella.NIL;
      Context module = PLI.safelyGetModule(moduleName, environment);

      { Module mdl000 = ((Module)(module));
        Context cxt000 = mdl000;

        if (mdl000 == null) {
          mdl000 = ((Module)(Stella.$MODULE$.get()));
          cxt000 = ((Context)(Stella.$CONTEXT$.get()));
        }
        { Object old$Module$000 = Stella.$MODULE$.get();
          Object old$Context$000 = Stella.$CONTEXT$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, mdl000);
            Native.setSpecial(Stella.$CONTEXT$, cxt000);
            environment = environment;
            synchronized (Logic.$POWERLOOM_LOCK$) {
              { Stella_Object sexp = null;
                SExpressionIterator iter000 = InputStream.sExpressions(InputStringStream.newInputStringStream(query));
                Cons collect000 = null;

                while (iter000.nextP()) {
                  sexp = iter000.value;
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(sexp, Stella.NIL);
                      if (queryform == Stella.NIL) {
                        queryform = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(queryform, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(sexp, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
            }

          } finally {
            Stella.$CONTEXT$.set(old$Context$000);
            Stella.$MODULE$.set(old$Module$000);
          }
        }
      }
      return (PLI.retrieve(queryform, ((Module)(module)), environment));
    }
  }

  public static void main(String[] argv061) {
    Stella.STANDARD_OUTPUT.nativeStream.println("Initializing STELLA...");
    StartupStellaSystem.startupStellaSystem();
    Stella.STANDARD_OUTPUT.nativeStream.println("Initializing PowerLoom...");
    StartupLogicSystem.startupLogicSystem();
    Stella.string_changeModule("PL-USER");
    Logic.powerloom();
  }

}
