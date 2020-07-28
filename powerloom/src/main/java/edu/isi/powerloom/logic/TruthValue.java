//  -*- Mode: Java -*-
//
// TruthValue.java

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

public class TruthValue extends LogicObject {
    /** One of :TRUE, :FALSE, :UNKNOWN or :INCONSISTENT.
     */
    public Keyword polarity;
    /** Either NULL, :STRICT or :DEFAULT.
     */
    public Keyword strength;
    public double positiveScore;

  public static TruthValue newTruthValue() {
    { TruthValue self = null;

      self = new TruthValue();
      self.dependentPropositionsIndex = null;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.variableValueInverse = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      self.positiveScore = 0.0;
      self.strength = null;
      self.polarity = Logic.KWD_UNKNOWN;
      LogicObject.logLogicObject(self);
      return (self);
    }
  }

  public static void printTruthValue(TruthValue self, OutputStream stream) {
    { String tvString = TruthValue.truthValueToString(self, false);

      if (tvString == null) {
        stream.nativeStream.print("|i|" + self.primaryType());
      }
      else {
        stream.nativeStream.print(tvString);
      }
    }
  }

  public static String truthValueToString(TruthValue self, boolean abbreviateP) {
    if (self == Logic.TRUE_TRUTH_VALUE) {
      return ((abbreviateP ? "T" : "TRUE"));
    }
    else if (self == Logic.FALSE_TRUTH_VALUE) {
      return ((abbreviateP ? "F" : "FALSE"));
    }
    else if (self == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
      return ((abbreviateP ? "t" : "DEFAULT-TRUE"));
    }
    else if (self == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
      return ((abbreviateP ? "f" : "DEFAULT-FALSE"));
    }
    else if (self == Logic.UNKNOWN_TRUTH_VALUE) {
      return ((abbreviateP ? "U" : "UNKNOWN"));
    }
    else if (self == Logic.INCONSISTENT_TRUTH_VALUE) {
      return ((abbreviateP ? "#" : "INCONSISTENT"));
    }
    else {
      return (null);
    }
  }

  /** Return TRUE if <code>self</code> represents INCONSISTENT.
   * @param self
   * @return boolean
   */
  public static boolean inconsistentTruthValueP(TruthValue self) {
    return (self == Logic.INCONSISTENT_TRUTH_VALUE);
  }

  /** Return TRUE if <code>self</code> is a known truth value, that is
   * either TRUE or FALSE, but not UNKNOWN, INCONSISTENT, etc.
   * @param self
   * @return boolean
   */
  public static boolean knownTruthValueP(TruthValue self) {
    return (((self == Logic.TRUE_TRUTH_VALUE) ||
        (self == Logic.DEFAULT_TRUE_TRUTH_VALUE)) ||
        ((self == Logic.FALSE_TRUTH_VALUE) ||
         (self == Logic.DEFAULT_FALSE_TRUTH_VALUE)));
  }

  /** Return TRUE if <code>self</code> represents UNKNOWN.
   * @param self
   * @return boolean
   */
  public static boolean unknownTruthValueP(TruthValue self) {
    return ((self == Logic.UNKNOWN_TRUTH_VALUE) ||
        (self == null));
  }

