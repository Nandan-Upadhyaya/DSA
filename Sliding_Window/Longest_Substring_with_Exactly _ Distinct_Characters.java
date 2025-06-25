public static int longestSubstringWithExactlyKDistinct(String s, int k) {
    int l = 0, r = 0, maxlen = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (r < s.length()) {
        char c = s.charAt(r);
        map.put(c, map.getOrDefault(c, 0) + 1);

        while (map.size() > k) {
            char leftChar = s.charAt(l);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            l++;
        }

       
        if (map.size() == k) {
            maxlen = Math.max(maxlen, r - l + 1);
        }

        r++;
    }

    return maxlen;
}
