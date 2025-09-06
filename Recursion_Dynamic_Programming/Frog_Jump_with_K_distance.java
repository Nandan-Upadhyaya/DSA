import java.util.*;
class Main {
    public static void main(String[] args) {
         int[] heights = {10, 30, 40, 20};
         int k = 3;
         int[] dp = new int[heights.length+1];
         Arrays.fill(dp, -1);
         System.out.println(frogJumpKRecursive(heights.length - 1,  k, heights));
         System.out.println(frogJumpKMemoizive(heights.length - 1 ,k, heights, dp));
         System.out.println(frogJumpKTabulative(heights.length - 1, k,heights, dp));
         
    }
    public static int frogJumpKRecursive(int n, int k, int[] heights){
        if(n == 0) return 0;
        int minenergy = Integer.MAX_VALUE;
        int kjumps = 0;
        for(int i = 1 ; i<=k ; i++){
            if(n- i >= 0) 
             kjumps = frogJumpKRecursive(n-i, k, heights) + Math.abs(heights[n] - heights[n-i]);
            minenergy = Math.min(minenergy, kjumps);
        }
       return minenergy; 
    }
     public static int frogJumpKMemoizive(int n, int k, int[] heights, int[] dp){
        if(n == 0) return 0;
        int minenergy = Integer.MAX_VALUE;
        int kjumps = 0;
        if(dp[n] != -1) return dp[n];
        for(int i = 1 ; i<=k ; i++){
            if(n- i >= 0) 
             kjumps = frogJumpKMemoizive(n-i, k, heights, dp) + Math.abs(heights[n] - heights[n-i]);
            minenergy = Math.min(minenergy, kjumps);
        }
       return dp[n] = minenergy; 
    }
     public static int frogJumpKTabulative(int n, int k, int[] heights, int[] dp){
        dp[0] = 0;
       
        int kjumps = 0;
        for(int i = 1 ; i<= n ;i++){
            for(int j = 1 ; j<=k ; j++){
            if(i- j >= 0) 
             kjumps = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
            dp[i] = Math.min(dp[i], kjumps);
        }
       
    }
    return dp[n];
    }
}

       
    
