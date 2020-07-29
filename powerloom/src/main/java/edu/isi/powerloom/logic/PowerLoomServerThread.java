//  -*- Mode: Java -*-

/*---------------------------- BEGIN LICENSE BLOCK ---------------------------+
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
 | Portions created by the Initial Developer are Copyright (C) 1997-2014      |
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
 +----------------------------- END LICENSE BLOCK ----------------------------*/


package edu.isi.powerloom.logic;

/** PowerLoomServerThread class.  Thread to runs a read-eval-print
 *  over a socket connection.
 *
 * @author Thomas Russ
 * @version PowerLoomServerThread.java,v 1.13 2014/06/14 01:44:12 hans Exp
 */

import java.net.*;
import java.io.*;
import edu.isi.stella.*;
import edu.isi.stella.javalib.*;

public class PowerLoomServerThread extends Thread {
  private Socket socket = null;
  private String password = null;
  private String adminPassword = null;

  public PowerLoomServerThread(Socket socket, String pword, String adminPword) {
    super("PowerLoomServerThread");
    this.socket = socket;
    this.password = pword;
    this.adminPassword = adminPword;
  }

  static int countNewlines (String s) {
    // For efficiency:  (but is it faster than s.charAt()?)
    int crCount = 0;
    int lfCount = 0;
    char [] chars = s.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == '\n') {
	lfCount++;
      } else if (chars[i] == '\r') {
	crCount++;
      }
    }
    return crCount > lfCount ? crCount : lfCount;
  }

  static void errorReply (edu.isi.stella.OutputStream out, String message) {
    int len = message.length() + 2;
    int lines = countNewlines(message) + 1;
    out.nativeStream.print("500 ASCII ENGLISH 1.1 CHARACTERS=" + len + " LINES=" + lines + "\r\n");
    out.nativeStream.print(message + "\r\n");
  }

  static void normalReply (edu.isi.stella.OutputStream out, String encoding, String language, String message) {
    int len = message.length() + 2;
    int lines = countNewlines(message) + 1;
    out.nativeStream.print("200 " + encoding + " " + language + " 1.1 CHARACTERS=" + len
	      + " LINES=" + lines + "\r\n");
    out.nativeStream.print(message + "\r\n");
  }

  static String [] parseCommandLine (String command) {
    java.util.StringTokenizer tok = new java.util.StringTokenizer(command);
    int size = tok.countTokens();
    String [] commands = new String [size];
    for (int i = 0; i < size; i++) {
      commands[i] = tok.nextToken();
    }
    return commands;
  }

  static void checkPassword (String offered, String correct) 
    throws java.lang.IllegalArgumentException {
    if ((correct != null) &&
	((offered == null) || !offered.equals(correct))) {
      throw new java.lang.IllegalArgumentException("Invalid password.  Access denied.");
    }
  }

  public void run() {
    edu.isi.stella.OutputStream out = null;
    edu.isi.stella.InputStream in = null;
    String [] commands;
    String commandLine, command, encoding, language, pword;
    
    try {
      // Need to use these deprecated forms for compatibility with
      // the standard system I/O streams & Stella.
      out = edu.isi.stella.OutputStream.newOutputStream();
      out.nativeStream = NativeOutputStream.create(socket.getOutputStream());

      in = edu.isi.stella.InputStream.newInputStream();
      in.nativeStream = NativeInputStream.create(socket.getInputStream());

      Stella_Object inputObject, resultObject;
      String outputLine;

      Stella.$PRINTREADABLYp$.set(Boolean.TRUE);
      Object [] mv_returnarray = new Object[1];

      for (;;) {
	try {
	  // Command line is of the form COMMAND ENCODING LANGUAGE VERSION [PASSWORD]
	  commandLine = edu.isi.stella.InputStream.readLine(in);
	  if (commandLine == null) {
	    System.out.println("Remote Connection Closed");
	    break;
	  }
	  commands = parseCommandLine(commandLine);
	  pword = "";
	  if (commands.length == 0) {  // Possibly trailing CR-LF or blank line sent.
	    continue;
	  } else if (commands.length < 4) {
	    errorReply(out, "Malformed command line: " + commandLine);
	    continue;
	  } else if (commands.length > 4) {
	    pword = commands[4];
	  }

	  command  = commands[0];
	  encoding  = commands[1];
	  language  = commands[2];

	  if (command.equals("HALT") && language.equals("CONTROL")) {
	    checkPassword(pword, adminPassword);
	    try {
	      normalReply(out, "ASCII", "ENGLISH", "Halting PowerLoomServer");
	    } catch (Exception e) {  // Suppress
	    } 
	    System.out.println("Halt command received.");
	    System.exit(0);
	  } else if (command.equals("CLOSE") && language.equals("CONTROL")) {
	    checkPassword(pword, password);
	    try {
	      normalReply(out, "ASCII", "ENGLISH", "Closing Connection");
	    } catch (Exception e) {  // Suppress
	    }
	    System.out.println("Close connection command received.");
	    break;
	  } else if (command.equals("EVALUATE")) {
	    checkPassword(pword, password);
	    if (language.equals("POWERLOOM") && encoding.equals("ASCII")) {
	      inputObject = edu.isi.stella.InputStream.readSExpression(in, mv_returnarray);
	      if (mv_returnarray[0] == Stella.TRUE_WRAPPER) {
		System.out.println("Remote Connection Closed");
		break;
	      }
	      synchronized (Logic.$POWERLOOM_LOCK$) {
		resultObject = Stella_Object.evaluate(inputObject);
	      }
	      normalReply(out, "ASCII", "POWERLOOM", Native.stringify(resultObject));
	    } else if (language.equals("POWERLOOM")) { 
	      errorReply(out, "The server doesn't support encoding " + encoding);
	    } else {
	      errorReply(out, "The server doesn't support input language " + language);
	    }
	  }
	} catch (Exception se) {
	  errorReply(out, se.toString());
	}
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println("I/O Error, closing connection");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error, closing connection");
      errorReply(out, e.toString());
    } finally {
      if (in  != null)  in.free();
      if (out != null) out.free();
      try {
	socket.close();
      } catch (IOException ioe) {
      }
    }
  }
}

