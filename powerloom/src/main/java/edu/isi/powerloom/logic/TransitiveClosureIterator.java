//  -*- Mode: Java -*-
//
// TransitiveClosureIterator.java

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

/** Iterator that visits all nodes reachable using an
 * embedded adjacency function.
 * @author Stella Java Translator
 */
public class TransitiveClosureIterator extends Iterator {
    public java.lang.reflect.Method allocateAdjacencyIteratorFunction;
    public java.lang.reflect.Method filterP;
    public Cons adjacencyIteratorStack;
    public Cons beenThereList;

  public static TransitiveClosureIterator newTransitiveClosureIterator() {
    { TransitiveClosureIterator self = null;

      self = new TransitiveClosureIterator();
      self.firstIterationP = true;
      self.value = null;
      self.beenThereList = null;
      self.adjacencyIteratorStack = Stella.NIL;
      self.filterP = null;
      self.allocateAdjacencyIteratorFunction = null;
      return (self);
    }
  }

  public boolean nextP() {
    { TransitiveClosureIterator self = this;

      return (TransitiveClosureIterator.transitiveClosureIteratorDnextP(self));
    }
  }

  public static boolean transitiveClosureIteratorDnextP(TransitiveClosureIterator self) {
    { Stella_Object node = self.value;
      Iterator adjacencyiterator = ((Iterator)(edu.isi.stella.javalib.Native.funcall(self.allocateAdjacencyIteratorFunction, null, new java.lang.Object [] {node})));

      if (adjacencyiterator != null) {
        self.adjacencyIteratorStack = Cons.cons(adjacencyiterator, self.adjacencyIteratorStack);
      }
      else {
        {
          adjacencyiterator = ((Iterator)(self.adjacencyIteratorStack.value));
          if (adjacencyiterator == null) {
            return (false);
          }
        }
      }
      for (;;) {
        while (!adjacencyiterator.nextP()) {
          self.adjacencyIteratorStack = self.adjacencyIteratorStack.rest;
          adjacencyiterator = ((Iterator)(self.adjacencyIteratorStack.value));
          if (adjacencyiterator == null) {
            return (false);
          }
        }
        node = adjacencyiterator.value;
        if ((!self.beenThereList.memberP(node)) &&
            ((self.filterP == null) ||
             ((Boolean)(edu.isi.stella.javalib.Native.funcall(self.filterP, null, new java.lang.Object [] {node}))).booleanValue())) {
          self.beenThereList = Cons.cons(node, self.beenThereList);
          self.value = node;
          return (true);
        }
      }
    }
  }

  public static Stella_Object accessTransitiveClosureIteratorSlotValue(TransitiveClosureIterator self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_ALLOCATE_ADJACENCY_ITERATOR_FUNCTION) {
      if (setvalueP) {
        self.allocateAdjacencyIteratorFunction = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.allocateAdjacencyIteratorFunction);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_FILTERp) {
      if (setvalueP) {
        self.filterP = ((FunctionCodeWrapper)(value)).wrapperValue;
      }
      else {
        value = FunctionCodeWrapper.wrapFunctionCode(self.filterP);
      }
    }
    else if (slotname == Logic.SYM_LOGIC_ADJACENCY_ITERATOR_STACK) {
      if (setvalueP) {
        self.adjacencyIteratorStack = ((Cons)(value));
      }
      else {
        value = self.adjacencyIteratorStack;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_BEEN_THERE_LIST) {
      if (setvalueP) {
        self.beenThereList = ((Cons)(value));
      }
      else {
        value = self.beenThereList;
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
    { TransitiveClosureIterator self = this;

      return (Logic.SGT_LOGIC_TRANSITIVE_CLOSURE_ITERATOR);
    }
  }

}

