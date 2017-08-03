import lib.ListNode;

/**
 * Definition for singly-linked list.
 * public class lib.ListNode {
 *     int val;
 *     lib.ListNode next;
 *     lib.ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatedFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;                
        }
        
        return head;
    }
}
