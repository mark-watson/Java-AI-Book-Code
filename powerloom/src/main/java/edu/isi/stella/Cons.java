//  -*- Mode: Java -*-
//
// Cons.java

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

public class Cons extends StandardObject {
    public Stella_Object value;
    public Cons rest;

  /** Return a list of conses that make up the list <code>values</code>,
   * terminated by the last value rather than by <code>nil</code>.  Assumes that
   * at least one value is passed in.
   * @param values
   * @return Cons
   */
  public static Cons list$(Cons values) {
    { Cons headcons = Stella.NIL;
      Stella_Object answer = null;
      Cons lastcons = null;

      { Stella_Object v = null;
        Cons iter000 = values;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = iter000.value;
          headcons = Cons.cons(v, headcons);
        }
      }
      answer = headcons.rest.reverse();
      if (answer == Stella.NIL) {
        answer = headcons.value;
        return (((Cons)(answer)));
      }
      lastcons = ((Cons)(answer));
      while (!(lastcons.rest == Stella.NIL)) {
        lastcons = lastcons.rest;
      }
      lastcons.rest = ((Cons)(headcons.value));
      return (((Cons)(answer)));
    }
  }

  /** Return a cons list containing <code>values</code>, in order.
   * @param values
   * @return Cons
   */
  public static Cons consList(Cons values) {
    { Cons list = Stella.NIL;

      { Stella_Object v = null;
        Cons iter000 = values;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          v = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(v, Stella.NIL);
              if (list == Stella.NIL) {
                list = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(list, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(v, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (list);
    }
  }

  /** Return a cons record that points to <code>value</code> and <code>rest</code>.
   * @param value
   * @param rest
   * @return Cons
   */
  public static Cons cons(Stella_Object value, Cons rest) {
    { Cons cons = new Cons();

      cons.value = value;
      cons.rest = rest;
      return (cons);
    }
  }

  public static Cons newCons() {
    { Cons self = null;

      self = new Cons();
      self.rest = Stella.NIL;
      self.value = null;
      return (self);
    }
  }

  public static StringWrapper stellaInformationEvaluatorWrapper(Cons arguments) {
    arguments = arguments;
    { String result = Stella.stellaInformation();

      if (result != null) {
        return (StringWrapper.wrapString(result));
      }
      else {
        return (null);
      }
    }
  }

  public static void printOutlineEvaluatorWrapper(Cons arguments) {
    Stella_Object.printOutline(arguments.value, ((OutputStream)(arguments.rest.value)), ((IntegerWrapper)(arguments.rest.rest.value)).wrapperValue, ((BooleanWrapper)(arguments.rest.rest.rest.value)).wrapperValue);
  }

  public static void idlOutputSignatures(Cons signatures) {
    Stella.idlIndent();
    Stella.idlBumpIndent();
    { Stella_Object signature = null;
      Cons iter000 = signatures;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        signature = iter000.value;
        Stella.idlIndent();
        Cons.idlOutputSignature(((Cons)(signature)), false);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    Stella.idlUnbumpIndent();
  }

  public static void idlOutputSignature(Cons signature, boolean outputmethodclassP) {
    Cons.idlOutputTypeExpression(((Cons)(signature.rest.value)));
    if (outputmethodclassP &&
        (signature.value != null)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(signature.value)).wrapperValue);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("::");
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(signature.rest.rest.value)).wrapperValue);
    Cons.idlOutputFormalParameters(((Cons)(signature.fourth())));
  }

  public static void idlOutputDeclarations(Cons declarations) {
    Stella.idlBumpIndent();
    { Cons declaration = null;
      Cons iter000 = declarations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        declaration = ((Cons)(iter000.value));
        Stella.idlIndent();
        Cons.idlOutputTypeExpression(((Cons)(declaration.value)));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(declaration.rest.value)).wrapperValue);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    Stella.idlUnbumpIndent();
  }

  public static void idlOutputFunctionSignature(Cons function) {
    Cons.idlOutputTypeExpression(((Cons)(function.value)));
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(function.rest.value)).wrapperValue);
    Cons.idlOutputFormalParameters(((Cons)(function.rest.rest.value)));
  }

  public static void idlOutputFormalParameters(Cons parameters) {
    { int nParameters = parameters.length();

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      { Cons parameter = null;
        Cons iter000 = parameters;
        int n = Stella.NULL_INTEGER;
        int iter001 = 1;
        int upperBound000 = nParameters;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;(!(iter000 == Stella.NIL)) &&
                  (unboundedP000 ||
                   (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
          parameter = ((Cons)(iter000.value));
          n = iter001;
          if (n == nParameters) {
            if (parameter.value == Stella.SYM_STELLA_IDL_VAR_ARGS) {
              {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("int ");
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(parameter.rest.value)).wrapperValue);
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ...");
              }
            }
            else {
              Cons.idlOutputOneFormalParameter(parameter);
            }
          }
          else {
            {
              Cons.idlOutputOneFormalParameter(parameter);
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
            }
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void idlOutputOneFormalParameter(Cons parameter) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(parameter.value)).wrapperValue + " " + ((StringWrapper)(parameter.rest.value)).wrapperValue + " " + ((StringWrapper)(parameter.rest.rest.value)).wrapperValue);
  }

  public static void idlOutputStruct(Cons classdef) {
    if (Stella.idlOutputTemplateClassesP()) {
      Cons.idlOutputTemplateParameters(((Cons)(classdef.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("struct " + ((StringWrapper)(classdef.value)).wrapperValue + " ");
    if (!(((Cons)(classdef.rest.rest.value)) == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(": ");
      Cons.idlOutputDerivedClasses(((Cons)(classdef.rest.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    { Stella_Object statement = null;
      Cons iter000 = classdef.nthRest(4);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        Stella_Object.idlOutputStatement(statement);
      }
    }
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("};");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void idlOutputInterface(Cons classdef) {
    if (Stella.idlOutputTemplateClassesP()) {
      Cons.idlOutputTemplateParameters(((Cons)(classdef.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("interface " + ((StringWrapper)(classdef.value)).wrapperValue + " ");
    if (!(((Cons)(classdef.rest.rest.value)) == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(": ");
      Cons.idlOutputDerivedClasses(((Cons)(classdef.rest.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    { Stella_Object statement = null;
      Cons iter000 = classdef.nthRest(4);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        Stella_Object.idlOutputStatement(statement);
      }
    }
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("};");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void idlOutputTemplateParameters(Cons parameters) {
    if (!(parameters == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("template <class " + ((StringWrapper)(parameters.value)).wrapperValue);
      { StringWrapper parameter = null;
        Cons iter000 = parameters.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parameter = ((StringWrapper)(iter000.value));
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", class " + parameter.wrapperValue);
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(">");
    }
  }

  public static void idlOutputDerivedClasses(Cons classList) {
    if (((StringWrapper)(classList.value)) != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(classList.value)).wrapperValue);
    }
    { StringWrapper renamed_Class = null;
      Cons iter000 = classList.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Class = ((StringWrapper)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", " + renamed_Class.wrapperValue);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
  }

  public static void idlOutputTypeExpression(Cons typeexpression) {
    { StringWrapper typeexpr = null;
      Cons iter000 = typeexpression;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        typeexpr = ((StringWrapper)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(typeexpr.wrapperValue + " ");
      }
    }
  }

  public static void idlOutputEnum(Cons renamed_Enum) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("enum {");
    Cons.idlOutputEnumerands(((Cons)(((Cons)(renamed_Enum.nth(4))).rest.value)));
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("};");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void idlOutputEnumerands(Cons enumerands) {
    if (((Cons)(enumerands.value)) != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(((Cons)(enumerands.value)).rest.value)).wrapperValue);
    }
    { Cons enumerand = null;
      Cons iter000 = enumerands.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        enumerand = ((Cons)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", " + ((StringWrapper)(enumerand.rest.value)).wrapperValue);
      }
    }
  }

  public static void idlOutputTypedef(Cons typedef) {
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("typedef " + ((StringWrapper)(typedef.rest.value)).wrapperValue + " " + ((StringWrapper)(typedef.value)).wrapperValue + ";");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void idlOutputParseTree(Cons constree) {
    { Object old$IdlIndentChars$000 = Stella.$IDL_INDENT_CHARS$.get();

      try {
        Native.setIntSpecial(Stella.$IDL_INDENT_CHARS$, 0);
        Stella_Object.idlOutputStatement(constree);

      } finally {
        Stella.$IDL_INDENT_CHARS$.set(old$IdlIndentChars$000);
      }
    }
  }

  public static void javaOutputActualParameters(Cons parameters) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    if (parameters.value != null) {
      Stella_Object.javaOutputStatement(parameters.value);
    }
    { Stella_Object parameter = null;
      Cons iter000 = parameters.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        parameter = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
        Stella_Object.javaOutputStatement(parameter);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void javaOutputFunctionCall(Cons functioncall) {
    Stella_Object.javaMaybeOutputStatementWithParentheses(functioncall.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(".");
    Stella_Object.javaOutputStatement(functioncall.rest.value);
    Stella_Object.javaOutputStatement(functioncall.rest.rest.value);
  }

  public static void javaOutputMethodCall(Cons methodcall) {
    Stella_Object.javaMaybeOutputStatementWithParentheses(methodcall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(".");
    Stella_Object.javaOutputStatement(methodcall.rest.value);
    Stella_Object.javaOutputStatement(methodcall.fourth());
  }

  public static void javaOutputTernaryOperator(Cons expression) {
    { Stella_Object arg1 = expression.value;
      StringWrapper op1 = ((StringWrapper)(expression.rest.value));
      Stella_Object arg2 = expression.rest.rest.value;
      StringWrapper op2 = ((StringWrapper)(expression.fourth()));
      Stella_Object arg3 = expression.fifth();

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      Stella_Object.javaMaybeOutputStatementWithParentheses(arg1);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op1.wrapperValue);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      Stella_Object.javaMaybeOutputStatementWithParentheses(arg2);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op2.wrapperValue);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      Stella_Object.javaMaybeOutputStatementWithParentheses(arg3);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void javaOutputBinaryOperator(Cons expression) {
    Cons.javaHelpOutputBinaryOperator(expression, 0);
  }

  public static void javaHelpOutputBinaryOperator(Cons expression, int nestlevel) {
    { Stella_Object arg1 = expression.value;
      StringWrapper op = ((StringWrapper)(expression.rest.value));
      Stella_Object arg2 = expression.rest.rest.value;

      if (StringWrapper.javaNestedOperatorNeedsParenthesesP(op, arg1)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      if (Stella_Object.javaBinaryOperatorP(op)) {
        Cons.javaHelpOutputBinaryOperator(((Cons)(arg1)).rest, nestlevel + 1);
      }
      else {
        Stella_Object.javaOutputStatement(arg1);
      }
      if (StringWrapper.javaNestedOperatorNeedsParenthesesP(op, arg1)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op.wrapperValue);
      if (StringWrapper.javaIndentableBinaryOperatorP(op)) {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          Stella.javaIndent();
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("    ");
          { int i = Stella.NULL_INTEGER;
            int iter000 = 1;
            int upperBound000 = nestlevel;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;unboundedP000 ||
                      (iter000 <= upperBound000); iter000 = iter000 + 1) {
              i = iter000;
              i = i;
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
            }
          }
        }
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      }
      if (StringWrapper.javaNestedOperatorNeedsParenthesesP(op, arg2)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      if (Stella_Object.javaBinaryOperatorP(arg2)) {
        Cons.javaHelpOutputBinaryOperator(((Cons)(arg2)).rest, nestlevel + 1);
      }
      else {
        Stella_Object.javaOutputStatement(arg2);
      }
      if (StringWrapper.javaNestedOperatorNeedsParenthesesP(op, arg2)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
    }
  }

  public static void javaOutputUnaryOperator(Cons expression) {
    { StringWrapper op = ((StringWrapper)(expression.value));
      Stella_Object arg = expression.rest.value;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op.wrapperValue);
      Stella_Object.javaMaybeOutputStatementWithParentheses(arg);
    }
  }

  public static Cons javaReverseAndConsolidateStrings(Cons items) {
    if (items == Stella.NIL) {
      return (Stella.NIL);
    }
    { Cons outputItems = Stella.NIL;
      Cons lastItem = ((Cons)(items.value));

      { Cons newItem = null;
        Cons iter000 = items.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          newItem = ((Cons)(iter000.value));
          if (Cons.javaLiteralStringP(newItem)) {
            if (Cons.javaLiteralStringP(lastItem)) {
              lastItem = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_LITERAL, Cons.cons(StringWrapper.wrapString(((StringWrapper)(newItem.rest.value)).wrapperValue + ((StringWrapper)(lastItem.rest.value)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL))));
            }
            else {
              {
                outputItems = Cons.cons(lastItem, outputItems);
                lastItem = newItem;
              }
            }
          }
          else {
            {
              outputItems = Cons.cons(lastItem, outputItems);
              lastItem = newItem;
            }
          }
        }
      }
      outputItems = Cons.cons(lastItem, outputItems);
      return (outputItems);
    }
  }

  public static boolean javaLiteralStringP(Cons item) {
    return ((item.value == Stella.SYM_STELLA_JAVA_LITERAL) &&
        Stella_Object.isaP(item.rest.value, Stella.SGT_STELLA_STRING_WRAPPER));
  }

  public static void javaOutputPrintStream(Cons exps, boolean nativestreamP) {
    { Stella_Object stream = exps.value;
      boolean foundeolP = false;
      boolean embeddedeolP = false;
      Cons printitems = Stella.NIL;

      { Stella_Object i = null;
        Cons iter000 = exps.rest;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = iter000.value;
          if (foundeolP) {
            embeddedeolP = true;
            break loop000;
          }
          if (Stella_Object.javaEndOfLineTokenP(i)) {
            foundeolP = true;
          }
        }
      }
      if (embeddedeolP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
        Stella.javaBumpIndent();
      }
      { ConsIterator it = exps.rest.allocateIterator();

        while (it.nextP()) {
          { Stella_Object item = it.value;

            if (Stella_Object.javaEndOfLineTokenP(item)) {
              {
                if (embeddedeolP) {
                  Stella.javaIndent();
                }
                Stella_Object.javaHelpOutputPrintStream(stream, Cons.javaReverseAndConsolidateStrings(printitems), nativestreamP, true);
                if (embeddedeolP) {
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
                }
                printitems = Stella.NIL;
              }
            }
            else {
              printitems = Cons.cons(item, printitems);
            }
          }
        }
      }
      if (!(printitems == Stella.NIL)) {
        if (embeddedeolP) {
          Stella.javaIndent();
        }
        Stella_Object.javaHelpOutputPrintStream(stream, Cons.javaReverseAndConsolidateStrings(printitems), nativestreamP, false);
        if (embeddedeolP) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        }
      }
      if (embeddedeolP) {
        Stella.javaUnbumpIndent();
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
      }
    }
  }

  public static void javaOutputForeach(Cons loop) {
    { Stella_Object continuationtest = loop.rest.value;
      Cons valueassignments = ((Cons)(loop.rest.rest.value));
      Cons nextassignments = ((Cons)(loop.fourth()));
      int nofnextassignments = nextassignments.length();
      Cons body = ((Cons)(loop.fifth()));
      boolean eolseparateexpressionsP = (nofnextassignments > 2) ||
          (((Integer)(Stella.$JAVA_INDENT_CHARS$.get())).intValue() > 35);

      if (nofnextassignments == 0) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("while (");
        Stella_Object.javaOutputStatement(continuationtest);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
        Stella.javaBumpIndent();
        Cons.javaOutputStatements(valueassignments.concatenate(body, Stella.NIL));
        Stella.javaUnbumpIndent();
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
        return;
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("for (;");
      Stella.javaBumpIndent();
      Stella.javaBumpIndent();
      Stella.javaBumpIndent();
      Stella_Object.javaOutputStatement(continuationtest);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("; ");
      if (!(nextassignments == Stella.NIL)) {
        if (eolseparateexpressionsP) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        }
        { Stella_Object next = null;
          Cons iter000 = nextassignments;
          int i = Stella.NULL_INTEGER;
          int iter001 = 1;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            next = iter000.value;
            i = iter001;
            if (eolseparateexpressionsP) {
              Stella.javaIndent();
            }
            Stella_Object.javaOutputStatement(next);
            if (!(i == nofnextassignments)) {
              if (eolseparateexpressionsP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(",");
              }
              else {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
              }
            }
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
      Stella.javaUnbumpIndent();
      Stella.javaUnbumpIndent();
      Cons.javaOutputStatements(valueassignments.concatenate(body, Stella.NIL));
      Stella.javaUnbumpIndent();
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static void javaOutputWhile(Cons loop) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("while (");
    Stella_Object.javaOutputStatement(loop.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
    Stella_Object.javaOutputStatement(loop.rest.value);
  }

  public static void javaOutputLoop(Cons loop) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("for (;;) ");
    Stella_Object.javaOutputStatement(loop.value);
  }

  public static void javaOutputAssignment(Cons assignment) {
    Stella_Object.javaOutputStatement(assignment.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" = ");
    Stella_Object.javaOutputStatement(assignment.rest.value);
  }

  public static void javaOutputUnless(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (!(");
    Stella_Object.javaOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(")) {");
    Stella.javaBumpIndent();
    Stella_Object.javaOutputStatement(tree.rest.value);
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void javaOutputWhen(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
    Stella_Object.javaOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
    Stella.javaBumpIndent();
    Stella_Object.javaOutputStatement(tree.rest.value);
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void javaOutputIf(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
    Stella_Object.javaOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
    if (Stella_Object.javaPrognP(tree.rest.value) ||
        Stella_Object.javaBlockP(tree.rest.value)) {
      Stella_Object.javaOutputStatement(tree.rest.value);
    }
    else {
      {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        Stella.javaBumpIndent();
        Stella.javaIndent();
        Stella_Object.javaOutputStatement(tree.rest.value);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        Stella.javaUnbumpIndent();
      }
    }
    if (!(tree.rest.rest.value == null)) {
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else ");
      if (Stella_Object.javaPrognP(tree.rest.rest.value) ||
          Stella_Object.javaBlockP(tree.rest.rest.value)) {
        Stella_Object.javaOutputStatement(tree.rest.rest.value);
      }
      else {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          Stella.javaBumpIndent();
          Stella.javaIndent();
          Stella_Object.javaOutputStatement(tree.rest.rest.value);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
          Stella.javaUnbumpIndent();
        }
      }
    }
  }

  public static void javaOutputCond(Cons cond) {
    { Cons defaultcondition = ((Cons)(cond.value));
      Cons conditions = ((Cons)(cond.rest.value));
      Cons firstcondition = ((Cons)(conditions.value));
      Cons restconditions = conditions.rest;

      if ((defaultcondition != null) &&
          (conditions == Stella.NIL)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (true) ");
        Stella_Object.javaOutputStatement(defaultcondition);
        return;
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
      Stella_Object.javaOutputStatement(firstcondition.value);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
      Stella_Object.javaOutputStatement(firstcondition.rest.value);
      { Stella_Object c = null;
        Cons iter000 = restconditions;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          c = iter000.value;
          { Cons condition = ((Cons)(c));

            Stella.javaIndent();
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else if (");
            Stella_Object.javaOutputStatement(condition.value);
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
            Stella_Object.javaOutputStatement(condition.rest.value);
          }
        }
      }
      if (defaultcondition != null) {
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else ");
        Stella_Object.javaOutputStatement(defaultcondition);
      }
    }
  }

  public static void javaOutputCase(Cons renamed_Case) {
    { Stella_Object keyform = renamed_Case.value;
      Stella_Object defaultcase = renamed_Case.rest.value;
      Stella_Object conditions = renamed_Case.rest.rest.value;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("switch (");
      Stella_Object.javaOutputStatement(keyform);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
      Stella.javaBumpIndent();
      { Cons c = null;
        Cons iter000 = ((Cons)(conditions));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          c = ((Cons)(iter000.value));
          { Cons condition = c;

            { Stella_Object cond = null;
              Cons iter001 = ((Cons)((Stella_Object.consP(((Cons)(condition.value)).value) ? condition.value : Cons.cons(condition.value, Stella.NIL))));

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                cond = iter001.value;
                Stella.javaIndent();
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("case ");
                Stella_Object.javaOutputStatement(cond);
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(": ");
              }
            }
            Stella.javaBumpIndent();
            Stella_Object.javaOutputStatement(condition.rest.value);
            Stella.javaUnbumpIndent();
            if (!(Cons.javaLastStatementReturnsP(((Cons)(condition.rest.value))))) {
              Stella.javaIndent();
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("break;");
            }
          }
        }
      }
      if (!(defaultcase != null)) {
        System.err.print("Safety violation: INTERNAL ERROR: `java-output-case' expects an `otherwise' clause.");
      }
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("default:");
      Stella.javaBumpIndent();
      Stella_Object.javaOutputStatement(defaultcase);
      Stella.javaUnbumpIndent();
      if (!(Cons.javaLastStatementReturnsP(((Cons)(defaultcase))))) {
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("break;");
      }
      Stella.javaUnbumpIndent();
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static boolean javaLastStatementReturnsP(Cons statements) {
    { Stella_Object lastStatement = statements.last();

      return (Stella_Object.isaP(lastStatement, Stella.SGT_STELLA_CONS) &&
          Cons.javaStatementReturnsP(((Cons)(lastStatement))));
    }
  }

  public static boolean javaStatementReturnsP(Cons statement) {
    if (!(statement != null)) {
      return (false);
    }
    else if (statement == Stella.NIL) {
      return (false);
    }
    else {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement.value));

        if (testValue000 == Stella.SYM_STELLA_JAVA_VERBATIM) {
          return (Native.stringSearch(((StringWrapper)(statement.rest.value)).wrapperValue, "throw new Error", 0) != Stella.NULL_INTEGER);
        }
        else if ((testValue000 == Stella.SYM_STELLA_JAVA_RETURN) ||
            ((testValue000 == Stella.SYM_STELLA_JAVA_CONTINUE) ||
             ((testValue000 == Stella.SYM_STELLA_JAVA_BREAK) ||
              (testValue000 == Stella.SYM_STELLA_JAVA_SIGNAL)))) {
          return (true);
        }
        else if (testValue000 == Stella.SYM_STELLA_JAVA_STATEMENTS) {
          return (Cons.javaLastStatementReturnsP(statement.rest));
        }
        else if (testValue000 == Stella.SYM_STELLA_JAVA_PROGN) {
          return (Cons.javaLastStatementReturnsP(((Cons)(statement.rest.value))));
        }
        else if (testValue000 == Stella.SYM_STELLA_JAVA_BLOCK) {
          return (Cons.javaLastStatementReturnsP(((Cons)(statement.rest.rest.value))));
        }
        else if (testValue000 == Stella.SYM_STELLA_JAVA_IF) {
          return (Cons.javaStatementReturnsP(((Cons)(statement.rest.rest.value))) &&
              Cons.javaStatementReturnsP(((Cons)(statement.fourth()))));
        }
        else if (testValue000 == Stella.SYM_STELLA_JAVA_COND) {
          { boolean testValue001 = false;

            testValue001 = Cons.javaStatementReturnsP(((Cons)(statement.rest.value)));
            if (testValue001) {
              { boolean alwaysP000 = true;

                { Stella_Object c = null;
                  Cons iter000 = ((Cons)(statement.rest.rest.value));

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    c = iter000.value;
                    if (!Cons.javaLastStatementReturnsP(((Cons)(c)))) {
                      alwaysP000 = false;
                      break loop000;
                    }
                  }
                }
                testValue001 = alwaysP000;
              }
            }
            { boolean value000 = testValue001;

              return (value000);
            }
          }
        }
        else {
          return (false);
        }
      }
    }
  }

  public static void javaOutputContinue(Cons tag) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("continue ");
    Stella_Object.javaOutputStatement(tag);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
  }

  public static void javaOutputBreak(Cons tag) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("break ");
    Stella_Object.javaOutputStatement(tag);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
  }

  public static void javaOutputMethodCodeCall(Cons methodcall) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.javaYieldFullNativeClassName() + ".funcall(");
    Stella_Object.javaOutputStatement(methodcall.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
    Stella_Object.javaOutputStatement(methodcall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", new java.lang.Object []");
    Cons.javaOutputArray(((Cons)(methodcall.fourth())).rest);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void javaOutputFuncall(Cons funcall) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.javaYieldFullNativeClassName() + ".funcall(");
    Stella_Object.javaOutputStatement(funcall.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", null, new java.lang.Object [] ");
    Cons.javaOutputArray(((Cons)(funcall.rest.rest.value)).rest);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void javaOutputActualsAsConsExpression(Cons arglist) {
    if (arglist == Stella.NIL) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(Stella.javaPrependGlobalClassName("NIL", Stella.$STELLA_MODULE$));
    }
    else {
      {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(Stella.$JAVA_STELLA_PACKAGE_MAPPING$.lookup(StringWrapper.wrapString("STELLAROOT")))) + ".Stella_Object.cons(");
        Stella_Object.javaOutputStatement(arglist.value);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
        Cons.javaOutputActualsAsConsExpression(arglist.rest);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
    }
  }

  public static void javaOutputGlobalDefinition(Cons global) {
    if (((StringWrapper)(global.value)).wrapperValue != null) {
      Stella.javaIndent();
      StringWrapper.javaOutputJavadocComment(((StringWrapper)(global.value)), Stella.NIL, null, null, null);
    }
    Stella.javaIndent();
    Stella_Object.javaOutputStatement(global.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(global.rest.rest.value)).wrapperValue);
    if (!(global.rest.rest.rest == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" = ");
      Stella_Object.javaOutputStatement(global.fourth());
    }
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void javaOutputSignal(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("throw ");
    Stella_Object.javaOutputStatement(tree);
  }

  public static void javaOutputHandlerCase(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("try {");
    Stella.javaBumpIndent();
    if (Stella_Object.javaPrognP(tree.value)) {
      Stella_Object.javaOutputStatement(((Cons)(tree.value)).rest.value);
    }
    else {
      {
        Stella.javaIndent();
        Stella_Object.javaOutputStatement(tree.value);
        if (Cons.javaOutputSemicolonP(((Cons)(tree.value)))) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        }
      }
    }
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("}");
    Cons.javaOutputStatements(tree.rest);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
  }

  public static void javaOutputUnwindProtect(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("try {");
    Stella.javaBumpIndent();
    if (Stella_Object.javaPrognP(tree.value)) {
      Stella_Object.javaOutputStatement(((Cons)(tree.value)).rest.value);
    }
    else if (Cons.javaIndentStatementP(((Cons)(tree.value)))) {
      Stella.javaIndent();
      Stella_Object.javaOutputStatement(tree.value);
      if (Cons.javaOutputSemicolonP(((Cons)(tree.value)))) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    else {
      Stella_Object.javaOutputStatement(tree.value);
    }
    Stella.javaUnbumpIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("} finally {");
    Stella.javaBumpIndent();
    Cons.javaOutputStatements(tree.rest);
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void javaOutputCatch(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" catch (");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(((Cons)(tree.value)).value)).wrapperValue);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(((Cons)(tree.value)).rest.value)).wrapperValue);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
    Stella.javaBumpIndent();
    Cons.javaOutputStatements(tree.rest);
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("}");
  }

  public static void javaOutputThrow(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("throw new ");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(tree.value)).wrapperValue);
  }

  public static void javaOutputReturn(Cons returnstatement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("return");
    if (returnstatement != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" (");
      Stella_Object.javaOutputStatement(returnstatement);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void javaOutputWithProcessLock(Cons synch) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("synchronized (");
    Stella_Object.javaOutputStatement(synch.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
    Cons.javaOutputProgn(((Cons)(synch.rest.value)));
  }

  public static void javaOutputBlock(Cons block) {
    { boolean firststatementP = true;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("{ ");
      Stella.javaBumpIndent();
      { Cons declaration = null;
        Cons iter000 = ((Cons)(block.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = ((Cons)(iter000.value));
          if (!(firststatementP)) {
            Stella.javaIndent();
          }
          firststatementP = false;
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(declaration.value)).wrapperValue);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
          Stella_Object.javaOutputStatement(declaration.rest.value);
          if (!(declaration.rest.rest.value == null)) {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" = ");
            Stella_Object.javaOutputStatement(declaration.rest.rest.value);
          }
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
      Stella_Object.javaOutputStatement(block.rest.value);
      Stella.javaUnbumpIndent();
      Stella.javaIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static void javaOutputProgn(Cons progn) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    Stella.javaBumpIndent();
    Stella_Object.javaOutputStatement(progn);
    Stella.javaUnbumpIndent();
    Stella.javaIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void javaOutputCast(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("((" + ((StringWrapper)(tree.rest.value)).wrapperValue + ")(");
    Stella_Object.javaOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("))");
  }

  public static void javaOutputMake(Cons statement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new ");
    Stella_Object.javaOutputStatement(statement.value);
    Stella_Object.javaOutputStatement(statement.rest.value);
  }

  public static void javaOutputDeclarations(Cons declarations) {
    Stella.javaBumpIndent();
    { Cons declaration = null;
      Cons iter000 = declarations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        declaration = ((Cons)(iter000.value));
        if (declaration.rest.rest.value != null) {
          Stella.javaIndent();
          StringWrapper.javaOutputJavadocComment(((StringWrapper)(declaration.rest.rest.value)), Stella.NIL, null, null, null);
        }
        Stella.javaIndent();
        Cons.javaOutputTypeExpression(((Cons)(declaration.value)));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(declaration.rest.value)).wrapperValue);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    Stella.javaUnbumpIndent();
  }

  public static void javaOutputStatements(Cons statementlist) {
    { Stella_Object statement = null;
      Cons iter000 = statementlist;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        if (!(Cons.javaIllegalStatementP(((Cons)(statement))))) {
          if (Cons.javaIndentStatementP(((Cons)(statement)))) {
            Stella.javaIndent();
          }
          Stella_Object.javaOutputStatement(statement);
          if (Cons.javaOutputSemicolonP(((Cons)(statement)))) {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
          }
        }
      }
    }
  }

  public static boolean javaIllegalStatementP(Cons statement) {
    if (statement != null) {
      return (Stella.getQuotedTree("((JAVA_LITERAL JAVA_IDENT) \"/STELLA\")", "/STELLA").memberP(statement.value));
    }
    else {
      return (false);
    }
  }

  public static boolean javaIndentStatementP(Cons statement) {
    if (statement != null) {
      return (!Stella.getQuotedTree("((JAVA_STATEMENTS JAVA_CATCH) \"/STELLA\")", "/STELLA").memberP(statement.value));
    }
    else {
      return (false);
    }
  }

  public static boolean javaOutputSemicolonP(Cons statement) {
    if (statement != null) {
      return (Stella.$JAVA_SEMICOLON_STATEMENTS$.memberP(statement.value));
    }
    else {
      return (false);
    }
  }

  public static void javaOutputTypeExpression(Cons typeexpression) {
    { StringWrapper typeexpr = null;
      Cons iter000 = typeexpression;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        typeexpr = ((StringWrapper)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(typeexpr.wrapperValue + " ");
      }
    }
  }

  public void javaOutputLiteral() {
    { Cons cons = this;

      if (cons == Stella.NIL) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("NIL");
      }
      else {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(" + cons.value + " . ");
          cons.rest.javaOutputLiteral();
        }
      }
    }
  }

  public static void javaOutputMethod(Cons method) {
    { Cons body = null;
      Cons comment = null;

      { Object [] caller_MV_returnarray = new Object[1];

        body = Cons.javaSeparateCommentFromBody(((Cons)(method.fifth())), caller_MV_returnarray);
        comment = ((Cons)(caller_MV_returnarray[0]));
      }
      if (comment != null) {
        Stella.javaIndent();
        StringWrapper.javaOutputJavadocComment(((StringWrapper)(comment.rest.value)), ((Cons)(method.fourth())), ((StringWrapper)(((Cons)(method.rest.value)).value)), null, null);
      }
      Stella.javaIndent();
      Cons.javaOutputMethodSignature(method);
      if (!(body == Stella.NIL)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" {");
        Stella.javaBumpIndent();
        Stella_Object.javaOutputStatement(body);
        Stella.javaUnbumpIndent();
        Stella.javaIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
      }
      else if (((Cons)(method.value)).memberP(StringWrapper.wrapString("abstract"))) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
      }
      else if (((Cons)(method.rest.value)).memberP(StringWrapper.wrapString("void"))) {
        Stella.STANDARD_OUTPUT.nativeStream.println("Note: Void method `" + method.rest.rest.value + "' has an empty body.");
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" {}");
      }
      else {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Method `" + method.rest.rest.value + "' has an empty body but is not abstract or void!");
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" {}");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
  }

  public static Cons javaSeparateCommentFromBody(Cons body, Object [] MV_returnarray) {
    if ((body.value == Stella.SYM_STELLA_JAVA_STATEMENTS) &&
        ((!(body.rest == Stella.NIL)) &&
         (Stella_Object.isaP(body.rest.value, Stella.SGT_STELLA_CONS) &&
          (((Cons)(body.rest.value)).value == Stella.SYM_STELLA_JAVA_COMMENT)))) {
      { Stella_Object comment = body.rest.value;

        body.rest = body.rest.rest;
        if (body.rest == Stella.NIL) {
          { Cons _return_temp = Stella.NIL;

            MV_returnarray[0] = ((Cons)(comment));
            return (_return_temp);
          }
        }
        else {
          { Cons _return_temp = body;

            MV_returnarray[0] = ((Cons)(comment));
            return (_return_temp);
          }
        }
      }
    }
    else {
      { Cons _return_temp = body;

        MV_returnarray[0] = null;
        return (_return_temp);
      }
    }
  }

  public static void javaOutputMethodSignature(Cons method) {
    { Stella_Object m = null;
      Cons iter000 = ((Cons)(method.value));

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        m = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(m)).wrapperValue + " ");
      }
    }
    Cons.javaOutputTypeExpression(((Cons)(method.rest.value)));
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(method.rest.rest.value)).wrapperValue);
    Cons.javaOutputFormalParameters(((Cons)(method.fourth())));
  }

  public static void javaOutputFormalParameters(Cons parameters) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    if (!(parameters == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(((Cons)(parameters.value)).value)).wrapperValue + " " + ((StringWrapper)(((Cons)(parameters.value)).rest.value)).wrapperValue);
      { Cons parameter = null;
        Cons iter000 = parameters.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parameter = ((Cons)(iter000.value));
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", " + ((StringWrapper)(parameter.value)).wrapperValue + " " + ((StringWrapper)(parameter.rest.value)).wrapperValue);
        }
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void javaOutputNamedStatement(Cons namedstatement) {
    Stella_Object.javaOutputStatement(namedstatement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" : ");
    Stella_Object.javaOutputStatement(namedstatement.rest.value);
  }

  public static void javaOutputClassMethods(Cons methods) {
    { TranslationUnit statement = null;
      Cons iter000 = methods;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = ((TranslationUnit)(iter000.value));
        Stella_Object.javaOutputStatement(TranslationUnit.javaTranslateUnit(statement));
        statement.translation = null;
        statement.codeRegister = null;
      }
    }
  }

  public static void javaOutputClassConstructors(Cons constructors, String classname, boolean exceptionclassP) {
    if (exceptionclassP) {
      Stella.javaOutputExceptionConstructor(classname);
    }
    { TranslationUnit statement = null;
      Cons iter000 = constructors;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = ((TranslationUnit)(iter000.value));
        Stella_Object.javaOutputStatement(TranslationUnit.javaTranslateUnit(statement));
        statement.translation = null;
        statement.codeRegister = null;
      }
    }
  }

  public static void javaOutputClassVariableDefinitions(Cons variabletranslations) {
    { Stella_Object statement = null;
      Cons iter000 = variabletranslations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        Stella_Object.javaOutputStatement(((Cons)(statement)));
      }
    }
  }

  public static void javaOutputClassDeclaration(Cons classdef) {
    if (StringWrapper.unwrapString(((StringWrapper)(classdef.value))) != null) {
      StringWrapper.javaOutputJavadocComment(((StringWrapper)(classdef.value)), null, null, "Stella Java Translator", null);
    }
    { Stella_Object m = null;
      Cons iter000 = ((Cons)(classdef.rest.value));

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        m = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(m)).wrapperValue + " ");
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(classdef.rest.rest.value)).wrapperValue + " " + ((StringWrapper)(classdef.fourth())).wrapperValue + " ");
    if (classdef.fifth() != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("extends " + ((StringWrapper)(classdef.fifth())).wrapperValue + " ");
    }
    if (!(((Cons)(classdef.nth(5))) == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("implements ");
      Cons.javaOutputImplementsInterfaces(((Cons)(classdef.nth(5))));
    }
  }

  public static void javaOutputClass(Cons classdef, boolean exceptionclassP) {
    Cons.javaOutputClassDeclaration(classdef);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    Stella.javaBumpIndent();
    Cons.javaOutputClassVariableDefinitions(((Cons)(classdef.nth(6))));
    Cons.javaOutputClassConstructors(((Cons)(classdef.nth(7))), ((StringWrapper)(classdef.fourth())).wrapperValue, exceptionclassP);
    Cons.javaOutputClassMethods(((Cons)(classdef.nth(8))));
    Stella.javaUnbumpIndent();
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
  }

  public static void javaOutputImplementsInterfaces(Cons interfacelist) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(interfacelist.value)).wrapperValue);
    { StringWrapper renamed_Interface = null;
      Cons iter000 = interfacelist.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Interface = ((StringWrapper)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", " + renamed_Interface.wrapperValue);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
  }

  public static void javaOutputSlotValueSetter(Cons statement) {
    Stella_Object.javaOutputStatement(statement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("." + ((StringWrapper)(statement.rest.value)).wrapperValue + " = ");
    Stella_Object.javaOutputStatement(statement.rest.rest.value);
  }

  public static void javaOutputSlotValue(Cons statement) {
    Stella_Object.javaOutputStatement(statement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("." + ((StringWrapper)(statement.rest.value)).wrapperValue);
  }

  public static void javaOutputAref(Cons statement) {
    Stella_Object.javaOutputStatement(statement.value);
    { Stella_Object dimension = null;
      Cons iter000 = statement.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        dimension = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("[");
        Stella_Object.javaOutputStatement(dimension);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("]");
      }
    }
  }

  public static void javaOutputAnonymousArray(Cons statement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new ");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(statement.value)).wrapperValue);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" [] ");
    Cons.javaOutputArray(statement.rest);
  }

  public static void javaOutputArray(Cons arrayelements) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("{");
    if (arrayelements.value != null) {
      Stella_Object.javaOutputStatement(arrayelements.value);
    }
    { Stella_Object element = null;
      Cons iter000 = arrayelements.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        element = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
        Stella_Object.javaOutputStatement(element);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("}");
  }

  public static void javaOutputMakeArray(Cons statement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new ");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(statement.value)).wrapperValue);
    { Stella_Object dimension = null;
      Cons iter000 = statement.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        dimension = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("[");
        Stella_Object.javaOutputStatement(dimension);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("]");
      }
    }
  }

  public static void javaOutputParseTree(Cons constree) {
    { Object old$JavaIndentChars$000 = Stella.$JAVA_INDENT_CHARS$.get();

      try {
        Native.setIntSpecial(Stella.$JAVA_INDENT_CHARS$, 0);
        Stella.$JAVA_STELLA_PACKAGE_MAPPING$.insertAt(StringWrapper.wrapString("STELLAROOT"), StringWrapper.wrapString(Stella.javaStellaPackage()));
        Stella_Object.javaOutputStatement(constree);

      } finally {
        Stella.$JAVA_INDENT_CHARS$.set(old$JavaIndentChars$000);
      }
    }
  }

  public static Cons javaTranslateOperatorCall(Cons operatornames, Cons arguments, int arity) {
    { Cons otree = null;

      switch (arity) {
        case 1: 
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_UNARY_OP, Cons.cons(operatornames.value, Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(arguments.value), Stella.NIL), Stella.NIL))));
        break;
        case 2: 
          if (arguments.length() > 2) {
            otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BINARY_OP, Cons.cons(Stella_Object.javaTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Cons.javaTranslateOperatorCall(operatornames, arguments.rest, 2), Stella.NIL)), Stella.NIL))));
          }
          else {
            otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BINARY_OP, Cons.cons(Stella_Object.javaTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Stella_Object.javaTranslateATree(arguments.rest.value), Stella.NIL)), Stella.NIL))));
          }
        break;
        case 3: 
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_TERNARY_OP, Cons.cons(Stella_Object.javaTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Stella_Object.javaTranslateATree(arguments.rest.value), Cons.cons(operatornames.rest.value, Cons.cons(Stella_Object.javaTranslateATree(arguments.rest.rest.value), Stella.NIL)))), Stella.NIL))));
        break;
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + arity + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
      return (otree);
    }
  }

  public static Cons javaTranslateOperatorTree(Cons tree) {
    { Cons operator = Symbol.javaLookupOperatorTable(((Symbol)(tree.value)));
      Cons args = tree.rest;
      int arity = Stella.NULL_INTEGER;

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

        if ((testValue000 == Stella.SYM_STELLA_AND) ||
            ((testValue000 == Stella.SYM_STELLA_OR) ||
             ((testValue000 == Stella.SYM_STELLA_EQp) ||
              ((testValue000 == Stella.SYM_STELLA_g) ||
               ((testValue000 == Stella.SYM_STELLA_ge) ||
                ((testValue000 == Stella.SYM_STELLA_l) ||
                 (testValue000 == Stella.SYM_STELLA_le))))))) {
          arity = 2;
        }
        else if ((testValue000 == Stella.SYM_STELLA_NOT) ||
            ((testValue000 == Stella.SYM_STELLA_ii) ||
             (testValue000 == Stella.SYM_STELLA___))) {
          arity = 1;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (Cons.javaTranslateOperatorCall(operator, args, arity));
    }
  }

  public static Cons javaTranslateMethodCall(Cons tree) {
    { Symbol methodname = ((Symbol)(tree.rest.rest.value));
      Surrogate classtype = ((Surrogate)(tree.rest.value));
      Cons allargs = tree.rest.rest.rest;
      Stella_Object renamed_Object = tree.fourth();

      if (methodname == Stella.SYM_STELLA_DEFINEDp) {
        return (Surrogate.javaTranslateDefinedOrNull(classtype, renamed_Object, false));
      }
      else if (methodname == Stella.SYM_STELLA_NULLp) {
        return (Surrogate.javaTranslateDefinedOrNull(classtype, renamed_Object, true));
      }
      else if (methodname == Stella.SYM_STELLA_CONCATENATE) {
        if (classtype == Stella.SGT_STELLA_STRING) {
          return (Cons.javaTranslateOperatorCall(Stella.getQuotedTree("((\"+\") \"/STELLA\")", "/STELLA"), allargs, 2));
        }
      }
      else if ((methodname == Stella.SYM_STELLA_NTH) ||
          (methodname == Stella.SYM_STELLA_NTH_SETTER)) {
        return (Symbol.javaTranslateNthMethodCall(methodname, classtype, allargs));
      }
      else if ((methodname == Stella.SYM_STELLA_AREF) ||
          (methodname == Stella.SYM_STELLA_AREF_SETTER)) {
        return (Symbol.javaTranslateArefMethodCall(methodname, classtype, allargs));
      }
      else {
      }
      return (Symbol.javaTranslateNormalMethodCall(methodname, classtype, allargs));
    }
  }

  public static Cons javaTranslateFunctionCall(Cons tree, MethodSlot method) {
    tree = tree.rest;
    { Symbol functionname = ((Symbol)(tree.value));
      Cons functionargs = Cons.copyConsList(tree.rest);
      Stella_Object firstarg = functionargs.value;
      MethodSlot function = ((method != null) ? method : Symbol.lookupFunction(functionname));
      Cons operator = Symbol.javaLookupOperatorTable(functionname.softPermanentify());
      Cons otree = null;

      if ((functionname == Stella.SYM_STELLA_GET_SYM) &&
          Stella_Object.isaP(firstarg, Stella.SGT_STELLA_INTEGER_WRAPPER)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SYMBOL, Cons.cons(Symbol.getSym(((IntegerWrapper)(firstarg)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if ((functionname == Stella.SYM_STELLA_GET_KWD) &&
          Stella_Object.isaP(firstarg, Stella.SGT_STELLA_INTEGER_WRAPPER)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SYMBOL, Cons.cons(Keyword.getKwd(((IntegerWrapper)(firstarg)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if ((functionname == Stella.SYM_STELLA_GET_SGT) &&
          Stella_Object.isaP(firstarg, Stella.SGT_STELLA_INTEGER_WRAPPER)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SYMBOL, Cons.cons(Surrogate.getSgt(((IntegerWrapper)(firstarg)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      if (operator != null) {
        otree = Cons.javaTranslateOperatorCall(operator, functionargs, functionargs.length());
      }
      else if (function == null) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't translate function call: Undefined function or method `" + functionname + "'");
        otree = Stella.NIL;
      }
      else {
        { Object old$Varargstatements$000 = Stella.$VARARGSTATEMENTS$.get();

          try {
            Native.setSpecial(Stella.$VARARGSTATEMENTS$, Stella.NIL);
            { Cons actuals = (((BooleanWrapper)(KeyValueList.dynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue ? Cons.javaTranslateVariableLengthActuals(functionargs, function) : Cons.javaTranslateActualParameters(functionargs));

              if (!((function.methodReturnTypeSpecifiers().rest() == Stella.NIL) ||
                  ((actuals.length() - 1) > function.methodParameterNames().length()))) {
                actuals = actuals.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE_ARRAY, Cons.cons(StandardObject.javaTranslateTypeSpec(Stella.SGT_STELLA_NATIVE_OBJECT_POINTER), Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(function.methodReturnTypeSpecifiers().length() - 1), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL);
              }
              otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(MethodSlot.javaYieldClassNameForFunction(function)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(MethodSlot.javaTranslateFunctionName(function), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(actuals, Cons.cons(Stella.NIL, Stella.NIL))))));
              if (!(((Cons)(Stella.$VARARGSTATEMENTS$.get())) == Stella.NIL)) {
                otree = Cons.javaWrapMethodBodyWithVarargValueSetup(otree);
              }
            }

          } finally {
            Stella.$VARARGSTATEMENTS$.set(old$Varargstatements$000);
          }
        }
      }
      return (otree);
    }
  }

  public static Cons javaTranslateActualParameters(Cons tree) {
    return (Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.javaTranslateListOfTrees(tree).concatenate(Stella.NIL, Stella.NIL)));
  }

  public static Cons javaTranslateVariableLengthActuals(Cons actuals, MethodSlot unusedMethod) {
    unusedMethod = unusedMethod;
    return (Cons.javaTranslateActualParameters(actuals));
  }

  public static Cons javaWrapMethodBodyWithVarargValueSetup(Cons methodbody) {
    return (Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, ((Cons)(Stella.$VARARGSTATEMENTS$.get())).reverse().concatenate(Cons.cons(methodbody, Stella.NIL), Stella.NIL)));
  }

  public static Cons javaWrapMethodBodyWithVarargDeclarations(Cons methodbody) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(((Cons)(Stella.$VARARGDECLS$.get())).reverse(), Cons.cons(Cons.cons(methodbody, Stella.NIL), Stella.NIL)))));
  }

  public static Cons javaDeleteQuotedNullStatements(Cons trees) {
    return (trees.remove(Stella.SYM_STELLA_NULL));
  }

  public static Cons javaTranslatePrintNativeStream(Cons tree) {
    { Cons otree = Cons.javaTranslatePrintStream(tree);

      otree.firstSetter(Stella.SYM_STELLA_JAVA_PRINT_NATIVE_STREAM);
      return (otree);
    }
  }

  public static Cons javaTranslatePrintStream(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_JAVA_PRINT_STREAM);
    if (Surrogate.subtypeOfKeywordP(Stella_Object.safePrimaryType(tree.rest.value))) {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.rest.value));

        if ((testValue000 == Stella.KWD_WARN) ||
            ((testValue000 == Stella.KWD_ERROR) ||
             (testValue000 == Stella.KWD_CONTINUABLE_ERROR))) {
          tree.secondSetter(Stella.SYM_STELLA_JAVA_STANDARD_ERROR);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
    else {
      if (Stella_Object.javaStreamIsStandardOutputP(tree.rest.value) &&
          false) {
        tree.secondSetter(Stella.SYM_STELLA_JAVA_STANDARD_OUT);
      }
      else {
        tree.secondSetter(Stella_Object.javaTranslateATree(tree.rest.value));
      }
    }
    { Cons args = tree.rest.rest;
      StandardObject arg1Type = Stella_Object.walkedExpressionType(args.value);
      StandardObject arg2Type = Stella_Object.walkedExpressionType(args.rest.value);

      Cons.javaTranslateListOfTrees(args);
      if ((!(args.rest == Stella.NIL)) &&
          ((!(arg1Type == Stella.SGT_STELLA_STRING)) &&
           (!(arg2Type == Stella.SGT_STELLA_STRING)))) {
        if (StandardObject.subTypeSpecOfP(arg1Type, Stella.SGT_STELLA_OBJECT)) {
          args.firstSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("Object"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("toString"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(args.value, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Stella.NIL), Stella.NIL)))))));
        }
        else if (StandardObject.subTypeSpecOfP(arg2Type, Stella.SGT_STELLA_OBJECT)) {
          args.secondSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("Object"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("toString"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(args.rest.value, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Stella.NIL), Stella.NIL)))))));
        }
        else {
          args.rest = Cons.cons(args.value, args.rest);
          args.firstSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_LITERAL, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
      return (tree);
    }
  }

  public static Stella_Object javaTranslateIgnoreTree(Cons tree) {
    tree = tree;
    return (Stella.javaTranslateNull());
  }

  public static Stella_Object javaTranslateTheCode(Cons tree) {
    { Cons otree = null;
      MethodSlot fn = null;
      String classname = "";
      String functionname = "";

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.rest.value));

        if (testValue000 == Stella.KWD_FUNCTION) {
          fn = Symbol.lookupFunction(((Symbol)(tree.rest.rest.value)));
          if (!(fn != null)) {
            fn = ((MethodSlot)(tree.fourth()));
          }
          if (!(fn != null)) {
            {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't translate the-code form for function `" + tree.rest.rest.value + "'");
              Stella.STANDARD_WARNING.nativeStream.println(" because it there is no corresponding function object");
            }
;
            return (Stella.javaTranslateNull());
          }
          { StringWrapper value000 = null;
            StringWrapper value001 = null;

            { Object [] caller_MV_returnarray = new Object[1];

              value000 = MethodSlot.javaYieldTranslatedClassAndFunctionNames(fn, caller_MV_returnarray);
              value001 = ((StringWrapper)(caller_MV_returnarray[0]));
            }
            {
              classname = value000.wrapperValue;
              functionname = value001.wrapperValue;
            }
          }
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(Stella.javaYieldNativeClassName()), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("find_java_method"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(StringWrapper.wrapString(classname), Cons.cons(Cons.cons(StringWrapper.wrapString(functionname), Cons.cons(MethodSlot.javaTranslateParamTypeSpecifications(fn, fn.slotOwner), Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
        }
        else if (testValue000 == Stella.KWD_METHOD) {
          fn = ((MethodSlot)(Stella_Class.lookupSlot(((Stella_Class)(((Surrogate)(tree.rest.rest.value)).surrogateValue)), ((Symbol)(tree.fourth())))));
          if (!(fn != null)) {
            {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't translate the-code form for method `" + tree.fourth() + "'");
              Stella.STANDARD_WARNING.nativeStream.println(" because it there is no corresponding function object");
            }
;
            return (Stella.javaTranslateNull());
          }
          { Object [] caller_MV_returnarray = new Object[1];

            classname = StandardObject.javaYieldTranslatedClassAndMethodNames(((StandardObject)(tree.rest.rest.value)), fn, caller_MV_returnarray);
            functionname = ((String)(((StringWrapper)(caller_MV_returnarray[0])).wrapperValue));
          }
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(Stella.javaYieldNativeClassName()), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("find_java_method"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(StringWrapper.wrapString(classname), Cons.cons(Cons.cons(StringWrapper.wrapString(functionname), Cons.cons(MethodSlot.javaTranslateParamTypeSpecifications(fn, ((StandardObject)(tree.rest.rest.value))), Stella.NIL)), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (otree);
    }
  }

  public static Cons javaTranslateCallMethodCode(Cons tree) {
    { Cons signature = Cons.javaTranslateCodeSignature(((Cons)(tree.rest.value)));
      Stella_Object methodnameexpr = Stella_Object.javaTranslateATree(tree.rest.rest.value);
      StandardObject primaryreturntype = ((StandardObject)(((Cons)(((Cons)(tree.rest.value)).value)).value));
      Stella_Object theobject = tree.rest.rest.rest.value;
      Cons methodargs = tree.rest.rest.rest.rest;
      Cons otree = null;

      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CODE_CALL, Cons.cons(signature, Cons.cons(Cons.cons(methodnameexpr, Cons.cons(Stella_Object.javaTranslateATree(theobject), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.javaTranslateActualParametersWithNativeWrappers(methodargs, ((Cons)(tree.rest.value)).rest.rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL))), Stella.NIL))));
      return (Cons.javaTranslateObjectToReturnType(otree, primaryreturntype));
    }
  }

  public static Cons javaTranslateCallFunctionCode(Cons tree) {
    { Cons signature = Cons.javaTranslateCodeSignature(((Cons)(tree.rest.value)));
      Stella_Object functionnameexpr = Stella_Object.javaTranslateATree(tree.rest.rest.value);
      Cons functionargs = tree.rest.rest.rest;
      StandardObject primaryreturntype = ((StandardObject)(((Cons)(((Cons)(tree.rest.value)).value)).value));
      Cons otree = null;

      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCALL, Cons.cons(signature, Cons.cons(Cons.cons(functionnameexpr, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.javaTranslateActualParametersWithNativeWrappers(functionargs, ((Cons)(tree.rest.value)).rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)), Stella.NIL))));
      return (Cons.javaTranslateObjectToReturnType(otree, primaryreturntype));
    }
  }

  public static Cons javaTranslateObjectToReturnType(Cons tree, StandardObject returntype) {
    if (StandardObject.javaLiteralP(returntype)) {
      return (Cons.javaWrapWithNativeValueExtraction(tree, returntype));
    }
    else if ((returntype == Stella.SGT_STELLA_STRING) ||
        (returntype == Stella.SGT_STELLA_MUTABLE_STRING)) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(tree, Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(returntype), Stella.NIL), Stella.NIL)))));
    }
    else if (returntype == Stella.SGT_STELLA_VOID) {
      return (tree);
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(tree, Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(returntype), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaWrapWithNativeValueExtraction(Cons tree, StandardObject primaryreturntype) {
    { StringWrapper wrappertype = null;
      StringWrapper extractorname = null;

      { Object [] caller_MV_returnarray = new Object[1];

        wrappertype = StandardObject.javaNativeLiteralWrapperNames(primaryreturntype, caller_MV_returnarray);
        extractorname = ((StringWrapper)(caller_MV_returnarray[0]));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(extractorname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(tree, Cons.cons(Cons.cons(wrappertype, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))))));
    }
  }

  public static Cons javaTranslateActualParametersWithNativeWrappers(Cons trees, Cons parametertypes) {
    { Cons cursor = trees;
      Cons typecursor = parametertypes;

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.javaTranslateWithNativeWrapper(cursor.value, ((StandardObject)(typecursor.value)));
        cursor = cursor.rest;
        typecursor = typecursor.rest;
      }
      return (trees);
    }
  }

  public static Cons javaTranslateCodeSignature(Cons signature) {
    { Cons translatedreturntypes = Stella.NIL;
      Cons translatedparametertypes = Stella.NIL;

      { Stella_Object returntype = null;
        Cons iter000 = ((Cons)(signature.value));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          returntype = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              if (translatedreturntypes == Stella.NIL) {
                translatedreturntypes = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(translatedreturntypes, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object parametertype = null;
        Cons iter001 = signature.rest;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parametertype = iter001.value;
          if (collect001 == null) {
            {
              collect001 = Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              if (translatedparametertypes == Stella.NIL) {
                translatedparametertypes = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(translatedparametertypes, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_SIGNATURE, Cons.cons(translatedreturntypes, Cons.cons(Cons.cons(translatedparametertypes, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateMvFunctionCall(Cons functioncall, Symbol mvvectorname) {
    return (((Cons)(Stella_Object.javaTranslateATree(functioncall.concatenate(Cons.cons(mvvectorname, Stella.NIL), Stella.NIL)))));
  }

  public static Cons javaTranslateMvSetq(Cons tree) {
    { Cons variables = ((Cons)(tree.rest.value));
      Cons functioncall = ((Cons)(tree.rest.rest.value));
      Cons mvassignments = Stella.NIL;
      Cons otree = null;
      Cons otherreturntypes = Stella.NIL;
      Cons mvreturnedvalue = Stella.NIL;

      if (functioncall.value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
        otherreturntypes = Symbol.lookupFunction(((Symbol)(functioncall.rest.value))).methodReturnTypeSpecifiers().rest();
      }
      else {
        otherreturntypes = ((MethodSlot)(Stella_Class.lookupSlot(((Stella_Class)(((Surrogate)(functioncall.rest.value)).surrogateValue)), ((Symbol)(functioncall.rest.rest.value))))).methodReturnTypeSpecifiers().rest();
      }
      { Stella_Object variable = null;
        Cons iter000 = variables.rest;
        int currentindex = Stella.NULL_INTEGER;
        int iter001 = 0;
        Stella_Object returntype = null;
        Cons iter002 = otherreturntypes;

        for (;(!(iter000 == Stella.NIL)) &&
                  (!(iter002 == Stella.NIL)); 
              iter000 = iter000.rest,
              iter001 = iter001 + 1,
              iter002 = iter002.rest) {
          variable = iter000.value;
          currentindex = iter001;
          returntype = iter002.value;
          mvreturnedvalue = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_AREF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("caller_MV_returnarray"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(IntegerWrapper.wrapInteger(currentindex), Cons.cons(Stella.NIL, Stella.NIL)))));
          if (Surrogate.subtypeOfP(StandardObject.typeSpecToBaseType(((StandardObject)(returntype))), Stella.SGT_STELLA_LITERAL)) {
            mvreturnedvalue = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SLOT_VALUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(mvreturnedvalue, Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(StandardObject.typeSpecToBaseType(((StandardObject)(returntype))).typeToWrappedType().yieldTypeSpecifier()), Stella.NIL), Stella.NIL)))), Cons.cons(StringWrapper.wrapString("wrapperValue"), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
          mvassignments = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(Stella_Object.javaTranslateATree(variable), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CAST, Cons.cons(mvreturnedvalue, Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(returntype))), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), mvassignments);
        }
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(Cons.cons(Cons.cons(StandardObject.javaTranslateArrayOfTypeSpec(Stella.SGT_STELLA_NATIVE_OBJECT_POINTER, false), Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("caller_MV_returnarray"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE_ARRAY, Cons.cons(StandardObject.javaTranslateTypeSpec(Stella.SGT_STELLA_NATIVE_OBJECT_POINTER), Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(otherreturntypes.length()), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(Stella_Object.javaTranslateATree(variables.value), Cons.cons(Cons.cons(Cons.javaTranslateMvFunctionCall(functioncall, Stella.SYM_STELLA_caller_MV_returnarray), Stella.NIL), Stella.NIL)))), Cons.cons(mvassignments.reverse().concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      return (otree);
    }
  }

  public static Cons javaTranslateNewArray(Cons tree) {
    { ParametricTypeSpecifier arraytype = ((ParametricTypeSpecifier)(tree.rest.value));
      Stella_Object initialelement = tree.rest.rest.value;
      Cons dimensions = Cons.javaTranslateListOfTrees(tree.rest.rest.rest);
      StandardObject elementtype = StandardObject.extractParameterType(arraytype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);

      initialelement = initialelement;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE_ARRAY, Cons.cons(StandardObject.javaTranslateTypeSpec(elementtype), Cons.cons(dimensions.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateSysNew(Cons tree) {
    { StandardObject typespec = ((StandardObject)(tree.rest.value));

      if (StandardObject.arrayTypeSpecifierP(typespec)) {
        return (Cons.javaTranslateNewArray(tree));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StandardObject.javaTranslateTypeSpecForFunction(typespec), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateName(Stella_Class.yieldConstructorName(StandardObject.typeSpecToClass(typespec))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.javaTranslateActualParameters(tree.rest.rest), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
    }
  }

  public static Cons javaTranslateMakeTree(Cons tree) {
    { Stella_Class renamed_Class = ((Symbol)(tree.rest.value)).getStellaClass(true);
      StringWrapper classname = ((((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null) ? StringWrapper.wrapString(renamed_Class.javaNativeType()) : GeneralizedSymbol.javaTranslateClassName(((GeneralizedSymbol)(tree.rest.value))));
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(classname, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.javaTranslateActualParameters(tree.rest.rest), Cons.cons(Stella.NIL, Stella.NIL)))));

      return (otree);
    }
  }

  public static Cons javaTranslateUnlessTree(Cons tree) {
    { Stella_Object test = Stella_Object.javaTranslateATree(tree.rest.value);
      Cons body = Cons.javaTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_UNLESS, Cons.cons(test, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateWhenTree(Cons tree) {
    { Stella_Object test = Stella_Object.javaTranslateATree(tree.rest.value);
      Cons body = Cons.javaTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_WHEN, Cons.cons(test, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateChooseTree(Cons tree) {
    { Stella_Object test = tree.rest.value;
      Stella_Object truebody = tree.rest.rest.value;
      Stella_Object falsebody = tree.rest.rest.rest.value;

      tree.rest.rest = Stella.NIL;
      return (Cons.javaTranslateOperatorCall(Cons.cons(StringWrapper.wrapString("?"), Cons.cons(StringWrapper.wrapString(":"), Stella.NIL)), Cons.cons(test, Cons.cons(truebody, Cons.cons(falsebody, Stella.NIL))), 3));
    }
  }

  public static Cons javaTranslateWhile(Cons tree) {
    { Object old$JavaLoopName$000 = Stella.$JAVA_LOOP_NAME$.get();
      Object old$JavaLoopNameUsedP$000 = Stella.$JAVA_LOOP_NAME_USEDp$.get();

      try {
        Native.setSpecial(Stella.$JAVA_LOOP_NAME$, Stella.localGensym("LOOP"));
        Native.setBooleanSpecial(Stella.$JAVA_LOOP_NAME_USEDp$, false);
        { Stella_Object test = Stella_Object.javaTranslateATree(tree.rest.value);
          Cons body = Cons.javaTranslateListOfTrees(tree.rest.rest);

          tree.rest.rest = Stella.NIL;
          if (((Boolean)(Stella.$JAVA_LOOP_NAME_USEDp$.get())).booleanValue()) {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_NAMED_STATEMENT, Cons.cons(Stella_Object.javaTranslateATree(((Symbol)(Stella.$JAVA_LOOP_NAME$.get()))), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_WHILE, Cons.cons(test, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))));
          }
          else {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_WHILE, Cons.cons(test, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))));
          }
        }

      } finally {
        Stella.$JAVA_LOOP_NAME_USEDp$.set(old$JavaLoopNameUsedP$000);
        Stella.$JAVA_LOOP_NAME$.set(old$JavaLoopName$000);
      }
    }
  }

  public static Cons javaTranslateCondTree(Cons tree) {
    { Cons otherwisecondition = null;
      Cons conditions = Stella.NIL;

      { Stella_Object condition = null;
        Cons iter000 = tree.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          condition = iter000.value;
          if (Stella_Object.safePrimaryType(condition) == Stella.SGT_STELLA_CONS) {
            { Cons condition000 = ((Cons)(condition));

              if (condition000.value == Stella.SYM_STELLA_OTHERWISE) {
                otherwisecondition = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
              }
              else {
                conditions = Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(condition000.value), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), conditions);
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(condition) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_COND, Cons.cons(otherwisecondition, Cons.cons(Cons.cons(conditions.reverse(), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateCaseTree(Cons tree) {
    { Cons otherwisecondition = null;
      Cons conditions = Stella.NIL;
      Stella_Object keyform = null;
      boolean symbolcasep = false;

      symbolcasep = Stella_Object.javaSymbolCaseP(tree.rest.value);
      keyform = Stella_Object.javaTranslateATree(tree.rest.value);
      { Stella_Object condition = null;
        Cons iter000 = tree.rest.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          condition = iter000.value;
          if (Stella_Object.safePrimaryType(condition) == Stella.SGT_STELLA_CONS) {
            { Cons condition000 = ((Cons)(condition));

              if (condition000.value == Stella.SYM_STELLA_OTHERWISE) {
                otherwisecondition = Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL));
              }
              else {
                conditions = Cons.cons(Cons.javaTranslateCondition(condition000, symbolcasep), conditions);
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(condition) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_CASE, Cons.cons(keyform, Cons.cons(Cons.cons(otherwisecondition, Cons.cons(conditions.reverse(), Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateCondition(Cons condition, boolean symbolcasep) {
    { Cons translatedactions = Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(condition.rest).concatenate(Stella.NIL, Stella.NIL));
      Stella_Object keys = condition.value;
      Stella_Object translatedkeys = null;
      Cons translatedkeyslist = Stella.NIL;

      if (symbolcasep) {
        if (Stella_Object.consP(keys)) {
          {
            { Stella_Object key = null;
              Cons iter000 = ((Cons)(keys));
              Cons collect000 = null;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                key = iter000.value;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(Stella.javaYieldSymbolIdForm(((IntegerWrapper)(key)).wrapperValue), Stella.NIL);
                    if (translatedkeyslist == Stella.NIL) {
                      translatedkeyslist = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(translatedkeyslist, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(Stella.javaYieldSymbolIdForm(((IntegerWrapper)(key)).wrapperValue), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            translatedkeys = translatedkeyslist;
          }
        }
        else {
          translatedkeys = Stella.javaYieldSymbolIdForm(((IntegerWrapper)(keys)).wrapperValue);
        }
      }
      else {
        translatedkeys = (Stella_Object.consP(keys) ? Cons.javaTranslateListOfTrees(((Cons)(keys))) : Stella_Object.javaTranslateATree(keys));
      }
      return (Cons.cons(translatedkeys, Cons.cons(translatedactions, Stella.NIL)));
    }
  }

  public static Cons javaTranslateIfTree(Cons tree) {
    { Stella_Object test = Stella_Object.javaTranslateATree(tree.rest.value);
      Cons truebody = ((Cons)(Stella_Object.javaTranslateATree(tree.rest.rest.value)));
      Cons falsebody = ((Cons)(Stella_Object.javaTranslateATree(tree.rest.rest.rest.value)));

      tree.rest.rest = Stella.NIL;
      if (Stella_Object.consP(truebody.value) &&
          (!(truebody.rest == Stella.NIL))) {
        truebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, truebody.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else {
        truebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(truebody, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      if (Stella_Object.consP(falsebody.value) &&
          (!(falsebody.rest == Stella.NIL))) {
        falsebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, falsebody.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else {
        falsebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(falsebody, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IF, Cons.cons(test, Cons.cons(Cons.cons(truebody, Cons.cons(falsebody, Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons javaTranslateContinue(Cons tree) {
    if (((Symbol)(Stella.$JAVA_LOOP_NAME$.get())) == null) {
      Stella.breakProgram("No loop name in (CONTINUE)");
    }
    Native.setBooleanSpecial(Stella.$JAVA_LOOP_NAME_USEDp$, true);
    tree.firstSetter(Stella.SYM_STELLA_JAVA_CONTINUE);
    tree.rest = Cons.cons(Stella_Object.javaTranslateATree(((Symbol)(Stella.$JAVA_LOOP_NAME$.get()))), Stella.NIL);
    return (tree);
  }

  public static Cons javaTranslateBreak(Cons tree) {
    if (((Symbol)(Stella.$JAVA_LOOP_NAME$.get())) == null) {
      Stella.breakProgram("No loop name in (BREAK)");
    }
    Native.setBooleanSpecial(Stella.$JAVA_LOOP_NAME_USEDp$, true);
    tree.firstSetter(Stella.SYM_STELLA_JAVA_BREAK);
    tree.rest = Cons.cons(Stella_Object.javaTranslateATree(((Symbol)(Stella.$JAVA_LOOP_NAME$.get()))), Stella.NIL);
    return (tree);
  }

  public static Cons javaTranslateReturnTree(Cons tree) {
    { Cons otree = null;
      Cons returnassignments = Stella.NIL;
      Cons methodotherreturntypes = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).methodReturnTypeSpecifiers().rest();
      Stella_Object returnexpression = null;
      Cons translatedreturnexpression = Stella.NIL;
      Cons mvreturnparametertranslation = Stella.NIL;

      { Stella_Object exp = null;
        Cons iter000 = tree.rest.rest;
        int parameterindex = Stella.NULL_INTEGER;
        int iter001 = 0;
        StandardObject parametertype = null;
        Cons iter002 = methodotherreturntypes;

        for (;(!(iter000 == Stella.NIL)) &&
                  (!(iter002 == Stella.NIL)); 
              iter000 = iter000.rest,
              iter001 = iter001 + 1,
              iter002 = iter002.rest) {
          exp = iter000.value;
          parameterindex = iter001;
          parametertype = ((StandardObject)(iter002.value));
          if (Surrogate.subtypeOfP(StandardObject.typeSpecToBaseType(parametertype), Stella.SGT_STELLA_LITERAL)) {
            mvreturnparametertranslation = ((Cons)(Stella_Object.javaTranslateATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_FUNCTION, Cons.cons(Surrogate.lookupLiteralTypeInfo(StandardObject.typeSpecToBaseType(parametertype), Stella.KWD_WRAP_FUNCTION), Cons.cons(Cons.cons(exp, Stella.NIL), Stella.NIL)))))));
          }
          else {
            mvreturnparametertranslation = ((Cons)(Stella_Object.javaTranslateATree(exp)));
          }
          returnassignments = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_AREF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("MV_returnarray"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(IntegerWrapper.wrapInteger(parameterindex), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(mvreturnparametertranslation, Cons.cons(Stella.NIL, Stella.NIL))))), returnassignments);
        }
      }
      returnassignments = returnassignments.reverse();
      returnexpression = tree.rest.value;
      if ((methodotherreturntypes.length() > 0) &&
          ((tree.rest.rest == Stella.NIL) &&
           (Stella_Object.consP(returnexpression) &&
            ((((Cons)(returnexpression)).value != null) &&
             ((((Cons)(returnexpression)).value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) ||
              (((Cons)(returnexpression)).value == Stella.SYM_STELLA_SYS_CALL_METHOD)))))) {
        translatedreturnexpression = Cons.javaTranslateMvFunctionCall(((Cons)(returnexpression)), Stella.SYM_STELLA_MV_returnarray);
      }
      else {
        translatedreturnexpression = ((Cons)(Stella_Object.javaTranslateATree(returnexpression)));
      }
      if (returnassignments == Stella.NIL) {
        if (tree.rest == Stella.NIL) {
          otree = Cons.cons(Stella.SYM_STELLA_JAVA_RETURN, Stella.NIL);
        }
        else {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_RETURN, Cons.cons(translatedreturnexpression, Cons.cons(Stella.NIL, Stella.NIL))));
        }
      }
      else {
        { String tempvarname = "_return_temp";

          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).computeReturnTypeSpec(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).slotOwner)), Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(tempvarname), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(translatedreturnexpression, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, returnassignments.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(tempvarname), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
      return (otree);
    }
  }

  public static Cons javaTranslateCast(Cons tree) {
    { Stella_Object expression = tree.rest.value;
      Surrogate type = StandardObject.typeSpecToBaseType(((StandardObject)(tree.rest.rest.value)));

      if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_NUMBER) &&
          Stella_Object.isaP(expression, Stella.SGT_STELLA_NUMBER_WRAPPER)) {
        return (((Cons)(Stella_Object.javaTranslateATree(NumberWrapper.coerceNumericConstant(((NumberWrapper)(expression)), type)))));
      }
      tree.firstSetter(Stella.SYM_STELLA_JAVA_CAST);
      tree.secondSetter(Stella_Object.javaTranslateATree(tree.rest.value));
      tree.thirdSetter(StandardObject.javaTranslateTypeSpec(((StandardObject)(tree.rest.rest.value))));
      return (tree);
    }
  }

  public static Cons javaTranslateLetTree(Cons tree) {
    { Cons odeclarations = Stella.NIL;
      Cons otree = null;

      { Stella_Object declaration = null;
        Cons iter000 = ((Cons)(tree.rest.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = iter000.value;
          { Cons d = ((Cons)(declaration));

            odeclarations = Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(d.rest.value))), Cons.cons(Stella_Object.javaTranslateATree(d.value), Cons.cons(Stella_Object.javaTranslateATree(d.rest.rest.value), Stella.NIL))), odeclarations);
          }
        }
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(odeclarations.reverse(), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL))));
      return (otree);
    }
  }

  public static Cons javaTranslateForeachTree(Cons tree) {
    { Object old$JavaLoopName$000 = Stella.$JAVA_LOOP_NAME$.get();
      Object old$JavaLoopNameUsedP$000 = Stella.$JAVA_LOOP_NAME_USEDp$.get();

      try {
        Native.setSpecial(Stella.$JAVA_LOOP_NAME$, Stella.localGensym("LOOP"));
        Native.setBooleanSpecial(Stella.$JAVA_LOOP_NAME_USEDp$, false);
        { Cons iteratorbindings = ((Cons)(tree.rest.value));
          Cons valuetrees = ((Cons)(tree.rest.rest.value));
          Cons nexttrees = ((Cons)(tree.fourth()));
          Stella_Object continuationtest = Stella_Object.javaTranslateATree(tree.fifth());
          Cons body = Cons.javaTranslateListOfTrees(tree.nthRest(5));
          Cons declarations = Stella.NIL;
          Cons valueassignments = Stella.NIL;
          Cons nextassignments = Stella.NIL;
          Cons variables = Stella.NIL;

          { Cons binding = null;
            Cons iter000 = iteratorbindings;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              binding = ((Cons)(iter000.value));
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Cons.consList(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(binding.rest.value))), Cons.cons(Stella_Object.javaTranslateATree(binding.value), Cons.cons(Stella_Object.javaTranslateATree(binding.rest.rest.value), Stella.NIL)))), Stella.NIL);
                  if (declarations == Stella.NIL) {
                    declarations = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(declarations, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Cons.consList(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(binding.rest.value))), Cons.cons(Stella_Object.javaTranslateATree(binding.value), Cons.cons(Stella_Object.javaTranslateATree(binding.rest.rest.value), Stella.NIL)))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          { Cons tree000 = null;
            Cons iter001 = valuetrees;
            Cons collect001 = null;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              tree000 = ((Cons)(iter001.value));
              if (collect001 == null) {
                {
                  collect001 = Cons.cons(Stella_Object.javaTranslateATree(tree000), Stella.NIL);
                  if (valueassignments == Stella.NIL) {
                    valueassignments = collect001;
                  }
                  else {
                    Cons.addConsToEndOfConsList(valueassignments, collect001);
                  }
                }
              }
              else {
                {
                  collect001.rest = Cons.cons(Stella_Object.javaTranslateATree(tree000), Stella.NIL);
                  collect001 = collect001.rest;
                }
              }
            }
          }
          { Cons tree000 = null;
            Cons iter002 = nexttrees;
            Cons collect002 = null;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
              tree000 = ((Cons)(iter002.value));
              if (collect002 == null) {
                {
                  collect002 = Cons.cons(Stella_Object.javaTranslateATree(tree000), Stella.NIL);
                  if (nextassignments == Stella.NIL) {
                    nextassignments = collect002;
                  }
                  else {
                    Cons.addConsToEndOfConsList(nextassignments, collect002);
                  }
                }
              }
              else {
                {
                  collect002.rest = Cons.cons(Stella_Object.javaTranslateATree(tree000), Stella.NIL);
                  collect002 = collect002.rest;
                }
              }
            }
          }
          { Cons decl = null;
            Cons iter003 = declarations;
            Cons collect003 = null;

            for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
              decl = ((Cons)(iter003.value));
              if (collect003 == null) {
                {
                  collect003 = Cons.cons(decl.rest.value, Stella.NIL);
                  if (variables == Stella.NIL) {
                    variables = collect003;
                  }
                  else {
                    Cons.addConsToEndOfConsList(variables, collect003);
                  }
                }
              }
              else {
                {
                  collect003.rest = Cons.cons(decl.rest.value, Stella.NIL);
                  collect003 = collect003.rest;
                }
              }
            }
          }
          if (((Boolean)(Stella.$JAVA_LOOP_NAME_USEDp$.get())).booleanValue()) {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(declarations, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_NAMED_STATEMENT, Cons.cons(Stella_Object.javaTranslateATree(((Symbol)(Stella.$JAVA_LOOP_NAME$.get()))), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FOREACH, Cons.cons(variables, Cons.cons(Cons.cons(continuationtest, Cons.cons(valueassignments, Cons.cons(nextassignments, Cons.cons(body, Stella.NIL)))), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))));
          }
          else {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(declarations, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FOREACH, Cons.cons(variables, Cons.cons(Cons.cons(continuationtest, Cons.cons(valueassignments, Cons.cons(nextassignments, Cons.cons(body, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))));
          }
        }

      } finally {
        Stella.$JAVA_LOOP_NAME_USEDp$.set(old$JavaLoopNameUsedP$000);
        Stella.$JAVA_LOOP_NAME$.set(old$JavaLoopName$000);
      }
    }
  }

  public static Cons javaTranslateLoop(Cons tree) {
    { Object old$JavaLoopName$000 = Stella.$JAVA_LOOP_NAME$.get();
      Object old$JavaLoopNameUsedP$000 = Stella.$JAVA_LOOP_NAME_USEDp$.get();

      try {
        Native.setSpecial(Stella.$JAVA_LOOP_NAME$, Stella.localGensym("LOOP"));
        Native.setBooleanSpecial(Stella.$JAVA_LOOP_NAME_USEDp$, false);
        { Cons body = Cons.javaTranslateListOfTrees(tree.rest);

          if (((Boolean)(Stella.$JAVA_LOOP_NAME_USEDp$.get())).booleanValue()) {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_NAMED_STATEMENT, Cons.cons(Stella_Object.javaTranslateATree(((Symbol)(Stella.$JAVA_LOOP_NAME$.get()))), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_LOOP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))));
          }
          else {
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_LOOP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
        }

      } finally {
        Stella.$JAVA_LOOP_NAME_USEDp$.set(old$JavaLoopNameUsedP$000);
        Stella.$JAVA_LOOP_NAME$.set(old$JavaLoopName$000);
      }
    }
  }

  public static Cons javaTranslateWithProcessLock(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_WITH_PROCESS_LOCK, Cons.cons(Stella_Object.javaTranslateATree(tree.rest.value), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
  }

  public static Cons javaTranslateProgn(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.javaTranslateListOfTrees(tree.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Cons javaTranslateSysSlotValue(Cons tree) {
    { Surrogate objecttype = ((Surrogate)(tree.rest.value));
      Stella_Object objectref = tree.fourth();
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objecttype);
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SLOT_VALUE, Cons.cons(Stella_Object.javaTranslateATree(objectref), Cons.cons(Cons.cons(Symbol.javaTranslateName(slotname), Stella.NIL), Stella.NIL))));

      return (otree);
    }
  }

  public static Cons javaTranslateSysSlotValueSetter(Cons tree) {
    { Stella_Object objectref = tree.fourth();
      Surrogate objecttype = ((Surrogate)(tree.rest.value));
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objecttype);
      Stella_Object valueref = Stella_Object.javaTranslateATree(tree.fifth());
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_SLOT_VALUE_SETTER, Cons.cons(Stella_Object.javaTranslateATree(objectref), Cons.cons(Cons.cons(Symbol.javaTranslateName(slotname), Cons.cons(valueref, Stella.NIL)), Stella.NIL))));

      tree.thirdSetter(null);
      tree.fourthSetter(null);
      tree.fifthSetter(null);
      return (otree);
    }
  }

  public static Stella_Object javaTranslateSysSetDefault(Cons tree) {
    { Symbol variablename = ((Symbol)(tree.rest.value));
      GlobalVariable globalvar = variablename.softPermanentify().lookupGlobalVariable();

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("setDefaultValue"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(variablename, false), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(Stella_Object.javaTranslateWithNativeWrapper(tree.rest.rest.value, ((((StandardObject)(KeyValueList.dynamicSlotValue(globalvar.dynamicSlots, Stella.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, null))) != null) ? ((StandardObject)(((StandardObject)(KeyValueList.dynamicSlotValue(globalvar.dynamicSlots, Stella.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, null))))) : globalvar.variableType)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))));
    }
  }

  public static Stella_Object javaTranslateSetqTree(Cons tree) {
    { Symbol variablename = ((Symbol)(tree.rest.value));
      GlobalVariable globalvar = variablename.softPermanentify().lookupGlobalVariable();

      if ((globalvar != null) &&
          globalvar.variableSpecialP) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(Stella.javaYieldNativeClassName()), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StandardObject.javaSpecialSetterName(GlobalVariable.globalVariableTypeSpec(globalvar)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(variablename, false), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.javaTranslateATree(tree.rest.rest.value), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ASSIGN, Cons.cons(Stella_Object.javaTranslateATree(tree.rest.value), Cons.cons(Cons.cons(Stella_Object.javaTranslateATree(tree.rest.rest.value), Stella.NIL), Stella.NIL)))));
      }
    }
  }

  public static Stella_Object javaTranslateBadSys(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(StringWrapper.wrapString("*** TRANSLATION FAILURE FROM " + Native.stringify(tree.rest.value)), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Cons javaTranslateTypedSys(Cons tree) {
    return (((Cons)(Stella_Object.javaTranslateATree(tree.rest.value))));
  }

  public static Cons javaTranslateVoidSys(Cons tree) {
    return (((Cons)(Stella_Object.javaTranslateATree(tree.rest.value))));
  }

  public static Cons javaTranslateHandleException(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_JAVA_CATCH);
    tree.secondSetter(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(((Cons)(tree.rest.value)).rest.value))), Cons.cons(Symbol.javaTranslateName(((Symbol)(((Cons)(tree.rest.value)).value))), Stella.NIL)));
    tree.rest.rest = Cons.javaTranslateListOfTrees(tree.rest.rest);
    return (tree);
  }

  public static Cons javaTranslateHandlerCase(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_JAVA_HANDLER_CASE);
    tree.rest = Cons.javaTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Cons javaTranslateSignal(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_JAVA_SIGNAL);
    tree.secondSetter(Stella_Object.javaTranslateATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(tree.rest.rest.value, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FILL_IN_STACK_TRACE, Cons.cons(tree.rest.value, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(tree.rest.rest.value, Cons.cons(Stella.NIL, Stella.NIL)))))));
    tree.rest.rest = Stella.NIL;
    return (tree);
  }

  public static Cons javaTranslateUnwindProtect(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_JAVA_UNWIND_PROTECT);
    tree.rest = Cons.javaTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Stella_Object javaTranslateInlineCallTree(Cons tree) {
    { Cons calltree = ((Cons)(tree.rest.value));
      Cons arguments = ((calltree.value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) ? calltree.nthRest(2) : calltree.nthRest(3));
      Cons tokenizedbody = Cons.tokenizeVerbatimMethodBody(calltree);

      if (tokenizedbody != null) {
        { List inlinedparameters = List.newList();
          String inlinedbody = null;
          boolean successP = true;

          { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

            try {
              Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
              { Stella_Object token = null;
                Cons iter000 = tokenizedbody;

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  token = iter000.value;
                  { Surrogate testValue000 = Stella_Object.safePrimaryType(token);

                    if (Surrogate.subtypeOfStringP(testValue000)) {
                      { StringWrapper token000 = ((StringWrapper)(token));

                        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(token000.wrapperValue);
                      }
                    }
                    else if (testValue000 == Stella.SGT_STELLA_CONS) {
                      { Cons token000 = ((Cons)(token));

                        { StringWrapper parameter = ((StringWrapper)(token000.value));
                          IntegerWrapper position = ((IntegerWrapper)(token000.rest.value));
                          Stella_Object argument = arguments.nth(position.wrapperValue);

                          if (!Stella_Object.sideEffectFreeExpressionP(argument)) {
                            if (inlinedparameters.memberP(parameter)) {
                              {
                                successP = false;
                                break loop000;
                              }
                            }
                            else {
                              inlinedparameters.insert(parameter);
                            }
                          }
                          if (!(Stella_Object.atomicExpressionP(argument))) {
                            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
                          }
                          Stella_Object.javaOutputStatement(Stella_Object.javaTranslateATree(Stella_Object.copyConsTree(argument)));
                          if (!(Stella_Object.atomicExpressionP(argument))) {
                            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
                          }
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
                }
              }
              inlinedbody = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();
              if (successP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper(inlinedbody), Cons.cons(Stella.NIL, Stella.NIL)))));
              }

            } finally {
              Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
            }
          }
        }
      }
      return (Stella_Object.javaTranslateATree(calltree));
    }
  }

  public static Cons javaTranslateVerbatimTree(Cons tree) {
    { Cons cursor = tree.rest;
      Stella_Object verbatimcode = null;

      while (!(cursor == Stella.NIL)) {
        if (cursor.value == Stella.KWD_JAVA) {
          verbatimcode = cursor.rest.value;
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_VERBATIM, Cons.cons(verbatimcode, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        cursor = cursor.rest.rest;
      }
      throw ((StellaException)(StellaException.newStellaException("Verbatim has no :java option").fillInStackTrace()));
    }
  }

  public static Cons javaTranslateSpecialTree(Cons tree) {
    { Cons savedeclarations = Stella.NIL;
      Cons setforms = Stella.NIL;
      Cons restoreforms = Stella.NIL;
      Cons otree = null;

      { Stella_Object declaration = null;
        Cons iter000 = ((Cons)(tree.rest.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = iter000.value;
          { Cons d = ((Cons)(declaration));
            Symbol specialvariablename = ((Symbol)(d.value));
            Stella_Object oldvaluevariable = Stella_Object.javaTranslateATree(Stella.localGensym("OLD-" + specialvariablename.symbolName));

            savedeclarations = Cons.cons(Cons.cons(StringWrapper.wrapString("Object"), Cons.cons(oldvaluevariable, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("get"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(specialvariablename, false), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))))), Stella.NIL))), savedeclarations);
            setforms = Cons.cons(Stella_Object.javaTranslateATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(d.value, Cons.cons(Cons.cons(d.rest.rest.value, Stella.NIL), Stella.NIL))))), setforms);
            restoreforms = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_METHOD_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString(""), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(StringWrapper.wrapString("set"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_IDENT, Cons.cons(Symbol.javaTranslateGlobalName(specialvariablename, false), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_ACTUALS, Cons.cons(oldvaluevariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))), restoreforms);
          }
        }
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(savedeclarations.reverse(), Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_UNWIND_PROTECT, Cons.cons(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, setforms.reverse().concatenate(Cons.javaTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(restoreforms.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL))));
      return (otree);
    }
  }

  public static Cons javaTranslateListOfTrees(Cons trees) {
    { Cons cursor = trees;

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.javaTranslateATree(cursor.value);
        cursor = cursor.rest;
      }
      return (trees);
    }
  }

  public static Cons wrapMethodBodyWithJavaAuxiliaryDeclarations(Cons methodbody, Cons declarations) {
    { Cons odeclarations = Stella.NIL;
      Cons otree = null;

      declarations = declarations.reverse();
      { Stella_Object declaration = null;
        Cons iter000 = declarations;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = iter000.value;
          { Cons d = ((Cons)(declaration));

            odeclarations = Cons.cons(Cons.cons(StandardObject.javaTranslateTypeSpec(((StandardObject)(d.rest.value))), Cons.cons(Stella_Object.javaTranslateATree(d.value), (((d.rest.rest.value != null) ? Cons.consList(Cons.cons(Stella_Object.javaTranslateATree(d.rest.rest.value), Stella.NIL)) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL))), odeclarations);
          }
        }
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_JAVA_BLOCK, Cons.cons(odeclarations.reverse(), Cons.cons(Cons.cons(methodbody, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      return (otree);
    }
  }

  public static void cppOutputExternC(Cons statement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("extern \"C\" ");
    Stella_Object.cppOutputStatement(statement);
  }

  public static void cppOutputFunction(Cons function) {
    { Stella_Object body = function.fourth();
      Cons basemembers = ((Cons)(function.fifth()));

      Cons.cppOutputFunctionSignature(function);
      if (basemembers != null) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" : ");
        { Stella_Object member = null;
          Cons iter000 = basemembers;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            member = iter000.value;
            Stella_Object.cppOutputStatement(member);
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" {");
      Stella.cppBumpIndent();
      Stella_Object.cppOutputStatement(body);
      Stella.cppUnbumpIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
  }

  public static void cppOutputFunctionSignature(Cons function) {
    { String result000 = null;

      { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
          {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(function.rest.value)).wrapperValue);
            Cons.cppOutputFormalParameters(((Cons)(function.rest.rest.value)));
          }
          result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

        } finally {
          Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        }
      }
      { String baresignature = result000;

        Stella_Object.cppOutputTypedEntity(function.value, StringWrapper.wrapString(baresignature), null);
      }
    }
  }

  public static void cppOutputDefprint(Cons defprint) {
    Cons.cppOutputDefprintSignature(defprint);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(" {");
    Stella.cppBumpIndent();
    { Object old$OutputtingdefprintP$000 = Stella.$OUTPUTTINGDEFPRINTp$.get();

      try {
        Native.setBooleanSpecial(Stella.$OUTPUTTINGDEFPRINTp$, true);
        Stella_Object.cppOutputStatement(defprint.rest.value);

      } finally {
        Stella.$OUTPUTTINGDEFPRINTp$.set(old$OutputtingdefprintP$000);
      }
    }
    Stella.cppUnbumpIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
  }

  public static void cppOutputDefprintSignature(Cons defprint) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("std::ostream& operator << (std::ostream& stream, ");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(defprint.value)).wrapperValue);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" self)");
  }

  public static void cppOutputFunctionCall(Cons functioncall) {
    Stella_Object.cppOutputStatement(functioncall.value);
    Stella_Object.cppOutputStatement(functioncall.rest.value);
  }

  public static void cppOutputReferencedMethodCall(Cons methodcall) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(methodcall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(".");
    Stella_Object.cppOutputStatement(methodcall.rest.value);
    Stella_Object.cppOutputStatement(methodcall.fourth());
  }

  public static void cppOutputMethodCall(Cons methodcall) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(methodcall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("->");
    Stella_Object.cppOutputStatement(methodcall.rest.value);
    Stella_Object.cppOutputStatement(methodcall.fourth());
  }

  public static void cppOutputMethodSetterCall(Cons methodsettercall) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(methodsettercall.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("->");
    Stella_Object.cppOutputStatement(methodsettercall.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("_setter(");
    Stella_Object.cppOutputStatement(methodsettercall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void cppOutputActualParameters(Cons parameters) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    if (parameters.value != null) {
      Stella_Object.cppOutputOneActualParameter(parameters.value);
    }
    { Stella_Object parameter = null;
      Cons iter000 = parameters.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        parameter = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
        Stella_Object.cppOutputOneActualParameter(parameter);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
  }

  public static void cppOutputFormalParameters(Cons parameters) {
    { int nParameters = parameters.length();
      boolean variableArgumentsP = false;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      { Cons parameter = null;
        Cons iter000 = parameters;
        int n = Stella.NULL_INTEGER;
        int iter001 = 1;
        int upperBound000 = nParameters;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;(!(iter000 == Stella.NIL)) &&
                  (unboundedP000 ||
                   (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
          parameter = ((Cons)(iter000.value));
          n = iter001;
          if (n == nParameters) {
            {
              variableArgumentsP = parameter.value == Stella.SYM_STELLA_CPP_VAR_ARGS;
              Stella_Object.cppOutputTypedEntity((variableArgumentsP ? StringWrapper.wrapString("int") : parameter.value), parameter.rest.value, null);
              if (variableArgumentsP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ...");
              }
            }
          }
          else {
            {
              Stella_Object.cppOutputTypedEntity(parameter.value, parameter.rest.value, null);
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
            }
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void cppOutputClass(Cons classdef) {
    if (Stella.cppOutputTemplateClassesP()) {
      Cons.cppOutputTemplateParameters(((Cons)(classdef.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("class " + ((StringWrapper)(classdef.value)).wrapperValue + " ");
    if (!(((Cons)(classdef.rest.rest.value)) == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(": public ");
      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("virtual ");
      }
      else {
      }
      Cons.cppOutputDerivedClasses(((Cons)(classdef.rest.rest.value)));
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    { Stella_Object statement = null;
      Cons iter000 = classdef.nthRest(4);

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        Stella_Object.cppOutputStatement(statement);
      }
    }
    {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("};");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
    }
;
    StringWrapper.cppOutputStaticMemberVars(((StringWrapper)(classdef.value)), ((Cons)(classdef.fourth())));
  }

  public static void cppOutputTemplateParameters(Cons parameters) {
    if (!(parameters == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("template <");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("class " + ((StringWrapper)(parameters.value)).wrapperValue);
      { Stella_Object parameter = null;
        Cons iter000 = parameters.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          parameter = iter000.value;
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("class " + ((StringWrapper)(parameter)) + ", ");
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(">");
    }
  }

  public static void cppOutputDerivedClasses(Cons classlist) {
    if (classlist.value != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(classlist.value)).wrapperValue);
    }
    { Stella_Object renamed_Class = null;
      Cons iter000 = classlist.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Class = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", public ");
        if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("virtual ");
        }
        else {
        }
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(((StringWrapper)(renamed_Class)).wrapperValue);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
  }

  public static void cppOutputWithProcessLock(Cons synch) {
    { OutputStringStream s = OutputStringStream.newOutputStringStream();

      { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

        try {
          Native.setSpecial(Stella.$CURRENT_STREAM$, s);
          Stella_Object.cppOutputStatement(synch.value);

        } finally {
          Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
        }
      }
      StringWrapper.cppOutputComment(StringWrapper.wrapString("Should be synchronized on process lock " + s.theStringReader()));
      Stella.cppIndent();
    }
    Cons.cppOutputProgn(((Cons)(synch.rest.value)));
  }

  public static void cppOutputBlock(Cons block) {
    { boolean firststatementP = true;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("{ ");
      Stella.cppBumpIndent();
      { Cons declaration = null;
        Cons iter000 = ((Cons)(block.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = ((Cons)(iter000.value));
          if (!(firststatementP)) {
            Stella.cppIndent();
          }
          firststatementP = false;
          Stella_Object.cppOutputTypedEntity(declaration.value, declaration.rest.value, declaration.rest.rest.value);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
      Stella_Object.cppOutputStatement(block.rest.value);
      Stella.cppUnbumpIndent();
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static void cppOutputProgn(Cons progn) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("{");
    Stella.cppBumpIndent();
    Stella_Object.cppOutputStatement(progn);
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void cppOutputSignature(Cons signature, boolean outputmethodclassP) {
    { StringWrapper methodclass = ((StringWrapper)(signature.value));
      Stella_Object returntype = signature.rest.value;
      StringWrapper name = ((StringWrapper)(signature.rest.rest.value));
      Stella_Object parameters = signature.fourth();

      { String result000 = null;

        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
            {
              if (outputmethodclassP &&
                  (methodclass != null)) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(methodclass.wrapperValue);
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("::");
              }
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(name.wrapperValue);
              Cons.cppOutputFormalParameters(((Cons)(parameters)));
            }
            result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }
        { String baresignature = result000;

          Stella_Object.cppOutputTypedEntity(returntype, StringWrapper.wrapString(baresignature), null);
        }
      }
    }
  }

  public static void cppOutputTypeExpression(Cons typeexpression) {
    { StringWrapper typeexpr = null;
      Cons iter000 = typeexpression;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        typeexpr = ((StringWrapper)(iter000.value));
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(typeexpr.wrapperValue + " ");
      }
    }
  }

  public static void cppOutputReturn(Cons returnstatement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("return");
    if (returnstatement != null) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" (");
      Stella_Object.cppOutputStatement(returnstatement);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void cppOutputStatementLine(Cons statement) {
    Stella_Object.cppOutputStatement(statement.value);
    { Stella_Object e = null;
      Cons iter000 = statement.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        e = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
        Stella_Object.cppOutputStatement(e);
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
  }

  public static void cppOutputTernaryOperator(Cons expression) {
    { Stella_Object arg1 = expression.value;
      StringWrapper op1 = ((StringWrapper)(expression.rest.value));
      Stella_Object arg2 = expression.rest.rest.value;
      StringWrapper op2 = ((StringWrapper)(expression.fourth()));
      Stella_Object arg3 = expression.fifth();
      String translatedarg = null;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      Stella_Object.cppMaybeOutputStatementWithParentheses(arg1);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op1.wrapperValue);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      { String result000 = null;

        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
            Stella_Object.cppMaybeOutputStatementWithParentheses(arg2);
            result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }
        translatedarg = result000;
      }
      if (translatedarg.charAt(0) == '"') {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(char*)");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(translatedarg);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op2.wrapperValue);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      { String result001 = null;

        { Object old$CurrentStream$001 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
            Stella_Object.cppMaybeOutputStatementWithParentheses(arg3);
            result001 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$001);
          }
        }
        translatedarg = result001;
      }
      if (translatedarg.charAt(0) == '"') {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(char*)");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(translatedarg);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    }
  }

  public static void cppOutputBinaryOperator(Cons expression) {
    Cons.cppHelpOutputBinaryOperator(expression, 0);
  }

  public static void cppHelpOutputBinaryOperator(Cons expression, int nestlevel) {
    { Stella_Object arg1 = expression.value;
      StringWrapper op = ((StringWrapper)(expression.rest.value));
      Stella_Object arg2 = expression.rest.rest.value;

      if (StringWrapper.cppNestedOperatorNeedsParenthesesP(op, arg1)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      if (Stella_Object.cppBinaryOperatorP(op)) {
        Cons.cppHelpOutputBinaryOperator(((Cons)(arg1)).rest, nestlevel + 1);
      }
      else {
        Stella_Object.cppOutputStatement(arg1);
      }
      if (StringWrapper.cppNestedOperatorNeedsParenthesesP(op, arg1)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op.wrapperValue);
      if (StringWrapper.cppIndentableBinaryOperatorP(op)) {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          Stella.cppIndent();
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("    ");
          { int i = Stella.NULL_INTEGER;
            int iter000 = 1;
            int upperBound000 = nestlevel;
            boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

            for (;unboundedP000 ||
                      (iter000 <= upperBound000); iter000 = iter000 + 1) {
              i = iter000;
              i = i;
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
            }
          }
        }
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
      }
      if (StringWrapper.cppNestedOperatorNeedsParenthesesP(op, arg2)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
      }
      if (Stella_Object.cppBinaryOperatorP(arg2)) {
        Cons.cppHelpOutputBinaryOperator(((Cons)(arg2)).rest, nestlevel + 1);
      }
      else {
        Stella_Object.cppOutputStatement(arg2);
      }
      if (StringWrapper.cppNestedOperatorNeedsParenthesesP(op, arg2)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
    }
  }

  public static void cppOutputUnaryOperator(Cons expression) {
    { StringWrapper op = null;
      Stella_Object arg = null;
      boolean postfixP = false;

      if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(expression.value))) {
        op = ((StringWrapper)(expression.value));
        arg = expression.rest.value;
      }
      else {
        op = ((StringWrapper)(expression.rest.value));
        arg = expression.value;
        postfixP = true;
      }
      if (!(postfixP)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op.wrapperValue);
      }
      Stella_Object.cppMaybeOutputStatementWithParentheses(arg);
      if (postfixP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(op.wrapperValue);
      }
    }
  }

  public static boolean cppAssignmentP(Cons statement) {
    return (statement.value == Stella.SYM_STELLA_CPP_ASSIGN);
  }

  public static void cppOutputPrintNativeStream(Cons exps) {
    { Stella_Object stream = exps.value;

      if (stream == Stella.SYM_STELLA_CPP_STANDARD_OUT) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("std::cout");
      }
      else if (stream == Stella.SYM_STELLA_CPP_STANDARD_ERROR) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("std::cerr");
      }
      else {
        if (!(((Boolean)(Stella.$OUTPUTTINGDEFPRINTp$.get())).booleanValue())) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("*(");
        }
        Stella_Object.cppOutputStatement(stream);
        if (!(((Boolean)(Stella.$OUTPUTTINGDEFPRINTp$.get())).booleanValue())) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
        }
      }
      Cons.cppOutputStreamPrintItems(exps.rest);
    }
  }

  public static void cppOutputPrintStream(Cons exps) {
    { Stella_Object stream = exps.value;

      if (stream == Stella.SYM_STELLA_CPP_STANDARD_OUT) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("std::cout");
      }
      else if (stream == Stella.SYM_STELLA_CPP_STANDARD_ERROR) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("std::cerr");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("get_ostream(");
        Stella_Object.cppOutputStatement(stream);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
      }
      Cons.cppOutputStreamPrintItems(exps.rest);
    }
  }

  public static void cppOutputStreamPrintItems(Cons items) {
    { Stella_Object e = null;
      Cons iter000 = items;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        e = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" << ");
        Stella_Object.cppMaybeOutputStatementWithParentheses(e);
      }
    }
  }

  public static void cppOutputStatements(Cons statementlist) {
    { Stella_Object statement = null;
      Cons iter000 = statementlist;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        statement = iter000.value;
        if (!(Cons.illegalCppStatementP(((Cons)(statement))))) {
          if (Cons.cppIndentStatementP(((Cons)(statement)))) {
            Stella.cppIndent();
          }
          Stella_Object.cppOutputStatement(statement);
          if (Cons.cppOutputSemicolonP(((Cons)(statement)))) {
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
          }
        }
      }
    }
  }

  public static boolean illegalCppStatementP(Cons statement) {
    if (statement != null) {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement.value));

        if ((testValue000 == Stella.SYM_STELLA_CPP_LITERAL) ||
            (testValue000 == Stella.SYM_STELLA_CPP_IDENT)) {
          return (true);
        }
        else {
        }
      }
    }
    return (false);
  }

  public static boolean cppIndentStatementP(Cons statement) {
    if (statement != null) {
      return (!Stella.getQuotedTree("((CPP_STATEMENTS) \"/STELLA\")", "/STELLA").memberP(statement.value));
    }
    else {
      return (false);
    }
  }

  public static boolean cppOutputSemicolonP(Cons statement) {
    if (statement != null) {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(statement.value));

        if ((testValue000 == Stella.SYM_STELLA_CPP_ASSIGN) ||
            ((testValue000 == Stella.SYM_STELLA_CPP_UNARY_OP) ||
             ((testValue000 == Stella.SYM_STELLA_CPP_BINARY_OP) ||
              ((testValue000 == Stella.SYM_STELLA_CPP_TERNARY_OP) ||
               ((testValue000 == Stella.SYM_STELLA_CPP_CAST) ||
                ((testValue000 == Stella.SYM_STELLA_CPP_FUNCALL) ||
                 ((testValue000 == Stella.SYM_STELLA_CPP_FUNCTION_CALL) ||
                  ((testValue000 == Stella.SYM_STELLA_CPP_FUNCTION_POINTER) ||
                   ((testValue000 == Stella.SYM_STELLA_CPP_MAKE) ||
                    ((testValue000 == Stella.SYM_STELLA_CPP_METHOD_CALL) ||
                     ((testValue000 == Stella.SYM_STELLA_CPP_METHOD_CODE_CALL) ||
                      ((testValue000 == Stella.SYM_STELLA_CPP_METHOD_POINTER) ||
                       ((testValue000 == Stella.SYM_STELLA_CPP_METHOD_SETTER_CALL) ||
                        ((testValue000 == Stella.SYM_STELLA_CPP_NEW) ||
                         ((testValue000 == Stella.SYM_STELLA_CPP_PRINT_NATIVE_STREAM) ||
                          ((testValue000 == Stella.SYM_STELLA_CPP_PRINT_STREAM) ||
                           ((testValue000 == Stella.SYM_STELLA_CPP_REFERENCED_METHOD_CALL) ||
                            ((testValue000 == Stella.SYM_STELLA_CPP_RETURN) ||
                             ((testValue000 == Stella.SYM_STELLA_CPP_SIGNAL) ||
                              ((testValue000 == Stella.SYM_STELLA_CPP_SLOT_VALUE_SETTER) ||
                               ((testValue000 == Stella.SYM_STELLA_CPP_THROW) ||
                                (testValue000 == Stella.SYM_STELLA_CPP_VERBATIM)))))))))))))))))))))) {
          return (true);
        }
        else {
        }
      }
    }
    return (false);
  }

  public void cppOutputLiteral() {
    { Cons cons = this;

      if (cons == Stella.NIL) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("NIL");
      }
      else {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(" + cons.value + " . ");
          cons.rest.cppOutputLiteral();
        }
      }
    }
  }

  public static void cppOutputMake(Cons statement) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("new ");
    Stella_Object.cppOutputStatement(statement.value);
    if (statement.rest.value != null) {
      Stella_Object.cppOutputStatement(statement.rest.value);
    }
  }

  public static void cppOutputSlotValueSetter(Cons statement) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(statement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("->" + ((StringWrapper)(statement.rest.value)).wrapperValue + " = ");
    Stella_Object.cppOutputStatement(statement.rest.rest.value);
  }

  public static void cppOutputReferencedSlotValue(Cons statement) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(statement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("." + ((StringWrapper)(statement.rest.value)).wrapperValue);
  }

  public static void cppOutputSlotValue(Cons statement) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(statement.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("->" + ((StringWrapper)(statement.rest.value)).wrapperValue);
  }

  public static void cppOutputForeach(Cons loop) {
    { Cons variables = ((Cons)(loop.value));
      int nofvariables = variables.length();
      Stella_Object continuationtest = loop.rest.value;
      Cons valueassignments = ((Cons)(loop.rest.rest.value));
      Cons nextassignments = ((Cons)(loop.fourth()));
      int nofnextassignments = nextassignments.length();
      Cons body = ((Cons)(loop.fifth()));
      boolean eolseparateexpressionsP = (nofvariables > 2) ||
          (((Integer)(Stella.$CPP_INDENT_CHARS$.get())).intValue() > 35);

      Stella.cppIndent();
      if (eolseparateexpressionsP) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("for  (");
      }
      else {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("for (");
      }
      Stella.cppBumpIndent();
      Stella.cppBumpIndent();
      Stella.cppBumpIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("; ");
      Stella_Object.cppOutputStatement(continuationtest);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("; ");
      if (!(nextassignments == Stella.NIL)) {
        if (eolseparateexpressionsP) {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        }
        { Stella_Object next = null;
          Cons iter000 = nextassignments;
          int i = Stella.NULL_INTEGER;
          int iter001 = 1;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            next = iter000.value;
            i = iter001;
            if (eolseparateexpressionsP) {
              Stella.cppIndent();
            }
            Stella_Object.cppOutputStatement(next);
            if (!(i == nofnextassignments)) {
              if (eolseparateexpressionsP) {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(",");
              }
              else {
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
              }
            }
          }
        }
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
      Stella.cppUnbumpIndent();
      Stella.cppUnbumpIndent();
      Cons.cppOutputStatements(Cons.cppFlattenStatements(valueassignments.concatenate(body, Stella.NIL)));
      Stella.cppUnbumpIndent();
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static void cppOutputWhile(Cons loop) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("while (");
    Stella_Object.cppOutputStatement(loop.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
    Stella_Object.cppOutputStatement(loop.rest.value);
  }

  public static void cppOutputLoop(Cons loop) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("for (;;) ");
    Stella_Object.cppOutputStatement(loop.value);
  }

  public static void cppOutputAssignment(Cons assignment) {
    Stella_Object.cppOutputStatement(assignment.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" = ");
    Stella_Object.cppOutputStatement(assignment.rest.value);
  }

  public static void cppOutputUnless(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (!(");
    Stella_Object.cppOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(")) {");
    Stella.cppBumpIndent();
    Stella_Object.cppOutputStatement(tree.rest.value);
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void cppOutputWhen(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
    Stella_Object.cppOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
    Stella.cppBumpIndent();
    Stella_Object.cppOutputStatement(tree.rest.value);
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
  }

  public static void cppOutputIf(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
    Stella_Object.cppOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
    if (Stella_Object.cppBlockP(tree.rest.value)) {
      Stella_Object.cppOutputStatement(tree.rest.value);
    }
    else {
      {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
        Stella.cppBumpIndent();
        Stella.cppIndent();
        Stella_Object.cppOutputStatement(tree.rest.value);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        Stella.cppUnbumpIndent();
      }
    }
    if (!(tree.rest.rest.value == null)) {
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else ");
      if (Stella_Object.cppBlockP(tree.rest.rest.value)) {
        Stella_Object.cppOutputStatement(tree.rest.rest.value);
      }
      else {
        {
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
          Stella.cppBumpIndent();
          Stella.cppIndent();
          Stella_Object.cppOutputStatement(tree.rest.rest.value);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
          Stella.cppUnbumpIndent();
        }
      }
    }
  }

  public static void cppOutputCond(Cons cond) {
    { Cons defaultcondition = ((Cons)(cond.value));
      Cons conditions = ((Cons)(cond.rest.value));
      Cons firstcondition = ((Cons)(conditions.value));
      Cons restconditions = conditions.rest;

      if ((defaultcondition != null) &&
          (conditions == Stella.NIL)) {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (TRUE) ");
        Stella_Object.cppOutputStatement(defaultcondition);
        return;
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("if (");
      Stella_Object.cppOutputStatement(firstcondition.value);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
      Stella_Object.cppOutputStatement(firstcondition.rest.value);
      { Stella_Object c = null;
        Cons iter000 = restconditions;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          c = iter000.value;
          { Cons condition = ((Cons)(c));

            Stella.cppIndent();
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else if (");
            Stella_Object.cppOutputStatement(condition.value);
            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(") ");
            Stella_Object.cppOutputStatement(condition.rest.value);
          }
        }
      }
      if (defaultcondition != null) {
        Stella.cppIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("else ");
        Stella_Object.cppOutputStatement(defaultcondition);
      }
    }
  }

  public static void cppOutputCase(Cons renamed_Case) {
    { Stella_Object keyform = renamed_Case.value;
      Stella_Object defaultcase = renamed_Case.rest.value;
      Stella_Object conditions = renamed_Case.rest.rest.value;

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("switch (");
      Stella_Object.cppOutputStatement(keyform);
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
      Stella.cppBumpIndent();
      { Cons c = null;
        Cons iter000 = ((Cons)(conditions));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          c = ((Cons)(iter000.value));
          { Cons condition = c;

            { Stella_Object cond = null;
              Cons iter001 = ((Cons)((Stella_Object.consP(((Cons)(condition.value)).value) ? condition.value : Cons.cons(condition.value, Stella.NIL))));

              for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                cond = iter001.value;
                Stella.cppIndent();
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("case ");
                Stella_Object.cppOutputStatement(cond);
                ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(": ");
              }
            }
            Stella.cppBumpIndent();
            Stella_Object.cppOutputStatement(condition.rest.value);
            Stella.cppUnbumpIndent();
            if (!(Cons.cppLastStatementIsReturnP(((Cons)(condition.rest.value))))) {
              Stella.cppIndent();
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("break;");
            }
          }
        }
      }
      if (!(defaultcase != null)) {
        System.err.print("Safety violation: INTERNAL ERROR: `cpp-output-case' expects an `otherwise' clause.");
      }
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("default:");
      Stella.cppBumpIndent();
      Stella_Object.cppOutputStatement(defaultcase);
      Stella.cppUnbumpIndent();
      if (!(Cons.cppLastStatementIsReturnP(((Cons)(defaultcase))))) {
        Stella.cppIndent();
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("break;");
      }
      Stella.cppUnbumpIndent();
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static boolean cppLastStatementIsReturnP(Cons statements) {
    { Stella_Object lastitem = statements.last();

      return (Stella_Object.consP(lastitem) &&
          (((Cons)(lastitem)).value == Stella.SYM_STELLA_CPP_RETURN));
    }
  }

  public static void cppOutputMethodCodeCall(Cons methodcall) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    Stella_Object.cppMaybeOutputStatementWithParentheses(methodcall.rest.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("->*(");
    Stella_Object.cppOutputStatement(methodcall.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" ");
    Stella_Object.cppOutputStatement(methodcall.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")) ");
    Stella_Object.cppOutputStatement(methodcall.fourth());
  }

  public static void cppOutputFuncall(Cons funcall) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
    Stella_Object.cppOutputStatement(funcall.value);
    Stella_Object.cppOutputStatement(funcall.rest.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
    Stella_Object.cppOutputStatement(funcall.rest.rest.value);
  }

  public static void cppOutputMethodCodeCallSignature(Cons signature) {
    { Cons returntypes = ((Cons)(signature.value));
      StringWrapper returntype = ((StringWrapper)(returntypes.value));
      String objecttype = ((StringWrapper)(signature.rest.value)).wrapperValue;
      Cons parametertypes = ((Cons)(signature.rest.rest.value));
      int nofparameters = parametertypes.length();

      { String result000 = null;

        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
            {
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" (");
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(objecttype);
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("::*) (");
              { StringWrapper partype = null;
                Cons iter000 = parametertypes;
                int i = Stella.NULL_INTEGER;
                int iter001 = 1;
                int upperBound000 = nofparameters;
                boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

                for (;(!(iter000 == Stella.NIL)) &&
                          (unboundedP000 ||
                           (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
                  partype = ((StringWrapper)(iter000.value));
                  i = iter001;
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(partype.wrapperValue);
                  if (i < nofparameters) {
                    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
                  }
                }
              }
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
            }
            result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }
        { String baresignature = result000;

          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
          Stella_Object.cppOutputTypedEntity(returntype, StringWrapper.wrapString(baresignature), null);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
        }
      }
    }
  }

  public static void cppOutputFuncallFunctionSignature(Cons signature) {
    { Cons returntypes = ((Cons)(signature.value));
      StringWrapper returntype = ((StringWrapper)(returntypes.value));
      Cons parametertypes = ((Cons)(signature.rest.value));
      int nofparameters = parametertypes.length();

      { String result000 = null;

        { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

          try {
            Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
            {
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(" (*) (");
              { StringWrapper partype = null;
                Cons iter000 = parametertypes;
                int i = Stella.NULL_INTEGER;
                int iter001 = 1;
                int upperBound000 = nofparameters;
                boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

                for (;(!(iter000 == Stella.NIL)) &&
                          (unboundedP000 ||
                           (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
                  partype = ((StringWrapper)(iter000.value));
                  i = iter001;
                  ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(partype.wrapperValue);
                  if (i < nofparameters) {
                    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(", ");
                  }
                }
              }
              ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
            }
            result000 = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();

          } finally {
            Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
          }
        }
        { String baresignature = result000;

          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
          Stella_Object.cppOutputTypedEntity(returntype, StringWrapper.wrapString(baresignature), null);
          ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
        }
      }
    }
  }

  public static void cppOutputVariableDefinition(Cons variable) {
    { Stella_Object kind = variable.value;
      String documentation = StringWrapper.unwrapString(((StringWrapper)(variable.rest.value)));
      Stella_Object type = variable.rest.rest.value;
      Stella_Object name = variable.fourth();
      Stella_Object initialvalue = variable.fifth();

      if (documentation != null) {
        StringWrapper.cppOutputComment(StringWrapper.wrapString(documentation));
      }
      if (((GeneralizedSymbol)(kind)) == Stella.SYM_STELLA_CPP_SPECIAL) {
        if (Stella.specialImplementationStyle() == Stella.KWD_UNBIND_WITH_DESTRUCTORS) {
          if (Stella.supportUnexecP()) {
            Stella_Object.cppOutputStatement(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("DECLARE_STELLA_SPECIAL"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(name, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(type, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
          }
          else {
            Stella_Object.cppOutputStatement(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("DEFINE_STELLA_SPECIAL"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(name, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(type, Cons.cons(Cons.cons(initialvalue, Stella.NIL), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
          }
        }
        else {
          Stella_Object.cppOutputTypedEntity(type, name, initialvalue);
        }
      }
      else {
        Stella_Object.cppOutputTypedEntity(type, name, initialvalue);
      }
      {
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
      }
;
    }
  }

  public static void cppOutputGlobalDeclaration(Cons global) {
    { Stella_Object kind = global.value;
      Stella_Object type = global.rest.rest.value;
      Stella_Object name = global.fourth();

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("extern ");
      if (((GeneralizedSymbol)(kind)) == Stella.SYM_STELLA_CPP_SPECIAL) {
        if (Stella.specialImplementationStyle() == Stella.KWD_UNBIND_WITH_DESTRUCTORS) {
          Stella_Object.cppOutputStatement(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("DECLARE_STELLA_SPECIAL"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(name, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(type, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
        }
        else {
          Stella_Object.cppOutputTypedEntity(type, name, null);
        }
      }
      else {
        Stella_Object.cppOutputTypedEntity(type, name, null);
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(";");
    }
  }

  public static void cppOutputUnwindProtect(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("try {");
    Stella.cppBumpIndent();
    Cons.cppOutputStatements(Stella_Object.cppStatementToList(tree.value));
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("catch (...) {");
    Stella.cppBumpIndent();
    Cons.cppOutputStatements(((Cons)(Stella_Object.copyConsTree(tree.rest))));
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("throw;");
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    Cons.cppOutputStatements(tree.rest);
  }

  public static void cppOutputCatch(Cons tree) {
    { Cons variabledecl = ((Cons)(tree.value));

      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("catch (");
      Stella_Object.cppOutputStatement(variabledecl.value);
      if (variabledecl.rest.value != null) {
        Stella_Object.cppOutputStatement(variabledecl.rest.value);
      }
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println(") {");
      Stella.cppBumpIndent();
      Cons.cppOutputStatements(Cons.cppFlattenStatements(tree.rest));
      Stella.cppUnbumpIndent();
      Stella.cppIndent();
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    }
  }

  public static void cppOutputHandlerCase(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("try {");
    Stella.cppBumpIndent();
    Cons.cppOutputStatements(Stella_Object.cppStatementToList(tree.value));
    Stella.cppUnbumpIndent();
    Stella.cppIndent();
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("}");
    Cons.cppOutputStatements(tree.rest);
  }

  public static void cppOutputSignal(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("throw ");
    Stella_Object.cppOutputStatement(tree.value);
  }

  public static void cppOutputCast(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("((" + ((StringWrapper)(tree.rest.value)).wrapperValue + ")(");
    Stella_Object.cppOutputStatement(tree.value);
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("))");
  }

  public static void cppOutputArrayReference(Cons tree) {
    Stella_Object.cppMaybeOutputStatementWithParentheses(tree.value);
    { Stella_Object indexexpression = null;
      Cons iter000 = tree.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        indexexpression = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("[");
        Stella_Object.cppOutputStatement(indexexpression);
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("]");
      }
    }
  }

  public static void cppOutputDereference(Cons tree) {
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("*");
    Stella_Object.cppOutputStatement(tree);
  }

  public static Cons cppFlattenStatements(Cons statements) {
    if ((statements != null) &&
        (!(statements == Stella.NIL))) {
      { Surrogate testValue000 = Stella_Object.safePrimaryType(statements.value);

        if (testValue000 == Stella.SGT_STELLA_CONS) {
          { Cons flattenedsubtree = Stella.NIL;
            Cons flattenedtree = Stella.NIL;

            while (!(statements == Stella.NIL)) {
              flattenedsubtree = Cons.cppFlattenStatements(((Cons)(statements.value)));
              if (Stella_Object.consP(flattenedsubtree.value)) {
                flattenedtree = flattenedsubtree.reverse().concatenate(flattenedtree, Stella.NIL);
              }
              else {
                flattenedtree = Cons.cons(flattenedsubtree, flattenedtree);
              }
              statements = statements.rest;
            }
            return (flattenedtree.reverse());
          }
        }
        else if (Surrogate.subtypeOfSymbolP(testValue000)) {
          { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(statements.value));

            if ((testValue001 == Stella.SYM_STELLA_CPP_PROGN) ||
                (testValue001 == Stella.SYM_STELLA_CPP_STATEMENTS)) {
              if (statements.rest == Stella.NIL) {
                return (Stella.NIL);
              }
              else {
                return (Cons.cppFlattenStatements(statements.rest));
              }
            }
            else {
              return (statements);
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
    }
    else {
      return (statements);
    }
  }

  public static void cppOutputParseTree(Cons constree) {
    { Object old$CppIndentChars$000 = Stella.$CPP_INDENT_CHARS$.get();

      try {
        Native.setIntSpecial(Stella.$CPP_INDENT_CHARS$, 0);
        Stella_Object.cppOutputStatement(constree);

      } finally {
        Stella.$CPP_INDENT_CHARS$.set(old$CppIndentChars$000);
      }
    }
  }

  public static Stella_Object cppOutputToString(Cons statement) {
    { Symbol resultvar = Stella.localGensym("RESULT");

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(resultvar, Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$CURRENT_STREAM$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OUTPUT_STRING_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(statement, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(resultvar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_STRING, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Stella.SYM_STELLA_$CURRENT_STREAM$, Cons.cons(Stella.SYM_STELLA_OUTPUT_STRING_STREAM, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))), Cons.cons(resultvar, Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Cons cppTranslateOperatorCall(Cons operatornames, Cons arguments, int arity) {
    { Cons otree = null;

      switch (arity) {
        case 1: 
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_UNARY_OP, Cons.cons(operatornames.value, Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(arguments.value), Stella.NIL), Stella.NIL))));
        break;
        case 2: 
          if (arguments.length() > 2) {
            otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BINARY_OP, Cons.cons(Stella_Object.cppTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Cons.cppTranslateOperatorCall(((Cons)(Stella_Object.copyConsTree(operatornames))), arguments.rest, 2), Stella.NIL)), Stella.NIL))));
          }
          else {
            otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BINARY_OP, Cons.cons(Stella_Object.cppTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Stella_Object.cppTranslateATree(arguments.rest.value), Stella.NIL)), Stella.NIL))));
          }
        break;
        case 3: 
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_TERNARY_OP, Cons.cons(Stella_Object.cppTranslateATree(arguments.value), Cons.cons(Cons.cons(operatornames.value, Cons.cons(Stella_Object.cppTranslateATree(arguments.rest.value), Cons.cons(operatornames.rest.value, Cons.cons(Stella_Object.cppTranslateATree(arguments.rest.rest.value), Stella.NIL)))), Stella.NIL))));
        break;
        default:
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + arity + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
      }
      return (otree);
    }
  }

  public static Cons cppTranslateOperatorTree(Cons tree) {
    { Cons operator = Symbol.cppLookupOperatorTable(((Symbol)(tree.value)));
      Cons args = tree.rest;
      int arity = Stella.NULL_INTEGER;

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

        if ((testValue000 == Stella.SYM_STELLA_AND) ||
            ((testValue000 == Stella.SYM_STELLA_OR) ||
             ((testValue000 == Stella.SYM_STELLA_EQp) ||
              ((testValue000 == Stella.SYM_STELLA_g) ||
               ((testValue000 == Stella.SYM_STELLA_ge) ||
                ((testValue000 == Stella.SYM_STELLA_l) ||
                 (testValue000 == Stella.SYM_STELLA_le))))))) {
          arity = 2;
        }
        else if ((testValue000 == Stella.SYM_STELLA_NOT) ||
            ((testValue000 == Stella.SYM_STELLA_ii) ||
             (testValue000 == Stella.SYM_STELLA___))) {
          arity = 1;
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (Cons.cppTranslateOperatorCall(operator, args, arity));
    }
  }

  public static Cons cppTranslateFunctionCall(Cons tree, MethodSlot method) {
    { Symbol functionname = ((Symbol)(tree.value));
      Cons functionargs = Cons.copyConsList(tree.rest);
      Stella_Object firstarg = functionargs.value;
      MethodSlot function = ((method != null) ? method : Symbol.lookupFunction(functionname));
      Cons operator = Symbol.cppLookupOperatorTable(functionname.softPermanentify());
      Cons otree = null;

      if ((functionname == Stella.SYM_STELLA_GET_SYM) ||
          ((functionname == Stella.SYM_STELLA_GET_KWD) ||
           (functionname == Stella.SYM_STELLA_GET_SGT))) {
        if (Surrogate.subtypeOfIntegerP(Stella_Object.safePrimaryType(firstarg))) {
          { IntegerWrapper firstarg000 = ((IntegerWrapper)(firstarg));

            return (Symbol.cppTranslateHardcodedSymbolReference(functionname, firstarg000.wrapperValue));
          }
        }
        else {
        }
      }
      else {
      }
      functionargs = functionargs.concatenate(MethodSlot.cppYieldUnusedDummyArgs(function, functionargs), Stella.NIL);
      if (operator != null) {
        otree = Cons.cppTranslateOperatorCall(operator, functionargs, functionargs.length());
      }
      else {
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(MethodSlot.cppTranslateFunctionName(function, true), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(((((BooleanWrapper)(KeyValueList.dynamicSlotValue(function.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue &&
            (!MethodSlot.passVariableArgumentsAsListP(function))) ? Cons.cppTranslateVariableLengthActuals(functionargs, function) : Cons.cppTranslateActualParameters(functionargs)), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      return (otree);
    }
  }

  public static Cons getLastNElements(Cons list, int n) {
    n = list.length() - n;
    if (n < 0) {
      n = 0;
    }
    return (list.nthRest(n));
  }

  public static Cons cppTranslateCallMethodCode(Cons tree) {
    { Cons signature = Cons.cppTranslateMethodCodeSignature(((Cons)(tree.rest.value)));
      Stella_Object methodnameexpr = Stella_Object.cppTranslateATree(tree.rest.rest.value);
      Stella_Object theobject = tree.rest.rest.rest.value;
      Cons methodargs = tree.rest.rest.rest.rest;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_METHOD_CODE_CALL, Cons.cons(signature, Cons.cons(Cons.cons(methodnameexpr, Cons.cons(Stella_Object.cppTranslateATree(theobject), Cons.cons(Cons.cppTranslateActualParameters(methodargs), Stella.NIL))), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateCallFunctionCode(Cons tree) {
    { Cons signature = Cons.cppTranslateCodeSignature(((Cons)(tree.rest.value)));
      Stella_Object functionnameexpr = Stella_Object.cppTranslateATree(tree.rest.rest.value);
      Cons functionargs = tree.rest.rest.rest;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCALL, Cons.cons(signature, Cons.cons(Cons.cons(functionnameexpr, Cons.cons(Cons.cppTranslateActualParameters(functionargs), Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateMethodCodeSignature(Cons signature) {
    { Cons translatedreturntypes = Stella.NIL;
      Cons translatedparametertypes = Stella.NIL;
      StringWrapper translatedobjecttype = StandardObject.cppTranslateTypeSpec(((StandardObject)(signature.rest.value)));

      { Stella_Object returntype = null;
        Cons iter000 = ((Cons)(signature.value));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          returntype = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              if (translatedreturntypes == Stella.NIL) {
                translatedreturntypes = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(translatedreturntypes, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object parametertype = null;
        Cons iter001 = signature.rest.rest;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parametertype = iter001.value;
          if (collect001 == null) {
            {
              collect001 = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              if (translatedparametertypes == Stella.NIL) {
                translatedparametertypes = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(translatedparametertypes, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_METHOD_SIGNATURE, Cons.cons(translatedreturntypes, Cons.cons(Cons.cons(translatedobjecttype, Cons.cons(translatedparametertypes, Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateCodeSignature(Cons signature) {
    { Cons translatedreturntypes = Stella.NIL;
      Cons translatedparametertypes = Stella.NIL;

      { Stella_Object returntype = null;
        Cons iter000 = ((Cons)(signature.value));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          returntype = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              if (translatedreturntypes == Stella.NIL) {
                translatedreturntypes = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(translatedreturntypes, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(returntype))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object parametertype = null;
        Cons iter001 = signature.rest;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          parametertype = iter001.value;
          if (collect001 == null) {
            {
              collect001 = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              if (translatedparametertypes == Stella.NIL) {
                translatedparametertypes = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(translatedparametertypes, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(parametertype))), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_SIGNATURE, Cons.cons(translatedreturntypes, Cons.cons(Cons.cons(translatedparametertypes, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateMethodCall(Cons tree, boolean referencedP) {
    { Symbol methodname = ((Symbol)(tree.rest.value));
      Surrogate owner = ((Surrogate)(tree.value));
      Cons arguments = tree.rest.rest;

      if ((methodname == Stella.SYM_STELLA_DEFINEDp) ||
          (methodname == Stella.SYM_STELLA_NULLp)) {
        return (Surrogate.cppTranslateDefinedPMethodCall(owner, arguments.value, methodname == Stella.SYM_STELLA_NULLp));
      }
      else if ((methodname == Stella.SYM_STELLA_NTH) ||
          (methodname == Stella.SYM_STELLA_NTH_SETTER)) {
        return (Symbol.cppTranslateNthMethodCall(methodname, owner, arguments));
      }
      else if ((methodname == Stella.SYM_STELLA_AREF) ||
          (methodname == Stella.SYM_STELLA_AREF_SETTER)) {
        return (Symbol.cppTranslateArefMethodCall(methodname, owner, arguments));
      }
      else {
        if ((owner == Stella.SGT_STELLA_ARGUMENT_LIST) ||
            (owner == Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR)) {
          return (Symbol.cppTranslateArgumentListTree(methodname, owner, arguments.value));
        }
      }
      return (Symbol.cppTranslateNormalMethodCall(methodname, owner, arguments, referencedP));
    }
  }

  public static Cons cppTranslateCallMethodSetter(Cons tree) {
    { Stella_Object methodname = tree.rest.rest.value;
      Stella_Object objectref = Stella_Object.cppTranslateATree(tree.fourth());
      Stella_Object valueref = Stella_Object.cppTranslateATree(tree.fifth());

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_METHOD_SETTER_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(((Symbol)(methodname))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(objectref, Cons.cons(Cons.cons(valueref, Stella.NIL), Stella.NIL))))));
    }
  }

  public static Cons cppTranslateVariableLengthActuals(Cons actuals, MethodSlot method) {
    { int nofparameters = method.methodParameterNames().length();
      int restargumentstart = (MethodSlot.cppMethodObjectIsFunctionP(method) ? (nofparameters - 1) : (nofparameters - 2));
      Cons otree = Stella.NIL;
      boolean pusheddummy = false;

      { Stella_Object actual = null;
        Cons iter000 = actuals;
        int i = Stella.NULL_INTEGER;
        int iter001 = 0;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          actual = iter000.value;
          i = iter001;
          if (i == restargumentstart) {
            pusheddummy = true;
            { int result = actuals.length() - restargumentstart;

              otree = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LITERAL, Cons.cons(IntegerWrapper.wrapInteger(result), Cons.cons(Stella.NIL, Stella.NIL)))), otree);
            }
          }
          otree = Cons.cons(Stella_Object.cppTranslateATree(actual), otree);
        }
      }
      if (!(pusheddummy)) {
        otree = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LITERAL, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), otree);
      }
      return (Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, otree.reverse().concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static Cons cppTranslateActualParameters(Cons tree) {
    return (Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cppTranslateListOfTrees(tree).concatenate(Stella.NIL, Stella.NIL)));
  }

  public static Cons cppTranslateReturnTree(Cons tree) {
    { Cons otree = null;
      Cons returnassignments = Stella.NIL;
      Cons returnvariables = Stella.NIL;
      Cons methodotherreturntypes = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).methodReturnTypeSpecifiers().rest();
      Stella_Object returnexpression = null;
      Cons translatedreturnexpression = Stella.NIL;
      boolean needtemporaryreturnvariableP = (!(tree.rest.rest == Stella.NIL)) &&
          (!Stella_Object.sideEffectFreeExpressionP(tree.rest.value));

      { Stella_Object exp = null;
        Cons iter000 = tree.rest.rest;
        int parameternum = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          exp = iter000.value;
          parameternum = iter001;
          if (!Stella_Object.sideEffectFreeExpressionP(exp)) {
            needtemporaryreturnvariableP = true;
          }
          returnassignments = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ASSIGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateReturnParameterName(Stella.SYM_STELLA__RETURN, parameternum), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.cppTranslateATree(exp), Cons.cons(Stella.NIL, Stella.NIL))))), returnassignments);
        }
      }
      returnassignments = returnassignments.reverse();
      returnexpression = tree.rest.value;
      if ((methodotherreturntypes.length() > 0) &&
          ((tree.rest.rest == Stella.NIL) &&
           (Stella_Object.consP(returnexpression) &&
            ((((Cons)(returnexpression)).value != null) &&
             ((((Cons)(returnexpression)).value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) ||
              (((Cons)(returnexpression)).value == Stella.SYM_STELLA_SYS_CALL_METHOD)))))) {
        {
          { StandardObject type = null;
            Cons iter002 = methodotherreturntypes;
            int parameternum = Stella.NULL_INTEGER;
            int iter003 = 1;
            Cons collect000 = null;

            for (;!(iter002 == Stella.NIL); iter002 = iter002.rest, iter003 = iter003 + 1) {
              type = ((StandardObject)(iter002.value));
              parameternum = iter003;
              type = type;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Symbol.internSymbol(Symbol.cppTranslateReturnParameterName(Stella.SYM_STELLA__RETURN, parameternum).wrapperValue), Stella.NIL);
                  if (returnvariables == Stella.NIL) {
                    returnvariables = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(returnvariables, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Symbol.internSymbol(Symbol.cppTranslateReturnParameterName(Stella.SYM_STELLA__RETURN, parameternum).wrapperValue), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          translatedreturnexpression = Cons.cppTranslateMvFunctionCall(((Cons)(returnexpression)), returnvariables);
        }
      }
      else {
        translatedreturnexpression = ((Cons)(Stella_Object.cppTranslateATree(returnexpression)));
      }
      if (returnassignments == Stella.NIL) {
        if (tree.rest == Stella.NIL) {
          otree = Cons.cons(Stella.SYM_STELLA_CPP_RETURN, Stella.NIL);
        }
        else {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_RETURN, Cons.cons(translatedreturnexpression, Cons.cons(Stella.NIL, Stella.NIL))));
        }
      }
      else {
        if (needtemporaryreturnvariableP) {
          { StringWrapper tempvar = Symbol.cppTranslateReturnParameterName(Stella.SYM_STELLA__RETURN, 0);

            otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).computeReturnTypeSpec(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).slotOwner)), Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(tempvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(translatedreturnexpression, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, returnassignments.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_RETURN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(tempvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
          }
        }
        else {
          otree = Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, returnassignments.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_RETURN, Cons.cons(translatedreturnexpression, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL));
        }
      }
      return (otree);
    }
  }

  public static Cons wrapMethodBodyWithCppAuxiliaryDeclarations(Cons methodbody, Cons declarations) {
    { Cons odeclarations = Stella.NIL;
      Cons otree = null;

      declarations = declarations.reverse();
      { Stella_Object declaration = null;
        Cons iter000 = declarations;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = iter000.value;
          { Cons d = ((Cons)(declaration));

            odeclarations = Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(d.rest.value))), Cons.cons(Stella_Object.cppTranslateATree(d.value), (((d.rest.rest.value != null) ? Cons.consList(Cons.cons(Stella_Object.cppTranslateATree(d.rest.rest.value), Stella.NIL)) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL))), odeclarations);
          }
        }
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(odeclarations.reverse(), Cons.cons(Cons.cons(methodbody, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      return (otree);
    }
  }

  public static Cons deleteQuotedNullStatements(Cons trees) {
    return (trees.remove(Stella.SYM_STELLA_NULL));
  }

  public static Cons cppTranslateLetTree(Cons tree) {
    { Cons odeclarations = Stella.NIL;

      { Stella_Object declaration = null;
        Cons iter000 = ((Cons)(tree.rest.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = iter000.value;
          { Cons d = ((Cons)(declaration));

            odeclarations = Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(d.rest.value))), Cons.cons(Stella_Object.cppTranslateATree(d.value), Cons.cons(Stella_Object.cppTranslateATree(d.rest.rest.value), Stella.NIL))), odeclarations);
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(odeclarations.reverse(), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Stella_Object cppTranslateSysSetDefault(Cons tree) {
    return (Cons.cppTranslateSetqTree(tree));
  }

  public static Cons cppTranslateSetqTree(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ASSIGN, Cons.cons(Stella_Object.cppTranslateATree(tree.rest.value), Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(tree.rest.rest.value), Stella.NIL), Stella.NIL)))));
  }

  public static Cons cppTranslatePrintStream(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_PRINT_STREAM);
    if (Surrogate.subtypeOfKeywordP(Stella_Object.safePrimaryType(tree.rest.value))) {
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.rest.value));

        if ((testValue000 == Stella.KWD_WARN) ||
            ((testValue000 == Stella.KWD_ERROR) ||
             (testValue000 == Stella.KWD_CONTINUABLE_ERROR))) {
          tree.secondSetter(Stella.SYM_STELLA_CPP_STANDARD_ERROR);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
    }
    else {
      if (Stella_Object.cppStreamIsStandardOutputP(tree.rest.value)) {
        tree.secondSetter(Stella.SYM_STELLA_CPP_STANDARD_OUT);
      }
      else {
        tree.secondSetter(Stella_Object.cppTranslateATree(tree.rest.value));
      }
    }
    { ConsIterator it = tree.rest.rest.allocateIterator();

      while (it.nextP()) {
        if (it.value == Stella.SYM_STELLA_EOL) {
          it.valueSetter(Stella.getQuotedTree("((CPP_IDENT \"std::endl\") \"/STELLA\")", "/STELLA"));
        }
        else {
          it.valueSetter(Stella_Object.cppTranslateATree(it.value));
        }
      }
    }
    return (tree);
  }

  public static Cons cppTranslateStartupTimeProgn(Cons tree) {
    { Stella_Object otree = Stella_Object.cppTranslateATree(tree.rest.value);

      tree.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STARTUP_TIME_PROGN, Cons.cons(otree, Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons cppTranslateMakeTree(Cons tree) {
    { Symbol classname = ((Symbol)(tree.rest.value));
      Stella_Class renamed_Class = classname.lookupClass();
      String nativetype = ((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue;
      Cons arguments = Cons.cppTranslateActualParameters(tree.rest.rest);

      if (nativetype == null) {
        if (StandardObject.cppTypeWithoutInteriorPointersP(renamed_Class.classType)) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("PointerFreeGC"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(GeneralizedSymbol.cppTranslateClassName(classname), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(arguments, Cons.cons(Stella.NIL, Stella.NIL)))))));
        }
        else {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(GeneralizedSymbol.cppTranslateClassName(classname), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(arguments, Cons.cons(Stella.NIL, Stella.NIL))))));
        }
      }
      else if (Stella.cppNativePointerTypeP(nativetype)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_MAKE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString(Stella.cppUnpointerizeNativeType(nativetype)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(arguments, Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString(nativetype), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(arguments, Cons.cons(Stella.NIL, Stella.NIL))))));
      }
    }
  }

  public static Cons cppTranslateSysSlotValueSetter(Cons tree) {
    { Stella_Object objectref = tree.fourth();
      Surrogate objecttype = ((Surrogate)(tree.rest.value));
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objecttype);
      Stella_Object valueref = Stella_Object.cppTranslateATree(tree.fifth());
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SLOT_VALUE_SETTER, Cons.cons(Stella_Object.cppTranslateATree(objectref), Cons.cons(Cons.cons(Symbol.cppTranslateName(slotname), Cons.cons(valueref, Stella.NIL)), Stella.NIL))));

      tree.thirdSetter(null);
      tree.fourthSetter(null);
      tree.fifthSetter(null);
      return (otree);
    }
  }

  public static Cons cppTranslateSysSlotValue(Cons tree) {
    { Surrogate objecttype = ((Surrogate)(tree.rest.value));
      Stella_Object objectref = tree.fourth();
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objecttype);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_SLOT_VALUE, Cons.cons(Stella_Object.cppTranslateATree(objectref), Cons.cons(Cons.cons(Symbol.cppTranslateName(slotname), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateSysReferencedSlotValue(Cons tree) {
    { Stella_Object objectref = tree.fourth();
      Stella_Object slotname = tree.rest.rest.value;

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_REFERENCED_SLOT_VALUE, Cons.cons(Stella_Object.cppTranslateATree(objectref), Cons.cons(Cons.cons(Symbol.cppTranslateName(((Symbol)(slotname))), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Stella_Object cppTranslateBadSys(Cons tree) {
    { Stella_Object returntype = tree.rest.rest.value;

      if (returntype == Stella.SGT_STELLA_VOID) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("illegal_stella_statement_flagged_by_the_translator"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("illegal_stella_expression_flagged_by_the_translator"), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
    }
  }

  public static Cons cppTranslateTypedSys(Cons tree) {
    return (((Cons)(Stella_Object.cppTranslateATree(tree.rest.value))));
  }

  public static Cons cppTranslateVoidSys(Cons tree) {
    return (((Cons)(Stella_Object.cppTranslateATree(tree.rest.value))));
  }

  public static Cons cppTranslateNewArray(Cons tree) {
    { ParametricTypeSpecifier arraytype = ((ParametricTypeSpecifier)(tree.rest.value));
      Stella_Object initialelement = tree.rest.rest.value;
      Cons dimensions = Cons.cppTranslateListOfTrees(tree.rest.rest.rest);
      StandardObject elementtype = StandardObject.extractParameterType(arraytype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);

      initialelement = initialelement;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons((Stella.cppUseGarbageCollectorP() ? ((StandardObject.cppNonPointerTypeP(elementtype) ? StringWrapper.wrapString("new (PointerFreeGC)") : StringWrapper.wrapString("new (GC)"))) : StringWrapper.wrapString("new")), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ARRAY_REFERENCE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(elementtype), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(dimensions.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static Cons cppTranslateSysNew(Cons tree) {
    { StandardObject typespec = ((StandardObject)(tree.rest.value));
      Stella_Class renamed_Class = StandardObject.typeSpecToClass(typespec);

      if (StandardObject.arrayTypeSpecifierP(typespec)) {
        return (Cons.cppTranslateNewArray(tree));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString(Stella.cppYieldQualifiedName(Symbol.cppTranslateName(Stella_Class.yieldConstructorName(renamed_Class)).wrapperValue, Stella_Class.classSymbol(renamed_Class))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.cppTranslateActualParameters(tree.rest.rest), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
    }
  }

  public static Cons cppTranslateSysPointerToFunction(Cons tree) {
    { String functionname = Symbol.cppTranslateName(((Symbol)(tree.rest.value))).wrapperValue;
      Cons otree = null;

      if (tree.rest.rest.value == Stella.SYM_STELLA_TRUE) {
        functionname = functionname + "_setter";
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_POINTER, Cons.cons(StringWrapper.wrapString(functionname), Cons.cons(Stella.NIL, Stella.NIL))));
      return (otree);
    }
  }

  public static Cons cppTranslateTheCode(Cons tree) {
    { Cons otree = null;

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.rest.value));

        if (testValue000 == Stella.KWD_FUNCTION) {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_POINTER, Cons.cons(Symbol.cppTranslateFunctionNameFromName(((Symbol)(tree.rest.rest.value))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(StringWrapper.wrapString("cpp_function_code"), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else if (testValue000 == Stella.KWD_METHOD) {
          otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_CAST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_METHOD_POINTER, Cons.cons(Symbol.cppTranslateMethodNameFromName(((Symbol)(tree.fourth())), ((StandardObject)(tree.rest.rest.value))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(StringWrapper.wrapString("cpp_method_code"), Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (otree);
    }
  }

  public static Cons cppTranslateForeachTree(Cons tree) {
    { Cons iteratorbindings = ((Cons)(tree.rest.value));
      Cons valuetrees = ((Cons)(tree.rest.rest.value));
      Cons nexttrees = ((Cons)(tree.fourth()));
      Stella_Object continuationtest = Stella_Object.cppTranslateATree(tree.fifth());
      Cons body = Cons.cppTranslateListOfTrees(tree.nthRest(5));
      Cons declaration = Stella.NIL;
      Cons declarations = Stella.NIL;
      Cons vadeclarations = Stella.NIL;
      Cons valueassignments = Stella.NIL;
      Cons nextassignments = Stella.NIL;
      Symbol varargsiterator = null;
      Cons variables = Stella.NIL;

      { Cons binding = null;
        Cons iter000 = iteratorbindings;
        Cons collect000 = null;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = ((Cons)(iter000.value));
          if (StandardObject.subTypeSpecOfP(((StandardObject)(binding.rest.value)), Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR)) {
            varargsiterator = ((Symbol)(binding.value));
            vadeclarations = vadeclarations.concatenate(Symbol.cppYieldVaIteratorDeclarations(varargsiterator), Stella.NIL);
            continue loop000;
          }
          else {
            declaration = Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(binding.rest.value))), Cons.cons(Stella_Object.cppTranslateATree(binding.value), Cons.cons(Stella_Object.cppTranslateATree(binding.rest.rest.value), Stella.NIL)));
          }
          if (collect000 == null) {
            {
              collect000 = Cons.cons(declaration, Stella.NIL);
              if (declarations == Stella.NIL) {
                declarations = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(declarations, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(declaration, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Cons tree000 = null;
        Cons iter001 = valuetrees;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          tree000 = ((Cons)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(Stella_Object.cppTranslateATree(tree000), Stella.NIL);
              if (valueassignments == Stella.NIL) {
                valueassignments = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(valueassignments, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(Stella_Object.cppTranslateATree(tree000), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      { Cons tree000 = null;
        Cons iter002 = nexttrees;
        Cons collect002 = null;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          tree000 = ((Cons)(iter002.value));
          if (collect002 == null) {
            {
              collect002 = Cons.cons(Stella_Object.cppTranslateATree(tree000), Stella.NIL);
              if (nextassignments == Stella.NIL) {
                nextassignments = collect002;
              }
              else {
                Cons.addConsToEndOfConsList(nextassignments, collect002);
              }
            }
          }
          else {
            {
              collect002.rest = Cons.cons(Stella_Object.cppTranslateATree(tree000), Stella.NIL);
              collect002 = collect002.rest;
            }
          }
        }
      }
      { Cons decl = null;
        Cons iter003 = vadeclarations;
        Cons collect003 = null;

        for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
          decl = ((Cons)(iter003.value));
          if (collect003 == null) {
            {
              collect003 = Cons.cons(decl.rest.value, Stella.NIL);
              if (variables == Stella.NIL) {
                variables = collect003;
              }
              else {
                Cons.addConsToEndOfConsList(variables, collect003);
              }
            }
          }
          else {
            {
              collect003.rest = Cons.cons(decl.rest.value, Stella.NIL);
              collect003 = collect003.rest;
            }
          }
        }
      }
      { Cons decl = null;
        Cons iter004 = declarations;
        Cons collect004 = null;

        for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
          decl = ((Cons)(iter004.value));
          if (collect004 == null) {
            {
              collect004 = Cons.cons(decl.rest.value, Stella.NIL);
              if (variables == Stella.NIL) {
                variables = collect004;
              }
              else {
                Cons.addConsToEndOfConsList(variables, collect004);
              }
            }
          }
          else {
            {
              collect004.rest = Cons.cons(decl.rest.value, Stella.NIL);
              collect004 = collect004.rest;
            }
          }
        }
      }
      if (!(vadeclarations == Stella.NIL)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(vadeclarations.concatenate(declarations, Stella.NIL), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Symbol.cppYieldVaStartTree(varargsiterator).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FOREACH, Cons.cons(variables, Cons.cons(Cons.cons(continuationtest, Cons.cons(valueassignments, Cons.cons(nextassignments, Cons.cons(body, Stella.NIL)))), Stella.NIL)))), Symbol.cppYieldVaEndTree(varargsiterator).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)), Stella.NIL), Stella.NIL)))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(declarations, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FOREACH, Cons.cons(variables, Cons.cons(Cons.cons(continuationtest, Cons.cons(valueassignments, Cons.cons(nextassignments, Cons.cons(body, Stella.NIL)))), Stella.NIL)))), Stella.NIL), Stella.NIL)))));
      }
    }
  }

  public static Cons cppTranslateUnlessTree(Cons tree) {
    { Stella_Object test = Stella_Object.cppTranslateATree(tree.rest.value);
      Cons body = Cons.cppTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_UNLESS, Cons.cons(test, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateWhenTree(Cons tree) {
    { Stella_Object test = Stella_Object.cppTranslateATree(tree.rest.value);
      Cons body = Cons.cppTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_WHEN, Cons.cons(test, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateChooseTree(Cons tree) {
    return (Cons.cppTranslateOperatorCall(Cons.cons(StringWrapper.wrapString("?"), Cons.cons(StringWrapper.wrapString(":"), Stella.NIL)), tree.rest, 3));
  }

  public static Cons cppTranslateIfTree(Cons tree) {
    { Stella_Object test = Stella_Object.cppTranslateATree(tree.rest.value);
      Cons truebody = ((Cons)(Stella_Object.cppTranslateATree(tree.rest.rest.value)));
      Cons falsebody = ((Cons)(Stella_Object.cppTranslateATree(tree.fourth())));

      if (Stella_Object.consP(truebody.value) &&
          (!(truebody.rest == Stella.NIL))) {
        truebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, truebody.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else {
        truebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cons(truebody, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      if (Stella_Object.consP(falsebody.value) &&
          (!(falsebody.rest == Stella.NIL))) {
        falsebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, falsebody.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else {
        falsebody = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cons(falsebody, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IF, Cons.cons(test, Cons.cons(Cons.cons(truebody, Cons.cons(falsebody, Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateContinue(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_CONTINUE);
    return (tree);
  }

  public static Cons cppTranslateBreak(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_BREAK);
    return (tree);
  }

  public static Cons cppTranslateWithProcessLock(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_WITH_PROCESS_LOCK, Cons.cons(Stella_Object.cppTranslateATree(tree.rest.value), Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
  }

  public static Cons cppTranslateProgn(Cons tree) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(tree.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Cons cppTranslateWhile(Cons tree) {
    { Stella_Object test = Stella_Object.cppTranslateATree(tree.rest.value);
      Cons body = Cons.cppTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_WHILE, Cons.cons(test, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateLoop(Cons tree) {
    { Cons body = Cons.cppTranslateListOfTrees(tree.rest);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LOOP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Cons cppTranslateCondTree(Cons tree) {
    { Cons otherwisecondition = null;
      Cons conditions = Stella.NIL;

      { Stella_Object condition = null;
        Cons iter000 = tree.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          condition = iter000.value;
          if (Stella_Object.safePrimaryType(condition) == Stella.SGT_STELLA_CONS) {
            { Cons condition000 = ((Cons)(condition));

              if (condition000.value == Stella.SYM_STELLA_OTHERWISE) {
                otherwisecondition = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))));
              }
              else {
                conditions = Cons.cons(Cons.cons(Stella_Object.cppTranslateATree(condition000.value), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), conditions);
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(condition) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_COND, Cons.cons(otherwisecondition, Cons.cons(Cons.cons(conditions.reverse(), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateCaseTree(Cons tree) {
    { Cons otherwisecondition = null;
      Cons conditions = Stella.NIL;
      Stella_Object keyform = null;
      boolean symbolcasep = false;

      symbolcasep = Stella_Object.symbolCaseP(tree.rest.value);
      keyform = Stella_Object.cppTranslateATree(tree.rest.value);
      { Stella_Object condition = null;
        Cons iter000 = tree.rest.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          condition = iter000.value;
          if (Stella_Object.safePrimaryType(condition) == Stella.SGT_STELLA_CONS) {
            { Cons condition000 = ((Cons)(condition));

              if (condition000.value == Stella.SYM_STELLA_OTHERWISE) {
                otherwisecondition = Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(condition000.rest).concatenate(Stella.NIL, Stella.NIL));
              }
              else {
                conditions = Cons.cons(Cons.cppTranslateCondition(condition000, symbolcasep), conditions);
              }
            }
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + Stella_Object.safePrimaryType(condition) + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
      tree.rest.rest = Stella.NIL;
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_CASE, Cons.cons(keyform, Cons.cons(Cons.cons(otherwisecondition, Cons.cons(conditions.reverse(), Stella.NIL)), Stella.NIL)))));
    }
  }

  public static Cons cppTranslateCondition(Cons condition, boolean symbolcasep) {
    { Cons translatedactions = Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, Cons.cppTranslateListOfTrees(condition.rest).concatenate(Stella.NIL, Stella.NIL));
      Stella_Object keys = condition.value;
      Stella_Object translatedkeys = null;
      Cons translatedkeyslist = Stella.NIL;

      if (symbolcasep) {
        if (Stella_Object.consP(keys)) {
          {
            { Stella_Object key = null;
              Cons iter000 = ((Cons)(keys));
              Cons collect000 = null;

              for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                key = iter000.value;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(Stella.cppYieldSymbolIdForm(((IntegerWrapper)(key)).wrapperValue), Stella.NIL);
                    if (translatedkeyslist == Stella.NIL) {
                      translatedkeyslist = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(translatedkeyslist, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(Stella.cppYieldSymbolIdForm(((IntegerWrapper)(key)).wrapperValue), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            translatedkeys = translatedkeyslist;
          }
        }
        else {
          translatedkeys = Stella.cppYieldSymbolIdForm(((IntegerWrapper)(keys)).wrapperValue);
        }
      }
      else {
        translatedkeys = (Stella_Object.consP(keys) ? Cons.cppTranslateListOfTrees(((Cons)(keys))) : Stella_Object.cppTranslateATree(keys));
      }
      return (Cons.cons(translatedkeys, Cons.cons(translatedactions, Stella.NIL)));
    }
  }

  public static Cons cppTranslateMvFunctionCall(Cons functioncall, Cons variables) {
    return (((Cons)(Stella_Object.cppTranslateATree(functioncall.concatenate(variables.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  public static Cons cppTranslateMvSetq(Cons tree) {
    { Cons variables = ((Cons)(tree.rest.value));
      Stella_Object functioncall = tree.rest.rest.value;
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ASSIGN, Cons.cons(Stella_Object.cppTranslateATree(variables.value), Cons.cons(Cons.cons(Cons.cppTranslateMvFunctionCall(((Cons)(functioncall)), variables.rest), Stella.NIL), Stella.NIL))));

      return (otree);
    }
  }

  public static Cons cppTranslateCast(Cons tree) {
    { Stella_Object expression = tree.rest.value;
      Surrogate type = StandardObject.typeSpecToBaseType(((StandardObject)(tree.rest.rest.value)));

      if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_NUMBER) &&
          Stella_Object.isaP(expression, Stella.SGT_STELLA_NUMBER_WRAPPER)) {
        return (((Cons)(Stella_Object.cppTranslateATree(NumberWrapper.coerceNumericConstant(((NumberWrapper)(expression)), type)))));
      }
      tree.firstSetter(Stella.SYM_STELLA_CPP_CAST);
      tree.secondSetter(Stella_Object.cppTranslateATree(tree.rest.value));
      tree.thirdSetter(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(tree.rest.rest.value))));
      return (tree);
    }
  }

  public static Cons cppTranslateUnwindProtect(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_UNWIND_PROTECT);
    tree.rest = Cons.cppTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Cons cppTranslateHandleException(Cons tree) {
    { Cons variabledecl = ((Cons)(tree.rest.value));
      Stella_Object variable = variabledecl.value;
      Stella_Object exceptiontype = variabledecl.rest.value;
      StringWrapper helpervariable = null;
      StringWrapper helpervariabletype = null;

      tree.firstSetter(Stella.SYM_STELLA_CPP_CATCH);
      if (variable != null) {
        helpervariable = StringWrapper.wrapString("_" + Symbol.cppTranslateName(((Symbol)(variable))).wrapperValue);
        helpervariabletype = StringWrapper.wrapString(Native.stringConcatenate(StandardObject.cppTranslateTypeSpec(((StandardObject)(exceptiontype))).wrapperValue, "&"));
      }
      tree.secondSetter(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_TYPE, Cons.cons(((variable != null) ? helpervariabletype : StandardObject.cppTranslateTypeSpec(((StandardObject)(exceptiontype)))), Cons.cons(Stella.NIL, Stella.NIL)))), (((variable != null) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(helpervariable, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL)));
      tree.rest.rest = Cons.cppTranslateListOfTrees(tree.rest.rest);
      if (variable != null) {
        tree.rest.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_LOCAL, Cons.cons(null, Cons.cons(Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(((StandardObject)(exceptiontype))), Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateName(((Symbol)(variable))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString(Native.stringConcatenate("&", helpervariable.wrapperValue)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)))), tree.rest.rest.concatenate(Stella.NIL, Stella.NIL));
      }
      return (tree);
    }
  }

  public static Cons cppTranslateHandlerCase(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_HANDLER_CASE);
    tree.rest = Cons.cppTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Cons cppTranslateSignal(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_CPP_SIGNAL);
    tree.secondSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_DEREFERENCE, Cons.cons(Stella_Object.cppTranslateATree(tree.rest.value), Cons.cons(Stella.NIL, Stella.NIL)))));
    tree.rest.rest = Stella.NIL;
    return (tree);
  }

  public static Cons cppTranslatePrintNativeStream(Cons tree) {
    { Cons otree = Cons.cppTranslatePrintStream(tree);

      otree.firstSetter(Stella.SYM_STELLA_CPP_PRINT_NATIVE_STREAM);
      return (otree);
    }
  }

  public static Stella_Object cppTranslateInlineCallTree(Cons tree) {
    { Cons calltree = ((Cons)(tree.rest.value));
      Cons arguments = ((calltree.value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) ? calltree.nthRest(2) : calltree.nthRest(3));
      Cons tokenizedbody = Cons.tokenizeVerbatimMethodBody(calltree);

      if (tokenizedbody != null) {
        { List inlinedparameters = List.newList();
          String inlinedbody = null;
          boolean successP = true;

          { Object old$CurrentStream$000 = Stella.$CURRENT_STREAM$.get();

            try {
              Native.setSpecial(Stella.$CURRENT_STREAM$, OutputStringStream.newOutputStringStream());
              { Stella_Object token = null;
                Cons iter000 = tokenizedbody;

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  token = iter000.value;
                  { Surrogate testValue000 = Stella_Object.safePrimaryType(token);

                    if (Surrogate.subtypeOfStringP(testValue000)) {
                      { StringWrapper token000 = ((StringWrapper)(token));

                        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(token000.wrapperValue);
                      }
                    }
                    else if (testValue000 == Stella.SGT_STELLA_CONS) {
                      { Cons token000 = ((Cons)(token));

                        { StringWrapper parameter = ((StringWrapper)(token000.value));
                          IntegerWrapper position = ((IntegerWrapper)(token000.rest.value));
                          Stella_Object argument = arguments.nth(position.wrapperValue);

                          if (!Stella_Object.sideEffectFreeExpressionP(argument)) {
                            if (inlinedparameters.memberP(parameter)) {
                              {
                                successP = false;
                                break loop000;
                              }
                            }
                            else {
                              inlinedparameters.insert(parameter);
                            }
                          }
                          if (!(Stella_Object.atomicExpressionP(argument))) {
                            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print("(");
                          }
                          Stella_Object.cppOutputStatement(Stella_Object.cppTranslateATree(Stella_Object.copyConsTree(argument)));
                          if (!(Stella_Object.atomicExpressionP(argument))) {
                            ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.print(")");
                          }
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
                }
              }
              inlinedbody = ((OutputStringStream)(((OutputStream)(Stella.$CURRENT_STREAM$.get())))).theStringReader();
              if (successP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_VERBATIM, Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper(inlinedbody), Cons.cons(Stella.NIL, Stella.NIL)))));
              }

            } finally {
              Stella.$CURRENT_STREAM$.set(old$CurrentStream$000);
            }
          }
        }
      }
      return (Stella_Object.cppTranslateATree(calltree));
    }
  }

  public static Cons tokenizeVerbatimMethodBody(Cons tree) {
    { MethodSlot method = ((MethodSlot)(Cons.slotFromExpressionTree(tree)));
      String body = ((VerbatimStringWrapper)(Cons.lookupVerbatimTree(((Cons)(Cons.walkVerbatimTree(((Cons)(MethodSlot.inlinableMethodBody(method))), new Object[1]))), null))).wrapperValue;
      int bodystart = 0;
      int bodylength = body.length();
      List parameters = List.newList();
      int parameterposition = 0;
      String identifierchars = "_ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$";
      Cons result = Stella.NIL;
      char ch = Stella.NULL_CHARACTER;
      int cursor = 0;
      int end = 0;

      { Symbol par = null;
        Cons iter000 = method.methodParameterNames().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          par = ((Symbol)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ? Symbol.cppTranslateName(par) : Symbol.javaTranslateName(par)), Stella.NIL);
              if (parameters.theConsList == Stella.NIL) {
                parameters.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(parameters.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ? Symbol.cppTranslateName(par) : Symbol.javaTranslateName(par)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      loop001 : for (;;) {
        if (cursor >= bodylength) {
          break loop001;
        }
        ch = body.charAt(cursor);
        if (ch == '/') {
          cursor = cursor + 1;
          if (cursor < bodylength) {
            switch (body.charAt(cursor)) {
              case '/': 
                { InputStringStream comment = InputStringStream.newInputStringStream(Native.string_subsequence(body, cursor, Stella.NULL_INTEGER));

                  cursor = cursor + (InputStream.readLine(comment)).length();
                }
              break;
              case '*': 
                cursor = Native.stringSearch(body, "*/", cursor);
                if (cursor == Stella.NULL_INTEGER) {
                  { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal `" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' verbatim code in `" + Stella_Object.deUglifyParseTree(method) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                    }
                  }
                  return (null);
                }
                else {
                  cursor = cursor + 2;
                }
              break;
              default:
              break;
            }
          }
        }
        else if (Native.string_memberP(identifierchars, ch) &&
            (!(Stella.$CHARACTER_TYPE_TABLE$[(int) ch] == Stella.KWD_DIGIT))) {
          end = cursor + 1;
          { int i = Stella.NULL_INTEGER;
            int iter001 = end;
            int upperBound000 = bodylength - 1;

            loop002 : for (;iter001 <= upperBound000; iter001 = iter001 + 1) {
              i = iter001;
              if (Native.string_memberP(identifierchars, body.charAt(i))) {
                end = end + 1;
              }
              else {
                break loop002;
              }
            }
          }
          parameterposition = parameters.position(StringWrapper.wrapString(Native.string_subsequence(body, cursor, end)), Stella.NULL_INTEGER);
          if (parameterposition != Stella.NULL_INTEGER) {
            result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(body, bodystart, cursor)), result);
            result = Cons.cons(Cons.cons(parameters.nth(parameterposition), Cons.cons(IntegerWrapper.wrapInteger(parameterposition), Stella.NIL)), result);
            bodystart = end;
          }
          cursor = end;
        }
        else {
          cursor = cursor + 1;
        }
      }
      if (bodystart < bodylength) {
        result = Cons.cons(StringWrapper.wrapString(Native.string_subsequence(body, bodystart, bodylength)), result);
      }
      return (result.reverse());
    }
  }

  public static Cons cppTranslateInlineTree(Cons tree) {
    tree = tree;
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_COMMENT, Cons.cons(StringWrapper.wrapString("inline method"), Cons.cons(Stella.NIL, Stella.NIL)))));
  }

  public static Cons cppTranslateSpecialTree(Cons tree) {
    if (!(Stella.specialImplementationStyle() == Stella.KWD_UNBIND_WITH_DESTRUCTORS)) {
      System.err.print("Safety violation: INTERNAL ERROR: Unexpected special implementation style");
    }
    { Cons odeclarations = Stella.NIL;
      GlobalVariable variable = null;
      Symbol variablename = null;
      StandardObject type = null;
      Stella_Object initialvaluetree = null;

      { Cons declaration = null;
        Cons iter000 = ((Cons)(tree.rest.value));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          declaration = ((Cons)(iter000.value));
          variablename = ((Symbol)(declaration.value));
          type = ((StandardObject)(declaration.rest.value));
          initialvaluetree = declaration.rest.rest.value;
          variable = variablename.lookupGlobalVariable();
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("BIND_STELLA_SPECIAL"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateGlobalName(Symbol.cppFixupNameSymbol(variablename, variable.homeModule())), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(type), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.cppTranslateATree(initialvaluetree), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
              if (odeclarations == Stella.NIL) {
                odeclarations = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(odeclarations, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_FUNCTION_CALL, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StringWrapper.wrapString("BIND_STELLA_SPECIAL"), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_ACTUALS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(Symbol.cppTranslateGlobalName(Symbol.cppFixupNameSymbol(variablename, variable.homeModule())), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_IDENT, Cons.cons(StandardObject.cppTranslateAndPointerizeTypeSpec(type), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella_Object.cppTranslateATree(initialvaluetree), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_BLOCK, Cons.cons(Stella.NIL, Cons.cons(Cons.cons(Stella.SYM_STELLA_CPP_STATEMENTS, odeclarations.concatenate(Cons.cppTranslateListOfTrees(tree.rest.rest).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static Cons cppTranslateVerbatimTree(Cons tree) {
    { Cons cursor = tree.rest;
      Stella_Object verbatimcode = null;

      while (!(cursor == Stella.NIL)) {
        if (cursor.value == Stella.KWD_CPP) {
          verbatimcode = cursor.rest.value;
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CPP_VERBATIM, Cons.cons(verbatimcode, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        cursor = cursor.rest.rest;
      }
      throw ((StellaException)(StellaException.newStellaException("Verbatim has no :cpp option").fillInStackTrace()));
    }
  }

  public static Cons cppTranslateListOfTrees(Cons trees) {
    { Cons cursor = trees;

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.cppTranslateATree(cursor.value);
        cursor = cursor.rest;
      }
      return (trees);
    }
  }

  public static void cppOutputClassHeadDeclarations(Cons classes) {
    if (!(classes == Stella.NIL)) {
      ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("// Class headers:");
    }
    { Stella_Object renamed_Class = null;
      Cons iter000 = classes;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        renamed_Class = iter000.value;
        ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println("class " + ((StringWrapper)(((Cons)(renamed_Class)).rest.value)).wrapperValue + ";");
      }
    }
    ((OutputStream)(Stella.$CURRENT_STREAM$.get())).nativeStream.println();
  }

  public static void prettyPrintDefinitionTree(Cons tree, OutputStream stream) {
    tree = ((Cons)(Stella_Object.consifyListsAndIterators(tree)));
    { Object old$PrintprettycodeP$000 = Stella.$PRINTPRETTYCODEp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTPRETTYCODEp$, true);
        Stella_Object.printStellaDefinition(tree, stream.nativeStream);

      } finally {
        Stella.$PRINTPRETTYCODEp$.set(old$PrintprettycodeP$000);
      }
    }
  }

  public static void prettyPrintStellaTree(Cons tree, OutputStream stream) {
    tree = ((Cons)(Stella_Object.consifyListsAndIterators(tree)));
    { Object old$PrintprettycodeP$000 = Stella.$PRINTPRETTYCODEp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTPRETTYCODEp$, true);
        Stella_Object.printStellaCode(tree, stream.nativeStream);

      } finally {
        Stella.$PRINTPRETTYCODEp$.set(old$PrintprettycodeP$000);
      }
    }
  }

  public static void describeEvaluatorWrapper(Cons arguments) {
    Stella_Object.describe(arguments.value, arguments.rest);
  }

  public static Stella_Object getEvaluatorWrapper(Cons arguments) {
    return (Stella_Object.get(arguments.value, arguments.rest));
  }

  public static Stella_Object getPropertyEvaluatorWrapper(Cons arguments) {
    return (Stella_Object.getProperty(arguments.value, arguments.rest));
  }

  public static void configureStellaEvaluatorWrapper(Cons arguments) {
    Stella.configureStella(((StringWrapper)(arguments.value)).wrapperValue);
  }

  public static KeyValueList loadConfigurationFileEvaluatorWrapper(Cons arguments) {
    return (KeyValueList.loadConfigurationFile(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static Cons startupNamesFromFiles(Cons files) {
    { Cons names = Stella.NIL;

      { StringWrapper f = null;
        Cons iter000 = files;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          f = ((StringWrapper)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Stella.startupNameFromFile(f.wrapperValue), Stella.NIL);
              if (names == Stella.NIL) {
                names = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(names, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Stella.startupNameFromFile(f.wrapperValue), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (names);
    }
  }

  public static boolean compileAndLoadFiles(Cons files, Keyword language, boolean forcerecompilationP) {
    if (language == Stella.KWD_COMMON_LISP) {
      return (Cons.clCompileAndLoadFiles(files, true, forcerecompilationP));
    }
    else {
      Stella.STANDARD_OUTPUT.nativeStream.println("'compile-and-load-files' NOT IMPLEMENTED FOR " + language);
      return (false);
    }
  }

  public static BooleanWrapper loadSystemEvaluatorWrapper(Cons arguments) {
    return ((Stella.loadSystem(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
  }

  public static Cons filesPlusSystemStartup(Cons files) {
    return (files.concatenate(Cons.consList(Cons.cons(StringWrapper.wrapString(SystemDefinition.systemStartupFileName(null)), Stella.NIL)), Stella.NIL));
  }

  public static BooleanWrapper makeSystemEvaluatorWrapper(Cons arguments) {
    return ((Stella.makeSystem(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
  }

  public static SystemDefinition defsystemEvaluatorWrapper(Cons arguments) {
    return (Symbol.defsystem(((Symbol)(arguments.value)), arguments.rest));
  }

  public static Cons parseListOfFilePaths(Cons files) {
    { Cons strings = Stella.NIL;

      { Stella_Object filespec = null;
        Cons iter000 = files;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          filespec = iter000.value;
          strings = Cons.cons(StringWrapper.wrapString(Stella_Object.implodePathname(filespec)), strings);
        }
      }
      return (strings.reverse());
    }
  }

  public static void loadFileEvaluatorWrapper(Cons arguments) {
    Stella.loadFile(((StringWrapper)(arguments.value)).wrapperValue);
  }

  public static Cons dropLoadPathEvaluatorWrapper(Cons arguments) {
    return (Stella.dropLoadPath(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static Cons addLoadPathEvaluatorWrapper(Cons arguments) {
    return (Stella.addLoadPath(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static StringWrapper popLoadPathEvaluatorWrapper(Cons arguments) {
    arguments = arguments;
    { String result = Stella.popLoadPath();

      if (result != null) {
        return (StringWrapper.wrapString(result));
      }
      else {
        return (null);
      }
    }
  }

  public static Cons pushLoadPathEvaluatorWrapper(Cons arguments) {
    return (Stella.pushLoadPath(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static Cons setLoadPathEvaluatorWrapper(Cons arguments) {
    return (Stella.setLoadPath(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static void transferFiles(Cons files, Keyword outputLanguage) {
    if (Stella.stringEqlP(Stella.rootSourceDirectory(), Stella.rootNativeDirectory())) {
      return;
    }
    { String flotsamfilename = "";
      String systemSubDirectory = (Stella.stringEqlP(((String)(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get())), "") ? "" : (((String)(Stella.$CURRENTSYSTEMDEFINITIONSUBDIRECTORY$.get())) + Stella.directorySeparatorString()));

      if (outputLanguage == Stella.KWD_JAVA) {
        flotsamfilename = Module.javaYieldFlotsamClassName(SystemDefinition.getCardinalModule(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
      }
      { Object old$Module$000 = Stella.$MODULE$.get();
        Object old$Context$000 = Stella.$CONTEXT$.get();

        try {
          Native.setSpecial(Stella.$MODULE$, SystemDefinition.getCardinalModule(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))));
          Native.setSpecial(Stella.$CONTEXT$, ((Module)(Stella.$MODULE$.get())));
          { StringWrapper f = null;
            Cons iter000 = files;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              f = ((StringWrapper)(iter000.value));
              { String filename = f.wrapperValue;
                Keyword type = Stella.classifyFileExtension(filename);
                String relativefilename = Stella.relativizeFileName(filename, Stella.rootSourceDirectory());
                String fromfilename = null;
                String tofilename = null;

                if (type == Stella.KWD_JAVA) {
                  if (Stella.stringEqlP(Stella.fileBaseName(filename), flotsamfilename)) {
                    {
                      Stella.STANDARD_WARNING.nativeStream.println("Warning: Native Java filename `" + flotsamfilename + "'");
                      Stella.STANDARD_WARNING.nativeStream.println(" conflicts with the Java catchall class' filename");
                    }
;
                  }
                }
                else {
                }
                fromfilename = Stella.rootSourceDirectory() + systemSubDirectory + filename;
                tofilename = Stella.makeFileName(relativefilename, type, true);
                if (!(Stella.fileYoungerThanP(tofilename, fromfilename) == Stella.TRUE_WRAPPER)) {
                  if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                    {
                      Stella.STANDARD_OUTPUT.nativeStream.println("Copying `" + fromfilename + "'");
                      Stella.STANDARD_OUTPUT.nativeStream.println(" to `" + tofilename + "' ...");
                    }
;
                  }
                  Stella.copyFile(fromfilename, tofilename);
                }
              }
            }
          }

        } finally {
          Stella.$CONTEXT$.set(old$Context$000);
          Stella.$MODULE$.set(old$Module$000);
        }
      }
    }
  }

  public static boolean helpTranslateSystem(Cons files, boolean twopassP, boolean forcetranslationP) {
    { Object old$Translationunits$000 = Stella.$TRANSLATIONUNITS$.get();

      try {
        Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
        { Keyword outputlanguage = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get()));
          String filename = null;
          boolean translatedfileP = false;
          KeyValueList walkedunits = KeyValueList.newKeyValueList();

          Stella.clearSymbolRegistry();
          if (twopassP) {
            { StringWrapper file = null;
              Cons iter000 = files;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                file = ((StringWrapper)(iter000.value));
                if (forcetranslationP ||
                    (Stella_Object.stellaNeedToTranslateP(file, outputlanguage) ||
                     (!((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())).loadedP))) {
                  filename = Stella.makeFileName(file.wrapperValue, Stella.KWD_STELLA, true);
                  if (!(Stella.probeFileP(filename))) {
                    Stella.STANDARD_OUTPUT.nativeStream.println("Warning: File `" + filename + "' does not exist.");
                    continue loop000;
                  }
                  Stella.operateOnFile(filename, Stella.KWD_DEFINE);
                  Stella.cleanUpTranslationUnitsSpecial();
                  translatedfileP = true;
                }
              }
            }
            if (translatedfileP) {
              if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
                Stella.STANDARD_OUTPUT.nativeStream.println("*** Pass 2, finalizing objects...");
              }
              Stella.finalizeClassesAndSlots();
            }
          }
          { StringWrapper file = null;
            Cons iter001 = files;

            loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              file = ((StringWrapper)(iter001.value));
              if (forcetranslationP ||
                  Stella_Object.stellaNeedToTranslateP(file, outputlanguage)) {
                filename = Stella.makeFileName(file.wrapperValue, Stella.KWD_STELLA, true);
                if (!(Stella.probeFileP(filename))) {
                  Stella.STANDARD_OUTPUT.nativeStream.println("Warning: File `" + filename + "' does not exist.");
                  continue loop001;
                }
                Stella.operateOnFile(filename, Stella.KWD_WALK);
                walkedunits.insertAt(StringWrapper.wrapString(filename), ((List)(Stella.$TRANSLATIONUNITS$.get())));
                Native.setSpecial(Stella.$TRANSLATIONUNITS$, List.newList());
              }
            }
          }
          walkedunits.reverse();
          if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 1) {
            Stella.STANDARD_OUTPUT.nativeStream.println("    ==============================");
          }
          if (outputlanguage == Stella.KWD_COMMON_LISP) {
            KeyValueList.clTranslateWalkedSystemUnits(walkedunits);
          }
          else if (outputlanguage == Stella.KWD_CPP) {
            KeyValueList.cppTranslateWalkedSystemUnits(walkedunits);
          }
          else if (outputlanguage == Stella.KWD_JAVA) {
            KeyValueList.javaTranslateWalkedSystemUnits(walkedunits);
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + outputlanguage + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
          Stella.clearSymbolRegistry();
          return (translatedfileP);
        }

      } finally {
        Stella.$TRANSLATIONUNITS$.set(old$Translationunits$000);
      }
    }
  }

  public static BooleanWrapper translateSystemEvaluatorWrapper(Cons arguments) {
    return ((Stella.translateSystem(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest) ? Stella.TRUE_WRAPPER : Stella.FALSE_WRAPPER));
  }

  public static boolean handleInModuleTree(Cons tree, boolean seeninmoduleP, boolean erroroninmoduleP, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Stella_Object firstarg = null;

      if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(operator))) {
        { Symbol operator000 = ((Symbol)(operator));

          { String testValue000 = (((Module)(Stella.$MODULE$.get())).caseSensitiveP ? Native.stringUpcase(operator000.symbolName) : operator000.symbolName);

            if (Stella.stringEqlP(testValue000, "IN-PACKAGE")) {
              { boolean _return_temp = true;

                MV_returnarray[0] = BooleanWrapper.wrapBoolean(seeninmoduleP);
                return (_return_temp);
              }
            }
            else if (Stella.stringEqlP(testValue000, "IN-MODULE")) {
              if (seeninmoduleP &&
                  erroroninmoduleP) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Additional IN-MODULE declaration: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                { boolean _return_temp = false;

                  MV_returnarray[0] = BooleanWrapper.wrapBoolean(seeninmoduleP);
                  return (_return_temp);
                }
              }
              firstarg = tree.rest.value;
              if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(firstarg))) {
                { StringWrapper firstarg000 = ((StringWrapper)(firstarg));

                  Stella.string_changeModule(firstarg000.wrapperValue);
                  seeninmoduleP = true;
                }
              }
              else {
                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationWarning();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                      {
                        Stella.STANDARD_WARNING.nativeStream.println();
                        Stella.STANDARD_WARNING.nativeStream.println(" Ignoring illegal IN-MODULE declaration: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
              }
              { boolean _return_temp = false;

                MV_returnarray[0] = BooleanWrapper.wrapBoolean(seeninmoduleP);
                return (_return_temp);
              }
            }
            else if (Stella.stringEqlP(testValue000, "DEFMODULE") ||
                Stella.stringEqlP(testValue000, "VERBATIM")) {
            }
            else {
              if (!(seeninmoduleP)) {
                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationWarning();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                      {
                        Stella.STANDARD_WARNING.nativeStream.println();
                        Stella.STANDARD_WARNING.nativeStream.println(" Missing IN-MODULE declaration, translating into module STELLA.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                Stella.string_changeModule("STELLA");
                seeninmoduleP = true;
              }
            }
          }
        }
      }
      else {
      }
      { boolean _return_temp = false;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(seeninmoduleP);
        return (_return_temp);
      }
    }
  }

  /** Non-keyword version of <code>composeNamestring</code>, which will probably be
   * easier to use when called from non-Lisp languages.
   * @param strings
   * @param prefix
   * @param suffix
   * @param outputcase
   * @param outputseparator
   * @param translationtable
   * @param useacronymheuristicsP
   * @return String
   */
  public static String composeNamestringFull(Cons strings, String prefix, String suffix, Keyword outputcase, String outputseparator, StringHashTable translationtable, boolean useacronymheuristicsP) {
    { int n = 0;
      int i = 0;
      StringBuffer out = null;
      int separatorLength = ((outputseparator != null) ? outputseparator.length() : 0);
      boolean firsttimeP = true;
      String s = null;
      int sLen = 0;

      if (translationtable != null) {
        { Cons temp = strings;

          strings = Stella.NIL;
          { StringWrapper sw = null;
            Cons iter000 = temp;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              sw = ((StringWrapper)(iter000.value));
              if (translationtable.lookup(sw.wrapperValue) != null) {
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(translationtable.lookup(sw.wrapperValue), Stella.NIL);
                    if (strings == Stella.NIL) {
                      strings = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(strings, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(translationtable.lookup(sw.wrapperValue), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
          }
        }
      }
      if (prefix != null) {
        n = n + prefix.length();
      }
      if (suffix != null) {
        n = n + suffix.length();
      }
      { StringWrapper sw = null;
        Cons iter001 = strings;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          sw = ((StringWrapper)(iter001.value));
          n = n + (sw.wrapperValue).length();
        }
      }
      n = n + ((strings.length() - 1) * separatorLength);
      out = Stella.makeRawMutableString(n);
      if (prefix != null) {
        i = Stella.insertString(prefix, 0, Stella.NULL_INTEGER, out, i, Stella.KWD_PRESERVE);
      }
      { StringWrapper sw = null;
        Cons iter002 = strings;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          sw = ((StringWrapper)(iter002.value));
          s = sw.wrapperValue;
          sLen = s.length();
          if (!(firsttimeP)) {
            if (separatorLength > 0) {
              i = Stella.insertString(outputseparator, 0, separatorLength - 1, out, i, Stella.KWD_PRESERVE);
            }
          }
          if (sLen == 0) {
          }
          else if (useacronymheuristicsP &&
              Stella.heuristicAcronymP(s)) {
            i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_PRESERVE);
          }
          else {
            if ((outputcase == Stella.KWD_ALLCAPS) ||
                (outputcase == Stella.KWD_UPCASE)) {
              i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_UPCASE);
            }
            else if (outputcase == Stella.KWD_DOWNCASE) {
              i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_DOWNCASE);
            }
            else if (outputcase == Stella.KWD_TITLECASE) {
              i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_CAPITALIZE);
            }
            else if (outputcase == Stella.KWD_TITLECASEX) {
              if (firsttimeP) {
                i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_DOWNCASE);
              }
              else {
                i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_CAPITALIZE);
              }
            }
            else if (outputcase == Stella.KWD_CAPITALIZE) {
              if (firsttimeP) {
                i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_CAPITALIZE);
              }
              else {
                i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_DOWNCASE);
              }
            }
            else if (outputcase == Stella.KWD_PRESERVE) {
              i = Stella.insertString(s, 0, sLen - 1, out, i, Stella.KWD_PRESERVE);
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + outputcase + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
          firsttimeP = false;
        }
      }
      if (suffix != null) {
        i = Stella.insertString(suffix, 0, Stella.NULL_INTEGER, out, i, Stella.KWD_PRESERVE);
      }
      return (out.toString());
    }
  }

  /** <code>nameComponents</code> is a cons to be processed into a namestring.
   * ':prefix' and ':suffix' are strings that will NOT be case-converted.
   * ':case' is one of :UPCASE :TitleCase :titleCaseX :downcase :Capitalize
   *         default is :TitleCase
   * ':separator' is a string that should separate word elements.  It does not
   *        separate the prefix or suffix.  Default is &quot;&quot;
   * ':translation-table' should be a STRING-HASH-TABLE hash table that strings into their
   *        desired printed representation as a string.  In general the argument
   *        will be strings, but that is not strictly necessary.
   * 
   * @param nameComponents
   * @param options
   * @return String
   */
  public static String composeNamestring(Cons nameComponents, Cons options) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList plist = self000;
        String prefix = "";
        String suffix = "";
        Keyword outputcase = Stella.KWD_TITLECASE;
        String outputseparator = "";
        StringHashTable translationTable = null;
        boolean useAcronymHeuristicsP = false;

        Stella_Object.vetOptions(plist, Stella.getQuotedTree("((:PREFIX :SUFFIX :CASE :SEPARATOR :TRANSLATION-TABLE :USE-ACRONYM-HEURISTICS?) \"/STELLA\")", "/STELLA"));
        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = plist.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

              if (testValue000 == Stella.KWD_PREFIX) {
                prefix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_SUFFIX) {
                suffix = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_CASE) {
                outputcase = ((Keyword)(value));
              }
              else if (testValue000 == Stella.KWD_SEPARATOR) {
                outputseparator = ((StringWrapper)(value)).wrapperValue;
              }
              else if (testValue000 == Stella.KWD_TRANSLATION_TABLE) {
                translationTable = ((StringHashTable)(value));
              }
              else if (testValue000 == Stella.KWD_USE_ACRONYM_HEURISTICSp) {
                useAcronymHeuristicsP = value == Stella.TRUE_WRAPPER;
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
        return (Cons.composeNamestringFull(nameComponents, prefix, suffix, outputcase, outputseparator, translationTable, useAcronymHeuristicsP));
      }
    }
  }

  public static void inPlaceNormalizeDemonOptions(Cons optionstree) {
    { ConsIterator it = optionstree.allocateIterator();

      while (it.nextP()) {
        if (Stella_Object.wrapperP(it.value)) {
          it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_LITERAL, Cons.cons(it.value, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else if (it.value == Stella.SYM_STELLA_TRUE) {
          it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_BOOLEAN, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
        else if (it.value == Stella.SYM_STELLA_FALSE) {
          it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_WRAP_BOOLEAN, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))));
        }
      }
    }
  }

  public static Cons destructureDefdemonBody(Cons demontree, Object [] MV_returnarray) {
    { Cons optionstree = demontree;
      Cons bodytree = demontree;
      Cons trailingcursor = null;

      while (Stella_Object.keywordP(bodytree.value)) {
        trailingcursor = bodytree;
        bodytree = bodytree.rest.rest;
      }
      if (trailingcursor != null) {
        trailingcursor.rest.rest = Stella.NIL;
      }
      else {
        optionstree = Stella.NIL;
      }
      { Cons _return_temp = optionstree;

        MV_returnarray[0] = bodytree;
        return (_return_temp);
      }
    }
  }

  /** Compute the value of an expression and memoize it relative to
   *    the values of <code>inputargs</code>.
   * <code>inputargs</code> should characterize the complete set of values upon which
   *    the computation of the result depended.
   * Calls to <code>memoize</code> should be of the form
   * <p>
   *       (memoize (&lt;arg&gt;+) {:&lt;option&gt; &lt;value&gt;}* &lt;expression&gt;)
   * <p>
   *    and have the status of an expression.
   *    The following options are supported:
   * <p>
   *       :timestamps   A single or list of keywords specifying the names of
   *                     timestamps which when bumped should invalidate all
   *                     entries currently memoized in this table.
   *       :name         Names the memoization table so it can be shared by other
   *                     memoization sites.  By default, a gensymed name is used.
   *                     CAUTION: IT IS ASSUMED THAT ALL ENTRIES IN A MEMOZATION
   *                     TABLE DEPEND ON THE SAME NUMBER OF ARGUMENTS!!
   *       :max-values   The maximum number of values to be memoized.  Only the
   *                     <code>CmaxValues</code> most recently used values will be kept
   *                     in the memoization table, older values will be discarded
   *                     and recomputed if needed.  Without a <code>CmaxValues</code>
   *                     specification, the memoization table will grow
   *                     indefinitely.
   * <p>
   * PERFORMANCE NOTES: For most efficient lookup, input arguments that vary the most
   * should be listed first.  Also, arguments of type STANDARD-OBJECT (and all its
   * subtypes) can be memoized more efficiently than arguments of type OBJECT or
   * wrapped literals (with the exception of BOOLEANs).
   * @param inputargs
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object memoize(Cons inputargs, Cons body) {
    { Surrogate memoname = null;
      Symbol memotablevar = Stella.localGensym("MEMO-TABLE");
      Symbol memoentryvar = Stella.localGensym("MEMOIZED-ENTRY");
      Symbol memovaluevar = Stella.localGensym("MEMOIZED-VALUE");
      int nofinputs = inputargs.length();
      PropertyList options = null;
      Stella_Object lookupfunction = null;
      Cons lookuptree = Stella.NIL;
      StandardObject valuetypespec = null;
      boolean alleqP = true;
      int eqvector = 0;

      body = Cons.cons(Stella.NIL, body);
      options = Cons.parseMemoizeOptions(Cons.extractOptions(body, null));
      body = body.rest;
      memoname = ((Surrogate)(options.lookup(Stella.KWD_NAME)));
      if (memoname == null) {
        memoname = Symbol.makeMemoizationTableSurrogate(null);
      }
      { ConsIterator it = inputargs.allocateIterator();
        int index = Stella.NULL_INTEGER;
        int iter000 = 0;

        for (;it.nextP(); iter000 = iter000 + 1) {
          index = iter000;
          { Stella_Object walkedarg = null;
            StandardObject type = null;

            { Object [] caller_MV_returnarray = new Object[1];

              walkedarg = Stella_Object.walkATree(it.value, caller_MV_returnarray);
              type = ((StandardObject)(caller_MV_returnarray[0]));
            }
            if (StandardObject.subTypeSpecOfP(type, Stella.SGT_STELLA_STANDARD_OBJECT) ||
                (StandardObject.subTypeSpecOfP(type, Stella.SGT_STELLA_BOOLEAN_WRAPPER) ||
                 StandardObject.subTypeSpecOfP(type, Stella.SGT_STELLA_BOOLEAN))) {
              if (index < 12) {
                eqvector = (eqvector | ((1 << index)));
              }
            }
            else {
              alleqP = false;
            }
            it.valueSetter(Stella_Object.sysTree(walkedarg, type, new Object[1]));
          }
        }
      }
      lookupfunction = ((options.lookup(Stella.KWD_MAX_VALUES) == null) ? (((nofinputs <= 4) ? Stella.SYM_STELLA_LOOKUP_MEMOIZED_VALUE : Stella.SYM_STELLA_LOOKUP_MEMOIZED_VALUEN)) : (((nofinputs <= 4) ? Stella.SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUE : Stella.SYM_STELLA_LOOKUP_MRU_MEMOIZED_VALUEN)));
      switch (nofinputs) {
        case 0: 
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing memoization input argument specification.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (Stella_Object.walkDontCallMeTree(body, Stella.SGT_STELLA_OBJECT, new Object[1]));
        case 1: 
          lookuptree = Cons.cons(lookupfunction, Cons.cons(memotablevar, Cons.cons(inputargs.value, Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMOIZED_NULL_VALUE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons((alleqP ? IntegerWrapper.wrapInteger(-1) : IntegerWrapper.wrapInteger(eqvector)), Cons.cons(Stella.NIL, Stella.NIL)))))))));
        break;
        case 2: 
          lookuptree = Cons.cons(lookupfunction, Cons.cons(memotablevar, Cons.cons(inputargs.value, Cons.cons(inputargs.rest.value, Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMOIZED_NULL_VALUE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons((alleqP ? IntegerWrapper.wrapInteger(-1) : IntegerWrapper.wrapInteger(eqvector)), Cons.cons(Stella.NIL, Stella.NIL)))))))));
        break;
        case 3: 
          lookuptree = Cons.cons(lookupfunction, Cons.cons(memotablevar, Cons.cons(inputargs.value, Cons.cons(inputargs.rest.value, Cons.cons(inputargs.rest.rest.value, Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMOIZED_NULL_VALUE, Cons.cons((alleqP ? IntegerWrapper.wrapInteger(-1) : IntegerWrapper.wrapInteger(eqvector)), Cons.cons(Stella.NIL, Stella.NIL)))))))));
        break;
        case 4: 
          lookuptree = Cons.cons(lookupfunction, Cons.cons(memotablevar, Cons.cons(inputargs.value, Cons.cons(inputargs.rest.value, Cons.cons(inputargs.rest.rest.value, Cons.cons(inputargs.fourth(), Cons.cons((alleqP ? IntegerWrapper.wrapInteger(-1) : IntegerWrapper.wrapInteger(eqvector)), Stella.NIL)))))));
        break;
        default:
          lookuptree = Cons.cons(lookupfunction, Cons.cons(memotablevar, Cons.list$(Cons.cons(Cons.cons(Stella.SYM_STELLA_CONS_LIST, inputargs.concatenate(Stella.NIL, Stella.NIL)), Cons.cons((alleqP ? IntegerWrapper.wrapInteger(-1) : IntegerWrapper.wrapInteger(eqvector)), Cons.cons(Stella.NIL, Stella.NIL))))));
        break;
      }
      valuetypespec = Stella_Object.computeExpressionType(body.value, true);
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.list$(Cons.cons(Cons.cons(memotablevar, Cons.list$(Cons.cons(Stella.SYM_STELLA_MEMOIZATION_TABLE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(memoentryvar, Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(memovaluevar, Cons.list$(Cons.cons(Stella.SYM_STELLA_OBJECT, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Stella.SYM_STELLA_$MEMOIZATION_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memotablevar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SURROGATE_VALUE, Cons.cons(memoname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(memotablevar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INITIALIZE_MEMOIZATION_TABLE, Cons.cons(memoname, Cons.cons(Cons.cons(StringWrapper.wrapString(Native.stringify(options.thePlist)), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memotablevar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SURROGATE_VALUE, Cons.cons(memoname, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memoentryvar, Cons.cons(Cons.cons(lookuptree, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memovaluevar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FIRST, Cons.cons(memoentryvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(memovaluevar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EQLp, Cons.cons(memovaluevar, Cons.cons(Cons.cons(Stella.SYM_STELLA_MEMOIZED_NULL_VALUE, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memovaluevar, Cons.cons(Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(memovaluevar, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Stella.SYM_STELLA_$MEMOIZATION_ENABLEDp$, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VALUE, Cons.cons(memoentryvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(memovaluevar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_MEMOIZED_NULL_VALUE, Cons.cons(memovaluevar, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(memovaluevar, Cons.cons(Cons.cons(StandardObject.yieldTypeSpecTree(valuetypespec), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))));
    }
  }

  public static PropertyList parseMemoizeOptions(Cons options) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = options;
      { PropertyList givenoptions = self000;
        PropertyList parsedoptions = PropertyList.newPropertyList();

        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = givenoptions.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(key));

              if (testValue000 == Stella.KWD_TIMESTAMPS) {
                if (!Stella_Object.consP(value)) {
                  value = Cons.cons(value, Stella.NIL);
                }
                { boolean testValue001 = false;

                  { boolean alwaysP000 = true;

                    { Stella_Object ts = null;
                      Cons iter001 = ((Cons)(value));

                      loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                        ts = iter001.value;
                        if (!Stella_Object.keywordP(ts)) {
                          alwaysP000 = false;
                          break loop001;
                        }
                      }
                    }
                    testValue001 = alwaysP000;
                  }
                  testValue001 = !testValue001;
                  if (testValue001) {
                    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationError();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                          {
                            Stella.STANDARD_ERROR.nativeStream.println();
                            Stella.STANDARD_ERROR.nativeStream.println(" Illegal :timestamp value in memoize: `" + Stella_Object.deUglifyParseTree(value) + "'.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                      }
                    }
                  }
                  else {
                    parsedoptions.insertAt(key, value);
                  }
                }
              }
              else if (testValue000 == Stella.KWD_NAME) {
                if (!Stella_Object.isaP(value, Stella.SGT_STELLA_GENERALIZED_SYMBOL)) {
                  { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal :name value in memoize: `" + Stella_Object.deUglifyParseTree(value) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                }
                else {
                  parsedoptions.insertAt(key, Symbol.makeMemoizationTableSurrogate(Symbol.internDerivedSymbol(((GeneralizedSymbol)(value)), ((GeneralizedSymbol)(value)).symbolName)));
                }
              }
              else if (testValue000 == Stella.KWD_MAX_VALUES) {
                if (!Stella_Object.integerP(value)) {
                  { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal :max-values value in memoize: `" + Stella_Object.deUglifyParseTree(value) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                    }
                  }
                }
                else {
                  parsedoptions.insertAt(key, value);
                }
              }
              else {
                { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal memoize option: `" + Stella_Object.deUglifyParseTree(key) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                  }
                }
              }
            }
          }
        }
        return (parsedoptions);
      }
    }
  }

  public static Cons findMemoizedValueEntryn(Cons bucket, Cons tuple, int eqvector, boolean deleteentryP) {
    { Cons entries = bucket.rest;
      Cons result = null;

      if (eqvector < 0) {
        loop000 : while (!(entries == Stella.NIL)) {
          { boolean alwaysP000 = true;

            { Stella_Object entryarg = null;
              Cons iter000 = ((Cons)(entries.value)).rest;
              Stella_Object inputarg = null;
              Cons iter001 = tuple;

              loop001 : for (;(!(iter000 == Stella.NIL)) &&
                        (!(iter001 == Stella.NIL)); iter000 = iter000.rest, iter001 = iter001.rest) {
                entryarg = iter000.value;
                inputarg = iter001.value;
                if (!(entryarg == inputarg)) {
                  alwaysP000 = false;
                  break loop001;
                }
              }
            }
            if (alwaysP000) {
              result = ((Cons)(entries.value));
              break loop000;
            }
          }
          entries = entries.rest;
        }
      }
      else {
        loop002 : while (!(entries == Stella.NIL)) {
          result = ((Cons)(entries.value));
          { Stella_Object entryarg = null;
            Cons iter002 = result.rest;
            Stella_Object inputarg = null;
            Cons iter003 = tuple;

            loop003 : for (;(!(iter002 == Stella.NIL)) &&
                      (!(iter003 == Stella.NIL)); iter002 = iter002.rest, iter003 = iter003.rest) {
              entryarg = iter002.value;
              inputarg = iter003.value;
              if ((entryarg == inputarg) ||
                  (((eqvector & 1) == 0) &&
                   Stella_Object.eqlP(entryarg, inputarg))) {
                eqvector = (eqvector >> 1);
              }
              else {
                result = null;
                break loop003;
              }
            }
          }
          if (result != null) {
            break loop002;
          }
          else {
            entries = entries.rest;
          }
        }
      }
      if (deleteentryP &&
          (result != null)) {
        entries.value = ((Cons)(bucket.rest.value));
        if ((bucket.rest = bucket.rest.rest) == Stella.NIL) {
          bucket.rest = Stella.NIL;
        }
      }
      return (result);
    }
  }

  public static Cons findMemoizedValueEntry(Cons bucket, Stella_Object arg1, Stella_Object arg2, Stella_Object arg3, Stella_Object arg4, int eqvector, boolean deleteentryP) {
    { Cons entries = bucket.rest;
      Cons args = Stella.NIL;
      Cons result = null;

      if (eqvector < 0) {
        loop000 : while (!(entries == Stella.NIL)) {
          args = ((Cons)(entries.value)).rest;
          if (args.value == arg1) {
            if (arg2 == Stella.MEMOIZED_NULL_VALUE) {
              result = ((Cons)(entries.value));
              break loop000;
            }
            args = args.rest;
            if (args.value == arg2) {
              if (arg3 == Stella.MEMOIZED_NULL_VALUE) {
                result = ((Cons)(entries.value));
                break loop000;
              }
              args = args.rest;
              if (args.value == arg3) {
                if (arg4 == Stella.MEMOIZED_NULL_VALUE) {
                  result = ((Cons)(entries.value));
                  break loop000;
                }
                args = args.rest;
                if (args.value == arg4) {
                  result = ((Cons)(entries.value));
                  break loop000;
                }
              }
            }
          }
          entries = entries.rest;
        }
      }
      else {
        { Stella_Object arg = null;

          loop001 : while (!(entries == Stella.NIL)) {
            args = ((Cons)(entries.value)).rest;
            arg = args.value;
            if ((arg == arg1) ||
                (((eqvector & 1) == 0) &&
                 ((arg != null) &&
                  ((arg1 != null) &&
                   arg.objectEqlP(arg1))))) {
              if (arg2 == Stella.MEMOIZED_NULL_VALUE) {
                result = ((Cons)(entries.value));
                break loop001;
              }
              args = args.rest;
              arg = args.value;
              if ((arg == arg2) ||
                  (((eqvector & 2) == 0) &&
                   ((arg != null) &&
                    ((arg2 != null) &&
                     arg.objectEqlP(arg2))))) {
                if (arg3 == Stella.MEMOIZED_NULL_VALUE) {
                  result = ((Cons)(entries.value));
                  break loop001;
                }
                args = args.rest;
                arg = args.value;
                if ((arg == arg3) ||
                    (((eqvector & 4) == 0) &&
                     ((arg != null) &&
                      ((arg3 != null) &&
                       arg.objectEqlP(arg3))))) {
                  if (arg4 == Stella.MEMOIZED_NULL_VALUE) {
                    result = ((Cons)(entries.value));
                    break loop001;
                  }
                  args = args.rest;
                  arg = args.value;
                  if ((arg == arg4) ||
                      (((eqvector & 8) == 0) &&
                       ((arg != null) &&
                        ((arg4 != null) &&
                         arg.objectEqlP(arg4))))) {
                    result = ((Cons)(entries.value));
                    break loop001;
                  }
                }
              }
            }
            entries = entries.rest;
          }
        }
      }
      if (deleteentryP &&
          (result != null)) {
        entries.value = ((Cons)(bucket.rest.value));
        if ((bucket.rest = bucket.rest.rest) == Stella.NIL) {
          bucket.rest = Stella.NIL;
        }
      }
      return (result);
    }
  }

  public static int hashMemoizedArgumentsn(Cons tuple, int eqvector) {
    { int hashcode = 0;

      if (eqvector < 0) {
        { Stella_Object arg = null;
          Cons iter000 = tuple;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            arg = iter000.value;
            if (arg == null) {
              arg = Stella.MEMOIZED_NULL_VALUE;
            }
            hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
            hashcode = (hashcode ^ (arg.hashCode()));
          }
        }
      }
      else {
        { Stella_Object arg = null;
          Cons iter001 = tuple;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            arg = iter001.value;
            if (arg == null) {
              arg = Stella.MEMOIZED_NULL_VALUE;
            }
            hashcode = (((hashcode & 1) == 0) ? (hashcode >>> 1) : (((hashcode >> 1)) | Stella.$INTEGER_MSB_MASK$));
            hashcode = (hashcode ^ ((((eqvector & 1) == 0) ? arg.hashCode_() : arg.hashCode())));
            eqvector = (eqvector >> 1);
          }
        }
      }
      return (hashcode);
    }
  }

  /** Defines a function called MAIN which will have the appropriate
   * signature for the target translation language.  The signature will be:
   *   C++:   public static int main (int v1, char** v2) {&lt;body&gt;}
   *   Java:  public static void main (String [] v2) {&lt;body&gt;}
   *   Lisp:  (defun main (&amp;rest args) &lt;body&gt;)
   * The argument <code>varlist</code> must have two symbols, which will be the names for the
   * INTEGER argument count and an array of STRINGs with the argument values.  It
   * can also be empty to indicate that no command line arguments will be handled.
   * The startup function for the containing system will automatically be called
   * before <code>body</code> is executed unless the option :STARTUP-SYSTEM? was supplied as
   * FALSE.  There can only be one DEFMAIN per module.
   * @param varlist
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object defmain(Cons varlist, Cons body) {
    { boolean processcmdlineargsP = !(varlist == Stella.NIL);
      Symbol v1Name = ((Symbol)(varlist.value));
      Symbol v2Name = ((Symbol)(varlist.rest.value));
      Symbol mainname = Symbol.internSymbolInModule("MAIN", ((Module)(Stella.$MODULE$.get())), true);
      Cons bodywithheader = Cons.cons(null, body);

      { PropertyList self000 = PropertyList.newPropertyList();

        self000.thePlist = Cons.extractOptions(bodywithheader, null);
        { PropertyList options = self000;
          Cons startupfunctioncall = (((((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get())) != null) &&
              (!(options.lookup(Stella.KWD_STARTUP_SYSTEMp) == Stella.SYM_STELLA_FALSE))) ? Cons.cons(Cons.cons(SystemDefinition.systemStartupFunctionSymbol(((SystemDefinition)(Stella.$CURRENTSYSTEMDEFINITION$.get()))), Stella.NIL), Stella.NIL) : Stella.NIL);

          startupfunctioncall = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF_STELLA_FEATURE, Cons.cons(Stella.KWD_SUPPORT_UNEXEC, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_CPP, Cons.cons(StringWrapper.wrapString("freopen (\"/dev/tty\",\"w\",stdout); freopen (\"/dev/tty\",\"w\",stderr); freopen (\"/dev/tty\",\"r\",stdin)"), Cons.cons(Stella.KWD_OTHERWISE, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), startupfunctioncall.concatenate(Stella.NIL, Stella.NIL));
          options.removeAt(Stella.KWD_STARTUP_SYSTEMp);
          options.removeAt(Stella.KWD_PUBLICp);
          body = options.thePlist.concatenate(bodywithheader.rest, Stella.NIL);
          if (!processcmdlineargsP) {
            if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(mainname, Cons.cons(Cons.list$(Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(startupfunctioncall.concatenate(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL))))), Stella.NIL)))));
            }
            else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
                ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
                 (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL))) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(mainname, Cons.cons(Stella.SYM_STELLA_INTEGER, Stella.NIL)), Cons.cons(Stella.NIL, Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(startupfunctioncall.concatenate(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL))))))));
            }
            else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(mainname, Cons.cons(Cons.list$(Cons.cons(Cons.cons(Cons.cons(Stella.localGensym("ARGV"), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ARRAY, Cons.cons(Stella.NIL, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)), Stella.NIL), Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(startupfunctioncall.concatenate(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL))))), Stella.NIL)))));
            }
            else {
            }
          }
          else {
            if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(mainname, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_aREST, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_rrARGS, Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.cons(v1Name, Cons.list$(Cons.cons(Stella.SYM_STELLA_INTEGER, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LENGTH"), Cons.cons(Stella.SYM_STELLA_rrARGS, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(v2Name, Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ARRAY, Cons.cons(Stella.NIL, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MAKE-ARRAY"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LENGTH"), Cons.cons(Stella.SYM_STELLA_rrARGS, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_INITIAL_CONTENTS, Cons.cons(Stella.SYM_STELLA_rrARGS, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(startupfunctioncall.concatenate(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)))));
            }
            else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(mainname, Cons.cons(Cons.list$(Cons.cons(Cons.cons(Cons.cons(v2Name, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ARRAY, Cons.cons(Stella.NIL, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)), Stella.NIL), Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(v1Name, Cons.list$(Cons.cons(Stella.SYM_STELLA_INTEGER, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_JAVA, Cons.cons(StringWrapper.wrapString(Symbol.javaTranslateName(v2Name).wrapperValue + ".length"), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(startupfunctioncall.concatenate(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)))));
            }
            else if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
                ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE) ||
                 (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_IDL))) {
              return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFUN, Cons.cons(Cons.cons(mainname, Cons.cons(Stella.SYM_STELLA_INTEGER, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Cons.cons(v1Name, Cons.cons(Stella.SYM_STELLA_INTEGER, Stella.NIL)), Cons.cons(Cons.cons(v2Name, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ARRAY, Cons.cons(Stella.NIL, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.KWD_PUBLICp, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(startupfunctioncall.concatenate(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_RETURN, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL))))))));
            }
            else {
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
                  Stella.STANDARD_ERROR.nativeStream.println(" `defmain' is not supported for `" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "'.");
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
  }

  /** Ignore unused 'variables' with NoOp 'setq' statements.
   * @param variables
   * @return Stella_Object
   */
  public static Stella_Object ignore(Cons variables) {
    { Cons ignoretrees = Stella.NIL;

      { Stella_Object variable = null;
        Cons iter000 = variables;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          variable = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(variable, Stella.NIL), Stella.NIL)))), Stella.NIL);
              if (ignoretrees == Stella.NIL) {
                ignoretrees = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(ignoretrees, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(variable, Stella.NIL), Stella.NIL)))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.prognify(ignoretrees));
    }
  }

  /** Allocate 'transient' (as opposed to 'permanent')
   * objects within the scope of this declaration.
   * CAUTION: The default assumption is the allocation of permanent objects.
   * The scope of <code>withTransientObjects</code> should be as small as possible, and
   * the user has to make sure that code that wasn't explicitly written to
   * account for transient objects will continue to work correctly.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withTransientObjects(Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$TRANSIENTOBJECTSp$, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Allocate 'permanent' (as opposed to 'transient')
   * objects within the scope of this declaration.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withPermanentObjects(Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$TRANSIENTOBJECTSp$, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Use a VRLET to collect values.  Input can have one of
   * the following forms:
   * 	 
   *   (collect &lt;var&gt; in &lt;expression&gt; [where &lt;test&gt; &lt;var&gt;])
   *   (collect &lt;collect-expression&gt;
   *            foreach &lt;var&gt; in &lt;expression&gt;
   *            {as ...}*
   *            [where &lt;test&gt; &lt;var&gt;]
   *            [do ...])
   * 	
   * The second form really accepts an arbitrary <code>foreach</code> expression following
   * the <code>foreach</code> keyword.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object collect(Cons body) {
    { Symbol collection = Stella.localGensym("VALUE");

      if (body.rest.value == Stella.SYM_STELLA_FOREACH) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(collection, Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL)), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_FOREACH, body.rest.rest.concatenate(Cons.list$(Cons.cons(Stella.SYM_STELLA_COLLECT, Cons.cons(body.value, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTO, Cons.cons(collection, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL)), Cons.cons(collection, Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
      else {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(collection, Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(body.value, Cons.cons(body.rest.concatenate(Cons.list$(Cons.cons(Stella.SYM_STELLA_COLLECT, Cons.cons(body.value, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTO, Cons.cons(collection, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(collection, Cons.cons(Stella.NIL, Stella.NIL)))))));
      }
    }
  }

  /** Evaluate each of the forms in 'forms', and
   * return TRUE if none of them are NULL.
   * @param forms
   * @return Stella_Object
   */
  public static Stella_Object allDefinedP(Cons forms) {
    switch (forms.length()) {
      case 0: 
        return (Stella.SYM_STELLA_TRUE);
      case 1: 
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(forms.value, Cons.cons(Stella.NIL, Stella.NIL)))));
      default:
        { Cons tests = Stella.NIL;

          { Stella_Object f = null;
            Cons iter000 = forms;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              f = iter000.value;
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(f, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
                  if (tests == Stella.NIL) {
                    tests = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(tests, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(f, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          return (Cons.cons(Stella.SYM_STELLA_AND, tests.concatenate(Stella.NIL, Stella.NIL)));
        }
    }
  }

  /** Return the result of the first form in <code>forms</code> whose value is defined
   * or NULL otherwise.
   * @param forms
   * @return Stella_Object
   */
  public static Stella_Object firstDefined(Cons forms) {
    switch (forms.length()) {
      case 0: 
        return (Stella.SYM_STELLA_NULL);
      case 1: 
        return (forms.value);
      case 2: 
        if (Stella_Object.symbolP(forms.value)) {
          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(forms.value, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(forms.value, Cons.cons(Cons.cons(forms.rest.value, Stella.NIL), Stella.NIL))))));
        }
        else {
          { Symbol letvariable = Stella.localGensym("TEMP");

            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(letvariable, Cons.cons(forms.value, Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(letvariable, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(letvariable, Cons.cons(Cons.cons(forms.rest.value, Stella.NIL), Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
          }
        }
      default:
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_FIRST_DEFINED, Cons.cons(forms.value, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_FIRST_DEFINED, forms.rest.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))));
    }
  }

  /** Push 'value' onto the cons list 'place'.
   * @param place
   * @param value
   * @return Stella_Object
   */
  public static Stella_Object pushf(Cons place, Stella_Object value) {
    { Cons placecopy = ((Cons)(Stella_Object.copyConsTree(place)));

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(place, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(value, Cons.cons(Cons.cons(placecopy, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))));
    }
  }

  /** Find the XML attribute in <code>attributes</code> with <code>name</code> and <code>namespace</code> and
   * return its value.  Note that it is assumed that all <code>attributes</code> come from
   * the same known tag, hence, the parent elements of any local attributes are
   * not considered by the lookup.
   * @param attributes
   * @param name
   * @param namespace
   * @return String
   */
  public static String xmlLookupAttribute(Cons attributes, String name, String namespace) {
    while (!(attributes == Stella.NIL)) {
      if (((XmlAttribute)(attributes.value)).xmlAttributeMatchP(name, namespace)) {
        return (StringWrapper.unwrapString(((StringWrapper)(attributes.rest.value))));
      }
      attributes = attributes.rest.rest;
    }
    return (null);
  }

  /** Return the CDATA content of a CDATA <code>form</code>.  Does NOT make sure that <code>form</code>
   * actually is a CDATA form, so bad things can happen if it is given wrong input.
   * @param form
   * @return String
   */
  public static String getXmlCdataContent(Cons form) {
    return (StringWrapper.unwrapString(((StringWrapper)(((Cons)(form.rest.value)).value))));
  }

  /** Return the list of content elements of an XML <code>expression</code> (may be empty).
   * @param expression
   * @return Cons
   */
  public static Cons getXmlContent(Cons expression) {
    return (expression.rest.rest);
  }

  /** Return the last base url attribute in the attribute list of this
   * element if it exists.  Otherwise NULL.
   * @param expression
   * @return String
   */
  public static String getXmlBaseAttributeValue(Cons expression) {
    { Cons attributeList = ((Cons)(expression.rest.value));
      XmlAttribute attribute = null;
      String value = null;
      String baseAttributeValue = null;

      while (!(attributeList == Stella.NIL)) {
        { Stella_Object head000 = attributeList.value;

          attributeList = attributeList.rest;
          attribute = ((XmlAttribute)(head000));
        }
        { Stella_Object head001 = attributeList.value;

          attributeList = attributeList.rest;
          value = ((StringWrapper)(head001)).wrapperValue;
        }
        if (Stella_Object.isaP(attribute, Stella.SGT_STELLA_XML_GLOBAL_ATTRIBUTE) &&
            (Stella.stringEqlP("base", ((XmlGlobalAttribute)(attribute)).name) &&
             Stella.stringEqlP(Stella.$XML_URN$, ((XmlGlobalAttribute)(attribute)).namespaceUri))) {
          baseAttributeValue = value;
        }
      }
      return (baseAttributeValue);
    }
  }

  /** Return the list of attributes of an XML <code>expression</code> (may be empty).
   * @param expression
   * @return Cons
   */
  public static Cons getXmlAttributes(Cons expression) {
    return (((Cons)(expression.rest.value)));
  }

  /** Return the XML tag object of an XML <code>expression</code>.
   * @param expression
   * @return XmlElement
   */
  public static XmlElement getXmlTag(Cons expression) {
    return (((XmlElement)(expression.value)));
  }

  public static boolean xmlRegionMatchesP(Cons regionspec, Cons regiontag) {
    if (Stella_Object.eqlP(regionspec.value, regiontag.value)) {
      { PropertyList specattributes = null;
        PropertyList tagattributes = null;
        Cons specattributesource = ((Cons)(regionspec.rest.value));

        if ((specattributesource != null) &&
            (!(specattributesource == Stella.NIL))) {
          { PropertyList self000 = PropertyList.newPropertyList();

            self000.thePlist = ((Cons)(regionspec.rest.value));
            specattributes = self000;
          }
        }
        else {
          return (true);
        }
        { PropertyList self001 = PropertyList.newPropertyList();

          self001.thePlist = ((Cons)(regiontag.rest.value));
          tagattributes = self001;
        }
        { Stella_Object key = null;
          Stella_Object value = null;
          Cons iter000 = specattributes.thePlist;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
            key = iter000.value;
            value = iter000.rest.value;
            if (!Stella_Object.eqlP(tagattributes.lookup(key), value)) {
              return (false);
            }
          }
        }
        return (true);
      }
    }
    else {
      return (false);
    }
  }

  public static Cons processAttributeList(Cons reverseattributelist, XmlElement element, KvCons namespaceTable) {
    if (reverseattributelist == Stella.NIL) {
      return (Stella.NIL);
    }
    { Cons attributelist = Stella.NIL;
      Cons conscell = null;
      String attributename = null;

      while (!(reverseattributelist == Stella.NIL)) {
        conscell = new Cons();
        conscell.value = reverseattributelist.value;
        reverseattributelist = reverseattributelist.rest;
        conscell.rest = attributelist;
        attributelist = conscell;
        if (reverseattributelist == Stella.NIL) {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("Malformed attribute list in XML element `" + element + "'");
            throw ((BadArgumentException)(BadArgumentException.newBadArgumentException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
        attributename = ((TokenizerToken)(reverseattributelist.value)).content;
        reverseattributelist = reverseattributelist.rest;
        conscell = new Cons();
        if (Stella.xmlnsAttributeNameP(attributename)) {
          conscell.value = Stella.makeXmlnsAttribute(attributename);
        }
        else {
          conscell.value = Stella.makeXmlAttributeRespectingNamespace(attributename, element, namespaceTable);
        }
        conscell.rest = attributelist;
        attributelist = conscell;
      }
      return (attributelist);
    }
  }

  /** Takes an S-Expression representing a doctype and processes into
   * a DOCTYPE object.
   * @param doctypeDeclaration
   * @return XmlDoctype
   */
  public static XmlDoctype processDoctype(Cons doctypeDeclaration) {
    if ((doctypeDeclaration != null) &&
        ((!(doctypeDeclaration == Stella.NIL)) &&
         (Stella_Object.isaP(doctypeDeclaration.value, Stella.SGT_STELLA_XML_DECLARATION) &&
          Stella.stringEqlP("DOCTYPE", ((XmlDeclaration)(doctypeDeclaration.value)).name)))) {
      { XmlDoctype doctype = XmlDoctype.newXmlDoctype();
        InputStream definitionStream = null;
        XmlExpressionIterator iterator = null;

        try {
          doctype.name = ((StringWrapper)(((Cons)(doctypeDeclaration.rest.value)).value)).wrapperValue;
          definitionStream = Cons.getDoctypeDefinition(doctypeDeclaration);
          if (definitionStream != null) {
            { XmlExpressionIterator self001 = XmlExpressionIterator.newXmlExpressionIterator();

              self001.theStream = definitionStream;
              self001.doctypeIteratorP = true;
              self001.doctype = doctype;
              iterator = self001;
            }
            { Stella_Object declaration = null;
              XmlExpressionIterator iter000 = iterator;

              while (iter000.nextP()) {
                declaration = iter000.value;
                if (Stella_Object.isaP(((Cons)(declaration)).value, Stella.SGT_STELLA_XML_DECLARATION) &&
                    Stella.stringEqlP("ENTITY", ((XmlDeclaration)(((Cons)(declaration)).value)).name)) {
                  { Cons attributes = ((Cons)(((Cons)(declaration)).rest.value));

                    if (Stella.stringEqlP("%", ((StringWrapper)(attributes.value)).wrapperValue)) {
                      if ((attributes.length() > 3) &&
                          Stella_Object.externalIdHeadP(attributes.rest.rest.value)) {
                        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                          stream000.nativeStream.print("Can't handle external entity definitions: `" + declaration + "'");
                          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
                        }
                      }
                      else {
                        Stella.addXmlReference(((StringWrapper)(attributes.rest.value)).wrapperValue, ((StringWrapper)(attributes.rest.rest.value)).wrapperValue, doctype.parameterEntityTable);
                      }
                    }
                    else {
                      if ((attributes.length() > 2) &&
                          Stella_Object.externalIdHeadP(attributes.rest.value)) {
                        { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                          stream001.nativeStream.print("Can't handle external entity definitions: `" + declaration + "'");
                          throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
                        }
                      }
                      else {
                        Stella.addXmlReference(((StringWrapper)(attributes.value)).wrapperValue, ((StringWrapper)(attributes.rest.value)).wrapperValue, doctype.entityTable);
                      }
                    }
                  }
                }
              }
            }
          }
          if (definitionStream != null) {
            definitionStream.free();
          }

        } finally {
        }
        return (doctype);
      }
    }
    else {
      return (null);
    }
  }

  static InputStream getDoctypeDefinition(Cons doctype) {
    { String definition = ((StringWrapper)(((Cons)(doctype.rest.value)).rest.value)).wrapperValue;

      if (Stella.internalDtdDefinitionP(definition)) {
        return (InputStringStream.newInputStringStream(Native.string_subsequence(definition, 1, definition.length() - 2)));
      }
      else {
        return (null);
      }
    }
  }

  public static Stella_Object getQualifiedSymbolSeparatorPosition(Cons escapemode) {
    { Stella_Object escape = escapemode.value;

      if (escape == null) {
        escape = Stella.KWD_NONE;
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_QUALIFIED_SYMBOL_SEPARATOR_POSITION_INTERNAL, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(escape, Cons.cons(Stella.NIL, Stella.NIL)))))))));
    }
  }

  public static Stella_Object getNextStellaToken(Cons options) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.cons(Stella.SYM_STELLA_GET_NEXT_TOKEN, options.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_STELLALOGICALSTATENAME_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(Stella.SYM_STELLA_TOK_STELLALOGICALSTATENAMES_, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
  }

  public static Stella_Object getNextToken(Cons options) {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-next-token' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_NEXT_TOKEN, Stella.NIL));
    }
    { Stella_Object savestreamstateP = options.value;
      Cons savestreamstatetree = Cons.cons(Cons.cons(Stella.SYM_STELLA_SAVE_TOKENIZER_STREAM_STATE, Stella.NIL), Stella.NIL);

      if ((savestreamstateP == null) ||
          (savestreamstateP == Stella.SYM_STELLA_TRUE)) {
      }
      else if (savestreamstateP == Stella.SYM_STELLA_FALSE) {
        savestreamstatetree = Stella.NIL;
      }
      else {
        savestreamstatetree = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(savestreamstateP, Cons.cons(savestreamstatetree.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL);
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOOP, Cons.cons((Stella.withTokenizerStringInputP() ? Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LEGAL_EOF_STATES, Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL)))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURSOR, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_READ_INTO_TOKENIZER_BUFFER, Cons.cons(Stella.SYM_STELLA_TOK_INPUTSTREAM_, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BUFFER, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BUFFER_SIZE, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MOD, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CURSOR, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_END, Cons.cons(Stella.SYM_STELLA_TOK_STREAMSTATE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LEGAL_EOF_STATES, Cons.cons(Stella.SYM_STELLA_TOK_TABLE_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_ENDOFTOKENSp_, Cons.cons(Stella.SYM_STELLA_FALSE, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ge, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))))))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CHECKPOINT_, Cons.cons(Stella.SYM_STELLA_TOK_END_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHARACTER_CODE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BYTE_ARRAY_NTH, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF_OUTPUT_LANGUAGE, Cons.cons(Stella.KWD_COMMON_LISP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_g, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(255), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(255), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CHARACTER_CODE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NTH, Cons.cons(Stella.SYM_STELLA_TOK_TRANSITIONS_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOGOR, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SHIFT_LEFT, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(IntegerWrapper.wrapInteger(8), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_COND, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOGAND, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(128), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(IntegerWrapper.wrapInteger(-1), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_e, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOGAND, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(64), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(Stella.SYM_STELLA_TOK_STATE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOGAND, Cons.cons(Stella.SYM_STELLA_TOK_NEXTSTATE_, Cons.cons(IntegerWrapper.wrapInteger(63), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons((((!Stella.withTokenizerStringInputP()) ? Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_TOK_ECHOSTREAM_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_TOK_ECHOSTREAM_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_BYTE_ARRAY_NTH, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_1_, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))))), Stella.NIL)))), Cons.cons(savestreamstatetree.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))));
    }
  }

  public static Stella_Object getTokenText(Cons options) {
    if (!Stella.insideWithTokenizerP()) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Encountered `get-token-text' outside of `with-tokenizer' macro..");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Cons.cons(Stella.SYM_STELLA_GET_TOKEN_TEXT, Stella.NIL));
    }
    { Stella_Object upcaseP = options.value;
      Stella_Object start = options.rest.value;
      Stella_Object end = options.rest.rest.value;

      if (upcaseP == Stella.SYM_STELLA_FALSE) {
        upcaseP = null;
      }
      if (Stella_Object.eqlP(start, Stella.ZERO_WRAPPER)) {
        start = null;
      }
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_TOKEN_TEXT_INTERNAL, Cons.cons(Stella.SYM_STELLA_TOK_BUFFER_, Cons.cons(((start == null) ? ((StandardObject)(Stella.SYM_STELLA_TOK_TOKENSTART_)) : ((StandardObject)(Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(start, Cons.cons(Stella.NIL, Stella.NIL)))))))), Cons.cons(Cons.cons(((end == null) ? ((StandardObject)(Stella.SYM_STELLA_TOK_CURSOR_)) : ((StandardObject)((Stella_Object.integerP(end) ? (((((IntegerWrapper)(end)).wrapperValue < 0) ? Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(end, Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(end, Cons.cons(Stella.NIL, Stella.NIL))))))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_CHOOSE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_l, Cons.cons(end, Cons.cons(Cons.cons(IntegerWrapper.wrapInteger(0), Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.SYM_STELLA_TOK_CURSOR_, Cons.cons(end, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_i, Cons.cons(Stella.SYM_STELLA_TOK_TOKENSTART_, Cons.cons(end, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))))))), Cons.list$(Cons.cons(Stella.SYM_STELLA_TOK_SIZE_, Cons.cons(((upcaseP != null) ? upcaseP : Stella.SYM_STELLA_FALSE), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))))));
    }
  }

  public static TokenizerTable parseTokenizerDefinition(Cons definition) {
    { Vector transitiontable = Vector.newVector(Stella.$MAX_TOKENIZER_STATES$);
      StringBuffer transitions = edu.isi.stella.javalib.Native.makeMutableString(Stella.$MAX_TOKENIZER_CHARACTERS$, Stella.NULL_CHARACTER);
      Vector uniquestatenames = Vector.newVector(Stella.$MAX_TOKENIZER_STATES$);
      Vector statenames = Vector.newVector(Stella.$MAX_TOKENIZER_STATES$);
      Vector legaleofstates = Vector.newVector(Stella.$MAX_TOKENIZER_STATES$);
      GeneralizedSymbol fromstatename = null;
      int fromstateid = Stella.NULL_INTEGER;
      GeneralizedSymbol tostatename = null;
      GeneralizedSymbol tostatealias = null;
      int tostateid = Stella.NULL_INTEGER;
      int freestateid = 2;
      Stella_Object characterspec = null;
      Cons characterset = null;
      List allcharactersets = List.newList();
      int statemodifiers = 0;
      boolean errorsP = false;
      TokenizerTable table = TokenizerTable.newTokenizerTable();

      (uniquestatenames.theArray)[0] = Stella.KWD_ERROR;
      (statenames.theArray)[0] = Stella.KWD_ERROR;
      (uniquestatenames.theArray)[1] = Stella.KWD_START;
      (statenames.theArray)[1] = Stella.KWD_START;
      { Cons statedefinition = null;
        Cons iter000 = definition;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          statedefinition = ((Cons)(iter000.value));
          if (!(Stella_Object.legalTokenizerFromStateP(statedefinition.value))) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal from state: `" + statedefinition.value + "'");
            errorsP = true;
            continue loop000;
          }
          fromstatename = ((GeneralizedSymbol)(statedefinition.value));
          statedefinition = statedefinition.rest;
          fromstateid = uniquestatenames.position(fromstatename, 0);
          if (fromstateid == Stella.NULL_INTEGER) {
            if (freestateid == Stella.$MAX_TOKENIZER_STATES$) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Too many tokenizer states; maximum is `" + Stella.$MAX_TOKENIZER_STATES$ + "'");
              errorsP = true;
              break loop000;
            }
            (uniquestatenames.theArray)[freestateid] = fromstatename;
            (statenames.theArray)[freestateid] = fromstatename;
            fromstateid = freestateid;
            freestateid = freestateid + 1;
          }
          allcharactersets.clear();
          { int i = Stella.NULL_INTEGER;
            int iter001 = 0;
            int upperBound000 = Stella.$MAX_TOKENIZER_CHARACTERS$ - 1;

            for (;iter001 <= upperBound000; iter001 = iter001 + 1) {
              i = iter001;
              edu.isi.stella.javalib.Native.mutableString_nthSetter(transitions, ((char) 0), i);
            }
          }
          loop002 : while (!(statedefinition == Stella.NIL)) {
            if (Stella_Object.tokenizerIncludeSpecP(statedefinition.value)) {
              if (!(Stella_Object.legalTokenizerFromStateP(statedefinition.rest.value))) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal include specification for state `" + fromstatename + "'");
                errorsP = true;
                break loop002;
              }
              statedefinition = Cons.copyConsList(statedefinition);
              { Cons statedef = null;
                Cons iter002 = definition;

                loop003 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  statedef = ((Cons)(iter002.value));
                  if (Stella_Object.eqlP(statedef.value, statedefinition.rest.value)) {
                    statedefinition.firstSetter(statedef.rest.value);
                    statedefinition.rest = Cons.copyConsList(statedef.rest.rest).concatenate(statedefinition.rest.rest, Stella.NIL);
                    break loop003;
                  }
                }
              }
              continue loop002;
            }
            statemodifiers = Stella_Object.parseTokenizerStateModifiers(statedefinition.value);
            if (statemodifiers > 0) {
              statedefinition = statedefinition.rest;
            }
            characterspec = statedefinition.value;
            statedefinition = statedefinition.rest;
            if (!(characterspec != null)) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal definition of `" + fromstatename + "' state");
              errorsP = true;
              break loop002;
            }
            if (!(Stella_Object.legalTokenizerToStateP(statedefinition.value))) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal to state `" + statedefinition.value + "' for state `" + fromstatename + "'");
              errorsP = true;
              break loop002;
            }
            if (characterspec == Stella.KWD_EOF) {
              (legaleofstates.theArray)[fromstateid] = Stella.TRUE_WRAPPER;
              statedefinition = statedefinition.rest;
              continue loop002;
            }
            tostatename = Stella_Object.tokenizerToStateName(statedefinition.value);
            tostatealias = Stella_Object.tokenizerToStateAlias(statedefinition.value);
            statedefinition = statedefinition.rest;
            tostateid = uniquestatenames.position(tostatename, 0);
            if (tostateid == Stella.NULL_INTEGER) {
              if (freestateid == Stella.$MAX_TOKENIZER_STATES$) {
                Stella.STANDARD_WARNING.nativeStream.println("Warning: Too many tokenizer states; maximum is `" + Stella.$MAX_TOKENIZER_STATES$ + "'");
                errorsP = true;
                break loop002;
              }
              (uniquestatenames.theArray)[freestateid] = tostatename;
              (statenames.theArray)[freestateid] = tostatealias;
              tostateid = freestateid;
              freestateid = freestateid + 1;
            }
            if ((!(((GeneralizedSymbol)((statenames.theArray)[tostateid])) == tostatealias)) &&
                (((GeneralizedSymbol)((statenames.theArray)[tostateid])) != null)) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal redefinition of alias `" + tostatealias + "' for state `" + tostatename + "' in state `" + fromstatename + "'");
              errorsP = true;
            }
            characterset = Stella_Object.parseTokenizerCharacterSpec(characterspec, allcharactersets);
            if (characterset == null) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: Illegal character specification `" + characterspec + "' for state `" + fromstatename + "'");
              errorsP = true;
              continue loop002;
            }
            allcharactersets.push(characterset);
            { CharacterWrapper renamed_Char = null;
              Cons iter003 = characterset;

              for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                renamed_Char = ((CharacterWrapper)(iter003.value));
                edu.isi.stella.javalib.Native.mutableString_nthSetter(transitions, ((char) ((((statemodifiers << 6)) | tostateid))), ((int) (renamed_Char.wrapperValue)));
              }
            }
          }
          (transitiontable.theArray)[fromstateid] = (MutableStringWrapper.wrapMutableString(transitions));
          transitions = edu.isi.stella.javalib.Native.makeMutableString(Stella.$MAX_TOKENIZER_CHARACTERS$, Stella.NULL_CHARACTER);
        }
      }
      { int i = Stella.NULL_INTEGER;
        int iter004 = 0;
        int upperBound001 = freestateid - 1;

        for (;iter004 <= upperBound001; iter004 = iter004 + 1) {
          i = iter004;
          if (((MutableStringWrapper)((transitiontable.theArray)[i])) == null) {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: State `" + ((GeneralizedSymbol)((uniquestatenames.theArray)[i])) + "' is undefined");
            errorsP = true;
          }
        }
      }
      if (errorsP) {
        return (null);
      }
      transitions = edu.isi.stella.javalib.Native.makeMutableString((freestateid * Stella.$MAX_TOKENIZER_CHARACTERS$), Stella.NULL_CHARACTER);
      { int i = Stella.NULL_INTEGER;
        int iter005 = 0;
        int upperBound002 = freestateid - 1;

        for (;iter005 <= upperBound002; iter005 = iter005 + 1) {
          i = iter005;
          { int j = Stella.NULL_INTEGER;
            int iter006 = 0;
            int upperBound003 = Stella.$MAX_TOKENIZER_CHARACTERS$ - 1;
            int k = Stella.NULL_INTEGER;
            int iter007 = Stella.$MAX_TOKENIZER_CHARACTERS$ * i;

            for (;iter006 <= upperBound003; iter006 = iter006 + 1, iter007 = iter007 + 1) {
              j = iter006;
              k = iter007;
              edu.isi.stella.javalib.Native.mutableString_nthSetter(transitions, ((((MutableStringWrapper)((transitiontable.theArray)[i])).wrapperValue).charAt(j)), k);
            }
          }
        }
      }
      table.transitions = transitions.toString();
      table.uniqueStateNames = Vector.newVector(freestateid);
      table.stateNames = Vector.newVector(freestateid);
      { int i = Stella.NULL_INTEGER;
        int iter008 = 0;
        int upperBound004 = freestateid - 1;

        for (;iter008 <= upperBound004; iter008 = iter008 + 1) {
          i = iter008;
          (table.uniqueStateNames.theArray)[i] = (((GeneralizedSymbol)((uniquestatenames.theArray)[i])));
          (table.stateNames.theArray)[i] = (((GeneralizedSymbol)((statenames.theArray)[i])));
        }
      }
      table.legalEofStates = Vector.newVector(freestateid);
      { int i = Stella.NULL_INTEGER;
        int iter009 = 0;
        int upperBound005 = freestateid - 1;

        for (;iter009 <= upperBound005; iter009 = iter009 + 1) {
          i = iter009;
          (table.legalEofStates.theArray)[i] = (((((BooleanWrapper)((legaleofstates.theArray)[i])) == null) ? Stella.FALSE_WRAPPER : ((BooleanWrapper)((legaleofstates.theArray)[i]))));
        }
      }
      return (table);
    }
  }

  public static Context cccEvaluatorWrapper(Cons arguments) {
    return (Stella.ccc(arguments));
  }

  public static Context ccEvaluatorWrapper(Cons arguments) {
    return (Stella.cc(arguments));
  }

  public static void clearModuleEvaluatorWrapper(Cons arguments) {
    Stella.clearModule(arguments);
  }

  public static void callClearModuleEvaluatorWrapper(Cons arguments) {
    Stella.callClearModule(arguments);
  }

  public static Cons listModulesEvaluatorWrapper(Cons arguments) {
    return (Stella.listModules(((BooleanWrapper)(arguments.value)).wrapperValue));
  }

  public static void defmoduleEvaluatorWrapper(Cons arguments) {
    Stella_Object.defmodule(arguments.value, arguments.rest);
  }

  public static Cons yieldDownCastTree(Cons tree, StandardObject returntype) {
    { Cons otree = Stella_Object.sysTree(tree, returntype, new Object[1]);

      if (!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) {
        Cons.setTargetLanguageType(otree, Stella.SGT_STELLA_OBJECT, new Object[1]);
      }
      return (otree);
    }
  }

  public static boolean clCompileAndLoadFiles(Cons files, boolean relativeP, boolean forcerecompilationP) {
    { Keyword lispkey = Stella.KWD_LISP;
      Keyword binarykey = Stella.KWD_LISP_BINARY;
      boolean translatedfileP = false;

      return (translatedfileP);
    }
  }

  public static Cons clYieldDeclareTree(Cons declarations, boolean includeTypeChecksP) {
    if (declarations == Stella.NIL) {
      return (Stella.NIL);
    }
    { Cons otherdeclarations = declarations.rest;
      Cons typechecks = Stella.NIL;

      if (includeTypeChecksP &&
          (((Integer)(Stella.$SAFETY$.get())).intValue() >= 1)) {
        { Cons decl = null;
          Cons iter000 = declarations;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            decl = ((Cons)(iter000.value));
            if (((Integer)(Stella.$SAFETY$.get())).intValue() <= 2) {
              typechecks = Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper("#+MCL"), typechecks);
            }
            typechecks = Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("CHECK-TYPE"), Cons.cons(decl.rest.rest.value, Cons.cons(Cons.cons(decl.rest.value, Stella.NIL), Stella.NIL)))), typechecks);
          }
        }
        typechecks = typechecks.reverse();
      }
      { Cons decl = null;
        Cons iter001 = declarations;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          decl = ((Cons)(iter001.value));
          if ((decl != null) &&
              (decl.value == Stella.internCommonLispSymbol("TYPE"))) {
            { Cons otherdecl = null;
              Cons iter002 = otherdeclarations;

              for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                otherdecl = ((Cons)(iter002.value));
                if ((otherdecl != null) &&
                    ((otherdecl.value == Stella.internCommonLispSymbol("TYPE")) &&
                     Stella_Object.eqlP(otherdecl.rest.value, decl.rest.value))) {
                  decl.concatenate(otherdecl.rest.rest, Stella.NIL);
                  otherdeclarations.substitute(null, otherdecl);
                }
              }
            }
          }
          otherdeclarations = otherdeclarations.rest;
        }
      }
      return (Cons.cons(Stella_Object.clConditionalizeTypeDeclarationTree(Cons.cons(Stella.internCommonLispSymbol("DECLARE"), declarations.remove(null).concatenate(Stella.NIL, Stella.NIL))), typechecks.concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static Cons clYieldLetVariableTypeDeclarationTrees(Cons bindingstree) {
    { Cons types = Stella.NIL;
      Symbol cltype = null;

      { Cons binding = null;
        Cons iter000 = bindingstree;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = ((Cons)(iter000.value));
          { Stella_Object type = binding.rest.value;

            if (type != null) {
              cltype = ((Symbol)(StandardObject.lookupClTypeFromStellaType(((StandardObject)(binding.rest.value)))));
            }
            if (cltype != null) {
              types = Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("TYPE"), Cons.cons(cltype, Cons.cons(Cons.cons(Symbol.clTranslateLocalSymbol(((Symbol)(binding.value))), Stella.NIL), Stella.NIL)))), types);
            }
          }
        }
      }
      return (types.reverse());
    }
  }

  public static Cons clTranslateInlineTree(Cons tree) {
    { Stella_Object operator = tree.value;
      Cons body = Cons.clTranslateListOfTrees(tree.rest);

      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(operator));

        if (testValue000 == Stella.SYM_STELLA_INLINE) {
          operator = Stella.internCommonLispSymbol("INLINE");
        }
        else if (testValue000 == Stella.SYM_STELLA_IGNORE) {
          operator = Stella.internCommonLispSymbol("IGNORE");
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLARE"), Cons.cons(Cons.cons(operator, body.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Stella_Object clTranslateVerbatimTree(Cons tree) {
    { Cons cursor = tree.rest;
      Stella_Object verbatimcode = null;

      loop000 : while (!(cursor == Stella.NIL)) {
        if (cursor.value == Stella.KWD_COMMON_LISP) {
          verbatimcode = cursor.rest.value;
          cursor.rest.value = null;
          break loop000;
        }
        cursor = cursor.rest.rest;
      }
      return (verbatimcode);
    }
  }

  public static Cons clTranslateTheCodeTree(Cons tree) {
    { Symbol name = ((tree.rest.value == Stella.KWD_FUNCTION) ? ((Symbol)(tree.rest.rest.value)) : ((Symbol)(tree.fourth())));

      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("FUNCTION"), Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.yieldRenamedNameIfNative(name, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION)), Cons.cons(Stella.NIL, Stella.NIL)))));
    }
  }

  public static Stella_Object clTranslateInlineCallTree(Cons tree) {
    { Cons calltree = ((Cons)(tree.rest.value));
      MethodSlot method = ((MethodSlot)(Cons.slotFromExpressionTree(calltree)));
      Cons args = ((calltree.value == Stella.SYM_STELLA_SYS_CALL_FUNCTION) ? calltree.nthRest(2) : calltree.nthRest(3));
      Cons translatedargs = Cons.clTranslateListOfTrees(args);
      Cons usedcomplexargs = Stella.NIL;
      Stella_Object argument = null;
      Stella_Object body = Cons.lookupVerbatimTree(((Cons)(Cons.walkVerbatimTree(((Cons)(MethodSlot.inlinableMethodBody(method))), new Object[1]))), null);
      List parameters = method.methodParameterNames();
      List parametertypes = method.methodParameterTypeSpecifiers();
      int parindex = 0;
      Cons otree = Stella.NIL;

      if (Stella_Object.safePrimaryType(body) == Stella.SGT_STELLA_CONS) {
        { Cons body000 = ((Cons)(body));

          { boolean alwaysP000 = true;

            { Stella_Object elt = null;
              Cons iter000 = body000;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                elt = iter000.value;
                if (!(!Stella_Object.consP(elt))) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            if (alwaysP000) {
              otree = Cons.cons(Stella_Object.clTranslateVerbatimBodySymbols(body000.value, Stella.NIL_LIST), Stella.NIL);
              { Stella_Object barg = null;
                Cons iter001 = body000.rest;

                loop001 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                  barg = iter001.value;
                  if (parameters.memberP(barg)) {
                    parindex = parameters.position(barg, 0);
                    argument = translatedargs.nth(parindex);
                    if (usedcomplexargs.memberP(argument)) {
                      otree = Stella.NIL;
                      break loop001;
                    }
                    if (Stella_Object.consP(argument)) {
                      usedcomplexargs = Cons.cons(argument, usedcomplexargs);
                      argument = Stella_Object.clYieldTypedExpressionTree(argument, ((StandardObject)(parametertypes.nth(parindex))));
                    }
                    otree = Cons.cons(argument, otree);
                  }
                  else {
                    otree = Cons.cons(Stella_Object.clTranslateVerbatimBodySymbols(barg, Stella.NIL_LIST), otree);
                  }
                }
              }
              if (!(otree == Stella.NIL)) {
                return (Stella_Object.clYieldTypedExpressionTree(otree.reverse(), method.type()));
              }
            }
          }
        }
      }
      else {
      }
      { Symbol par = null;
        Cons iter002 = parameters.theConsList;
        Stella_Object arg = null;
        Cons iter003 = translatedargs;
        Cons collect000 = null;

        for (;(!(iter002 == Stella.NIL)) &&
                  (!(iter003 == Stella.NIL)); iter002 = iter002.rest, iter003 = iter003.rest) {
          par = ((Symbol)(iter002.value));
          arg = iter003.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.cons(Symbol.clTranslateLocalSymbol(par), Cons.cons(arg, Stella.NIL)), Stella.NIL);
              if (otree == Stella.NIL) {
                otree = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(otree, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.cons(Symbol.clTranslateLocalSymbol(par), Cons.cons(arg, Stella.NIL)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LET"), Cons.cons(otree, Cons.cons(Cons.clYieldDeclareTree(MethodSlot.clYieldMethodParameterTypeDeclarationTrees(method), false).concatenate(Cons.cons(Stella_Object.clYieldTypedExpressionTree(Stella_Object.clTranslateVerbatimBodySymbols(Stella_Object.copyConsTree(body), parameters), method.type()), Stella.NIL), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons clTranslateCallFunctionCodeTree(Cons tree) {
    { boolean methodcodeP = tree.value == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE;
      Cons otree = tree.rest;

      otree.rest = Cons.clTranslateListOfTrees(otree.rest);
      otree.firstSetter(((methodcodeP &&
          ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) ? Stella.SYM_STELLA_CLSYS_METHOD_CODE_CALL : Stella.internCommonLispSymbol("FUNCALL")));
      return (otree);
    }
  }

  public static Cons clTranslatePrintStreamTree(Cons tree) {
    { Stella_Object stream = tree.rest.value;

      if (stream == Stella.KWD_WARN) {
        return (Cons.cons(Stella.internCommonLispSymbol("WARN"), Cons.yieldFormatArguments(tree).concatenate(Stella.NIL, Stella.NIL)));
      }
      else if (stream == Stella.KWD_ERROR) {
        return (Cons.cons(Stella.internCommonLispSymbol("ERROR"), Cons.yieldFormatArguments(tree).concatenate(Stella.NIL, Stella.NIL)));
      }
      else if (stream == Stella.KWD_CONTINUABLE_ERROR) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("CERROR"), Cons.cons(StringWrapper.wrapString("Continue anyway? "), Cons.cons(Cons.yieldFormatArguments(tree).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
      }
      else {
        return (Cons.yieldPrintTree(tree));
      }
    }
  }

  public static Cons yieldPrintTree(Cons tree) {
    { Stella_Object stream = tree.rest.value;
      Cons arguments = tree.rest.rest;
      Surrogate argumenttype = null;
      Symbol printoperator = null;
      String compoundedstring = null;
      Cons printforms = Stella.NIL;

      stream = Stella_Object.clTranslateATree(stream);
      { Stella_Object arg = null;
        Cons iter000 = arguments;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          arg = iter000.value;
          if (arg == Stella.EOL) {
            printforms = Cons.cons(arg, printforms);
            compoundedstring = null;
          }
          else {
            argumenttype = StandardObject.typeSpecToBaseType(Stella_Object.walkedExpressionType(arg));
            if (argumenttype == Stella.SGT_STELLA_STRING) {
              printoperator = Stella.internCommonLispSymbol("WRITE-STRING");
            }
            else {
              if (Surrogate.subtypeOfP(argumenttype, Stella.SGT_STELLA_OBJECT)) {
                printoperator = Stella.SYM_STELLA_PRINT_OBJECT;
              }
              else {
                printoperator = Stella.internCommonLispSymbol("PRINC");
              }
            }
            if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(arg))) {
              { StringWrapper arg000 = ((StringWrapper)(arg));

                if (compoundedstring != null) {
                  compoundedstring = compoundedstring + arg000.wrapperValue;
                  printforms.firstSetter(StringWrapper.wrapString(compoundedstring));
                  continue loop000;
                }
                compoundedstring = arg000.wrapperValue;
              }
            }
            else {
              compoundedstring = null;
            }
            if (Symbol.methodCallTypeForVectorStructs(printoperator, argumenttype, !(printoperator == Stella.SYM_STELLA_PRINT_OBJECT)) == Stella.SYM_STELLA_PRINT_OBJECT) {
              printforms = Cons.cons(Stella_Object.clTranslateATree(arg), printforms);
            }
            else {
              printforms = Cons.cons(Stella_Object.clTranslateATree(arg), printforms);
            }
          }
        }
      }
      printforms = printforms.reverse();
      return (Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_rrPRINT_STREAM), Cons.cons(stream, printforms.concatenate(Stella.NIL, Stella.NIL))));
    }
  }

  public static Cons yieldFormatArguments(Cons tree) {
    { String formatstring = "";
      Cons formatarguments = Stella.NIL;

      tree.rest.rest = tree.rest.rest.reverse();
      { Stella_Object arg = null;
        Cons iter000 = tree.rest.rest;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          arg = iter000.value;
          if (Stella_Object.stringP(arg)) {
            formatstring = ((StringWrapper)(arg)).wrapperValue + formatstring;
          }
          else if (arg == Stella.EOL) {
            formatstring = "~%" + formatstring;
          }
          else {
            formatstring = "~A" + formatstring;
            formatarguments = Cons.cons(Stella_Object.clTranslateATree(arg), formatarguments);
          }
        }
      }
      formatarguments = Cons.cons(StringWrapper.wrapString(formatstring), formatarguments);
      return (formatarguments);
    }
  }

  public static Cons clTranslateOperatorTree(Cons tree) {
    { Symbol operator = null;
      Surrogate owner = null;
      Cons arguments = null;

      { Object [] caller_MV_returnarray = new Object[2];

        operator = Cons.destructureCallTree(tree, caller_MV_returnarray);
        owner = ((Surrogate)(caller_MV_returnarray[0]));
        arguments = ((Cons)(caller_MV_returnarray[1]));
      }
      owner = owner;
      if (operator == Stella.SYM_STELLA_i) {
        if ((arguments.length() == 2) &&
            arguments.memberP(Stella.ONE_WRAPPER)) {
          if (Stella_Object.eqlP(arguments.value, Stella.ONE_WRAPPER)) {
            arguments = arguments.rest;
          }
          else {
            arguments.rest = Stella.NIL;
          }
          operator = Stella.internCommonLispSymbol("1+");
        }
      }
      else if (operator == Stella.SYM_STELLA__) {
        if ((arguments.length() == 2) &&
            Stella_Object.eqlP(arguments.rest.value, Stella.ONE_WRAPPER)) {
          arguments.rest = Stella.NIL;
          operator = Stella.internCommonLispSymbol("1-");
        }
      }
      else if (operator == Stella.SYM_STELLA_EQp) {
        return (((Cons)(Stella_Object.clTranslatePlainBooleanTest(tree, false))));
      }
      else {
      }
      if ((operator == Stella.SYM_STELLA_i) ||
          ((operator == Stella.SYM_STELLA__) ||
           ((operator == Stella.SYM_STELLA_$) ||
            (operator == Stella.SYM_STELLA_s)))) {
        operator = ((Symbol)(Stella.$CL_OPERATOR_TABLE$.lookup(operator)));
      }
      else {
      }
      return (Cons.cons(Symbol.clTranslateGlobalSymbol(operator), Cons.clTranslateListOfTrees(arguments).concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static Cons clTranslateNewArrayTree(Cons tree) {
    { Stella_Object initialelement = tree.rest.rest.value;
      Cons dimensions = Cons.clTranslateListOfTrees(tree.rest.rest.rest);

      initialelement = null;
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MAKE-ARRAY"), Cons.cons(((dimensions.length() == 1) ? dimensions.value : Cons.cons(Stella.internCommonLispSymbol("LIST"), dimensions.concatenate(Stella.NIL, Stella.NIL))), Cons.cons((((initialelement != null) ? Cons.list$(Cons.cons(Stella.KWD_INITIAL_ELEMENT, Cons.cons(Stella_Object.clTranslateATree(initialelement), Cons.cons(Stella.NIL, Stella.NIL)))) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
  }

  public static Cons clTranslateNewTree(Cons tree) {
    if (StandardObject.arrayTypeSpecifierP(((StandardObject)(tree.rest.value)))) {
      return (Cons.clTranslateNewArrayTree(tree));
    }
    { Stella_Object typespec = tree.rest.value;
      Stella_Object constructorname = Symbol.clTranslateGlobalSymbol(Stella_Class.yieldConstructorName(((Stella_Object.typeP(typespec) ? ((Surrogate)(typespec)) : ((ParametricTypeSpecifier)(typespec)).specifierBaseType)).getStellaClass(true)));
      Cons requiredargrefs = Cons.clTranslateListOfTrees(tree.rest.rest);

      return (Cons.cons(constructorname, requiredargrefs.concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static Cons clTranslateMakeTree(Cons tree) {
    { Stella_Class renamed_Class = ((Stella_Class)(Stella_Object.typify(tree.rest.value).surrogateValue));
      Stella_Object classsymbol = Stella_Class.clTranslateClassName(renamed_Class);
      Cons otree = null;

      if ((classsymbol == Stella.internCommonLispSymbol("CONS")) &&
          ((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_CONSES)) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("CONS"), Cons.cons(Stella.internCommonLispSymbol("NIL"), Cons.cons(Stella.internCommonLispSymbol("NIL"), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      if (Stella_Class.exceptionClassP(renamed_Class)) {
        otree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MAKE-CONDITION"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("QUOTE"), Cons.cons(classsymbol, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_$CONDITION_MESSAGE_KEYWORD$), Cons.cons(Cons.cons(Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_REPLACE_SUBSTRINGS), Cons.cons(Stella_Object.clTranslateATree(tree.rest.rest.value), Cons.list$(Cons.cons(StringWrapper.wrapString("~~"), Cons.cons(StringWrapper.wrapString("~"), Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL), Stella.NIL)))));
      }
      else if ((!((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_STRUCTS)) ||
          Stella_Class.clAlwaysTranslateToClosClassP(renamed_Class)) {
        otree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("MAKE-INSTANCE"), Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("QUOTE"), Cons.cons(classsymbol, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))));
      }
      else if (((List)(Stella.$CURRENT_STELLA_FEATURES$.get())).membP(Stella.KWD_USE_COMMON_LISP_VECTOR_STRUCTS)) {
        otree = Cons.cons(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CLSYS_MAKE), Cons.cons(classsymbol, Cons.cons(IntegerWrapper.wrapInteger(Stella_Class.clStructSlots(renamed_Class).length() + 1), Stella.NIL)));
      }
      else {
        otree = Cons.cons(Stella_Class.yieldStructConstructorName(renamed_Class), Stella.NIL);
      }
      return (otree);
    }
  }

  public static Cons clTranslateBooleanTree(Cons tree) {
    return (((Cons)(Stella_Object.clTranslateBooleanTest(tree, false))));
  }

  public static Cons clTranslateCaseTree(Cons tree) {
    { boolean otherwiseP = false;

      tree.secondSetter(Stella_Object.clTranslateATree(tree.rest.value));
      { Cons cond = null;
        Cons iter000 = ((Cons)(tree.rest.rest));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          cond = ((Cons)(iter000.value));
          if (cond.value == Stella.SYM_STELLA_OTHERWISE) {
            otherwiseP = true;
            cond.firstSetter(Stella.internCommonLispSymbol("OTHERWISE"));
          }
          else if (Stella_Object.consP(cond.value)) {
            cond.firstSetter(Cons.clTranslateListOfTrees(((Cons)(cond.value))));
          }
          else {
            cond.firstSetter(Stella_Object.clTranslateATree(cond.value));
          }
          cond.rest = Cons.clTranslateListOfTrees(cond.rest);
        }
      }
      tree.firstSetter((otherwiseP ? Stella.internCommonLispSymbol("CASE") : Stella.internCommonLispSymbol("ECASE")));
      return (tree);
    }
  }

  public static Cons clTranslateCondTree(Cons tree) {
    { Cons condition = null;
      Cons iter000 = ((Cons)(tree.rest));

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        condition = ((Cons)(iter000.value));
        if (condition.value == Stella.SYM_STELLA_OTHERWISE) {
          condition.value = Stella.internCommonLispSymbol("T");
        }
        else {
          condition.value = Stella_Object.clTranslateBooleanTest(condition.value, false);
        }
        condition.rest = Cons.clTranslateListOfTrees(condition.rest);
      }
    }
    tree.value = Stella.internCommonLispSymbol("COND");
    return (tree);
  }

  public static Cons clTranslateConditionalTree(Cons tree) {
    { Stella_Object operator = tree.value;
      Stella_Object test = tree.rest.value;
      Cons body = tree.rest.rest;

      tree.rest.rest = Stella.NIL;
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(operator));

        if ((testValue000 == Stella.SYM_STELLA_IF) ||
            (testValue000 == Stella.SYM_STELLA_CHOOSE)) {
          return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("IF"), Cons.cons(Stella_Object.clTranslateBooleanTest(test, false), Cons.cons(Cons.cons(Stella_Object.clTranslateATree(body.value), Cons.cons(Stella_Object.clTranslateATree(body.rest.value), Stella.NIL)), Stella.NIL)))));
        }
        else if (testValue000 == Stella.SYM_STELLA_WHEN) {
          return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("WHEN"), Cons.cons(Stella_Object.clTranslateBooleanTest(test, false), Cons.cons(Cons.clTranslateListOfTrees(body).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
        }
        else if (testValue000 == Stella.SYM_STELLA_UNLESS) {
          return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("WHEN"), Cons.cons(Stella_Object.clTranslateBooleanTest(test, true), Cons.cons(Cons.clTranslateListOfTrees(body).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
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

  public static Cons clTranslateWhileTree(Cons tree) {
    { Stella_Object test = Stella_Object.clTranslateBooleanTest(tree.rest.value, false);
      Cons body = Cons.clTranslateListOfTrees(tree.rest.rest);

      tree.rest.rest = Stella.NIL;
      return (((body == Stella.NIL) ? Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LOOP"), Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(test, Cons.cons(Stella.NIL, Stella.NIL))))) : Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LOOP"), Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(test, Cons.cons(Cons.cons(Stella.SYM_STELLA_DO, Cons.maybeWrapWithContinueLabel(body).concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)))))));
    }
  }

  public static Stella_Object clTranslateReturnTree(Cons tree) {
    { Cons returnvalues = Cons.clTranslateListOfTrees(tree.rest);

      if (!(returnvalues.rest == Stella.NIL)) {
        returnvalues = Cons.cons(Cons.cons(Stella.internCommonLispSymbol("VALUES"), returnvalues.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL);
      }
      return ((((!((Boolean)(Stella.$NEEDEXPLICITRETURNp$.get())).booleanValue()) &&
          Stella.preserveTailMergeOptimizabilityP()) ? returnvalues.value : Cons.list$(Cons.cons(Stella.internCommonLispSymbol("RETURN-FROM"), Cons.cons(Symbol.clTranslateGlobalSymbol(Symbol.yieldRenamedNameIfNative(((MethodSlot)(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject)).slotName, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION)), Cons.cons(returnvalues.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))))));
    }
  }

  public static Stella_Object clTranslateCastTree(Cons tree) {
    { Stella_Object expression = tree.rest.value;
      Surrogate type = StandardObject.typeSpecToBaseType(((StandardObject)(tree.rest.rest.value)));

      tree.secondSetter(Stella_Object.clTranslateATree(expression));
      tree.thirdSetter(Stella_Object.clTranslateATree(type));
      if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_NUMBER) &&
          Stella_Object.isaP(expression, Stella.SGT_STELLA_NUMBER_WRAPPER)) {
        return (NumberWrapper.coerceNumericConstant(((NumberWrapper)(expression)), type).clTranslateAtomicTree());
      }
      else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_FLOAT)) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("FLOAT"), Cons.cons(tree.rest.value, Cons.cons(Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper("0.0d0"), Stella.NIL), Stella.NIL)))));
      }
      else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_INTEGER) ||
          Surrogate.subtypeOfP(type, Stella.SGT_STELLA_LONG_INTEGER)) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("TRUNCATE"), Cons.cons(tree.rest.value, Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      if ((((Integer)(Stella.$SAFETY$.get())).intValue() < 2) ||
          ((tree.value == Stella.SYM_STELLA_SAFE_CAST) ||
           (Stella_Class.lookupSlot(Surrogate.typeToClass(type), Stella.SYM_STELLA_PRIMARY_TYPE) == null))) {
        expression = tree.rest.value;
        tree.secondSetter(Stella.NIL);
        return (expression);
      }
      tree.firstSetter(Symbol.clTranslateGlobalSymbol(Stella.SYM_STELLA_CAST));
      return (tree);
    }
  }

  public static Cons clTranslateHandleExceptionTree(Cons tree) {
    { Symbol var = ((Symbol)(((Cons)(tree.rest.value)).value));
      StandardObject type = ((StandardObject)(((Cons)(tree.rest.value)).rest.value));

      tree.value = Stella_Class.clTranslateClassName(Surrogate.typeToClass(StandardObject.typeSpecToBaseType(type)));
      if (var != null) {
        tree.secondSetter(Cons.cons(Symbol.clTranslateLocalSymbol(var), Stella.NIL));
      }
      else {
        tree.secondSetter(Stella.NIL);
      }
      tree.rest.rest = Cons.clTranslateListOfTrees(tree.rest.rest);
      return (tree);
    }
  }

  public static Cons clTranslateHandlerCaseTree(Cons tree) {
    tree.value = Stella.internCommonLispSymbol("HANDLER-CASE");
    tree.rest = Cons.clTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Cons clTranslateSignalTree(Cons tree) {
    tree.value = Stella.internCommonLispSymbol("ERROR");
    tree.secondSetter(Stella_Object.clTranslateATree(tree.rest.value));
    tree.rest.rest = Stella.NIL;
    return (tree);
  }

  public static Cons clTranslateUnwindProtectTree(Cons tree) {
    tree.value = Stella.internCommonLispSymbol("UNWIND-PROTECT");
    tree.rest = Cons.clTranslateListOfTrees(tree.rest);
    return (tree);
  }

  public static Cons clTranslateStartupTimePrognTree(Cons tree) {
    tree.value = Stella.internCommonLispSymbol("PROGN");
    tree.rest = Cons.clTranslateListOfTrees(tree.rest);
    return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("EVAL-WHEN"), Cons.cons(Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper(":LOAD-TOPLEVEL"), Cons.cons(VerbatimStringWrapper.newVerbatimStringWrapper(":EXECUTE"), Stella.NIL)), Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL))))));
  }

  public static Cons clTranslateSpecialTree(Cons tree) {
    { Cons translatedtree = Cons.clTranslateLetTree(tree, true);
      Cons specialvars = Stella.NIL;

      { Cons decl = null;
        Cons iter000 = ((Cons)(tree.rest.value));
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          decl = ((Cons)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(decl.value, Stella.NIL);
              if (specialvars == Stella.NIL) {
                specialvars = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(specialvars, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(decl.value, Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      translatedtree.rest.rest = Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("DECLARE"), Cons.cons(Cons.cons(Stella.internCommonLispSymbol("SPECIAL"), specialvars.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))), translatedtree.rest.rest);
      return (translatedtree);
    }
  }

  public static Cons clTranslateLetTree(Cons tree, boolean specialP) {
    { Cons odeclarations = Stella.NIL;
      Cons typedeclarations = (Stella.generateClTypeDeclarationsP() ? Cons.clYieldLetVariableTypeDeclarationTrees(((Cons)(tree.rest.value))) : Stella.NIL);

      { Cons d = null;
        Cons iter000 = ((Cons)(tree.rest.value));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          d = ((Cons)(iter000.value));
          odeclarations = Cons.cons(Cons.cons((specialP ? Symbol.clTranslateGlobalSymbol(((Symbol)(d.value))) : Symbol.clTranslateLocalSymbol(((Symbol)(d.value)))), Cons.cons(Stella_Object.clTranslateATree(d.rest.rest.value), Stella.NIL)), odeclarations);
        }
      }
      tree.firstSetter(Stella.internCommonLispSymbol("LET*"));
      tree.secondSetter(odeclarations.reverse());
      tree.rest.rest = Cons.clYieldDeclareTree(typedeclarations, false).concatenate(Cons.clTranslateListOfTrees(tree.rest.rest), Stella.NIL);
      return (tree);
    }
  }

  public static Cons maybeWrapWithContinueLabel(Cons translatedloopbody) {
    if (Stella_Object.searchConsTreeWithFilterP(translatedloopbody, Stella.KWD_CONTINUE, Stella.getQuotedTree("((CL:LOOP QUOTE) \"/STELLA\")", "/STELLA"))) {
      return (Cons.cons(Cons.cons(Stella.internCommonLispSymbol("TAGBODY"), translatedloopbody.concatenate(Cons.cons(Stella.KWD_CONTINUE, Stella.NIL), Stella.NIL)), Stella.NIL));
    }
    else {
      return (translatedloopbody);
    }
  }

  public static Cons clTranslateForeachTree(Cons tree) {
    { Cons iteratorbindings = ((Cons)(tree.rest.value));
      Cons valuetrees = ((Cons)(tree.rest.rest.value));
      Cons nexttrees = ((Cons)(tree.fourth()));
      Stella_Object continuationtest = Stella_Object.clTranslateBooleanTest(tree.fifth(), false);
      Cons body = Cons.clTranslateListOfTrees(tree.nthRest(5));
      Cons declarations = Stella.NIL;
      Cons valueassignments = Stella.NIL;
      Cons nextassignments = Stella.NIL;
      Cons typedeclarations = Stella.NIL;
      Stella_Object iteratorconstructor = null;

      if (Stella.generateClTypeDeclarationsP()) {
        typedeclarations = Cons.clYieldLetVariableTypeDeclarationTrees(iteratorbindings);
      }
      { Cons binding = null;
        Cons iter000 = iteratorbindings;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = ((Cons)(iter000.value));
          iteratorconstructor = Stella_Object.clTranslateATree(binding.rest.rest.value);
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Cons.cons(Symbol.clTranslateLocalSymbol(((Symbol)(binding.value))), Cons.cons(iteratorconstructor, Stella.NIL)), Stella.NIL);
              if (declarations == Stella.NIL) {
                declarations = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(declarations, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Cons.cons(Symbol.clTranslateLocalSymbol(((Symbol)(binding.value))), Cons.cons(iteratorconstructor, Stella.NIL)), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Cons tree000 = null;
        Cons iter001 = valuetrees;
        Cons collect001 = null;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          tree000 = ((Cons)(iter001.value));
          if (collect001 == null) {
            {
              collect001 = Cons.cons(Stella_Object.clTranslateATree(tree000), Stella.NIL);
              if (valueassignments == Stella.NIL) {
                valueassignments = collect001;
              }
              else {
                Cons.addConsToEndOfConsList(valueassignments, collect001);
              }
            }
          }
          else {
            {
              collect001.rest = Cons.cons(Stella_Object.clTranslateATree(tree000), Stella.NIL);
              collect001 = collect001.rest;
            }
          }
        }
      }
      { Cons tree000 = null;
        Cons iter002 = nexttrees;
        Cons collect002 = null;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          tree000 = ((Cons)(iter002.value));
          if (collect002 == null) {
            {
              collect002 = Cons.cons(Stella_Object.clTranslateATree(tree000), Stella.NIL);
              if (nextassignments == Stella.NIL) {
                nextassignments = collect002;
              }
              else {
                Cons.addConsToEndOfConsList(nextassignments, collect002);
              }
            }
          }
          else {
            {
              collect002.rest = Cons.cons(Stella_Object.clTranslateATree(tree000), Stella.NIL);
              collect002 = collect002.rest;
            }
          }
        }
      }
      return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LET*"), Cons.cons(declarations, Cons.cons(Cons.clYieldDeclareTree(typedeclarations, false).concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LOOP"), Cons.cons(Stella.SYM_STELLA_WHILE, Cons.cons(continuationtest, Cons.cons(Cons.cons(Stella.SYM_STELLA_DO, valueassignments.concatenate(Cons.maybeWrapWithContinueLabel(body).concatenate(nextassignments.concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL)), Stella.NIL))))), Stella.NIL), Stella.NIL), Stella.NIL)))));
    }
  }

  public static Stella_Object clTranslateArgumentListTree(Cons tree) {
    { Symbol operator = null;
      Surrogate owner = null;
      Cons arguments = null;

      { Object [] caller_MV_returnarray = new Object[2];

        operator = Cons.destructureCallTree(tree, caller_MV_returnarray);
        owner = ((Surrogate)(caller_MV_returnarray[0]));
        arguments = ((Cons)(caller_MV_returnarray[1]));
      }
      owner = owner;
      if (operator == Stella.SYM_STELLA_ALLOCATE_ITERATOR) {
        return (Stella_Object.clTranslateATree(arguments.value));
      }
      else if (operator == Stella.SYM_STELLA_LENGTH) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("LENGTH"), Cons.cons(Stella_Object.clTranslateATree(arguments.value), Cons.cons(Stella.NIL, Stella.NIL)))));
      }
      else if (operator == Stella.SYM_STELLA_NEXTp) {
        return (Stella_Object.clTranslateATree(arguments.value));
      }
      else if (operator == Stella.SYM_STELLA_ARGUMENT) {
        return (Cons.list$(Cons.cons(Stella.internCommonLispSymbol("POP"), Cons.cons(Stella_Object.clTranslateATree(arguments.value), Cons.cons(Stella.NIL, Stella.NIL)))));
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
                Stella.STANDARD_ERROR.nativeStream.println(" Cannot translate call to `" + Stella_Object.deUglifyParseTree(operator) + "' on an `ARGUMENT-LIST'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Cons.cons(operator, Cons.cons(Stella_Object.clTranslateATree(arguments.value), Stella.NIL)));
      }
    }
  }

  public static Cons clTranslateArefTree(Cons tree) {
    { Symbol operator = null;
      Surrogate owner = null;
      Cons arguments = null;

      { Object [] caller_MV_returnarray = new Object[2];

        operator = Cons.destructureCallTree(tree, caller_MV_returnarray);
        owner = ((Surrogate)(caller_MV_returnarray[0]));
        arguments = ((Cons)(caller_MV_returnarray[1]));
      }
      if (owner == Stella.SGT_STELLA_ARRAY) {
        { boolean setterP = operator == Stella.SYM_STELLA_AREF_SETTER;
          Stella_Object array = arguments.value;
          StandardObject arraytype = Stella_Object.walkedExpressionType(array);
          Cons indices = (setterP ? arguments.rest.rest : arguments.rest);
          Stella_Object value = (setterP ? arguments.rest.value : ((Stella_Object)(null)));

          operator = Stella.internCommonLispSymbol("AREF");
          array = Stella_Object.clTranslateATree(array);
          indices = Cons.clTranslateListOfTrees(indices);
          if (Stella.generateClTypeDeclarationsP()) {
            if (Stella_Object.consP(array)) {
              array = Stella_Object.clYieldTypedExpressionTree(array, arraytype);
            }
            { ConsIterator it = indices.allocateIterator();

              while (it.nextP()) {
                if (Stella_Object.consP(it.value)) {
                  it.valueSetter(Stella_Object.clYieldTypedExpressionTree(it.value, Stella.SGT_STELLA_INTEGER));
                }
              }
            }
          }
          tree = Cons.cons(operator, Cons.cons(array, indices.concatenate(Stella.NIL, Stella.NIL)));
          if (setterP) {
            tree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("SETF"), Cons.cons(tree, Cons.cons(Cons.cons(Stella_Object.clTranslateATree(value), Stella.NIL), Stella.NIL))));
          }
          return (tree);
        }
      }
      else {
        return (Symbol.clTranslateNormalCallMethodTree(operator, owner, arguments));
      }
    }
  }

  public static Cons clTranslateNthTree(Cons tree) {
    { Symbol operator = null;
      Surrogate owner = null;
      Cons arguments = null;

      { Object [] caller_MV_returnarray = new Object[2];

        operator = Cons.destructureCallTree(tree, caller_MV_returnarray);
        owner = ((Surrogate)(caller_MV_returnarray[0]));
        arguments = ((Cons)(caller_MV_returnarray[1]));
      }
      { boolean setterP = operator == Stella.SYM_STELLA_NTH_SETTER;
        Stella_Object collection = arguments.value;
        Stella_Object position = arguments.last();
        Stella_Object value = (setterP ? arguments.rest.value : ((Stella_Object)(null)));

        if ((owner == Stella.SGT_STELLA_STRING) ||
            ((owner == Stella.SGT_STELLA_MUTABLE_STRING) ||
             (owner == Stella.SGT_STELLA_NATIVE_VECTOR))) {
          if ((owner == Stella.SGT_STELLA_NATIVE_VECTOR) ||
              Stella.methodCallInliningEnabledP()) {
            operator = Stella.internCommonLispSymbol("AREF");
            tree = Cons.cons(operator, Cons.cons(Stella_Object.clTranslateATree(collection), Cons.cons(Stella_Object.clTranslateATree(position), Stella.NIL)));
            if (setterP) {
              tree = Cons.list$(Cons.cons(Stella.internCommonLispSymbol("SETF"), Cons.cons(tree, Cons.cons(Cons.cons(Stella_Object.clTranslateATree(value), Stella.NIL), Stella.NIL))));
            }
            return (tree);
          }
        }
        else {
        }
        return (Symbol.clTranslateNormalCallMethodTree(operator, owner, arguments));
      }
    }
  }

  public static Stella_Object clTranslateCallMethodTree(Cons tree) {
    { Symbol operator = null;
      Surrogate owner = null;
      Cons arguments = null;

      { Object [] caller_MV_returnarray = new Object[2];

        operator = Cons.destructureCallTree(tree, caller_MV_returnarray);
        owner = ((Surrogate)(caller_MV_returnarray[0]));
        arguments = ((Cons)(caller_MV_returnarray[1]));
      }
      if ((operator == Stella.SYM_STELLA_NTH) ||
          (operator == Stella.SYM_STELLA_NTH_SETTER)) {
        return (Cons.clTranslateNthTree(tree));
      }
      else if ((operator == Stella.SYM_STELLA_AREF) ||
          (operator == Stella.SYM_STELLA_AREF_SETTER)) {
        return (Cons.clTranslateArefTree(tree));
      }
      else if ((operator == Stella.SYM_STELLA_NULLp) ||
          (operator == Stella.SYM_STELLA_DEFINEDp)) {
        return (Stella_Object.clTranslatePlainBooleanTest(tree, false));
      }
      else {
      }
      if ((owner == Stella.SGT_STELLA_ARGUMENT_LIST) ||
          (owner == Stella.SGT_STELLA_ARGUMENT_LIST_ITERATOR)) {
        return (Cons.clTranslateArgumentListTree(tree));
      }
      if (Stella.$CL_OPERATOR_TABLE$.lookup(operator) != null) {
        return (Cons.clTranslateOperatorTree(tree));
      }
      return (Symbol.clTranslateNormalCallMethodTree(operator, owner, arguments));
    }
  }

  public static Cons clTranslateFixedSlotValueSetterTree(Cons tree) {
    { Surrogate objtype = ((Surrogate)(tree.rest.value));
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objtype);
      Stella_Object objref = Stella_Object.clTranslateATree(tree.fourth());
      Stella_Object valueref = Stella_Object.clTranslateATree(tree.fifth());
      Cons otree = Symbol.yieldSlotValueWriterTree(slotname, objref, objtype, valueref);

      return (otree);
    }
  }

  public static Cons clTranslateFixedSlotValueTree(Cons tree) {
    { Surrogate objtype = ((Surrogate)(tree.rest.value));
      Symbol slotname = Symbol.trueSlotName(((Symbol)(tree.rest.rest.value)), objtype);
      Stella_Object objref = Stella_Object.clTranslateATree(tree.fourth());
      Cons otree = Symbol.yieldSlotValueReaderTree(slotname, objref, objtype);

      return (otree);
    }
  }

  public static Cons clTranslateSetqTree(Cons tree) {
    tree.firstSetter(Stella.internCommonLispSymbol("SETQ"));
    tree.secondSetter(Stella_Object.clTranslateATree(tree.rest.value));
    tree.thirdSetter(Stella_Object.clTranslateATree(tree.rest.rest.value));
    return (tree);
  }

  public static Stella_Object clTranslateBadSys(Cons tree) {
    { Stella_Object returntype = tree.rest.rest.value;

      if (returntype == Stella.SGT_STELLA_VOID) {
        return (Stella_Object.clTranslateATree(Stella.yieldIllegalStatementTree()));
      }
      else {
        return (Stella_Object.clTranslateATree(Stella.yieldIllegalExpressionTree()));
      }
    }
  }

  public static Stella_Object clTranslateTypedSys(Cons tree) {
    { Stella_Object otree = Stella_Object.clTranslateATree(tree.rest.value);

      return (otree);
    }
  }

  public static Cons clTranslateVoidSys(Cons tree) {
    { Stella_Object otree = Stella_Object.clTranslateATree(tree.rest.value);

      return (((Cons)(otree)));
    }
  }

  public static Cons clTranslateListOfTrees(Cons trees) {
    { Cons cursor = trees;

      while (!(cursor == Stella.NIL)) {
        { Object old$NeedexplicitreturnP$000 = Stella.$NEEDEXPLICITRETURNp$.get();

          try {
            Native.setBooleanSpecial(Stella.$NEEDEXPLICITRETURNp$, ((Boolean)(Stella.$NEEDEXPLICITRETURNp$.get())).booleanValue() ||
                (!(cursor.rest == Stella.NIL)));
            cursor.value = Stella_Object.clTranslateATree(cursor.value);

          } finally {
            Stella.$NEEDEXPLICITRETURNp$.set(old$NeedexplicitreturnP$000);
          }
        }
        cursor = cursor.rest;
      }
      return (trees);
    }
  }

  public static Symbol destructureCallTree(Cons tree, Object [] MV_returnarray) {
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

      if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
        { Symbol _return_temp = ((Symbol)(tree.rest.value));

          MV_returnarray[0] = null;
          MV_returnarray[1] = tree.rest.rest;
          return (_return_temp);
        }
      }
      else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) {
        { Symbol _return_temp = ((Symbol)(tree.rest.rest.value));

          MV_returnarray[0] = ((Surrogate)(tree.rest.value));
          MV_returnarray[1] = tree.rest.rest.rest;
          return (_return_temp);
        }
      }
      else {
        { Symbol _return_temp = ((Symbol)(tree.value));

          MV_returnarray[0] = null;
          MV_returnarray[1] = tree.rest;
          return (_return_temp);
        }
      }
    }
  }

  public static Stella_Object evaluateBquoteTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object argtree = null;

      { Object old$UsehardcodedsymbolsP$000 = Stella.$USEHARDCODEDSYMBOLSp$.get();

        try {
          Native.setBooleanSpecial(Stella.$USEHARDCODEDSYMBOLSp$, true);
          argtree = Stella_Object.makeEvaluatableBquoteTree(Stella_Object.expandBquoteTree(tree.rest.value));

        } finally {
          Stella.$USEHARDCODEDSYMBOLSp$.set(old$UsehardcodedsymbolsP$000);
        }
      }
      return (Stella_Object.evaluateArgumentTree(argtree, true, MV_returnarray));
    }
  }

  public static Stella_Object evaluateConsTree(Cons tree, Object [] MV_returnarray) {
    { Object old$Evaluationparenttree$000 = Stella.$EVALUATIONPARENTTREE$.get();
      Object old$Evaluationtree$000 = Stella.$EVALUATIONTREE$.get();

      try {
        Native.setSpecial(Stella.$EVALUATIONPARENTTREE$, ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
        Native.setSpecial(Stella.$EVALUATIONTREE$, tree);
        { Stella_Object operatorname = tree.value;
          Cons arguments = tree.rest;
          MethodSlot operator = null;

          if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(operatorname))) {
            { Symbol operatorname000 = ((Symbol)(operatorname));

              if (operatorname000 == Stella.SYM_STELLA_QUOTE) {
                if (arguments.length() == 1) {
                  { Stella_Object _return_temp = arguments.value;

                    MV_returnarray[0] = arguments.value.primaryType();
                    return (_return_temp);
                  }
                }
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
                  stream000.nativeStream.print("Illegal QUOTE expression");
                  throw ((EvaluationException)(EvaluationException.newEvaluationException(stream000.theStringReader()).fillInStackTrace()));
                }
              }
              else if (operatorname000 == Stella.SYM_STELLA_BQUOTE) {
                return (Cons.evaluateBquoteTree(tree, MV_returnarray));
              }
              else if (operatorname000 == Stella.SYM_STELLA_CONS) {
                { Stella_Object arg1 = Stella_Object.evaluateArgumentTree(arguments.value, true, new Object[1]);
                  Stella_Object arg2 = Stella_Object.evaluateArgumentTree(arguments.rest.value, true, new Object[1]);

                  if (Stella_Object.consP(arg2) &&
                      (arguments.rest.rest == Stella.NIL)) {
                    { Stella_Object _return_temp = Cons.cons(arg1, ((Cons)(arg2)));

                      MV_returnarray[0] = Stella.SGT_STELLA_CONS;
                      return (_return_temp);
                    }
                  }
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
                    stream001.nativeStream.print("Illegal CONS expression");
                    throw ((EvaluationException)(EvaluationException.newEvaluationException(stream001.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              else if (operatorname000 == Stella.SYM_STELLA_APPEND) {
                { Stella_Object arg1 = Stella_Object.evaluateArgumentTree(arguments.value, true, new Object[1]);
                  Stella_Object arg2 = Stella_Object.evaluateArgumentTree(arguments.rest.value, true, new Object[1]);

                  if (Stella_Object.consP(arg1) &&
                      (Stella_Object.consP(arg2) &&
                       (arguments.rest.rest == Stella.NIL))) {
                    { Stella_Object _return_temp = Cons.append(((Cons)(arg1)), ((Cons)(arg2)));

                      MV_returnarray[0] = Stella.SGT_STELLA_CONS;
                      return (_return_temp);
                    }
                  }
                  { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                    stream002.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
                    if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                      {
                        stream002.nativeStream.println();
                        stream002.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                      }
;
                    }
                    stream002.nativeStream.println("':");
                    stream002.nativeStream.print("Illegal APPEND expression");
                    throw ((EvaluationException)(EvaluationException.newEvaluationException(stream002.theStringReader()).fillInStackTrace()));
                  }
                }
              }
              else if (operatorname000 == Stella.SYM_STELLA_PROGN) {
                { Stella_Object arg = null;
                  Cons iter000 = arguments;

                  for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    arg = iter000.value;
                    Stella_Object.evaluate(arg);
                  }
                }
                { Stella_Object _return_temp = null;

                  MV_returnarray[0] = Stella.SGT_STELLA_VOID;
                  return (_return_temp);
                }
              }
              else {
                operator = Symbol.lookupCommand(operatorname000);
                if (operator == null) {
                  operator = Symbol.lookupCommandLikeFunction(operatorname000);
                }
                if (operator == null) {
                  { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

                    stream003.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
                    if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                      {
                        stream003.nativeStream.println();
                        stream003.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                      }
;
                    }
                    stream003.nativeStream.println("':");
                    stream003.nativeStream.print("Undefined operator: `" + operatorname000 + "'");
                    throw ((EvaluationException)(EvaluationException.newEvaluationException(stream003.theStringReader()).fillInStackTrace()));
                  }
                }
              }
            }
          }
          else {
            { OutputStringStream stream004 = OutputStringStream.newOutputStringStream();

              stream004.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
              if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                {
                  stream004.nativeStream.println();
                  stream004.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                }
;
              }
              stream004.nativeStream.println("':");
              stream004.nativeStream.print("Illegal operator: `" + operatorname + "'");
              throw ((EvaluationException)(EvaluationException.newEvaluationException(stream004.theStringReader()).fillInStackTrace()));
            }
          }
          { java.lang.reflect.Method evaluatorwrappercode = ((FunctionCodeWrapper)(KeyValueList.dynamicSlotValue(operator.dynamicSlots, Stella.SYM_STELLA_EVALUATOR_WRAPPER_CODE, Stella.NULL_FUNCTION_CODE_WRAPPER))).wrapperValue;
            boolean evaluateargsP = operator.methodEvaluateArgumentsP();
            boolean variableargsP = ((BooleanWrapper)(KeyValueList.dynamicSlotValue(operator.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue;
            List parametertypes = operator.methodParameterTypeSpecifiers();
            int nofparameters = parametertypes.length();
            int nofargs = arguments.length();
            int minargs = (variableargsP ? (nofparameters - 1) : nofparameters);
            int maxargs = (variableargsP ? ((int)(Stella.NULL_INTEGER)) : nofparameters);
            Cons unevaluatedargs = arguments;
            Stella_Object evaluatedarg = null;
            StandardObject evaluatedargtype = null;
            int argindex = 0;
            Surrogate returntype = operator.type();
            Stella_Object result = null;

            if ((nofargs < minargs) ||
                ((maxargs != Stella.NULL_INTEGER) &&
                 (nofargs > maxargs))) {
              { String minstring = Native.integerToString(((long)(minargs)));
                String maxstring = "";

                if (maxargs == Stella.NULL_INTEGER) {
                  maxstring = "+";
                }
                else if (maxargs > minargs) {
                  maxstring = Native.stringConcatenate("-", Native.integerToString(((long)(maxargs))));
                }
                { OutputStringStream stream005 = OutputStringStream.newOutputStringStream();

                  stream005.nativeStream.print("While evaluating '" + ((Stella_Object)(Stella.$EVALUATIONTREE$.get())));
                  if (((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())) != null) {
                    {
                      stream005.nativeStream.println();
                      stream005.nativeStream.print("' inside '" + ((Stella_Object)(Stella.$EVALUATIONPARENTTREE$.get())));
                    }
;
                  }
                  stream005.nativeStream.println("':");
                  stream005.nativeStream.print("Wrong number of arguments.  Expected `" + minstring + "'`" + maxstring + "' but got `" + nofargs + "'");
                  throw ((EvaluationException)(EvaluationException.newEvaluationException(stream005.theStringReader()).fillInStackTrace()));
                }
              }
            }
            while (!(unevaluatedargs == Stella.NIL)) {
              { Object [] caller_MV_returnarray = new Object[1];

                evaluatedarg = Stella_Object.evaluateArgumentTree(unevaluatedargs.value, evaluateargsP, caller_MV_returnarray);
                evaluatedargtype = ((StandardObject)(caller_MV_returnarray[0]));
              }
              { Object [] caller_MV_returnarray = new Object[1];

                evaluatedarg = Stella_Object.coerceEvaluatedTree(evaluatedarg, unevaluatedargs.value, evaluatedargtype, ((argindex >= minargs) ? MethodSlot.variableArgumentsType(operator) : ((StandardObject)(parametertypes.nth(argindex)))), evaluateargsP, caller_MV_returnarray);
                evaluatedargtype = ((StandardObject)(caller_MV_returnarray[0]));
              }
              unevaluatedargs.value = evaluatedarg;
              unevaluatedargs = unevaluatedargs.rest;
              argindex = argindex + 1;
            }
            if (evaluatorwrappercode != null) {
              if (StandardObject.voidP(returntype)) {
                edu.isi.stella.javalib.Native.funcall(evaluatorwrappercode, null, new java.lang.Object [] {arguments});
              }
              else {
                result = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(evaluatorwrappercode, null, new java.lang.Object [] {arguments})));
              }
            }
            else {
              if (StandardObject.voidP(returntype)) {
                Stella.apply(operator.functionCode, arguments);
              }
              else {
                result = Stella.apply(operator.functionCode, arguments);
              }
            }
            if (result != null) {
              returntype = result.primaryType();
            }
            { Stella_Object _return_temp = result;

              MV_returnarray[0] = returntype;
              return (_return_temp);
            }
          }
        }

      } finally {
        Stella.$EVALUATIONTREE$.set(old$Evaluationtree$000);
        Stella.$EVALUATIONPARENTTREE$.set(old$Evaluationparenttree$000);
      }
    }
  }

  public static Cons deUglifyArguments(Cons uglyarguments) {
    { Cons prettyarguments = Stella.NIL;

      { Stella_Object arg = null;
        Cons iter000 = uglyarguments;
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
      return (prettyarguments);
    }
  }

  public static Cons walkTheCodeTree(Cons tree, Object [] MV_returnarray) {
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.rest.value));

      if (testValue000 == Stella.KWD_FUNCTION) {
        if (Cons.badArgumentRangeP(tree, 2, 3)) {
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_FUNCTION_CODE, MV_returnarray));
        }
        if (tree.rest.rest.value == Stella.SYM_STELLA_MAIN) {
          if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
              (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Cannot generate a function pointer to `main' in C++.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_FUNCTION_CODE, MV_returnarray));
          }
          else {
            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationWarning();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                  {
                    Stella.STANDARD_WARNING.nativeStream.println();
                    Stella.STANDARD_WARNING.nativeStream.println(" Won't be able to generate a function pointer to `main' in C++.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
          }
        }
        { Cons _return_temp = tree;

          MV_returnarray[0] = Stella.SGT_STELLA_FUNCTION_CODE;
          return (_return_temp);
        }
      }
      else if (testValue000 == Stella.KWD_METHOD) {
        if (Cons.badArgumentCountP(tree, 3)) {
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_METHOD_CODE, MV_returnarray));
        }
        { Surrogate type = Stella_Object.typify(tree.rest.rest.value);

          tree.thirdSetter(type);
          if (((Stella_Class)(type.surrogateValue)) == null) {
            { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" No class defined for the type: `" + Stella_Object.deUglifyParseTree(type) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
              }
            }
          }
          else {
            if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) ||
                (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP_STANDALONE)) {
              if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_LITERAL)) {
                { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationNote();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
                      {
                        Stella.STANDARD_OUTPUT.nativeStream.println();
                        Stella.STANDARD_OUTPUT.nativeStream.println(" Cannot have methods on literals in `" + Stella.translatorOutputLanguageName() + "', hence, cannot generate");
                        Stella.STANDARD_OUTPUT.nativeStream.println(" a method-code pointer for `" + tree.rest.rest.value + "'.`" + tree.fourth() + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                  }
                }
                { Stella_Object value000 = null;
                  StandardObject value001 = null;

                  { Object [] caller_MV_returnarray = new Object[1];

                    value000 = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.SYM_STELLA_METHOD_CODE, Cons.cons(Stella.NIL, Stella.NIL))))), caller_MV_returnarray);
                    value001 = ((StandardObject)(caller_MV_returnarray[0]));
                  }
                  { Cons _return_temp = ((Cons)(value000));

                    MV_returnarray[0] = value001;
                    return (_return_temp);
                  }
                }
              }
              if (!Surrogate.subtypeOfP(type, Stella.SGT_STELLA_OBJECT)) {
                { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationNote();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
                      {
                        Stella.STANDARD_OUTPUT.nativeStream.println();
                        Stella.STANDARD_OUTPUT.nativeStream.println(" Cannot store a method-code pointer for ");
                        Stella.STANDARD_OUTPUT.nativeStream.println(" `" + tree.rest.rest.value + "'.`" + tree.fourth() + "'");
                        Stella.STANDARD_OUTPUT.nativeStream.println(" since it is not defined on a subtype of @OBJECT.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
                  }
                }
                { Stella_Object value002 = null;
                  StandardObject value003 = null;

                  { Object [] caller_MV_returnarray = new Object[1];

                    value002 = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.SYM_STELLA_METHOD_CODE, Cons.cons(Stella.NIL, Stella.NIL))))), caller_MV_returnarray);
                    value003 = ((StandardObject)(caller_MV_returnarray[0]));
                  }
                  { Cons _return_temp = ((Cons)(value002));

                    MV_returnarray[0] = value003;
                    return (_return_temp);
                  }
                }
              }
            }
            else {
            }
          }
          { Cons _return_temp = tree;

            MV_returnarray[0] = Stella.SGT_STELLA_METHOD_CODE;
            return (_return_temp);
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
  }

  public static Cons walkFuncallTree(Cons tree, Object [] MV_returnarray) {
    if ((tree.value == Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE) ||
        (tree.value == Stella.SYM_STELLA_SYS_CALL_METHOD_CODE)) {
      { Cons _return_temp = tree;

        MV_returnarray[0] = ((StandardObject)(((Cons)(((Cons)(tree.rest.value)).value)).value));
        return (_return_temp);
      }
    }
    { StandardObject returntype = ((((StandardObject)(Stella.$TARGETTYPE$.get())) == Stella.SGT_STELLA_UNKNOWN) ? Stella.SGT_STELLA_VOID : ((StandardObject)(((StandardObject)(Stella.$TARGETTYPE$.get())))));
      Cons signature = Cons.cons(Cons.cons(returntype, Stella.NIL), Stella.NIL);

      { Stella_Object otree = null;
        StandardObject otype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          otree = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_CODE, Stella.SYM_STELLA_FUNCALL, true, caller_MV_returnarray);
          otype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        tree.firstSetter(((otype == Stella.SGT_STELLA_METHOD_CODE) ? Stella.SYM_STELLA_SYS_CALL_METHOD_CODE : Stella.SYM_STELLA_SYS_CALL_FUNCTION_CODE));
        tree.secondSetter(otree);
      }
      { ConsIterator it = tree.rest.rest.allocateIterator();

        while (it.nextP()) {
          { Stella_Object argtree = null;
            StandardObject argtype = null;

            { Object [] caller_MV_returnarray = new Object[1];

              argtree = Stella_Object.walkATree(it.value, caller_MV_returnarray);
              argtype = ((StandardObject)(caller_MV_returnarray[0]));
            }
            it.valueSetter(argtree);
            signature = Cons.cons(argtype, signature);
          }
        }
      }
      tree.rest = Cons.cons(signature.reverse(), tree.rest);
      { Cons _return_temp = tree;

        MV_returnarray[0] = returntype;
        return (_return_temp);
      }
    }
  }

  public static Cons walkMakeTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object classname = tree.rest.value;
      Cons arguments = tree.rest.rest;
      Surrogate type = null;
      Stella_Class renamed_Class = null;

      if (Stella_Object.symbolP(classname)) {
      }
      else if (Stella_Object.typeP(classname)) {
        tree.secondSetter(Symbol.internSymbolInModule(((Surrogate)(classname)).symbolName, ((Module)(((Surrogate)(classname)).homeContext)), true));
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
                Stella.STANDARD_ERROR.nativeStream.println(" Bad argument to 'make':");
                Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(classname) + "' found where symbol expected.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      type = Stella_Object.typify(classname);
      renamed_Class = ((Stella_Class)(type.surrogateValue));
      if (!(renamed_Class != null)) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Reference to undefined class `" + Stella_Object.deUglifyParseTree(classname) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      if ((!(arguments == Stella.NIL)) &&
          (!Stella_Class.exceptionClassP(renamed_Class))) {
        if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_CPP) {
          if (!(((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_CPP_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null)) {
            { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" MAKE arguments not supported for non-native class `" + Stella_Object.deUglifyParseTree(classname) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, type, MV_returnarray));
          }
        }
        else if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
          if (!(((StringWrapper)(KeyValueList.dynamicSlotValue(renamed_Class.dynamicSlots, Stella.SYM_STELLA_CLASS_JAVA_NATIVE_TYPE, Stella.NULL_STRING_WRAPPER))).wrapperValue != null)) {
            { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" MAKE arguments not supported for non-native class `" + Stella_Object.deUglifyParseTree(classname) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, type, MV_returnarray));
          }
        }
        else {
          { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationWarning();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                {
                  Stella.STANDARD_WARNING.nativeStream.println();
                  Stella.STANDARD_WARNING.nativeStream.println(" MAKE arguments not supported for `" + Stella.translatorOutputLanguageName() + "'; skipping them.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
            }
          }
          arguments = Stella.NIL;
        }
      }
      tree.rest.rest = Cons.walkListOfTrees(arguments);
      { Cons _return_temp = tree;

        MV_returnarray[0] = type;
        return (_return_temp);
      }
    }
  }

  public static Cons walkNewTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Stella_Object classtree = tree.rest.value;
      Stella_Object baseclassname = (Stella_Object.consP(classtree) ? ((Cons)(classtree)).value : classtree);
      Cons keywordarguments = tree.rest.rest;
      Symbol selfvariable = Stella.localGensym("SELF");
      StandardObject classtype = null;
      Cons newtree = null;

      if ((!Stella_Object.symbolP(baseclassname)) &&
          (!Stella_Object.keywordP(baseclassname))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal argument to `" + Stella_Object.deUglifyParseTree(operator) + "' where symbol expected:  `" + Stella_Object.deUglifyParseTree(baseclassname) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      classtype = Stella_Object.safeYieldTypeSpecifier(classtree);
      if (StandardObject.typeSpecToClass(classtype) == null) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Undefined class supplied to `" + Stella_Object.deUglifyParseTree(operator) + "' operator: `" + Stella_Object.deUglifyParseTree(baseclassname) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      if (!(Stella_Object.typeP(classtype))) {
        classtype = StandardObject.computeRelativeTypeSpec(classtype, Stella.getCurrentSelfType());
      }
      if (StandardObject.typeSpecToClass(classtype).abstractP) {
        { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Trying to create an instance of the ABSTRACT class `" + Stella_Object.deUglifyParseTree(baseclassname) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      { Cons requiredargs = null;
        Cons otherassignments = null;

        { Object [] caller_MV_returnarray = new Object[1];

          requiredargs = Cons.yieldNewArgumentsTree(keywordarguments, classtype, selfvariable, caller_MV_returnarray);
          otherassignments = ((Cons)(caller_MV_returnarray[0]));
        }
        newtree = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_NEW, Cons.cons(classtype, Cons.cons(requiredargs.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));
        if (otherassignments == Stella.NIL) {
          { Cons _return_temp = newtree;

            MV_returnarray[0] = classtype;
            return (_return_temp);
          }
        }
        else {
          { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(selfvariable, Cons.cons(newtree, Stella.NIL)), Stella.NIL), Cons.cons(otherassignments.concatenate(Cons.cons(selfvariable, Stella.NIL), Stella.NIL), Stella.NIL))));

            MV_returnarray[0] = classtype;
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Cons yieldNewArgumentsTree(Cons keywordsandvalues, StandardObject classtype, Symbol selfvariable, Object [] MV_returnarray) {
    if ((((keywordsandvalues.length()) % 2) == 1)) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Odd number of arguments in 'new' expression: `" + Stella_Object.deUglifyParseTree(keywordsandvalues) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      { Cons _return_temp = Stella.NIL;

        MV_returnarray[0] = Stella.NIL;
        return (_return_temp);
      }
    }
    { Stella_Class renamed_Class = StandardObject.typeSpecToClass(classtype);

      { PropertyList self000 = PropertyList.newPropertyList();

        self000.thePlist = keywordsandvalues;
        { PropertyList plist = self000;
          Cons otherassignments = Stella.NIL;
          Cons requiredvalues = null;
          Symbol slotname = null;
          Slot slot = null;

          { PropertyListIterator it = ((PropertyListIterator)(plist.allocateIterator()));

            while (it.nextP()) {
              { Surrogate testValue000 = Stella_Object.safePrimaryType(it.key);

                if (Surrogate.subtypeOfKeywordP(testValue000)) {
                  slotname = Symbol.internSymbolInModule(((Keyword)(it.key)).symbolName, renamed_Class.homeModule(), false);
                }
                else if (Surrogate.subtypeOfSymbolP(testValue000)) {
                  slotname = ((Symbol)(it.key));
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
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal slot keyword `" + it.key + "' in NEW expression.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                  { Cons _return_temp = Stella.NIL;

                    MV_returnarray[0] = Stella.NIL;
                    return (_return_temp);
                  }
                }
              }
              slot = Stella_Class.lookupSlot(renamed_Class, slotname);
              if (slot == null) {
                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" No such slot `" + Stella_Object.deUglifyParseTree(slotname) + "' on the class `" + Stella_Class.className(renamed_Class) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                { Cons _return_temp = Stella.NIL;

                  MV_returnarray[0] = Stella.NIL;
                  return (_return_temp);
                }
              }
              it.keySetter(slot);
            }
          }
          requiredvalues = StandardObject.extractRequiredArgumentValues(classtype, plist);
          { Slot slot000 = null;
            Stella_Object valueref = null;
            Cons iter000 = ((PropertyList)(plist)).thePlist;
            Cons collect000 = null;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
              slot000 = ((Slot)(iter000.value));
              valueref = iter000.rest.value;
              if (!Stella_Object.storageSlotP(slot000)) {
                { MethodSlot method = ((MethodSlot)(slot000));

                  if (((Symbol)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_STORAGE_SLOT, null))) != null) {
                    slot000 = Stella_Class.lookupSlot(renamed_Class, ((Symbol)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_STORAGE_SLOT, null))));
                  }
                }
              }
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slot000.slotName, Cons.cons(selfvariable, Stella.NIL)), Cons.cons(valueref, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
                  if (otherassignments == Stella.NIL) {
                    otherassignments = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(otherassignments, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETF, Cons.cons(Cons.cons(slot000.slotName, Cons.cons(selfvariable, Stella.NIL)), Cons.cons(valueref, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
          { Cons _return_temp = requiredvalues;

            MV_returnarray[0] = otherassignments;
            return (_return_temp);
          }
        }
      }
    }
  }

  public static void walkDefmoduleTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_MODULE;
      self000.theObject = tree;
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
    { Module module = null;
      String modulename = Stella_Object.coerceToModuleName(tree.rest.value, false);

      if (modulename == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal module name: `" + tree.rest.value + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
        return;
      }
      module = Module.defineModule(modulename, tree.rest.rest);
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = module;
    }
  }

  public static Stella_Object lookupVerbatimTree(Cons tree, Keyword language) {
    if (language == null) {
      language = ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get()));
    }
    return (Cons.searchPlist(tree.rest, language));
  }

  public static Stella_Object walkVerbatimTree(Cons tree, Object [] MV_returnarray) {
    { PropertyList self000 = PropertyList.newPropertyList();

      self000.thePlist = tree.rest;
      { PropertyList options = self000;
        Stella_Object verbatimtree = options.lookup(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())));

        if (verbatimtree == null) {
          verbatimtree = options.lookup(Stella.KWD_OTHERWISE);
          if (verbatimtree == null) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Verbatim statement has no `" + ((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) + "' option..");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            { Stella_Object _return_temp = null;

              MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
              return (_return_temp);
            }
          }
          if (!(verbatimtree == Stella.SYM_STELLA_NULL)) {
            return (Stella_Object.walkATree(verbatimtree, MV_returnarray));
          }
        }
        if (verbatimtree == Stella.SYM_STELLA_NULL) {
          { Stella_Object _return_temp = null;

            MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
            return (_return_temp);
          }
        }
        if (Surrogate.subtypeOfStringP(Stella_Object.safePrimaryType(verbatimtree))) {
          { StringWrapper verbatimtree000 = ((StringWrapper)(verbatimtree));

            options.insertAt(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())), VerbatimStringWrapper.newVerbatimStringWrapper(verbatimtree000.wrapperValue));
          }
        }
        else {
        }
        { Stella_Object _return_temp = tree;

          MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
          return (_return_temp);
        }
      }
    }
  }

  public static void walkVerbatimDefinitionTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_VERBATIM;
      self000.codeRegister = tree;
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
  }

  public static Cons walkUnwindProtectTree(Cons tree, Object [] MV_returnarray) {
    if (tree.value == Stella.SYM_STELLA_SYS_UNWIND_PROTECT) {
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
    { Cons _return_temp = Cons.cons(Stella.SYM_STELLA_SYS_UNWIND_PROTECT, Cons.walkListOfStatements(tree.rest).concatenate(Stella.NIL, Stella.NIL));

      MV_returnarray[0] = Stella.SGT_STELLA_VOID;
      return (_return_temp);
    }
  }

  public static Cons walkExceptionHandlerTrees(Cons tree) {
    { Cons clauses = Stella.NIL;
      Stella_Object exceptiontype = null;
      Stella_Object exceptionvariablespec = null;
      Symbol exceptionvariable = null;

      { Stella_Object clause = null;
        Cons iter000 = tree;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          clause = iter000.value;
          if (Stella_Object.safePrimaryType(clause) == Stella.SGT_STELLA_CONS) {
            { Cons clause000 = ((Cons)(clause));

              if (clause000.length() < 2) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal exception handler clause: `" + Stella_Object.deUglifyParseTree(clause000) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                return (null);
              }
              exceptiontype = clause000.value;
              if (!Stella_Object.symbolP(exceptiontype)) {
                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal exception type: `" + Stella_Object.deUglifyParseTree(exceptiontype) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
                return (null);
              }
              exceptiontype = Stella_Object.typify(exceptiontype);
              if (Surrogate.typeToClass(((Surrogate)(exceptiontype))) == null) {
                { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Undefined exception type: `" + Stella_Object.deUglifyParseTree(exceptiontype) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                  }
                }
                return (null);
              }
              if (!Surrogate.subtypeOfP(((Surrogate)(exceptiontype)), Stella.SGT_STELLA_NATIVE_EXCEPTION)) {
                { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Exception type `" + Stella_Object.deUglifyParseTree(exceptiontype) + "' is not a subtype of NATIVE-EXCEPTION.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                  }
                }
                return (null);
              }
              exceptionvariablespec = clause000.rest.value;
              if ((!Stella_Object.consP(exceptionvariablespec)) ||
                  ((((Cons)(exceptionvariablespec)).length() > 1) ||
                   ((((Cons)(exceptionvariablespec)).length() == 1) &&
                    (!Stella_Object.symbolP(((Cons)(exceptionvariablespec)).value))))) {
                { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal exception variable specification: `" + Stella_Object.deUglifyParseTree(clause000) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
                  }
                }
                return (null);
              }
              exceptionvariable = ((Symbol)(((Cons)(exceptionvariablespec)).value));
              if (Stella.translateToJavaP() &&
                  (exceptionvariable == null)) {
                exceptionvariable = Stella.localGensym("E");
              }
              exceptionvariablespec = Symbol.walkADeclaration(exceptionvariable, exceptiontype, null, true);
              clause000 = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_HANDLE_EXCEPTION, Cons.cons(exceptionvariablespec, Cons.cons(Cons.walkListOfTrees(clause000.rest.rest).concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));
              if (exceptionvariable != null) {
                Stella.popVariableBinding();
              }
              clauses = Cons.cons(clause000, clauses);
            }
          }
          else {
            { Object old$PrintreadablyP$005 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal exception handler clause: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$005);
              }
            }
            return (null);
          }
        }
      }
      return (clauses.reverse());
    }
  }

  public static Cons walkExceptionCaseTree(Cons tree, Object [] MV_returnarray) {
    if (tree.length() <= 2) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Missing handler(s) in 'exception-case': `" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    { Stella_Object protectedtree = Stella_Object.walkATree(tree.rest.value, new Object[1]);
      Cons handlertrees = Cons.walkExceptionHandlerTrees(tree.rest.rest);

      if ((protectedtree == null) ||
          (handlertrees == null)) {
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_HANDLER_CASE, Cons.cons(Stella_Object.walkATree(protectedtree, new Object[1]), Cons.cons(handlertrees.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Cons walkSignalExceptionTree(Cons tree, Object [] MV_returnarray) {
    Native.setBooleanSpecial(Stella.$FOUNDRETURNp$, true);
    { Stella_Object expression = null;
      StandardObject itsType = null;

      { Object [] caller_MV_returnarray = new Object[1];

        expression = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_STELLA_ROOT_EXCEPTION, Stella.SYM_STELLA_SIGNAL_EXCEPTION, false, caller_MV_returnarray);
        itsType = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_SIGNAL, Cons.cons(expression, Cons.cons(Cons.cons(itsType, Stella.NIL), Stella.NIL))));

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Keyword extractStartupTimePhase(Cons tree) {
    { Keyword startuptimephase = Stella.KWD_FINAL;
      Cons startuptimephasetree = null;

      if ((tree.length() >= 2) &&
          (Stella_Object.keywordP(tree.rest.value) &&
           Stella.$STARTUP_TIME_PHASES$.memberP(tree.rest.value))) {
        startuptimephase = ((Keyword)(tree.rest.value));
        startuptimephasetree = tree.rest;
        tree.rest = tree.rest.rest;
        startuptimephasetree.rest = Stella.NIL;
      }
      return (startuptimephase);
    }
  }

  public static void walkStartupTimePrognTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_STARTUP_TIME_PROGN;
      self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
      self000.codeRegister = tree;
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
  }

  public static void walkDeftypeTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_TYPE;
      self000.theObject = tree;
      self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
    if (tree.length() < 3) {
      Cons.badArgumentCountP(tree, 3);
      TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
      return;
    }
    { Surrogate type = null;

      type = Cons.defineStellaTypeFromParseTree(tree);
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = type;
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).codeRegister = tree;
    }
  }

  public static void walkDefglobalTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_GLOBAL_VARIABLE;
      self000.theObject = tree;
      self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
    if (tree.length() < 3) {
      Cons.badArgumentCountP(tree, 3);
      TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
      return;
    }
    { GlobalVariable global = null;
      Stella_Object initialvaluetree = null;

      { Object [] caller_MV_returnarray = new Object[1];

        global = Cons.defineStellaGlobalVariableFromParseTree(tree, Native.stringify(tree), caller_MV_returnarray);
        initialvaluetree = ((Stella_Object)(caller_MV_returnarray[0]));
      }
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = global;
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).codeRegister = initialvaluetree;
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).auxiliaryP = global.variableAuxiliaryP;
    }
  }

  public static void walkDefmacroTree(Cons tree) {
    { Stella_Object name = tree.rest.value;

      { PropertyList self000 = PropertyList.newPropertyList();

        self000.thePlist = Cons.extractOptions(tree, null);
        { PropertyList options = self000;
          MethodSlot method = null;

          if (Stella_Object.consP(name)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Macro `" + ((Cons)(name)).value + "' contains return type specification.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            return;
          }
          if (!(Stella_Object.symbolP(name))) {
            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal macro name: `" + Stella_Object.deUglifyParseTree(name) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            return;
          }
          tree.firstSetter(Stella.SYM_STELLA_DEFUN);
          options.insertAt(Stella.KWD_MACROp, Stella.SYM_STELLA_TRUE);
          options.insertAt(Stella.KWD_TYPE, Stella.SYM_STELLA_OBJECT);
          tree.rest.rest.rest = options.thePlist.concatenate(tree.rest.rest.rest, Stella.NIL);
          Cons.walkDefmethodTree(tree);
          if (((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())) != null) {
            method = ((MethodSlot)(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject));
            if (method.methodArgumentCount() > 5) {
              { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Too many arguments in macro definition, maximum is 5.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
              Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
            }
          }
        }
      }
    }
  }

  public static void walkDefslotTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_SLOT;
      self000.theObject = tree;
      self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
    { StorageSlot slot = null;

      slot = Cons.defineExternalSlotFromParseTree(tree);
      if (slot == null) {
        TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
        return;
      }
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = slot;
      ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).codeRegister = tree;
    }
  }

  public static void walkDefclassTree(Cons tree) {
    { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

      self000.category = Stella.SYM_STELLA_CLASS;
      self000.theObject = tree.rest.value;
      self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
    }
    ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = Cons.defineClassFromParseTree(tree);
    if (((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject == null) {
      TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
      Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
    }
  }

  public static Cons walkSysCallTree(Cons tree, Object [] MV_returnarray) {
    { Slot slot = Cons.slotFromExpressionTree(tree);
      StandardObject slottype = Stella.SGT_STELLA_UNKNOWN;

      if (slot != null) {
        slottype = ((CompoundTypeSpecifier)(KeyValueList.dynamicSlotValue(slot.dynamicSlots, Stella.SYM_STELLA_SLOT_TYPE_SPECIFIER, null)));
        { boolean testValue000 = false;

          testValue000 = slottype != null;
          if (testValue000) {
            if (Stella_Object.anchoredTypeSpecifierP(slottype)) {
              testValue000 = true;
            }
            else {
              { boolean foundP000 = false;

                { StandardObject ts = null;
                  Cons iter000 = ((ParametricTypeSpecifier)(slottype)).specifierParameterTypes.theConsList;

                  loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                    ts = ((StandardObject)(iter000.value));
                    if (Stella_Object.anchoredTypeSpecifierP(ts)) {
                      foundP000 = true;
                      break loop000;
                    }
                  }
                }
                testValue000 = foundP000;
              }
            }
          }
          if (testValue000) {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("walk-sys-call-tree: OOPS, can't handle anchored slot types: `" + tree + "'");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }
        if (!(slottype != null)) {
          slottype = slot.type();
        }
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = slottype;
        return (_return_temp);
      }
    }
  }

  public static void walkDefmethodTree(Cons tree) {
    { MethodSlot method = null;

      { TranslationUnit self000 = TranslationUnit.newTranslationUnit();

        self000.category = Stella.SYM_STELLA_METHOD;
        self000.theObject = tree;
        self000.tuHomeModule = ((Module)(Stella.$MODULE$.get()));
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, self000);
      }
      method = Cons.defineMethodFromParseTree(tree);
      if ((!method.methodFunctionP) &&
          ((method.slotOwner == null) ||
           (((Stella_Class)(method.slotOwner.surrogateValue)) == null))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't define method `" + method.slotName + "' on the non-existent class `" + method.slotOwner + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        method.free();
        TranslationUnit.clearTranslationUnit(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
      }
      else {
        ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).theObject = method;
        ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).codeRegister = tree.nthRest(3);
        if (MethodSlot.methodNeedsLispMacroP(method)) {
          Symbol.registerNativeName(method.slotName, Stella.KWD_COMMON_LISP, Stella.KWD_FUNCTION);
        }
      }
    }
  }

  public static Stella_Object walkCallSlotTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object slotname = tree.value;
      Stella_Object walkedfirstarg = null;
      StandardObject firstargtype = Stella.SGT_STELLA_VOID;
      Stella_Class firstargclass = null;
      boolean illegalfirstargP = false;
      int previouserrors = ((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue();
      Slot slot = null;

      if (slotname == Stella.SYM_STELLA_ERROR) {
        Native.setBooleanSpecial(Stella.$FOUNDRETURNp$, true);
      }
      slot = Symbol.lookupFunction(((Symbol)(slotname)));
      if (slot != null) {
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(((MethodSlot)(slot)).dynamicSlots, Stella.SYM_STELLA_METHOD_MACROp, Stella.FALSE_WRAPPER))).wrapperValue) {
          return (Cons.walkMacroTree(tree, MV_returnarray));
        }
        else {
          firstargtype = MethodSlot.walkFirstArgumentToFunction(((MethodSlot)(slot)), tree);
        }
      }
      else {
        if (!(tree.rest == Stella.NIL)) {
          { Object [] caller_MV_returnarray = new Object[1];

            walkedfirstarg = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_UNKNOWN, ((Symbol)(slotname)), true, caller_MV_returnarray);
            firstargtype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          tree.secondSetter(Stella_Object.coerceATree(walkedfirstarg, firstargtype, firstargtype, new Object[1]));
          if (StandardObject.voidP(firstargtype)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" First argument in call to `" + Stella_Object.deUglifyParseTree(slotname) + "' returns @VOID.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
          }
          firstargclass = StandardObject.typeSpecToClass(firstargtype);
          slot = Stella_Class.lookupSlot(firstargclass, ((Symbol)(slotname)));
        }
      }
      illegalfirstargP = ((Integer)(Stella.$TRANSLATIONERRORS$.get())).intValue() > previouserrors;
      if (Stella_Object.vrletExpressionP(tree.rest.value)) {
        return (Cons.percolateOutVrletExpression(tree, ((Cons)(tree.rest.value)), Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      if ((slot == null) &&
          StandardObject.subTypeSpecOfP(firstargtype, Stella.SGT_STELLA_ARGUMENT_LIST)) {
        slot = Stella_Class.lookupSlot(((Stella_Class)(Stella.SGT_STELLA_CONS.surrogateValue)), ((Symbol)(slotname)));
      }
      if (slot == null) {
        if (Stella.warnAboutUndefinedMethodsP() &&
            ((!(firstargtype == Stella.SGT_STELLA_UNKNOWN)) &&
             ((firstargclass != null) &&
              firstargclass.abstractP))) {
          return (Cons.walkSlotOnAbstractTypeTree(tree, StandardObject.typeSpecToBaseType(firstargtype), MV_returnarray));
        }
        else {
          { Cons value000 = null;
            Surrogate value001 = null;

            { Object [] caller_MV_returnarray = new Object[1];

              value000 = Cons.walkUndefinedSlotTree(tree, (StandardObject.voidP(firstargtype) ? Stella.SGT_STELLA_UNKNOWN : ((StandardObject)(firstargtype))), (!illegalfirstargP) &&
                  Stella.warnAboutUndefinedMethodsP(), caller_MV_returnarray);
              value001 = ((Surrogate)(caller_MV_returnarray[0]));
            }
            { Stella_Object _return_temp = value000;

              MV_returnarray[0] = value001;
              return (_return_temp);
            }
          }
        }
      }
      { int minargs = slot.methodArgumentCount();
        int maxargs = minargs;

        if (Surrogate.subtypeOfMethodSlotP(Stella_Object.safePrimaryType(slot))) {
          { MethodSlot slot000 = ((MethodSlot)(slot));

            if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(slot000.dynamicSlots, Stella.SYM_STELLA_METHOD_VARIABLE_ARGUMENTSp, Stella.FALSE_WRAPPER))).wrapperValue ||
                ((BooleanWrapper)(KeyValueList.dynamicSlotValue(slot000.dynamicSlots, Stella.SYM_STELLA_METHOD_BODY_ARGUMENTp, Stella.FALSE_WRAPPER))).wrapperValue) {
              minargs = minargs - 1;
              maxargs = Stella.NULL_INTEGER;
            }
          }
        }
        else {
        }
        if (Cons.badArgumentRangeP(tree, minargs, maxargs)) {
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
        }
      }
      { Stella_Object otree = null;
        StandardObject otype = null;

        if (StandardObject.subTypeSpecOfP(firstargtype, Stella.SGT_STELLA_ARGUMENT_LIST)) {
          { Object [] caller_MV_returnarray = new Object[1];

            otree = Slot.finishWalkingArgumentListTree(slot, tree, firstargtype, caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
          }
        }
        else {
          { Object [] caller_MV_returnarray = new Object[1];

            otree = slot.finishWalkingCallSlotTree(tree, firstargtype, caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
          }
        }
        return (Slot.sysTreeIfNeeded(slot, otree, firstargtype, otype, MV_returnarray));
      }
    }
  }

  public static Cons walkVariableArguments(Cons arguments, MethodSlot method, StandardObject firstargtype) {
    { StandardObject targettype = MethodSlot.variableArgumentsType(method);
      boolean listifyargsP = MethodSlot.passVariableArgumentsAsListP(method);
      boolean wrapargsP = false;
      Cons cursor = arguments;

      if ((!Stella_Object.typeP(targettype)) &&
          (firstargtype != null)) {
        targettype = StandardObject.computeRelativeTypeSpec(targettype, firstargtype);
      }
      wrapargsP = listifyargsP &&
          StandardObject.subTypeSpecOfP(targettype, Stella.SGT_STELLA_LITERAL);
      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.walkExpressionTree(cursor.value, targettype, method.slotName, false, new Object[1]);
        cursor = cursor.rest;
      }
      if (listifyargsP) {
        { Cons listifiedargs = Cons.yieldListifiedVariableArguments(arguments, targettype, wrapargsP);

          if (arguments == Stella.NIL) {
            return (listifiedargs);
          }
          arguments.value = listifiedargs;
          arguments.rest = Stella.NIL;
        }
      }
      return (arguments);
    }
  }

  public static Cons yieldListifiedVariableArguments(Cons walkedargs, StandardObject targettype, boolean wrapargsP) {
    if (!(walkedargs == Stella.NIL)) {
      { Stella_Object listifiedargs = Stella.SYM_STELLA_NIL;

        { ConsIterator it = walkedargs.allocateIterator();

          while (it.nextP()) {
            { Stella_Object arg = it.value;

              arg = Stella_Object.sysTree(arg, targettype, new Object[1]);
              if (wrapargsP) {
                arg = Cons.cons(((targettype == Stella.SGT_STELLA_BOOLEAN) ? Stella.SYM_STELLA_WRAP_BOOLEAN : Stella.SYM_STELLA_WRAP_LITERAL), Cons.cons(arg, Stella.NIL));
              }
              it.valueSetter(arg);
            }
          }
        }
        if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
          { Stella_Object arg = null;
            Cons iter000 = walkedargs.reverse();

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              arg = iter000.value;
              listifiedargs = Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS, Cons.cons(arg, Cons.cons(Cons.cons(listifiedargs, Stella.NIL), Stella.NIL))));
            }
          }
        }
        else {
          listifiedargs = Cons.list$(Cons.cons(Stella.SYM_STELLA_CONS_LIST, Cons.cons(walkedargs.value, Cons.cons(walkedargs.rest.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));
        }
        return (((Cons)(Stella_Object.walkWithoutTypeTree(listifiedargs))));
      }
    }
    else {
      return (Cons.cons(Stella.SYM_STELLA_NIL, Stella.NIL));
    }
  }

  public static Cons walkSlotOnAbstractTypeTree(Cons tree, Surrogate abstracttype, Object [] MV_returnarray) {
    { Stella_Object methodname = tree.value;
      MethodSlot prototypemethod = Symbol.findPrototypeMethod(((Symbol)(methodname)), abstracttype);
      boolean undefinedmethodP = true;
      Stella_Object otree = null;
      StandardObject otype = null;

      if (prototypemethod != null) {
        undefinedmethodP = false;
        if (Stella.warnAboutMissingMethodsP()) {
          { int nofsubs = Stella.NULL_INTEGER;
            int nofmethods = Stella.NULL_INTEGER;
            boolean compatibleP = false;

            { Object [] caller_MV_returnarray = new Object[2];

              nofsubs = MethodSlot.compatibleRealMethods(prototypemethod, abstracttype, caller_MV_returnarray);
              nofmethods = ((int)(((IntegerWrapper)(caller_MV_returnarray[0])).wrapperValue));
              compatibleP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[1])).wrapperValue));
            }
            if ((nofsubs == nofmethods) &&
                compatibleP) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationNote();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
                    {
                      Stella.STANDARD_OUTPUT.nativeStream.println();
                      Stella.STANDARD_OUTPUT.nativeStream.println(" Inferred the method `" + Stella_Object.deUglifyParseTree(methodname) + "' on the abstract");
                      Stella.STANDARD_OUTPUT.nativeStream.println("   type `" + Stella_Object.deUglifyParseTree(abstracttype) + "', since `" + Stella_Object.deUglifyParseTree(methodname) + "' is implemented");
                      Stella.STANDARD_OUTPUT.nativeStream.println("   on all non-abstract subtypes of `" + Stella_Object.deUglifyParseTree(abstracttype) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                }
              }
              tree.secondSetter(Stella_Object.sysTree(tree.rest.value, prototypemethod.slotOwner, new Object[1]));
              { Object [] caller_MV_returnarray = new Object[1];

                otree = Cons.walkCallSlotTree(tree, caller_MV_returnarray);
                otype = ((StandardObject)(caller_MV_returnarray[0]));
              }
            }
            else if (nofsubs == nofmethods) {
              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Could not infer `" + Stella_Object.deUglifyParseTree(methodname) + "' on abstract type `" + Stella_Object.deUglifyParseTree(abstracttype) + "',");
                      Stella.STANDARD_WARNING.nativeStream.println("   since the implementations of `" + Stella_Object.deUglifyParseTree(methodname) + "' on the non-abstract");
                      Stella.STANDARD_WARNING.nativeStream.println("   subtypes of `" + Stella_Object.deUglifyParseTree(abstracttype) + "' are not all compatible.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
            }
            else {
              { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Could not infer `" + Stella_Object.deUglifyParseTree(methodname) + "' on abstract type `" + Stella_Object.deUglifyParseTree(abstracttype) + "',");
                      Stella.STANDARD_WARNING.nativeStream.println("   since `" + Stella_Object.deUglifyParseTree(methodname) + "' is only implemented on `" + Stella_Object.deUglifyParseTree(IntegerWrapper.wrapInteger(nofmethods)) + "' of the `" + Stella_Object.deUglifyParseTree(IntegerWrapper.wrapInteger(nofsubs)) + "'");
                      Stella.STANDARD_WARNING.nativeStream.println("   non-abstract subtypes of `" + Stella_Object.deUglifyParseTree(abstracttype) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
              if (!(compatibleP)) {
                Stella.STANDARD_OUTPUT.nativeStream.println(" Additionally, the method signatures are not compatible.");
              }
            }
          }
        }
      }
      if (undefinedmethodP) {
        { Cons value000 = null;
          Surrogate value001 = null;

          { Object [] caller_MV_returnarray = new Object[1];

            value000 = Cons.walkUndefinedSlotTree(tree, abstracttype, Stella.warnAboutUndefinedMethodsP(), caller_MV_returnarray);
            value001 = ((Surrogate)(caller_MV_returnarray[0]));
          }
          {
            otree = value000;
            otype = value001;
          }
        }
      }
      else {
        { Cons value002 = null;
          Surrogate value003 = null;

          { Object [] caller_MV_returnarray = new Object[1];

            value002 = Cons.walkUndefinedSlotTree(tree, abstracttype, false, caller_MV_returnarray);
            value003 = ((Surrogate)(caller_MV_returnarray[0]));
          }
          {
            otree = value002;
            otype = value003;
          }
        }
      }
      { Cons _return_temp = ((Cons)(otree));

        MV_returnarray[0] = otype;
        return (_return_temp);
      }
    }
  }

  public static Cons walkUndefinedSlotTree(Cons tree, StandardObject firstargtype, boolean warnP, Object [] MV_returnarray) {
    { Cons cursor = tree.rest.rest;
      Surrogate type = StandardObject.typeSpecToBaseType(firstargtype);
      Symbol operatorname = ((Symbol)(tree.value));

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.walkExpressionTree(cursor.value, null, operatorname, true, new Object[1]);
        cursor = cursor.rest;
      }
      if (warnP &&
          (!Symbol.symbolCommonLispP(operatorname))) {
        if ((operatorname == Stella.SYM_STELLA_NULLp) ||
            (operatorname == Stella.SYM_STELLA_DEFINEDp)) {
          if (!(StandardObject.walkTypeSpecIsNativeTypeP(type))) {
            {
              Stella.STANDARD_OUTPUT.nativeStream.println("Using default native test for `" + operatorname + "' in the expression:");
              Stella.STANDARD_OUTPUT.nativeStream.println("  `" + tree + "'");
            }
;
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
                  Stella.STANDARD_ERROR.nativeStream.println(" Reference to undefined method or function named `" + Stella_Object.deUglifyParseTree(operatorname) + "'");
                  Stella.STANDARD_ERROR.nativeStream.println("   in the expression:");
                  Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
        }
      }
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(type, Cons.cons(tree.concatenate(Stella.NIL, Stella.NIL), Stella.NIL))));

        MV_returnarray[0] = Stella.SGT_STELLA_UNKNOWN;
        return (_return_temp);
      }
    }
  }

  public static Cons walkPrintStreamTree(Cons tree, Object [] MV_returnarray) {
    if (tree.length() <= 2) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Missing arguments in print statement: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    { Stella_Object operator = tree.value;
      Stella_Object streamtree = tree.rest.value;
      Stella_Object otree = null;
      StandardObject otype = null;

      if (Stella_Object.keywordP(streamtree)) {
        if (!((streamtree == Stella.KWD_WARN) ||
            ((streamtree == Stella.KWD_ERROR) ||
             (streamtree == Stella.KWD_CONTINUABLE_ERROR)))) {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal stream argument in print statement: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
        }
      }
      else {
        { Object [] caller_MV_returnarray = new Object[1];

          otree = Stella_Object.walkExpressionTree(streamtree, Stella.SGT_STELLA_NATIVE_OUTPUT_STREAM, ((Symbol)(tree.value)), false, caller_MV_returnarray);
          otype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        tree.firstSetter(Stella.SYM_STELLA_PRINT_NATIVE_STREAM);
        tree.secondSetter(otree);
      }
      { ConsIterator it = tree.rest.rest.allocateIterator();

        while (it.nextP()) {
          { Object [] caller_MV_returnarray = new Object[1];

            otree = Stella_Object.walkExpressionTree(it.value, Stella.SGT_STELLA_UNKNOWN, ((Symbol)(operator)), false, caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          it.valueSetter(otree);
          if (!(otree == Stella.SYM_STELLA_EOL)) {
            { Surrogate testValue000 = Stella_Object.safePrimaryType(otree);

              if (Surrogate.subtypeOfStringP(testValue000)) {
                { StringWrapper otree000 = ((StringWrapper)(otree));

                }
              }
              else if (Surrogate.subtypeOfIntegerP(testValue000)) {
                { IntegerWrapper otree000 = ((IntegerWrapper)(otree));

                  it.valueSetter(StringWrapper.wrapString(Native.stringify(otree000)));
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
                { LongIntegerWrapper otree000 = ((LongIntegerWrapper)(otree));

                  it.valueSetter(StringWrapper.wrapString(Native.stringify(otree000)));
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue000)) {
                { FloatWrapper otree000 = ((FloatWrapper)(otree));

                  it.valueSetter(StringWrapper.wrapString(Native.stringify(otree000)));
                }
              }
              else if (Surrogate.subtypeOfCharacterP(testValue000)) {
                { CharacterWrapper otree000 = ((CharacterWrapper)(otree));

                  it.valueSetter(StringWrapper.wrapString(Native.makeString(1, otree000.wrapperValue)));
                }
              }
              else {
                it.valueSetter(Stella_Object.sysTree(otree, otype, new Object[1]));
              }
            }
          }
        }
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkMacroTree(Cons tree, Object [] MV_returnarray) {
    return (Stella_Object.walkATree(Cons.expandMacro(tree), MV_returnarray));
  }

  public static Stella_Object expandMacro(Cons tree) {
    { Symbol macroname = ((Symbol)(tree.value));
      MethodSlot expanderobject = Symbol.lookupMacro(macroname);
      java.lang.reflect.Method expandercode = expanderobject.functionCode;
      Cons args = tree.rest;
      Stella_Object expansion = null;

      if (expandercode == null) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Macro expander code for `" + Stella_Object.deUglifyParseTree(macroname) + "' is not available.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, new Object[1]));
      }
      if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(expanderobject.dynamicSlots, Stella.SYM_STELLA_METHOD_BODY_ARGUMENTp, Stella.FALSE_WRAPPER))).wrapperValue) {
        switch (expanderobject.methodArgumentCount()) {
          case 1: 
            expansion = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(expandercode, null, new java.lang.Object [] {args})));
            tree.rest = Stella.NIL;
          break;
          case 2: 
            expansion = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(expandercode, null, new java.lang.Object [] {args.value, args.rest})));
            args.rest = Stella.NIL;
          break;
          case 3: 
            expansion = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(expandercode, null, new java.lang.Object [] {args.value, args.rest.value, args.rest.rest})));
            args.rest.rest = Stella.NIL;
          break;
          case 4: 
            expansion = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(expandercode, null, new java.lang.Object [] {args.value, args.rest.value, args.rest.rest.value, args.nthRest(3)})));
            args.nthRestSetter(Stella.NIL, 3);
          break;
          case 5: 
            expansion = ((Stella_Object)(edu.isi.stella.javalib.Native.funcall(expandercode, null, new java.lang.Object [] {args.value, args.rest.value, args.rest.rest.value, args.fourth(), args.nthRest(4)})));
            args.nthRestSetter(Stella.NIL, 4);
          break;
          default:
            { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Too many arguments in definition of macro `" + Stella_Object.deUglifyParseTree(macroname) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, new Object[1]));
        }
      }
      else {
        expansion = Stella.apply(expandercode, tree.rest);
      }
      return (expansion);
    }
  }

  public static Stella_Object walkBquoteTree(Cons tree, Object [] MV_returnarray) {
    if (Cons.badArgumentCountP(tree, 1)) {
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
    }
    { Stella_Object otree = null;
      StandardObject otype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkATree(Stella_Object.simplifyBquoteTree(Stella_Object.expandBquoteTree(tree.rest.value)), caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Stella_Object _return_temp = otree;

        MV_returnarray[0] = otype;
        return (_return_temp);
      }
    }
  }

  public static Stella_Object walkQuotedTree(Cons tree, Object [] MV_returnarray) {
    if (Cons.badArgumentCountP(tree, 1)) {
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
    }
    { Stella_Object argument = tree.rest.value;
      boolean quotedliteralP = (!Stella_Object.consP(argument)) ||
          (argument == Stella.NIL);
      String objectname = null;

      if (quotedliteralP) {
        { Stella_Object otree = null;
          StandardObject otype = null;

          { Object [] caller_MV_returnarray = new Object[1];

            otree = Stella_Object.walkATree(Stella_Object.bquotify(argument), caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          { Stella_Object _return_temp = otree;

            MV_returnarray[0] = otype;
            return (_return_temp);
          }
        }
      }
      objectname = Cons.nameQuotedTree(((Cons)(argument)));
      return (Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_GET_QUOTED_TREE, Cons.cons(StringWrapper.wrapString(objectname), Cons.cons(Cons.cons(StringWrapper.wrapString(((Module)(Stella.$MODULE$.get())).moduleFullName), Stella.NIL), Stella.NIL)))), MV_returnarray));
    }
  }

  public static Stella_Object walkArithmeticTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Cons operands = tree.rest;
      int nofoperands = operands.length();
      Stella_Object operand = null;
      StandardObject operandtype = null;
      Surrogate returntype = Stella.SGT_STELLA_INTEGER;

      switch (nofoperands) {
        case 0: 
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(operator));

            if (testValue000 == Stella.SYM_STELLA_i) {
              { Stella_Object _return_temp = IntegerWrapper.wrapInteger(0);

                MV_returnarray[0] = Stella.SGT_STELLA_INTEGER;
                return (_return_temp);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_$) {
              { Stella_Object _return_temp = IntegerWrapper.wrapInteger(1);

                MV_returnarray[0] = Stella.SGT_STELLA_INTEGER;
                return (_return_temp);
              }
            }
            else {
              Cons.badArgumentCountP(tree, 1);
              { Cons value000 = null;
                StandardObject value001 = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  value000 = Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_NUMBER, caller_MV_returnarray);
                  value001 = ((StandardObject)(caller_MV_returnarray[0]));
                }
                { Stella_Object _return_temp = value000;

                  MV_returnarray[0] = ((Surrogate)(value001));
                  return (_return_temp);
                }
              }
            }
          }
        case 1: 
          { GeneralizedSymbol testValue001 = ((GeneralizedSymbol)(operator));

            if ((testValue001 == Stella.SYM_STELLA_i) ||
                (testValue001 == Stella.SYM_STELLA_$)) {
              { Stella_Object value002 = null;
                StandardObject value003 = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  value002 = Stella_Object.walkExpressionTree(operands.value, Stella.SGT_STELLA_NUMBER, ((Symbol)(operator)), false, caller_MV_returnarray);
                  value003 = ((StandardObject)(caller_MV_returnarray[0]));
                }
                { Stella_Object _return_temp = value002;

                  MV_returnarray[0] = ((Surrogate)(value003));
                  return (_return_temp);
                }
              }
            }
            else if ((testValue001 == Stella.SYM_STELLA__) ||
                (testValue001 == Stella.SYM_STELLA_s)) {
              operands.rest = Cons.cons(operands.value, Stella.NIL);
              operands.firstSetter(((operator == Stella.SYM_STELLA__) ? IntegerWrapper.wrapInteger(0) : IntegerWrapper.wrapInteger(1)));
            }
            else {
              { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

                stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
              }
            }
          }
        break;
        default:
        break;
      }
      { ConsIterator it = operands.allocateIterator();

        while (it.nextP()) {
          { Object [] caller_MV_returnarray = new Object[1];

            operand = Stella_Object.walkExpressionTree(it.value, Stella.SGT_STELLA_NUMBER, ((Symbol)(operator)), false, caller_MV_returnarray);
            operandtype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          returntype = Surrogate.moreGeneralNumericType(returntype, StandardObject.typeSpecToBaseType(operandtype));
          it.valueSetter(operand);
        }
      }
      if ((operator == Stella.SYM_STELLA_s) &&
          ((returntype == Stella.SGT_STELLA_INTEGER) ||
           (returntype == Stella.SGT_STELLA_LONG_INTEGER))) {
        if (Stella_Object.wrapperP(operands.value)) {
          operands.firstSetter(FloatWrapper.wrapFloat(Stella_Object.coerceToFloat(operands.value)));
        }
        else if (Stella_Object.wrapperP(operands.rest.value)) {
          operands.secondSetter(FloatWrapper.wrapFloat(Stella_Object.coerceToFloat(operands.rest.value)));
        }
        else {
          operands = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(operands.value, Cons.cons(Cons.cons(Stella.SGT_STELLA_FLOAT, Stella.NIL), Stella.NIL)))), operands.rest.concatenate(Stella.NIL, Stella.NIL));
          nofoperands = nofoperands + 1;
        }
        returntype = Stella.SGT_STELLA_FLOAT;
      }
      if ((nofoperands > 2) &&
          (!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP))) {
        { Cons value004 = null;
          StandardObject value005 = null;

          { Object [] caller_MV_returnarray = new Object[1];

            value004 = Stella_Object.sysTree(Symbol.yieldNestedArithmeticOperatorCallTree(((Symbol)(operator)), operands), returntype, caller_MV_returnarray);
            value005 = ((StandardObject)(caller_MV_returnarray[0]));
          }
          { Stella_Object _return_temp = value004;

            MV_returnarray[0] = ((Surrogate)(value005));
            return (_return_temp);
          }
        }
      }
      else {
        { Cons value006 = null;
          StandardObject value007 = null;

          { Object [] caller_MV_returnarray = new Object[1];

            value006 = Stella_Object.sysTree(Symbol.yieldArithmeticOperatorCallTree(((Symbol)(operator)), operands), returntype, caller_MV_returnarray);
            value007 = ((StandardObject)(caller_MV_returnarray[0]));
          }
          { Stella_Object _return_temp = value006;

            MV_returnarray[0] = ((Surrogate)(value007));
            return (_return_temp);
          }
        }
      }
    }
  }

  public static Stella_Object walkEqualityTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object arg1 = null;
      Stella_Object arg2 = null;
      StandardObject type1 = null;
      StandardObject type2 = null;

      { Object [] caller_MV_returnarray = new Object[1];

        arg1 = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_UNKNOWN, ((Symbol)(tree.value)), true, caller_MV_returnarray);
        type1 = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        arg2 = Stella_Object.walkExpressionTree(tree.rest.rest.value, Stella.SGT_STELLA_UNKNOWN, ((Symbol)(tree.value)), true, caller_MV_returnarray);
        type2 = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.secondSetter(arg1);
      tree.thirdSetter(arg2);
      if (Stella_Object.vrletExpressionP(arg1)) {
        return (Stella_Object.walkATree(Cons.percolateOutVrletExpression(tree, ((Cons)(arg1)), Stella.SGT_STELLA_BOOLEAN, new Object[1]), MV_returnarray));
      }
      if (Stella_Object.vrletExpressionP(arg2)) {
        return (Stella_Object.walkATree(Cons.percolateOutVrletExpression(tree, ((Cons)(arg2)), Stella.SGT_STELLA_BOOLEAN, new Object[1]), MV_returnarray));
      }
      type1 = Surrogate.canonicalType(StandardObject.typeSpecToBaseType(type1));
      type2 = Surrogate.canonicalType(StandardObject.typeSpecToBaseType(type2));
      if (!((type1 == Stella.SGT_STELLA_UNKNOWN) ||
          ((type2 == Stella.SGT_STELLA_UNKNOWN) ||
           (Surrogate.subtypeOfP(((Surrogate)(type1)), ((Surrogate)(type2))) ||
            (Surrogate.subtypeOfP(((Surrogate)(type2)), ((Surrogate)(type1))) ||
             ((Surrogate.subtypeOfP(((Surrogate)(type1)), Stella.SGT_STELLA_NUMBER) &&
          Surrogate.subtypeOfP(((Surrogate)(type2)), Stella.SGT_STELLA_NUMBER)) ||
              (Surrogate.subtypeOfP(((Surrogate)(type1)).typeToWrappedType(), ((Surrogate)(type2))) ||
               Surrogate.subtypeOfP(((Surrogate)(type2)).typeToWrappedType(), ((Surrogate)(type1)))))))))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationWarning();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
              {
                Stella.STANDARD_WARNING.nativeStream.println();
                Stella.STANDARD_WARNING.nativeStream.println(" This equality test will always fail due to disjoint argument types:");
                Stella.STANDARD_WARNING.nativeStream.println("    `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

        if ((testValue000 == Stella.SYM_STELLA_EQp) ||
            (testValue000 == Stella.SYM_STELLA_e)) {
          tree.firstSetter(Stella.SYM_STELLA_EQp);
          tree.secondSetter(Stella_Object.sysTree(tree.rest.value, type1, new Object[1]));
          tree.thirdSetter(Stella_Object.sysTree(tree.rest.rest.value, type2, new Object[1]));
          { Stella_Object _return_temp = tree;

            MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
            return (_return_temp);
          }
        }
        else if (testValue000 == Stella.SYM_STELLA_EQLp) {
          return (Cons.finishWalkingEqlTree(tree, ((Surrogate)(type1)), ((Surrogate)(type2)), MV_returnarray));
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

  public static Cons finishWalkingEqualTree(Cons tree, Surrogate type1, Surrogate type2, Object [] MV_returnarray) {
    {
      tree = tree;
      type1 = type1;
      type2 = type2;
    }
    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
        Stella.signalTranslationError();
        if (!(Stella.suppressWarningsP())) {
          Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
          {
            Stella.STANDARD_ERROR.nativeStream.println();
            Stella.STANDARD_ERROR.nativeStream.println(" finish-walking-equal-tree: NOT YET IMPLEMENTED..");
          }
;
        }

      } finally {
        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
      }
    }
    { Cons _return_temp = null;

      MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
      return (_return_temp);
    }
  }

  public static Cons finishWalkingEqlTree(Cons tree, Surrogate type1, Surrogate type2, Object [] MV_returnarray) {
    if (Surrogate.subtypeOfP(type1, Stella.SGT_STELLA_STANDARD_OBJECT) ||
        (Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_STANDARD_OBJECT) ||
         (((type1 == Stella.SGT_STELLA_BOOLEAN_WRAPPER) &&
        (type2 == Stella.SGT_STELLA_BOOLEAN_WRAPPER)) ||
          (((!Surrogate.subtypeOfP(type1, Stella.SGT_STELLA_OBJECT)) &&
        (!Surrogate.subtypeOfP(type1, Stella.SGT_STELLA_LITERAL))) ||
           ((!Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_OBJECT)) &&
            (!Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_LITERAL))))))) {
      tree.firstSetter(Stella.SYM_STELLA_EQp);
      tree.secondSetter(Stella_Object.sysTree(tree.rest.value, type1, new Object[1]));
      tree.thirdSetter(Stella_Object.sysTree(tree.rest.rest.value, type2, new Object[1]));
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
        return (_return_temp);
      }
    }
    if (Surrogate.subtypeOfP(type1, Stella.SGT_STELLA_LITERAL) &&
        Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_LITERAL)) {
      if (type1 == Stella.SGT_STELLA_STRING) {
        tree.firstSetter(Stella.SYM_STELLA_STRING_EQLp);
      }
      else {
        tree.firstSetter(Stella.SYM_STELLA_EQp);
      }
      return (Cons.walkAConsTree(tree, MV_returnarray));
    }
    if ((!Surrogate.subtypeOfP(type1, Stella.SGT_STELLA_LITERAL)) &&
        (!Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_LITERAL))) {
      { Stella_Object otree = null;
        StandardObject otype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          otree = Cons.walkCallSlotTree(tree, caller_MV_returnarray);
          otype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        { Cons _return_temp = ((Cons)(otree));

          MV_returnarray[0] = otype;
          return (_return_temp);
        }
      }
    }
    if (!Surrogate.subtypeOfP(type2, Stella.SGT_STELLA_LITERAL)) {
      { Stella_Object temparg = tree.rest.rest.value;
        Surrogate temptype = type2;

        tree.thirdSetter(tree.rest.value);
        tree.secondSetter(temparg);
        type2 = type1;
        type1 = temptype;
      }
    }
    if (type2 == Stella.SGT_STELLA_BOOLEAN) {
      tree.firstSetter(Stella.SYM_STELLA_EQL_TO_BOOLEANp);
    }
    else if (type2 == Stella.SGT_STELLA_INTEGER) {
      tree.firstSetter(Stella.SYM_STELLA_EQL_TO_INTEGERp);
    }
    else if (type2 == Stella.SGT_STELLA_LONG_INTEGER) {
      tree.firstSetter(Stella.SYM_STELLA_EQL_TO_LONG_INTEGERp);
    }
    else if (type2 == Stella.SGT_STELLA_FLOAT) {
      tree.firstSetter(Stella.SYM_STELLA_EQL_TO_FLOATp);
    }
    else if (type2 == Stella.SGT_STELLA_STRING) {
      tree.firstSetter(Stella.SYM_STELLA_EQL_TO_STRINGp);
    }
    else {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        stream000.nativeStream.print("`" + type2 + "' is not a valid case option");
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    { Cons _return_temp = ((Cons)(Stella_Object.walkWithoutTypeTree(tree)));

      MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
      return (_return_temp);
    }
  }

  public static Cons walkWithProcessLockTree(Cons tree, Object [] MV_returnarray) {
    tree.secondSetter(Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_PROCESS_LOCK_OBJECT, ((Symbol)(tree.value)), true, new Object[1]));
    tree.rest.rest = Cons.walkListOfStatements(tree.rest.rest);
    return (Stella_Object.sysTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
  }

  public static Cons walkTypecaseTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object testtree = tree.rest.value;
      StandardObject testexpressiontype = null;
      Symbol testvariable = null;
      Cons expandedcases = Stella.NIL;
      boolean needcastP = Stella_Object.symbolP(testtree) &&
          (((Symbol)(testtree)).lookupGlobalVariable() == null);
      List precedingclausetypes = List.newList();

      if (needcastP) {
        testvariable = ((Symbol)(testtree));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        testtree = Stella_Object.walkATree(testtree, caller_MV_returnarray);
        testexpressiontype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.secondSetter(testtree);
      testexpressiontype = StandardObject.typeSpecToBaseType(testexpressiontype);
      if (Surrogate.unknownTypeP(((Surrogate)(testexpressiontype)))) {
        testexpressiontype = Stella.SGT_STELLA_UNKNOWN;
      }
      tree.secondSetter(Stella_Object.sysTree(testtree, testexpressiontype, new Object[1]));
      if (needcastP) {
        { Stella_Object casetree = null;
          Cons iter000 = tree.rest.rest;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            casetree = iter000.value;
            if (Stella_Object.safePrimaryType(casetree) == Stella.SGT_STELLA_CONS) {
              { Cons casetree000 = ((Cons)(casetree));

                { Stella_Object typetree = casetree000.value;

                  if (Stella_Object.safePrimaryType(typetree) == Stella.SGT_STELLA_CONS) {
                    { Cons typetree000 = ((Cons)(typetree));

                      casetree000.firstSetter(typetree000.value);
                      expandedcases = Cons.cons(casetree000, expandedcases);
                      { Stella_Object type = null;
                        Cons iter001 = typetree000.rest;

                        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
                          type = iter001.value;
                          expandedcases = Cons.cons(Cons.cons(type, ((Cons)(((Cons)(Stella_Object.copyConsTree(casetree000.rest))))).concatenate(Stella.NIL, Stella.NIL)), expandedcases);
                        }
                      }
                    }
                  }
                  else {
                    expandedcases = Cons.cons(casetree000, expandedcases);
                  }
                }
              }
            }
            else {
              expandedcases = Cons.cons(casetree, expandedcases);
            }
          }
        }
        tree.rest.rest = expandedcases.reverse();
      }
      { Stella_Object casetree = null;
        Cons iter002 = tree.rest.rest;

        for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
          casetree = iter002.value;
          if (Stella_Object.safePrimaryType(casetree) == Stella.SGT_STELLA_CONS) {
            { Cons casetree000 = ((Cons)(casetree));

              { Stella_Object typetree = casetree000.value;

                { Surrogate testValue000 = Stella_Object.safePrimaryType(typetree);

                  if (Surrogate.subtypeOfSymbolP(testValue000)) {
                    { Symbol typetree000 = ((Symbol)(typetree));

                      if (!(Stella.stringEqlP(typetree000.symbolName, "OTHERWISE"))) {
                        { Surrogate type = StandardObject.typeSpecToBaseType(typetree000.yieldTypeSpecifier());

                          Surrogate.verifyTypecaseClauseType(((Surrogate)(testexpressiontype)), type, precedingclausetypes, casetree000);
                          casetree000.firstSetter(type);
                          type = type.typeToWrappedType();
                          if (needcastP &&
                              (!(casetree000.rest == Stella.NIL))) {
                            casetree000.rest = Symbol.yieldCastedTypecaseClauseTrees(testvariable, type, casetree000.rest);
                          }
                        }
                      }
                    }
                  }
                  else if (Surrogate.subtypeOfSurrogateP(testValue000)) {
                    { Surrogate typetree000 = ((Surrogate)(typetree));

                      if (!(Stella.stringEqlP(typetree000.symbolName, "OTHERWISE"))) {
                        { Surrogate type = StandardObject.typeSpecToBaseType(typetree000.yieldTypeSpecifier());

                          Surrogate.verifyTypecaseClauseType(((Surrogate)(testexpressiontype)), type, precedingclausetypes, casetree000);
                          casetree000.firstSetter(type);
                          type = type.typeToWrappedType();
                          if (needcastP &&
                              (!(casetree000.rest == Stella.NIL))) {
                            casetree000.rest = Symbol.yieldCastedTypecaseClauseTrees(testvariable, type, casetree000.rest);
                          }
                        }
                      }
                    }
                  }
                  else if (testValue000 == Stella.SGT_STELLA_CONS) {
                    { Cons typetree000 = ((Cons)(typetree));

                      { ConsIterator it = typetree000.allocateIterator();

                        while (it.nextP()) {
                          if (Stella_Object.consP(it.value)) {
                            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                              try {
                                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                                Stella.signalTranslationError();
                                if (!(Stella.suppressWarningsP())) {
                                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                                  {
                                    Stella.STANDARD_ERROR.nativeStream.println();
                                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal type expression in 'typecase': `" + Stella_Object.deUglifyParseTree(typetree000) + "'.");
                                  }
;
                                }

                              } finally {
                                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                              }
                            }
                            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
                          }
                          it.valueSetter(StandardObject.typeSpecToBaseType(it.value.yieldTypeSpecifier()));
                          Surrogate.verifyTypecaseClauseType(((Surrogate)(testexpressiontype)), ((Surrogate)(it.value)), precedingclausetypes, casetree000);
                        }
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
                            Stella.STANDARD_ERROR.nativeStream.println(" Illegal type expression in 'typecase': `" + Stella_Object.deUglifyParseTree(typetree) + "'.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                      }
                    }
                    return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
                  }
                }
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
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal case expression in 'typecase': `" + Stella_Object.deUglifyParseTree(casetree) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
              }
            }
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
          }
        }
      }
      return (Cons.walkNonBuiltInCaseTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_CASE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SAFE_PRIMARY_TYPE, Cons.cons(tree.rest.value, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(tree.rest.rest.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.SYM_STELLA_SUBTYPE_OFp, MV_returnarray));
    }
  }

  public static Cons walkCaseTree(Cons tree, Object [] MV_returnarray) {
    { boolean testValue000 = false;

      testValue000 = tree.length() >= 3;
      if (testValue000) {
        { boolean alwaysP000 = true;

          { Stella_Object clause = null;
            Cons iter000 = tree.rest.rest;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              clause = iter000.value;
              if (!Stella_Object.consP(clause)) {
                alwaysP000 = false;
                break loop000;
              }
            }
          }
          testValue000 = alwaysP000;
        }
      }
      testValue000 = !testValue000;
      if (testValue000) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal `case' statement: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
    }
    { Cons clauses = ((Cons)(tree.rest.rest));
      Stella_Object firsttesttree = (Stella_Object.consP(((Cons)(clauses.value)).value) ? ((Cons)(((Cons)(clauses.value)).value)).value : ((Cons)(clauses.value)).value);
      Surrogate caseconstanttype = Stella.SGT_STELLA_UNKNOWN;

      { Surrogate testValue001 = Stella_Object.safePrimaryType(firsttesttree);

        if (Surrogate.subtypeOfSymbolP(testValue001)) {
          { Symbol firsttesttree000 = ((Symbol)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_GENERALIZED_SYMBOL;
          }
        }
        else if (Surrogate.subtypeOfSurrogateP(testValue001)) {
          { Surrogate firsttesttree000 = ((Surrogate)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_GENERALIZED_SYMBOL;
          }
        }
        else if (Surrogate.subtypeOfKeywordP(testValue001)) {
          { Keyword firsttesttree000 = ((Keyword)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_GENERALIZED_SYMBOL;
          }
        }
        else if (Surrogate.subtypeOfStringP(testValue001)) {
          { StringWrapper firsttesttree000 = ((StringWrapper)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_STRING;
          }
        }
        else if (Surrogate.subtypeOfCharacterP(testValue001)) {
          { CharacterWrapper firsttesttree000 = ((CharacterWrapper)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_CHARACTER;
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue001)) {
          { IntegerWrapper firsttesttree000 = ((IntegerWrapper)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_INTEGER;
          }
        }
        else if (Surrogate.subtypeOfLongIntegerP(testValue001)) {
          { LongIntegerWrapper firsttesttree000 = ((LongIntegerWrapper)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_LONG_INTEGER;
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue001)) {
          { FloatWrapper firsttesttree000 = ((FloatWrapper)(firsttesttree));

            caseconstanttype = Stella.SGT_STELLA_FLOAT;
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
                  Stella.STANDARD_ERROR.nativeStream.println(" `case' statement contains illegal constant of type `" + firsttesttree.primaryType() + "'");
                  Stella.STANDARD_ERROR.nativeStream.println("    `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
        }
      }
      tree.secondSetter(Stella_Object.walkExpressionTree(tree.rest.value, caseconstanttype, Stella.SYM_STELLA_CASE, true, new Object[1]));
      if (Stella_Object.vrletExpressionP(tree.rest.value)) {
        return (Cons.percolateOutVrletExpression(tree, ((Cons)(tree.rest.value)), caseconstanttype, MV_returnarray));
      }
      if ((caseconstanttype == Stella.SGT_STELLA_GENERALIZED_SYMBOL) &&
          Stella.useHardcodedSymbolsP()) {
        return (Cons.walkHardcodedSymbolCaseTree(tree, MV_returnarray));
      }
      if (!((caseconstanttype == Stella.SGT_STELLA_INTEGER) ||
          ((caseconstanttype == Stella.SGT_STELLA_LONG_INTEGER) ||
           (caseconstanttype == Stella.SGT_STELLA_CHARACTER)))) {
        return (Cons.walkNonBuiltInCaseTree(tree, ((caseconstanttype == Stella.SGT_STELLA_STRING) ? Stella.SYM_STELLA_STRING_EQLp : Stella.SYM_STELLA_EQLp), MV_returnarray));
      }
      if (!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP)) {
        tree = Cons.attachUnhandledCaseErrorClause(tree, tree.rest.value);
      }
      { Cons cursor = tree.rest.rest;
        Cons conditiontree = null;

        while (!(cursor == Stella.NIL)) {
          conditiontree = ((Cons)(cursor.value));
          if (!(conditiontree.value == Stella.SYM_STELLA_OTHERWISE)) {
            conditiontree.firstSetter((Stella_Object.consP(conditiontree.value) ? Cons.walkListOfTrees(((Cons)(conditiontree.value))) : Stella_Object.walkATree(conditiontree.value, new Object[1])));
          }
          conditiontree.rest = Cons.walkListOfStatements(conditiontree.rest);
          cursor = cursor.rest;
        }
        { Cons _return_temp = tree;

          MV_returnarray[0] = Stella.SGT_STELLA_VOID;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons walkNonBuiltInCaseTree(Cons tree, Symbol equalitytest, Object [] MV_returnarray) {
    { Stella_Object testexpression = tree.rest.value;
      Stella_Object testvariable = ((Stella_Object.atomicExpressionP(testexpression) ||
          (Cons.countCaseTestClauses(tree, new Object[1]) <= 1)) ? tree.rest.value : Stella.localGensym("TEST-VALUE"));
      Cons conditions = tree.rest.rest;

      { Cons cond = null;
        Cons iter000 = ((Cons)(conditions));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          cond = ((Cons)(iter000.value));
          cond.firstSetter(Stella_Object.yieldCondTestOrTests(cond.value, testvariable, equalitytest));
        }
      }
      conditions = Cons.attachUnhandledCaseErrorClause(conditions, testvariable);
      return (Cons.walkAConsTree((Stella_Object.eqlP(testexpression, testvariable) ? Cons.cons(Stella.SYM_STELLA_COND, conditions.concatenate(Stella.NIL, Stella.NIL)) : Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(testvariable, Cons.cons(testexpression, Stella.NIL)), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_COND, conditions.concatenate(Stella.NIL, Stella.NIL)), Cons.cons(Stella.NIL, Stella.NIL)))))), MV_returnarray));
    }
  }

  public static Cons attachUnhandledCaseErrorClause(Cons casetree, Stella_Object testtree) {
    { Stella_Object lastclause = casetree.last();

      if (Stella_Object.consP(lastclause) &&
          (!(((Cons)(lastclause)).value == Stella.SYM_STELLA_OTHERWISE))) {
        return (casetree.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OTHERWISE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR, Cons.cons(Stella_Object.copyConsTree(testtree), Cons.cons(Cons.cons(StringWrapper.wrapString(" is not a valid case option"), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL));
      }
      else {
        return (casetree);
      }
    }
  }

  public static int countCaseTestClauses(Cons tree, Object [] MV_returnarray) {
    { Cons clauses = ((Cons)(tree.rest.rest));
      int nofclauses = 0;
      boolean otherwiseP = false;

      { Cons clause = null;
        Cons iter000 = clauses;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          clause = ((Cons)(iter000.value));
          if (Stella_Object.safePrimaryType(clause.value) == Stella.SGT_STELLA_CONS) {
            nofclauses = nofclauses + ((Cons)(clause.value)).length();
          }
          else {
            if (clause.value == Stella.SYM_STELLA_OTHERWISE) {
              otherwiseP = true;
            }
            else {
              nofclauses = nofclauses + 1;
            }
          }
        }
      }
      { int _return_temp = nofclauses;

        MV_returnarray[0] = BooleanWrapper.wrapBoolean(otherwiseP);
        return (_return_temp);
      }
    }
  }

  public static Cons walkHardcodedSymbolCaseTree(Cons tree, Object [] MV_returnarray) {
    tree.secondSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYMBOL_ID, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(tree.rest.value, Cons.cons(Cons.cons(Stella.SYM_STELLA_GENERALIZED_SYMBOL, Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))));
    { Cons cond = null;
      Cons iter000 = ((Cons)(tree.rest.rest));

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        cond = ((Cons)(iter000.value));
        cond.firstSetter(Stella_Object.yieldHardcodedCaseSymbolIdOrIds(cond.value));
      }
    }
    return (Cons.walkCaseTree(tree, MV_returnarray));
  }

  public static Cons condTreeToIfTree(Cons tree) {
    { Stella_Object firstcondition = tree.rest.value;
      Cons otherconditions = tree.rest.rest;
      Stella_Object firsttest = null;

      if (Stella_Object.safePrimaryType(firstcondition) == Stella.SGT_STELLA_CONS) {
        { Cons firstcondition000 = ((Cons)(firstcondition));

          firsttest = firstcondition000.value;
          if (firsttest == Stella.SYM_STELLA_OTHERWISE) {
            if (otherconditions == Stella.NIL) {
              tree.firstSetter(Stella.SYM_STELLA_PROGN);
              tree.rest = firstcondition000.rest;
              return (tree);
            }
            else {
              firstcondition000.value = Stella.SYM_STELLA_TRUE;
              return (Cons.condTreeToIfTree(tree));
            }
          }
          else if (otherconditions == Stella.NIL) {
            tree.firstSetter(Stella.SYM_STELLA_WHEN);
            tree.rest = firstcondition000;
            return (tree);
          }
          else {
            firstcondition000.value = Stella.SYM_STELLA_PROGN;
            tree.secondSetter(Stella.SYM_STELLA_COND);
            return (Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(firsttest, Cons.cons(Cons.cons(firstcondition000, Cons.cons(Cons.condTreeToIfTree(tree.rest), Stella.NIL)), Stella.NIL)))));
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
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal condition in COND statement: `" + Stella_Object.deUglifyParseTree(firstcondition) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, new Object[1]));
      }
    }
  }

  public static Cons walkCondTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object condition = null;
      Cons iter000 = tree.rest;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        condition = iter000.value;
        if (Stella_Object.safePrimaryType(condition) == Stella.SGT_STELLA_CONS) {
          { Cons condition000 = ((Cons)(condition));

            if (!(condition000.value == Stella.SYM_STELLA_OTHERWISE)) {
              condition000.value = Stella_Object.walkExpressionTree(condition000.value, Stella.SGT_STELLA_BOOLEAN, Stella.SYM_STELLA_COND, true, new Object[1]);
              if (Stella_Object.proceduralExpressionP(condition000.value)) {
                return (Cons.walkAConsTree(Cons.condTreeToIfTree(tree), MV_returnarray));
              }
            }
            condition000.rest = Cons.walkListOfStatements(condition000.rest);
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
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal condition in COND statement: `" + Stella_Object.deUglifyParseTree(condition) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
        }
      }
    }
    { Cons _return_temp = tree;

      MV_returnarray[0] = Stella.SGT_STELLA_VOID;
      return (_return_temp);
    }
  }

  public static Stella_Object helpWalkBooleanTree(Cons tree) {
    { Cons cursor = tree.rest;
      Stella_Object temp = null;

      while (!(cursor == Stella.NIL)) {
        cursor.value = (Stella_Object.andOrNotTreeP(cursor.value) ? Cons.helpWalkBooleanTree(((Cons)(cursor.value))) : Stella_Object.walkExpressionTree(cursor.value, Stella.SGT_STELLA_BOOLEAN, ((Symbol)(tree.value)), true, new Object[1]));
        cursor = cursor.rest;
      }
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

        if (testValue000 == Stella.SYM_STELLA_AND) {
          if (tree.rest == Stella.NIL) {
            return (Stella.TRUE_WRAPPER);
          }
          if (tree.rest.rest == Stella.NIL) {
            temp = tree.rest.value;
            return (temp);
          }
        }
        else if (testValue000 == Stella.SYM_STELLA_OR) {
          if (tree.rest == Stella.NIL) {
            return (Stella.FALSE_WRAPPER);
          }
          if (tree.rest.rest == Stella.NIL) {
            temp = tree.rest.value;
            return (temp);
          }
        }
        else if (testValue000 == Stella.SYM_STELLA_NOT) {
          if (Cons.badArgumentCountP(tree, 1)) {
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_BOOLEAN, new Object[1]));
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (tree);
    }
  }

  public static Stella_Object walkBooleanTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object otree = Cons.helpWalkBooleanTree(tree);

      if (Stella_Object.proceduralExpressionP(otree)) {
        otree = Cons.percolateOutBooleanVrletExpressions(((Cons)(otree)));
      }
      { Stella_Object _return_temp = otree;

        MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
        return (_return_temp);
      }
    }
  }

  public static Cons walkChooseTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Stella_Object test = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_BOOLEAN, ((Symbol)(operator)), true, new Object[1]);
      Stella_Object temp = null;
      StandardObject type1 = null;
      StandardObject type2 = null;
      StandardObject type = null;

      tree.secondSetter(test);
      if (Stella_Object.vrletExpressionP(test)) {
        return (Cons.percolateOutVrletExpression(tree, ((Cons)(test)), Stella.SGT_STELLA_BOOLEAN, MV_returnarray));
      }
      if (Cons.badArgumentCountP(tree, 3)) {
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        temp = Stella_Object.walkExpressionTree(tree.rest.rest.value, ((StandardObject)(Stella.$TARGETTYPE$.get())), Stella.SYM_STELLA_CHOOSE, true, caller_MV_returnarray);
        type1 = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.thirdSetter(temp);
      { Object [] caller_MV_returnarray = new Object[1];

        temp = Stella_Object.walkExpressionTree(tree.fourth(), ((StandardObject)(Stella.$TARGETTYPE$.get())), Stella.SYM_STELLA_CHOOSE, true, caller_MV_returnarray);
        type2 = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.fourthSetter(temp);
      if (type1 == Stella.SGT_STELLA_UNKNOWN) {
        type = type2;
        tree.thirdSetter(Stella_Object.coerceATree(tree.rest.rest.value, type1, type, new Object[1]));
      }
      else if (type2 == Stella.SGT_STELLA_UNKNOWN) {
        type = type1;
        tree.fourthSetter(Stella_Object.coerceATree(tree.fourth(), type2, type, new Object[1]));
      }
      else {
        type = StandardObject.twoArgumentLeastCommonSupertype(type1, type2);
      }
      if ((type == Stella.SGT_STELLA_VOID) ||
          ((!StandardObject.subTypeSpecOfP(type, Stella.SGT_STELLA_OBJECT)) &&
           StandardObject.typeSpecToClass(type).abstractP)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Incompatible subexpression types `" + Stella_Object.deUglifyParseTree(type1) + "' and `" + Stella_Object.deUglifyParseTree(type2) + "'");
                Stella.STANDARD_ERROR.nativeStream.println(" in 'choose' expression..");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
      }
      if (Stella_Object.vrletExpressionP(tree.rest.rest.value) ||
          Stella_Object.vrletExpressionP(tree.fourth())) {
        { Symbol resultvariable = Stella.localGensym("CHOOSE-VALUE");

          { Stella_Object value000 = null;
            StandardObject value001 = null;

            { Object [] caller_MV_returnarray = new Object[1];

              value000 = Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(resultvariable, Cons.cons(type, Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IF, Cons.cons(tree.rest.value, Cons.cons(Cons.list$(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(resultvariable, Cons.cons(Cons.cons(tree.rest.rest.value, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(resultvariable, Cons.cons(Cons.cons(tree.fourth(), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(resultvariable, Cons.cons(Stella.NIL, Stella.NIL)))))), caller_MV_returnarray);
              value001 = ((StandardObject)(caller_MV_returnarray[0]));
            }
            { Cons _return_temp = ((Cons)(value000));

              MV_returnarray[0] = value001;
              return (_return_temp);
            }
          }
        }
      }
      if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      }
      else {
        if ((!(type1 == type)) &&
            (!StandardObject.subTypeSpecOfP(type1, type2))) {
          tree.thirdSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(tree.rest.rest.value, Cons.cons(Cons.cons(type, Stella.NIL), Stella.NIL)))));
        }
        if ((!(type2 == type)) &&
            (!StandardObject.subTypeSpecOfP(type2, type1))) {
          tree.fourthSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_CAST, Cons.cons(tree.fourth(), Cons.cons(Cons.cons(type, Stella.NIL), Stella.NIL)))));
        }
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = type;
        return (_return_temp);
      }
    }
  }

  public static Cons walkConditionalTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Stella_Object test = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_BOOLEAN, ((Symbol)(operator)), true, new Object[1]);

      tree.secondSetter(test);
      if (Stella_Object.proceduralExpressionP(test)) {
        { Cons _return_temp = Cons.transformBooleanProceduralExpression(tree, ((Cons)(test)), new Object[1]);

          MV_returnarray[0] = Stella.SGT_STELLA_VOID;
          return (_return_temp);
        }
      }
      { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(operator));

        if (testValue000 == Stella.SYM_STELLA_IF) {
          if (Cons.badArgumentCountP(tree, 3)) {
            return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
          }
          tree.thirdSetter(Stella_Object.walkStatement(tree.rest.rest.value, true));
          tree.fourthSetter(Stella_Object.walkStatement(tree.fourth(), true));
        }
        else if ((testValue000 == Stella.SYM_STELLA_WHEN) ||
            (testValue000 == Stella.SYM_STELLA_UNLESS)) {
          tree.rest.rest = Cons.walkListOfStatements(tree.rest.rest);
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Cons walkWhileTree(Cons tree, Object [] MV_returnarray) {
    { Object old$Nofspecialsatloopentry$000 = Stella.$NOFSPECIALSATLOOPENTRY$.get();

      try {
        Native.setIntSpecial(Stella.$NOFSPECIALSATLOOPENTRY$, ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length());
        { Stella_Object test = Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_BOOLEAN, Stella.SYM_STELLA_WHILE, true, new Object[1]);
          Cons body = tree.rest.rest;

          tree.secondSetter(test);
          if (Stella_Object.proceduralExpressionP(test)) {
            tree.rest.rest = Stella.NIL;
            return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LOOP, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(test, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Stella.NIL), Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), MV_returnarray));
          }
          tree.rest.rest = Cons.walkListOfStatements(tree.rest.rest);
          { Cons _return_temp = tree;

            MV_returnarray[0] = Stella.SGT_STELLA_VOID;
            return (_return_temp);
          }
        }

      } finally {
        Stella.$NOFSPECIALSATLOOPENTRY$.set(old$Nofspecialsatloopentry$000);
      }
    }
  }

  public static Cons walkLoopExitTree(Cons tree, Object [] MV_returnarray) {
    Cons.badArgumentCountP(tree, 0);
    if (Stella.needToUnbindSpecialsP()) {
      { Cons unbindtree = Stella.yieldLoopExitSpecialUnbindTree();

        { Object old$SpecialsenabledP$000 = Stella.$SPECIALSENABLEDp$.get();

          try {
            Native.setBooleanSpecial(Stella.$SPECIALSENABLEDp$, false);
            return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(unbindtree, Cons.cons(Cons.cons(tree, Stella.NIL), Stella.NIL)))), MV_returnarray));

          } finally {
            Stella.$SPECIALSENABLEDp$.set(old$SpecialsenabledP$000);
          }
        }
      }
    }
    else {
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Cons walkLoopTree(Cons tree, Object [] MV_returnarray) {
    { Object old$Nofspecialsatloopentry$000 = Stella.$NOFSPECIALSATLOOPENTRY$.get();

      try {
        Native.setIntSpecial(Stella.$NOFSPECIALSATLOOPENTRY$, ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length());
        tree.rest = Cons.walkListOfStatements(tree.rest);
        return (Stella_Object.sysTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));

      } finally {
        Stella.$NOFSPECIALSATLOOPENTRY$.set(old$Nofspecialsatloopentry$000);
      }
    }
  }

  public static Cons walkMvBindTree(Cons tree, Object [] MV_returnarray) {
    if ((tree.length() < 3) ||
        (!Stella_Object.consP(tree.rest.value))) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal 'mv-bind' expression: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    { Cons declarations = ((Cons)(tree.rest.value));
      Stella_Object mvtree = tree.rest.rest.value;
      Cons body = tree.rest.rest.rest;
      Cons variables = Stella.NIL;
      Stella_Object decl = null;
      List targettypes = List.newList();

      { ConsIterator it = declarations.allocateIterator();

        while (it.nextP()) {
          decl = it.value;
          { Surrogate testValue000 = Stella_Object.safePrimaryType(decl);

            if (testValue000 == Stella.SGT_STELLA_CONS) {
              { Cons decl000 = ((Cons)(decl));

                if (!(Stella_Object.symbolP(decl000.value) &&
                    (decl000.length() == 2))) {
                  { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Illegal variable declaration `" + Stella_Object.deUglifyParseTree(decl000) + "' in 'mv-bind' expression: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                  return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
                }
                targettypes.push(decl000.rest.value.yieldTypeSpecifier());
                decl000.rest.rest = Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL);
                variables = Cons.cons(decl000.value, variables);
              }
            }
            else if (Surrogate.subtypeOfSymbolP(testValue000)) {
              { Symbol decl000 = ((Symbol)(decl));

                targettypes.push(Stella.SGT_STELLA_UNKNOWN);
                it.valueSetter(Cons.cons(decl000, Cons.list$(Cons.cons(Stella.SGT_STELLA_UNKNOWN, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))));
                variables = Cons.cons(decl000, variables);
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
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal variable `" + Stella_Object.deUglifyParseTree(decl) + "' in 'mv-bind' expression: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
              return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
            }
          }
        }
      }
      variables = variables.reverse();
      { Stella_Object variable = null;
        Cons iter000 = variables;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          variable = iter000.value;
          Symbol.pushVariableBinding(((Symbol)(variable)), Stella.SGT_STELLA_UNINITIALIZED);
        }
      }
      { Stella_Object omvtree = null;
        Cons valuestree = null;
        List variabletypes = null;

        { Object [] caller_MV_returnarray = new Object[2];

          omvtree = Stella_Object.walkMvExpressionTree(mvtree, targettypes.reverse(), Stella.SYM_STELLA_MV_BIND, caller_MV_returnarray);
          valuestree = ((Cons)(caller_MV_returnarray[0]));
          variabletypes = ((List)(caller_MV_returnarray[1]));
        }
        { Stella_Object variable = null;
          Cons iter001 = variables;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            variable = iter001.value;
            variable = variable;
            Stella.popVariableBinding();
          }
        }
        targettypes.free();
        tree.rest.rest.rest = Stella.NIL;
        { Cons decl000 = null;
          Cons iter002 = ((Cons)(declarations));
          StandardObject type = null;
          Cons iter003 = variabletypes.theConsList;

          for (;(!(iter002 == Stella.NIL)) &&
                    (!(iter003 == Stella.NIL)); iter002 = iter002.rest, iter003 = iter003.rest) {
            decl000 = ((Cons)(iter002.value));
            type = ((StandardObject)(iter003.value));
            if (Stella.SGT_STELLA_UNKNOWN == decl000.rest.value) {
              decl000.secondSetter(type);
            }
          }
        }
        variabletypes.free();
        if (valuestree != null) {
          valuestree.firstSetter(Stella.SYM_STELLA_PROGN);
          { ConsIterator it = valuestree.rest.allocateIterator();
            Stella_Object var = null;
            Cons iter004 = variables;

            for (;it.nextP() &&
                      (!(iter004 == Stella.NIL)); iter004 = iter004.rest) {
              var = iter004.value;
              it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(var, Cons.cons(Cons.cons(it.value, Stella.NIL), Stella.NIL)))));
            }
          }
          valuestree = ((Cons)(omvtree));
        }
        else {
          valuestree = Cons.list$(Cons.cons(Stella.SYM_STELLA_MV_SETQ, Cons.cons(variables, Cons.cons(Cons.cons(omvtree, Stella.NIL), Stella.NIL))));
        }
        return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(declarations, Cons.cons(Cons.cons(valuestree, body.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)))), MV_returnarray));
      }
    }
  }

  public static Cons walkMvSetqTree(Cons tree, Object [] MV_returnarray) {
    { boolean testValue000 = false;

      if (Cons.badArgumentCountP(tree, 2)) {
        testValue000 = true;
      }
      else {
        if (!Stella_Object.consP(tree.rest.value)) {
          testValue000 = true;
        }
        else {
          {
            { boolean alwaysP000 = true;

              { Stella_Object v = null;
                Cons iter000 = ((Cons)(tree.rest.value));

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  v = iter000.value;
                  if (!Stella_Object.symbolP(v)) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
              testValue000 = alwaysP000;
            }
            testValue000 = !testValue000;
          }
        }
      }
      if (testValue000) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal 'mv-setq' expression: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
    }
    { Cons variables = ((Cons)(tree.rest.value));
      List targettypes = List.newList();

      { ConsIterator it = variables.allocateIterator();
        Cons collect000 = null;

        while (it.nextP()) {
          it.valueSetter(Symbol.trueVariableName(((Symbol)(it.value))));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Symbol.lookupVariableType(((Symbol)(it.value))), Stella.NIL);
              if (targettypes.theConsList == Stella.NIL) {
                targettypes.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(targettypes.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Symbol.lookupVariableType(((Symbol)(it.value))), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object otree = null;
        Cons valuestree = null;
        List valuetypes = null;

        { Object [] caller_MV_returnarray = new Object[2];

          otree = Stella_Object.walkMvExpressionTree(tree.rest.rest.value, targettypes, Stella.SYM_STELLA_MV_SETQ, caller_MV_returnarray);
          valuestree = ((Cons)(caller_MV_returnarray[0]));
          valuetypes = ((List)(caller_MV_returnarray[1]));
        }
        valuetypes.free();
        targettypes.free();
        if (valuestree != null) {
          valuestree.firstSetter(Stella.SYM_STELLA_PROGN);
          { ConsIterator it = valuestree.rest.allocateIterator();
            Stella_Object var = null;
            Cons iter001 = variables;

            for (;it.nextP() &&
                      (!(iter001 == Stella.NIL)); iter001 = iter001.rest) {
              var = iter001.value;
              it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(var, Cons.cons(Cons.cons(it.value, Stella.NIL), Stella.NIL)))));
            }
          }
          tree.rest.rest = Stella.NIL;
          return (Stella_Object.sysTree(otree, Stella.SGT_STELLA_VOID, MV_returnarray));
        }
        tree.thirdSetter(otree);
        return (Stella_Object.sysTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
    }
  }

  public static Cons walkReturnTree(Cons tree, Object [] MV_returnarray) {
    if (!(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())) != null)) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Return statement encountered outside of method or function definition.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    Native.setBooleanSpecial(Stella.$FOUNDRETURNp$, true);
    if (Stella.needToUnbindSpecialsP()) {
      return (Cons.walkReturnAndUnbindSpecials(tree, MV_returnarray));
    }
    { MethodSlot method = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get()));
      List targettypes = List.newList();

      { StandardObject rtype = null;
        Cons iter000 = method.methodReturnTypeSpecifiers().theConsList;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          rtype = ((StandardObject)(iter000.value));
          if (collect000 == null) {
            {
              collect000 = Cons.cons(StandardObject.computeRelativeTypeSpec(rtype, method.slotOwner), Stella.NIL);
              if (targettypes.theConsList == Stella.NIL) {
                targettypes.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(targettypes.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(StandardObject.computeRelativeTypeSpec(rtype, method.slotOwner), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object otree = null;
        Cons valuestree = null;
        List valuetypes = null;

        { Object [] caller_MV_returnarray = new Object[2];

          otree = Stella_Object.walkMvExpressionTree((((tree.rest.length() == 1) &&
              (!(targettypes.rest() == Stella.NIL))) ? tree.rest.value : Cons.cons(Stella.SYM_STELLA_VALUES, tree.rest.concatenate(Stella.NIL, Stella.NIL))), targettypes, Stella.SYM_STELLA_RETURN, caller_MV_returnarray);
          valuestree = ((Cons)(caller_MV_returnarray[0]));
          valuetypes = ((List)(caller_MV_returnarray[1]));
        }
        targettypes.free();
        valuetypes.free();
        if (valuestree == null) {
          if (!(tree.rest == Stella.NIL)) {
            tree.secondSetter(otree);
          }
          { Cons _return_temp = tree;

            MV_returnarray[0] = Stella.SGT_STELLA_VOID;
            return (_return_temp);
          }
        }
        valuestree.firstSetter(Stella.SYM_STELLA_RETURN);
        { Cons _return_temp = ((Cons)(otree));

          MV_returnarray[0] = Stella.SGT_STELLA_VOID;
          return (_return_temp);
        }
      }
    }
  }

  public static Cons walkReturnAndUnbindSpecials(Cons tree, Object [] MV_returnarray) {
    { Cons unbindtree = Stella.yieldReturnSpecialUnbindTree();
      Cons valuetrees = tree.rest;
      Cons valuevariables = Stella.NIL;
      Cons valuebindings = Stella.NIL;

      { Object old$SpecialsenabledP$000 = Stella.$SPECIALSENABLEDp$.get();

        try {
          Native.setBooleanSpecial(Stella.$SPECIALSENABLEDp$, false);
          if (valuetrees.length() == 0) {
            return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(unbindtree, Cons.cons(Cons.cons(tree, Stella.NIL), Stella.NIL)))), MV_returnarray));
          }
          if ((valuetrees.length() == 1) &&
              (!(((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).methodReturnTypeSpecifiers().rest() == Stella.NIL))) {
            { int i = Stella.NULL_INTEGER;
              int iter000 = 0;
              int upperBound000 = ((MethodSlot)(Stella.$METHODBEINGWALKED$.get())).methodReturnTypeSpecifiers().length() - 1;
              Cons collect000 = null;

              for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
                i = iter000;
                i = i;
                if (collect000 == null) {
                  {
                    collect000 = Cons.cons(Stella.localGensym("RETURN-VALUE"), Stella.NIL);
                    if (valuevariables == Stella.NIL) {
                      valuevariables = collect000;
                    }
                    else {
                      Cons.addConsToEndOfConsList(valuevariables, collect000);
                    }
                  }
                }
                else {
                  {
                    collect000.rest = Cons.cons(Stella.localGensym("RETURN-VALUE"), Stella.NIL);
                    collect000 = collect000.rest;
                  }
                }
              }
            }
            tree.rest = valuevariables;
            return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_MV_BIND, Cons.cons(Cons.copyConsList(valuevariables), Cons.cons(Cons.cons(valuetrees.value, Stella_Object.treeToTrees(unbindtree).concatenate(Cons.cons(tree, Stella.NIL), Stella.NIL)), Stella.NIL)))), MV_returnarray));
          }
          { ConsIterator it = valuetrees.allocateIterator();

            while (it.nextP()) {
              if (Stella_Object.consP(it.value) ||
                  (Stella_Object.symbolP(it.value) &&
                   (Symbol.lookupOldValueVariable(((Symbol)(it.value))) != null))) {
                valuebindings = Cons.cons(Cons.cons(Stella.localGensym("RETURN-VALUE"), Cons.cons(it.value, Stella.NIL)), valuebindings);
                it.valueSetter(((Cons)(valuebindings.value)).value);
              }
            }
          }
          return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(valuebindings.reverse(), Cons.cons(Stella_Object.treeToTrees(unbindtree).concatenate(Cons.cons(tree, Stella.NIL), Stella.NIL), Stella.NIL)))), MV_returnarray));

        } finally {
          Stella.$SPECIALSENABLEDp$.set(old$SpecialsenabledP$000);
        }
      }
    }
  }

  public static Cons walkMvValuesTree(Cons tree, Object [] MV_returnarray) {
    if (tree.length() == 1) {
      { Cons _return_temp = tree;

        MV_returnarray[0] = tree;
        MV_returnarray[1] = StandardObject.listifyTypeSpec(Stella.SGT_STELLA_VOID);
        return (_return_temp);
      }
    }
    { Stella_Object otree = null;
      StandardObject otype = null;
      List returntypes = List.newList();
      Cons typedsystree = null;

      otype = otype;
      { Object [] caller_MV_returnarray = new Object[1];

        otree = Cons.walkValuesTree(tree, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.firstSetter(Stella.SYM_STELLA_VALUES);
      { ConsIterator it = tree.rest.allocateIterator();

        while (it.nextP()) {
          typedsystree = ((Cons)(it.value));
          returntypes.push(((StandardObject)(typedsystree.rest.rest.value)));
          if (Stella.SGT_STELLA_UNKNOWN == typedsystree.rest.rest.value) {
            it.valueSetter(typedsystree.rest.value);
          }
        }
      }
      { Cons _return_temp = ((Cons)(otree));

        MV_returnarray[0] = tree;
        MV_returnarray[1] = returntypes.reverse();
        return (_return_temp);
      }
    }
  }

  public static Slot slotFromExpressionTree(Cons tree) {
    if (Stella.SYM_STELLA_TYPED_SYS == tree.value) {
      tree = ((Cons)(tree.rest.value));
    }
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

      if ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE) ||
          ((testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD) ||
           ((testValue000 == Stella.SYM_STELLA_SYS_SLOT_VALUE_SETTER) ||
            (testValue000 == Stella.SYM_STELLA_SYS_CALL_METHOD_SETTER)))) {
        return (Stella_Class.lookupSlot(((Stella_Class)(((Surrogate)(tree.rest.value)).surrogateValue)), ((Symbol)(tree.rest.rest.value))));
      }
      else if (testValue000 == Stella.SYM_STELLA_SYS_CALL_FUNCTION) {
        { MethodSlot function = Symbol.lookupFunction(((Symbol)(tree.rest.value)));

          if ((function != null) &&
              Stella_Object.isaP(function, Stella.SGT_STELLA_METHOD_SLOT)) {
            return (function);
          }
        }
      }
      else {
        return (null);
      }
    }
    return (null);
  }

  public static Cons walkValuesTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object otree = null;
      StandardObject otype = null;
      Cons bindtree = Stella.NIL;
      Symbol valuevar = null;
      boolean hasproceduralvalueP = false;

      { ConsIterator it = tree.rest.allocateIterator();

        loop000 : while (it.nextP()) {
          { Object [] caller_MV_returnarray = new Object[1];

            otree = Stella_Object.walkATree(it.value, caller_MV_returnarray);
            otype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          if (Stella_Object.vrletExpressionP(otree)) {
            it.valueSetter(otree);
            hasproceduralvalueP = true;
            break loop000;
          }
          otree = Stella_Object.sysTree(otree, otype, new Object[1]);
          if (StandardObject.voidP(otype)) {
            otree = ((Cons)(otree)).concatenate(Cons.cons(Stella.SGT_STELLA_VOID, Stella.NIL), Stella.NIL);
          }
          it.valueSetter(otree);
        }
      }
      if (!hasproceduralvalueP) {
        tree.firstSetter(Stella.SYM_STELLA_PROGN);
        { Cons _return_temp = tree;

          MV_returnarray[0] = Stella.SGT_STELLA_VOID;
          return (_return_temp);
        }
      }
      { ConsIterator it = tree.rest.allocateIterator();

        loop001 : while (it.nextP()) {
          { Cons value = ((Cons)(it.value));

            if (Stella_Object.proceduralExpressionP(value) ||
                (!Stella_Object.atomicExpressionP(value.rest.value))) {
              valuevar = Stella.localGensym("VALUE");
              bindtree = Cons.cons(Cons.cons(valuevar, Cons.cons((Stella_Object.proceduralExpressionP(value) ? value : value.rest.value), Stella.NIL)), bindtree);
              if (Stella_Object.proceduralExpressionP(value)) {
                it.valueSetter(valuevar);
                break loop001;
              }
              else {
                value.secondSetter(valuevar);
              }
            }
          }
        }
      }
      return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(bindtree.reverse(), Cons.cons(Cons.cons(tree, Stella.NIL), Stella.NIL)))), MV_returnarray));
    }
  }

  public static Cons walkCastTree(Cons tree, Object [] MV_returnarray) {
    if (Cons.badArgumentCountP(tree, 2)) {
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
    }
    { StandardObject typespec = tree.rest.rest.value.yieldTypeSpecifier();

      tree.secondSetter(Stella_Object.walkExpressionTree(tree.rest.value, Stella.SGT_STELLA_UNKNOWN, Stella.SYM_STELLA_CAST, true, new Object[1]));
      if (Stella_Object.vrletExpressionP(tree.rest.value)) {
        return (Cons.percolateOutVrletExpression(tree, ((Cons)(tree.rest.value)), typespec, MV_returnarray));
      }
      tree.thirdSetter(typespec);
      if ((((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) &&
          ((tree.value == Stella.SYM_STELLA_CAST) &&
           (((Integer)(Stella.$SAFETY$.get())).intValue() >= 2))) {
        GeneralizedSymbol.registerSymbol(StandardObject.typeSpecToBaseType(typespec));
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = typespec;
        return (_return_temp);
      }
    }
  }

  public static Cons walkUnwindProtectSpecialTree(Cons tree, Object [] MV_returnarray) {
    { Cons bindings = ((Cons)(tree.rest.value));
      Cons body = tree.rest.rest;
      Symbol variable = null;
      Symbol oldvaluevariable = null;
      Cons oldvaluebindings = Stella.NIL;
      Cons bindtrees = Stella.NIL;
      Cons unbindtrees = Stella.NIL;

      { Cons binding = null;
        Cons iter000 = bindings;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = ((Cons)(iter000.value));
          variable = ((Symbol)(binding.value));
          bindtrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(binding.rest.value, Stella.NIL), Stella.NIL)))), bindtrees);
          oldvaluevariable = Stella.localGensym("OLD-" + variable.symbolName);
          Symbol.pushSpecial(variable, oldvaluevariable);
          oldvaluebindings = Cons.cons(Cons.cons(oldvaluevariable, Cons.cons(variable, Stella.NIL)), oldvaluebindings);
          unbindtrees = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variable, Cons.cons(Cons.cons(oldvaluevariable, Stella.NIL), Stella.NIL)))), unbindtrees);
        }
      }
      tree = ((Cons)(Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(oldvaluebindings.reverse(), Cons.cons(bindtrees.reverse().concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNWIND_PROTECT, Cons.cons(Cons.prognify(body), Cons.cons(unbindtrees.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))), new Object[1])));
      { Cons binding = null;
        Cons iter001 = bindings;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          binding = ((Cons)(iter001.value));
          binding = binding;
          Stella.popSpecial();
        }
      }
      { Cons _return_temp = tree;

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Cons walkClSpecialTree(Cons tree, Object [] MV_returnarray) {
    { Cons bindings = ((Cons)(tree.rest.value));
      Cons body = tree.rest.rest;
      Symbol variablename = null;
      StandardObject variabletype = null;
      boolean bindviasetqP = false;
      Cons bindviasetqtrees = Stella.NIL;
      Stella_Object otree = null;

      { Cons binding = null;
        Cons iter000 = bindings;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          binding = ((Cons)(iter000.value));
          variablename = ((Symbol)(binding.value));
          variabletype = Symbol.lookupGlobalVariableType(variablename);
          if (bindviasetqP) {
            bindviasetqtrees = Cons.cons(Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variablename, Cons.cons(Cons.cons(binding.rest.value, Stella.NIL), Stella.NIL)))), new Object[1]), bindviasetqtrees);
            binding.secondSetter(variabletype);
            binding.rest.rest = Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL);
          }
          else {
            otree = Stella_Object.walkExpressionTree(binding.rest.value, variabletype, Stella.SYM_STELLA_SPECIAL, true, new Object[1]);
            if (Stella_Object.proceduralExpressionP(otree)) {
              bindviasetqP = true;
              bindviasetqtrees = Cons.cons(Stella_Object.walkATree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(variablename, Cons.cons(Cons.cons(otree, Stella.NIL), Stella.NIL)))), new Object[1]), bindviasetqtrees);
              otree = Stella.SYM_STELLA_NULL;
            }
            binding.secondSetter(variabletype);
            binding.rest.rest = Cons.cons(otree, Stella.NIL);
          }
        }
      }
      tree.firstSetter(Stella.SYM_STELLA_SPECIAL);
      tree.rest.rest = bindviasetqtrees.reverse().concatenate(Cons.walkListOfStatements(body), Stella.NIL);
      return (Stella_Object.sysTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
  }

  public static Cons walkSpecialTree(Cons tree, Object [] MV_returnarray) {
    if (!(((Boolean)(Stella.$SPECIALSENABLEDp$.get())).booleanValue())) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" 'special' statement not legal in the current context: ");
              Stella.STANDARD_ERROR.nativeStream.println("`" + Stella_Object.deUglifyParseTree(tree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    { boolean testValue000 = false;

      if (tree.length() < 2) {
        testValue000 = true;
      }
      else {
        if (!Stella_Object.consP(tree.rest.value)) {
          testValue000 = true;
        }
        else {
          {
            { boolean alwaysP000 = true;

              { Cons binding = null;
                Cons iter000 = ((Cons)(tree.rest.value));

                loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  binding = ((Cons)(iter000.value));
                  if (!(Stella_Object.consP(binding) &&
                      (Stella_Object.symbolP(binding.value) &&
                       (binding.length() == 2)))) {
                    alwaysP000 = false;
                    break loop000;
                  }
                }
              }
              testValue000 = alwaysP000;
            }
            testValue000 = !testValue000;
          }
        }
      }
      if (testValue000) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal 'special' statement: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
    }
    if (((Cons)(tree.rest.value)).length() == 0) {
      tree.firstSetter(Stella.SYM_STELLA_LET);
      return (Cons.walkLetTree(tree, MV_returnarray));
    }
    { GlobalVariable variable = null;

      { Cons binding = null;
        Cons iter001 = ((Cons)(tree.rest.value));

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          binding = ((Cons)(iter001.value));
          variable = ((Symbol)(binding.value)).lookupGlobalVariable();
          if ((variable == null) ||
              (!variable.variableSpecialP)) {
            { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Trying to bind non-special variable `" + binding.value + "'");
                    Stella.STANDARD_ERROR.nativeStream.println(" in 'special' statement.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
              }
            }
          }
        }
      }
    }
    { Keyword testValue001 = Stella.specialImplementationStyle();

      if (testValue001 == Stella.KWD_COMMON_LISP) {
        return (Cons.walkClSpecialTree(tree, MV_returnarray));
      }
      else if (testValue001 == Stella.KWD_UNBIND_WITH_DESTRUCTORS) {
        return (Cons.walkClSpecialTree(tree, MV_returnarray));
      }
      else if (testValue001 == Stella.KWD_UNWIND_PROTECT) {
        return (Cons.walkUnwindProtectSpecialTree(tree, MV_returnarray));
      }
      else {
        { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

          stream000.nativeStream.print("`" + testValue001 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  public static Cons walkLetTree(Cons tree, Object [] MV_returnarray) {
    tree.secondSetter(Cons.walkVariableDeclarations(((Cons)(tree.rest.value))));
    { boolean testValue000 = false;

      { boolean foundP000 = false;

        { Cons d = null;
          Cons iter000 = ((Cons)(tree.rest.value));

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            d = ((Cons)(iter000.value));
            if (Stella_Object.proceduralExpressionP(d.rest.rest.value)) {
              foundP000 = true;
              break loop000;
            }
          }
        }
        testValue000 = foundP000;
      }
      testValue000 = !testValue000;
      if (testValue000) {
        tree.rest.rest = Cons.walkListOfStatements(tree.rest.rest);
        Cons.popLocalVariableBindings(((Cons)(tree.rest.value)));
        return (Stella_Object.sysTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
    }
    { Cons originaldeclarations = ((Cons)(tree.rest.value));
      Cons leadingdeclarations = Stella.NIL;
      Cons trailingdeclarations = Stella.NIL;
      boolean leadingP = true;

      { Cons d = null;
        Cons iter001 = ((Cons)(originaldeclarations));

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          d = ((Cons)(iter001.value));
          if (Stella_Object.proceduralExpressionP(d.rest.rest.value)) {
            leadingP = false;
          }
          if (leadingP) {
            leadingdeclarations = Cons.cons(d, leadingdeclarations);
          }
          else {
            trailingdeclarations = Cons.cons(d, trailingdeclarations);
          }
        }
      }
      leadingdeclarations = leadingdeclarations.reverse();
      trailingdeclarations = trailingdeclarations.reverse();
      tree.secondSetter(trailingdeclarations);
      tree = Cons.transformLetWithProceduralExpression(tree);
      if (!(leadingdeclarations == Stella.NIL)) {
        Cons.popLocalVariableBindings(leadingdeclarations);
        tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(leadingdeclarations, Cons.cons(Cons.cons(tree, Stella.NIL), Stella.NIL))));
      }
      return (Cons.walkAConsTree(tree, MV_returnarray));
    }
  }

  public static void popLocalVariableBindings(Cons declarations) {
    { Stella_Object d = null;
      Cons iter000 = declarations;

      for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
        d = iter000.value;
        d = d;
        Stella.popVariableBinding();
      }
    }
  }

  public static Cons transformLetWithProceduralExpression(Cons tree) {
    { Cons firstdeclaration = ((Cons)(((Cons)(tree.rest.value)).value));
      Stella_Object typetree = firstdeclaration.rest.value;
      Stella_Object vrlettree = Stella_Object.walkWithoutTypeTree(firstdeclaration.rest.rest.value);

      if (typetree == Stella.SGT_STELLA_UNKNOWN) {
        firstdeclaration.rest = firstdeclaration.rest.rest;
      }
      { Cons otree = null;
        StandardObject unusedtypespec = null;

        { Object [] caller_MV_returnarray = new Object[1];

          otree = Cons.transformProceduralExpression(tree, ((Cons)(vrlettree)), ((StandardObject)(typetree)), caller_MV_returnarray);
          unusedtypespec = ((StandardObject)(caller_MV_returnarray[0]));
        }
        unusedtypespec = unusedtypespec;
        return (otree);
      }
    }
  }

  public static Cons walkVariableDeclarations(Cons declarations) {
    { Cons odeclarations = Stella.NIL;
      Symbol variable = null;
      boolean vrletencounteredP = false;

      { Stella_Object decl = null;
        Cons iter000 = declarations;

        loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          decl = iter000.value;
          if (Stella_Object.safePrimaryType(decl) == Stella.SGT_STELLA_CONS) {
            { Cons decl000 = ((Cons)(decl));

              if (vrletencounteredP) {
                odeclarations = Cons.cons(decl000, odeclarations);
                continue loop000;
              }
              else if (!Stella_Object.symbolP(decl000.value)) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal variable in `let' declaration: `" + Stella_Object.deUglifyParseTree(decl000) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                variable = Stella.SYM_STELLA_ILLEGAL_VARIABLE;
              }
              else {
                variable = ((Symbol)(decl000.value));
                if ((variable.lookupGlobalVariable() != null) ||
                    Symbol.constantSymbolP(variable)) {
                  { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" `" + ((Symbol.constantSymbolP(variable) ? "Illegal binding of constant value " : "Illegal binding of global or special variable ")) + "'in `let' declaration:");
                          Stella.STANDARD_ERROR.nativeStream.println("    `" + Stella_Object.deUglifyParseTree(decl000) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                    }
                  }
                  variable = Stella.SYM_STELLA_ILLEGAL_VARIABLE;
                }
              }
              switch (decl000.length()) {
                case 1: 
                  { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Missing argument(s) in `let' declaration: `" + Stella_Object.deUglifyParseTree(decl000) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                    }
                  }
                break;
                case 2: 
                  if (decl000.rest.value == Stella.SYM_STELLA_NULL) {
                    { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationError();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                          {
                            Stella.STANDARD_ERROR.nativeStream.println();
                            Stella.STANDARD_ERROR.nativeStream.println(" Missing type specifier in `let' declaration: `" + Stella_Object.deUglifyParseTree(decl000) + "'.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                      }
                    }
                  }
                  odeclarations = Cons.cons(Symbol.walkADeclaration(variable, null, decl000.rest.value, false), odeclarations);
                break;
                case 3: 
                  odeclarations = Cons.cons(Symbol.walkADeclaration(variable, decl000.rest.value, decl000.rest.rest.value, false), odeclarations);
                break;
                default:
                  { Object old$PrintreadablyP$004 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationError();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                        {
                          Stella.STANDARD_ERROR.nativeStream.println();
                          Stella.STANDARD_ERROR.nativeStream.println(" Too many terms in `let' declaration:`" + Stella_Object.deUglifyParseTree(decl000) + "'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$004);
                    }
                  }
                break;
              }
              if (Stella_Object.proceduralExpressionP(((Cons)(odeclarations.value)).rest.rest.value)) {
                vrletencounteredP = true;
                Stella.popVariableBinding();
              }
            }
          }
          else {
            { Object old$PrintreadablyP$005 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Illegal `let' declaration: `" + Stella_Object.deUglifyParseTree(decl) + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$005);
              }
            }
          }
        }
      }
      return (odeclarations.reverse());
    }
  }

  public static Cons walkArefTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object operator = tree.value;
      Stella_Object otree = null;
      StandardObject otype = null;
      ParametricTypeSpecifier arraytype = null;
      StandardObject elementtype = null;
      Cons arguments = tree.rest;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkExpressionTree(arguments.value, Stella.SGT_STELLA_ARRAY, ((Symbol)(operator)), true, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      if (Stella_Object.vrletExpressionP(otree)) {
        arguments.firstSetter(otree);
        return (Cons.percolateOutVrletExpression(tree, ((Cons)(otree)), Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      if (!(StandardObject.arrayTypeSpecifierP(otype))) {
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
      }
      arraytype = ((ParametricTypeSpecifier)(otype));
      elementtype = StandardObject.extractParameterType(arraytype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]);
      { boolean testValue000 = false;

        testValue000 = ParametricTypeSpecifier.indefiniteArrayTypeP(arraytype);
        if (testValue000) {
          { boolean alwaysP000 = true;

            { IntegerWrapper dim = null;
              Cons iter000 = ParametricTypeSpecifier.arrayTypeDimensions(arraytype).rest();

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                dim = ((IntegerWrapper)(iter000.value));
                if (!(dim != null)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
          testValue000 = !testValue000;
        }
        if (testValue000) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Can't AREF underspecified array type");
                  Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(arraytype) + "' in");
                  Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
        }
      }
      arguments.firstSetter(otree);
      arguments = arguments.rest;
      if (operator == Stella.SYM_STELLA_AREF_SETTER) {
        { Object [] caller_MV_returnarray = new Object[1];

          otree = Stella_Object.walkExpressionTree(arguments.value, elementtype, ((Symbol)(operator)), true, caller_MV_returnarray);
          otype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        arguments.firstSetter(otree);
        if (Stella_Object.vrletExpressionP(otree)) {
          return (Cons.percolateOutVrletExpression(tree, ((Cons)(otree)), Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
        }
        arguments = arguments.rest;
      }
      if (!(arguments.length() == ParametricTypeSpecifier.arrayTypeRank(arraytype))) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" AREF indices don't match the rank of the array in");
                Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
      }
      while (!(arguments == Stella.NIL)) {
        { Object [] caller_MV_returnarray = new Object[1];

          otree = Stella_Object.walkExpressionTree(arguments.value, Stella.SGT_STELLA_INTEGER, ((Symbol)(operator)), true, caller_MV_returnarray);
          otype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        arguments.firstSetter(otree);
        if (Stella_Object.vrletExpressionP(otree)) {
          return (Cons.percolateOutVrletExpression(tree, ((Cons)(otree)), Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
        }
        arguments = arguments.rest;
      }
      return (Stella_Object.sysTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(arraytype.specifierBaseType, Cons.cons(Cons.cons(operator, Cons.cons(Stella_Object.sysTree(tree.rest.value, arraytype, new Object[1]), tree.rest.rest.concatenate(Stella.NIL, Stella.NIL))), Stella.NIL)))), elementtype, MV_returnarray));
    }
  }

  public static Cons walkSlotValueSetterTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object objectref = null;
      StandardObject objecttype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        objectref = Stella_Object.walkATree(tree.rest.value, caller_MV_returnarray);
        objecttype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Stella_Object slotname = tree.fourth();
        Cons csoptions = tree.nthRest(4);
        Stella_Class objectclass = StandardObject.typeSpecToClass(objecttype);
        Slot slot = Stella_Class.lookupSlot(objectclass, ((Symbol)(slotname)));
        Stella_Object valueref = null;
        Cons otree = null;
        StandardObject otype = null;

        if (slot == null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Can't set a non-existent slot `" + Stella_Object.deUglifyParseTree(slotname) + "'");
                  Stella.STANDARD_ERROR.nativeStream.println("   on the class `" + Stella_Class.className(objectclass) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
        }
        { Surrogate testValue000 = Stella_Object.safePrimaryType(slot);

          if (Surrogate.subtypeOfMethodSlotP(testValue000)) {
            { MethodSlot slot000 = ((MethodSlot)(slot));

              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Can't set the method slot `" + Stella_Object.deUglifyParseTree(slot000) + "' by calling 'slot-value-setter'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
              return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
            }
          }
          else if (Surrogate.subtypeOfStorageSlotP(testValue000)) {
            { StorageSlot slot000 = ((StorageSlot)(slot));

              otype = slot000.computeReturnTypeSpec(objecttype);
              valueref = Stella_Object.walkExpressionTree(tree.rest.rest.value, otype, Stella.SYM_STELLA_SLOT_VALUE_SETTER, false, new Object[1]);
              { Object [] caller_MV_returnarray = new Object[1];

                otree = StorageSlot.yieldSlotValueSetterTree(slot000, objectref, objecttype, valueref, otype, csoptions, caller_MV_returnarray);
                otype = ((StandardObject)(caller_MV_returnarray[0]));
              }
              if (Stella_Object.proceduralExpressionP(otree)) {
                { Cons _return_temp = otree;

                  MV_returnarray[0] = otype;
                  return (_return_temp);
                }
              }
              else {
                { Stella_Object value000 = null;
                  StandardObject value001 = null;

                  { Object [] caller_MV_returnarray = new Object[1];

                    value000 = Slot.sysTreeIfNeeded(slot000, otree, objecttype, otype, caller_MV_returnarray);
                    value001 = ((StandardObject)(caller_MV_returnarray[0]));
                  }
                  { Cons _return_temp = ((Cons)(value000));

                    MV_returnarray[0] = value001;
                    return (_return_temp);
                  }
                }
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
      }
    }
  }

  public static Cons walkSlotValueTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object objectref = null;
      StandardObject objecttype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        objectref = Stella_Object.walkATree(tree.rest.value, caller_MV_returnarray);
        objecttype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Stella_Object slotname = tree.rest.rest.value;
        Cons csoptions = tree.nthRest(3);
        Stella_Class objectclass = StandardObject.typeSpecToClass(objecttype);
        Slot slot = Stella_Class.lookupSlot(objectclass, ((Symbol)(slotname)));
        Cons otree = null;
        StandardObject otype = null;

        if (slot == null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Can't read a non-existent slot `" + Stella_Object.deUglifyParseTree(slotname) + "'");
                  Stella.STANDARD_ERROR.nativeStream.println("   on the class `" + Stella_Class.className(objectclass) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_UNKNOWN, MV_returnarray));
        }
        { Surrogate testValue000 = Stella_Object.safePrimaryType(slot);

          if (Surrogate.subtypeOfMethodSlotP(testValue000)) {
            { MethodSlot slot000 = ((MethodSlot)(slot));

              { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Can't read the method slot `" + Stella_Object.deUglifyParseTree(slot000) + "' by calling 'slot-value'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                }
              }
              { Cons _return_temp = null;

                MV_returnarray[0] = null;
                return (_return_temp);
              }
            }
          }
          else if (Surrogate.subtypeOfStorageSlotP(testValue000)) {
            { StorageSlot slot000 = ((StorageSlot)(slot));

              otype = slot000.computeReturnTypeSpec(objecttype);
              { Object [] caller_MV_returnarray = new Object[1];

                otree = StorageSlot.yieldSlotValueTree(slot000, objectref, objecttype, otype, csoptions, caller_MV_returnarray);
                otype = ((StandardObject)(caller_MV_returnarray[0]));
              }
              if (Stella_Object.proceduralExpressionP(otree)) {
                { Cons _return_temp = otree;

                  MV_returnarray[0] = otype;
                  return (_return_temp);
                }
              }
              else {
                { Stella_Object value000 = null;
                  StandardObject value001 = null;

                  { Object [] caller_MV_returnarray = new Object[1];

                    value000 = Slot.sysTreeIfNeeded(slot000, otree, objecttype, otype, caller_MV_returnarray);
                    value001 = ((StandardObject)(caller_MV_returnarray[0]));
                  }
                  { Cons _return_temp = ((Cons)(value000));

                    MV_returnarray[0] = value001;
                    return (_return_temp);
                  }
                }
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
      }
    }
  }

  public static Cons walkSetfTree(Cons tree, Object [] MV_returnarray) {
    { Cons place = null;

      if (Stella_Object.consP(tree.rest.value)) {
        place = ((Cons)(tree.rest.value));
      }
      if (!((place != null) &&
          (Stella_Object.symbolP(place.value) &&
           (place.length() >= (((place.value == Stella.SYM_STELLA_SLOT_VALUE) ? 3 : 2)))))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal place argument in 'setf' expression: `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
      if (Cons.badArgumentCountP(tree, 2)) {
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
      { Stella_Object objectref = null;
        StandardObject objecttype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          objectref = Stella_Object.walkATree(place.rest.value, caller_MV_returnarray);
          objecttype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        objectref = Stella_Object.coerceATree(objectref, objecttype, objecttype, new Object[1]);
        { Stella_Class objectclass = StandardObject.typeSpecToClass(objecttype);
          Stella_Object slotname = place.value;
          Slot slot = Stella_Class.lookupSlot(objectclass, ((Symbol)(slotname)));
          StandardObject slottype = null;
          Cons otherplacearguments = place.rest.rest;
          Cons otree = Stella.NIL;

          if (slot != null) {
            slottype = slot.computeReturnTypeSpec(objecttype);
          }
          { Stella_Object valueref = null;
            StandardObject valuetypespec = null;

            { Object [] caller_MV_returnarray = new Object[1];

              valueref = Stella_Object.walkExpressionTree(tree.rest.rest.value, slottype, Stella.SYM_STELLA_SETF, true, caller_MV_returnarray);
              valuetypespec = ((StandardObject)(caller_MV_returnarray[0]));
            }
            if (Stella_Object.proceduralExpressionP(valueref)) {
              tree.thirdSetter(valueref);
              { Cons ootree = null;
                StandardObject otypespec = null;

                { Object [] caller_MV_returnarray = new Object[1];

                  ootree = Cons.transformProceduralExpression(tree, ((Cons)(valueref)), valuetypespec, caller_MV_returnarray);
                  otypespec = ((StandardObject)(caller_MV_returnarray[0]));
                }
                { Cons _return_temp = ootree;

                  MV_returnarray[0] = otypespec;
                  return (_return_temp);
                }
              }
            }
            if (slotname == Stella.SYM_STELLA_SLOT_VALUE) {
              return (Cons.walkAConsTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_SLOT_VALUE_SETTER, Cons.cons(objectref, Cons.cons(Cons.cons(valueref, otherplacearguments.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL)))), MV_returnarray));
            }
            if (Surrogate.subtypeOfStorageSlotP(Stella_Object.safePrimaryType(slot))) {
              { StorageSlot slot000 = ((StorageSlot)(slot));

                if ((slot000.writer() != null) ||
                    (Stella_Class.lookupSlot(objectclass, Symbol.yieldSetterMethodName(((Symbol)(slotname)))) != null)) {
                  return (Cons.walkAConsTree(Cons.cons(((slot000.writer() != null) ? slot000.writer() : Symbol.yieldSetterMethodName(((Symbol)(slotname)))), Cons.cons(objectref, Cons.cons(valueref, otherplacearguments.concatenate(Stella.NIL, Stella.NIL)))), MV_returnarray));
                }
                if (StorageSlot.systemDefinedSlotWriterP(slot000)) {
                  { Stella_Object value000 = null;
                    StandardObject value001 = null;

                    { Object [] caller_MV_returnarray = new Object[1];

                      value000 = Slot.sysTreeIfNeeded(slot000, Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_CALL_METHOD, Cons.cons(slot000.slotOwner, Cons.cons(Cons.cons(Symbol.yieldSetterMethodName(((Symbol)(slotname))), Cons.cons(objectref, Cons.cons(Stella_Object.walkExpressionTree(valueref, slottype, Stella.SYM_STELLA_SETF, false, new Object[1]), Stella.NIL))), Stella.NIL)))), objecttype, slottype, caller_MV_returnarray);
                      value001 = ((StandardObject)(caller_MV_returnarray[0]));
                    }
                    { Cons _return_temp = ((Cons)(value000));

                      MV_returnarray[0] = value001;
                      return (_return_temp);
                    }
                  }
                }
                otree = StorageSlot.yieldSlotValueSetterTree(slot000, objectref, objecttype, valueref, slottype, null, new Object[1]);
                if (Stella_Object.proceduralExpressionP(otree)) {
                  { Cons _return_temp = otree;

                    MV_returnarray[0] = slottype;
                    return (_return_temp);
                  }
                }
                else {
                  { Stella_Object value002 = null;
                    StandardObject value003 = null;

                    { Object [] caller_MV_returnarray = new Object[1];

                      value002 = Slot.sysTreeIfNeeded(slot000, otree, objecttype, slottype, caller_MV_returnarray);
                      value003 = ((StandardObject)(caller_MV_returnarray[0]));
                    }
                    { Cons _return_temp = ((Cons)(value002));

                      MV_returnarray[0] = value003;
                      return (_return_temp);
                    }
                  }
                }
              }
            }
            else {
              return (Cons.walkAConsTree(Cons.cons(Symbol.yieldSetterMethodName(((Symbol)(slotname))), Cons.cons(objectref, Cons.cons(valueref, otherplacearguments.concatenate(Stella.NIL, Stella.NIL)))), MV_returnarray));
            }
          }
        }
      }
    }
  }

  public static Cons walkSetqTree(Cons tree, Object [] MV_returnarray) {
    if (Cons.badArgumentCountP(tree, 2)) {
      return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
    }
    { Stella_Object variable = tree.rest.value;
      Stella_Object value = tree.rest.rest.value;
      StandardObject variabletype = null;
      Stella_Object ovalue = null;
      StandardObject otype = null;

      if (!(Stella_Object.symbolP(variable))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal first argument to 'setq'; should be a symbol: `" + Stella_Object.deUglifyParseTree(variable) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Stella_Object.walkDontCallMeTree(tree, Stella.SGT_STELLA_VOID, MV_returnarray));
      }
      variabletype = Symbol.lookupVariableType(((Symbol)(variable)));
      { Object [] caller_MV_returnarray = new Object[1];

        ovalue = Stella_Object.walkExpressionTree(value, variabletype, Stella.SYM_STELLA_SETQ, true, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      tree.thirdSetter(ovalue);
      if (!(Stella_Object.proceduralExpressionP(ovalue))) {
        tree.secondSetter(Symbol.trueVariableName(((Symbol)(variable))));
        if (Stella.walkingExpressionP() &&
            (!(((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP))) {
          return (Cons.setTargetLanguageType(Stella_Object.sysTree(tree, otype, new Object[1]), StandardObject.typeSpecToBaseType(variabletype), MV_returnarray));
        }
        if (!Stella_Object.eqlP(variable, tree.rest.value)) {
          return (Stella_Object.sysTree(tree, otype, MV_returnarray));
        }
        else {
          { Cons _return_temp = tree;

            MV_returnarray[0] = otype;
            return (_return_temp);
          }
        }
      }
      return (Cons.transformProceduralExpression(tree, ((Cons)(ovalue)), ((otype == Stella.SGT_STELLA_UNKNOWN) ? variabletype : otype), MV_returnarray));
    }
  }

  public static Cons percolateOutVrletExpression(Cons statement, Cons vrexpression, StandardObject type, Object [] MV_returnarray) {
    { Stella_Object laststatement = null;
      Cons cursor = vrexpression.rest.rest;

      loop000 : while (!(cursor == Stella.NIL)) {
        if (cursor.rest == Stella.NIL) {
          laststatement = cursor.value;
          cursor.value = Stella.KWD_PLACE_WHERE_LAST_EXPRESSION_WAS;
          break loop000;
        }
        cursor = cursor.rest;
      }
      Stella_Object.substituteOnce(statement, laststatement, vrexpression);
      Stella_Object.substituteOnce(vrexpression, statement, Stella.KWD_PLACE_WHERE_LAST_EXPRESSION_WAS);
      { Cons _return_temp = vrexpression;

        MV_returnarray[0] = type;
        return (_return_temp);
      }
    }
  }

  public static Cons transformProceduralExpression(Cons statement, Cons vrexpression, StandardObject type, Object [] MV_returnarray) {
    if (StandardObject.typeSpecToBaseType(type) == Stella.SGT_STELLA_BOOLEAN) {
      return (Cons.transformBooleanProceduralExpression(statement, vrexpression, MV_returnarray));
    }
    else {
      return (Cons.transformVrletExpression(statement, vrexpression, MV_returnarray));
    }
  }

  public static Cons percolateOutBooleanVrletExpressions(Cons booleanexpression) {
    { Symbol testvariable = Stella.localGensym("TEST-VALUE");
      Cons otree = null;

      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(testvariable, Cons.cons(Stella.SYM_STELLA_FALSE, Stella.NIL)), Stella.NIL), Cons.cons(Stella_Object.helpTransformBooleanProceduralExpression(booleanexpression, testvariable).concatenate(Cons.cons(testvariable, Stella.NIL), Stella.NIL), Stella.NIL))));
      return (otree);
    }
  }

  public static Cons transformBooleanProceduralExpression(Cons statement, Cons vrexpression, Object [] MV_returnarray) {
    if (vrexpression.value == Stella.SYM_STELLA_VRLET) {
      return (Cons.transformVrletExpression(statement, vrexpression, MV_returnarray));
    }
    { Symbol testvariable = Stella.localGensym("TEST-VALUE");
      Cons otree = null;

      Stella_Object.substituteOnce(statement, testvariable, vrexpression);
      otree = ((Cons)(Stella_Object.walkWithoutTypeTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(testvariable, Cons.cons(Stella.SYM_STELLA_FALSE, Stella.NIL)), Stella.NIL), Cons.cons(Stella_Object.helpTransformBooleanProceduralExpression(vrexpression, testvariable).concatenate(Cons.cons(statement, Stella.NIL), Stella.NIL), Stella.NIL)))))));
      { Cons _return_temp = otree;

        MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
        return (_return_temp);
      }
    }
  }

  public static Cons transformVrletExpression(Cons statement, Cons vrexpression, Object [] MV_returnarray) {
    { Cons cursor = null;
      Stella_Object laststatement = null;

      Stella_Object.substituteOnce(statement, Stella.KWD_PLACE_WHERE_VRLET_WAS, vrexpression);
      vrexpression.value = Stella.SYM_STELLA_LET;
      cursor = vrexpression.rest.rest;
      loop000 : while (!(cursor == Stella.NIL)) {
        if (cursor.rest == Stella.NIL) {
          laststatement = cursor.value;
          cursor.value = statement;
          break loop000;
        }
        cursor = cursor.rest;
      }
      Stella_Object.substituteOnce(statement, laststatement, Stella.KWD_PLACE_WHERE_VRLET_WAS);
      return (Cons.walkAConsTree(vrexpression, MV_returnarray));
    }
  }

  public static Cons walkAConsTree(Cons tree, Object [] MV_returnarray) {
    { Stella_Object otree = null;
      StandardObject otype = null;

      { Object [] caller_MV_returnarray = new Object[1];

        otree = Stella_Object.walkATree(tree, caller_MV_returnarray);
        otype = ((StandardObject)(caller_MV_returnarray[0]));
      }
      { Cons _return_temp = ((Cons)(otree));

        MV_returnarray[0] = otype;
        return (_return_temp);
      }
    }
  }

  public static Cons setTargetLanguageType(Cons systree, Surrogate type, Object [] MV_returnarray) {
    if (systree.length() == 4) {
      systree.fourthSetter(type);
    }
    else {
      systree.rest.rest.rest = Cons.consList(Cons.cons(type, Stella.NIL));
    }
    { Cons _return_temp = systree;

      MV_returnarray[0] = ((StandardObject)(systree.rest.rest.value));
      return (_return_temp);
    }
  }

  public static Cons eliminateVrletStatement(Cons tree) {
    tree.firstSetter(Stella.SYM_STELLA_LET);
    return (((Cons)(Stella_Object.walkATree(tree, new Object[1]))));
  }

  public static Cons walkListOfStatements(Cons trees) {
    { Cons otrees = Stella.NIL;

      { Stella_Object otree = null;
        Cons iter000 = Cons.walkListOfTrees(trees);
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          otree = iter000.value;
          if (Stella_Object.consP(otree)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(otree, Stella.NIL);
                if (otrees == Stella.NIL) {
                  otrees = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(otrees, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(otree, Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      return (otrees);
    }
  }

  public static Cons walkListOfTrees(Cons trees) {
    { Cons cursor = trees;

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.walkStatement(cursor.value, false);
        cursor = cursor.rest;
      }
      return (trees);
    }
  }

  public static Stella_Object optimizeProgn(Cons prognTree) {
    switch (prognTree.rest.length()) {
      case 0: 
        return (Stella.NIL);
      case 1: 
        { Stella_Object tree = prognTree.rest.value;

          prognTree.secondSetter(null);
          return (tree);
        }
      default:
        return (prognTree);
    }
  }

  public static Stella_Object prognify(Cons trees) {
    switch (trees.length()) {
      case 0: 
        return (Stella.NIL);
      case 1: 
        { Stella_Object tree = trees.value;

          trees.firstSetter(null);
          return (tree);
        }
      default:
        return (Cons.cons(Stella.SYM_STELLA_PROGN, trees.concatenate(Stella.NIL, Stella.NIL)));
    }
  }

  public static boolean badArgumentCountP(Cons tree, int arity) {
    return (Cons.badArgumentRangeP(tree, arity, arity));
  }

  public static boolean badArgumentRangeP(Cons tree, int minarity, int maxarity) {
    { int argnum = tree.length() - 1;

      if (argnum < minarity) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Missing arguments in the expression: ");
                Stella.STANDARD_ERROR.nativeStream.println(" `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (true);
      }
      else if ((maxarity != Stella.NULL_INTEGER) &&
          (argnum > maxarity)) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Too many arguments in the expression: ");
                Stella.STANDARD_ERROR.nativeStream.println(" `" + Stella_Object.deUglifyParseTree(tree) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (true);
      }
      else {
        return (false);
      }
    }
  }

  public static void breakProgramEvaluatorWrapper(Cons arguments) {
    Stella.breakProgram(((StringWrapper)(arguments.value)).wrapperValue);
  }

  public static void setCallLogBreakPointEvaluatorWrapper(Cons arguments) {
    Stella.setCallLogBreakPoint(((IntegerWrapper)(arguments.value)).wrapperValue);
  }

  public static void startFunctionCallLoggingEvaluatorWrapper(Cons arguments) {
    Stella.startFunctionCallLogging(((StringWrapper)(arguments.value)).wrapperValue);
  }

  public static TranslationUnit helpWalkAuxiliaryTree(Cons tree, boolean finalizeP) {
    if (!(Stella.getQuotedTree("((DEFCLASS DEFMETHOD DEFUN DEFMACRO DEFGLOBAL DEFSPECIAL DEFCONSTANT STARTUP-TIME-PROGN VERBATIM) \"/STELLA\")", "/STELLA").memberP(tree.value))) {
      { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

        {
          stream000.nativeStream.println("OOPS, illegal auxiliary statement:");
          stream000.nativeStream.print("   `" + tree + "'");
        }
;
        throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
      }
    }
    Cons.walkTopLevelTree(tree, false);
    if (finalizeP) {
      Stella.finalizeClassesAndSlots();
    }
    { TranslationUnit unit = ((TranslationUnit)(((List)(Stella.$TRANSLATIONUNITS$.get())).pop()));

      unit.auxiliaryP = true;
      TranslationUnit.walkPhaseOneUnit(unit);
      return (unit);
    }
  }

  public static void walkAuxiliaryTree(Cons tree) {
    Cons.helpWalkAuxiliaryTree(tree, true);
  }

  public static void walkTopLevelTree(Cons tree, boolean createannotationP) {
    { Object old$Currenttranslationunit$000 = Stella.$CURRENTTRANSLATIONUNIT$.get();

      try {
        Native.setSpecial(Stella.$CURRENTTRANSLATIONUNIT$, null);
        { String annotation = null;

          if (createannotationP) {
            annotation = Cons.createAnnotation(tree);
            if (((Integer)(Stella.$TRANSLATIONVERBOSITYLEVEL$.get())).intValue() >= 2) {
              Stella.STANDARD_OUTPUT.nativeStream.println("Defining `" + annotation + "'");
            }
          }
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

            if (testValue000 == Stella.SYM_STELLA_DEFCLASS) {
              Cons.walkDefclassTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_DEFSLOT) {
              Cons.walkDefslotTree(tree);
            }
            else if ((testValue000 == Stella.SYM_STELLA_DEFMETHOD) ||
                ((testValue000 == Stella.SYM_STELLA_DEFUN) ||
                 (testValue000 == Stella.SYM_STELLA_DEFOPERATOR))) {
              if (tree.value == Stella.SYM_STELLA_DEFOPERATOR) {
                tree.firstSetter(Stella.SYM_STELLA_DEFMETHOD);
              }
              Cons.walkDefmethodTree(tree);
            }
            else if ((testValue000 == Stella.SYM_STELLA_DEFGLOBAL) ||
                ((testValue000 == Stella.SYM_STELLA_DEFSPECIAL) ||
                 (testValue000 == Stella.SYM_STELLA_DEFCONSTANT))) {
              Cons.walkDefglobalTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_DEFTYPE) {
              Cons.walkDeftypeTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_DEFMODULE) {
              Cons.walkDefmoduleTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_DEFMACRO) {
              Cons.walkDefmacroTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_STARTUP_TIME_PROGN) {
              Cons.walkStartupTimePrognTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_VERBATIM) {
              Cons.walkVerbatimDefinitionTree(tree);
            }
            else if (testValue000 == Stella.SYM_STELLA_PROGN) {
              { Stella_Object form = null;
                Cons iter000 = tree.rest;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  form = iter000.value;
                  Cons.walkTopLevelTree(((Cons)(form)), createannotationP);
                }
              }
              return;
            }
            else {
              if (Symbol.lookupMacro(((Symbol)(tree.value))) != null) {
                { Stella_Object expansion = Cons.expandMacro(tree);

                  if (expansion != null) {
                    Cons.walkTopLevelTree(((Cons)(expansion)), createannotationP);
                  }
                }
              }
              else {
                if (!(Stella.incrementalTranslationP() ||
                    (Symbol.lookupCommand(((Symbol)(tree.value))) != null))) {
                  { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                    try {
                      Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                      Stella.signalTranslationWarning();
                      if (!(Stella.suppressWarningsP())) {
                        Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                        {
                          Stella.STANDARD_WARNING.nativeStream.println();
                          Stella.STANDARD_WARNING.nativeStream.println(" Illegal top-level statement:");
                          Stella.STANDARD_WARNING.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tree) + "'");
                          Stella.STANDARD_WARNING.nativeStream.println(" Wrapping it into a 'startup-time-progn'.");
                        }
;
                      }

                    } finally {
                      Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                    }
                  }
                }
                tree = Cons.list$(Cons.cons(Stella.SYM_STELLA_STARTUP_TIME_PROGN, Cons.cons(tree, Cons.cons(Stella.NIL, Stella.NIL))));
                Cons.walkTopLevelTree(tree, false);
              }
              return;
            }
          }
          if (((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())) != null) {
            ((List)(Stella.$TRANSLATIONUNITS$.get())).push(((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())));
            ((TranslationUnit)(Stella.$CURRENTTRANSLATIONUNIT$.get())).annotation = annotation;
          }
        }

      } finally {
        Stella.$CURRENTTRANSLATIONUNIT$.set(old$Currenttranslationunit$000);
      }
    }
  }

  public static String createAnnotation(Cons topLevelTree) {
    return ("(" + ((Symbol)(topLevelTree.value)).symbolName + " " + Native.stringify(topLevelTree.rest.value) + " ...)");
  }

  public static boolean declarationTreeP(Cons tree) {
    { Stella_Object operator = tree.value;

      if (Symbol.declarationOperatorP(((Symbol)(operator)))) {
        return (true);
      }
      if (operator == Stella.SYM_STELLA_PROGN) {
        { boolean foundP000 = false;

          { Stella_Object subtree = null;
            Cons iter000 = tree.rest;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              subtree = iter000.value;
              if (Stella_Object.consP(subtree) &&
                  Cons.declarationTreeP(((Cons)(subtree)))) {
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
      if (Symbol.lookupMacro(((Symbol)(operator))) != null) {
        { Stella_Object expansion = Cons.expandMacro(Cons.copyConsList(tree));

          if (expansion != null) {
            if (Stella_Object.safePrimaryType(expansion) == Stella.SGT_STELLA_CONS) {
              { Cons expansion000 = ((Cons)(expansion));

                tree.value = expansion000.value;
                tree.rest = expansion000.rest;
                return (Cons.declarationTreeP(tree));
              }
            }
            else {
              return (false);
            }
          }
          else {
            tree.value = Stella.SYM_STELLA_PROGN;
            tree.rest = Stella.NIL;
            return (false);
          }
        }
      }
      return (false);
    }
  }

  public static String nameQuotedTree(Cons tree) {
    { Cons nametree = Cons.cons(tree, Cons.cons(StringWrapper.wrapString(((Module)(Stella.$MODULE$.get())).moduleFullName), Stella.NIL));
      String name = Native.stringify(nametree);

      return (name);
    }
  }

  public static List dropTraceEvaluatorWrapper(Cons arguments) {
    return (Stella.dropTrace(arguments));
  }

  public static List addTraceEvaluatorWrapper(Cons arguments) {
    return (Stella.addTrace(arguments));
  }

  public static void unsetStellaFeatureEvaluatorWrapper(Cons arguments) {
    Stella.unsetStellaFeature(arguments);
  }

  public static void setStellaFeatureEvaluatorWrapper(Cons arguments) {
    Stella.setStellaFeature(arguments);
  }

  public static Cons walkSomeTree(Cons tree, Object [] MV_returnarray) {
    { Symbol valuevar = Stella.localGensym("VALUE");
      Stella_Object iterationvar = tree.rest.value;
      Cons otree = null;

      { Stella_Object sequenceref = null;
        StandardObject sequencetype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          sequenceref = Stella_Object.walkATree(tree.fourth(), caller_MV_returnarray);
          sequencetype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        tree.fourthSetter(sequenceref);
        otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(valuevar, Cons.cons(StandardObject.extractParameterType(sequencetype, Stella.SYM_STELLA_ANY_VALUE, new Object[1]), Cons.cons(Stella.SYM_STELLA_NULL, Stella.NIL))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_FOREACH, tree.rest.concatenate(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(valuevar, Cons.cons(Cons.cons(iterationvar, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)), Cons.cons(valuevar, Cons.cons(Stella.NIL, Stella.NIL))))));
        return (Cons.walkAConsTree(otree, MV_returnarray));
      }
    }
  }

  public static Cons walkForallTree(Cons tree, Object [] MV_returnarray) {
    { Symbol alwaysP = Stella.localGensym("ALWAYS?");
      Cons iteratorsandwhere = Stella.NIL;
      Stella_Object alwaystest = Stella.NIL;
      Cons precursor = Stella.NIL;
      Cons cursor = tree;

      loop000 : while (!(cursor == Stella.NIL)) {
        if (cursor.value == Stella.SYM_STELLA_ALWAYS) {
          alwaystest = cursor.rest.value;
          precursor.rest = Stella.NIL;
          break loop000;
        }
        precursor = cursor;
        cursor = cursor.rest;
      }
      iteratorsandwhere = tree.rest;
      { Cons _return_temp = ((Cons)(Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(alwaysP, Cons.cons(Stella.SYM_STELLA_TRUE, Stella.NIL)), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_FOREACH, iteratorsandwhere.concatenate(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NOT, Cons.cons(alwaystest, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(alwaysP, Cons.cons(Cons.cons(Stella.SYM_STELLA_FALSE, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Cons.cons(alwaysP, Cons.cons(Stella.NIL, Stella.NIL))))))));

        MV_returnarray[0] = Stella.SGT_STELLA_BOOLEAN;
        return (_return_temp);
      }
    }
  }

  public static Cons walkExistsTree(Cons tree, Object [] MV_returnarray) {
    { Symbol foundP = Stella.localGensym("FOUND?");
      Cons otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(foundP, Cons.cons(Stella.SYM_STELLA_FALSE, Stella.NIL)), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_FOREACH, tree.rest.concatenate(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(foundP, Cons.cons(Cons.cons(Stella.SYM_STELLA_TRUE, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.cons(Stella.SYM_STELLA_BREAK, Stella.NIL), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)), Cons.cons(foundP, Cons.cons(Stella.NIL, Stella.NIL))))));

      return (Cons.walkAConsTree(otree, MV_returnarray));
    }
  }

  public static Cons walkPrefixForeachTree(Cons tree, Object [] MV_returnarray) {
    { Cons tail = null;
      Cons iteratorclauses = null;
      Cons valueclauses = null;
      Cons bumpclauses = null;
      Stella_Object continuationtest = null;
      Stella_Object wheretest = null;
      Cons doactions = Stella.NIL;

      { Object [] caller_MV_returnarray = new Object[3];

        iteratorclauses = Cons.walkCursorsTree(((Cons)(tree.rest.value)), false, caller_MV_returnarray);
        valueclauses = ((Cons)(caller_MV_returnarray[0]));
        bumpclauses = ((Cons)(caller_MV_returnarray[1]));
        continuationtest = ((Stella_Object)(caller_MV_returnarray[2]));
      }
      tail = ((Cons)(tree.rest.rest));
      if (((Cons)(tail.value)).value == Stella.SYM_STELLA_WHERE) {
        wheretest = ((Cons)(tail.value)).rest.value;
        tail = tail.rest;
      }
      if (((Cons)(tail.value)).value == Stella.SYM_STELLA_DO) {
        doactions = ((Cons)(tail.value)).rest;
        tail = tail.rest;
      }
      if (!(tail == Stella.NIL)) {
        { Object [] caller_MV_returnarray = new Object[1];

          iteratorclauses = Cons.walkPrefixCollectIntoTree(((Cons)(tail.value)), iteratorclauses, doactions, caller_MV_returnarray);
          doactions = ((Cons)(caller_MV_returnarray[0]));
        }
      }
      { Cons _return_temp = Cons.list$(Cons.cons(Stella.SYM_STELLA_SYS_FOREACH, Cons.cons(iteratorclauses, Cons.cons(Cons.cons(valueclauses, Cons.cons(bumpclauses, Cons.cons(continuationtest, Cons.walkPrefixForeachBody(iteratorclauses, wheretest, doactions).concatenate(Stella.NIL, Stella.NIL)))), Stella.NIL))));

        MV_returnarray[0] = Stella.SGT_STELLA_VOID;
        return (_return_temp);
      }
    }
  }

  public static Cons walkPrefixForeachBody(Cons iteratorclauses, Stella_Object wheretest, Cons doactions) {
    { Cons otree = null;

      { Cons c = null;
        Cons iter000 = ((Cons)(iteratorclauses));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          c = ((Cons)(iter000.value));
          Symbol.pushVariableBinding(((Symbol)(c.value)), ((StandardObject)(c.rest.value)));
          c.firstSetter(Symbol.trueVariableName(((Symbol)(c.value))));
        }
      }
      otree = Cons.walkListOfTrees(Stella_Object.wrapWhereTest(wheretest, doactions));
      { Stella_Object c = null;
        Cons iter001 = iteratorclauses;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
          c = iter001.value;
          c = c;
          Stella.popVariableBinding();
        }
      }
      return (otree);
    }
  }

  public static Cons walkPrefixCollectIntoTree(Cons collectintotree, Cons iterators, Cons docode, Object [] MV_returnarray) {
    { Stella_Object collecttree = collectintotree.rest.value;
      Stella_Object intotree = collectintotree.rest.rest.value;
      Symbol collectvariable = Stella.localGensym("COLLECT");
      Cons collectintobindings = Cons.cons(Cons.cons(collectvariable, Cons.list$(Cons.cons(Stella.SGT_STELLA_CONS, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);
      Cons collectcode = null;
      Symbol intovariable = null;
      StandardObject intovariabletype = null;

      if (Stella_Object.symbolP(intotree)) {
        {
          intovariable = ((Symbol)(intotree));
          collectcode = Symbol.yieldCollectCode(collectvariable, intovariable, collecttree);
        }
      }
      else {
        {
          { Cons d = null;
            Cons iter000 = iterators;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              d = ((Cons)(iter000.value));
              Symbol.pushVariableBinding(((Symbol)(d.value)), ((StandardObject)(d.rest.value)));
            }
          }
          { Object [] caller_MV_returnarray = new Object[1];

            intotree = Stella_Object.walkExpressionTree(intotree, null, Stella.SYM_STELLA_FOREACH, false, caller_MV_returnarray);
            intovariabletype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          { Cons d = null;
            Cons iter001 = iterators;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              d = ((Cons)(iter001.value));
              d = d;
              Stella.popVariableBinding();
            }
          }
          intovariable = Stella.localGensym("INTO");
          collectintobindings = Cons.cons(Cons.consList(Cons.cons(intovariable, Cons.cons(intovariabletype, Cons.cons(intotree, Stella.NIL)))), collectintobindings);
          Symbol.pushVariableBinding(intovariable, intovariabletype);
          collectcode = Symbol.yieldCollectCode(collectvariable, intovariable, collecttree);
          Stella.popVariableBinding();
        }
      }
      { Cons _return_temp = iterators.concatenate(collectintobindings, Stella.NIL);

        MV_returnarray[0] = docode.concatenate(collectcode, Stella.NIL);
        return (_return_temp);
      }
    }
  }

  public static Cons walkCursorsTree(Cons cursorstree, boolean dontoptimizeP, Object [] MV_returnarray) {
    { Cons iteratorclauses = null;
      Cons valueclauses = null;
      Cons bumpclauses = null;
      Stella_Object continuationtest = null;

      { Object [] caller_MV_returnarray = new Object[3];

        iteratorclauses = Cons.collectCursorClauses(cursorstree, dontoptimizeP, caller_MV_returnarray);
        valueclauses = ((Cons)(caller_MV_returnarray[0]));
        bumpclauses = ((Cons)(caller_MV_returnarray[1]));
        continuationtest = ((Stella_Object)(caller_MV_returnarray[2]));
      }
      { Cons clause = null;
        Cons iter000 = ((Cons)(iteratorclauses));

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          clause = ((Cons)(iter000.value));
          { Stella_Object iteratortree = null;
            StandardObject iteratortype = null;

            { Object [] caller_MV_returnarray = new Object[1];

              iteratortree = Stella_Object.walkExpressionTree(clause.rest.rest.value, ((StandardObject)(clause.rest.value)), Stella.SYM_STELLA_FOREACH, false, caller_MV_returnarray);
              iteratortype = ((StandardObject)(caller_MV_returnarray[0]));
            }
            clause.secondSetter(iteratortype);
            clause.thirdSetter(Stella_Object.coerceATree(iteratortree, iteratortype, iteratortype, new Object[1]));
          }
          Symbol.pushVariableBinding(((Symbol)(clause.value)), ((StandardObject)(clause.rest.value)));
        }
      }
      valueclauses = Cons.walkListOfTrees(valueclauses);
      bumpclauses = Cons.walkListOfTrees(bumpclauses);
      continuationtest = Stella_Object.walkWithoutTypeTree(continuationtest);
      { int i = Stella.NULL_INTEGER;
        int iter001 = 1;
        int upperBound000 = iteratorclauses.length();

        for (;iter001 <= upperBound000; iter001 = iter001 + 1) {
          i = iter001;
          i = i;
          Stella.popVariableBinding();
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

  public static Cons collectCursorClauses(Cons cursorstree, boolean dontoptimizeP, Object [] MV_returnarray) {
    { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(cursorstree.value));

      if (testValue000 == Stella.SYM_STELLA_IN) {
        return (Cons.yieldInCursorClauses(cursorstree, dontoptimizeP, MV_returnarray));
      }
      else if (testValue000 == Stella.SYM_STELLA_ON) {
        return (Cons.yieldOnCursorClauses(cursorstree, MV_returnarray));
      }
      else if (testValue000 == Stella.SYM_STELLA_AS) {
        { Cons alliteratorclauses = Stella.NIL;
          Cons allvalueclauses = Stella.NIL;
          Cons allbumpclauses = Stella.NIL;
          Cons continuationtests = Stella.NIL;

          { Stella_Object clause = null;
            Cons iter000 = cursorstree.rest;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              clause = iter000.value;
              { Cons iteratorclauses = null;
                Cons valueclauses = null;
                Cons bumpclauses = null;
                Stella_Object continuationtest = null;

                { Object [] caller_MV_returnarray = new Object[3];

                  iteratorclauses = Cons.collectCursorClauses(((Cons)(clause)), dontoptimizeP, caller_MV_returnarray);
                  valueclauses = ((Cons)(caller_MV_returnarray[0]));
                  bumpclauses = ((Cons)(caller_MV_returnarray[1]));
                  continuationtest = ((Stella_Object)(caller_MV_returnarray[2]));
                }
                alliteratorclauses = alliteratorclauses.concatenate(iteratorclauses, Stella.NIL);
                allvalueclauses = allvalueclauses.concatenate(valueclauses, Stella.NIL);
                allbumpclauses = allbumpclauses.concatenate(bumpclauses, Stella.NIL);
                continuationtests = Cons.cons(continuationtest, continuationtests);
              }
            }
          }
          { Cons _return_temp = alliteratorclauses;

            MV_returnarray[0] = allvalueclauses;
            MV_returnarray[1] = allbumpclauses;
            MV_returnarray[2] = ((continuationtests.length() == 1) ? continuationtests.value : Cons.cons(Stella.SYM_STELLA_AND, continuationtests.reverse().remove(Stella.SYM_STELLA_TRUE).concatenate(Stella.NIL, Stella.NIL)));
            return (_return_temp);
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
  }

  public static Cons yieldOnCursorClauses(Cons ontree, Object [] MV_returnarray) {
    { Stella_Object iteratorvar = ontree.rest.value;

      if (!Stella_Object.symbolP(iteratorvar)) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal ON clause with non-atomic variable: `" + Stella_Object.deUglifyParseTree(ontree) + "'.");
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
      { Stella_Object collectiontree = null;
        StandardObject collectiontype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          collectiontree = Stella_Object.walkCollectionTree(ontree.rest.rest.value, true, caller_MV_returnarray);
          collectiontype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        if (StandardObject.subTypeSpecOfP(collectiontype, Stella.SGT_STELLA_ARGUMENT_LIST)) {
          { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" ON iteration not supported for ARGUMENT-LISTs: `" + Stella_Object.deUglifyParseTree(ontree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
          { Cons _return_temp = Stella.NIL;

            MV_returnarray[0] = Stella.NIL;
            MV_returnarray[1] = Stella.NIL;
            MV_returnarray[2] = Stella.SYM_STELLA_FALSE;
            return (_return_temp);
          }
        }
        ontree.thirdSetter(null);
        if (!Surrogate.safeSubtypeOfP(StandardObject.typeSpecToBaseType(collectiontype), Stella.SGT_STELLA_ABSTRACT_ITERATOR)) {
          collectiontree = Cons.list$(Cons.cons(Stella.SYM_STELLA_ALLOCATE_ITERATOR, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL))));
        }
        { Cons _return_temp = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_ABSTRACT_ITERATOR, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL);

          MV_returnarray[0] = Stella.NIL;
          MV_returnarray[1] = Stella.NIL;
          MV_returnarray[2] = Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXTp, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL))));
          return (_return_temp);
        }
      }
    }
  }

  public static Cons yieldOptimizedInCursorClausesForIntegerInterval(Cons collectiontree, StandardObject collectiontype, Symbol keyvar, Symbol valuevar, Object [] MV_returnarray) {
    {
      collectiontype = collectiontype;
      keyvar = keyvar;
    }
    { Stella_Object upperbound = collectiontree.rest.rest.value;
      boolean unboundedP = (upperbound == Stella.SYM_STELLA_NULL) ||
          (upperbound == Stella.SYM_STELLA_NULL_INTEGER);
      Symbol iteratorvar = valuevar;
      Symbol upperboundvar = null;
      Symbol testoperator = Stella.SYM_STELLA_le;

      if (!(unboundedP)) {
        if (Stella_Object.consP(upperbound)) {
          { Cons ub = ((Cons)(upperbound));

            if ((ub.value == Stella.SYM_STELLA_1_) ||
                ((ub.value == Stella.SYM_STELLA__) &&
                 (Stella_Object.eqlP(ub.rest.value, Stella.ONE_WRAPPER) &&
                  (ub.rest.rest.rest == Stella.NIL)))) {
              upperbound = ub.rest.value;
              testoperator = Stella.SYM_STELLA_l;
            }
          }
        }
        upperbound = Stella_Object.sysTree(Stella_Object.walkExpressionTree(upperbound, Stella.SGT_STELLA_INTEGER, Stella.SYM_STELLA_FOREACH, false, new Object[1]), Stella.SGT_STELLA_INTEGER, new Object[1]);
        if (!(Stella_Object.atomicExpressionP(upperbound))) {
          upperboundvar = Stella.localGensym("UPPER-BOUND");
        }
      }
      { Cons _return_temp = Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(collectiontree.rest.value, Cons.cons(Stella.NIL, Stella.NIL))))), (((upperboundvar != null) ? Cons.cons(Cons.cons(upperboundvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(upperbound, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL));

        MV_returnarray[0] = Stella.NIL;
        MV_returnarray[1] = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
        MV_returnarray[2] = (unboundedP ? ((StandardObject)(Stella.SYM_STELLA_TRUE)) : ((StandardObject)(Cons.cons(testoperator, Cons.cons(iteratorvar, Cons.cons(((upperboundvar != null) ? upperboundvar : upperbound), Stella.NIL))))));
        return (_return_temp);
      }
    }
  }

  public static Cons yieldInCursorClausesForIntegerInterval(Cons collectiontree, StandardObject collectiontype, Symbol keyvar, Symbol valuevar, Object [] MV_returnarray) {
    if (keyvar != null) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal key variable specified for INTEGER-INTERVAL.");
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
    if (Stella.$AGGRESSIVELY_OPTIMIZE_INTERVAL_FOREACHp$) {
      return (Cons.yieldOptimizedInCursorClausesForIntegerInterval(collectiontree, collectiontype, keyvar, valuevar, MV_returnarray));
    }
    { Stella_Object upperbound = collectiontree.rest.rest.value;
      boolean knownunboundedP = (upperbound == Stella.SYM_STELLA_NULL) ||
          (upperbound == Stella.SYM_STELLA_NULL_INTEGER);
      boolean knownboundedP = (!knownunboundedP) &&
          (Stella_Object.isaP(Stella_Object.walkExpressionTree(Stella_Object.copyConsTree(upperbound), Stella.SGT_STELLA_INTEGER, Stella.SYM_STELLA_FOREACH, false, new Object[1]), Stella.SGT_STELLA_NUMBER_WRAPPER) ||
           (Stella_Object.consP(upperbound) &&
            Stella.getQuotedTree("((+ - * / 1+ 1- ++ -- LENGTH) \"/STELLA\")", "/STELLA").memberP(((Cons)(upperbound)).value)));
      Symbol iteratorvar = Stella.localGensym("ITER");
      Symbol upperboundvar = (knownunboundedP ? ((Symbol)(null)) : Stella.localGensym("UPPER-BOUND"));
      Symbol unboundedvar = ((knownunboundedP ||
          knownboundedP) ? ((Symbol)(null)) : Stella.localGensym("UNBOUNDED?"));

      { Cons _return_temp = Cons.list$(Cons.cons(Cons.cons(valuevar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(iteratorvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(collectiontree.rest.value, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(((knownunboundedP ? Stella.NIL : Cons.cons(Cons.cons(upperboundvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_INTEGER, Cons.cons(upperbound, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))).concatenate((((knownunboundedP ||
            knownboundedP) ? Stella.NIL : Cons.cons(Cons.cons(unboundedvar, Cons.list$(Cons.cons(Stella.SGT_STELLA_BOOLEAN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NULLp, Cons.cons(upperboundvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL))).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL))));

        MV_returnarray[0] = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(valuevar, Cons.cons(Cons.cons(iteratorvar, Stella.NIL), Stella.NIL)))), Stella.NIL);
        MV_returnarray[1] = Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ii, Cons.cons(iteratorvar, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
        MV_returnarray[2] = (knownunboundedP ? ((StandardObject)(Stella.SYM_STELLA_TRUE)) : ((StandardObject)((knownboundedP ? Cons.list$(Cons.cons(Stella.SYM_STELLA_le, Cons.cons(iteratorvar, Cons.cons(Cons.cons(upperboundvar, Stella.NIL), Stella.NIL)))) : Cons.list$(Cons.cons(Stella.SYM_STELLA_OR, Cons.cons(unboundedvar, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_le, Cons.cons(iteratorvar, Cons.cons(Cons.cons(upperboundvar, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL))))))));
        return (_return_temp);
      }
    }
  }

  public static Cons yieldInCursorClauses(Cons intree, boolean dontoptimizeP, Object [] MV_returnarray) {
    { Stella_Object vartree = intree.rest.value;
      Symbol keyvar = null;
      Symbol valuevar = null;
      Surrogate collectionbasetype = null;

      { Stella_Object collectiontree = null;
        StandardObject collectiontype = null;

        { Object [] caller_MV_returnarray = new Object[1];

          collectiontree = Stella_Object.walkCollectionTree(intree.rest.rest.value, dontoptimizeP, caller_MV_returnarray);
          collectiontype = ((StandardObject)(caller_MV_returnarray[0]));
        }
        intree.thirdSetter(null);
        collectionbasetype = StandardObject.typeSpecToBaseType(collectiontype);
        if (dontoptimizeP &&
            (!Surrogate.safeSubtypeOfP(collectionbasetype, Stella.SGT_STELLA_ABSTRACT_ITERATOR))) {
          { Object [] caller_MV_returnarray = new Object[1];

            collectiontree = Stella_Object.walkCollectionTree(Cons.list$(Cons.cons(Stella.SYM_STELLA_ALLOCATE_ITERATOR, Cons.cons(collectiontree, Cons.cons(Stella.NIL, Stella.NIL)))), true, caller_MV_returnarray);
            collectiontype = ((StandardObject)(caller_MV_returnarray[0]));
          }
          collectionbasetype = StandardObject.typeSpecToBaseType(collectiontype);
        }
        if (Stella_Object.safePrimaryType(vartree) == Stella.SGT_STELLA_CONS) {
          { Cons vartree000 = ((Cons)(vartree));

            if (!(vartree000.length() == 2)) {
              { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal number of variables in IN clause: `" + Stella_Object.deUglifyParseTree(intree) + "'.");
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
            keyvar = ((Symbol)(vartree000.value));
            valuevar = ((Symbol)(vartree000.rest.value));
          }
        }
        else {
          valuevar = ((Symbol)(vartree));
        }
        if (collectionbasetype == Stella.SGT_STELLA_INTEGER_INTERVAL) {
          return (Cons.yieldInCursorClausesForIntegerInterval(((Cons)(collectiontree)), collectiontype, keyvar, valuevar, MV_returnarray));
        }
        else if (collectionbasetype == Stella.SGT_STELLA_ARGUMENT_LIST) {
          return (Stella_Object.yieldInCursorClausesForArgumentList(collectiontree, collectiontype, keyvar, valuevar, MV_returnarray));
        }
        else {
          if (Surrogate.useVectorStyleIterationP(collectionbasetype)) {
            return (Stella_Object.yieldInCursorClausesForVector(collectiontree, collectiontype, keyvar, valuevar, MV_returnarray));
          }
          else {
            return (Stella_Object.yieldInCursorClausesForGeneralCollection(collectiontree, collectiontype, keyvar, valuevar, MV_returnarray));
          }
        }
      }
    }
  }

  public static Cons walkForeachTree(Cons tree, Object [] MV_returnarray) {
    { Object old$Nofspecialsatloopentry$000 = Stella.$NOFSPECIALSATLOOPENTRY$.get();

      try {
        Native.setIntSpecial(Stella.$NOFSPECIALSATLOOPENTRY$, ((KeyValueList)(Stella.$SPECIALVARIABLESTACK$.get())).length());
        { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(tree.value));

          if (testValue000 == Stella.SYM_STELLA_FOREACH) {
            return (Cons.walkPrefixForeachTree(Cons.foreachToPrefixForeachTree(tree), MV_returnarray));
          }
          else if (testValue000 == Stella.SYM_STELLA_EXISTS) {
            return (Cons.walkExistsTree(tree, MV_returnarray));
          }
          else if (testValue000 == Stella.SYM_STELLA_FORALL) {
            return (Cons.walkForallTree(tree, MV_returnarray));
          }
          else if (testValue000 == Stella.SYM_STELLA_SOME) {
            return (Cons.walkSomeTree(tree, MV_returnarray));
          }
          else {
            { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

              stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
            }
          }
        }

      } finally {
        Stella.$NOFSPECIALSATLOOPENTRY$.set(old$Nofspecialsatloopentry$000);
      }
    }
  }

  public static Cons foreachToPrefixForeachTree(Cons foreachtree) {
    { Cons generatorsclause = null;
      Stella_Object filterclause = null;
      Cons doclause = null;
      Stella_Object collectclause = null;
      Stella_Object intoclause = null;
      Cons residue = ((Cons)(foreachtree.rest));
      Cons otree = null;

      { Object [] caller_MV_returnarray = new Object[1];

        generatorsclause = Cons.extractGeneratorsClause(residue, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      if (generatorsclause == null) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PREFIX_FOREACH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Stella.SYM_STELLA_X, Cons.cons(Stella.SYM_STELLA_NIL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella_Object.walkDontCallMeTree(otree, Stella.SGT_STELLA_VOID, new Object[1]), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        filterclause = Symbol.extractOptionAndResidue(Stella.SYM_STELLA_WHERE, residue, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      if (filterclause != null) {
        filterclause = Cons.list$(Cons.cons(Stella.SYM_STELLA_WHERE, Cons.cons(filterclause, Cons.cons(Stella.NIL, Stella.NIL))));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        doclause = Cons.extractDoClause(residue, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        collectclause = Symbol.extractOptionAndResidue(Stella.SYM_STELLA_COLLECT, residue, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        intoclause = Symbol.extractOptionAndResidue(Stella.SYM_STELLA_INTO, residue, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      if ((collectclause != null) ||
          (intoclause != null)) {
        collectclause = Cons.list$(Cons.cons(Stella.SYM_STELLA_COLLECT_INTO, Cons.cons(collectclause, Cons.cons(Cons.cons(intoclause, Stella.NIL), Stella.NIL))));
      }
      otree = Cons.list$(Cons.cons(Stella.SYM_STELLA_PREFIX_FOREACH, Cons.cons(generatorsclause, Cons.cons((((filterclause != null) ? Cons.cons(filterclause, Stella.NIL) : Stella.NIL)).concatenate((((doclause != null) ? Cons.cons(doclause, Stella.NIL) : Stella.NIL)).concatenate((((collectclause != null) ? Cons.cons(collectclause, Stella.NIL) : Stella.NIL)).concatenate(Stella.NIL, Stella.NIL), Stella.NIL), Stella.NIL), Stella.NIL))));
      if (((collectclause != null) &&
          (intoclause == null)) ||
          ((intoclause != null) &&
           (collectclause == null))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Missing COLLECT or INTO clause in.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PREFIX_FOREACH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Stella.SYM_STELLA_X, Cons.cons(Stella.SYM_STELLA_NIL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella_Object.walkDontCallMeTree(otree, Stella.SGT_STELLA_VOID, new Object[1]), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      if (!(residue == Stella.NIL)) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Extra expressions at the end of foreach statement: `" + Stella_Object.deUglifyParseTree(residue) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PREFIX_FOREACH, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Stella.SYM_STELLA_X, Cons.cons(Stella.SYM_STELLA_NIL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Stella_Object.walkDontCallMeTree(otree, Stella.SGT_STELLA_VOID, new Object[1]), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      return (otree);
    }
  }

  public static Cons extractDoClause(Cons tail, Object [] MV_returnarray) {
    if (!(tail.value == Stella.SYM_STELLA_DO)) {
      { Cons _return_temp = null;

        MV_returnarray[0] = tail;
        return (_return_temp);
      }
    }
    { Cons doclause = tail;
      Cons lastdocons = null;

      tail = tail.rest;
      while ((!(tail == Stella.NIL)) &&
          (!(tail.value == Stella.SYM_STELLA_COLLECT))) {
        lastdocons = tail;
        tail = tail.rest;
      }
      if (lastdocons == null) {
        {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing arguments to DO separator.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
            }
          }
          doclause.rest = Cons.consList(Cons.cons(Stella_Object.walkDontCallMeTree(Stella.NIL, Stella.SGT_STELLA_VOID, new Object[1]), Stella.NIL));
        }
      }
      else {
        lastdocons.rest = Stella.NIL;
      }
      { Cons _return_temp = doclause;

        MV_returnarray[0] = tail;
        return (_return_temp);
      }
    }
  }

  public static Cons extractGeneratorsClause(Cons tail, Object [] MV_returnarray) {
    { Cons generatorterm = null;
      Cons residue = null;
      Cons generatorsclause = null;

      { Object [] caller_MV_returnarray = new Object[1];

        generatorterm = Cons.extractOneGeneratorTerm(tail, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      if (!(residue.value == Stella.SYM_STELLA_COMMA)) {
        { Cons _return_temp = generatorterm;

          MV_returnarray[0] = residue;
          return (_return_temp);
        }
      }
      generatorsclause = Cons.cons(generatorterm, Cons.cons(Stella.SYM_STELLA_COMMA, Stella.NIL));
      while (residue.value == Stella.SYM_STELLA_COMMA) {
        { Object [] caller_MV_returnarray = new Object[1];

          generatorterm = Cons.extractOneGeneratorTerm(residue.rest, caller_MV_returnarray);
          residue = ((Cons)(caller_MV_returnarray[0]));
        }
        generatorsclause = Cons.cons(generatorterm, generatorsclause);
      }
      { Cons _return_temp = generatorsclause.reverse();

        MV_returnarray[0] = residue;
        return (_return_temp);
      }
    }
  }

  public static Cons extractOneGeneratorTerm(Cons tail, Object [] MV_returnarray) {
    { Cons inclause = null;
      Cons residue = null;
      Cons parallelterms = null;

      { Object [] caller_MV_returnarray = new Object[1];

        inclause = Cons.extractOneInClause(tail, caller_MV_returnarray);
        residue = ((Cons)(caller_MV_returnarray[0]));
      }
      if (!(residue.value == Stella.SYM_STELLA_AS)) {
        { Cons _return_temp = inclause;

          MV_returnarray[0] = residue;
          return (_return_temp);
        }
      }
      parallelterms = Cons.cons(inclause, Cons.cons(Stella.SYM_STELLA_AS, Stella.NIL));
      while (residue.value == Stella.SYM_STELLA_AS) {
        residue = residue.rest;
        { Object [] caller_MV_returnarray = new Object[1];

          inclause = Cons.extractOneInClause(residue, caller_MV_returnarray);
          residue = ((Cons)(caller_MV_returnarray[0]));
        }
        parallelterms = Cons.cons(inclause, parallelterms);
      }
      { Cons _return_temp = parallelterms.reverse();

        MV_returnarray[0] = residue;
        return (_return_temp);
      }
    }
  }

  public static Cons extractOneInClause(Cons tail, Object [] MV_returnarray) {
    { Stella_Object variable = tail.value;
      Stella_Object operator = tail.rest.value;
      Cons clause = tail;

      if (!((Stella_Object.symbolP(variable) ||
          Stella_Object.consP(variable)) &&
          (Stella.getQuotedTree("((IN ON ISA) \"/STELLA\")", "/STELLA").memberP(operator) &&
           (tail.rest.rest.value != null)))) {
        { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal syntax where 'IN', 'ON', or 'ISA' clause expected:");
                Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(tail) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
          }
        }
        { Cons _return_temp = null;

          MV_returnarray[0] = Stella.NIL;
          return (_return_temp);
        }
      }
      clause.firstSetter(operator);
      clause.secondSetter(variable);
      tail = tail.rest.rest.rest;
      clause.rest.rest.rest = Stella.NIL;
      { Cons _return_temp = clause;

        MV_returnarray[0] = tail;
        return (_return_temp);
      }
    }
  }

  public static StorageSlot defineExternalSlotFromParseTree(Cons parsetree) {
    if (Cons.badArgumentRangeP(parsetree, 2, Stella.NULL_INTEGER)) {
      return (null);
    }
    if ((!Stella_Object.symbolP(parsetree.rest.value)) ||
        ((!Stella_Object.symbolP(parsetree.rest.rest.value)) ||
         (!(((parsetree.nthRest(3).length()) % 2) == 0)))) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal external slot definition: `" + Stella_Object.deUglifyParseTree(parsetree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (null);
    }
    { Symbol classname = ((Symbol)(parsetree.rest.value));
      Surrogate owner = Stella_Object.typify(classname);
      Stella_Class ownerclass = ((Stella_Class)(owner.surrogateValue));
      StorageSlot slot = null;
      Cons options = parsetree.nthRest(3);
      Module marker = Stella.$STELLA_MODULE$;
      boolean abstractP = false;

      if (ownerclass == null) {
        { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't define a slot on the non-existent class `" + Stella_Object.deUglifyParseTree(classname) + "'.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
          }
        }
        return (null);
      }
      while (!(options == Stella.NIL)) {
        { Stella_Object option = options.value;
          Stella_Object value = options.rest.value;

          if (Stella.$UNSUPPORTED_EXTERNAL_SLOT_OPTIONS$.memberP(option)) {
            if ((!(option == Stella.KWD_ALLOCATION)) ||
                (!(value == Stella.KWD_DYNAMIC))) {
              { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationWarning();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                    {
                      Stella.STANDARD_WARNING.nativeStream.println();
                      Stella.STANDARD_WARNING.nativeStream.println(" Skipping slot option `" + Stella_Object.deUglifyParseTree(option) + "' which is unsupported on external slots.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                }
              }
            }
            options.firstSetter(marker);
            if (value != null) {
              options.secondSetter(marker);
            }
          }
          if (((option == Stella.KWD_ABSTRACTp) &&
              (value == Stella.SYM_STELLA_TRUE)) ||
              (option == Stella.KWD_RENAMES)) {
            abstractP = true;
          }
        }
        options = options.rest.rest;
      }
      if ((!abstractP) &&
          (ownerclass.classFinalizedP &&
           (!Surrogate.subtypeOfP(owner, Stella.SGT_STELLA_DYNAMIC_SLOTS_MIXIN)))) {
        { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

          try {
            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
            Stella.signalTranslationError();
            if (!(Stella.suppressWarningsP())) {
              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
              {
                Stella.STANDARD_ERROR.nativeStream.println();
                Stella.STANDARD_ERROR.nativeStream.println(" Can't define a non-abstract external slot on class `" + Stella_Object.deUglifyParseTree(classname) + "',");
                Stella.STANDARD_ERROR.nativeStream.println(" since it does not inherit DYNAMIC-SLOTS-MIXIN.");
              }
;
            }

          } finally {
            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
          }
        }
        return (null);
      }
      parsetree = parsetree.remove(marker);
      if (!(abstractP)) {
        parsetree = parsetree.concatenate(Cons.list$(Cons.cons(Stella.KWD_ALLOCATION, Cons.cons(Stella.KWD_DYNAMIC, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL);
      }
      slot = Cons.defineStorageSlotFromParseTree(parsetree.rest.rest, owner);
      if (slot != null) {
        Slot.attachSlotToOwner(slot);
      }
      return (slot);
    }
  }

  public static String stringifyMethodSignature(Cons parsetree) {
    { Cons signature = Stella.NIL;
      String signaturestring = null;
      Cons optionstree = parsetree.nthRest(3);

      signature = Cons.cons(parsetree.value, signature);
      signature = Cons.cons(parsetree.rest.value, signature);
      signature = Cons.cons(parsetree.rest.rest.value, signature);
      while (Stella_Object.keywordP(optionstree.value)) {
        signature = Cons.cons(optionstree.value, signature);
        signature = Cons.cons(optionstree.rest.value, signature);
        optionstree = optionstree.rest.rest;
      }
      signaturestring = Native.stringify(signature.reverse());
      return (signaturestring);
    }
  }

  public static MethodSlot defineMethodFromParseTree(Cons parsetree) {
    if (Cons.badArgumentRangeP(parsetree, 2, Stella.NULL_INTEGER)) {
      return (null);
    }
    { MethodSlot method = null;
      boolean identicalmethodP = false;

      { Object [] caller_MV_returnarray = new Object[1];

        method = Cons.helpDefineMethodFromParseTree(parsetree, null, caller_MV_returnarray);
        identicalmethodP = ((boolean)(((BooleanWrapper)(caller_MV_returnarray[0])).wrapperValue));
      }
      if (!(identicalmethodP ||
          (method == null))) {
        if (((BooleanWrapper)(KeyValueList.dynamicSlotValue(method.dynamicSlots, Stella.SYM_STELLA_SLOT_AUXILIARYp, Stella.FALSE_WRAPPER))).wrapperValue) {
          method.slotExternalP = true;
        }
        else {
          MethodSlot.attachMethodSlotToOwner(method);
        }
      }
      return (method);
    }
  }

  public static MethodSlot helpDefineMethodFromParseTree(Cons inputtree, String stringifiedsource, Object [] MV_returnarray) {
    { Stella_Object nametree = null;
      Cons parameterstree = null;
      KeywordKeyValueList methodoptions = KeywordKeyValueList.newKeywordKeyValueList();
      Cons bodytree = null;
      Symbol name = null;
      Cons returntypestree = null;
      boolean functionP = inputtree.value == Stella.SYM_STELLA_DEFUN;
      MethodSlot oldmethod = null;
      String signaturestring = ((stringifiedsource == null) ? Cons.stringifyMethodSignature(inputtree) : stringifiedsource);

      { Object [] caller_MV_returnarray = new Object[2];

        nametree = Cons.destructureDefmethodTree(inputtree, methodoptions, caller_MV_returnarray);
        parameterstree = ((Cons)(caller_MV_returnarray[0]));
        bodytree = ((Cons)(caller_MV_returnarray[1]));
      }
      { Object [] caller_MV_returnarray = new Object[1];

        name = Stella_Object.destructureMethodNameTree(nametree, caller_MV_returnarray);
        returntypestree = ((Cons)(caller_MV_returnarray[0]));
      }
      if (name == null) {
        { MethodSlot _return_temp = null;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
          return (_return_temp);
        }
      }
      oldmethod = (functionP ? Symbol.getFunctionWithIdenticalSignature(name, signaturestring) : Symbol.getMethodWithIdenticalSignature(name, parameterstree, signaturestring));
      if (oldmethod != null) {
        { MethodSlot _return_temp = oldmethod;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(true);
          return (_return_temp);
        }
      }
      KeywordKeyValueList.inPlaceNormalizeMethodOptions(methodoptions, name);
      { MethodSlot method = Symbol.defineStellaMethodSlot(name, returntypestree, functionP, parameterstree, methodoptions);

        if (stringifiedsource == null) {
          stringifiedsource = (MethodSlot.stringifyMethodBodyP(method) ? Native.stringify(((Cons)(Stella.readSExpressionFromString(signaturestring))).concatenate(bodytree, Stella.NIL)) : signaturestring);
        }
        method.methodStringifiedSource = stringifiedsource;
        Slot.recordSlotHomeModule(method);
        { MethodSlot _return_temp = method;

          MV_returnarray[0] = BooleanWrapper.wrapBoolean(false);
          return (_return_temp);
        }
      }
    }
  }

  /** Return three parse trees representing the name,
   * parameters, and code body of the parse tree <code>methodTree</code>.  Fill
   * <code>optionsTable</code> with a dictionary of method options.
   * Storage note:  Options are treated specially because the other return
   * values are subtrees of <code>methodTree</code>, while <code>optionsTable</code> is a newly-created
   * cons tree.  Note also, the parameter and body trees are destructively
   * removed from <code>methodTree</code>.
   * @param methodTree
   * @param optionsTable
   * @param MV_returnarray
   * @return Stella_Object
   */
  public static Stella_Object destructureDefmethodTree(Cons methodTree, KeyValueList optionsTable, Object [] MV_returnarray) {
    { Stella_Object nametree = methodTree.rest.value;
      Stella_Object parameterstree = methodTree.rest.rest.value;

      if (!Stella_Object.consP(parameterstree)) {
        if (parameterstree == null) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing parameter list.");
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
                  Stella.STANDARD_ERROR.nativeStream.println(" Illegal parameter list: `" + Stella_Object.deUglifyParseTree(parameterstree) + "'.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
        }
        parameterstree = Stella.NIL;
      }
      Cons.extractOptions(methodTree, optionsTable);
      { Stella_Object _return_temp = nametree;

        MV_returnarray[0] = ((Cons)(parameterstree));
        MV_returnarray[1] = methodTree.nthRest(3);
        return (_return_temp);
      }
    }
  }

  public static Cons extractOptions(Cons tree, KeyValueList optionstable) {
    { Cons options = null;
      Cons tail = null;

      while ((!(tree.rest == Stella.NIL)) &&
          (!Stella_Object.keywordP(tree.rest.value))) {
        tree = tree.rest;
      }
      if ((tree.rest == Stella.NIL) ||
          (tree.rest.rest == Stella.NIL)) {
        return (Stella.NIL);
      }
      if (optionstable != null) {
        optionstable.insertAt(tree.rest.value, tree.rest.rest.value);
      }
      options = tree.rest;
      tail = tree.rest.rest;
      while ((!(tail.rest.rest == Stella.NIL)) &&
          Stella_Object.keywordP(tail.rest.value)) {
        if (optionstable != null) {
          optionstable.insertAt(tail.rest.value, tail.rest.rest.value);
        }
        tail = tail.rest.rest;
      }
      tree.rest = tail.rest;
      tail.rest = Stella.NIL;
      return (options);
    }
  }

  public static Stella_Class defineClassFromParseTree(Cons parsetree) {
    if (Cons.badArgumentRangeP(parsetree, 2, Stella.NULL_INTEGER)) {
      return (null);
    }
    if (!(Stella_Object.symbolP(parsetree.rest.value) &&
        Stella_Object.consP(parsetree.rest.rest.value))) {
      { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

        try {
          Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
          Stella.signalTranslationError();
          if (!(Stella.suppressWarningsP())) {
            Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
            {
              Stella.STANDARD_ERROR.nativeStream.println();
              Stella.STANDARD_ERROR.nativeStream.println(" Illegal class definition: `" + Stella_Object.deUglifyParseTree(parsetree) + "'.");
            }
;
          }

        } finally {
          Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
        }
      }
      return (null);
    }
    { Symbol classname = ((Symbol)(parsetree.rest.value));
      String stringifiedsource = Native.stringify(parsetree);
      Stella_Class oldclass = Stella.getIdenticalClass(classname.symbolName, stringifiedsource);

      if ((oldclass != null) &&
          (!Stella.$REDEFINE_IDENTICAL_CLASSESp$)) {
        return (oldclass);
      }
      return (Cons.helpDefineClassFromParseTree(parsetree, stringifiedsource));
    }
  }

  public static StorageSlot defineStorageSlotFromParseTree(Cons slotdef, Surrogate owner) {
    { Stella_Object name = slotdef.value.permanentify();
      Surrogate basetype = null;
      Cons typeexpression = Stella.NIL;
      PropertyList theoptions = PropertyList.newPropertyList();
      KeywordKeyValueList slotoptions = KeywordKeyValueList.newKeywordKeyValueList();
      Keyword key = null;
      StorageSlot slot = null;

      theoptions.thePlist = slotdef.rest;
      { Stella_Object thekey = null;
        Stella_Object thevalue = null;
        Cons iter000 = theoptions.thePlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
          thekey = iter000.value;
          thevalue = iter000.rest.value;
          key = ((Keyword)(thekey.permanentify()));
          if ((key == Stella.KWD_INITIALLY) ||
              (key == Stella.KWD_DEFAULT)) {
            slotoptions.insertAt(key, Stella_Object.permanentifyForm(thevalue));
          }
          else if (key == Stella.KWD_TYPE) {
            if (Stella_Object.safePrimaryType(thevalue) == Stella.SGT_STELLA_CONS) {
              { Cons thevalue000 = ((Cons)(thevalue));

                typeexpression = thevalue000;
                if (thevalue000.value == Stella.SYM_STELLA_LIKE) {
                  basetype = null;
                }
                else {
                  basetype = Stella_Object.typify(thevalue000.value);
                }
              }
            }
            else {
              basetype = Stella_Object.typify(thevalue);
              if (Surrogate.definedTypeP(basetype)) {
                { StandardObject realtype = thevalue.yieldTypeSpecifier();

                  basetype = StandardObject.typeSpecToBaseType(realtype);
                  if (!(Stella_Object.typeP(realtype))) {
                    typeexpression = ((Cons)(StandardObject.yieldTypeSpecTree(realtype)));
                  }
                }
              }
            }
          }
          else if (key == Stella.KWD_ALLOCATION) {
            slotoptions.insertAt(key, thevalue.permanentify());
          }
          else if (key == Stella.KWD_READER) {
            slotoptions.insertAt(key, thevalue.permanentify());
          }
          else if (key == Stella.KWD_WRITER) {
            slotoptions.insertAt(key, thevalue.permanentify());
          }
          else if ((key == Stella.KWD_INVERSE) ||
              (key == Stella.KWD_RENAMES)) {
            slotoptions.insertAt(key, thevalue.permanentify());
          }
          else if ((key == Stella.KWD_PUBLICp) ||
              ((key == Stella.KWD_REQUIREDp) ||
               ((key == Stella.KWD_COMPONENTp) ||
                ((key == Stella.KWD_READ_ONLYp) ||
                 ((key == Stella.KWD_ACTIVEp) ||
                  ((key == Stella.KWD_CONTEXT_SENSITIVEp) ||
                   ((key == Stella.KWD_HARDWIREDp) ||
                    (key == Stella.KWD_ABSTRACTp)))))))) {
            slotoptions.insertAt(key, Stella_Object.coerceToBoolean(thevalue));
          }
          else if (key == Stella.KWD_DOCUMENTATION) {
            slotoptions.insertAt(key, thevalue);
          }
          else if (key == Stella.KWD_PROPERTIES) {
            slotoptions.insertAt(key, Stella_Object.collectFeatureList(thevalue));
          }
          else if (key == Stella.KWD_META_ATTRIBUTES) {
            slotoptions.insertAt(key, Stella_Object.collectKeyValueList(thevalue));
          }
          else if ((key == Stella.KWD_OPTION_KEYWORD) ||
              (key == Stella.KWD_OPTION_HANDLER)) {
            slotoptions.insertAt(key, thevalue.permanentify());
          }
          else {
            slotoptions.insertAt(key, thevalue);
          }
        }
      }
      theoptions.thePlist = null;
      slot = ((StorageSlot)(Symbol.defineStellaSlot(((Symbol)(name)), owner, basetype, typeexpression, ((KeywordKeyValueList)(slotoptions.reverse())))));
      Slot.recordSlotHomeModule(slot);
      return (slot);
    }
  }

  public static Stella_Class helpDefineClassFromParseTree(Cons parsetree, String stringifiedsource) {
    { Cons treedefinition = parsetree.rest;
      Cons thesupers = ((Cons)(treedefinition.rest.value));
      PropertyList theoptions = PropertyList.newPropertyList();
      Surrogate classtype = Stella_Object.typify(treedefinition.value);
      List directsupers = List.newList();
      List slots = List.newList();
      KeywordKeyValueList classoptions = KeywordKeyValueList.newKeywordKeyValueList();
      Keyword key = null;
      List parameters = null;
      Cons slottree = null;

      theoptions.thePlist = treedefinition.rest.rest;
      { Stella_Object s = null;
        Cons iter000 = thesupers;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          s = iter000.value;
          if (collect000 == null) {
            {
              collect000 = Cons.cons(Stella_Object.typify(s), Stella.NIL);
              if (directsupers.theConsList == Stella.NIL) {
                directsupers.theConsList = collect000;
              }
              else {
                Cons.addConsToEndOfConsList(directsupers.theConsList, collect000);
              }
            }
          }
          else {
            {
              collect000.rest = Cons.cons(Stella_Object.typify(s), Stella.NIL);
              collect000 = collect000.rest;
            }
          }
        }
      }
      { Stella_Object thekey = null;
        Stella_Object thevalue = null;
        Cons iter001 = theoptions.thePlist;

        for (;!(iter001 == Stella.NIL); iter001 = iter001.rest.rest) {
          thekey = iter001.value;
          thevalue = iter001.rest.value;
          key = ((Keyword)(thekey.permanentify()));
          if ((key == Stella.KWD_PUBLIC_SLOTS) ||
              (key == Stella.KWD_SLOTS)) {
            { Slot localslot = null;

              { Stella_Object slotdef = null;
                Cons iter002 = ((Cons)(thevalue));
                Cons collect001 = null;

                loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                  slotdef = iter002.value;
                  if (!Stella_Object.consP(slotdef)) {
                    { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationNote();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
                          {
                            Stella.STANDARD_OUTPUT.nativeStream.println();
                            Stella.STANDARD_OUTPUT.nativeStream.println(" Illegal slot definition:");
                            Stella.STANDARD_OUTPUT.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(slotdef) + "'");
                            Stella.STANDARD_OUTPUT.nativeStream.println(".");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                      }
                    }
                    continue loop002;
                  }
                  localslot = Cons.defineStorageSlotFromParseTree(((Cons)(slotdef)), classtype);
                  if (key == Stella.KWD_PUBLIC_SLOTS) {
                    localslot.slotPublicP = true;
                  }
                  if (collect001 == null) {
                    {
                      collect001 = Cons.cons(localslot, Stella.NIL);
                      if (slots.theConsList == Stella.NIL) {
                        slots.theConsList = collect001;
                      }
                      else {
                        Cons.addConsToEndOfConsList(slots.theConsList, collect001);
                      }
                    }
                  }
                  else {
                    {
                      collect001.rest = Cons.cons(localslot, Stella.NIL);
                      collect001 = collect001.rest;
                    }
                  }
                }
              }
            }
          }
          else if ((key == Stella.KWD_PUBLIC_METHODS) ||
              (key == Stella.KWD_METHODS)) {
            { Slot localslot = null;

              { Cons methoddef = null;
                Cons iter003 = ((Cons)(thevalue));
                Cons collect002 = null;

                loop003 : for (;!(iter003 == Stella.NIL); iter003 = iter003.rest) {
                  methoddef = ((Cons)(iter003.value));
                  if (!Stella_Object.consP(methoddef)) {
                    { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationNote();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> NOTE: ", Stella.STANDARD_OUTPUT);
                          {
                            Stella.STANDARD_OUTPUT.nativeStream.println();
                            Stella.STANDARD_OUTPUT.nativeStream.println(" Illegal inline method definition:");
                            Stella.STANDARD_OUTPUT.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(methoddef) + "'");
                            Stella.STANDARD_OUTPUT.nativeStream.println(".");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                      }
                    }
                    continue loop003;
                  }
                  localslot = Symbol.defineInlineMethod(((Symbol)(methoddef.value)), methoddef.rest);
                  if (key == Stella.KWD_PUBLIC_METHODS) {
                    localslot.slotPublicP = true;
                  }
                  if (!(localslot.slotOwner == classtype)) {
                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationError();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                          {
                            Stella.STANDARD_ERROR.nativeStream.println();
                            Stella.STANDARD_ERROR.nativeStream.println(" Defining a method for the class `" + localslot.slotOwner + "' inside of the class `" + Stella_Object.deUglifyParseTree(classtype) + "'.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                      }
                    }
                  }
                  if (collect002 == null) {
                    {
                      collect002 = Cons.cons(localslot, Stella.NIL);
                      if (slots.theConsList == Stella.NIL) {
                        slots.theConsList = collect002;
                      }
                      else {
                        Cons.addConsToEndOfConsList(slots.theConsList, collect002);
                      }
                    }
                  }
                  else {
                    {
                      collect002.rest = Cons.cons(localslot, Stella.NIL);
                      collect002 = collect002.rest;
                    }
                  }
                }
              }
            }
          }
          else if (key == Stella.KWD_PARAMETERS) {
            parameters = List.newList();
            { Stella_Object slotdef = null;
              Cons iter004 = ((Cons)(thevalue));
              Cons collect003 = null;

              for (;!(iter004 == Stella.NIL); iter004 = iter004.rest) {
                slotdef = iter004.value;
                if (collect003 == null) {
                  {
                    collect003 = Cons.cons(Cons.defineStorageSlotFromParseTree(((Cons)(slotdef)), classtype), Stella.NIL);
                    if (parameters.theConsList == Stella.NIL) {
                      parameters.theConsList = collect003;
                    }
                    else {
                      Cons.addConsToEndOfConsList(parameters.theConsList, collect003);
                    }
                  }
                }
                else {
                  {
                    collect003.rest = Cons.cons(Cons.defineStorageSlotFromParseTree(((Cons)(slotdef)), classtype), Stella.NIL);
                    collect003 = collect003.rest;
                  }
                }
              }
            }
            classoptions.insertAt(key, parameters);
          }
          else if (key == Stella.KWD_KEY) {
            if (!Stella_Object.consP(thevalue)) {
              thevalue = Cons.cons(thekey, Stella.NIL);
            }
            Cons.inPlaceObjectsToSymbols(((Cons)(thevalue)));
            classoptions.insertAt(key, ((Cons)(thevalue)));
          }
          else if (key == Stella.KWD_SYNONYMS) {
            if (!Stella_Object.consP(thevalue)) {
              thevalue = Cons.cons(thekey, Stella.NIL);
            }
            Cons.inPlaceObjectsToTypes(((Cons)(thevalue)));
            classoptions.insertAt(key, ((Cons)(thevalue)));
          }
          else if ((key == Stella.KWD_DOCUMENTATION) ||
              ((key == Stella.KWD_CL_NATIVE_TYPE) ||
               ((key == Stella.KWD_CPP_NATIVE_TYPE) ||
                ((key == Stella.KWD_JAVA_NATIVE_TYPE) ||
                 (key == Stella.KWD_IDL_NATIVE_TYPE))))) {
            classoptions.insertAt(key, thevalue);
          }
          else if ((key == Stella.KWD_ABSTRACTp) ||
              ((key == Stella.KWD_ACTIVEp) ||
               ((key == Stella.KWD_PUBLICp) ||
                ((key == Stella.KWD_CL_STRUCTp) ||
                 (key == Stella.KWD_MIXINp))))) {
            classoptions.insertAt(key, Stella_Object.coerceToBoolean(thevalue));
          }
          else if (key == Stella.KWD_RECYCLE_METHOD) {
            thevalue = thevalue.permanentify();
            classoptions.insertAt(key, thevalue);
            if (Stella.getQuotedTree("((:SWEEP-LIST :FREE-AND-SWEEP-LIST) \"/STELLA\")", "/STELLA").memberP(thevalue)) {
              slottree = Cons.list$(Cons.cons(Stella.SYM_STELLA_NEXT_SWEEP_LIST_OBJECT, Cons.cons(Stella.KWD_TYPE, Cons.cons(treedefinition.value, Cons.cons(Stella.NIL, Stella.NIL)))));
              slots.push(Cons.defineStorageSlotFromParseTree(slottree, classtype));
            }
          }
          else if ((key == Stella.KWD_EXTENSION) ||
              ((key == Stella.KWD_CREATOR) ||
               ((key == Stella.KWD_DESTRUCTOR) ||
                ((key == Stella.KWD_INITIALIZER) ||
                 ((key == Stella.KWD_TERMINATOR) ||
                  (key == Stella.KWD_EQUALITY_TEST)))))) {
            classoptions.insertAt(key, thevalue.permanentify());
          }
          else if ((key == Stella.KWD_INITIAL_VALUE) ||
              (key == Stella.KWD_PRINT_FORM)) {
            classoptions.insertAt(key, Stella_Object.permanentifyForm(thevalue));
          }
          else if (key == Stella.KWD_PROPERTIES) {
            classoptions.insertAt(key, Stella_Object.collectFeatureList(thevalue));
          }
          else if (key == Stella.KWD_META_ATTRIBUTES) {
            classoptions.insertAt(key, Stella_Object.collectKeyValueList(thevalue));
          }
          else if (key == Stella.KWD_CHILDREN) {
            if (Stella_Object.safePrimaryType(thevalue) == Stella.SGT_STELLA_CONS) {
              { Cons thevalue000 = ((Cons)(thevalue));

                { List children = List.newList();

                  { Stella_Object child = null;
                    Cons iter005 = thevalue000;
                    Cons collect004 = null;

                    for (;!(iter005 == Stella.NIL); iter005 = iter005.rest) {
                      child = iter005.value;
                      if (Stella_Object.symbolP(child)) {
                        if (collect004 == null) {
                          {
                            collect004 = Cons.cons(Stella_Object.typify(child), Stella.NIL);
                            if (children.theConsList == Stella.NIL) {
                              children.theConsList = collect004;
                            }
                            else {
                              Cons.addConsToEndOfConsList(children.theConsList, collect004);
                            }
                          }
                        }
                        else {
                          {
                            collect004.rest = Cons.cons(Stella_Object.typify(child), Stella.NIL);
                            collect004 = collect004.rest;
                          }
                        }
                      }
                    }
                  }
                  classoptions.insertAt(key, children);
                }
              }
            }
            else {
              { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                try {
                  Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                  Stella.signalTranslationError();
                  if (!(Stella.suppressWarningsP())) {
                    Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                    {
                      Stella.STANDARD_ERROR.nativeStream.println();
                      Stella.STANDARD_ERROR.nativeStream.println(" Illegal :children specification: `" + Stella_Object.deUglifyParseTree(thevalue) + "'.");
                    }
;
                  }

                } finally {
                  Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                }
              }
            }
          }
          else {
            classoptions.insertAt(key, thevalue);
          }
        }
      }
      theoptions.thePlist = null;
      { Stella_Class renamed_Class = Surrogate.defineStellaClass(classtype, directsupers, slots, ((KeywordKeyValueList)(classoptions.reverse())));

        if (renamed_Class != null) {
          renamed_Class.classStringifiedSource = stringifiedsource;
        }
        return (renamed_Class);
      }
    }
  }

  public static void setTimeValues(Cons stringForm, DecodedDateTime parsedValues, DecodedDateTime defaultValues) {
    { Stella_Object formType = null;
      Stella_Object formValue = null;

      { Cons formPart = null;
        Cons iter000 = stringForm;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          formPart = ((Cons)(iter000.value));
          formType = formPart.value;
          formValue = formPart.rest.value;
          { GeneralizedSymbol testValue000 = ((GeneralizedSymbol)(formType));

            if (testValue000 == Stella.SYM_STELLA_SECONDP) {
              { Surrogate testValue001 = Stella_Object.safePrimaryType(formValue);

                if (Surrogate.subtypeOfIntegerP(testValue001)) {
                  { IntegerWrapper formValue000 = ((IntegerWrapper)(formValue));

                    parsedValues.dateTimeSecond = formValue000.wrapperValue;
                  }
                }
                else if (Surrogate.subtypeOfFloatP(testValue001)) {
                  { FloatWrapper formValue000 = ((FloatWrapper)(formValue));

                    parsedValues.dateTimeSecond = Native.floor(formValue000.wrapperValue);
                    parsedValues.dateTimeMillis = 1000.0 * (formValue000.wrapperValue - Native.floor(formValue000.wrapperValue));
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
            else if (testValue000 == Stella.SYM_STELLA_MINUTE) {
              parsedValues.dateTimeMinute = ((IntegerWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_HOUR) {
              parsedValues.dateTimeHour = ((IntegerWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_DAY) {
              parsedValues.dateTimeDay = ((IntegerWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_MONTH) {
              parsedValues.dateTimeMonth = ((IntegerWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_YEAR) {
              parsedValues.dateTimeYear = ((IntegerWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_ZONE) {
              parsedValues.dateTimeZone = ((FloatWrapper)(formValue)).wrapperValue;
            }
            else if (testValue000 == Stella.SYM_STELLA_ZONE_MINUTE) {
              if (parsedValues.dateTimeZone > 0) {
                parsedValues.dateTimeZone = parsedValues.dateTimeZone + (((NumberWrapper)(formValue)).numberWrapperToFloat() / 60.0);
              }
              else {
                parsedValues.dateTimeZone = parsedValues.dateTimeZone + (((NumberWrapper)(formValue)).numberWrapperToFloat() / -60.0);
              }
            }
            else if (testValue000 == Stella.SYM_STELLA_WEEKDAY) {
              parsedValues.dateTimeDow = ((Keyword)(formValue));
            }
            else if (testValue000 == Stella.SYM_STELLA_AM_PM) {
              Stella_Object.dealWithAmPm(formValue, parsedValues);
            }
            else if (testValue000 == Stella.SYM_STELLA_ERA) {
              Stella_Object.dealWithEra(formValue, parsedValues);
            }
            else if (testValue000 == Stella.SYM_STELLA_NOON_MIDN) {
              Stella_Object.dealWithNoonMidn(formValue, parsedValues);
            }
            else if (testValue000 == Stella.SYM_STELLA_SPECIAL) {
              edu.isi.stella.javalib.Native.funcall(Symbol.lookupFunction(((Symbol)(formValue))).functionCode, null, new java.lang.Object [] {parsedValues, defaultValues});
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("Unrecognized symbol in form list: ~A.`" + formType + "'");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
    }
  }

  public static Cons matchPattern(Cons pattern, Cons datum, int datumLength) {
    if (pattern.length() < datumLength) {
      return (Stella.NIL);
    }
    else {
      { Cons formList = Stella.NIL;
        Cons patternCursor = pattern;
        Cons datumCursor = datum;
        Stella_Object patternElement = null;
        Stella_Object datumElement = null;
        boolean optionalP = false;
        Cons matching = Stella.NIL;

        while (!((patternCursor == Stella.NIL) ||
            (datumCursor == Stella.NIL))) {
          patternElement = patternCursor.value;
          datumElement = datumCursor.value;
          optionalP = Stella_Object.isaP(patternElement, Stella.SGT_STELLA_CONS);
          matching = Symbol.matchPatternElement((optionalP ? ((Symbol)(((Cons)(patternElement)).value)) : ((Symbol)(patternElement))), datumElement);
          if (!(matching == Stella.NIL)) {
            { Stella_Object formType = matching.value;

              if (!((formType == Stella.SYM_STELLA_TIME_DIVIDER) ||
                  ((formType == Stella.SYM_STELLA_DATE_DIVIDER) ||
                   (formType == Stella.SYM_STELLA_DATE_TIME_DIVIDER)))) {
                formList = Cons.cons(matching, formList);
              }
            }
          }
          else if (optionalP) {
            datumCursor = Cons.cons(datumElement, datumCursor);
          }
          else {
            return (Stella.NIL);
          }
          patternCursor = patternCursor.rest;
          datumCursor = datumCursor.rest;
        }
        if ((patternCursor == Stella.NIL) &&
            (datumCursor == Stella.NIL)) {
          return (formList.reverse());
        }
        else if (patternCursor == Stella.NIL) {
          return (Stella.NIL);
        }
        else if (datumCursor == Stella.NIL) {
          { Stella_Object element = null;
            Cons iter000 = patternCursor;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              element = iter000.value;
              if (!Stella_Object.isaP(element, Stella.SGT_STELLA_CONS)) {
                return (Stella.NIL);
              }
            }
          }
          return (formList.reverse());
        }
        else {
          throw ((StellaException)(StellaException.newStellaException("Shouldn't get here!").fillInStackTrace()));
        }
      }
    }
  }

  public static Surrogate defineStellaTypeFromParseTree(Cons tree) {
    { Stella_Object typename = tree.rest.value;
      StandardObject typedefinition = tree.rest.rest.value.yieldTypeSpecifier();
      Surrogate type = null;

      if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(typename))) {
        { Symbol typename000 = ((Symbol)(typename));

          type = Stella_Object.typify(typename000);
          if ((!Surrogate.definedTypeP(type)) &&
              (type.surrogateValue != null)) {
            { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

              try {
                Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                Stella.signalTranslationError();
                if (!(Stella.suppressWarningsP())) {
                  Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                  {
                    Stella.STANDARD_ERROR.nativeStream.println();
                    Stella.STANDARD_ERROR.nativeStream.println(" Cannot define type `" + Stella_Object.deUglifyParseTree(typename000) + "', since `" + Stella_Object.deUglifyParseTree(type) + "'");
                    Stella.STANDARD_ERROR.nativeStream.println("   already points to `" + type.surrogateValue + "'.");
                  }
;
                }

              } finally {
                Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
              }
            }
            return (null);
          }
          type.surrogateValue = typedefinition;
          return (type);
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
                Stella.STANDARD_ERROR.nativeStream.println(" Illegal type name: `" + Stella_Object.deUglifyParseTree(typename) + "'.");
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
  }

  public static GlobalVariable defineStellaGlobalVariableFromParseTree(Cons tree, String stringifiedsource, Object [] MV_returnarray) {
    { Stella_Object typetree = tree.rest.rest.value;
      Stella_Object initialvaluetree = tree.fourth();
      Cons optionstree = tree.nthRest(4);
      boolean specialP = tree.value == Stella.SYM_STELLA_DEFSPECIAL;
      boolean constantP = tree.value == Stella.SYM_STELLA_DEFCONSTANT;
      boolean noinitialvalueP = false;
      GlobalVariable global = GlobalVariable.newGlobalVariable();
      GlobalVariable internedglobal = null;

      if ((tree.length() <= 3) ||
          (Stella.getQuotedTree("((:DOCUMENTATION :PUBLIC? :AUXILIARY?) \"/STELLA\")", "/STELLA").memberP(initialvaluetree) &&
           (((optionstree.length()) % 2) == 1))) {
        noinitialvalueP = true;
        initialvaluetree = (specialP ? Stella.KWD_UNBOUND_SPECIAL_VARIABLE : null);
        optionstree = tree.nthRest(3);
      }
      global.variableName = ((Symbol)(tree.rest.value.permanentify()));
      global.variableStringifiedSource = stringifiedsource;
      internedglobal = GlobalVariable.internGlobalVariable(global);
      GlobalVariable.recordVariableHomeModule(internedglobal);
      if (noinitialvalueP &&
          (!specialP)) {
        if (constantP) {
          { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

            try {
              Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
              Stella.signalTranslationError();
              if (!(Stella.suppressWarningsP())) {
                Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                {
                  Stella.STANDARD_ERROR.nativeStream.println();
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing value in constant declaration.");
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
                  Stella.STANDARD_ERROR.nativeStream.println(" Missing initial value in variable declaration.");
                }
;
              }

            } finally {
              Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
            }
          }
        }
        { GlobalVariable _return_temp = internedglobal;

          MV_returnarray[0] = initialvaluetree;
          return (_return_temp);
        }
      }
      if (!(global == internedglobal)) {
        { GlobalVariable _return_temp = internedglobal;

          MV_returnarray[0] = initialvaluetree;
          return (_return_temp);
        }
      }
      typetree = typetree.yieldTypeSpecifier();
      StandardObject.validateTypeSpecifier(((StandardObject)(typetree)), null, true);
      if (Stella_Object.typeP(typetree)) {
        global.variableType = ((Surrogate)(typetree));
      }
      else {
        {
          KeyValueList.setDynamicSlotValue(global.dynamicSlots, Stella.SYM_STELLA_VARIABLE_TYPE_SPECIFIER, ((StandardObject)(typetree)), null);
          global.variableType = StandardObject.typeSpecToBaseType(((StandardObject)(typetree)));
        }
      }
      global.variableSpecialP = specialP;
      global.variableConstantP = constantP;
      if (!(optionstree == Stella.NIL)) {
        { PropertyList options = PropertyList.newPropertyList();

          options.thePlist = optionstree;
          { Stella_Object key = null;
            Stella_Object value = null;
            Cons iter000 = options.thePlist;

            for (;!(iter000 == Stella.NIL); iter000 = iter000.rest.rest) {
              key = iter000.value;
              value = iter000.rest.value;
              { Keyword testValue000 = ((Keyword)(key));

                if (testValue000 == Stella.KWD_DOCUMENTATION) {
                  global.documentation = ((StringWrapper)(value)).wrapperValue;
                }
                else if (testValue000 == Stella.KWD_PUBLICp) {
                  global.variablePublicP = BooleanWrapper.coerceWrappedBooleanToBoolean(Stella_Object.coerceToBoolean(value));
                }
                else if (testValue000 == Stella.KWD_AUXILIARYp) {
                  global.variableAuxiliaryP = BooleanWrapper.coerceWrappedBooleanToBoolean(Stella_Object.coerceToBoolean(value));
                }
                else {
                  if (!(Stella_Object.runOptionHandlerP(global, ((Keyword)(key)), value))) {
                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationWarning();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> WARNING: ", Stella.STANDARD_WARNING);
                          {
                            Stella.STANDARD_WARNING.nativeStream.println();
                            Stella.STANDARD_WARNING.nativeStream.println(" Skipping invalid variable option `" + Stella_Object.deUglifyParseTree(key) + "'");
                            Stella.STANDARD_WARNING.nativeStream.println("in the definition of variable `" + global.variableName + "'.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                      }
                    }
                  }
                }
              }
            }
          }
          options.thePlist = null;
        }
      }
      { GlobalVariable _return_temp = global;

        MV_returnarray[0] = initialvaluetree;
        return (_return_temp);
      }
    }
  }

  public static AnchoredTypeSpecifier yieldAnchoredTypeSpecifier(Cons typespectree) {
    { AnchoredTypeSpecifier typespec = AnchoredTypeSpecifier.newAnchoredTypeSpecifier();
      Stella_Object likeargument = typespectree.rest.value;

      if (!(likeargument == Stella.SYM_STELLA_SELF)) {
        typespec.specifierParameterName = ((Symbol)(((Cons)(likeargument)).value.permanentify()));
      }
      return (typespec);
    }
  }

  public static ParametricTypeSpecifier yieldParametricTypeSpecifier(Cons typespectree) {
    { ParametricTypeSpecifier typespec = ParametricTypeSpecifier.newParametricTypeSpecifier();
      StandardObject parametertypespec = null;
      Cons cursor = typespectree;

      { Stella_Object head000 = cursor.value;

        cursor = cursor.rest;
        { Surrogate basetype = Stella_Object.typify(head000);
          StandardObject realbasetypespec = Surrogate.realTypeSpecifier(basetype);
          boolean definedbasetypeP = !(basetype == realbasetypespec);

          { Stella_Object head001 = cursor.value;

            cursor = cursor.rest;
            { Stella_Object operator = head001;
              boolean arraytypeP = false;

              if (definedbasetypeP) {
                basetype = StandardObject.typeSpecToBaseType(realbasetypespec);
              }
              typespec.specifierBaseType = Surrogate.verifyType(basetype);
              if (StandardObject.arrayTypeSpecifierP(typespec)) {
                if (operator == Stella.SYM_STELLA_SIZE) {
                  { Stella_Object head002 = cursor.value;

                    cursor = cursor.rest;
                    operator = head002;
                  }
                }
                arraytypeP = true;
                typespec.specifierDimensions = Stella_Object.parseArrayDimensionsSpec(operator);
                { Stella_Object head003 = cursor.value;

                  cursor = cursor.rest;
                  operator = head003;
                }
              }
              if (arraytypeP &&
                  (typespec.specifierDimensions == null)) {
                { Object old$PrintreadablyP$000 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Illegal array type specifier dimensions: `" + Stella_Object.deUglifyParseTree(typespectree) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$000);
                  }
                }
                return (Cons.yieldParametricTypeSpecifier(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNKNOWN, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.NIL, Stella.NIL))))));
              }
              if (!(operator == Stella.SYM_STELLA_OF)) {
                { Object old$PrintreadablyP$001 = Stella.$PRINTREADABLYp$.get();

                  try {
                    Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                    Stella.signalTranslationError();
                    if (!(Stella.suppressWarningsP())) {
                      Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                      {
                        Stella.STANDARD_ERROR.nativeStream.println();
                        Stella.STANDARD_ERROR.nativeStream.println(" Bad type specifier `" + Stella_Object.deUglifyParseTree(typespectree) + "'.");
                      }
;
                    }

                  } finally {
                    Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$001);
                  }
                }
                return (Cons.yieldParametricTypeSpecifier(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNKNOWN, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.NIL, Stella.NIL))))));
              }
              { Stella_Object p = null;
                Cons iter000 = cursor;
                List into000 = typespec.specifierParameterTypes;
                Cons collect000 = null;

                for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                  p = iter000.value;
                  parametertypespec = p.yieldTypeSpecifier();
                  if (StandardObject.arrayTypeSpecifierP(parametertypespec)) {
                    { Object old$PrintreadablyP$002 = Stella.$PRINTREADABLYp$.get();

                      try {
                        Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                        Stella.signalTranslationError();
                        if (!(Stella.suppressWarningsP())) {
                          Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                          {
                            Stella.STANDARD_ERROR.nativeStream.println();
                            Stella.STANDARD_ERROR.nativeStream.println(" Illegal nested array type specifier: ");
                            Stella.STANDARD_ERROR.nativeStream.println("   `" + Stella_Object.deUglifyParseTree(typespectree) + "'");
                            Stella.STANDARD_ERROR.nativeStream.println("   Use multi-dimensional arrays instead.");
                          }
;
                        }

                      } finally {
                        Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$002);
                      }
                    }
                    return (Cons.yieldParametricTypeSpecifier(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNKNOWN, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.NIL, Stella.NIL))))));
                  }
                  if (collect000 == null) {
                    {
                      collect000 = Cons.cons(parametertypespec, Stella.NIL);
                      if (into000.theConsList == Stella.NIL) {
                        into000.theConsList = collect000;
                      }
                      else {
                        Cons.addConsToEndOfConsList(into000.theConsList, collect000);
                      }
                    }
                  }
                  else {
                    {
                      collect000.rest = Cons.cons(parametertypespec, Stella.NIL);
                      collect000 = collect000.rest;
                    }
                  }
                }
              }
              if (definedbasetypeP) {
                if (Surrogate.subtypeOfParametricTypeSpecifierP(Stella_Object.safePrimaryType(realbasetypespec))) {
                  { ParametricTypeSpecifier realbasetypespec000 = ((ParametricTypeSpecifier)(realbasetypespec));

                    { boolean testValue000 = false;

                      testValue000 = realbasetypespec000.specifierParameterTypes.length() == typespec.specifierParameterTypes.length();
                      if (testValue000) {
                        { boolean alwaysP000 = true;

                          { StandardObject partype = null;
                            Cons iter001 = typespec.specifierParameterTypes.theConsList;
                            StandardObject rpartype = null;
                            Cons iter002 = realbasetypespec000.specifierParameterTypes.theConsList;

                            loop001 : for (;(!(iter001 == Stella.NIL)) &&
                                      (!(iter002 == Stella.NIL)); iter001 = iter001.rest, iter002 = iter002.rest) {
                              partype = ((StandardObject)(iter001.value));
                              rpartype = ((StandardObject)(iter002.value));
                              if (!Surrogate.optimisticSubtypeOfP(StandardObject.typeSpecToBaseType(partype), StandardObject.typeSpecToBaseType(rpartype))) {
                                alwaysP000 = false;
                                break loop001;
                              }
                            }
                          }
                          testValue000 = alwaysP000;
                        }
                      }
                      if (!(testValue000)) {
                        { Object old$PrintreadablyP$003 = Stella.$PRINTREADABLYp$.get();

                          try {
                            Native.setBooleanSpecial(Stella.$PRINTREADABLYp$, true);
                            Stella.signalTranslationError();
                            if (!(Stella.suppressWarningsP())) {
                              Stella.printErrorContext(">> ERROR: ", Stella.STANDARD_ERROR);
                              {
                                Stella.STANDARD_ERROR.nativeStream.println();
                                Stella.STANDARD_ERROR.nativeStream.println(" Parameter types of `" + Stella_Object.deUglifyParseTree(typespectree) + "' are incompatible ");
                                Stella.STANDARD_ERROR.nativeStream.println(" with parameter types of defined type `" + typespectree.value + "'.");
                              }
;
                            }

                          } finally {
                            Stella.$PRINTREADABLYp$.set(old$PrintreadablyP$003);
                          }
                        }
                        return (Cons.yieldParametricTypeSpecifier(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNKNOWN, Cons.cons(Stella.SYM_STELLA_OF, Cons.cons(Stella.NIL, Stella.NIL))))));
                      }
                    }
                  }
                }
                else {
                }
              }
              return (typespec);
            }
          }
        }
      }
    }
  }

  public StandardObject yieldTypeSpecifier() {
    { Cons typespectree = this;

      if (typespectree == Stella.NIL) {
        return (Stella.SGT_STELLA_VOID);
      }
      else if (typespectree.value == Stella.SYM_STELLA_LIKE) {
        return (Cons.yieldAnchoredTypeSpecifier(typespectree));
      }
      else {
        return (Cons.yieldParametricTypeSpecifier(typespectree));
      }
    }
  }

  public static void printUnboundSurrogatesEvaluatorWrapper(Cons arguments) {
    Stella.printUnboundSurrogates(arguments);
  }

  public static void inPlaceObjectsToTypes(Cons conslist) {
    { Cons cursor = conslist;

      while (!(cursor == Stella.NIL)) {
        cursor.value = Stella_Object.typify(cursor.value);
        cursor = cursor.rest;
      }
    }
  }

  public static void inPlaceObjectsToSymbols(Cons conslist) {
    { Cons cursor = conslist;

      while (!(cursor == Stella.NIL)) {
        cursor.value = cursor.value.permanentify();
        cursor = cursor.rest;
      }
    }
  }

  public static Cons removeShadowedSymbols(Cons visiblesymbols) {
    if (visiblesymbols.rest == Stella.NIL) {
      return (visiblesymbols);
    }
    { Cons shadowingmodules = Stella.NIL;

      { GeneralizedSymbol symbol = null;
        Cons iter000 = visiblesymbols;
        Cons collect000 = null;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          symbol = ((GeneralizedSymbol)(iter000.value));
          if (GeneralizedSymbol.shadowedSymbolP(symbol)) {
            if (collect000 == null) {
              {
                collect000 = Cons.cons(((Module)(symbol.homeContext)), Stella.NIL);
                if (shadowingmodules == Stella.NIL) {
                  shadowingmodules = collect000;
                }
                else {
                  Cons.addConsToEndOfConsList(shadowingmodules, collect000);
                }
              }
            }
            else {
              {
                collect000.rest = Cons.cons(((Module)(symbol.homeContext)), Stella.NIL);
                collect000 = collect000.rest;
              }
            }
          }
        }
      }
      if (!(shadowingmodules == Stella.NIL)) {
        { Cons unshadowedsymbols = Stella.NIL;

          { GeneralizedSymbol symbol = null;
            Cons iter001 = visiblesymbols;
            Cons collect001 = null;

            for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              symbol = ((GeneralizedSymbol)(iter001.value));
              { boolean testValue000 = false;

                { boolean foundP000 = false;

                  { Module module = null;
                    Cons iter002 = shadowingmodules;

                    loop002 : for (;!(iter002 == Stella.NIL); iter002 = iter002.rest) {
                      module = ((Module)(iter002.value));
                      if ((!(module == ((Module)(symbol.homeContext)))) &&
                          Context.visibleFromP(((Module)(symbol.homeContext)), module)) {
                        foundP000 = true;
                        break loop002;
                      }
                    }
                  }
                  testValue000 = foundP000;
                }
                testValue000 = !testValue000;
                if (testValue000) {
                  if (collect001 == null) {
                    {
                      collect001 = Cons.cons(symbol, Stella.NIL);
                      if (unshadowedsymbols == Stella.NIL) {
                        unshadowedsymbols = collect001;
                      }
                      else {
                        Cons.addConsToEndOfConsList(unshadowedsymbols, collect001);
                      }
                    }
                  }
                  else {
                    {
                      collect001.rest = Cons.cons(symbol, Stella.NIL);
                      collect001 = collect001.rest;
                    }
                  }
                }
              }
            }
          }
          visiblesymbols = unshadowedsymbols;
        }
      }
      return (visiblesymbols);
    }
  }

  /** Allocate a cross product iterator for a list of <code>domains</code>.
   * @param domains
   * @return CrossProductIterator
   */
  public static CrossProductIterator allocateCrossProductIterator(Cons domains) {
    { CrossProductIterator self000 = CrossProductIterator.newCrossProductIterator();

      self000.domains = domains;
      { CrossProductIterator iterator = self000;
        Cons cursors = Stella.NIL;
        Cons values = Stella.NIL;

        { Cons domain = null;
          Cons iter000 = domains;
          int i = Stella.NULL_INTEGER;
          int iter001 = 0;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
            domain = ((Cons)(iter000.value));
            i = iter001;
            if ((domain == null) ||
                (domain == Stella.NIL)) {
              return (iterator);
            }
            cursors = Cons.cons(((i == 0) ? domain : domain.rest), cursors);
            values = Cons.cons(domain.value, values);
          }
        }
        iterator.cursors = cursors.reverse();
        iterator.value = values.reverse();
        return (iterator);
      }
    }
  }

  public Iterator allocateDestructiveListIterator() {
    { Cons self = this;

      { DestructiveListIterator iterator = DestructiveListIterator.newDestructiveListIterator();

        iterator.theConsList = self;
        iterator.listIteratorCursor = self;
        return (iterator);
      }
    }
  }

  /** Return a list of elements in <code>self</code>.
   * @return List
   */
  public List listify() {
    { Cons self = this;

      { List self000 = List.newList();

        self000.theConsList = self;
        { List value000 = self000;

          return (value000);
        }
      }
    }
  }

  public static Stella_Object searchPlist(Cons plist, Stella_Object key) {
    while (!(plist == Stella.NIL)) {
      if (Stella_Object.eqlP(plist.value, key)) {
        return (plist.rest.value);
      }
      plist = plist.rest.rest;
    }
    return (null);
  }

  public static int safeTreeSize(Cons tree, Object [] MV_returnarray) {
    { Object old$DepthexceededP$000 = Stella.$DEPTHEXCEEDEDp$.get();

      try {
        Native.setBooleanSpecial(Stella.$DEPTHEXCEEDEDp$, false);
        { int cutoff = 99;
          int size = Cons.safelyComputeTreeSize(tree, 0, cutoff);

          { int _return_temp = size;

            MV_returnarray[0] = StringWrapper.wrapString(((((Boolean)(Stella.$DEPTHEXCEEDEDp$.get())).booleanValue() ||
                (size >= cutoff)) ? "CIRCULAR" : "OK"));
            return (_return_temp);
          }
        }

      } finally {
        Stella.$DEPTHEXCEEDEDp$.set(old$DepthexceededP$000);
      }
    }
  }

  public static int safelyComputeTreeSize(Cons tree, int depthcount, int cutoff) {
    { int count = 1;
      Stella_Object value = null;

      if (depthcount > Stella.$DEPTHCUTOFF$) {
        Native.setBooleanSpecial(Stella.$DEPTHEXCEEDEDp$, true);
        return (1);
      }
      for (;;) {
        value = tree.value;
        if (Stella_Object.consP(value)) {
          count = count + Cons.safelyComputeTreeSize(((Cons)(tree.value)), depthcount + 1, cutoff);
        }
        if ((tree.rest == null) ||
            ((tree.rest == Stella.NIL) ||
             (count > cutoff))) {
          return (count);
        }
        tree = tree.rest;
      }
    }
  }

  public static void pprintCons(Cons tree, edu.isi.stella.javalib.NativeOutputStream stream, String lparen, String rparen) {
    { Object old$PrintprettyP$000 = Stella.$PRINTPRETTYp$.get();

      try {
        Native.setBooleanSpecial(Stella.$PRINTPRETTYp$, false);
        Cons.printCons(tree, stream, lparen, rparen);

      } finally {
        Stella.$PRINTPRETTYp$.set(old$PrintprettyP$000);
      }
    }
  }

  public static void printCons(Cons tree, edu.isi.stella.javalib.NativeOutputStream stream, String lparen, String rparen) {
    if (((Boolean)(Stella.$PRINTREADABLYp$.get())).booleanValue()) {
      lparen = "(";
      rparen = ")";
    }
    if (((Boolean)(Stella.$PRINTPRETTYp$.get())).booleanValue()) {
      Cons.pprintCons(tree, stream, lparen, rparen);
      return;
    }
    stream.print(lparen);
    if (!(tree == Stella.NIL)) {
      stream.print(tree.value);
      tree = tree.rest;
      if (((Integer)(Stella.$PRINTLENGTH$.get())).intValue() != Stella.NULL_INTEGER) {
        { int i = 1;

          { Stella_Object element = null;
            Cons iter000 = tree;

            loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
              element = iter000.value;
              stream.print(" " + element);
              tree = tree.rest;
              i = i + 1;
              if (i >= ((Integer)(Stella.$PRINTLENGTH$.get())).intValue()) {
                break loop000;
              }
            }
          }
          if (!(tree == Stella.NIL)) {
            stream.print(" ...");
          }
        }
      }
      else {
        { Stella_Object element = null;
          Cons iter001 = tree;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            element = iter001.value;
            stream.print(" " + element);
          }
        }
      }
    }
    stream.print(rparen);
  }

  /** Access an arbitrary sublist of <code>tree</code> identified by a path
   * specified as a list of <code>index</code> values.  The first <code>index</code> specifies the
   * <code>index</code>-th element of <code>tree</code>, the second <code>index</code> the <code>index</code>-th subelement
   * of that element, ..., the last index specifies the <code>nthRest</code> of the previous
   * element (different from <code>consTreeNth</code>).  Example:
   * 	 
   *   (cons-tree-nth-rest (quote (a (b (c d e) f) g)) 1 1 1) =&gt; (d e)
   * 	
   * 
   * @param tree
   * @param index
   * @return Cons
   */
  public static Cons consTreeNthRest(Cons tree, Cons index) {
    { Stella_Object result = tree;
      int nofindices = index.length();

      { int i = Stella.NULL_INTEGER;
        Cons iter000 = index;
        int j = Stella.NULL_INTEGER;
        int iter001 = 1;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          i = ((IntegerWrapper)(iter000.value)).wrapperValue;
          j = iter001;
          if (Stella_Object.safePrimaryType(result) == Stella.SGT_STELLA_CONS) {
            { Cons result000 = ((Cons)(result));

              tree = result000;
            }
          }
          else {
            return (null);
          }
          if (j == nofindices) {
            result = tree.nthRest(i);
          }
          else {
            result = tree.nth(i);
          }
        }
      }
      return (((Cons)(result)));
    }
  }

  /** Access an arbitrary element of <code>tree</code> identified by a path
   * specified as a list of <code>index</code> values.  The first <code>index</code> specifies the
   * <code>index</code>-th element of <code>tree</code>, the second <code>index</code> the <code>index</code>-th subelement
   * of that element, etc.  Example:
   * 	 
   *   (cons-tree-nth (quote (a (b (c d e) f) g)) 1 1 2) =&gt; e
   * 	
   * 
   * @param tree
   * @param index
   * @return Stella_Object
   */
  public static Stella_Object consTreeNth(Cons tree, Cons index) {
    { Stella_Object result = tree;

      { int i = Stella.NULL_INTEGER;
        Cons iter000 = index;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = ((IntegerWrapper)(iter000.value)).wrapperValue;
          if (Stella_Object.safePrimaryType(result) == Stella.SGT_STELLA_CONS) {
            { Cons result000 = ((Cons)(result));

              tree = result000;
            }
          }
          else {
            return (null);
          }
          result = tree.nth(i);
        }
      }
      return (result);
    }
  }

  /** Return an <code>equalP</code> hash code for <code>self</code>.  Note that this
   * is O(N) in the number of elements of <code>self</code>.
   * @return int
   */
  public int equalHashCode() {
    { Cons self = this;

      { int code = 18589447;

        loop000 : for (;;) {
          if (self == Stella.NIL) {
            break loop000;
          }
          code = (code ^ (Stella_Object.safeEqualHashCode(self.value)));
          self = self.rest;
          code = (((code & 1) == 0) ? (code >>> 1) : (((code >> 1)) | Stella.$INTEGER_MSB_MASK$));
        }
        return (code);
      }
    }
  }

  /** Return <code>true</code> iff the cons trees <code>tree1</code> and <code>tree2</code> are
   * structurally equivalent.  Uses <code>equalP</code> to test equality of subtrees.
   * @param tree2
   * @return boolean
   */
  public boolean objectEqualP(Stella_Object tree2) {
    { Cons tree1 = this;

      if (Stella_Object.safePrimaryType(tree2) == Stella.SGT_STELLA_CONS) {
        { Cons tree2000 = ((Cons)(tree2));

          while (!(tree1 == Stella.NIL)) {
            if (!Stella_Object.equalP(tree1.value, tree2000.value)) {
              return (false);
            }
            tree1 = tree1.rest;
            tree2000 = tree2000.rest;
          }
          return (tree2000 == Stella.NIL);
        }
      }
      else {
        return (false);
      }
    }
  }

  /** Just like <code>sort</code> but assumes each element of <code>self</code> has a <code>slot</code>
   * whose value will be used for comparison.  Elements must be descendants of
   * STANDARD OBJECT.  Note that while this will work with literal-valued slots,
   * it will cause value wrapping everytime <code>slot</code> is read.
   * @param slot
   * @param predicate
   * @return Cons
   */
  public Cons sortObjects(StorageSlot slot, java.lang.reflect.Method predicate) {
    { Cons self = this;

      if ((predicate == null) &&
          (!(self == Stella.NIL))) {
        predicate = Stella_Object.chooseSortPredicate(StandardObject.readSlotValue(((StandardObject)(self.value)), slot));
      }
      { Object old$SortTupleComparePredicate$000 = Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get();
        Object old$SortObjectsCompareSlot$000 = Stella.$SORT_OBJECTS_COMPARE_SLOT$.get();

        try {
          Native.setSpecial(Stella.$SORT_TUPLE_COMPARE_PREDICATE$, predicate);
          Native.setSpecial(Stella.$SORT_OBJECTS_COMPARE_SLOT$, slot);
          return (Cons.helpSortConsList(self, self.length(), Native.find_java_method("edu.isi.stella.Stella_Object", "sortObjectsCompareP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Stella_Object"), Native.find_java_class("edu.isi.stella.Stella_Object")})));

        } finally {
          Stella.$SORT_OBJECTS_COMPARE_SLOT$.set(old$SortObjectsCompareSlot$000);
          Stella.$SORT_TUPLE_COMPARE_PREDICATE$.set(old$SortTupleComparePredicate$000);
        }
      }
    }
  }

  /** Just like <code>sort</code> but assumes each element of <code>self</code> is a tuple (a cons)
   * whose <code>n</code>-th element (0-based) will be used for comparison.
   * @param n
   * @param predicate
   * @return Cons
   */
  public Cons sortTuples(int n, java.lang.reflect.Method predicate) {
    { Cons self = this;

      if ((predicate == null) &&
          (!(self == Stella.NIL))) {
        predicate = Stella_Object.chooseSortPredicate(((Cons)(self.value)).nth(n));
      }
      { Object old$SortTupleComparePredicate$000 = Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get();
        Object old$SortTupleCompareIndex$000 = Stella.$SORT_TUPLE_COMPARE_INDEX$.get();

        try {
          Native.setSpecial(Stella.$SORT_TUPLE_COMPARE_PREDICATE$, predicate);
          Native.setIntSpecial(Stella.$SORT_TUPLE_COMPARE_INDEX$, n);
          return (Cons.helpSortConsList(self, self.length(), Native.find_java_method("edu.isi.stella.Cons", "sortTupleCompareP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.Cons"), Native.find_java_class("edu.isi.stella.Cons")})));

        } finally {
          Stella.$SORT_TUPLE_COMPARE_INDEX$.set(old$SortTupleCompareIndex$000);
          Stella.$SORT_TUPLE_COMPARE_PREDICATE$.set(old$SortTupleComparePredicate$000);
        }
      }
    }
  }

  public static boolean sortTupleCompareP(Cons x, Cons y) {
    { int n = ((Integer)(Stella.$SORT_TUPLE_COMPARE_INDEX$.get())).intValue();
      java.lang.reflect.Method pred = ((java.lang.reflect.Method)(Stella.$SORT_TUPLE_COMPARE_PREDICATE$.get()));

      return (((Boolean)(edu.isi.stella.javalib.Native.funcall(pred, null, new java.lang.Object [] {x.nth(n), y.nth(n)}))).booleanValue());
    }
  }

  public static Cons mergeConsLists(Cons list1, Cons list2, java.lang.reflect.Method predicate) {
    { Cons cursor1 = list1;
      Cons cursor2 = list2;
      Cons result = Stella.NIL;
      Cons tail = Stella.NIL;
      Cons temp = Stella.NIL;

      for (;;) {
        if (cursor1 == Stella.NIL) {
          if (tail == Stella.NIL) {
            return (cursor2);
          }
          tail.rest = cursor2;
          return (result);
        }
        if (cursor2 == Stella.NIL) {
          if (tail == Stella.NIL) {
            return (cursor1);
          }
          tail.rest = cursor1;
          return (result);
        }
        if (((Boolean)(edu.isi.stella.javalib.Native.funcall(predicate, null, new java.lang.Object [] {cursor2.value, cursor1.value}))).booleanValue()) {
          temp = cursor2;
          cursor2 = cursor2.rest;
          list2 = cursor2;
        }
        else {
          temp = cursor1;
          cursor1 = cursor1.rest;
          list1 = cursor1;
        }
        if (tail == Stella.NIL) {
          result = temp;
        }
        else {
          tail.rest = temp;
        }
        tail = temp;
      }
    }
  }

  public static Cons helpSortConsList(Cons list, int length, java.lang.reflect.Method predicate) {
    if (length < 2) {
      return (list);
    }
    { int frontlength = Native.floor(length / 2.0);
      Cons temp = list;
      Cons back = Stella.NIL;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 2;
        int upperBound000 = frontlength;
        boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

        for (;unboundedP000 ||
                  (iter000 <= upperBound000); iter000 = iter000 + 1) {
          i = iter000;
          i = i;
          temp = temp.rest;
        }
      }
      back = temp.rest;
      temp.rest = Stella.NIL;
      return (Cons.mergeConsLists(Cons.helpSortConsList(list, frontlength, predicate), Cons.helpSortConsList(back, length - frontlength, predicate), predicate));
    }
  }

  /** Perform a stable, destructive sort of <code>self</code> according to
   * <code>predicate</code>, and return the result.  If <code>predicate</code> has a '&lt;' semantics, the
   * result will be in ascending order.  It is not guaranteed that <code>self</code> will
   * point to the beginning of the sorted result.  If <code>predicate</code> is <code>null</code>, a
   * suitable '&lt;' predicate is chosen depending on the first element of <code>self</code>,
   * and it is assumed that all elements of <code>self</code> have the same type (supported
   * element types are GENERALIZED-SYMBOL, STRING, INTEGER, and FLOAT).
   * @param predicate
   * @return Cons
   */
  public Cons sort(java.lang.reflect.Method predicate) {
    { Cons self = this;

      if (predicate == null) {
        predicate = Stella_Object.chooseSortPredicate(self.value);
      }
      return (Cons.helpSortConsList(self, self.length(), predicate));
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherlist</code> by destructively
   * removing elements from <code>self</code> that also occur in <code>otherlist</code>.  Uses an <code>eqlP</code>
   * test and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if <code>self</code> is a set.
   * @param otherlist
   * @return Cons
   */
  public Cons subtract(Cons otherlist) {
    { Cons self = this;

      if (otherlist == null) {
        return (self);
      }
      { Stella_Object i = null;
        Cons iter000 = otherlist;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = iter000.value;
          if (self.memberP(i)) {
            self = self.remove(i);
          }
        }
      }
      return (self);
    }
  }

  /** Return the set difference of <code>self</code> and <code>otherlist</code> (i.e., all elements
   * that are in <code>self</code> but not in <code>otherSet</code>).  Uses an <code>eqlP</code> test and a simple
   * quadratic-time algorithm.  Note that the result is only guaranteed to be a
   * set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return Cons
   */
  public Cons difference(Cons otherlist) {
    { Cons self = this;

      if ((otherlist == null) ||
          (otherlist == Stella.NIL)) {
        return (Cons.copyConsList(self));
      }
      { Cons diff = Stella.NIL;

        { Stella_Object i = null;
          Cons iter000 = self;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            i = iter000.value;
            if (!otherlist.memberP(i)) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(i, Stella.NIL);
                  if (diff == Stella.NIL) {
                    diff = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(diff, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(i, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        return (diff);
      }
    }
  }

  /** Return the set union of <code>self</code> and <code>otherlist</code>.  Uses an <code>eqlP</code> test
   * and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return Cons
   */
  public Cons union(Cons otherlist) {
    { Cons self = this;

      { Cons list = Cons.copyConsList(self);
        Cons othersurvivors = Stella.NIL;

        if (otherlist == null) {
          return (list);
        }
        { Stella_Object i = null;
          Cons iter000 = otherlist;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            i = iter000.value;
            if (!list.memberP(i)) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(i, Stella.NIL);
                  if (othersurvivors == Stella.NIL) {
                    othersurvivors = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(othersurvivors, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(i, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        return (list.concatenate(othersurvivors, Stella.NIL));
      }
    }
  }

  /** Return the set intersection of <code>self</code> and <code>otherlist</code>.  Uses an <code>eqlP</code>
   * test and a simple quadratic-time algorithm.  Note that the result is only
   * guaranteed to be a set if both <code>self</code> and <code>otherlist</code> are sets.
   * @param otherlist
   * @return Cons
   */
  public Cons intersection(Cons otherlist) {
    { Cons self = this;

      { Cons list = Stella.NIL;

        if (otherlist == null) {
          return (list);
        }
        { Stella_Object i = null;
          Cons iter000 = self;
          Cons collect000 = null;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            i = iter000.value;
            if (otherlist.memberP(i)) {
              if (collect000 == null) {
                {
                  collect000 = Cons.cons(i, Stella.NIL);
                  if (list == Stella.NIL) {
                    list = collect000;
                  }
                  else {
                    Cons.addConsToEndOfConsList(list, collect000);
                  }
                }
              }
              else {
                {
                  collect000.rest = Cons.cons(i, Stella.NIL);
                  collect000 = collect000.rest;
                }
              }
            }
          }
        }
        return (list);
      }
    }
  }

  /** Return true if the intersection of <code>self</code> and <code>otherlist</code> is empty.
   * This is always true if at least one of the two sets is the empty set.
   * Uses an <code>eqlP</code> test and a simple quadratic-time algorithm.  Note that
   * this does not check whether <code>self</code> and <code>otherlist</code> actually are sets.
   * @param otherlist
   * @return boolean
   */
  public boolean disjointSetsP(Cons otherlist) {
    { Cons self = this;

      { boolean alwaysP000 = true;

        { Stella_Object item = null;
          Cons iter000 = self;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            item = iter000.value;
            if (!(!otherlist.memberP(item))) {
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
  }

  /** Return true if every element of <code>self</code> occurs in <code>otherlist</code> and vice versa.
   * Uses an <code>eqlP</code> test and a simple quadratic-time algorithm.  Note that
   * this does not check whether <code>self</code> and <code>otherlist</code> actually are sets.
   * @param otherlist
   * @return boolean
   */
  public boolean equivalentSetsP(Cons otherlist) {
    { Cons self = this;

      { boolean testValue000 = false;

        testValue000 = self.length() == otherlist.length();
        if (testValue000) {
          { boolean alwaysP000 = true;

            { Stella_Object item = null;
              Cons iter000 = self;

              loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
                item = iter000.value;
                if (!otherlist.memberP(item)) {
                  alwaysP000 = false;
                  break loop000;
                }
              }
            }
            testValue000 = alwaysP000;
          }
        }
        { boolean value000 = testValue000;

          return (value000);
        }
      }
    }
  }

  /** Return true if every element of <code>self</code> also occurs in <code>otherlist</code>.
   * Uses an <code>eqlP</code> test and a simple quadratic-time algorithm.  Note that
   * this does not check whether <code>self</code> and <code>otherlist</code> actually are sets.
   * @param otherlist
   * @return boolean
   */
  public boolean subsetP(Cons otherlist) {
    { Cons self = this;

      { boolean alwaysP000 = true;

        { Stella_Object item = null;
          Cons iter000 = self;

          loop000 : for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            item = iter000.value;
            if (!otherlist.memberP(item)) {
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
  }

  /** Return a cons list representing the concatenation
   * of <code>conslist1</code> and <code>conslist2</code>.  The concatenation is NOT destructive.
   * @param conslist1
   * @param conslist2
   * @return Cons
   */
  public static Cons append(Cons conslist1, Cons conslist2) {
    if (conslist1 == Stella.NIL) {
      return (conslist2);
    }
    else if (conslist2 == Stella.NIL) {
      return (conslist1);
    }
    else {
      return (Cons.copyConsList(conslist1).concatenate(conslist2, Stella.NIL));
    }
  }

  /** Return a copy of the cons list <code>self</code>.
   * @param self
   * @return Cons
   */
  public static Cons copyConsList(Cons self) {
    if (self == Stella.NIL) {
      return (Stella.NIL);
    }
    { Cons newconslist = Cons.cons(self.value, Stella.NIL);
      Cons nextcons = newconslist;
      Cons copyfromcons = null;
      Cons previouscons = null;

      copyfromcons = self.rest;
      while (!(copyfromcons == Stella.NIL)) {
        previouscons = nextcons;
        nextcons = Cons.cons(copyfromcons.value, Stella.NIL);
        previouscons.rest = nextcons;
        copyfromcons = copyfromcons.rest;
      }
      return (newconslist);
    }
  }

  public Cons removeDeletedMembers() {
    { Cons self = this;

      { Cons cursor = self;
        Cons trailer = null;

        while (!(cursor == Stella.NIL)) {
          if (cursor.value.deletedP() &&
              (trailer != null)) {
            {
              trailer.rest = cursor.rest;
              cursor = trailer.rest;
            }
          }
          else {
            {
              trailer = cursor;
              cursor = cursor.rest;
            }
          }
        }
        if ((!(self == Stella.NIL)) &&
            self.value.deletedP()) {
          return (self.rest);
        }
        return (self);
      }
    }
  }

  /** Return <code>self</code>.
   * @return Cons
   */
  public Cons consify() {
    { Cons self = this;

      return (self);
    }
  }

  /** Generate all but the last element of the cons list <code>self</code>.
   * @return Iterator
   */
  public Iterator butLast() {
    { Cons self = this;

      { AllPurposeIterator iterator = AllPurposeIterator.newAllPurposeIterator();

        iterator.iteratorConsList = self;
        iterator.firstIterationP = true;
        iterator.iteratorNextCode = Native.find_java_method("edu.isi.stella.AllPurposeIterator", "butLastNextP", new java.lang.Class [] {Native.find_java_class("edu.isi.stella.AllPurposeIterator")});
        return (iterator);
      }
    }
  }

  public static void addConsToEndOfConsList(Cons self, Cons lastcons) {
    while (!(self.rest == Stella.NIL)) {
      self = self.rest;
    }
    self.rest = lastcons;
  }

  public ConsIterator allocateIterator() {
    { Cons self = this;

      { ConsIterator iterator = ConsIterator.newConsIterator();

        iterator.consIteratorCursor = self;
        iterator.firstIterationP = true;
        return (iterator);
      }
    }
  }

  public Stella_Object nthRestSetter(Stella_Object value, int position) {
    { Cons self = this;

      if (position <= 0) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't apply nth-rest setter to negative position `" + position + "'.");
      }
      { Cons cursor = self;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 2;
          int upperBound000 = position;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            cursor = cursor.rest;
            if (cursor == Stella.NIL) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: 'nth-rest setter' ran off end of cons list.");
              return (null);
            }
          }
        }
        cursor.rest = ((Cons)(value));
        return (value);
      }
    }
  }

  public Stella_Object fifthSetter(Stella_Object value) {
    { Cons self = this;

      return (self.nthSetter(value, 4));
    }
  }

  public Stella_Object fourthSetter(Stella_Object value) {
    { Cons self = this;

      return (self.nthSetter(value, 3));
    }
  }

  public Stella_Object nthSetter(Stella_Object value, int position) {
    { Cons self = this;

      if (position < 0) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't apply nth setter to negative position `" + position + "'.");
        return (null);
      }
      { Cons cursor = self;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = position;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            cursor = cursor.rest;
            if (cursor == Stella.NIL) {
              Stella.STANDARD_WARNING.nativeStream.println("Warning: 'nth setter' ran off end of cons list.");
              return (null);
            }
          }
        }
        cursor.value = value;
        return (value);
      }
    }
  }

  public Stella_Object thirdSetter(Stella_Object value) {
    { Cons self = this;

      { Cons thirdcons = self.rest.rest;

        if (!(thirdcons == Stella.NIL)) {
          return (thirdcons.value = value);
        }
        else {
          {
            Stella.STANDARD_WARNING.nativeStream.println("Warning: 'third setter' applied to too short cons list.");
            return (null);
          }
        }
      }
    }
  }

  public Stella_Object secondSetter(Stella_Object value) {
    { Cons self = this;

      if (self.rest == Stella.NIL) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: 'second setter' applied to too short cons list.");
        return (null);
      }
      return (self.rest.value = value);
    }
  }

  public Stella_Object firstSetter(Stella_Object value) {
    { Cons self = this;

      if (self == Stella.NIL) {
        Stella.STANDARD_WARNING.nativeStream.println("Warning: Can't apply first setter to empty list.");
        return (null);
      }
      return (self.value = value);
    }
  }

  /** Return the last element of <code>self</code>.
   * @return Stella_Object
   */
  public Stella_Object last() {
    { Cons self = this;

      return (Cons.lastCons(self).value);
    }
  }

  /** Return the last cons of <code>self</code>.
   * @param self
   * @return Cons
   */
  public static Cons lastCons(Cons self) {
    while (!(self.rest == Stella.NIL)) {
      self = self.rest;
    }
    return (self);
  }

  /** Apply <code>rest</code> <code>position</code> times to <code>self</code>.
   * @param position
   * @return Cons
   */
  public Cons nthRest(int position) {
    { Cons self = this;

      if (position < 0) {
        return (null);
      }
      { Cons cursor = self;

        { int i = Stella.NULL_INTEGER;
          int iter000 = 1;
          int upperBound000 = position;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;unboundedP000 ||
                    (iter000 <= upperBound000); iter000 = iter000 + 1) {
            i = iter000;
            i = i;
            cursor = cursor.rest;
            if (cursor == Stella.NIL) {
              return (Stella.NIL);
            }
          }
        }
        return (cursor);
      }
    }
  }

  /** Return the element of <code>self</code> at <code>position</code>.  The nth element
   * of <code>self</code> can be set with <code>setf</code>.  Note, that '(nth NIL &lt;pos&gt;)' = <code>null</code>.
   * @param position
   * @return Stella_Object
   */
  public Stella_Object nth(int position) {
    { Cons self = this;

      { int i = -1;

        { Stella_Object value = null;
          Cons iter000 = self;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            value = iter000.value;
            if ((i = i + 1) == position) {
              return (value);
            }
          }
        }
        return (null);
      }
    }
  }

  /** Return the fifth element of <code>self</code>.  The fifth element
   * of <code>self</code> can be set with <code>setf</code>.  Note, that '(fifth NIL)' = <code>null</code>.
   * @return Stella_Object
   */
  public Stella_Object fifth() {
    { Cons self = this;

      return (self.rest.rest.rest.rest.value);
    }
  }

  /** Return the fourth element of <code>self</code>.  The fourth element
   * of <code>self</code> can be set with <code>setf</code>.  Note that '(fourth NIL)' = <code>null</code>.
   * @return Stella_Object
   */
  public Stella_Object fourth() {
    { Cons self = this;

      return (self.rest.rest.rest.value);
    }
  }

  /** Return the third element of <code>self</code>.  The third element
   * of <code>self</code> can be set with <code>setf</code>.  Note that '(third NIL)' = <code>null</code>.
   * @return Stella_Object
   */
  public Stella_Object third() {
    { Cons self = this;

      return (self.rest.rest.value);
    }
  }

  /** Return the second element of <code>self</code>.  The second element
   * of <code>self</code> can be set with <code>setf</code>.  Note that '(second NIL)' = <code>null</code>.
   * @return Stella_Object
   */
  public Stella_Object second() {
    { Cons self = this;

      return (self.rest.value);
    }
  }

  /** Return the first element of <code>self</code>.  The first element
   * of <code>self</code> can be set with <code>setf</code>.  Note that '(first NIL)' = <code>null</code>.
   * @return Stella_Object
   */
  public Stella_Object first() {
    { Cons self = this;

      return (self.value);
    }
  }

  /** Return <code>nil</code> iff <code>self</code> is <code>null</code> or <code>self</code> otherwise.
   * @param self
   * @return Cons
   */
  public static Cons mapNullToNil(Cons self) {
    return (((self == null) ? Stella.NIL : self));
  }

  /** Destructively replace each appearance of <code>outvalue</code> by
   * <code>invalue</code> in the cons list <code>self</code>.
   * @param invalue
   * @param outvalue
   * @return Cons
   */
  public Cons substitute(Stella_Object invalue, Stella_Object outvalue) {
    { Cons self = this;

      { Cons cursor = self;

        while (!(cursor == Stella.NIL)) {
          if (Stella_Object.eqlP(cursor.value, outvalue)) {
            cursor.value = invalue;
          }
          cursor = cursor.rest;
        }
        return (self);
      }
    }
  }

  /** Destructively reverse the members of the cons list <code>self</code>.
   * @return Cons
   */
  public Cons reverse() {
    { Cons self = this;

      if (self == Stella.NIL) {
        return (self);
      }
      { Cons reversedconslist = self;
        Cons remainingconslist = reversedconslist.rest;
        Cons detachedcons = null;

        if (remainingconslist == Stella.NIL) {
          return (reversedconslist);
        }
        reversedconslist.rest = Stella.NIL;
        while (!(remainingconslist == Stella.NIL)) {
          detachedcons = remainingconslist;
          remainingconslist = remainingconslist.rest;
          detachedcons.rest = reversedconslist;
          reversedconslist = detachedcons;
        }
        return (reversedconslist);
      }
    }
  }

  /** Return a cons list consisting of the concatenation of
   * <code>list1</code> and <code>self</code>.  A copy of <code>list1</code> is prepended to <code>self</code>.  This
   * operation results in structure sharing of <code>self</code>; to avoid this, <code>self</code>
   * should not be pointed to by anything other than the tail of the prepended
   * copy.
   * @param list1
   * @return Cons
   */
  public Cons prepend(Cons list1) {
    { Cons self = this;

      if (list1 == Stella.NIL) {
        return (self);
      }
      { Cons copy1 = Cons.copyConsList(list1);

        copy1.concatenate(self, Stella.NIL);
        return (copy1);
      }
    }
  }

  /** Return a cons list consisting of the concatenation of 
   * <code>list1</code>, <code>list2</code>, and <code>otherlists</code>.  The operation is destructive wrt all
   * but the last list argument which is left intact.  The two mandatory
   * parameters allow us to optimize the common binary case by not relying on
   * the somewhat less efficient variable arguments mechanism.
   * @param list2
   * @param otherlists
   * @return Cons
   */
  public Cons concatenate(Cons list2, Cons otherlists) {
    { Cons list1 = this;

      if (list1 == Stella.NIL) {
        list1 = list2;
      }
      else {
        if (list2 == Stella.NIL) {
          list2 = list1;
        }
        else {
          Cons.lastCons(list1).rest = list2;
        }
      }
      if (otherlists.length() > 0) {
        { Cons list = null;
          Cons iter000 = otherlists;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            list = ((Cons)(iter000.value));
            if (!(list == Stella.NIL)) {
              if (!(list2 == Stella.NIL)) {
                Cons.lastCons(list2).rest = list;
              }
              else {
                list1 = list;
              }
              list2 = list;
            }
          }
        }
      }
      return (list1);
    }
  }

  public static Cons removeDuplicatesFromLongList(Cons self, boolean equaltestP) {
    { int tablesize = Native.ceiling(self.length() * 0.3);
      Cons[] table = new Cons[tablesize];
      Cons cursor = self;
      Stella_Object item = null;
      Cons bucket = null;
      int bucketindex = 0;

      { int i = Stella.NULL_INTEGER;
        int iter000 = 0;
        int upperBound000 = tablesize - 1;

        for (;iter000 <= upperBound000; iter000 = iter000 + 1) {
          i = iter000;
          table[i] = Stella.NIL;
        }
      }
      while (!(cursor == Stella.NIL)) {
        item = cursor.value;
        if (equaltestP) {
          bucketindex = item.equalHashCode();
        }
        else {
          bucketindex = item.hashCode_();
        }
        bucketindex = ((bucketindex & 0x7FFFFFFF) % tablesize);
        bucket = table[bucketindex];
        { boolean foundP000 = false;

          { Stella_Object it = null;
            Cons iter001 = bucket;

            loop002 : for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
              it = iter001.value;
              if ((equaltestP ? Stella_Object.equalP(it, item) : Stella_Object.eqlP(it, item))) {
                foundP000 = true;
                break loop002;
              }
            }
          }
          if (foundP000) {
            cursor.value = null;
          }
          else {
            table[bucketindex] = Cons.cons(item, bucket);
          }
        }
        cursor = cursor.rest;
      }
      return (self.remove(null));
    }
  }

  /** <code>removeDuplicates</code> (which see) using an <code>equalP</code> test.
   * IMPORTANT: since this uses hashing to speed things up, an <code>equalHashCode</code>
   * method needs to be defined for this to work.
   * @return Cons
   */
  public Cons removeDuplicatesEqual() {
    { Cons self = this;

      return (Cons.removeDuplicatesFromLongList(self, true));
    }
  }

  /** Destructively remove duplicates from <code>self</code> and return the
   * result.  Removes all but the first occurrence of items in the list.
   * Preserves the original order of the remaining members.  Runs in linear time.
   * @return Cons
   */
  public Cons removeDuplicates() {
    { Cons self = this;

      if (self.length() > Stella.$REMOVE_DUPLICATES_CROSSOVER_POINT$) {
        return (Cons.removeDuplicatesFromLongList(self, false));
      }
      else {
        { Cons cursor = self;
          Cons rest = null;

          while (!(cursor == Stella.NIL)) {
            rest = cursor.rest;
            if (rest.memberP(cursor.value)) {
              rest = rest.remove(cursor.value);
              cursor.rest = rest;
            }
            cursor = rest;
          }
          return (self);
        }
      }
    }
  }

  /** Destructively removes all members of the cons list
   * <code>self</code> for which <code>testP</code> evaluates to <code>true</code>.  <code>test</code> takes a single 
   * argument of type OBJECT and returns <code>true</code> or <code>false</code>.  Returns a cons list.
   * In case the first element is removed, the return result should be
   * assigned to a variable.
   * @param testP
   * @return Cons
   */
  public Cons removeIf(java.lang.reflect.Method testP) {
    { Cons self = this;

      { Cons cursor = self;
        Cons trailer = null;

        while (!(cursor == Stella.NIL)) {
          if (((Boolean)(edu.isi.stella.javalib.Native.funcall(testP, null, new java.lang.Object [] {cursor.value}))).booleanValue() &&
              (trailer != null)) {
            {
              trailer.rest = cursor.rest;
              cursor = trailer.rest;
            }
          }
          else {
            {
              trailer = cursor;
              cursor = cursor.rest;
            }
          }
        }
        cursor = self;
        if ((!(cursor == Stella.NIL)) &&
            ((Boolean)(edu.isi.stella.javalib.Native.funcall(testP, null, new java.lang.Object [] {cursor.value}))).booleanValue()) {
          trailer = cursor.rest;
          return (trailer);
        }
        return (self);
      }
    }
  }

  /** Destructively remove all entries in the cons list <code>self</code> that
   * match <code>value</code>.  Unless the remaining list is <code>nil</code>, insure that the cons that
   * heads the list is unchanged.
   * @param value
   * @return Cons
   */
  public Cons remove(Stella_Object value) {
    { Cons self = this;

      { Cons cons = self;
        Cons previouscons = null;

        if (!(cons == Stella.NIL)) {
          if (!(cons.rest == Stella.NIL)) {
            previouscons = cons;
            cons = cons.rest;
            while (!(cons == Stella.NIL)) {
              if (Stella_Object.eqlP(cons.value, value)) {
                {
                  previouscons.rest = cons.rest;
                  cons = cons.rest;
                }
              }
              else {
                {
                  previouscons = cons;
                  cons = cons.rest;
                }
              }
            }
          }
          if (Stella_Object.eqlP(self.value, value)) {
            if (self.rest == Stella.NIL) {
              return (Stella.NIL);
            }
            cons = self.rest;
            self.value = cons.value;
            self.rest = cons.rest;
          }
        }
        return (self);
      }
    }
  }

  /** Return <code>true</code> iff <code>renamed_Object</code> is a member of the cons list
   * <code>self</code> (uses an <code>eqP</code> test).
   * @param renamed_Object
   * @return boolean
   */
  public boolean membP(Stella_Object renamed_Object) {
    { Cons self = this;

      { Stella_Object i = null;
        Cons iter000 = self;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          i = iter000.value;
          if (i == renamed_Object) {
            return (true);
          }
        }
      }
      return (false);
    }
  }

  /** Return <code>true</code> iff <code>renamed_Object</code> is a member of the cons list
   * <code>self</code> (uses an <code>eqlP</code> test).
   * @param renamed_Object
   * @return boolean
   */
  public boolean memberP(Stella_Object renamed_Object) {
    { Cons self = this;

      if ((renamed_Object == null) ||
          renamed_Object.standardObjectP()) {
        { Stella_Object i = null;
          Cons iter000 = self;

          for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
            i = iter000.value;
            if (i == renamed_Object) {
              return (true);
            }
          }
        }
      }
      else {
        { Stella_Object i = null;
          Cons iter001 = self;

          for (;!(iter001 == Stella.NIL); iter001 = iter001.rest) {
            i = iter001.value;
            if (Stella_Object.eqlP(i, renamed_Object)) {
              return (true);
            }
          }
        }
      }
      return (false);
    }
  }

  /** Return the position of <code>renamed_Object</code> within the cons-list
   * <code>self</code> (counting from zero); or return <code>null</code> if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>start</code> was supplied as non-<code>null</code>, only 
   * consider the sublist ending at <code>end</code>, however, the returned position 
   * will always be relative to the entire list.
   * @param renamed_Object
   * @param end
   * @return int
   */
  public int lastPosition(Stella_Object renamed_Object, int end) {
    { Cons self = this;

      { int lastPos = Stella.NULL_INTEGER;

        if (end == Stella.NULL_INTEGER) {
          end = self.length() - 1;
        }
        { Stella_Object element = null;
          Cons iter000 = self;
          int position = Stella.NULL_INTEGER;
          int iter001 = 0;
          int upperBound000 = end;
          boolean unboundedP000 = upperBound000 == Stella.NULL_INTEGER;

          for (;(!(iter000 == Stella.NIL)) &&
                    (unboundedP000 ||
                     (iter001 <= upperBound000)); iter000 = iter000.rest, iter001 = iter001 + 1) {
            element = iter000.value;
            position = iter001;
            if (Stella_Object.eqlP(element, renamed_Object)) {
              lastPos = position;
            }
          }
        }
        return (lastPos);
      }
    }
  }

  /** Return the position of <code>renamed_Object</code> within the cons-list
   * <code>self</code> (counting from zero); or return <code>null</code> if <code>renamed_Object</code> does not occur within 
   * <code>self</code> (uses an <code>eqlP</code> test).  If <code>start</code> was supplied as non-<code>null</code>, only 
   * consider the sublist starting at <code>start</code>, however, the returned position 
   * will always be relative to the entire list.
   * @param renamed_Object
   * @param start
   * @return int
   */
  public int position(Stella_Object renamed_Object, int start) {
    { Cons self = this;

      if (start == Stella.NULL_INTEGER) {
        start = 0;
      }
      { Stella_Object element = null;
        Cons iter000 = self.nthRest(start);
        int position = Stella.NULL_INTEGER;
        int iter001 = start;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest, iter001 = iter001 + 1) {
          element = iter000.value;
          position = iter001;
          if (Stella_Object.eqlP(element, renamed_Object)) {
            return (position);
          }
        }
      }
      return (Stella.NULL_INTEGER);
    }
  }

  /** Return the length of the CONS list <code>self</code>.
   * @return int
   */
  public int length() {
    { Cons self = this;

      { Cons cons = self;
        int i = 0;

        while (!(cons == Stella.NIL)) {
          i = i + 1;
          cons = cons.rest;
        }
        return (i);
      }
    }
  }

  /** Return <code>true</code> iff <code>self</code> is not equal to <code>nil</code>.
   * @return boolean
   */
  public boolean nonEmptyP() {
    { Cons self = this;

      return (!(self == Stella.NIL));
    }
  }

  /** Return <code>true</code> iff <code>self</code> equals <code>nil</code>.
   * @return boolean
   */
  public boolean emptyP() {
    { Cons self = this;

      return (self == Stella.NIL);
    }
  }

  public static Cons listDirectoryFilesRecursivelyEvaluatorWrapper(Cons arguments) {
    return (Stella.listDirectoryFilesRecursively(((StringWrapper)(arguments.value)).wrapperValue));
  }

  public static Cons listDirectoryFilesEvaluatorWrapper(Cons arguments) {
    return (Stella.listDirectoryFiles(((StringWrapper)(arguments.value)).wrapperValue));
  }

  /** Converts (x y z) into a float.  The return value
   * is x + y/60 + z/3600.
   * This can be used to convert from Degree-Minute-Second to decimal degrees
   * or from Hour-Minute-Second format to decimal hours.
   * @param l
   * @return double
   */
  public static double base60ToFloat(Cons l) {
    { NumberWrapper dvalue = ((NumberWrapper)(l.value));
      NumberWrapper mvalue = ((NumberWrapper)(l.rest.value));
      NumberWrapper svalue = ((NumberWrapper)(l.rest.rest.value));
      double d = 0.0;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(dvalue);

        if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper dvalue000 = ((FloatWrapper)(dvalue));

            d = dvalue000.wrapperValue;
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper dvalue000 = ((IntegerWrapper)(dvalue));

            d = dvalue000.numberWrapperToFloat();
          }
        }
        else {
          { OutputStringStream stream000 = OutputStringStream.newOutputStringStream();

            stream000.nativeStream.print("`" + testValue000 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream000.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Surrogate testValue001 = Stella_Object.safePrimaryType(mvalue);

        if (Surrogate.subtypeOfFloatP(testValue001)) {
          { FloatWrapper mvalue000 = ((FloatWrapper)(mvalue));

            d = d + (mvalue000.wrapperValue / 60.0);
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue001)) {
          { IntegerWrapper mvalue000 = ((IntegerWrapper)(mvalue));

            d = d + (mvalue000.wrapperValue / 60.0);
          }
        }
        else {
          { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

            stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
          }
        }
      }
      { Surrogate testValue002 = Stella_Object.safePrimaryType(svalue);

        if (Surrogate.subtypeOfFloatP(testValue002)) {
          { FloatWrapper svalue000 = ((FloatWrapper)(svalue));

            d = d + (svalue000.wrapperValue / 3600.0);
          }
        }
        else if (Surrogate.subtypeOfIntegerP(testValue002)) {
          { IntegerWrapper svalue000 = ((IntegerWrapper)(svalue));

            d = d + (svalue000.wrapperValue / 3600.0);
          }
        }
        else {
          { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

            stream002.nativeStream.print("`" + testValue002 + "' is not a valid case option");
            throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
          }
        }
      }
      return (d);
    }
  }

  public static void setLogLevelEvaluatorWrapper(Cons arguments) {
    Stella.setLogLevel(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest.value);
  }

  public static void setLoggingParametersEvaluatorWrapper(Cons arguments) {
    Stella.setLoggingParameters(((StringWrapper)(arguments.value)).wrapperValue, arguments.rest);
  }

  public static Stella_Object withXmlTag(Cons tagAndStream, Cons body) {
    return (Cons.expandMarkupTagFunction(tagAndStream, body, true));
  }

  public static Stella_Object withHtmlTag(Cons tagAndStream, Cons body) {
    return (Cons.expandMarkupTagFunction(tagAndStream, body, false));
  }

  public static Cons expandMarkupTagFunction(Cons tagAndStream, Cons body, boolean xmlP) {
    { Stella_Object tag = tagAndStream.value;
      Symbol tagvar = null;
      String tagvalue = null;
      Stella_Object stream = tagAndStream.rest.value;
      Stella_Object eolargument = tagAndStream.rest.rest.value;
      boolean eolP = (eolargument != null) &&
          BooleanWrapper.coerceWrappedBooleanToBoolean(Stella_Object.coerceToBoolean(eolargument));

      if (body == Stella.NIL) {
        { Surrogate testValue000 = Stella_Object.safePrimaryType(tag);

          if (Surrogate.subtypeOfStringP(testValue000)) {
            { StringWrapper tag000 = ((StringWrapper)(tag));

              if (eolP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("<" + tag000.wrapperValue + ((xmlP ? "/>" : ">"))), Cons.cons(Stella.SYM_STELLA_EOL, Stella.NIL)), Stella.NIL)))));
              }
              else {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("<" + tag000.wrapperValue + ((xmlP ? "/>" : ">"))), Stella.NIL), Stella.NIL)))));
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_OBJECT)) {
            { Stella_Object tag000 = ((Stella_Object)(tag));

              if (eolP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tag000, Cons.cons(Cons.cons((xmlP ? StringWrapper.wrapString("/>") : StringWrapper.wrapString(">")), Cons.cons(Stella.SYM_STELLA_EOL, Stella.NIL)), Stella.NIL)))), Stella.NIL)))));
              }
              else {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tag000, Cons.cons(Cons.cons((xmlP ? StringWrapper.wrapString("/>") : StringWrapper.wrapString(">")), Stella.NIL), Stella.NIL)))), Stella.NIL)))));
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
      }
      else {
        { Surrogate testValue001 = Stella_Object.safePrimaryType(tag);

          if (Surrogate.subtypeOfStringP(testValue001)) {
            { StringWrapper tag000 = ((StringWrapper)(tag));

              tagvalue = tag000.wrapperValue;
              if (eolP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("<" + tagvalue + ">"), Stella.NIL), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("</" + Native.string_subsequence(tagvalue, 0, Native.string_position(tagvalue, ' ', 0)) + ">"), Cons.cons(Stella.SYM_STELLA_EOL, Stella.NIL)), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))));
              }
              else {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("<" + tagvalue + ">"), Stella.NIL), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.cons(StringWrapper.wrapString("</" + Native.string_subsequence(tagvalue, 0, Native.string_position(tagvalue, ' ', 0)) + ">"), Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))));
              }
            }
          }
          else if (Surrogate.subtypeOfSymbolP(testValue001)) {
            { Symbol tag000 = ((Symbol)(tag));

              if (eolP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tag000, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Stella.NIL)))), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("</"), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SUBSEQUENCE, Cons.cons(tag000, Cons.cons(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_POSITION, Cons.cons(tag000, Cons.cons(Cons.list$(Cons.cons(CharacterWrapper.wrapCharacter(' '), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(StringWrapper.wrapString(">"), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))));
              }
              else {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tag000, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Stella.NIL)))), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("</"), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SUBSEQUENCE, Cons.cons(tag000, Cons.cons(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_POSITION, Cons.cons(tag000, Cons.cons(Cons.list$(Cons.cons(CharacterWrapper.wrapCharacter(' '), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(StringWrapper.wrapString(">"), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL)))));
              }
            }
          }
          else if (Surrogate.subtypeOfP(testValue001, Stella.SGT_STELLA_OBJECT)) {
            { Stella_Object tag000 = ((Stella_Object)(tag));

              tagvar = Stella.gensym("TAG");
              if (eolP) {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(tagvar, Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(tag000, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tagvar, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Stella.NIL)))), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("</"), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SUBSEQUENCE, Cons.cons(tagvar, Cons.cons(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_POSITION, Cons.cons(tagvar, Cons.cons(Cons.list$(Cons.cons(CharacterWrapper.wrapCharacter(' '), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(StringWrapper.wrapString(">"), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))))), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL))))));
              }
              else {
                return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(tagvar, Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(tag000, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("<"), Cons.cons(tagvar, Cons.cons(Cons.cons(StringWrapper.wrapString(">"), Stella.NIL), Stella.NIL)))), Stella.NIL)))), Cons.cons(body.concatenate(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(stream, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("</"), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SUBSEQUENCE, Cons.cons(tagvar, Cons.cons(Cons.list$(Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_POSITION, Cons.cons(tagvar, Cons.cons(Cons.list$(Cons.cons(CharacterWrapper.wrapCharacter(' '), Cons.cons(IntegerWrapper.wrapInteger(0), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(StringWrapper.wrapString(">"), Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)))), Stella.NIL), Stella.NIL), Stella.NIL))))));
              }
            }
          }
          else {
            { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

              stream001.nativeStream.print("`" + testValue001 + "' is not a valid case option");
              throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
            }
          }
        }
      }
    }
  }

  /** Sets up an unwind-protected form which opens a network
   * socket stream to a host and port for input and output and closes it afterwards.
   * Separate variables as provided in the call are bound to the input and output
   * streams. Syntax is (WITH-NETWORK-STREAM (varIn varOut hostname port) body+)
   * @param binding
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withNetworkStream(Cons binding, Cons body) {
    { Symbol varIn = ((Symbol)(binding.value));
      Symbol varOut = ((Symbol)(binding.rest.value));

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.list$(Cons.cons(Cons.cons(varIn, Cons.list$(Cons.cons(Stella.SYM_STELLA_INPUT_STREAM, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.cons(varOut, Cons.list$(Cons.cons(Stella.SYM_STELLA_OUTPUT_STREAM, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNWIND_PROTECT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_MV_SETQ, Cons.cons(Cons.cons(varIn, Cons.cons(varOut, Stella.NIL)), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OPEN_NETWORK_STREAM, Cons.cons(binding.rest.rest.value, Cons.cons(Cons.cons(binding.fourth(), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(varIn, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(varIn, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(varOut, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(varOut, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  /** Sets up an unwind-protected form which opens a file for
   * output and closes it afterwards.  The stream for writing is bound to the
   * variable provided in the macro form.
   * Syntax is <code>_WITH_OUTPUT_FILE__var_filename_options$__bodyI_</code> where <code>options</code>
   * can be any that are legal for <code>openOutputFile</code> (which see).
   * @param binding
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withOutputFile(Cons binding, Cons body) {
    { Symbol var = ((Symbol)(binding.value));

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(var, Cons.list$(Cons.cons(Stella.SYM_STELLA_FILE_OUTPUT_STREAM, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNWIND_PROTECT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(var, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OPEN_OUTPUT_FILE, Cons.cons(binding.rest.value, Cons.cons(binding.rest.rest.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(var, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(var, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  /** Sets up an unwind-protected form which opens a file for
   * input and closes it afterwards.  The stream for reading is bound to the
   * variable provided in the macro form.
   * Syntax is <code>_WITH_INPUT_FILE__var_filename_options$__bodyI_</code> where <code>options</code>
   * can be any that are legal for <code>openInputFile</code> (which see).
   * @param binding
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object withInputFile(Cons binding, Cons body) {
    { Symbol var = ((Symbol)(binding.value));

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(var, Cons.list$(Cons.cons(Stella.SYM_STELLA_FILE_INPUT_STREAM, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNWIND_PROTECT, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PROGN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(var, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_OPEN_INPUT_FILE, Cons.cons(binding.rest.value, Cons.cons(binding.rest.rest.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Stella.NIL), Stella.NIL)))), Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(var, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_FREE, Cons.cons(var, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
    }
  }

  public static Stella_Object messageToString(Cons body) {
    { Cons messagearguments = Cons.formatStringMessageArguments(body, false);
      Symbol messagevar = Stella.localGensym("MESSAGE");

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_VRLET, Cons.cons(Cons.cons(Cons.cons(messagevar, Cons.list$(Cons.cons(Stella.SYM_STELLA_STRING, Cons.cons(Stella.SYM_STELLA_NULL, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$PRINTREADABLYp$, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SETQ, Cons.cons(messagevar, Cons.cons(Cons.cons(Cons.cons(Stella.SYM_STELLA_CONCATENATE, messagearguments.concatenate(Stella.NIL, Stella.NIL)), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(messagevar, Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Cons formatStringMessageArguments(Cons messagearguments, boolean trailingeolP) {
    { Cons formattedarguments = Cons.formatMessageArguments(messagearguments, trailingeolP);

      { ConsIterator it = formattedarguments.allocateIterator();

        while (it.nextP()) {
          { Surrogate testValue000 = Stella_Object.safePrimaryType(it.value);

            if (Surrogate.subtypeOfStringP(testValue000)) {
            }
            else if (Surrogate.subtypeOfP(testValue000, Stella.SGT_STELLA_LITERAL_WRAPPER)) {
              it.valueSetter(StringWrapper.wrapString(Native.stringify(it.value)));
            }
            else {
              if (it.value == Stella.SYM_STELLA_EOL) {
                it.valueSetter(StringWrapper.wrapString(Stella.EOL_STRING));
              }
              else {
                it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_STRINGIFY, Cons.cons(it.value, Cons.cons(Stella.NIL, Stella.NIL)))));
              }
            }
          }
        }
      }
      return (formattedarguments);
    }
  }

  public static Stella_Object evaluationError(Cons body) {
    { Symbol streamvar = Stella.localGensym("STREAM");

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OUTPUT_STRING_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("While evaluating '"), Cons.cons(Stella.SYM_STELLA_$EVALUATIONTREE$, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_WHEN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_DEFINEDp, Cons.cons(Stella.SYM_STELLA_$EVALUATIONPARENTTREE$, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(StringWrapper.wrapString("' inside '"), Cons.cons(Stella.SYM_STELLA_$EVALUATIONPARENTTREE$, Cons.cons(Stella.NIL, Stella.NIL))))), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(StringWrapper.wrapString("':"), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.formatMessageArguments(body, false).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL_EXCEPTION, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_EVALUATION_EXCEPTION, Cons.cons(Stella.KWD_MESSAGE, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_STRING, Cons.cons(streamvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))))));
    }
  }

  public static Stella_Object walkWarn(Cons body) {
    { Cons messagearguments = Cons.formatMessageArguments(Cons.formatWalkMessageArguments(body), false);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$PRINTREADABLYp$, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_SIGNAL_TRANSLATION_WARNING, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(Cons.cons(Stella.SYM_STELLA_SUPPRESS_WARNINGSp, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_ERROR_CONTEXT, Cons.cons(StringWrapper.wrapString(">> WARNING: "), Cons.cons(Stella.SYM_STELLA_STANDARD_WARNING, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_WARNING, Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(StringWrapper.wrapString(" "), Cons.cons(messagearguments.concatenate(Cons.list$(Cons.cons(StringWrapper.wrapString("."), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Stella_Object walkInform(Cons body) {
    { Cons messagearguments = Cons.formatMessageArguments(Cons.formatWalkMessageArguments(body), false);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$PRINTREADABLYp$, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_SIGNAL_TRANSLATION_NOTE, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(Cons.cons(Stella.SYM_STELLA_SUPPRESS_WARNINGSp, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_ERROR_CONTEXT, Cons.cons(StringWrapper.wrapString(">> NOTE: "), Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(StringWrapper.wrapString(" "), Cons.cons(messagearguments.concatenate(Cons.list$(Cons.cons(StringWrapper.wrapString("."), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Stella_Object walkError(Cons body) {
    { Cons messagearguments = Cons.formatMessageArguments(Cons.formatWalkMessageArguments(body), false);

      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SPECIAL, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_$PRINTREADABLYp$, Cons.cons(Stella.SYM_STELLA_TRUE, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.cons(Stella.SYM_STELLA_SIGNAL_TRANSLATION_ERROR, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_UNLESS, Cons.cons(Cons.cons(Stella.SYM_STELLA_SUPPRESS_WARNINGSp, Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_ERROR_CONTEXT, Cons.cons(StringWrapper.wrapString(">> ERROR: "), Cons.cons(Stella.SYM_STELLA_STANDARD_ERROR, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_ERROR, Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(StringWrapper.wrapString(" "), Cons.cons(messagearguments.concatenate(Cons.list$(Cons.cons(StringWrapper.wrapString("."), Cons.cons(Stella.SYM_STELLA_EOL, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))), Cons.cons(Stella.NIL, Stella.NIL)))))));
    }
  }

  public static Cons formatWalkMessageArguments(Cons messageargumentstree) {
    { ConsIterator it = messageargumentstree.allocateIterator();

      while (it.nextP()) {
        { Stella_Object item = it.value;

          if (Surrogate.subtypeOfSymbolP(Stella_Object.safePrimaryType(item))) {
            { Symbol item000 = ((Symbol)(item));

              if (!(item000 == Stella.EOL)) {
                it.valueSetter(Cons.list$(Cons.cons(Stella.SYM_STELLA_DE_UGLIFY_PARSE_TREE, Cons.cons(item000, Cons.cons(Stella.NIL, Stella.NIL)))));
              }
            }
          }
          else {
          }
        }
      }
    }
    return (messageargumentstree);
  }

  /** Specialized version of <code>signal</code> that throws a READ-EXCEPTION.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object signalReadError(Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL, Cons.cons(Stella.SYM_STELLA_READ_EXCEPTION, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Signal error message, placing non-string arguments in quotes.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object continuableError(Cons body) {
    body = Cons.formatMessageArguments(body, false);
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_JAVA) {
      if ((body.length() == 1) &&
          Stella_Object.isaP(body.value, Stella.SGT_STELLA_STRING_WRAPPER)) {
        return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR_MESSAGE_, Cons.cons(StringWrapper.wrapString(((StringWrapper)(body.value)).wrapperValue), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_JAVA, Cons.cons(StringWrapper.wrapString("Native.continuableError(error_message_)"), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))));
      }
      else {
        { Symbol streamvar = Stella.localGensym("STREAM");

          return (Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.cons(streamvar, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_NEW, Cons.cons(Stella.SYM_STELLA_OUTPUT_STRING_STREAM, Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL)), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(streamvar, Cons.cons(Cons.formatMessageArguments(body, false).concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_LET, Cons.cons(Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_ERROR_MESSAGE_, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_THE_STRING, Cons.cons(streamvar, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL)))), Stella.NIL), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_VERBATIM, Cons.cons(Stella.KWD_JAVA, Cons.cons(StringWrapper.wrapString("Native.continuableError(error_message_)"), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL)))))));
        }
      }
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.KWD_CONTINUABLE_ERROR, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
  }

  /** Signal error message, placing non-string arguments in quotes.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object error(Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_SIGNAL, Cons.cons(Stella.SYM_STELLA_STELLA_EXCEPTION, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** Signal warning message, placing non-string arguments in quotes.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object warn(Cons body) {
    body = Cons.formatMessageArguments(body, false);
    if (((Keyword)(Stella.$TRANSLATOROUTPUTLANGUAGE$.get())) == Stella.KWD_COMMON_LISP) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.KWD_WARN, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_WARNING, Cons.cons(StringWrapper.wrapString("Warning: "), Cons.cons(body.concatenate(Cons.cons(Stella.SYM_STELLA_EOL, Stella.NIL), Stella.NIL), Stella.NIL))))));
    }
  }

  /** Print informative message, placing non-string arguments in quotes,
   * and terminating with a newline.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object inform(Cons body) {
    body = Cons.formatMessageArguments(body, true);
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  /** (print-spaces [stream] N) prints N spaces onto stream.  If
   * no stream form is provided, then STANDARD-OUTPUT will be used.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object printSpaces(Cons body) {
    if (body.rest == Stella.NIL) {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(Stella.SYM_STELLA_I, Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTERVAL, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(body.value, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_I, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(StringWrapper.wrapString(" "), Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.NIL, Stella.NIL))))))))));
    }
    else {
      return (Cons.list$(Cons.cons(Stella.SYM_STELLA_FOREACH, Cons.cons(Stella.SYM_STELLA_I, Cons.cons(Stella.SYM_STELLA_IN, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_INTERVAL, Cons.cons(IntegerWrapper.wrapInteger(1), Cons.cons(body.rest.value, Cons.cons(Stella.NIL, Stella.NIL))))), Cons.cons(Stella.SYM_STELLA_DO, Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_IGNORE, Cons.cons(Stella.SYM_STELLA_I, Cons.cons(Stella.NIL, Stella.NIL)))), Cons.cons(Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(body.value, Cons.cons(Cons.cons(StringWrapper.wrapString(" "), Stella.NIL), Stella.NIL)))), Cons.cons(Stella.NIL, Stella.NIL))))))))));
    }
  }

  /** Print arguments to the standard output stream.
   * @param body
   * @return Stella_Object
   */
  public static Stella_Object print(Cons body) {
    return (Cons.list$(Cons.cons(Stella.SYM_STELLA_PRINT_STREAM, Cons.cons(Stella.SYM_STELLA_STANDARD_OUTPUT, Cons.cons(body.concatenate(Stella.NIL, Stella.NIL), Stella.NIL)))));
  }

  public static Cons formatMessageArguments(Cons messageargumentstree, boolean trailingeolP) {
    { Cons augmentedarguments = Stella.NIL;

      { Stella_Object item = null;
        Cons iter000 = messageargumentstree;

        for (;!(iter000 == Stella.NIL); iter000 = iter000.rest) {
          item = iter000.value;
          if (Stella_Object.stringP(item) ||
              (item == Stella.EOL)) {
            augmentedarguments = Cons.cons(item, augmentedarguments);
          }
          else {
            augmentedarguments = Cons.cons(Stella.SINGLE_BQUOTE_STRING, augmentedarguments);
            augmentedarguments = Cons.cons(item, augmentedarguments);
            augmentedarguments = Cons.cons(Stella.SINGLE_QUOTE_STRING, augmentedarguments);
          }
        }
      }
      if (trailingeolP) {
        augmentedarguments = Cons.cons(Stella.EOL, augmentedarguments);
      }
      return (augmentedarguments.reverse());
    }
  }

  public void printObject(edu.isi.stella.javalib.NativeOutputStream stream) {
    { Cons self = this;

      Cons.printCons(self, stream, "(", ")");
    }
  }

  public static Stella_Object accessConsSlotValue(Cons self, Symbol slotname, Stella_Object value, boolean setvalueP) {
    if (slotname == Stella.SYM_STELLA_VALUE) {
      if (setvalueP) {
        self.value = value;
      }
      else {
        value = self.value;
      }
    }
    else if (slotname == Stella.SYM_STELLA_REST) {
      if (setvalueP) {
        self.rest = ((Cons)(value));
      }
      else {
        value = self.rest;
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
    { Cons self = this;

      return (Stella.SGT_STELLA_CONS);
    }
  }

}

