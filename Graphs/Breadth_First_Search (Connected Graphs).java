import java.util.*;
class Main {
    public static void main(String[] args) {
       int n = 6;
       int[][] edges = {
           {0,1},
           {0,2},
           {1,3},
           {1,4},
           {4,5}
       };
       List<List<Integer>> graph = buildgraph(n, edges);
       bfstraversal(graph, n);
    }
    
    public static List<List<Integer>> buildgraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    
    public static void bfstraversal(List<List<Integer>> graph, int n){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    
    
    }

