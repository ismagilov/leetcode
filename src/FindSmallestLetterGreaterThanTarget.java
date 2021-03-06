/**
* https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
*/
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int b = 0, e = letters.length - 1;
        
        while (b <= e) {
            int mid = b + (e - b) / 2;
            
            if (letters[mid] <= target)
                b = mid + 1;
            else
                e = mid - 1;
        }
        
        return letters[b % letters.length]; 
    }
}
