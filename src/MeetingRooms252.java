import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms252 {
    /*
    [1, 3]
    [2, 7]
    [2, 5]
    [4, 7]
    [9, 10]
    */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(
                intervals, Comparator
                .comparing(value -> ((int[]) value)[0])
                .thenComparing(value -> ((int[]) value)[1])
        );

        System.out.println(Arrays.deepToString(intervals));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] meetings = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        MeetingRooms252 s = new MeetingRooms252();

        System.out.println(s.canAttendMeetings(meetings));
    }
}
