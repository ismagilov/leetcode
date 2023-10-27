class ReverseLinkedList206 {

    /*
    1 -> 4 -> 2 -> 7 -> null
    1 <- 4 -> 2 -> 7 -> null
     */

    fun reverseList(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var oldHead = head
        while (oldHead != null) {
            val afterOldHead = oldHead.next
            oldHead.next = newHead
            newHead = oldHead
            oldHead = afterOldHead
        }

        return newHead
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val n1 = ReverseLinkedList206.ListNode(1)
    val n2 = ReverseLinkedList206.ListNode(2)
    val n3 = ReverseLinkedList206.ListNode(3)
    n1.next = n2
    n2.next = n3

    val s = ReverseLinkedList206()

    val head = n1
    val res = s.reverseList(head)

    var iter = res
    while (iter != null) {
        print("${iter.`val`}->")
        iter = iter.next
    }
}