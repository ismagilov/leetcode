/**
* https://leetcode.com/problems/max-chunks-to-make-sorted/description/
*/
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        
        boolean started = false;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max)
                chunks++;
        }
        
        return chunks;
    }
}
