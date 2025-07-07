import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRodRecursive(price, n));
        System.out.println(cutRodMemoizive(price, n));
        System.out.println(cutRodTabulative(price, n));
    }
    public static int cutRodRecursive(int[] price, int n){
        return recursivehelper(price.length - 1, price, n);
    }
    
    public static int cutRodMemoizive(int[] price, int n){
        int[][] dp = new int[price.length + 1][n + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(price.length - 1, price, n, dp);
    }
    
    public static int cutRodTabulative(int[] price, int n){
        int[][] dp = new int[price.length + 1][n + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        for(int i = 0 ; i<price.length ; i++){
            for(int j = 0 ; j<= n; j++){
                if(i == 0) dp[i][j] = price[0] * j;
                else{
                int notpick = dp[i-1][j];
                int pick = i + 1 <= j ? price[i] + dp[i][j - (i + 1)] : 0;
                dp[i][j] = Math.max(pick, notpick);
                }
            }
        }
       return dp[price.length -1][n];
    }
    
    public static int recursivehelper(int index, int[] price, int n){
        if(index == 0) return price[0] * n;
        int notpick = recursivehelper(index-1, price, n);
        int pick = 0;
        if(index + 1 <= n) pick = price[index] + recursivehelper(index, price, n - (index + 1));
        return Math.max(pick, notpick);
    }
    
    public static int memoizivehelper(int index, int[] price, int n, int[][] dp){
        if(index == 0) return price[0] * n;
        if(dp[index][n] != -1) return dp[index][n];
        int notpick = memoizivehelper(index-1, price, n, dp);
        int pick = 0;
        if(index + 1 <= n) pick = price[index] + memoizivehelper(index, price, n - (index + 1), dp);
        return dp[index][n] = Math.max(pick, notpick);
    }
    
}