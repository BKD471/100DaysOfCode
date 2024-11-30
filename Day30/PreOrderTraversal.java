package Day30;

import utilities.TreeNode;

import java.util.ArrayList;

public class PreOrderTraversal {
    ArrayList<Integer> res=new ArrayList<>();
    private void preOrder(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return res;
        if((root.left==null && root.right==null)) {
            res.add(root.val);
            return res;
        }
        preOrder(root);
        return res;
    }
}
