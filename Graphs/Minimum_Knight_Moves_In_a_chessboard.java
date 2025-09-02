import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println(minknightmovesinchessboard(5,5));
    }
    
    public static int minknightmovesinchessboard(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new int[] {0,0});
        visited.add("0,0");
        
        int steps = 0;
        
        int[][] directions = { {2,1}, {2,-1}, {-2,-1}, {-2,1}, {1,2}, {1,-2}, {-1,-2}, {-1,2}};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0 ; s < size ; s++) {
                int[] current = queue.poll();
                int i = current[0], j = current[1];
                
                if(i == start && j == end) return steps;
                
                for(int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    
                    if(ni > -1 && nj > -1) {
                        String key = ni + "," + nj;
                        if(!visited.contains(key)) {
                            visited.add(key);
                            queue.offer(new int[] {ni, nj});
                        }
                        
                    }
                }
                
            }
            
            steps++;
        }
        return -1;
    }
}