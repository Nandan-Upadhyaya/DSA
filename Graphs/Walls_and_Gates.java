
import java.util.LinkedList;
import java.util.Queue;

class Solution {
public static void WallsandGates(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0 ; i<grid.length ; i++) {
            for(int j = 0 ; j<grid[0].length ; j++) {
                if(grid[i][j] == 0) queue.add(new int[] {i,j});
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0 ; s < size ; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                
                int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                
                for(int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    
                    if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == Integer.MAX_VALUE) {
                        grid[ni][nj] = grid[i][j] + 1;
                        queue.offer(new int[] {ni, nj});
                    }
                }
            }
        }
            
        }

}