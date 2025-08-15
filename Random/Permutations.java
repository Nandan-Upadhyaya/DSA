
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int num : nums) current.add(num);
        recursivebacktracking(nums, 0, current, result);
        return result;
    }

    public static void recursivebacktracking(int[] nums, int index, List<Integer> current,
    List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index ; i< nums.length ; i++){
           Collections.swap(current, index, i);
           recursivebacktracking(nums, index + 1, current, result);
           Collections.swap(current, index , i);
        }
 
    }
}