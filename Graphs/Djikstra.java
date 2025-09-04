import java.util.*;
class Main {
    public static void main(String[] args) {
        List<List<Djikstra.Pair>> graph = new ArrayList<>();
        int V = 5;
        for(int i = 0 ; i<V ; i++) graph.add(new ArrayList<>());
        graph.get(0).add(new Djikstra.Pair(1,10));
        graph.get(0).add(new Djikstra.Pair(4,5));
        graph.get(1).add(new Djikstra.Pair(2,1));
        graph.get(1).add(new Djikstra.Pair(4,2));
        graph.get(2).add(new Djikstra.Pair(3,4));
        graph.get(3).add(new Djikstra.Pair(0,10));
        graph.get(3).add(new Djikstra.Pair(2,6));
        graph.get(4).add(new Djikstra.Pair(3,2));
        graph.get(4).add(new Djikstra.Pair(1,1));
        graph.get(4).add(new Djikstra.Pair(2,9));
        
        
        int[] dist = Djikstra.shortestPath(V, graph, 0);
        for(int i = 0 ; i< V ; i++)
         System.out.println(i  + " " +  dist[i]);

        int[][] result = Djikstra.allPairsShortestPath(V, graph);

        System.out.println("All Pairs Shortest Path:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    }

   

class Djikstra {
    
    static public class Pair {
        int node;
        int distance;
        
       public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        
    }
    
    public static int[] shortestPath(int V, List<List<Pair>> graph, int src) {
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;
            
            if (d > dist[u]) continue; 
            
            for(Pair edge : graph.get(u)) {
                int v = edge.node;
                int W = edge.distance;
                
                if(dist[u] + W < dist[v]) {
                    dist[v] = dist[u] + W;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        
        return dist;
    }

    public static int[][] allPairsShortestPath(int V, List<List<Pair>> graph) {
        int[][] dist = new int[V][V];

        for (int src = 0; src < V; src++) {
            dist[src] = shortestPath(V, graph, src);
        }
        return dist;
    }
    
    

}