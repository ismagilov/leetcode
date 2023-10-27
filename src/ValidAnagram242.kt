class ValidAnagram242 {
    fun isAnagram(s: String, t: String): Boolean {
        return s.groupingBy { it }.eachCount() == t.groupingBy { it }.eachCount()
    }

    fun isAnagramB(s: String, t: String): Boolean {
        return s.toCharArray().sorted() == t.toCharArray().sorted()
    }
}

fun main() {
    println(ValidAnagram242().isAnagram("rat", "car"))
    println(ValidAnagram242().isAnagram("anagram", "nagaram"))
}