import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            dict.merge(s.charAt(i), 1, Integer::sum);
        }

        int length = 0;
        for (Integer cnt: dict.values()) {
            length += cnt / 2 * 2;

            if (length % 2 == 0 && cnt % 2 == 1)
                length++;
        }

        return length;
    }

    public static void main(String[] args) {
        LongestPalindrome409 s = new LongestPalindrome409();

        System.out.println(s.longestPalindrome("abccccdd"));
    }
}
