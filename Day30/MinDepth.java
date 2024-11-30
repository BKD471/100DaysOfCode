package Day30;

import utilities.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return 1+minDepth(root.right);
        if(root.right==null) return 1+minDepth(root.left);

        int leftHeight=minDepth(root.left);
        int rightHeight=minDepth(root.right);

        return 1+Math.min(leftHeight,rightHeight);
    }
}
