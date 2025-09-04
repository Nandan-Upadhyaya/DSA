
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());

        for(int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new Pair(v,w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node, d = current.distance;

            if(d > dist[u]) continue;

            for(Pair edge : graph.get(u)) {
                int v = edge.node;
                int w = edge.distance;

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }


        }
        int ans = 0;
        for(int i = 1 ; i<=n ; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            else ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
    
}