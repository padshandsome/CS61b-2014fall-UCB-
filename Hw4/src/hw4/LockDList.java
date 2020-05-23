package hw4;

public class LockDList extends DList {

	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new LockDListNode(item, prev, next);
	  }
	
	
	public void locknode(DListNode node)
	{
		LockDListNode temp=(LockDListNode)node;
		temp.lock=true;
	}
	
public static void main(String[] args)
{
	LockDList test=new LockDList();
	test.insertFront(1);
	System.out.println(test.head.next.lock);
}
}
