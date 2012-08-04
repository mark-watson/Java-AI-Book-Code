package semanticweb;

import java.util.List;

/**
 * <p/>
 * Copyright 2008 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under either the LGPL version 3 or Apache 2 license.
 *
 * @author Mark Watson
 */
public interface ISparqlProcessResults {
    /**
     * Callback handler for processing SPARQL query results. This method is called once for each result.
     * 
     * @param data a list of strings containing SPARQL query results.
     */
    public void processResult(List<String> data);
}