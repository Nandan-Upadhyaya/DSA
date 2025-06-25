class Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k) -numberOfSubarrays(nums, k-1));
        
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int l = 0, r = 0;
        int oddcount = 0, count = 0;
        while(r < nums.length){
            if(nums[r] % 2 != 0) oddcount++;
            while(oddcount > k){
                if(nums[l] % 2 != 0) oddcount--;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}