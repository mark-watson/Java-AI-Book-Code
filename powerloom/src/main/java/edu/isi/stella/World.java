//  -*- Mode: Java -*-
//
// World.java

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

public class World extends Context {
    public Context parentContext;

  public static World newWorld() {
    { World self = null;

      self = new World();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.contextNumber = Stella.NULL_INTEGER;
      self.allSuperContexts = null;
      self.baseModule = null;
      self.childContexts = List.newList();
      self.parentContext = null;
      return (self);
    }
  }

  /** Return FALSE always, since worlds never have more than one parent.
   * @return boolean
   */
  public boolean multipleParentsP() {
    { World world = this;

      return (false);
    }
  }

  /** Destroy the context 'self', and recursively destroy
   * all contexts that inherit 'self'.
   */
  public void destroyContext() {
    { World self = this;

      World.destroyWorld(self);
    }
  }

  public static void destroyWorld(World self) {
    if (self.childContexts.nonEmptyP()) {
      { World child = null;
        Cons iter000 = self.childContexts.copy().theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          child = ((World)(iter000.value));
          if (!child.deletedP()) {
            World.destroyWorld(child);
          }
        }
      }
    }
    { Context parentcontext = self.parentContext;

      HookList.runHooks(Stella.$DESTROY_CONTEXT_HOOKS$, self);
      self.unfinalizeWorld();
      if (self == ((Context)(Stella.$CONTEXT$.get()))) {
        Native.setSpecial(Stella.$CONTEXT$, parentcontext);
      }
    }
  }

  public void unfinalizeWorld() {
    { World self = this;

      self.parentContext.childContexts.remove(self);
      self.contextNumber = self.contextNumber - 1;
      self.allSuperContexts = null;
      self.parentContext = null;
    }
  }

  public static void finalizeWorld(World self) {
    { Context parentcontext = self.parentContext;

      self.allSuperContexts = Cons.cons(parentcontext, parentcontext.allSuperContexts);
      Stella.$CONTEXT_NUMBER_COUNTER$ = Stella.$CONTEXT_NUMBER_COUNTER$ + 2;
      self.contextNumber = Stella.$CONTEXT_NUMBER_COUNTER$;
    }
  }

  public void inheritSupercontexts() {
    { World world = this;

      { Context parent = world.parentContext;

        if (parent != null) {
          world.allSuperContexts = Cons.cons(parent, parent.allSuperContexts);
        }
        else {
          world.allSuperContexts = Stella.NIL;
        }
      }
    }
  }

  public Iterator parentContexts() {
    { World self = this;

      return (((Cons)(Cons.cons(self.parentContext, Stella.NIL))).allocateDestructiveListIterator());
    }
  }

  public static Stella_Object accessWorldSlotValue(World self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_PARENT_CONTEXT) {
      if (setvalueP) {
        self.parentContext = ((Context)(value));
      }
      else {
        value = self.parentContext;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CHILD_CONTEXTS) {
      if (setvalueP) {
        self.childContexts = ((List)(value));
      }
      else {
        value = self.childContexts;
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

  public Surrogate primaryType() {
    { World self = this;

      return (Stella.SGT_STELLA_WORLD);
    }
  }

}

