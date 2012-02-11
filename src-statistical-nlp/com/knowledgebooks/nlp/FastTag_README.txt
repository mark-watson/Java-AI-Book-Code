USE:

Both versions of FastTag are packaed as Java JAR files that contain source code, compiled
code, and required data. While FastTag is intended to use as a library, you can also run
it as a standalone application:

java -jar fasttag.jar "The ball rolled down the street."

Note: there is a small startup time when the Java loader loads the FastTag JAR file. This
does not affect its performance when used as a library but does add a second or two of
startup time when using FastTag as a standalone application.

ACKNOWLEDGMENTS:

1. Eric Brill for his lexicon and trained rule set:   http://www.cs.jhu.edu/~brill/

2. Medpost team for their tagging lexicon:            http://mmtx.nlm.nih.gov/MedPost_SKR.shtml


TAG DEFINITIONS:

CC Coord Conjuncn           and,but,or
NN Noun, sing. or mass      dog
CD Cardinal number          one,two
NNS Noun, plural            dogs
DT Determiner               the,some
NNP Proper noun, sing.      Edinburgh
EX Existential there        there
NNPS Proper noun, plural    Smiths
FW Foreign Word             mon dieu
PDT Predeterminer           all, both
IN Preposition              of,in,by
POS Possessive ending       ’s
JJ Adjective                big
PP Personal pronoun         I,you,she
JJR Adj., comparative       bigger
PP$ Possessive pronoun      my,one’s
JJS Adj., superlative       biggest
RB Adverb                   quickly
LS List item marker         1,One
RBR Adverb, comparative     faster
MD Modal                    can,should
RBS Adverb, superlative     fastest
RP Particle                 up,off
WP$ Possessive-Wh           whose
SYM Symbol                  +,%,&
WRB Wh-adverb               how,where
TO “to”                     to
$ Dollar sign               $
UH Interjection             oh, oops
# Pound sign                #
VB verb, base form          eat
" quote                     "
VBD verb, past tense        ate
VBG verb, gerund            eating
( Left paren                (
VBN verb, past part         eaten
) Right paren               )
VBP Verb, present           eat
, Comma                     ,
VBZ Verb, present           eats
. Sent-final punct          . ! ?
WDT Wh-determiner           which,that
: Mid-sent punct.           : ; —
WP Wh pronoun               who,what


MEDPOST TAG DEFINITIONS:

CC coordinating conjunction
CS subordinating conjunction
CSN comparative conjunction (than)
CST complementizer (that)
DB predeterminer
DD determiner
EX existential there
GE genitive marker ’s
II preposition
JJ adjective
JJR comparative adjective
JJT superlative adjective
MC number or numeric
NN noun
NNP proper noun
NNS plural noun
PN pronoun
PND determiner as pronoun
PNG genitive pronoun
PNR relative pronoun
RR adverb 
RRR comparative adverb
RRT superlative adverb
SYM symbol
TO infinitive marker to
VM modal
VBB base be, am, are
VBD past was, were
VBG participle being
VBI infinitive be
VBN participle been
VBZ 3rd pers. sing. is
VDB base do
VDD past did
VDG participle doing
VDI infinite do
VDN participle done
VDZ 3rd pers. sing. does
VHB base have
VHD past had
VHG participle having
VHI infinitive have
VHN participle had
VHZ 3rd pers. sing. has
VVB base form lexical verb
VVD past tense
VVG present part.
VVI infinitive lexical verb
VVN past part.
VVZ 3rd pers. sing.
VVNJ prenominal past part.
VVGJ prenominal present part.
VVGN nominal gerund
( left parenthesis
) right parenthesis
, comma
. end-of-sentence period
: dashes, colons
`` left quote
 ? ? right quo

