/**
 * https://leetcode.com/problems/reorder-list
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode l = head.next;
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;
        }

        l = head;
        for (int i = 0; i < cnt / 2; i++)
            l = l.next;

        ListNode second = l.next;
        l.next = null;

        second = reverse(second);
        
        ListNode l1 = head.next, l2 = second;
        ListNode end = head;
        while (l1 != null || l2 != null) {
            if (l2 != null) {
                end.next = l2;
                l2 = l2.next;
                end = end.next;
            }
            
            if (l1 != null) {
                end.next = l1;
                l1 = l1.next;
                end = end.next;
            }
        }
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode cur = head; //0
        ListNode next = cur.next; //1

        while (cur != null) {
            next = cur.next; //1

            cur.next = prev; //null
            prev = cur; //0
            cur = next; //1
        }

        return prev;
    }
}
