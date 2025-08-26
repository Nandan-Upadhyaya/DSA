
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<numCourses ; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<indegree.length ; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        } 
        return count == numCourses;
    }
}