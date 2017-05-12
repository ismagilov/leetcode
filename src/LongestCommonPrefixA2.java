/**
* Editorial solution: Approach #3 (Divide and conquer)
*/
public class LongestCommonPrefixA2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        return lcp(strs, 0, strs.length - 1);
    }
    
    public String lcp(String[] strs, int l, int r) {
        if (l == r)
            return strs[l];
            
        int mid = l + (r - l) / 2;
        
        String s1 = lcp(strs, l, mid);
        String s2 = lcp(strs, mid + 1, r);
        
        return getCommon(s1, s2);
    }
    
    public String getCommon(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        
        int i = 0;
        for (i = 0; i < min; i++) {
            if (!s1.startsWith(s2.substring(0, i + 1)))
                break;
        }
        
        return s1.substring(0, i);
    }
}

