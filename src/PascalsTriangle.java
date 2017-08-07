import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0)
            return triangle;

        List<Integer> prev = new ArrayList();
        for (int r = 0; r < numRows; r++) {
            ArrayList<Integer> next = new ArrayList<>();

            for (int i = 0; i <= r; i++) {
                if (i == 0 || i == r)
                    next.add(1);
                else
                    next.add(prev.get(i - 1) + prev.get(i));
            }

            triangle.add(next);
            prev = next;
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle tr = new PascalsTriangle();

        System.out.println(tr.generate(2));
    }
}
