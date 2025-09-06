
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0 ; i<inorder.length ; i++) inorderMap.put(inorder[i], i);
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, inorderMap);
    }

    public static TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap ) {
        
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inorderMap.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = buildTree(preStart + 1, preStart + numsLeft, inStart, inRoot - 1, preorder, inorder, inorderMap);

        root.right = buildTree(preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, preorder, inorder, inorderMap);
        
        return root;
    } 
}