import java.util.stream.*;
class Solution {
    public int findPages(int[] nums, int m) {

    int left = IntStream.of(nums).max().orElseThrow();
    int right = IntStream.of(nums).sum();
    
    while(left < right) {
        int mid = left + (right - left) / 2;
        if(canAllocate(nums, m, mid)) right = mid;
        else left = mid + 1;
    }
    
    return left;
   
    }
    public static boolean canAllocate(int[] nums, int m, int maxPages) {
        int currentPages = 0;
        int students = 1;
        
        for(int i = 0 ; i<nums.length ; i++) {
            if(currentPages + nums[i] <= maxPages) currentPages += nums[i];
            else {
                students++;
                currentPages = nums[i];
            }
        }
        
        if(students > m) return false;
        return true;
    }
}