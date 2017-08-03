import java.util.HashSet;
import java.util.Set;

/**
* https://leetcode.com/articles/distribute-candies/
*/
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        
        for (int c : candies)
            kinds.add(c);
        
        return Math.min(kinds.size(), candies.length / 2);
    }
}
