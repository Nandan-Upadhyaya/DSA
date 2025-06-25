public static int longestSubarrayWithKOdds(int[] nums, int k){
    int l = 0, r = 0;
    int oddcount = 0, maxlen = 0;

    while(r < nums.length){
        if(nums[r] % 2 != 0) oddcount++;

        while(oddcount > k){
            if(nums[l] % 2 != 0) oddcount--;  
            l++;
        }

        maxlen = Math.max(maxlen, r - l + 1);
        r++;
    }

    return maxlen;
}
