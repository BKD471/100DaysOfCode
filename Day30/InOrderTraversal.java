package Day30;

import utilities.TreeNode;

import java.util.ArrayList;

public class InOrderTraversal {
    ArrayList<Integer> res=new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return res;
        if((root.left==null && root.right==null)) {
            res.add(root.val);
            return res;
        }
        inOrder(root);
        return res;
    }
}
