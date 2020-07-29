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

// Version: NativeFileInputStream.java,v 1.2 2014/06/14 01:12:24 hans Exp

// Buffered file input stream that preserves access to the underlying
// file input stream channel, so that we can query and update stream
// positions.

// TO DO: figure out how to handle stream position access in light of
//        pushed back input via unread.


package edu.isi.stella.javalib;

import edu.isi.stella.*;
import java.io.*;

public class NativeFileInputStream extends NativeInputStream {

    public java.nio.channels.FileChannel channel;

    public NativeFileInputStream(String filename) throws FileNotFoundException {
        // Create an input file stream for `filename'.
        super(new FileInputStream(filename));
        channel = ((FileInputStream)in).getChannel();
        in = new FlushableBufferedInputStream(in);
    }
    
    public static NativeFileInputStream open(String filename) {
        // Open `filename' for input and return the resulting stream.
        try {
            return (new NativeFileInputStream(filename));
        }
        catch (java.io.FileNotFoundException e) {
            throw (NoSuchFileException) NoSuchFileException.newNoSuchFileException("NativeFileInputStream.openInputFileStream: " + e.getMessage()).fillInStackTrace();
        }
    }

    public long position() {
        // Return the current stream position of this file stream.
        // Needs to account for various buffering.
        try {
            return (channel.position()   // file position 
                    - (buf.length - pos) // unread character(s)
                    - ((FlushableBufferedInputStream)in).bufferedBytes()); // file buffer
        }
        catch (IOException e) {
            throw (InputOutputException)InputOutputException.newInputOutputException("NativeFileInputStream.position: " + e.getMessage()).fillInStackTrace();
        }
    }

    public long position(long newPosition) {
        // Set the current stream position of this file stream to `newPosition'.
        // Needs to flush various buffered input.
        try {
            // flush the unread buffer of the PushBackStream:
            pos=buf.length;
            // flush the file buffering stream:
            ((FlushableBufferedInputStream)in).resetBuffer();
            channel.position(newPosition);
            return newPosition;
        }
        catch (IOException e) {
            throw (InputOutputException)InputOutputException.newInputOutputException("NativeFileInputStream.position: " + e.getMessage()).fillInStackTrace();
        }
    }
}
