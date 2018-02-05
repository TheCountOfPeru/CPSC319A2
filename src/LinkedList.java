
public class LinkedList{
	private int size;
    private Node head;
    private Node cursor;
			   
    public LinkedList(){
		size = 0;
		head = null;
		setCursor(null);
	}
	public int size(){
	  return size;
	}
	public void cursor_to_start() {
		setCursor(head);
	}
	public boolean cursor_ok(){
	  return getCursor() != null;
	}
	public String cursor()   
	{
	  assert(cursor_ok());
	  return getCursor().getItem(); 
	}
	/**
	 * Puts a new node at the end of a linked list.
	 * @param itemA
	 */
    public void push_back(String itemA){
    	Node new_node = new Node(itemA, null);
	  if(head == null)
		  head = new_node;
	  else {
	      setCursor(head.getNext());
	      Node p = head;
	      while (getCursor() != null){ 
		    setCursor(getCursor().getNext());
		    p = p.getNext();
	      }
	      p.setNext(new_node);
       }  
	   size++;
    }
    public void find(String someString )
	{
    	Node ptr= head;
    	while (ptr!= null && (ptr.getItem().compareTo(someString) > 0 || ptr.getItem().compareTo(someString) < 0))
		{
			ptr=ptr.getNext();
		}
		cursor = ptr;
	}
    public void print()
	{ 
	  setCursor(head);
	  while (getCursor() != null){ 
		  System.out.print(getCursor().getItem() + " ");
		  setCursor(getCursor().getNext());
	  }
	}
	public Node getCursor() {
		return cursor;
	}
	public void setCursor(Node cursor) {
		this.cursor = cursor;
	}
	public void   make_empty()
	{
      head = null;
	  size = 0;
	  cursor = null;
	}
	public void insertionSort() {
		if (head == null || head.getNext() == null)
			return;
		System.out.println("Sorting...");
		Node newhead = new Node(head.getItem(), head.getNext());
		Node pointer = head.getNext();
		System.out.println(head.getItem());
		// loop through each element in the list
		while (head.getNext() != null) {
			System.out.println("Sorting...");
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
					if(innerPointer.getNext() == null && pointer.getItem().compareTo(innerPointer.getItem()) > 0) {
						innerPointer.setNext(pointer);
						pointer.setNext(null);
					}
				}
				// finally
				pointer = next;
			}
				
		}
		head = newhead;
	}
	
}
