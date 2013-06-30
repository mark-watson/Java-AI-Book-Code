clean:
	rm -r -f *.jar temp_build

jar:
	rm -r -f temp_build
	mkdir -p temp_build/neuralnetworks
	cp ../../src/neuralnetworks/Neural_2H_momentum.java temp_build/neuralnetworks/
	(cd temp_build; javac neuralnetworks/Neural_2H_momentum.java)
	(cd temp_build; jar cvf ../nn.jar .)
	rm -r -f temp_build
