import kotlin.math.log
import kotlin.math.pow

/**
* https://leetcode.com/problems/powerful-integers/submissions/
*/
class PowerfulIntegers {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val dx = x.toDouble()
        val dy = y.toDouble()
        
        val maxi = log(bound.toDouble(), dx).toInt()
        val maxj = log(bound.toDouble(), dy).toInt()
            
        val powerfulSet = mutableSetOf<Int>()
        
        for (i in 0..maxi) {
            for (j in 0..maxj) {
                val n = (dx.pow(i) + dy.pow(j)).toInt()
                if (n <= bound)
                    powerfulSet.add(n)
            }
        }
            
        return powerfulSet.toList()
    }
}
