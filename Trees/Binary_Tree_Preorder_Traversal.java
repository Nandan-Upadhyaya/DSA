
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursivehelper(root, list);
        return list;
        
    }
    public static void recursivehelper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        recursivehelper(root.left, list);
        recursivehelper(root.right, list);
        
    }
}