/**
 * https://leetcode.com/problems/excel-sheet-column-title
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n != 0) {
            n--;
            char c = (char)(n % 26 + 65);
            res.append(c);

            n /= 26;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();

        System.out.println(e.convertToTitle(26));
        System.out.println(e.convertToTitle(28));
    }
}
