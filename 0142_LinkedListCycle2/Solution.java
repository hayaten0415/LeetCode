class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
        return null;
    }
        
    ListNode slow = head;
    ListNode fast = head;
    while(true) {
      if (fast.next == null || fast.next.next == null) {
          return null;
      }
      slow = slow.next;
      fast = fast.next.next;
      
      if (slow == fast) {
          break;
      }
    }
        
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
  }
}
