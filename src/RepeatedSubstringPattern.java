/**
 * https://leetcode.com/problems/repeated-substring-pattern
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int max = s.length() / 2;
        for (int i = 1; i <= max; i++) {
            if (s.length() % i == 0) {
                String pattern = s.substring(0, i);
                StringBuilder composed = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++)
                    composed.append(pattern);

                if (composed.toString().equals(s))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();

        System.out.println(r.repeatedSubstringPattern("aaaa"));
        System.out.println(r.repeatedSubstringPattern("aba"));
        System.out.println(r.repeatedSubstringPattern("abab"));
        System.out.println(r.repeatedSubstringPattern("aabbaabb"));
    }
}
