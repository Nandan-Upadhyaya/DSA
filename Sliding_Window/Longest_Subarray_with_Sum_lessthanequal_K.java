public static int longestSubarraySumLEK(int[] nums, int k){
        int sum = 0;
        int maxlen = 0;
        int r = 0, l = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            maxlen = Math.max(maxlen, r-l + 1);
            r++;
        }
        return maxlen;
    }