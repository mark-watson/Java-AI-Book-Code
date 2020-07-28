// -*- Mode: Java -*-

/*--------------------------- BEGIN LICENSE BLOCK ---------------------------+
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
| Portions created by the Initial Developer are Copyright (C) 1996-2014      |
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
+---------------------------- END LICENSE BLOCK ----------------------------*/

// Version: Native.java,v 1.63 2014/07/02 06:22:30 hans Exp

// Native Java stuff for STELLA


package edu.isi.stella.javalib;

import edu.isi.stella.*;
import java.io.*;
import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class Native {

  public static boolean $BREAK_ON_CERROR$ = true;
  public static java.util.Random RNG = new java.util.Random();

    //
  ///// 'null?' and 'defined?':
   //
  // NOTE: 'definedP' and 'nullP' really aren't called anymore, since they
  //       get translated directly into '==' tests by the Java translator.


    //
  ///// Arithmetic functions
   //

  public static int ceiling(int n) {
    return n;
  }
  public static int ceiling(double n) {
    return (int) Math.ceil(n);
  }

  public static int floor (int n) {
    return n;
  }

  public static int floor (double n) {
    return (int) Math.floor(n);
  }

  public static int round (int n) {
    return n;
  }

  public static int round (double n) {
    return (int) Math.round(n);
  }

  public static int truncate (int n) {
    return n;
  }

  public static int truncate (double n) {
    return (int) n;
  }


  public static double exp (double n) {
    return Math.exp(n);
  }


    //
  ///// Character library functions
   //

    //
  ///// String library functions
   //

  public static String makeString(int size, char initialElement) {
    StringBuffer newstring = new StringBuffer (size);
    newstring.setLength(size);
    for (int i = 0; i< size; i++) {
      newstring.setCharAt (i, initialElement);
    }
    return newstring.toString();
  }

  public static StringBuffer makeMutableString(int size, char initialElement) {
    StringBuffer newstring = new StringBuffer (size);
    newstring.setLength(size);
    for (int i = 0; i< size; i++) {
      newstring.setCharAt (i, initialElement);
    }
    return newstring;
  }

  public static String stringConcatenate(String string1, String string2) {
    return string1 + string2;
  }

  public static String stringUpcase(String string) {
    // Return an upper-case copy of 'string'.
    return string.toUpperCase();
  }

  public static String stringDowncase(String string) {
    // Return a lower-case copy of 'string'.
    return string.toLowerCase();
  }

  public static String stringCapitalize(String string) {
    // Return a capitalized version of 'string'.
    // Titlecase first character and characters after non-letter characters.
    StringBuffer newstring = new StringBuffer(stringDowncase(string));
    boolean capitalizeFlag = true;
    for (int i = 0; i < newstring.length(); i++) {
      if (!(Character.isLetter(newstring.charAt(i)))) {
	capitalizeFlag = true; 
      } else if (capitalizeFlag) {
	newstring.setCharAt(i,Character.toTitleCase(newstring.charAt(i)));
	capitalizeFlag = false;
      }
    }
    return newstring.toString();
  }

  public static String string_copy(String string) {
    return new String (string);
  }

  public static String string_remove (String s, char c) {
    // Return string 's' with all instances of character 'c' removed.
    // If character 'c' doesn't appear in string 's', then 's' is returned.
    if (s.indexOf(c) == -1) {
      return s;
    }
    else {
      char [] original = s.toCharArray();
      char [] culled = new char [s.length()];
      int j = 0;
      for (int i = 0; i < s.length(); i++) {
	if (original[i] != c) {
	  culled[j] = original[i];
	  j++;
	}
      }
      return new String(culled, 0, j);
    }
  }

  public static String string_substitute(String self, char newchar, char oldchar) {
    return self.replace(oldchar, newchar);
  }

  public static StringBuffer mutableString_substitute
    (StringBuffer self, char newchar, char oldchar) {
    for (int i = 0; i < self.length(); i++) {
      if (self.charAt(i) == oldchar) {
	self.setCharAt(i, newchar);
      }
    }
    return self;
  }

  public static boolean string_memberP(String self, char character) {
    return -1 != self.indexOf(character);
  }

  // throws IndexOutOfBoundsException    ??
  public static char mutableString_nthSetter (StringBuffer self, char c, int pos) {
    self.setCharAt(pos, c);
    return c;
  }

  public static String string_rest(String self) {
    // Return pointer to second character.
    return self.substring(1);
  }

  public static int string_position(String string, char character, int start) {
    // Return the position of 'character' within 'string' (counting
    // from zero), or return NULL if 'character' does not occur within 'string'.
    // If 'start' was supplied as non-NULL, only consider the substring starting
    // at 'start', however, the returned position will always be relative to the
    // entire string.

    int pos;
    if (start == Stella.NULL_INTEGER) {
      pos = string.indexOf(character);
    }
    else {
      pos = string.indexOf(character, start);
    }

    if (pos == -1) {
      return Stella.NULL_INTEGER;
    }
    else {
      return pos;
    }
  }

  public static int string_lastPosition(String string, char character, int end) {
    // Return the last position of 'character' within 'string' (counting
    // from zero), or return NULL if 'character' does not occur within 'string'.
    // If 'end' was supplied as non-NULL, only consider the substring ending
    // at 'end', however, the returned position will always be relative to the
    // entire string.

    int pos;
    if (end == Stella.NULL_INTEGER) {
      pos = string.lastIndexOf(character);
    }
    else {
      pos = string.lastIndexOf(character, end);
    }

    if (pos == -1) {
      return Stella.NULL_INTEGER;
    }
    else {
      return pos;
    }
  }


  public static int stringSearch(String string, String substring, int start) {
    // Return start position of the left-most occurrence right of
    // 'start' of 'substring' in 'string'.  Return NULL if it is not 
    // a substring.

    int pos;
    if (start == Stella.NULL_INTEGER) {
      pos = string.indexOf(substring);
    } else {
      pos = string.indexOf(substring, start);
    }
    if (pos > -1) {
      return pos;
    } else {
      return Stella.NULL_INTEGER;
    }
  }

  public static String string_subsequence(String string, int start, int end) {
    // Return a substring of 'string' beginning at position 'start'
    // and ending up to but not including position 'end', counting from zero.  
    // An 'end' value of NULL stands for the rest of the string.
    if (end == Stella.NULL_INTEGER) {
      return string.substring(start);
    } else {
      return string.substring(start, end);
    }
  }

  public static String mutableString_subsequence(StringBuffer string, int start, int end) {
    // Return a substring of 'string' beginning at position 'start'
    // and ending up to but not including position 'end', counting from zero.  
    // An 'end' value of NULL stands for the rest of the string.
    if (end == Stella.NULL_INTEGER) {
      return string.substring(start);
    } else {
      return string.substring(start, end);
    }
  }

  
//  Converting to and from string representations:


  // Common code for normal stringify (which is always printed readably) and
  // the stringify generated by the translator for print functions in Java.

  public static String stringify_via_print(Stella_Object expression) {
    NativeStringOutputStream ss = NativeStringOutputStream.create();
    expression.printObject(ss);
    return ss.toString();
  }

  public static String stringify(Stella_Object expression) {
    if (expression == null) {
      return "NULL";
    }
    String newstring;
    Object old_printreadablyp = Stella.$PRINTREADABLYp$.get();
    Object old_printprettyp = Stella.$PRINTPRETTYp$.get();
    try {
      Stella.$PRINTREADABLYp$.set(Boolean.TRUE);
      Stella.$PRINTPRETTYp$.set(Boolean.FALSE);
      newstring = stringify_via_print(expression);
    }
    finally {
      Stella.$PRINTREADABLYp$.set(old_printreadablyp);
      Stella.$PRINTPRETTYp$.set(old_printprettyp);
    }
    return newstring;
  }

// **************************************************

  public static String integerToString(long i) {
    return Long.toString(i);
  }

  public static String integerToHexString(long i) {
    return Long.toHexString(i);
  }

  public static String integerToStringInBase(long i, int base) {
    return Long.toString(i, base);
  }

  public static String floatToString(double f) {
    return Double.toString(f);
  }

  public static String formatFloat (double v, int n) {
    // TO DO: allocate this formatter in a thread-local cache
    final java.text.DecimalFormat formatter = new java.text.DecimalFormat();
    formatter.setMinimumFractionDigits(n);
    formatter.setMaximumFractionDigits(n);
    formatter.setGroupingUsed(false);                          // match what Lisp is doing
    formatter.setRoundingMode(java.math.RoundingMode.HALF_UP); // match better what Lisp is doing
    return formatter.format(v);
  }


  //  throws NumberFormatException    ??
  public static long stringToInteger(String string) {
    return Long.parseLong(string);
  }

  public static double stringToFloat(String string) {
    return Double.valueOf(string).doubleValue();
  }


    //
  ///// Stream operations
   //

  public static NativeFileInputStream openInputFileStream(String filename) {
      return NativeFileInputStream.open(filename);
  }

  public static NativeFileOutputStream openOutputFileStream(String filename, boolean append) {
      return NativeFileOutputStream.open(filename, append);
  }

  public static String readLine(NativeInputStream stream) {
    // Create a new encapsulated stream that knows how to read lines of text.
    try {
        return stream.getReader().readLine();
    }
    catch (IOException e) {
      throw (InputOutputException) InputOutputException.newInputOutputException("readLine: " + e.getMessage()).fillInStackTrace();
    }
  }

  public static char readCharacter(NativeInputStream stream, Stella_Object [] return_values) {
    int return_int;
    char return_char;

    try {
      stream.getReader().mark(1); // for the benefit of `unreadCharacter'
      return_int = stream.getReader().read();
      //  The read method returns -1 on EOF rather than throwing an exception:
      if (return_int == -1) {
	return_char = Stella.NULL_CHARACTER;
	return_values[0] = Stella.TRUE_WRAPPER;
      }
      else {
        // int-to-char cast produces ISO-8859-1 characters, so we are already good here:
	return_char = (char) return_int;
	return_values[0] = Stella.FALSE_WRAPPER;
      }
    }
    catch (IOException e) {
      throw (InputOutputException) InputOutputException.newInputOutputException("readCharacter: " + e.getMessage()).fillInStackTrace();
    }

    return return_char;
  }

  public static void unreadCharacter(char c, NativeInputStream stream) {
    try {
      stream.getReader().reset();
    }
    catch (IOException e) {
      throw (InputOutputException) InputOutputException.newInputOutputException("unreadCharacter: " + e.getMessage()).fillInStackTrace();
    }
  }

    //
  ///// File operations
   //

  public static boolean nativeProbeFileP(String filename) {
    return (new File(filename)).exists();
  }

  public static CalendarDate nativeFileWriteDate(String filename) {
    return CalendarDate.nativeDateTimeToCalendarDate ((new File(filename)).lastModified());
  }

  public static long nativeFileLength(String filename) {
    return (new File(filename)).length();
  }

  public static void nativeDeleteFile(String filename) {
    (new File(filename)).delete();
  }

  public static void nativeRenameFile(String fromfile, String tofile) {
    (new File(fromfile)).renameTo(new File(tofile));
  }


    //
  ///// Exception-handling support
   //

  public static void rethrowAsStellaException(Exception e, 
                                              Class stellaExceptionType, 
                                              String messagePrefix,
                                              boolean stackTrace) {
      // Convenience method to map a Java exception `e' that needs to be
      // caught or declared onto a STELLA runtime exception of type
      // `stellaExceptionType'.  If non-null, prepend `messagePrefix'
      // to the exception message; also, fill in stack trace if
      // `stackTrace' is true.
      RuntimeException stellaException = null;
      String message = messagePrefix;
      if (message == null) message = "";
      message += e.getMessage();
      if (stackTrace) message += "\n";
      
      try {
          java.lang.reflect.Constructor constructor = 
              stellaExceptionType.getConstructor(new Class[]{String.class});
          stellaException = (RuntimeException)constructor.newInstance(new Object[]{message});
      }
      catch (Exception ex) {
          // instantiation problem, use a generic StellaException:
          stellaException = new StellaException(message);
      }
      if (stackTrace)
          stellaException.fillInStackTrace();
      throw stellaException;
  }


    //
  ///// Funcall support
   //

  public static Cons arrayToCons (Stella_Object [] a) {
    Cons c = Stella.NIL;
    for (int i = a.length - 1; i >= 0; i--) {
      c = Cons.cons(a[i],c);
    }
    return c;
  }

  public static Cons arrayToCons (Stella_Object [][] a) {
    Cons c = Stella.NIL;
    for (int i = a.length - 1; i >= 0; i--) {
      c = Cons.cons(arrayToCons(a[i]),c);
    }
    return c;
  }


  public static Object [] consToArray (Cons c) {
    int i = 0;
    Object [] arr = new Object [c.length()];
    Cons iter_000 = c;

    while (!(iter_000 == Stella.NIL)) {
      arr[i] = iter_000.value;
      i++;
      iter_000 = iter_000.rest;
    }
    return arr;
  }

  public static Object [][] consToArrayArray (Cons c) {
    int i = 0;
    Object [] arr = new Object[c.length()];
    Cons iter_000 = c;

    while (!(iter_000 == Stella.NIL)) {
      arr[i] = consToArray((Cons)iter_000.value);
      i++;
      iter_000 = iter_000.rest;
    }
    return (Object [][])arr;
  }


  public static String formatArguments (Object [] argArray) {
    // Formats the arguments in argArray.
    StringBuffer args = new StringBuffer(" (");
    for (int i = 0; i < argArray.length; i++) {
      if (i != 0) {
	args.append(", ");
      }
      args.append(argArray[i]);
    }
    args.append(")");
    return args.toString();
  }

  public static String formatArgumentTypes (Object [] argArray) {
    // Formats the arguments in argArray.
    StringBuffer args = new StringBuffer(" (");
    for (int i = 0; i < argArray.length; i++) {
      if (i != 0) {
	args.append(", ");
      }
      args.append(argArray[i].getClass());
    }
    args.append(")");
    return args.toString();
  }
       

  public static Object funcall (java.lang.reflect.Method x, Stella_Object y, Object [] z) {
    // Wrapped to catch and transform errors.
    try {
      return  x.invoke(y,z);
    }
    catch (IllegalAccessException e) {
      if (y == null) {
	throw (StellaException) StellaException.newStellaException("Illegal Java Access in funcall of function:\n  "
								   + x + formatArguments(z)).fillInStackTrace();
      }
      else {
	throw (StellaException) StellaException.newStellaException("Illegal Java Access in funcall of:\n  "
								   + x + " on " + y + formatArguments(z)).fillInStackTrace();
      }
    }
    catch (IllegalArgumentException e) {
      if (y == null) {
	throw (StellaException) BadArgumentException.newBadArgumentException("Illegal Java Arguments in funcall of function:\n  "
								   + x + formatArguments(z)
								   + "\n  of types " + formatArgumentTypes(z)).fillInStackTrace();
      }
      else {
	throw (StellaException) BadArgumentException.newBadArgumentException("Illegal Java Arguments in funcall of:\n  " 
								   + x + " on " + y + formatArguments(z)
								   + "\n  of types " + formatArgumentTypes(z)).fillInStackTrace();
      }
    }
    catch (java.lang.reflect.InvocationTargetException e) {
      // Pass Stella Exceptions through to the funcaller:
      if (e.getTargetException() instanceof StellaException) {
	throw (StellaException) e.getTargetException();
      // and generate a new stella exception for the others:
      }
      NativeStringOutputStream msg = NativeStringOutputStream.create();
      if (y == null) {
	msg.println("Invocation Target Exception in funcall of function:");
        msg.println("    " + x + formatArguments(z));
      }
      else {
	msg.println("Invocation Target Exception in funcall of:");
        msg.println("    " + x + " on " + y + formatArguments(z));
      }
      msg.println("    " + e.getTargetException());
      msg.println("    " + e.getTargetException().getMessage());
      e.getTargetException().printStackTrace(msg);
      String errorMessage = msg.toString();
      msg.close();
      throw  (StellaException) StellaException.newStellaException(errorMessage).fillInStackTrace();
    }
  }

  public static Class find_java_class (String className) {
    try {
      return Class.forName(className);
    }
    catch (ClassNotFoundException e) {
      throw (NoSuchObjectException) NoSuchObjectException.newNoSuchObjectException ("Can't find class `" + className + "' in find_java_class").fillInStackTrace();
    }
  }


  public static java.lang.reflect.Method find_java_method 
  (String className, String methodName, Class [] parameterTypes) {
    java.lang.reflect.Method theMethod;
    try {
      //      return Class.forName(className).getMethod(methodName, parameterTypes);
      theMethod = Class.forName(className).getDeclaredMethod(methodName, parameterTypes);
      theMethod.setAccessible(true);  // Make it callable from outside package.
      return theMethod;
    }
    catch (ClassNotFoundException e) {
      throw (NoSuchObjectException) NoSuchObjectException.newNoSuchObjectException ("Can't find class `" + className + "' in find_java_method").fillInStackTrace();
    }
    catch (NoSuchMethodException e) {
      StringBuffer params = new StringBuffer(" [");
      for (int i = 0; i < parameterTypes.length; i++) {
	if (i != 0) {
	  params.append(", ");
	}
	params.append(parameterTypes[i]);
	  }
      params.append("]");

      throw (NoSuchObjectException) NoSuchObjectException.newNoSuchObjectException ("Can't find method `" + methodName + "' on `" + className + "' for " + params + " in find_java_method").fillInStackTrace();
    }
  }

    //
  ///// Timing functions
   //

  public static long getTicktock () {
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    if (bean.isCurrentThreadCpuTimeSupported()) {
      return bean.getCurrentThreadCpuTime();
    } else {
      return java.lang.System.currentTimeMillis();
    }
  }

  public static double ticktockDifference (long t1, long t2) {
    // The difference in two TICKTOCK time values in seconds.
    // The resolution is implementation dependent but will normally be some fractional
    // value of a second.
    return (t2 - t1) * ticktockResolution();
  }

  public static double ticktockResolution () {
    // The minimum theoretically detectable resolution of the
    // difference in two TICKTOCK time values in seconds.  This resolution is
    // implementation dependent.  It may also not be realizable in practice, since
    // the timing grain size may be larger than this resolution.
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    return bean.isCurrentThreadCpuTimeSupported() ? 1.0e-9 : 1.0e-3;
  }


    //
  ///// Thread-safe special Variable stuff:
   //

  // A series of functions for setting special variables and returning
  // the values so that the setting functions can be used in expressions.
  // Includes one for objects in general, and others for literals:

  public static Object setSpecial(ThreadLocal special, Object value) {
    special.set(value);
    return value;
  }

  public static int setIntSpecial(ThreadLocal special, int value) {
    special.set(new Integer(value));
    return value;
  }

  public static long setLongSpecial(ThreadLocal special, long value) {
    special.set(new Long(value));
    return value;
  }
  
  public static char setCharSpecial(ThreadLocal special, char value) {
    special.set(new Character(value));
    return value;
  }

  public static double setDoubleSpecial(ThreadLocal special, double value) {
    special.set(new Double(value));
    return value;
  }

  public static float setFloatSpecial(ThreadLocal special, float value) {
    special.set(new Float(value));
    return value;
  }

  public static boolean setBooleanSpecial(ThreadLocal special, boolean value) {
    if (value) {
      special.set(Boolean.TRUE);
    } else {
      special.set(Boolean.FALSE);
      }
    return value;
  }

  public static Object getSpecial(ThreadLocal special) {
    return special.get();
  }

  public static int getIntSpecial(ThreadLocal special) {
    Integer value = (Integer) special.get();
    return (value == null) ? Stella.NULL_INTEGER : value.intValue();
  }

  public static long getLongSpecial(ThreadLocal special) {
    Long value = (Long) special.get();
    return (value == null) ? Stella.NULL_LONG_INTEGER : value.longValue();
  }

  public static char getCharSpecial(ThreadLocal special) {
    Character value = (Character) special.get();
    return (value == null) ? Stella.NULL_CHARACTER : value.charValue();
  }

  public static double getDoubleSpecial(ThreadLocal special) {
    Double value = (Double) special.get();
    return (value == null) ? Stella.NULL_FLOAT : value.doubleValue();
  }

  public static float getFloatSpecial(ThreadLocal special) {
    Float value = (Float) special.get();
    return (value == null) ? Stella.NULL_SINGLE_FLOAT : value.floatValue();
  }

  public static boolean getBooleanSpecial(ThreadLocal special) {
    return (special.get() == Boolean.TRUE);
  }


    //
  ///// Errors
   //

  public static void continuableError (String message) {
    if ($BREAK_ON_CERROR$) {
      throw (StellaException) StellaException.newStellaException(message).fillInStackTrace();
    } else {
      System.err.println(message);
    }
  }

    //
  ///// Startup
   //

  public static void startupJavaNative() {
    // Do this one phase after :symbols, so we'll be sure everything is ready:
    // Currently an empty function.
  }

}


