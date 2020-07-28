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
 | Portions created by the Initial Developer are Copyright (C) 1997-2006      |
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

import java.net.*;
import java.io.*;
import edu.isi.stella.*;
import edu.isi.powerloom.PLI;

/** PowerLoomServer class.  Runs a socket listener and spawns threads of
 *  PowerLoom  read-eval-print loops to handle each connection.
 *
 *  The server will listen at a port given on the command line at startup.
 *
 *  Commands are then sent on the socket connection.  The syntax of
 *  commands is as follows:
 *  <PRE>
 *
 *  COMMAND ENCODING LANGUAGE VERSION [PASSWORD]
 * 
 *  </PRE>
 *  Where COMMAND is one of
 *  <UL>
 *  <LI>CLOSE -- close the socket connection.</LI>
 *  <LI>HALT  -- stops the server.  Don't do this lightly!</LI>
 *  <LI>EVALUATE -- read an expression starting on the following line,
 *   evaluate it, and return the result.</LI>
 *  </UL>
 *  and ENCODING is one of
 *  <UL>
 *  <LI>ASCII -- normal text.</LI>
 *  </UL>
 *  and LANGUAGE is one of
 *  <UL>
 *  <LI>CONTROL -- for the CLOSE and HALT commands.</LI>
 *  <LI>POWERLOOM -- for the EVALUATE command.<LI>
 *  </UL>
 *  VERSION is currently not checked.<BR>
 *  PASSWORD, if required, must match the server password established at startup.
 *
 *  Replies will be in the following form:
 *  <PRE>
 *
 *  CODE ENCODING LANGUAGE VERSION CHARACTERS=n LINES=m
 * 
 *  </PRE>
 *  Where CODE is one of
 *  <UL>
 *  <LI>200 -- successful response.</LI>
 *  <LI>500 -- error response.</LI>
 *  </UL>
 *  and ENCODING is one of
 *  <UL>
 *  <LI>ASCII -- normal text.</LI>
 *  </UL>
 *  and LANGUAGE is one of
 *  <UL>
 *  <LI>ENGLISH -- for error messages.</LI>
 *  <LI>POWERLOOM -- for evaluation results.<LI>
 *  </UL>
 *  The CHARACTERS=n and LINES=m indicate how many characters and lines the
 *  response uses.  Line terminators may be any combinbation of CR, LF or CR/LF.
 *
 * @author Thomas Russ
 * @version PowerLoomServer.java,v 1.10 2006/05/11 07:05:01 hans Exp
 */
public class PowerLoomServer {

  static void usage () {
    System.err.println("Usage: java edu.isi.powerloom.logic.PowerLoomServer [-port <n>] [-kb <filename>]* [-ontology <name>] [-password <password>] [-admin <password>]");
  }

  /* Function to run Stella system startup code specified by the
     input argument.  The name must be a FULLY QUALIFIED static
     method name which takes no arguments.

     @param code Fully qualified name of method to be run.
  */
  static void runStartupCode (String code) {
    int startOfMethodName = code.lastIndexOf('.');
    String className = code.substring(0, startOfMethodName);
    String methodName = code.substring(startOfMethodName+1);
    Class theClass;
    java.lang.reflect.Method theMethod;
    try {
      theClass = Class.forName(className);
      theMethod = theClass.getDeclaredMethod(methodName, new Class [] {});
      theMethod.invoke(theClass, new Object [] {});
    } catch (ClassNotFoundException cnfe) {
      System.err.println("Can't find class `" + className + "' for startup code.");
      System.exit(-1);
    } catch (NoSuchMethodException nsme) {
      System.err.println("Can't find method `" + methodName + "' on `" + className + "' for startup code.");
      System.exit(-1);
    } catch (Exception e) {
      System.err.println("Error invoking method `" + methodName + "' on `" + className + "' for startup code.");
      e.printStackTrace();
    }
  }

  /** Starts socket server, taking optional port argument.
   *  The arguments that may be given at the command line are the following:
   *
   *<PRE>
   *  -port N         N is the port number for socket connections.  If it is
   *                  not specified, then 4444 is used.
   *  -kb FILENAME    A kb from FILENAME is loaded.  This option may be repeated
   *                  multiple times.
   *  -ontology NAME  If given, then the default ontology for new threads is
   *                  set to NAME.  If not specified, PL-USER is used.
   *  -password S     S is a string which is the password for connections.  If
   *                  not specified, then no password is required.  If specified,
   *                  then commands must include the correct password.
   *  -admin S        S is a string which is the password for administration.  If
   *                  not specified, then it defaults to the value of the -password
   *                  field.  This allows a separate password to be used for
   *                  administrative functions like shutting down the server.
   *  -startup NAME   NAME is a fully qualified method name which must take no
   *                  arguments.  It is invoked in the order encountered on the
   *                  command line.  An example would be
   *       "edu.isi.stella.utilities.StartupUtilitiesSystem.startupUtilitiesSystem"
   *</PRE>
   *
   */
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = null;
    boolean listening = true;
    String ontology = "PL-USER";
    String password = null;
    String adminPassword = null;
    int port = 4444;


    // For backward compatibility:
    if (args.length == 1) {
      if (args[0].equals("-help")) {
	usage();
	System.exit(0);
      } else {
	try { port = Integer.parseInt(args[0]);
	} catch (Exception e) {
	  System.err.println("Problem parsing `" + args[0] + "' as a port number");
	  usage();
	  System.exit(-1);
	}
      }
    }

    System.out.print("Initializing PowerLoom ...");
    StartupLogicSystem.startupLogicSystem();
    System.out.println("  Done.");


    // For new argument parsing scheme:
    for (int argn = 0; argn < args.length; argn++) {
      try {
	if (args[argn].equals("-help")) {
	  usage();
	  System.exit(0);
	} else if (args[argn].equals("-ontology")) {
	  ontology = args[++argn];
	} else if ((args[argn].equals("-kb"))) {
	  argn++;
	  System.out.println("Loading " + args[argn] + " ...");
	  PLI.load(args[argn], null);
	  System.out.println("   Done.");
	} else if (args[argn].equals("-port")) {
	    ++argn;
	    port = Integer.parseInt( args[argn] );
	  } else if (args[argn].equals("-startup")) {
	    ++argn;
	    System.out.println("Executing " + args[argn] + " ...");
	    runStartupCode(args[argn]);
	    System.out.println("   Done.");
	  } else {
	    System.err.println("ERROR: Unrecognized option " + args[argn]);
	    usage();
	    System.exit(1);
	  }
      } catch (ArrayIndexOutOfBoundsException e) {
	System.err.println("Missing argument value for option " + args[argn-1]);
	usage();
	System.exit(1);	    
      } catch (NumberFormatException nfe) {
	System.err.println("Numeric argument expected for option " + args[argn-1] 
			   + " but " + args[argn] + " supplied");
	usage();
	System.exit(1);
      }
    }

    try {
      serverSocket = new ServerSocket(port);
      System.out.println("Listening on port " + port);
    } catch (IOException e) {
      System.err.println("Could not listen on port: " + port + ".");
      System.exit(-1);
    }

    while (listening) {
      new PowerLoomServerThread(serverSocket.accept(), password, adminPassword).start();
      System.out.println("Accepted connection");  
    }
    serverSocket.close();
  }
}
