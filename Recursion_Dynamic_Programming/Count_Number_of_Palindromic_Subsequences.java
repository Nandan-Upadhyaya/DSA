import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "abcbacbbacbabcbacbab";
        System.out.println(countPalindromicSubsequencesRecursive(s));
        System.out.println(countPalindromicSubsequencesMemoizive(s));
        System.out.println(countPalindromicSubsequencesTabulative(s));
    }
    
    public static int countPalindromicSubsequencesRecursive(String s){
        return recursivehelper(s, 0, s.length() -1);
    }
    
    public static int countPalindromicSubsequencesMemoizive(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(s, 0, s.length() -1, dp);
    }
    
    public static int countPalindromicSubsequencesTabulative(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp) Arrays.fill(arr, 0);
        for(int i = 0 ; i<s.length() ; i++) dp[i][i] = 1;
        for(int len = 2 ; len <= s.length() ; len++){
            for(int i = 0 ; i <= s.length() - len ; i++){
                int j = len + i -1;
                 if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1 + dp[i + 1][j] + dp[i][j-1];
                 else dp[i][j] = dp[i + 1][j] + dp[i][j-1] - dp[i+1][j-1];
            }
        }
        return dp[0][s.length() - 1];
    }
    
    public static int recursivehelper(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(s.charAt(i) == s.charAt(j)) return 1 + recursivehelper(s, i+1, j) + recursivehelper(s, i, j - 1) ;
        else return recursivehelper(s, i+1, j) + recursivehelper(s, i, j - 1) - recursivehelper(s, i + 1, j-1);
    }
    
    public static int memoizivehelper(String s, int i, int j, int[][] dp){
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 1 + memoizivehelper(s, i+1, j, dp) + memoizivehelper(s, i, j - 1, dp) ;
        else return dp[i][j] = memoizivehelper(s, i+1, j, dp) + memoizivehelper(s, i, j - 1, dp) - memoizivehelper(s, i + 1, j-1, dp);
    }
}