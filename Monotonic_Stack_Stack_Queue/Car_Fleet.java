 public static int carFleet(int target, int[] position, int[] speed){
        Stack<Double> stack = new Stack<>();
        double[][] cars = new double[position.length][position.length];
        for(int i = 0 ; i<position.length ; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        
        for(int i = 0 ; i< cars.length ; i++){
            if(stack.isEmpty() || cars[i][1] > stack.peek()){
                stack.push(cars[i][1]);
            }
        }
        return stack.size();
    }