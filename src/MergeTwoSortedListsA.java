import lib.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 *
 * Iterative solution.
 */
public class MergeTwoSortedListsA {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = tail.next;
                tail.next = l2;
                l1 = l1.next;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return head.next;
    }
}
