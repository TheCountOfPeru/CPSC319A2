public class stringVector {
	private String[] words;
	private int size;
	
	public stringVector() {
		size = 0;
		words = new String[10];
	}
	public int size() {
		return size;
	}
	public String get(int index) {
		return words[index];
	}
	public void addElement(String a) {
		if(size < words.length) {
			words[size] = a;
			size++;
		}
		else {
			String[] temp = new String[2*size];
			int i = 0;
			for (; i < words.length; i++) {
				temp[i] = words[i];
			}
			temp[i] = a;
			size = words.length;
			words = temp;
			size++;
		}
		
	}
	public void print() {
		for (int j = 0; j < words.length; j++) {
			System.out.print(words[j] + " ");
		}
		System.out.println();
	}
}
