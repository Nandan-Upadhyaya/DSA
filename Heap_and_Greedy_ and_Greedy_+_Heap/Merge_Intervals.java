
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
       List<int[]> res = new ArrayList<>();
       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

       int[] current = intervals[0];
       res.add(current);

       for(int i = 1 ; i<intervals.length ; i++) {
         int[] next = intervals[i];
         if(next[0] <= current[1]) current[1] = Math.max(current[1], next[1]);
         else {
            current = next;
            res.add(current);
         }
       }
       return res.toArray(new int[res.size()][]);
    }
     
}