//  -*- Mode: Java -*-
//
// AllPurposeIterator.java

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

/** The all-purpose iterator works by storing a <code>nextP</code>
 * function within itself during iterator allocation.  The method
 * <code>ALL_PURPOSE_ITERAORDnextP</code> funcalls the stored <code>nextP</code> function.
 * An assortment of storage slots are provided for constructing different
 * kinds of iterators.
 * @author Stella Java Translator
 */
public class AllPurposeIterator extends Iterator {
    public Stella_Object key;
    public java.lang.reflect.Method iteratorNextCode;
    public java.lang.reflect.Method iteratorFilterCode;
    public java.lang.reflect.Method iteratorEmptyCode;
    public Iterator iteratorNestedIterator;
    public Cons iteratorConsList;
    public Stella_Object iteratorObject;
    public Stella_Object iteratorSecondObject;
    public int iteratorInteger;
    public int iteratorSecondInteger;

  public static AllPurposeIterator newAllPurposeIterator() {
    { AllPurposeIterator self = null;

      self = new AllPurposeIterator();
      self.firstIterationP = true;
      self.value = null;
      self.iteratorSecondInteger = Stella.NULL_INTEGER;
      self.iteratorInteger = Stella.NULL_INTEGER;
      self.iteratorSecondObject = null;
      self.iteratorObject = null;
      self.iteratorConsList = null;
      self.iteratorNestedIterator = null;
      self.iteratorEmptyCode = null;
      self.iteratorFilterCode = null;
      self.iteratorNextCode = null;
      self.key = null;
      return (self);
    }
  }

