package nlp.com.knowledgebooks.nlp.util;

public class NameValue <K, V> {
    private K name = null;
    private V value = null;
    public NameValue(K k, V v) {
        this.name = k;
        this.value = v;
    }
    public K getName() {
        return this.name;
    }
    public V getValue() {
        return this.value;
    }
    public void setValue(V val) {
        this.value = val;
    }
    public String toString() {
    	return "[NameValue: " + name + " : " + value + "]";
    }
}