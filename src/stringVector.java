
public class stringVector {
	private String[] words;
	private int size;
	/**
	 * myVector constructor. Creates a new String array.
	 * @param size The size of the String array.
	 */
	public stringVector(int size) {
		size = this.size;
		words = new String[size];
	}
	public stringVector() {
		size = 0;
		words = new String[size];
	}
	public int size() {
		return size;
	}
	public String[] getWords() {
		return words;
	}
	public String get(int x) {
		return words[x];
	}
	/**
	 * Adds a new String to the end of an array of Strings.
	 * @param a
	 */
	public void addElement(String a) {
		String[] temp = new String[++size];
		int i = 0;
		for (; i < words.length; i++) {
			temp[i] = words[i];
		}
		temp[i] = a;
		words = temp;
	}
}
