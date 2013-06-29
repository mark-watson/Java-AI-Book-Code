# This directory accompanies the Chapter on Data Science

You will need to run the script best_ngrams.rb 5 times, setting the variable $$match$$ to:

    1gram
    2gram
    3gram
    4gram
    5gram

And Adjusting the value of $$CUTOFF$$.

Also, on the leased Linux server I used, I was putting the best ngram data (best in the sense that I only kept ngrams with a use count greater than $$CUTOFF$$) in my home directory "/home/markw" - you will want to change the target directory for your system.

~~~~~~~~
match = "3gram"
CUTOFF = 500

$words = "====="
$count = 0

$out = File.new("/home/markw/#{match}.txt", 'w')

File.new("ngrams_uris.txt").lines.each do |line|
  if line.index("<a href='") && line.index(match)
~~~~~~~~

