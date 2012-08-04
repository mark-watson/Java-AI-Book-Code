package powerloom;

import edu.isi.powerloom.PLI;
import edu.isi.powerloom.PlIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PowerLoom Java utilities
 *
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */public class PowerLoomUtils {

    public PowerLoomUtils() {
        System.out.print("Initializing...");
        PLI.initialize();
        System.out.println("    done.");
    }
    public int load(String fpath) {
        try {
            PLI.load(fpath, null);
            return 1;
            } catch (Exception ex) {
                System.out.println("Error loading " + fpath + " is: " + ex);
                return 0;
            }   
    }
    public int changeModule(String workingModule) {
        try {
            PLI.sChangeModule(workingModule, null);
            this.workingModule = workingModule;
            return 1;
        } catch (Exception ex) {
            System.out.println("Error changing module " + workingModule + " is: " + ex);
            return 0;
        }   
    }
    public int assertProposition(String proposition) {
    	proposition = proposition.replace('\'', '\"');
        try {
            PLI.sAssertProposition(proposition, workingModule, null);
            return 1;
        } catch (Exception ex) {
            System.out.println("Error asserting proposition '" + proposition + "' is: " + ex);
            return 0;
        }   
    }
    public int createRelation(String relation, int arity) {
        try {
            PLI.sCreateRelation(relation, arity, workingModule, null);
            return 1;
        } catch (Exception ex) {
            System.out.println("Error creating relation '" + relation + "' with arity=" + arity + " is: " + ex);
            return 0;
        }   
    }

    private String fix(Object obj) {
      String s = ""+obj;
      return s.substring(3);
    }

  // following method donated by Thomas Russ:
  public List doQuery(String query) {
	  ArrayList ret = null;
      try {
       PlIterator rawAnswer = PLI.sRetrieve(query, workingModule, null);
       ret = new ArrayList<ArrayList<String>>(rawAnswer.length());
       Iterator answer =
         new edu.isi.stella.javalib.StellaIterator(rawAnswer);
       while (answer.hasNext()) {
         Object obj = answer.next();
         int nItems = PLI.getColumnCount((edu.isi.stella.Stella_Object)obj);
         java.util.ArrayList r2 = new java.util.ArrayList(nItems);
         for (int i = 0; i < nItems; i++) {
           r2.add(fix(PLI.getNthValue((edu.isi.stella.Stella_Object)obj, i, null, null)));
         }
         ret.add(r2);
       }
      } catch (Exception ex) {
       System.out.println("Error with query '" + query + "': " + ex);
       ret = new java.util.ArrayList(0);
    }
      return ret;
  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    private String workingModule = "PL-USER";
}
