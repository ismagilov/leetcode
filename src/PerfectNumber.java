/**
* https://leetcode.com/problems/perfect-number
*/
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        
        double upper = Math.sqrt(num);
        
        int sum = 1;
        for (int d = 2; d < upper; d++) {
            if (num % d == 0) {
                sum += d;
                sum += num / d;
            }
        }
        
        return sum == num;
    }
}
