// This is a brute force recursive solution. Memoization to this is not recommended as there is too much to track, prevIndex, current Index, current length, max length, count etc. which will lead to state gamble.
// So Tabulation is best for this. But its hard. It will be looked at later stages. 
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        System.out.println(findNumberOfLISRecursive(nums));
    }
    
    public static int findNumberOfLISRecursive(int[] nums){
        int[] maxlen = {0};
        int[] count ={0};
        recursivehelper(0, -1, nums, 0, maxlen, count);
        return count[0];
    }
    
    public static int recursivehelper(int index, int prevIndex, int[] nums, int currlen, int[] maxlen, int[] count){
        if(index == nums.length){
            if(currlen == maxlen[0]) count[0]++;
           else if(currlen > maxlen[0]){
                maxlen[0] = currlen;
                count[0] = 1;
                return 1;
            }
           return 0;
        }
        int notpick = recursivehelper(index + 1, prevIndex, nums, currlen, maxlen, count);
        int pick = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) 
        pick = recursivehelper(index + 1, index, nums, currlen + 1, maxlen, count);
        return pick + notpick;
        
    }
    
}