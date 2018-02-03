
public class LLVector {
	private LinkedList[] lists;
	private int size;
	
	public LLVector() {
		size = 0;
		lists = new LinkedList[size];
	}
	public int size() {
		return size;
	}
	public LinkedList get(int index) {
		return lists[index];
	}
	/**
	 * Adds a new LinkedList to the end of an array of LinkedList.
	 * @param a
	 */
	public void addElement(LinkedList a) {
		LinkedList[] temp = new LinkedList[++size];
		int i = 0;
		for (; i < lists.length; i++) {
			temp[i] = lists[i];
		}
		temp[i] = a;
		lists = temp;
	}
	
}
