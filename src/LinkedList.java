
public class LinkedList{
	private int sizeM;
    private Node headM;
    private Node cursorM;
			   
    public LinkedList(){
		sizeM = 0;
		headM = null;
		cursorM = null;
	}
	public int size(){
	  return sizeM;
	}
	public boolean cursor_ok(){
	  return cursorM != null;
	}
	public String cursor()   
	{
	  assert(cursor_ok());
	  return cursorM.item; 
	}
    public void push_back(String itemA){
    	Node new_node = new Node(itemA, null);
	  if(headM == null)
		  headM = new_node;
	  else {
	      cursorM = headM.next;
	      Node p = headM;
	      while (cursorM != null){
		    cursorM = cursorM.next;
		    p = p.next;
	      }
	      p.next = new_node;
       }  
	   sizeM++;
     }


	
}
