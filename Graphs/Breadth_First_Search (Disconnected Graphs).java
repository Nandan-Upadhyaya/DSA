import java.util.*;
class Main {
    public static void main(String[] args) {
       int n = 7;
       int[][] edges = {
           {0,1},
           {0,2},
           {3,4},
           {5,6},
       };
       List<List<Integer>> graph = buildgraph(n, edges);
       bfsdisconnectedgraph(graph, n);
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
    
    public static void bfsdisconnectedgraph(List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i<n ; i++){
            if(!visited[i]) bfstraversal(i, graph, visited);
        }
    }
    
    public static void bfstraversal(int start, List<List<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
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
    
    
    

