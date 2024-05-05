create_data_and_remove_duplicates: install
	mvn test -q
	echo "Removing duplicate RDF statements"
	awk '!visited[$$0]++' output_with_duplicates.rdf > output.rdf
	rm -f output_with_duplicates.rdf


install:
	mvn install -DskipTest -Dmaven.test.skip=true -q

clean:
	rm -r -f target output.rdf output_with_duplicates.rdf