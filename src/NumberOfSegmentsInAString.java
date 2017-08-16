/**
 * https://leetcode.com/problems/number-of-segments-in-a-string
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int cnt = 0;

        boolean word = false;
        for (int i = 0; i < s.length(); i++) {
            if (word && Character.isWhitespace(s.charAt(i))) {
                cnt++;
                word = false;
            } else if (!word && !Character.isWhitespace(s.charAt(i))) {
                word = true;
            }
        }

        if (word)
            cnt++;

        return cnt;
    }

    public static void main(String[] args) {
        NumberOfSegmentsInAString n = new NumberOfSegmentsInAString();

        System.out.println(n.countSegments("Idea   is the best IDE in the  world"));
        System.out.println(n.countSegments("Idea is the best IDE in the"));
        System.out.println(n.countSegments("Idea"));
    }
}
