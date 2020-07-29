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

// Version: NativeOutputStream.java,v 1.2 2014/07/02 06:33:14 hans Exp

// PrintStream that uses the ISO-8859-1 encoding for byte-to-char transparency.


package edu.isi.stella.javalib;

import java.io.*;

// TO DO:
// - clean up the whole PrintWriter mess (see Native.java log for some explanation
//   why we had to add the writer mechanism);  Basically, we either want to implement
//   STELLA streams as Writers, or always use Writers and implement all relevant
//   Writer print methods on NativeOutputStream (however, we tried that and ran into
//   some trouble - so some other time).  We are doing something like that for flush
//   and close, but it's a bit messy.
// - as part of cleaning this up, we shouldn't have to extend from PrintStream anymore,
//   but it shouldn't hurt either.
// - whatever we do/did here (e.g., for flush and close) should probably be done in
//   NativeInputStream as well.

public class NativeOutputStream extends PrintStream {

    public PrintWriter writer;

    public NativeOutputStream(OutputStream out) throws UnsupportedEncodingException {
        // Created a NativeOutputStream for `out' which is a PrintStream that uses the ISO-8859-1 encoding.
        // Unfortunately, there is no available constructor that takes a charset object, so we have to use the name.
        // Unfortunately#2, in order to specify the charset which we know exists, we have to declare UnsupportedEncodingException.
        super(out, false, edu.isi.stella.Stella.STELLA_CHARSET.name());
    }

    public NativeOutputStream(OutputStream output, boolean autoFlush) throws UnsupportedEncodingException {
        // NativeOutputStream constructor variant that allows control of `autoFlush' behavior.
        super(output, autoFlush, edu.isi.stella.Stella.STELLA_CHARSET.name());
    }


    public static NativeOutputStream create (OutputStream out) {
        // Static convenience constructor that catches the useless UnsupportedEncodingException.
        try {
            return new NativeOutputStream(out);
        }
        catch (UnsupportedEncodingException e) {
            // this will never happen, but we need to keep the compiler happy:
            return null;
        }
    }

    public static NativeOutputStream create (OutputStream out, boolean autoFlush) {
        // Static convenience constructor that catches the useless UnsupportedEncodingException.
        try {
            return new NativeOutputStream(out, autoFlush);
        }
        catch (UnsupportedEncodingException e) {
            // this will never happen, but we need to keep the compiler happy:
            return null;
        }
    }

    public PrintWriter getWriter () {
        // Access the ISO-8859-1 charset writer for this stream or created if it doesn't yet exist.
        if (writer == null)
            writer =  new PrintWriter(new OutputStreamWriter(this, edu.isi.stella.Stella.STELLA_CHARSET), true);
        return writer;
    }

    public void setWriter (PrintWriter wtr) {
        // Set the writer for this stream.
        writer = wtr;
    }

    public void flush () {
        if (writer != null) {
            PrintWriter wrtr = writer;
            writer = null;
            wrtr.flush();
            writer = wrtr;
        }
        else
            super.flush();
    }

    public void close () {
        if (writer != null) {
            PrintWriter wrtr = writer;
            writer = null;
            wrtr.close();
            writer = wrtr;
        }
        else
            super.close();
    }
}
