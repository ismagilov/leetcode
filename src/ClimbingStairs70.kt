class ClimbingStairs70 {
    fun climbStairs(n: Int): Int {
        var prevPrev = 0
        var prev = 1
        var steps = 0
        for (i in 1..n) {
            steps = prev + prevPrev
            prevPrev = prev
            prev = steps
        }

        return steps
    }
}