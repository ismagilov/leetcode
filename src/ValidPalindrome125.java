public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;

        while (p1 < p2) {
            while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))) p1++;
            while (p2 > p1 && !Character.isLetterOrDigit(s.charAt(p2))) p2--;

            if (Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2)))
                return false;

            p1++;
            p2--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125Funs s = new ValidPalindrome125Funs();

        System.out.println(s.isPalindrome("asdsa"));
        System.out.println(s.isPalindrome("asdff"));
        System.out.println(s.isPalindrome("A\tsd  Sa"));
    }
}
