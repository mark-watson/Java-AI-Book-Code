//  -*- Mode: Java -*-
//
// Stella_Object.java

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

/** A reflective object that can participate in dynamically-typed
 * contexts.  Either a STANDARD-OBJECT or a WRAPPER or a GENERIC-OBJECT.
 * Also, either an OBJECT-WITH-INHERITED-TYPE or an OBJECT-WITH-OWN-TYPE.
 * @author Stella Java Translator
 */
public abstract class Stella_Object {
  /** Helper method for <code>printOutline</code>
   * @param stream
   * @param currentDepth
   * @param depth
   * @param namedP
   */
  public void helpPrintOutline(OutputStream stream, int currentDepth, int depth, boolean namedP) {
    { Stella_Object top = this;

      {
        namedP = namedP;
        currentDepth = currentDepth;
        depth = depth;
      }
      stream.nativeStream.println(top.toString());
    }
  }

  /** Print an outline of <code>thing</code> and its subparts on <code>stream</code>.
   * If <code>depth</code> is non-negative, only <code>depth</code> levels will be printed.
   * If <code>namedP</code> is <code>TRUE</code>, then only named entities will be printed.
   * <p>
   * This function is intended to be used on things like modules, contexts,
   * concepts, etc. that have hierarchical structure.  If <code>thing</code> doesn't
   * have a hierarchical structure, it will just be printed.
   * @param thing
   * @param stream
   * @param depth
   * @param namedP
   */
  public static void printOutline(Stella_Object thing, OutputStream stream, int depth, boolean namedP) {
    thing.helpPrintOutline(stream, 0, depth, namedP);
  }

  public static void idlOutputAtomicExpression(Stella_Object atom) {
    atom.idlOutputLiteral();
  }

  public void idlOutputLiteral() {
    { Stella_Object renamed_Object = this;

    }
  }

