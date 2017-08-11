import java.util.HashMap;

/**
 * https://leetcode.com/problems/word-pattern
 *
 * Look up pattern (of type Character) and word (of type String) in O(N);
 */
public class WordPatternB {
    public boolean wordPattern(String pattern, String str) {
        HashMap ps = new HashMap();

        String[] words = str.split(" ");

        if (pattern.length() != words.length)
            return false;

        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            if (ps.put(c, i) != ps.put(words[i], i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        WordPatternB p = new WordPatternB();

        System.out.println(p.wordPattern("aba", "cat a cat"));
        System.out.println(p.wordPattern("aba", "cat b cat"));

        HashMap ps = new HashMap();
        ps.put('c', 1);
        ps.put("c", 2);
        System.out.println(ps.containsKey("c"));
        System.out.println(ps.get('c'));
        System.out.println(ps.get("c"));
    }
}
