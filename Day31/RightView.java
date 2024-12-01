package Day31;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if(root.left==null && root.right==null){
            res.add(root.val);
            return res;
        }


        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);q.offer(null);

        ArrayList<Integer> tempList=new ArrayList<>();
        while(q.size()>1){
            TreeNode tempNode=q.poll();
            if(tempNode==null){
                res.add(tempList.getLast());
                tempList=new ArrayList<>();
                q.offer(null);
            }else{
                tempList.add(tempNode.val);
                if(tempNode.left!=null) q.offer(tempNode.left);
                if(tempNode.right!=null) q.offer(tempNode.right);
            }
        }
        res.add(tempList.getLast());
        return res;
    }
}
