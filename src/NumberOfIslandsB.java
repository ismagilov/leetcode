/**
* https://leetcode.com/problems/number-of-islands/description/
*
* Breadth first search approach.
*/
public class NumberOfIslandsB {
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
        int[] adjacentRows = new int[] {-1, 1, 0, 0}; // top, bottom, left, right
        int[] adjacentCols = new int[] {0, 0, -1, 1}; // top, bottom, left, right
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(row * w + col);
        while (!q.isEmpty()) {
            int idx = q.poll();
            int r = idx / w, c = idx % w;
            if (visited[r][c]) 
                continue;
            
            visited[r][c] = true; 
            for (int i = 0; i < 4; i++) {
                int nr = r + adjacentRows[i];
                int nc = c + adjacentCols[i];

                if (isSafe(nr, nc) && grid[nr][nc] == '1' && !visited[nr][nc])
                    q.offer(nr * w + nc);
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        if (0 <= row && row < h && 0 <= col && col < w)
            return true;
        else
            return false;
    }
}
