
/**
* https://leetcode.com/problems/number-of-islands/description/
*
* Depth first seach approach.
*/
public class NumberOfIslandsA {
    private boolean[][] visited;
    private int h;
    private int w;
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        h = grid.length;
        w = grid[0].length;
        
        visited = new boolean[h][w];
        
        int count = 0;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    visitIsland(grid, r, c);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void visitIsland(char[][] grid, int row, int col) {
        visited[row][col] = true;
        
        int[] adjacentRows = new int[] {-1, 1, 0, 0}; // top, bottom, left, right
        int[] adjacentCols = new int[] {0, 0, -1, 1}; // top, bottom, left, right
        
        for (int i = 0; i < 4; i++) {
            int r = row + adjacentRows[i];
            int c = col + adjacentCols[i];
            
            if (isSafe(r, c) && grid[r][c] == '1' && !visited[r][c])
                visitIsland(grid, r, c);
        }
    }
    
    private boolean isSafe(int row, int col) {
        if (0 <= row && row < h && 0 <= col && col < w)
            return true;
        else
            return false;
    }
}