  public static void idlOutputStatement(Stella_Object statement) {
    if (Stella_Object.safePrimaryType(statement) == Stella.SGT_STELLA_CONS) {
      { Cons statement000 = ((Cons)(statement));

        if (statement000 == Stella.NIL) {
          return;
        }
        if (Stella_Object.consP(statement000.value) ||
            (statement000.value == null)) {
          {
            Stella_Object.idlOutputStatement(statement000.value);
            Stella_Object.idlOutputStatement(statement000.rest);
          }
        }
        else {
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement000.value));

            if (testValue000 == Stella.SYM_STELLA_IDL_COMMENT) {
              StringWrapper.idlOutputComment(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_TYPEDEF) {
              Cons.idlOutputTypedef(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_ENUM) {
              Cons.idlOutputEnum(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_INTERFACE) {
              Cons.idlOutputInterface(((Cons)(statement000.rest)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_STRUCT) {
              Cons.idlOutputStruct(((Cons)(statement000.rest)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_DECLARATIONS) {
              Cons.idlOutputDeclarations(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_IDENT) {
              StringWrapper.idlOutputIdentifier(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_TYPE) {
              Cons.idlOutputTypeExpression(((Cons)(statement000.rest)));
            }
            else if (testValue000 == Stella.SYM_STELLA_IDL_SIGNATURES) {
              Cons.idlOutputSignatures(((Cons)(statement000.rest.value)));
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
    else {
      if (statement == null) {
        return;
      }
      Stella_Object.idlOutputAtomicExpression(statement);
    }
  }

  public Cons idlTranslateAtomicTree() {
    { Stella_Object tree = this;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_IDL_LITERAL, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Stella_Object idlTranslateATree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (tree000.idlTranslateAtomicTree());
        }
        else {
          return (Stella.idlTranslateNull());
        }
      }
    }
    else {
      if (tree == null) {
        return (Stella.idlTranslateNull());
      }
      return (tree.idlTranslateAtomicTree());
    }
  }

  public static boolean javaOperatorP(Stella_Object statement) {
    return (Stella_Object.consP(statement) &&
        Stella.getQuotedTree("((JAVA_UNARY_OP JAVA_BINARY_OP JAVA_TERNARY_OP JAVA_ASSIGN JAVA_SLOT_VALUE_SETTER) \"/STELLA\")", "/STELLA").memberP(((Cons)(statement)).value));
  }

  public static boolean javaBinaryOperatorP(Stella_Object statement) {
    return (Stella_Object.consP(statement) &&
        (Stella.SYM_STELLA_JAVA_BINARY_OP == ((Cons)(statement)).value));
  }

  public static void javaHelpOutputPrintStream(Stella_Object stream, Cons exps, boolean nativestreamP, boolean endoflineP) {
    if (stream == Stella.SYM_STELLA_JAVA_STANDARD_OUT) {
      if ((Stella.string_getStellaClass("SYSTEM", false) != null) ||
          Stella.inheritedClassNameConflictsP("SYSTEM")) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("java.lang.System.out");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("System.out");
      }
    }
    else if (stream == Stella.SYM_STELLA_JAVA_STANDARD_ERROR) {
      if ((Stella.string_getStellaClass("SYSTEM", false) != null) ||
          Stella.inheritedClassNameConflictsP("SYSTEM")) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("java.lang.System.err");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("System.err");
      }
    }
    else {
      Stella_Object.javaOutputStatement(stream);
      if (!nativestreamP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(".nativeStream");
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((endoflineP ? ".println(" : ".print(")));
    Stella_Object.javaMaybeOutputStatementWithParentheses(exps.value);
    { Stella_Object e = null;
      Cons iter000 = exps.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        e = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" + ");
        Stella_Object.javaMaybeOutputStatementWithParentheses(e);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static boolean javaEndOfLineTokenP(Stella_Object token) {
    if (Stella_Object.safePrimaryType(token) == Stella.SGT_STELLA_CONS) {
      { Cons token000 = ((Cons)(token));

        return (token000.value == Stella.SYM_STELLA_JAVA_EOL);
      }
    }
    else {
    }
    return (false);
  }

  public static boolean javaBlockP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_JAVA_BLOCK));
  }

  public static boolean javaPrognP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_JAVA_PROGN));
  }

  public void javaOutputLiteral() {
    { Stella_Object renamed_Object = this;

    }
  }

  public static void javaMaybeOutputStatementWithParentheses(Stella_Object statement) {
    if (Stella_Object.javaOperatorP(statement)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    }
    Stella_Object.javaOutputStatement(statement);
    if (Stella_Object.javaOperatorP(statement)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void javaOutputStatement(Stella_Object statement) {
    if (Stella_Object.safePrimaryType(statement) == Stella.SGT_STELLA_CONS) {
      { Cons statement000 = ((Cons)(statement));

        if (statement000 == Stella.NIL) {
          return;
        }
        if (Stella_Object.consP(statement000.value) ||
            (statement000.value == null)) {
          {
            Stella_Object.javaOutputStatement(statement000.value);
            Stella_Object.javaOutputStatement(statement000.rest);
          }
        }
        else {
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement000.value));

            if (testValue000 == Stella.SYM_STELLA_JAVA_CLASS) {
              Cons.javaOutputClass(statement000.rest, false);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_EXCEPTION_CLASS) {
              Cons.javaOutputClass(statement000.rest, true);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_NAMED_STATEMENT) {
              Cons.javaOutputNamedStatement(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_STATEMENTS) {
              Cons.javaOutputStatements(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_IDENT) {
              StringWrapper.javaOutputIdentifier(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_EOL) {
              StringWrapper.javaOutputIdentifier(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_LITERAL) {
              statement000.rest.value.javaOutputLiteral();
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_COMMENT) {
              StringWrapper.javaOutputComment(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_SYMBOL) {
              statement000.rest.value.javaOutputLiteral();
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_CATCH) {
              Cons.javaOutputCatch(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_THROW) {
              Cons.javaOutputThrow(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_UNWIND_PROTECT) {
              Cons.javaOutputUnwindProtect(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_HANDLER_CASE) {
              Cons.javaOutputHandlerCase(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_SIGNAL) {
              Cons.javaOutputSignal(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_VERBATIM) {
              StringWrapper.javaOutputVerbatim(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_CAST) {
              Cons.javaOutputCast(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_GLOBAL) {
              Cons.javaOutputGlobalDefinition(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_TYPE) {
              Cons.javaOutputTypeExpression(((Cons)(statement000.rest)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_PROGN) {
              Cons.javaOutputProgn(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_BLOCK) {
              Cons.javaOutputBlock(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_WITH_PROCESS_LOCK) {
              Cons.javaOutputWithProcessLock(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_RETURN) {
              Cons.javaOutputReturn(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_MAKE) {
              Cons.javaOutputMake(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_FUNCALL) {
              Cons.javaOutputFuncall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_METHOD_CODE_CALL) {
              Cons.javaOutputMethodCodeCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_ASSIGN) {
              Cons.javaOutputAssignment(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_BREAK) {
              Cons.javaOutputBreak(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_CONTINUE) {
              Cons.javaOutputContinue(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_COND) {
              Cons.javaOutputCond(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_CASE) {
              Cons.javaOutputCase(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_IF) {
              Cons.javaOutputIf(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_WHEN) {
              Cons.javaOutputWhen(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_UNLESS) {
              Cons.javaOutputUnless(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_LOOP) {
              Cons.javaOutputLoop(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_WHILE) {
              Cons.javaOutputWhile(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_FOREACH) {
              Cons.javaOutputForeach(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_SLOT_VALUE) {
              Cons.javaOutputSlotValue(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_SLOT_VALUE_SETTER) {
              Cons.javaOutputSlotValueSetter(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_UNARY_OP) {
              Cons.javaOutputUnaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_BINARY_OP) {
              Cons.javaOutputBinaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_TERNARY_OP) {
              Cons.javaOutputTernaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_FUNCTION_CALL) {
              Cons.javaOutputFunctionCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_METHOD_CALL) {
              Cons.javaOutputMethodCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_ACTUALS) {
              Cons.javaOutputActualParameters(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_MAKE_ARRAY) {
              Cons.javaOutputMakeArray(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_ARRAY_INITIALIZER) {
              Cons.javaOutputArray(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_ANONYMOUS_ARRAY) {
              Cons.javaOutputAnonymousArray(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_AREF) {
              Cons.javaOutputAref(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_METHOD) {
              Cons.javaOutputMethod(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_FUNCTION) {
              Cons.javaOutputMethod(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_PRINT_STREAM) {
              Cons.javaOutputPrintStream(statement000.rest, false);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_PRINT_NATIVE_STREAM) {
              Cons.javaOutputPrintStream(statement000.rest, true);
            }
            else if (testValue000 == Stella.SYM_STELLA_JAVA_DECLARATIONS) {
              Cons.javaOutputDeclarations(((Cons)(statement000.rest)));
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
    else {
      if (statement == null) {
        return;
      }
      statement.javaOutputLiteral();
    }
  }

  public Cons javaTranslateAtomicTree() {
    { Stella_Object tree = this;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_LITERAL, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static boolean javaStreamIsStandardOutputP(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        return (Stella_Object.equalConsTreesP(tree000, Stella.getQuotedTree("((SYS-SLOT-VALUE @OUTPUT-STREAM NATIVE-STREAM STANDARD-OUTPUT) \"/STELLA\")", "/STELLA")));
      }
    }
    else {
      return (false);
    }
  }

  public static Cons javaTranslateWithNativeWrapper(Stella_Object tree, StandardObject type) {
    if (StandardObject.javaLiteralP(type)) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StandardObject.javaNativeLiteralWrapperNames(type, new Object[1]), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(Stella_Object.javaTranslateATree(tree), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
    else {
      return (((Cons)(Stella_Object.javaTranslateATree(tree))));
    }
  }

  public static boolean javaSymbolCaseP(Stella_Object keyform) {
    if (Stella_Object.safePrimaryType(keyform) == Stella.SGT_STELLA_CONS) {
      { Cons keyform000 = ((Cons)(keyform));

        return ((keyform000.value == Stella.SYM_STELLA_SYS_SLOT_VALUE) &&
            (keyform000.rest.rest.value == Stella.SYM_STELLA_SYMBOL_ID));
      }
    }
    else {
      return (false);
    }
  }

  public static Stella_Object javaTranslateATree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (tree000.javaTranslateAtomicTree());
        }
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_SPECIAL) {
            return (Cons.javaTranslateSpecialTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
            return (Cons.javaTranslateVerbatimTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_UNWIND_PROTECT) {
            return (Cons.javaTranslateUnwindProtect(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SIGNAL) {
            return (Cons.javaTranslateSignal(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLER_CASE) {
            return (Cons.javaTranslateHandlerCase(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLE_EXCEPTION) {
            return (Cons.javaTranslateHandleException(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_VOID_SYS) {
            return (Cons.javaTranslateVoidSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
            return (Cons.javaTranslateTypedSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BAD_SYS) {
            return (Cons.javaTranslateBadSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SETQ) {
            return (Cons.javaTranslateSetqTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SET_DEFAULT) {
            return (Cons.javaTranslateSysSetDefault(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) {
            return (Cons.javaTranslateSysSlotValue(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) {
            return (Cons.javaTranslateSysSlotValueSetter(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) {
            return (Cons.javaTranslateMethodCall(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
            return (Cons.javaTranslateFunctionCall(tree000, null));
          }
          else if (testValue000 == Stella.SYM_STELLA_PROGN) {
            return (Cons.javaTranslateProgn(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WITH_PROCESS_LOCK) {
            return (Cons.javaTranslateWithProcessLock(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_LOOP) {
            return (Cons.javaTranslateLoop(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_FOREACH) {
            return (Cons.javaTranslateForeachTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_LET) {
            return (Cons.javaTranslateLetTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_CAST) ||
              (testValue000 == Stella.SYM_STELLA_SAFE_CAST)) {
            return (Cons.javaTranslateCast(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_RETURN) {
            return (Cons.javaTranslateReturnTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BREAK) {
            return (Cons.javaTranslateBreak(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CONTINUE) {
            return (Cons.javaTranslateContinue(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WHILE) {
            return (Cons.javaTranslateWhile(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_IF) {
            return (Cons.javaTranslateIfTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CHOOSE) {
            return (Cons.javaTranslateChooseTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WHEN) {
            return (Cons.javaTranslateWhenTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_UNLESS) {
            return (Cons.javaTranslateUnlessTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_AND) ||
              ((testValue000 == Stella.SYM_STELLA_OR) ||
               ((testValue000 == Stella.SYM_STELLA_NOT) ||
                ((testValue000 == Stella.SYM_STELLA_EQp) ||
                 ((testValue000 == Stella.SYM_STELLA_g) ||
                  ((testValue000 == Stella.SYM_STELLA_ge) ||
                   ((testValue000 == Stella.SYM_STELLA_l) ||
                    ((testValue000 == Stella.SYM_STELLA_le) ||
                     ((testValue000 == Stella.SYM_STELLA_ii) ||
                      (testValue000 == Stella.SYM_STELLA___)))))))))) {
            return (Cons.javaTranslateOperatorTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_COND) {
            return (Cons.javaTranslateCondTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CASE) {
            return (Cons.javaTranslateCaseTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MAKE) {
            return (Cons.javaTranslateMakeTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_NEW) {
            return (Cons.javaTranslateSysNew(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MV_SETQ) {
            return (Cons.javaTranslateMvSetq(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE) {
            return (Cons.javaTranslateCallFunctionCode(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE) {
            return (Cons.javaTranslateCallMethodCode(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_INLINE_CALL) {
            return (Cons.javaTranslateInlineCallTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_THE_CODE) {
            return (Cons.javaTranslateTheCode(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_INLINE) ||
              (testValue000 == Stella.SYM_STELLA_IGNORE)) {
            return (Cons.javaTranslateIgnoreTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_PRINT_STREAM) {
            return (Cons.javaTranslatePrintStream(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_PRINT_NATIVE_STREAM) {
            return (Cons.javaTranslatePrintNativeStream(tree000));
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
    else {
      if (tree == null) {
        return (Stella.javaTranslateNull());
      }
      return (tree.javaTranslateAtomicTree());
    }
  }

  /** Translate <code>statement</code> to C++ and print the result.
   * @param statement
   */
  public static void jptrans(Stella_Object statement) {
    { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();
      Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
        Native.setSpecial(Stella.$CURRENT_STREAM$, Stella.STANDARD_OUTPUT);
        Keyword.setTranslatorOutputLanguage(Stella.KWD_JAVA);
        Stella_Object.incrementallyTranslate(statement);

      } finally {
        Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
      }
    }
  }

  public static void cppOutputOneActualParameter(Stella_Object parameter) {
    if (((Boolean)(Stella.$OUTPUTTINGDEFPRINTp$.get())).booleanValue() &&
        Stella_Object.cppArgumentIsStreamP(parameter)) {
      {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("&");
        Stella_Object.cppOutputStatement(parameter);
      }
    }
    else {
      Stella_Object.cppOutputStatement(parameter);
    }
  }

  public static boolean cppArgumentIsStreamP(Stella_Object arg) {
    if (Stella_Object.safePrimaryType(arg) == Stella.SGT_STELLA_CONS) {
      { Cons arg000 = ((Cons)(arg));

        return ((arg000.value == Stella.SYM_STELLA_CPP_IDENT) &&
            Stella_Object.eqlToStringP(arg000.rest.value, "stream"));
      }
    }
    else {
      return (false);
    }
  }

  public static void cppOutputTypedEntity(Stella_Object type, Stella_Object entity, Stella_Object initialvalue) {
    { boolean arraytypeP = Stella_Object.cppTranslatedArrayTypeP(type);

      if (arraytypeP) {
        { String translatedtype = null;
          String translatedentity = null;

          { Surrogate testValue000 = Stella_Object.safePrimaryType(type);

            if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons type000 = ((Cons)(type));

                if (!(type000.value == Stella.SYM_STELLA_CPP_TYPE)) {
                  type000 = Cons.cons(Stella.SYM_STELLA_CPP_TYPE, type000);
                }
                { String result000 = null;

                  { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

                    try {
                      Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
                      Stella_Object.cppOutputStatement(type000);
                      result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

                    } finally {
                      Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
                    }
                  }
                  translatedtype = result000;
                }
              }
            }
            else if (Surrogate.subtypeOfStringP(testValue000)) {
              { StringWrapper type000 = ((StringWrapper)(type));

                translatedtype = type000.wrapperValue;
              }
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
          { Surrogate testValue001 = Stella_Object.safePrimaryType(entity);

            if (testValue001 == Stella.SGT_STELLA_CONS) {
              { Cons entity000 = ((Cons)(entity));

                { String result001 = null;

                  { Object old$CurrentStream$001 = Stella.$CURRENT_STREAM$.get();

                    try {
                      Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
                      Stella_Object.cppOutputStatement(entity000);
                      result001 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

                    } finally {
                      Stella.$CURRENT_STREAM$.set(old$CurrentStream$001);
                    }
                  }
                  translatedentity = result001;
                }
              }
            }
            else if (Surrogate.subtypeOfStringP(testValue001)) {
              { StringWrapper entity000 = ((StringWrapper)(entity));

                translatedentity = entity000.wrapperValue;
              }
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.cppGenerateArrayTypedEntity(translatedentity, translatedtype));
        }
      }
      else {
        { Surrogate testValue002 = Stella_Object.safePrimaryType(type);

          if (testValue002 == Stella.SGT_STELLA_CONS) {
            { Cons type000 = ((Cons)(type));

              if (!(type000.value == Stella.SYM_STELLA_CPP_TYPE)) {
                type000 = Cons.cons(Stella.SYM_STELLA_CPP_TYPE, type000);
              }
              Stella_Object.cppOutputStatement(type000);
            }
          }
          else if (Surrogate.subtypeOfStringP(testValue002)) {
            { StringWrapper type000 = ((StringWrapper)(type));

              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(type000.wrapperValue + " ");
            }
          }
          else {
            { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

              stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
            }
          }
        }
        { Surrogate testValue003 = Stella_Object.safePrimaryType(entity);

          if (testValue003 == Stella.SGT_STELLA_CONS) {
            { Cons entity000 = ((Cons)(entity));

              Stella_Object.cppOutputStatement(entity000);
            }
          }
          else if (Surrogate.subtypeOfStringP(testValue003)) {
            { StringWrapper entity000 = ((StringWrapper)(entity));

              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(entity000.wrapperValue);
            }
          }
          else {
            { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

              stream003.nativeStream.print("`" + testValue003 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      if (initialvalue != null) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" = ");
        Stella_Object.cppOutputStatement(initialvalue);
      }
    }
  }

  public static boolean cppOperatorP(Stella_Object statement) {
    return (Stella_Object.consP(statement) &&
        Stella.getQuotedTree("((CPP_UNARY_OP CPP_BINARY_OP CPP_TERNARY_OP CPP_ASSIGN CPP_SLOT_VALUE_SETTER) \"/STELLA\")", "/STELLA").memberP(((Cons)(statement)).value));
  }

  public static boolean cppBinaryOperatorP(Stella_Object statement) {
    return (Stella_Object.consP(statement) &&
        (Stella.SYM_STELLA_CPP_BINARY_OP == ((Cons)(statement)).value));
  }

  public static void cppMaybeOutputStatementWithParentheses(Stella_Object statement) {
    { boolean operatorP = Stella_Object.cppOperatorP(statement);

      if (operatorP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      Stella_Object.cppOutputStatement(statement);
      if (operatorP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
    }
  }

  public static void cppOutputAtomicExpression(Stella_Object atom) {
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(atom));

      if (testValue000 == Stella.SYM_STELLA_NEWLINE) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
      }
      else if (testValue000 == Stella.SYM_STELLA_CPP_NULL_VALUE) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("NULL_VALUE");
      }
      else if (testValue000 == Stella.SYM_STELLA_ASSIGN) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("=");
      }
      else if (testValue000 == Stella.SYM_STELLA_SCOLON) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(";");
      }
      else if (testValue000 == Stella.SYM_STELLA_LPAREN) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      else if (testValue000 == Stella.SYM_STELLA_RPAREN) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
      else {
        atom.cppOutputLiteral();
      }
    }
  }

  public void cppOutputLiteral() {
    { Stella_Object renamed_Object = this;

    }
  }

  public static boolean cppBlockP(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if ((testValue000 == Stella.SYM_STELLA_CPP_BLOCK) ||
              (testValue000 == Stella.SYM_STELLA_CPP_PROGN)) {
            return (true);
          }
          else {
          }
        }
      }
    }
    else {
    }
    return (false);
  }

  public static boolean cppPrognP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_CPP_PROGN));
  }

  public static void cppOutputStatement(Stella_Object statement) {
    if (Stella_Object.safePrimaryType(statement) == Stella.SGT_STELLA_CONS) {
      { Cons statement000 = ((Cons)(statement));

        if (statement000 == Stella.NIL) {
          return;
        }
        if (Stella_Object.consP(statement000.value) ||
            (statement000.value == null)) {
          {
            Stella_Object.cppOutputStatement(statement000.value);
            Stella_Object.cppOutputStatement(statement000.rest);
          }
        }
        else {
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement000.value));

            if (testValue000 == Stella.SYM_STELLA_CPP_COMMENT) {
              StringWrapper.cppOutputComment(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_CLASS) {
              Cons.cppOutputClass(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_HANDLER_CASE) {
              Cons.cppOutputHandlerCase(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_CATCH) {
              Cons.cppOutputCatch(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_SIGNAL) {
              Cons.cppOutputSignal(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_UNWIND_PROTECT) {
              Cons.cppOutputUnwindProtect(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_VERBATIM) {
              StringWrapper.cppOutputVerbatim(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_CAST) {
              Cons.cppOutputCast(statement000.rest);
            }
            else if ((testValue000 == Stella.SYM_STELLA_CPP_GLOBAL) ||
                ((testValue000 == Stella.SYM_STELLA_CPP_SPECIAL) ||
                 (testValue000 == Stella.SYM_STELLA_CPP_LOCAL))) {
              Cons.cppOutputVariableDefinition(statement000);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_TYPE) {
              Cons.cppOutputTypeExpression(((Cons)(statement000.rest)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_DEREFERENCE) {
              Cons.cppOutputDereference(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_ARRAY_REFERENCE) {
              Cons.cppOutputArrayReference(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_PROGN) {
              Cons.cppOutputProgn(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_WITH_PROCESS_LOCK) {
              Cons.cppOutputWithProcessLock(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_BREAK) {
              Stella.cppOutputBreak();
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_CONTINUE) {
              Stella.cppOutputContinue();
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_IF) {
              Cons.cppOutputIf(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_FUNCTION_SIGNATURE) {
              Cons.cppOutputFuncallFunctionSignature(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_METHOD_SIGNATURE) {
              Cons.cppOutputMethodCodeCallSignature(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_COND) {
              Cons.cppOutputCond(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_CASE) {
              Cons.cppOutputCase(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_WHEN) {
              Cons.cppOutputWhen(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_UNLESS) {
              Cons.cppOutputUnless(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_ASSIGN) {
              Cons.cppOutputAssignment(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_LOOP) {
              Cons.cppOutputLoop(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_WHILE) {
              Cons.cppOutputWhile(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_FOREACH) {
              Cons.cppOutputForeach(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_BLOCK) {
              Cons.cppOutputBlock(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_IDENT) {
              StringWrapper.cppOutputIdentifier(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_PRINT_STREAM) {
              Cons.cppOutputPrintStream(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_PRINT_NATIVE_STREAM) {
              Cons.cppOutputPrintNativeStream(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_LITERAL) {
              statement000.rest.value.cppOutputLiteral();
            }
            else if ((testValue000 == Stella.SYM_STELLA_CPP_FUNCTION) ||
                (testValue000 == Stella.SYM_STELLA_CPP_METHOD)) {
              Cons.cppOutputFunction(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_RETURN) {
              Cons.cppOutputReturn(((Cons)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_SYMBOL) {
              statement000.rest.value.cppOutputLiteral();
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_MAKE) {
              Cons.cppOutputMake(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_FUNCALL) {
              Cons.cppOutputFuncall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_METHOD_CODE_CALL) {
              Cons.cppOutputMethodCodeCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_FUNCTION_POINTER) {
              StringWrapper.cppOutputFunctionPointer(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_METHOD_POINTER) {
              StringWrapper.cppOutputMethodPointer(((StringWrapper)(statement000.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_SLOT_VALUE) {
              Cons.cppOutputSlotValue(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_REFERENCED_SLOT_VALUE) {
              Cons.cppOutputReferencedSlotValue(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_SLOT_VALUE_SETTER) {
              Cons.cppOutputSlotValueSetter(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_DECLARATIONS) {
              Keyword.cppOutputDeclarations(((Keyword)(statement000.rest.value)), ((Cons)(statement000.rest.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_DEFINITIONS) {
              Keyword.cppOutputDefinitions(((Keyword)(statement000.rest.value)), ((Cons)(statement000.rest.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_SIGNATURES) {
              Keyword.cppOutputSignatures(((Keyword)(statement000.rest.value)), ((Cons)(statement000.rest.rest.value)));
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_STATEMENTS) {
              Cons.cppOutputStatements(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_UNARY_OP) {
              Cons.cppOutputUnaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_BINARY_OP) {
              Cons.cppOutputBinaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_TERNARY_OP) {
              Cons.cppOutputTernaryOperator(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_FUNCTION_CALL) {
              Cons.cppOutputFunctionCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_METHOD_SETTER_CALL) {
              Cons.cppOutputMethodSetterCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_METHOD_CALL) {
              Cons.cppOutputMethodCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_REFERENCED_METHOD_CALL) {
              Cons.cppOutputReferencedMethodCall(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_ACTUALS) {
              Cons.cppOutputActualParameters(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_DEFPRINT) {
              Cons.cppOutputDefprint(statement000.rest);
            }
            else if (testValue000 == Stella.SYM_STELLA_CPP_EXTERN_C) {
              Cons.cppOutputExternC(statement000.rest);
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
    else {
      if (statement == null) {
        return;
      }
      Stella_Object.cppOutputAtomicExpression(statement);
    }
  }

  public static Cons cppStatementToList(Stella_Object statement) {
    { Cons flattenedstatement = Cons.cppFlattenStatements(((Cons)(statement)));

      if (flattenedstatement == statement) {
        return (Cons.cons(flattenedstatement, Stella.NIL));
      }
      else {
        return (flattenedstatement);
      }
    }
  }

  public static Cons cppPrognifyStatement(Stella_Object statement) {
    if (Stella_Object.cppPrognP(statement)) {
      return (((Cons)(statement)));
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cons(statement, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static boolean cppTranslatedArrayTypeP(Stella_Object translatedtype) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(translatedtype);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons translatedtype000 = ((Cons)(translatedtype));

          return (Stella_Object.cppTranslatedArrayTypeP(translatedtype000.last()));
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper translatedtype000 = ((StringWrapper)(translatedtype));

          { String transtype = translatedtype000.wrapperValue;

            return ((transtype.charAt((transtype.length() - 1)) == ']') &&
                ((Native.stringSearch(transtype, "(*)", 0) != Stella.NULL_INTEGER) ||
                 (Native.stringSearch(transtype, "(*&)", 0) != Stella.NULL_INTEGER)));
          }
        }
      }
      else {
      }
    }
    return (false);
  }

  public Cons cppTranslateAtomicTree() {
    { Stella_Object tree = this;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LITERAL, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static boolean cppStreamIsStandardOutputP(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        return (Stella_Object.equalConsTreesP(tree000, Stella.getQuotedTree("((SYS-SLOT-VALUE @OUTPUT-STREAM NATIVE-STREAM STANDARD-OUTPUT) \"/STELLA\")", "/STELLA")));
      }
    }
    else {
      return (false);
    }
  }

  public static boolean symbolCaseP(Stella_Object keyform) {
    if (Stella_Object.safePrimaryType(keyform) == Stella.SGT_STELLA_CONS) {
      { Cons keyform000 = ((Cons)(keyform));

        return ((keyform000.value == Stella.SYM_STELLA_SYS_SLOT_VALUE) &&
            (keyform000.rest.rest.value == Stella.SYM_STELLA_SYMBOL_ID));
      }
    }
    else {
      return (false);
    }
  }

  public static Stella_Object cppTranslateATree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (tree000.cppTranslateAtomicTree());
        }
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_SPECIAL) {
            return (Cons.cppTranslateSpecialTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
            return (Cons.cppTranslateVerbatimTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_UNWIND_PROTECT) {
            return (Cons.cppTranslateUnwindProtect(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SIGNAL) {
            return (Cons.cppTranslateSignal(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLER_CASE) {
            return (Cons.cppTranslateHandlerCase(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLE_EXCEPTION) {
            return (Cons.cppTranslateHandleException(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_VOID_SYS) {
            return (Cons.cppTranslateVoidSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BAD_SYS) {
            return (Cons.cppTranslateBadSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
            return (Cons.cppTranslateTypedSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SETQ) {
            return (Cons.cppTranslateSetqTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SET_DEFAULT) {
            return (Cons.cppTranslateSysSetDefault(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) {
            return (Cons.cppTranslateSysSlotValue(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_REFERENCED_SLOT_VALUE) {
            return (Cons.cppTranslateSysReferencedSlotValue(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) {
            return (Cons.cppTranslateSysSlotValueSetter(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) {
            return (Cons.cppTranslateMethodCall(tree000.rest, false));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_REFERENCED_CALL_METHOD) {
            return (Cons.cppTranslateMethodCall(tree000.rest, true));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
            return (Cons.cppTranslateFunctionCall(tree000.rest, null));
          }
          else if (testValue000 == Stella.SYM_STELLA_PROGN) {
            return (Cons.cppTranslateProgn(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WITH_PROCESS_LOCK) {
            return (Cons.cppTranslateWithProcessLock(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_LOOP) {
            return (Cons.cppTranslateLoop(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_FOREACH) {
            return (Cons.cppTranslateForeachTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_LET) {
            return (Cons.cppTranslateLetTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
            return (Cons.cppTranslateStartupTimeProgn(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_CAST) ||
              (testValue000 == Stella.SYM_STELLA_SAFE_CAST)) {
            return (Cons.cppTranslateCast(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_RETURN) {
            return (Cons.cppTranslateReturnTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BREAK) {
            return (Cons.cppTranslateBreak(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CONTINUE) {
            return (Cons.cppTranslateContinue(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WHILE) {
            return (Cons.cppTranslateWhile(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_IF) {
            return (Cons.cppTranslateIfTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CHOOSE) {
            return (Cons.cppTranslateChooseTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_WHEN) {
            return (Cons.cppTranslateWhenTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_UNLESS) {
            return (Cons.cppTranslateUnlessTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_AND) ||
              ((testValue000 == Stella.SYM_STELLA_OR) ||
               ((testValue000 == Stella.SYM_STELLA_NOT) ||
                ((testValue000 == Stella.SYM_STELLA_EQp) ||
                 ((testValue000 == Stella.SYM_STELLA_g) ||
                  ((testValue000 == Stella.SYM_STELLA_ge) ||
                   ((testValue000 == Stella.SYM_STELLA_l) ||
                    ((testValue000 == Stella.SYM_STELLA_le) ||
                     ((testValue000 == Stella.SYM_STELLA_ii) ||
                      (testValue000 == Stella.SYM_STELLA___)))))))))) {
            return (Cons.cppTranslateOperatorTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_COND) {
            return (Cons.cppTranslateCondTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CASE) {
            return (Cons.cppTranslateCaseTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MAKE) {
            return (Cons.cppTranslateMakeTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_NEW) {
            return (Cons.cppTranslateSysNew(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MV_SETQ) {
            return (Cons.cppTranslateMvSetq(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE) {
            return (Cons.cppTranslateCallFunctionCode(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE) {
            return (Cons.cppTranslateCallMethodCode(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_INLINE_CALL) {
            return (Cons.cppTranslateInlineCallTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_THE_CODE) {
            return (Cons.cppTranslateTheCode(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_POINTER_TO_FUNCTION) {
            return (Cons.cppTranslateSysPointerToFunction(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_INLINE) ||
              (testValue000 == Stella.SYM_STELLA_IGNORE)) {
            return (Cons.cppTranslateInlineTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_PRINT_STREAM) {
            return (Cons.cppTranslatePrintStream(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_PRINT_NATIVE_STREAM) {
            return (Cons.cppTranslatePrintNativeStream(tree000));
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
    else {
      if (tree == null) {
        return (Stella.cppTranslateNull());
      }
      return (tree.cppTranslateAtomicTree());
    }
  }

  /** Translate <code>statement</code> to C++ and print the result.
   * @param statement
   */
  public static void cpptrans(Stella_Object statement) {
    { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();
      Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
        Native.setSpecial(Stella.$CURRENT_STREAM$, Stella.STANDARD_OUTPUT);
        Keyword.setTranslatorOutputLanguage(Stella.KWD_CPP);
        Stella_Object.incrementallyTranslate(statement);

      } finally {
        Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
      }
    }
  }

  /** Prints a description of 'self' to stream 'stream'.  'mode'
   * can be :terse, :verbose, or :source.  The :terse mode is often equivalent
   * to the standard print function.
   * @param stream
   * @param mode
   */
  public void describeObject(OutputStream stream, Keyword mode) {
    { Stella_Object self = this;

      mode = mode;
      Stella_Object.describeTersely(self, stream);
    }
  }

  public static Stella_Object convertToLiteral(Stella_Object renamed_Object) {
    if (renamed_Object == null) {
      return (renamed_Object);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(renamed_Object);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LITERAL_WRAPPER)) {
        { LiteralWrapper object000 = ((LiteralWrapper)(renamed_Object));

          return (object000);
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol object000 = ((Symbol)(renamed_Object));

          if (object000 == Stella.SYM_STELLA_TRUE) {
            return (Stella.TRUE_WRAPPER);
          }
          if (object000 == Stella.SYM_STELLA_FALSE) {
            return (Stella.FALSE_WRAPPER);
          }
          return (object000);
        }
      }
      else if (Surrogate.subtypeOfKeywordP(testValue000)) {
        { Keyword object000 = ((Keyword)(renamed_Object));

          return (object000);
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate object000 = ((Surrogate)(renamed_Object));

          return (object000);
        }
      }
      else {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: `convert-to-literal': Can't handle non-boolean literals");
        return (null);
      }
    }
  }

  public static boolean literalEqlP(Stella_Object x, Stella_Object y) {
    if (((x != null) &&
        Stella_Object.isaP(x, Stella.SGT_STELLA_BOOLEAN_WRAPPER)) ||
        ((y != null) &&
         Stella_Object.isaP(y, Stella.SGT_STELLA_BOOLEAN_WRAPPER))) {
      return (((((BooleanWrapper)(x)) == null) &&
          (!BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(y))))) ||
          (((((BooleanWrapper)(y)) == null) &&
          (!BooleanWrapper.coerceWrappedBooleanToBoolean(((BooleanWrapper)(x))))) ||
           Stella_Object.eqlP(x, y)));
    }
    return (Stella_Object.eqlP(x, y));
  }

  public static void prettyPrintLiteral(Stella_Object literal, OutputStream stream) {
    if (Surrogate.subtypeOfBooleanP(Stella_Object.safePrimaryType(literal))) {
      { BooleanWrapper literal000 = ((BooleanWrapper)(literal));

        if (literal000 == Stella.TRUE_WRAPPER) {
          stream.nativeStream.print("TRUE");
        }
        else {
          stream.nativeStream.print("FALSE");
        }
      }
    }
    else {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          stream.nativeStream.print(literal);

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static Stella_Object consifyListsAndIterators(Stella_Object tree) {
    if (tree == null) {
      return (tree);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          { ConsIterator cons = tree000.allocateIterator();

            while (cons.nextP()) {
              cons.valueSetter(Stella_Object.consifyListsAndIterators(cons.value));
            }
          }
          return (tree000);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LIST)) {
        { List tree000 = ((List)(tree));

          { Cons conslist = Stella.NIL;

            { Stella_Object item = null;
              Cons iter000 = tree000.theConsList;
              int i = Stella.NULL_INTEGER;
              int iter001 = 0;
              int upperBound000 = Stella.$PRETTY_PRINT_LIST_CUTOFF$;
              boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;
              Cons collect000 = null;

              for (;(!(iter000 == Stella.NIL)) &&
                        (unboundedP000 ||
                         (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
                item = iter000.value;
                i = iter001;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(((i == Stella.$PRETTY_PRINT_LIST_CUTOFF$) ? Stella.ELIPSIS : item), Stella.NIL);
                    if (conslist == Stella.NIL) {
                      conslist = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(conslist, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(((i == Stella.$PRETTY_PRINT_LIST_CUTOFF$) ? Stella.ELIPSIS : item), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            return (conslist);
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_ITERATOR)) {
        { Iterator tree000 = ((Iterator)(tree));

          { Cons conslist = Stella.NIL;

            { Stella_Object item = null;
              Iterator iter002 = tree000;
              int i = Stella.NULL_INTEGER;
              int iter003 = 0;
              int upperBound001 = Stella.$PRETTY_PRINT_LIST_CUTOFF$;
              boolean unboundedP001 = upperBound001 == Stella.NULL_INTEGER;
              Cons collect001 = null;

              for (;iter002.nextP() &&
                        (unboundedP001 ||
                         (iter003 <= upperBound001)); iter003 = iter003 + 1) {
                item = iter002.value;
                i = iter003;
                if (collect001 == null) {
                  {
                    collect001 = Cons.cons(((i == Stella.$PRETTY_PRINT_LIST_CUTOFF$) ? Stella.ELIPSIS : item), Stella.NIL);
                    if (conslist == Stella.NIL) {
                      conslist = collect001;
                    }
                    else {
                      Cons.addConsToEndOfConsList(conslist, collect001);
                    }
                  }
                }
                else {
                  {
                    collect001.rest = Cons.cons(((i == Stella.$PRETTY_PRINT_LIST_CUTOFF$) ? Stella.ELIPSIS : item), Stella.NIL);
                    collect001 = collect001.rest;
                  }
                }
              }
            }
            return (conslist);
          }
        }
      }
      else {
        return (tree);
      }
    }
  }

  public static void describeTersely(Stella_Object self, OutputStream stream) {
    stream.nativeStream.print(self);
  }

  /** Print a description of an object in :verbose, :terse,
   * or :source modes.
   * @param name
   * @param mode
   */
  public static void describe(Stella_Object name, Cons mode) {
    { Stella_Object renamed_Object = ((name == null) ? ((Stella_Object)(null)) : name.getObject(null));
      Stella_Object modespec = mode.value;
      Keyword validmode = null;

      if (modespec == null) {
        modespec = Stella.$DEFAULT_DESCRIBE_MODE$;
      }
      if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(modespec), Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
        { GeneralizedSymbol modespec000 = ((GeneralizedSymbol)(modespec));

          { String testValue000 = modespec000.symbolName;

            if (Stella.stringEqlP(testValue000, "VERBOSE") ||
                (Stella.stringEqlP(testValue000, "TERSE") ||
                 Stella.stringEqlP(testValue000, "SOURCE"))) {
              validmode = Stella.internKeyword(modespec000.symbolName);
            }
            else {
            }
          }
        }
      }
      else {
      }
      if (validmode == null) {
        {
          Stella.STANDARD_OUTPUT.nativeStream.println("Valid modes (the second argument to 'describe') are ");
          Stella.STANDARD_OUTPUT.nativeStream.println("   :VERBOSE, :TERSE, and :SOURCE");
        }
;
        validmode = Stella.$DEFAULT_DESCRIBE_MODE$;
      }
      if (renamed_Object == null) {
        Stella.STANDARD_OUTPUT.nativeStream.print("NULL");
      }
      else {
        renamed_Object.describeObject(Stella.STANDARD_OUTPUT, validmode);
      }
    }
  }

  /** If <code>self</code> is a string or a symbol, search for an object named
   * <code>self</code> of type <code>type</code>.  Otherwise, if <code>self</code> is an object, return it.
   * @param self
   * @param typeref
   * @return Stella_Object
   */
  public static Stella_Object searchForObject(Stella_Object self, Stella_Object typeref) {
    { Surrogate classtype = null;

      if (typeref != null) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(typeref);

          if (Surrogate.subtypeOfSymbolP(testValue000)) {
            { Symbol typeref000 = ((Symbol)(typeref));

              classtype = Surrogate.lookupSurrogateInModule(typeref000.symbolName, ((Module)(typeref000.homeContext)), false);
            }
          }
          else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
            { Surrogate typeref000 = ((Surrogate)(typeref));

              classtype = typeref000;
            }
          }
          else if (Surrogate.subtypeOfStringP(testValue000)) {
            { StringWrapper typeref000 = ((StringWrapper)(typeref));

              classtype = Surrogate.lookupSurrogate(typeref000.wrapperValue);
            }
          }
          else if (Surrogate.subtypeOfClassP(testValue000)) {
            { Stella_Class typeref000 = ((Stella_Class)(typeref));

              classtype = typeref000.classType;
            }
          }
          else {
            Stella.STANDARD_OUTPUT.nativeStream.println("Invalid type reference: `" + typeref + "'");
          }
        }
        if ((classtype != null) &&
            ((classtype.surrogateValue == null) ||
             (!Stella_Object.isaP(classtype.surrogateValue, Stella.SGT_STELLA_CLASS)))) {
          Stella.STANDARD_OUTPUT.nativeStream.println("No class exists with name: `" + classtype.symbolName + "'");
          classtype = null;
        }
      }
      { Surrogate testValue001 = Stella_Object.safePrimaryType(self);

        if (Surrogate.subtypeOfStringP(testValue001)) {
          { StringWrapper self000 = ((StringWrapper)(self));

            { String string = self000.wrapperValue;
              Stella_Object renamed_Object = Stella.stringSearchForObject(string, classtype);
              Module module = null;

              if ((renamed_Object == null) &&
                  Stella.qualifiedStellaNameP(string)) {
                { Object [] caller_MV_returnarray = new Object[1];

                  module = Stella.computeModuleAndBareName(string, caller_MV_returnarray);
                  string = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
                }
                renamed_Object = Stella.stringSearchForObject(string, classtype);
              }
              if (renamed_Object == null) {
                string = Native.stringUpcase(string);
                renamed_Object = Stella.stringSearchForObject(string, classtype);
              }
              return (renamed_Object);
            }
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue001)) {
          { Symbol self000 = ((Symbol)(self));

            return (Stella_Object.searchForObject(StringWrapper.wrapString(self000.symbolName), classtype));
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue001)) {
          { IntegerWrapper self000 = ((IntegerWrapper)(self));

            { int integer = self000.wrapperValue;
              Stella_Object renamed_Object = null;

              { CodeWrapper fn = null;
                Cons iter000 = Stella.$INTEGER_TO_OBJECT_FUNCTIONS$.theConsList;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  fn = ((CodeWrapper)(iter000.value));
                  if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(fn), Stella.SGT_STELLA_FUNCTION_CODE_WRAPPER)) {
                    { FunctionCodeWrapper fn000 = ((FunctionCodeWrapper)(fn));

                      renamed_Object = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(fn000.wrapperValue, null, new java.lang.Object [] {new Integer(integer)})));
                    }
                  }
                  else {
                    { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                      stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(fn) + "' is not a valid case option");
                      throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                    }
                  }
                  if (renamed_Object != null) {
                    return (renamed_Object);
                  }
                }
              }
              return (null);
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_OBJECT)) {
          { Stella_Object self000 = ((Stella_Object)(self));

            return (self000);
          }
        }
        else {
          return (null);
        }
      }
    }
  }

  public Stella_Object getObject(Stella_Object type) {
    { Stella_Object self = this;

      return (Stella_Object.searchForObject(self, type));
    }
  }

  public static Stella_Object get(Stella_Object name, Cons type) {
    { Cons typespec = type;

      return (Stella_Object.searchForObject(name, typespec.value));
    }
  }

  /** Add <code>value</code> to the end of <code>property</code>s (a string or symbol) value
   * list in the configuration table.  Coerces the current value to a list or initializes
   * the list if it is as yet undefined.  Allows incremental addition of values to
   * list-valued propertys.  Note that <code>property</code> is evaluated and will need to be quoted
   * if supplied as a symbol.  Symbols will also be upcased if this command is run in a
   * non-case-sensitive module.
   * @param property
   * @param value
   */
  public static void addPropertyValue(Stella_Object property, Stella_Object value) {
    { String key = Stella_Object.coerceToString(property);

      Stella.addConfigurationProperty(key, value, Stella.$SYSTEM_CONFIGURATION_TABLE$);
    }
  }

  /** Set <code>property</code> (a string or symbol) in the configuration
   * table to <code>value</code>.  Note that <code>property</code> is evaluated and will need to be quoted
   * if supplied as a symbol.  Symbols will also be upcased if this command is run in
   * a non-case-sensitive module.
   * @param property
   * @param value
   */
  public static void setProperty(Stella_Object property, Stella_Object value) {
    { String key = Stella_Object.coerceToString(property);

      Stella.setConfigurationProperty(key, value, Stella.$SYSTEM_CONFIGURATION_TABLE$);
    }
  }

  /** Lookup <code>property</code> (a string or symbol) in the configuration
   * table and return its value.  If it is undefined, return the optional <code>defaultvalue</code>.
   * Note that <code>property</code> is evaluated and will need to be quoted if supplied as a
   * symbol.  Symbols will also be upcased if this command is run in a non-case-
   * sensitive module.
   * @param property
   * @param defaultvalue
   * @return Stella_Object
   */
  public static Stella_Object getProperty(Stella_Object property, Cons defaultvalue) {
    { String key = Stella_Object.coerceToString(property);
      Stella_Object renamed_Default = defaultvalue.value;

      return (Stella.lookupConfigurationProperty(key, renamed_Default, Stella.$SYSTEM_CONFIGURATION_TABLE$));
    }
  }

  public static SystemDefinition defineSystem(Stella_Object name, Cons options) {
    { String stringname = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(name);

        if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper name000 = ((StringWrapper)(name));

            stringname = name000.wrapperValue;
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol name000 = ((Symbol)(name));

            stringname = Native.stringDowncase(name000.symbolName);
          }
        }
        else {
          Stella.STANDARD_OUTPUT.nativeStream.print("Illegal system name: " + name);
          return (null);
        }
      }
      { SystemDefinition self000 = SystemDefinition.newSystemDefinition();

        self000.name = stringname;
        { SystemDefinition system = self000;

          { PropertyList self001 = PropertyList.newPropertyList();

            self001.thePlist = options;
            { PropertyList plist = self001;

              { SystemDefinition value000 = null;

                { SystemDefinition s = null;
                  Cons iter000 = Stella.$SYSTEMDEFINITIONS$.theConsList;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    s = ((SystemDefinition)(iter000.value));
                    if (Stella.stringEqlP(s.name, stringname)) {
                      value000 = s;
                      break loop000;
                    }
                  }
                }
                { SystemDefinition oldsystem = value000;

                  { Stella_Object key = null;
                    Stella_Object value = null;
                    Cons iter001 = plist.thePlist;

                    for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
                      key = iter001.value;
                      value = iter001.rest.value;
                      { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(key));

                        if (testValue001 == Stella.KWD_DIRECTORY) {
                          system.directory = Stella_Object.implodePathname(value);
                        }
                        else if (testValue001 == Stella.KWD_FILES) {
                          system.files = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_REQUIRED_SYSTEMS) {
                          system.requiredSystems = ((Cons)(value));
                          { Stella_Object sys = null;
                            Cons iter002 = ((Cons)(value));

                            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                              sys = iter002.value;
                              Stella.getSystemDefinition(((StringWrapper)(sys)).wrapperValue);
                              if (!Stella.systemLoadedOrStartedUpP(((StringWrapper)(sys)).wrapperValue)) {
                                { Keyword currentaction = Stella.KWD_LOAD_SYSTEM;
                                  Keyword currentlanguage = Stella.runningInLanguage();

                                  if (((PropertyList)(Stella.$CURRENT_SYSTEM_ACTION$.get())) != null) {
                                    currentaction = ((Keyword)(((PropertyList)(Stella.$CURRENT_SYSTEM_ACTION$.get())).lookupWithDefault(Stella.KWD_ACTION, currentaction)));
                                    currentlanguage = ((Keyword)(((PropertyList)(Stella.$CURRENT_SYSTEM_ACTION$.get())).lookupWithDefault(Stella.KWD_LANGUAGE, currentlanguage)));
                                  }
                                  if (currentaction == Stella.KWD_MAKE_SYSTEM) {
                                    Stella.STANDARD_OUTPUT.nativeStream.println("Making required system " + StringWrapper.unwrapString(((StringWrapper)(sys))));
                                    Stella.makeSystem(((StringWrapper)(sys)).wrapperValue, Cons.cons(currentlanguage, Stella.NIL));
                                  }
                                  else {
                                    Stella.STANDARD_OUTPUT.nativeStream.println("Loading required system " + StringWrapper.unwrapString(((StringWrapper)(sys))));
                                    Stella.loadSystem(((StringWrapper)(sys)).wrapperValue, Cons.cons(currentlanguage, Stella.NIL));
                                  }
                                }
                              }
                            }
                          }
                        }
                        else if (testValue001 == Stella.KWD_LISP_ONLY_FILES) {
                          system.lispOnlyFiles = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_CPP_ONLY_FILES) {
                          system.cppOnlyFiles = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_JAVA_ONLY_FILES) {
                          system.javaOnlyFiles = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_DATA_FILES) {
                          system.dataFiles = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_PREPROCESSED_FILES) {
                          system.preprocessedFiles = Cons.parseListOfFilePaths(((Cons)(value)));
                        }
                        else if (testValue001 == Stella.KWD_CARDINAL_MODULE) {
                          system.cardinalModule = ((StringWrapper)(value)).wrapperValue;
                        }
                        else if (testValue001 == Stella.KWD_ROOT_SOURCE_DIRECTORY) {
                          system.sourceRootDirectory = ((StringWrapper)(value)).wrapperValue;
                        }
                        else if (testValue001 == Stella.KWD_ROOT_NATIVE_DIRECTORY) {
                          system.nativeRootDirectory = ((StringWrapper)(value)).wrapperValue;
                        }
                        else if (testValue001 == Stella.KWD_ROOT_BINARY_DIRECTORY) {
                          system.binaryRootDirectory = ((StringWrapper)(value)).wrapperValue;
                        }
                        else if ((testValue001 == Stella.KWD_BANNER) ||
                            (testValue001 == Stella.KWD_COPYRIGHT_HEADER)) {
                          system.banner = ((StringWrapper)(value)).wrapperValue;
                        }
                        else if (testValue001 == Stella.KWD_PRODUCTION_SETTINGS) {
                          system.productionSettings = ((Cons)(value));
                        }
                        else if (testValue001 == Stella.KWD_DEVELOPMENT_SETTINGS) {
                          system.developmentSettings = ((Cons)(value));
                        }
                        else if (testValue001 == Stella.KWD_FINALIZATION_FUNCTION) {
                          system.finalizationFunction = ((Symbol)(value));
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
                  if (system.directory == null) {
                    system.directory = system.name;
                  }
                  Stella.$SYSTEMDEFINITIONS$.push(system);
                  if (oldsystem != null) {
                    {
                      Stella.STANDARD_OUTPUT.nativeStream.println("Redefining system `" + system.name + "'");
                      Stella.STANDARD_OUTPUT.nativeStream.println();
                    }
;
                    Stella.$SYSTEMDEFINITIONS$.remove(oldsystem);
                  }
                  return (system);
                }
              }
            }
          }
        }
      }
    }
  }

  public static Stella_Object evaluateCommand(Stella_Object command, boolean finalizeP) {
    { Object old$Translationerrors$000 = Stella.$TRANSLATIONERRORS$.get();
      Object old$Translationwarnings$000 = Stella.$TRANSLATIONWARNINGS$.get();
      Object old$Translationnotes$000 = Stella.$TRANSLATIONNOTES$.get();
      Object old$IgnoretranslationerrorsP$000 = Stella.$IGNORETRANSLATIONERRORSp$.get();
      Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();
      Object old$Translationphase$000 = Stella.$TRANSLATIONPHASE$.get();
      Object old$Evaluationtree$000 = Stella.$EVALUATIONTREE$.get();

      try {
        Native.setIntSpecial(Stella.$TRANSLATIONERRORS$, 0);
        Native.setIntSpecial(Stella.$TRANSLATIONWARNINGS$, 0);
        Native.setIntSpecial(Stella.$TRANSLATIONNOTES$, 0);
        Native.setBooleanSpecial(Stella.$IGNORETRANSLATIONERRORSp$, false);
        Native.setSpecial(Stella.$TRANSLATIONUNITS$, null);
        Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_DEFINE);
        Native.setSpecial(Stella.$EVALUATIONTREE$, null);
        { Stella_Object operator = null;
          Stella_Object result = null;

          { Surrogate testValue000 = Stella_Object.safePrimaryType(command);

            if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons command000 = ((Cons)(command));

                operator = command000.value;
                if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(operator))) {
                  { Symbol operator000 = ((Symbol)(operator));

                    if (operator000 == Stella.SYM_STELLA_IN_MODULE) {
                      Cons.handleInModuleTree(command000, false, false, new Object[1]);
                    }
                    else {
                      if (Cons.declarationTreeP(command000)) {
                        Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.list(Stella.NIL));
                        Cons.walkTopLevelTree(command000, false);
                        switch (((List)(Stella.$TRANSLATIONUNITS$.get())).reverse().length()) {
                          case 0: 
                            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                              stream000.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
                              if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                                {
                                  stream000.nativeStream.println();
                                  stream000.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                                }
;
                              }
                              stream000.nativeStream.println("':");
                              stream000.nativeStream.print("Couldn't translate `" + command000 + "'");
                              throw ((EvaluationException)(EvaluationException.newEvaluationException(stream000.theStringReader()).fillInStackTrace()));
                            }
                          case 1: 
                            result = ((TranslationUnit)(((List)(Stella.$TRANSLATIONUNITS$.get())).first())).theObject;
                          break;
                          default:
                            { Cons results = Stella.NIL;

                              { TranslationUnit unit = null;
                                Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;
                                Cons collect000 = null;

                                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                                  unit = ((TranslationUnit)(iter000.value));
                                  if (collect000 == null) {
                                    {
                                      collect000 = Cons.cons(unit.theObject, Stella.NIL);
                                      if (results == Stella.NIL) {
                                        results = collect000;
                                      }
                                      else {
                                        Cons.addConsToEndOfConsList(results, collect000);
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
                              result = results;
                            }
                          break;
                        }
                      }
                      else if (Stella.stringEqualP(operator000.symbolName, "in-package")) {
                      }
                      else {
                        Stella_Object.evaluate(command000);
                      }
                    }
                  }
                }
                else {
                  Stella_Object.evaluate(command000);
                }
              }
            }
            else if (Surrogate.subtypeOfKeywordP(testValue000)) {
              { Keyword command000 = ((Keyword)(command));

                result = command000;
              }
            }
            else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
              { Surrogate command000 = ((Surrogate)(command));

                result = command000;
              }
            }
            else {
              Stella_Object.evaluate(command);
            }
          }
          if ((!Stella.translationErrorsP()) &&
              finalizeP) {
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_FINALIZE);
            if (((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) {
              SystemDefinition.runSystemFinalization(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())));
            }
            else {
              Stella.STANDARD_OUTPUT.nativeStream.println("Can't run finalization because *currentSystemDefinition* is not set.");
            }
          }
          return (result);
        }

      } finally {
        Stella.$EVALUATIONTREE$.set(old$Evaluationtree$000);
        Stella.$TRANSLATIONPHASE$.set(old$Translationphase$000);
        Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
        Stella.$IGNORETRANSLATIONERRORSp$.set(old$IgnoretranslationerrorsP$000);
        Stella.$TRANSLATIONNOTES$.set(old$Translationnotes$000);
        Stella.$TRANSLATIONWARNINGS$.set(old$Translationwarnings$000);
        Stella.$TRANSLATIONERRORS$.set(old$Translationerrors$000);
      }
    }
  }

  /** Parse <code>options</code>, check their validity according to
   * <code>legalOptionsATypes</code> and return the result as a PROPERTY-LIST.
   * <code>legalOptionsATypes</code> has to either be NULL or a flat list of legal
   * &lt;keyword&gt; &lt;coercionType&gt; pairs.  A type specifcation of @IDENTITY
   * means don't perform any coercion.
   * If <code>coercionErrorP</code> is TRUE, raise an error if a coercion failed.
   * If <code>allowOtherKeysP</code> is TRUE options other than those specified in
   * <code>legalOptionsATypes</code> are allowed but won't be coerced since we don't
   * know their type.
   * @param options
   * @param legaloptionsAtypes
   * @param coercionerrorP
   * @param allowotherkeysP
   * @return PropertyList
   */
  public static PropertyList parseOptions(Stella_Object options, Cons legaloptionsAtypes, boolean coercionerrorP, boolean allowotherkeysP) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = legaloptionsAtypes;
      { PropertyList legaloptions = self000;
        PropertyList parsedoptions = null;
        Surrogate type = null;
        Stella_Object coercedvalue = null;

        { Surrogate testValue000 = Stella_Object.safePrimaryType(options);

          if (testValue000 == Stella.SGT_STELLA_CONS) {
            { Cons options000 = ((Cons)(options));

              if ((((options000.length()) % 2) == 1)) {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("Odd-length options list: `" + options000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              { PropertyList self003 = PropertyList.newPropertyList();

                self003.thePlist = options000;
                parsedoptions = self003;
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_PROPERTY_LIST)) {
            { PropertyList options000 = ((PropertyList)(options));

              parsedoptions = options000;
            }
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("Illegal options specification: `" + options + "'");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }
        if (legaloptions != null) {
          { Stella_Object key = null;
            Stella_Object value = null;
            Cons iter000 = parsedoptions.thePlist;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
              key = iter000.value;
              value = iter000.rest.value;
              type = ((Surrogate)(legaloptions.lookup(key)));
              if ((type == null) &&
                  (!allowotherkeysP)) {
                { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                  stream002.nativeStream.print("Illegal option: `" + key + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                }
              }
              if (!((type == Stella.SGT_STELLA_IDENTITY) ||
                  (value == null))) {
                coercedvalue = Stella_Object.coerceValueToType(value, type, coercionerrorP);
                parsedoptions.insertAt(key, coercedvalue);
              }
            }
          }
        }
        return (parsedoptions);
      }
    }
  }

  public static PropertyList vetOptions(Stella_Object plist, Cons legaloptions) {
    { PropertyList propertylist = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(plist);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_PROPERTY_LIST)) {
          { PropertyList plist000 = ((PropertyList)(plist));

            propertylist = plist000;
          }
        }
        else if (testValue000 == Stella.SGT_STELLA_CONS) {
          { Cons plist000 = ((Cons)(plist));

            { PropertyList self000 = PropertyList.newPropertyList();

              self000.thePlist = plist000;
              propertylist = self000;
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LIST)) {
          { List plist000 = ((List)(plist));

            { PropertyList self001 = PropertyList.newPropertyList();

              self001.thePlist = plist000.theConsList;
              propertylist = self001;
            }
          }
        }
        else {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal argument passed to 'vet-options'");
          return (PropertyList.newPropertyList());
        }
      }
      { Stella_Object key = null;
        Stella_Object value = null;
        Cons iter000 = propertylist.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          key = iter000.value;
          value = iter000.rest.value;
          if ((!Stella_Object.stellaObjectP(key)) ||
              ((!Stella_Object.keywordP(key)) ||
               ((legaloptions != null) &&
                (!legaloptions.memberP(key))))) {
            value = value;
            if (!Stella_Object.stellaObjectP(key)) {
              { PropertyList newplist = PropertyList.newPropertyList();

                { Stella_Object key000 = null;
                  Stella_Object value000 = null;
                  Cons iter001 = propertylist.thePlist;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
                    key000 = iter001.value;
                    value000 = iter001.rest.value;
                    newplist.insertAt(Stella_Object.stellify(key000), Stella_Object.stellify(value000));
                  }
                }
                propertylist.thePlist = newplist.thePlist;
              }
              Stella_Object.vetOptions(propertylist, legaloptions);
              return (propertylist);
            }
            propertylist.removeAt(key);
            {
              Stella.STANDARD_OUTPUT.nativeStream.println("Skipping illegal option: `" + key + "'");
              Stella.STANDARD_OUTPUT.nativeStream.println();
            }
;
            if (Stella_Object.keywordP(key)) {
              {
                Stella.STANDARD_OUTPUT.nativeStream.println("   Legal options are: `" + legaloptions + "'");
                Stella.STANDARD_OUTPUT.nativeStream.println();
              }
;
            }
            else {
              Stella.STANDARD_OUTPUT.nativeStream.println("   Option must be a keyword.");
            }
            Stella_Object.vetOptions(propertylist, legaloptions);
            return (propertylist);
          }
        }
      }
      return (propertylist);
    }
  }

  /** Coerce <code>value</code> to <code>type</code>.  Return NULL if not possible.
   * @param value
   * @param type
   * @return Stella_Object
   */
  public static Stella_Object coerceOptionValue(Stella_Object value, Surrogate type) {
    return (Stella_Object.coerceValueToType(value, type, false));
  }

  /** Coerce <code>value</code> to <code>type</code>.  Return NULL if not possible
   * or raise an error if <code>errorP</code> is TRUE.
   * @param value
   * @param type
   * @param errorP
   * @return Stella_Object
   */
  public static Stella_Object coerceValueToType(Stella_Object value, Surrogate type, boolean errorP) {
    if (type == Stella.SGT_STELLA_INTEGER) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

        if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper value000 = ((IntegerWrapper)(value));

            return (value000);
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper value000 = ((FloatWrapper)(value));

            return (IntegerWrapper.wrapInteger(Native.floor(value000.wrapperValue)));
          }
        }
        else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
          { LongIntegerWrapper value000 = ((LongIntegerWrapper)(value));

            if ((value000.wrapperValue >= Stella.NULL_INTEGER) &&
                (value000.wrapperValue <= Stella.MOST_POSITIVE_INTEGER)) {
              return (value000);
            }
          }
        }
        else {
        }
      }
    }
    else if (type == Stella.SGT_STELLA_FLOAT) {
      { double val = Stella_Object.coerceValueToFloat(value, errorP);

        if (val != Stella.NULL_FLOAT) {
          return (FloatWrapper.wrapFloat(val));
        }
        else {
          return (null);
        }
      }
    }
    else if (type == Stella.SGT_STELLA_NUMBER) {
      { Surrogate testValue001 = Stella_Object.safePrimaryType(value);

        if (Surrogate.subtypeOfIntegerP(testValue001)) {
          { IntegerWrapper value000 = ((IntegerWrapper)(value));

            return (value000);
          }
        }
        else if (Surrogate.subtypeOfLongIntegerP(testValue001)) {
          { LongIntegerWrapper value000 = ((LongIntegerWrapper)(value));

            return (value000);
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue001)) {
          { FloatWrapper value000 = ((FloatWrapper)(value));

            return (value000);
          }
        }
        else {
        }
      }
    }
    else if (type == Stella.SGT_STELLA_STRING) {
      { String val = Stella_Object.coerceValueToString(value, errorP);

        if (val != null) {
          return (StringWrapper.wrapString(val));
        }
        else {
          return (null);
        }
      }
    }
    else if (type == Stella.SGT_STELLA_KEYWORD) {
      { Surrogate testValue002 = Stella_Object.safePrimaryType(value);

        if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
          { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

            return (value000.keywordify());
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue002)) {
          { StringWrapper value000 = ((StringWrapper)(value));

            return (value000.keywordify());
          }
        }
        else {
        }
      }
    }
    else if (type == Stella.SGT_STELLA_SYMBOL) {
      { Surrogate testValue003 = Stella_Object.safePrimaryType(value);

        if (Surrogate.subtypeOfKeywordP(testValue003)) {
          { Keyword value000 = ((Keyword)(value));

            return (Symbol.internSymbol(value000.symbolName));
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue003)) {
          { Surrogate value000 = ((Surrogate)(value));

            return (Symbol.internDerivedSymbol(value000, value000.symbolName));
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue003)) {
          { Symbol value000 = ((Symbol)(value));

            return (value000);
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue003)) {
          { StringWrapper value000 = ((StringWrapper)(value));

            return (Symbol.internSymbol(value000.wrapperValue));
          }
        }
        else {
        }
      }
    }
    else if (type == Stella.SGT_STELLA_BOOLEAN) {
      return (Stella_Object.coerceValueToBoolean(value, errorP));
    }
    else if (type == Stella.SGT_STELLA_MODULE) {
      { Module module = Stella_Object.coerceToModule(value, false);

        if (module != null) {
          return (module);
        }
      }
    }
    else {
      if (type == null) {
        return (value);
      }
      else if (Stella_Object.isaP(value, type)) {
        return (value);
      }
      else if (Stella_Object.isaP(value, type.typeToWrappedType())) {
        return (value);
      }
    }
    if (errorP) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("coerce-value-to-type: don't know how to coerce `" + value + "' to type `" + type + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      return (null);
    }
  }

  /** Coerce <code>number</code> to a float value or NULL if not possible.
   * @param renamed_Object
   * @return double
   */
  public static double coerceToFloat(Stella_Object renamed_Object) {
    return (Stella_Object.coerceValueToFloat(renamed_Object, false));
  }

  /** Coerce <code>value</code> to a float value if possible, return
   * NULL otherwise or raise an error if <code>errorP</code> is true.
   * @param value
   * @param errorP
   * @return double
   */
  public static double coerceValueToFloat(Stella_Object value, boolean errorP) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

      if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper value000 = ((IntegerWrapper)(value));

          return (value000.wrapperValue * 1.0);
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper value000 = ((LongIntegerWrapper)(value));

          return (value000.wrapperValue * 1.0);
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper value000 = ((FloatWrapper)(value));

          return (value000.wrapperValue);
        }
      }
      else {
      }
    }
    if (errorP) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("coerce-value-to-float: don't know how to coerce `" + value + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      return (Stella.NULL_FLOAT);
    }
  }

  /** Coerce <code>renamed_Object</code> into a string.  If no standard coercion
   * is possible, simply stringify <code>renamed_Object</code>.
   * @param renamed_Object
   * @return String
   */
  public static String coerceToString(Stella_Object renamed_Object) {
    { String string = Stella_Object.coerceValueToString(renamed_Object, false);

      if (string == null) {
        string = Native.stringify(renamed_Object);
      }
      return (string);
    }
  }

  /** Coerce <code>value</code> into a string if possible, return NULL
   * otherwise or raise an error if <code>errorP</code> is true.
   * @param value
   * @param errorP
   * @return String
   */
  public static String coerceValueToString(Stella_Object value, boolean errorP) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper value000 = ((StringWrapper)(value));

          return (value000.wrapperValue);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
        { GeneralizedSymbol value000 = ((GeneralizedSymbol)(value));

          return (value000.symbolName);
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper value000 = ((IntegerWrapper)(value));

          return (Native.integerToString(((long)(value000.wrapperValue))));
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper value000 = ((LongIntegerWrapper)(value));

          return (Native.integerToString(value000.wrapperValue));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper value000 = ((FloatWrapper)(value));

          return (Native.floatToString(value000.wrapperValue));
        }
      }
      else {
      }
    }
    if (errorP) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("coerce-value-to-string: don't know how to coerce `" + value + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      return (null);
    }
  }

  /** Return the boolean object represented by <code>renamed_Object</code>.
   * Return NULL if coercion is not possible.
   * @param renamed_Object
   * @return BooleanWrapper
   */
  public static BooleanWrapper coerceToBoolean(Stella_Object renamed_Object) {
    return (Stella_Object.coerceValueToBoolean(renamed_Object, false));
  }

  /** Return the boolean object represented by <code>value</code>.  Return NULL
   * if coercion is not possible or raise an error if <code>errorP</code> is TRUE.
   * @param value
   * @param errorP
   * @return BooleanWrapper
   */
  public static BooleanWrapper coerceValueToBoolean(Stella_Object value, boolean errorP) {
    if ((value == Stella.SYM_STELLA_TRUE) ||
        (value == Stella.KWD_TRUE)) {
      return (Stella.TRUE_WRAPPER);
    }
    else if ((value == Stella.SYM_STELLA_FALSE) ||
        (value == Stella.KWD_FALSE)) {
      return (Stella.FALSE_WRAPPER);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(value);

      if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol value000 = ((Symbol)(value));

          if (Stella.stringEqualP(value000.symbolName, "TRUE")) {
            return (Stella.TRUE_WRAPPER);
          }
          else if (Stella.stringEqualP(value000.symbolName, "FALSE")) {
            return (Stella.FALSE_WRAPPER);
          }
        }
      }
      else if (Surrogate.subtypeOfKeywordP(testValue000)) {
        { Keyword value000 = ((Keyword)(value));

          if (Stella.stringEqualP(value000.symbolName, "TRUE")) {
            return (Stella.TRUE_WRAPPER);
          }
          else if (Stella.stringEqualP(value000.symbolName, "FALSE")) {
            return (Stella.FALSE_WRAPPER);
          }
        }
      }
      else if (Surrogate.subtypeOfBooleanP(testValue000)) {
        { BooleanWrapper value000 = ((BooleanWrapper)(value));

          return (value000);
        }
      }
      else {
      }
    }
    if (errorP) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("coerce-value-to-boolean: can't coerce `" + value + "' of type `" + (((value != null) ? value.primaryType() : Stella.SGT_STELLA_UNKNOWN)) + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    else {
      return (null);
    }
  }

  public static boolean stellaNeedToCompileP(Stella_Object file) {
    { String sourcefile = Stella.makeFileName(((StringWrapper)(file)).wrapperValue, Stella.KWD_LISP, true);
      String compiledfile = Stella.makeFileName(((StringWrapper)(file)).wrapperValue, Stella.KWD_LISP_BINARY, true);

      return (!(Stella.fileYoungerThanP(compiledfile, sourcefile) == Stella.TRUE_WRAPPER));
    }
  }

  public static boolean stellaNeedToTranslateP(Stella_Object file, Keyword language) {
    if (language == Stella.KWD_JAVA) {
      return (true);
    }
    { String sourcefile = Stella.makeFileName(((StringWrapper)(file)).wrapperValue, Stella.KWD_STELLA, true);
      String translatedfile = Stella.makeFileName(((StringWrapper)(file)).wrapperValue, Keyword.languageToFileType(language), true);

      return (Stella.probeFileP(sourcefile) &&
          (!(Stella.fileYoungerThanP(translatedfile, sourcefile) == Stella.TRUE_WRAPPER)));
    }
  }

  public static String implodePathname(Stella_Object filepath) {
    { String file = null;

      if (Stella_Object.safePrimaryType(filepath) == Stella.SGT_STELLA_CONS) {
        { Cons filepath000 = ((Cons)(filepath));

          { int pathLength = filepath000.length();

            file = "";
            { StringWrapper name = null;
              Cons iter000 = ((Cons)(filepath000));
              int n = Stella.NULL_INTEGER;
              int iter001 = 1;
              int upperBound000 = pathLength;
              boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

              for (;(!(iter000 == Stella.NIL)) &&
                        (unboundedP000 ||
                         (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
                name = ((StringWrapper)(iter000.value));
                n = iter001;
                if (n == pathLength) {
                  file = file + Stella.helpImplodePathname(name.wrapperValue);
                }
                else {
                  file = file + name.wrapperValue + Stella.directorySeparatorString();
                }
              }
            }
          }
        }
      }
      else {
        file = Stella.helpImplodePathname(((StringWrapper)(filepath)).wrapperValue);
      }
      return (file);
    }
  }

  public static String makeFileNameFromRelativePath(Stella_Object filepath, Keyword type) {
    return (Stella.makeFileName(Stella_Object.implodePathname(filepath), type, true));
  }

  public static Cons makeMemoizedValueEntryn(Stella_Object value, Cons args) {
    return (Cons.cons(value, args));
  }

  public static Cons makeMemoizedValueEntry(Stella_Object value, Stella_Object arg1, Stella_Object arg2, Stella_Object arg3, Stella_Object arg4) {
    { Cons entry = Stella.NIL;
      Cons cursor = Stella.NIL;
      Cons cell = Stella.NIL;

      entry = new Cons();
      entry.value = value;
      cell = new Cons();
      entry.rest = cell;
      cell.value = arg1;
      if (arg2 == Stella.MEMOIZED_NULL_VALUE) {
        cell.rest = Stella.NIL;
        return (entry);
      }
      cursor = cell;
      cell = new Cons();
      cursor.rest = cell;
      cell.value = arg2;
      if (arg3 == Stella.MEMOIZED_NULL_VALUE) {
        cell.rest = Stella.NIL;
        return (entry);
      }
      cursor = cell;
      cell = new Cons();
      cursor.rest = cell;
      cell.value = arg3;
      if (arg4 == Stella.MEMOIZED_NULL_VALUE) {
        cell.rest = Stella.NIL;
        return (entry);
      }
      cursor = cell;
      cell = new Cons();
      cursor.rest = cell;
      cell.value = arg4;
      cell.rest = Stella.NIL;
      return (entry);
    }
  }

  public static int hashMemoizedArguments(Stella_Object arg1, Stella_Object arg2, Stella_Object arg3, Stella_Object arg4, int eqvector) {
    { int hashcode = 0;

      if (eqvector < 0) {
        if (arg1 == null) {
          arg1 = Stella.MEMOIZED_NULL_VALUE;
        }
        hashcode = arg1.hashCode();
        loop000 : for (;;) {
          if (arg2 == Stella.MEMOIZED_NULL_VALUE) {
            break loop000;
          }
          if (arg2 == null) {
            arg2 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ (arg2.hashCode()));
          if (arg3 == Stella.MEMOIZED_NULL_VALUE) {
            break loop000;
          }
          if (arg3 == null) {
            arg3 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ (arg3.hashCode()));
          if (arg4 == Stella.MEMOIZED_NULL_VALUE) {
            break loop000;
          }
          if (arg4 == null) {
            arg4 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ (arg4.hashCode()));
          break loop000;
        }
      }
      else {
        if (arg1 == null) {
          arg1 = Stella.MEMOIZED_NULL_VALUE;
        }
        hashcode = (((eqvector & 1) == 0) ? arg1.hashCode_() : arg1.hashCode());
        loop001 : for (;;) {
          if (arg2 == Stella.MEMOIZED_NULL_VALUE) {
            break loop001;
          }
          if (arg2 == null) {
            arg2 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ ((((eqvector & 2) == 0) ? arg2.hashCode_() : arg2.hashCode())));
          if (arg3 == Stella.MEMOIZED_NULL_VALUE) {
            break loop001;
          }
          if (arg3 == null) {
            arg3 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ ((((eqvector & 4) == 0) ? arg3.hashCode_() : arg3.hashCode())));
          if (arg4 == Stella.MEMOIZED_NULL_VALUE) {
            break loop001;
          }
          if (arg4 == null) {
            arg4 = Stella.MEMOIZED_NULL_VALUE;
          }
          hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
          hashcode = (hashcode ^ ((((eqvector & 8) == 0) ? arg4.hashCode_() : arg4.hashCode())));
          break loop001;
        }
      }
      return (hashcode);
    }
  }

  /** Set *currentSystemDefinition* to the system definition named <code>system</code>.
   * Set *currentSystemDefinitionSubdirectory* to match. Execute <code>body</code> within
   * that scope.
   * @param systemnameexpression
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withSystemDefinition(Stella_Object systemnameexpression, Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITION$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_SYSTEM_DEFINITION, Cons.cons(systemnameexpression, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ONLY_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITION$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DIRECTORY, Cons.cons(Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITION$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_$CURRENTSYSTEMDEFINITION$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_PROGN, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WARN, Cons.cons(StringWrapper.wrapString("Can't find a system named "), Cons.cons(systemnameexpression, Cons.cons(Cons.cons(Stella.SYM_STELLA_EOL, Stella.NIL), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))));
  }

  /** Execute <code>body</code> within the module resulting from <code>moduleform</code>.
   * <code>$MODULE$</code> is an acceptable <code>moduleform</code>.  It will locally rebind 
   * <code>$MODULE$</code> and <code>$CONTEXT$</code> and shield the outer bindings from changes.
   * @param moduleform
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withinModule(Stella_Object moduleform, Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$MODULE$, Cons.cons(moduleform, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(Stella.SYM_STELLA_$MODULE$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Execute <code>body</code> within the context resulting from <code>contextform</code>.
   * @param contextform
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withinContext(Stella_Object contextform, Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(contextform, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$MODULE$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BASE_MODULE, Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Execute <code>body</code> within the world resulting from <code>worldform</code>.
   * @param worldform
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withinWorld(Stella_Object worldform, Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(worldform, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFETY, Cons.cons(IntegerWrapper.wrapInteger(3), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQLp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BASE_MODULE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(Stella.SYM_STELLA_WORLD, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_$MODULE$, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(StringWrapper.wrapString("within-world: The base module of world "), Cons.cons(Stella.SYM_STELLA_$CONTEXT$, Cons.cons(StringWrapper.wrapString(" does not match the current module."), Cons.cons(Stella.NIL, Stella.NIL)))))))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))));
  }

  /** If 'test' is TRUE, return the result of evaluating 
   * 'expression'.
   * @param test
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object onlyIf(Stella_Object test, Stella_Object expression) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(test, Cons.cons(Cons.cons(expression, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL)), Stella.NIL)))));
  }

  /** If 'value1' is defined, return that, else return 'value2'.
   * @param value1
   * @param value2
   * @return Stella_Object
   */
  public static Stella_Object either(Stella_Object value1, Stella_Object value2) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_FIRST_DEFINED, Cons.cons(value1, Cons.cons(Cons.cons(value2, Stella.NIL), Stella.NIL)))));
  }

  /** Subtract 1 from 'expression' and return the result.
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object one(Stella_Object expression) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA__, Cons.cons(expression, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(1), Stella.NIL), Stella.NIL)))));
  }

  /** Add 1 to 'expression' and return the result.
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object oneI(Stella_Object expression) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(expression, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(1), Stella.NIL), Stella.NIL)))));
  }

  /** Decrement the value of <code>place</code> and return the result.
   * <code>place</code> can be either a variable name or a slot reference.  Decrement by
   * the optional <code>decrement</code> (which can be a float) or 1 otherwise.
   * @param place
   * @param decrement
   * @return Stella_Object
   */
  public static Stella_Object _(Stella_Object place, Cons decrement) {
    { Stella_Object decr = decrement.value;

      if (!(Stella_Object.symbolP(place) ||
          Stella_Object.consP(place))) {
        if (place == null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing place in `--' expression.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
        }
        else {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal place in `--' expression: `" + Stella_Object.deUglifyParseTree(place) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
        }
        return (Stella.NIL);
      }
      if (decr == null) {
        decr = Stella.ONE_WRAPPER;
      }
      return ((Stella_Object.symbolP(place) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(place, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA__, Cons.cons(place, Cons.cons(Cons.cons(decr, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(place, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA__, Cons.cons(Stella_Object.copyConsTree(place), Cons.cons(Cons.cons(decr, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))));
    }
  }

  /** Increment the value of <code>place</code> and return the result.
   * <code>place</code> can be either a variable name or a slot reference.  Increment by
   * the optional <code>increment</code> (which can be a float) or 1 otherwise.
   * @param place
   * @param increment
   * @return Stella_Object
   */
  public static Stella_Object stella_Increment(Stella_Object place, Cons increment) {
    { Stella_Object incr = increment.value;

      if (!(Stella_Object.symbolP(place) ||
          Stella_Object.consP(place))) {
        if (place == null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing place in `++' expression.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
        }
        else {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal place in `++' expression: `" + Stella_Object.deUglifyParseTree(place) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
        }
        return (Stella.NIL);
      }
      if (incr == null) {
        incr = Stella.ONE_WRAPPER;
      }
      return ((Stella_Object.symbolP(place) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(place, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(place, Cons.cons(Cons.cons(incr, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(place, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella_Object.copyConsTree(place), Cons.cons(Cons.cons(incr, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))));
    }
  }

  /** A case form for matching <code>item</code> against XML element tags.  Each
   * element of <code>clauses</code> should be a clause with the form
   *   (&quot;tagname&quot; ...)     or
   *   ((&quot;tagname&quot; &quot;namespace-uri&quot;) ...)
   * The clause heads can optionally be symbols instead of strings.  The key forms the
   * parameters to the method <code>xmlElementMatchP</code>, with a missing namespace argument
   * passed as NULL.
   * <p>
   * The namespace argument will be evaluated, so one can use bound variables in
   * place of a fixed string.   As a special case, if the namespace argument is
   * :ANY, then the test will be done for a match on the tag name alone.
   * @param item
   * @param clauses
   * @return Stella_Object
   */
  public static Stella_Object xmlTagCase(Stella_Object item, Cons clauses) {
    if (Stella_Object.isaP(item, Stella.SGT_STELLA_SYMBOL)) {
      return (Symbol.expandXmlTagCase(((Symbol)(item)), clauses));
    }
    else {
      { Symbol var = Stella.localGensym("ITEM");

        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(var, Cons.list$(Cons.cons(Stella.SYM_STELLA_XML_ELEMENT, Cons.cons(item, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Symbol.expandXmlTagCase(var, clauses), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
    }
  }

  /** Return <code>true</code> if <code>form</code> is a CONS headed by a CDATA tag
   * @param form
   * @return boolean
   */
  public static boolean xmlCdataFormP(Stella_Object form) {
    return (Stella_Object.isaP(form, Stella.SGT_STELLA_CONS) &&
        Stella_Object.xmlCdataP(((Cons)(form)).value));
  }

  /** Return <code>true</code> if <code>form</code> is a CONS headed by a DOCTYPE tag
   * @param form
   * @return boolean
   */
  public static boolean xmlDoctypeFormP(Stella_Object form) {
    return ((Stella_Object.isaP(form, Stella.SGT_STELLA_CONS) &&
        Stella_Object.isaP(((Cons)(form)).value, Stella.SGT_STELLA_XML_DECLARATION)) &&
        Stella.stringEqlP(((XmlDeclaration)(((Cons)(form)).value)).name, "DOCTYPE"));
  }

  /** Return <code>true</code> if <code>form</code> is a CONS headed by an XML DECLARATION tag
   * @param form
   * @return boolean
   */
  public static boolean xmlDeclarationFormP(Stella_Object form) {
    return (Stella_Object.isaP(form, Stella.SGT_STELLA_CONS) &&
        Stella_Object.isaP(((Cons)(form)).value, Stella.SGT_STELLA_XML_DECLARATION));
  }

  /** Return <code>true</code> if <code>form</code> is a CONS headed by an XML PROCESSING INSTRUCTION tag
   * @param form
   * @return boolean
   */
  public static boolean xmlProcessingInstructionFormP(Stella_Object form) {
    return (Stella_Object.isaP(form, Stella.SGT_STELLA_CONS) &&
        Stella_Object.isaP(((Cons)(form)).value, Stella.SGT_STELLA_XML_PROCESSING_INSTRUCTION));
  }

  /** Return <code>true</code> if <code>form</code> is a CONS headed by an XML ELEMENT tag
   * @param form
   * @return boolean
   */
  public static boolean xmlElementFormP(Stella_Object form) {
    return (Stella_Object.isaP(form, Stella.SGT_STELLA_CONS) &&
        Stella_Object.isaP(((Cons)(form)).value, Stella.SGT_STELLA_XML_ELEMENT));
  }

  /** Return <code>true</code> if <code>item</code> is an XML processing instruction object
   * @param item
   * @return boolean
   */
  public static boolean xmlProcessingInstructionP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_PROCESSING_INSTRUCTION));
  }

  /** Return <code>true</code> if <code>item</code> is an XML declaration object
   * @param item
   * @return boolean
   */
  public static boolean xmlDeclarationP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_DECLARATION));
  }

  /** Return <code>true</code> if <code>item</code> is an XML attribute object
   * @param item
   * @return boolean
   */
  public static boolean xmlBaseAttributeP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_GLOBAL_ATTRIBUTE) &&
        (Stella.stringEqlP("base", ((XmlGlobalAttribute)(item)).name) &&
         Stella.stringEqlP(Stella.$XML_URN$, ((XmlGlobalAttribute)(item)).namespaceUri)));
  }

  /** Return <code>true</code> if <code>item</code> is an XML attribute object
   * @param item
   * @return boolean
   */
  public static boolean xmlLocalAttributeP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_LOCAL_ATTRIBUTE));
  }

  /** Return <code>true</code> if <code>item</code> is an XML attribute object
   * @param item
   * @return boolean
   */
  public static boolean xmlGlobalAttributeP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_GLOBAL_ATTRIBUTE));
  }

  /** Return <code>true</code> if <code>item</code> is an XML attribute object
   * @param item
   * @return boolean
   */
  public static boolean xmlAttributeP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_ATTRIBUTE));
  }

  /** Return <code>true</code> if <code>item</code> is an XML element object
   * @param item
   * @return boolean
   */
  public static boolean xmlElementP(Stella_Object item) {
    return (Stella_Object.isaP(item, Stella.SGT_STELLA_XML_ELEMENT));
  }

  /** Return <code>true</code> if <code>item</code> is an XML CDATA tag object
   * @param item
   * @return boolean
   */
  public static boolean xmlCdataP(Stella_Object item) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(item), Stella.SGT_STELLA_XML_SPECIAL)) {
      { XmlSpecial item000 = ((XmlSpecial)(item));

        return (Stella.stringEqlP(item000.name, "CDATA"));
      }
    }
    else {
      return (false);
    }
  }

  public static XmlElement coerceToXmlElement(Stella_Object regiontag) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(regiontag);

      if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol regiontag000 = ((Symbol)(regiontag));

          return (Stella.makeXmlElement(regiontag000.symbolName, "", null));
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_XML_ELEMENT)) {
        { XmlElement regiontag000 = ((XmlElement)(regiontag));

          return (regiontag000);
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper regiontag000 = ((StringWrapper)(regiontag));

          return (Stella.makeXmlElement(regiontag000.wrapperValue, "", null));
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons regiontag000 = ((Cons)(regiontag));

          if (regiontag000.rest == Stella.NIL) {
            return (Stella_Object.coerceToXmlElement(regiontag000.value));
          }
          else {
            { Stella_Object name = regiontag000.value;
              StringWrapper namespace = ((StringWrapper)(regiontag000.rest.value));

              { Surrogate testValue001 = Stella_Object.safePrimaryType(name);

                if (Surrogate.subtypeOfSymbolP(testValue001)) {
                  { Symbol name000 = ((Symbol)(name));

                    return (Stella.makeXmlElement(name000.symbolName, "", namespace.wrapperValue));
                  }
                }
                else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_XML_ELEMENT)) {
                  { XmlElement name000 = ((XmlElement)(name));

                    return (name000);
                  }
                }
                else if (Surrogate.subtypeOfStringP(testValue001)) {
                  { StringWrapper name000 = ((StringWrapper)(name));

                    return (Stella.makeXmlElement(name000.wrapperValue, "", namespace.wrapperValue));
                  }
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
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Checks to see if this <code>attribute</code> is the literal marking either
   * a PUBLIC or SYSTEM literal for an XML Elternal ID.  (See 4.2.2)
   * @param attribute
   * @return boolean
   */
  static boolean externalIdHeadP(Stella_Object attribute) {
    return (Stella_Object.isaP(attribute, Stella.SGT_STELLA_STRING_WRAPPER) &&
        (Stella.stringEqlP(((StringWrapper)(attribute)).wrapperValue, "SYSTEM") ||
         Stella.stringEqlP(((StringWrapper)(attribute)).wrapperValue, "PUBLIC")));
  }

  public static boolean xmlnsAttributeP(Stella_Object attribute) {
    return (Stella_Object.isaP(attribute, Stella.SGT_STELLA_XML_GLOBAL_ATTRIBUTE) &&
        Stella.stringEqlP("xmlns", ((XmlGlobalAttribute)(attribute)).namespaceName));
  }

  public static Stella_Object withStellaTokenizer(Stella_Object input, Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WITH_TOKENIZER, Cons.cons(Stella.SYM_STELLA_$STELLA_TOKENIZER_TABLE$, Cons.cons(input, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STELLALOGICALSTATENAMES_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_ARRAY, Cons.cons(Stella.SYM_STELLA_$STELLA_LOGICAL_STATE_NAMES$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STELLALOGICALSTATENAME_, Cons.cons(Stella.SYM_STELLA_KEYWORD, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))));
  }

  public static Stella_Object withTokenizer(Stella_Object table, Stella_Object input, Cons body) {
    { Stella_Object inputtree = null;
      StandardObject inputtype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        inputtree = Stella_Object.walkATree(input, caller_MV_returnarray);
        inputtype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      if (!(StandardObject.subTypeSpecOfP(inputtype, Stella.SGT_STELLA_INPUT_STREAM) ||
          StandardObject.subTypeSpecOfP(inputtype, Stella.SGT_STELLA_STRING))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" with-tokenizer: Can't handle input of type `" + Stella_Object.deUglifyParseTree(inputtype) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(body, Stella.SGT_STELLA_VOID, new Object[1]));
      }
      { boolean stringP = StandardObject.subTypeSpecOfP(inputtype, Stella.SGT_STELLA_STRING) ||
            StandardObject.subTypeSpecOfP(inputtype, Stella.SGT_STELLA_MUTABLE_STRING);
        Cons expansion = Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(table, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_TRANSITIONS_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TRANSITIONS, Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STATENAMES_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_ARRAY, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STATE_NAMES, Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(((stringP ? Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.SYM_STELLA_TOKENIZER_STREAM_STATE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING_TO_TOKENIZER_BYTE_ARRAY, Cons.cons(input, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LENGTH, Cons.cons(input, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))))) : Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella_Object.sysTree(inputtree, inputtype, new Object[1]), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_ECHOSTREAM_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ECHO_STREAM, Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOKENIZER_STATE, Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOKENIZER_STATE, Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_TOKENIZER_STREAM_STATE, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOKENIZER_STATE, Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BUFFER, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BUFFER_SIZE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_SAVED_STATE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURSOR, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_END, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_le, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))))))))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_TOK_STATENAMES_, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(((stringP ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL)))));

        { Object old$Withtokenizerinputtype$000 = Stella.$WITHTOKENIZERINPUTTYPE$.get();

          try {
            Native.setSpecial(Stella.$WITHTOKENIZERINPUTTYPE$, ((Surrogate)(inputtype)));
            return (Stella_Object.walkATree(((Cons)(Stella_Object.copyConsTree(expansion))), new Object[1]));

          } finally {
            Stella.$WITHTOKENIZERINPUTTYPE$.set(old$Withtokenizerinputtype$000);
          }
        }
      }
    }
  }

  public static Cons parseTokenizerCharacterSpec(Stella_Object characterspec, List allcharactersets) {
    { Cons charset = Stella.NIL;
      Cons complementset = Stella.NIL;
      Cons parsedspec = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(characterspec);

        if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper characterspec000 = ((StringWrapper)(characterspec));

            { char renamed_Char = Stella.NULL_CHARACTER;
              String vector000 = characterspec000.wrapperValue;
              int index000 = 0;
              int length000 = vector000.length();
              Cons collect000 = null;

              for (;index000 < length000; index000 = index000 + 1) {
                renamed_Char = vector000.charAt(index000);
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(CharacterWrapper.wrapCharacter(renamed_Char), Stella.NIL);
                    if (charset == Stella.NIL) {
                      charset = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(charset, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(CharacterWrapper.wrapCharacter(renamed_Char), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
          }
        }
        else if (Surrogate.subtypeOfCharacterP(testValue000)) {
          { CharacterWrapper characterspec000 = ((CharacterWrapper)(characterspec));

            charset = Cons.cons(characterspec000, charset);
          }
        }
        else if (testValue000 == Stella.SGT_STELLA_CONS) {
          { Cons characterspec000 = ((Cons)(characterspec));

            { Stella_Object spec = null;
              Cons iter000 = characterspec000;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                spec = iter000.value;
                parsedspec = Stella_Object.parseTokenizerCharacterSpec(spec, Stella.NIL_LIST);
                if (parsedspec == null) {
                  return (null);
                }
                { CharacterWrapper renamed_Char = null;
                  Cons iter001 = parsedspec;
                  Cons collect001 = null;

                  for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                    renamed_Char = ((CharacterWrapper)(iter001.value));
                    if (collect001 == null) {
                      {
                        collect001 = Cons.cons(renamed_Char, Stella.NIL);
                        if (charset == Stella.NIL) {
                          charset = collect001;
                        }
                        else {
                          Cons.addConsToEndOfConsList(charset, collect001);
                        }
                      }
                    }
                    else {
                      {
                        collect001.rest = Cons.cons(renamed_Char, Stella.NIL);
                        collect001 = collect001.rest;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
          { GeneralizedSymbol characterspec000 = ((GeneralizedSymbol)(characterspec));

            { String testValue001 = characterspec000.symbolName;

              if (Stella.stringEqlP(testValue001, "ANY")) {
                { int i = Stella.NULL_INTEGER;
                  int iter002 = 0;
                  int upperBound000 = Stella.$MAX_TOKENIZER_CHARACTERS$ - 1;
                  Cons collect002 = null;

                  for (;iter002 <= upperBound000; iter002 = iter002 + 1) {
                    i = iter002;
                    if (collect002 == null) {
                      {
                        collect002 = Cons.cons(CharacterWrapper.wrapCharacter((char) i), Stella.NIL);
                        if (charset == Stella.NIL) {
                          charset = collect002;
                        }
                        else {
                          Cons.addConsToEndOfConsList(charset, collect002);
                        }
                      }
                    }
                    else {
                      {
                        collect002.rest = Cons.cons(CharacterWrapper.wrapCharacter((char) i), Stella.NIL);
                        collect002 = collect002.rest;
                      }
                    }
                  }
                }
              }
              else if (Stella.stringEqlP(testValue001, "OTHERWISE")) {
                { Cons set = null;
                  Cons iter003 = allcharactersets.theConsList;

                  for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                    set = ((Cons)(iter003.value));
                    { CharacterWrapper renamed_Char = null;
                      Cons iter004 = set;
                      Cons collect003 = null;

                      for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                        renamed_Char = ((CharacterWrapper)(iter004.value));
                        if (collect003 == null) {
                          {
                            collect003 = Cons.cons(renamed_Char, Stella.NIL);
                            if (charset == Stella.NIL) {
                              charset = collect003;
                            }
                            else {
                              Cons.addConsToEndOfConsList(charset, collect003);
                            }
                          }
                        }
                        else {
                          {
                            collect003.rest = Cons.cons(renamed_Char, Stella.NIL);
                            collect003 = collect003.rest;
                          }
                        }
                      }
                    }
                  }
                }
                { int i = Stella.NULL_INTEGER;
                  int iter005 = 0;
                  int upperBound001 = Stella.$MAX_TOKENIZER_CHARACTERS$ - 1;
                  Cons collect004 = null;

                  for (;iter005 <= upperBound001; iter005 = iter005 + 1) {
                    i = iter005;
                    if (!charset.memberP(CharacterWrapper.wrapCharacter((char) i))) {
                      if (collect004 == null) {
                        {
                          collect004 = Cons.cons(CharacterWrapper.wrapCharacter((char) i), Stella.NIL);
                          if (complementset == Stella.NIL) {
                            complementset = collect004;
                          }
                          else {
                            Cons.addConsToEndOfConsList(complementset, collect004);
                          }
                        }
                      }
                      else {
                        {
                          collect004.rest = Cons.cons(CharacterWrapper.wrapCharacter((char) i), Stella.NIL);
                          collect004 = collect004.rest;
                        }
                      }
                    }
                  }
                }
                charset = complementset;
              }
              else {
                return (null);
              }
            }
          }
        }
        else {
          return (null);
        }
      }
      return (charset);
    }
  }

  public static boolean tokenizerIncludeSpecP(Stella_Object x) {
    return (Stella_Object.isaP(x, Stella.SGT_STELLA_GENERALIZED_SYMBOL) &&
        Stella.stringEqlP(((GeneralizedSymbol)(x)).symbolName, "INCLUDE"));
  }

  public static int parseTokenizerStateModifiers(Stella_Object modifier) {
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(modifier), Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
      { GeneralizedSymbol modifier000 = ((GeneralizedSymbol)(modifier));

        { String testValue000 = modifier000.symbolName;

          if (Stella.stringEqlP(testValue000, "*")) {
            return (2);
          }
          else if (Stella.stringEqlP(testValue000, "!") ||
              (Stella.stringEqlP(testValue000, "*!") ||
               Stella.stringEqlP(testValue000, "!*"))) {
            return (3);
          }
          else {
            return (0);
          }
        }
      }
    }
    else {
      return (0);
    }
  }

  public static GeneralizedSymbol tokenizerToStateAlias(Stella_Object state) {
    if (Stella_Object.consP(state)) {
      return (((GeneralizedSymbol)(((Cons)(state)).rest.value)));
    }
    else {
      return (((GeneralizedSymbol)(state)));
    }
  }

  public static GeneralizedSymbol tokenizerToStateName(Stella_Object state) {
    if (Stella_Object.consP(state)) {
      return (((GeneralizedSymbol)(((Cons)(state)).value)));
    }
    else {
      return (((GeneralizedSymbol)(state)));
    }
  }

  public static boolean legalTokenizerToStateP(Stella_Object x) {
    return (Stella_Object.legalTokenizerStateP(x) ||
        (Stella_Object.consP(x) &&
         (Stella_Object.legalTokenizerStateP(((Cons)(x)).value) &&
          Stella_Object.legalTokenizerStateP(((Cons)(x)).rest.value))));
  }

  public static boolean legalTokenizerFromStateP(Stella_Object x) {
    return (Stella_Object.legalTokenizerStateP(x));
  }

  public static boolean legalTokenizerStateP(Stella_Object x) {
    return (Stella_Object.keywordP(x) ||
        Stella_Object.symbolP(x));
  }

  public static Stella_Object updateInContext(Stella_Object oldvalue, Stella_Object newvalue, Context homecontext, boolean copytochildrenP) {
    { CsValue csvalue = null;

      if ((oldvalue != null) &&
          (oldvalue.primaryType() == Stella.SGT_STELLA_CS_VALUE)) {
        csvalue = ((CsValue)(oldvalue));
      }
      else {
        if ((homecontext == ((Context)(Stella.$CONTEXT$.get()))) &&
            (((Context)(Stella.$CONTEXT$.get())).childContexts.emptyP() ||
             (!copytochildrenP))) {
          return (newvalue);
        }
        else {
          {
            csvalue = CsValue.newCsValue();
            if (oldvalue != null) {
              csvalue.insertAt(homecontext, oldvalue);
            }
          }
        }
      }
      csvalue.insertAt(((Context)(Stella.$CONTEXT$.get())), newvalue);
      if (copytochildrenP) {
        CsValue.copyCurrentValueToChildren(csvalue, homecontext, newvalue);
      }
      return (csvalue);
    }
  }

  public static Stella_Object accessInContext(Stella_Object value, Context homecontext, boolean dontinheritP) {
    if ((value == null) ||
        (!((value != null) &&
        (value.primaryType() == Stella.SGT_STELLA_CS_VALUE)))) {
      if (dontinheritP) {
        if (((Context)(Stella.$CONTEXT$.get())) == homecontext) {
          return (value);
        }
      }
      else {
        if ((homecontext == null) ||
            (((((Context)(Stella.$CONTEXT$.get())) == homecontext) ||
            ((Context)(Stella.$CONTEXT$.get())).allSuperContexts.membP(homecontext)) ||
             (Stella_Object.isaP(homecontext, Stella.SGT_STELLA_MODULE) &&
              Context.visibleFromP(homecontext, ((Module)(Stella.$MODULE$.get())))))) {
          return (value);
        }
      }
      return (null);
    }
    { KvCons kvcons = ((CsValue)(value)).theKvList;
      int contextnumber = Stella.NULL_INTEGER;

      { Context target = ((Context)(Stella.$CONTEXT$.get()));

        contextnumber = target.contextNumber;
        while ((kvcons != null) &&
            (contextnumber < ((Context)(kvcons.key)).contextNumber)) {
          if ((((((Context)(kvcons.key)).contextNumber) % 2) == 1) &&
              ((!Stella.$CONTEXT_BACKTRACKING_MODE$) &&
               Stella.$UNLINK_DISCARDED_CONTEXTS_ON_READp$)) {
            if (kvcons.rest != null) {
              { KvCons nextkvcons = kvcons.rest;

                kvcons.key = nextkvcons.key;
                kvcons.value = nextkvcons.value;
                kvcons.rest = nextkvcons.rest;
                nextkvcons.free();
              }
            }
            else {
              {
                ((CsValue)(value)).removeAt(((Context)(kvcons.key)));
                return (null);
              }
            }
          }
          else {
            kvcons = kvcons.rest;
          }
        }
        if (kvcons == null) {
          return (null);
        }
        if (target == kvcons.key) {
          return (kvcons.value);
        }
        if (dontinheritP) {
          return (null);
        }
      }
      { Context target = null;
        Cons iter000 = ((Context)(Stella.$CONTEXT$.get())).allSuperContexts;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          target = ((Context)(iter000.value));
          contextnumber = target.contextNumber;
          while ((kvcons != null) &&
              (contextnumber < ((Context)(kvcons.key)).contextNumber)) {
            if ((((((Context)(kvcons.key)).contextNumber) % 2) == 1) &&
                ((!Stella.$CONTEXT_BACKTRACKING_MODE$) &&
                 Stella.$UNLINK_DISCARDED_CONTEXTS_ON_READp$)) {
              if (kvcons.rest != null) {
                { KvCons nextkvcons = kvcons.rest;

                  kvcons.key = nextkvcons.key;
                  kvcons.value = nextkvcons.value;
                  kvcons.rest = nextkvcons.rest;
                  nextkvcons.free();
                }
              }
              else {
                {
                  ((CsValue)(value)).removeAt(((Context)(kvcons.key)));
                  return (null);
                }
              }
            }
            else {
              kvcons = kvcons.rest;
            }
          }
          if (kvcons == null) {
            return (null);
          }
          if (target == kvcons.key) {
            return (kvcons.value);
          }
          if (dontinheritP) {
            return (null);
          }
        }
      }
      return (null);
    }
  }

  public static boolean csValueP(Stella_Object self) {
    return ((self != null) &&
        (self.primaryType() == Stella.SGT_STELLA_CS_VALUE));
  }

  public static boolean filterModuleP(Stella_Object self, AllPurposeIterator iterator) {
    iterator = iterator;
    return (self.primaryType() == Stella.SGT_STELLA_MODULE);
  }

  /** Change the current module to the module named <code>name</code>.
   * @param name
   * @return Module
   */
  public static Module inModule(Stella_Object name) {
    { String modulename = Stella_Object.coerceToModuleName(name, true);
      Module module = ((modulename != null) ? Stella.getStellaModule(modulename, false) : ((Module)(null)));

      if (module != null) {
        Native.setSpecial(Stella.$MODULE$, module);
        Native.setSpecial(Stella.$CONTEXT$, module);
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("Illegal or undefined module: `" + name + "'");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      return (((Module)(Stella.$MODULE$.get())));
    }
  }

  /** Define (or redefine) a module named <code>name</code>.
   * The accepted syntax is:
   * 	 
   *   (defmodule &lt;module-name&gt;
   *      [:documentation &lt;docstring&gt;]
   *      [:includes {&lt;module-name&gt; | (&lt;module-name&gt;*)}]
   *      [:uses {&lt;module-name&gt; | (&lt;module-name&gt;*)}]
   *      [:lisp-package &lt;package-name-string&gt;]
   *      [:java-package &lt;package-specification-string&gt;]
   *      [:cpp-namespace &lt;namespace-name-string&gt;]
   *      [:java-catchall-class
   *      [:api? {TRUE | FALSE}]
   *      [:case-sensitive? {TRUE | FALSE}]
   *      [:shadow (&lt;symbol&gt;*)]
   *      [:java-catchall-class &lt;class-name-string&gt;]
   *      [&lt;other-options&gt;*])
   * 	
   * <code>name</code> can be a string or a symbol.
   * <p>
   * Modules include objects from other modules via two separate mechanisms:
   * (1) they inherit from their parents specified via the <code>Cincludes</code> option
   * and/or a fully qualified module name, and (2) they inherit from used
   * modules specified via the <code>Cuses</code> option.  The main difference between
   * the two mechanisms is that inheritance from parents is transitive, while
   * uses-links are only followed one level deep.  I.e., a module A that uses
   * B will see all objects of B (and any of B's parents) but not see anything
   * from modules used by B.  Another difference is that only objects declared
   * as public can be inherited via uses-links (this is not yet enforced).
   * Note that - contrary to Lisp - there are separate name spaces for classes,
   * functions, and variables.  For example, a module could inherit the class
   * <code>CONS</code> from the <code>STELLA</code> module, but shadow the function of the same name.
   * <p>
   * The above discussion of <code>Cincludes</code> and <code>Cuses</code> semantics keyed on the
   * inheritance/visibility of symbols. The PowerLoom system makes another
   * very important distinction: If a module 'A' is inherited directly or
   * indirectly via <code>Cincludes</code> specification(s) by a submodule 'B', then all
   * definitions and facts asserted in 'A' are visible in 'B'. This is not the
   * cases for <code>Cuses</code>; the <code>Cuses</code> options does not impact inheritance of
   * propositions at all.
   * <p>
   * The list of modules specified in the
   * <code>Cincludes</code> option plus (if supplied) the parent in the path used for
   * <code>name</code> become the new module's parents. If no <code>Cuses</code> option was
   * supplied, the new module will use the <code>STELLA</code> module by default,
   * otherwise, it will use the set of specified modules.
   * <p>
   * If <code>CcaseSensitiveP</code> is supplied as TRUE, symbols in the module
   * will be interned case-sensitively, otherwise (the default), they
   * will be converted to uppercase before they get interned.  That
   * means that any reference from inside a case-sensitive module to a
   * non-case-sensitive module will have to use uppercase names for
   * symbols in the non-case-sensitive module.  The standard system
   * modules are all NOT case sensitive.
   * <p>
   * Modules can shadow definitions of functions and classes inherited
   * from parents or used modules. Shadowing is done automatically,
   * but generates a warning unless the shadowed type or function name
   * is listed in the <code>Cshadow</code> option of the module definition .
   * <p>
   * Examples:
   * 	 
   *   (defmodule &quot;PL-KERNEL/PL-USER&quot;
   *     :uses (&quot;LOGIC&quot; &quot;STELLA&quot;)
   *     :package &quot;PL-USER&quot;)
   * <p>
   *   (defmodule PL-USER/GENEALOGY)
   * 	
   * The remaining options are relevant only for modules that contain STELLA
   * code.  Modules used only to contain knowledge base definitions and assertions
   * have no use for them:
   * <p>
   * The keywords <code>ClispPackage</code>, <code>CjavaPackage</code>, and <code>CcppPackage</code> specify
   * the name of a native package or name space in which symbols of the module
   * should be allocated when they get translated into one of Lisp, Java, or
   * C++. By default, Lisp symbols are allocated in the <code>STELLA</code> package, and
   * C++ names are translated without any prefixes. The rules that the STELLA
   * translator uses to attach translated Java objects to classes and packages
   * are somewhat complex. Use :java-package option to specify a list of
   * package names (separated by periods) that prefix the Java object in this
   * module.  Use :java-catchall-class to specify the name of the Java class to
   * contain all global &amp; special variables, parameter-less functions and functions 
   * defined on arguments that are not classes in the current module.
   * The default value will be the name of the module.
   * <p>
   * When set to TRUE, the :api? option tells the PowerLoom User Manual
   * generator that all functions defined in this module should be included in
   * the API section. Additionally, the Java translator makes all API
   * functions <code>renamed_Synchronized</code>.
   * 
   * @param name
   * @param options
   */
  public static void defmodule(Stella_Object name, Cons options) {
    { String modulename = Stella_Object.coerceToModuleName(name, true);

      if (modulename != null) {
        Module.defineModule(modulename, options);
      }
    }
  }

  public static boolean trueOptionP(Stella_Object value) {
    return ((value == Stella.SYM_STELLA_TRUE) ||
        (Stella_Object.eqlP(value, Stella.TRUE_WRAPPER) ||
         (Stella_Object.isaP(value, Stella.SGT_STELLA_SYMBOL) &&
          Stella.stringEqualP(((Symbol)(value)).symbolName, "TRUE"))));
  }

  public static Module coerceToModule(Stella_Object renamed_Object, boolean warnP) {
    if (renamed_Object == null) {
      return (((Module)(Stella.$MODULE$.get())));
    }
    if (Surrogate.subtypeOfP(Stella_Object.safePrimaryType(renamed_Object), Stella.SGT_STELLA_MODULE)) {
      { Module object000 = ((Module)(renamed_Object));

        return (object000);
      }
    }
    else {
      { String modulename = Stella_Object.coerceToModuleName(renamed_Object, warnP);

        if (modulename != null) {
          if (Stella.qualifiedStellaNameP(modulename)) {
            return (Stella.getStellaModule(modulename, warnP));
          }
          return (Stella.getStellaModule(modulename, warnP));
        }
        return (null);
      }
    }
  }

  public static String coerceToModuleName(Stella_Object namespec, boolean warnP) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(namespec);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper namespec000 = ((StringWrapper)(namespec));

          return (namespec000.wrapperValue);
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MUTABLE_STRING_WRAPPER)) {
        { MutableStringWrapper namespec000 = ((MutableStringWrapper)(namespec));

          return ((namespec000.wrapperValue).toString());
        }
      }
      else if (Surrogate.subtypeOfKeywordP(testValue000)) {
        { Keyword namespec000 = ((Keyword)(namespec));

          return (namespec000.symbolName);
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol namespec000 = ((Symbol)(namespec));

          { Module module = ((Module)(namespec000.homeContext));

            if (module == null) {
              return (namespec000.symbolName);
            }
            else {
              return (namespec000.visibleName(false));
            }
          }
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate namespec000 = ((Surrogate)(namespec));

          { Module module = ((Module)(namespec000.homeContext));

            if (module == null) {
              return (namespec000.symbolName);
            }
            else {
              return (namespec000.visibleName(false));
            }
          }
        }
      }
      else {
        if (warnP) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal module name: `" + namespec + "'");
        }
        return (null);
      }
    }
  }

  public static void helpLptrans(Stella_Object statement) {
    { Object old$Translatoroutputlanguage$000 = Stella.$TRANSLATOROUTPUTLANGUAGE$.get();
      Object old$PrintprettycodeP$000 = Stella.$PRINTPRETTYCODEp$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATOROUTPUTLANGUAGE$, ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));
        Native.setBooleanSpecial(Stella.$PRINTPRETTYCODEp$, true);
        Keyword.setTranslatorOutputLanguage(Stella.KWD_COMMON_LISP);
        { boolean declarationP = Cons.declarationTreeP(((Cons)(statement)));
          Stella_Object translation = Stella_Object.incrementallyTranslate(statement);

          if (declarationP &&
              (Stella_Object.consP(translation) &&
               (((Cons)(translation)).value == Stella.internCommonLispSymbol("PROGN")))) {
            { Stella_Object elt = null;
              Cons iter000 = ((Cons)(translation)).rest;
              int i = Stella.NULL_INTEGER;
              int iter001 = 1;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
                elt = iter000.value;
                i = iter001;
                if (i == 1) {
                  Stella_Object.printStellaDefinition(elt, Stella.STANDARD_OUTPUT.nativeStream);
                }
                else {
                  Stella_Object.printStellaCode(elt, Stella.STANDARD_OUTPUT.nativeStream);
                }
              }
            }
          }
          else {
            Stella_Object.printStellaCode(translation, Stella.STANDARD_OUTPUT.nativeStream);
          }
        }

      } finally {
        Stella.$PRINTPRETTYCODEp$.set(old$PrintprettycodeP$000);
        Stella.$TRANSLATOROUTPUTLANGUAGE$.set(old$Translatoroutputlanguage$000);
      }
    }
  }

  /** Translate <code>statement</code> to Common-Lisp and print the result.
   * @param statement
   */
  public static void ptrans(Stella_Object statement) {
    Stella_Object.helpLptrans(statement);
  }

  /** Translate <code>statement</code> to Common-Lisp and print the result.
   * @param statement
   */
  public static void lptrans(Stella_Object statement) {
    Stella_Object.helpLptrans(statement);
  }

  public static Stella_Object clConditionalizeTypeDeclarationTree(Stella_Object declaration) {
    return (declaration);
  }

  public static Stella_Object clYieldTypedExpressionTree(Stella_Object tree, StandardObject type) {
    { Stella_Object cltype = StandardObject.lookupClTypeFromStellaType(type);

      if (cltype != null) {
        if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
          { Cons tree000 = ((Cons)(tree));

            if ((tree000.value == Stella.internCommonLispSymbol("THE")) &&
                Stella_Object.eqlP(tree000.rest.value, cltype)) {
              return (tree000);
            }
          }
        }
        else {
        }
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("THE"), Cons.cons(cltype, Cons.cons(Cons.cons(tree, Stella.NIL), Stella.NIL)))));
      }
      else {
        return (tree);
      }
    }
  }

  public static Stella_Object clTranslateVerbatimBodySymbols(Stella_Object body, List parameters) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(body);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons body000 = ((Cons)(body));

          if (!(body000 == Stella.NIL)) {
            return (Cons.cons(Stella_Object.clTranslateVerbatimBodySymbols(body000.value, parameters), ((Cons)(Stella_Object.clTranslateVerbatimBodySymbols(body000.rest, parameters)))));
          }
          else {
            return (Stella.NIL);
          }
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol body000 = ((Symbol)(body));

          if (parameters.memberP(body000)) {
            return (Symbol.clTranslateLocalSymbol(body000));
          }
          else {
            return (Symbol.clTranslateGlobalSymbol(body000));
          }
        }
      }
      else {
        return (body);
      }
    }
  }

  public static Stella_Object clTranslatePlainBooleanTest(Stella_Object tree, boolean invertP) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { Symbol operator = null;
          Surrogate owner = null;
          Cons arguments = null;

          { Object [] caller_MV_returnarray = new Object[2];

            operator = Cons.destructureCallTree(tree000, caller_MV_returnarray);
            owner = ((Surrogate)(caller_MV_returnarray[0]));
            arguments = ((Cons)(caller_MV_returnarray[1]));
          }
          if ((operator == Stella.SYM_STELLA_l) ||
              ((operator == Stella.SYM_STELLA_le) ||
               ((operator == Stella.SYM_STELLA_e) ||
                ((operator == Stella.SYM_STELLA_ge) ||
                 (operator == Stella.SYM_STELLA_g))))) {
            if (Stella.optimizeBooleanTestsP()) {
              if (invertP) {
                if (operator == Stella.SYM_STELLA_l) {
                  operator = Stella.SYM_STELLA_ge;
                }
                else if (operator == Stella.SYM_STELLA_le) {
                  operator = Stella.SYM_STELLA_g;
                }
                else if (operator == Stella.SYM_STELLA_e) {
                  operator = Stella.SYM_STELLA_xe;
                }
                else if (operator == Stella.SYM_STELLA_ge) {
                  operator = Stella.SYM_STELLA_l;
                }
                else if (operator == Stella.SYM_STELLA_g) {
                  operator = Stella.SYM_STELLA_le;
                }
                else {
                  { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                    stream000.nativeStream.print("`" + operator + "' is not a valid case option");
                    throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                  }
                }
                invertP = false;
              }
            }
            tree000 = Cons.cons(Stella.$CL_OPERATOR_TABLE$.lookup(operator), Cons.clTranslateListOfTrees(arguments).concatenate(Stella.NIL, Stella.NIL));
            if (invertP) {
              return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree000, Cons.cons(Stella.NIL, Stella.NIL)))));
            }
            else {
              return (tree000);
            }
          }
          else if (operator == Stella.SYM_STELLA_EQp) {
            if (Stella.optimizeBooleanTestsP()) {
              { StandardObject argtype1 = Stella_Object.walkedExpressionType(arguments.value);
                StandardObject argtype2 = Stella_Object.walkedExpressionType(arguments.rest.value);

                if (StandardObject.subTypeSpecOfP(argtype1, Stella.SGT_STELLA_LITERAL) &&
                    StandardObject.subTypeSpecOfP(argtype2, Stella.SGT_STELLA_LITERAL)) {
                  if ((argtype1 == Stella.SGT_STELLA_STRING) ||
                      StandardObject.subTypeSpecOfP(argtype1, Stella.SGT_STELLA_BOOLEAN)) {
                    operator = Stella.internCommonLispSymbol("EQ");
                  }
                  else if (StandardObject.subTypeSpecOfP(argtype1, Stella.SGT_STELLA_NUMBER)) {
                    operator = Stella.internCommonLispSymbol("=");
                  }
                  else {
                    operator = Stella.internCommonLispSymbol("EQL");
                  }
                }
                else {
                  operator = Stella.internCommonLispSymbol("EQ");
                }
                tree000.firstSetter(operator);
              }
            }
            tree000.rest = Cons.clTranslateListOfTrees(tree000.rest);
            if (invertP) {
              return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree000, Cons.cons(Stella.NIL, Stella.NIL)))));
            }
            else {
              return (tree000);
            }
          }
          else if ((operator == Stella.SYM_STELLA_NULLp) ||
              (operator == Stella.SYM_STELLA_DEFINEDp)) {
            if (Stella.methodCallInliningEnabledP()) {
              if ((owner == Stella.SGT_STELLA_OBJECT) ||
                  ((owner == Stella.SGT_STELLA_SECOND_CLASS_OBJECT) ||
                   ((owner == Stella.SGT_STELLA_STRING) ||
                    ((owner == Stella.SGT_STELLA_NATIVE_VECTOR) ||
                     ((owner == Stella.SGT_STELLA_ARRAY) ||
                      ((owner == Stella.SGT_STELLA_INTEGER) ||
                       ((owner == Stella.SGT_STELLA_LONG_INTEGER) ||
                        ((owner == Stella.SGT_STELLA_FLOAT) ||
                         (owner == Stella.SGT_STELLA_CODE))))))))) {
                if (owner == Stella.SGT_STELLA_ARRAY) {
                  tree000 = Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_NULL_ARRAYp), Cons.cons(Stella_Object.clTranslateATree(arguments.value), Stella.NIL));
                }
                else {
                  tree000 = Cons.cons((Surrogate.subtypeOfP(owner, Stella.SGT_STELLA_NUMBER) ? Stella.internCommonLispSymbol("=") : Stella.internCommonLispSymbol("EQ")), Cons.cons(Stella_Object.clTranslateATree(arguments.value), Cons.cons(Stella_Object.clTranslateATree(StandardObject.typeToWalkedNullValueTree(owner, owner)), Stella.NIL)));
                }
                if (owner == Stella.SGT_STELLA_FLOAT) {
                  tree000.firstSetter(Stella.internCommonLispSymbol("="));
                }
                else {
                }
                if ((invertP &&
                    (operator == Stella.SYM_STELLA_NULLp)) ||
                    ((!invertP) &&
                     (operator == Stella.SYM_STELLA_DEFINEDp))) {
                  return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree000, Cons.cons(Stella.NIL, Stella.NIL)))));
                }
                else {
                  return (tree000);
                }
              }
              else {
              }
            }
            tree000 = Cons.cons(Symbol.clTranslateGlobalSymbol(operator), Cons.cons(Stella_Object.clTranslateATree(arguments.value), Stella.NIL));
            if (invertP) {
              return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree000, Cons.cons(Stella.NIL, Stella.NIL)))));
            }
            else {
              return (tree000);
            }
          }
          else {
          }
        }
      }
    }
    else {
    }
    tree = Stella_Object.clTranslateATree(tree);
    if (invertP) {
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
    else {
      return (tree);
    }
  }

  public static Stella_Object clTranslateBooleanTest(Stella_Object tree, boolean invertP) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_NOT) {
            { Stella_Object postree = tree000.rest.value;

              return (Stella_Object.clTranslateBooleanTest(postree, !invertP));
            }
          }
          else if ((testValue000 == Stella.SYM_STELLA_AND) ||
              (testValue000 == Stella.SYM_STELLA_OR)) {
            { Cons cursor = tree000.rest;

              while (!(cursor == Stella.NIL)) {
                cursor.value = Stella_Object.clTranslateBooleanTest(cursor.value, false);
                cursor = cursor.rest;
              }
            }
            if (tree000.value == Stella.SYM_STELLA_AND) {
              tree000.firstSetter(Stella.internCommonLispSymbol("AND"));
            }
            else {
              tree000.firstSetter(Stella.internCommonLispSymbol("OR"));
            }
            if (invertP) {
              tree000 = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("NOT"), Cons.cons(tree000, Cons.cons(Stella.NIL, Stella.NIL))));
            }
            return (tree000);
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
            return (Stella_Object.clTranslateBooleanTest(tree000.rest.value, invertP));
          }
          else {
          }
        }
      }
    }
    else {
    }
    return (Stella_Object.clTranslatePlainBooleanTest(tree, invertP));
  }

  /** Perform a run-time type check, and then return <code>value</code>.
   * @param value
   * @param type
   * @return Stella_Object
   */
  public static Stella_Object cast(Stella_Object value, Surrogate type) {
    if ((((Integer)(Stella.$SAFETY$.get())).intValue() >= 2) &&
        ((Stella.$STARTUP_TIME_PHASE$ == 999) &&
         Stella.$UNFINALIZED_CLASSES$.emptyP())) {
      if ((value != null) &&
          (!Stella_Object.isaP(value, type))) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          {
            stream000.nativeStream.println("Run-time casting violation.  The value: ");
            stream000.nativeStream.println("`" + value + "'");
            stream000.nativeStream.print(" is not of type `" + type + "'.");
          }
;
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
    return (value);
  }

  public Stella_Object clTranslateAtomicTree() {
    { Stella_Object tree = this;

      return (tree);
    }
  }

  public static Stella_Object helpClTranslateATree(Stella_Object tree) {
    if (tree == null) {
      return (tree);
    }
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (tree000);
        }
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_VOID_SYS) {
            return (Cons.clTranslateVoidSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
            return (Cons.clTranslateTypedSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BAD_SYS) {
            return (Cons.clTranslateBadSys(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SETQ) {
            return (Cons.clTranslateSetqTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) {
            return (Cons.clTranslateFixedSlotValueTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) {
            return (Cons.clTranslateFixedSlotValueSetterTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) ||
              (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION)) {
            return (Cons.clTranslateCallMethodTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_PROGN) {
            tree000.value = Stella.internCommonLispSymbol("PROGN");
            tree000.rest = Cons.clTranslateListOfTrees(tree000.rest);
            return (tree000);
          }
          else if (testValue000 == Stella.SYM_STELLA_WITH_PROCESS_LOCK) {
            tree000.value = Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_WITH_PROCESS_LOCK);
            tree000.secondSetter(Stella_Object.clTranslateATree(tree000.rest.value));
            tree000.rest.rest = Cons.clTranslateListOfTrees(tree000.rest.rest);
            return (tree000);
          }
          else if (testValue000 == Stella.SYM_STELLA_LOOP) {
            { Object old$NeedexplicitreturnP$000 = Stella.$NEEDEXPLICITRETURNp$.get();

              try {
                Native.setBooleanSpecial(Stella.$NEEDEXPLICITRETURNp$, true);
                tree000.value = Stella.internCommonLispSymbol("LOOP");
                tree000.rest = Cons.maybeWrapWithContinueLabel(Cons.clTranslateListOfTrees(tree000.rest));
                return (tree000);

              } finally {
                Stella.$NEEDEXPLICITRETURNp$.set(old$NeedexplicitreturnP$000);
              }
            }
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_FOREACH) {
            { Object old$NeedexplicitreturnP$001 = Stella.$NEEDEXPLICITRETURNp$.get();

              try {
                Native.setBooleanSpecial(Stella.$NEEDEXPLICITRETURNp$, true);
                return (Cons.clTranslateForeachTree(tree000));

              } finally {
                Stella.$NEEDEXPLICITRETURNp$.set(old$NeedexplicitreturnP$001);
              }
            }
          }
          else if (testValue000 == Stella.SYM_STELLA_LET) {
            return (Cons.clTranslateLetTree(tree000, false));
          }
          else if (testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
            { Object old$NeedexplicitreturnP$002 = Stella.$NEEDEXPLICITRETURNp$.get();

              try {
                Native.setBooleanSpecial(Stella.$NEEDEXPLICITRETURNp$, true);
                return (Cons.clTranslateStartupTimePrognTree(tree000));

              } finally {
                Stella.$NEEDEXPLICITRETURNp$.set(old$NeedexplicitreturnP$002);
              }
            }
          }
          else if (testValue000 == Stella.SYM_STELLA_SPECIAL) {
            return (Cons.clTranslateSpecialTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_UNWIND_PROTECT) {
            return (Cons.clTranslateUnwindProtectTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLER_CASE) {
            return (Cons.clTranslateHandlerCaseTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_HANDLE_EXCEPTION) {
            return (Cons.clTranslateHandleExceptionTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_SIGNAL) {
            return (Cons.clTranslateSignalTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_CAST) ||
              (testValue000 == Stella.SYM_STELLA_SAFE_CAST)) {
            return (Cons.clTranslateCastTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_RETURN) {
            return (Cons.clTranslateReturnTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_BREAK) {
            tree000.firstSetter(Stella.internCommonLispSymbol("RETURN"));
            return (tree000);
          }
          else if (testValue000 == Stella.SYM_STELLA_CONTINUE) {
            return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("GO"), Cons.cons(Stella.KWD_CONTINUE, Cons.cons(Stella.NIL, Stella.NIL)))));
          }
          else if (testValue000 == Stella.SYM_STELLA_WHILE) {
            { Object old$NeedexplicitreturnP$003 = Stella.$NEEDEXPLICITRETURNp$.get();

              try {
                Native.setBooleanSpecial(Stella.$NEEDEXPLICITRETURNp$, true);
                return (Cons.clTranslateWhileTree(tree000));

              } finally {
                Stella.$NEEDEXPLICITRETURNp$.set(old$NeedexplicitreturnP$003);
              }
            }
          }
          else if ((testValue000 == Stella.SYM_STELLA_IF) ||
              ((testValue000 == Stella.SYM_STELLA_CHOOSE) ||
               ((testValue000 == Stella.SYM_STELLA_WHEN) ||
                (testValue000 == Stella.SYM_STELLA_UNLESS)))) {
            return (Cons.clTranslateConditionalTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_AND) ||
              ((testValue000 == Stella.SYM_STELLA_OR) ||
               (testValue000 == Stella.SYM_STELLA_NOT))) {
            return (Cons.clTranslateBooleanTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_COND) {
            return (Cons.clTranslateCondTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_CASE) {
            return (Cons.clTranslateCaseTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_EQp) ||
              ((testValue000 == Stella.SYM_STELLA_g) ||
               ((testValue000 == Stella.SYM_STELLA_ge) ||
                ((testValue000 == Stella.SYM_STELLA_l) ||
                 (testValue000 == Stella.SYM_STELLA_le))))) {
            return (Cons.clTranslateOperatorTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MAKE) {
            return (Cons.clTranslateMakeTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_NEW) {
            return (Cons.clTranslateNewTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_MV_SETQ) {
            tree000.firstSetter(Stella.internCommonLispSymbol("MULTIPLE-VALUE-SETQ"));
            tree000.secondSetter(Cons.clTranslateListOfTrees(((Cons)(tree000.rest.value))));
            tree000.thirdSetter(Stella_Object.clTranslateATree(tree000.rest.rest.value));
            return (tree000);
          }
          else if (testValue000 == Stella.SYM_STELLA_QUOTE) {
            tree000.firstSetter(Stella.internCommonLispSymbol("QUOTE"));
            return (tree000);
          }
          else if ((testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE) ||
              (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE)) {
            return (Cons.clTranslateCallFunctionCodeTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_SYS_INLINE_CALL) {
            return (Cons.clTranslateInlineCallTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_THE_CODE) {
            return (Cons.clTranslateTheCodeTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_PRINT_STREAM) ||
              (testValue000 == Stella.SYM_STELLA_PRINT_NATIVE_STREAM)) {
            return (Cons.clTranslatePrintStreamTree(tree000));
          }
          else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
            return (Cons.clTranslateVerbatimTree(tree000));
          }
          else if ((testValue000 == Stella.SYM_STELLA_INLINE) ||
              (testValue000 == Stella.SYM_STELLA_IGNORE)) {
            return (Cons.clTranslateInlineTree(tree000));
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
    else {
      return (tree.clTranslateAtomicTree());
    }
  }

  public static Stella_Object clTranslateATree(Stella_Object tree) {
    return (Stella_Object.helpClTranslateATree(tree));
  }

  public static Stella_Object coerceEvaluatedTree(Stella_Object tree, Stella_Object sourcetree, StandardObject sourcetype, StandardObject targettype, boolean evaluateP, Object [] MV_returnarray) {
    { Object old$Evaluationparenttree$000 = Stella.$EVALUATIONPARENTTREE$.get();
      Object old$Evaluationtree$000 = Stella.$EVALUATIONTREE$.get();

      try {
        Native.setSpecial(Stella.$EVALUATIONPARENTTREE$, ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
        Native.setSpecial(Stella.$EVALUATIONTREE$, sourcetree);
        { Surrogate sourcebasetype = StandardObject.typeSpecToBaseType(sourcetype);
          Surrogate targetbasetype = StandardObject.typeSpecToBaseType(targettype);

          if ((tree == null) ||
              (tree == Stella.SYM_STELLA_NULL)) {
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(targettype));

              if (testValue000 == Stella.SGT_STELLA_INTEGER) {
                { Stella_Object _return_temp = Stella.NULL_INTEGER_WRAPPER;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
              else if (testValue000 == Stella.SGT_STELLA_LONG_INTEGER) {
                { Stella_Object _return_temp = Stella.NULL_LONG_INTEGER_WRAPPER;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
              else if (testValue000 == Stella.SGT_STELLA_FLOAT) {
                { Stella_Object _return_temp = Stella.NULL_FLOAT_WRAPPER;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
              else if (testValue000 == Stella.SGT_STELLA_STRING) {
                { Stella_Object _return_temp = Stella.NULL_STRING_WRAPPER;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
              else if (testValue000 == Stella.SGT_STELLA_BOOLEAN) {
                { Stella_Object _return_temp = Stella.FALSE_WRAPPER;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
              else {
                { Stella_Object _return_temp = null;

                  MV_returnarray[0] = targettype;
                  return (_return_temp);
                }
              }
            }
          }
          if ((targettype == Stella.SGT_STELLA_BOOLEAN) &&
              (!evaluateP)) {
            if (tree == Stella.SYM_STELLA_TRUE) {
              { Stella_Object _return_temp = Stella.TRUE_WRAPPER;

                MV_returnarray[0] = targettype;
                return (_return_temp);
              }
            }
            if (tree == Stella.SYM_STELLA_FALSE) {
              { Stella_Object _return_temp = Stella.FALSE_WRAPPER;

                MV_returnarray[0] = targettype;
                return (_return_temp);
              }
            }
          }
          if (Surrogate.subtypeOfP(sourcebasetype, targetbasetype)) {
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = sourcetype;
              return (_return_temp);
            }
          }
          if (((!evaluateP) ||
              Stella_Object.isaP(tree, Stella.SGT_STELLA_WRAPPER)) &&
              (Surrogate.subtypeOfP(sourcebasetype, Stella.SGT_STELLA_LITERAL) &&
               Surrogate.subtypeOfP(sourcebasetype.typeToWrappedType(), targetbasetype))) {
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = sourcebasetype.typeToWrappedType();
              return (_return_temp);
            }
          }
          if (Surrogate.subtypeOfP(targetbasetype, Stella.SGT_STELLA_LITERAL) &&
              Surrogate.subtypeOfP(sourcebasetype, targetbasetype.typeToWrappedType())) {
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = targettype;
              return (_return_temp);
            }
          }
          if (StandardObject.voidP(sourcetype)) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
              if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                {
                  stream000.nativeStream.println();
                  stream000.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                }
;
              }
              stream000.nativeStream.println("':");
              stream000.nativeStream.print("`" + sourcetree + "' does not return a value");
              throw ((EvaluationException)(EvaluationException.newEvaluationException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
              if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                {
                  stream001.nativeStream.println();
                  stream001.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                }
;
              }
              stream001.nativeStream.println("':");
              stream001.nativeStream.print("Type conflict: `" + StandardObject.yieldTypeSpecTree(sourcetype) + "' found where `" + StandardObject.yieldTypeSpecTree(targettype) + "' expected");
              throw ((EvaluationException)(EvaluationException.newEvaluationException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }

      } finally {
        Stella.$EVALUATIONTREE$.set(old$Evaluationtree$000);
        Stella.$EVALUATIONPARENTTREE$.set(old$Evaluationparenttree$000);
      }
    }
  }

  public static Stella_Object makeEvaluatableBquoteTree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_GET_SYM) {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_QUOTE, Cons.cons(Symbol.getSym(((IntegerWrapper)(tree000.rest.value)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
          else if (testValue000 == Stella.SYM_STELLA_GET_SGT) {
            return (Surrogate.getSgt(((IntegerWrapper)(tree000.rest.value)).wrapperValue));
          }
          else if (testValue000 == Stella.SYM_STELLA_GET_KWD) {
            return (Keyword.getKwd(((IntegerWrapper)(tree000.rest.value)).wrapperValue));
          }
          else {
            { Cons args = Stella.NIL;

              { Stella_Object arg = null;
                Cons iter000 = tree000.rest;
                Cons collect000 = null;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  arg = iter000.value;
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(Stella_Object.makeEvaluatableBquoteTree(arg), Stella.NIL);
                      if (args == Stella.NIL) {
                        args = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(args, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(Stella_Object.makeEvaluatableBquoteTree(arg), Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
              { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(tree000.value));

                if (testValue001 == Stella.SYM_STELLA_LIST$) {
                  if (args.rest == Stella.NIL) {
                    return (args.value);
                  }
                  args = args.reverse();
                  { Cons constree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(args.rest.value, Cons.cons(Cons.cons(args.value, Stella.NIL), Stella.NIL))));

                    { Stella_Object arg = null;
                      Cons iter001 = args.rest.rest;

                      for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                        arg = iter001.value;
                        constree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(arg, Cons.cons(Cons.cons(constree, Stella.NIL), Stella.NIL))));
                      }
                    }
                    return (constree);
                  }
                }
                else if (testValue001 == Stella.SYM_STELLA_CONCATENATE) {
                  return (Cons.list$(Cons.cons(Stella.SYM_STELLA_APPEND, Cons.cons(args.value, Cons.cons(Cons.cons(args.rest.value, Stella.NIL), Stella.NIL)))));
                }
                else if (testValue001 == Stella.SYM_STELLA_WRAP_LITERAL) {
                  return (args.value);
                }
                else {
                  return (Cons.cons(tree000.value, args));
                }
              }
            }
          }
        }
      }
    }
    else {
      return (tree);
    }
  }

  public static Stella_Object evaluateAtomicTree(Stella_Object tree, Object [] MV_returnarray) {
    { Object old$Evaluationparenttree$000 = Stella.$EVALUATIONPARENTTREE$.get();
      Object old$Evaluationtree$000 = Stella.$EVALUATIONTREE$.get();

      try {
        Native.setSpecial(Stella.$EVALUATIONPARENTTREE$, ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
        Native.setSpecial(Stella.$EVALUATIONTREE$, tree);
        { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

          if (Surrogate.subtypeOfSymbolP(testValue000)) {
            { Symbol tree000 = ((Symbol)(tree));

              if (tree000 == Stella.SYM_STELLA_NULL) {
                { Stella_Object _return_temp = tree000;

                  MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
                  return (_return_temp);
                }
              }
              else if (tree000 == Stella.SYM_STELLA_NIL) {
                { Stella_Object _return_temp = Stella.NIL;

                  MV_returnarray[0] = Stella.SGT_STELLA_CONS;
                  return (_return_temp);
                }
              }
              else if (tree000 == Stella.SYM_STELLA_TRUE) {
                { Stella_Object _return_temp = Stella.TRUE_WRAPPER;

                  MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
                  return (_return_temp);
                }
              }
              else if (tree000 == Stella.SYM_STELLA_FALSE) {
                { Stella_Object _return_temp = Stella.FALSE_WRAPPER;

                  MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
                  return (_return_temp);
                }
              }
              else {
                { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                  stream000.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
                  if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                    {
                      stream000.nativeStream.println();
                      stream000.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                    }
;
                  }
                  stream000.nativeStream.println("':");
                  stream000.nativeStream.print("Variable evaluation not yet implemented");
                  throw ((EvaluationException)(EvaluationException.newEvaluationException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
            }
          }
          else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
            { Surrogate tree000 = ((Surrogate)(tree));

              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_SURROGATE;
                return (_return_temp);
              }
            }
          }
          else if (Surrogate.subtypeOfKeywordP(testValue000)) {
            { Keyword tree000 = ((Keyword)(tree));

              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_KEYWORD;
                return (_return_temp);
              }
            }
          }
          else if (Surrogate.subtypeOfWrapperP(testValue000)) {
            { Wrapper tree000 = ((Wrapper)(tree));

              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Surrogate.wrappedTypeToType(tree000.primaryType());
                return (_return_temp);
              }
            }
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
              if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                {
                  stream001.nativeStream.println();
                  stream001.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                }
;
              }
              stream001.nativeStream.println("':");
              stream001.nativeStream.print("Unknown atomic expression type: `" + tree + "'");
              throw ((EvaluationException)(EvaluationException.newEvaluationException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }

      } finally {
        Stella.$EVALUATIONTREE$.set(old$Evaluationtree$000);
        Stella.$EVALUATIONPARENTTREE$.set(old$Evaluationparenttree$000);
      }
    }
  }

  public static Stella_Object evaluateArgumentTree(Stella_Object tree, boolean evaluateP, Object [] MV_returnarray) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          if (evaluateP) {
            return (Cons.evaluateConsTree(tree000, MV_returnarray));
          }
          else {
            { Stella_Object _return_temp = tree000;

              MV_returnarray[0] = Stella.SGT_STELLA_CONS;
              return (_return_temp);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfWrapperP(testValue000)) {
        { Wrapper tree000 = ((Wrapper)(tree));

          { Stella_Object _return_temp = tree000;

            MV_returnarray[0] = Surrogate.wrappedTypeToType(tree000.primaryType());
            return (_return_temp);
          }
        }
      }
      else {
        if (evaluateP) {
          return (Stella_Object.evaluateAtomicTree(tree, MV_returnarray));
        }
        else {
          { Stella_Object _return_temp = tree;

            MV_returnarray[0] = tree.primaryType();
            return (_return_temp);
          }
        }
      }
    }
  }

  /** Variant of <code>evaluate</code> that only evaluates <code>tree</code> if it
   * represents an evaluable expression.  If it does not, <code>tree</code> is returned
   * unmodified.  This can be used to implement commands with mixed argument
   * evaluation strategies.
   * @param tree
   * @return Stella_Object
   */
  public static Stella_Object tryToEvaluate(Stella_Object tree) {
    { Stella_Object otree = tree;

      if (tree != null) {
        if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
          { Cons tree000 = ((Cons)(tree));

            if (Stella_Object.symbolP(tree000.value) &&
                (Symbol.lookupCommand(((Symbol)(tree000.value))) != null)) {
              try {
                otree = Cons.evaluateConsTree(tree000, new Object[1]);
              } catch (StellaException e) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" `" + Stella.exceptionMessage(e) + "'.");
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
        }
        else {
        }
      }
      return (otree);
    }
  }

  /** Evaluate the expression <code>expression</code> and return the result.
   * Currently, only the evaluation of (possibly nested) commands and global
   * variables is supported.  The second return value indicates the actual type 
   * of the result (which might have been wrapped), and the third return value
   * indicates whether an error occurred during the evaluation.  Expressions
   * are simple to program in Common Lisp, since they are built into the language,
   * and relatively awkward in Java and C++.  Users of either of those 
   * languages are more likely to want to call <code>evaluateString</code>.
   * @param expression
   * @return Stella_Object
   */
  public static Stella_Object evaluate(Stella_Object expression) {
    { Stella_Object otree = null;

      if (expression != null) {
        if (Stella_Object.safePrimaryType(expression) == Stella.SGT_STELLA_CONS) {
          { Cons expression000 = ((Cons)(expression));

            otree = Cons.evaluateConsTree(expression000, new Object[1]);
          }
        }
        else {
          otree = Stella_Object.evaluateAtomicTree(expression, new Object[1]);
        }
      }
      return (otree);
    }
  }

  public static Stella_Object deUglifyParseTree(Stella_Object tree) {
    if (tree == null) {
      return (null);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          { Stella_Object operator = tree000.value;

            if (!Stella_Object.symbolP(operator)) {
              return (Cons.deUglifyArguments(tree000));
            }
            { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(operator));

              if ((testValue001 == Stella.SYM_STELLA_SYS_SLOT_VALUE) ||
                  ((testValue001 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) ||
                   (testValue001 == Stella.SYM_STELLA_SYS_CALL_METHOD))) {
                return (Stella_Object.deUglifyParseTree(tree000.rest.rest));
              }
              else if (testValue001 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
                return (Stella_Object.deUglifyParseTree(tree000.rest));
              }
              else if ((testValue001 == Stella.SYM_STELLA_TYPED_SYS) ||
                  ((testValue001 == Stella.SYM_STELLA_VOID_SYS) ||
                   (testValue001 == Stella.SYM_STELLA_BAD_SYS))) {
                return (Stella_Object.deUglifyParseTree(tree000.rest.value));
              }
              else if (testValue001 == Stella.SYM_STELLA_GET_SYM) {
                return (Symbol.getSymFromOffset(((IntegerWrapper)(tree000.rest.value)).wrapperValue));
              }
              else {
                { Cons prettyarguments = Stella.NIL;

                  { Stella_Object arg = null;
                    Cons iter000 = tree000.rest;
                    Cons collect000 = null;

                    for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                      arg = iter000.value;
                      if (collect000 == null) {
                        {
                          collect000 = Cons.cons(Stella_Object.deUglifyParseTree(arg), Stella.NIL);
                          if (prettyarguments == Stella.NIL) {
                            prettyarguments = collect000;
                          }
                          else {
                            Cons.addConsToEndOfConsList(prettyarguments, collect000);
                          }
                        }
                      }
                      else {
                        {
                          collect000.rest = Cons.cons(Stella_Object.deUglifyParseTree(arg), Stella.NIL);
                          collect000 = collect000.rest;
                        }
                      }
                    }
                  }
                  return (Cons.cons(operator, prettyarguments.concatenate(Stella.NIL, Stella.NIL)));
                }
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_COMPOUND_TYPE_SPECIFIER)) {
        { CompoundTypeSpecifier tree000 = ((CompoundTypeSpecifier)(tree));

          return (StandardObject.yieldTypeSpecTree(tree000));
        }
      }
      else {
        return (tree);
      }
    }
  }

  public static boolean verbatimTreeP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_VERBATIM));
  }

  public static int estimatedEvaluationCost(Stella_Object tree) {
    { int cost = 0;

      if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

            if ((testValue000 == Stella.SYM_STELLA_TYPED_SYS) ||
                ((testValue000 == Stella.SYM_STELLA_CAST) ||
                 (testValue000 == Stella.SYM_STELLA_SAFE_CAST))) {
              return (Stella_Object.estimatedEvaluationCost(tree000.rest.value));
            }
            else if ((testValue000 == Stella.SYM_STELLA_AND) ||
                ((testValue000 == Stella.SYM_STELLA_OR) ||
                 ((testValue000 == Stella.SYM_STELLA_NOT) ||
                  ((testValue000 == Stella.SYM_STELLA_EQp) ||
                   ((testValue000 == Stella.SYM_STELLA_EQLp) ||
                    ((testValue000 == Stella.SYM_STELLA_e) ||
                     ((testValue000 == Stella.SYM_STELLA_i) ||
                      ((testValue000 == Stella.SYM_STELLA__) ||
                       ((testValue000 == Stella.SYM_STELLA_$) ||
                        ((testValue000 == Stella.SYM_STELLA_s) ||
                         ((testValue000 == Stella.SYM_STELLA_g) ||
                          ((testValue000 == Stella.SYM_STELLA_ge) ||
                           ((testValue000 == Stella.SYM_STELLA_l) ||
                            ((testValue000 == Stella.SYM_STELLA_le) ||
                             ((testValue000 == Stella.SYM_STELLA_THE_CODE) ||
                              ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) ||
                               (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER))))))))))))))))) {
              cost = cost + 1;
              { Stella_Object arg = null;
                Cons iter000 = tree000.rest;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  arg = iter000.value;
                  cost = cost + Stella_Object.estimatedEvaluationCost(arg);
                }
              }
            }
            else {
            }
          }
        }
      }
      else {
      }
      return (cost);
    }
  }

  public static boolean sideEffectFreeExpressionP(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if ((testValue000 == Stella.SYM_STELLA_TYPED_SYS) ||
              ((testValue000 == Stella.SYM_STELLA_CAST) ||
               (testValue000 == Stella.SYM_STELLA_SAFE_CAST))) {
            return (Stella_Object.sideEffectFreeExpressionP(tree000.rest.value));
          }
          else if ((testValue000 == Stella.SYM_STELLA_AND) ||
              ((testValue000 == Stella.SYM_STELLA_OR) ||
               ((testValue000 == Stella.SYM_STELLA_NOT) ||
                ((testValue000 == Stella.SYM_STELLA_EQp) ||
                 ((testValue000 == Stella.SYM_STELLA_EQLp) ||
                  ((testValue000 == Stella.SYM_STELLA_e) ||
                   ((testValue000 == Stella.SYM_STELLA_i) ||
                    ((testValue000 == Stella.SYM_STELLA__) ||
                     ((testValue000 == Stella.SYM_STELLA_$) ||
                      ((testValue000 == Stella.SYM_STELLA_s) ||
                       ((testValue000 == Stella.SYM_STELLA_g) ||
                        ((testValue000 == Stella.SYM_STELLA_ge) ||
                         ((testValue000 == Stella.SYM_STELLA_l) ||
                          ((testValue000 == Stella.SYM_STELLA_le) ||
                           ((testValue000 == Stella.SYM_STELLA_THE_CODE) ||
                            ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) ||
                             (testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER))))))))))))))))) {
            { boolean alwaysP000 = true;

              { Stella_Object arg = null;
                Cons iter000 = tree000.rest;

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  arg = iter000.value;
                  if (!Stella_Object.sideEffectFreeExpressionP(arg)) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
              { boolean value000 = alwaysP000;

                return (value000);
              }
            }
          }
          else {
          }
        }
      }
    }
    else {
      return (true);
    }
    return (false);
  }

  public static Stella_Object yieldCondTestOrTests(Stella_Object casetest, Stella_Object testvariable, Symbol equalitytest) {
    if (Stella_Object.safePrimaryType(casetest) == Stella.SGT_STELLA_CONS) {
      { Cons casetest000 = ((Cons)(casetest));

        { ConsIterator it = casetest000.allocateIterator();

          while (it.nextP()) {
            it.valueSetter(Stella_Object.yieldCondTest(it.value, testvariable, equalitytest));
          }
        }
        casetest000 = Cons.cons(Stella.SYM_STELLA_OR, casetest000);
        return (casetest000);
      }
    }
    else {
      if (casetest == Stella.SYM_STELLA_OTHERWISE) {
        return (casetest);
      }
      else {
        return (Stella_Object.yieldCondTest(casetest, testvariable, equalitytest));
      }
    }
  }

  public static Cons yieldCondTest(Stella_Object casetest, Stella_Object testvariable, Symbol equalitytest) {
    if (Stella_Object.symbolP(casetest) &&
        (!Stella.useHardcodedSymbolsP())) {
      casetest = Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPED_SYS, Cons.cons(GeneralizedSymbol.registerSymbol(((GeneralizedSymbol)(casetest))), Cons.cons(Cons.cons(Stella.SGT_STELLA_SYMBOL, Stella.NIL), Stella.NIL))));
    }
    if (equalitytest == Stella.SYM_STELLA_ISAp) {
      return (Surrogate.yieldIsaPCaseTest(Stella_Object.typify(casetest), testvariable));
    }
    else if (equalitytest == Stella.SYM_STELLA_SUBTYPE_OFp) {
      return (Surrogate.yieldSubtypeOfPCaseTest(Stella_Object.typify(casetest), testvariable));
    }
    else {
      return (Cons.cons(equalitytest, Cons.cons(Stella_Object.copyConsTree(testvariable), Cons.cons(casetest, Stella.NIL))));
    }
  }

  public static Stella_Object yieldHardcodedCaseSymbolIdOrIds(Stella_Object casetest) {
    if (casetest == Stella.SYM_STELLA_OTHERWISE) {
      return (casetest);
    }
    { Symbol symbol = null;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(casetest);

        if (testValue000 == Stella.SGT_STELLA_CONS) {
          { Cons casetest000 = ((Cons)(casetest));

            { ConsIterator it = casetest000.allocateIterator();

              while (it.nextP()) {
                symbol = ((Symbol)(it.value));
                if (!(symbol.symbolId != Stella.NULL_INTEGER)) {
                  symbol = Symbol.internPermanentSymbol(symbol.symbolName);
                }
                it.valueSetter(IntegerWrapper.wrapInteger(symbol.symbolId));
                GeneralizedSymbol.registerSymbol(symbol);
              }
            }
            return (casetest000);
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol casetest000 = ((Symbol)(casetest));

            symbol = casetest000;
            if (!(symbol.symbolId != Stella.NULL_INTEGER)) {
              symbol = Symbol.internPermanentSymbol(symbol.symbolName);
            }
            GeneralizedSymbol.registerSymbol(casetest000);
            return (IntegerWrapper.wrapInteger(symbol.symbolId));
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

  public static boolean andOrNotTreeP(Stella_Object tree) {
    if (Stella_Object.consP(tree)) {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(((Cons)(tree)).value));

        if ((testValue000 == Stella.SYM_STELLA_AND) ||
            ((testValue000 == Stella.SYM_STELLA_OR) ||
             (testValue000 == Stella.SYM_STELLA_NOT))) {
          return (true);
        }
        else {
          return (false);
        }
      }
    }
    else {
      return (false);
    }
  }

  public static Stella_Object coerceMvTree(Stella_Object tree, Symbol operator, List sourcetypes, List targettypes, Object [] MV_returnarray) {
    { boolean valuestreeP = Stella_Object.valuesTreeP(tree);
      Cons valuestree = Stella.NIL;
      boolean needtemporariesP = false;
      boolean successP = false;
      Stella_Object otree = null;
      StandardObject otype = null;
      List returntypes = List.newList();

      if (valuestreeP) {
        valuestree = ((Cons)(tree));
      }
      else {
        valuestree = Cons.cons(Stella.SYM_STELLA_VALUES, Stella.NIL);
        { StandardObject type = null;
          Cons iter000 = sourcetypes.theConsList;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            type = ((StandardObject)(iter000.value));
            if (collect000 == null) {
              {
                collect000 = Cons.cons(Stella_Object.sysTree(null, type, new Object[1]), Stella.NIL);
                if (valuestree == Stella.NIL) {
                  valuestree = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(valuestree, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(Stella_Object.sysTree(null, type, new Object[1]), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      { StandardObject tgtts = null;
        Cons iter001 = targettypes.theConsList;
        StandardObject srcts = null;
        Cons iter002 = sourcetypes.theConsList;
        int i = Stella.NULL_INTEGER;
        int iter003 = 1;
        ConsIterator it = valuestree.rest.allocateIterator();
        Cons collect001 = null;

        for (;(!(iter001 == Stella.NIL)) &&
                  ((!(iter002 == Stella.NIL)) &&
                   it.nextP()); 
              iter001 = iter001.rest,
              iter002 = iter002.rest,
              iter003 = iter003 + 1) {
          tgtts = ((StandardObject)(iter001.value));
          srcts = ((StandardObject)(iter002.value));
          i = iter003;
          { Object [] caller_MV_returnarray = new Object[2];

            otree = Stella_Object.helpCoerceATree(it.value, srcts, tgtts, false, caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
            successP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[1])).wrapperValue));
          }
          if (!(successP)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Type clash on argument `" + Stella_Object.deUglifyParseTree(IntegerWrapper.wrapInteger(i)) + "' of `" + Stella_Object.deUglifyParseTree(operator) + "' operator.");
                    Stella.STANDARD_ERROR.nativeStream.println(" `" + Stella_Object.deUglifyParseTree(srcts) + "' found where `" + Stella_Object.deUglifyParseTree(tgtts) + "' expected.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = ((Cons)((valuestreeP ? tree : ((Stella_Object)(null)))));
              MV_returnarray[1] = targettypes.copy();
              return (_return_temp);
            }
          }
          if ((!Stella_Object.eqlP(otree, it.value)) ||
              ((i > 1) &&
               ((!valuestreeP) &&
                ((!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) &&
                 ((!(StandardObject.typeSpecToBaseType(tgtts) == Stella.SGT_STELLA_UNKNOWN)) &&
                  (!(StandardObject.typeSpecToBaseType(srcts) == StandardObject.typeSpecToBaseType(tgtts)))))))) {
            needtemporariesP = true;
          }
          it.valueSetter(otree);
          if (collect001 == null) {
            {
              collect001 = Cons.cons(otype, Stella.NIL);
              if (returntypes.theConsList == Stella.NIL) {
                returntypes.theConsList = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(returntypes.theConsList, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(otype, Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      if (valuestreeP) {
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = ((Cons)(tree));
          MV_returnarray[1] = returntypes;
          return (_return_temp);
        }
      }
      if (!needtemporariesP) {
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = null;
          MV_returnarray[1] = returntypes;
          return (_return_temp);
        }
      }
      valuestree = Cons.cons(Stella.SYM_STELLA_VALUES, Stella.NIL);
      { int i = Stella.NULL_INTEGER;
        int iter004 = 1;
        int upperBound000 = targettypes.length();
        Cons collect002 = null;

        for (;iter004 <= upperBound000; iter004 = iter004 + 1) {
          i = iter004;
          i = i;
          if (collect002 == null) {
            {
              collect002 = Cons.cons(Stella.localGensym("VALUE"), Stella.NIL);
              if (valuestree == Stella.NIL) {
                valuestree = collect002;
              }
              else {
                Cons.addConsToEndOfConsList(valuestree, collect002);
              }
            }
          }
          else {
            {
              collect002.rest = Cons.cons(Stella.localGensym("VALUE"), Stella.NIL);
              collect002 = collect002.rest;
            }
          }
        }
      }
      otree = Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_MV_BIND, Cons.cons(Cons.copyConsList(valuestree.rest), Cons.cons(Cons.cons(tree, Cons.cons(valuestree, Stella.NIL)), Stella.NIL)))));
      valuestree.firstSetter(Stella.getQuotedTree("((VALUES) \"/STELLA\")", "/STELLA"));
      { ConsIterator it = valuestree.rest.allocateIterator();
        StandardObject srcts = null;
        Cons iter005 = sourcetypes.theConsList;
        StandardObject tgtts = null;
        Cons iter006 = targettypes.theConsList;

        for (;it.nextP() &&
                  ((!(iter005 == Stella.NIL)) &&
                   (!(iter006 == Stella.NIL))); iter005 = iter005.rest, iter006 = iter006.rest) {
          srcts = ((StandardObject)(iter005.value));
          tgtts = ((StandardObject)(iter006.value));
          it.valueSetter(Stella_Object.coerceATree(it.value, srcts, tgtts, new Object[1]));
        }
      }
      { Stella_Object _return_temp = otree;

        MV_returnarray[0] = valuestree;
        MV_returnarray[1] = returntypes;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkMvTree(Stella_Object tree, Object [] MV_returnarray) {
    { Stella_Object otree = null;
      StandardObject otype = null;
      Slot slot = null;

      if (Stella_Object.valuesTreeP(tree)) {
        return (Cons.walkMvValuesTree(((Cons)(tree)), MV_returnarray));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkATree(tree, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      if (Stella_Object.consP(otree)) {
        slot = Cons.slotFromExpressionTree(((Cons)(otree)));
      }
      if (slot != null) {
        if (Surrogate.subtypeOfMethodSlotP(Stella_Object.safePrimaryType(slot))) {
          { MethodSlot slot000 = ((MethodSlot)(slot));

            { Stella_Object _return_temp = otree;

              MV_returnarray[0] = null;
              MV_returnarray[1] = slot000.methodReturnTypeSpecifiers().copy();
              return (_return_temp);
            }
          }
        }
        else {
        }
      }
      { Stella_Object _return_temp = otree;

        MV_returnarray[0] = null;
        MV_returnarray[1] = StandardObject.listifyTypeSpec(otype);
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkMvExpressionTree(Stella_Object tree, List targettypes, Symbol operator, Object [] MV_returnarray) {
    { Object old$Targettype$000 = Stella.$TARGETTYPE$.get();

      try {
        Native.setSpecial(Stella.$TARGETTYPE$, ((targettypes.length() == 1) ? ((StandardObject)(((StandardObject)(targettypes.first())))) : Stella.SGT_STELLA_UNKNOWN));
        { Stella_Object otree = null;
          Cons valuestree = null;
          List sourcetypes = null;

          { Object [] caller_MV_returnarray = new Object[2];

            otree = Stella_Object.walkMvTree(tree, caller_MV_returnarray);
            valuestree = ((Cons)(caller_MV_returnarray[0]));
            sourcetypes = ((List)(caller_MV_returnarray[1]));
          }
          if (!(sourcetypes.length() == targettypes.length())) {
            if ((sourcetypes.length() == 1) &&
                (Stella.SGT_STELLA_UNKNOWN == ((StandardObject)(sourcetypes.first())))) {
              Stella_Object.warnAboutUnknownSourceType(otree);
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
                      Stella.STANDARD_ERROR.nativeStream.println(" `" + Stella_Object.deUglifyParseTree(operator) + "' operator expected `" + targettypes.length() + "' value(s) from `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
            }
            { Stella_Object _return_temp = otree;

              MV_returnarray[0] = valuestree;
              MV_returnarray[1] = targettypes.copy();
              return (_return_temp);
            }
          }
          if (sourcetypes.emptyP()) {
            { Stella_Object _return_temp = otree;

              MV_returnarray[0] = valuestree;
              MV_returnarray[1] = sourcetypes;
              return (_return_temp);
            }
          }
          if (valuestree != null) {
            { Object [] caller_MV_returnarray = new Object[2];

              tree = Stella_Object.coerceMvTree(valuestree, operator, sourcetypes, targettypes, caller_MV_returnarray);
              valuestree = ((Cons)(caller_MV_returnarray[0]));
              targettypes = ((List)(caller_MV_returnarray[1]));
            }
          }
          else {
            { Object [] caller_MV_returnarray = new Object[2];

              otree = Stella_Object.coerceMvTree(otree, operator, sourcetypes, targettypes, caller_MV_returnarray);
              valuestree = ((Cons)(caller_MV_returnarray[0]));
              targettypes = ((List)(caller_MV_returnarray[1]));
            }
          }
          sourcetypes.free();
          { Stella_Object _return_temp = otree;

            MV_returnarray[0] = valuestree;
            MV_returnarray[1] = targettypes;
            return (_return_temp);
          }
        }

      } finally {
        Stella.$TARGETTYPE$.set(old$Targettype$000);
      }
    }
  }

  public static boolean valuesTreeP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (Stella.SYM_STELLA_VALUES == ((Cons)(tree)).value));
  }

  public static StandardObject safeYieldTypeSpecifier(Stella_Object typetree) {
    if (typetree != null) {
      { StandardObject typespec = typetree.yieldTypeSpecifier();

        StandardObject.validateTypeSpecifier(typespec, null, true);
        return (typespec);
      }
    }
    else {
      return (null);
    }
  }

  public static Cons helpTransformBooleanProceduralExpression(Stella_Object expression, Symbol testvariable) {
    if ((!Stella_Object.consP(expression)) ||
        (!Stella_Object.proceduralExpressionP(expression))) {
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(testvariable, Cons.cons(Cons.cons(expression, Stella.NIL), Stella.NIL)))), Stella.NIL));
    }
    { Cons exp = ((Cons)(expression));
      Stella_Object operator = exp.value;
      Stella_Object firstarg = exp.rest.value;
      Cons otherargs = exp.rest.rest;

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(operator));

        if (testValue000 == Stella.SYM_STELLA_AND) {
          if (otherargs == Stella.NIL) {
            return (Stella_Object.helpTransformBooleanProceduralExpression(firstarg, testvariable));
          }
          else if (Stella_Object.proceduralExpressionP(firstarg)) {
            return (Stella_Object.helpTransformBooleanProceduralExpression(firstarg, testvariable).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(testvariable, Cons.cons(Stella_Object.helpTransformBooleanProceduralExpression(Cons.cons(Stella.SYM_STELLA_AND, otherargs.concatenate(Stella.NIL, Stella.NIL)), testvariable).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL));
          }
          else {
            return (Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(testvariable, Cons.cons(Cons.cons(firstarg, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(testvariable, Cons.cons(Stella_Object.helpTransformBooleanProceduralExpression(Cons.cons(Stella.SYM_STELLA_AND, otherargs.concatenate(Stella.NIL, Stella.NIL)), testvariable).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
        }
        else if (testValue000 == Stella.SYM_STELLA_OR) {
          if (otherargs == Stella.NIL) {
            return (Stella_Object.helpTransformBooleanProceduralExpression(firstarg, testvariable));
          }
          else if (Stella_Object.proceduralExpressionP(firstarg)) {
            return (Stella_Object.helpTransformBooleanProceduralExpression(firstarg, testvariable).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(testvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.helpTransformBooleanProceduralExpression(Cons.cons(Stella.SYM_STELLA_OR, otherargs.concatenate(Stella.NIL, Stella.NIL)), testvariable).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL));
          }
          else {
            { Cons otherargstest = Stella_Object.helpTransformBooleanProceduralExpression(Cons.cons(Stella.SYM_STELLA_OR, otherargs.concatenate(Stella.NIL, Stella.NIL)), testvariable);

              if (!(otherargstest.rest == Stella.NIL)) {
                otherargstest = Cons.cons(Cons.cons(Stella.SYM_STELLA_PROGN, otherargstest.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL);
              }
              return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(firstarg, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(testvariable, Cons.cons(Cons.cons(Stella.SYM_STELLA_TRUE, Stella.NIL), Stella.NIL)))), otherargstest.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)))), Stella.NIL));
            }
          }
        }
        else if (testValue000 == Stella.SYM_STELLA_NOT) {
          return (Stella_Object.helpTransformBooleanProceduralExpression(firstarg, testvariable).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(testvariable, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(testvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL));
        }
        else if (testValue000 == Stella.SYM_STELLA_VRLET) {
          { Cons cursor = otherargs;

            while (!(cursor.rest == Stella.NIL)) {
              cursor = cursor.rest;
            }
            cursor.value = Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(testvariable, Cons.cons(Cons.cons(cursor.value, Stella.NIL), Stella.NIL))));
          }
          return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(firstarg, Cons.cons(otherargs.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL));
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

  public static boolean substituteOnce(Stella_Object expression, Stella_Object newtree, Stella_Object oldtree) {
    if (Stella_Object.safePrimaryType(expression) == Stella.SGT_STELLA_CONS) {
      { Cons expression000 = ((Cons)(expression));

        if (!(expression000 == Stella.NIL)) {
          if (Stella_Object.eqlP(expression000.value, oldtree)) {
            expression000.value = newtree;
            return (true);
          }
          return (Stella_Object.substituteOnce(expression000.value, newtree, oldtree) ||
              Stella_Object.substituteOnce(expression000.rest, newtree, oldtree));
        }
      }
    }
    else {
    }
    return (false);
  }

  public static boolean proceduralExpressionP(Stella_Object tree) {
    { boolean testValue000 = false;

      testValue000 = Stella_Object.consP(tree);
      if (testValue000) {
        if (((Cons)(tree)).value == Stella.SYM_STELLA_VRLET) {
          testValue000 = true;
        }
        else {
          { boolean foundP000 = false;

            { Stella_Object term = null;
              Cons iter000 = ((Cons)(tree)).rest;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                term = iter000.value;
                if (Stella_Object.proceduralExpressionP(term)) {
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

  public static boolean vrletExpressionP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_VRLET));
  }

  public static boolean variableExpressionP(Stella_Object tree) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          if (((GeneralizedSymbol)(tree000.value)) == Stella.SYM_STELLA_TYPED_SYS) {
            return (Stella_Object.variableExpressionP(tree000.rest.value));
          }
          else {
          }
          return (false);
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol tree000 = ((Symbol)(tree));

          return (true);
        }
      }
      else {
        return (false);
      }
    }
  }

  public static boolean atomicExpressionP(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (((GeneralizedSymbol)(tree000.value)) == Stella.SYM_STELLA_TYPED_SYS) {
          return (Stella_Object.atomicExpressionP(tree000.rest.value));
        }
        else {
        }
        return (false);
      }
    }
    else {
      return (true);
    }
  }

  public Stella_Object walkAtomicTree(Object [] MV_returnarray) {
    { Stella_Object self = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("walk-atomic-tree: Not defined on `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object helpWalkATree(Stella_Object tree, Object [] MV_returnarray) {
    if (tree == null) {
      { Stella_Object _return_temp = null;

        MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
        return (_return_temp);
      }
    }
    else {
      if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          if (tree000 == Stella.NIL) {
            { Stella_Object _return_temp = Stella.NIL;

              MV_returnarray[0] = Stella.SGT_STELLA_CONS;
              return (_return_temp);
            }
          }
          if (Stella_Object.consP(tree000.value)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Unimplemented or illegal parse tree: `" + Stella_Object.deUglifyParseTree(tree000) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            { Stella_Object _return_temp = tree000;

              MV_returnarray[0] = Stella.SGT_STELLA_VOID;
              return (_return_temp);
            }
          }
          if (!(Stella_Object.consP(tree000.rest))) {
            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal dotted pair or list*.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            { Stella_Object _return_temp = tree000;

              MV_returnarray[0] = Stella.SGT_STELLA_VOID;
              return (_return_temp);
            }
          }
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

            if (testValue000 == Stella.SYM_STELLA_VOID_SYS) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_VOID;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = ((StandardObject)(tree000.rest.rest.value));
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_SYS_FOREACH) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_VOID;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_BAD_SYS) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = ((StandardObject)(tree000.rest.rest.value));
                return (_return_temp);
              }
            }
            else if ((testValue000 == Stella.SYM_STELLA_SETQ) ||
                (testValue000 == Stella.SYM_STELLA_SYS_SET_DEFAULT)) {
              return (Cons.walkSetqTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_SETF) {
              return (Cons.walkSetfTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_SLOT_VALUE) {
              return (Cons.walkSlotValueTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_SLOT_VALUE_SETTER) {
              return (Cons.walkSlotValueSetterTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_AREF) ||
                (testValue000 == Stella.SYM_STELLA_AREF_SETTER)) {
              return (Cons.walkArefTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_PROGN) {
              tree000.rest = Cons.walkListOfStatements(tree000.rest);
              return (Stella_Object.sysTree(tree000, Stella.SGT_STELLA_VOID, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_WITH_PROCESS_LOCK) {
              return (Cons.walkWithProcessLockTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_LOOP) {
              return (Cons.walkLoopTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_LET) {
              return (Cons.walkLetTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_VRLET) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_VALUES) {
              return (Cons.walkValuesTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_SPECIAL) ||
                (testValue000 == Stella.SYM_STELLA_SYS_SPECIAL)) {
              return (Cons.walkSpecialTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_CAST) ||
                (testValue000 == Stella.SYM_STELLA_SAFE_CAST)) {
              return (Cons.walkCastTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_RETURN) {
              return (Cons.walkReturnTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_MV_SETQ) {
              return (Cons.walkMvSetqTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_MV_BIND) {
              return (Cons.walkMvBindTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_BREAK) ||
                (testValue000 == Stella.SYM_STELLA_CONTINUE)) {
              return (Cons.walkLoopExitTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_WHILE) {
              return (Cons.walkWhileTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_FOREACH) ||
                ((testValue000 == Stella.SYM_STELLA_EXISTS) ||
                 ((testValue000 == Stella.SYM_STELLA_FORALL) ||
                  ((testValue000 == Stella.SYM_STELLA_SOME) ||
                   ((testValue000 == Stella.SYM_STELLA_SETOF) ||
                    ((testValue000 == Stella.SYM_STELLA_SET_OF) ||
                     (testValue000 == Stella.SYM_STELLA_SELECT))))))) {
              return (Cons.walkForeachTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_IF) ||
                ((testValue000 == Stella.SYM_STELLA_WHEN) ||
                 (testValue000 == Stella.SYM_STELLA_UNLESS))) {
              return (Cons.walkConditionalTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_CHOOSE) {
              return (Cons.walkChooseTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_AND) ||
                ((testValue000 == Stella.SYM_STELLA_OR) ||
                 (testValue000 == Stella.SYM_STELLA_NOT))) {
              return (Cons.walkBooleanTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_COND) {
              return (Cons.walkCondTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_CASE) {
              return (Cons.walkCaseTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_TYPECASE) {
              return (Cons.walkTypecaseTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_EQp) ||
                ((testValue000 == Stella.SYM_STELLA_EQLp) ||
                 (testValue000 == Stella.SYM_STELLA_e))) {
              return (Cons.walkEqualityTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_i) ||
                ((testValue000 == Stella.SYM_STELLA__) ||
                 ((testValue000 == Stella.SYM_STELLA_$) ||
                  (testValue000 == Stella.SYM_STELLA_s)))) {
              { Stella_Object value000 = null;
                Surrogate value001 = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  value000 = Cons.walkArithmeticTree(tree000, caller_MV_returnarray);
                  value001 = ((Surrogate)(caller_MV_returnarray[0]));
                }
                { Stella_Object _return_temp = value000;

                  MV_returnarray[0] = value001;
                  return (_return_temp);
                }
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_QUOTE) {
              return (Cons.walkQuotedTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_BQUOTE) {
              return (Cons.walkBquoteTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_PRINT_STREAM) ||
                (testValue000 == Stella.SYM_STELLA_PRINT_NATIVE_STREAM)) {
              return (Cons.walkPrintStreamTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_NEW) ||
                ((testValue000 == Stella.SYM_STELLA_ALLOCATE) ||
                 (testValue000 == Stella.SYM_STELLA_LOCAL_NEW))) {
              return (Cons.walkNewTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_MAKE) {
              return (Cons.walkMakeTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_FUNCALL) ||
                ((testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE) ||
                 (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE))) {
              return (Cons.walkFuncallTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_THE_CODE) {
              return (Cons.walkTheCodeTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_SIGNAL_EXCEPTION) {
              return (Cons.walkSignalExceptionTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_EXCEPTION_CASE) {
              return (Cons.walkExceptionCaseTree(tree000, MV_returnarray));
            }
            else if ((testValue000 == Stella.SYM_STELLA_UNWIND_PROTECT) ||
                (testValue000 == Stella.SYM_STELLA_SYS_UNWIND_PROTECT)) {
              { Cons value002 = null;
                Surrogate value003 = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  value002 = Cons.walkUnwindProtectTree(tree000, caller_MV_returnarray);
                  value003 = ((Surrogate)(caller_MV_returnarray[0]));
                }
                { Stella_Object _return_temp = value002;

                  MV_returnarray[0] = value003;
                  return (_return_temp);
                }
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
              return (Cons.walkVerbatimTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_INLINE) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = Stella.SGT_STELLA_VOID;
                return (_return_temp);
              }
            }
            else if ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) ||
                ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) ||
                 ((testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) ||
                  ((testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_SETTER) ||
                   (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION))))) {
              return (Cons.walkSysCallTree(tree000, MV_returnarray));
            }
            else if (testValue000 == Stella.SYM_STELLA_SYS_NEW) {
              { Stella_Object _return_temp = tree000;

                MV_returnarray[0] = ((StandardObject)(tree000.rest.value));
                return (_return_temp);
              }
            }
            else if ((testValue000 == Stella.SYM_STELLA_DEFCLASS) ||
                ((testValue000 == Stella.SYM_STELLA_DEFMETHOD) ||
                 ((testValue000 == Stella.SYM_STELLA_DEFUN) ||
                  ((testValue000 == Stella.SYM_STELLA_DEFMACRO) ||
                   ((testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) ||
                    ((testValue000 == Stella.SYM_STELLA_DEFGLOBAL) ||
                     ((testValue000 == Stella.SYM_STELLA_DEFSPECIAL) ||
                      (testValue000 == Stella.SYM_STELLA_DEFCONSTANT)))))))) {
              { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal declaration -- must appear as a top-level statement;");
                      Stella.STANDARD_ERROR.nativeStream.println("   not nested within other statements..");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
              { Stella_Object _return_temp = null;

                MV_returnarray[0] = Stella.SGT_STELLA_VOID;
                return (_return_temp);
              }
            }
            else {
              if (Stella_Object.symbolP(tree000.value)) {
                return (Cons.walkCallSlotTree(tree000, MV_returnarray));
              }
              else {
                {
                  { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal expression where method name expected:");
                          Stella.STANDARD_ERROR.nativeStream.println("   `" + tree000.value + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                    }
                  }
                  return (Stella_Object.walkDontCallMeTree(tree000, Stella.SGT_STELLA_VOID, MV_returnarray));
                }
              }
            }
          }
        }
      }
      else {
        return (tree.walkAtomicTree(MV_returnarray));
      }
    }
  }

  public static Stella_Object walkATree(Stella_Object tree, Object [] MV_returnarray) {
    return (Stella_Object.helpWalkATree(tree, MV_returnarray));
  }

  public static Surrogate targetLanguageType(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if ((tree000.value == Stella.SYM_STELLA_TYPED_SYS) &&
            (tree000.length() == 4)) {
          return (((Surrogate)(tree000.fourth())));
        }
      }
    }
    else {
    }
    return (null);
  }

  public static Stella_Object walkedExpressionExpression(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if ((testValue000 == Stella.SYM_STELLA_VOID_SYS) ||
              (testValue000 == Stella.SYM_STELLA_TYPED_SYS)) {
            return (tree000.rest.value);
          }
          else {
          }
        }
      }
    }
    else {
    }
    return (tree);
  }

  public static StandardObject walkedExpressionType(Stella_Object tree) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          if (tree000.value == Stella.SYM_STELLA_TYPED_SYS) {
            return (((StandardObject)(tree000.rest.rest.value)));
          }
        }
      }
      else if (Surrogate.subtypeOfWrapperP(testValue000)) {
        { Wrapper tree000 = ((Wrapper)(tree));

          return (Surrogate.wrappedTypeToType(tree000.primaryType()));
        }
      }
      else {
      }
    }
    return (Stella.SGT_STELLA_UNKNOWN);
  }

  public static Cons sysTree(Stella_Object tree, StandardObject typespec, Object [] MV_returnarray) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree000.value));

          if (testValue000 == Stella.SYM_STELLA_VOID_SYS) {
            if (StandardObject.voidP(typespec)) {
              { Cons _return_temp = tree000;

                MV_returnarray[0] = typespec;
                return (_return_temp);
              }
            }
          }
          else if (testValue000 == Stella.SYM_STELLA_TYPED_SYS) {
            if (tree000.rest.rest.value == typespec) {
              { Cons _return_temp = tree000;

                MV_returnarray[0] = typespec;
                return (_return_temp);
              }
            }
          }
          else if (testValue000 == Stella.SYM_STELLA_VRLET) {
            { Cons _return_temp = tree000;

              MV_returnarray[0] = typespec;
              return (_return_temp);
            }
          }
          else {
          }
        }
      }
    }
    else {
    }
    if (StandardObject.voidP(typespec)) {
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_VOID_SYS, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL))));

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
    else {
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_TYPED_SYS, Cons.cons(tree, Cons.cons(Cons.cons(typespec, Stella.NIL), Stella.NIL))));

        MV_returnarray[0] = typespec;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkStatement(Stella_Object tree, boolean warnonatomP) {
    { Stella_Object otree = null;
      StandardObject unusedtypespec = null;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkATree(tree, caller_MV_returnarray);
        unusedtypespec = ((StandardObject)(caller_MV_returnarray[0]));
      }
      unusedtypespec = unusedtypespec;
      if (Stella_Object.safePrimaryType(otree) == Stella.SGT_STELLA_CONS) {
        { Cons otree000 = ((Cons)(otree));

          if (otree000.value == Stella.SYM_STELLA_VRLET) {
            otree000 = Cons.eliminateVrletStatement(otree000);
          }
        }
      }
      else {
        if (warnonatomP &&
            ((otree != null) &&
             (!(otree == Stella.SYM_STELLA_NULL)))) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationWarning();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                {
                  Stella.STANDARD_WARNING.nativeStream.println();
                  Stella.STANDARD_WARNING.nativeStream.println(" Expression found where statement expected: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
        }
      }
      return (otree);
    }
  }

  public static Stella_Object walkWithoutTypeTree(Stella_Object tree) {
    { Stella_Object otree = null;
      StandardObject unusedtypespec = null;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkATree(tree, caller_MV_returnarray);
        unusedtypespec = ((StandardObject)(caller_MV_returnarray[0]));
      }
      unusedtypespec = unusedtypespec;
      return (otree);
    }
  }

  public static StandardObject computeExpressionType(Stella_Object expression, boolean wrapP) {
    { Stella_Object walkedtree = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_X, Cons.cons(Stella_Object.copyConsTree(expression), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL)))), new Object[1]);
      Stella_Object typespec = Cons.consTreeNth(((Cons)(walkedtree)), Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(IntegerWrapper.wrapInteger(1), Stella.NIL)))));

      if (wrapP) {
        return ((StandardObject.subTypeSpecOfP(((StandardObject)(typespec)), Stella.SGT_STELLA_LITERAL) ? StandardObject.typeSpecToBaseType(((StandardObject)(typespec))).typeToWrappedType() : ((StandardObject)(((StandardObject)(typespec))))));
      }
      else {
        return (((StandardObject)(typespec)));
      }
    }
  }

  public static Stella_Object walkExpressionTree(Stella_Object exptree, StandardObject targettype, Symbol operatorname, boolean vrletisokP, Object [] MV_returnarray) {
    { Object old$Targettype$000 = Stella.$TARGETTYPE$.get();

      try {
        Native.setSpecial(Stella.$TARGETTYPE$, ((targettype != null) ? ((StandardObject)(targettype)) : Stella.SGT_STELLA_UNKNOWN));
        { Stella_Object oexp = null;
          StandardObject sourcetype = null;

          { Object [] caller_MV_returnarray = new Object[1];

            oexp = Stella_Object.walkATree(exptree, caller_MV_returnarray);
            sourcetype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          if (Stella_Object.vrletExpressionP(oexp)) {
            if (!(vrletisokP)) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal procedural expression as argument to `" + Stella_Object.deUglifyParseTree(operatorname) + "':");
                      Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(exptree) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
            }
            { Stella_Object _return_temp = oexp;

              MV_returnarray[0] = sourcetype;
              return (_return_temp);
            }
          }
          if (StandardObject.voidP(sourcetype) &&
              (!StandardObject.voidP(targettype))) {
            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal argument to `" + Stella_Object.deUglifyParseTree(operatorname) + "':");
                    Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(oexp) + "'");
                    Stella.STANDARD_ERROR.nativeStream.println("The argument must be an expression, not a statement.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            return (Stella_Object.walkDontCallMeTree(oexp, sourcetype, MV_returnarray));
          }
          if (sourcetype == null) {
            sourcetype = Stella.SGT_STELLA_UNKNOWN;
          }
          if (targettype == null) {
            targettype = sourcetype;
          }
          return (Stella_Object.coerceATree(oexp, sourcetype, targettype, MV_returnarray));
        }

      } finally {
        Stella.$TARGETTYPE$.set(old$Targettype$000);
      }
    }
  }

  public static boolean coercibleP(Stella_Object tree, StandardObject sourcetype, StandardObject targettype) {
    { Stella_Object otree = null;
      StandardObject otype = null;
      boolean coercibleP = false;

      { Object [] caller_MV_returnarray = new Object[2];

        otree = Stella_Object.helpCoerceATree(tree, sourcetype, targettype, true, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
        coercibleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[1])).wrapperValue));
      }
      {
        otree = otree;
        otype = otype;
      }
      return (coercibleP);
    }
  }

  public static Stella_Object helpCoerceATree(Stella_Object tree, StandardObject sourcetype, StandardObject targettype, boolean testonlyP, Object [] MV_returnarray) {
    { Stella_Object coersionfunction = null;
      Surrogate realsourcetype = Stella_Object.targetLanguageType(tree);
      Surrogate sourcebasetype = StandardObject.typeSpecToBaseType(sourcetype);
      Surrogate targetbasetype = StandardObject.typeSpecToBaseType(targettype);

      if (sourcetype == Stella.SGT_STELLA_UNKNOWN) {
        Stella_Object.warnAboutUnknownSourceType(tree);
        if ((tree == Stella.SYM_STELLA_NULL) &&
            (targetbasetype != null)) {
          { Stella_Object _return_temp = StandardObject.typeToWalkedNullValueTree(targettype, targetbasetype);

            MV_returnarray[0] = targettype;
            MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
            return (_return_temp);
          }
        }
        else {
          { Stella_Object _return_temp = tree;

            MV_returnarray[0] = targettype;
            MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
            return (_return_temp);
          }
        }
      }
      if (realsourcetype != null) {
        Cons.setTargetLanguageType(((Cons)(tree)), null, new Object[1]);
        tree = Stella_Object.coerceATree(tree, realsourcetype, sourcetype, new Object[1]);
      }
      if (targettype == Stella.SGT_STELLA_UNKNOWN) {
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = sourcetype;
          MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      if (((Stella_Class)(sourcebasetype.surrogateValue)) == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" No class defined for type: `" + Stella_Object.deUglifyParseTree(sourcebasetype) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = targettype;
          MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      if ((targetbasetype != null) &&
          (((Stella_Class)(targetbasetype.surrogateValue)) == null)) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" No class defined for type: `" + Stella_Object.deUglifyParseTree(targetbasetype) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = sourcetype;
          MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      if (StandardObject.subTypeSpecOfP(sourcetype, targettype)) {
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = sourcetype;
          MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      if ((targetbasetype != null) &&
          (StandardObject.compatibleParameterTypesP(sourcetype, targettype) ||
           ((!StandardObject.arrayTypeSpecifierP(sourcetype)) &&
            (Surrogate.subtypeOfP(targetbasetype, sourcebasetype) &&
             StandardObject.compatibleParameterTypesP(targettype, sourcetype))))) {
        { boolean testValue000 = false;

          testValue000 = Stella_Object.typeP(sourcetype);
          if (testValue000) {
            { 
              coersionfunction = Surrogate.lookupCoersionMethod(((Surrogate)(sourcetype)), targetbasetype, tree);
              testValue000 = coersionfunction != null;
            }
          }
          if (testValue000) {
            if (!(testonlyP)) {
              { Object [] caller_MV_returnarray = new Object[1];

                tree = Stella_Object.applyCoercionMethod(tree, ((Surrogate)(sourcetype)), targetbasetype, coersionfunction, caller_MV_returnarray);
                targettype = ((StandardObject)(caller_MV_returnarray[0]));
              }
            }
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = targettype;
              MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
              return (_return_temp);
            }
          }
        }
        if (Surrogate.subtypeOfP(targetbasetype, sourcebasetype)) {
          if (testonlyP) {
            { Stella_Object _return_temp = tree;

              MV_returnarray[0] = targettype;
              MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
              return (_return_temp);
            }
          }
          { Stella_Object _return_temp = Stella_Object.walkWithoutTypeTree(Cons.cons(((realsourcetype != null) ? Stella.SYM_STELLA_SAFE_CAST : Stella.SYM_STELLA_CAST), Cons.cons(tree, Cons.cons(targettype, Stella.NIL))));

            MV_returnarray[0] = targettype;
            MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
            return (_return_temp);
          }
        }
        if (Surrogate.subtypeOfP(targetbasetype, Stella.SGT_STELLA_NON_OBJECT) &&
            (Stella_Object.typeP(sourcetype) &&
             Surrogate.subtypeOfP(Stella.SGT_STELLA_WRAPPER, ((Surrogate)(sourcetype))))) {
          { Surrogate wrappertype = targetbasetype.typeToWrappedType();

            if (wrappertype != null) {
              if (testonlyP) {
                { Stella_Object _return_temp = tree;

                  MV_returnarray[0] = targettype;
                  MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
                  return (_return_temp);
                }
              }
              coersionfunction = Surrogate.lookupCoersionMethod(wrappertype, targetbasetype, tree);
              if (coersionfunction != null) {
                { Object [] caller_MV_returnarray = new Object[1];

                  tree = Stella_Object.applyCoercionMethod(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(tree, Cons.cons(Cons.cons(wrappertype, Stella.NIL), Stella.NIL)))), ((Surrogate)(sourcetype)), targetbasetype, coersionfunction, caller_MV_returnarray);
                  targettype = ((StandardObject)(caller_MV_returnarray[0]));
                }
                { Stella_Object _return_temp = tree;

                  MV_returnarray[0] = targettype;
                  MV_returnarray[1] = BooleanWrapper.wrapBoolean(true);
                  return (_return_temp);
                }
              }
            }
          }
        }
      }
      { Stella_Object _return_temp = tree;

        MV_returnarray[0] = sourcetype;
        MV_returnarray[1] = BooleanWrapper.wrapBoolean(false);
        return (_return_temp);
      }
    }
  }

  public static Stella_Object coerceATree(Stella_Object tree, StandardObject sourcetype, StandardObject targettype, Object [] MV_returnarray) {
    { Stella_Object otree = null;
      StandardObject otype = null;
      boolean coercibleP = false;

      { Object [] caller_MV_returnarray = new Object[2];

        otree = Stella_Object.helpCoerceATree(tree, sourcetype, targettype, false, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
        coercibleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[1])).wrapperValue));
      }
      if (!(coercibleP)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Type conflict: the expression:");
                Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'");
                Stella.STANDARD_ERROR.nativeStream.println(" has type `" + StandardObject.yieldTypeSpecTree(sourcetype) + "' but should have type `" + StandardObject.yieldTypeSpecTree(targettype) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
      { Stella_Object _return_temp = otree;

        MV_returnarray[0] = otype;
        return (_return_temp);
      }
    }
  }

  public static void warnAboutUnknownSourceType(Stella_Object tree) {
    if (Stella.warnAboutUndefinedMethodsP()) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

        if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { Symbol tree000 = ((Symbol)(tree));

            return;
          }
        }
        else if (testValue000 == Stella.SGT_STELLA_CONS) {
          { Cons tree000 = ((Cons)(tree));

            { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(tree000.value));

              if ((testValue001 == Stella.SYM_STELLA_VERBATIM) ||
                  (testValue001 == Stella.SYM_STELLA_VRLET)) {
                return;
              }
              else if (testValue001 == Stella.SYM_STELLA_SYS_CALL_METHOD) {
                if (Symbol.symbolCommonLispP(((Symbol)(tree000.rest.rest.value))) ||
                    (Stella_Class.lookupSlot(((Stella_Class)(((Surrogate)(tree000.rest.value)).surrogateValue)), ((Symbol)(tree000.rest.rest.value))) == null)) {
                  return;
                }
              }
              else if (testValue001 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
                if (Symbol.lookupFunction(((Symbol)(tree000.rest.value))).slotBaseType == Stella.SGT_STELLA_UNKNOWN) {
                  return;
                }
              }
              else if ((testValue001 == Stella.SYM_STELLA_TYPED_SYS) ||
                  (testValue001 == Stella.SYM_STELLA_SYS_INLINE_CALL)) {
                Stella_Object.warnAboutUnknownSourceType(tree000.rest.value);
                return;
              }
              else {
              }
            }
          }
        }
        else {
          if (tree == null) {
            return;
          }
        }
      }
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" The expression");
              Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'");
              Stella.STANDARD_ERROR.nativeStream.println(" has UNKNOWN type.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
    }
  }

  public static Stella_Object applyCoercionMethod(Stella_Object expression, Surrogate sourcetype, Surrogate targettype, Stella_Object coercionmethod, Object [] MV_returnarray) {
    if (coercionmethod == null) {
      coercionmethod = Surrogate.lookupCoersionMethod(sourcetype, targettype, expression);
    }
    if (coercionmethod == null) {
      { Stella_Object _return_temp = expression;

        MV_returnarray[0] = sourcetype;
        return (_return_temp);
      }
    }
    if (coercionmethod == Stella.SYM_STELLA_IDENTITY) {
      { Stella_Object _return_temp = expression;

        MV_returnarray[0] = targettype;
        return (_return_temp);
      }
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(coercionmethod);

      if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol coercionmethod000 = ((Symbol)(coercionmethod));

          return (Stella_Object.walkExpressionTree(Cons.cons(coercionmethod000, Cons.cons(expression, Stella.NIL)), targettype, coercionmethod000, false, MV_returnarray));
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons coercionmethod000 = ((Cons)(coercionmethod));

          return (Stella_Object.walkExpressionTree(Stella_Object.copyConsTree(Stella_Object.substituteConsTree(((Cons)(Stella_Object.copyConsTree(coercionmethod000))), expression, Stella.SYM_STELLA_lXg)), targettype, ((Symbol)(coercionmethod000.value)), false, MV_returnarray));
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

  public static Cons treeToTrees(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000.value == Stella.SYM_STELLA_PROGN) {
          return (tree000.rest);
        }
      }
    }
    else {
    }
    return (Cons.cons(tree, Stella.NIL));
  }

  public static boolean illegalTreeP(Stella_Object tree) {
    return (Stella_Object.consP(tree) &&
        (((Cons)(tree)).value == Stella.SYM_STELLA_BAD_SYS));
  }

  public static Cons walkDontCallMeTree(Stella_Object tree, StandardObject returntype, Object [] MV_returnarray) {
    { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_BAD_SYS, Cons.cons(tree, Cons.cons(Cons.cons(StandardObject.typeSpecToBaseType(returntype), Stella.NIL), Stella.NIL))));

      MV_returnarray[0] = returntype;
      return (_return_temp);
    }
  }

  public static void po(Stella_Object thing) {
    Stella.STANDARD_OUTPUT.nativeStream.println(thing.toString());
  }

  /** Translate a single Stella expression <code>tree</code> and return
   * the result.  For C++ and Java print the translation to standard output and
   * return NIL instead.
   * @param tree
   * @return Stella_Object
   */
  public static Stella_Object incrementallyTranslate(Stella_Object tree) {
    { boolean toplevelinvocationP = ((List)(Stella.$TRANSLATIONUNITS$.get())) == null;
      Stella_Object ocode = null;
      boolean declarationP = Stella_Object.consP(tree) &&
          Cons.declarationTreeP(((Cons)(tree)));

      { Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();
        Object old$Translationverbositylevel$000 = Stella.$TRANSLATIONVERBOSITYLEVEL$.get();
        Object old$Translationphase$000 = Stella.$TRANSLATIONPHASE$.get();
        Object old$Translationerrors$000 = Stella.$TRANSLATIONERRORS$.get();
        Object old$Translationwarnings$000 = Stella.$TRANSLATIONWARNINGS$.get();
        Object old$Translationnotes$000 = Stella.$TRANSLATIONNOTES$.get();

        try {
          Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
          Native.setIntSpecial(Stella.$TRANSLATIONVERBOSITYLEVEL$, 0);
          Native.setSpecial(Stella.$TRANSLATIONPHASE$, null);
          Native.setIntSpecial(Stella.$TRANSLATIONERRORS$, 0);
          Native.setIntSpecial(Stella.$TRANSLATIONWARNINGS$, 0);
          Native.setIntSpecial(Stella.$TRANSLATIONNOTES$, 0);
          if (declarationP) {
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_DEFINE);
            Cons.walkTopLevelTree(((Cons)(tree)), false);
            if (Stella.translationErrorsP()) {
              Stella.summarizeTranslationErrors();
              return (Stella.NIL);
            }
            ((List)(Stella.$TRANSLATIONUNITS$.get())).reverse();
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_FINALIZE);
            Stella.finalizeClassesAndSlots();
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_WALK);
            if (!(Stella.useHardcodedSymbolsP())) {
              Stella.clearSymbolRegistry();
            }
            Stella.walkAllPhaseOneUnits();
          }
          else {
            Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_WALK);
            { Object old$UsehardcodedsymbolsP$000 = Stella.$USEHARDCODEDSYMBOLSp$.get();

              try {
                Native.setBooleanSpecial(Stella.$USEHARDCODEDSYMBOLSp$, true);
                ocode = Stella_Object.walkTopLevelExpression(tree);

              } finally {
                Stella.$USEHARDCODEDSYMBOLSp$.set(old$UsehardcodedsymbolsP$000);
              }
            }
          }
          if (Stella.translationErrorsP()) {
            Stella.summarizeTranslationErrors();
            return (Stella.NIL);
          }
          Native.setSpecial(Stella.$TRANSLATIONPHASE$, Stella.KWD_TRANSLATE);
          if (declarationP) {
            Stella.translateAllUnits();
            ocode = Stella.combineTranslatedTrees();
          }
          else {
            { Object old$UsehardcodedsymbolsP$001 = Stella.$USEHARDCODEDSYMBOLSp$.get();

              try {
                Native.setBooleanSpecial(Stella.$USEHARDCODEDSYMBOLSp$, true);
                ocode = Stella_Object.translateWalkedTree(ocode);

              } finally {
                Stella.$USEHARDCODEDSYMBOLSp$.set(old$UsehardcodedsymbolsP$001);
              }
            }
          }
          if (Stella.translationErrorsP()) {
            Stella.summarizeTranslationErrors();
            return (Stella.NIL);
          }
          if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
          }
          else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
            Cons.idlOutputParseTree(((Cons)(ocode)));
            ocode = Stella.NIL;
          }
          else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
            Cons.javaOutputParseTree(((Cons)(ocode)));
            ocode = Stella.NIL;
          }
          else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
              (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
            Cons.cppOutputParseTree(((Cons)(ocode)));
            ocode = Stella.NIL;
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          { TranslationUnit unit = null;
            Cons iter000 = ((List)(Stella.$TRANSLATIONUNITS$.get())).theConsList;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              unit = ((TranslationUnit)(iter000.value));
              unit.free();
            }
          }
          ((List)(Stella.$TRANSLATIONUNITS$.get())).clear();
          if (toplevelinvocationP) {
            Stella.sweepTransients();
          }
          Stella.summarizeTranslationErrors();
          return (ocode);

        } finally {
          Stella.$TRANSLATIONNOTES$.set(old$Translationnotes$000);
          Stella.$TRANSLATIONWARNINGS$.set(old$Translationwarnings$000);
          Stella.$TRANSLATIONERRORS$.set(old$Translationerrors$000);
          Stella.$TRANSLATIONPHASE$.set(old$Translationphase$000);
          Stella.$TRANSLATIONVERBOSITYLEVEL$.set(old$Translationverbositylevel$000);
          Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
        }
      }
    }
  }

  public static Stella_Object translateWalkedTree(Stella_Object codetree) {
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return (Stella_Object.clTranslateATree(codetree));
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL) {
      return (Stella_Object.idlTranslateATree(codetree));
    }
    else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      return (Stella_Object.javaTranslateATree(codetree));
    }
    else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
        (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
      return (Stella_Object.cppTranslateATree(codetree));
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object walkTopLevelExpression(Stella_Object tree) {
    { Object old$Localvariabletypetable$000 = Stella.$LOCALVARIABLETYPETABLE$.get();

      try {
        Native.setSpecial(Stella.$LOCALVARIABLETYPETABLE$, KeyValueList.newKeyValueList());
        { Stella_Object otree = Stella_Object.walkWithoutTypeTree(tree);

          if (Stella_Object.vrletExpressionP(otree)) {
            return (Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(otree, Cons.cons(Stella.NIL, Stella.NIL))))));
          }
          return (otree);
        }

      } finally {
        Stella.$LOCALVARIABLETYPETABLE$.set(old$Localvariabletypetable$000);
      }
    }
  }

  public static boolean traceKeywordP(Stella_Object keyword) {
    { boolean testValue000 = false;

      testValue000 = Stella.$TRACED_KEYWORDS$ != null;
      if (testValue000) {
        { boolean chooseValue000 = false;

          if (Stella_Object.consP(keyword)) {
            { boolean foundP000 = false;

              { Stella_Object kwd = null;
                Cons iter000 = ((Cons)(keyword));

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  kwd = iter000.value;
                  if (Stella.$TRACED_KEYWORDS$.membP(((Keyword)(kwd)))) {
                    foundP000 = true;
                    break loop000;
                  }
                }
              }
              chooseValue000 = foundP000;
            }
          }
          else {
            chooseValue000 = Stella.$TRACED_KEYWORDS$.membP(((Keyword)(keyword)));
          }
          testValue000 = chooseValue000;
        }
      }
      { boolean value000 = testValue000;

        return (value000);
      }
    }
  }

  /** If <code>keyword</code> is a trace keyword that has been enabled with <code>addTrace</code>
   * print all the elements in <code>body</code> to standard output.  Otherwise, do nothing.
   * <code>keyword</code> can also be a list of keywords in which case printing is done if
   * one or more of them are trace enabled.
   * @param keyword
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object traceIf(Stella_Object keyword, Cons body) {
    { Cons test = Stella.NIL;
      Cons elements = Cons.copyConsList(body);

      if (Stella_Object.safePrimaryType(keyword) == Stella.SGT_STELLA_CONS) {
        { Cons keyword000 = ((Cons)(keyword));

          { Stella_Object kwd = null;
            Cons iter000 = keyword000;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              kwd = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMBp, Cons.cons(Stella.SYM_STELLA_$TRACED_KEYWORDS$, Cons.cons(kwd, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
                  if (test == Stella.NIL) {
                    test = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(test, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMBp, Cons.cons(Stella.SYM_STELLA_$TRACED_KEYWORDS$, Cons.cons(kwd, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          switch (test.length()) {
            case 0: 
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Missing `trace-if' keyword.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              return (Stella_Object.walkDontCallMeTree(Stella.NIL, Stella.SGT_STELLA_VOID, new Object[1]));
            case 1: 
              test = ((Cons)(test.value));
            break;
            default:
              test = Cons.cons(Stella.SYM_STELLA_OR, test);
            break;
          }
        }
      }
      else {
        test = Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMBp, Cons.cons(Stella.SYM_STELLA_$TRACED_KEYWORDS$, Cons.cons(keyword, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_AND, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_$TRACED_KEYWORDS$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(test, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_PRINT, Cons.copyConsList(elements).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(((((elements.last() == Stella.SYM_STELLA_EOL) ||
          (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) ? Stella.NIL : Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FLUSH_OUTPUT, Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))));
    }
  }

  public static Cons wrapWhereTest(Stella_Object wheretest, Cons actions) {
    if (wheretest != null) {
      return (Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(wheretest, Cons.cons(actions.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL));
    }
    else {
      return (actions);
    }
  }

  public static Cons yieldInCursorClausesForArgumentList(Stella_Object collectiontree, StandardObject collectiontype, Symbol keyvar, Symbol valuevar, Object [] MV_returnarray) {
    if (keyvar != null) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal key variable specified for `" + Stella_Object.deUglifyParseTree(collectiontype) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      { Cons _return_temp = Stella.NIL;

        MV_returnarray[0] = Stella.NIL;
        MV_returnarray[1] = Stella.NIL;
        MV_returnarray[2] = Stella.SYM_STELLA_FALSE;
        return (_return_temp);
      }
    }
    if (!MethodSlot.passVariableArgumentsAsListP(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())))) {
      { ParametricTypeSpecifier self000 = ParametricTypeSpecifier.newParametricTypeSpecifier();

        self000.specifierBaseType = Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR;
        self000.specifierParameterTypes = List.list(Cons.cons(StandardObject.extractParameterType(collectiontype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]), Stella.NIL));
        { ParametricTypeSpecifier iteratortype = self000;

          return (Stella_Object.yieldInCursorClausesForGeneralCollection(Stella_Object.sysTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR, Cons.cons(Stella.SYM_STELLA_ALLOCATE_ITERATOR, Cons.cons(Stella_Object.walkWithoutTypeTree(collectiontree), Cons.cons(Stella.NIL, Stella.NIL)))))), iteratortype, new Object[1]), iteratortype, keyvar, valuevar, MV_returnarray));
        }
      }
    }
    { StandardObject listifiedtype = MethodSlot.yieldListifiedVariableArgumentsType(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())));
      StandardObject elementtype = StandardObject.extractParameterType(collectiontype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);

      { Cons iteratorclauses = null;
        Cons valueclauses = null;
        Cons bumpclauses = null;
        Stella_Object continuationtest = null;

        { Object [] caller_MV_returnarray = new Object[3];

          iteratorclauses = Stella_Object.yieldInCursorClausesForGeneralCollection(Stella_Object.sysTree(collectiontree, listifiedtype, new Object[1]), listifiedtype, keyvar, valuevar, caller_MV_returnarray);
          valueclauses = ((Cons)(caller_MV_returnarray[0]));
          bumpclauses = ((Cons)(caller_MV_returnarray[1]));
          continuationtest = ((Stella_Object)(caller_MV_returnarray[2]));
        }
        if (StandardObject.subTypeSpecOfP(elementtype, Stella.SGT_STELLA_LITERAL)) {
          { Cons clause = null;
            Cons iter000 = ((Cons)(iteratorclauses));

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              clause = ((Cons)(iter000.value));
              if (clause.value == valuevar) {
                clause.secondSetter(elementtype);
                break loop000;
              }
            }
          }
        }
        { Cons _return_temp = iteratorclauses;

          MV_returnarray[0] = valueclauses;
          MV_returnarray[1] = bumpclauses;
          MV_returnarray[2] = continuationtest;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons yieldInCursorClausesForVector(Stella_Object collectiontree, StandardObject collectiontype, Symbol keyvar, Symbol valuevar, Object [] MV_returnarray) {
    if (keyvar != null) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal key variable specified for `" + Stella_Object.deUglifyParseTree(collectiontype) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      { Cons _return_temp = Stella.NIL;

        MV_returnarray[0] = Stella.NIL;
        MV_returnarray[1] = Stella.NIL;
        MV_returnarray[2] = Stella.SYM_STELLA_FALSE;
        return (_return_temp);
      }
    }
    { Symbol vectorvar = Stella.localGensym("VECTOR");
      Symbol indexvar = Stella.localGensym("INDEX");
      Symbol lengthvar = Stella.localGensym("LENGTH");

      { Cons _return_temp = Cons.list$(Cons.cons(Cons.cons(valuevar, Cons.cons((((collectiontype == Stella.SGT_STELLA_STRING) ||
            (collectiontype == Stella.SGT_STELLA_MUTABLE_STRING)) ? Stella.SGT_STELLA_CHARACTER : ((StandardObject)(StandardObject.extractParameterType(collectiontype, Stella.SYM_STELLA_ANY_VALUE, new Object[1])))), Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))), Cons.cons(Cons.cons(vectorvar, Cons.cons(collectiontype, Cons.cons(collectiontree, Stella.NIL))), Cons.cons(Cons.cons(indexvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(lengthvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LENGTH, Cons.cons(vectorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));

        MV_returnarray[0] = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(valuevar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(vectorvar, Cons.cons(Cons.cons(indexvar, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL);
        MV_returnarray[1] = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(indexvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
        MV_returnarray[2] = Cons.list$(Cons.cons(Stella.SYM_STELLA_l, Cons.cons(indexvar, Cons.cons(Cons.cons(lengthvar, Stella.NIL), Stella.NIL))));
        return (_return_temp);
      }
    }
  }

  public static Cons yieldInCursorClausesForGeneralCollection(Stella_Object collectiontree, StandardObject collectiontype, Symbol keyvar, Symbol valuevar, Object [] MV_returnarray) {
    { Surrogate collectionbasetype = StandardObject.typeSpecToBaseType(collectiontype);
      Symbol iteratorvar = Stella.localGensym("ITER");
      Cons iteratorclauses = Stella.NIL;
      Cons valueclauses = Stella.NIL;
      Stella_Object continuationtest = null;
      Cons keytree = Stella.NIL;
      Cons valuetree = Stella.NIL;
      Cons bumptrees = Stella.NIL;

      if (collectionbasetype == Stella.SGT_STELLA_LIST) {
        iteratorclauses = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_CONS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_CONS_LIST, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
        collectionbasetype = Stella.SGT_STELLA_CONS;
      }
      else if (collectionbasetype == Stella.SGT_STELLA_KEY_VALUE_LIST) {
        iteratorclauses = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_KV_CONS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_KV_LIST, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
        collectionbasetype = Stella.SGT_STELLA_KV_CONS;
      }
      else if (collectionbasetype == Stella.SGT_STELLA_PROPERTY_LIST) {
        iteratorclauses = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_CONS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_PLIST, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
      }
      else if ((collectionbasetype == Stella.SGT_STELLA_CONS) ||
          (collectionbasetype == Stella.SGT_STELLA_KV_CONS)) {
        iteratorclauses = Cons.cons(Cons.cons(iteratorvar, Cons.cons(collectionbasetype, Cons.cons(collectiontree, Stella.NIL))), Stella.NIL);
      }
      else {
        if (!(Surrogate.safeSubtypeOfP(collectionbasetype, Stella.SGT_STELLA_ABSTRACT_ITERATOR))) {
          collectiontree = Cons.list$(Cons.cons(Stella.SYM_STELLA_ALLOCATE_ITERATOR, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL))));
        }
        iteratorclauses = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_ABSTRACT_ITERATOR, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
        collectionbasetype = Stella.SGT_STELLA_ABSTRACT_ITERATOR;
      }
      if (keyvar != null) {
        keytree = Cons.list$(Cons.cons(Stella.SYM_STELLA_KEY, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      valuetree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
      if (collectionbasetype == Stella.SGT_STELLA_CONS) {
        bumptrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(iteratorvar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL);
        continuationtest = Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NILp, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (collectionbasetype == Stella.SGT_STELLA_KV_CONS) {
        bumptrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(iteratorvar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL);
        continuationtest = Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (collectionbasetype == Stella.SGT_STELLA_PROPERTY_LIST) {
        if (keyvar != null) {
          keytree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
        }
        valuetree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
        bumptrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(iteratorvar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_REST, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL);
        continuationtest = Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NILp, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (collectionbasetype == Stella.SGT_STELLA_ABSTRACT_ITERATOR) {
        bumptrees = Stella.NIL;
        continuationtest = Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXTp, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + collectionbasetype + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
      iteratorclauses = Cons.cons(Cons.cons(valuevar, Cons.cons(StandardObject.extractParameterType(collectiontype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]), Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))), iteratorclauses);
      valueclauses = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(valuevar, Cons.cons(Cons.cons(valuetree, Stella.NIL), Stella.NIL)))), valueclauses);
      if (keyvar != null) {
        { StandardObject keytype = null;
          boolean parameterexistsP = false;

          { Object [] caller_MV_returnarray = new Object[1];

            keytype = StandardObject.extractParameterType(collectiontype, Stella.SYM_STELLA_ANY_KEY, caller_MV_returnarray);
            parameterexistsP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
          }
          if (parameterexistsP) {
            iteratorclauses = Cons.cons(Cons.cons(keyvar, Cons.cons(keytype, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))), iteratorclauses);
            valueclauses = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(keyvar, Cons.cons(Cons.cons(keytree, Stella.NIL), Stella.NIL)))), valueclauses);
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
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal key variable specified for keyless collection `" + Stella_Object.deUglifyParseTree(collectiontype) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            { Cons _return_temp = Stella.NIL;

              MV_returnarray[0] = Stella.NIL;
              MV_returnarray[1] = Stella.NIL;
              MV_returnarray[2] = Stella.SYM_STELLA_FALSE;
              return (_return_temp);
            }
          }
        }
      }
      { Cons _return_temp = iteratorclauses;

        MV_returnarray[0] = valueclauses;
        MV_returnarray[1] = bumptrees;
        MV_returnarray[2] = continuationtest;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkCollectionTree(Stella_Object tree, boolean dontoptimizeP, Object [] MV_returnarray) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if ((!dontoptimizeP) &&
            ((tree000.value == Stella.SYM_STELLA_INTERVAL) &&
             (tree000.length() == 3))) {
          { Stella_Object _return_temp = tree000;

            MV_returnarray[0] = Stella.SGT_STELLA_INTEGER_INTERVAL;
            return (_return_temp);
          }
        }
      }
    }
    else {
    }
    { Stella_Object otree = null;
      StandardObject otype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkExpressionTree(tree, Stella.SGT_STELLA_UNKNOWN, Stella.SYM_STELLA_FOREACH, false, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      return (Stella_Object.sysTree(otree, otype, MV_returnarray));
    }
  }

  public static void defaultOptionHandler(Stella_Object self, StorageSlot slot, Stella_Object tree) {
    { Stella_Object parsedvalue = null;

      if (slot.type() == Stella.SGT_STELLA_BOOLEAN) {
        parsedvalue = Stella_Object.coerceToBoolean(tree);
      }
      else {
        if (tree != null) {
          parsedvalue = Stella_Object.permanentCopy(tree);
        }
      }
      if ((((Integer)(Stella.$SAFETY$.get())).intValue() >= 2) &&
          (parsedvalue != null)) {
        if (!Stella_Object.isaP(parsedvalue, slot.type().typeToWrappedType())) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal value for `" + ((Keyword)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_OPTION_KEYWORD, null))) + "' option: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return;
        }
      }
      StandardObject.writeSlotValue(((StandardObject)(self)), slot, parsedvalue);
    }
  }

  public static boolean runOptionHandlerP(Stella_Object renamed_Object, Keyword option, Stella_Object valuetree) {
    { StorageSlot slot = Surrogate.lookupSlotFromOptionKeyword(renamed_Object.primaryType(), option);
      MethodSlot handler = ((slot != null) ? StorageSlot.lookupOptionHandler(slot) : ((MethodSlot)(null)));

      if (handler != null) {
        edu.isi.stella.javalib.Native.funcall(handler.functionCode, null, new java.lang.Object [] {renamed_Object, slot, valuetree});
        return (true);
      }
      return (false);
    }
  }

  public static Symbol destructureMethodNameTree(Stella_Object nametree, Object [] MV_returnarray) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(nametree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons nametree000 = ((Cons)(nametree));

          if (!Stella_Object.symbolP(nametree000.value)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal method name: `" + Stella_Object.deUglifyParseTree(nametree000) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            { Symbol _return_temp = null;

              MV_returnarray[0] = null;
              return (_return_temp);
            }
          }
          if (nametree000.rest.value == Stella.SYM_STELLA_SETTER) {
            { Symbol _return_temp = Symbol.yieldSetterMethodName(((Symbol)(nametree000.value)));

              MV_returnarray[0] = Stella.NIL;
              return (_return_temp);
            }
          }
          else {
            { Symbol _return_temp = ((Symbol)(nametree000.value));

              MV_returnarray[0] = nametree000.rest;
              return (_return_temp);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol nametree000 = ((Symbol)(nametree));

          { Symbol _return_temp = nametree000;

            MV_returnarray[0] = Stella.NIL;
            return (_return_temp);
          }
        }
      }
      else {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal method name: `" + Stella_Object.deUglifyParseTree(nametree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        { Symbol _return_temp = null;

          MV_returnarray[0] = null;
          return (_return_temp);
        }
      }
    }
  }

  public static KeyValueList collectKeyValueList(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { int length = tree000.length();
          Cons cursor = tree000;
          Stella_Object key = null;
          Stella_Object value = null;
          KeyValueList result = null;

          if (length == 0) {
            return (null);
          }
          if (((length % 2) == 1)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Unbalanced keys and values in key-value list: `" + Stella_Object.deUglifyParseTree(tree000) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            return (null);
          }
          result = KeyValueList.newKeyValueList();
          loop000 : while (!(cursor == Stella.NIL)) {
            key = cursor.value;
            value = cursor.rest.value;
            cursor = cursor.rest.rest;
            if (!Stella_Object.isaP(key, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Ignoring illegal key `" + Stella_Object.deUglifyParseTree(key) + "' in key-value list: `" + Stella_Object.deUglifyParseTree(tree000) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
              continue loop000;
            }
            if ((value == Stella.SYM_STELLA_TRUE) ||
                (value == Stella.SYM_STELLA_FALSE)) {
              value = Stella_Object.coerceToBoolean(value);
            }
            else {
              value = Stella_Object.permanentCopy(value);
            }
            result.insertAt(key.permanentify(), value);
          }
          return (result);
        }
      }
    }
    else {
      { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal atomic key-value list: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
        }
      }
      return (null);
    }
  }

  public static List collectFeatureList(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { List result = null;

          if (tree000.length() > 0) {
            result = List.newList();
          }
          { Stella_Object feature = null;
            Cons iter000 = tree000;
            Cons collect000 = null;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              feature = iter000.value;
              if (!Stella_Object.isaP(feature, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Ignoring illegal feature `" + Stella_Object.deUglifyParseTree(feature) + "' in feature list: `" + Stella_Object.deUglifyParseTree(tree000) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                continue loop000;
              }
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(feature.permanentify(), Stella.NIL);
                  if (result.theConsList == Stella.NIL) {
                    result.theConsList = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(result.theConsList, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(feature.permanentify(), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          return (result);
        }
      }
    }
    else {
      { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal atomic feature list: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
        }
      }
      return (null);
    }
  }

  /** Stringify a parse <code>tree</code> relative to <code>module</code>, or
   * <code>$MODULE$</code> if no module is specified.
   * @param tree
   * @param module
   * @return String
   */
  public static String stringifyInModule(Stella_Object tree, Module module) {
    if (module == null) {
      module = ((Module)(Stella.$MODULE$.get()));
    }
    { Object old$Module$000 = Stella.$MODULE$.get();
      Object old$Context$000 = Stella.$CONTEXT$.get();

      try {
        Native.setSpecial(Stella.$MODULE$, module);
        Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
        return (Native.stringify(tree));

      } finally {
        Stella.$CONTEXT$.set(old$Context$000);
        Stella.$MODULE$.set(old$Module$000);
      }
    }
  }

  public static Stella_Object transientifyForm(Stella_Object form) {
    return (Stella_Object.copyConsTree(form));
  }

  public static Stella_Object permanentifyForm(Stella_Object form) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(form);

      if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol form000 = ((Symbol)(form));

          if (form000 == Stella.SYM_STELLA_TRUE) {
            return (form000);
          }
          else if (form000 == Stella.SYM_STELLA_FALSE) {
            return (form000);
          }
          else {
            return (((Symbol)(form000.permanentify())));
          }
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons form000 = ((Cons)(form));

          return (Stella_Object.permanentCopy(form000));
        }
      }
      else {
        return (form.permanentify());
      }
    }
  }

  public static void dealWithEra(Stella_Object formValue, DecodedDateTime parsedValues) {
    if (formValue == Stella.SYM_STELLA_BCE) {
      parsedValues.dateTimeYear = 0 - parsedValues.dateTimeYear;
    }
    else {
      if (!(formValue == Stella.SYM_STELLA_CE)) {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + formValue + "'isn't BCE/CE - this shouldn't happen.");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static void dealWithAmPm(Stella_Object formValue, DecodedDateTime parsedValues) {
    { int hour = parsedValues.dateTimeHour;

      if (formValue == Stella.SYM_STELLA_AM) {
        if (hour == 12) {
          parsedValues.dateTimeHour = 0;
        }
        else if (!((0 <= hour) &&
            (hour <= 12))) {
          if (((Boolean)(Stella.$ERROR_ON_MISMATCH$.get())).booleanValue()) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + hour + "' is not an AM hour.");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      else if (formValue == Stella.SYM_STELLA_PM) {
        if ((0 <= hour) &&
            (hour <= 11)) {
          parsedValues.dateTimeHour = hour + 12;
        }
      }
      else {
        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

          stream001.nativeStream.print("`" + formValue + "'isn't AM/PM - this shouldn't happen.");
          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static void dealWithNoonMidn(Stella_Object formValue, DecodedDateTime parsedValues) {
    if (formValue == Stella.SYM_STELLA_NOON) {
      parsedValues.dateTimeHour = 12;
    }
    else if (formValue == Stella.SYM_STELLA_MIDN) {
      parsedValues.dateTimeHour = 0;
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Unrecognized symbol: ~A`" + formValue + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    parsedValues.dateTimeMinute = 0;
    parsedValues.dateTimeSecond = 0;
  }

  public static BooleanWrapper dateTimeDivider(Stella_Object thecharacter) {
    if (Surrogate.subtypeOfCharacterP(Stella_Object.safePrimaryType(thecharacter))) {
      { CharacterWrapper thecharacter000 = ((CharacterWrapper)(thecharacter));

        return ((Stella.DATE_TIME_DIVIDERS.memberP(thecharacter000) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper dateDivider(Stella_Object thecharacter) {
    if (Surrogate.subtypeOfCharacterP(Stella_Object.safePrimaryType(thecharacter))) {
      { CharacterWrapper thecharacter000 = ((CharacterWrapper)(thecharacter));

        return ((Stella.DATE_DIVIDERS.memberP(thecharacter000) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper timeDivider(Stella_Object thecharacter) {
    if (Surrogate.subtypeOfCharacterP(Stella_Object.safePrimaryType(thecharacter))) {
      { CharacterWrapper thecharacter000 = ((CharacterWrapper)(thecharacter));

        return ((Stella.TIME_DIVIDERS.memberP(thecharacter000) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper year(Stella_Object number) {
    if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(number))) {
      { IntegerWrapper number000 = ((IntegerWrapper)(number));

        return ((((-4713 <= number000.wrapperValue) ||
            (number000.wrapperValue <= 5000)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper day(Stella_Object number) {
    if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(number))) {
      { IntegerWrapper number000 = ((IntegerWrapper)(number));

        return ((((1 <= number000.wrapperValue) &&
            (number000.wrapperValue <= 31)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper hour(Stella_Object number) {
    if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(number))) {
      { IntegerWrapper number000 = ((IntegerWrapper)(number));

        return ((((0 <= number000.wrapperValue) &&
            (number000.wrapperValue <= 23)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper zoneMinute(Stella_Object number) {
    if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(number))) {
      { IntegerWrapper number000 = ((IntegerWrapper)(number));

        return ((((0 <= number000.wrapperValue) &&
            (number000.wrapperValue <= 59)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper minute(Stella_Object number) {
    if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(number))) {
      { IntegerWrapper number000 = ((IntegerWrapper)(number));

        return ((((0 <= number000.wrapperValue) &&
            (number000.wrapperValue <= 59)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
      }
    }
    else {
      return (Stella.FALSE_WRAPPER);
    }
  }

  public static BooleanWrapper secondp(Stella_Object number) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(number);

      if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper number000 = ((IntegerWrapper)(number));

          return ((((0 <= number000.wrapperValue) &&
              (number000.wrapperValue <= 59)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper number000 = ((FloatWrapper)(number));

          return ((((0.0 <= number000.wrapperValue) &&
              (number000.wrapperValue < 60.0)) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
        }
      }
      else {
        return (Stella.FALSE_WRAPPER);
      }
    }
  }

  public static Symbol specialp(Stella_Object string) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(string))) {
      { StringWrapper string000 = ((StringWrapper)(string));

        return (((Symbol)(((StringHashTable)(Stella.$SPECIAL_STRINGS$.get())).lookup(string000.wrapperValue))));
      }
    }
    else {
      return (null);
    }
  }

  public static FloatWrapper zone(Stella_Object thing) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(thing);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper thing000 = ((StringWrapper)(thing));

          if (Stella.stringEqualP(thing000.wrapperValue, "local")) {
            return (FloatWrapper.wrapFloat(Stella.NULL_FLOAT));
          }
          { FloatWrapper zoneNumber = ((FloatWrapper)(((StringHashTable)(Stella.$ZONE_STRINGS$.get())).lookup(thing000.wrapperValue)));

            if (zoneNumber != null) {
              return (zoneNumber);
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper thing000 = ((FloatWrapper)(thing));

          if ((-12.0 <= thing000.wrapperValue) &&
              (thing000.wrapperValue <= 14.0)) {
            return (thing000);
          }
          else {
            return (null);
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper thing000 = ((IntegerWrapper)(thing));

          { int offset = thing000.wrapperValue;

            if ((-12 <= offset) &&
                (offset <= 14)) {
              return (FloatWrapper.wrapFloat(((double)(offset))));
            }
            else if ((-1200 <= offset) &&
                (offset <= 1400)) {
              return (FloatWrapper.wrapFloat((offset / 100) + ((offset % 100) / 60.0)));
            }
            else {
              return (null);
            }
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static IntegerWrapper month(Stella_Object thing) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(thing);

      if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper thing000 = ((StringWrapper)(thing));

          { int monthNumber = ((StringToIntegerHashTable)(Stella.$MONTH_STRINGS$.get())).lookup(thing000.wrapperValue);

            if (monthNumber != Stella.NULL_INTEGER) {
              return (IntegerWrapper.wrapInteger(monthNumber));
            }
            else {
              return (null);
            }
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper thing000 = ((IntegerWrapper)(thing));

          if ((1 <= thing000.wrapperValue) &&
              (thing000.wrapperValue <= 12)) {
            return (thing000);
          }
          else {
            return (null);
          }
        }
      }
      else {
        return (null);
      }
    }
  }

  public static Keyword weekday(Stella_Object thing) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(thing))) {
      { StringWrapper thing000 = ((StringWrapper)(thing));

        return (((Keyword)(((StringHashTable)(Stella.$WEEKDAY_STRINGS$.get())).lookup(thing000.wrapperValue))));
      }
    }
    else {
      return (null);
    }
  }

  public static Symbol noonMidn(Stella_Object string) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(string))) {
      { StringWrapper string000 = ((StringWrapper)(string));

        if (Stella.stringEqlP(string000.wrapperValue, "noon")) {
          return (Stella.SYM_STELLA_NOON);
        }
        else if (Stella.stringEqlP(string000.wrapperValue, "midnight")) {
          return (Stella.SYM_STELLA_MIDN);
        }
        else {
          return (null);
        }
      }
    }
    else {
      return (null);
    }
  }

  public static Symbol era(Stella_Object string) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(string))) {
      { StringWrapper string000 = ((StringWrapper)(string));

        return (((Symbol)(((StringHashTable)(Stella.$ERA_STRINGS$.get())).lookup(string000.wrapperValue))));
      }
    }
    else {
      return (null);
    }
  }

  public static Symbol amPm(Stella_Object string) {
    if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(string))) {
      { StringWrapper string000 = ((StringWrapper)(string));

        if (Stella.stringEqlP(string000.wrapperValue, "am")) {
          return (Stella.SYM_STELLA_AM);
        }
        else if (Stella.stringEqlP(string000.wrapperValue, "pm")) {
          return (Stella.SYM_STELLA_PM);
        }
        else {
          return (null);
        }
      }
    }
    else {
      return (null);
    }
  }

  public static Stella_Object hashlist(Stella_Object list, Stella_Object table) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(Stella.SYM_STELLA_ITEM, Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(list, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INSERT_AT, Cons.cons(table, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FIRST, Cons.cons(Stella.SYM_STELLA_ITEM, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SECOND, Cons.cons(Stella.SYM_STELLA_ITEM, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))));
  }

  /** Format <code>date</code> just like <code>formatDateToStream</code> (which see), but return the result as a string.
   * @param date
   * @param timezone
   * @param control
   * @return String
   */
  public static String formatDate(Stella_Object date, Stella_Object timezone, String control) {
    { OutputStringStream out = OutputStringStream.newOutputStringStream();

      Stella_Object.formatDateToStream(date, timezone, control, out);
      return (out.theStringReader());
    }
  }

  /** Perform formatted printing of <code>date</code> relative to <code>timezone</code> onto <code>stream</code>.  <code>date</code>
   * has to be either a calendar-date or a decoded-date-time object.  <code>timezone</code> can be null to indicate
   * the local timezone, or a float or supported timezone name.  <code>control</code> is a format control string whose
   * characters are printed literally, unless they are a %-code such as one of these (inspired by the codes
   * supported by the Unix <code>date</code> command):
   *        %%     a literal %
   *        %a     abbreviated weekday name (e.g., Sun)
   *        %A     full weekday name (e.g., Sunday)
   *        %b     abbreviated month name (e.g., Jan)
   *        %B     full month name (e.g., January)
   *        %d     day of month (e.g., 01)
   *        %D     date; same as %m/%d/%y
   *        %F     full date; same as %Y-%m-%d
   *        %H     hour (00..23)
   *        %I     hour (01..12)
   *        %m     month (01..12)
   *        %M     minute (00..59)
   *        %p     either AM or PM
   *        %r     12-hour clock time (e.g., 11:11:04 PM)
   *        %R     24-hour hour and minute; same as %H:%M
   *        %S     second (00..60)
   *        %T     time; same as %H:%M:%S
   *        %y     last two digits of year (00..99)
   *        %Y     year
   *        %z     +hhmm numeric time zone (e.g., -0400)
   *        %:z    +hhmm numeric time zone (e.g., -04:00)
   *        %Z     alphabetic time zone abbreviation (e.g., EDT)
   * By default, numeric fields are padded with zeroes. The following optional flags may follow '%':
   *        -      (hyphen) do not pad the field
   *        _      (underscore) pad with spaces
   *        0      (zero) pad with zeros
   *        ^      use upper case if possible
   *        ,      use lower case if possible
   * @param date
   * @param timezone
   * @param control
   * @param stream
   */
  public static void formatDateToStream(Stella_Object date, Stella_Object timezone, String control, OutputStream stream) {
    { double decodedzone = Stella.getLocalTimeZone();
      DecodedDateTime decodeddate = null;
      int end = control.length() - 1;
      int i = 0;
      char ch = Stella.NULL_CHARACTER;
      char flag = Stella.NULL_CHARACTER;

      if (timezone != null) {
        { FloatWrapper deczone = Stella_Object.zone(timezone);

          if ((deczone == null) &&
              Stella_Object.stringP(timezone)) {
            deczone = Stella_Object.zone(StringWrapper.wrapString(Native.stringDowncase(((StringWrapper)(timezone)).wrapperValue)));
          }
          if (deczone != null) {
            decodedzone = deczone.wrapperValue;
          }
        }
      }
      { Surrogate testValue000 = Stella_Object.safePrimaryType(date);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_CALENDAR_DATE)) {
          { CalendarDate date000 = ((CalendarDate)(date));

            decodeddate = date000.decodeCalendarDate(decodedzone);
          }
        }
        else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_DECODED_DATE_TIME)) {
          { DecodedDateTime date000 = ((DecodedDateTime)(date));

            decodeddate = date000;
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("format-date: unsupported date type: `" + date.primaryType() + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      loop000 : while (i <= end) {
        ch = control.charAt(i);
        if (ch == '%') {
          if (i == end) {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("format-date: end of control string encountered: `" + control + "'");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
          i = i + 1;
          flag = Stella.NULL_CHARACTER;
          ch = control.charAt(i);
          if (ch == '%') {
            stream.nativeStream.print("%");
            i = i + 1;
            continue loop000;
          }
          if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_LETTER)) {
            if (i == end) {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("format-date: end of control string encountered: `" + control + "'");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
            i = i + 1;
            flag = ch;
            ch = control.charAt(i);
            if (Native.string_position("-_0^,:", flag, 0) == Stella.NULL_INTEGER) {
              { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                stream003.nativeStream.print("format-date: illegal control flag: `" + flag + "'");
                throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
              }
            }
            if (!(Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_LETTER)) {
              { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                stream004.nativeStream.print("format-date: illegal control character: `" + ch + "'");
                throw ((StellaException)(StellaException.newStellaException(stream004.theStringReader()).fillInStackTrace()));
              }
            }
          }
          edu.isi.stella.javalib.Native.funcall(((FunctionCodeWrapper)((Stella.$FORMAT_DATE_HANDLERS$.theArray)[((int) ch)])).wrapperValue, null, new java.lang.Object [] {decodeddate, new Character(ch), new Character(flag), stream});
        }
        else {
          stream.nativeStream.print(ch);
        }
        i = i + 1;
      }
    }
  }

  /** Multiplies a relative date by a wrapped number.  One of <code>t1</code> or <code>t2</code>
   * must be a relative date and the other a wrapped number.
   * @param t1
   * @param t2
   * @return TimeDuration
   */
  public static TimeDuration timeMultiply(Stella_Object t1, Stella_Object t2) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(t1);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_CALENDAR_DATE)) {
        { CalendarDate t1000 = ((CalendarDate)(t1));

          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Calendar dates cannot be involved in multiplication:  `" + t1000 + "'  `" + t2 + "'");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_TIME_DURATION)) {
        { TimeDuration t1000 = ((TimeDuration)(t1));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                  stream001.nativeStream.print("Calendar dates cannot be involved in multiplication:  `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                  stream002.nativeStream.print("You can't multiply two relative dates: `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfIntegerP(testValue001)) {
              { IntegerWrapper t2000 = ((IntegerWrapper)(t2));

                return (TimeDuration.makeTimeDuration(t1000.days * t2000.wrapperValue, t1000.millis * t2000.wrapperValue));
              }
            }
            else if (Surrogate.subtypeOfFloatP(testValue001)) {
              { FloatWrapper t2000 = ((FloatWrapper)(t2));

                return (TimeDuration.makeTimeDuration(Native.round(t1000.days * t2000.wrapperValue), Native.round(t1000.millis * t2000.wrapperValue)));
              }
            }
            else {
              { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                stream003.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper t1000 = ((IntegerWrapper)(t1));

          { Surrogate testValue002 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

                  stream004.nativeStream.print("Calendar dates cannot be involved in multiplication:  `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream004.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (TimeDuration.makeTimeDuration(t1000.wrapperValue * t2000.days, t1000.wrapperValue * t2000.millis));
              }
            }
            else if (Surrogate.subtypeOfP(testValue002, Stella.SGT_STELLA_NUMBER_WRAPPER)) {
              { NumberWrapper t2000 = ((NumberWrapper)(t2));

                { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                  stream005.nativeStream.print("One argument must be a relative date:  `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream005.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else {
              { OutputStringStream stream006 = OutputStringStream.newOutputStringStream();

                stream006.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream006.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper t1000 = ((FloatWrapper)(t1));

          { Surrogate testValue003 = Stella_Object.safePrimaryType(t2);

            if (Surrogate.subtypeOfP(testValue003, Stella.SGT_STELLA_CALENDAR_DATE)) {
              { CalendarDate t2000 = ((CalendarDate)(t2));

                { OutputStringStream stream007 = OutputStringStream.newOutputStringStream();

                  stream007.nativeStream.print("Calendar dates cannot be involved in multiplication:  `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream007.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else if (Surrogate.subtypeOfP(testValue003, Stella.SGT_STELLA_TIME_DURATION)) {
              { TimeDuration t2000 = ((TimeDuration)(t2));

                return (TimeDuration.makeTimeDuration(Native.round(t1000.wrapperValue * t2000.days), Native.round(t1000.wrapperValue * t2000.millis)));
              }
            }
            else if (Surrogate.subtypeOfP(testValue003, Stella.SGT_STELLA_NUMBER_WRAPPER)) {
              { NumberWrapper t2000 = ((NumberWrapper)(t2));

                { OutputStringStream stream008 = OutputStringStream.newOutputStringStream();

                  stream008.nativeStream.print("One argument must be a relative date:  `" + t1000 + "'  `" + t2000 + "'");
                  throw ((StellaException)(StellaException.newStellaException(stream008.theStringReader()).fillInStackTrace()));
                }
              }
            }
            else {
              { OutputStringStream stream009 = OutputStringStream.newOutputStringStream();

                stream009.nativeStream.print("`" + testValue003 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream009.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream010 = OutputStringStream.newOutputStringStream();

          stream010.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream010.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static boolean transientObjectP(Stella_Object renamed_Object) {
    { Surrogate type = renamed_Object.primaryType();

      return (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_TRANSIENT_MIXIN));
    }
  }

  public static void unregisterRecycledItem(Stella_Object item) {
    Stella.$CURRENTLY_RECYCLED_ITEMS$.removeAt(item);
  }

  public static void registerRecycledItem(Stella_Object item) {
    if (Stella.$CURRENTLY_RECYCLED_ITEMS$.lookup(item) != null) {
      Stella.breakProgram("Trying to recyle an already recycled item!");
    }
    else {
      Stella.$CURRENTLY_RECYCLED_ITEMS$.insertAt(item, item);
    }
  }

  /** Default method.  Sweep up all <code>self</code>-type objects.
   */
  public void sweep() {
    { Stella_Object self = this;

    }
  }

  public static List parseArrayDimensionsSpec(Stella_Object dimensionsspec) {
    { List dimensions = List.newList();

      if (dimensionsspec == null) {
        return (null);
      }
      if (!(Stella_Object.consP(dimensionsspec) &&
          (!(dimensionsspec == Stella.NIL)))) {
        dimensionsspec = Cons.cons(dimensionsspec, Stella.NIL);
      }
      { Stella_Object dimspec = null;
        Cons iter000 = ((Cons)(dimensionsspec));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          dimspec = iter000.value;
          if (Stella_Object.consP(dimspec)) {
            dimspec = ((Cons)(dimspec)).value;
          }
          if ((dimspec == null) ||
              (dimspec == Stella.SYM_STELLA_NULL)) {
            dimspec = null;
          }
          else if (Stella_Object.integerP(dimspec)) {
          }
          else {
            return (null);
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(dimspec, Stella.NIL);
              if (dimensions.theConsList == Stella.NIL) {
                dimensions.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(dimensions.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(dimspec, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (dimensions);
    }
  }

  public StandardObject yieldTypeSpecifier() {
    { Stella_Object typespectree = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Illegal type specification ``" + typespectree + "''");
        { String error_message_ = stream000.theStringReader();

          Native.continuableError(error_message_);
        }
      }
      return (Stella.SGT_STELLA_OBJECT);
    }
  }

  public static boolean taxonomyIsaP(Stella_Object renamed_Object, Surrogate type) {
    return (Stella_Object.isaP(renamed_Object, type));
  }

  /** Return <code>true</code> iff <code>renamed_Object</code> is an instance of the class named <code>type</code>.
   * @param renamed_Object
   * @param type
   * @return boolean
   */
  public static boolean isaP(Stella_Object renamed_Object, Surrogate type) {
    return (Stella_Class.subclassOfP(((Stella_Class)(renamed_Object.primaryType().surrogateValue)), ((Stella_Class)(type.surrogateValue))));
  }

  /** Print all undefined or bad (indirect) super classes of <code>renamed_Class</code>.
   * @param renamed_Class
   */
  public static void printUndefinedSuperClasses(Stella_Object renamed_Class) {
    { Surrogate type = Stella_Object.typify(Stella_Object.coerceToSymbol(renamed_Class));
      List badones = List.newList();

      if (type == null) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Illegal class name: " + renamed_Class);
        return;
      }
      Surrogate.collectBadSuperClasses(type, badones);
      if (badones.memberP(type)) {
        if (type.surrogateValue == null) {
          Stella.STANDARD_OUTPUT.nativeStream.println(type + " is itself undefined.");
        }
        else {
          Stella.STANDARD_OUTPUT.nativeStream.println(type + " itself points to non-class " + type.surrogateValue);
        }
        return;
      }
      { boolean foundP000 = false;

        { Surrogate renamed_Super = null;
          Cons iter000 = badones.theConsList;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            renamed_Super = ((Surrogate)(iter000.value));
            if (renamed_Super.surrogateValue == null) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        if (foundP000) {
          Stella.STANDARD_OUTPUT.nativeStream.println("The following (indirect) super(s) of " + type + " are undefined:");
          { Surrogate renamed_Super = null;
            Cons iter001 = badones.theConsList;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              renamed_Super = ((Surrogate)(iter001.value));
              if (renamed_Super.surrogateValue == null) {
                Stella.STANDARD_OUTPUT.nativeStream.println("    " + renamed_Super);
              }
            }
          }
        }
      }
      { boolean foundP001 = false;

        { Surrogate renamed_Super = null;
          Cons iter002 = badones.theConsList;

          loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
            renamed_Super = ((Surrogate)(iter002.value));
            if (renamed_Super.surrogateValue != null) {
              foundP001 = true;
              break loop002;
            }
          }
        }
        if (foundP001) {
          Stella.STANDARD_OUTPUT.nativeStream.println("The following (indirect) super(s) of " + type + " point to non-classes:");
          { Surrogate renamed_Super = null;
            Cons iter003 = badones.theConsList;

            for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              renamed_Super = ((Surrogate)(iter003.value));
              if (renamed_Super.surrogateValue != null) {
                Stella.STANDARD_OUTPUT.nativeStream.println("    " + renamed_Super + " points to " + renamed_Super.surrogateValue);
              }
            }
          }
        }
      }
    }
  }

  /** Return the (generalized) symbol represented by <code>name</code>.
   * Return <code>null</code> if <code>name</code> is undefined or does not represent a string.
   * @param name
   * @return GeneralizedSymbol
   */
  public static GeneralizedSymbol coerceToSymbol(Stella_Object name) {
    if (name != null) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(name);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
          { GeneralizedSymbol name000 = ((GeneralizedSymbol)(name));

            return (name000);
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper name000 = ((StringWrapper)(name));

            return (Symbol.lookupSymbol(name000.wrapperValue));
          }
        }
        else {
        }
      }
    }
    return (null);
  }

  /** Return the string represented by <code>name</code>.  Return <code>null</code>
   * if <code>name</code> is undefined or does not represent a string.
   * @param name
   * @return String
   */
  public static String nameToString(Stella_Object name) {
    if (name != null) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(name);

        if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
          { GeneralizedSymbol name000 = ((GeneralizedSymbol)(name));

            return (name000.symbolName);
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue000)) {
          { StringWrapper name000 = ((StringWrapper)(name));

            return (name000.wrapperValue);
          }
        }
        else {
        }
      }
    }
    return (null);
  }

  /** Return an iterator over public slots of <code>self</code>.
   * @return Iterator
   */
  public Iterator publicSlots() {
    { Stella_Object self = this;

      return (self.primaryClass().publicSlots());
    }
  }

  /** Default method.  Deallocate storage for <code>self</code>.
   */
  public void free() {
    { Stella_Object self = this;

      Stella_Object.unmake(self);
    }
  }

  public static boolean bindToSurrogateP(Stella_Object self, String name, boolean clipoldvalueP, boolean askforpermissionP, Object [] MV_returnarray) {
    { Surrogate oldsurrogate = Surrogate.lookupSurrogate(name);
      Stella_Object oldvalue = ((oldsurrogate != null) ? oldsurrogate.surrogateValue : ((Stella_Object)(null)));
      Surrogate surrogate = Stella.shadowSurrogate(name);
      Module oldmodule = null;

      if (oldvalue == null) {
        surrogate.surrogateValue = self;
        { boolean _return_temp = true;

          MV_returnarray[0] = null;
          MV_returnarray[1] = surrogate;
          return (_return_temp);
        }
      }
      if (Stella_Object.eqlP(oldvalue, self)) {
        { boolean _return_temp = true;

          MV_returnarray[0] = null;
          MV_returnarray[1] = surrogate;
          return (_return_temp);
        }
      }
      oldmodule = ((Module)(oldsurrogate.homeContext));
      if (!(oldmodule == ((Module)(Stella.$MODULE$.get())))) {
        surrogate.surrogateValue = self;
        if (askforpermissionP) {
          Stella.STANDARD_WARNING.nativeStream.println("Warning: Shadowing the `" + self.primaryType().symbolName + "' named `" + name + "'");
          {
            Stella.STANDARD_OUTPUT.nativeStream.println("CAUTION: Automatic shadowing can be dangerous, because forward ");
            Stella.STANDARD_OUTPUT.nativeStream.println("   references to a shadowed object may be bound to the now-shadowed ");
            Stella.STANDARD_OUTPUT.nativeStream.println("   object.  Suggestion: Explicitly shadow the name using");
            Stella.STANDARD_OUTPUT.nativeStream.println("   DEFMODULE's `:shadow' option.");
          }
;
          if (Stella.yesOrNoP("Do it anyway? ")) {
            surrogate.surrogateValue = self;
            { boolean _return_temp = true;

              MV_returnarray[0] = oldvalue;
              MV_returnarray[1] = surrogate;
              return (_return_temp);
            }
          }
        }
        { boolean _return_temp = true;

          MV_returnarray[0] = null;
          MV_returnarray[1] = surrogate;
          return (_return_temp);
        }
      }
      else if (clipoldvalueP) {
        if (((Boolean)(Stella.$WARNIFREDEFINEp$.get())).booleanValue()) {
          Stella.STANDARD_OUTPUT.nativeStream.println("Redefining the `" + self.primaryType().symbolName + "' named `" + name + "'");
        }
        surrogate.surrogateValue = self;
        if (!(self.primaryType() == oldvalue.primaryType())) {
          oldvalue = null;
        }
        { boolean _return_temp = true;

          MV_returnarray[0] = oldvalue;
          MV_returnarray[1] = surrogate;
          return (_return_temp);
        }
      }
      else {
        if (askforpermissionP) {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't define the `" + self.primaryType().symbolName + "' named `" + name + "' in module `" + ((Module)(Stella.$MODULE$.get())) + "'");
            Stella.STANDARD_WARNING.nativeStream.println("   because that term is already bound to `" + oldvalue + "'");
            Stella.STANDARD_WARNING.nativeStream.println();
          }
;
          if (Stella.yesOrNoP("Do it anyway? ")) {
            surrogate.surrogateValue = self;
            { boolean _return_temp = true;

              MV_returnarray[0] = oldvalue;
              MV_returnarray[1] = surrogate;
              return (_return_temp);
            }
          }
        }
        { boolean _return_temp = false;

          MV_returnarray[0] = null;
          MV_returnarray[1] = surrogate;
          return (_return_temp);
        }
      }
    }
  }

  public Stella_Class primaryClass() {
    { Stella_Object self = this;

      if (self.primaryType() != null) {
        return (((Stella_Class)(self.primaryType().surrogateValue)));
      }
      return (null);
    }
  }

  public double numberWrapperToFloat() {
    { Stella_Object self = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + self + "' is not a number wrapper");
        throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object permanentCopy(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (tree000);
        }
        else {
          return (Cons.cons(Stella_Object.permanentCopy(tree000.value), ((Cons)(Stella_Object.permanentCopy(tree000.rest)))));
        }
      }
    }
    else {
      return (tree.permanentify());
    }
  }

  public Stella_Object permanentify() {
    { Stella_Object self = this;

      return (self);
    }
  }

  public static Stella_Object simplifyBquoteTree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { Cons cursor = tree000.rest;

          while (!(cursor == Stella.NIL)) {
            cursor.value = Stella_Object.simplifyBquoteTree(cursor.value);
            cursor = cursor.rest;
          }
          if (!(tree000.value == Stella.SYM_STELLA_LIST$)) {
            return (tree000);
          }
          switch (tree000.rest.length()) {
            case 1: 
              return (tree000.rest.value);
            case 2: 
              tree000.value = Stella.SYM_STELLA_CONS;
              return (tree000);
            default:
              return (tree000);
          }
        }
      }
    }
    else {
      return (tree);
    }
  }

  public static Stella_Object expandBquoteTree(Stella_Object tree) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        { Cons expandedtree = Cons.cons(Stella.SYM_STELLA_LIST$, Stella.NIL);
          Cons cursor = tree000;
          Stella_Object term = cursor.value;

          while ((!(cursor == Stella.NIL)) &&
              (!((term == Stella.SYM_STELLA_a) ||
              (term == Stella.SYM_STELLA_aa)))) {
            expandedtree = Cons.cons(Stella_Object.expandBquoteTree(term), expandedtree);
            cursor = cursor.rest;
            term = cursor.value;
          }
          if (cursor == Stella.NIL) {
            return (Cons.cons(Stella.SYM_STELLA_NIL, expandedtree).reverse());
          }
          else if (term == Stella.SYM_STELLA_a) {
            cursor = cursor.rest;
            if (cursor == Stella.NIL) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal bquote tree -- missing term after '&'..");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
            }
            return (Cons.cons(Stella_Object.expandBquoteTree(cursor.rest), Cons.cons(cursor.value, expandedtree)).reverse());
          }
          else {
            cursor = cursor.rest;
            if (cursor == Stella.NIL) {
              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal bquote tree -- missing term after '&&'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
            }
            return (Cons.cons(Cons.consList(Cons.cons(Stella.SYM_STELLA_CONCATENATE, Cons.cons(cursor.value, Cons.cons(Stella_Object.expandBquoteTree(cursor.rest), Stella.NIL)))), expandedtree).reverse());
          }
        }
      }
    }
    else {
      return (Stella_Object.bquotify(tree));
    }
  }

  public static Stella_Object bquotify(Stella_Object tree) {
    return (Stella_Object.helpBquotify(tree));
  }

  public static Stella_Object helpBquotify(Stella_Object tree) {
    if (tree == null) {
      return (Stella.SYM_STELLA_NULL);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(tree);

      if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons tree000 = ((Cons)(tree));

          if (tree000 == Stella.NIL) {
            return (Stella.SYM_STELLA_NIL);
          }
          else {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella_Object.helpBquotify(tree000.value), Cons.cons(Stella_Object.helpBquotify(tree000.rest), Stella.NIL)))));
          }
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper tree000 = ((IntegerWrapper)(tree));

          return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(tree000, Stella.NIL))));
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper tree000 = ((LongIntegerWrapper)(tree));

          return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(tree000, Stella.NIL))));
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper tree000 = ((StringWrapper)(tree));

          return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(tree000, Stella.NIL))));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper tree000 = ((FloatWrapper)(tree));

          return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(tree000, Stella.NIL))));
        }
      }
      else if (Surrogate.subtypeOfCharacterP(testValue000)) {
        { CharacterWrapper tree000 = ((CharacterWrapper)(tree));

          return (Cons.consList(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(tree000, Stella.NIL))));
        }
      }
      else if (Surrogate.subtypeOfKeywordP(testValue000)) {
        { Keyword tree000 = ((Keyword)(tree));

          if (Stella.useHardcodedSymbolsP()) {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_GET_KWD, Cons.cons(IntegerWrapper.wrapInteger(tree000.symbolId), Stella.NIL))));
          }
          else {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_TYPED_SYS, Cons.cons(GeneralizedSymbol.registerSymbol(tree000), Cons.cons(Stella.SGT_STELLA_SYMBOL, Stella.NIL)))));
          }
        }
      }
      else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
        { Surrogate tree000 = ((Surrogate)(tree));

          if (Stella.useHardcodedSymbolsP()) {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_GET_SGT, Cons.cons(IntegerWrapper.wrapInteger(tree000.symbolId), Stella.NIL))));
          }
          else {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_TYPED_SYS, Cons.cons(GeneralizedSymbol.registerSymbol(tree000), Cons.cons(Stella.SGT_STELLA_SYMBOL, Stella.NIL)))));
          }
        }
      }
      else if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol tree000 = ((Symbol)(tree));

          if (Symbol.symbolCommonLispP(tree000)) {
            return (Cons.consList(Cons.cons(Stella.SYM_STELLA_INTERN_COMMON_LISP_SYMBOL, Cons.cons(StringWrapper.wrapString(tree000.symbolName), Stella.NIL))));
          }
          else {
            if (Stella.useHardcodedSymbolsP()) {
              return (Cons.consList(Cons.cons(Stella.SYM_STELLA_GET_SYM, Cons.cons(IntegerWrapper.wrapInteger(((Symbol)(tree000.permanentify())).symbolId), Stella.NIL))));
            }
            else {
              return (Cons.consList(Cons.cons(Stella.SYM_STELLA_TYPED_SYS, Cons.cons(GeneralizedSymbol.registerSymbol(tree000), Cons.cons(Stella.SGT_STELLA_SYMBOL, Stella.NIL)))));
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
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal argument to quote: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (null);
      }
    }
  }

  public static boolean eqlToCharacterP(Stella_Object y, char x) {
    return (Stella_Object.characterP(y) &&
        (((CharacterWrapper)(y)).wrapperValue == x));
  }

  public static boolean eqlToStringP(Stella_Object y, String x) {
    return (Stella_Object.stringP(y) &&
        Stella.stringEqlP(((StringWrapper)(y)).wrapperValue, x));
  }

  public static boolean eqlToFloatP(Stella_Object y, double x) {
    return (Stella_Object.floatP(y) &&
        (((FloatWrapper)(y)).wrapperValue == x));
  }

  public static boolean eqlToLongIntegerP(Stella_Object y, long x) {
    return (Stella_Object.longIntegerP(y) &&
        (((LongIntegerWrapper)(y)).wrapperValue == x));
  }

  public static boolean eqlToIntegerP(Stella_Object y, int x) {
    return (Stella_Object.integerP(y) &&
        (((IntegerWrapper)(y)).wrapperValue == x));
  }

  public static boolean eqlToBooleanP(Stella_Object y, boolean x) {
    return (Stella_Object.booleanP(y) &&
        (((BooleanWrapper)(y)).wrapperValue == x));
  }

  public boolean objectEqlP(Stella_Object y) {
    { Stella_Object x = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("object-eql?: Don't know how to compare `" + x + "' with `" + y + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static Stella_Object inlineUnwrapBoolean(Stella_Object expression) {
    { Stella_Object walkedexp = Stella_Object.walkedExpressionExpression(expression);

      if (walkedexp == Stella.SYM_STELLA_TRUE_WRAPPER) {
        return (Stella.SYM_STELLA_TRUE);
      }
      else if (walkedexp == Stella.SYM_STELLA_FALSE_WRAPPER) {
        return (Stella.SYM_STELLA_FALSE);
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_COERCE_WRAPPED_BOOLEAN_TO_BOOLEAN, Cons.cons(expression, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static Stella_Object inlineWrapBoolean(Stella_Object expression) {
    { Stella_Object walkedexp = Stella_Object.walkedExpressionExpression(expression);

      if (walkedexp == Stella.SYM_STELLA_TRUE) {
        return (Stella.SYM_STELLA_TRUE_WRAPPER);
      }
      else if (walkedexp == Stella.SYM_STELLA_FALSE) {
        return (Stella.SYM_STELLA_FALSE_WRAPPER);
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_BOOLEAN, Cons.cons(expression, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static Surrogate typify(Stella_Object self) {
    return (self.surrogatify());
  }

  public Surrogate surrogatify() {
    { Stella_Object self = this;

      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("Don't know how to 'surrogatify' `" + self + "'");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
  }

  public static boolean commonLispSymbolP(Stella_Object self) {
    return (Stella_Object.symbolP(self) &&
        Symbol.symbolCommonLispP(((Symbol)(self))));
  }

  /** Coerce the collection <code>self</code> into a HASH-SET.  Use an
   * equal test if <code>equalTestP</code> is TRUE (<code>equalTestP</code> will be ignored if <code>self</code>
   * already is a HASH-SET).
   * @param self
   * @param equaltestP
   * @return HashSet
   */
  public static HashSet coerceToHashSet(Stella_Object self, boolean equaltestP) {
    { HashSet chooseValue000 = null;

      if (Stella_Object.isaP(self, Stella.SGT_STELLA_HASH_SET)) {
        chooseValue000 = ((HashSet)(self));
      }
      else {
        { HashSet self000 = HashSet.newHashSet();

          self000.equalTestP = equaltestP;
          chooseValue000 = self000;
        }
      }
      { HashSet theset = chooseValue000;

        { Surrogate testValue000 = Stella_Object.safePrimaryType(self);

          if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_HASH_SET)) {
            { HashSet self001 = ((HashSet)(self));

            }
          }
          else if (testValue000 == Stella.SGT_STELLA_CONS) {
            { Cons self001 = ((Cons)(self));

              { Stella_Object elt = null;
                Cons iter000 = self001;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  elt = iter000.value;
                  theset.insertAt(elt, elt);
                }
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LIST)) {
            { List self001 = ((List)(self));

              { Stella_Object elt = null;
                Cons iter001 = self001.theConsList;

                for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  elt = iter001.value;
                  theset.insertAt(elt, elt);
                }
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_VECTOR)) {
            { Vector self001 = ((Vector)(self));

              { Stella_Object elt = null;
                Vector vector000 = self001;
                int index000 = 0;
                int length000 = vector000.length();

                for (;index000 < length000; index000 = index000 + 1) {
                  elt = (vector000.theArray)[index000];
                  theset.insertAt(elt, elt);
                }
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_COLLECTION)) {
            { Collection self001 = ((Collection)(self));

              { Stella_Object elt = null;
                Iterator iter002 = ((Iterator)(self001.allocateIterator()));

                while (iter002.nextP()) {
                  elt = iter002.value;
                  theset.insertAt(elt, elt);
                }
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("coerce-to-hash-set: don't know how to coerce a `" + self.primaryType() + "' into a hash-set");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        return (theset);
      }
    }
  }

  /** Return <code>true</code> if <code>self</code> is a native collection.
   * @param self
   * @return boolean
   */
  public static boolean stellaCollectionP(Stella_Object self) {
    return (Stella_Object.isaP(self, Stella.SGT_STELLA_COLLECTION));
  }

  public static int treeSize(Stella_Object self) {
    if (Stella_Object.safePrimaryType(self) == Stella.SGT_STELLA_CONS) {
      { Cons self000 = ((Cons)(self));

        if (self000 == Stella.NIL) {
          return (0);
        }
        else {
          return (1 + Stella_Object.treeSize(self000.value) + Stella_Object.treeSize(self000.rest));
        }
      }
    }
    else {
      return (0);
    }
  }

  public static void printStellaDefinition(Stella_Object tree, edu.isi.stella.javalib.NativeOutputStream stream) {
    { Object old$PrintprettyP$000 = Stella.$PRINTPRETTYp$.get();
      Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, ((Boolean)(Stella.$PRINTPRETTYCODEp$.get())).booleanValue());
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
          { Cons tree000 = ((Cons)(tree));

            if (tree000.length() >= 3) {
              Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, false);
              stream.print("(" + tree000.value + " " + tree000.rest.value + " " + tree000.rest.rest.value);
              Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, ((Boolean)(Stella.$PRINTPRETTYCODEp$.get())).booleanValue());
              { Stella_Object form = null;
                Cons iter000 = tree000.nthRest(3);

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  form = iter000.value;
                  {
                    stream.println();
                    stream.print("  " + form);
                  }
;
                }
              }
              stream.print(")");
            }
            else {
              stream.print(tree000);
            }
          }
        }
        else {
          stream.print(tree);
        }
        stream.println();

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        Stella.$PRINTPRETTYp$.set(old$PrintprettyP$000);
      }
    }
  }

  public static void printStellaCode(Stella_Object tree, edu.isi.stella.javalib.NativeOutputStream stream) {
    { Object old$PrintprettyP$000 = Stella.$PRINTPRETTYp$.get();
      Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, ((Boolean)(Stella.$PRINTPRETTYCODEp$.get())).booleanValue());
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        stream.println(tree.toString());

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        Stella.$PRINTPRETTYp$.set(old$PrintprettyP$000);
      }
    }
  }

  /** Predicate version of <code>matchConsTree</code> (which see).
   * @param tree
   * @param pattern
   * @return boolean
   */
  public static boolean consTreeMatchP(Stella_Object tree, Stella_Object pattern) {
    return (Stella_Object.matchConsTree(tree, pattern, null) != null);
  }

  /** Match <code>pattern</code> against <code>tree</code> and return a list of
   * variable bindings if they match, or NULL otherwise.  <code>bindings</code> can
   * be NULL or an initial list of bindings to consider.  Pattern variables
   * use KIF syntax, i.e., they need to start with a <code>P</code> character.  A
   * single question mark is interpreted as the anonymous variable. Example:
   * 	 
   *   (match-cons-tree (quote (a (b (a d) e) (a d) f g))
   *                    (quote (a (?x ?y ?) ?y ? g))
   *                    NULL)
   *   =&gt; |kv|(&lt;?Y,(A D)&gt; &lt;?X,B&gt;)
   * 	
   * Variables can't be quoted but quoting can effectively be achieved by
   * inserting to-be-quoted variables bound to themselves into <code>bindings</code>.
   * @param tree
   * @param pattern
   * @param bindings
   * @return KeyValueList
   */
  public static KeyValueList matchConsTree(Stella_Object tree, Stella_Object pattern, KeyValueList bindings) {
    if (bindings == null) {
      bindings = KeyValueList.newKeyValueList();
    }
    if (pattern == Stella.SYM_STELLA_p) {
      return (bindings);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(pattern);

      if (Surrogate.subtypeOfSymbolP(testValue000)) {
        { Symbol pattern000 = ((Symbol)(pattern));

          if ((pattern000.symbolName).charAt(0) == '?') {
            { Stella_Object value = bindings.lookup(pattern000);

              if (value == null) {
                bindings.insertAt(pattern000, tree);
                return (bindings);
              }
              else if (Stella_Object.equalP(value, tree)) {
                return (bindings);
              }
            }
          }
          else {
            if (tree == pattern000) {
              return (bindings);
            }
          }
        }
      }
      else if (testValue000 == Stella.SGT_STELLA_CONS) {
        { Cons pattern000 = ((Cons)(pattern));

          if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
            { Cons tree000 = ((Cons)(tree));

              { boolean testValue001 = false;

                testValue001 = tree000.length() == pattern000.length();
                if (testValue001) {
                  { boolean alwaysP000 = true;

                    { Stella_Object elt = null;
                      Cons iter000 = tree000;
                      Stella_Object pat = null;
                      Cons iter001 = pattern000;

                      loop000 : for (;(!(iter000 == Stella.NIL)) &&
                                (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
                        elt = iter000.value;
                        pat = iter001.value;
                        if (!(Stella_Object.matchConsTree(elt, pat, bindings) != null)) {
                          alwaysP000 = false;
                          break loop000;
                        }
                      }
                    }
                    testValue001 = alwaysP000;
                  }
                }
                if (testValue001) {
                  return (bindings);
                }
              }
            }
          }
          else {
          }
        }
      }
      else {
        if (Stella_Object.eqlP(tree, pattern)) {
          return (bindings);
        }
      }
    }
    return (null);
  }

  /** Destructively replace each appearance of <code>oldvalue</code> by
   * <code>newvalue</code> in the cons tree <code>tree</code>.  Return the tree.  Uses an <code>eqlP</code> test.
   * @param tree
   * @param newvalue
   * @param oldvalue
   * @return Stella_Object
   */
  public static Stella_Object substituteConsTree(Stella_Object tree, Stella_Object newvalue, Stella_Object oldvalue) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (!(tree000 == Stella.NIL)) {
          if (Stella_Object.eqlP(tree000.value, oldvalue)) {
            tree000.value = newvalue;
          }
          else {
            Stella_Object.substituteConsTree(tree000.value, newvalue, oldvalue);
          }
          Stella_Object.substituteConsTree(tree000.rest, newvalue, oldvalue);
        }
      }
    }
    else {
    }
    return (tree);
  }

  /** Return <code>true</code> iff the cons trees <code>tree1</code> and <code>tree2</code> are
   * structurally equivalent.  Uses an <code>eqlP</code> test.
   * @param tree1
   * @param tree2
   * @return boolean
   */
  public static boolean equalConsTreesP(Stella_Object tree1, Stella_Object tree2) {
    if (Stella_Object.eqlP(tree1, tree2)) {
      return (true);
    }
    else {
      if (Stella_Object.safePrimaryType(tree1) == Stella.SGT_STELLA_CONS) {
        { Cons tree1000 = ((Cons)(tree1));

          if (Stella_Object.safePrimaryType(tree2) == Stella.SGT_STELLA_CONS) {
            { Cons tree2000 = ((Cons)(tree2));

              return (Stella_Object.equalConsTreesP(tree1000.value, tree2000.value) &&
                  Stella_Object.equalConsTreesP(tree1000.rest, tree2000.rest));
            }
          }
          else {
            return (false);
          }
        }
      }
      else {
        return (false);
      }
    }
  }

  /** Return a copy of the cons tree <code>self</code>.
   * @param self
   * @return Stella_Object
   */
  public static Stella_Object copyConsTree(Stella_Object self) {
    if (Stella_Object.safePrimaryType(self) == Stella.SGT_STELLA_CONS) {
      { Cons self000 = ((Cons)(self));

        if (self000 == Stella.NIL) {
          return (Stella.NIL);
        }
        else {
          return (Cons.cons(Stella_Object.copyConsTree(self000.value), ((Cons)(Stella_Object.copyConsTree(self000.rest)))));
        }
      }
    }
    else {
      return (self);
    }
  }

  /** Return <code>true</code> iff the value <code>value</code> is embedded within
   * the cons tree <code>tree</code>.  Uses an <code>eqlP</code> test.  Does not descend into any
   * cons whose first element matches an element of <code>filter</code>.
   * @param tree
   * @param value
   * @param filter
   * @return boolean
   */
  public static boolean searchConsTreeWithFilterP(Stella_Object tree, Stella_Object value, Cons filter) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (value == Stella.NIL);
        }
        else if (filter.memberP(tree000.value)) {
          return (false);
        }
        else {
          { boolean foundP000 = false;

            { Stella_Object item = null;
              Cons iter000 = tree000;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                item = iter000.value;
                if (Stella_Object.searchConsTreeWithFilterP(item, value, filter)) {
                  foundP000 = true;
                  break loop000;
                }
              }
            }
            { boolean value000 = foundP000;

              return (value000);
            }
          }
        }
      }
    }
    else {
      return (Stella_Object.eqlP(tree, value));
    }
  }

  /** Return <code>true</code> iff the value <code>value</code> is embedded within
   * the cons tree <code>tree</code>.  Uses an <code>eqlP</code> test.
   * @param tree
   * @param value
   * @return boolean
   */
  public static boolean searchConsTreeP(Stella_Object tree, Stella_Object value) {
    if (Stella_Object.safePrimaryType(tree) == Stella.SGT_STELLA_CONS) {
      { Cons tree000 = ((Cons)(tree));

        if (tree000 == Stella.NIL) {
          return (value == Stella.NIL);
        }
        else {
          return (Stella_Object.searchConsTreeP(tree000.value, value) ||
              Stella_Object.searchConsTreeP(tree000.rest, value));
        }
      }
    }
    else {
      return (Stella_Object.eqlP(tree, value));
    }
  }

  public static boolean sortObjectsCompareP(Stella_Object x, Stella_Object y) {
    { StorageSlot slot = ((StorageSlot)(Stella.$SORT_OBJECTS_COMPARE_SLOT$.get()));
      java.lang.reflect.Method pred = ((java.lang.reflect.Method)(Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get()));

      return (((Boolean)(edu.isi.stella.javalib.Native.funcall(pred, null, new java.lang.Object [] {StandardObject.readSlotValue(((StandardObject)(x)), slot), StandardObject.readSlotValue(((StandardObject)(y)), slot)}))).booleanValue());
    }
  }

  public static java.lang.reflect.Method chooseSortPredicate(Stella_Object firstelement) {
    if (firstelement == null) {
      return (null);
    }
    { Surrogate testValue000 = Stella_Object.safePrimaryType(firstelement);

      if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
        { GeneralizedSymbol firstelement000 = ((GeneralizedSymbol)(firstelement));

          return (Native.find_java_method("edu.isi.stella.GeneralizedSymbol", "generalizedSymbolLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.GeneralizedSymbol"), Native.find_java_class("edu.isi.stella.GeneralizedSymbol")}));
        }
      }
      else if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper firstelement000 = ((IntegerWrapper)(firstelement));

          return (Native.find_java_method("edu.isi.stella.IntegerWrapper", "wrappedIntegerLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.IntegerWrapper"), Native.find_java_class("edu.isi.stella.IntegerWrapper")}));
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper firstelement000 = ((LongIntegerWrapper)(firstelement));

          return (Native.find_java_method("edu.isi.stella.LongIntegerWrapper", "wrappedLongIntegerLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.LongIntegerWrapper"), Native.find_java_class("edu.isi.stella.LongIntegerWrapper")}));
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper firstelement000 = ((FloatWrapper)(firstelement));

          return (Native.find_java_method("edu.isi.stella.FloatWrapper", "wrappedFloatLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.FloatWrapper"), Native.find_java_class("edu.isi.stella.FloatWrapper")}));
        }
      }
      else if (Surrogate.subtypeOfStringP(testValue000)) {
        { StringWrapper firstelement000 = ((StringWrapper)(firstelement));

          return (Native.find_java_method("edu.isi.stella.StringWrapper", "wrappedStringLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.StringWrapper"), Native.find_java_class("edu.isi.stella.StringWrapper")}));
        }
      }
      else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_MUTABLE_STRING_WRAPPER)) {
        { MutableStringWrapper firstelement000 = ((MutableStringWrapper)(firstelement));

          return (Native.find_java_method("edu.isi.stella.MutableStringWrapper", "wrappedMutableStringLessThanP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.MutableStringWrapper"), Native.find_java_class("edu.isi.stella.MutableStringWrapper")}));
        }
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("choose-sort-predicate: Don't know how to sort `" + firstelement.primaryType() + "'s");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** If <code>renamed_Object</code> is a CONS, return it.  Otherwise, return
   * a singleton cons list containing it.
   * @return Cons
   */
  public Cons consify() {
    { Stella_Object self = this;

      return ((Stella_Object.consP(self) ? ((Cons)(self)) : Cons.cons(self, Stella.NIL)));
    }
  }

  /** Return <code>true</code> iff <code>x</code> equals <code>nil</code>.
   * @param x
   * @return boolean
   */
  public static boolean nilP(Stella_Object x) {
    return (x == Stella.NIL);
  }

  public boolean standardObjectP() {
    { Stella_Object self = this;

      return (false);
    }
  }

  public static boolean parametricTypeSpecifierP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_PARAMETRIC_TYPE_SPECIFIER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_PARAMETRIC_TYPE_SPECIFIER));
  }

  public static boolean anchoredTypeSpecifierP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_ANCHORED_TYPE_SPECIFIER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_ANCHORED_TYPE_SPECIFIER));
  }

  public static boolean methodSlotP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_METHOD_SLOT));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_METHOD_SLOT));
  }

  public static boolean storageSlotP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_STORAGE_SLOT));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_STORAGE_SLOT));
  }

  public static boolean stellaClassP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      if (x != null) {
        { Stella_Class typeclass = ((Stella_Class)(x.primaryType().surrogateValue));

          return ((typeclass != null) &&
              Stella_Class.subclassOfP(typeclass, ((Stella_Class)(Stella.SGT_STELLA_CLASS.surrogateValue))));
        }
      }
      else {
        return (false);
      }
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_CLASS));
  }

  public static boolean consP(Stella_Object x) {
    if (x != null) {
      return (x.primaryType() == Stella.SGT_STELLA_CONS);
    }
    else {
      return (false);
    }
  }

  public static boolean keywordP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_KEYWORD));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_KEYWORD));
  }

  public static boolean transientSymbolP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_TRANSIENT_SYMBOL));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_TRANSIENT_SYMBOL));
  }

  public static boolean symbolP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_SYMBOL));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_SYMBOL) ||
        Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_TRANSIENT_SYMBOL));
  }

  public static boolean typeP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_SURROGATE));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_SURROGATE));
  }

  public static boolean surrogateP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_SURROGATE));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_SURROGATE));
  }

  public static boolean wrapperP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_WRAPPER));
    }
    return (Stella_Object.booleanP(x) ||
        (Stella_Object.integerP(x) ||
         (Stella_Object.longIntegerP(x) ||
          (Stella_Object.floatP(x) ||
           (Stella_Object.stringP(x) ||
            (Stella_Object.characterP(x) ||
             Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_WRAPPER)))))));
  }

  public static boolean characterP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_CHARACTER_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_CHARACTER_WRAPPER));
  }

  public static boolean verbatimStringP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER));
  }

  public static boolean stringP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_STRING_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_STRING_WRAPPER) ||
        Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_VERBATIM_STRING_WRAPPER));
  }

  public static boolean floatP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_FLOAT_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_FLOAT_WRAPPER));
  }

  public static boolean longIntegerP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_LONG_INTEGER_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_LONG_INTEGER_WRAPPER));
  }

  public static boolean integerP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_INTEGER_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_INTEGER_WRAPPER));
  }

  public static boolean booleanP(Stella_Object x) {
    if (Stella.$CLASS_HIERARCHY_BOOTEDp$) {
      return ((x != null) &&
          Stella_Object.isaP(x, Stella.SGT_STELLA_BOOLEAN_WRAPPER));
    }
    return (Stella_Object.bootstrapIsaP(x, Stella.SGT_STELLA_BOOLEAN_WRAPPER));
  }

  public static boolean bootstrapIsaP(Stella_Object x, Surrogate type) {
    return ((x != null) &&
        ((x.primaryType() == type) ||
         ((type.surrogateValue != null) &&
          ((x.primaryType().surrogateValue != null) &&
           Stella_Object.isaP(x, type)))));
  }

  public static Surrogate safePrimaryType(Stella_Object x) {
    return (((x == null) ? Stella.SGT_STELLA_UNKNOWN : x.primaryType()));
  }

  /** Return true if <code>self</code> is a member of the STELLA class <code>OBJECT</code>.
   * @param self
   * @return boolean
   */
  public static boolean stellaObjectP(Stella_Object self) {
    { boolean resultP = true;

      return (resultP);
    }
  }

  /** Convert a Lisp object into a STELLA object.
   * @param self
   * @return Stella_Object
   */
  public static Stella_Object stellify(Stella_Object self) {
    { Stella_Object result = self;

      return (result);
    }
  }

  public static void unmake(Stella_Object self) {
    self = self;
  }

  /** Return a hash code for <code>self</code>.  Just like <code>equalHashCode</code>
   * - which see, but also works for NULL.  <code>equalHashCode</code> methods that expect to
   * handle NULL components should use this function for recursive calls.
   * @param self
   * @return int
   */
  public static int safeEqualHashCode(Stella_Object self) {
    if (self == null) {
      return (16569644);
    }
    else {
      return (self.equalHashCode());
    }
  }

  /** Return a hash code for <code>self</code> (can be negative).  Two objects that are <code>equalP</code>
   * are guaranteed to generate the same hash code (provided, that writers of
   * <code>objectEqualP</code> methods also implemented the appropriate <code>equalHashCode</code>
   * method).  Two objects that are not <code>equalP</code>do not necessarily generate different
   * hash codes.
   * @return int
   */
  public int equalHashCode() {
    { Stella_Object self = this;

      return (self.hashCode_());
    }
  }

  /** Return a hash code for <code>self</code>.  Just like <code>hashCode</code>
   * - which see, but also works for NULL.
   * @param self
   * @return int
   */
  public static int safeHashCode(Stella_Object self) {
    if (self == null) {
      return (63842277);
    }
    else {
      return (self.hashCode_());
    }
  }

  /** Return a hash code for <code>self</code> (can be negative).  Two objects that are <code>eqlP</code>
   * are guaranteed to generate the same hash code.  Two objects that are not <code>eqlP</code>
   * do not necessarily generate different hash codes.
   * @return int
   */
  public int hashCode_() {
    { Stella_Object self = this;

      return (self.hashCode());
    }
  }

  /** Return a hash code for <code>self</code> (can be negative).  Two objects that are <code>eqP</code>
   * are guaranteed to generate the same hash code.  Two objects that are not <code>eqP</code>
   * do not necessarily generate different hash codes.  Similar to <code>hashCode</code> but
   * always hashes on the address of <code>self</code> even if it is a wrapper.
   * @param self
   * @return int
   */
  public static int objectHashCode(Stella_Object self) {
    return (self.hashCode());
  }

  /** Return true if <code>x</code> and <code>y</code> are <code>eqP</code>.
   * @param y
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object y) {
    { Stella_Object x = this;

      return (x == y);
    }
  }

  /** Return true if <code>x</code> and <code>y</code> are <code>eqlP</code> or considered equal
   * by a user-defined <code>objectEqualP</code> method.  This implements a fully extensible
   * equality test similar to Java's <code>equals</code> method.  Note that writers of custom
   * <code>objectEqualP</code> methods must also implement a corresponding <code>equalHashCode</code>
   * method.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean equalP(Stella_Object x, Stella_Object y) {
    return (((x == null) ? (y == null) : ((x == y) ||
        x.objectEqualP(y))));
  }

  /** Return true if <code>x</code> and <code>y</code> are <code>eqP</code> or equivalent literals
   * such as strings that also might be wrapped in non-identical wrappers.  For
   * the case where <code>x</code> or <code>y</code> are plain literals such as strings or integers, the
   * STELLA translator substitutes the equality test appropriate for the particular
   * target language and does not actually call this function.  For cases where
   * <code>x</code> or <code>y</code> are known to be of type STANDARD-OBJECT, the STELLA translator
   * substitutes the faster <code>eqP</code> test inline.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean eqlP(Stella_Object x, Stella_Object y) {
    return (((x == null) ? (y == null) : ((x == y) ||
        x.objectEqlP(y))));
  }

  /** Return TRUE if <code>level</code> is lower than or equal to the current
   * log level of <code>module</code>.  Return FALSE if any of them are undefined.
   * @param level
   * @param module
   * @return boolean
   */
  public static boolean logLevelLE(Stella_Object level, String module) {
    { Cons loglevels = ((Cons)(Stella.lookupLoggingParameter(module, Stella.KWD_LOG_LEVELS, Stella.NIL)));
      Stella_Object modulelevel = Stella.lookupLoggingParameter(module, Stella.KWD_LEVEL, null);
      int pos1 = loglevels.position(level, 0);
      int pos2 = loglevels.position(modulelevel, 0);

      return ((pos1 != Stella.NULL_INTEGER) &&
          ((pos2 != Stella.NULL_INTEGER) &&
           (pos1 <= pos2)));
    }
  }

  public String toString() {
    { Stella_Object self = this;

      if (self == null) {
        return ("!NULL!");
      }
      else {
        return (edu.isi.stella.javalib.Native.stringify_via_print(self));
      }
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Stella_Object self = this;

      stream.print("|i|" + self.primaryType());
    }
  }

  public void decrementReferenceCount() {
    { Stella_Object self = this;

    }
  }

  public void incrementReferenceCount() {
    { Stella_Object self = this;

    }
  }

  /** Default <code>deletedP</code> method which always returns FALSE.  Objects
   * that inherit DYNAMIC-SLOTS-MIXIN also inherit the dynamically-allocated slot
   * <code>deletedObjectP</code> which is read/writable with specializations of this method.
   * @return boolean
   */
  public boolean deletedP() {
    { Stella_Object self = this;

      return (false);
    }
  }

  /** Return the home module of <code>self</code>.
   * @return Module
   */
  public Module homeModule() {
    { Stella_Object self = this;

      return (null);
    }
  }

  /** Returns the primary type of <code>self</code>.
   * Gets defined automatically for every non-abstract subclass of OBJECT.
   * @return Surrogate
   */
  public Surrogate primaryType() {
    { Stella_Object self = this;

      return (null);
    }
  }

}

