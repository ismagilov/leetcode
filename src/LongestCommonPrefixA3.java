/**
* Editorial solution: Approach #4 (Binary search)
*/
public class LongestCommonPrefixA3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int min = Integer.MAX_VALUE;
        
        for (String s : strs)
            min = Math.min(min, s.length()); //4
            
        int left = 0;
        int right = min;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasCommon(strs, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return strs[0].substring(0, res);
    }
    
    private boolean hasCommon(String[] strs, int idx) {
        String prefix = strs[0].substring(0, idx);
        
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(prefix))
                return false;
        
        return true;
    }
}



