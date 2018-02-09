/**
* https://leetcode.com/problems/valid-word-abbreviation/description/
*/
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int ps = 0, pa = 0;
        
        while (ps < word.length() && pa < abbr.length()) {
            char cs = word.charAt(ps);
            char ca = abbr.charAt(pa);
            
            if (cs == ca) {
                ps++; pa++;
                continue;
            }
            
            if (ca == '0' || Character.isLetter(ca))
                return false;
            
            StringBuilder sb = new StringBuilder();
            while (pa < abbr.length()) {
                ca = abbr.charAt(pa);
                if (!Character.isDigit(ca)) break;
            
                sb.append(ca);
                pa++;
            }
            
            int num = Integer.valueOf(sb.toString());
            ps += num;
        }
        
        return ps == word.length() && pa == abbr.length();
    }
}
