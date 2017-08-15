import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for (int l = 0; l <= rowIndex; l++) {
            res.add(1);
            for (int j = l - 1; j >= 1; j--)
                res.set(j, res.get(j - 1) + res.get(j));
        }

        return res;
    }

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();

        System.out.println(pt.getRow(1));
        System.out.println(pt.getRow(4));
    }
}
