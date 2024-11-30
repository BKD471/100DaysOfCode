package Day30;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();

        if(root==null)  return res;
        if((root.left==null && root.right==null)) {
            temp.add(root.val);
            res.add(temp);
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while(q.size()>1){
            TreeNode tempNode=q.poll();
            if(tempNode==null){
                q.offer(null);
                res.add(temp);
                temp=new ArrayList<>();
            }else{
                temp.add(tempNode.val);
                if(tempNode.left!=null) q.offer(tempNode.left);
                if(tempNode.right!=null) q.offer(tempNode.right);
            }
        }
        res.add(temp);
        return res;
    }
}
