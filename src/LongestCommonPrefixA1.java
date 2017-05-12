/**
* My own approach: vertical search.
*/
public class LongestCommonPrefixA1 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        if (strs.length == 0)
            return "";
        
        String base = strs[0];
        for (int i = 0; i < base.length(); i++) {
            boolean found = true;
            for (int j = 1; j < strs.length; j++ ) {
                if (i == strs[j].length() || base.charAt(i) != strs[j].charAt(i)) {
                    found = false;
                    break;
                }
            }
            
            if (found) sb.append(base.charAt(i));
            else break;
        }
        
        return sb.toString();
    }
}
