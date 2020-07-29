//  -*- Mode: Java -*-
//
// Context.java

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

public abstract class Context extends Thing {
    public List childContexts;
    public Module baseModule;
    public Cons allSuperContexts;
    public int contextNumber;

  /** Helper method for <code>printOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Context top = this;

      if (namedP) {
        return;
      }
      Stella.indentOutline(currentDepth, stream);
      stream.nativeStream.println(top.toString());
      if (!((depth != Stella.NULL_INTEGER) &&
          ((depth >= 0) &&
           (currentDepth >= depth)))) {
        currentDepth = currentDepth + 1;
        { Context c = null;
          Cons iter000 = top.childContexts.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            c = ((Context)(iter000.value));
            c.helpPrintOutline(stream, currentDepth, depth, namedP);
          }
        }
      }
    }
  }

  public static void printContextTree(Context root) {
    if (root == null) {
      root = Stella.$ROOT_MODULE$;
    }
    { List toplist = List.list(Cons.cons(root, Stella.NIL));

      List.helpPrintContextTree(toplist, 0);
      toplist.free();
    }
  }

  public static void printContext(Context self, edu.isi.stella.javalib.NativeOutputStream stream) {
    { String typestring = null;
      String name = null;
      int number = self.contextNumber;

      if (!Stella.$CLASS_HIERARCHY_BOOTEDp$) {
        stream.print("|MDL|" + ((Module)(self)).moduleName);
        return;
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MODULE)) {
          { Module self000 = ((Module)(self));

            name = self000.moduleFullName;
            if ((((self000.contextNumber) % 2) == 1)) {
              typestring = "|DeLeTeD MDL|";
            }
            else {
              typestring = "|MDL|";
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_WORLD)) {
          { World self000 = ((World)(self));

            name = ((StringWrapper)(KeyValueList.dynamicSlotValue(self000.dynamicSlots, Stella.SYM_STELLA_WORLD_NAME, Stella.NULL_STRING_WRAPPER))).wrapperValue;
            if ((((self000.contextNumber) % 2) == 1)) {
              typestring = "|DeLeTeD WLD|";
            }
            else {
              typestring = "|WLD|";
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
      if ((((self.contextNumber) % 2) == 1)) {
        number = number + 1;
      }
      if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
        if (name != null) {
          stream.print(name);
        }
        else {
          stream.print("#<" + typestring + number + ">");
        }
      }
      else {
        if (name != null) {
          stream.print(typestring + name);
        }
        else {
          stream.print(typestring + number);
        }
      }
    }
  }

  public static Context changeContextSlowly(Context self) {
    if (self != null) {
      return (self.changeContext());
    }
    else {
      return (((Context)(Stella.$CONTEXT$.get())));
    }
  }

  public boolean deletedP() {
    { Context context = this;

      return ((((context.contextNumber) % 2) == 1));
    }
  }

  public static boolean discardedContextP(Context context) {
    return ((((context.contextNumber) % 2) == 1));
  }

  public static boolean subcontextP(Context subcontext, Context supercontext) {
    return ((subcontext == supercontext) ||
        subcontext.allSuperContexts.membP(supercontext));
  }

  /** Destroy all objects belonging to 'self' or any of its subcontexts.
   * @param self
   */
  public static void clearContext(Context self) {
    Context.helpClearContext(self);
    Stella.finalizeClassesAndSlots();
  }

