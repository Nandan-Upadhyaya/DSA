
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static class Pair{
        int node;
        int distance;
        int stops;

        Pair(int node, int distance, int stops) {
            this.node = node;
            this.distance = distance;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i< n ; i++) graph.add(new ArrayList<>());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
                graph.get(u).add(new int[]{v, w});
        }
        
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[src][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        pq.add(new Pair(src, 0, 0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node, d = current.distance, s = current.stops;

             if(u == dst) return d;
             if (s > k) continue;
            
            if(d > dist[u]) continue;

            for(int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
            if (d + w < dp[v][s + 1]) {  
                    dp[v][s + 1] = d + w;
                    pq.add(new Pair(v, d + w, s + 1));
                }
               

            }
        }
         
        return -1;
    }
}