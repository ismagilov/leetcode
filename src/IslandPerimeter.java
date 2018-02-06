/**
* https://leetcode.com/problems/island-perimeter/description/
*/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int p = 0;
        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                                    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int neighbs = 0;
                
                if (grid[i][j] == 0) continue;
                
                for (int k = 0; k < dirs.length; k++) {
                    int nr = i + dirs[k][0];
                    int nc = j + dirs[k][1];
                    
                    if (0 <= nr && nr < grid.length && 0 <= nc && nc < grid[0].length && grid[nr][nc] == 1)
                        neighbs++;
                }
                
                p += 4 - neighbs;
            }
        }
                                    
        return p;
    }
}
