import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] plusOne = new int[digits.length];

        int carry = 0;
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + one + carry;
            one = 0;
            plusOne[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry == 1) {
            plusOne = Arrays.copyOf(plusOne, plusOne.length + 1);
            plusOne[0] = 1;
        }

        return plusOne;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();

        System.out.println(Arrays.toString(po.plusOne(new int[]{1, 9, 9})));
    }
}
