import java.util.*;
class Main {
    public static void main(String[] args) {
       int[][] grid = {
           { 0,1,0,0  },
            {0,1,1,0},
            {0,0,0,0 },
           {1,1,1,0 }
       };
       System.out.println(break1nwalltoreachdestination(grid));
       
    }
    
    public static int break1nwalltoreachdestination(int[][] grid) {
        
    // Queue + visited initialization based on the states 
     Queue<int[]> queue = new LinkedList<>();
     boolean[][][] visited = new boolean[grid.length][grid[0].length][2];
     
     // First entry addition
     queue.offer(new int[] {0,0,0});
     visited[0][0][0] = true;
     
     // Steps tracker
     int steps = 1;
     
     // Direction Array for up down left right
     int[][] directions = { {1,0 }, {-1, 0}, {0,1}, {0, -1}}; 
     
     // BFS traversal
     while(!queue.isEmpty()) {
         int size = queue.size();
         for(int s = 0 ; s< size ; s++) {
             int[] cur = queue.poll();
             int i = cur[0], j = cur[1], broken = cur[2];
             
             // Goal Check
             if (i == grid.length - 1 && j == grid[0].length - 1) return steps;
             
             //  Directions checking
             for(int[] dir : directions) {
                 int ni = i + dir[0], nj = j + dir[1];
                 
                 // Direction out of bound checking
                 if(ni < 0 || nj < 0 || ni > grid.length - 1 || nj > grid[0].length - 1)
                  continue;
                  
                  // Conditions based on the problem
                 if(grid[ni][nj] == 0 && !visited[ni][nj][broken]) {
                     visited[ni][nj][broken] = true;
                     queue.offer(new int[] {ni, nj, broken});
                 }
                 
                 if(grid[ni][nj] == 1 && broken == 0 && !visited[ni][nj][1]) {
                     visited[ni][nj][1] = true;
                     queue.offer(new int[] {ni, nj, 1});
                     
                 }
             }
         }
         // At each level increment
         steps++;
     }
     return -1;
    }
    
}