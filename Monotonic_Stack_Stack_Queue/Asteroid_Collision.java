 public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<asteroids.length ; i++){
            if(asteroids[i] > 0) stack.push(asteroids[i]);
            else{
            while(!stack.isEmpty()  && Math.abs(asteroids[i]) >= stack.peek()) stack.pop();
             if(stack.isEmpty() || stack.peek() < 0) stack.push(asteroids[i]);
        }
        }
        int[] results = new int[stack.size()];
        for(int i = stack.size() - 1 ; i>= 0 ; i--){
            results[i] = stack.pop();
        }
        return results;
    }