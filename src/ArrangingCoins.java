/**
 * https://leetcode.com/problems/arranging-coins
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        double dn = n;
        double k = (Math.sqrt(1 + 8 * dn) - 1) / 2;

        return new Double(Math.floor(k)).intValue();
    }
}