  public static void helpClearContext(Context self) {
    { Context child = null;
      Cons iter000 = self.childContexts.theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        child = ((Context)(iter000.value));
        Context.helpClearContext(child);
      }
    }
    Context.clearOneContext(self);
  }

  public static void clearOneContext(Context self) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Stella.SGT_STELLA_MODULE)) {
      { Module self000 = ((Module)(self));

        if (!self000.clearableP()) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Module `" + self000.moduleFullName + "' cannot be cleared!");
          return;
        }
        HookList.runHooks(Stella.$CLEAR_MODULE_HOOKS$, self000);
        { MethodSlot function = null;
          Iterator iter000 = Module.allFunctions(self000, true);

          while (iter000.nextP()) {
            function = ((MethodSlot)(iter000.value));
            MethodSlot.destroyFunction(function);
          }
        }
        { GlobalVariable variable = null;
          Iterator iter001 = Module.allVariables(self000, true);

          while (iter001.nextP()) {
            variable = ((GlobalVariable)(iter001.value));
            GlobalVariable.destroyVariable(variable);
          }
        }
        { Stella_Class renamed_Class = null;
          Iterator iter002 = Module.allClasses(self000, true);

          while (iter002.nextP()) {
            renamed_Class = ((Stella_Class)(iter002.value));
            renamed_Class.destroyClass();
          }
        }
        { Surrogate surrogate = null;
          Iterator iter003 = Module.allSurrogates(self000, true);

          while (iter003.nextP()) {
            surrogate = ((Surrogate)(iter003.value));
            if (self000.protectSurrogatesP()) {
              surrogate.surrogateValue = null;
            }
            else {
              Surrogate.uninternSurrogate(surrogate);
            }
          }
        }
        if (!(self000.protectSurrogatesP())) {
          { Symbol symbol = null;
            Iterator iter004 = Module.allSymbols(self000, true);

            while (iter004.nextP()) {
              symbol = ((Symbol)(iter004.value));
              Symbol.uninternSymbol(symbol);
            }
          }
        }
        { Object old$Module$000 = Stella.$MODULE$.get();

          try {
            Native.setSpecial(Stella.$MODULE$, self000);
            { ListIterator it = ((ListIterator)(self000.shadowedSurrogates().allocateIterator()));

              while (it.nextP()) {
                it.valueSetter(Stella.shadowSurrogate(((Surrogate)(it.value)).symbolName));
              }
            }

          } finally {
            Stella.$MODULE$.set(old$Module$000);
          }
        }
        Keyword.bumpMemoizationTimestamp(Stella.KWD_MODULE_UPDATE);
      }
    }
    else {
    }
  }

  public static boolean visibleFromP(Context viewedcontext, Context fromcontext) {
    { boolean testValue000 = false;

      if (viewedcontext == fromcontext) {
        testValue000 = true;
      }
      else {
        if (fromcontext.allSuperContexts.membP(viewedcontext)) {
          testValue000 = true;
        }
        else {
          { boolean foundP000 = false;

            { Module usesmodule = null;
              Cons iter000 = (Stella_Object.isaP(fromcontext, Stella.SGT_STELLA_MODULE) ? ((Module)(fromcontext)).uses : fromcontext.baseModule.uses).theConsList;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                usesmodule = ((Module)(iter000.value));
                if ((viewedcontext == usesmodule) ||
                    usesmodule.allSuperContexts.membP(viewedcontext)) {
                  foundP000 = true;
                  break loop000;
                }
              }
            }
            testValue000 = foundP000;
          }
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** Return an iterator that generates all subcontexts of
   * 'self' (not including 'self') in the order specified by 'traversal' (one
   * of :preorder, :inorder, :postorder or :topdown).
   * @param context
   * @param traversal
   * @return AllPurposeIterator
   */
  public static AllPurposeIterator allSubcontexts(Context context, Keyword traversal) {
    { AllPurposeIterator contextsiterator = AllPurposeIterator.newAllPurposeIterator();
      Cons subcontexts = Stella.NIL;

      { Context child = null;
        Cons iter000 = context.childContexts.theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((Context)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(child, Stella.NIL);
              if (subcontexts == Stella.NIL) {
                subcontexts = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(subcontexts, collect000);
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
      if (traversal == Stella.KWD_POSTORDER) {
        subcontexts = subcontexts.reverse();
      }
      contextsiterator.iteratorConsList = subcontexts;
      if (traversal == Stella.KWD_TOPDOWN) {
        {
          contextsiterator.iteratorObject = context;
          contextsiterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allTopdownSubcontextsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        }
      }
      else {
        {
          contextsiterator.iteratorObject = traversal;
          contextsiterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSubcontextsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        }
      }
      return (contextsiterator);
    }
  }

  /** Create a new world below the world or module 'parentContext'.
   * Optionally, specify a name.
   * @param parentcontext
   * @param name
   * @return World
   */
  public static World createWorld(Context parentcontext, String name) {
    { World world = World.newWorld();

      if (name != null) {
        KeyValueList.setDynamicSlotValue(world.dynamicSlots, Stella.SYM_STELLA_WORLD_NAME, StringWrapper.wrapString(name), Stella.NULL_STRING_WRAPPER);
        { boolean foundP000 = false;

          { Context sibling = null;
            Cons iter000 = parentcontext.childContexts.theConsList;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sibling = ((Context)(iter000.value));
              if (Stella.stringEqlP(sibling.contextName(), name)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          if (foundP000) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't create a world named `" + name + "' because a sibling already has that name.");
            return (null);
          }
        }
      }
      world.parentContext = parentcontext;
      parentcontext.childContexts.insert(world);
      world.baseModule = parentcontext.baseModule;
      World.finalizeWorld(world);
      return (world);
    }
  }

  /** Make the translator happy.
   */
  public void destroyContext() {
    { Context self = this;

    }
  }

  public void uninheritSupercontexts() {
    { Context context = this;

      context.allSuperContexts = Stella.NIL;
    }
  }

  public void inheritSupercontexts() {
    { Context context = this;

    }
  }

  public boolean multipleParentsP() {
    { Context self = this;

      return (false);
    }
  }

  /** Change the current context to be the context
   * 'context'.
   * @return Context
   */
  public Context changeContext() {
    { Context context = this;

      if (context == ((Context)(Stella.$CONTEXT$.get()))) {
        return (context);
      }
      else {
        return (Context.changeCurrentContext(context));
      }
    }
  }

  public static Context changeCurrentContext(Context context) {
    if (!(context.baseModule == ((Module)(Stella.$MODULE$.get())))) {
      Module.changeCurrentModule(context.baseModule);
    }
    Native.setSpecial(Stella.$CONTEXT$, context);
    return (context);
  }

  public Iterator parentContexts() {
    { Context self = this;

      return (null);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Context self = this;

      Context.printContext(self, stream);
    }
  }

  public static Stella_Object accessContextSlotValue(Context self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_CHILD_CONTEXTS) {
      if (setvalueP) {
        self.childContexts = ((List)(value));
      }
      else {
        value = self.childContexts;
      }
    }
    else if (slotname == Stella.SYM_STELLA_BASE_MODULE) {
      if (setvalueP) {
        self.baseModule = ((Module)(value));
      }
      else {
        value = self.baseModule;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ALL_SUPER_CONTEXTS) {
      if (setvalueP) {
        self.allSuperContexts = ((Cons)(value));
      }
      else {
        value = self.allSuperContexts;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CONTEXT_NUMBER) {
      if (setvalueP) {
        self.contextNumber = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.contextNumber);
      }
    }
    else {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, slotname, value, null);
      }
      else {
        value = self.dynamicSlots.lookup(slotname);
      }
    }
    return (value);
  }

  public Module homeModule() {
    { Context self = this;

      return (self.baseModule);
    }
  }

  public String contextName() {
    { Context self = this;

      { Context aux = self;

        { Surrogate testValue000 = Stella_Object.safePrimaryType(aux);

          if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MODULE)) {
            { Module aux000 = ((Module)(aux));

              return (aux000.moduleName);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_WORLD)) {
            { World aux000 = ((World)(aux));

              return (((StringWrapper)(KeyValueList.dynamicSlotValue(aux000.dynamicSlots, Stella.SYM_STELLA_WORLD_NAME, Stella.NULL_STRING_WRAPPER))).wrapperValue);
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

}

