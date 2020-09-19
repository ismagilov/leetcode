public class NthDigit {
    public int findNthDigit(int n) {
        // 1 * 9, 2 * 90, 3 * 900

        // n == 26
        int start = 1;
        int lng = 1;
        long step = 9;

        while (n - lng * step > 0) {
            n -= lng * step;
            lng++;
            start *= 10;
            step *= 10;
        }
        // n == 26 - 9 == 17
        // 10 11 12 13 14 15 16 17 *1*8
        n--;
        // n == 16
        // 10 + 16 / 2 == 18
        return Integer.toString(start + n / lng).charAt(n % lng) - '0';
    }

    public static void main(String[] args) {
        NthDigit n = new NthDigit();

        System.out.println(n.findNthDigit(26));
    }
}
