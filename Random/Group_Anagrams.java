
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class SolutionOptimized {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String, List<String>> map = new HashMap<>();
     for(String word : strs){
        char[] wordarray = word.toCharArray();
        Arrays.sort(wordarray);
        String sortedWord = new String(wordarray);

        if(!map.containsKey(sortedWord)) map.put(sortedWord, new ArrayList<>());
        map.get(sortedWord).add(word);
       
     }
      return new ArrayList<>(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     List<List<String>> result = new ArrayList<>();
  
     boolean[] visited = new boolean[strs.length];
     int i = 0;
     while(i < strs.length){
        if(visited[i]){
           i++;
           continue;
        }
        List<String> current = new ArrayList<>();
        current.add(strs[i]);
        visited[i] = true;
         int j = i + 1;
        while(j < strs.length){
            if(isAnagram(strs[i], strs[j]) && !visited[j]){
              current.add(strs[j]);
              visited[j] = true;
              
            }
            j++;
            
        }
        result.add(current);
        i++;
     }

        return result;
    }

    public static boolean isAnagram(String string1, String string2){
        if(string1.length() != string2.length()) return false;
        int[] count = new int[26];
        for(int i = 0 ; i<string1.length() ; i++){
            count[string1.charAt(i) - 'a']++;
            count[string2.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i<count.length ; i++){
            if(count[i] != 0) return false;
        }
      return true;
    }
}