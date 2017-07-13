/**
* https://leetcode.com/problems/house-robber
*
* Solved using acc avariables.
*/
public class HouseRobberB {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int curRob = notRob + nums[i]; // If we rob current, previous is not robbed
            notRob = Math.max(rob, notRob); // If we do not rob current, we get max from previous robbed and not robbed
            rob = curRob;
        }
        
        return Math.max(rob, notRob);
    }
}
