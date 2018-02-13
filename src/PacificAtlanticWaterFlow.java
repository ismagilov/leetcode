/**
* https://leetcode.com/problems/pacific-atlantic-water-flow/description/
*/
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new ArrayList<int[]>();
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        boolean[][] av = new boolean[h][w];
        boolean[][] pv = new boolean[h][w];
        
        Deque<int[]> aq = new ArrayDeque<>();
        Deque<int[]> pq = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            pq.offer(new int[]{0, i});
            aq.offer(new int[]{h - 1, i});
        }
        for (int i = 0; i < h; i++) {
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, w - 1});
        }
        
        bfs(aq, matrix, av);
        bfs(pq, matrix, pv);
        
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (av[i][j] && pv[i][j])
                    res.add(new int[]{i, j});
            }
        }
        
        return res;
    }
    
    private void bfs(Deque<int[]> q, int[][] matrix, boolean[][] visited) {
        int h = matrix.length;
        int w = matrix[0].length;

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            
            for (int i = 0; i < dirs.length; i++) {
                int r = cur[0] + dirs[i][0], c = cur[1] + dirs[i][1];
                
                if (isInside(h, w, r, c) && !visited[r][c] && matrix[cur[0]][cur[1]] <= matrix[r][c])
                    q.offer(new int[]{r, c});
            }
        }
        
        return;
    }
    
    private boolean isInside(int h, int w, int r, int c) {
        return 0 <= r && r < h && 0 <= c && c < w;
    }
}
