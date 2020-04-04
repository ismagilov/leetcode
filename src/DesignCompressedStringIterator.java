/**
* https://leetcode.com/problems/design-compressed-string-iterator/description/
*/
public class DesignCompressedStringIterator {
    private final char[] compressed;
    private int p;
    
    private char ch;
    private int cnt;
    
    public DesignCompressedStringIterator(String compressedString) {
        compressed = compressedString.toCharArray();
        p = 0;
    }
    
    public char next() {
        if (cnt == 0 && p == compressed.length)
            return ' ';
        else if (cnt == 0 && p < compressed.length) {
            ch = compressed[p];
            p++;

            StringBuilder sb = new StringBuilder();
            while (p < compressed.length && Character.isDigit(compressed[p])) {
                sb.append(compressed[p]);
                p++;
            }
            cnt = Integer.valueOf(sb.toString());
        }
        
        cnt--;
        return ch;
    }
    
    public boolean hasNext() {
        return cnt > 0 || p != compressed.length;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
