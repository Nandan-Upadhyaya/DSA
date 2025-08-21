
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      recursivebacktracking(0, n, k, new ArrayList<>(), result);
      return result;
    }

    public static void recursivebacktracking(int currnum, int n, int k, List<Integer> current, List<List<Integer>> result){   
    if(k == 0){
        result.add(new ArrayList<>(current));
        return;
    }

    for(int i = currnum + 1 ; i<= n ; i++){
        current.add(i);
        recursivebacktracking(i, n, k-1, current, result);
        current.remove(current.size() - 1);
    }

    }
}