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

public class StringUtility {
  public static StringBuffer replace(StringBuffer buf, int start, int end, String text) {
    int len = text.length();
    char[] ch = new char[buf.length() + len - (end - start)];
    buf.getChars(0, start, ch, 0);
    text.getChars(0, len, ch, start);
    buf.getChars(end, buf.length(), ch, start + len);
    buf.setLength(0);
    buf.append(ch);
    return buf;
  }

  public static void main(String[] args) {
    System.out.println(StringUtility.replace(new StringBuffer(args[0]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[1]));
  }
}
