// Kahn's Algorithm for Topological Sort (BFS Style)
// 1. Compute the in-degree of each node.
// 2. Initialize a queue and add all nodes with in-degree 0.
// 3. While the queue is not empty:
//    - Remove a node from the queue and add it to the topological order.
//    - For each of its neighbors, decrease their in-degree by 1.
//    - If any neighbor's in-degree becomes 0, add it to the queue.
// 4. If the topological order contains all nodes, return it; otherwise, return an empty list (indicating a cycle). 



import java.util.*;
class Main {
    public static void main(String[] args) {
       int n = 7;
       int[][] edges = {
          {0, 1},
          {1, 2},
          {3, 4},
          {5, 6}
       };
     List<Integer> topologicalorder = topologicalSortKahn(n, edges);
     System.out.println(topologicalorder);
       
    }
    
    public static List<Integer>topologicalSortKahn(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); //Directed graph
            indegree[v]++; //Indegree computation
        }
        List<Integer> topologicalorder = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            if(indegree[i] == 0) queue.offer(i); //Adding nodes with indegree 0 to the queue
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            topologicalorder.add(node);
            for(int neighbor : graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        if(topologicalorder.size() == n) return topologicalorder;
        else return new ArrayList<>();
    }
    
    }
    
    
    
    
    
    

