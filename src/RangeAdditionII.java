/**
* https://leetcode.com/problems/range-addition-ii
*/
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return m * n;
            
        int minr = 40001, minc = 40001;
        
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < minr)
                minr = ops[i][0];

            if (ops[i][1] < minc)
                minc = ops[i][1];
        }
        
        return minr * minc;
    }
}
