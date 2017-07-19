/**
* https://leetcode.com/problems/reverse-string-ii
*/
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
    
        for (int i = 0; i < s.length(); i += k) {
            String sub = s.substring(i, Math.min(i + k, s.length()));
            
            if (i / k % 2 == 0)
                res.append(new StringBuilder(sub).reverse());
            else
                res.append(sub);
        }
        
        return res.toString();
    }
}
