/**
 * https://leetcode.com/problems/linked-list-cycle 
 *
 * Definition for singly-linked list.
 * class lib.ListNode {
 *     int val;
 *     lib.ListNode next;
 *     lib.ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow)
                return true;
        }
        
        return false;
    }

    public boolean hasCycleB(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
