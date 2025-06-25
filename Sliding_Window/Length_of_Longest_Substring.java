public static int lengthOfLongestSubstring(String s){
    Map<Character, Integer> map = new HashMap<>();
    int l = 0, maxlen = 0;

    for (int r = 0; r < s.length(); r++) {
        char ch = s.charAt(r);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        
        while(map.get(ch) > 1){
            char leftChar = s.charAt(l);
            map.put(leftChar, map.get(leftChar) - 1);
            if(map.get(leftChar) == 0) map.remove(leftChar);
            l++;
        }

        maxlen = Math.max(maxlen, r - l + 1);
    }

    return maxlen;
}