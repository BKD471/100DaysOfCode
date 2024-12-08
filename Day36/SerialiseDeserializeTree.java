package Day36;

import utilities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerialiseDeserializeTree {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while (!q.isEmpty()) {
            TreeNode tempNode = q.poll();
            if (tempNode == null) res.append("# ");
            else {
                res.append(tempNode.val + " ");
                q.offer(tempNode.left);
                q.offer(tempNode.right);
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int n = data.length();
        if (n == 0) return null;

        String[] nums = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int index = 1; index < nums.length; index++) {
            TreeNode node = q.poll();

            String nextNode1 = nums[index];
            if (!nextNode1.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nextNode1));
                node.left = leftNode;
                q.offer(leftNode);
            }

            String nextNode2 = nums[++index];
            if (!nextNode2.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nextNode2));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;

    }
}
