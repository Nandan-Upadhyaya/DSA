
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<String> queue = new LinkedList<>();
       Set<String> wordSet = new HashSet<>(wordList);
       Set<String> visited = new HashSet<>();

       if(!wordSet.contains(endWord)) return 0;

       queue.offer(beginWord);
       visited.add(beginWord);
       
       int steps = 1;

       while(!queue.isEmpty()) {
        int size = queue.size();

        for(int s = 0 ; s < size ; s++) {
            String cur = queue.poll();

            if(cur.equals(endWord)) return steps;

            char[] arr = cur.toCharArray();
            for(int i = 0 ; i< arr.length ; i++) {
            char original = arr[i];
            for(char c = 'a' ; c <= 'z' ; c++) {
               if(c == original) continue;
               arr[i] = c;
               String next = new String(arr);

               if(wordSet.contains(next) && !visited.contains(next)) {
                queue.offer(next);
                visited.add(next);
               }
            }

            arr[i] = original;
        }

        }
        steps++;

       }
       return 0;
    }
}