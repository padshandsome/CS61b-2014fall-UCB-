package List;

public class SList {
  int size;
  SListNode head;
  
  public SList()
  {
	  size=0;
	  head=null;
  }
  
  public boolean isEmpty()
  {
	  if(size==0)
		  return true;
	  else return false;
  }
  
  public void insertFront(Object obj)
  {
	  if(size!=0)
	  {
		  head.next=new SListNode(obj,head.next);
		  size++;
	  }
	  else if(size==0)
	  {
		  head=new SListNode(obj);
		  size++;
	  }  
  }
  
  public void insertEnd(Object obj)
  {
	  if(size==0)
	  {
		  this.insertFront(obj);
	  }
	  else if(size!=0)
	  {
		  SListNode idx=head;
		  while(idx.next!=null)
		  {
			  idx=idx.next;
		  }
		  idx.next=new SListNode(obj);
		  size++;
	  }
  }
  
  public SListNode front()
  {
	  return head;
  }
  
  public String toString()
  {
	  String results="[ ";
	  SListNode idx=head;
	  while(idx!=null)
	  {
		  results=results+idx.item+" ";
		  idx=idx.next;
	  }
	  return results+"]";
  }
  
  public void removeFront()
  {
	  if(head.next!=null)
	  {
		  head=head.next;
	  }
  }
  
  public static void main(String[] args)
  {
	  SList test=new SList();
	  test.insertFront(5);
	  System.out.println(test);
	  test.insertEnd(6);
	  System.out.println(test);
	  System.out.println(test.front());
  }
}
