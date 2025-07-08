import java.util.*;

// Consider an array of n integers. Consider subsetA with k elements => subsetB has n-k elements. The problem states
// sum A / k = sum B / (n-k) => sum A * (n-k) = sum B * k
// => sum A * n - sum A * k = sum B * k => sum A * n = (sum A + sum B) * k => sum A * n = sum * k
// => sum A = (sum * k) / n (This is the target sum for subset A). If this is not an integer, then it is not possible to partition the array. So we proceed.
// If we are able to count enough number of elements, compare their sum with the estimated target sum. Other keep exploring the pick and not pick options recursively.
class Main {
    public static void main(String[] args) {
       int[] nums = {3,1};
       System.out.println(canPartitionWithEqualAverageRecursive(nums));
    }
   public static boolean canPartitionWithEqualAverageRecursive(int[] nums){
      int sum = 0;
      for(int num : nums) sum += num;
      for(int k = 1 ; k<nums.length ; k++){
          if((sum * k) % nums.length != 0) continue;
          int targetsum = (sum * k) / nums.length;
          if(isPossible(0, nums, 0, 0 ,targetsum, k)) return true;
          
      }
      return false;
   }
   public static boolean isPossible(int index, int[] nums, int currsum, int currcount, int targetsum,  int targetcount){
       if(currcount == targetcount) return targetsum == currsum;
       if(index >= nums.length) return false;
       if(isPossible(index + 1, nums, currsum + nums[index], currcount + 1, targetsum,  targetcount)) return true;
       if(isPossible(index + 1, nums, currsum, currcount, targetsum, targetcount)) return true;
       return false;
       
   }

}

