import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] coins = {3, 7, 405, 436};
        int amount = 8839 ;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        //System.out.println(coinChangeRecursive(coins, amount));
        System.out.println(coinChangeMemoizive(coins, amount, dp));
        System.out.println(coinChangeTabulative(coins, amount));
    }
    public static int coinChangeRecursive(int[] coins, int amount){
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        int mincoins = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length ; i++){
            int res = coinChangeRecursive(coins, amount - coins[i]);
            if(res != Integer.MAX_VALUE) mincoins = Math.min(res + 1, mincoins);
        }
        return mincoins == Integer.MAX_VALUE ? -1 : mincoins;
    }
    public static int coinChangeMemoizive(int[] coins, int amount, int[] dp){
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount] == -2 ? Integer.MAX_VALUE : dp[amount];
        int mincoins = Integer.MAX_VALUE;
        for(int i = 0 ; i< coins.length ; i++){
            int res = coinChangeMemoizive(coins, amount - coins[i], dp);
            if(res != Integer.MAX_VALUE) mincoins = Math.min(res + 1, mincoins);
        }
         dp[amount] = mincoins  == Integer.MAX_VALUE ? -2 : mincoins;
         return mincoins == Integer.MAX_VALUE ? Integer.MAX_VALUE : mincoins;
    }
   public static int coinChangeTabulative(int[] coins, int amount){
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for(int i = 1; i <= amount; i++){
        for(int coin : coins){
            if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
}

    
}