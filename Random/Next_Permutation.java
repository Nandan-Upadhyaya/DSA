class Solution  {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        int j = n-1;
        if(i >= 0){
            while(j >= 0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}