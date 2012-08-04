package opencalais;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * This is a web services client class for using the Open Calais web service
 * for analysizing text and identifying entities and relationships between
 * entities. You will need a free Open Calais developer's key that should
 * be set in an environment variable of defined on the command line when starting
 * the JVM. This property is obtained using: <code>System.getProperty("OPEN_CALAIS_KEY")</code>
 * <p/>
 * Copyright 2002-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class OpenCalaisClient {
    
    /**
     * A client program to use Reuters News Open Calais web service. This can be
     * used as an alternative to the KnowledgeBooks.com entity extraction
     * classes.
     * 
     * @param text 
     * @return Hashtable<String, List<String>> of properties with associated values list (e.g., property "Person", value list would be a list of names occurring in the input text other properties can be "City","State", "Country", etc.)
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public Hashtable<String, List<String>> getPropertyNamesAndValues(String text) throws MalformedURLException, IOException {
        Hashtable<String, List<String>> ret = new Hashtable<String, List<String>>();
        String licenseID = System.getenv("OPEN_CALAIS_KEY");
        if (licenseID == null) {
        	System.out.println("Error: must have environment variable OPEN_CALAIS_KEY set");
        	System.exit(1);
        }
        System.out.println("licenseID = " + licenseID);
        String content = text;
        String paramsXML = "<c:params xmlns:c=\"http://s.opencalais.com/1/pred/\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"><c:processingDirectives c:contentType=\"text/txt\" c:outputFormat=\"xml/rdf\"></c:processingDirectives><c:userDirectives c:allowDistribution=\"true\" c:allowSearch=\"true\" c:externalID=\"17cabs901\" c:submitter=\"ABC\"></c:userDirectives><c:externalMetadata></c:externalMetadata></c:params>";
		StringBuilder sb = new StringBuilder(content.length() + 512);
		sb.append("licenseID=").append(licenseID);
		sb.append("&content=").append(content);
		sb.append("&paramsXML=").append(paramsXML);
		String payload = sb.toString();
		URLConnection connection = new URL("http://api.opencalais.com/enlighten/calais.asmx/Enlighten").openConnection();
		connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.addRequestProperty("Content-Length", String.valueOf(payload.length()));
		connection.setDoOutput(true);
		OutputStream out = connection.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(out);
		writer.write(payload);
		writer.flush();
        // get response from Open Calais server:		
		String result = new Scanner(
		           connection.getInputStream()).
		           useDelimiter("\\Z").next();
		result = result.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		System.out.println(result);
        int index1 = result.indexOf("terms of service.-->");
        index1 = result.indexOf("<!--", index1);
        int index2 = result.indexOf("-->", index1);
        result = result.substring(index1 + 4, index2 - 1 + 1);
        String[] lines = result.split("\\n");
        for (String line : lines) {
            int index = line.indexOf(":");
            if (index > -1) {
                String relation = line.substring(0, index).trim();
                String[] entities = line.substring(index + 1).trim().split(",");
                for (int i = 0, size = entities.length; i < size; i++) {
                    entities[i] = entities[i].trim();
                }
                ret.put(relation, Arrays.asList(entities));
            }
        }
        return ret;
    }

    /**
     * 
     * @param args
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        	String content = "Hillary Clinton likes to remind Texans that she first came here to ask for their votes in 1972 as a young Democratic campaign worker. Doug Hattaway, a Clinton adviser who worked on Al Gore's presidential campaign in 2000 was in Austin Texas. Texas is crucial to Clinton's hopes of staying in the U.S. presidential race. Clinton travleed to France, Spain, and San Francisco.";
        	Map<String, List<String>> results = new OpenCalaisClient().getPropertyNamesAndValues(content);
        	//System.out.println("\n\nresults:\n\n" + results);
        	for (String key : results.keySet()) { 
        		System.out.println("  " + key + ": " + results.get(key));
        	}
    }

}
