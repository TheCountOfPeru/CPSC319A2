
public class stringVector {
	private String[] words;
	private int size;
	
	public stringVector() {
		size = 0;
		words = new String[size];
	}
	public int size() {
		return size;
	}
	public String get(int index) {
		return words[index];
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
	public void remove(int index) {
		String[] temp_arr = new String[--size];
		String temp_s = words[index];
		int j = 0;
		for(int i = 0;i<words.length; i++) {
			if(!temp_s.equals(words[i])) {
				temp_arr[j] = words[i];
				j++;
			}
		}
		words = temp_arr;	
	}
	public void print() {
		for (int j = 0; j < words.length; j++) {
			System.out.print(words[j] + " ");
		}
		System.out.println();
	}
}
