import java.util.HashMap;

/**
 * https://leetcode.com/problems/word-pattern
 *
 * Look up word in O(N).
 */
public class WordPatternA {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> ps = new HashMap<>();

        String[] words = str.split(" ");

        if (pattern.length() != words.length)
            return false;

        for (int i = 0; i < words.length; i++) {
            Character p = pattern.charAt(i);

            if (ps.containsKey(p)) {
                if (!ps.get(p).equals(words[i]))
                    return false;
            } else {
                if (ps.containsValue(words[i]))
                    return false;

                ps.put(p, words[i]);
            }
        }

        return true;
    }
}
