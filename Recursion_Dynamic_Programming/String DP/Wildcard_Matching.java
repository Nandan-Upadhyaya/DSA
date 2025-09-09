import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "abcde", p = "a*?e";
       System.out.println(isMatchRecursive(s, p));
       System.out.println(isMatchMemoizive(s, p)); 
       System.out.println(isMatchTabulative(s, p)); 
    }
    
    public static boolean isMatchRecursive(String s, String p){
     return recursivehelper(s,p, s.length() -1, p.length() -1);   
    }
    
     public static boolean isMatchMemoizive(String s, String p){
     Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
     return memoizivehelper(s,p, s.length() -1, p.length() -1, dp);   
    }
    
    public static boolean isMatchTabulative(String s, String p){
     boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
     dp[0][0] = true;
    
     for(int j = 1 ; j<=p.length() ; j++){
         boolean allstars = true;
          for(int k = 0 ; k < j ; k++) 
               if(p.charAt(k) != '*'){
                   allstars = false;
                   break;
               } 
              dp[0][j] = allstars; 
     }
     for(int i = 1 ; i<= s.length() ; i++){
         for(int j = 1 ; j<= p.length() ; j++){
             if(s.charAt(i - 1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
             else if(p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
             else dp[i][j] = false;
         }
     }
     return dp[s.length()][p.length()];
    }
    
    public static boolean recursivehelper(String s, String p, int i, int j){
       if(i < 0 && j < 0) return true;
       if(j < 0 && i >= 0) return false;
       if(i < 0 && j >= 0){
           for(int k = 0 ; k <= j ; k++) if(p.charAt(k) != '*') return false;
           return true;
       }
       if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return recursivehelper(s, p, i-1, j-1);
       else if(p.charAt(j) == '*') return recursivehelper(s, p, i-1, j) || recursivehelper(s, p, i, j-1);
       else return false;
       
    }
    
    public static boolean memoizivehelper(String s, String p, int i, int j, Boolean[][] dp){
       if(i < 0 && j < 0) return true;
       if(j < 0 && i >= 0) return false;
       if(i < 0 && j >= 0){
           for(int k = 0 ; k <= j ; k++) if(p.charAt(k) != '*') return false;
           return true;
       }
       if(dp[i][j] != null) return dp[i][j];
       if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return dp[i][j] = memoizivehelper(s, p, i-1, j-1, dp);
       else if(p.charAt(j) == '*') return dp[i][j] = memoizivehelper(s, p, i-1, j, dp) || memoizivehelper(s, p, i, j-1, dp);
        else return dp[i][j] = false;
    }
    }
       
  