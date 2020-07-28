//  -*- Mode: Java -*-
//
// List.java

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

public class List extends Sequence {
    public Cons theConsList;

  /** Return a list containing <code>values</code>, in order.
   * @param values
   * @return List
   */
  public static List list(Cons values) {
    { List list = List.newList();

      { Stella_Object v = null;
        Cons iter000 = values;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(v, Stella.NIL);
              if (list.theConsList == Stella.NIL) {
                list.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(list.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(v, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (list);
    }
  }

  public static List newList() {
    { List self = null;

      self = new List();
      self.theConsList = Stella.NIL;
      return (self);
    }
  }

  public static List cppSortUnitsForHeaderFile(List fileunits) {
    { Cons globals = Stella.NIL;
      Cons auxiliaryglobals = Stella.NIL;
      Cons methods = Stella.NIL;
      Cons includestatements = Stella.NIL;
      Cons classes = Stella.NIL;
      Cons main = Stella.NIL;

      { TranslationUnit unit = null;
        Cons iter000 = fileunits.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          { Symbol testValue000 = unit.category;

            if ((testValue000 == Stella.SYM_STELLA_METHOD) ||
                ((testValue000 == Stella.SYM_STELLA_PRINT_METHOD) ||
                 (testValue000 == Stella.SYM_STELLA_MACRO))) {
              if (TranslationUnit.cppUnitDefinesMainP(unit)) {
                main = Cons.cons(unit, main);
              }
              else {
                methods = Cons.cons(unit, methods);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
              { Cons translation = ((Cons)(unit.translation));
                String code = ((StringWrapper)(translation.rest.value)).wrapperValue;

                if ((code.charAt(0) == '#') &&
                    (!(Stella.$CHARACTER_TYPE_TABLE$[(int) (code.charAt(1))] == Stella.KWD_WHITE_SPACE))) {
                  { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

                    self000.category = Stella.SYM_STELLA_VERBATIM;
                    self000.translation = Stella_Object.copyConsTree(unit.translation);
                    includestatements = Cons.cons(self000, includestatements);
                  }
                  translation.secondSetter(StringWrapper.wrapString(""));
                }
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_CLASS) {
              classes = Cons.cons(unit, classes);
            }
            else if (testValue000 == Stella.SYM_STELLA_GLOBAL_VARIABLE) {
              if (TranslationUnit.auxiliaryVariableUnitP(unit)) {
                auxiliaryglobals = Cons.cons(unit, auxiliaryglobals);
                unit.category = Stella.SYM_STELLA_AUXILIARY_VARIABLE;
              }
              else {
                globals = Cons.cons(unit, globals);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_TYPE) {
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
      return (List.list(Cons.cons(includestatements.reverse(), Cons.cons(classes.reverse(), Cons.cons(globals.reverse(), Cons.cons(methods.reverse(), Cons.cons(auxiliaryglobals.reverse(), Cons.cons(main, Stella.NIL))))))));
    }
  }

  public static Module computeFileUnitsModule(List fileunits) {
    { TranslationUnit unit = null;
      Cons iter000 = fileunits.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        unit = ((TranslationUnit)(iter000.value));
        if (unit.tuHomeModule != null) {
          return (unit.tuHomeModule);
        }
      }
    }
    return (((Module)(Stella.$MODULE$.get())));
  }

  public static List ejectDemon(List demonlist, Demon demon) {
    if (demonlist == null) {
      return (null);
    }
    demonlist.remove(demon);
    if (demonlist.emptyP()) {
      demonlist.free();
      demonlist = null;
    }
    return (demonlist);
  }

  public static List injectDemon(List demonlist, Demon demon) {
    if (List.nullListP(demonlist)) {
      demonlist = List.newList();
    }
    { ListIterator it = ((ListIterator)(demonlist.allocateIterator()));

      while (it.nextP()) {
        if (Stella.stringEqlP(((Demon)(it.value)).demonName, demon.demonName)) {
          it.valueSetter(demon);
          return (demonlist);
        }
      }
    }
    demonlist.insert(demon);
    return (demonlist);
  }

  public static void helpPrintContextTree(List list, int level) {
    { Context c = null;
      Cons iter000 = list.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        c = ((Context)(iter000.value));
        Stella.STANDARD_OUTPUT.nativeStream.println();
        { int i = Stella.NULL_INTEGER;
          int iter001 = 1;
          int upperBound000 = level;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter001 <= upperBound000); iter001 = iter001 + 1) {
            i = iter001;
            i = i;
            Stella.STANDARD_OUTPUT.nativeStream.print("   ");
          }
        }
        Stella.STANDARD_OUTPUT.nativeStream.print(c.contextNumber);
        if (c.contextName() != null) {
          Stella.STANDARD_OUTPUT.nativeStream.print("   " + c.contextName());
        }
        Stella.STANDARD_OUTPUT.nativeStream.println();
        List.helpPrintContextTree(c.childContexts, level + 1);
      }
    }
  }

  public static void clOutputSystemClStructsFile(List classunits) {
    { String outputfile = Stella.makeFileName(Stella.clYieldStructClassFileName(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).name), Stella.KWD_LISP, true);
      OutputFileStream outputstream = OutputFileStream.newOutputFileStream(outputfile);
      List classes = List.newList();
      Module currentmodule = ((Module)(Stella.$MODULE$.get()));
      String renamed_Package = null;
      List ensuredpackages = List.list(Stella.NIL);

      { TranslationUnit unit = null;
        Cons iter000 = classunits.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          unit = ((TranslationUnit)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(unit.theObject, Stella.NIL);
              if (classes.theConsList == Stella.NIL) {
                classes.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(classes.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(unit.theObject, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      classes = List.sortClStructClasses(classes);
      if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Writing `" + outputfile + "'...");
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, ((Module)(Stella.$MODULE$.get())));
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          if (classes.nonEmptyP()) {
            Native.setSpecial(Stella.$MODULE$, ((Stella_Class)(classes.first())).homeModule());
          }
          else {
            Native.setSpecial(Stella.$MODULE$, Stella.getStellaModule(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).cardinalModule, true));
          }
          currentmodule = ((Module)(Stella.$MODULE$.get()));
          OutputStream.clOutputFileHeader(outputstream, outputfile, true);
          { TranslationUnit unit = null;
            Cons iter001 = classunits.theConsList;
            Stella_Class renamed_Class = null;
            Cons iter002 = classes.theConsList;

            for (;(!(iter001 == Stella.NIL)) &&
                      (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
              unit = ((TranslationUnit)(iter001.value));
              renamed_Class = ((Stella_Class)(iter002.value));
              unit.theObject = renamed_Class;
              unit.annotation = null;
              Native.setSpecial(Stella.$MODULE$, renamed_Class.homeModule());
              if (!(((Module)(Stella.$MODULE$.get())) == currentmodule)) {
                currentmodule = ((Module)(Stella.$MODULE$.get()));
                renamed_Package = ((Module)(Stella.$MODULE$.get())).lispPackage();
                if (!(ensuredpackages.memberP(StringWrapper.wrapString(renamed_Package)))) {
                  ensuredpackages.push(StringWrapper.wrapString(renamed_Package));
                  outputstream.nativeStream.println();
                  OutputStream.clOutputEnsurePackageDefinition(outputstream, renamed_Package);
                }
                outputstream.nativeStream.println();
                OutputStream.clOutputInPackageDeclaration(outputstream, renamed_Package);
              }
              unit.translation = TranslationUnit.clTranslateDefineNativeClassUnit(unit);
              TranslationUnit.clOutputOneUnit(unit, outputstream.nativeStream);
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
      outputstream.free();
    }
  }

  public static List sortClStructClasses(List unsortedclasses) {
    { HashTable classtable = HashTable.newHashTable();
      List roots = List.list(Stella.NIL);
      List sortedclasses = List.list(Stella.NIL);

      { Stella_Class renamed_Class = null;
        Cons iter000 = unsortedclasses.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Class = ((Stella_Class)(iter000.value));
          classtable.insertAt(renamed_Class.classType, Stella.TRUE_WRAPPER);
        }
      }
      { Stella_Class renamed_Class = null;
        Cons iter001 = unsortedclasses.theConsList;
        Cons collect000 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          renamed_Class = ((Stella_Class)(iter001.value));
          { boolean testValue000 = false;

            { boolean foundP000 = false;

              { Surrogate renamed_Super = null;
                Cons iter002 = renamed_Class.classDirectSupers.theConsList;

                loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  renamed_Super = ((Surrogate)(iter002.value));
                  if (((BooleanWrapper)(classtable.lookup(renamed_Super))) != null) {
                    foundP000 = true;
                    break loop002;
                  }
                }
              }
              testValue000 = foundP000;
            }
            testValue000 = !testValue000;
            if (testValue000) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(renamed_Class, Stella.NIL);
                  if (roots.theConsList == Stella.NIL) {
                    roots.theConsList = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(roots.theConsList, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(renamed_Class, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
      }
      while (roots.nonEmptyP()) {
        sortedclasses.push(((Stella_Class)(roots.first())));
        { Surrogate sub = null;
          Cons iter003 = ((Stella_Class)(roots.pop())).classDirectSubs.theConsList;

          for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
            sub = ((Surrogate)(iter003.value));
            if (((BooleanWrapper)(classtable.lookup(sub))) != null) {
              roots.push(((Stella_Class)(sub.surrogateValue)));
            }
          }
        }
      }
      return (sortedclasses.reverse());
    }
  }

  public static void extractStartupFunctionUnits(List startupunits, Symbol startupfnname) {
    { int remainingunits = startupunits.length();
      int minunitsperfunction = Native.floor((((double)(Stella.$MAX_NUMBER_OF_STARTUP_UNITS$)) / Stella.$STARTUP_TIME_PHASES$.length()) + 1);
      Cons cursor = startupunits.theConsList;
      Cons phasestart = cursor;
      int phaseunits = 0;
      Keyword phase = ((Keyword)(((TranslationUnit)(cursor.value)).codeRegister));
      Keyword unitphase = phase;
      int helpfncounter = 0;

      loop000 : while (!(cursor == Stella.NIL)) {
        unitphase = ((Keyword)(((TranslationUnit)(cursor.value)).codeRegister));
        if (unitphase == phase) {
          phaseunits = phaseunits + 1;
          if (phaseunits < Stella.$MAX_NUMBER_OF_STARTUP_UNITS$) {
            cursor = cursor.rest;
            continue loop000;
          }
        }
        if (phaseunits < minunitsperfunction) {
          phasestart = cursor;
          phaseunits = 0;
          phase = unitphase;
          continue loop000;
        }
        { Symbol functionname = Symbol.internDerivedSymbol(startupfnname, "HELP-" + startupfnname.symbolName + Native.integerToString(((long)(helpfncounter = helpfncounter + 1))));
          Cons helpfntree = ((Cons)(((TranslationUnit)(phasestart.value)).theObject));

          ((TranslationUnit)(phasestart.value)).theObject = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_FUNCTION, Cons.cons(functionname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
          phasestart = phasestart.rest;
          { ConsIterator it = phasestart.allocateIterator();
            int i = Stella.NULL_INTEGER;
            int iter000 = 2;
            int upperBound000 = phaseunits;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;it.nextP() &&
                      (unboundedP000 ||
                       (iter000 <= upperBound000)); iter000 = iter000 + 1) {
              i = iter000;
              i = i;
              helpfntree = helpfntree.concatenate(((Cons)(((TranslationUnit)(it.value)).theObject)), Stella.NIL);
              TranslationUnit.clearTranslationUnit(((TranslationUnit)(it.value)));
              it.valueSetter(null);
            }
          }
          helpfntree = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(functionname, Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VOID_SYS, Cons.cons(Cons.cons(Stella.SYM_STELLA_PROGN, helpfntree.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL))));
          KeyValueList.setDynamicSlotValue(((MethodSlot)(Cons.helpWalkAuxiliaryTree(helpfntree, true).theObject)).dynamicSlots, Stella.SYM_STELLA_METHOD_STARTUP_CLASSNAME, StringWrapper.wrapString(Symbol.yieldStartupFunctionClassname(startupfnname)), Stella.NULL_STRING_WRAPPER);
          remainingunits = remainingunits - (phaseunits - 1);
          if (remainingunits <= Stella.$MAX_NUMBER_OF_STARTUP_UNITS$) {
            break loop000;
          }
          if (unitphase == phase) {
            cursor = cursor.rest;
          }
          phasestart = cursor;
          phaseunits = 0;
          phase = ((Keyword)(((TranslationUnit)(cursor.value)).codeRegister));
        }
      }
      startupunits.remove(null);
    }
  }

  public Iterator allocateDestructiveListIterator() {
    { List self = this;

      { Iterator iterator = self.theConsList.allocateDestructiveListIterator();

        self.theConsList = Stella.NIL;
        self.free();
        return (iterator);
      }
    }
  }

  /** Return <code>self</code>.
   * @return List
   */
  public List listify() {
    { List self = this;

      return (self);
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherlist</code> by destructively
   * removing elements from <code>self</code> that also occur in <code>otherlist</code>.  Uses an <code>eqlP</code>
   * test and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if <code>self</code> is a set.
   * @param otherlist
   * @return List
   */
  public List subtract(List otherlist) {
    { List self = this;

      self.theConsList = self.theConsList.subtract(otherlist.theConsList);
      return (self);
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherlist</code> (i.e., all elements
   * that are in <code>self</code> but not in <code>otherSet</code>).  Uses an <code>eqlP</code> test and a simple
   * quadratic-time algorithm.  Note that the result is only guaranteed to be a
   * set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return List
   */
  public List difference(List otherlist) {
    { List self = this;

      { List result = List.createDerivedList(self);

        result.theConsList = self.theConsList.difference(otherlist.theConsList);
        return (result);
      }
    }
  }

  /** Return the set union of <code>self</code> and <code>otherlist</code>.  Uses an <code>eqlP</code> test
   * and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return List
   */
  public List union(List otherlist) {
    { List self = this;

      { List result = List.createDerivedList(self);

        result.theConsList = self.theConsList.union(otherlist.theConsList);
        return (result);
      }
    }
  }

  /** Return the set intersection of <code>self</code> and <code>otherlist</code>.  Uses an <code>eqlP</code>
   * test and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return List
   */
  public List intersection(List otherlist) {
    { List self = this;

      { List result = List.createDerivedList(self);

        result.theConsList = self.theConsList.intersection(otherlist.theConsList);
        return (result);
      }
    }
  }

  /** Return true if every element of <code>self</code> occurs in <code>otherlist</code> and vice versa.
   * Uses an <code>eqlP</code> test and a simple quadratic-time algorithm.  Note that
   * this does not check whether <code>self</code> and <code>otherlist</code> actually are sets.
   * @param otherlist
   * @return boolean
   */
  public boolean equivalentSetsP(List otherlist) {
    { List self = this;

      return (self.theConsList.equivalentSetsP(otherlist.theConsList));
    }
  }

  /** Return true if every element of <code>self</code> also occurs in <code>otherlist</code>.
   * Uses an <code>eqlP</code> test and a simple quadratic-time algorithm.  Note that
   * this does not check whether <code>self</code> and <code>otherlist</code> actually are sets.
   * @param otherlist
   * @return boolean
   */
  public boolean subsetP(List otherlist) {
    { List self = this;

      return (self.theConsList.subsetP(otherlist.theConsList));
    }
  }

  public List removeDeletedMembers() {
    { List self = this;

      self.theConsList = self.theConsList.removeDeletedMembers();
      return (self);
    }
  }

  /** Generate all but the last element of the list <code>self</code>.
   * @return Iterator
   */
  public Iterator butLast() {
    { List self = this;

      return (self.theConsList.butLast());
    }
  }

  public AbstractIterator allocateIterator() {
    { List self = this;

      { ListIterator iterator = ListIterator.newListIterator();

        iterator.listIteratorCursor = self.theConsList;
        iterator.listIteratorCollection = self;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of elements of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { List self = this;

      { int code = 5619580;

        return ((code ^ (self.theConsList.equalHashCode())));
      }
    }
  }

  /** Return TRUE iff the lists <code>x</code> and <code>y</code> are structurally
   * equivalent.  Uses <code>equalP</code> to test equality of elements.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { List x = this;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(y), Stella.SGT_STELLA_LIST)) {
        { List y000 = ((List)(y));

          return (Stella_Object.equalP(x.theConsList, y000.theConsList));
        }
      }
      else {
      }
      return (false);
    }
  }

  /** Return NIL-LIST iff <code>self</code> is NULL or <code>self</code> otherwise.
   * @param self
   * @return List
   */
  public static List mapNullToNilList(List self) {
    return (((self == null) ? Stella.NIL_LIST : self));
  }

  /** Perform a stable, destructive sort of <code>self</code> according to
   * <code>predicate</code>, and return the result.  If <code>predicate</code> has a '&lt;' semantics, the
   * result will be in ascending order.  If <code>predicate</code> is NULL, a suitable
   * '&lt;' predicate is chosen depending on the first element of <code>self</code>, and it 
   * is assumed that all elements of <code>self</code> have the same type (supported
   * element types are GENERALIZED-SYMBOL, STRING, INTEGER, and FLOAT).
   * @param predicate
   * @return List
   */
  public List sort(java.lang.reflect.Method predicate) {
    { List self = this;

      self.theConsList = self.theConsList.sort(predicate);
      return (self);
    }
  }

  /** Make <code>self</code> an empty list.
   */
  public void clear() {
    { List self = this;

      self.theConsList = Stella.NIL;
    }
  }

  /** Return a copy of the list <code>self</code>.  The conses in the copy are
   * freshly allocated.
   * @return List
   */
  public List copy() {
    { List self = this;

      { List copy = List.createDerivedList(self);

        copy.theConsList = Cons.copyConsList(self.theConsList);
        return (copy);
      }
    }
  }

  /** Create a new list object with the same type as <code>self</code>.
   * @param self
   * @return List
   */
  public static List createDerivedList(List self) {
    { Surrogate listtype = self.primaryType();

      if (listtype == Stella.SGT_STELLA_LIST) {
        return (List.newList());
      }
      else if (listtype == Stella.SGT_STELLA_SET) {
        return (Set.newSet());
      }
      else {
        return (((List)(Surrogate.createObject(listtype, Stella.NIL))));
      }
    }
  }

  /** Copy <code>list2</code> onto the front of the list <code>self</code>.
   * The operation is destructive wrt <code>self</code>, but leaves <code>list2</code> intact.
   * @param list2
   * @return List
   */
  public List prepend(List list2) {
    { List self = this;

      if (list2.emptyP()) {
        return (self);
      }
      self.theConsList = Cons.copyConsList(list2.theConsList).concatenate(self.theConsList, Stella.NIL);
      return (self);
    }
  }

  /** Copy <code>list2</code> and all <code>otherlists</code> onto the end of <code>list1</code>.
   * The operation is destructive wrt <code>list1</code>, but leaves all other lists intact.
   * The two mandatory parameters allow us to optimize the common binary case by
   * not relying on the somewhat less efficient variable arguments mechanism.
   * @param list2
   * @param otherlists
   * @return List
   */
  public List concatenate(List list2, Cons otherlists) {
    { List list1 = this;

      { Cons firstlist = list1.theConsList;
        Cons lastlist = list2.theConsList;
        Cons copy = Stella.NIL;

        if (firstlist == Stella.NIL) {
          firstlist = Cons.copyConsList(lastlist);
          lastlist = firstlist;
        }
        else if (lastlist == Stella.NIL) {
          lastlist = firstlist;
        }
        else {
          lastlist = Cons.copyConsList(lastlist);
          Cons.lastCons(firstlist).rest = lastlist;
        }
        if (otherlists.length() > 0) {
          { List list = null;
            Cons iter000 = otherlists;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              list = ((List)(iter000.value));
              if (list.nonEmptyP()) {
                copy = Cons.copyConsList(list.theConsList);
                if (!(lastlist == Stella.NIL)) {
                  Cons.lastCons(lastlist).rest = copy;
                }
                else {
                  firstlist = copy;
                }
                lastlist = copy;
              }
            }
          }
        }
        list1.theConsList = firstlist;
        return (list1);
      }
    }
  }

  /** Destructively replace each appearance of <code>outvalue</code> by
   * <code>invalue</code> in the list <code>self</code>.
   * @param invalue
   * @param outvalue
   * @return List
   */
  public List substitute(Stella_Object invalue, Stella_Object outvalue) {
    { List self = this;

      self.theConsList = self.theConsList.substitute(invalue, outvalue);
      return (self);
    }
  }

  /** Reverse the members of <code>self</code> (in place).
   * @return List
   */
  public List reverse() {
    { List self = this;

      self.theConsList = self.theConsList.reverse();
      return (self);
    }
  }

  /** Remove and return the first element in the list <code>self</code>.
   * Return NULL if the list is empty.
   * @return Stella_Object
   */
  public Stella_Object pop() {
    { List self = this;

      { Cons cons = self.theConsList;
        Stella_Object value = null;

        if (cons == Stella.NIL) {
          return (null);
        }
        value = cons.value;
        self.theConsList = cons.rest;
        return (value);
      }
    }
  }

  /** <code>removeDuplicates</code> (which see) using an <code>equalP</code> test.
   * @return List
   */
  public List removeDuplicatesEqual() {
    { List self = this;

      if (!(self.theConsList == Stella.NIL)) {
        self.theConsList = self.theConsList.removeDuplicatesEqual();
      }
      return (self);
    }
  }

  /** Destructively remove duplicates from <code>self</code> and return the result.
   * Preserves the original order of the remaining members.
   * @return Collection
   */
  public Collection removeDuplicates() {
    { List self = this;

      if (!(self.theConsList == Stella.NIL)) {
        self.theConsList = self.theConsList.removeDuplicates();
      }
      return (self);
    }
  }

  /** Destructively remove all members of the list <code>self</code> for which
   * 'test?' evaluates to TRUE.  <code>test</code> takes a single argument of type OBJECT and
   * returns TRUE or FALSE.  Returns <code>self</code>.
   * @param testP
   * @return List
   */
  public List removeIf(java.lang.reflect.Method testP) {
    { List self = this;

      self.theConsList = self.theConsList.removeIf(testP);
      return (self);
    }
  }

  /** Destructively remove all entries in <code>self</code> that match <code>value</code>.
   * @param value
   * @return AbstractCollection
   */
  public AbstractCollection remove(Stella_Object value) {
    { List self = this;

      self.theConsList = self.theConsList.remove(value);
      return (self);
    }
  }

  /** Insert <code>value</code> as the last entry in the list <code>self</code>.
   * @param value
   */
  public void insertLast(Stella_Object value) {
    { List self = this;

      if (!(!(self == Stella.NIL_LIST))) {
        System.err.print("Safety violation: Attempt to insert into NIL-LIST.");
      }
      { Cons cursor = self.theConsList;
        Cons lastcons = Cons.cons(value, Stella.NIL);

        if (cursor == Stella.NIL) {
          self.theConsList = lastcons;
        }
        else {
          Cons.addConsToEndOfConsList(cursor, lastcons);
        }
      }
    }
  }

  /** Add <code>value</code> to the front of the list <code>self</code> unless its 
   * already a member.
   * @param value
   */
  public void insertNew(Stella_Object value) {
    { List self = this;

      if (!(!(self == Stella.NIL_LIST))) {
        System.err.print("Safety violation: Attempt to insert into NIL-LIST.");
      }
      if (!self.theConsList.memberP(value)) {
        self.theConsList = Cons.cons(value, self.theConsList);
      }
    }
  }

  /** Add <code>value</code> to the front of the list <code>self</code>.
   * @param value
   */
  public void push(Stella_Object value) {
    { List self = this;

      if (!(!(self == Stella.NIL_LIST))) {
        System.err.print("Safety violation: Attempt to insert into NIL-LIST.");
      }
      self.theConsList = Cons.cons(value, self.theConsList);
    }
  }

  /** Add <code>value</code> to the front of the list <code>self</code>.
   * @param value
   */
  public void insert(Stella_Object value) {
    { List self = this;

      if (!(!(self == Stella.NIL_LIST))) {
        System.err.print("Safety violation: Attempt to insert into NIL-LIST.");
      }
      self.theConsList = Cons.cons(value, self.theConsList);
    }
  }

  /** Return the position of <code>renamed_Object</code> within the list
   * <code>self</code> (counting from zero); or return NULL if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>end</code> was supplied as non-NULL, only 
   * consider the sublist ending at <code>end</code>, however, the returned position 
   * will always be relative to the entire list.
   * @param renamed_Object
   * @param end
   * @return int
   */
  public int lastPosition(Stella_Object renamed_Object, int end) {
    { List self = this;

      return (self.theConsList.lastPosition(renamed_Object, end));
    }
  }

  /** Return the position of <code>renamed_Object</code> within the list
   * <code>self</code> (counting from zero); or return NULL if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>start</code> was supplied as non-NULL, only 
   * consider the sublist starting at <code>start</code>, however, the returned position 
   * will always be relative to the entire list.
   * @param renamed_Object
   * @param start
   * @return int
   */
  public int position(Stella_Object renamed_Object, int start) {
    { List self = this;

      return (self.theConsList.position(renamed_Object, start));
    }
  }

  public int length() {
    { List self = this;

      return (self.theConsList.length());
    }
  }

  public Stella_Object nthSetter(Stella_Object value, int position) {
    { List self = this;

      return (self.theConsList.nthSetter(value, position));
    }
  }

  public Stella_Object fifthSetter(Stella_Object value) {
    { List self = this;

      return (self.theConsList.fifthSetter(value));
    }
  }

  public Stella_Object fourthSetter(Stella_Object value) {
    { List self = this;

      return (self.theConsList.fourthSetter(value));
    }
  }

  public Stella_Object thirdSetter(Stella_Object value) {
    { List self = this;

      return (self.theConsList.thirdSetter(value));
    }
  }

  public Stella_Object secondSetter(Stella_Object value) {
    { List self = this;

      return (self.theConsList.secondSetter(value));
    }
  }

  public Stella_Object firstSetter(Stella_Object value) {
    { List self = this;

      return (self.theConsList.firstSetter(value));
    }
  }

  /** Return a cons list of all but the first item in the list <code>self</code>.
   * @return Cons
   */
  public Cons rest() {
    { List self = this;

      return (self.theConsList.rest);
    }
  }

  /** Return the last element of <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object last() {
    { List self = this;

      return (self.theConsList.last());
    }
  }

  /** Return the nth item in the list <code>self</code>, or NULL if empty.
   * @param position
   * @return Stella_Object
   */
  public Stella_Object nth(int position) {
    { List self = this;

      return (self.theConsList.nth(position));
    }
  }

  /** Return the fifth item in the list <code>self</code>, or NULL if empty.
   * @return Stella_Object
   */
  public Stella_Object fifth() {
    { List self = this;

      return (self.theConsList.fifth());
    }
  }

  /** Return the fourth item in the list <code>self</code>, or NULL if empty.
   * @return Stella_Object
   */
  public Stella_Object fourth() {
    { List self = this;

      return (self.theConsList.fourth());
    }
  }

  /** Return the third item in the list <code>self</code>, or NULL if empty.
   * @return Stella_Object
   */
  public Stella_Object third() {
    { List self = this;

      return (self.theConsList.rest.rest.value);
    }
  }

  /** Return the second item in the list <code>self</code>, or NULL if empty.
   * @return Stella_Object
   */
  public Stella_Object second() {
    { List self = this;

      return (self.theConsList.rest.value);
    }
  }

  /** Return the first item in the list <code>self</code>, or NULL if empty.
   * @return Stella_Object
   */
  public Stella_Object first() {
    { List self = this;

      { Cons cons = self.theConsList;

        return (((!(cons == Stella.NIL)) ? cons.value : null));
      }
    }
  }

  /** Return TRUE iff <code>renamed_Object</code> is a member of the cons list
   * <code>self</code> (uses an 'eq?' test).
   * @param renamed_Object
   * @return boolean
   */
  public boolean membP(Stella_Object renamed_Object) {
    { List self = this;

      { Stella_Object i = null;
        Cons iter000 = self.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = iter000.value;
          if (i == renamed_Object) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  /** Return TRUE iff <code>renamed_Object</code> is a member of the list
   * <code>self</code> (uses an <code>eqlP</code> test).
   * @param renamed_Object
   * @return boolean
   */
  public boolean memberP(Stella_Object renamed_Object) {
    { List self = this;

      { Stella_Object i = null;
        Cons iter000 = self.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = iter000.value;
          if (Stella_Object.eqlP(i, renamed_Object)) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  public static boolean terminateListP(List self) {
    if (self == Stella.NIL_LIST) {
      if (!(!(self == Stella.NIL_LIST))) {
        System.err.print("Safety violation: Attempt to free NIL-LIST.");
      }
      return (false);
    }
    { Cons cons = self.theConsList;
      Cons rest = null;

      while (!(cons == Stella.NIL)) {
        rest = cons.rest;
        cons.free();
        cons = rest;
      }
      self.theConsList = Stella.NIL;
      return (true);
    }
  }

  /** Return TRUE if the list <code>self</code> has at least one member.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { List self = this;

      return (!(self.theConsList == Stella.NIL));
    }
  }

  /** Return TRUE if the list <code>self</code> has no members.
   * @return boolean
   */
  public boolean emptyP() {
    { List self = this;

      return (self.theConsList == Stella.NIL);
    }
  }

  /** Return TRUE iff <code>self</code> is NULL or the <code>NIL_LIST</code>.
   * @param self
   * @return boolean
   */
  public static boolean nullListP(List self) {
    return ((self == Stella.NIL_LIST) ||
        (self == null));
  }

  /** Return TRUE unless <code>self</code> is NULL or the <code>NIL_LIST</code>.
   * @param self
   * @return boolean
   */
  public static boolean definedListP(List self) {
    return ((!(self == Stella.NIL_LIST)) &&
        (self != null));
  }

  /** Return a list of elements in <code>self</code>.
   * @return Cons
   */
  public Cons consify() {
    { List self = this;

      return (self.theConsList);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { List self = this;

      {
        stream.print("|l|");
        Cons.printCons(self.theConsList, stream, "(", ")");
      }
    }
  }

  public static Stella_Object accessListSlotValue(List self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_THE_CONS_LIST) {
      if (setvalueP) {
        self.theConsList = ((Cons)(value));
      }
      else {
        value = self.theConsList;
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + slotname + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    return (value);
  }

  public Surrogate primaryType() {
    { List self = this;

      return (Stella.SGT_STELLA_LIST);
    }
  }

}

