package Day30;

import utilities.TreeNode;

import java.util.ArrayList;

public class PostOrderTraversal {
    ArrayList<Integer> res = new ArrayList<>();

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }


    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        if ((root.left == null && root.right == null)) {
            res.add(root.val);
            return res;
        }
        postOrder(root);
        return res;
    }
}
