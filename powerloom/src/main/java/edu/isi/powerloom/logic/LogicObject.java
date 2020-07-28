//  -*- Mode: Java -*-
//
// LogicObject.java

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

/** Object with propositions, and possibly a variable value.
 * @author Stella Java Translator
 */
public class LogicObject extends ContextSensitiveObject {
    public Stella_Object variableValueInverse;
    public Surrogate surrogateValueInverse;
    public KeyValueList dynamicSlots;
    public BacklinksIndex dependentPropositionsIndex;

  public static LogicObject newLogicObject() {
    { LogicObject self = null;

      self = new LogicObject();
      self.dependentPropositionsIndex = null;
      self.dynamicSlots = KeyValueList.newKeyValueList();
      self.surrogateValueInverse = null;
      self.variableValueInverse = null;
      self.homeContext = ((Module)(Stella.$MODULE$.get()));
      LogicObject.logLogicObject(self);
      return (self);
    }
  }

  public static boolean filterInstanceP(LogicObject self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (!Stella_Object.isaP(self, Logic.SGT_LOGIC_DESCRIPTION));
  }

  public static boolean visibleTermP(LogicObject term, Context context, boolean localP) {
    return ((localP ? (term.homeContext == context) : Context.visibleFromP(term.homeContext, context)));
  }

  /** Return a set of the most specific types for fillers
   * of the slot 'relation' applied to 'self'.
   * @param self
   * @param relation
   * @return Cons
   */
  public static Cons allSlotValueTypes(LogicObject self, Surrogate relation) {
    return (Logic.mostSpecificNamedDescriptions(Logic.currentInferenceLevel().levellizedAllSlotValueTypes(self, relation)));
  }

  /** Return a most specific type for fillers of the slot 'relation'
   * (a surrogate) applied to 'self'. If there is more than one, pick one.
   * @param self
   * @param relation
   * @return NamedDescription
   */
  public static NamedDescription getSlotValueType(LogicObject self, Surrogate relation) {
    return (((NamedDescription)(LogicObject.allSlotValueTypes(self, relation).value)));
  }

  /** Return a maximum value for the number of fillers of relation
   * 'relation' (a surrogate) applied to the instance 'self' (an object).
   * @param self
   * @param relation
   * @return int
   */
  public static int getSlotMaximumCardinality(LogicObject self, Surrogate relation) {
    return (Logic.currentInferenceLevel().levellizedGetSlotMaximumCardinality(self, relation));
  }

  /** Return a minimum value for the number of fillers of relation
   * 'relation' (a surrogate) applied to the instance 'self' (an object).
   * @param self
   * @param relation
   * @return int
   */
  public static int getSlotMinimumCardinality(LogicObject self, Surrogate relation) {
    return (Logic.currentInferenceLevel().levellizedGetSlotMinimumCardinality(self, relation));
  }

  /** Return TRUE if the proposition '(&lt;relation&gt; &lt;self&gt; &lt;filler&gt;)'
   * is true.
   * @param self
   * @param relation
   * @param filler
   * @return boolean
   */
  public static boolean testSlotValueP(LogicObject self, Surrogate relation, Stella_Object filler) {
    return (Logic.testRelationOnArgumentsP(relation, Cons.consList(Cons.cons(self, Cons.cons(filler, Stella.NIL)))));
  }

  /** Return a single value for the slot 'relation' (a surrogate)
   * applied to 'self' (an object).
   * @param self
   * @param relation
   * @return Stella_Object
   */
  public static Stella_Object getSlotValue(LogicObject self, Surrogate relation) {
    return (LogicObject.allSlotValues(self, relation).value);
  }

  /** Return a set of values for the slot 'relation' (a surrogate)
   * applied to 'self' (an object).
   * @param self
   * @param relation
   * @return Cons
   */
  public static Cons allSlotValues(LogicObject self, Surrogate relation) {
    return (Logic.allRelationValues(relation, Cons.consList(Cons.cons(self, Stella.NIL))));
  }

