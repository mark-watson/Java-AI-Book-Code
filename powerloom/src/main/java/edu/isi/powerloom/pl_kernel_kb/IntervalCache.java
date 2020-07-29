//  -*- Mode: Java -*-
//
// IntervalCache.java

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

package edu.isi.powerloom.pl_kernel_kb;

import edu.isi.stella.javalib.Native;
import edu.isi.stella.javalib.StellaSpecialVariable;
import edu.isi.powerloom.logic.*;
import edu.isi.stella.*;

public class IntervalCache extends Thing {
    public Context homeContext;
    public LogicObject intervalMember;
    public Stella_Object lowerBound;
    public Stella_Object upperBound;
    public boolean strictLowerBoundP;
    public boolean strictUpperBoundP;

  public static IntervalCache newIntervalCache() {
    { IntervalCache self = null;

      self = new IntervalCache();
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.strictUpperBoundP = false;
      self.strictLowerBoundP = false;
      self.upperBound = null;
      self.lowerBound = null;
      self.intervalMember = null;
      self.homeContext = null;
      return (self);
    }
  }

  public static Stella_Object accessIntervalCacheBounds(IntervalCache intervalcache, Keyword lowerorupper, Object [] MV_returnarray) {
    if (intervalcache == null) {
      { Stella_Object _return_temp = null;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
        return (_return_temp);
      }
    }
    else {
      if (lowerorupper == PlKernelKb.KWD_LOWER_BOUND) {
        { Stella_Object _return_temp = intervalcache.lowerBound;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(intervalcache.strictLowerBoundP);
          return (_return_temp);
        }
      }
      else if (lowerorupper == PlKernelKb.KWD_UPPER_BOUND) {
        { Stella_Object _return_temp = intervalcache.upperBound;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(intervalcache.strictUpperBoundP);
          return (_return_temp);
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + lowerorupper + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static void unifyIntervalCaches(IntervalCache cache1, IntervalCache cache2, Surrogate operator) {
    if ((operator == PlKernelKb.SGT_PL_KERNEL_KB_g) ||
        (operator == Logic.SGT_PL_KERNEL_KB_ge)) {
      cache1.propagateInequalityToIntervalCache(IntervalCache.accessIntervalCacheBounds(cache2, PlKernelKb.KWD_LOWER_BOUND, new Object[1]), operator);
      cache2.propagateInequalityToIntervalCache(IntervalCache.accessIntervalCacheBounds(cache1, PlKernelKb.KWD_UPPER_BOUND, new Object[1]), PlKernelKb.inverseInequalityOperator(operator));
    }
    else if ((operator == PlKernelKb.SGT_PL_KERNEL_KB_l) ||
        (operator == PlKernelKb.SGT_PL_KERNEL_KB_el)) {
      cache1.propagateInequalityToIntervalCache(IntervalCache.accessIntervalCacheBounds(cache2, PlKernelKb.KWD_UPPER_BOUND, new Object[1]), operator);
      cache2.propagateInequalityToIntervalCache(IntervalCache.accessIntervalCacheBounds(cache1, PlKernelKb.KWD_LOWER_BOUND, new Object[1]), PlKernelKb.inverseInequalityOperator(operator));
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + operator + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public void propagateInequalityToIntervalCache(Stella_Object value, Surrogate operator) {
    { IntervalCache self = this;

      if (PlKernelKb.nullLiteralWrapperP(value)) {
        return;
      }
      if (!(Stella_Object.isaP(value, Logic.SGT_STELLA_NUMBER_WRAPPER) ||
          Stella_Object.isaP(value, Logic.SGT_LOGIC_QUANTITY_LOGIC_WRAPPER))) {
        return;
      }
      { boolean tighterintervalP = false;

        try {
          if (operator == PlKernelKb.SGT_PL_KERNEL_KB_g) {
            if ((self.lowerBound == null) ||
                (PlKernelKb.compareIntervalBoundsP(PlKernelKb.SGT_PL_KERNEL_KB_g, value, self.lowerBound) ||
                 (Stella_Object.eqlP(value, self.lowerBound) &&
                  (!self.strictLowerBoundP)))) {
              self.lowerBound = value;
              self.strictLowerBoundP = true;
              tighterintervalP = true;
            }
          }
          else if (operator == Logic.SGT_PL_KERNEL_KB_ge) {
            if ((self.lowerBound == null) ||
                PlKernelKb.compareIntervalBoundsP(PlKernelKb.SGT_PL_KERNEL_KB_g, value, self.lowerBound)) {
              self.lowerBound = value;
              self.strictLowerBoundP = false;
              tighterintervalP = true;
            }
          }
          else if (operator == PlKernelKb.SGT_PL_KERNEL_KB_l) {
            if ((self.upperBound == null) ||
                (PlKernelKb.compareIntervalBoundsP(PlKernelKb.SGT_PL_KERNEL_KB_l, value, self.upperBound) ||
                 ((value == self.upperBound) &&
                  (!self.strictUpperBoundP)))) {
              self.upperBound = value;
              self.strictUpperBoundP = true;
              tighterintervalP = true;
            }
          }
          else if (operator == PlKernelKb.SGT_PL_KERNEL_KB_el) {
            if ((self.upperBound == null) ||
                PlKernelKb.compareIntervalBoundsP(PlKernelKb.SGT_PL_KERNEL_KB_l, value, self.upperBound)) {
              self.upperBound = value;
              self.strictUpperBoundP = false;
              tighterintervalP = true;
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + operator + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        } catch (IncompatibleQuantityException e000) {
          IntervalCache.signalIntervalClash(self);
        }
        if (tighterintervalP) {
          self.evaluateTighterInterval();
        }
      }
    }
  }

  public void evaluateTighterInterval() {
    { IntervalCache interval = this;

      if ((interval.lowerBound != null) &&
          (interval.upperBound != null)) {
        if (Stella_Object.eqlP(interval.lowerBound, interval.upperBound)) {
          if (interval.strictLowerBoundP ||
              interval.strictUpperBoundP) {
            IntervalCache.signalIntervalClash(interval);
          }
          else {
            Proposition.equateValues(null, interval.intervalMember, interval.lowerBound);
          }
        }
        else {
          try {
            if (PlKernelKb.compareIntervalBoundsP(PlKernelKb.SGT_PL_KERNEL_KB_g, interval.lowerBound, interval.upperBound)) {
              IntervalCache.signalIntervalClash(interval);
            }
            if (interval.integerValuedMemberP()) {
              interval.evaluateTighterIntegerInterval();
            }
          } catch (IncompatibleQuantityException e000) {
            IntervalCache.signalIntervalClash(interval);
          }
        }
      }
      PlKernelKb.evaluateAdjacentInequalities(interval.intervalMember);
    }
  }

  public void evaluateTighterIntegerInterval() {
    { IntervalCache interval = this;

      { IntegerWrapper lb = interval.integerLowerBound();
        IntegerWrapper ub = interval.integerUpperBound();

        if ((lb != null) &&
            ((ub != null) &&
             Stella_Object.eqlP(lb, ub))) {
          Proposition.equateValues(null, interval.intervalMember, lb);
        }
      }
    }
  }

  public IntegerWrapper integerUpperBound() {
    { IntervalCache interval = this;

      { Stella_Object ub = interval.upperBound;

        if (ub != null) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(ub);

            if (Surrogate.subtypeOfIntegerP(testValue000)) {
              { IntegerWrapper ub000 = ((IntegerWrapper)(ub));

                if (interval.strictUpperBoundP) {
                  return (IntegerWrapper.wrapInteger(IntegerWrapper.unwrapInteger(ub000) - 1));
                }
                else {
                  return (ub000);
                }
              }
            }
            else if (Surrogate.subtypeOfFloatP(testValue000)) {
              { FloatWrapper ub000 = ((FloatWrapper)(ub));

                if (interval.strictUpperBoundP) {
                  if (Stella.integerValuedP(FloatWrapper.unwrapFloat(ub000))) {
                    return (IntegerWrapper.wrapInteger(Native.floor(FloatWrapper.unwrapFloat(ub000)) - 1));
                  }
                  else {
                    return (IntegerWrapper.wrapInteger(Native.floor(FloatWrapper.unwrapFloat(ub000))));
                  }
                }
                else {
                  return (IntegerWrapper.wrapInteger(Native.floor(FloatWrapper.unwrapFloat(ub000))));
                }
              }
            }
            else {
              return (null);
            }
          }
        }
        return (null);
      }
    }
  }

  public IntegerWrapper integerLowerBound() {
    { IntervalCache interval = this;

      { Stella_Object lb = interval.lowerBound;

        if (lb != null) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(lb);

            if (Surrogate.subtypeOfIntegerP(testValue000)) {
              { IntegerWrapper lb000 = ((IntegerWrapper)(lb));

                if (interval.strictLowerBoundP) {
                  return (IntegerWrapper.wrapInteger(IntegerWrapper.unwrapInteger(lb000) + 1));
                }
                else {
                  return (lb000);
                }
              }
            }
            else if (Surrogate.subtypeOfFloatP(testValue000)) {
              { FloatWrapper lb000 = ((FloatWrapper)(lb));

                if (interval.strictLowerBoundP) {
                  if (Stella.integerValuedP(FloatWrapper.unwrapFloat(lb000))) {
                    return (IntegerWrapper.wrapInteger(Native.floor(FloatWrapper.unwrapFloat(lb000)) + 1));
                  }
                  else {
                    return (IntegerWrapper.wrapInteger(Native.ceiling(FloatWrapper.unwrapFloat(lb000))));
                  }
                }
                else {
                  return (IntegerWrapper.wrapInteger(Native.ceiling(FloatWrapper.unwrapFloat(lb000))));
                }
              }
            }
            else {
              return (null);
            }
          }
        }
        return (null);
      }
    }
  }

  public boolean integerValuedMemberP() {
    { IntervalCache interval = this;

      { LogicObject member = interval.intervalMember;

        return (Stella_Object.isaP(member, Logic.SGT_LOGIC_SKOLEM) &&
            Surrogate.subtypeOfP(((Skolem)(member)).skolemType, Logic.SGT_STELLA_INTEGER));
      }
    }
  }

  public static void signalIntervalClash(IntervalCache interval) {
    interval.intervalMember.markAsIncoherent();
    { String message000 = null;

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          message000 = "Clash in interval values " + "`" + Native.stringify(interval) + "'" + "\n";

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      { String message = message000;
        IntervalClash clash = IntervalClash.newIntervalClash(message);

        clash.context = ((Context)(Stella.$CONTEXT$.get()));
        clash.intervalMember = interval.intervalMember;
        clash.lowerBound = interval.lowerBound;
        clash.upperBound = interval.upperBound;
        clash.strictLowerBoundP = interval.strictLowerBoundP;
        clash.strictUpperBoundP = interval.strictUpperBoundP;
        throw ((IntervalClash)(clash.fillInStackTrace()));
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { IntervalCache self = this;

      {
        stream.print("|cache-of: " + self.intervalMember + " ");
        PlKernelKb.printInterval(stream, self.lowerBound, self.strictLowerBoundP, self.upperBound, self.strictUpperBoundP);
        stream.print("|");
      }
    }
  }

  public static Stella_Object accessIntervalCacheSlotValue(IntervalCache self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_HOME_CONTEXT) {
      if (setvalueP) {
        self.homeContext = ((Context)(value));
      }
      else {
        value = self.homeContext;
      }
    }
    else if (slotname == PlKernelKb.SYM_LOGIC_INTERVAL_MEMBER) {
      if (setvalueP) {
        self.intervalMember = ((LogicObject)(value));
      }
      else {
        value = self.intervalMember;
      }
    }
    else if (slotname == PlKernelKb.SYM_STELLA_LOWER_BOUND) {
      if (setvalueP) {
        self.lowerBound = value;
      }
      else {
        value = self.lowerBound;
      }
    }
    else if (slotname == PlKernelKb.SYM_STELLA_UPPER_BOUND) {
      if (setvalueP) {
        self.upperBound = value;
      }
      else {
        value = self.upperBound;
      }
    }
    else if (slotname == PlKernelKb.SYM_LOGIC_STRICT_LOWER_BOUNDp) {
      if (setvalueP) {
        self.strictLowerBoundP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.strictLowerBoundP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
      }
    }
    else if (slotname == PlKernelKb.SYM_LOGIC_STRICT_UPPER_BOUNDp) {
      if (setvalueP) {
        self.strictUpperBoundP = BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(value)));
      }
      else {
        value = (self.strictUpperBoundP ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER);
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
    { IntervalCache self = this;

      return (Logic.SGT_PL_KERNEL_KB_INTERVAL_CACHE);
    }
  }

}

