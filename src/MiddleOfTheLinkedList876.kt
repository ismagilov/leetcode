/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
private class MiddleOfTheLinkedList876 {
    fun middleNodeA(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow
    }

    fun middleNodeB(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {
    val s = MiddleOfTheLinkedList876()

    println(s.middleNodeB(intArrayOf(1, 2, 3).toList())?.toString())
    println(s.middleNodeB(intArrayOf(1, 2, 3, 4).toList())?.toString())
    println(s.middleNodeB(intArrayOf(1).toList())?.toString())
    println(s.middleNodeB(intArrayOf().toList())?.toString())

//    val lnLast = ListNode(0)
//    val ln1 = ListNode(1, lnLast)
//    val ln2 = ListNode(2, ln1)
//    val ln3 = ListNode(3, ln2)
//
//    println(MiddleOfTheLinkedList876().middleNode(lnLast))
//    println(MiddleOfTheLinkedList876().middleNode(ln1))
//    println(MiddleOfTheLinkedList876().middleNode(ln2))
//    println(MiddleOfTheLinkedList876().middleNode(ln3))


}

private fun IntArray.toList(): ListNode? {
    if (this.isEmpty())
        return null

    val head = ListNode(this[0])
    var cur: ListNode? = head
    for (i in 1..<this.size) {
        cur?.next = ListNode(this[i])
        cur = cur?.next
    }

    return head
}

private data class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        val node = this
        return buildString {
            var cur: ListNode? = node
            while (cur != null) {
                append("${cur.`val`} -> ")
                cur = cur.next
            }
            append("null")
        }
    }
}


