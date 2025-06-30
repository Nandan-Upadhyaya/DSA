 public static List<Integer> maxSlidingWindow(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0 ; i< nums.length ; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i-k) deque.pollFirst();
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
            if(i >= k-1) list.add(nums[deque.peekFirst()]);
        }
        return list;
    }