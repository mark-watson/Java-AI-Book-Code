clean:
	rm -r -f out
	(cd clojure_examples; lein clean; rm -r -f lib/* classes)

mapreduce_example:
	rm -r -f mr_temp
	mkdir -p mr_temp/nlp/com/knowledgebooks/mapreduce
	mkdir -p mr_temp/nlp/com/knowledgebooks/nlp/util
	cp src/nlp/com/knowledgebooks/mapreduce/NameFinder.java mr_temp/nlp/com/knowledgebooks/mapreduce/
	cp src/nlp/com/knowledgebooks/nlp/util/ScoredList.java mr_temp/nlp/com/knowledgebooks/nlp/util/
	cp src/nlp/com/knowledgebooks/nlp/util/Tokenizer.java mr_temp/nlp/com/knowledgebooks/nlp/util/
	cp src/nlp/com/knowledgebooks/nlp/ExtractNames.java mr_temp/nlp/com/knowledgebooks/nlp/
	mkdir -p mr_temp/test_data
	cp test_data/propername.ser mr_temp/test_data/
	(cd mr_temp; jar xvf ../lib/hadoop-core-1.1.2.jar)
	(cd mr_temp; javac nlp/com/knowledgebooks/mapreduce/NameFinder.java)
	(cd mr_temp; jar cvf ../namefinder.jar .)
