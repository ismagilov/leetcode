import java.util.HashSet;

/**
* https://leetcode.com/problems/number-of-islands/discuss/
*
* Union Find/Disjoint Set approach.
*/ 
public class NumberOfIslandsC {
    private boolean[][] visited;
    private int h;
    private int w;
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        h = grid.length;
        w = grid[0].length;
        
        DisjointSet ds = new DisjointSet(h * w);
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '0')
                    continue;
                
                if (i - 1 >= 0 && grid[i - 1][j] == '1') // up
                    ds.union(i * w + j, (i - 1) * w + j);
                if (i + 1 < h && grid[i + 1][j] == '1') // down
                    ds.union(i * w + j, (i + 1) * w + j);
                if (j - 1 >= 0 && grid[i][j - 1] == '1') // left
                    ds.union(i * w + j, i * w + j - 1);
                if (j + 1 < w && grid[i][j + 1] == '1') // right
                    ds.union(i * w + j, i * w + j + 1);
            }
        }

        HashSet<Integer> islands = new HashSet<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1')
                    islands.add(ds.find(i * w + j));
            }
        }
        
        return islands.size();
    }

    
    private static class DisjointSet {
        private final Set[] set;
        
        private DisjointSet(int sz) {
            set = new Set[sz];    
            
            for (int i = 0; i < sz; i++)
                set[i] = new Set(i, 0);
        }
        
        private int find(int val) {
            if (set[val].parent == val)
                return set[val].parent;
            
            int parent = find(set[val].parent);
            set[val].parent = parent;
            
            return parent;
        }
        
        private void union(int val1, int val2) {    
            int root1 = find(val1);
            int root2 = find(val2);
            
            if (root1 == root2)
                return;
            
            if (set[root1].rank > set[root2].rank) {    
                set[root2].parent = root1;
            } else if (set[root1].rank < set[root2].rank) {    
                set[root1].parent = root2;
            } else {
                set[root2].parent = root1;
                set[root1].rank++;
            }
        }
    }
    
    private static class Set {
        private int parent;
        private int rank;
        
        private Set(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
}
