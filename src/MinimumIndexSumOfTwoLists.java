import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
* https://leetcode.com/problems/minimum-index-sum-of-two-lists
*/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
       
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        
        Set<String> keys = map.keySet();
        int min = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    res.clear();
                    res.add(list2[i]);
                } else if (sum == min) {
                    res.add(list2[i]);      
                }
            }
        }
               
        return res.toArray(new String[res.size()]);
    }
}
