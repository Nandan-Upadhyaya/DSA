import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println( findTargetSumWaysRecursive(nums, target));
        System.out.println( findTargetSumWaysMemoizive(nums, target));
        System.out.println( findTargetSumWaysTabulative(nums, target));
        
    }
    public static int findTargetSumWaysRecursive(int[] nums, int target){
        return recursivehelper(nums.length -1 , nums, target, 0);
    }
    
    public static int findTargetSumWaysMemoizive(int[] nums, int target){
        int total = 0;
        for(int num : nums) total += num;
        int[][] dp = new int[nums.length + 1][2 * total +1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return  memoizivehelper(nums.length -1 , nums, target, 0, total, dp);
    }
    
    public static int recursivehelper(int index, int[] nums, int target, int currsum){
        if(index < 0) return currsum == target ? 1 : 0;
        int addition = recursivehelper(index-1, nums, target, currsum + nums[index]);
        int subtraction = recursivehelper(index-1, nums, target, currsum - nums[index]);
        return addition + subtraction;
    }
     public static int memoizivehelper(int index, int[] nums, int target, int currsum, int total, int[][] dp){
        if(index < 0) return currsum == target ? 1 : 0;
        if(dp[index][currsum + total] != -1) return dp[index][currsum + total];
        int addition =  memoizivehelper(index-1, nums, target, currsum + nums[index], total,dp);
        int subtraction =  memoizivehelper(index-1, nums, target, currsum - nums[index], total, dp);
        return dp[index][currsum + total] = addition + subtraction;
    }
}