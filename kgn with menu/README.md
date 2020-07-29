This exmample will only work when run as a junit test or in an IDE.

Trying to run using:

    mvn exec:java -Dexec.mainClass="com.knowledgegraphnavigator.KGN"

will not work because "mvn exec" works by only having the
jar file plexus-classworlds-2.6.0.jar (or some other version)
on the CLASSPATH. This prevents the dependency

       <dependency>
          <groupId>com.markwatson</groupId>
          <artifactId>nerdbpedia</artifactId>
          <version>1.1-SNAPSHOT</version>
        </dependency>
     
from a previous chapter from being able to load entity definition
text files from its packaged jar file.


