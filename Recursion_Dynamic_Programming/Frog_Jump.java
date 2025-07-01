import java.util.*;
class Main {
    public static void main(String[] args) {
         int[] heights = {10,30,40,20};
         int[] dp = new int[heights.length+1];
         Arrays.fill(dp, -1);
         System.out.println(frogJumpRecursive(heights.length - 1, heights));
         System.out.println(frogJumpMemoizive(heights.length - 1, heights, dp));
         System.out.println(frogJumpTabulative(heights.length - 1, heights, dp));
         System.out.println(frogJumpSpaceOptimisive(heights.length - 1, heights));
    }
    public static int frogJumpRecursive(int n, int[] heights){
        if(n == 0) return 0;
        int onejump = frogJumpRecursive(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int twojump = Integer.MAX_VALUE;
        if(n - 2 >= 0) twojump = frogJumpRecursive(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        return Math.min(onejump, twojump);
    }
    public static int frogJumpMemoizive(int n ,int[] heights, int[] dp){
         if(n == 0) return 0;
         if(dp[n] != -1) return dp[n];
         int onejump = frogJumpMemoizive(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int twojump = Integer.MAX_VALUE;
        if(n - 2 >= 0) twojump = frogJumpMemoizive(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
         return dp[n] = Math.min(onejump, twojump);
    }
    public static int frogJumpTabulative(int n ,int[] heights, int[] dp){
        dp[0] = 0; 
        for(int i = 1 ; i<=n ; i++){
             int onejump = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
             int twojump = Integer.MAX_VALUE;
             if(i-2 >= 0) twojump = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
             dp[i] = Math.min(onejump, twojump);
        }
        return dp[n];
    }
    public static int frogJumpSpaceOptimisive(int n ,int[] heights){
        int prev2 = 0, prev1 = 0, minenergy = Integer.MAX_VALUE;
        for(int i = 1 ; i<=n ; i++){
            int onejump = prev1 +  Math.abs(heights[i] - heights[i-1]);
            int twojump = Integer.MAX_VALUE;
            if(i-2 >= 0) twojump = prev2 + Math.abs(heights[i] - heights[i-2]);
            int current = Math.min(onejump, twojump);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}