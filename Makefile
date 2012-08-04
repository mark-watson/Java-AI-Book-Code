clean:
	rm -r -f out
	(cd clojure_examples; lein clean; rm -r -f lib/* classes)
