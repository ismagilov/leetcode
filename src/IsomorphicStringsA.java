import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings
 *
 * Hash maps solution.
 */
public class IsomorphicStringsA {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);


            if (map.containsKey(from)) {
                char iso = map.get(from);
                if (iso != to)
                    return false;
            } else {
                if (map.containsValue(to))
                    return false;

                map.put(from, to);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStringsA i = new IsomorphicStringsA();

        System.out.println(i.isIsomorphic("ab", "aa"));
    }
}
