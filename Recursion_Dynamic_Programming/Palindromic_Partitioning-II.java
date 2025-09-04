
import java.util.Arrays;

class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return recursivehelper(0, s, dp) - 1;
    }

    public static int recursivehelper(int index, String s, int[] dp) {

     int mincuts = Integer.MAX_VALUE;
     if(index == s.length()) return 0;
     if(dp[index] != -1) return dp[index];

     for(int i = index ; i< s.length() ; i++) {
        
        if(isPalindrome(s, index, i)) {
            int cuts = 1 + recursivehelper(i + 1, s, dp);
            mincuts = Math.min(mincuts, cuts);
        }
     }
        return dp[index] = mincuts;
    }

    public static boolean isPalindrome(String s, int left, int right) {
    
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}