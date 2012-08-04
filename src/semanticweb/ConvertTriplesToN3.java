package semanticweb;

import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;

import java.io.IOException;


/**
 *
 * <p/>
 * Copyright 2002-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under either of the following licenses:
 * <p/>
 * 1. LGPL
 * 2. Apache 2
 */
public class ConvertTriplesToN3 {
    public static void main(String [] args) throws RepositoryException, IOException, RDFParseException, RDFHandlerException {
      TripleStoreSesameManager ts = new TripleStoreSesameManager();
      ts.loadRDF("rdf_files/rdfs.nt");
      ts.loadRDF("rdf_files/news.nt");
      ts.saveRepositoryAsN3("sample_N3.n3");
    }
}
