import java.util.ArrayList;
import java.util.List;

/**
* https://leetcode.com/problems/binary-watch/description/
*/
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        return generateTimes(0, 0, num);
    }
    
    private List<String> generateTimes(int start, int time, int bits) {
        List<String> res = new ArrayList<>();
        if (bits == 0) {
            String t = timeToString(time);
            if (t != null) res.add(t);
            
            return res;
        }
              
        for (int i = start; i <= 10 - bits; i++) {
            int setBitMask = 1 << i;
            
            time |= setBitMask;
            res.addAll(generateTimes(i + 1, time, bits - 1));
            time &= ~setBitMask;
        } 
        
        return res;
    }
    
    private String timeToString(int time) {
        final int maskHs = 0x3C0;
        final int maskMins = 0x3F;
        
        int hs = (time & maskHs) >>> 6;
        if (hs >= 12) return null;
        int mins = time & maskMins;
        if (mins >= 60) return null;
        
        return String.format("%1$d:%2$02d", hs, mins);
    }
}
