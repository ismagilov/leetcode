/**
* https://leetcode.com/problems/valid-anagram
*/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        
        for (char c : s.toCharArray())
            cnt1[c - 97]++;
        
        for (char c : t.toCharArray())
            cnt2[c - 97]++;
        
        for (int i = 0; i < cnt1.length; i++)
            if (cnt1[i] != cnt2[i])
                return false;
        
        return true;
    }
}
