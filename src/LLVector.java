
public class LLVector {
	myLinkedList[] lists;
	int size;
	
	public LLVector() {
		size = 0;
		lists = new myLinkedList[size];
	}
	public int size() {
		return size;
	}
	public myLinkedList get(int index) {
		return lists[index];
	}
	/**
	 * Adds a new LinkedList to the end of an array of LinkedList.
	 * @param myLinkedList
	 */
	public void addElement(myLinkedList myLinkedList) {
		myLinkedList[] temp = new myLinkedList[++size];
		int i = 0;
		for (; i < lists.length; i++) {
			temp[i] = lists[i];
		}
		temp[i] = myLinkedList;
		lists = temp;
	}
	
}
