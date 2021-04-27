all_examples: 1H 2H 2H_momentum

1H:
	mvn install -DskipTests
	mvn test -Dtest=NeuralNetwork_1H_Test

2H:
	mvn install -DskipTests
	mvn test -Dtest=NeuralNetwork_2H_Test


2H_momentum:
	mvn install -DskipTests
	mvn test -Dtest=NeuralNetwork_2H_momentum_Test


install:
	mvn install -DskipTest -Dmaven.test.skip=true
