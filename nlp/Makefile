names:
	mvn install -DskipTests
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.ExtractNames"

autotagger:
	mvn install -DskipTests
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.AutoTagger"

fasttag:
	mvn install -DskipTests
	mvn exec:java -Dexec.mainClass="com.markwatson.nlp.FastTag"


install:
	mvn install -DskipTest -Dmaven.test.skip=true
