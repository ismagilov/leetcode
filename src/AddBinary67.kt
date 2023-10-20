class AddBinary67 {
    fun addBinary(a: String, b: String): String {
        val la = a.length
        val lb = b.length
        if (la < lb) return addBinary(b, a)

        var carry = 0
        var result = StringBuilder()
        var j = b.length - 1
        for (i in a.length - 1 downTo 0) {
            val d1 = a[i].digitToInt()
            var d2 = when (j >= 0) {
                true -> b[j].digitToInt()
                false -> 0
            }
            j--
            val sum = d1 + d2 + carry
            result.append((sum % 2).digitToChar())

            carry = sum / 2
        }

        if (carry == 1)
            result.append('1')

        return result.reversed().toString()
    }
}

fun main() {
    val s = AddBinary67()

    println(s.addBinary("11", "11"))
    println(s.addBinary("11", "1"))
    println(s.addBinary("111", "1"))
    println(s.addBinary("111", "10"))
}