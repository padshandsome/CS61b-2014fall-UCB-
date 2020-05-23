package hw4;

public class LockDListNode extends DListNode {

     boolean lock;
	
	LockDListNode(Object i,DListNode p,DListNode n)
	{
		super(i,p,n);
		lock=false;
	}
}
