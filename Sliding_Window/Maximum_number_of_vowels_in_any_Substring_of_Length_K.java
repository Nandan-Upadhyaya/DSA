public static int maxVowels(String s, int k){
        int len = 0;
        int vowels = 0;
        int maxvowels = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            if(isVowel(s.charAt(r))) vowels++;
            len++;
            while(len > k){
                if(isVowel(s.charAt(l))) vowels--;
                len--;
                l++;
            }
            maxvowels = Math.max(maxvowels, vowels);
            r++;
        }
       return maxvowels;
    }
    static public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }