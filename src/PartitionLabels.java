import java.util.ArrayList;
import java.util.List;

/**
* https://leetcode.com/contest/weekly-contest-67/problems/partition-labels/
*/
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        int[] maxPos = new int[26];
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            maxPos[idx] = i;
        }
        
        int right = -1;
        int left = -1;
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            
            if (left == -1)
                left = i;
            
            right = Math.max(right, maxPos[idx]);
            
            if (i == right) {
                res.add(right - left + 1);
                left = -1;
            }
        }
        
        return res;
    }
}
