import java.util.*;
class Main {
    public static void main(String[] args) {
        String s1 = "zxabcdezy", s2 = "yzabcdezx";
        System.out.println(longestCommonSubstringRecursive(s1, s2));
        System.out.println(longestCommonSubstringMemoizive(s1, s2));
        System.out.println(longestCommonSubstringTabulative(s1, s2));
    }
    
    public static int longestCommonSubstringRecursive(String s1, String s2){
       return recursivehelper(s1, s2, s1.length() -1, s2.length() -1, 0);
    }
    
    public static int longestCommonSubstringMemoizive(String s1, String s2){
        int[][][] dp = new int[s1.length() +1][s2.length() + 1][Math.max(s1.length(), s2.length())];
            for (int[][] matrix : dp) {
               for (int[] arr : matrix) {
                    Arrays.fill(arr, -1);
                      }
                          }
       return memoizivehelper(s1, s2, s1.length() -1, s2.length() -1, 0, dp);
    }
    
    public static int longestCommonSubstringTabulative(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxlen = 0;
        for(int i = 1 ; i<=s1.length() ; i++){
            for(int j = 1 ; j<=s2.length() ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 +  dp[i-1][j-1];
                else  dp[i][j] = 0;
                maxlen = Math.max(maxlen, dp[i][j]);
            }
        }
        return maxlen;
    }
    
   public static int recursivehelper(String s1, String s2, int i, int j, int currlen){
       if(i < 0 || j < 0) return currlen;
       int len = currlen;
       if(s1.charAt(i) == s2.charAt(j)) len = recursivehelper(s1, s2, i-1, j-1, currlen + 1);
       int skips1 = recursivehelper(s1, s2, i-1, j, 0);
       int skips2 = recursivehelper(s1, s2, i, j-1, 0);
       return Math.max(len, Math.max(skips1, skips2));
   }
   
   public static int memoizivehelper(String s1, String s2, int i, int j, int currlen, int[][][] dp){
        if(i < 0 || j < 0) return currlen;
        int len = currlen;
        if(dp[i][j][currlen] != -1) return dp[i][j][currlen];
        if(s1.charAt(i) == s2.charAt(j)) len = memoizivehelper(s1, s2, i-1, j-1, currlen + 1, dp);
        int skips1 = memoizivehelper(s1, s2, i-1, j, 0, dp);
        int skips2 = memoizivehelper(s1, s2, i, j-1, 0, dp);
        return dp[i][j][currlen] = Math.max(len, Math.max(skips1, skips2));
        
   }
   
}