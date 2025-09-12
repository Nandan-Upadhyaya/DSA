
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        return recursivehelper(s, new HashSet<>(wordDict), 0, dp);
    }

    public static boolean recursivehelper(String s, Set<String> wordSet, int start, Boolean[] dp) {

        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        for(int end = start + 1 ; end <= s.length() ; end++) {
            String prefix = s.substring(start, end);

            if(wordSet.contains(prefix)) {
                if(recursivehelper(s, wordSet, end, dp)) {
                      dp[start] = true;
                      return true;
                } 
               
            }
        }
          dp[start] = false;
          return false;
    }

    public static boolean tabulativehelper(String s, Set<String> wordSet) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i = s.length() - 1 ; i>= 0 ; i--) {
            for(int end = i + 1 ; end <= s.length() ; end++) {
                String prefix = s.substring(i, end);
                if(wordSet.contains(prefix)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}