/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * Two pointers solution: tail of odd and one before next odd. 
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedListA {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode l = head;
        ListNode r = head.next;
        
        while (r != null && r.next != null) {
            ListNode leftNext = l.next;
            
            l.next = r.next;
            r.next = r.next.next;
            
            l.next.next = leftNext;
            
            l = l.next;
            r = r.next;
        }
        
        return head;
    }
}
