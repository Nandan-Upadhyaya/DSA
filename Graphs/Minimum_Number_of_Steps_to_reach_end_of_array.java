import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(minstepstoreachendofarray(nums));
    }
    
    public static int minstepstoreachendofarray(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(0);
        visited.add(0);
        
        int steps = 0;
        
        while(!queue.isEmpty()) {
        int size = queue.size();
        for(int s = 0 ; s < size ; s++) {
            int i = queue.poll();
            
            if(i == nums.length - 1) return steps;
            
            for(int j = 0 ; j<= nums[i] ; j++) {
                if(j + i < nums.length && !visited.contains(j + i)) {
                visited.add(j + i);
                queue.offer(j + i);
            }
                
            }
    
        }
         steps++;
        }
        return -1;
    }
}