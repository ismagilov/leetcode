import lib.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 *
 * Recursive solution.
 */
public class RemoveLinkedListElementsB {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }

    // 1 --> 2 --> 2 --> 3 --> null
}
