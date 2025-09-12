
import java.util.Arrays;

class Solution {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - a[1]);
        for(int i = 1 ; i<intervals.length ; i++) {
            if(intervals[i][0] < intervals[i-1][1]) return false;
        } 
        return false;
    }
}