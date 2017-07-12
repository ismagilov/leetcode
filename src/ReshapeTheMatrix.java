/**
* https://leetcode.com/problems/reshape-the-matrix
*/
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        
        if (r * c != rows * cols)
            return nums;
        
        int[][] res = new int[r][c];
        
        int x = 0, y = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[x][y] = nums[i][j];
                y = (y + 1) % c;
                if (y == 0) {
                    x = (x + 1) % r;
                    if (x == 0)
                        break;
                }
                
            }  
        }
        
        return res;
    }
}
