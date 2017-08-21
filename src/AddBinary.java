/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int idxa = a.length() - 1, idxb = b.length() - 1;
        int carry = 0;

        while (idxa >= 0 || idxb >= 0) {
            int da = idxa >= 0 ? a.charAt(idxa) - '0' : 0;
            int db = idxb >= 0 ? b.charAt(idxb) - '0' : 0;

            int v = da + db + carry;

            int d = v % 2;
            carry = v / 2 ;

            res.append(d);

            idxa--;
            idxb--;
        }

        if (carry == 1)
            res.append(carry);

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();

        System.out.println(a.addBinary("1", "0"));

//        System.out.println(a.addBinary("11", "10"));
//        System.out.println(a.addBinary("111", "1"));
//        System.out.println(a.addBinary("1110", "11"));
    }
}
