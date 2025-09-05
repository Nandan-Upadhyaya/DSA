class Solution {
    public boolean isSubsequence(String s, String t) {
        Boolean[][] dp = new Boolean[s.length() + 1][t.length() + 1];
        return recursivehelper(s.length() - 1, t.length() - 1, s, t, dp);
    }
    public static boolean recursivehelper(int i, int j, String s, String t, Boolean[][] dp) {
        if(i < 0) return true;
        if(j < 0) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = recursivehelper(i - 1, j - 1, s , t, dp);
        else return dp[i][j] = recursivehelper(i, j - 1 ,s , t, dp);
    }
}