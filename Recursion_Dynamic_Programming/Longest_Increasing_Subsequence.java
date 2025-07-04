import java.util.*;
class Main {
    public static void main(String[] args) {
       int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISrecursive(nums));
        System.out.println(lengthOfLISmemoizive(nums));
        System.out.println(lengthOfLISTabulative(nums));
      
    }
    public static int lengthOfLISrecursive(int[] nums){
        return recursivehelper(nums, 0, -1);
    }
     public static int lengthOfLISmemoizive(int[] nums){
         int[][] dp = new int[nums.length + 1][nums.length + 1];
         for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(nums, 0, -1, dp);
    }
    public static int lengthOfLISTabulative(int[] nums){
          int n = nums.length;
          int[][] dp = new int[n + 1][n + 1]; 
          for(int index = n - 1; index >= 0; index--){
            for(int prevIndex = index - 1; prevIndex >= -1; prevIndex--){
              int notPick = dp[index + 1][prevIndex + 1]; 
             int pick = 0;
             if(prevIndex == -1 || nums[index] > nums[prevIndex]){
                pick = 1 + dp[index + 1][index + 1];
            }

            dp[index][prevIndex + 1] = Math.max(pick, notPick);
        }
    }

    return dp[0][0]; 
    }
    
    public static int recursivehelper(int[] nums, int index, int prevIndex){
       if(index == nums.length) return 0;
       int notpick = recursivehelper(nums, index+1, prevIndex);
       int pick = 0;
       if(prevIndex == -1 || nums[index] > nums[prevIndex]){
           pick = 1 + recursivehelper(nums, index + 1, index);
    }
    return Math.max(pick, notpick);
    }
    
    public static int memoizivehelper(int[] nums, int index, int prevIndex, int[][] dp){
       if(index == nums.length) return 0;
       if(dp[index + 1][prevIndex + 1] != -1) return dp[index + 1][prevIndex + 1];
       int notpick = memoizivehelper(nums, index+1, prevIndex, dp);
       int pick = 0;
       if(prevIndex == -1 || nums[index] > nums[prevIndex]){
           pick = 1 + memoizivehelper(nums, index + 1, index, dp);
    }
    return dp[index + 1][prevIndex + 1] = Math.max(pick, notpick);
    }
    
}
