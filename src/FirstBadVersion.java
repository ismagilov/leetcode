/**
 * @author Ilya Ismagilov <ilya@singulator.net>
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int b = 1;
        int e = n;
        int result = -1;

        while (b <= e) {
            long mid2 = (b + e) / 2L;

            if (mid2 > Integer.MAX_VALUE) {
                System.out.println(mid2);
                break;
            }

            int mid = (int)mid2;

            System.out.println(b + " " + e + " " + mid + " " + mid2);

            if (isBadVersion(mid)) {
                result = mid;
                e = mid - 1;
            } else {
                b = mid + 1;
            }
        }

        return result;
    }

    private boolean isBadVersion(int version) {
        if (version >= 1702766719)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        //FirstBadVersion fbv = new FirstBadVersion();
        //System.out.println(fbv.firstBadVersion(2126753390));

        int a = 1063376696, b = 2126753390;
        int l = (int)(((long)a + (long)b) / 2);

        System.out.println(a + b);
        System.out.println(l);
    }
}
