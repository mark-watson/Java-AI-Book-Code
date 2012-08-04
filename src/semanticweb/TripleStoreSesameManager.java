package semanticweb;

import org.openrdf.query.*;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandler;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.n3.N3Writer;
import org.openrdf.sail.inferencer.fc.ForwardChainingRDFSInferencer;
import org.openrdf.sail.memory.MemoryStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper class for an embedded Sesame RDF data store. This class was derived
 * from the TrippleStoreSesameManager class in the commercial (but free for
 * non commercial use) product KB_bundle as descibed at http://knowledgebooks.com
 *
 * Copyright 2008-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under either the LGPL version 3 or Apache 2 license.
 */
public class TripleStoreSesameManager {
	
    /**
     * Create an in-memory RDF triple store
     * 
     * @throws org.openrdf.repository.RepositoryException
     */
    public TripleStoreSesameManager() throws RepositoryException {
        MemoryStore ms = new MemoryStore();
        ForwardChainingRDFSInferencer fci = new ForwardChainingRDFSInferencer(ms);
        myRepository = new SailRepository(fci);
        myRepository.initialize();
        System.out.println(myRepository);
        con = myRepository.getConnection();
    }
    
    /**
     * Load RDF from a file. The file should have one of these extentions:
     * <ul>
     *   <li>.rdf - for XML RDF format</li>
     *   <li>.nt - for NTriple RDF format</li>
     *   <li>.n3 - for the most concise N3 RDF format</li>
     * </ul>
     * @param rdf_file_path_name
     * @throws org.openrdf.repository.RepositoryException
     * @throws java.io.IOException
     * @throws org.openrdf.rio.RDFParseException
     */
    public void loadRDF(String rdf_file_path_name) throws RepositoryException, IOException, RDFParseException {
        File file = new File(rdf_file_path_name);
        if (rdf_file_path_name.endsWith(".nt"))
            con.add(file, "http://knowledgebooks.com/ontology", RDFFormat.NTRIPLES);
        else if (rdf_file_path_name.endsWith(".n3"))
            con.add(file, "http://knowledgebooks.com/ontology", RDFFormat.N3);
        else if (rdf_file_path_name.endsWith(".rdf"))
            con.add(file, "http://knowledgebooks.com/ontology", RDFFormat.RDFXML);
        else System.out.println("\n\nERROR: file name " + rdf_file_path_name + " has an unsupported file extention.\n");
    }
    
    /**
     * Close the RDF repository
     */
    public void close() {
        try {
            con.close();
        } catch (RepositoryException ex) {
            Logger.getLogger(TripleStoreSesameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Perform a SPARQL query
     * 
     * @param sparql_query 
     * @param handler 
     * @return
     * @throws RepositoryException 
     * @throws MalformedQueryException 
     * @throws QueryEvaluationException
     */
    public String doSparqlQuery(String sparql_query, ISparqlProcessResults handler) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
        StringBuffer sb = new StringBuffer();
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, sparql_query);
        TupleQueryResult result = tupleQuery.evaluate();
        try {
            //.... // do something with the result
            //System.out.println("\n\n\n* * * result: " + result.getBindingNames());
            List<String> bindingNames = result.getBindingNames();
            int size = result.getBindingNames().size();
            //System.out.println("Size of result data = " + size);
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                int size2 = bindingSet.size();
                //System.out.println("size2 = " + size2);
                List<String> temp = new ArrayList<String>(size2);
                for (int i = 0; i < size2; i++) {
                    String val = bindingSet.getValue(bindingNames.get(i)).stringValue();
                    //System.out.println("val = " + val);
                    temp.add(val);
                }
                handler.processResult(temp);
            }
        } finally {
            result.close();
        }
        return sb.toString();
    }
    
    /**
     * Save the RDF repository that is currently in memory to a N3 formatted RDF file.
     * 
     * @param output_file_path
     * @throws org.openrdf.repository.RepositoryException
     * @throws org.openrdf.rio.RDFHandlerException
     * @throws java.io.IOException
     */
    public void saveRepositoryAsN3(String output_file_path) throws RepositoryException, RDFHandlerException, IOException {
        FileWriter outFile = new FileWriter(output_file_path);
        //PrintWriter out = new PrintWriter(outFile);
        RDFHandler n3Writer = new N3Writer(outFile);
        con.export(n3Writer);
        outFile.close();
    }
    
    private Repository myRepository;
    private RepositoryConnection con;
    private String baseURI = "http://knowledgebooks.com/ontology";
}
