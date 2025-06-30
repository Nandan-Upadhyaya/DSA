// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 15;
        int[] dp = new int[n +1];
        Arrays.fill(dp, -1);
        System.out.println(recursiveclimbStairs(n));
        System.out.println(memoiziveclimbStairs(n,dp));
        System.out.println(tabulativeclimbStairs(n,dp));
        System.out.println(spaceoptimisiveclimbStairs(n));
    }
    public static int recursiveclimbStairs(int n){
       if(n == 0) return 1;
       if(n < 0) return 0;
       return recursiveclimbStairs(n-1) + recursiveclimbStairs(n-2); 
    }
    public static int memoiziveclimbStairs(int n, int[] dp){
         if(n == 0) return 1;
         if(n < 0) return 0;
         if(dp[n] != -1) return dp[n];
         dp[n] = memoiziveclimbStairs(n-1,dp) + memoiziveclimbStairs(n-2,dp); 
         return dp[n];
    }
    public static int tabulativeclimbStairs(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i<=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int spaceoptimisiveclimbStairs(int n){
        if(n == 0 || n == 1) return 1;
        int prev2 = 1, prev1 = 1;
        for(int i = 2 ; i<= n ; i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

}