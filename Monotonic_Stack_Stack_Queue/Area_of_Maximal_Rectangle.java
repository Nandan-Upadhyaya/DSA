import java.util.*;
class Main {
  
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix){
         int maxArea = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];
        for(int i = 0 ; i< matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; i++){
                if(heights[j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, findMaxArea(heights));
        }
        return maxArea;
    }
    public static int findMaxArea(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int[] newheights = new int[heights.length + 1];
        System.arraycopy(heights, 0, newheights, 0, heights.length);
        newheights[newheights.length -1] = 0;
        
        for(int i = 0 ; i<newheights.length ; i++){
            while(!stack.isEmpty() && newheights[i] < newheights[stack.peek()]){
                int height = newheights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
                
            }
            stack.push(i);
        }
        return maxArea;
}
}