import java.util.*;
class Main {
    public static void main(String[] args) {
        String text1 = "acd";
        String text2 = "abc";
        System.out.println(recursivelongestCommonSubsequence(text1, text2));
        System.out.println(memoizivelongestCommonSubsequence(text1, text2));
        System.out.println(tabulativelongestCommonSubsequence(text1, text2));
    }
    
    public static int recursivelongestCommonSubsequence(String text1, String text2){
        return recursivelcshelper(text1, text2, text1.length(), text2.length());
    }
    
    public static int memoizivelongestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivelcshelper(text1, text2, text1.length(), text2.length(), dp);
    }
    
     public static int tabulativelongestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] arr : dp) Arrays.fill(arr, 0);
        dp[0][0] = 0;
        for(int i = 1 ; i<= text1.length() ; i++){
            for(int j = 1 ; j <= text2.length() ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))  dp[i][j] = 1 + dp[i-1][j-1];
                else  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
    
    public static int recursivelcshelper(String text1, String text2, int i, int j){
        if(i == 0 || j == 0) return 0;
        if(text1.charAt(i-1) == text2.charAt(j-1)) return 1 + recursivelcshelper(text1, text2, i-1,j-1);
        else return Math.max(recursivelcshelper(text1, text2, i-1,j), recursivelcshelper(text1, text2, i, j-1));
    }
    
    public static int memoizivelcshelper(String text1, String text2, int i, int j, int[][] dp){
         if(i == 0 || j == 0) return 0;
         if(dp[i][j] != -1) return dp[i][j];
         if(text1.charAt(i-1) == text2.charAt(j-1)) return 1 + memoizivelcshelper(text1, text2, i-1, j-1, dp);
         else return dp[i][j] = Math.max(memoizivelcshelper(text1, text2, i-1,j, dp), memoizivelcshelper(text1, text2, i, j-1, dp));
    }
}