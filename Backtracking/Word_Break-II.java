
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        recursivehelper(s, new HashSet<>(wordDict), 0, new ArrayList<>(), result);
        return result;
        
    }

    public static void recursivehelper(String s, Set<String> wordSet, int start, List<String> path, List<String> result) {
      if(start == s.length()) {
        result.add(String.join(" ", path));
        return;
      }
    
      for(int end = start + 1; end <= s.length() ; end++) {
          String prefix = s.substring(start, end);
          if(wordSet.contains(prefix)) {
            path.add(prefix);
            recursivehelper(s, wordSet, end, path, result);
            path.remove(path.size() - 1);
          }
      }
      
    }

    public static List<String> memoizivehelper(String s, Set<String> wordSet, int start, List<String>[] dp) {
        if (dp[start] != null) return dp[start];

        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add(""); 
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                List<String> suffixes = memoizivehelper(s, wordSet, end, dp);
                for (String suffix : suffixes)  result.add(prefix + (suffix.isEmpty() ? "" : " " + suffix));
            }
        }

        dp[start] = result; 
        return result;
    }
}