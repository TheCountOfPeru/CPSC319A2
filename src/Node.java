
public class Node {
	private String item;
	private Node next;
	public Node(){
		setItem(null); 
		setNext(null);
	}
	public Node(String itemA, Node nextA){
		setItem(itemA) ;
		setNext(nextA);
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
