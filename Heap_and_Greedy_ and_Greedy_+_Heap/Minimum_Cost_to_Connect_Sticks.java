
import java.util.PriorityQueue;

class Solution {

    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) pq.offer(stick);
        int totalCost = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.offer(cost);
        }
        return totalCost;
    }
}