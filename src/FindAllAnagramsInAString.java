import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> idxs = new ArrayList<>();

        int pCnt[] = new int[26];
        for (int i = 0; i < p.length(); i++)
            pCnt[p.charAt(i) - 'a']++;

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] sCnt = new int[26];
            for (int j = 0; j < p.length(); j++) {
                sCnt[s.charAt(i + j) - 'a']++;
            }

            if (Arrays.equals(pCnt, sCnt))
                idxs.add(i);
        }

        return idxs;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();

        //System.out.println(f.findAnagrams("abab", "ab"));
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
    }
}
