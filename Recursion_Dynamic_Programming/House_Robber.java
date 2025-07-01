import java.util.*;
class Main {
    public static void main(String[] args) {
         int[] nums = {5,2};
         System.out.println(recursiverob(nums));
         System.out.println(memoiziverob(nums));
         System.out.println(tabulativerob(nums));
         System.out.println(spaceoptimisiverob(nums));
    }
   public static int recursiverob(int[] nums){
       return recursivehelper(nums.length - 1 , nums);
   }
   public static int memoiziverob(int[] nums){
     int[] dp = new int[nums.length+1];
     Arrays.fill(dp, -1);
       return memoizivehelper(nums.length - 1 , nums, dp);
   }
   public static int tabulativerob(int[] nums){
     if (nums.length == 1) return nums[0];
     if (nums.length == 2) return Math.max(nums[0], nums[1]);
     int[] dp = new int[nums.length+1];
     Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i< nums.length ; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];  
   }
   public static int spaceoptimisiverob(int[] nums){
      if(nums.length == 1) return nums[0];
      else if(nums.length == 2) return Math.max(nums[0], nums[1]);
      else{
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]), current = 0;
       for(int i = 2 ; i< nums.length ; i++){
            current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
       }
       return prev1;
      }
   }
   public static int recursivehelper(int index, int[] nums){
       if(index == 0) return nums[index];
       if(index < 0) return 0;
       return Math.max(nums[index] + recursivehelper(index-2, nums), recursivehelper(index-1, nums));
   }
   public static int memoizivehelper(int index, int[] nums, int[] dp){
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        return dp[nums.length] =  Math.max(nums[index] + memoizivehelper(index-2, nums, dp), memoizivehelper(index-1, nums, dp));
   }

}

       
    
