import java.util.*;
class Main {
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistanceRecursive(word1, word2));
        System.out.println(minDistanceMemoizive(word1, word2));
        System.out.println(minDistanceTabulative(word1, word2));
    }
    public static int minDistanceRecursive(String word1, String word2){
        return recursivehelper(word1, word2, word1.length() - 1, word2.length() -1);
    }
     public static int minDistanceMemoizive(String word1, String word2){
         int[][] dp = new int[word1.length() +1][word2.length() +1];
         for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(word1, word2, word1.length() - 1, word2.length() -1, dp);
    }
     public static int minDistanceTabulative(String word1, String word2){
         int[][] dp = new int[word1.length() +1][word2.length() +1];
         for(int[] arr : dp) Arrays.fill(arr, 0);
         for(int i = 0 ; i<= word1.length() ; i++) dp[i][0] = i;
         for(int j = 0 ; j<=word2.length() ; j++) dp[0][j] = j;
         
         for(int i = 1 ; i <= word1.length() ; i++){
             for(int j = 1 ; j <= word2.length() ; j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                 else dp[i][j] = Math.min(1 + dp[i][j-1], Math.min(1 + dp[i-1][j], 1 + dp[i-1][j-1]));
             }
         }
         return dp[word1.length()][word2.length()];
    }
    public static int recursivehelper(String word1, String word2, int i, int j){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(word1.charAt(i) == word2.charAt(j)) return recursivehelper(word1, word2, i-1, j-1);
        else{
            int insert = 1 + recursivehelper(word1, word2, i, j-1);
            int delete = 1 + recursivehelper(word1, word2, i-1, j);
            int replace = 1 + recursivehelper(word1, word2, i-1, j-1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
    public static int memoizivehelper(String word1, String word2, int i, int j, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) return memoizivehelper(word1, word2, i-1, j-1, dp);
        else{
            int insert = 1 + memoizivehelper(word1, word2, i, j-1, dp);
            int delete = 1 + memoizivehelper(word1, word2, i-1, j, dp);
            int replace = 1 + memoizivehelper(word1, word2, i-1, j-1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}