
import java.util.Arrays;

class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return countTrees(1,n, dp);
    }

    public static int countTrees(int start, int end, int[][] dp) {
        if(start > end) return 1;
        int total = 0;
        if(dp[start][end] != -1) return dp[start][end];
        for(int i = start ; i<= end ; i++) {
            int leftCount = countTrees(start, i-1, dp);
            int rightCount = countTrees(i+1, end, dp);
            total += leftCount * rightCount;
        }
        return dp[start][end] = total;
    }
}