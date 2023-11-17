import java.util.LinkedList
import kotlin.math.min

/**
 * https://leetcode.com/problems/min-stack/
 */
class MinStack155A {
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

class MinStackMinInSameStack() {
    val q = ArrayDeque<Entity>()

    fun push(`val`: Int) {
        if (q.isEmpty()) {
            q.addFirst(Entity(`val`, `val`))
        } else {
            val newMin = min(q.first().min, `val`)

            q.addFirst(Entity(`val`, newMin))
        }
    }

    fun pop() {
        q.removeFirstOrNull() ?: throw IllegalStateException()
    }

    fun top(): Int {
        return q.firstOrNull()?.value ?: throw IllegalStateException()
    }

    fun getMin(): Int {
        return q.firstOrNull()?.min ?: throw IllegalStateException()
    }

    data class Entity(val value: Int, val min: Int)
}

fun main() {
    val minStack = MinStackMinInSameStack()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top()) // return 0
    println(minStack.getMin()) // return -2
    minStack.pop()
    minStack.pop()
//    println(minStack.getMin()) // return MAX_VAL
}