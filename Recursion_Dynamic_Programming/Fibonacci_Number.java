
import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(recursivefib(n));
        System.out.println(memoizivefib(n,dp));
        System.out.println(tabulativefib(n,dp));
        System.out.println(spaceoptimisivefib(n));
    }
    public static int recursivefib(int n){
        if(n == 0 || n == 1) return n;
        else return recursivefib(n-1) + recursivefib(n-2); 
    }
    public static int memoizivefib(int n, int[] dp){
         if(n == 0 || n == 1) return n;
         if(dp[n] != -1) return dp[n];
         dp[n] = memoizivefib(n-1, dp) + memoizivefib(n-2,dp);
         return dp[n];
         }
    public static int tabulativefib(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int spaceoptimisivefib(int n){
        int prev1 = 1, prev2 = 0;
        if(n == 0 || n == 1) return n;
        for(int i = 2 ; i<= n ; i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}