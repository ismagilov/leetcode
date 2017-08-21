import lib.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 *
 * Iterative solution.
 */
public class RemoveLinkedListElementsA {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head.next = head;

        //1 --> 2 --> 3 --> 3 --> 5 --> null

        ListNode cur = head; // head doesn't have val
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        RemoveLinkedListElementsA r = new RemoveLinkedListElementsA();

        System.out.println(r.removeElements(head, 1));
    }
}
