class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return recursivehelper(s1, s2, s3, 0, 0, 0, dp);
    }
    public static boolean recursivehelper(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][] dp ) {
        
       if(index3 == s3.length()) return index1 == s1.length() && index2 == s2.length();
       
       boolean takeS1 = false, takeS2 = false;
       if(dp[index1][index2] != null) return dp[index1][index2];

       if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3))
        takeS1 = recursivehelper(s1, s2, s3, index1 + 1, index2, index3 + 1, dp);

       if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3))
        takeS2 = recursivehelper(s1, s2, s3, index1, index2 + 1, index3 + 1, dp);

       return dp[index1][index2] = takeS1 || takeS2;
    }
}