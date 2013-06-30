require 'java'  # for Java interop

require 'nn.jar' # load the neural netowrk compiled Java code
java_import 'neuralnetworks.Neural_2H_momentum'

## training data to rotate three input values:

in1 = [0.1, 0.1, 0.9]
in2 = [0.1, 0.9, 0.1]
in3 = [0.9, 0.1, 0.1]

out1 = [0.9, 0.1, 0.1]
out2 = [0.1, 0.1, 0.9]
out3 = [0.1, 0.9, 0.1]

test1 = [0.1, 0.1, 0.9]
test2 = [0.1, 0.9, 0.1]
test3 = [0.9, 0.1, 0.1]

nn = Neural_2H_momentum.new(3, 3, 3, 3, 0.75)
p nn

nn.addTrainingExample(in1, out1)
nn.addTrainingExample(in2, out2)
nn.addTrainingExample(in3, out3)

100.times do |training_iteration|
   p nn.train() # train and print the error at output neurons
end

## test to make sure we have learned the input patterns:

p nn.recall(test1)
p nn.recall(test2)
p nn.recall(test3)