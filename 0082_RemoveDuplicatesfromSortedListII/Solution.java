
 //Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode previous = new ListNode(-1);
        previous.next = head;
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next;
            boolean delete = false;
            while(temp != null && current.val == temp.val) {
                temp = temp.next;
                delete = true;
            }
            if(delete) {
                previous.next = temp;
                if(current == head) head = temp;
                delete = false;
            } else {
                previous = previous.next;
            }
            current = temp;
        }
        return head;
    }
}
