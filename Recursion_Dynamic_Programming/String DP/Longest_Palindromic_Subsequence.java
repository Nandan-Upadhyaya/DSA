
import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "ababba";
        System.out.println(longestPalindromeSubseqRecursive(s));
        System.out.println(longestPalindromeSubseqMemoizive(s));
        System.out.println(longestPalindromeSubseqTabulative(s));
    }
    public static int longestPalindromeSubseqRecursive(String s){
        return lpsrecursivehelper(s, 0, s.length() -1);
    }
    public static int longestPalindromeSubseqMemoizive(String s){
        int[][] dp = new int[s.length() +1][s.length()+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return lpsmemoizivehelper(s, 0, s.length() -1, dp);
    }
    public static int longestPalindromeSubseqTabulative(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp) Arrays.fill(arr, 0);
        for(int i= s.length() -1 ; i >= 0 ; i--){
            dp[i][i] = 1;
            for(int j = i+1  ; j <s.length() ; j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length() -1];
    }
    public static int lpsrecursivehelper(String s, int i, int j){
        if(i == j) return 1;
        if(i > j) return 0;
        if(s.charAt(i) == s.charAt(j)) return 2 + lpsrecursivehelper(s, i+1, j-1);
        else return Math.max(lpsrecursivehelper(s, i+1, j), lpsrecursivehelper(s, i, j-1));
    }
    public static int lpsmemoizivehelper(String s, int i, int j, int[][] dp){
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return 2 + lpsmemoizivehelper(s, i+1, j-1, dp);
        else return dp[i][j] = Math.max(lpsmemoizivehelper(s, i+1, j, dp), lpsmemoizivehelper(s, i, j-1, dp));
    }
    
}