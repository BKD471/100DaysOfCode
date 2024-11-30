package Day30;


import utilities.TreeNode;

public class BalancedBinaryTree {
    boolean isBalanced=true;
    private int checkBalanced(TreeNode root){
        if(root==null) return 0;

        int leftHeight=checkBalanced(root.left);
        int rightHeight=checkBalanced(root.right);

        int diff=Math.abs(leftHeight-rightHeight);
        if(diff>1) isBalanced=false;
        return 1+Math.max(leftHeight,rightHeight);
    }
    public int isBalanced(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 1;
        checkBalanced(root);
        return isBalanced ? 1:0;
    }
}
