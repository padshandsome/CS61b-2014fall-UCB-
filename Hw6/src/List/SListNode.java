package List;

public class SListNode {
    public Object item;
    public SListNode next;
    
    public SListNode(Object item,SListNode next)
    {
    	this.item=item;
    	this.next=next;
    }
    
    public SListNode(Object item)
    {
    	this(item,null);
    }
}
