/*
Jazzy - a Java library for Spell Checking
Copyright (C) 2001 Mindaugas Idzelis
Full text of license can be found in LICENSE.txt

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.swabunga.util;

import java.util.Iterator;
import java.util.List;

public class VectorUtility {
  public static List addAll(List dest, List src) {
    return addAll(dest, src, true);
  }

  public static List addAll(List dest, List src, boolean allow_duplicates) {
    for (Iterator e = src.iterator(); e.hasNext();) {
      Object o = e.next();
      if (allow_duplicates || !dest.contains(o))
        dest.add(o);
    }
    return dest;
  }
}
