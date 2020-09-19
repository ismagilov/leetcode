/**
 * https://leetcode.com/problems/reverse-integer
 */
public class ReverseInteger {
    // 45690
    // 4569 % 10 == 9
    // rev 9
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int tmp = rev * 10 + x % 10;
            if (tmp / 10 != rev)
                return 0;

            x /= 10;
            rev = tmp;
        }

        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();

        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
    }

}
