import java.io.PrintWriter;

public class LLVector {
	/**
	 * An array of myLinkedLists
	 */
	myLinkedList[] lists;
	/**
	 * Size of the array of myLinkedLists
	 */
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
	public void set(int index, myLinkedList list) {
		lists[index] = list;
	}
	/**
	 * Adds a new LinkedList to the end of an array of LinkedList.
	 * @param aLinkedList
	 */
	public void addElement(myLinkedList aLinkedList) {
		myLinkedList[] temp = new myLinkedList[++size];
		int i = 0;
		for (; i < lists.length; i++) {
			temp[i] = lists[i];
		}
		temp[i] = aLinkedList;
		lists = temp;
	}
	public void printLLVector(PrintWriter writer) {
		for (int i = 0; i < size; i++) {
			lists[i].printAll(writer);
			writer.println();
		}
	}
	public void insertionSortAllindex() {

		for (int i = 0; i < size; i++) {
			lists[i].insertionSortLL();
		}
	}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.474
	 */
	public void swap(int last, int max) {
		myLinkedList tmp = lists[last]; 
		lists[last] = lists[max]; 
		lists[max] = tmp;
		}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.489
	 */
	public void quicksort(int first, int last) {
		int lower = first + 1, upper = last;
		swap(first,(first+last)/2);
		String bound = lists[first].getheadItem();
		while (lower <= upper) {
				while (bound.compareTo(lists[lower].getheadItem()) > 0) {
					lower++;
				}
				while (bound.compareTo(lists[upper].getheadItem()) < 0) { 
					upper--;
				if (lower < upper)
					swap(lower++,upper--);
				else lower++;
			}
				swap(upper,first);
				if (first < upper-1)
					quicksort(first,upper-1);
				if (upper+1 < last)
					quicksort(upper+1,last);
			}
		}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.489
	 */
	public void quicksort() {
		if (size < 2)
			return;
		int max = 0;
		// find the largest element and put it at the end of data;
		for (int i = 1; i < size; i++) {
			if (lists[max].getheadItem().compareTo(lists[i].getheadItem()) < 0){
				max = i;
			}
		}
		swap(size-1,max); 		// largest el is now in its
		quicksort(0,size - 2); 	// final position;
		}
	
}