  public static boolean allTopdownSubcontextsNextP(AllPurposeIterator self) {
    { Cons remainingcontexts = self.iteratorConsList;
      Context thiscontext = null;
      Cons subcontexts = Stella.NIL;
      HashTable beenthere = ((HashTable)(self.iteratorSecondObject));

      if (remainingcontexts == Stella.NIL) {
        self.value = null;
        return (false);
      }
      if (beenthere == null) {
        beenthere = HashTable.newHashTable();
        self.iteratorSecondObject = beenthere;
        { Context sub = null;
          AllPurposeIterator iter000 = Context.allSubcontexts(((Context)(self.iteratorObject)), Stella.KWD_PREORDER);

          while (iter000.nextP()) {
            sub = ((Context)(iter000.value));
            beenthere.insertAt(sub, Stella.FALSE_WRAPPER);
          }
        }
      }
      loop001 : while (!(remainingcontexts == Stella.NIL)) {
        thiscontext = ((Context)(remainingcontexts.value));
        { boolean alwaysP000 = true;

          { Context p = null;
            Iterator iter001 = thiscontext.parentContexts();

            loop002 : while (iter001.nextP()) {
              p = ((Context)(iter001.value));
              if (!(!Stella_Object.eqlP(beenthere.lookup(p), Stella.FALSE_WRAPPER))) {
                alwaysP000 = false;
                break loop002;
              }
            }
          }
          if (alwaysP000) {
            break loop001;
          }
        }
        remainingcontexts = remainingcontexts.rest;
      }
      if (remainingcontexts == Stella.NIL) {
        {
          self.value = null;
          return (false);
        }
      }
      else {
        remainingcontexts = remainingcontexts.rest;
      }
      beenthere.insertAt(thiscontext, Stella.TRUE_WRAPPER);
      { Context child = null;
        Cons iter002 = thiscontext.childContexts.theConsList;
        Cons collect000 = null;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          child = ((Context)(iter002.value));
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
      if (remainingcontexts == Stella.NIL) {
        self.iteratorConsList = subcontexts;
      }
      else if (subcontexts == Stella.NIL) {
        self.iteratorConsList = remainingcontexts;
      }
      else {
        Cons.lastCons(remainingcontexts).rest = subcontexts;
        self.iteratorConsList = remainingcontexts;
      }
      self.value = thiscontext;
      return (true);
    }
  }

  public static boolean allSubcontextsNextP(AllPurposeIterator self) {
    { Keyword traversal = ((Keyword)(self.iteratorObject));
      Cons remainingcontexts = self.iteratorConsList;
      Context thiscontext = null;
      Cons subcontexts = Stella.NIL;
      HashSet beenthere = ((HashSet)(self.iteratorSecondObject));

      if (remainingcontexts == Stella.NIL) {
        self.value = null;
        return (false);
      }
      if (beenthere == null) {
        beenthere = HashSet.newHashSet();
        self.iteratorSecondObject = beenthere;
        { Stella_Object ctxt = null;
          Cons iter000 = remainingcontexts;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            ctxt = iter000.value;
            beenthere.insert(ctxt);
          }
        }
      }
      thiscontext = ((Context)(remainingcontexts.value));
      remainingcontexts = remainingcontexts.rest;
      { Context child = null;
        Cons iter001 = thiscontext.childContexts.theConsList;
        Cons collect000 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          child = ((Context)(iter001.value));
          if (!beenthere.memberP(child)) {
            beenthere.insert(child);
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
      }
      if (subcontexts == Stella.NIL) {
        self.iteratorConsList = remainingcontexts;
      }
      else {
        if (traversal == Stella.KWD_PREORDER) {
          Cons.lastCons(subcontexts).rest = remainingcontexts;
          self.iteratorConsList = subcontexts;
        }
        else if (traversal == Stella.KWD_POSTORDER) {
          subcontexts = subcontexts.reverse();
          Cons.lastCons(subcontexts).rest = remainingcontexts;
          self.iteratorConsList = subcontexts;
        }
        else if (traversal == Stella.KWD_INORDER) {
          if (remainingcontexts == Stella.NIL) {
            self.iteratorConsList = subcontexts;
          }
          else {
            Cons.lastCons(remainingcontexts).rest = subcontexts;
            self.iteratorConsList = remainingcontexts;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + traversal + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      self.value = thiscontext;
      return (true);
    }
  }

  public static boolean classTablesNextP(AllPurposeIterator self) {
    { Slot slot = null;

      loop000 : for (;;) {
        { 
          slot = ((Slot)(self.iteratorConsList.value));
          if (!(slot != null)) {
            break loop000;
          }
        }
        self.iteratorConsList = self.iteratorConsList.rest;
        if (Stella_Object.isaP(slot, Stella.SGT_STELLA_TABLE) &&
            ((self.iteratorFilterCode == null) ||
             ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {slot, self}))).booleanValue())) {
          self.value = slot;
          return (true);
        }
      }
      return (false);
    }
  }

  public static boolean classStorageSlotsNextP(AllPurposeIterator self) {
    { Slot slot = null;

      loop000 : for (;;) {
        { 
          slot = ((Slot)(self.iteratorConsList.value));
          if (!(slot != null)) {
            break loop000;
          }
        }
        self.iteratorConsList = self.iteratorConsList.rest;
        if (Stella_Object.storageSlotP(slot) &&
            ((self.iteratorFilterCode == null) ||
             ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {slot, self}))).booleanValue())) {
          self.value = slot;
          return (true);
        }
      }
      return (false);
    }
  }

  public static boolean classMethodsNextP(AllPurposeIterator self) {
    { Slot slot = null;

      loop000 : for (;;) {
        { 
          slot = ((Slot)(self.iteratorConsList.value));
          if (!(slot != null)) {
            break loop000;
          }
        }
        self.iteratorConsList = self.iteratorConsList.rest;
        if (Stella_Object.methodSlotP(slot) &&
            ((self.iteratorFilterCode == null) ||
             ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {slot, self}))).booleanValue())) {
          self.value = slot;
          return (true);
        }
      }
      return (false);
    }
  }

  public static boolean slotsNextP(AllPurposeIterator self) {
    { Slot slot = null;

      for (;;) {
        loop001 : for (;;) {
          { 
            slot = ((Slot)(self.iteratorConsList.value));
            if (!(slot != null)) {
              break loop001;
            }
          }
          self.iteratorConsList = self.iteratorConsList.rest;
          if ((self.iteratorFilterCode == null) ||
              ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {slot, self}))).booleanValue()) {
            self.value = slot;
            return (true);
          }
        }
        if (!self.iteratorNestedIterator.nextP()) {
          return (false);
        }
        self.iteratorConsList = ((Stella_Class)(self.iteratorNestedIterator.value)).classLocalSlots.theConsList;
      }
    }
  }

  public static boolean allClassesNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;
      Surrogate surrogate = null;
      Stella_Object value = null;

      while (cursor < self.iteratorSecondInteger) {
        surrogate = ((Surrogate)((Stella.$SURROGATE_ARRAY$.theArray)[cursor]));
        if ((surrogate != null) &&
            AllPurposeIterator.selectedMetaObjectP(self, ((Module)(surrogate.homeContext)))) {
          value = surrogate.surrogateValue;
          if ((value != null) &&
              (Stella_Object.stellaClassP(value) &&
               (((Stella_Class)(value)).classType == surrogate))) {
            self.value = value;
            self.iteratorInteger = cursor + 1;
            return (true);
          }
        }
        cursor = cursor + 1;
      }
      return (false);
    }
  }

  public static boolean allSurrogatesNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;
      Surrogate surrogate = null;

      while (cursor < self.iteratorSecondInteger) {
        surrogate = ((Surrogate)((Stella.$SURROGATE_ARRAY$.theArray)[cursor]));
        if ((surrogate != null) &&
            AllPurposeIterator.selectedMetaObjectP(self, ((Module)(surrogate.homeContext)))) {
          self.value = surrogate;
          self.iteratorInteger = cursor + 1;
          return (true);
        }
        cursor = cursor + 1;
      }
      return (false);
    }
  }

  public static boolean allVariablesNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;
      Symbol symbol = null;
      GlobalVariable variable = null;

      while (cursor < self.iteratorSecondInteger) {
        symbol = ((Symbol)((Stella.$SYMBOL_ARRAY$.theArray)[cursor]));
        if ((symbol != null) &&
            AllPurposeIterator.selectedMetaObjectP(self, ((Module)(symbol.homeContext)))) {
          variable = ((GlobalVariable)(Stella.$GLOBAL_VARIABLE_LOOKUP_TABLE$.lookup(symbol)));
          if ((variable != null) &&
              (AllPurposeIterator.selectedMetaObjectP(self, variable.homeModule()) &&
               ((self.iteratorFilterCode == null) ||
                ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {variable, self}))).booleanValue()))) {
            self.value = variable;
            self.iteratorInteger = cursor + 1;
            return (true);
          }
        }
        cursor = cursor + 1;
      }
      return (false);
    }
  }

  public static boolean allFunctionsNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;
      Symbol symbol = null;
      MethodSlot function = null;

      while (cursor < self.iteratorSecondInteger) {
        symbol = ((Symbol)((Stella.$SYMBOL_ARRAY$.theArray)[cursor]));
        if ((symbol != null) &&
            AllPurposeIterator.selectedMetaObjectP(self, Symbol.lookupFunctionHomeModule(symbol))) {
          function = Symbol.lookupFunction(symbol);
          if ((function != null) &&
              ((self.iteratorFilterCode == null) ||
               ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {function, self}))).booleanValue())) {
            self.value = function;
            self.iteratorInteger = cursor + 1;
            return (true);
          }
        }
        cursor = cursor + 1;
      }
      return (false);
    }
  }

  public static boolean allSymbolsNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;
      Symbol symbol = null;

      while (cursor < self.iteratorSecondInteger) {
        symbol = ((Symbol)((Stella.$SYMBOL_ARRAY$.theArray)[cursor]));
        if ((symbol != null) &&
            AllPurposeIterator.selectedMetaObjectP(self, ((Module)(symbol.homeContext)))) {
          self.value = symbol;
          self.iteratorInteger = cursor + 1;
          return (true);
        }
        cursor = cursor + 1;
      }
      return (false);
    }
  }

  public static boolean selectedMetaObjectP(AllPurposeIterator self, Module objectmodule) {
    { Cons modules = self.iteratorConsList;

      if (modules == Stella.NIL) {
        return (true);
      }
      else {
        if (modules.rest == Stella.NIL) {
          if (objectmodule == modules.value) {
            return (true);
          }
          else {
            return (false);
          }
        }
        else {
          return (modules.membP(objectmodule));
        }
      }
    }
  }

  public static boolean filteredConcatenatedIteratorNextP(AllPurposeIterator self) {
    { Iterator nestediterator = self.iteratorNestedIterator;
      java.lang.reflect.Method filtercode = self.iteratorFilterCode;
      Stella_Object value = null;

      loop000 : for (;;) {
        while (nestediterator.nextP()) {
          value = nestediterator.value;
          if (((filtercode != null) ? ((Boolean)(edu.isi.stella.javalib.Native.funcall(filtercode, null, new java.lang.Object [] {value, self}))).booleanValue() : true)) {
            self.value = value;
            return (true);
          }
        }
        nestediterator = ((Iterator)(self.iteratorConsList.value));
        self.iteratorConsList = self.iteratorConsList.rest;
        if (nestediterator == null) {
          break loop000;
        }
        else {
          self.iteratorNestedIterator = nestediterator;
        }
      }
      return (false);
    }
  }

  public static boolean iteratorConsListEmptyP(AllPurposeIterator self) {
    return (self.iteratorConsList == Stella.NIL);
  }

  public static boolean iteratorConsListNextP(AllPurposeIterator self) {
    { Cons cursor = self.iteratorConsList;

      if (cursor == Stella.NIL) {
        return (false);
      }
      self.value = cursor.value;
      self.iteratorConsList = cursor.rest;
      return (true);
    }
  }

  public static boolean filteredNestedIteratorNextP(AllPurposeIterator self) {
    { Iterator nestediterator = self.iteratorNestedIterator;
      Stella_Object value = null;

      while (nestediterator.nextP()) {
        value = nestediterator.value;
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorFilterCode, null, new java.lang.Object [] {value, self}))).booleanValue()) {
          self.value = value;
          return (true);
        }
      }
      return (false);
    }
  }

  public boolean terminateAllPurposeIteratorP() {
    { AllPurposeIterator self = this;

      if (self.iteratorNestedIterator != null) {
        self.iteratorNestedIterator.free();
      }
      return (true);
    }
  }

  public boolean emptyP() {
    { AllPurposeIterator self = this;

      if (self.iteratorEmptyCode == null) {
        throw ((StellaException)(StellaException.newStellaException("Missing 'empty?' method").fillInStackTrace()));
      }
      return (((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorEmptyCode, null, new java.lang.Object [] {}))).booleanValue());
    }
  }

  /** Apply the stored 'next?' function to 'self'.
   * @return boolean
   */
  public boolean nextP() {
    { AllPurposeIterator self = this;

      return (((Boolean)(edu.isi.stella.javalib.Native.funcall(self.iteratorNextCode, null, new java.lang.Object [] {self}))).booleanValue());
    }
  }

  public static boolean vectorNextP(AllPurposeIterator self) {
    { int cursor = self.iteratorInteger;

      if (cursor < self.iteratorSecondInteger) {
        self.value = (((Vector)(self.iteratorObject)).theArray)[cursor];
        self.iteratorInteger = cursor + 1;
        return (true);
      }
      return (false);
    }
  }

  public static boolean butLastNextP(AllPurposeIterator self) {
    if (self.firstIterationP) {
      self.firstIterationP = false;
    }
    else {
      self.iteratorConsList = self.iteratorConsList.rest;
    }
    if (self.iteratorConsList.rest == Stella.NIL) {
      return (false);
    }
    self.value = self.iteratorConsList.value;
    return (true);
  }

  public static boolean allTaxonomyNodesNextP(AllPurposeIterator self) {
    { List roots = ((List)(self.iteratorObject));

      if (roots.emptyP()) {
        return (false);
      }
      self.value = ((TaxonomyNode)(roots.pop()));
      { TaxonomyNode child = null;
        Cons iter000 = ((TaxonomyNode)(self.value)).treeChildren;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((TaxonomyNode)(iter000.value));
          roots.push(child);
        }
      }
      return (true);
    }
  }

  public static Stella_Object accessAllPurposeIteratorSlotValue(AllPurposeIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_KEY) {
      if (setvalueP) {
        self.key = value;
      }
      else {
        value = self.key;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_NEXT_CODE) {
      if (setvalueP) {
        self.iteratorNextCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.iteratorNextCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_FILTER_CODE) {
      if (setvalueP) {
        self.iteratorFilterCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.iteratorFilterCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_EMPTY_CODE) {
      if (setvalueP) {
        self.iteratorEmptyCode = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.iteratorEmptyCode);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_NESTED_ITERATOR) {
      if (setvalueP) {
        self.iteratorNestedIterator = ((Iterator)(value));
      }
      else {
        value = self.iteratorNestedIterator;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_CONS_LIST) {
      if (setvalueP) {
        self.iteratorConsList = ((Cons)(value));
      }
      else {
        value = self.iteratorConsList;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_OBJECT) {
      if (setvalueP) {
        self.iteratorObject = value;
      }
      else {
        value = self.iteratorObject;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_SECOND_OBJECT) {
      if (setvalueP) {
        self.iteratorSecondObject = value;
      }
      else {
        value = self.iteratorSecondObject;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_INTEGER) {
      if (setvalueP) {
        self.iteratorInteger = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.iteratorInteger);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITERATOR_SECOND_INTEGER) {
      if (setvalueP) {
        self.iteratorSecondInteger = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.iteratorSecondInteger);
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
    { AllPurposeIterator self = this;

      return (Stella.SGT_STELLA_ALL_PURPOSE_ITERATOR);
    }
  }

  public void free() {
    { AllPurposeIterator self = this;

      if (self.terminateAllPurposeIteratorP()) {
        Stella_Object.unmake(self);
      }
    }
  }

}

