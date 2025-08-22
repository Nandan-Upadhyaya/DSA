
import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    public static List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if(start > end) {
            result.add(null);
            return result;
        }

        for(int i = start ; i<= end ; i++) {
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            for(TreeNode L : leftTrees) {
                for(TreeNode R : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = L;
                    root.right = R;
                    result.add(root);
                }
            }
        }
        return result;
    }
    
}