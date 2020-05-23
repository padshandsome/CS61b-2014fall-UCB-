package lab7;

/* ListNode.java */

/**
 *  ListNode is a very simple headless list class, akin to cons cells in
 *  Scheme.  Each ListNode contains an item and a reference to the next node.
 **/
class ListNode {

  public Object item;
  public ListNode next;

  /**
   *  Constructs a ListNode with item i and next node n.
   *  @param i the item to store in the ListNode.
   *  @param n the next ListNode following this ListNode.
   **/
  ListNode(Object i, ListNode n) {
    item = i;
    next = n;
  }

  /**
   *  listSum() computes the sum of terms in a list.  
   *  @param l is linked list represented by ListNodes.  Each item in the list
   *           is assumed to be a Double.
   */
  public static double listSum(ListNode l) {
    if (l == null) {
      return 0.0;
    }

    return ((Double) l.item).doubleValue() + listSum(l.next);
  }
}

