/**
 * https://leetcode.com/problems/palindrome-number
 *
 * Compare left and right digits, remove that digits from the number, repeat.
 */
public class PalindromeNumberA {
    public boolean isPalindrome(int x) {
        if (x < 0 )
            return false;

        int lng = 0;

        int d = x;
        while (d != 0) {
            d /= 10;
            lng++;
        }

        for (int i = lng - 1; i >= 0; i -= 2) {
            int l = x / (int)Math.pow(10, i);
            int r = x % 10;

            if (l != r)
                return false;

            x -= l * (int)Math.pow(10, i);
            x /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumberA pn = new PalindromeNumberA();

        System.out.println(pn.isPalindrome(45754));
        System.out.println(pn.isPalindrome(4));
        System.out.println(pn.isPalindrome(475));
    }
}
