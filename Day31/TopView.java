package Day31;

import utilities.NodeWithCordinates;
import utilities.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopView {
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if(root.left==null && root.right==null){
            res.add(root.val);
            return res;
        }

        Map<Integer,TreeNode> map=new HashMap<>();
        Queue<NodeWithCordinates> q=new LinkedList<>();
        q.offer(new NodeWithCordinates(root,0));

        while(!q.isEmpty()){
            NodeWithCordinates temp=q.poll();

            int y=temp.y;
            TreeNode node=temp.node;
            if(!map.containsKey(y)) map.put(y,node);

            if(node.left!=null) q.offer(new NodeWithCordinates(node.left,y-1));
            if(node.right!=null) q.offer(new NodeWithCordinates(node.right,y+1));
        }

        for(TreeNode node:map.values()) res.add(node.val);
        return res;
    }
}
