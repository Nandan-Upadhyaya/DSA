import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,9};
        System.out.println(minimumSubsetSumDifferenceRecursive(nums));
        System.out.println(minimumSubsetSumDifferenceMemoizive(nums));
      
    }
    public static int minimumSubsetSumDifferenceRecursive(int[] nums){
      int sum = 0;
      for(int num : nums) sum += num;
      return recursivehelper(nums.length - 1, nums, sum, 0);
    }
    
    public static int minimumSubsetSumDifferenceMemoizive(int[] nums){
      int sum = 0;
      for(int num : nums) sum += num;
      int[][] dp = new int[nums.length + 1][sum + 1];
      for(int[] arr : dp) Arrays.fill(arr, -1);
      return memoizivehelper(nums.length - 1, nums, sum, 0, dp);
    }
    
    public static int recursivehelper(int index, int[] nums, int sum, int currsum){
        if(index < 0){
         return Math.abs(currsum - (sum - currsum));   
        }
        return Math.min(recursivehelper(index-1, nums, sum, currsum + nums[index]), recursivehelper(index-1, nums, sum, currsum));
    }
    
     public static int memoizivehelper(int index, int[] nums, int sum, int currsum, int[][] dp){
        if(index < 0){
         return Math.abs(currsum - (sum - currsum));   
        }
        if(dp[index][currsum] != -1) return dp[index][currsum];
        return dp[index][currsum] = Math.min(memoizivehelper(index-1, nums, sum, currsum + nums[index], dp), memoizivehelper(index-1, nums, sum, currsum, dp));
    }
}