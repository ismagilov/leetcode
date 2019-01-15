/**
* https://leetcode.com/problems/buddy-strings/
*/
class BuddyStrings {
    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) return false
        
        var diff = 0
        var i = -1
        var j = -1
        
        val count = mutableSetOf<Char>()
        for (idx in 0..A.length - 1) {
            if (A[idx] == B[idx]) {
                count.add(A[idx])        
            } else {
                diff++
                  
                if (i == -1) i = idx
                else if (j == -1) j = idx
            }
        }
        
        return if ((diff == 0 && count.size < A.length) || (diff == 2 && A[i] == B[j] && A[j] == B[i])) true else false
    }
}
