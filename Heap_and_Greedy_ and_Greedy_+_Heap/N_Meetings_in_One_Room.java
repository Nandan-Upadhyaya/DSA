
import java.util.Arrays;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
      int[][] meetingpairs = new int[start.length][2];
      for(int i = 0 ; i<start.length ; i++) {
        meetingpairs[i][0] = start[i];
        meetingpairs[i][1] = end[i];
      }

      Arrays.sort(meetingpairs, (a,b) -> a[1] - b[1]);

      int lastEnd = -1, meetings = 0;
      for(int[] meeting : meetingpairs) {
        if(meeting[0] >= lastEnd) {
            meetings++;
            lastEnd = meeting[1];
        }
      }

      return meetings;

    }
}