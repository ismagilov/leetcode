import java.util.LinkedList

/**
 * https://leetcode.com/problems/min-stack/
 */
class MinStack155 {
    private val values = LinkedList<Int>()
    private val mins = LinkedList<CountedMin>()
    private var min: Int = Int.MAX_VALUE

    fun push(x: Int) {
        values.push(x)

        if (x <= min) {
            min = x
            mins.push(CountedMin(x))
        } else {
            mins.peek().counter++
        }
    }

    fun pop() {
        values.pop()

        val curMin = mins.peek()
        curMin.counter--
        if (curMin.counter == 0) {
            mins.pop()
            min = mins.peek()?.value ?: Int.MAX_VALUE
        }
    }

    fun top(): Int {
        return values.peek()
    }

    fun getMin(): Int {
        return min
    }
}

private data class CountedMin(val value: Int, var counter: Int = 1)

fun main() {
    val minStack = MinStack155()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top()) // return 0
    println(minStack.getMin()) // return -2
    minStack.pop()
    minStack.pop()
    println(minStack.getMin()) // return MAX_VAL
}