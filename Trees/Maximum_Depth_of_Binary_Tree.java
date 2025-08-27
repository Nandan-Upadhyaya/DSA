class Solution {
    
    // Standard Approach
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    
    // My Version
    public int maxDepth(TreeNode root) {
        
        return recursivehelper(root, 0);
    }

    public int recursivehelper(TreeNode root, int count) {
        if(root == null) return count;
        return Math.max( recursivehelper(root.left, count + 1), recursivehelper(root.right, count + 1));
    }
}