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

        if (head.val == val)
            return removeElements(head.next, val);

        head.next = removeElements(head.next, val);

        return head;
    }

    // 1 --> 2 --> 2 --> 3 --> null
}
