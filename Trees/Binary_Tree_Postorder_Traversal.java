
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursivehelper(root, list);
        return list;
        
    }
    public static void recursivehelper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        recursivehelper(root.left, list);
        recursivehelper(root.right, list);
        list.add(root.val);
    }
}