/**
 * https://leetcode.com/problems/count-primes
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < isPrime.length; i++)
            isPrime[i] = true;

        int cnt = n; // 0, ..., n - 1
        isPrime[0] = false;
        isPrime[1] = false;
        cnt -= 2;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int k = i * i; k < n; k += i) {
                    if (isPrime[k] == true) // For sample, 12 is checked twice: for k = 2 and for k = 3
                        cnt--;

                    isPrime[k] = false;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();

        System.out.println(cp.countPrimes(18));
    }
}
