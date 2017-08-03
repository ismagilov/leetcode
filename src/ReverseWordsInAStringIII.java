/**
* https://leetcode.com/problems/reverse-words-in-a-string-iii
*/
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder w = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                w.append(s.charAt(i));
            
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                w = w.reverse();

                if (s.charAt(i) == ' ')
                    w.append(s.charAt(i));
                    
                res.append(w);
                w = new StringBuilder();
            }
        }
        
        return res.toString();
    }
}
