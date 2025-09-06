import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(canPartitionRecursive(nums));
        System.out.println(canPartitionMemoizive(nums));
        System.out.println(canPartitionTabulative(nums));
    }
    public static boolean canPartitionRecursive(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        return recursivehelper(nums, nums.length -1, sum/2);
    }
    
    public static boolean canPartitionMemoizive(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        Boolean[][] dp = new Boolean [nums.length +1][sum +1];
        if(sum % 2 != 0) return false;
        return memoizivehelper(nums, nums.length -1, sum/2, dp);
    }
    
     public static boolean canPartitionTabulative(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        boolean[][] dp = new boolean [nums.length +1][sum +1];
        for(int i = 0 ; i<nums.length ; i++) dp[i][0] = true;
        boolean pick = true;
        for(int index = 1 ; index <= nums.length ; index++){
            for(int s = 1 ; s <= sum ; s++){
                boolean notpick = dp[index-1][s];
                if(nums[index -1] <= s) pick = dp[index -1][s - nums[index -1]];
                dp[index][s] = pick || notpick;
            }
        }
       return dp[nums.length][sum];
    }
    
    
    public static boolean recursivehelper(int[] nums, int index, int sum){
        if(sum == 0) return true;
        if(index < 0 || sum < 0) return false;
        boolean notpick = recursivehelper(nums, index -1, sum);
        boolean pick = false;
        if(sum <= nums[index])
         pick = recursivehelper(nums, index-1, sum - nums[index]);
        return pick || notpick;
    }
    
     public static boolean memoizivehelper(int[] nums, int index, int sum, Boolean[][] dp){
        if(sum == 0) return true;
        if(index < 0 || sum < 0) return false;
        if(dp[index][sum] != null) return dp[index][sum];
        boolean notpick = memoizivehelper(nums, index -1, sum, dp);
        boolean pick = false;
        if(sum <= nums[index])
         pick = memoizivehelper(nums, index-1, sum - nums[index], dp);
        return dp[index][sum] = pick || notpick;
    }
}