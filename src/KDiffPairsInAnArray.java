/**
* https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
*/ 
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
            
        HashSet<Integer> ns = new HashSet<>();
        HashSet<String> ps = new HashSet<>();
        
        for (int x : nums) {
            if (ns.contains(x - k))
                ps.add(pair(x, x - k));
            if (ns.contains(x + k))    
                ps.add(pair(x, x + k));

            ns.add(x);
        }

        return ps.size();    
    }
    
    private String pair(int x, int y) {
        return x > y ? y + ";" + x : x + ";" + y;
    }
}
