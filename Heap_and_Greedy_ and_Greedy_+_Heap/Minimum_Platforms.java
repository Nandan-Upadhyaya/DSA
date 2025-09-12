
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static int minPlatforms(int[] arrivals, int[] departures) {
        int[][] trainarray = new int[arrivals.length][2];
        for(int i = 0 ; i<trainarray.length ; i++) trainarray[i][0] = arrivals[i];
        for(int i = 0 ; i<trainarray.length ; i++) trainarray[i][1] = departures[i];

        Arrays.sort(trainarray, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] train : trainarray) {
            if(!pq.isEmpty() && pq.peek() <= train[0]) pq.poll();
            pq.add(train[1]);
        }
        return pq.size();
    }
}