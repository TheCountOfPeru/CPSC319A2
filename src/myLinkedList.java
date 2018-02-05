
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
	
}
