package Day31;

import utilities.NodeWithCordinates;
import utilities.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {

            tempList.add(root.val);
            res.add(tempList);
            return res;
        }

        Map<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        Queue<NodeWithCordinates> q = new LinkedList<>();
        q.offer(new NodeWithCordinates(root, 0, 0));

        while (!q.isEmpty()) {
            NodeWithCordinates temp = q.poll();

            int x = temp.x;
            int y = temp.y;
            TreeNode node = temp.node;

            if (!map.containsKey(y)) map.put(y, new TreeMap<>());
            if (!map.get(y).containsKey(x)) map.get(y).put(x, new ArrayList<>());
            map.get(y).get(x).add(node.val);

            if (node.left != null) q.offer(new NodeWithCordinates(node.left, x + 1, y - 1));
            if (node.right != null) q.offer(new NodeWithCordinates(node.right, x + 1, y + 1));
        }

        for (Map<Integer, ArrayList<Integer>> tempMap : map.values()) {
            tempList = new ArrayList<>();
            for (ArrayList<Integer> list : tempMap.values()) tempList.addAll(list);
            res.add(tempList);
        }
        return res;
    }
}
