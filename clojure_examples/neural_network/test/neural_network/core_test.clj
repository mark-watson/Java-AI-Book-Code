(ns neural-network.core-test
  (:use clojure.test
        neural-network.core))

(import '(neuralnetworks.Neural_2H_momentum))

(def nn (neuralnetworks.Neural_2H_momentum. 3 3 3 3 0.2))

(println nn)
 
(def in1 (float-array [0.1 0.1 0.9]))
(println in1)

(def in2 (float-array [0.1 0.9 0.1]))
(def in3 (float-array [0.9 0.1 0.1]))

(def out1 (float-array [0.9 0.1 0.1]))
(def out2 (float-array [0.1 0.1 0.9]))
(def out3 (float-array [0.1 0.9 0.1]))

(def test1 (float-array [0.1 0.1 0.9]))
(def test2 (float-array [0.1 0.9 0.1]))
(def test3 (float-array [0.9 0.1 0.1]))

(.addTrainingExample nn in1 out1)
(.addTrainingExample nn in2 out2)
(.addTrainingExample nn in3 out3)

(doseq [i (range 300)] (println (.train nn))) ;; train net 300 cycles

;; test to make sure we have learned the input patterns:

(println (seq (.recall nn test1)))
(println (seq (.recall nn test2)))
(println (seq (.recall nn test3)))

