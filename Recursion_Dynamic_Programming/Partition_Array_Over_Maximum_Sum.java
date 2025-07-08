import java.util.*;
class Main {
    public static void main(String[] args) {
       int[] arr = {1, 15, 7, 9 ,2 , 5 , 10};
       int k = 3;
       System.out.println(maxSumAfterPartitioningRecursive(arr, k));
       System.out.println(maxSumAfterPartitioningMemoizive(arr, k));
       System.out.println(maxSumAfterPartitioningTabulative(arr, k));
    }
    public static int maxSumAfterPartitioningRecursive(int[] arr, int k){
        return recursivehelper(0, arr, k);
    }
    
    public static int maxSumAfterPartitioningMemoizive(int[] arr, int k){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return memoizivehelper(0, arr, k, dp);
    }
    
    public static int maxSumAfterPartitioningTabulative(int[] arr, int k){
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, 0);
        for(int i = arr.length - 1 ; i >= 0 ; i--){
             int maxelement = 0, maxtotal = 0;
            for(int len = 1 ; len <= k && i + len <= arr.length ; len++){
                 maxelement = Math.max(maxelement, arr[len + i - 1]);
                 int total = maxelement * len + dp[len + i];
                maxtotal = Math.max(maxtotal, total);
            }
            dp[i] = maxtotal;
        }
        return dp[0];
    }
    
    public static int recursivehelper(int index, int[] arr, int k){
        int maxelement = 0, maxtotal = 0;
        if(index == arr.length) return 0;
        
        for(int len = 1 ; len <= k &&  index + len <= arr.length ; len++){
            maxelement = Math.max(maxelement, arr[len + index - 1]);
            int total = maxelement * len + recursivehelper(index + len, arr, k);
            maxtotal = Math.max(maxtotal, total);
        }
        return maxtotal;
    }
    
    public static int memoizivehelper(int index, int[] arr, int k, int[] dp){
        int maxelement = 0, maxtotal = 0;
        if(index == arr.length) return 0;
        if(dp[index] != -1) return dp[index];
        for(int len = 1 ; len <= k &&  index + len <= arr.length ; len++){
            maxelement = Math.max(maxelement, arr[len + index - 1]);
            int total = maxelement * len + memoizivehelper(index + len, arr, k, dp);
            maxtotal = Math.max(maxtotal, total);
        }
        return dp[index] = maxtotal;
    }
    
       
   }