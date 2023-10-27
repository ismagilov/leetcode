import java.lang.IllegalStateException

/*

KeyMap<key, {value, freq}>
FreqMap<freq, [key]>

put {a, 7}
put {a, 3}
get {a}
put {b, 9}

get:
if missing
    return -1
if present:
    f++
    move to another freq in FreqMap
        remove freq key in FreqMap if empty
    return from KeyMap

put:
if missing
    f = 1
    KeyMap.put {key, {v, f}}
    FreqMap.put {1, key}
if present
    f++
    KeyMap.put {key, {v, f}}
    move to another freq in FreqMap
        remove freq key in FreqMap if empty
    return from KeyMap
*/

class LFUCache460(capacity: Int) {
    val cap = capacity
    var minF: Int = 0

    data class CountedValue(val v: Int, val f: Int = 1)

    private val keys = mutableMapOf<Int, CountedValue>()
    private val freqs = mutableMapOf<Int, LinkedHashSet<Int>>()

    fun get(key: Int): Int {
        val cv = keys[key] ?: return -1

        val newF = incFreq(key, cv)
        addValue(key, cv.copy(f = newF))

        return cv.v
    }

    fun put(key: Int, value: Int) {
        if (cap == 0) return

        if (keys.containsKey(key)) {
            val cv = keys[key] ?: throw IllegalStateException()

            val newF = incFreq(key, cv)
            addValue(key, cv.copy(v = value, f = newF))
        } else {
            if (keys.size == cap) {
                val iter = freqs[minF]?.iterator()
                keys.remove(iter?.next())
                iter?.remove()
            }

            val cv = CountedValue(value, 1)
            minF = 1
            addValue(key, cv)
        }
    }

    private fun incFreq(key: Int, cv: CountedValue): Int {
        val newF = cv.f + 1
        val keysWithFreq = freqs.getValue(cv.f)
        keysWithFreq.remove(key)
        if (keysWithFreq.isEmpty()) {
            freqs.remove(cv.f)

            if (minF == cv.f)
                minF = newF
        }

        return newF
    }

    private fun addValue(key: Int, cv: CountedValue) {
        keys[key] = cv
        freqs.getOrPut(cv.f) { LinkedHashSet() }.add(key)
    }
}

fun main() {
    val s = LFUCache460(2)

    println(s.put(3, 1))
    println(s.put(2, 1))
    println(s.put(2, 2))
    println(s.put(4, 4))
    println(s.get(2))
}