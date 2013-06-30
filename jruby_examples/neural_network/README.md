# Using the Backpropagation neural network example in JRuby

One reason why I like Java is that it is easy to package up Java code and use with
other JVM languages like JRuby, Clojure, and Scala.

Here is an example using a Makefile (works on Max OS X and Linux - for Windows developers, it would
be great if someone would provide me with a Windows .bat command file) to build a JAR file
and using it in a small JRuby test program

~~~~~~~~
make jar
jruby test.rb
~~~~~~~~

This is a simple example with a tiny amount of training data. The Java code that this example uses
can be used to train very large networks but you must increase the number of training iterations.

