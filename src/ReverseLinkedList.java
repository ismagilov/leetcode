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
        //head: 1 --> 2 --> null
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
