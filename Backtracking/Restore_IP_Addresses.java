
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    recursivebacktracking(s, 0, new ArrayList<>(), result);
    return result;

    }

    public static void recursivebacktracking(String s, int index, List<String> path,  List<String> result) {
        if(path.size() == 4 && index == s.length()) {
            result.add(String.join(".", path));
            return;
        }

        if (path.size() >= 4 || index >= s.length()) return;

        String one = s.substring(index, index + 1);
        path.add(one);
        recursivebacktracking(s, index + 1, path, result);
        path.remove(path.size() - 1);

        if(index + 1 < s.length()) {
            String two = s.substring(index, index + 2);
            if(!two.startsWith("0")) {
               path.add(two);
               recursivebacktracking(s, index + 2, path, result);
              path.remove(path.size() - 1);
            }
            
        }

        if(index + 2 < s.length()) {
            String threeString = s.substring(index, index + 3);
            if(!threeString.startsWith("0")) {
                   int three = Integer.parseInt(threeString);
            if(three <= 255) {
                path.add(threeString);
                recursivebacktracking(s, index + 3, path, result);
                path.remove(path.size() - 1);
            } 
            }
            
        }
        
    }

}