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

// Version: NativeFileOutputStream.java,v 1.2 2014/06/14 01:13:53 hans Exp

// Buffered file output stream that preserves access to the underlying file
// output stream (and associated channel), so that we can query and update
// stream positions.


package edu.isi.stella.javalib;

import edu.isi.stella.*;
import java.io.*;

public class NativeFileOutputStream extends NativeOutputStream {

    public java.nio.channels.FileChannel channel;

    public NativeFileOutputStream(String filename, boolean append) throws FileNotFoundException, UnsupportedEncodingException {
        // Create an output file stream for `filename'.
        // Append to `filename' if `append' is true.
        // See NativeOutputStream on why we need to throw UnsupportedEncodingException.
        super(new FileOutputStream(filename, append));
        channel = ((FileOutputStream)out).getChannel();
        if (append)
            // Work around an apparent Java bug: if we append to a file, the channel's initial
            // position is 0 instead of the size of the file, contrary to what (I think) it says
            // at: http://java.sun.com/javase/6/docs/api/java/io/FileOutputStream.html#getChannel()
            try {
                channel.position(channel.size());
            }
            catch (Exception e) {};
        out = new BufferedOutputStream(out);
    }
    
    public static NativeFileOutputStream open(String filename, boolean append) {
        // Open `filename' for output and return the resulting stream.
        // Append to `filename' if `append' is true.
        try {
            return (new NativeFileOutputStream(filename, append));
        }
        catch (java.io.FileNotFoundException e) {
            throw (NoSuchFileException) NoSuchFileException.newNoSuchFileException("NativeFileOutputStream.openOutputFileStream: " + e.getMessage()).fillInStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            // this will never happen, but we need to keep the compiler happy:
            return null;
        }
    }

    public long position() {
        // Return the current stream position of this file stream.
        // Needs to flush any buffered output.
        try {
            flush();
            return channel.position();
        }
        catch (IOException e) {
            throw (InputOutputException)InputOutputException.newInputOutputException("NativeFileOutputStream.position: " + e.getMessage()).fillInStackTrace();
        }
    }

    public long position(long newPosition) {
        // Set the current stream position of this file stream to `newPosition'.
        // Needs to flush any buffered output.
        try {
            flush();
            channel.position(newPosition);
            return newPosition;
        }
        catch (IOException e) {
            throw (InputOutputException)InputOutputException.newInputOutputException("NativeFileOutputStream.position: " + e.getMessage()).fillInStackTrace();
        }
    }
}
