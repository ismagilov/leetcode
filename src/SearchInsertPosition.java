/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int b = 0, e = nums.length - 1;

        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                e--;
            else if (nums[mid] < target)
                b++;
        }

        return b;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();

        System.out.println(s.searchInsert(new int[] {1, 2, 5, 6, 7}, 8));
        System.out.println(s.searchInsert(new int[] {1, 2, 5, 6, 7}, 0));
        System.out.println(s.searchInsert(new int[] {1, 2, 5, 6, 7}, 4));

        System.out.println(s.searchInsert(new int[] {1}, 4));


    }
}
