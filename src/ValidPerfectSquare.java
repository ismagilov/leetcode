/**
 * https://leetcode.com/problems/valid-perfect-square
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int b = 0, e = num;

        while (b <= e) {
            int mid = b + (e - b) / 2;

            long square = (long)mid * (long)mid;
            if (square == num)
                return true;
            else if (square > num)
                e = mid - 1;
            else
                b = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare v = new ValidPerfectSquare();

        System.out.println(v.isPerfectSquare(2147483647));
    }
}
