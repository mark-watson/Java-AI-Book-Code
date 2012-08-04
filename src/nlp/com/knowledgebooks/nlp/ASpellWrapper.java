package nlp.com.knowledgebooks.nlp;

public class ASpellWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

/*  my old Ruby code:
def ASpell text
    response = `echo "#{text}" | /usr/local/bin/aspell -p ./my_custom_dict_300  -a list`
    response = response.split("\n")
    response.shift
    results = []
    response.each {|line|
        tokens = line.split(",")
        header = tokens[0].gsub(':','').split(' ')
        tokens[0] = header[4]
        results << [header[1], header[3], tokens.collect {|tt| tt.strip}]  if header[1]
    }
    results
end
 */