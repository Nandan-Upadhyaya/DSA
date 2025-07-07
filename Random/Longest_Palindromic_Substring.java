import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(LongestPalindromicSubstring(s));
        
    }
    public static int LongestPalindromicSubstring(String s){
        int maxlen = 0;
        for(int i = 0 ; i < s.length() ; i++){
            maxlen = Math.max(maxlen, expandfromcenter(s,i, i));
            maxlen = Math.max(maxlen, expandfromcenter(s,i, i + 1));
        }
        return maxlen;
    }
    public static int expandfromcenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
         return right - left - 1;
    }
}