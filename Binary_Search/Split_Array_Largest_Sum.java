
import java.util.stream.IntStream;

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = IntStream.of(nums).max().orElseThrow();
        int right = IntStream.of(nums).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(canSplit(mid, nums, k)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean canSplit(int maxSum, int[] nums, int k) {
        int currentSum = 0;
        int splits = 1;
        for(int i = 0 ; i<nums.length ; i++) {
            if(currentSum + nums[i] <= maxSum) currentSum += nums[i];
            else {
                splits++;
                currentSum = nums[i];
            }
        }
        return splits <= k;
    }
}