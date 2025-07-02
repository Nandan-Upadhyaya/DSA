import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] obstacleGrid = { 
        {0,1},
  {0,0}
        };
        System.out.println(uniquePathsWithObstaclesRecursive(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesMemoizive(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesTabulative(obstacleGrid));
         System.out.println(uniquePathsWithObstaclesSpaceoptimisive(obstacleGrid));
    }
    
    public static int uniquePathsWithObstaclesRecursive(int[][] obstacleGrid){
        return recursivehelper(obstacleGrid, obstacleGrid.length -1, obstacleGrid[0].length -1);
    }
    
    public static int uniquePathsWithObstaclesMemoizive(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(obstacleGrid, obstacleGrid.length -1, obstacleGrid[0].length -1, dp);
    }
    
     public static int uniquePathsWithObstaclesTabulative(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for(int[] arr : dp) Arrays.fill(arr, 0);
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
       
        for(int i =1 ; i<obstacleGrid.length  ; i++){
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) ? 1 : 0;
        } 
        for(int j = 1; j<obstacleGrid[0].length ; j++){
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j-1] == 1) ? 1 : 0;
        } 
            
            for(int i = 1 ; i< obstacleGrid.length ; i++){
                for(int j = 1 ; j< obstacleGrid[0].length ; j++){
                    if(obstacleGrid[i][j] == 0){
                     dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    
    public static int uniquePathsWithObstaclesSpaceoptimisive(int[][] obstacleGrid){
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    
    int[] prev = new int[n];
    
    for(int i = 0; i < m; i++){
        int[] current = new int[n];
        for(int j = 0; j < n; j++){
            if(obstacleGrid[i][j] == 1){
                current[j] = 0; 
            } else if(i == 0 && j == 0){
                current[j] = 1; 
            } else {
                int up = i > 0 ? prev[j] : 0;
                int left = j > 0 ? current[j-1] : 0;
                current[j] = up + left;
            }
        }
        prev = current;
    }
    
    return prev[n - 1];
}
    
    public static int recursivehelper(int[][] obstacleGrid, int m, int n){
        if(m == 0 && n == 0) return 1;
        int left = 0, up = 0;
        if(obstacleGrid[m][n] == 0){
            if(n -1 >= 0 && obstacleGrid[m][n-1] == 0)
                left = recursivehelper(obstacleGrid, m, n-1);
            if(m -1 >= 0 && obstacleGrid[m-1][n] == 0)
                up = recursivehelper(obstacleGrid, m-1, n);
        }
        return left + up;
    }
    
    public static int memoizivehelper(int[][] obstacleGrid, int m, int n, int[][] dp){
        if(m == 0 && n == 0) return 1;
        int left = 0, up = 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(obstacleGrid[m][n] == 0){
            if(n -1 >= 0 && obstacleGrid[m][n-1] == 0)
                left = memoizivehelper(obstacleGrid, m, n-1, dp);
            if(m -1 >= 0 && obstacleGrid[m-1][n] == 0)
                up = memoizivehelper(obstacleGrid, m-1, n, dp);
        }
        return dp[m][n] = left + up;
        
    }
}
