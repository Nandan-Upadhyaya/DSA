
class Solution {

    // Stupid Solution
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
      
    // Goated solution
    public int mySqrtOptimized(int x) {
        long left = 1 , right = x , ans = 0;

        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid <= x){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return (int) ans;
}
    
    
}
