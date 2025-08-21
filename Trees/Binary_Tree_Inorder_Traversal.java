
import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursivehelper(root, list);
        return list;
    }

    public static void recursivehelper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        recursivehelper(root.left, list);
        list.add(root.val);
        recursivehelper(root.right, list);
    }
}