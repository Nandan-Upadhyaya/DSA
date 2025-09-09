class Solution {
    public boolean isMatch(String s, String p) {
        return recursivehelper(s.length() - 1, p.length() - 1, s, p);
    }

    public static boolean recursivehelper(int i, int j, String s, String p) {
     if(i < 0 && j < 0) return true;
     if(j < 0 && i >= 0) return false;

     if(i < 0) {
        if(p.charAt(j) != '*') return false;
        return recursivehelper(i, j-2, s,p);
     }

     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return recursivehelper(i-1, j-1, s, p);

     else if(p.charAt(j) == '*') {
        if(recursivehelper(i, j-2, s, p)) return true; 
        if(p.charAt(j-1) == s.charAt(i) || p.charAt(j - 1) == '.') return recursivehelper(i-1, j, s, p);
            
     }
       return false;
    }



}