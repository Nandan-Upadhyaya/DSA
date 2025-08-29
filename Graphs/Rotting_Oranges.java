
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int fresh = 0;
    for(int i = 0 ; i<grid.length ; i++) {
        for(int j = 0 ; j<grid[0].length ; j++) {

            if(grid[i][j] == 2) queue.offer(new int[] {i,j});
            
           else if(grid[i][j] == 1) fresh++;
        }
    }

    if(fresh == 0) return 0;
    int minutes = 0;

    while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0 ; i< size ; i++) {
            int[] oranges = queue.poll();
            int j = oranges[0], k = oranges[1];

            if(j - 1 >= 0 && grid[j-1][k] == 1) {
                grid[j-1][k] = 2;
                queue.offer(new int[] {j - 1, k});
                fresh--;
            }

             if(j + 1 < grid.length && grid[j + 1][k] == 1) {
                grid[j + 1][k] = 2;
                queue.offer(new int[] {j  + 1, k});
                fresh--;
            }

            if(k - 1 >= 0 && grid[j][k - 1] == 1) {
                grid[j][k - 1] = 2;
                queue.offer(new int[] {j, k - 1});
                fresh--;
            }

            if(k + 1 < grid[0].length && grid[j][k + 1] == 1) {
                grid[j][k + 1] = 2;
                queue.offer(new int[] {j, k + 1});
                fresh--;
            }
          
        }
         if(!queue.isEmpty()) minutes++;
    }    
    
    return fresh == 0 ? minutes : -1;
    }

    

}