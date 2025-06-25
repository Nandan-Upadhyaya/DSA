public static int countUniqueSubstrings(String s){
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            while(map.get(s.charAt(r)) > 1){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }