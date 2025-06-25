public static double findMaxAverage(int[] nums, int k){
          double sum = 0, avg = 0, maxavg = Double.NEGATIVE_INFINITY;
          int len = 0, l = 0, r = 0;
          while(r < nums.length){
              len++;
              sum += nums[r];
              while(len > k){
                  len--;
                  sum -= nums[l];
                  l++;
              }
              avg = sum/len;
              maxavg = Math.max(maxavg,avg);
              r++;
          }
          return maxavg;
  }