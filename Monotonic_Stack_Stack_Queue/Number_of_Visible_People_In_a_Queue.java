public static int[] canSeePersonsCount(int[] heights){
      int[] result = new int[heights.length];
      Stack<Integer> stack = new Stack<>();
      for(int i = 0 ; i< heights.length ; i++){
          while(!stack.isEmpty() && heights[i] > heights[stack.peek()]){
              result[stack.pop()]++;
          } 
          if(!stack.isEmpty() && heights[i] < heights[stack.peek()]) result[stack.peek()]++; 
          stack.push(i);
      }
      return result;
    }