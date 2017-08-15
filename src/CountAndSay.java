/**
 * https://leetcode.com/problems/count-and-say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String prev = "1";
        StringBuilder cur = new StringBuilder(prev);

        for (int i = 2; i <= n; i++) {

            int say = 0;
            int cnt = 0;
            //1
            cur = new StringBuilder();
            for (int j = 0; j < prev.length(); j++) {

                int d = prev.charAt(j) - '0';

                if (d == say) {
                    cnt++;
                } else {
                    if (j != 0)
                        cur.append(cnt).append(say);

                    say = d;
                    cnt = 1;
                }

                if (j == prev.length() - 1)
                    cur.append(cnt).append(say);
            }

            prev = cur.toString();
        }

        return cur.toString();
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();

        System.out.println(c.countAndSay(5));
    }

}
