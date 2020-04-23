/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
private class MiddleOfTheLinkedList876 {
    fun middleNode(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow
    }
}

fun main() {
    val lnLast = ListNode(0)
    val ln1 = ListNode(1, lnLast)
    val ln2 = ListNode(2, ln1)
    val ln3 = ListNode(3, ln2)

    println(MiddleOfTheLinkedList876().middleNode(lnLast))
    println(MiddleOfTheLinkedList876().middleNode(ln1))
    println(MiddleOfTheLinkedList876().middleNode(ln2))
    println(MiddleOfTheLinkedList876().middleNode(ln3))
}

private data class ListNode(var `val`: Int, var next: ListNode? = null)

