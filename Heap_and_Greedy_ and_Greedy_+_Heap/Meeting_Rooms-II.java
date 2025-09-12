
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
 
 public static int minEngineers(int[][] tasks) {
    Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int[] task : tasks) {

        if(!pq.isEmpty() && pq.peek() < task[0]) pq.poll();
        pq.offer(task[1]);
    }
  return pq.size();
 }
 
}