/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
            
        if (head.next == null)
            return head;
            
        ListNode p = reverseList(head.next);    
        
        head.next.next = head;
        head.next = null;
        
        return p;
    }
}
