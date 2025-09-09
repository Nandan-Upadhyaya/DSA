import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertionsToMakePalindromeRecursive(s));
        System.out.println(minInsertionsToMakePalindromeMemoizive(s));
        System.out.println(minInsertionsToMakePalindromeTabulative(s));
    }
    
    public static int minInsertionsToMakePalindromeRecursive(String s){
        return recursivehelper(s, 0, s.length() -1);
    }
    public static int minInsertionsToMakePalindromeMemoizive(String s){
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(s, 0, s.length() -1, dp);
    }
    public static int minInsertionsToMakePalindromeTabulative(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;

            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = dp[i + 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[0][n - 1];
}

    public static int recursivehelper(String s, int i , int j){
        if(j < i) return 0;
        if(s.charAt(i) == s.charAt(j)) return recursivehelper(s, i+1, j-1);
        else return Math.min(1 + recursivehelper(s, i+1, j), 1 + recursivehelper(s, i, j-1));
    }
    public static int memoizivehelper(String s, int i , int j, int[][] dp){
        if(j < i) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return memoizivehelper(s, i+1, j-1, dp);
        else return dp[i][j] = Math.min(1 + memoizivehelper(s, i+1, j, dp), 1 + memoizivehelper(s, i, j-1, dp));
    }
}
