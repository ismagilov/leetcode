/**
* https://leetcode.com/problems/shuffle-an-array/description/
*/
public class ShuffleAnArray {
    private final int[] original;
    private final Random r = new Random();
    
    public Solution(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(original, original.length);
        
        for (int i = 0; i < shuffled.length; i++) {
            int j = r.nextInt(i + 1);
            
            int temp = shuffled[j];
            shuffled[j] = shuffled[i];
            shuffled[i] = temp;
        }
        
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
