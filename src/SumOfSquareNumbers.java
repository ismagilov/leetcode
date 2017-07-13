/**
* https://leetcode.com/articles/sum-of-square-numbers/
*
* Solved, determining if b*b is perfect square by Math.sqrt.
*/
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c / 2; a++) {
            int b2 = c - a * a;
            
            double b = Math.sqrt(b2);
            if (b % 1 == 0)
                return true;
        }
        
        return false;
    }
}
