class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
          return root == null ? false : recursivehelper(root, targetSum, 0);
    }

    public static boolean recursivehelper(TreeNode root, int targetSum, int currSum) {
        return root.left == null && root.right == null ? currSum + root.val == targetSum : root.left != null && recursivehelper(root.left, targetSum, currSum + root.val) || root.right != null && recursivehelper(root.right, targetSum, currSum + root.val) ;
    }
}