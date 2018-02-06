/**
* https://leetcode.com/problems/license-key-formatting/description/
*/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        
        int cntGroup = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch == '-') continue;

            if (cntGroup > 0 && cntGroup % K == 0)
                res.append('-');
           
            ch = Character.toUpperCase(ch);
            cntGroup++;
            
            res.append(ch);
        }
        
        return res.reverse().toString();
    }
}
