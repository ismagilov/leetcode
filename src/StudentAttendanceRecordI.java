/**
* https://leetcode.com/problems/student-attendance-record-i
*/
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        char p = 0;
        char pp = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') a++;
            if (a > 1) return false;
            
            if (c == 'L' && p == 'L' && pp == 'L') return false;
            
            pp = p;
            p = c;
        }
        
        return true;
    }
}
