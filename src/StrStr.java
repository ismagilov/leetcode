/**
* https://leetcode.com/problems/implement-strstr/description/
*/
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null)
            return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
            
            if (j == needle.length())
                return i;
        }
        
        return -1;
    }
}
