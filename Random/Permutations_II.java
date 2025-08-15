
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int num : nums) current.add(num);
        recursivebacktracking(nums, current, result, 0);
        return result;
    }
    public static void recursivebacktracking(int[] nums, List<Integer> current, List<List<Integer>> result, int index){
        
        if(index == nums.length){
            if(!result.contains(current)){
            result.add(new ArrayList<>(current));
            return;
            }
        }
        for(int i = index ; i< nums.length ; i++){
            Collections.swap(current, index, i);
            recursivebacktracking(nums, current, result, index + 1);
            Collections.swap(current, index, i);
        }
    }
}