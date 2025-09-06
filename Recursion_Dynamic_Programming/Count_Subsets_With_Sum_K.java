import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        int target = 0;
        System.out.println(countSubsetsWithSumRecursive(nums, target));
        System.out.println(countSubsetsWithSumMemoizive(nums, target));
        System.out.println(countSubsetsWithSumTabulative(nums, target));
        
    }
    public static int countSubsetsWithSumRecursive(int[] nums, int target){
        return recursivehelper(nums.length - 1, nums, target);
    }
    
    public static int countSubsetsWithSumMemoizive(int[] nums, int target){
        int[][] dp = new int[nums.length][target + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return memoizivehelper(nums.length - 1, nums, target, dp);
    }
    
    public static int countSubsetsWithSumTabulative(int[] nums, int target){
        int[][] dp = new int[nums.length][target + 1];
        for(int[] arr : dp) Arrays.fill(arr, 0);
        for (int i = 0; i < nums.length; i++) dp[i][0] = 1; //sum == 0 base case 
        if (nums[0] == 0) dp[0][0] = 2; //if first elenent is 0 , even if pick and not pick sum will be 0 only so it becomes 2 (pick + not pick)
        else dp[0][0] = 1;   // otherwise sum = 0 will happen only when you not pick it          
        if (nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1; //If the first element is not zero and its less than target then only 1 way exists to reach nums[0] by picking it.
        for(int i = 1 ; i< nums.length ; i++){
            for(int j = 0 ; j<= target ; j++){
                int pick = 0;
                if(nums[i] <= j) pick = dp[i-1][j - nums[i]];
                int notpick = dp[i-1][j];
                dp[i][j] = pick + notpick;
            }
        }
        return dp[nums.length - 1][target];
    }
    
    public static int recursivehelper(int index, int[] nums, int target){
       
        if(index < 0) return target == 0 ? 1 : 0;
        int pick = 0;
        if(nums[index] <= target)
         pick = recursivehelper(index - 1, nums, target - nums[index]);
        int notpick =  recursivehelper( index - 1, nums, target); 
        return pick + notpick;
    }
    
    public static int memoizivehelper(int index, int[] nums, int target, int[][] dp){
        if(index < 0) return target == 0 ? 1 : 0;
        int pick = 0;
        if(dp[index][target] != -1) return dp[index][target];
        if(nums[index] <= target)
         pick = memoizivehelper(index - 1, nums, target - nums[index], dp);
        int notpick = memoizivehelper( index - 1, nums, target, dp);
        return dp[index][target] = pick + notpick;
    }
    
    
}
