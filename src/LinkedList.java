
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
		  System.out.println(getCursor().getItem());
		  setCursor(getCursor().getNext());
	  }
	}
	public Node getCursor() {
		return cursor;
	}
	public void setCursor(Node cursor) {
		this.cursor = cursor;
	}

	
}