  public void processDefinitionOptions(Stella_Object options) {
    { LogicObject self = this;

      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = Stella_Object.vetOptions(options, null).thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          if (!Stella_Object.runOptionHandlerP(self, ((Keyword)(key)), value)) {
            Logic.definitionKeywordAxiomsHandler(self, Logic.objectName(self), ((Keyword)(key)), value);
          }
        }
      }
    }
  }

  public static Cons allEquivalentCollections(LogicObject self, boolean reflexiveP) {
    { Cons equivalents = Cons.consList(Cons.cons(self, Stella.NIL));
      List unscannedequivalents = List.list(Cons.cons(self, Stella.NIL));
      LogicObject u = null;

      if (LogicObject.allSupercollections(self).memberP(self)) {
        loop000 : for (;;) {
          u = ((LogicObject)(unscannedequivalents.pop()));
          { LogicObject parent = null;
            Iterator iter000 = LogicObject.allDirectSupercollections(u, false);

            while (iter000.nextP()) {
              parent = ((LogicObject)(iter000.value));
              if ((!equivalents.memberP(parent)) &&
                  LogicObject.allSupercollections(parent).memberP(u)) {
                equivalents = Cons.cons(parent, equivalents);
                unscannedequivalents.push(parent);
              }
            }
          }
          if (unscannedequivalents.emptyP()) {
            break loop000;
          }
        }
      }
      if (reflexiveP) {
        return (equivalents);
      }
      else {
        return (equivalents.remove(self));
      }
    }
  }

  public static void downclassifyOneDescription(LogicObject self) {
    { Object old$Classificationsession$000 = Logic.$CLASSIFICATIONSESSION$.get();

      try {
        Native.setSpecial(Logic.$CLASSIFICATIONSESSION$, Logic.getClassificationSession(Logic.KWD_DESCRIPTION));
        if (!LogicObject.downclassifiedP(self)) {
          if (Description.nonInferableP(((Description)(self)))) {
            LogicObject.refreshDownclassificationTimestamp(self);
            return;
          }
          if ((Stella.$TRACED_KEYWORDS$ != null) &&
              (Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER) ||
               Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER_PROFILE))) {
            Stella.STANDARD_OUTPUT.nativeStream.println("DOWNCLASSIFY-ONE-DESCRIPTION:  " + self);
          }
          Logic.emitThinkingDot(Logic.KWD_DOWNCLASSIFY);
          { MarkerTable alreadyvisitedtable = Logic.createMarkerStorage(false);
            Cons parents = Description.allNamedDirectSuperdescriptions(((Description)(self)), false);
            LogicObject bestparent = Logic.chooseBestDownclassifiedParent(parents);
            Cons otherparents = parents.remove(bestparent);

            alreadyvisitedtable.setMarker(self);
            if (bestparent != null) {
              { NamedDescription child = null;
                Cons iter000 = Description.allNamedDirectSubdescriptions(((Description)(bestparent)));

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  child = ((NamedDescription)(iter000.value));
                  LogicObject.helpDownclassifyOneDescription(child, self, otherparents, alreadyvisitedtable);
                }
              }
            }
          }
          LogicObject.refreshDownclassificationTimestamp(self);
        }

      } finally {
        Logic.$CLASSIFICATIONSESSION$.set(old$Classificationsession$000);
      }
    }
  }

  public static void helpDownclassifyOneDescription(LogicObject node, LogicObject self, Cons necessaryancestors, MarkerTable alreadyvisitedtable) {
    if (alreadyvisitedtable.testMarkerP(node) ||
        LogicObject.collectionImpliesCollectionP(((Description)(node)), ((Description)(self)))) {
      return;
    }
    alreadyvisitedtable.setMarker(node);
    { boolean nodecouldbetheoneP = true;

      if (Logic.upclassificationTimestamp(node) == -1) {
        LogicObject.upclassifyOneDescription(node);
      }
      else if (!LogicObject.upclassifiedLaterThanP(node, self)) {
        { boolean foundP000 = false;

          { LogicObject ancestor = null;
            Cons iter000 = necessaryancestors;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              ancestor = ((LogicObject)(iter000.value));
              if (LogicObject.upclassifiedLaterThanP(node, ancestor) &&
                  (!LogicObject.collectionImpliesCollectionP(((Description)(node)), ((Description)(ancestor))))) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          if (foundP000) {
            nodecouldbetheoneP = false;
          }
          else {
            LogicObject.upclassifyOneDescription(node);
          }
        }
      }
      if (nodecouldbetheoneP &&
          LogicObject.collectionImpliesCollectionP(((Description)(node)), ((Description)(self)))) {
        return;
      }
      { NamedDescription subnode = null;
        Cons iter001 = Description.allNamedDirectSubdescriptions(((Description)(node)));

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          subnode = ((NamedDescription)(iter001.value));
          LogicObject.helpDownclassifyOneDescription(subnode, self, necessaryancestors, alreadyvisitedtable);
        }
      }
    }
  }

  public static void upclassifyOneDescription(LogicObject self) {
    if (Logic.upclassifiedP(self) ||
        (!Stella_Object.isaP(self, Logic.SGT_LOGIC_DESCRIPTION))) {
      return;
    }
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        (Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER) ||
         Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER_PROFILE))) {
      Stella.STANDARD_OUTPUT.nativeStream.println("UPCLASSIFY: " + self);
    }
    Logic.emitThinkingDot(Logic.KWD_UPCLASSIFY);
    { Cons equivalents = LogicObject.allEquivalentCollections(self, true);

      { LogicObject e = null;
        Cons iter000 = equivalents;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          e = ((LogicObject)(iter000.value));
          if (!Description.namedDescriptionP(((Description)(e)))) {
            { Description pd = null;
              Cons iter001 = Description.allIntensionalParents(((Description)(e))).theConsList;

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                pd = ((Description)(iter001.value));
                Description.addSubsumptionLink(((Description)(self)), pd);
              }
            }
          }
        }
      }
    }
    { NamedDescription renamed_Super = null;
      Cons iter002 = Description.allNamedDirectSuperdescriptions(((Description)(self)), true);

      for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
        renamed_Super = ((NamedDescription)(iter002.value));
        LogicObject.upclassifyOneDescription(renamed_Super);
      }
    }
    LogicObject.helpUpclassifyOneEntity(self, Logic.KWD_DESCRIPTION);
  }

  public static void upclassifyOneInstance(LogicObject self) {
    if (Logic.upclassifiedP(self)) {
      return;
    }
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        (Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER) ||
         Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER_PROFILE))) {
      Stella.STANDARD_OUTPUT.nativeStream.println("UPCLASSIFY:  " + self);
    }
    Logic.emitThinkingDot(Logic.KWD_UPCLASSIFY);
    LogicObject.helpUpclassifyOneEntity(self, Logic.KWD_INSTANCE);
  }

  public static void helpUpclassifyOneEntity(LogicObject self, Keyword instanceordescription) {
    if (Logic.upclassifiedP(self)) {
      return;
    }
    { MarkerTable alreadyvisitedtable = Logic.createMarkerStorage(false);
      MarkerTable instanceisbelowtable = Logic.createMarkerStorage(false);
      List newparentdescriptions = List.newList();

      instanceisbelowtable.setMarker(self);
      { LogicObject renamed_Super = null;
        Iterator iter000 = Logic.allAncestorCollections(self, instanceordescription);

        while (iter000.nextP()) {
          renamed_Super = ((LogicObject)(iter000.value));
          instanceisbelowtable.setMarker(renamed_Super);
        }
      }
      if ((Stella.$TRACED_KEYWORDS$ != null) &&
          Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER)) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println("   WORLD: " + ((Context)(Stella.$CONTEXT$.get())) + "  self: " + self);
          Stella.STANDARD_OUTPUT.nativeStream.println("   ANCESTORS: " + Logic.allAncestorCollections(self, instanceordescription).consify());
        }