  /** Return TRUE if <code>self</code> is a default truth value.
   * @param self
   * @return boolean
   */
  public static boolean defaultTruthValueP(TruthValue self) {
    return ((self == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (self == Logic.DEFAULT_FALSE_TRUTH_VALUE));
  }

  /** Return TRUE if <code>self</code> is a strict truth value.
   * @param self
   * @return boolean
   */
  public static boolean strictTruthValueP(TruthValue self) {
    return ((self == Logic.TRUE_TRUTH_VALUE) ||
        (self == Logic.FALSE_TRUTH_VALUE));
  }

  /** Return TRUE if <code>self</code> represents some form of falsehood.
   * @param self
   * @return boolean
   */
  public static boolean falseTruthValueP(TruthValue self) {
    return ((self == Logic.FALSE_TRUTH_VALUE) ||
        (self == Logic.DEFAULT_FALSE_TRUTH_VALUE));
  }

  /** Return TRUE if <code>self</code> represents some form of truth.
   * @param self
   * @return boolean
   */
  public static boolean trueTruthValueP(TruthValue self) {
    return ((self == Logic.TRUE_TRUTH_VALUE) ||
        (self == Logic.DEFAULT_TRUE_TRUTH_VALUE));
  }

  /** If <code>tv2</code> has greater strength than <code>tv1</code>, adapt the strength of <code>tv1</code> (not
   * its value!) and return the result.  Otherwise, return <code>tv1</code> unmodified.
   * @param tv1
   * @param tv2
   * @return TruthValue
   */
  public static TruthValue strengthenTruthValue(TruthValue tv1, TruthValue tv2) {
    if (((tv2 == Logic.TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.FALSE_TRUTH_VALUE)) &&
        ((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
         (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE))) {
      if ((tv1 == Logic.TRUE_TRUTH_VALUE) ||
          (tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
        return (Logic.TRUE_TRUTH_VALUE);
      }
      if ((tv1 == Logic.FALSE_TRUTH_VALUE) ||
          (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
        return (Logic.FALSE_TRUTH_VALUE);
      }
    }
    return (tv1);
  }

  /** If <code>tv2</code> has lesser strength than <code>tv1</code>, adapt the strength of <code>tv1</code> (not
   * its value!) and return the result.  Otherwise, return <code>tv1</code> unmodified.
   * @param tv1
   * @param tv2
   * @return TruthValue
   */
  public static TruthValue weakenTruthValue(TruthValue tv1, TruthValue tv2) {
    if ((tv2 == Logic.UNKNOWN_TRUTH_VALUE) ||
        (tv2 == null)) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if ((tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      if ((tv1 == Logic.TRUE_TRUTH_VALUE) ||
          (tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
        return (Logic.DEFAULT_TRUE_TRUTH_VALUE);
      }
      if ((tv1 == Logic.FALSE_TRUTH_VALUE) ||
          (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
        return (Logic.DEFAULT_FALSE_TRUTH_VALUE);
      }
    }
    return (tv1);
  }

  /** Merge two truth values that are describing the &quot;same&quot; logical
   * proposition.  This handles subordination of default to strict values, 
   * known over unknown and potential inconsistent values.
   * <p>
   * In particular, this can be used to check for negated values by asking for
   * the truth of a proposition and its negation, inverting the negation and then
   * using merge to come up with an answer.
   * @param tv1
   * @param tv2
   * @return TruthValue
   */
  public static TruthValue mergeTruthValues(TruthValue tv1, TruthValue tv2) {
    if (tv1 == tv2) {
      return (tv1);
    }
    else if ((tv1 == Logic.INCONSISTENT_TRUTH_VALUE) ||
        (tv2 == Logic.INCONSISTENT_TRUTH_VALUE)) {
      return (Logic.INCONSISTENT_TRUTH_VALUE);
    }
    else if (((tv1 == Logic.TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.FALSE_TRUTH_VALUE)) &&
        ((tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
         (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE))) {
      return (tv1);
    }
    else if (((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) &&
        ((tv2 == Logic.TRUE_TRUTH_VALUE) ||
         (tv2 == Logic.FALSE_TRUTH_VALUE))) {
      return (tv2);
    }
    else if (TruthValue.knownTruthValueP(tv1) &&
        ((tv2 == Logic.UNKNOWN_TRUTH_VALUE) ||
         (tv2 == null))) {
      return (tv1);
    }
    else if (((tv1 == Logic.UNKNOWN_TRUTH_VALUE) ||
        (tv1 == null)) &&
        TruthValue.knownTruthValueP(tv2)) {
      return (tv2);
    }
    else if (((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) &&
        ((tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
         (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE))) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if (((tv1 == Logic.TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.FALSE_TRUTH_VALUE)) &&
        ((tv2 == Logic.TRUE_TRUTH_VALUE) ||
         (tv2 == Logic.FALSE_TRUTH_VALUE))) {
      return (Logic.INCONSISTENT_TRUTH_VALUE);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Internal Error: MERGE-TRUTH-VALUES: Shouldn't get here. tv1=`" + tv1 + "' tv2=`" + tv2 + "'");
        throw ((LogicException)(LogicException.newLogicException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Compare the two truth values and return <code>true</code> if <code>tv1</code> is strictly
   * stronger than <code>tv2</code>.  Stronger uses the following partial order:
   *   INCONSISTENT &gt; STRICT &gt; DEFAULT &gt; UNKNOWN.
   * Truth values at the same level are equal in strength.
   * @param tv1
   * @param tv2
   * @return boolean
   */
  public static boolean strongerTruthValueP(TruthValue tv1, TruthValue tv2) {
    if (tv1 == tv2) {
      return (false);
    }
    else if (tv1 == Logic.INCONSISTENT_TRUTH_VALUE) {
      return (!(tv2 == Logic.INCONSISTENT_TRUTH_VALUE));
    }
    else if (tv2 == Logic.INCONSISTENT_TRUTH_VALUE) {
      return (false);
    }
    else if ((tv1 == Logic.TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.FALSE_TRUTH_VALUE)) {
      return (!((tv2 == Logic.TRUE_TRUTH_VALUE) ||
          (tv2 == Logic.FALSE_TRUTH_VALUE)));
    }
    else if ((tv2 == Logic.TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.FALSE_TRUTH_VALUE)) {
      return (false);
    }
    else if ((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      return (!((tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
          (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)));
    }
    else if ((tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      return (false);
    }
    else if (((tv1 == Logic.UNKNOWN_TRUTH_VALUE) ||
        (tv1 == null)) &&
        ((tv2 == Logic.UNKNOWN_TRUTH_VALUE) ||
         (tv2 == null))) {
      return (false);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Internal Error: STRONGER-TRUTH-VALUE?: Shouldn't get here. tv1=`" + tv1 + "' tv2=`" + tv2 + "'");
        throw ((LogicException)(LogicException.newLogicException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  /** Return the logical negation of <code>self</code>.
   * @param self
   * @return TruthValue
   */
  public static TruthValue invertTruthValue(TruthValue self) {
    if (self == Logic.TRUE_TRUTH_VALUE) {
      return (Logic.FALSE_TRUTH_VALUE);
    }
    else if (self == Logic.DEFAULT_TRUE_TRUTH_VALUE) {
      return (Logic.DEFAULT_FALSE_TRUTH_VALUE);
    }
    else if (self == Logic.FALSE_TRUTH_VALUE) {
      return (Logic.TRUE_TRUTH_VALUE);
    }
    else if (self == Logic.DEFAULT_FALSE_TRUTH_VALUE) {
      return (Logic.DEFAULT_TRUE_TRUTH_VALUE);
    }
    else if (self == Logic.INCONSISTENT_TRUTH_VALUE) {
      return (Logic.INCONSISTENT_TRUTH_VALUE);
    }
    else {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
  }

  /** Return the logical disjunction of truth values <code>tv1</code> and <code>tv2</code>.
   * @param tv1
   * @param tv2
   * @return TruthValue
   */
  public static TruthValue disjoinTruthValues(TruthValue tv1, TruthValue tv2) {
    if ((tv1 == Logic.TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.TRUE_TRUTH_VALUE)) {
      return (Logic.TRUE_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
      return (Logic.DEFAULT_TRUE_TRUTH_VALUE);
    }
    else if ((tv1 == null) ||
        ((tv1 == Logic.UNKNOWN_TRUTH_VALUE) ||
         ((tv2 == null) ||
          (tv2 == Logic.UNKNOWN_TRUTH_VALUE)))) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      return (Logic.DEFAULT_FALSE_TRUTH_VALUE);
    }
    else {
      return (Logic.FALSE_TRUTH_VALUE);
    }
  }

  /** Return the logical conjunction of truth values <code>tv1</code> and <code>tv2</code>.
   * @param tv1
   * @param tv2
   * @return TruthValue
   */
  public static TruthValue conjoinTruthValues(TruthValue tv1, TruthValue tv2) {
    if ((tv1 == Logic.INCONSISTENT_TRUTH_VALUE) ||
        (tv2 == Logic.INCONSISTENT_TRUTH_VALUE)) {
      return (Logic.INCONSISTENT_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.FALSE_TRUTH_VALUE) ||
        (tv2 == Logic.FALSE_TRUTH_VALUE)) {
      return (Logic.FALSE_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE) &&
        (tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) &&
        (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if ((tv1 == null) ||
        ((tv1 == Logic.UNKNOWN_TRUTH_VALUE) ||
         ((tv2 == null) ||
          (tv2 == Logic.UNKNOWN_TRUTH_VALUE)))) {
      return (Logic.UNKNOWN_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_FALSE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_FALSE_TRUTH_VALUE)) {
      return (Logic.DEFAULT_FALSE_TRUTH_VALUE);
    }
    else if ((tv1 == Logic.DEFAULT_TRUE_TRUTH_VALUE) ||
        (tv2 == Logic.DEFAULT_TRUE_TRUTH_VALUE)) {
      return (Logic.DEFAULT_TRUE_TRUTH_VALUE);
    }
    else {
      return (Logic.TRUE_TRUTH_VALUE);
    }
  }

  public static Stella_Object accessTruthValueSlotValue(TruthValue self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_LOGIC_POLARITY) {
      if (setvalueP) {
        self.polarity = ((Keyword)(value));
      }
      else {
        value = self.polarity;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_STRENGTH) {
      if (setvalueP) {
        self.strength = ((Keyword)(value));
      }
      else {
        value = self.strength;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_POSITIVE_SCORE) {
      if (setvalueP) {
        self.positiveScore = ((FloatWrapper)(value)).wrapperValue;
      }
      else {
        value = FloatWrapper.wrapFloat(self.positiveScore);
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
    { TruthValue self = this;

      return (Logic.SGT_LOGIC_TRUTH_VALUE);
    }
  }

}

