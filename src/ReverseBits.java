/**
 * https://leetcode.com/problems/reverse-bits
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 32; i++) {
            rev |= n & 1;
            n >>>= 1;

            if (i != 31)
                rev <<= 1;
        }

        return rev;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();

        System.out.println(Integer.toBinaryString(r.reverseBits(8)));
    }
}
