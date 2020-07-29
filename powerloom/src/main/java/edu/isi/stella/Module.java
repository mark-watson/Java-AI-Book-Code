//  -*- Mode: Java -*-
//
// Module.java

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

public class Module extends Context {
    public List parentModules;
    public String documentation;
    public List nicknames;
    public List uses;
    public List usedBy;
    public List requires;
    public boolean caseSensitiveP;
    public String moduleFullName;
    public String moduleName;
    public String moduleStringifiedSource;
    public String stringifiedOptions;
    public Module cardinalModule;
    public StringToIntegerHashTable symbolOffsetTable;
    public StringToIntegerHashTable surrogateOffsetTable;
    public World strictInferenceCache;
    public World defaultInferenceCache;
    public World prototypeInferenceCache;

  public static Module defineModuleFromStringifiedSource(String name, String stringifiedoptions) {
    return (Module.defineModule(name, ((Cons)(Stella.readSExpressionFromString(stringifiedoptions)))));
  }

  /** Define or redefine a module named 'name' having the
   * options 'options'.  Return the new module.
   * @param name
   * @param options
   * @return Module
   */
  public static Module defineModule(String name, Cons options) {
    { Object old$Shadowedsurrogates$000 = Stella.$SHADOWEDSURROGATES$.get();

      try {
        Native.setSpecial(Stella.$SHADOWEDSURROGATES$, Stella.NIL);
        { Module module = null;
          String stringifiedoptions = Native.stringify(options);
          Module oldmodule = null;

          oldmodule = Stella.getStellaModule(name, false);
          if ((oldmodule != null) &&
              Module.identicalModuleStructureP(oldmodule, null, stringifiedoptions)) {
            Module.updateNonStructuralModuleOptions(oldmodule, null, stringifiedoptions);
            return (oldmodule);
          }
          module = Module.newModule();
          module.stringifiedOptions = stringifiedoptions;
          Module.incorporateModuleOptions(module, options);
          Module.incorporateModuleName(module, name);
          module.baseModule = module;
          if (oldmodule != null) {
            if (Module.identicalModuleStructureP(oldmodule, module, null)) {
              Module.updateNonStructuralModuleOptions(oldmodule, module, null);
              module.unfinalizeModule();
              return (oldmodule);
            }
            if (oldmodule == ((Module)(Stella.$MODULE$.get()))) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't define a module inside of itself.");
              Stella.STANDARD_OUTPUT.nativeStream.println("Skipping redefinition of module " + name + ".");
              module.unfinalizeModule();
              return (oldmodule);
            }
            Module.undefineModule(oldmodule, module);
          }
          Module.finalizeModule(module);
          if (oldmodule != null) {
            { Context c = null;
              AllPurposeIterator iter000 = Context.allSubcontexts(module, Stella.KWD_TOPDOWN);

              while (iter000.nextP()) {
                c = ((Context)(iter000.value));
                { Surrogate testValue000 = Stella_Object.safePrimaryType(c);

                  if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MODULE)) {
                    { Module c000 = ((Module)(c));

                      if (c000.uses.emptyP()) {
                        c000.uses = List.list(Cons.cons(c000, Stella.NIL));
                      }
                      Module.finalizeModule(c000);
                    }
                  }
                  else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_WORLD)) {
                    { World c000 = ((World)(c));

                      World.finalizeWorld(c000);
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
          Keyword.bumpMemoizationTimestamp(Stella.KWD_MODULE_UPDATE);
          HookList.runHooks(Stella.$DEFINE_MODULE_HOOKS$, module);
          return (module);
        }

      } finally {
        Stella.$SHADOWEDSURROGATES$.set(old$Shadowedsurrogates$000);
      }
    }
  }

  public static Module newModule() {
    { Module self = null;

      self = new Module();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.contextNumber = Stella.NULL_INTEGER;
      self.allSuperContexts = null;
      self.baseModule = null;
      self.childContexts = List.newList();
      self.prototypeInferenceCache = null;
      self.defaultInferenceCache = null;
      self.strictInferenceCache = null;
      self.surrogateOffsetTable = null;
      self.symbolOffsetTable = null;
      self.cardinalModule = null;
      self.stringifiedOptions = null;
      self.moduleStringifiedSource = null;
      self.moduleName = null;
      self.moduleFullName = null;
      self.caseSensitiveP = false;
      self.requires = null;
      self.usedBy = List.newList();
      self.uses = List.newList();
      self.nicknames = null;
      self.documentation = null;
      self.parentModules = List.newList();
      return (self);
    }
  }

  /** Helper method for <code>printOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Module top = this;

      Stella.indentOutline(currentDepth, stream);
      stream.nativeStream.println(top.name());
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

  public static String javaPackagePrefix(Module module, String separator) {
    { String result = "";
      char separatorChar = separator.charAt(0);
      String packagePrefix = module.javaPackage();

      if (packagePrefix != null) {
        if (separatorChar == '.') {
          result = packagePrefix;
        }
        else {
          result = Native.string_substitute(packagePrefix, separatorChar, '.');
        }
        return (result + separator);
      }
      result = Stella.javaTranslateNamestring(Native.stringDowncase(module.name())) + separator;
      { Context mod = null;
        Iterator iter000 = module.parentContexts();

        loop000 : while (iter000.nextP()) {
          mod = ((Context)(iter000.value));
          if (Stella_Object.isaP(mod, Stella.SGT_STELLA_MODULE) &&
              (!(mod == Stella.$ROOT_MODULE$))) {
            result = Module.javaPackagePrefix(((Module)(mod)), separator) + result;
            break loop000;
          }
        }
      }
      if (separatorChar == '.') {
        KeyValueList.setDynamicSlotValue(module.dynamicSlots, Stella.SYM_STELLA_JAVA_PACKAGE, StringWrapper.wrapString(Native.string_subsequence(result, 0, result.length() - 1)), Stella.NULL_STRING_WRAPPER);
      }
      return (result);
    }
  }

  public static boolean omitJavaPackagePrefixP(Module module, String stellaClassName) {
    if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_MINIMIZE_JAVA_PREFIXES)) {
      return (Module.inCurrentJavaPackageP(module) ||
          ((((Module)(Stella.$MODULE$.get())).uses.membP(module) ||
          ((Module)(Stella.$MODULE$.get())).allSuperContexts.membP(module)) &&
           (!Stella.inheritedClassNameConflictsP(stellaClassName))));
    }
    else {
      return (Module.inCurrentJavaPackageP(module));
    }
  }

  public static boolean inCurrentJavaPackageP(Module module) {
    return ((module == ((Module)(Stella.$MODULE$.get()))) ||
        Stella.stringEqlP(Module.javaPackagePrefix(module, "."), Module.javaPackagePrefix(((Module)(Stella.$MODULE$.get())), ".")));
  }

  public static String javaYieldFlotsamClassName(Module mod) {
    { String flotsamclassname = ((StringWrapper)(KeyValueList.dynamicSlotValue(mod.dynamicSlots, Stella.SYM_STELLA_JAVA_FLOTSAM_CLASS, Stella.NULL_STRING_WRAPPER))).wrapperValue;

      if ((flotsamclassname != null) &&
          (!(flotsamclassname == ""))) {
        return (flotsamclassname);
      }
      else {
        {
          flotsamclassname = StringWrapper.javaTranslateClassNamestring(StringWrapper.wrapString(mod.name())).wrapperValue;
          KeyValueList.setDynamicSlotValue(mod.dynamicSlots, Stella.SYM_STELLA_JAVA_FLOTSAM_CLASS, StringWrapper.wrapString(flotsamclassname), Stella.NULL_STRING_WRAPPER);
          return (flotsamclassname);
        }
      }
    }
  }

  public static String javaMakeGlobalOutputFileName(Module module, boolean donttruncateP) {
    return (Stella.string_javaMakeCodeOutputFileName(Module.javaYieldFlotsamClassName(module), donttruncateP));
  }

  public static String cppYieldNamespacePrefixFromModule(Module module) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    { String packageprefix = module.cppPackage();
      boolean packageprefixinheritedP = ((StringWrapper)(KeyValueList.dynamicSlotValue(module.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue == null;

      if (packageprefixinheritedP) {
        { String relativemodulepath = module.moduleFullName;

          return (packageprefix + Stella.cppSubstituteForbiddenCharacters(Native.string_substitute(Native.stringDowncase(relativemodulepath), '_', '/'), Stella.KWD_LOWERCASE));
        }
      }
      else {
        return (packageprefix);
      }
    }
  }

  public static void cppOutputNamespaceChange(Module fromnamespace, Module tonamespace) {
    if (!((tonamespace == fromnamespace) ||
        ((fromnamespace != null) &&
         Stella.stringEqlP(Module.cppYieldNamespacePrefixFromModule(fromnamespace), Module.cppYieldNamespacePrefixFromModule(tonamespace))))) {
      if (!(fromnamespace == null)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        Module.cppOutputNamespaceFooter(fromnamespace);
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("");
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        }
;
      }
      Module.cppOutputNamespaceHeader(tonamespace);
    }
  }

  public static void cppOutputNamespaceFooter(Module module) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("} // end of namespace " + Module.cppYieldNamespacePrefixFromModule(module));
  }

  public static void cppOutputNamespaceHeader(Module module) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("namespace " + Module.cppYieldNamespacePrefixFromModule(module) + " {");
    { Module usee = null;
      Cons iter000 = Cons.copyConsList(Module.visibleModules(module).consify().rest).reverse();

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        usee = ((Module)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("  using namespace " + Module.cppYieldNamespacePrefixFromModule(usee) + ";");
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
  }

  public static String xmoduleStringifiedSource(Module self) {
    return ("(defmodule " + self.moduleName + " " + self.stringifiedOptions + ")");
  }

  public void describeObject(OutputStream stream, Keyword mode) {
    { Module self = this;

      if (mode == Stella.KWD_SOURCE) {
        Cons.prettyPrintStellaTree(((Cons)(Stella.readSExpressionFromString(Module.xmoduleStringifiedSource(self)))), stream);
      }
      else if (mode == Stella.KWD_TERSE) {
        Stella_Object.describeTersely(self, stream);
      }
      else if (mode == Stella.KWD_VERBOSE) {
        Cons.prettyPrintDefinitionTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFMODULE, Cons.cons(StringWrapper.wrapString(self.moduleName), Cons.cons(Cons.list$(Cons.cons(Stella.KWD_INCLUDES, Cons.cons(self.parentModules, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_USES, Cons.cons(self.uses, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_SHADOWS, Cons.cons(self.shadowedSurrogates(), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_gg_INFERRED_SLOTS, Cons.cons(Stella.KWD_CHILDREN, Cons.cons(self.childContexts, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_USED_BY, Cons.cons(self.usedBy, Cons.cons(Cons.list$(Cons.cons(Stella.KWD_CARDINAL_MODULE, Cons.cons(self.cardinalModule, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL))))), Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), Stella.NIL)))), stream);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + mode + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public void printDefinition(OutputStream stream) {
    { Module self = this;

      { Cons options = ((Cons)(Stella.readSExpressionFromString(self.stringifiedOptions)));

        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            stream.nativeStream.print("(DEFMODULE \"" + self.moduleFullName + "\"");
            while (!(options == Stella.NIL)) {
              {
                stream.nativeStream.println();
                stream.nativeStream.print("  " + options.value + " " + options.rest.value);
              }
;
              options = options.nthRest(2);
            }
            stream.nativeStream.println(")");

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static boolean cardinalModuleP(Module self) {
    return (self.cardinalModule == self);
  }

  public static Cons helpMemoizeVisibleModules(Module from) {
    { Cons visiblemodules = Stella.NIL;

      visiblemodules = Cons.cons(from, visiblemodules);
      { Context renamed_Super = null;
        Cons iter000 = from.allSuperContexts;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          renamed_Super = ((Context)(iter000.value));
          visiblemodules = Cons.cons(renamed_Super, visiblemodules);
        }
      }
      { Module usee = null;
        Cons iter001 = from.uses.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          usee = ((Module)(iter001.value));
          if (!visiblemodules.membP(usee)) {
            visiblemodules = Cons.cons(usee, visiblemodules);
          }
          { Context useesuper = null;
            Cons iter002 = usee.allSuperContexts;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              useesuper = ((Context)(iter002.value));
              if (!visiblemodules.membP(useesuper)) {
                visiblemodules = Cons.cons(useesuper, visiblemodules);
              }
            }
          }
        }
      }
      return (visiblemodules.reverse());
    }
  }

  /** Return a list of all modules visible from module <code>from</code> (or <code>$MODULE$</code>
   * if <code>from</code> is NULL.  The generated modules are generated from most to
   * least-specific and will start with the module <code>from</code>.
   * @param from
   * @return Cons
   */
  public static Cons visibleModules(Module from) {
    if (from == null) {
      from = ((Module)(Stella.$MODULE$.get()));
    }
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_VISIBLE_MODULES_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Stella.SGT_STELLA_F_VISIBLE_MODULES_MEMO_TABLE_000, "(:MAX-VALUES 50 :TIMESTAMPS (:MODULE-UPDATE))");
          memoTable000 = ((MemoizationTable)(Stella.SGT_STELLA_F_VISIBLE_MODULES_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), from, Stella.MEMOIZED_NULL_VALUE, null, null, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = Module.helpMemoizeVisibleModules(from);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Cons value000 = ((Cons)(memoizedValue000));

        return (value000);
      }
    }
  }

  /** Generate a sequence of all modules included
   * by 'self', inclusive, starting from the highest ancestor and working
   * down to 'self' (which is last).
   * @param self
   * @return Iterator
   */
  public static Iterator allIncludedModules(Module self) {
    { Cons copy = Cons.copyConsList(((Cons)(self.allSuperContexts)));

      copy = Cons.cons(self, copy);
      return (copy.reverse().allocateDestructiveListIterator());
    }
  }

  public static Cons yieldDefineModule(Module module) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINE_MODULE_FROM_STRINGIFIED_SOURCE, Cons.cons(StringWrapper.wrapString(module.moduleFullName), Cons.cons(Cons.cons(Stella.yieldStringConstantTree(module.stringifiedOptions), Stella.NIL), Stella.NIL)))));
  }

  public static boolean identicalModuleStructureP(Module oldmodule, Module newmodule, String newoptions) {
    if ((newmodule != null) &&
        (!Stella.stringEqlP(oldmodule.moduleFullName, newmodule.moduleFullName))) {
      return (false);
    }
    { String oldoptions = oldmodule.stringifiedOptions;

      newoptions = ((newmodule == null) ? newoptions : newmodule.stringifiedOptions);
      if (newoptions == null) {
        return (false);
      }
      if (Stella.eqlExceptInWhitespaceP(oldoptions, newoptions)) {
        return (true);
      }
      if ((Native.stringSearch(oldoptions, ":INCLUDES", 0) == Stella.NULL_INTEGER) &&
          (Native.stringSearch(newoptions, ":INCLUDES", 0) == Stella.NULL_INTEGER)) {
        return (false);
      }
      if ((newmodule != null) &&
          Stella_Object.equalConsTreesP(oldmodule.parentModules.theConsList, newmodule.parentModules.theConsList)) {
        { PropertyList self000 = PropertyList.newPropertyList();

          self000.thePlist = ((Cons)(Stella.readSExpressionFromString(oldoptions)));
          { PropertyList oldplist = self000;

            { PropertyList self001 = PropertyList.newPropertyList();

              self001.thePlist = ((Cons)(Stella.readSExpressionFromString(newoptions)));
              { PropertyList newplist = self001;

                oldplist.removeAt(Stella.KWD_INCLUDES);
                newplist.removeAt(Stella.KWD_INCLUDES);
                { Stella_Object key = null;
                  Stella_Object value = null;
                  Cons iter000 = oldplist.thePlist;

                  for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
                    key = iter000.value;
                    value = iter000.rest.value;
                    if (!Stella.$MODULE_NON_STRUCTURAL_OPTIONS$.memberP(key)) {
                      if (!(Stella_Object.equalConsTreesP(value, newplist.lookup(key)))) {
                        return (false);
                      }
                    }
                  }
                }
                { Stella_Object key = null;
                  Stella_Object value = null;
                  Cons iter001 = newplist.thePlist;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
                    key = iter001.value;
                    value = iter001.rest.value;
                    if (!Stella.$MODULE_NON_STRUCTURAL_OPTIONS$.memberP(key)) {
                      if (!(Stella_Object.equalConsTreesP(value, oldplist.lookup(key)))) {
                        return (false);
                      }
                    }
                  }
                }
                return (true);
              }
            }
          }
        }
      }
      return (false);
    }
  }

  public static void updateNonStructuralModuleOptions(Module oldmodule, Module newmodule, String newoptions) {
    if (newoptions == null) {
      newoptions = newmodule.stringifiedOptions;
    }
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = ((Cons)(Stella.readSExpressionFromString(oldmodule.stringifiedOptions)));
      { PropertyList oldplist = self000;

        { PropertyList self001 = PropertyList.newPropertyList();

          self001.thePlist = ((Cons)(Stella.readSExpressionFromString(newoptions)));
          { PropertyList newplist = self001;
            Stella_Object oldvalue = null;
            Stella_Object newvalue = null;
            Cons changedValues = Stella.NIL;

            { Keyword option = null;
              Cons iter000 = Stella.$MODULE_NON_STRUCTURAL_OPTIONS$;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                option = ((Keyword)(iter000.value));
                oldvalue = oldplist.lookup(option);
                newvalue = newplist.lookup(option);
                if (!(Stella_Object.eqlP(oldvalue, newvalue))) {
                  if (newvalue != null) {
                    changedValues = Cons.cons(newvalue, changedValues);
                  }
                  else {
                    {
                      if (newmodule == null) {
                        newmodule = Module.newModule();
                      }
                      changedValues = Cons.cons(StandardObject.readSlotValue(newmodule, Surrogate.lookupSlotFromOptionKeyword(newmodule.primaryType(), option)), changedValues);
                    }
                  }
                  changedValues = Cons.cons(option, changedValues);
                }
              }
            }
            if (!(changedValues == Stella.NIL)) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Updating module `" + oldmodule + "'");
              Module.incorporateModuleOptions(oldmodule, changedValues);
              oldmodule.stringifiedOptions = newoptions;
            }
          }
        }
      }
    }
  }

  public static void undefineModule(Module oldmodule, Module newmodule) {
    Stella.STANDARD_OUTPUT.nativeStream.println("Redefining the module `" + oldmodule.contextName() + "'");
    if (Stella.$SUBCONTEXT_REVISION_POLICY$ == Stella.KWD_DESTROY) {
      oldmodule.destroyContext();
      return;
    }
    else if (Stella.$SUBCONTEXT_REVISION_POLICY$ == Stella.KWD_PRESERVE) {
    }
    else if (Stella.$SUBCONTEXT_REVISION_POLICY$ == Stella.KWD_CLEAR) {
      { Context c = null;
        AllPurposeIterator iter000 = Context.allSubcontexts(oldmodule, Stella.KWD_PREORDER);

        while (iter000.nextP()) {
          c = ((Context)(iter000.value));
          Context.clearContext(c);
        }
      }
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + Stella.$SUBCONTEXT_REVISION_POLICY$ + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    if (Module.cardinalModuleP(oldmodule)) {
      Stella.$ROOT_MODULE$.childContexts.remove(oldmodule);
    }
    else {
      { Module p = null;
        Cons iter001 = oldmodule.parentModules.theConsList;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          p = ((Module)(iter001.value));
          p.childContexts.remove(oldmodule);
        }
      }
    }
    { Context c = null;
      Cons iter002 = oldmodule.childContexts.theConsList;

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        c = ((Context)(iter002.value));
        { Surrogate testValue000 = Stella_Object.safePrimaryType(c);

          if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MODULE)) {
            { Module c000 = ((Module)(c));

              c000.parentModules.theConsList.substitute(newmodule, oldmodule);
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_WORLD)) {
            { World c000 = ((World)(c));

              c000.parentContext = newmodule;
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
    newmodule.childContexts.theConsList = oldmodule.childContexts.theConsList;
    oldmodule.childContexts.theConsList = Stella.NIL;
    oldmodule.surrogateValueInverse = null;
    oldmodule.unfinalizeModule();
    oldmodule.free();
  }

  public static void incorporateModuleOptions(Module self, Cons options) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList plist = Stella_Object.vetOptions(self000, Stella.getQuotedTree("((:NICKNAME :INCLUDES :USES :DOCUMENTATION :SHADOW :CASE-SENSITIVE? :LISP-PACKAGE :CPP-PACKAGE :JAVA-PACKAGE :JAVA-CATCHALL-CLASS :API? :CLEARABLE? :PROTECT-SURROGATES? :CODE-ONLY? :NAMESPACE?) \"/STELLA\")", "/STELLA"));

        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = plist.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            { Keyword testValue000 = ((Keyword)(key));

              if (testValue000 == Stella.KWD_INCLUDES) {
                Module.incorporateIncludesModules(self, value);
              }
              else if (testValue000 == Stella.KWD_USES) {
                Module.incorporateUsesModules(self, value);
              }
              else if (testValue000 == Stella.KWD_SHADOW) {
                Native.setSpecial(Stella.$SHADOWEDSURROGATES$, ((Cons)(value)));
              }
              else {
                value = Stella_Object.permanentCopy(value);
                { Keyword testValue001 = ((Keyword)(key));

                  if (testValue001 == Stella.KWD_DOCUMENTATION) {
                    self.documentation = StringWrapper.unwrapString(((StringWrapper)(value)));
                  }
                  else if (testValue001 == Stella.KWD_CASE_SENSITIVEp) {
                    self.caseSensitiveP = (value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")));
                  }
                  else if (testValue001 == Stella.KWD_APIp) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_APIp, (((value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_LISP_PACKAGE) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, StringWrapper.wrapString(StringWrapper.unwrapString(((StringWrapper)(value)))), Stella.NULL_STRING_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_CPP_PACKAGE) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, StringWrapper.wrapString(StringWrapper.unwrapString(((StringWrapper)(value)))), Stella.NULL_STRING_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_JAVA_PACKAGE) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_JAVA_PACKAGE, StringWrapper.wrapString(StringWrapper.unwrapString(((StringWrapper)(value)))), Stella.NULL_STRING_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_JAVA_CATCHALL_CLASS) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_JAVA_FLOTSAM_CLASS, StringWrapper.wrapString(StringWrapper.unwrapString(((StringWrapper)(value)))), Stella.NULL_STRING_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_NICKNAME) {
                    if (self.nicknames == null) {
                      self.nicknames = List.newList();
                    }
                    self.nicknames.insert(((StringWrapper)(value)));
                  }
                  else if (testValue001 == Stella.KWD_CLEARABLEp) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, (((value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_PROTECT_SURROGATESp) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROTECT_SURROGATESp, (((value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_CODE_ONLYp) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CODE_ONLYp, (((value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_NAMESPACEp) {
                    KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_NAMESPACEp, (((value == Stella.SYM_STELLA_TRUE) ||
                        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
                         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
                          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE")))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
                  }
                  else if (testValue001 == Stella.KWD_REQUIRES) {
                    self.requires = ((List)(value));
                  }
                  else {
                    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                      stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                    }
                  }
                }
              }
            }
          }
        }
        plist.free();
      }
    }
  }

  public static void incorporateUsesModules(Module module, Stella_Object usees) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(usees);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons usees000 = ((Cons)(usees));

          { Stella_Object name = null;
            Cons iter000 = usees000;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              name = iter000.value;
              Module.incorporateUsesModules(module, name);
            }
          }
          if (module.uses.emptyP()) {
            module.uses.insert(module);
          }
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper usees000 = ((StringWrapper)(usees));

          { Module useemodule = Stella_Object.coerceToModule(usees000, true);

            if (useemodule != null) {
              if (!module.uses.memberP(useemodule)) {
                module.uses.insertLast(useemodule);
              }
              useemodule.usedBy.insertNew(module);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol usees000 = ((Symbol)(usees));

          { Module useemodule = Stella_Object.coerceToModule(usees000, true);

            if (useemodule != null) {
              if (!module.uses.memberP(useemodule)) {
                module.uses.insertLast(useemodule);
              }
              useemodule.usedBy.insertNew(module);
            }
          }
        }
      }
      else {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal argument to ':uses' option .");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static void incorporateIncludesModules(Module module, Stella_Object includees) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(includees);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons includees000 = ((Cons)(includees));

          { Stella_Object name = null;
            Cons iter000 = includees000;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              name = iter000.value;
              Module.incorporateIncludesModules(module, name);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper includees000 = ((StringWrapper)(includees));

          { Module includeemodule = Stella_Object.coerceToModule(includees000, true);

            if (includeemodule != null) {
              if (!module.parentModules.memberP(includeemodule)) {
                module.parentModules.insertLast(includeemodule);
              }
              includeemodule.childContexts.insertNew(module);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol includees000 = ((Symbol)(includees));

          { Module includeemodule = Stella_Object.coerceToModule(includees000, true);

            if (includeemodule != null) {
              if (!module.parentModules.memberP(includeemodule)) {
                module.parentModules.insertLast(includeemodule);
              }
              includeemodule.childContexts.insertNew(module);
            }
          }
        }
      }
      else {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal argument to ':includes' option`" + Stella_Object.deUglifyParseTree(includees) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static void incorporateModuleName(Module module, String name) {
    { Module parentmodule = null;
      String barename = null;

      if (Stella.qualifiedStellaNameP(name)) {
        {
          { Object [] caller_MV_returnarray = new Object[1];

            parentmodule = Stella.computeModuleAndBareName(name, caller_MV_returnarray);
            barename = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
          }
          if (parentmodule == null) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Bad path name `" + name + "' when defining the module `" + barename + "'");
            return;
          }
          { boolean testValue000 = false;

            if ((parentmodule == Stella.$ROOT_MODULE$) &&
                module.parentModules.nonEmptyP()) {
              testValue000 = true;
            }
            else {
              { boolean foundP000 = false;

                { Module includedmodule = null;
                  Cons iter000 = module.parentModules.theConsList;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    includedmodule = ((Module)(iter000.value));
                    if ((!(includedmodule == parentmodule)) &&
                        ((includedmodule == parentmodule) ||
                         includedmodule.allSuperContexts.membP(parentmodule))) {
                      foundP000 = true;
                      break loop000;
                    }
                  }
                }
                testValue000 = foundP000;
              }
            }
            if (testValue000) {
              {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Bad path name `" + name + "' when defining the module `" + barename + "',");
                Stella.STANDARD_WARNING.nativeStream.println("   since it points to a parent of an included module.");
              }
;
            }
            else {
              Module.linkToParentModule(module, parentmodule, true);
            }
          }
        }
      }
      else {
        {
          if (module.parentModules.emptyP()) {
            Module.linkToParentModule(module, Stella.$ROOT_MODULE$, true);
          }
          barename = name;
        }
      }
      module.moduleName = barename;
      module.moduleFullName = Stella.computeFullName("", module);
    }
  }

  public static void linkToParentModule(Module self, Module parent, boolean insertFirstP) {
    if ((!(parent == Stella.$ROOT_MODULE$)) &&
        (!self.parentModules.memberP(parent))) {
      if (insertFirstP) {
        self.parentModules.insert(parent);
      }
      else {
        self.parentModules.insertLast(parent);
      }
    }
    parent.childContexts.insertNew(self);
  }

  /** Destroy the context 'self', and recursively destroy
   * all contexts that inherit 'self'.
   */
  public void destroyContext() {
    { Module self = this;

      Module.destroyModule(self);
    }
  }

  public static void helpDestroyModule(Module self) {
    { Context child = null;
      Cons iter000 = self.childContexts.copy().theConsList;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        child = ((Context)(iter000.value));
        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(child), Stella.SGT_STELLA_MODULE)) {
          { Module child000 = ((Module)(child));

            Module.helpDestroyModule(child000);
          }
        }
        else {
          child.destroyContext();
        }
      }
    }
    { Module parentmodule = self.parentModule();

      HookList.runHooks(Stella.$DESTROY_CONTEXT_HOOKS$, self);
      if (parentmodule == null) {
        parentmodule = self.cardinalModule;
      }
      if (parentmodule == null) {
        parentmodule = Stella.$STELLA_MODULE$;
      }
      self.unfinalizeModule();
      Keyword.bumpMemoizationTimestamp(Stella.KWD_MODULE_UPDATE);
      if (self == ((Module)(Stella.$MODULE$.get()))) {
        parentmodule.changeModule();
      }
    }
  }

  /** Destroy the module 'self', and recursively destroy
   * all contexts that inherit 'self'.
   * @param self
   */
  public static void destroyModule(Module self) {
    if ((self == Stella.$ROOT_MODULE$) ||
        (self == Stella.$STELLA_MODULE$)) {
      Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't destroy the root module or the STELLA module.");
      return;
    }
    Context.clearContext(self);
    Module.helpDestroyModule(self);
  }

  public void unfinalizeModule() {
    { Module self = this;

      self.uninheritSupercontexts();
      Module.uninheritUsedModules(self);
      if (Module.cardinalModuleP(self)) {
        Stella.$ROOT_MODULE$.childContexts.remove(self);
      }
      else {
        { Module parent = null;
          Cons iter000 = self.parentModules.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            parent = ((Module)(iter000.value));
            parent.childContexts.remove(self);
          }
        }
      }
      self.parentModules.clear();
      if (self.contextNumber != Stella.NULL_INTEGER) {
        self.contextNumber = self.contextNumber - 1;
      }
      self.moduleFullName = null;
      self.cardinalModule = null;
      self.symbolOffsetTable = null;
      self.surrogateOffsetTable = null;
    }
  }

  public static void finalizeModule(Module self) {
    self.inheritSupercontexts();
    Module.inheritUsedModules(self);
    Stella.$CONTEXT_NUMBER_COUNTER$ = Stella.$CONTEXT_NUMBER_COUNTER$ + 2;
    self.contextNumber = Stella.$CONTEXT_NUMBER_COUNTER$;
    self.cardinalModule = ((self.parentModule() == null) ? self : self.parentModule().cardinalModule);
    self.symbolOffsetTable = StringToIntegerHashTable.newStringToIntegerHashTable();
    self.surrogateOffsetTable = StringToIntegerHashTable.newStringToIntegerHashTable();
    if (!(((Cons)(Stella.$SHADOWEDSURROGATES$.get())) == Stella.NIL)) {
      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SHADOWED_SURROGATES, List.newList(), null);
      { Object old$Module$000 = Stella.$MODULE$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, self);
          { Symbol sym = null;
            Cons iter000 = ((Cons)(Stella.$SHADOWEDSURROGATES$.get()));

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sym = ((Symbol)(iter000.value));
              self.shadowedSurrogates().insertLast(Stella.shadowSurrogate(sym.symbolName));
            }
          }

        } finally {
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  public static void uninheritUsedModules(Module module) {
    { List usees = module.uses;

      if (usees.emptyP()) {
        usees.push(module);
      }
      else if (Native.stringSearch(module.stringifiedOptions, ":USES ", 0) == Stella.NULL_INTEGER) {
        { Module usee = null;
          Cons iter000 = usees.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            usee = ((Module)(iter000.value));
            usee.usedBy.remove(module);
          }
        }
        usees.clear();
      }
    }
  }

  public static void inheritUsedModules(Module module) {
    { List usees = module.uses;

      if (usees.emptyP()) {
        if (module.parentModules.emptyP()) {
          usees.push(Stella.$STELLA_MODULE$);
          Stella.$STELLA_MODULE$.usedBy.insertNew(module);
        }
        else {
          { Module parent = null;
            Cons iter000 = module.parentModules.theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              parent = ((Module)(iter000.value));
              { Module parentusees = null;
                Cons iter001 = parent.uses.theConsList;

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  parentusees = ((Module)(iter001.value));
                  usees.insertNew(parentusees);
                  parentusees.usedBy.insertNew(module);
                }
              }
            }
          }
          usees.reverse();
        }
      }
      else if (usees.memberP(module)) {
        usees.remove(module);
      }
      else {
      }
    }
  }

  public void inheritSupercontexts() {
    { Module module = this;

      if (!module.multipleParentsP()) {
        { Module onlyparent = ((Module)(module.parentModules.first()));

          if (onlyparent != null) {
            module.allSuperContexts = Cons.cons(onlyparent, onlyparent.allSuperContexts);
            return;
          }
        }
      }
      { Cons allsupercontexts = Stella.NIL;
        Cons sublist = null;

        Module.normalizeParentModules(module);
        module.parentModules.reverse();
        { Module parent = null;
          Cons iter000 = module.parentModules.theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            parent = ((Module)(iter000.value));
            sublist = Stella.NIL;
            { Context ancestor = null;
              Cons iter001 = parent.allSuperContexts;
              Cons collect000 = null;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                ancestor = ((Context)(iter001.value));
                if (!allsupercontexts.memberP(ancestor)) {
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(ancestor, Stella.NIL);
                      if (sublist == Stella.NIL) {
                        sublist = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(sublist, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(ancestor, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
            }
            sublist = Cons.cons(parent, sublist);
            allsupercontexts = sublist.concatenate(allsupercontexts, Stella.NIL);
          }
        }
        module.allSuperContexts = allsupercontexts;
        module.parentModules.reverse();
      }
    }
  }

  public static void normalizeParentModules(Module self) {
    if (!self.multipleParentsP()) {
      return;
    }
    { List parents = self.parentModules;
      boolean recomputefullnameP = false;

      { Module supermodule = null;
        Cons iter000 = parents.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          supermodule = ((Module)(iter000.value));
          { Module othersupermodule = null;
            Cons iter001 = parents.theConsList;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              othersupermodule = ((Module)(iter001.value));
              if (!(othersupermodule == supermodule)) {
                if (supermodule.allSuperContexts.memberP(othersupermodule)) {
                  parents.remove(othersupermodule);
                  othersupermodule.childContexts.remove(self);
                  recomputefullnameP = true;
                }
              }
            }
          }
        }
      }
      if (recomputefullnameP) {
        self.moduleFullName = Stella.computeFullName("", self);
      }
    }
  }

  /** Return TRUE if 'module' has more than one parent.
   * @return boolean
   */
  public boolean multipleParentsP() {
    { Module module = this;

      return (!(module.parentModules.rest() == Stella.NIL));
    }
  }

  /** Change the current module to be the module
   * 'module'.
   * @return Module
   */
  public Module changeModule() {
    { Module module = this;

      return (Module.changeCurrentModule(module));
    }
  }

  public static Module changeCurrentModule(Module module) {
    Native.setSpecial(Stella.$MODULE$, module);
    Native.setSpecial(Stella.$CONTEXT$, module);
    HookList.runHooks(Stella.$CHANGE_MODULE_HOOKS$, module);
    return (module);
  }

  public Iterator parentContexts() {
    { Module self = this;

      return (((ListIterator)(self.parentModules.allocateIterator())));
    }
  }

  public static Stella_Object yieldGlobalLispSymbol(Module symbolmodule, String symbolname) {
    { String lispsymbolpackage = (((symbolmodule == null) ||
          ((symbolmodule == ((Module)(Stella.$MODULE$.get()))) ||
           Stella.stringEqlP(symbolmodule.lispPackage(), ((Module)(Stella.$MODULE$.get())).lispPackage()))) ? ((String)(null)) : symbolmodule.lispPackage());
      String lispsymbolname = Module.yieldReadableSymbolName(symbolmodule, symbolname, false);

      if (lispsymbolpackage == null) {
        return (VerbatimStringWrapper.newVerbatimStringWrapper(lispsymbolname));
      }
      else {
        return (VerbatimStringWrapper.newVerbatimStringWrapper(lispsymbolpackage + "::" + lispsymbolname));
      }
    }
  }

  public static String yieldReadableSymbolName(Module symbolmodule, String symbolname, boolean localP) {
    { String lispsymbolname = ((localP ||
          (((StringWrapper)(KeyValueList.dynamicSlotValue(symbolmodule.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null)) ? symbolname : Stella.computeFullName(symbolname, symbolmodule));

      { Keyword testValue000 = Stella.computeSymbolEscapeCode(lispsymbolname, false);

        if (testValue000 == Stella.KWD_UNESCAPED) {
        }
        else if (testValue000 == Stella.KWD_ESCAPED) {
          lispsymbolname = "|" + lispsymbolname + "|";
        }
        else if (testValue000 == Stella.KWD_COMPLEX_ESCAPED) {
          { OutputStringStream s = OutputStringStream.newOutputStringStream();

            Stella.printSymbolNameReadably(lispsymbolname, s.nativeStream, false);
            lispsymbolname = s.theStringReader();
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (lispsymbolname);
    }
  }

  /** Print all declared but not yet defined functions and methods
   * in <code>module</code>.  If <code>localP</code> is true, do not consider any parent modules of
   * <code>module</code>.  If <code>module</code> is NULL, look at all modules in the system.  This
   * is handy to pinpoint forward declarations that haven't been followed up
   * by actual definitions.
   * @param module
   * @param localP
   */
  public static void printUndefinedMethods(Module module, boolean localP) {
    { Cons undefinedmethods = Stella.NIL;

      { MethodSlot method = null;
        Iterator iter000 = Module.allMethods(module, localP);
        Cons collect000 = null;

        while (iter000.nextP()) {
          method = ((MethodSlot)(iter000.value));
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.FALSE_WRAPPER))).wrapperValue &&
              ((!method.abstractP) &&
               (!MethodSlot.methodContainsUnknownTypeP(method)))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(method, Stella.NIL);
                if (undefinedmethods == Stella.NIL) {
                  undefinedmethods = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(undefinedmethods, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(method, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { MethodSlot function = null;
        Iterator iter001 = Module.allFunctions(module, localP);
        Cons collect001 = null;

        while (iter001.nextP()) {
          function = ((MethodSlot)(iter001.value));
          if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_FORWARD_DECLARATIONp, Stella.FALSE_WRAPPER))).wrapperValue) {
            if (collect001 == null) {
              {
                collect001 = Cons.cons(function, Stella.NIL);
                if (undefinedmethods == Stella.NIL) {
                  undefinedmethods = collect001;
                }
                else {
                  Cons.addConsToEndOfConsList(undefinedmethods, collect001);
                }
              }
            }
            else {
              {
                collect001.rest = Cons.cons(function, Stella.NIL);
                collect001 = collect001.rest;
              }
            }
          }
        }
      }
      if (!(undefinedmethods == Stella.NIL)) {
        Stella.STANDARD_OUTPUT.nativeStream.println("The following functions and methods are declared but not yet defined:");
        { Stella_Object method = null;
          Cons iter002 = undefinedmethods;

          for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            method = iter002.value;
            Stella.STANDARD_OUTPUT.nativeStream.println("    " + method);
          }
        }
      }
    }
  }

  /** Iterate over all unbound surrogates visible from <code>module</code>.
   * Look at all modules if <code>module</code> is <code>null</code>.  If <code>localP</code>, only consider
   * surrogates interned in <code>module</code>.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator unboundSurrogates(Module module, boolean localP) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNestedIterator = Module.allSurrogates(module, localP);
      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "filteredNestedIteratorNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Surrogate", "filterUnboundSurrogateP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Surrogate"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  public static void initializeKernelModule(Module module, String name, String fullname, Module parent) {
    module.moduleName = name;
    module.moduleFullName = fullname;
    if (parent != null) {
      parent.childContexts.insert(module);
      module.cardinalModule = module;
    }
    module.symbolOffsetTable = StringToIntegerHashTable.newStringToIntegerHashTable();
    module.surrogateOffsetTable = StringToIntegerHashTable.newStringToIntegerHashTable();
    module.allSuperContexts = Stella.NIL;
    module.baseModule = module;
    Stella.$CONTEXT_NUMBER_COUNTER$ = Stella.$CONTEXT_NUMBER_COUNTER$ + 2;
    module.contextNumber = Stella.$CONTEXT_NUMBER_COUNTER$;
    module.stringifiedOptions = "";
  }

  public static StringToIntegerHashTable selectSymbolOffsetTable(Module module, int kindofsym) {
    switch (kindofsym) {
      case 0: 
        return (module.symbolOffsetTable);
      case 1: 
        return (module.surrogateOffsetTable);
      case 2: 
        return (Stella.$KEYWORD_OFFSET_TABLE$);
      default:
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + kindofsym + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
    }
  }

  /** Iterate over all public methods visible from 'module'.
   * If 'local?', return only methods interned in 'module'.
   * If 'module' is null, return all methods interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allPublicMethods(Module module, boolean localP) {
    { AllPurposeIterator iterator = ((AllPurposeIterator)(Module.allSlots(module, localP)));

      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterPublicMethodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  /** Iterate over all methods visible from 'module'.
   * If 'local?', return only methods interned in 'module'.
   * If 'module' is null, return all methods interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allMethods(Module module, boolean localP) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "slotsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorNestedIterator = Module.allClasses(module, localP);
      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterMethodSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorConsList = Stella.NIL;
      return (iterator);
    }
  }

  /** Iterate over all slots visible from 'module'.
   * If 'local?', return only methods interned in 'module'.
   * If 'module' is null, return all methods interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allSlots(Module module, boolean localP) {
    { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

      iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "slotsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      iterator.iteratorNestedIterator = Module.allClasses(module, localP);
      iterator.iteratorConsList = Stella.NIL;
      return (iterator);
    }
  }

  /** Iterate over all classes visible from 'module'.
   * If 'local?', return only classes interned in 'module'.
   * If 'module' is null, return all classes interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allClasses(Module module, boolean localP) {
    return (Stella.allocateAllMetaObjectsIterator(Stella.$SURROGATE_ARRAY$.topSymbolOffset + 1, Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allClassesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), module, localP));
  }

  /** Iterate over all surrogates visible from 'module'.
   * If 'local?', return only surrogates interned in 'module'.
   * If 'module' is null, return all surrogates interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allSurrogates(Module module, boolean localP) {
    return (Stella.allocateAllMetaObjectsIterator(Stella.$SURROGATE_ARRAY$.topSymbolOffset + 1, Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSurrogatesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), module, localP));
  }

  /** Iterate over all variables visible from 'module'.
   * If 'local?', return only variables bound to symbols interned in 'module'.
   * If 'module' is null, return all variables defined everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allVariables(Module module, boolean localP) {
    return (Stella.allocateAllMetaObjectsIterator(Stella.$SYMBOL_ARRAY$.topSymbolOffset + 1, Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allVariablesNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), module, localP));
  }

  /** Iterate over all functions visible from 'module'.
   * If 'local?', return only functions bound to symbols interned in 'module'.
   * If 'module' is null, return all functions defined everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allPublicFunctions(Module module, boolean localP) {
    { AllPurposeIterator iterator = ((AllPurposeIterator)(Module.allFunctions(module, localP)));

      iterator.iteratorFilterCode = Native.find_java_method("edu.isi.stella.Slot", "filterPublicSlotP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Slot"), Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
      return (iterator);
    }
  }

  /** Iterate over all functions visible from 'module'.
   * If 'local?', return only functions bound to symbols interned in 'module'.
   * If 'module' is null, return all functions defined everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allFunctions(Module module, boolean localP) {
    return (Stella.allocateAllMetaObjectsIterator(Stella.$SYMBOL_ARRAY$.topSymbolOffset + 1, Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allFunctionsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), module, localP));
  }

  /** Iterate over all symbols visible from 'module'.
   * If 'local?', return only symbols interned in 'module'.
   * If 'module' is null, return all symbols interned everywhere.
   * @param module
   * @param localP
   * @return Iterator
   */
  public static Iterator allSymbols(Module module, boolean localP) {
    return (Stella.allocateAllMetaObjectsIterator(Stella.$SYMBOL_ARRAY$.topSymbolOffset + 1, Native.find_java_method("edu.isi.stella.AllPurposeIterator", "allSymbolsNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")}), module, localP));
  }

  public static Stella_Object accessModuleSlotValue(Module self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PARENT_MODULES) {
      if (setvalueP) {
        self.parentModules = ((List)(value));
      }
      else {
        value = self.parentModules;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DOCUMENTATION) {
      if (setvalueP) {
        self.documentation = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.documentation);
      }
    }
    else if (slotname == Stella.SYM_STELLA_NICKNAMES) {
      if (setvalueP) {
        self.nicknames = ((List)(value));
      }
      else {
        value = self.nicknames;
      }
    }
    else if (slotname == Stella.SYM_STELLA_USES) {
      if (setvalueP) {
        self.uses = ((List)(value));
      }
      else {
        value = self.uses;
      }
    }
    else if (slotname == Stella.SYM_STELLA_USED_BY) {
      if (setvalueP) {
        self.usedBy = ((List)(value));
      }
      else {
        value = self.usedBy;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SHADOWED_SURROGATES) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SHADOWED_SURROGATES, ((List)(value)), null);
      }
      else {
        value = self.shadowedSurrogates();
      }
    }
    else if (slotname == Stella.SYM_STELLA_REQUIRES) {
      if (setvalueP) {
        self.requires = ((List)(value));
      }
      else {
        value = self.requires;
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE_LISP_PACKAGE) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
      }
      else {
        value = StringWrapper.wrapString(self.moduleLispPackage());
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE_CPP_PACKAGE) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
      }
      else {
        value = StringWrapper.wrapString(self.moduleCppPackage());
      }
    }
    else if (slotname == Stella.SYM_STELLA_JAVA_PACKAGE) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_JAVA_PACKAGE, StringWrapper.wrapString(((StringWrapper)(value)).wrapperValue), Stella.NULL_STRING_WRAPPER);
      }
      else {
        value = StringWrapper.wrapString(self.javaPackage());
      }
    }
    else if (slotname == Stella.SYM_STELLA_CASE_SENSITIVEp) {
      if (setvalueP) {
        self.caseSensitiveP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.caseSensitiveP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CLEARABLEp) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
      }
      else {
        value = (self.clearableP() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_PROTECT_SURROGATESp) {
      if (setvalueP) {
        KeyValueList.setDynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROTECT_SURROGATESp, (BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value))) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.FALSE_WRAPPER);
      }
      else {
        value = (self.protectSurrogatesP() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE_FULL_NAME) {
      if (setvalueP) {
        self.moduleFullName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.moduleFullName);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE_NAME) {
      if (setvalueP) {
        self.moduleName = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.moduleName);
      }
    }
    else if (slotname == Stella.SYM_STELLA_MODULE_STRINGIFIED_SOURCE) {
      if (setvalueP) {
        self.moduleStringifiedSource = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.moduleStringifiedSource);
      }
    }
    else if (slotname == Stella.SYM_STELLA_STRINGIFIED_OPTIONS) {
      if (setvalueP) {
        self.stringifiedOptions = ((StringWrapper)(value)).wrapperValue;
      }
      else {
        value = StringWrapper.wrapString(self.stringifiedOptions);
      }
    }
    else if (slotname == Stella.SYM_STELLA_CARDINAL_MODULE) {
      if (setvalueP) {
        self.cardinalModule = ((Module)(value));
      }
      else {
        value = self.cardinalModule;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SYMBOL_OFFSET_TABLE) {
      if (setvalueP) {
        self.symbolOffsetTable = ((StringToIntegerHashTable)(value));
      }
      else {
        value = self.symbolOffsetTable;
      }
    }
    else if (slotname == Stella.SYM_STELLA_SURROGATE_OFFSET_TABLE) {
      if (setvalueP) {
        self.surrogateOffsetTable = ((StringToIntegerHashTable)(value));
      }
      else {
        value = self.surrogateOffsetTable;
      }
    }
    else if (slotname == Stella.SYM_STELLA_STRICT_INFERENCE_CACHE) {
      if (setvalueP) {
        self.strictInferenceCache = ((World)(value));
      }
      else {
        value = self.strictInferenceCache;
      }
    }
    else if (slotname == Stella.SYM_STELLA_DEFAULT_INFERENCE_CACHE) {
      if (setvalueP) {
        self.defaultInferenceCache = ((World)(value));
      }
      else {
        value = self.defaultInferenceCache;
      }
    }
    else if (slotname == Stella.SYM_STELLA_PROTOTYPE_INFERENCE_CACHE) {
      if (setvalueP) {
        self.prototypeInferenceCache = ((World)(value));
      }
      else {
        value = self.prototypeInferenceCache;
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

  public boolean protectSurrogatesP() {
    { Module self = this;

      return (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_PROTECT_SURROGATESp, Stella.TRUE_WRAPPER))).wrapperValue);
    }
  }

  public boolean clearableP() {
    { Module self = this;

      return (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_CLEARABLEp, Stella.TRUE_WRAPPER))).wrapperValue);
    }
  }

  public String javaPackage() {
    { Module self = this;

      { String answer = ((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_JAVA_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (answer == null) {
          return (null);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public String moduleCppPackage() {
    { Module self = this;

      { String answer = ((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (answer == null) {
          return ("stella");
        }
        else {
          return (answer);
        }
      }
    }
  }

  public String moduleLispPackage() {
    { Module self = this;

      { String answer = ((StringWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        if (answer == null) {
          return ("STELLA");
        }
        else {
          return (answer);
        }
      }
    }
  }

  public List shadowedSurrogates() {
    { Module self = this;

      { List answer = ((List)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Stella.SYM_STELLA_SHADOWED_SURROGATES, null)));

        if (answer == null) {
          return (Stella.NIL_LIST);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public String cppPackage() {
    { Module self = this;

      { Module cursor = self;
        String value = ((StringWrapper)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Module)(cursor.parentModules.first()));
          if (cursor != null) {
            value = ((StringWrapper)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_MODULE_CPP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
          }
          else {
            return ("stella");
          }
        }
      }
    }
  }

  public String lispPackage() {
    { Module self = this;

      { Module cursor = self;
        String value = ((StringWrapper)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;

        for (;;) {
          if (value != null) {
            return (value);
          }
          cursor = ((Module)(cursor.parentModules.first()));
          if (cursor != null) {
            value = ((StringWrapper)(KeyValueList.dynamicSlotValue(cursor.dynamicSlots, Stella.SYM_STELLA_MODULE_LISP_PACKAGE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
          }
          else {
            return ("STELLA");
          }
        }
      }
    }
  }

  public Module parentModule() {
    { Module self = this;

      return (((Module)(((Context)(self.parentContexts().pop())))));
    }
  }

  public String name() {
    { Module self = this;

      return (self.moduleName);
    }
  }

  public Surrogate primaryType() {
    { Module self = this;

      return (Stella.SGT_STELLA_MODULE);
    }
  }

}

