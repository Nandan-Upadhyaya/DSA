import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
                      };
        System.out.println(minPathSumRecursive(grid));
        System.out.println(minPathSumMemoizive(grid));
        System.out.println(minPathSumTabulative(grid));
    }
    
   public static int minPathSumRecursive(int[][] grid){
       return recursivehelper(grid, grid.length -1, grid[0].length -1);
   }
   
   public static int minPathSumMemoizive(int[][] grid){
       int[][] dp = new int[grid.length+1][grid[0].length+1];
       for(int[] arr : dp) Arrays.fill(arr, -1);
       return memoizivehelper(grid, grid.length -1, grid[0].length -1, dp);
   }
   
   public static int minPathSumTabulative(int[][] grid){
       int[][] dp = new int[grid.length +1 ][grid[0].length + 1];
       for(int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
       dp[0][0] = grid[0][0];
       for(int i = 1 ; i < grid.length ; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
       for(int j = 1 ; j < grid[0].length ; j++)  dp[0][j] = dp[0][j-1] + grid[0][j];
       for(int i = 1 ; i< grid.length ; i++){
           for(int j = 1 ; j< grid[0].length ; j++){
               dp[i][j] = Math.min(grid[i][j] + dp[i][j-1], grid[i][j] + dp[i-1][j]);
           }
       }
       return dp[grid.length - 1][grid[0].length - 1];
   }
   
   
   public static int recursivehelper(int[][] grid, int m, int n){
       if(m == 0 && n == 0) return grid[m][n];
       int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
       if(n -1 >= 0) left = grid[m][n] + recursivehelper(grid, m, n-1);
       if(m -1 >= 0) up = grid[m][n] + recursivehelper(grid, m-1, n);
       return Math.min(left, up);
   }
   
   public static int memoizivehelper(int[][] grid, int m, int n, int[][] dp) {
       if(m == 0 && n == 0) return grid[m][n];
       int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
       if(dp[m][n] != -1) return dp[m][n];
       if(n -1 >= 0) left = grid[m][n] + recursivehelper(grid, m, n-1);
       if(m -1 >= 0) up = grid[m][n] + recursivehelper(grid, m-1, n);
       return dp[m][n] = Math.min(left, up);
   }
}