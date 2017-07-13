/**
* https://leetcode.com/problems/minimum-moves-to-equal-array-elements
* 
* sum - sum of all elements
* m - number of moves
* x - new final value of all elements
* n - num of elements in array
*
* sum + m * (n - 1) = x * n
* min + m = x
* sum + m * (n - 1) = min * n + m * n ==> sum - min * n = m
*/
public class MovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;
        
        for (int n : nums)
            min = Math.min(min, n);
        for (int n : nums)
            moves += n - min;
        
        return moves;
    }
}
