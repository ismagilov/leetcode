private class Node(val v: Int) {
     var next: Node? = null
}

private class PalindromeLinkedList234 {
    var front: Node? = null

    fun isPalindrome(head: Node?): Boolean {
        front = head
        return checkPalindrome(head)
    }

    private fun checkPalindrome(head: Node?): Boolean {
        if (head == null) return true

        if (checkPalindrome(head.next) && front?.v == head.v) {
            front = front?.next
            return true
        }

        return false
    }

    fun isPalindromeA(head: Node?): Boolean {
        val mid = findMiddle(head)
        val secondHead = reverseList(mid?.next)

        var h1 = head
        var h2 = secondHead
        while (h1 != null && h2 != null) {
            if (h1.v != h2.v) return false

            h1 = h1.next
            h2 = h2.next
        }

        return true
    }

    fun reverseList(head: Node?): Node? {
        var prev: Node? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }

    fun findMiddle(head: Node?): Node? {
        var slow = head
        var fast = head

        while(fast?.next != null && fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow
    }
}

fun main() {
    val s = PalindromeLinkedList234()

    println(s.findMiddle(intArrayOf(1, 2, 3).toList())?.v)
    println(s.findMiddle(intArrayOf(1, 2, 3, 4).toList())?.v)

    s.reverseList(intArrayOf(1, 2, 3, 4).toList())?.printList()
    s.reverseList(intArrayOf(1).toList())?.printList()
    s.reverseList(intArrayOf(1, 2).toList())?.printList()

    println(s.isPalindrome(intArrayOf(1, 2, 3).toList()))
    println(s.isPalindrome(intArrayOf(1).toList()))
    println(s.isPalindrome(intArrayOf(1, 2, 3, 2, 1).toList()))
    println(s.isPalindrome(intArrayOf().toList()))
}

private fun IntArray.toList(): Node? {
    var head: Node? = null
    var next: Node? = null

    for (i in this.indices.reversed()) {
        head = Node(this[i])
        head.next = next

        next = head
    }

    return head
}

private fun Node.printList() {
    var cur: Node? = this
    while (cur != null) {
        print("${cur.v} -> ")
        cur = cur.next
    }
    println("null")
}