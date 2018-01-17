import lib.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Recursion approach.
 *
 * Definition for singly-linked list.
 * public class lib.ListNode {
 *     int val;
 *     lib.ListNode next;
 *     lib.ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListA {
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
