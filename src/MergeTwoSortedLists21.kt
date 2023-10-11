private class MergeTwoSortedLists21 {
    fun mergeTwoLists(list1: ListNode21?, list2: ListNode21?): ListNode21? {
        val head = ListNode21(Int.MIN_VALUE)

        var cur: ListNode21? = head
        var p1 = list1
        var p2 = list2
        while (p1 != null && p2 != null) {
            if (p1.`val` <= p2.`val`) {
                cur?.next = p1
                p1 = p1.next
            } else {
                cur?.next = p2
                p2 = p2.next
            }

            cur = cur?.next
        }

        if (p1 != null)
            cur?.next = p1
        else if (p2 != null)
            cur?.next = p2

        return head.next
    }
}

fun main() {
    val s = MergeTwoSortedLists21()

    println(s.mergeTwoLists(intArrayOf(1, 3, 5, 7).toList(), intArrayOf(2, 4, 6, 8).toList()))
    println(s.mergeTwoLists(intArrayOf(1, 3, 5, 7).toList(), intArrayOf().toList()))
    println(s.mergeTwoLists(intArrayOf(1, 3, 5, 7).toList(), intArrayOf(8, 10, 12).toList()))
}

private data class ListNode21(var `val`: Int, var next: ListNode21? = null) {
    override fun toString(): String {
        val node = this
        return buildString {
            var cur: ListNode21? = node
            while (cur != null) {
                append("${cur.`val`} -> ")
                cur = cur.next
            }
            append("null")
        }
    }
}

private fun IntArray.toList(): ListNode21? {
    if (this.isEmpty())
        return null

    val head = ListNode21(this[0])
    var cur: ListNode21? = head
    for (i in 1..<this.size) {
        cur?.next = ListNode21(this[i])
        cur = cur?.next
    }

    return head
}

