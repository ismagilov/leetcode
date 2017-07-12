/**
* https://leetcode.com/problems/can-place-flowers
*/
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] fb, int n) {
        int b = -1, e = b + 2;
        int busyPlots = 0;
        while(e <= fb.length) {
            if (b >= 0 && fb[b] == 1)
                busyPlots++;
            if (fb[b + 1] == 1)
                busyPlots++;
            if (b + 2 < fb.length && fb[b + 2] == 1)
                busyPlots++;
            
            if (busyPlots == 0) {
                n--;
                fb[b + 1] = 1;
            }
            
            b++;
            e++;
            busyPlots = 0;
        }
        
        return n <= 0;
    }
}
