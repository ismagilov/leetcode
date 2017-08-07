/**
 * https://leetcode.com/problems/power-of-four/description/
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        //0x55555555 to check, that bit is set at one of the positions 0, 2, 4, etc.
        return num > 0 && (((num - 1) & num) == 0) && (num & 0x55555555) == num;
    }

    public static void main(String[] args) {
        PowerOfFour p4 = new PowerOfFour();

        System.out.println(p4.isPowerOfFour(0));
        System.out.println(p4.isPowerOfFour(1));
        System.out.println(p4.isPowerOfFour(4));
        System.out.println(p4.isPowerOfFour(-32));

    }
}
