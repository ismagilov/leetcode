/**
* https://leetcode.com/problems/sliding-window-median/description/
*
* Non-optimal because of O(N) for PriorityQueue.remove(Object o).
*/
public class SlidingWindowMedianA {
    private PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
               
        for (int i = 0; i < k; i++)
            add(nums[i]);
                        
        int idx = 0;
        medians[idx++] = median();
        for (int i = 0; i < nums.length - k; i++) {
            remove(nums[i]);
            add(nums[i + k]);
            
            medians[idx++] = median();
        }
        
        return medians;
    }
    
    private void add(int n) {
        left.offer(n);
        
        right.offer(left.poll());
        
        if (right.size() > left.size())
            left.offer(right.poll());
    }
    
    private void remove(int n) {
        if (n <= median())
            left.remove(n);
        else 
            right.remove(n);
        
        if (right.size() > left.size())
            left.offer(right.poll());
        else if (left.size() - right.size() > 1)
            right.offer(left.poll());
    }
    
    private double median() {
        return left.size() == right.size() ? ((double)left.peek() + (double)right.peek()) / 2.0: left.peek();
    }
}
