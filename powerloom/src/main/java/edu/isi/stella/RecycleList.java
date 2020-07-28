//  -*- Mode: Java -*-
//
// RecycleList.java

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

public class RecycleList extends Sequence {
    public Surrogate recycleListOf;
    public Stella_Object recycledItems;
    public List listOfRecycledItems;
    public Stella_Object allItems;
    public Stella_Object unusedItems;
    public int currentLength;
    public int itemSize;

  public static RecycleList newRecycleList() {
    { RecycleList self = null;

      self = new RecycleList();
      self.itemSize = Stella.NULL_INTEGER;
      self.currentLength = 0;
      self.unusedItems = null;
      self.allItems = null;
      self.listOfRecycledItems = Stella.makeNonRecycledList();
      self.recycledItems = null;
      self.recycleListOf = null;
      return (self);
    }
  }

  public static void reduceRecycleListSize(RecycleList list, double fraction) {
    { int length = list.currentLength;
      int reducedlength = Native.floor(length * fraction);
      Surrogate itemtype = list.recycleListOf;
      Stella_Object cursor = null;
      Stella_Object trailingcursor = null;
      Stella_Object unused = null;
      StorageSlot nextslot = null;

      if (((list.allItems != null) ||
          (list.recycledItems != null)) &&
          (!Surrogate.subtypeOfP(itemtype, Stella.SGT_STELLA_STANDARD_OBJECT))) {
        RecycleList.clearRecycleList(list);
        return;
      }
      Native.setBooleanSpecial(Stella.$RECYCLING_ENABLEDp$, false);
      if (list.allItems != null) {
        cursor = list.allItems;
        unused = list.unusedItems;
        nextslot = ((StorageSlot)(Stella_Class.lookupSlot(((Stella_Class)(itemtype.surrogateValue)), Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT)));
        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = length - reducedlength;

          for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            if (cursor == unused) {
              list.unusedItems = list.allItems;
            }
            trailingcursor = cursor;
            cursor = StandardObject.readSlotValue(((StandardObject)(cursor)), nextslot);
            StandardObject.putSlotValue(((StandardObject)(trailingcursor)), nextslot, null);
          }
        }
        if (Stella_Object.eqlP(list.unusedItems, list.allItems)) {
          list.unusedItems = cursor;
        }
        list.allItems = cursor;
      }
      if (list.listOfRecycledItems.nonEmptyP()) {
        cursor = list.listOfRecycledItems.theConsList.nthRest(reducedlength);
        if (cursor != null) {
          ((Cons)(cursor)).rest = Stella.NIL;
        }
      }
      else if (list.recycledItems != null) {
        if (list.allItems != null) {
          list.recycledItems = null;
        }
        else {
          cursor = list.recycledItems;
          nextslot = Stella_Class.recycleSlot(((Stella_Class)(itemtype.surrogateValue)));
          { int i = Stella.NULL_INTEGER;
            int iter001 = 2;
            int upperBound001 = reducedlength;
            boolean unboundedP000 = upperBound001 == Stella.NULL_INTEGER;

            loop001 : for (;unboundedP000 ||
                      (iter001 <= upperBound001); iter001 = iter001 + 1) {
              i = iter001;
              cursor = StandardObject.readSlotValue(((StandardObject)(cursor)), nextslot);
              if (cursor == null) {
                break loop001;
              }
            }
          }
          if (cursor != null) {
            StandardObject.putSlotValue(((StandardObject)(cursor)), nextslot, null);
          }
        }
      }
      list.currentLength = reducedlength;
      Native.setBooleanSpecial(Stella.$RECYCLING_ENABLEDp$, true);
    }
  }

  public static boolean recycleListSizeL(RecycleList list1, RecycleList list2) {
    return ((list1.itemSize * list1.currentLength) < (list2.itemSize * list2.currentLength));
  }

  public static int recycleListSize(RecycleList list) {
    return (list.itemSize * list.currentLength);
  }

  public boolean deletedPSetter(boolean value) {
    { RecycleList self = this;

      if (value) {
        self.recycleListOf = null;
      }
      else {
        if (self.recycleListOf == null) {
          self.recycleListOf = Stella.SGT_STELLA_UNKNOWN;
        }
      }
      return (value);
    }
  }

  public boolean deletedP() {
    { RecycleList self = this;

      return (self.recycleListOf == null);
    }
  }

  /** Reset <code>list</code> to its empty state.
   * @param list
   */
  public static void clearRecycleList(RecycleList list) {
    list.allItems = null;
    list.unusedItems = null;
    list.recycledItems = null;
    list.listOfRecycledItems.theConsList = Stella.NIL;
    list.currentLength = 0;
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { RecycleList self = this;

      if (self.recycleListOf != null) {
        stream.print("|i|[RECYCLE-LIST OF " + self.currentLength + " " + self.recycleListOf + "'s]");
      }
      else {
        stream.print("|i|@RECYCLE-LIST");
      }
    }
  }

  public static Stella_Object accessRecycleListSlotValue(RecycleList self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_RECYCLE_LIST_OF) {
      if (setvalueP) {
        self.recycleListOf = ((Surrogate)(value));
      }
      else {
        value = self.recycleListOf;
      }
    }
    else if (slotname == Stella.SYM_STELLA_RECYCLED_ITEMS) {
      if (setvalueP) {
        self.recycledItems = value;
      }
      else {
        value = self.recycledItems;
      }
    }
    else if (slotname == Stella.SYM_STELLA_LIST_OF_RECYCLED_ITEMS) {
      if (setvalueP) {
        self.listOfRecycledItems = ((List)(value));
      }
      else {
        value = self.listOfRecycledItems;
      }
    }
    else if (slotname == Stella.SYM_STELLA_ALL_ITEMS) {
      if (setvalueP) {
        self.allItems = value;
      }
      else {
        value = self.allItems;
      }
    }
    else if (slotname == Stella.SYM_STELLA_UNUSED_ITEMS) {
      if (setvalueP) {
        self.unusedItems = value;
      }
      else {
        value = self.unusedItems;
      }
    }
    else if (slotname == Stella.SYM_STELLA_CURRENT_LENGTH) {
      if (setvalueP) {
        self.currentLength = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.currentLength);
      }
    }
    else if (slotname == Stella.SYM_STELLA_ITEM_SIZE) {
      if (setvalueP) {
        self.itemSize = ((IntegerWrapper)(value)).wrapperValue;
      }
      else {
        value = IntegerWrapper.wrapInteger(self.itemSize);
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
    { RecycleList self = this;

      return (Stella.SGT_STELLA_RECYCLE_LIST);
    }
  }

}

