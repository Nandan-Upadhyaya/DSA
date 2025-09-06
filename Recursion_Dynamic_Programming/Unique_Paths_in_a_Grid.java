
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int m = 5, n= 4;
        System.out.println(uniquePathsRecursive(m ,n));
        System.out.println(uniquePathsMemoizive(m ,n));
        System.out.println(uniquePathsTabulative(m ,n));
        System.out.println(uniquePathsSpaceoptimizive(m ,n));
    }
    
    public static int uniquePathsRecursive(int m, int n){
     return recursivehelper(m-1,n-1);
    }
    
    public static int uniquePathsMemoizive(int m, int n){
     int[][] dp = new int[m+1][n+1];
     for(int[] arr : dp) Arrays.fill(arr, -1);
     return memoizivehelper(m-1,n-1, dp);
    }
    
    public static int uniquePathsTabulative(int m, int n){
     int[][] dp = new int[m+1][n+1];
     for(int[] arr : dp) Arrays.fill(arr, 0);
     for (int i = 0; i < m; i++) dp[i][0] = 1;
     for (int j = 0; j < n; j++) dp[0][j] = 1;
     for(int i = 1 ; i<m ; i++){
         for(int j = 1 ; j<n ; j++){
             dp[i][j] = dp[i-1][j] + dp[i][j-1];
         }
     }
     return dp[m-1][n-1];
    }
    public static int uniquePathsSpaceoptimizive(int m, int n) {
    int[] prev = new int[n];
    Arrays.fill(prev, 1); 

    for (int i = 1; i < m; i++) {
        int[] curr = new int[n];
        curr[0] = 1;
        for (int j = 1; j < n; j++) {
            curr[j] =  prev[j] + curr[j - 1] ;
        }
        prev = curr;
    }
    return prev[n - 1];
}

    
    public static int recursivehelper(int m, int n){
    if(m == 0 && n == 0) return 1;
    int left = 0, up = 0;
    if(n -1 >= 0)
     left =  recursivehelper(m , n-1);
    if(m -1 >= 0)
     up = recursivehelper(m-1, n);
    return left + up;
    }
    public static int memoizivehelper(int m, int n, int[][] dp){
    if(m == 0 && n == 0) return 1;
    int left = 0, up = 0;
    if(dp[m][n] != -1) return dp[m][n];
    if(n -1 >= 0)
     left =  memoizivehelper(m , n-1, dp);
    if(m -1 >= 0)
     up = memoizivehelper(m-1, n, dp);
    return dp[m][n] = left + up;
    }
    
}
