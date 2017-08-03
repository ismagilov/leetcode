/**
* https://leetcode.com/problems/sum-of-square-numbers
*/
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        //3^19 == 1162261467
        return n > 0 && (1162261467 % n) == 0;
    }
}
