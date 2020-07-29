//  -*- Mode: Java -*-
//
// NumberWrapper.java

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

public abstract class NumberWrapper extends LiteralWrapper {
  public static NumberWrapper coerceNumericConstant(NumberWrapper constant, Surrogate type) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(constant);

      if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper constant000 = ((IntegerWrapper)(constant));

          if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_FLOAT)) {
            return (FloatWrapper.wrapFloat(Stella_Object.coerceToFloat(constant000)));
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_INTEGER)) {
            return (constant000);
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_LONG_INTEGER)) {
            return (Stella.wrapLongInteger(((long)(constant000.wrapperValue))));
          }
        }
      }
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper constant000 = ((LongIntegerWrapper)(constant));

          if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_FLOAT)) {
            return (FloatWrapper.wrapFloat(Stella_Object.coerceToFloat(constant000)));
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_INTEGER)) {
            return (IntegerWrapper.wrapInteger(((int)(constant000.wrapperValue))));
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_LONG_INTEGER)) {
            return (constant000);
          }
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper constant000 = ((FloatWrapper)(constant));

          if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_FLOAT)) {
            return (constant000);
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_INTEGER)) {
            return (IntegerWrapper.wrapInteger(((int)(constant000.wrapperValue))));
          }
          else if (Surrogate.subtypeOfP(type, Stella.SGT_STELLA_LONG_INTEGER)) {
            return (Stella.wrapLongInteger(((long)(constant000.wrapperValue))));
          }
        }
      }
      else {
      }
    }
    return (constant);
  }

  /** Generic number comparison that works with integers, longs and floats.
   * @param x
   * @param y
   * @return boolean
   */
  public static boolean numberLessThanP(NumberWrapper x, NumberWrapper y) {
    { Surrogate testValue000 = Stella_Object.safePrimaryType(x);

      if (Surrogate.subtypeOfIntegerP(testValue000)) {
        { IntegerWrapper x000 = ((IntegerWrapper)(x));

          { Surrogate testValue001 = Stella_Object.safePrimaryType(y);

            if (Surrogate.subtypeOfFloatP(testValue001)) {
              { FloatWrapper y000 = ((FloatWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfLongIntegerP(testValue001)) {
              { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfIntegerP(testValue001)) {
              { IntegerWrapper y000 = ((IntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
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
      else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
        { LongIntegerWrapper x000 = ((LongIntegerWrapper)(x));

          { Surrogate testValue002 = Stella_Object.safePrimaryType(y);

            if (Surrogate.subtypeOfFloatP(testValue002)) {
              { FloatWrapper y000 = ((FloatWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfLongIntegerP(testValue002)) {
              { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfIntegerP(testValue002)) {
              { IntegerWrapper y000 = ((IntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else {
              { OutputStringStream stream001 = OutputStringStream.newOutputStringStream();

                stream001.nativeStream.print("`" + testValue002 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream001.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else if (Surrogate.subtypeOfFloatP(testValue000)) {
        { FloatWrapper x000 = ((FloatWrapper)(x));

          { Surrogate testValue003 = Stella_Object.safePrimaryType(y);

            if (Surrogate.subtypeOfFloatP(testValue003)) {
              { FloatWrapper y000 = ((FloatWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfLongIntegerP(testValue003)) {
              { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else if (Surrogate.subtypeOfIntegerP(testValue003)) {
              { IntegerWrapper y000 = ((IntegerWrapper)(y));

                return (x000.wrapperValue < y000.wrapperValue);
              }
            }
            else {
              { OutputStringStream stream002 = OutputStringStream.newOutputStringStream();

                stream002.nativeStream.print("`" + testValue003 + "' is not a valid case option");
                throw ((StellaException)(StellaException.newStellaException(stream002.theStringReader()).fillInStackTrace()));
              }
            }
          }
        }
      }
      else {
        { OutputStringStream stream003 = OutputStringStream.newOutputStringStream();

          stream003.nativeStream.print("`" + testValue000 + "' is not a valid case option");
          throw ((StellaException)(StellaException.newStellaException(stream003.theStringReader()).fillInStackTrace()));
        }
      }
    }
  }

  /** Return the maximum of <code>x</code> and <code>y</code>.  If <code>y</code> is NULL, return <code>x</code>.
   * @param y
   * @return NumberWrapper
   */
  public NumberWrapper max(NumberWrapper y) {
    { NumberWrapper x = this;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(x);

        if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper x000 = ((IntegerWrapper)(x));

            { Surrogate testValue001 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue001)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue001)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue001)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
              }
            }
          }
        }
        else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
          { LongIntegerWrapper x000 = ((LongIntegerWrapper)(x));

            { Surrogate testValue002 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue002)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue002)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue002)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
              }
            }
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper x000 = ((FloatWrapper)(x));

            { Surrogate testValue003 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue003)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue003)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue003)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue >= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
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

  /** Return the minimum of <code>x</code> and <code>y</code>.  If <code>y</code> is NULL, return <code>x</code>.
   * @param y
   * @return NumberWrapper
   */
  public NumberWrapper min(NumberWrapper y) {
    { NumberWrapper x = this;

      { Surrogate testValue000 = Stella_Object.safePrimaryType(x);

        if (Surrogate.subtypeOfIntegerP(testValue000)) {
          { IntegerWrapper x000 = ((IntegerWrapper)(x));

            { Surrogate testValue001 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue001)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue001)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue001)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
              }
            }
          }
        }
        else if (Surrogate.subtypeOfLongIntegerP(testValue000)) {
          { LongIntegerWrapper x000 = ((LongIntegerWrapper)(x));

            { Surrogate testValue002 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue002)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue002)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue002)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
              }
            }
          }
        }
        else if (Surrogate.subtypeOfFloatP(testValue000)) {
          { FloatWrapper x000 = ((FloatWrapper)(x));

            { Surrogate testValue003 = Stella_Object.safePrimaryType(y);

              if (Surrogate.subtypeOfIntegerP(testValue003)) {
                { IntegerWrapper y000 = ((IntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfLongIntegerP(testValue003)) {
                { LongIntegerWrapper y000 = ((LongIntegerWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else if (Surrogate.subtypeOfFloatP(testValue003)) {
                { FloatWrapper y000 = ((FloatWrapper)(y));

                  if ((y000 == null) ||
                      (x000.wrapperValue <= y000.wrapperValue)) {
                    return (x000);
                  }
                  else {
                    return (y000);
                  }
                }
              }
              else {
                return (x000);
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

