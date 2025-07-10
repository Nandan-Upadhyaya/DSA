import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2}, {1,4} ,{2,3}, {3,4}, {4,1}};
        List<List<Integer>> graph = buildGraph(n, edges);
        System.out.println(hasCycleDirectedGraph(graph, n)); 
    }
    
    public static List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
           
        }
        return graph;
    }
    
    public static boolean hasCycleDirectedGraph(List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n];
        boolean[] instack = new boolean[n];
        
        for(int i = 0 ; i<n ; i++){
            if(!visited[i] && dfs(i, graph, visited, instack)) return true;
        }
        return false;
    }
    
    public static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] instack){
        visited[node] = true;
        instack[node] = true;
        
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, graph, visited, instack)) return true;
            }
            else if(instack[neighbor]) return true;
            
        }
        instack[node] = false;
        return false;
    }
    
    
}