/**
* https://leetcode.com/problems/next-greater-element-i
*/
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> greaters = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] nexts = new int[findNums.length];
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && stack.peek() <= nums[i])
                greaters.put(stack.pop(), nums[i]);

            stack.push(nums[i]);    
        }
        
        for (int i = 0; i < findNums.length; i++)
            nexts[i] = greaters.getOrDefault(findNums[i], -1);
        
        return nexts;
    }
}
