public class Node {
	private String item;
	private Node next;
	public Node(String i){
		setItem(i); 
		setNext(null);
	}
	public Node(String itemA, Node nextA){
		setItem(itemA) ;
		setNext(nextA);
	}
	public String getItem() {
		return item;
	}
	public void setItem(String itemA) {
		item = itemA;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node nextA) {
		next = nextA;
	}

}
