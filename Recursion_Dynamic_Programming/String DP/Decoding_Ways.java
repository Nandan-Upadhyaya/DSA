
import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
          return recursivehelper(s, 0, dp);
    }

    public int recursivehelper(String s, int index, int[] dp) {
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != -1) return dp[index];
        int onedigit = recursivehelper(s, index + 1, dp);
        int twodigit = 0;
        if(index + 1 < s.length()) {
            int twodigits = Integer.parseInt(s.substring(index, index + 2));
            if(twodigits >= 10 && twodigits <= 26)
            twodigit = recursivehelper(s, index + 2, dp);
        }
         return dp[index] = onedigit + twodigit;
    }
}