class HappyNumber {
    fun isHappyA(n: Int): Boolean {
        var nextN = n
        val cycle = mutableSetOf<Int>()
        while (nextN != 1 && !cycle.contains(nextN)) {
            cycle.add(nextN)
            nextN = getNext(nextN)
        }

        return nextN == 1
    }

    fun isHappyB(n: Int): Boolean {
        var slow = n
        var fast = getNext(n)
        while (fast != 1 && fast != slow) {
            slow = getNext(slow)
            fast = getNext(getNext(fast))
        }

        return fast == 1
    }

    private fun getNext(n: Int): Int {
        var nd = n
        var total = 0
        while (nd > 0) {
            val d = nd % 10
            total += d * d
            nd /= 10
        }

        return total
    }
}

fun main() {
    println(HappyNumber().isHappyB(1))
    println(HappyNumber().isHappyB(19))
    println(HappyNumber().isHappyB(48))
    println(HappyNumber().isHappyB(9999))
}