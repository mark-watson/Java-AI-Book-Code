names:
	mvn install -DskipTests -q
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.ExtractNames" -q

autotagger:
	mvn install -DskipTests -q
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.AutoTagger" -q

fasttag:
	mvn install -DskipTests -q
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.FastTag" -q


install:
	mvn install -DskipTest -Dmaven.test.skip=true -q
