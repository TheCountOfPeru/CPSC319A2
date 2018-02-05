
public class myLinkedList {
	private Node head;
	private Node tail;
	
	public myLinkedList() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void addToHead(String el) {
		head = new Node(el,head);
		if (tail == null)
			tail = head;
	}
	public void addToTail(String el) {
		if (!isEmpty()) {
			tail.next = new Node(el);
			tail = tail.next;
		}
		else 
			head = tail = new Node(el);
	}
	public String deleteFromHead() { // delete the head and return its info;
			String el = head.item;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else 
			head = head.next;
		return el;
	}
	public void printAll() {
		for (Node tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.item + " ");
	}
	public boolean isInList(String el) {
		Node tmp;
		for (tmp = head; tmp != null && !tmp.item.equals(el); tmp = tmp.next);
		return tmp != null;
	}
	/**
	 * Adapted from https://www.programcreek.com/2012/11/leetcode-solution-sort-a-linked-list-using-insertion-sort-in-java/
	 */
	public void insertionSort() {
		//First check if the linkedlist is empty or has only one node
		if (head == null || head.getNext() == null)
			return;
		
		//We will allocate a new linkedlist and add to it from the old linkedlist except it will sort the items
		Node newhead = new Node(head.getItem());
		Node pointer = head.getNext();

		// loop through each element in the list until you get a null node
		while (pointer != null) {
			
			// insert this element to the new list
			Node innerPointer = newhead;
			Node next = pointer.getNext();
			
			if (pointer.getItem().compareTo(newhead.getItem()) <= 0) {
				Node oldhead = newhead;
				newhead = pointer;
				newhead.setNext(oldhead);
			}
			else {
				while (innerPointer.getNext() != null) {
					if (pointer.getItem().compareTo(innerPointer.getItem()) > 0 && pointer.getItem().compareTo(innerPointer.getNext().getItem()) <= 0) {
						Node oldNext = innerPointer.getNext();
						innerPointer.setNext(pointer);
						pointer.setNext(oldNext);
					}
					innerPointer = innerPointer.getNext();
				}
				
					if(innerPointer.getNext() == null && pointer.getItem().compareTo(innerPointer.getItem()) > 0) {
						innerPointer.setNext(pointer);
						pointer.setNext(null);
					}
			}
			// finally
			pointer = next;	
		}
		head = newhead;
	}
}
