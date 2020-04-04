import java.util.ArrayList;
import java.util.Comparator;

/**
* https://leetcode.com/problems/sliding-window-median/description/
*
* Use sorted array for window.
*/
public class SlidingWindowMedianB {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        ArrayList<Integer> w = new ArrayList<>();
        
        for (int i = 0; i < k; i++)
            w.add(nums[i]);
        
        w.sort(Comparator.naturalOrder());
        
        int idx = 0;
        medians[idx++] = median(w);
        for (int i = 0; i < nums.length - k; i++) {
            remove(w, nums[i]);
            add(w, nums[i + k]);
            
            medians[idx++] = median(w);
        }
        
        return medians;
    }
    
    private void add(ArrayList<Integer> w, int n) {
        int idx = 0;
        
        while (idx < w.size() && n > w.get(idx))
            idx++;
        
        w.add(idx, n);
    }
    
    private void remove(ArrayList<Integer> w, int n) {
        w.remove(Integer.valueOf(n));
    }
    
    private double median(ArrayList<Integer> w) {
        int sz = w.size();
        
        return sz % 2 == 0 ? ((double)w.get(sz / 2) + (double)w.get(sz / 2 - 1)) / 2.0 : w.get(sz / 2);
    }
}
