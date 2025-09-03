// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] grid = { {0,1,0}, {0,0,0}, {1,0,0}};
        System.out.println(binaryMatrixShortestPath(grid, 0, grid.length - 1));
    }
    
    public static int binaryMatrixShortestPath(int[][] grid, int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        queue.offer(new int[] {0,0});
        visited[0][0] = true;
        
        int steps = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0 ; s < size ; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                
                if(i == grid.length - 1 && j == grid[0].length - 1) return steps;
                
                int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1} } ;
   
                for(int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    
                    if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && !visited[ni][nj] && grid[ni][nj] == 0) {
                        visited[ni][nj] = true;
                        queue.offer(new int[] {ni, nj});
                    }
                }
            }
            steps++;
        }
          return -1;   
    }
}