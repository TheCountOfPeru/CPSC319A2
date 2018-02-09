import java.io.PrintWriter;

public class myLinkedList {
	private Node head;
	private Node tail;
	
	public myLinkedList() {
		setHead(tail = null);
	}
	public boolean isEmpty() {
		return getHead() == null;
	}
	public void addToHead(String el) {
		setHead(new Node(el,getHead()));
		if (tail == null)
			tail = getHead();
	}
	public void addToTail(String el) {
		if (!isEmpty()) {
			tail.next = new Node(el);
			tail = tail.next;
		}
		else 
			setHead(tail = new Node(el));
	}
	public String deleteFromHead() { // delete the head and return its info;
			String el = getHead().item;
		if (getHead() == tail) // if only one node on the list;
			setHead(tail = null);
		else 
			setHead(getHead().next);
		return el;
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	public void printAllFile(PrintWriter writer) {
		for (Node tmp = getHead(); tmp != null; tmp = tmp.next)
			writer.print(tmp.item + " ");
	}
	public void printAllConsole() {
		for (Node tmp = getHead(); tmp != null; tmp = tmp.next)
			System.out.print(tmp.item + " ");
	}
	public boolean isInList(String el) {
		Node tmp;
		for (tmp = getHead(); tmp != null && !tmp.item.equals(el); tmp = tmp.next);
		return tmp != null;
	}
	public String getheadItem() {
		return getHead().item;
	}
	public void append(Node addition) {
		if(head == null) {//When Linkedlist is empty set the addition as the first node
			head = tail = addition;
		}
		else {//When the linkedlist has 1 or more nodes set addition to be after tail and move tail to the new last node.
			tail.setNext(addition);
			tail = tail.next;
		}
	}
	/**
	 * Adapted from https://www.programcreek.com/2012/11/leetcode-solution-sort-a-linked-list-using-insertion-sort-in-java/
	 */
	public void insertionSortLL() {
		//First check if the linkedlist is empty or has only one node
		if (getHead() == null || getHead().getNext() == null)
			return;
		
		//We will allocate a new linkedlist and add to it from the old linkedlist except it will sort the items
		Node newhead = new Node(getHead().getItem());
		Node pointer = getHead().getNext();

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
		setHead(newhead);
	}
}
