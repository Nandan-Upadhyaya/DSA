public static int numSubarrayProductLessThanK(int[] nums, int k){
        int product = 1;
        int count = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            product *= nums[r];
            while(product >= k){
                product /= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }