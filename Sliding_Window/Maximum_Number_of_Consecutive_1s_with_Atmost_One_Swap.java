public static int maxConsecutiveOnesAfterSwap(int[] nums){
        int l = 0, r = 0, swap = 0, maxlen = 0;
        while(r < nums.length){
            if(nums[r] == 0) swap++;
            while(swap > 1){
                if(nums[l] == 0) swap--;
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }