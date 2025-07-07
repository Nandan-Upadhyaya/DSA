
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        int target = 1;
        System.out.println(countSubsetsWithGivenDifferenceRecursive(nums, target));
        System.out.println(countSubsetsWithGivenDifferenceMemoizive(nums, target));

    }
    
   public static int countSubsetsWithGivenDifferenceRecursive(int[] nums, int diff){
       int sum = 0;
       for(int num : nums) sum += num;
       return recursivehelper(nums.length -1, nums, diff, 0, sum);
   }
   
    public static int countSubsetsWithGivenDifferenceMemoizive(int[] nums, int diff){
       int sum = 0;
       for(int num : nums) sum += num;
       int[][] dp = new int[nums.length +1][sum+1];
       for(int[] arr : dp) Arrays.fill(arr, -1);
       return memoizivehelper(nums.length -1, nums, diff, 0, sum, dp);
   }
   
   
   public static int recursivehelper(int index, int[] nums, int diff, int currsum, int sum){
       if(index < 0) return currsum - (sum - currsum) == diff ? 1 : 0;
       return recursivehelper(index-1, nums, diff, currsum + nums[index], sum) + recursivehelper(index-1, nums, diff, currsum, sum);
   } 
   
   public static int memoizivehelper(int index, int[] nums, int diff, int currsum, int sum, int[][] dp){
       if(index < 0) return currsum - (sum - currsum) == diff ? 1 : 0;
       if(dp[index][currsum] != -1) return dp[index][currsum];
       return dp[index][currsum] = memoizivehelper(index-1, nums, diff, currsum + nums[index], sum, dp) + memoizivehelper(index-1, nums, diff, currsum, sum, dp);
   } 
    
}