;
      }
      { LogicObject renamed_Super = null;
        Iterator iter001 = Logic.allAncestorCollections(self, instanceordescription);

        while (iter001.nextP()) {
          renamed_Super = ((LogicObject)(iter001.value));
          if (Stella_Object.isaP(renamed_Super, Logic.SGT_LOGIC_DESCRIPTION) &&
              (((!((Boolean)(Logic.$CLASSIFY_FROM_NON_INFERABLE_PARENTS_ONLYp$.get())).booleanValue()) ||
              Description.nonInferableP(((Description)(renamed_Super)))) &&
               (!alreadyvisitedtable.testMarkerP(renamed_Super)))) {
            alreadyvisitedtable.setMarker(renamed_Super);
            LogicObject.collectSubsumingParentsBelow(self, ((Description)(renamed_Super)), newparentdescriptions, alreadyvisitedtable, instanceisbelowtable, ((instanceordescription == Logic.KWD_INSTANCE) ? Native.find_java_method("edu.isi.powerloom.logic.Logic", "instanceSatisfiesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.powerloom.logic.Description")}) : Native.find_java_method("edu.isi.powerloom.logic.Description", "descriptionSpecializesDescriptionP", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.Description"), Native.find_java_class("edu.isi.powerloom.logic.Description")})));
          }
        }
      }
      { LogicObject pd = null;
        Cons iter002 = Logic.mostSpecificNamedCollections(newparentdescriptions.theConsList);

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          pd = ((LogicObject)(iter002.value));
          if (instanceordescription == Logic.KWD_INSTANCE) {
            LogicObject.addIsaLink(self, ((Description)(pd)));
          }
          else if (instanceordescription == Logic.KWD_DESCRIPTION) {
            Description.addSubsumptionLink(((Description)(self)), ((Description)(pd)));
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + instanceordescription + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      Logic.refreshUpclassificationTimestamp(self);
    }
  }

  public static void collectSubsumingParentsBelow(LogicObject self, Description renamed_Super, List newparentdescriptions, MarkerTable alreadyvisitedtable, MarkerTable selfisbelowtable, java.lang.reflect.Method subsumptiontest) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("COLLECT-SUBSUMING  self= " + self + "    super= " + renamed_Super);
    }
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("   ALL-INFERABLE-SUBS:  " + Cons.consList(Cons.cons(LogicObject.allInferableDirectSubcollections(renamed_Super).listify(), Stella.NIL)));
    }
    { Object old$ReversepolarityP$000 = Logic.$REVERSEPOLARITYp$.get();

      try {
        Native.setBooleanSpecial(Logic.$REVERSEPOLARITYp$, false);
        { Description sub = null;
          Cons iter000 = LogicObject.allInferableDirectSubcollections(renamed_Super).theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            sub = ((Description)(iter000.value));
            if (!alreadyvisitedtable.testMarkerP(sub)) {
              LogicObject.helpCollectParentsBelowP(self, sub, newparentdescriptions, alreadyvisitedtable, selfisbelowtable, subsumptiontest);
            }
          }
        }

      } finally {
        Logic.$REVERSEPOLARITYp$.set(old$ReversepolarityP$000);
      }
    }
  }

  public static boolean helpCollectParentsBelowP(LogicObject self, Description renamed_Super, List newparentdescriptions, MarkerTable alreadyvisitedtable, MarkerTable selfisbelowtable, java.lang.reflect.Method subsumptiontest) {
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("HELP-COLLECT-PARENTS-BELOW  self= " + self + "    super= " + renamed_Super);
    }
    if ((Stella.$TRACED_KEYWORDS$ != null) &&
        Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER)) {
      Stella.STANDARD_OUTPUT.nativeStream.println("   TEST-MARKER of 'super': " + selfisbelowtable.testMarkerP(renamed_Super));
    }
    { boolean foundsubsumingsubP = false;

      alreadyvisitedtable.setMarker(renamed_Super);
      if (selfisbelowtable.testMarkerP(renamed_Super)) {
        foundsubsumingsubP = true;
        { Description sub = null;
          Cons iter000 = LogicObject.allInferableDirectSubcollections(renamed_Super).theConsList;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            sub = ((Description)(iter000.value));
            if (!alreadyvisitedtable.testMarkerP(sub)) {
              LogicObject.helpCollectParentsBelowP(self, sub, newparentdescriptions, alreadyvisitedtable, selfisbelowtable, subsumptiontest);
            }
          }
        }
      }
      else if ((!LogicObject.upclassifiedLaterThanP(self, renamed_Super)) &&
          Logic.applySubsumptionTestP(subsumptiontest, self, renamed_Super)) {
        foundsubsumingsubP = true;
        Description.markUnmarkedSuperrelations(renamed_Super, selfisbelowtable);
        { boolean foundP000 = false;

          { Description sub = null;
            Cons iter001 = LogicObject.allInferableDirectSubcollections(renamed_Super).theConsList;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              sub = ((Description)(iter001.value));
              if ((!alreadyvisitedtable.testMarkerP(sub)) &&
                  LogicObject.helpCollectParentsBelowP(self, sub, newparentdescriptions, alreadyvisitedtable, selfisbelowtable, subsumptiontest)) {
                foundP000 = true;
                break loop001;
              }
            }
          }
          { boolean existsmorespecificsubP = foundP000;

            if (!existsmorespecificsubP) {
              if ((Stella.$TRACED_KEYWORDS$ != null) &&
                  (Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER) ||
                   Stella.$TRACED_KEYWORDS$.membP(Logic.KWD_CLASSIFIER_PROFILE))) {
                {
                  Stella.STANDARD_OUTPUT.nativeStream.println();
                  Stella.STANDARD_OUTPUT.nativeStream.println("XXXXXXX PUSHING NEW PARENT: " + renamed_Super + "  of " + self);
                  Stella.STANDARD_OUTPUT.nativeStream.println();
                }
;
              }
              newparentdescriptions.push(renamed_Super);
            }
          }
        }
      }
      else {
      }
      return (foundsubsumingsubP);
    }
  }

  public static boolean downclassifiedP(LogicObject self) {
    return (Description.nonInferableP(((Description)(self))) ||
        (LogicObject.downclassificationTimestamp(self) > Logic.youngestIntroductionTimestamp()));
  }

  public static boolean upclassifiedLaterThanP(LogicObject self, LogicObject other) {
    return (Logic.upclassificationTimestamp(self) > other.introductionTimestamp());
  }

  public static void refreshDownclassificationTimestamp(LogicObject self) {
    Logic.getClassificationCache(self).cacheDownclassificationTimestamp = Logic.bumpClassificationTimeclock();
  }

  public static int downclassificationTimestamp(LogicObject self) {
    return (Logic.getClassificationCache(self).cacheDownclassificationTimestamp);
  }

  public int introductionTimestamp() {
    { LogicObject self = this;

      return (Logic.getClassificationCache(self).introductionTimestamp);
    }
  }

  public static List allInferableDirectSubcollections(LogicObject self) {
    { ClassificationCache cache = Logic.getClassificationCache(self);
      List list = cache.inferableDirectSubdescriptions;

      if ((list == null) ||
          (!Logic.$CACHE_INFERABLE_SUBCOLLECTIONSp$)) {
        list = List.newList();
        { NamedDescription sub = null;
          Cons iter000 = Description.allNamedDirectSubdescriptions(((Description)(self)));

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            sub = ((NamedDescription)(iter000.value));
            if (Description.inferableP(sub)) {
              list.insert(sub);
            }
          }
        }
        cache.inferableDirectSubdescriptions = list;
      }
      return (list);
    }
  }

  public static boolean namedCollectionP(LogicObject self) {
    return ((self.surrogateValueInverse != null) ||
        (self == ((Description)(Logic.$FINDSUPERSANDSUBSDESCRIPTION$.get()))));
  }

  public static void addIsaLink(LogicObject instance, Description superdescription) {
    { Proposition isaprop = Logic.assertIsaProposition(instance, superdescription.surrogateValueInverse);

      KeyValueList.setDynamicSlotValue(isaprop.dynamicSlots, Logic.SYM_LOGIC_SUBSUMPTION_LINKp, Stella.TRUE_WRAPPER, Stella.FALSE_WRAPPER);
      if (Stella_Object.traceKeywordP(Logic.KWD_CLASSIFIER_INFERENCES)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            if (Logic.$EMIT_THINKING_DOTSp$) {
              Stella.STANDARD_OUTPUT.nativeStream.println();
            }
            Stella.STANDARD_OUTPUT.nativeStream.println("Recognized type: " + isaprop);

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
    }
  }

  public static void logicObjectDinheritUnnamedDescription(LogicObject instance, Description description, boolean defaulttrueP) {
    { Vector vector = Vector.newVector(1);

      (vector.theArray)[0] = instance;
      Logic.inheritUnnamedDescription(vector, description, defaulttrueP);
    }
  }

  public static Cons helpAllSupportedNamedSubcollections(LogicObject self) {
    { Cons subcollections = Stella.NIL;
      SupportedClosureIterator closureiterator = Logic.allocateSupportedClosureIterator(Cons.cons(self, Cons.cons(Logic.TRUE_TRUTH_VALUE, Stella.NIL)), Native.find_java_method("edu.isi.powerloom.logic.Logic", "allDirectlyLinkedSubcollections", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object")}), null);

      { Cons sub = null;
        SupportedClosureIterator iter000 = closureiterator;
        Cons collect000 = null;

        while (iter000.nextP()) {
          sub = ((Cons)(iter000.value));
          if (Stella_Object.isaP(sub.value, Logic.SGT_LOGIC_NAMED_DESCRIPTION) &&
              (!(sub.value == self))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(sub, Stella.NIL);
                if (subcollections == Stella.NIL) {
                  subcollections = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(subcollections, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(sub, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (subcollections);
    }
  }

  public static Cons allSupportedNamedSubcollections(LogicObject self) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_ALL_SUPPORTED_NAMED_SUBCOLLECTIONS_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_ALL_SUPPORTED_NAMED_SUBCOLLECTIONS_MEMO_TABLE_000, "(:MAX-VALUES 1000 :TIMESTAMPS (:META-KB-UPDATE))");
          memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_ALL_SUPPORTED_NAMED_SUBCOLLECTIONS_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), self, ((!((Boolean)(Logic.$DONTUSEDEFAULTKNOWLEDGEp$.get())).booleanValue()) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = LogicObject.helpAllSupportedNamedSubcollections(self);
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Cons value000 = ((Cons)(memoizedValue000));

        return (value000);
      }
    }
  }

  public static Iterator allSubcollections(LogicObject self) {
    return (Logic.allocateTransitiveClosureIterator(self, Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSubcollectionsWithEquivalents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null));
  }

  public static Iterator allSupercollections(LogicObject self) {
    { MemoizationTable memoTable000 = null;
      Cons memoizedEntry000 = null;
      Stella_Object memoizedValue000 = null;

      if (Stella.$MEMOIZATION_ENABLEDp$) {
        memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_ALL_SUPERCOLLECTIONS_MEMO_TABLE_000.surrogateValue));
        if (memoTable000 == null) {
          Surrogate.initializeMemoizationTable(Logic.SGT_LOGIC_F_ALL_SUPERCOLLECTIONS_MEMO_TABLE_000, "(:MAX-VALUES 1000 :TIMESTAMPS (:META-KB-UPDATE))");
          memoTable000 = ((MemoizationTable)(Logic.SGT_LOGIC_F_ALL_SUPERCOLLECTIONS_MEMO_TABLE_000.surrogateValue));
        }
        memoizedEntry000 = MruMemoizationTable.lookupMruMemoizedValue(((MruMemoizationTable)(memoTable000)), self, ((Context)(Stella.$CONTEXT$.get())), (((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue() ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), Stella.MEMOIZED_NULL_VALUE, -1);
        memoizedValue000 = memoizedEntry000.value;
      }
      if (memoizedValue000 != null) {
        if (memoizedValue000 == Stella.MEMOIZED_NULL_VALUE) {
          memoizedValue000 = null;
        }
      }
      else {
        memoizedValue000 = MemoizableIterator.newMemoizableIterator(Logic.allocateTransitiveClosureIterator(self, Native.find_java_method("edu.isi.powerloom.logic.LogicObject", "allDirectSupercollectionsWithEquivalents", new java.lang.Class [] {Native.find_java_class("edu.isi.powerloom.logic.LogicObject")}), null));
        if (Stella.$MEMOIZATION_ENABLEDp$) {
          memoizedEntry000.value = ((memoizedValue000 == null) ? Stella.MEMOIZED_NULL_VALUE : memoizedValue000);
        }
      }
      { Iterator value000 = MemoizableIterator.cloneMemoizedIterator(((MemoizableIterator)(memoizedValue000)));

        return (((Iterator)(value000)));
      }
    }
  }

  public static Iterator allDirectSubcollectionsWithEquivalents(LogicObject self) {
    return (LogicObject.allDirectSubcollections(self, false));
  }

  public static Iterator allDirectSubcollections(LogicObject self, boolean performfilteringP) {
    if (Stella_Object.isaP(self, Logic.SGT_LOGIC_DESCRIPTION)) {
      Description.deriveDeferredSatelliteRules(((Description)(self)));
    }
    { Iterator directlylinkedobjects = Logic.allDirectlyLinkedObjects(self, Logic.SGT_PL_KERNEL_KB_SUBSET_OF, !((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue());

      if (!performfilteringP) {
        return (directlylinkedobjects);
      }
      { Cons directsubs = Stella.NIL;
        Cons equivalents = LogicObject.allEquivalentCollections(self, true);

        if (!(equivalents.rest == Stella.NIL)) {
          { LogicObject e = null;
            Cons iter000 = equivalents;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              e = ((LogicObject)(iter000.value));
              { LogicObject child = null;
                Iterator iter001 = LogicObject.allDirectSubcollections(e, false);

                while (iter001.nextP()) {
                  child = ((LogicObject)(iter001.value));
                  if ((!equivalents.memberP(child)) &&
                      (!directsubs.memberP(child))) {
                    directsubs = Cons.cons(child, directsubs);
                  }
                }
              }
            }
          }
        }
        else {
          directsubs = ((Cons)(directlylinkedobjects.consify()));
        }
        return (Logic.mostGeneralCollections(directsubs).allocateIterator());
      }
    }
  }

  public static Iterator allDirectSupercollectionsWithEquivalents(LogicObject self) {
    return (LogicObject.allDirectSupercollections(self, false));
  }

  public static Iterator allDirectSupercollections(LogicObject self, boolean performfilteringP) {
    if (Stella_Object.isaP(self, Logic.SGT_LOGIC_DESCRIPTION)) {
      Description.deriveDeferredSatelliteRules(((Description)(self)));
    }
    { Iterator directlylinkedobjects = Logic.allDirectlyLinkedObjects(self, Logic.SGT_PL_KERNEL_KB_SUBSET_OF, ((Boolean)(Logic.$REVERSEPOLARITYp$.get())).booleanValue());

      if (!performfilteringP) {
        return (directlylinkedobjects);
      }
      { Cons directsupers = Stella.NIL;
        Cons equivalents = LogicObject.allEquivalentCollections(self, true);

        if (!(equivalents.rest == Stella.NIL)) {
          { LogicObject e = null;
            Cons iter000 = equivalents;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              e = ((LogicObject)(iter000.value));
              { LogicObject parent = null;
                Iterator iter001 = LogicObject.allDirectSupercollections(e, false);

                while (iter001.nextP()) {
                  parent = ((LogicObject)(iter001.value));
                  if ((!equivalents.memberP(parent)) &&
                      (!directsupers.memberP(parent))) {
                    directsupers = Cons.cons(parent, directsupers);
                  }
                }
              }
            }
          }
        }
        else {
          directsupers = ((Cons)(directlylinkedobjects.consify()));
        }
        return (Logic.mostSpecificCollections(directsupers).allocateIterator());
      }
    }
  }

  public static boolean expensiveEmptyTermP(LogicObject self) {
    { LogicObject super1 = null;
      Iterator iter000 = LogicObject.allDirectSupercollections(self, false);

      while (iter000.nextP()) {
        super1 = ((LogicObject)(iter000.value));
        { LogicObject super2 = null;
          Iterator iter001 = LogicObject.allDirectSupercollections(self, false);

          while (iter001.nextP()) {
            super2 = ((LogicObject)(iter001.value));
            if ((!(super1 == super2)) &&
                Description.disjointTermsP(((Description)(super1)), ((Description)(super2)))) {
              return (true);
            }
          }
        }
      }
    }
    return (false);
  }

  public static boolean cheapEmptyTermP(LogicObject self) {
    if (Logic.skolemP(self)) {
      { Proposition definingproposition = ((Skolem)(self)).definingProposition;

        if ((definingproposition != null) &&
            (Proposition.collectionofPropositionP(definingproposition) &&
             (definingproposition.arguments.length() == 1))) {
          return (true);
        }
      }
    }
    { boolean testValue000 = false;

      if (Logic.testPropertyP(self, Logic.SGT_PL_KERNEL_KB_EMPTY)) {
        testValue000 = true;
      }
      else {
        { boolean foundP000 = false;

          { LogicObject renamed_Super = null;
            Iterator iter000 = LogicObject.allDirectSupercollections(self, false);

            loop000 : while (iter000.nextP()) {
              renamed_Super = ((LogicObject)(iter000.value));
              if (LogicObject.cheapEmptyTermP(renamed_Super)) {
                foundP000 = true;
                break loop000;
              }
            }
          }
          testValue000 = foundP000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  public static boolean derivePartitionMembershipsP(LogicObject self) {
    { List tuples = List.list(Stella.NIL);

      LogicObject.helpDerivePartitionMemberships(self, self, tuples);
      { LogicObject renamed_Super = null;
        Iterator iter000 = LogicObject.allSupercollections(self);

        while (iter000.nextP()) {
          renamed_Super = ((LogicObject)(iter000.value));
          LogicObject.helpDerivePartitionMemberships(self, renamed_Super, tuples);
        }
      }
      return (tuples.nonEmptyP());
    }
  }

  public static void helpDerivePartitionMemberships(LogicObject self, LogicObject renamed_Super, List tuples) {
    { Stella_Object mc = null;
      Cons iter000 = Logic.applyCachedRetrieve(Cons.list$(Cons.cons(Logic.SYM_LOGIC_pSUPER, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.list$(Cons.cons(Logic.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_MEMBER_OF, Cons.cons(Logic.SYM_LOGIC_pSUPER, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Logic.SYM_LOGIC_MUTUALLY_DISJOINT_COLLECTION, Cons.cons(Logic.SYM_LOGIC_pMDC, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.consList(Cons.cons(renamed_Super, Cons.cons(null, Stella.NIL))), Cons.consList(Stella.NIL), Logic.SYM_LOGIC_F_HELP_DERIVE_PARTITION_MEMBERSHIPS_QUERY_000, new Object[2]);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        mc = iter000.value;
        { Proposition mdcproposition = ((Proposition)(Logic.allTrueDependentPropositions(mc, Logic.SGT_PL_KERNEL_KB_MUTUALLY_DISJOINT_COLLECTION, false).consify().value));

          tuples.push(Logic.assertTuple(Logic.SGT_PL_KERNEL_KB_PARTITION_MEMBERSHIP, Cons.consList(Cons.cons(self, Cons.cons(mdcproposition, Cons.cons(renamed_Super, Stella.NIL))))));
        }
      }
    }
    { Proposition p = null;
      Iterator iter001 = Logic.allTrueDependentPropositions(renamed_Super, Logic.SGT_PL_KERNEL_KB_DISJOINT, false);

      while (iter001.nextP()) {
        p = ((Proposition)(iter001.value));
        tuples.push(Logic.assertTuple(Logic.SGT_PL_KERNEL_KB_PARTITION_MEMBERSHIP, Cons.consList(Cons.cons(self, Cons.cons(p, Cons.cons(renamed_Super, Stella.NIL))))));
      }
    }
  }

  public static boolean conceptPrototypeP(LogicObject self) {
    return (LogicObject.conceptPrototypeOf(self) != null);
  }

  public static NamedDescription conceptPrototypeOf(LogicObject self) {
    if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_LOGIC_HYPOTHESIZED_INSTANCEp, Stella.FALSE_WRAPPER))).wrapperValue) {
      { Proposition prop = null;
        Iterator iter000 = Logic.allTrueDependentIsaPropositions(self);

        while (iter000.nextP()) {
          prop = ((Proposition)(iter000.value));
          if (Logic.accessBinaryValue(Logic.surrogateToDescription(((Surrogate)(prop.operator))), Logic.SGT_PL_KERNEL_KB_CONCEPT_PROTOTYPE) != null) {
            return (Logic.surrogateToDescription(((Surrogate)(prop.operator))));
          }
        }
      }
    }
    return (null);
  }

  /** Return an s-expression representing the source expression for 'self'.
   * @param self
   * @param canonicalizevariablenamesP
   * @return Stella_Object
   */
  public static Stella_Object generateExpression(LogicObject self, boolean canonicalizevariablenamesP) {
    { Object old$Canonicalvariablenamemapping$000 = Logic.$CANONICALVARIABLENAMEMAPPING$.get();
      Object old$Canonicalvariablecounter$000 = Logic.$CANONICALVARIABLECOUNTER$.get();
      Object old$Printquantifiedobjectsstack$000 = Logic.$PRINTQUANTIFIEDOBJECTSSTACK$.get();

      try {
        Native.setSpecial(Logic.$CANONICALVARIABLENAMEMAPPING$, (canonicalizevariablenamesP ? KeyValueList.newKeyValueList() : null));
        Native.setIntSpecial(Logic.$CANONICALVARIABLECOUNTER$, -1);
        Native.setSpecial(Logic.$PRINTQUANTIFIEDOBJECTSSTACK$, Stella.NIL);
        return (Logic.generateTerm(self));

      } finally {
        Logic.$PRINTQUANTIFIEDOBJECTSSTACK$.set(old$Printquantifiedobjectsstack$000);
        Logic.$CANONICALVARIABLECOUNTER$.set(old$Canonicalvariablecounter$000);
        Logic.$CANONICALVARIABLENAMEMAPPING$.set(old$Canonicalvariablenamemapping$000);
      }
    }
  }

  public static void printLogicObject(LogicObject self, OutputStream stream, boolean toplevelP) {
    { String prefix = ((toplevelP &&
          (!((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue())) ? "|i|" : "");

      if (self.surrogateValueInverse != null) {
        if ((!(self.surrogateValueInverse.surrogateValue == self)) &&
            (!Logic.synonymSurrogateP(self.surrogateValueInverse))) {
          prefix = "|BAD surrogate|";
        }
        stream.nativeStream.print(prefix + Logic.stringifiedSurrogate(self.surrogateValueInverse));
      }
      else {
        stream.nativeStream.print(prefix + "_" + Logic.logicalType(self).symbolName);
      }
    }
  }

  public static void printKifLogicObject(LogicObject self) {
    { OutputStream stream = ((OutputStream)(Logic.$PRINTLOGICALFORMSTREAM$.get()));

      if (self.surrogateValueInverse != null) {
        stream.nativeStream.print(Logic.stringifiedSurrogate(self.surrogateValueInverse));
      }
      else {
        stream.nativeStream.print("Unnamed_Object");
      }
    }
  }

  public static Cons getMostSpecificClasses(LogicObject instance) {
    { Cons types = Logic.allDirectTypes(instance);

      if (types == Stella.NIL) {
        return (Logic.allAssertedTypes(instance));
      }
      return (types);
    }
  }

  public static Stella_Object generateCaseBasedAnswer(LogicObject probe, Surrogate slot, List cases) {
    { int num = cases.length();
      Vector slotVector = Logic.createCaseValueVector(cases, slot);
      Vector matchScores = Vector.newVector(num);
      int farthest = 0;
      Vector nearestNeighbors = Vector.newVector(Logic.$NUM_NEIGHBORS$);
      double max = 0.0;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = Logic.$NUM_NEIGHBORS$ - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          (nearestNeighbors.theArray)[i] = (IntegerWrapper.wrapInteger(0));
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter001 = 0;
        int upperBound001 = num - 1;

        for (;iter001 <= upperBound001; iter001 = iter001 + 1) {
          i = iter001;
          (matchScores.theArray)[i] = (FloatWrapper.wrapFloat(1.0));
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter002 = 0;
        int upperBound002 = num - 1;
        Stella_Object renamed_Case = null;
        Cons iter003 = cases.theConsList;

        for (;(iter002 <= upperBound002) &&
                  (!(iter003 == Stella.NIL)); iter002 = iter002 + 1, iter003 = iter003.rest) {
          i = iter002;
          renamed_Case = iter003.value;
          if (!(probe == renamed_Case)) {
            { FloatWrapper score = LogicObject.matchInstances(probe, ((LogicObject)(renamed_Case)));

              (matchScores.theArray)[i] = score;
              if (score.wrapperValue > max) {
                max = ((double)(i));
              }
              if (score.wrapperValue > ((FloatWrapper)((matchScores.theArray)[(((IntegerWrapper)((nearestNeighbors.theArray)[farthest])).wrapperValue)])).wrapperValue) {
                (nearestNeighbors.theArray)[farthest] = (IntegerWrapper.wrapInteger(i));
                farthest = 0;
                { int j = Stella.NULL_INTEGER;
                  int iter004 = 1;
                  int upperBound003 = Logic.$NUM_NEIGHBORS$ - 1;

                  for (;iter004 <= upperBound003; iter004 = iter004 + 1) {
                    j = iter004;
                    if (((FloatWrapper)((matchScores.theArray)[(((IntegerWrapper)((nearestNeighbors.theArray)[j])).wrapperValue)])).wrapperValue < ((FloatWrapper)((matchScores.theArray)[(((IntegerWrapper)((nearestNeighbors.theArray)[farthest])).wrapperValue)])).wrapperValue) {
                      farthest = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return (Logic.combineCaseAnswers(nearestNeighbors, matchScores, slotVector));
    }
  }

  public static FloatWrapper matchInstances(LogicObject x, LogicObject y) {
    { Cons prop = Cons.list$(Cons.cons(Logic.SYM_PL_KERNEL_KB_CASE_MATCH, Cons.cons(x, Cons.cons(Cons.cons(y, Stella.NIL), Stella.NIL))));

      return (FloatWrapper.wrapFloat(QueryIterator.returnPartialTruth(Logic.makeQuery(Stella.NIL, Logic.coerceToTree(prop), Stella.NIL, Stella.NIL), true)));
    }
  }

  public static void buildCaseFromInstance(LogicObject inst, Surrogate kind) {
    Logic.$SEEN_INSTANCES$ = List.newList();
    Logic.$DELETED_CASE_VARIABLES$ = List.newList();
    Logic.$NUM_CASES$ = Logic.$NUM_CASES$ + 1;
    Logic.$BASE_COUNTER$ = Logic.$CASE_VARIABLE_COUNTER$;
    { Symbol name = Logic.objectName(inst);
      List antecedent = Logic.getAssertionStructure(name, 1);
      Stella_Object renamed_Class = kind.surrogateValue;
      Symbol classSymbol = Logic.objectName(renamed_Class);
      String ruleName = Logic.objectNameString(renamed_Class) + "-match";
      List ruleAntecedent = ((List)(Logic.$CASE_ANTECEDENT_TABLE$.lookup(ruleName)));
      List ruleTypes = ((List)(Logic.$CASE_TYPES_TABLE$.lookup(ruleName)));
      List caseList = ((List)(Logic.$CASE_NAME_TABLE$.lookup(classSymbol)));
      List typeDefs = null;

      if (caseList == null) {
        Logic.$CASE_NAME_TABLE$.insertAt(classSymbol, List.list(Cons.cons(name, Stella.NIL)));
      }
      else {
        {
          caseList.push(name);
          Logic.$CASE_NAME_TABLE$.insertAt(classSymbol, caseList);
        }
      }
      if (ruleAntecedent == null) {
        ruleAntecedent = List.newList();
      }
      if (ruleTypes == null) {
        ruleTypes = List.newList();
      }
      Logic.$SYMBOL_VARIABLE_HASH_TABLE$ = HashTable.newHashTable();
      if (Logic.$ONLY_VARIABLIZE_VISITED_INSTANCES$) {
        antecedent = Logic.variablizeInstances(antecedent, Logic.$VISITED_INSTANCES$);
      }
      else {
        antecedent = Logic.variablizeConsPropositions(antecedent);
      }
      { Cons clause = null;
        Cons iter000 = antecedent.theConsList;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          clause = ((Cons)(iter000.value));
          Stella_Object.substituteConsTree(clause, Logic.SYM_LOGIC_pY, ((Symbol)(Logic.$SYMBOL_VARIABLE_HASH_TABLE$.lookup(name))));
        }
      }
      Logic.$SYMBOL_VARIABLE_HASH_TABLE$.insertAt(name, Logic.SYM_LOGIC_pY);
      Logic.filterAntecedent(antecedent, ruleName);
      typeDefs = Logic.buildTypeDefs(Logic.$SEEN_INSTANCES$);
      ruleAntecedent = ruleAntecedent.concatenate(antecedent, Stella.NIL);
      ruleTypes = ruleTypes.concatenate(typeDefs, Stella.NIL);
      Logic.$CASE_ANTECEDENT_TABLE$.insertAt(ruleName, ruleAntecedent);
      Logic.$CASE_TYPES_TABLE$.insertAt(ruleName, ruleTypes);
    }
  }

  /** Retract all definite (TRUE or FALSE) propositions attached to <code>self</code>.
   * @param self
   */
  public static void retractFactsOfInstance(LogicObject self) {
    if (self == null) {
      return;
    }
    { Proposition p = null;
      Cons iter000 = Logic.allFactsOfInstance(self, false, true).theConsList;

      loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        p = ((Proposition)(iter000.value));
        if (p.kind == Logic.KWD_FUNCTION) {
          { Skolem skolem = ((Skolem)(p.arguments.last()));

            if (skolem == self) {
              continue loop000;
            }
            if ((skolem != null) &&
                (((Stella_Object)(Stella_Object.accessInContext(skolem.variableValue, skolem.homeContext, false))) != null)) {
              Proposition.unassertProposition(p);
            }
            LogicObject.retractFactsOfInstance(skolem);
          }
        }
        else {
          Proposition.unassertProposition(p);
        }
      }
    }
  }

  public static void evaluateReachableInequalities(LogicObject self, List visitedlist) {
    { Proposition p = null;
      Iterator iter000 = Logic.allTrueDependentPropositions(self, Logic.SGT_PL_KERNEL_KB_INEQUALITY, true);

      while (iter000.nextP()) {
        p = ((Proposition)(iter000.value));
        Proposition.postForEvaluation(p, ((Context)(Stella.$CONTEXT$.get())));
        visitedlist.push(self);
        { Stella_Object arg = null;
          Vector vector000 = p.arguments;
          int index000 = 0;
          int length000 = vector000.length();

          for (;index000 < length000; index000 = index000 + 1) {
            arg = (vector000.theArray)[index000];
            if ((!visitedlist.memberP(arg)) &&
                Stella_Object.isaP(arg, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
              LogicObject.evaluateReachableInequalities(((LogicObject)(arg)), visitedlist);
            }
          }
        }
      }
    }
  }

  public void markAsIncoherent() {
    { LogicObject self = this;

    }
  }

  public static boolean collectionImpliesCollectionP(LogicObject subcollection, LogicObject supercollection) {
    if (subcollection == supercollection) {
      return (true);
    }
    else {
      return (LogicObject.allSupercollections(subcollection).memberP(supercollection));
    }
  }

  public static Cons applicableRulesOfDescription(LogicObject self, Keyword direction, boolean truerulesonlyP) {
    if (Stella_Object.isaP(self, Logic.SGT_LOGIC_DESCRIPTION)) {
      Description.deriveDeferredSatelliteRules(((Description)(self)));
    }
    { Cons rules = Stella.NIL;

      { Proposition p = null;
        Iterator iter000 = Logic.selectRulePropositions(Logic.makeRulesPattern(((direction == Logic.KWD_FORWARD) ? null : self), ((direction == Logic.KWD_FORWARD) ? self : null))).allocateIterator();
        Cons collect000 = null;

        while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          if ((Proposition.trueP(p) &&
              (!((BooleanWrapper)(KeyValueList.dynamicSlotValue(p.dynamicSlots, Logic.SYM_LOGIC_SUBSUMPTION_LINKp, Stella.FALSE_WRAPPER))).wrapperValue)) ||
              (Proposition.inheritsTruthFromMasterP(p) ||
               (!truerulesonlyP))) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(p, Stella.NIL);
                if (rules == Stella.NIL) {
                  rules = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(rules, collect000);
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
      return (rules);
    }
  }

  public static void removeAllDependentPropositionLinks(LogicObject self) {
    self.dependentPropositionsIndex = null;
  }

  public static boolean objectNameLessThanP(LogicObject o1, LogicObject o2) {
    return (Logic.safeStringTermLessP(Logic.objectName(o1).symbolName, Logic.objectName(o2).symbolName));
  }

  /** Destroy all propositions that reference 'self',
   * and mark it as 'deleted?', thereby making it invisible within class
   * extensions.  Unlink descriptions from native relations.
   * @param self
   */
  public static void destroyTerm(LogicObject self) {
    if ((self == null) ||
        self.deletedP()) {
      return;
    }
    Logic.destroyLogicInstance(self);
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_DESCRIPTION)) {
      { Description self000 = ((Description)(self));

        if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self000), Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
          { NamedDescription self001 = ((NamedDescription)(self000));

            { Relation nativerelation = self001.nativeRelation();

              self001.nativeRelationSetter(null);
              if (nativerelation != null) {
                KeyValueList.setDynamicSlotValue(nativerelation.dynamicSlots, Logic.SYM_LOGIC_DESCRIPTION, null, null);
              }
              if (self001.extension != null) {
                self001.extension = null;
              }
            }
          }
        }
        else {
        }
        { Description complement = ((Description)(KeyValueList.dynamicSlotValue(self000.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null)));

          if (complement != null) {
            KeyValueList.setDynamicSlotValue(complement.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null, null);
            KeyValueList.setDynamicSlotValue(self000.dynamicSlots, Logic.SYM_LOGIC_COMPLEMENT_DESCRIPTION, null, null);
          }
        }
        LogicObject.removeAllDependentPropositionLinks(self000);
        self000.ioVariables = null;
        self000.internalVariables = null;
        self000.proposition = null;
        self000.homeContext = null;
      }
    }
    else {
    }
    self.dynamicSlots.clear();
    self.deletedPSetter(true);
  }

  public static Cons evaluateRemainingArguments(LogicObject predicatevalue, Cons arguments) {
    { Cons evaluatedarguments = Stella.NIL;

      if ((predicatevalue != null) &&
          Stella_Object.isaP(predicatevalue, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
        { List variabletypes = ((NamedDescription)(predicatevalue)).ioVariableTypes;

          { Surrogate type = null;
            Cons iter000 = variabletypes.rest();

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              type = ((Surrogate)(iter000.value));
              { Stella_Object head000 = arguments.value;

                arguments = arguments.rest;
                { Stella_Object arg = head000;

                  if (arg != null) {
                    evaluatedarguments = Cons.cons(Logic.evaluateTypedArgument(arg, type), evaluatedarguments);
                  }
                }
              }
            }
          }
          { Stella_Object arg = null;
            Cons iter001 = arguments;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              arg = iter001.value;
              evaluatedarguments = Cons.cons(Logic.evaluateTypedArgument(arg, ((Surrogate)(variabletypes.last()))), evaluatedarguments);
            }
          }
          return (evaluatedarguments.reverse());
        }
      }
      else {
        {
          { Stella_Object arg = null;
            Cons iter002 = arguments;
            Cons collect000 = null;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              arg = iter002.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Logic.evaluateTerm(arg), Stella.NIL);
                  if (evaluatedarguments == Stella.NIL) {
                    evaluatedarguments = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(evaluatedarguments, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Logic.evaluateTerm(arg), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          return (evaluatedarguments);
        }
      }
    }
  }

  public static boolean nonPolymorphicPredicateP(LogicObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
        { NamedDescription self000 = ((NamedDescription)(self));

          { Relation relation = self000.nativeRelation();

            return (!((relation != null) &&
                Logic.polymorphicRelationP(relation)));
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject self000 = ((LogicObject)(self));

          return (!Logic.testIsaP(self000, Logic.SGT_PL_KERNEL_KB_POLYMORPHIC));
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

  public static Proposition retractProperty(LogicObject instance, Surrogate property) {
    return (LogicObject.updateProperty(instance, property, Logic.KWD_RETRACT_TRUE));
  }

  public static Proposition assertProperty(LogicObject instance, Surrogate property) {
    return (LogicObject.updateProperty(instance, property, Logic.KWD_ASSERT_TRUE));
  }

  public static Proposition updateProperty(LogicObject self, Surrogate surrogate, Keyword updatemode) {
    { Proposition value000 = null;

      { Proposition p = null;
        Iterator iter000 = Logic.unfilteredDependentPropositions(self, surrogate).allocateIterator();

        loop000 : while (iter000.nextP()) {
          p = ((Proposition)(iter000.value));
          if ((((Surrogate)(p.operator)) == surrogate) &&
              (p.arguments.length() == 1)) {
            value000 = p;
            break loop000;
          }
        }
      }
      { Proposition propertyproposition = value000;

        if ((surrogate == null) ||
            (surrogate.surrogateValue == null)) {
          Stella.STANDARD_OUTPUT.nativeStream.println("Error: Property " + surrogate + " is not defined.");
          return (null);
        }
        if (propertyproposition == null) {
          propertyproposition = Logic.createProposition(Logic.SYM_STELLA_PREDICATE, 1);
          (propertyproposition.arguments.theArray)[0] = self;
          propertyproposition.operator = surrogate;
          Proposition.fastenDownOneProposition(propertyproposition, false);
        }
        Proposition.updatePropositionTruthValue(propertyproposition, updatemode);
        return (propertyproposition);
      }
    }
  }

  public static Stella_Object evaluateLogicObjectTerm(LogicObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
        { PatternVariable self000 = ((PatternVariable)(self));

          return (self000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem self000 = ((Skolem)(self));

          return (self000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
        { Description self000 = ((Description)(self));

          if (Logic.descriptionModeP()) {
            { Surrogate name = self000.surrogateValueInverse;

              if (name != null) {
                return (name);
              }
            }
          }
          return (self000);
        }
      }
      else {
        if (Logic.descriptionModeP()) {
          { Surrogate name = self.surrogateValueInverse;

            if (name != null) {
              return (name);
            }
          }
        }
        else {
          return (self);
        }
      }
    }
    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          stream000.nativeStream.println("ERROR: Illegal LOGIC-OBJECT term: `" + self + "'.");
          Logic.helpSignalPropositionError(stream000, Logic.KWD_ERROR);

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      throw ((PropositionError)(PropositionError.newPropositionError(stream000.theStringReader()).fillInStackTrace()));
    }
  }

  public static void equivalenceCollections(LogicObject collection1, LogicObject collection2) {
    if (!Logic.$EQUIVALENCE_COLLECTIONSp$) {
      return;
    }
    { Stella_Object value1 = Logic.equivalentValueOf(Logic.valueOf(collection1));
      Stella_Object value2 = Logic.equivalentValueOf(Logic.valueOf(collection2));

      if (LogicObject.equivalentCollectionPriority(((LogicObject)(value1))) > LogicObject.equivalentCollectionPriority(((LogicObject)(value2)))) {
        LogicObject.bindToEquivalentValue(((LogicObject)(value2)), ((Description)(value1)));
      }
      else {
        LogicObject.bindToEquivalentValue(((LogicObject)(value1)), ((Description)(value2)));
      }
    }
  }

  public static int equivalentCollectionPriority(LogicObject self) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

      if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_NAMED_DESCRIPTION)) {
        { NamedDescription self000 = ((NamedDescription)(self));

          return (1);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Logic.SGT_LOGIC_DESCRIPTION)) {
        { Description self000 = ((Description)(self));

          return (2);
        }
      }
      else {
        return (0);
      }
    }
  }

  public static void unlinkEquivalentValue(LogicObject self) {
    { Stella_Object oldvalue = null;

      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_SKOLEM)) {
        { Skolem self000 = ((Skolem)(self));

          oldvalue = Logic.valueOf(self000);
          { Skolem object000 = self000;
            Stella_Object value000 = null;
            Stella_Object oldValue000 = object000.variableValue;
            Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

            if (!((oldValue000 != null) &&
                (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
              object000.variableValue = newValue000;
            }
          }
        }
      }
      else {
        oldvalue = Logic.equivalentValueOf(self);
        { LogicObject object001 = self;
          Description value001 = null;
          Stella_Object oldValue001 = KeyValueList.dynamicSlotValue(object001.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, null);
          Stella_Object newValue001 = Stella_Object.updateInContext(oldValue001, value001, object001.homeContext, false);

          if (!((oldValue001 != null) &&
              (oldValue001.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            KeyValueList.setDynamicSlotValue(object001.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, newValue001, null);
          }
        }
      }
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(oldvalue), Logic.SGT_LOGIC_LOGIC_OBJECT)) {
        { LogicObject oldvalue000 = ((LogicObject)(oldvalue));

          if (((LogicObject)(oldvalue000.variableValueInverse().value)) == self) {
            { LogicObject object002 = oldvalue000;
              Cons value002 = oldvalue000.variableValueInverse().rest;
              Stella_Object oldValue002 = object002.variableValueInverse;
              Stella_Object newValue002 = Stella_Object.updateInContext(oldValue002, value002, object002.homeContext, false);

              if (!((oldValue002 != null) &&
                  (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object002.variableValueInverse = newValue002;
              }
            }
          }
          else {
            { LogicObject object003 = oldvalue000;
              Cons value003 = Cons.copyConsList(oldvalue000.variableValueInverse()).remove(self);
              Stella_Object oldValue003 = object003.variableValueInverse;
              Stella_Object newValue003 = Stella_Object.updateInContext(oldValue003, value003, object003.homeContext, false);

              if (!((oldValue003 != null) &&
                  (oldValue003.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
                object003.variableValueInverse = newValue003;
              }
            }
          }
        }
      }
      else {
      }
    }
  }

  public static void unbindEquivalentValue(LogicObject self) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(self), Logic.SGT_LOGIC_SKOLEM)) {
      { Skolem self000 = ((Skolem)(self));

        Skolem.unbindSkolemValue(self000, false);
      }
    }
    else {
      LogicObject.unlinkEquivalentValue(self);
      Logic.handleOutOfDateInferenceCache(Logic.KWD_RETRACT, null);
    }
  }

  public static void bindToEquivalentValue(LogicObject from, Description to) {
    if (from == to) {
      return;
    }
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(from), Logic.SGT_LOGIC_SKOLEM)) {
      { Skolem from000 = ((Skolem)(from));

        { Skolem object000 = from000;
          Stella_Object value000 = to;
          Stella_Object oldValue000 = object000.variableValue;
          Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

          if (!((oldValue000 != null) &&
              (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object000.variableValue = newValue000;
          }
        }
      }
    }
    else {
      if (((Description)(Stella_Object.accessInContext(KeyValueList.dynamicSlotValue(from.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, null), from.homeContext, false))) == to) {
        return;
      }
      { LogicObject object001 = from;
        Description value001 = to;
        Stella_Object oldValue002 = KeyValueList.dynamicSlotValue(object001.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, null);
        Stella_Object newValue001 = Stella_Object.updateInContext(oldValue002, value001, object001.homeContext, false);

        if (!((oldValue002 != null) &&
            (oldValue002.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
          KeyValueList.setDynamicSlotValue(object001.dynamicSlots, Logic.SYM_LOGIC_EQUIVALENT_VALUE, newValue001, null);
        }
      }
    }
    { Description object002 = to;
      Cons value002 = Cons.cons(from, from.variableValueInverse());
      Stella_Object oldValue003 = object002.variableValueInverse;
      Stella_Object newValue002 = Stella_Object.updateInContext(oldValue003, value002, object002.homeContext, false);

      if (!((oldValue003 != null) &&
          (oldValue003.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
        object002.variableValueInverse = newValue002;
      }
    }
  }

  public static void logLogicObject(LogicObject self) {
    if (Logic.descriptionModeP() ||
        Stella_Object.isaP(self, Logic.SGT_LOGIC_PATTERN_VARIABLE)) {
      return;
    }
    if (!((Boolean)(Logic.$LOADINGREGENERABLEOBJECTSp$.get())).booleanValue()) {
      Logic.locallyConceivedInstances(((Context)(Stella.$CONTEXT$.get()))).push(self);
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { LogicObject self = this;

      Logic.printTopLevelObject(self, stream);
    }
  }

  public boolean deletedPSetter(boolean value) {
    { LogicObject self = this;

      KeyValueList.setDynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_DELETED_OBJECTp, (value ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER), null);
      return (value);
    }
  }

  public boolean deletedP() {
    { LogicObject self = this;

      { BooleanWrapper deletedP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_DELETED_OBJECTp, null)));

        if (deletedP != null) {
          return (BooleanWrapper.coerceWrappedBooleanToBoolean(deletedP));
        }
        else {
          return (false);
        }
      }
    }
  }

  public static Stella_Object accessLogicObjectSlotValue(LogicObject self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Logic.SYM_STELLA_HOME_CONTEXT) {
      if (setvalueP) {
        self.homeContext = ((Context)(value));
      }
      else {
        value = self.homeContext;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_VARIABLE_VALUE_INVERSE) {
      if (setvalueP) {
        { LogicObject object000 = self;
          Cons value000 = ((Cons)(value));
          Stella_Object oldValue000 = object000.variableValueInverse;
          Stella_Object newValue000 = Stella_Object.updateInContext(oldValue000, value000, object000.homeContext, false);

          if (!((oldValue000 != null) &&
              (oldValue000.primaryType() == Logic.SGT_STELLA_CS_VALUE))) {
            object000.variableValueInverse = newValue000;
          }
        }
      }
      else {
        value = self.variableValueInverse();
      }
    }
    else if (slotname == Logic.SYM_STELLA_SURROGATE_VALUE_INVERSE) {
      if (setvalueP) {
        self.surrogateValueInverse = ((Surrogate)(value));
      }
      else {
        value = self.surrogateValueInverse;
      }
    }
    else if (slotname == Logic.SYM_LOGIC_OBJECT_STRINGIFIED_SOURCE) {
      if (setvalueP) {
        Logic.stringifiedSourceSetter(self, ((StringWrapper)(value)).wrapperValue);
      }
      else {
        value = StringWrapper.wrapString(Logic.stringifiedSource(self));
      }
    }
    else if (slotname == Logic.SYM_LOGIC_OBJECT_ORIGINATED_PROPOSITIONS) {
      if (setvalueP) {
        Logic.originatedPropositionsSetter(self, ((List)(value)));
      }
      else {
        value = Logic.originatedPropositions(self);
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

  public BooleanWrapper badP() {
    { LogicObject self = this;

      { BooleanWrapper answer = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(self.dynamicSlots, Logic.SYM_STELLA_BADp, null)));

        if (answer == null) {
          return (Stella.FALSE_WRAPPER);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Cons variableValueInverse() {
    { LogicObject self = this;

      { Cons answer = ((Cons)(Stella_Object.accessInContext(self.variableValueInverse, self.homeContext, false)));

        if (answer == null) {
          return (Stella.NIL);
        }
        else {
          return (answer);
        }
      }
    }
  }

  public Surrogate primaryType() {
    { LogicObject self = this;

      return (Logic.SGT_LOGIC_LOGIC_OBJECT);
    }
  }

}

