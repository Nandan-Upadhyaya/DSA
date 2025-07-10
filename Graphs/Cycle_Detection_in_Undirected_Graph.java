import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { {0,1},{1,2},{2,3},{3,4} };
        List<List<Integer>> graph = buildGraph(n, edges);
        System.out.println(hasCycle(graph, n)); 
    }
    
    public static List<List<Integer>> buildGraph(int n, int[][] edges){
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
    
    public static boolean hasCycle(List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i<n ; i++){
            if(!visited[i] && dfs(i, -1, graph, visited)) return true;
        }
        return false;
    }
    
    public static boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, node, graph, visited)) return true;
            }
            else if( neighbor!= parent) return true;
        }
        return false;
    }
}