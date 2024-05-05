all_examples: 1H 2H 2H_momentum

1H:
	mvn install -DskipTests -q
	mvn test -Dtest=NeuralNetwork_1H_Test -q

2H:
	mvn install -DskipTests -q
	mvn test -Dtest=NeuralNetwork_2H_Test -q


2H_momentum:
	mvn install -DskipTests -q
	mvn test -Dtest=NeuralNetwork_2H_momentum_Test -q


install:
	mvn install -DskipTest -Dmaven.test.skip=true -q
