import lib.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        
        node.val = next.val;
        node.next = next.next;
    }
}
