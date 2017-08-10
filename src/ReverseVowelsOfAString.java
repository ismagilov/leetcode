/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int b = 0, e = s.length() - 1;
        char[] chs = s.toCharArray();

        while (b < e) {
            if (!isVowel(chs[b])) {
                b++;
                continue;
            }

            if (!isVowel(chs[e])) {
                e--;
                continue;
            }

            char tmp = chs[b];
            chs[b] = chs[e];
            chs[e] = tmp;

            b++;
            e--;
        }

        return new String(chs);
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString r = new ReverseVowelsOfAString();

        System.out.println(r.reverseVowels("Leetcode"));
        System.out.println(r.reverseVowels("hello"));
        System.out.println(r.reverseVowels("world"));
        System.out.println(r.reverseVowels("ao"));
    }
}
